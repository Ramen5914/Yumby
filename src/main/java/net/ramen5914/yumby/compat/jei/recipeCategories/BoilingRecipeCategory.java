package net.ramen5914.yumby.compat.jei.recipeCategories;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.ramen5914.yumby.Yumby;
import net.ramen5914.yumby.block.ModBlocks;
import net.ramen5914.yumby.recipe.boiling.BoilingRecipe;
import org.jetbrains.annotations.Nullable;

public class BoilingRecipeCategory implements IRecipeCategory<BoilingRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, "boiling");

    public static final RecipeType<BoilingRecipe> BOILING_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, BoilingRecipe.class);

    private final IDrawable icon;

    public BoilingRecipeCategory(IGuiHelper helper) {
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.POT.get()));
    }

    @Override
    public RecipeType<BoilingRecipe> getRecipeType() {
        return BOILING_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Boiling");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, BoilingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 54, 34).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 104, 34).addItemStack(recipe.getResultItem(null));
    }
}
