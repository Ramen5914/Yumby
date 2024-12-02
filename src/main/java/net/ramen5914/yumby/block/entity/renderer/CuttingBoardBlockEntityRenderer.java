package net.ramen5914.yumby.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.ramen5914.yumby.block.custom.CuttingBoardBlock;
import net.ramen5914.yumby.block.entity.custom.CuttingBoardBlockEntity;

public class CuttingBoardBlockEntityRenderer implements BlockEntityRenderer<CuttingBoardBlockEntity> {
    public CuttingBoardBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(CuttingBoardBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = blockEntity.getItem(0);

        Direction facing =  blockEntity.getBlockState().getValue(CuttingBoardBlock.FACING);

        poseStack.pushPose();

        poseStack.mulPose(Axis.YP.rotationDegrees(180));
        poseStack.mulPose(Axis.XP.rotationDegrees(90));
        poseStack.translate(-9/16f, -8/16f, -1.25/16f);

        switch (facing) {
            case EAST -> {
                poseStack.rotateAround(Axis.ZP.rotationDegrees(90), 1/16f, 0, 0);
            }
            case SOUTH -> {
                poseStack.rotateAround(Axis.ZP.rotationDegrees(180), 1/16f, 0, 0);
            }
            case WEST -> {
                poseStack.rotateAround(Axis.ZP.rotationDegrees(270), 1/16f, 0, 0);
            }
        }

        poseStack.scale(7/16f, 7/16f, 7/16f);

        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, getLightLevel(blockEntity.getLevel(), blockEntity.getBlockPos()),
                OverlayTexture.NO_OVERLAY, poseStack, multiBufferSource, blockEntity.getLevel(), 1);

        poseStack.popPose();
            }


    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
