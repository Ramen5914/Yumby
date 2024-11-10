package net.ramen5914.yumby.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class PanBlock extends BaseEntityBlock {
    public static final MapCodec<PanBlock> CODEC = simpleCodec(PanBlock::new);
    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;

    private static final VoxelShape NORTH_HANDLE = Block.box(9.25, 1, 7, 15.25, 2, 9);
    private static final VoxelShape EAST_HANDLE = Block.box(7, 1, 9.25, 9, 2, 15.25);
    private static final VoxelShape SOUTH_HANDLE = Block.box(0.75, 1, 7, 6.75, 2, 9);
    private static final VoxelShape WEST_HANDLE = Block.box(7, 1, 0.75, 9, 2, 6.75);

    private static final VoxelShape NORTH_DISH = Block.box(0.75, 0, 3.75, 9.25, 2, 12.25);
    private static final VoxelShape EAST_DISH = Block.box(3.75, 0, 0.75, 12.25, 2, 9.25);
    private static final VoxelShape SOUTH_DISH = Block.box(6.75, 0, 3.75, 15.25, 2, 12.25);
    private static final VoxelShape WEST_DISH = Block.box(3.75, 0, 6.75, 12.25, 2, 15.25);

    private static final VoxelShape NORTH_PAN = Shapes.or(NORTH_DISH, NORTH_HANDLE);
    private static final VoxelShape EAST_PAN = Shapes.or(EAST_DISH, EAST_HANDLE);
    private static final VoxelShape SOUTH_PAN = Shapes.or(SOUTH_DISH, SOUTH_HANDLE);
    private static final VoxelShape WEST_PAN = Shapes.or(WEST_DISH, WEST_HANDLE);

    public PanBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Block.box(0.75d, 0, 3.75d, 15.25d, 2d, 12.25d);
    }
}
