package net.ramen5914.yumby;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ramen5914.yumby.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Yumby.MOD_ID);

    public static final Supplier<CreativeModeTab> YUMBY_TAB =
            CREATIVE_MODE_TABS.register("yumby_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable(String.format("itemgroup.%s.yumby_tab", Yumby.MOD_ID)))
                    .icon(() -> new ItemStack(ModBlocks.BOWL.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.BOWL);
                        output.accept(ModBlocks.POT);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
