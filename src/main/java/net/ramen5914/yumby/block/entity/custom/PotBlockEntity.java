package net.ramen5914.yumby.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.capabilities.BlockCapability;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.ramen5914.yumby.Yumby;
import net.ramen5914.yumby.block.entity.ModBlockEntities;
import net.ramen5914.yumby.recipe.ModRecipes;
import net.ramen5914.yumby.recipe.boiling.BoilingRecipe;
import net.ramen5914.yumby.recipe.boiling.BoilingRecipeInput;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class PotBlockEntity extends BlockEntity implements Container {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(BoilingRecipe.MAX_INGREDIENTS, ItemStack.EMPTY);
    private float rotation;

    private final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;
    private final int DEFAULT_MAX_PROGRESS = 72;

    private final FluidTank FLUID_TANK = createFluidTank();
    public static final BlockCapability<IFluidHandler, Void> FLUID_HANDLER =
            BlockCapability.createVoid(
                    ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, "pot_fluid_handler"),
                    IFluidHandler.class
            );

    private FluidTank createFluidTank() {
        return new FluidTank(FluidType.BUCKET_VOLUME) {
            @Override
            protected void onContentsChanged() {
                setChanged();
                if (!level.isClientSide()) {
                    level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                }
            }

            @Override
            public boolean isFluidValid(FluidStack stack) {
                return stack.getFluid() != Fluids.LAVA;
            }
        };
    }

    public PotBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.POT_BE.get(), pos, blockState);
        this.data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> PotBlockEntity.this.progress;
                    case 1 -> PotBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i) {
                    case 0: PotBlockEntity.this.progress = value;
                    case 1: PotBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public int getContainerSize() {
        return inventory.size();
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < getContainerSize(); i++) {
            ItemStack stack = getItem(i);
            if (!stack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack getItem(int slot) {
        setChanged();
        return inventory.get(slot);
    }

    @Override
    public ItemStack removeItem(int slot, int amount) {
        setChanged();
        ItemStack stack = inventory.get(slot);
        stack.shrink(amount);

        return inventory.set(slot, stack);
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        setChanged();
        return ContainerHelper.takeItem(inventory, slot);
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        setChanged();
        inventory.set(slot, stack.copyWithCount(1));
    }

    @Override
    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    @Override
    public void clearContent() {
        inventory.clear();
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.putInt("pot.progress", progress);
        tag.putInt("pot.max_progress", maxProgress);

        super.saveAdditional(tag, registries);

        ContainerHelper.saveAllItems(tag, inventory, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);

        progress = tag.getInt("pot.progress");
        maxProgress = tag.getInt("pot.max_progress");

        ContainerHelper.loadAllItems(tag, inventory, registries);
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        if (hasRecipe() && isOutputSlotEmptyOrReceivable()) {
            increaseCraftingProgress();
            setChanged(level, pos, state);

            if (hasCraftingFinished()) {
                craftItem();
                resetProgress();

                setChanged();
                this.level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);
            }
        } else {
            resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
        this.maxProgress = DEFAULT_MAX_PROGRESS;
    }

    private void craftItem() {
        Optional<RecipeHolder<BoilingRecipe>> recipe = getCurrentRecipe();
        ItemStack output = recipe.get().value().getResult();

        inventory.getFirst().shrink(1);

        this.setItem(0, output);
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        this.progress++;
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return true;
    }

    private boolean hasRecipe() {
        Optional<RecipeHolder<BoilingRecipe>> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        }

        ItemStack output = recipe.get().value().getResult();

        return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
    }

    private Optional<RecipeHolder<BoilingRecipe>> getCurrentRecipe() {
        return this.level.getRecipeManager()
                .getRecipeFor(ModRecipes.BOILING.get(), new BoilingRecipeInput(List.of(inventory.getFirst())), level);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return true;
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return true;
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }

    public float getRenderingRotation() {
        rotation += 0.5f;
        if (rotation >= 360) {
            rotation = 0;
        }

        return rotation;
    }

    @Override
    public void onLoad() {

    }
}
