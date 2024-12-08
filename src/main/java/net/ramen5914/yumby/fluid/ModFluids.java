package net.ramen5914.yumby.fluid;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ramen5914.yumby.Yumby;
import net.ramen5914.yumby.block.ModBlocks;
import net.ramen5914.yumby.item.ModItems;

import java.util.function.Supplier;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID, Yumby.MOD_ID);

    // Beef Bone Broth
    public static final Supplier<FlowingFluid> SOURCE_BEEF_BONE_BROTH = FLUIDS.register("source_beef_bone_broth",
            () -> new BaseFlowingFluid.Source(ModFluids.BEEF_BONE_BORTH_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_BEEF_BONE_BROTH = FLUIDS.register("flowing_beef_bone_broth",
            () -> new BaseFlowingFluid.Flowing(ModFluids.BEEF_BONE_BORTH_PROPERTIES));

    public static final DeferredBlock<LiquidBlock> BEEF_BONE_BROTH_BLOCK = ModBlocks.BLOCKS.register("beef_bone_broth_block",
            () -> new LiquidBlock(ModFluids.SOURCE_BEEF_BONE_BROTH.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredItem<Item> BEEF_BONE_BROTH_BUCKET = ModItems.ITEMS.registerItem("beef_bone_broth_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_BEEF_BONE_BROTH.get(), properties.stacksTo(1).craftRemainder(Items.BUCKET)));

    public static final BaseFlowingFluid.Properties BEEF_BONE_BORTH_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.BEEF_BONE_BROTH_FLUID_TYPE, SOURCE_BEEF_BONE_BROTH, FLOWING_BEEF_BONE_BROTH)
            .slopeFindDistance(2)
            .levelDecreasePerBlock(1)
            .block(ModFluids.BEEF_BONE_BROTH_BLOCK)
            .bucket(ModFluids.BEEF_BONE_BROTH_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
