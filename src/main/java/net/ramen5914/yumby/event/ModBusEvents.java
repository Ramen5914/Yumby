package net.ramen5914.yumby.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.ramen5914.yumby.Yumby;
import net.ramen5914.yumby.block.entity.ModBlockEntities;
import net.ramen5914.yumby.block.entity.custom.TankBlockEntity;

@EventBusSubscriber(modid = Yumby.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModBusEvents {
    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, ModBlockEntities.TANK_BE.get(), TankBlockEntity::getTank);
    }
}
