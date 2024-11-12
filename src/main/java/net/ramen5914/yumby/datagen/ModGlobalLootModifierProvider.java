package net.ramen5914.yumby.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.ramen5914.yumby.Yumby;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, Yumby.MOD_ID);
    }

    @Override
    protected void start() {
//        add("cow_bone_from_cow", new AddTableLootModifier(new LootItemCondition[]{
//                LootItemKilledByPlayerCondition.killedByPlayer().build(),
//                LootItemEntityPropertyCondition.
//        }, ModItems.CHEFS_KNIFE_KEY.get()));
    }
}
