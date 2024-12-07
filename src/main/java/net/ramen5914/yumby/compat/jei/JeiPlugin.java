package net.ramen5914.yumby.compat.jei;

import mezz.jei.api.IModPlugin;
import net.minecraft.resources.ResourceLocation;
import net.ramen5914.yumby.Yumby;

@mezz.jei.api.JeiPlugin
public class JeiPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, "jei_plugin");
    }
}
