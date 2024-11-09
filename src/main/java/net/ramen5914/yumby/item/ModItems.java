package net.ramen5914.yumby.item;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ramen5914.yumby.Yumby;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Yumby.MOD_ID);

    private static ResourceKey<Item> createKey(ResourceKey<? extends Registry<Item>> resourceKey, String id) {
        return ResourceKey.create(resourceKey, ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, id));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
