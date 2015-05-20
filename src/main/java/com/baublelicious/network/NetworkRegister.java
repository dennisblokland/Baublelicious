package com.baublelicious.network;

import com.baublelicious.ModInfo;
import com.baublelicious.network.handlers.HandlerToggleGrowthAmulet;
import com.baublelicious.network.messages.MessageToggleGrowthAmulet;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class NetworkRegister {
  public static final SimpleNetworkWrapper wrapper = NetworkRegistry.INSTANCE.newSimpleChannel(ModInfo.MOD_ID);

  public static void registerMessages() {
    // Server Side Handler
    wrapper.registerMessage(HandlerToggleGrowthAmulet.class, MessageToggleGrowthAmulet.class, 100, Side.SERVER);
  }
}