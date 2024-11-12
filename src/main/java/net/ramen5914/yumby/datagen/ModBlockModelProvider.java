package net.ramen5914.yumby.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.ramen5914.yumby.Yumby;

public class ModBlockModelProvider extends BlockModelProvider {
    public ModBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Yumby.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("dark_oak_bowl", modLoc("block/bowl"))
                .texture("material", mcLoc("block/dark_oak_log"));

        withExistingParent("spruce_bowl", modLoc("block/bowl"))
                .texture("material", mcLoc("block/spruce_log"));

        withExistingParent("birch_bowl", modLoc("block/bowl"))
                .texture("material", mcLoc("block/birch_log"));

        withExistingParent("jungle_bowl", modLoc("block/bowl"))
                .texture("material", mcLoc("block/jungle_log"));

        withExistingParent("acacia_bowl", modLoc("block/bowl"))
                .texture("material", mcLoc("block/acacia_log"));

        withExistingParent("dark_oak_bowl", modLoc("block/bowl"))
                .texture("material", mcLoc("block/dark_oak_log"));

        withExistingParent("mangrove_bowl", modLoc("block/bowl"))
                .texture("material", mcLoc("block/mangrove_log"));

        withExistingParent("cherry_bowl", modLoc("block/bowl"))
                .texture("material", mcLoc("block/cherry_log"));

        withExistingParent("crimson_bowl", modLoc("block/bowl"))
                .texture("material", mcLoc("block/crimson_stem"));

        withExistingParent("warped_bowl", modLoc("block/bowl"))
                .texture("material", mcLoc("block/warped_stem"));

    }
}
