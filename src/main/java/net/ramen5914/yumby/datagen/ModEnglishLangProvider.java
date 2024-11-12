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
        addBlockAndItem(ModBlocks.POT, "Pot");
        addBlockAndItem(ModBlocks.PAN, "Pan");

        addBlockAndItem(ModBlocks.OAK_BOWL, "Oak Bowl");
        addBlockAndItem(ModBlocks.SPRUCE_BOWL, "Spruce Bowl");
        addBlockAndItem(ModBlocks.BIRCH_BOWL, "Birch Bowl");
        addBlockAndItem(ModBlocks.JUNGLE_BOWL, "Jungle Bowl");
        addBlockAndItem(ModBlocks.ACACIA_BOWL, "Acacia Bowl");
        addBlockAndItem(ModBlocks.DARK_OAK_BOWL, "Dark Oak Bowl");
        addBlockAndItem(ModBlocks.MANGROVE_BOWL, "Mangrove Bowl");
        addBlockAndItem(ModBlocks.CHERRY_BOWL, "Cherry Bowl");
        addBlockAndItem(ModBlocks.CRIMSON_BOWL, "Crimson Bowl");
        addBlockAndItem(ModBlocks.WARPED_BOWL, "Warped Bowl");
        addBlockAndItem(ModBlocks.BAMBOO_BOWL, "Bamboo Bowl");

        add(String.format("itemgroup.%s.yumby_tab", Yumby.MOD_ID), "Yumby");
    }

    private void addBlockAndItem(DeferredBlock<Block> block, String name) {
        addBlock(block, name);
        addItem(block::asItem, name);
    }
}
