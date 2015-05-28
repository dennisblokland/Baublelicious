package com.baublelicious.client.gui;

import com.baublelicious.ModInfo;
import com.baublelicious.container.MagnetRingContainer;
import com.baublelicious.network.NetworkRegister;
import com.baublelicious.network.messages.MessageBlacklistAdd;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class GuiMagnetRing extends GuiContainer {
  public static final ResourceLocation texture = new ResourceLocation(ModInfo.RESOURCE_LOCATION, "textures/gui/magnetRing.png");
  public MagnetRingContainer container;

  public GuiMagnetRing(MagnetRingContainer container) {
    super(container);
    this.container = container;

    xSize = 176;
    ySize = 112;
  }

  @Override
  protected void drawGuiContainerForegroundLayer(int mx, int my) {
  }

  @Override
  protected void drawGuiContainerBackgroundLayer(float f, int mX, int mY) {
    mc.renderEngine.bindTexture(texture);
    this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
  }

  @Override
  public void initGui() {
    super.initGui();

    buttonList.clear();
    buttonList.add(new GuiToggleButton(0, guiLeft + 29, guiTop + 6, 34, 20, "Meta"));
    buttonList.add(new GuiToggleButton(1, guiLeft + 67, guiTop + 6, 28, 20, "NBT"));
    buttonList.add(new GuiButton(2, guiLeft + 141, guiTop + 6, 28, 20, "Add"));
    buttonList.add(new GuiButton(3, guiLeft + 99, guiTop + 6, 38, 20, "Clear"));
  }

  @Override
  protected void actionPerformed(GuiButton button) {
    if (button instanceof GuiToggleButton) {
      GuiToggleButton toggleButton = (GuiToggleButton) button;
      toggleButton.toggleState = !toggleButton.toggleState;
    } else {
      if (button.id == 2) {
        NetworkRegister.wrapper.sendToServer(new MessageBlacklistAdd(getCompareType()));
      } else if (button.id == 3) {
        NetworkRegister.wrapper.sendToServer(new MessageBlacklistAdd((byte) -1));
      }
    }
  }

  public byte getCompareType() {
    GuiToggleButton metaButton = (GuiToggleButton) buttonList.get(0);
    GuiToggleButton nbtButton = (GuiToggleButton) buttonList.get(1);
    byte compareType = 0;
    if (metaButton.toggleState) {
      compareType = 1;
    }
    if (nbtButton.toggleState) {
      compareType = 2;
    }
    if (nbtButton.toggleState && metaButton.toggleState) {
      compareType = 3;
    }
    return compareType;
  }
}
