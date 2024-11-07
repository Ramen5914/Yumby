package net.ramen5914.yumby.item;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ramen5914.yumby.Yumby;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Yumby.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
