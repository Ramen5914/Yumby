package net.ramen5914.yumby.recipe.boiling;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.ramen5914.yumby.Yumby;
import net.ramen5914.yumby.recipe.SimpleRecipeBuilder;

public class BoilingRecipeBuilder extends SimpleRecipeBuilder {
    private final NonNullList<Ingredient> ingredients = NonNullList.create();

    public BoilingRecipeBuilder(ItemStack result) {
        super(result);
    }

    /**
     * Adds an ingredient that can be any item in the given tag.
     */
    public BoilingRecipeBuilder requires(TagKey<Item> tag) {
        return this.requires(Ingredient.of(tag));
    }

    /**
     * Adds an ingredient that can be any item in the given tag multiple times.
     */
    public BoilingRecipeBuilder requires(TagKey<Item> tag, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.requires(Ingredient.of(tag));
        }

        return this;
    }

    /**
     * Adds an ingredient of the given item.
     */
    public BoilingRecipeBuilder requires(ItemLike item) {
        return this.requires(item, 1);
    }

    /**
     * Adds the given ingredient multiple times.
     */
    public BoilingRecipeBuilder requires(ItemLike item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.requires(Ingredient.of(item));
        }

        return this;
    }

    /**
     * Adds an ingredient.
     */
    public BoilingRecipeBuilder requires(Ingredient ingredient) {
        return this.requires(ingredient, 1);
    }

    /**
     * Adds an ingredient multiple times.
     */
    public BoilingRecipeBuilder requires(Ingredient ingredient, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.ingredients.add(ingredient);
        }

        return this;
    }

    @Override
    public void save(RecipeOutput recipeOutput, String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, name + "_from_boiling");

        save(recipeOutput, id);
    }

    @Override
    public void save(RecipeOutput output, ResourceLocation id) {
        this.ensureValid(id);
        Advancement.Builder advancement = output.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                .rewards(AdvancementRewards.Builder.recipe(id))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancement::addCriterion);
        BoilingRecipe recipe = new BoilingRecipe(
                this.result,
                this.ingredients
        );
        output.accept(id, recipe, advancement.build(id.withPrefix("recipes/")));
    }

    private void ensureValid(ResourceLocation id) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + id);
        }
    }
}
