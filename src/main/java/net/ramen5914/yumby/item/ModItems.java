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

    public static final DeferredItem<Item> BUTCHERING_KNIFE = registerItem("butchering_knife",
            (properties) -> new KnifeItem(properties
                    .stacksTo(1)));

    public static final DeferredItem<Item> FILLET_KNIFE = registerItem("fillet_knife",
            (properties -> new KnifeItem(properties
                    .stacksTo(1))));

    public static final DeferredItem<Item> BEEF_BONE = registerItem("beef_bone", Item::new);

    public static final DeferredItem<Item> CHICKEN_BONE = registerItem("chicken_bone", Item::new);

    public static final DeferredItem<Item> PORK_BONE = registerItem("pork_bone", Item::new);

//    public static final DeferredItem<Item> ONION_SEEDS = registerItem("onion_seeds",
//            (properties) -> new BlockItem(ModBlocks.ONION_CROP.get(), properties));

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
