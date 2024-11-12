package net.ramen5914.yumby.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.ramen5914.yumby.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider provider) {
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
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
