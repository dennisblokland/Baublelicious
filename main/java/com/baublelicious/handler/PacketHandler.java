package com.baublelicious.handler;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler {

    public static final SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel("SimplyJetpacks");

    public static void preInit() {
System.out.print("PacketHandler inicilized");
        instance.registerMessage(MessageToggleGrowthAmulet.class, MessageToggleGrowthAmulet.class, 0, Side.SERVER);
       
}
}