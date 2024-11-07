package net.ramen5914.yumby.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.ramen5914.yumby.Yumby;

public class ModEnglishLangProvider extends LanguageProvider {
    public ModEnglishLangProvider(PackOutput output) {
        super(output, Yumby.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

    }
}
