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
        bowl("oak_bowl", mcLoc("block/oak_log"));
        bowl("dark_oak_bowl", mcLoc("block/dark_oak_log"));
        bowl("spruce_bowl", mcLoc("block/spruce_log"));
        bowl("birch_bowl", mcLoc("block/birch_log"));
        bowl("jungle_bowl", mcLoc("block/jungle_log"));
        bowl("acacia_bowl", mcLoc("block/acacia_log"));
        bowl("dark_oak_bowl", mcLoc("block/dark_oak_log"));
        bowl("mangrove_bowl", mcLoc("block/mangrove_log"));
        bowl("cherry_bowl", mcLoc("block/cherry_log"));
        bowl("crimson_bowl", mcLoc("block/crimson_stem"));
        bowl("warped_bowl", mcLoc("block/warped_stem"));
    }

    private void bowl(String name, ResourceLocation material) {
        withExistingParent(name, modLoc("block/bowl"))
                .texture("material", material);
    }
}
