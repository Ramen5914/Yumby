package net.ramen5914.yumby.fluid;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.ramen5914.yumby.Yumby;
import org.joml.Vector3f;

import java.util.function.Supplier;

public class ModFluidTypes {
    private static final ResourceLocation STILL_RL = ResourceLocation.parse("block/water_still");
    private static final ResourceLocation FLOWING_RL = ResourceLocation.parse("block/water_flow");
    private static final ResourceLocation OVERLAY_RL = ResourceLocation.parse("block/water_overlay");

    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, Yumby.MOD_ID);

    public static final Supplier<FluidType> BEEF_BONE_BROTH_FLUID_TYPE = registerFluidType("beef_bone_broth_fluid",
            new BaseFluidType(STILL_RL, FLOWING_RL, OVERLAY_RL,
                    0xA1343E69,
                    new Vector3f(108f/255, 168f/255, 212f/255),
                    FluidType.Properties.create()));

    private static Supplier<FluidType> registerFluidType(String name, FluidType fluidType) {
        return FLUID_TYPES.register(name, () -> fluidType);
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
