package net.ramen5914.yumby.datagen;

import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.ramen5914.yumby.Yumby;
import net.ramen5914.yumby.datagen.loot.YumbyResourceKeys;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Yumby.MOD_ID);
    }

    @Override
    protected void start() {
        add("beef_bone_from_cow", new AddTableLootModifier(new LootItemCondition[] {
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, new EntityPredicate.Builder().of(EntityType.COW)).build()
        }, YumbyResourceKeys.LootTables.BEEF_BONE_DROPS));

        add("chicken_bone_from_chicken", new AddTableLootModifier(new LootItemCondition[] {
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, new EntityPredicate.Builder().of(EntityType.CHICKEN)).build()
        }, YumbyResourceKeys.LootTables.CHICKEN_BONE_DROPS));

        add("pork_bone_from_pig", new AddTableLootModifier(new LootItemCondition[] {
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, new EntityPredicate.Builder().of(EntityType.PIG)).build()
        }, YumbyResourceKeys.LootTables.PORK_BONE_DROPS));
    }
}
