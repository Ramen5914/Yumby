package net.ramen5914.yumby.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.ramen5914.yumby.Yumby;
import net.ramen5914.yumby.block.ModBlocks;

public class ModEnglishLangProvider extends LanguageProvider {
    public ModEnglishLangProvider(PackOutput output) {
        super(output, Yumby.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addBlock(ModBlocks.POT, "Pot");
        addBlock(ModBlocks.BOWL, "Bowl");
        addBlock(ModBlocks.PAN, "Pan");

        add(String.format("itemgroup.%s.yumby_tab", Yumby.MOD_ID), "Yumby");
    }

    private void addBlockAndItem(DeferredBlock<Block> block, String name) {
        addBlock(block, name);
        addItem(block::asItem, name);
    }
}
