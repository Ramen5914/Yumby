package net.ramen5914.yumby.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BowlBlock extends Block{
    public static final MapCodec<BowlBlock> CODEC = simpleCodec(BowlBlock::new);

    public BowlBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }
}
