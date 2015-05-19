package com.baublelicious.client.gui;

import com.baublelicious.container.PedestalContainer;
import com.baublelicious.tiles.TilePedestal;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiPedistal extends GuiContainer {

  public GuiPedistal(InventoryPlayer inventoryPlayer, TilePedestal tileEntity) {
    //the container is instanciated and passed to the superclass for handling
    super(new PedestalContainer(inventoryPlayer, tileEntity));
  }

  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {

    fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
  }

  @Override
  protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
    //draw your Gui here, only thing you need to change is the path
    ResourceLocation texture = new ResourceLocation("baublelicious:textures/gui/pedestal.png");
    this.mc.renderEngine.bindTexture(texture);
    int x = (width - xSize) / 2;
    int y = (height - ySize) / 2;
    this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
  }
}