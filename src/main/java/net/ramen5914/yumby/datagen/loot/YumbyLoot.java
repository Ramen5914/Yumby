package net.ramen5914.yumby.datagen.loot;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.ramen5914.yumby.Yumby;

public final class YumbyLoot {
    public static final class Tables {
        public static final ResourceKey<LootTable> BEEF_BONE_DROPS = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, "drops/beef_bone"));
        public static final ResourceKey<LootTable> CHICKEN_BONE_DROPS = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, "drops/chicken_bone"));
        public static final ResourceKey<LootTable> PORK_BONE_DROPS = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, "drops/pork_bone"));
    }
}
