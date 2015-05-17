package com.baublelicious.network;

import com.baublelicious.blocks.BaubleliciousBlocks;
import com.baublelicious.tiles.TilePedestal;
import com.baublelicious.handler.KeyHandler;
import com.baublelicious.renderer.ItemRendererPedestalBlock;
import com.baublelicious.renderer.PedestalRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;


public class ClientProxy extends CommonProxy {

  @Override
  public void init() {
    FMLCommonHandler.instance().bus().register(new KeyHandler());
  }


  @Override
  public void registerRenderThings() {
    ClientRegistry.bindTileEntitySpecialRenderer(TilePedestal.class, new PedestalRenderer());
    MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BaubleliciousBlocks.BlockPedestal), new ItemRendererPedestalBlock());
  }

}