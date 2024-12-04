package net.ramen5914.yumby.recipe.boiling;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.ramen5914.yumby.recipe.ModRecipes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record BoilingRecipe(Ingredient inputItem, ItemStack output) implements Recipe<BoilingRecipeInput> {
    private static PlacementInfo info;

    @Override
    public boolean matches(BoilingRecipeInput input, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        return inputItem.test(input.getItem(0));
    }

    @Override
    public ItemStack assemble(BoilingRecipeInput boilingRecipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<BoilingRecipeInput>> getSerializer() {
        return ModRecipes.BOILING_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<BoilingRecipeInput>> getType() {
        return ModRecipes.BOILING_TYPE.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        if (info == null) {
            List<Optional<Ingredient>> ingredients = new ArrayList<>();
            ingredients.add(Optional.of(inputItem));

            info = PlacementInfo.createFromOptionals(ingredients);
        }

        return info;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return null;
    }

    public static class Serializer implements RecipeSerializer<BoilingRecipe> {
        public static final MapCodec<BoilingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(BoilingRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(BoilingRecipe::output)
        ).apply(inst, BoilingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, BoilingRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, BoilingRecipe::inputItem,
                        ItemStack.STREAM_CODEC, BoilingRecipe::output,
                        BoilingRecipe::new);

        @Override
        public MapCodec<BoilingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, BoilingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
