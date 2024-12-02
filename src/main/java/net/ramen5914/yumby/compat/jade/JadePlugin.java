package net.ramen5914.yumby.compat.jade;

import net.ramen5914.yumby.block.custom.PotBlock;
import net.ramen5914.yumby.compat.jade.providers.ComponentProvider;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class JadePlugin implements IWailaPlugin {
    @Override
    public void register(IWailaCommonRegistration registration) {
        //TODO register data providers
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        //TODO register component providers, icon providers, callbacks, and config options here

        registration.registerBlockComponent(ComponentProvider.INSTANCE, PotBlock.class);
    }
}
