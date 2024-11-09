package net.ramen5914.yumby.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.Block;

public class PanBlock extends Block {
    public static final MapCodec<PanBlock> CODEC = simpleCodec(PanBlock::new);

    public PanBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }
}
