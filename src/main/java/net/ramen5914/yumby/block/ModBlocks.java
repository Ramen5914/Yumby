package net.ramen5914.yumby.block;

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
import net.ramen5914.yumby.block.custom.CuttingBoardBlock;
import net.ramen5914.yumby.block.custom.OnionCropBlock;
import net.ramen5914.yumby.block.custom.PanBlock;
import net.ramen5914.yumby.block.custom.PotBlock;
import net.ramen5914.yumby.item.ModItems;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Yumby.MOD_ID);

    public static DeferredBlock<Block> POT = registerBlock("pot",
            (properties) -> new PotBlock(properties
                    .noOcclusion()),
            (properties) -> properties
                    .stacksTo(1));

    public static DeferredBlock<Block> PAN = registerBlock("pan",
            (properties) -> new PanBlock(properties
                    .noOcclusion()),
            (properties) -> properties
                    .stacksTo(1));

    public static DeferredBlock<Block> OAK_BOWL = registerBlock("oak_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> SPRUCE_BOWL = registerBlock("spruce_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> BIRCH_BOWL = registerBlock("birch_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> JUNGLE_BOWL = registerBlock("jungle_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> ACACIA_BOWL = registerBlock("acacia_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> DARK_OAK_BOWL = registerBlock("dark_oak_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> MANGROVE_BOWL = registerBlock("mangrove_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> CHERRY_BOWL = registerBlock("cherry_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> CRIMSON_BOWL = registerBlock("crimson_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> WARPED_BOWL = registerBlock("warped_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> BAMBOO_BOWL = registerBlock("bamboo_bowl",
            (properties) -> new BowlBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> OAK_CUTTING_BOARD = registerBlock("oak_cutting_board",
            (properties) -> new CuttingBoardBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> SPRUCE_CUTTING_BOARD = registerBlock("spruce_cutting_board",
            (properties) -> new CuttingBoardBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> BIRCH_CUTTING_BOARD = registerBlock("birch_cutting_board",
            (properties) -> new CuttingBoardBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> JUNGLE_CUTTING_BOARD = registerBlock("jungle_cutting_board",
            (properties) -> new CuttingBoardBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> ACACIA_CUTTING_BOARD = registerBlock("acacia_cutting_board",
            (properties) -> new CuttingBoardBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> DARK_OAK_CUTTING_BOARD = registerBlock("dark_oak_cutting_board",
            (properties) -> new CuttingBoardBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> MANGROVE_CUTTING_BOARD = registerBlock("mangrove_oak_cutting_board",
            (properties) -> new CuttingBoardBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> CHERRY_CUTTING_BOARD = registerBlock("cherry_cutting_board",
            (properties) -> new CuttingBoardBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> CRIMSON_CUTTING_BOARD = registerBlock("crimson_cutting_board",
            (properties) -> new CuttingBoardBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> WARPED_CUTTING_BOARD = registerBlock("warped_cutting_board",
            (properties) -> new CuttingBoardBlock(properties
                    .noOcclusion()),
            (properties) -> properties);

    public static DeferredBlock<Block> BAMBOO_CUTTING_BOARD = registerBlock("bamboo_cutting_board",
            (properties) -> new CuttingBoardBlock(properties
                    .noOcclusion()),
            (properties) -> properties);
            
    public static DeferredBlock<Block> ONION_CROP = registerBlock("onion_crop",
            (properties) -> new OnionCropBlock(properties),
            (properties) -> properties);

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> blockSupplier, Function<Item.Properties, Item.Properties> itemSupplier) {
        BlockBehaviour.Properties blockProperties = BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, name)));
        Item.Properties itemProperties = new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, name)));

        DeferredBlock<T> toReturn = BLOCKS.register(name, () -> blockSupplier.apply(blockProperties));
        registerBlockItem(name, toReturn, itemSupplier.apply(itemProperties));

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block, Item.Properties properties) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
