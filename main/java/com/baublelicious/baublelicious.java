package com.baublelicious;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.baublelicious.handler.PacketHandler;
import com.baublelicious.items.BaubleliciousItems;
import com.baublelicious.network.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid = baublelicious.modid, dependencies="required-after:Baubles@[1.0.1.4,);")
public class baublelicious
{
	@SidedProxy(clientSide = "com.baublelicious.network.ClientProxy", serverSide="com.baublelicious.network.CommonProxy")
    public static CommonProxy proxy;

    public static final String modid = "baublelicious";
    
    public static CreativeTabs TabBaublelicious = new CreativeTabs("Baublelicious")
    {
    public Item getTabIconItem()
    {
    return BaubleliciousItems.ItemNecklesDiving;
    }
    };
    public static SimpleNetworkWrapper network;
    public static boolean isCoFHCoreLoaded;

    @EventHandler
	public void preInit(FMLPreInitializationEvent event) {
    	proxy.registerRenderThings();

		proxy.preInit(event);
		network = NetworkRegistry.INSTANCE.newSimpleChannel("toggle");
		
	//	isCoFHCoreLoaded = Loader.isModLoaded("CoFHCore");
		PacketHandler.preInit();
    }
    	


    @EventHandler
    public void init(FMLInitializationEvent event){
    	
    
    proxy.init();

    {
  
   
    }
 
}

}