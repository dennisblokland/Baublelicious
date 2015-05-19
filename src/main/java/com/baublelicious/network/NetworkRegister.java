package com.baublelicious.network;

import com.baublelicious.ModInfo;
import com.baublelicious.handler.MessageToggleGrowthAmulet;
import com.baublelicious.network.handlers.HandlerTileNBT;
import com.baublelicious.network.handlers.HandlerTileRequest;
import com.baublelicious.network.messages.MessageTileNBT;
import com.baublelicious.network.messages.MessageTileRequest;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class NetworkRegister {
  public static final SimpleNetworkWrapper wrapper = NetworkRegistry.INSTANCE.newSimpleChannel(ModInfo.MOD_ID);

  public static void registerMessages() {
    // Client Side Handler
    wrapper.registerMessage(HandlerTileNBT.class, MessageTileNBT.class, 2, Side.CLIENT);

    // Server Side Handler
    wrapper.registerMessage(MessageToggleGrowthAmulet.class, MessageToggleGrowthAmulet.class, 100, Side.SERVER);
    wrapper.registerMessage(HandlerTileRequest.class, MessageTileRequest.class, 101, Side.SERVER);
    wrapper.registerMessage(HandlerTileNBT.class, MessageTileNBT.class, 102, Side.SERVER);
  }
}