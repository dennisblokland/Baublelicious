package com.baublelicious.network;

import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.baublelicious.blocks.PedistalModel;

import cpw.mods.fml.client.FMLClientHandler;

public class ItemRendererTileentityPedistalBlock implements IItemRenderer {
	private final PedistalModel model;
    
    public ItemRendererTileentityPedistalBlock() {
            this.model = new PedistalModel();
    }
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		 return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {	
		 GL11.glPushMatrix();
            ResourceLocation texture = new ResourceLocation("baublelicious:textures/models/TileentityPedistal.png");
            FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture);                  
            GL11.glPushMatrix();
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0f, -1f, 0.0F);
            this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
    
	}
	
	
}
