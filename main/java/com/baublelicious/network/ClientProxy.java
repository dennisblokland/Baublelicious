package com.baublelicious.network;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.baublelicious.blocks.TileentityPedistalEntity;
import com.baublelicious.blocks.TileentityPedistalRenderer;
import com.baublelicious.blocks.baubleliciousBlocks;
import com.baublelicious.handler.KeyHandler;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;


public class ClientProxy extends CommonProxy {
    
    @Override
    public void init() {
    	FMLCommonHandler.instance().bus().register(new KeyHandler());
    }

    
    public void registerRenderThings() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileentityPedistalEntity.class, new TileentityPedistalRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(baubleliciousBlocks.BlockPedistal), new ItemRendererTileentityPedistalBlock());
}
    
}