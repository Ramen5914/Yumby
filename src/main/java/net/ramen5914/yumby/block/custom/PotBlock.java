package net.ramen5914.yumby.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PotBlock extends Block {
    private static final VoxelShape BASE = Block.box(4, 0, 4, 12, 1, 12);
    private static final VoxelShape NORTH_WALL = Block.box(4, 1, 3, 12, 10, 4);
    private static final VoxelShape EAST_WALL = Block.box(12, 1, 4, 13, 10, 12);
    private static final VoxelShape SOUTH_WALL = Block.box(4, 1, 12, 12, 10, 13);
    private static final VoxelShape WEST_WALL = Block.box(3, 1, 4, 4, 10, 12);

    public PotBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.or(BASE, NORTH_WALL, EAST_WALL, SOUTH_WALL, WEST_WALL);
    }
}
