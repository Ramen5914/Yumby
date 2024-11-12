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
    }

    private void bowl(String name, ResourceLocation material) {
        withExistingParent(name, modLoc("block/bowl"))
                .texture("material", material);
    }
}
