package net.ramen5914.yumby.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ramen5914.yumby.Yumby;
import net.ramen5914.yumby.item.custom.KnifeItem;

import java.util.function.Function;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Yumby.MOD_ID);

    private static final ResourceKey<Item> CHEFS_KNIFE_KEY = createKey(Registries.ITEM, "chefs_knife");
    private static final ResourceKey<Item> PARING_KNIFE_KEY = createKey(Registries.ITEM, "paring_knife");
    private static final ResourceKey<Item> SERRATED_KNIFE_KEY = createKey(Registries.ITEM, "serrated_knife");
    private static final ResourceKey<Item> UTILITY_KNIFE_KEY = createKey(Registries.ITEM, "utility_knife");
    private static final ResourceKey<Item> BONING_KNIFE_KEY = createKey(Registries.ITEM, "boning_knife");
    private static final ResourceKey<Item> SANTOKU_KNIFE_KEY = createKey(Registries.ITEM, "santoku_knife");
    private static final ResourceKey<Item> CLEAVER_KEY = createKey(Registries.ITEM, "cleaver");
    private static final ResourceKey<Item> FILLET_KNIFE_KEY = createKey(Registries.ITEM, "fillet_knife");
    private static final ResourceKey<Item> CARVING_KNIFE_KEY = createKey(Registries.ITEM, "carving_knife");
    private static final ResourceKey<Item> NAKIRI_KNIFE_KEY = createKey(Registries.ITEM, "nakiri_knife");
    private static final ResourceKey<Item> PEELING_KNIFE_KEY = createKey(Registries.ITEM, "peeling_knife");

    public static final DeferredItem<Item> CHEFS_KNIFE = ITEMS.register("chefs_knife",
            () -> new KnifeItem(new Item.Properties()
                    .setId(CHEFS_KNIFE_KEY)
                    .stacksTo(1)));

    public static final DeferredItem<Item> PARING_KNIFE = ITEMS.register("paring_knife",
            () -> new KnifeItem(new Item.Properties()
                    .setId(PARING_KNIFE_KEY)
                    .stacksTo(1)));

    public static final DeferredItem<Item> SERRATED_KNIFE = ITEMS.register("serrated_knife",
            () -> new KnifeItem(new Item.Properties()
                    .setId(SERRATED_KNIFE_KEY)
                    .stacksTo(1)));

    public static final DeferredItem<Item> UTILITY_KNIFE = ITEMS.register("utility_knife",
            () -> new KnifeItem(new Item.Properties()
                    .setId(UTILITY_KNIFE_KEY)
                    .stacksTo(1)));

    public static final DeferredItem<Item> BONING_KNIFE = ITEMS.register("boning_knife",
            () -> new KnifeItem(new Item.Properties()
                    .setId(BONING_KNIFE_KEY)
                    .stacksTo(1)));

    public static final DeferredItem<Item> SANTOKU_KNIFE = ITEMS.register("santoku_knife",
            () -> new KnifeItem(new Item.Properties()
                    .setId(SANTOKU_KNIFE_KEY)
                    .stacksTo(1)));

    public static final DeferredItem<Item> CLEAVER = ITEMS.register("cleaver",
            () -> new KnifeItem(new Item.Properties()
                    .setId(CLEAVER_KEY)
                    .stacksTo(1)));

    public static final DeferredItem<Item> FILLET_KNIFE = ITEMS.register("fillet_knife",
            () -> new KnifeItem(new Item.Properties()
                    .setId(FILLET_KNIFE_KEY)
                    .stacksTo(1)));

    public static final DeferredItem<Item> CARVING_KNIFE = ITEMS.register("carving_knife",
            () -> new KnifeItem(new Item.Properties()
                    .setId(CARVING_KNIFE_KEY)
                    .stacksTo(1)));

    public static final DeferredItem<Item> NAKIRI_KNIFE = ITEMS.register("nakiri_knife",
            () -> new KnifeItem(new Item.Properties()
                    .setId(NAKIRI_KNIFE_KEY)
                    .stacksTo(1)));

    public static final DeferredItem<Item> PEELING_KNIFE = ITEMS.register("peeling_knife",
            () -> new KnifeItem(new Item.Properties()
                    .setId(PEELING_KNIFE_KEY)
                    .stacksTo(1)));

    public static final DeferredItem<Item> COW_BONE = registerItem("cow_bone",
            Item::new);

    private static ResourceKey<Item> createKey(ResourceKey<? extends Registry<Item>> resourceKey, String id) {
        return ResourceKey.create(resourceKey, ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, id));
    }

    private static <U extends Item> DeferredItem<Item> registerItem(String name, Function<Item.Properties, U> properties) {
        Item.Properties itemProperties = new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, name)));

        return ITEMS.register(name, () -> properties.apply(itemProperties));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
