package com.baublelicious.renderer;

import com.baublelicious.entity.TileentityPedestal;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;


public class PedestalRenderer extends TileEntitySpecialRenderer {

  //The model of your block
  private final PedestalModel model;
  private final RenderItem customRenderItem;
  private Entity entItem;

  public PedestalRenderer() {
    this.model = new PedestalModel();
    customRenderItem = new RenderItem() {
      @Override
      public boolean shouldBob() {
        return false;
      }
    };


  }

  private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
    int meta = world.getBlockMetadata(x, y, z);
    GL11.glRotatef(meta * (90), 0.0F, 1.0F, 0.0F);

  }

  private void adjustRotatePivotViaMetaItem(World world, int x, int y, int z) {
    int meta = world.getBlockMetadata(x, y, z);


    // GL11.glRotatef(meta * (90), 0.0F, 1.0F, 0.0F);
    if (meta == 3)//1
      GL11.glRotatef(meta * (90), 0.0F, 1.0F, 0.0F);
    else if (meta == 1)//3
      GL11.glRotatef(meta * (90), 0.0F, 1.0F, 0.0F);
    else if (meta == 2)//0
      GL11.glRotatef(meta * (180), 0.0F, 1.0F, 0.0F);
    else if (meta == 0)//1
      GL11.glRotatef(1 * (180), 0.0F, 1.0F, 0.0F);
  }

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
    this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
    GL11.glPopMatrix();
    GL11.glPopMatrix();

    TileentityPedestal disp = (TileentityPedestal) te;

    TileentityPedestal tileAltar = (TileentityPedestal) te;

    if (tileAltar.getStackInSlot(0) != null) {
      GL11.glPushMatrix();
      EntityItem ghostEntityItem = new EntityItem(tileAltar.getWorldObj());
      ghostEntityItem.hoverStart = 0.0F;
      ghostEntityItem.setEntityItemStack(tileAltar.getStackInSlot(0));
      float displacement = 0.0F;


      GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
      adjustRotatePivotViaMetaItem(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord);
      GL11.glRotatef(54, 1, 0, 0);
      GL11.glTranslatef(0.0F, -0.50F, 0.685F);

      if (tileAltar.getStackInSlot(0) != null) {
        if (RenderManager.instance.options.fancyGraphics)
          RenderManager.instance.renderEntityWithPosYaw(ghostEntityItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
        else {
          GL11.glRotatef(180F, 0F, 1F, 0F);
          RenderManager.instance.options.fancyGraphics = true;
          RenderManager.instance.renderEntityWithPosYaw(ghostEntityItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
          RenderManager.instance.options.fancyGraphics = false;

        }

      }

      GL11.glPopMatrix();
    }


  }


}