package net.ramen5914.yumby.block;

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
import net.ramen5914.yumby.block.custom.PanBlock;
import net.ramen5914.yumby.block.custom.PotBlock;
import net.ramen5914.yumby.item.ModItems;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Yumby.MOD_ID);

    public static DeferredBlock<Block> POT = registerBlock("pot",
            (properties) -> new PotBlock(properties
                    .noOcclusion()),

    public static DeferredBlock<Block> PAN = registerBlock("pan",
            (properties) -> new PanBlock(properties
                    .noOcclusion()),

    public static DeferredBlock<Block> OAK_BOWL = registerBlock("oak_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()));

    public static DeferredBlock<Block> SPRUCE_BOWL = registerBlock("spruce_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()));

    public static DeferredBlock<Block> BIRCH_BOWL = registerBlock("birch_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()));

    public static DeferredBlock<Block> JUNGLE_BOWL = registerBlock("jungle_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()));

    public static DeferredBlock<Block> ACACIA_BOWL = registerBlock("acacia_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()));

    public static DeferredBlock<Block> DARK_OAK_BOWL = registerBlock("dark_oak_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()));

    public static DeferredBlock<Block> MANGROVE_BOWL = registerBlock("mangrove_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()));

    public static DeferredBlock<Block> CHERRY_BOWL = registerBlock("cherry_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()));

    public static DeferredBlock<Block> CRIMSON_BOWL = registerBlock("crimson_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()));

    public static DeferredBlock<Block> WARPED_BOWL = registerBlock("warped_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()));

    public static DeferredBlock<Block> BAMBOO_BOWL = registerBlock("bamboo_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()));

    private static <T> ResourceKey<T> createKey(ResourceKey<? extends Registry<T>> resourceKey, String id) {
        return ResourceKey.create(resourceKey, ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, id));
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> blockSupplier) {
        BlockBehaviour.Properties defaultProperties = BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, name)));

        DeferredBlock<T> toReturn = BLOCKS.register(name, () -> blockSupplier.apply(defaultProperties));
        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> blockSupplier, Item.Properties properties) {
        BlockBehaviour.Properties defaultProperties = BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, name)));

        DeferredBlock<T> toReturn = BLOCKS.register(name, () -> blockSupplier.apply(defaultProperties));
        registerBlockItem(name, toReturn, properties);

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, name)))));
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block, Item.Properties properties) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), properties
                .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, name)))));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
