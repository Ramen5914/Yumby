package net.ramen5914.yumby.block;

import java.util.function.Supplier;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ramen5914.yumby.Yumby;
import net.ramen5914.yumby.block.custom.BowlBlock;
import net.ramen5914.yumby.block.custom.PotBlock;
import net.ramen5914.yumby.item.ModItems;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Yumby.MOD_ID);

    private static final ResourceKey<Block> POT_BLOCK = createKey(Registries.BLOCK, "pot");
    private static final ResourceKey<Item> POT_ITEM = createKey(Registries.ITEM, "pot");

    private static final ResourceKey<Block> BOWL_BLOCK = createKey(Registries.BLOCK, "bowl");
    private static final ResourceKey<Item> BOWL_ITEM = createKey(Registries.ITEM, "bowl");

    public static DeferredBlock<Block> POT = registerBlock("pot",
            POT_ITEM,
            () -> new PotBlock(BlockBehaviour.Properties.of()
                    .setId(POT_BLOCK)
                    .noOcclusion()
                    .requiresCorrectToolForDrops()));

    public static DeferredBlock<Block> BOWL = registerBlock("bowl",
            BOWL_ITEM,
            () -> new BowlBlock(BlockBehaviour.Properties.of()
                    .setId(BOWL_BLOCK)
                    .noOcclusion()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, ResourceKey<Item> itemResourceKey, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, itemResourceKey);

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block, ResourceKey<Item> resourceKey) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .setId(resourceKey)));
    }

    private static <T> ResourceKey<T> createKey(ResourceKey<? extends Registry<T>> resourceKey, String id) {
        return ResourceKey.create(resourceKey, ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, id));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
