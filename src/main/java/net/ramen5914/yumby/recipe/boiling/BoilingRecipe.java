package net.ramen5914.yumby.recipe.boiling;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.ramen5914.yumby.recipe.ModRecipeSerializers;
import net.ramen5914.yumby.recipe.ModRecipes;

public class BoilingRecipe implements Recipe<BoilingRecipeInput> {
    private final Ingredient inputItem;
    private final ItemStack result;

    public BoilingRecipe(Ingredient inputItem, ItemStack result) {
        this.inputItem = inputItem;
        this.result = result;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(this.inputItem);
        return list;
    }

    public Ingredient getInputItem() {
        return this.inputItem;
    }

    public ItemStack getResult() {
        return this.result;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 1;
    }

    @Override
    public boolean matches(BoilingRecipeInput input, Level level) {
        return this.inputItem.test(input.stack());
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return this.result;
    }

    @Override
    public ItemStack assemble(BoilingRecipeInput boilingRecipeInput, HolderLookup.Provider provider) {
        return this.result.copy();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.BOILING.get();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.BOILING.get();
    }
}
