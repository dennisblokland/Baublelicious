package com.baublelicious.config;

import com.baublelicious.ModInfo;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class BGuiConfig extends GuiConfig {
  public BGuiConfig(GuiScreen parentScreen) {
    super(parentScreen, new ConfigElement(Config.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), ModInfo.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(Config.configuration.toString()));
  }
}
