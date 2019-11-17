package com.pugz.bloomful.client.render;

import com.pugz.bloomful.common.block.ChestBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.ChestTileEntityRenderer;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.util.ResourceLocation;

public class WisteriaChestTileEntityRenderer extends ChestTileEntityRenderer<ChestTileEntity> {

    private ChestTileEntity tile;
    public static ResourceLocation forceNormal = new ResourceLocation("bloomful:textures/model/chest/wisteria_chest_double.png");
    public static ResourceLocation forceDouble = new ResourceLocation("bloomful:textures/model/chest/wisteria_chest.png");

    @Override
    public void render(ChestTileEntity tileEntityIn, double x, double y, double z, float partialTicks, int destroyStage) {
        tile = tileEntityIn;
        super.render(tileEntityIn, x, y, z, partialTicks, destroyStage);
    }

    @Override
    protected void bindTexture(ResourceLocation location) {
        boolean isDouble = location.getPath().contains("double");
        if(tile != null && tile.hasWorld()) {
            if(location.getPath().contains("normal")) {
                Block block = tile.getBlockState().getBlock();
                if(block instanceof ChestBlock) {
                    location = isDouble ? forceDouble : forceNormal;
                }
            }
        }
        else {
            ResourceLocation forced = isDouble ? forceDouble : forceNormal;
            if(forced != null) {
                location = forced;
            }
        }
        super.bindTexture(location);
    }
}