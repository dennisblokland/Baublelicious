package com.baublelicious;

import com.baublelicious.handler.PacketHandler;
import com.baublelicious.items.BaubleliciousItems;
import com.baublelicious.network.CommonProxy;
import com.baublelicious.network.GuiHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = "required-after:Baubles@[1.0.1.4,);")
public class Baublelicious {
  @Instance("baublelicious")
  public static Baublelicious instance;

  @SidedProxy(clientSide = "com.baublelicious.network.ClientProxy", serverSide = "com.baublelicious.network.CommonProxy")
  public static CommonProxy proxy;

  public static CreativeTabs TabBaublelicious = new CreativeTabs("Baublelicious") {
    @Override
    public Item getTabIconItem() {
      return BaubleliciousItems.ItemNecklesDiving;
    }
  };

  public static SimpleNetworkWrapper network;

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    proxy.registerRenderThings();

    proxy.preInit(event);
    network = NetworkRegistry.INSTANCE.newSimpleChannel("toggle");

    PacketHandler.preInit();
  }


  @EventHandler
  public void init(FMLInitializationEvent event) {
    NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    proxy.init();
  }

  @EventHandler
  public void load(FMLInitializationEvent event) {
    proxy.registerRenderThings();
  }
}