package net.ramen5914.yumby.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.ramen5914.yumby.Yumby;
import net.ramen5914.yumby.block.ModBlocks;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Yumby.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        complexBlock(ModBlocks.PAN.get());
        complexBlock(ModBlocks.POT.get());
    }

    private ItemModelBuilder complexBlock(Block block) {
        return withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath(), ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID,
                "block/" + BuiltInRegistries.BLOCK.getKey(block).getPath()));
    }
}

