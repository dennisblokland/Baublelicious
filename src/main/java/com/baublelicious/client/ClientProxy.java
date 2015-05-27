package com.baublelicious.client;

import com.baublelicious.CommonProxy;
import com.baublelicious.blocks.BaubleliciousBlocks;
import com.baublelicious.client.renderers.ItemRendererPedestalBlock;
import com.baublelicious.client.renderers.PedestalRenderer;
import com.baublelicious.handler.KeyHandler;
import com.baublelicious.tiles.TilePedestal;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
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

  @Override
  public World getWorldForId(int id) {
    return FMLCommonHandler.instance().getEffectiveSide().isServer() ? super.getWorldForId(id) : (Minecraft.getMinecraft().theWorld.provider.dimensionId == id ? Minecraft.getMinecraft().theWorld : null);
  }

  @Override
  public EntityPlayer getPlayerFromUUID(String uuid) {
    if (FMLCommonHandler.instance().getEffectiveSide().isServer()) {
      return super.getPlayerFromUUID(uuid);
    } else {
      return Minecraft.getMinecraft().thePlayer.getUniqueID().toString().equals(uuid) ? Minecraft.getMinecraft().thePlayer : null;
    }
  }
}