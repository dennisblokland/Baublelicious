package com.baublelicious.config;

import com.baublelicious.ModInfo;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {
  public static int soundEffectChance = 400;
  public static Configuration configuration;

  public static void init(File file) {
    configuration = new Configuration(file);
    readConfig();
  }

  public static void readConfig() {
    soundEffectChance = configuration.getInt("magnetSoundChance", Configuration.CATEGORY_GENERAL, 400, 0, Integer.MAX_VALUE, "Effects the chance of hearing a sound when attempting to suck up an item with a magnet ring. The number is the max bound of the random number generator so a higher number gives a lower chance. 0 will disable the sound altogether", "baublelicous.config.magnetSoundChance");

    if (configuration.hasChanged()) {
      configuration.save();
    }
  }

  @SubscribeEvent
  public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
    if (event.modID.equalsIgnoreCase(ModInfo.MOD_ID)) {
      readConfig();
    }
  }
}
