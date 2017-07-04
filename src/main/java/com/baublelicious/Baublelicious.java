package com.baublelicious;

import com.baublelicious.items.BaubleliciousItems;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.NAME, version = ModInfo.VERSION)

public class Baublelicious
{
    @SidedProxy(clientSide = "com.baublelicious.client.ClientProxy", serverSide = "com.baublelicious.CommonProxy")
    public static CommonProxy proxy;
    public static final CreativeTabs BaubleliciousTab = new BaubleliciousTab(CreativeTabs.getNextID(), "Baublelicious");
    @Mod.Instance(ModInfo.MOD_ID)
    public static Baublelicious instance;
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        BaubleliciousItems.init();
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}