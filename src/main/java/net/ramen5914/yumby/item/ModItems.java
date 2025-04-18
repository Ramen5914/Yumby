package net.ramen5914.yumby.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ramen5914.yumby.Yumby;
import net.ramen5914.yumby.block.ModBlocks;
import net.ramen5914.yumby.item.custom.KnifeItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Yumby.MOD_ID);

    public static final DeferredItem<Item> CHEFS_KNIFE = ITEMS.registerItem("chefs_knife",
            KnifeItem::new,
            new Item.Properties()
                    .stacksTo(1));

    public static final DeferredItem<Item> BUTCHERING_KNIFE = ITEMS.registerItem("butchering_knife",
            KnifeItem::new,
            new Item.Properties()
                    .stacksTo(1));

    public static final DeferredItem<Item> FILLET_KNIFE = ITEMS.registerItem("fillet_knife",
            KnifeItem::new,
            new Item.Properties()
                    .stacksTo(1));

    public static final DeferredItem<Item> BEEF_BONE = ITEMS.registerItem("beef_bone",
            Item::new,
            new Item.Properties());

    public static final DeferredItem<Item> CHICKEN_BONE = ITEMS.registerItem("chicken_bone",
            Item::new,
            new Item.Properties());

    public static final DeferredItem<Item> PORK_BONE = ITEMS.registerItem("pork_bone",
            Item::new,
            new Item.Properties());

    public static final DeferredItem<Item> TOMATO = ITEMS.registerItem("tomato",
            Item::new,
            new Item.Properties().food(ModFoodProperties.TOMATO));

    public static final DeferredItem<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds",
            () -> new ItemNameBlockItem(ModBlocks.TOMATO_CROP.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
