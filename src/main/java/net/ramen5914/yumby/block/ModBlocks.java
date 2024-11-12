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

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Yumby.MOD_ID);

    private static final ResourceKey<Block> POT_BLOCK = createKey(Registries.BLOCK, "pot");
    private static final ResourceKey<Item> POT_ITEM = createKey(Registries.ITEM, "pot");

    private static final ResourceKey<Block> PAN_BLOCK = createKey(Registries.BLOCK, "pan");
    private static final ResourceKey<Item> PAN_ITEM = createKey(Registries.ITEM, "pan");

    private static final ResourceKey<Block> OAK_BOWL_BLOCK = createKey(Registries.BLOCK, "oak_bowl");
    private static final ResourceKey<Item> OAK_BOWL_ITEM = createKey(Registries.ITEM, "oak_bowl");
    private static final ResourceKey<Block> SPRUCE_BOWL_BLOCK = createKey(Registries.BLOCK, "spruce_bowl");
    private static final ResourceKey<Item> SPRUCE_BOWL_ITEM = createKey(Registries.ITEM, "spruce_bowl");
    private static final ResourceKey<Block> BIRCH_BOWL_BLOCK = createKey(Registries.BLOCK, "birch_bowl");
    private static final ResourceKey<Item> BIRCH_BOWL_ITEM = createKey(Registries.ITEM, "birch_bowl");
    private static final ResourceKey<Block> JUNGLE_BOWL_BLOCK = createKey(Registries.BLOCK, "jungle_bowl");
    private static final ResourceKey<Item> JUNGLE_BOWL_ITEM = createKey(Registries.ITEM, "jungle_bowl");
    private static final ResourceKey<Block> ACACIA_BOWL_BLOCK = createKey(Registries.BLOCK, "acacia_bowl");
    private static final ResourceKey<Item> ACACIA_BOWL_ITEM = createKey(Registries.ITEM, "acacia_bowl");
    private static final ResourceKey<Block> DARK_OAK_BOWL_BLOCK = createKey(Registries.BLOCK, "dark_oak_bowl");
    private static final ResourceKey<Item> DARK_OAK_BOWL_ITEM = createKey(Registries.ITEM, "dark_oak_bowl");
    private static final ResourceKey<Block> MANGROVE_BOWL_BLOCK = createKey(Registries.BLOCK, "mangrove_bowl");
    private static final ResourceKey<Item> MANGROVE_BOWL_ITEM = createKey(Registries.ITEM, "mangrove_bowl");
    private static final ResourceKey<Block> CHERRY_BOWL_BLOCK = createKey(Registries.BLOCK, "cherry_bowl");
    private static final ResourceKey<Item> CHERRY_BOWL_ITEM = createKey(Registries.ITEM, "cherry_bowl");
    private static final ResourceKey<Block> CRIMSON_BOWL_BLOCK = createKey(Registries.BLOCK, "crimson_bowl");
    private static final ResourceKey<Item> CRIMSON_BOWL_ITEM = createKey(Registries.ITEM, "crimson_bowl");
    private static final ResourceKey<Block> WARPED_BOWL_BLOCK = createKey(Registries.BLOCK, "warped_bowl");
    private static final ResourceKey<Item> WARPED_BOWL_ITEM = createKey(Registries.ITEM, "warped_bowl");

    public static DeferredBlock<Block> POT = registerBlock("pot",
            POT_ITEM,
            () -> new PotBlock(BlockBehaviour.Properties.of()
                    .setId(POT_BLOCK)
                    .noOcclusion()));

    public static DeferredBlock<Block> PAN = registerBlock("pan",
            PAN_ITEM,
            () -> new PanBlock(BlockBehaviour.Properties.of()
                    .setId(PAN_BLOCK)
                    .noOcclusion()));

    public static DeferredBlock<Block> OAK_BOWL = registerBlock("oak_bowl",
            OAK_BOWL_ITEM,
            () -> new BowlBlock(BlockBehaviour.Properties.of()
                    .setId(OAK_BOWL_BLOCK)
                    .noOcclusion()));

    public static DeferredBlock<Block> SPRUCE_BOWL = registerBlock("spruce_bowl",
            SPRUCE_BOWL_ITEM,
            () -> new BowlBlock(BlockBehaviour.Properties.of()
                    .setId(SPRUCE_BOWL_BLOCK)
                    .noOcclusion()));

    public static DeferredBlock<Block> BIRCH_BOWL = registerBlock("birch_bowl",
            BIRCH_BOWL_ITEM,
            () -> new BowlBlock(BlockBehaviour.Properties.of()
                    .setId(BIRCH_BOWL_BLOCK)
                    .noOcclusion()));

    public static DeferredBlock<Block> JUNGLE_BOWL = registerBlock("jungle_bowl",
            JUNGLE_BOWL_ITEM,
            () -> new BowlBlock(BlockBehaviour.Properties.of()
                    .setId(JUNGLE_BOWL_BLOCK)
                    .noOcclusion()));

    public static DeferredBlock<Block> ACACIA_BOWL = registerBlock("acacia_bowl",
            ACACIA_BOWL_ITEM,
            () -> new BowlBlock(BlockBehaviour.Properties.of()
                    .setId(ACACIA_BOWL_BLOCK)
                    .noOcclusion()));

    public static DeferredBlock<Block> DARK_OAK_BOWL = registerBlock("dark_oak_bowl",
            DARK_OAK_BOWL_ITEM,
            () -> new BowlBlock(BlockBehaviour.Properties.of()
                    .setId(DARK_OAK_BOWL_BLOCK)
                    .noOcclusion()));

    public static DeferredBlock<Block> MANGROVE_BOWL = registerBlock("mangrove_bowl",
            MANGROVE_BOWL_ITEM,
            () -> new BowlBlock(BlockBehaviour.Properties.of()
                    .setId(MANGROVE_BOWL_BLOCK)
                    .noOcclusion()));

    public static DeferredBlock<Block> CHERRY_BOWL = registerBlock("cherry_bowl",
            CHERRY_BOWL_ITEM,
            () -> new BowlBlock(BlockBehaviour.Properties.of()
                    .setId(CHERRY_BOWL_BLOCK)
                    .noOcclusion()));

    public static DeferredBlock<Block> CRIMSON_BOWL = registerBlock("crimson_bowl",
            CRIMSON_BOWL_ITEM,
            () -> new BowlBlock(BlockBehaviour.Properties.of()
                    .setId(CRIMSON_BOWL_BLOCK)
                    .noOcclusion()));

    public static DeferredBlock<Block> WARPED_BOWL = registerBlock("warped_bowl",
            WARPED_BOWL_ITEM,
            () -> new BowlBlock(BlockBehaviour.Properties.of()
                    .setId(WARPED_BOWL_BLOCK)
                    .noOcclusion()));

    private static <T> ResourceKey<T> createKey(ResourceKey<? extends Registry<T>> resourceKey, String id) {
        return ResourceKey.create(resourceKey, ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, id));
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, ResourceKey<Item> itemResourceKey, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, itemResourceKey);

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block, ResourceKey<Item> resourceKey) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .setId(resourceKey)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
