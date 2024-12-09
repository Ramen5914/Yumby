package net.ramen5914.yumby.recipe.boiling;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class BoilingRecipeSerializer implements RecipeSerializer<BoilingRecipe> {
    public static final MapCodec<BoilingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC.fieldOf("ingredient").forGetter(BoilingRecipe::getInputItem),
            ItemStack.CODEC.fieldOf("result").forGetter(BoilingRecipe::getResult)
    ).apply(inst, BoilingRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, BoilingRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    Ingredient.CONTENTS_STREAM_CODEC, BoilingRecipe::getInputItem,
                    ItemStack.STREAM_CODEC, BoilingRecipe::getResult,
                    BoilingRecipe::new
            );

    @Override
    public MapCodec<BoilingRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, BoilingRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
