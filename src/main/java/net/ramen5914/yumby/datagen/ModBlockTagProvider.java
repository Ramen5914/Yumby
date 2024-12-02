package net.ramen5914.yumby.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.ramen5914.yumby.Yumby;
import net.ramen5914.yumby.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Yumby.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.create(ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, "cutting_boards")))
                .add(ModBlocks.ACACIA_CUTTING_BOARD.get())
                .add(ModBlocks.BAMBOO_CUTTING_BOARD.get())
                .add(ModBlocks.BIRCH_CUTTING_BOARD.get())
                .add(ModBlocks.CHERRY_CUTTING_BOARD.get())
                .add(ModBlocks.CRIMSON_CUTTING_BOARD.get())
                .add(ModBlocks.DARK_OAK_CUTTING_BOARD.get())
                .add(ModBlocks.JUNGLE_CUTTING_BOARD.get())
                .add(ModBlocks.OAK_CUTTING_BOARD.get())
                .add(ModBlocks.SPRUCE_CUTTING_BOARD.get())
                .add(ModBlocks.MANGROVE_CUTTING_BOARD.get())
                .add(ModBlocks.WARPED_CUTTING_BOARD.get());
    }
}
