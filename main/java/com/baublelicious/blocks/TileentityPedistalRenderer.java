package com.baublelicious.blocks;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;


public class TileentityPedistalRenderer extends TileEntitySpecialRenderer {
	
        //The model of your block
        private final PedistalModel model;
        
        public TileentityPedistalRenderer() {
                this.model = new PedistalModel();
                customRenderItem = new RenderItem()
    	        {
    	            @Override
    	            public boolean shouldBob()
    	            {
    	                return false;
    	            }
    	        };
        
               
        }
        	private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
        		  int meta = world.getBlockMetadata(x, y, z);
                  GL11.glRotatef(meta * (90), 0.0F, 1.0F, 0.0F);
        	}
        	
        
        	private final RenderItem customRenderItem;
			private Entity entItem;
			
		
        
        @Override
        public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        

        	 GL11.glPushMatrix();
             GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
                ResourceLocation texture = new ResourceLocation("baublelicious:textures/models/TileentityPedistal.png");
                FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture);                  
                GL11.glPushMatrix();
                GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
                adjustRotatePivotViaMeta(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord);
                this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
               
                GL11.glPopMatrix();
                GL11.glPopMatrix();
               
                TileentityPedistalEntity disp = (TileentityPedistalEntity)te;
             
               TileentityPedistalEntity tileAltar = (TileentityPedistalEntity) te;
            
                if (tileAltar.getStackInSlot(0) != null)
                {
                	 
                	 GL11.glPushMatrix();
                    EntityItem ghostEntityItem = new EntityItem(tileAltar.getWorldObj());
                    ghostEntityItem.hoverStart = 0.0F;
                    ghostEntityItem.setEntityItemStack(tileAltar.getStackInSlot(0));
                    float displacement = 0.0F;
                    GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
                    adjustRotatePivotViaMeta(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord);
                    GL11.glRotatef(90, 1, 0, 0);
                    RenderManager.instance.renderEntityWithPosYaw(ghostEntityItem, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
                    GL11.glPopMatrix();
                }
              
              
             
        }
        
          
                
        
               
}