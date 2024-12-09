package net.ramen5914.yumby;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.ramen5914.yumby.block.ModBlocks;
import net.ramen5914.yumby.block.entity.ModBlockEntities;
import net.ramen5914.yumby.block.entity.renderer.CuttingBoardBlockEntityRenderer;
import net.ramen5914.yumby.block.entity.renderer.PotBlockEntityRenderer;
import net.ramen5914.yumby.fluid.BaseFluidType;
import net.ramen5914.yumby.fluid.ModFluidTypes;
import net.ramen5914.yumby.fluid.ModFluids;
import net.ramen5914.yumby.item.ModItems;
import net.ramen5914.yumby.recipe.ModRecipeSerializers;
import net.ramen5914.yumby.recipe.ModRecipes;
import org.slf4j.Logger;

@Mod(Yumby.MOD_ID)
public class Yumby {
    public static final String MOD_ID = "yumby";

    public static final Logger LOGGER = LogUtils.getLogger();

    public Yumby(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        ModCreativeModeTabs.register(modEventBus);
        
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModFluidTypes.register(modEventBus);
        ModFluids.register(modEventBus);

        ModRecipes.register(modEventBus);
        ModRecipeSerializers.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) { }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
//        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) { }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) { }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_BEEF_BONE_BROTH.get(), RenderType.TRANSLUCENT);
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_BEEF_BONE_BROTH.get(), RenderType.TRANSLUCENT);
            });
        }

        @SubscribeEvent
        public static void onClientExtensions(RegisterClientExtensionsEvent event) {
            event.registerFluidType(((BaseFluidType) ModFluidTypes.BEEF_BONE_BROTH_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                    ModFluidTypes.BEEF_BONE_BROTH_FLUID_TYPE.get());
        }

        @SubscribeEvent
        public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.POT_BE.get(), PotBlockEntityRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.CUTTING_BOARD_BE.get(), CuttingBoardBlockEntityRenderer::new);
        }
    }
}
