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

//        simpleBlockWithItem(ModBlocks.PAN.get(),
//                new ModelFile.UncheckedModelFile(modLoc("block/pan")));

        horizontalBlock(ModBlocks.PAN.get(),
                 new ModelFile.UncheckedModelFile(modLoc("block/pan")));
    }
}
