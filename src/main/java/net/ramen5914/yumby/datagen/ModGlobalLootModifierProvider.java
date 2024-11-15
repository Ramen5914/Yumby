package net.ramen5914.yumby.datagen;

import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.ramen5914.yumby.Yumby;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Yumby.MOD_ID);
    }

    @Override
    protected void start() {
        add("cow_bone_from_cow", new AddTableLootModifier(new LootItemCondition[] {
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, new EntityPredicate.Builder().of(registries.lookupOrThrow(Registries.ENTITY_TYPE), EntityType.COW)).build()
        }, ));
    }
}
