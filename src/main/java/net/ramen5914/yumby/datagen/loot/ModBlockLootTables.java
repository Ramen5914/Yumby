package net.ramen5914.yumby.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.ramen5914.yumby.block.ModBlocks;
import net.ramen5914.yumby.block.custom.TomatoCropBlock;
import net.ramen5914.yumby.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.POT.get());
        dropSelf(ModBlocks.PAN.get());

        dropSelf(ModBlocks.OAK_BOWL.get());
        dropSelf(ModBlocks.SPRUCE_BOWL.get());
        dropSelf(ModBlocks.BIRCH_BOWL.get());
        dropSelf(ModBlocks.JUNGLE_BOWL.get());
        dropSelf(ModBlocks.ACACIA_BOWL.get());
        dropSelf(ModBlocks.DARK_OAK_BOWL.get());
        dropSelf(ModBlocks.MANGROVE_BOWL.get());
        dropSelf(ModBlocks.CHERRY_BOWL.get());
        dropSelf(ModBlocks.CRIMSON_BOWL.get());
        dropSelf(ModBlocks.WARPED_BOWL.get());
        dropSelf(ModBlocks.BAMBOO_BOWL.get());

        dropSelf(ModBlocks.OAK_CUTTING_BOARD.get());
        dropSelf(ModBlocks.SPRUCE_CUTTING_BOARD.get());
        dropSelf(ModBlocks.BIRCH_CUTTING_BOARD.get());
        dropSelf(ModBlocks.JUNGLE_CUTTING_BOARD.get());
        dropSelf(ModBlocks.ACACIA_CUTTING_BOARD.get());
        dropSelf(ModBlocks.DARK_OAK_CUTTING_BOARD.get());
        dropSelf(ModBlocks.MANGROVE_CUTTING_BOARD.get());
        dropSelf(ModBlocks.CHERRY_CUTTING_BOARD.get());
        dropSelf(ModBlocks.CRIMSON_CUTTING_BOARD.get());
        dropSelf(ModBlocks.WARPED_CUTTING_BOARD.get());
        dropSelf(ModBlocks.BAMBOO_CUTTING_BOARD.get());

        crop(ModBlocks.TOMATO_CROP.get(), ModItems.TOMATO.get(), ModItems.TOMATO_SEEDS.get(), TomatoCropBlock.class);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

    private <T extends CropBlock> void crop(Block cropBlock, Item crop, Item seed, Class<T> cropClass) {
        add(cropBlock, createCropDrops(cropBlock, crop, seed, cropLootItemCondition(cropBlock, cropClass)));
    }

    private <T extends CropBlock> LootItemCondition.Builder cropLootItemCondition(Block cropBlock, Class<T> crop) {
        IntegerProperty age;
        int maxAge;

        try {
            age = (IntegerProperty) crop.getField("AGE").get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Failed to retrieve AGE property from crop class: " + crop.getName(), e);
        }

        try {
            maxAge = (int) crop.getField("MAX_AGE").get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Failed to retrieve MAX_AGE property from crop class: " + crop.getName(), e);
        }

        return LootItemBlockStatePropertyCondition.hasBlockStateProperties(cropBlock)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(age, maxAge));
    }
}
