package net.ramen5914.yumby.recipe.boiling;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.fluids.FluidStack;

public class BoilingRecipeSerializer implements RecipeSerializer<BoilingRecipe> {
    public static final MapCodec<BoilingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            ItemStack.STRICT_CODEC.fieldOf("result").forGetter(BoilingRecipe::getResult),
            Ingredient.CODEC_NONEMPTY
                    .listOf()
                    .fieldOf("ingredients")
                    .flatXmap(
                            ingredients -> {
                                Ingredient[] aIngredient = ingredients.toArray(Ingredient[]::new);
                                if (aIngredient.length == 0) {
                                    return DataResult.error(() -> "No ingredients for boiling recipe");
                                } else {
                                    return aIngredient.length > BoilingRecipe.MAX_INGREDIENTS
                                            ? DataResult.error(() -> "Too many ingredients for boiling recipe. The maximus is: %s".formatted(BoilingRecipe.MAX_INGREDIENTS))
                                            : DataResult.success(NonNullList.of(Ingredient.EMPTY, aIngredient));
                                }
                            },
                            DataResult::success
                    )
                    .forGetter(BoilingRecipe::getIngredients),
            FluidStack.CODEC.fieldOf("fluid").forGetter(BoilingRecipe::getFluid)
    ).apply(inst, BoilingRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, BoilingRecipe> STREAM_CODEC = StreamCodec.of(
            BoilingRecipeSerializer::toNetwork, BoilingRecipeSerializer::fromNetwork
    );

    private static void toNetwork(RegistryFriendlyByteBuf buffer, BoilingRecipe recipe) {
        buffer.writeVarInt(recipe.getIngredients().size());

        for (Ingredient ingredient : recipe.getIngredients()) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
        }

        ItemStack.STREAM_CODEC.encode(buffer, recipe.getResult());

        FluidStack.STREAM_CODEC.encode(buffer, recipe.getFluid());
    }

    private static BoilingRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
        int size = buffer.readVarInt();
        NonNullList<Ingredient> ingredients = NonNullList.withSize(size, Ingredient.EMPTY);
        ingredients.replaceAll(ingredient -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
        ItemStack itemStack = ItemStack.STREAM_CODEC.decode(buffer);
        FluidStack fluidStack = FluidStack.STREAM_CODEC.decode(buffer);

        return new BoilingRecipe(itemStack, ingredients, fluidStack);
    }

    @Override
    public MapCodec<BoilingRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, BoilingRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
