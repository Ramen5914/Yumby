package net.ramen5914.yumby.recipe.boiling;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.ramen5914.yumby.recipe.SimpleRecipeBuilder;

public class BoilingRecipeBuilder extends SimpleRecipeBuilder {
    private final Ingredient inputItem;

    public BoilingRecipeBuilder(ItemStack result, Ingredient inputItem) {
        super(result);
        this.inputItem = inputItem;
    }

    @Override
    public void save(RecipeOutput output, ResourceKey<Recipe<?>> key) {
        Advancement.Builder advancement = output.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(key))
                .rewards(AdvancementRewards.Builder.recipe(key))
                .requirements(AdvancementRequirements.Strategy.OR);

        this.criteria.forEach(advancement::addCriterion);

        BoilingRecipe recipe = new BoilingRecipe(this.inputItem, this.result);
        output.accept(key, recipe, advancement.build(key.location().withPrefix("recipes/")));
    }
}
