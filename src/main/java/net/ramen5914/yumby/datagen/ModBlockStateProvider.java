package net.ramen5914.yumby.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.ramen5914.yumby.Yumby;
import net.ramen5914.yumby.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Yumby.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.POT.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/pot")));

        horizontalBlock(ModBlocks.PAN.get(),
                 new ModelFile.UncheckedModelFile(modLoc("block/pan")));

        horizontalBlock(ModBlocks.OAK_CUTTING_BOARD.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/oak_cutting_board")));

        simpleBlockWithItem(ModBlocks.OAK_BOWL.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/oak_bowl")));

        simpleBlockWithItem(ModBlocks.SPRUCE_BOWL.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/spruce_bowl")));

        simpleBlockWithItem(ModBlocks.BIRCH_BOWL.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/birch_bowl")));

        simpleBlockWithItem(ModBlocks.JUNGLE_BOWL.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/jungle_bowl")));

        simpleBlockWithItem(ModBlocks.ACACIA_BOWL.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/acacia_bowl")));

        simpleBlockWithItem(ModBlocks.DARK_OAK_BOWL.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/dark_oak_bowl")));

        simpleBlockWithItem(ModBlocks.MANGROVE_BOWL.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/mangrove_bowl")));

        simpleBlockWithItem(ModBlocks.CHERRY_BOWL.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/cherry_bowl")));

        simpleBlockWithItem(ModBlocks.CRIMSON_BOWL.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/crimson_bowl")));

        simpleBlockWithItem(ModBlocks.WARPED_BOWL.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/warped_bowl")));

        simpleBlockWithItem(ModBlocks.BAMBOO_BOWL.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/bamboo_bowl")));
    }
}
