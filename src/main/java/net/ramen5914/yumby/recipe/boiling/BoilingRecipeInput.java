package net.ramen5914.yumby.recipe.boiling;

import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.neoforged.neoforge.fluids.FluidStack;

import java.util.List;

public class BoilingRecipeInput implements RecipeInput {
    private final List<ItemStack> items;
    private final FluidStack fluid;
    private final StackedContents stackedContents = new StackedContents();
    private final int ingredientCount;

    public BoilingRecipeInput(List<ItemStack> items, FluidStack fluid) {
        this.fluid = fluid;

        this.items = items;
        int i = 0;

        for (ItemStack itemStack : items) {
            if (!itemStack.isEmpty()) {
                i++;
                this.stackedContents.accountStack(itemStack, 1);
            }
        }

        this.ingredientCount = i;
    }

    @Override
    public ItemStack getItem(int index) {
        return this.items.get(index);
    }

    @Override
    public int size() {
        return this.items.size();
    }

    @Override
    public boolean isEmpty() {
        return this.ingredientCount == 0;
    }

    public StackedContents stackedContents() {
        return this.stackedContents;
    }

    public List<ItemStack> items() {
        return this.items;
    }

    public FluidStack fluid() {
        return this.fluid;
    }

    public int ingredientCount() {
        return this.ingredientCount;
    }

    @Override
    public boolean equals(Object other) {
        return other == this;
    }
}
