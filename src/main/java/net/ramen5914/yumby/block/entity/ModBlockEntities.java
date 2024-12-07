package net.ramen5914.yumby.block.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ramen5914.yumby.Yumby;
import net.ramen5914.yumby.block.ModBlocks;
import net.ramen5914.yumby.block.entity.custom.CuttingBoardBlockEntity;
import net.ramen5914.yumby.block.entity.custom.PotBlockEntity;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Yumby.MOD_ID);

    public static final Supplier<BlockEntityType<PotBlockEntity>> POT_BE =
            BLOCK_ENTITIES.register("pot_be", () -> BlockEntityType.Builder.of(
                    PotBlockEntity::new, ModBlocks.POT.get()).build(null));

    public static final Supplier<BlockEntityType<CuttingBoardBlockEntity>> CUTTING_BOARD_BE =
            BLOCK_ENTITIES.register("cutting_board_be", () -> BlockEntityType.Builder.of(
                    CuttingBoardBlockEntity::new,
                    ModBlocks.ACACIA_CUTTING_BOARD.get(),
                    ModBlocks.BAMBOO_CUTTING_BOARD.get(),
                    ModBlocks.BIRCH_CUTTING_BOARD.get(),
                    ModBlocks.CHERRY_CUTTING_BOARD.get(),
                    ModBlocks.CRIMSON_CUTTING_BOARD.get(),
                    ModBlocks.DARK_OAK_CUTTING_BOARD.get(),
                    ModBlocks.JUNGLE_CUTTING_BOARD.get(),
                    ModBlocks.OAK_CUTTING_BOARD.get(),
                    ModBlocks.SPRUCE_CUTTING_BOARD.get(),
                    ModBlocks.MANGROVE_CUTTING_BOARD.get(),
                    ModBlocks.WARPED_CUTTING_BOARD.get()
            ).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
