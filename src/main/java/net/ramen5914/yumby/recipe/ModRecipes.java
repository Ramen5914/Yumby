package net.ramen5914.yumby.recipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ramen5914.yumby.Yumby;
import net.ramen5914.yumby.recipe.boiling.BoilingRecipe;

import java.util.function.Supplier;

public class ModRecipes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, Yumby.MOD_ID);

    public static final Supplier<RecipeType<BoilingRecipe>> BOILING =
            RECIPE_TYPES.register(
                    "boiling",
                    () -> RecipeType.<BoilingRecipe>simple(ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, "boiling")));

    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
    }
}
