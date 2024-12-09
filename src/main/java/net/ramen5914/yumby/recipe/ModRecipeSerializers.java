package net.ramen5914.yumby.recipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ramen5914.yumby.Yumby;
import net.ramen5914.yumby.recipe.boiling.BoilingRecipe;
import net.ramen5914.yumby.recipe.boiling.BoilingRecipeSerializer;

import java.util.function.Supplier;

public class ModRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, Yumby.MOD_ID);

    public static final Supplier<RecipeSerializer<BoilingRecipe>> BOILING =
            RECIPE_SERIALIZERS.register("boiling", BoilingRecipeSerializer::new);


    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZERS.register(eventBus);
    }
}
