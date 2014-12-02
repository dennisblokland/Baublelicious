package com.baublelicious.network;

import com.baublelicious.handler.KeyHandler;

import cpw.mods.fml.common.FMLCommonHandler;


public class ClientProxy extends CommonProxy {
    
    @Override
    public void init() {
    	FMLCommonHandler.instance().bus().register(new KeyHandler());
    }
    
    @Override
    public void registerRenderThings() {

    }
    
}