package net.ramen5914.yumby.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.ramen5914.yumby.Yumby;

public class ModBlockModelProvider extends BlockModelProvider {
    public ModBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Yumby.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        bowl("acacia_bowl", mcLoc("block/acacia_planks"));
        bowl("bamboo_bowl", mcLoc("block/bamboo_planks"));
        bowl("birch_bowl", mcLoc("block/birch_planks"));
        bowl("cherry_bowl", mcLoc("block/cherry_planks"));
        bowl("crimson_bowl", mcLoc("block/crimson_planks"));
        bowl("dark_oak_bowl", mcLoc("block/dark_oak_planks"));
        bowl("jungle_bowl", mcLoc("block/jungle_planks"));
        bowl("mangrove_bowl", mcLoc("block/mangrove_planks"));
        bowl("oak_bowl", mcLoc("block/oak_planks"));
        bowl("spruce_bowl", mcLoc("block/spruce_planks"));
        bowl("warped_bowl", mcLoc("block/warped_planks"));

        cuttingBoard("acacia_cutting_board", mcLoc("block/acacia_planks"));
        cuttingBoard("bamboo_cutting_board", mcLoc("block/bamboo_planks"));
        cuttingBoard("birch_cutting_board", mcLoc("block/birch_planks"));
        cuttingBoard("cherry_cutting_board", mcLoc("block/cherry_planks"));
        cuttingBoard("crimson_cutting_board", mcLoc("block/crimson_planks"));
        cuttingBoard("dark_oak_cutting_board", mcLoc("block/dark_oak_planks"));
        cuttingBoard("jungle_cutting_board", mcLoc("block/jungle_planks"));
        cuttingBoard("mangrove_cutting_board", mcLoc("block/mangrove_planks"));
        cuttingBoard("oak_cutting_board", modLoc("block/oak_cutting_board"));
        cuttingBoard("spruce_cutting_board", mcLoc("block/spruce_planks"));
        cuttingBoard("warped_cutting_board", mcLoc("block/warped_planks"));
    }

    private void bowl(String name, ResourceLocation material) {
        withExistingParent(name, modLoc("block/bowl"))
                .texture("material", material);
    }

    private void cuttingBoard(String name, ResourceLocation material) {
        withExistingParent(name, modLoc("block/cutting_board"))
                .texture("material", material);
    }
}
