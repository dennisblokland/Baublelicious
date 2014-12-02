package com.baublelicious.network;

import com.baublelicious.baublelicious;
import com.baublelicious.blocks.baubleliciousBlocks;
import com.baublelicious.handler.KeyHandler;
import com.baublelicious.items.BaubleliciousItems;
import com.baublelicious.registery.BaubleliciousRecipe;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		  System.out.print("network Initialized");
	 	 BaubleliciousItems.init();
	 	baubleliciousBlocks.init();
	 	BaubleliciousRecipe.init();

	 	
	 	
	}
   
	public void init() {
	    
    }
    
    public void initRenderers() {
    
    }

	public void registerRenderThings() {
		// TODO Auto-generated method stub
		
	}
    

}