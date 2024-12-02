package net.ramen5914.yumby.compat.jade.providers;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.ramen5914.yumby.Yumby;
import net.ramen5914.yumby.block.entity.custom.PotBlockEntity;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public enum ComponentProvider implements IBlockComponentProvider {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config) {
        if (accessor.getBlockEntity() instanceof PotBlockEntity pot) {
            tooltip.add(Component.literal("Hello World!!!"));
        }
    }

    @Override
    public ResourceLocation getUid() {
        return ResourceLocation.fromNamespaceAndPath(Yumby.MOD_ID, "jadetest");
    }

    @Override
    public int getDefaultPriority() {
        return 1000;
    }
}