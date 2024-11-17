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

    public static final DeferredItem<Item> CHEFS_KNIFE = registerItem("chefs_knife",
            (properties) -> new KnifeItem(properties
                    .stacksTo(1)));

    public static final DeferredItem<Item> PARING_KNIFE = registerItem("paring_knife",
            (properties) -> new KnifeItem(properties
                    .stacksTo(1)));

    public static final DeferredItem<Item> SERRATED_KNIFE = registerItem("serrated_knife",
            (properties) -> new KnifeItem(properties
                    .stacksTo(1)));

    public static final DeferredItem<Item> UTILITY_KNIFE = registerItem("utility_knife",
            (properties) -> new KnifeItem(properties
                    .stacksTo(1)));

    public static final DeferredItem<Item> BONING_KNIFE = registerItem("boning_knife",
            (properties) -> new KnifeItem(properties
                    .stacksTo(1)));

    public static final DeferredItem<Item> SANTOKU_KNIFE = registerItem("santoku_knife",
            (properties) -> new KnifeItem(properties
                    .stacksTo(1)));

    public static final DeferredItem<Item> CLEAVER = registerItem("cleaver",
            (properties) -> new KnifeItem(properties
                    .stacksTo(1)));

    public static final DeferredItem<Item> FILLET_KNIFE = registerItem("fillet_knife",
            (properties) -> new KnifeItem(properties
                    .stacksTo(1)));

    public static final DeferredItem<Item> CARVING_KNIFE = registerItem("carving_knife",
            (properties) -> new KnifeItem(properties
                    .stacksTo(1)));

    public static final DeferredItem<Item> NAKIRI_KNIFE = registerItem("nakiri_knife",
            (properties) -> new KnifeItem(properties
                    .stacksTo(1)));

    public static final DeferredItem<Item> PEELING_KNIFE = registerItem("peeling_knife",
            (properties) -> new KnifeItem(properties
                    .stacksTo(1)));

    public static final DeferredItem<Item> BEEF_BONE = registerItem("beef_bone", Item::new);

    public static final DeferredItem<Item> CHICKEN_BONE = registerItem("chicken_bone", Item::new);

    public static final DeferredItem<Item> PORK_BONE = registerItem("pork_bone", Item::new);

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
