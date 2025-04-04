package net.ramen5914.yumby;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ramen5914.yumby.block.ModBlocks;
import net.ramen5914.yumby.item.ModItems;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Yumby.MOD_ID);

    public static final Supplier<CreativeModeTab> YUMBY_COOKWARE_TAB =
            CREATIVE_MODE_TABS.register("yumby_cookware_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable(String.format("itemgroup.%s.yumby_cookware_tab", Yumby.MOD_ID)))
                    .icon(() -> new ItemStack(ModBlocks.POT.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.POT);
                        output.accept(ModBlocks.PAN);
                        output.accept(ModBlocks.OAK_BOWL);
                        output.accept(ModBlocks.SPRUCE_BOWL);
                        output.accept(ModBlocks.BIRCH_BOWL);
                        output.accept(ModBlocks.JUNGLE_BOWL);
                        output.accept(ModBlocks.ACACIA_BOWL);
                        output.accept(ModBlocks.DARK_OAK_BOWL);
                        output.accept(ModBlocks.MANGROVE_BOWL);
                        output.accept(ModBlocks.CHERRY_BOWL);
                        output.accept(ModBlocks.CRIMSON_BOWL);
                        output.accept(ModBlocks.WARPED_BOWL);
                        output.accept(ModBlocks.BAMBOO_BOWL);
                        output.accept(ModItems.CHEFS_KNIFE);
                        output.accept(ModItems.BUTCHERING_KNIFE);
                        output.accept(ModItems.FILLET_KNIFE);
                        output.accept(ModBlocks.OAK_CUTTING_BOARD);
                        output.accept(ModBlocks.SPRUCE_CUTTING_BOARD);
                        output.accept(ModBlocks.BIRCH_CUTTING_BOARD);
                        output.accept(ModBlocks.JUNGLE_CUTTING_BOARD);
                        output.accept(ModBlocks.ACACIA_CUTTING_BOARD);
                        output.accept(ModBlocks.DARK_OAK_CUTTING_BOARD);
                        output.accept(ModBlocks.MANGROVE_CUTTING_BOARD);
                        output.accept(ModBlocks.CHERRY_CUTTING_BOARD);
                        output.accept(ModBlocks.CRIMSON_CUTTING_BOARD);
                        output.accept(ModBlocks.WARPED_CUTTING_BOARD);
                        output.accept(ModBlocks.BAMBOO_CUTTING_BOARD);
                    }).build());

    public static final Supplier<CreativeModeTab> YUMBY_FOOD_TAB =
            CREATIVE_MODE_TABS.register("yumby_food_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable(String.format("itemgroup.%s.yumby_food_tab", Yumby.MOD_ID)))
                    .icon(() -> new ItemStack(ModItems.BEEF_BONE.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.BEEF_BONE);
                        output.accept(ModItems.CHICKEN_BONE);
                        output.accept(ModItems.PORK_BONE);
                        output.accept(ModItems.TOMATO);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> YUMBY_SEED_TAB =
            CREATIVE_MODE_TABS.register("yumby_seed_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable(String.format("itemgroup.%s.yumby_seed_tab", Yumby.MOD_ID)))
                    .icon(() -> new ItemStack(ModItems.TOMATO_SEEDS.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.TOMATO_SEEDS.get());
                    })
                    .build());

    public static final Supplier<CreativeModeTab> YUMBY_TESTING_TAB =
            CREATIVE_MODE_TABS.register("yumby_testing_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable(String.format("itemgroup.%s.yumby_testing_tab", Yumby.MOD_ID)))
                    .icon(() -> new ItemStack(ModBlocks.TANK.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.TANK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
