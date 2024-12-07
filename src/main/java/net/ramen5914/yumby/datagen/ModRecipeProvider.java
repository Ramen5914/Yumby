package net.ramen5914.yumby.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.ramen5914.yumby.Yumby;
import net.ramen5914.yumby.block.ModBlocks;
import net.ramen5914.yumby.item.ModItems;
import net.ramen5914.yumby.recipe.boiling.BoilingRecipeBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.POT)
                .pattern("L L")
                .pattern("I I")
                .pattern("III")
                .define('L', Items.LEATHER)
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .unlockedBy("has_leather", has(Items.LEATHER))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.PAN)
                .pattern("  I")
                .pattern("II ")
                .pattern("II ")
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(output);

        bowl(ModBlocks.OAK_BOWL, Blocks.OAK_SLAB)
                .unlockedBy("has_oak_slab", has(Blocks.OAK_SLAB))
                .save(output);

        bowl(ModBlocks.SPRUCE_BOWL, Blocks.SPRUCE_SLAB)
                .unlockedBy("has_spruce_slab", has(Blocks.SPRUCE_SLAB))
                .save(output);

        bowl(ModBlocks.BIRCH_BOWL, Blocks.BIRCH_SLAB)
                .unlockedBy("has_birch_slab", has(Blocks.BIRCH_SLAB))
                .save(output);

        bowl(ModBlocks.JUNGLE_BOWL, Blocks.JUNGLE_SLAB)
                .unlockedBy("has_jungle_slab", has(Blocks.JUNGLE_SLAB))
                .save(output);

        bowl(ModBlocks.ACACIA_BOWL, Blocks.ACACIA_SLAB)
                .unlockedBy("has_acacia_slab", has(Blocks.ACACIA_SLAB))
                .save(output);

        bowl(ModBlocks.DARK_OAK_BOWL, Blocks.DARK_OAK_SLAB)
                .unlockedBy("has_dark_oak_slab", has(Blocks.DARK_OAK_SLAB))
                .save(output);

        bowl(ModBlocks.MANGROVE_BOWL, Blocks.MANGROVE_SLAB)
                .unlockedBy("has_mangrove_slab", has(Blocks.MANGROVE_SLAB))
                .save(output);

        bowl(ModBlocks.CHERRY_BOWL, Blocks.CHERRY_SLAB)
                .unlockedBy("has_cherry_slab", has(Blocks.CHERRY_SLAB))
                .save(output);

        bowl(ModBlocks.CRIMSON_BOWL, Blocks.CRIMSON_SLAB)
                .unlockedBy("has_crimson_slab", has(Blocks.CRIMSON_SLAB))
                .save(output);

        bowl(ModBlocks.WARPED_BOWL, Blocks.WARPED_SLAB)
                .unlockedBy("has_warped_slab", has(Blocks.WARPED_SLAB))
                .save(output);

        bowl(ModBlocks.BAMBOO_BOWL, Blocks.BAMBOO_SLAB)
                .unlockedBy("has_stripped_bamboo_block", has(Blocks.BAMBOO_SLAB))
                .save(output);

        new BoilingRecipeBuilder(new ItemStack(Items.BONE), Ingredient.of(ModItems.BEEF_BONE))
                .unlockedBy("has_beef_bone", has(ModItems.BEEF_BONE))
                .group("misc")
                .save(output, ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, "bone"));
    }

    private ShapedRecipeBuilder bowl(ItemLike output, ItemLike input) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output)
                .pattern("M M")
                .pattern("MMM")
                .define('M', input);
    }
}
