package com.baublelicious.network;

import com.baublelicious.ModInfo;
import com.baublelicious.handler.MessageToggleGrowthAmulet;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class NetworkRegister {
  public static final SimpleNetworkWrapper wrapper = NetworkRegistry.INSTANCE.newSimpleChannel(ModInfo.MOD_ID);

  public static void registerMessages() {
    // Client Side Handler

    // Server Side Handler
    wrapper.registerMessage(MessageToggleGrowthAmulet.class, MessageToggleGrowthAmulet.class, 100, Side.SERVER);
  }
}