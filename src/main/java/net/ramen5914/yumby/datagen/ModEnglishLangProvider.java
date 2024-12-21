package net.ramen5914.yumby.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.ramen5914.yumby.Yumby;
import net.ramen5914.yumby.block.ModBlocks;
import net.ramen5914.yumby.item.ModItems;

public class ModEnglishLangProvider extends LanguageProvider {
    public ModEnglishLangProvider(PackOutput output) {
        super(output, Yumby.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Cooking Utility
        addBlock(ModBlocks.POT, "Pot");
        addBlock(ModBlocks.PAN, "Pan");

        // Bowls
        addBlock(ModBlocks.OAK_BOWL, "Oak Bowl");
        addBlock(ModBlocks.SPRUCE_BOWL, "Spruce Bowl");
        addBlock(ModBlocks.BIRCH_BOWL, "Birch Bowl");
        addBlock(ModBlocks.JUNGLE_BOWL, "Jungle Bowl");
        addBlock(ModBlocks.ACACIA_BOWL, "Acacia Bowl");
        addBlock(ModBlocks.DARK_OAK_BOWL, "Dark Oak Bowl");
        addBlock(ModBlocks.MANGROVE_BOWL, "Mangrove Bowl");
        addBlock(ModBlocks.CHERRY_BOWL, "Cherry Bowl");
        addBlock(ModBlocks.CRIMSON_BOWL, "Crimson Bowl");
        addBlock(ModBlocks.WARPED_BOWL, "Warped Bowl");
        addBlock(ModBlocks.BAMBOO_BOWL, "Bamboo Bowl");

        // Knives
        addItem(ModItems.CHEFS_KNIFE, "Chef's Knife");
        addItem(ModItems.BUTCHERING_KNIFE, "Butchering Knife");
        addItem(ModItems.FILLET_KNIFE, "Fillet Knife");

        // Jade
        add("config.jade.plugin_yumby.jadetest", "what am i supposed to put here");

        // Creative Mode Tabs
        add(String.format("itemgroup.%s.yumby_cookware_tab", Yumby.MOD_ID), "Yumby Cookware");
        add(String.format("itemgroup.%s.yumby_food_tab", Yumby.MOD_ID), "Yumby Foods");
        add(String.format("itemgroup.%s.yumby_seed_tab", Yumby.MOD_ID), "Yumby Seeds");

        /* Crops */
        // Tomato
        addItem(ModItems.TOMATO_SEEDS, "Tomato Seeds");
        addBlock(ModBlocks.TOMATO_CROP, "Tomato Crop");
    }
}
