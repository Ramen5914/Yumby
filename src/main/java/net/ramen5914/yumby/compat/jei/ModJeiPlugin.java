package net.ramen5914.yumby.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.ramen5914.yumby.Yumby;
import net.ramen5914.yumby.compat.jei.recipeCategories.BoilingRecipeCategory;
import net.ramen5914.yumby.recipe.ModRecipes;
import net.ramen5914.yumby.recipe.boiling.BoilingRecipe;

import java.util.List;

@JeiPlugin
public class ModJeiPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new BoilingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<BoilingRecipe> boilingRecipes = recipeManager.getAllRecipesFor(ModRecipes.BOILING_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(BoilingRecipeCategory.BOILING_RECIPE_RECIPE_TYPE, boilingRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        // registration.addRecipeClickArea(____Screen.class, 70, 30, 25, 20,
        //         ____RecipeCategory._____RECIPE_RECIPE_TYPE);
    }
}
