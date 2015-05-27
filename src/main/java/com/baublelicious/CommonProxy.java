package com.baublelicious;

import com.baublelicious.blocks.BaubleliciousBlocks;
import com.baublelicious.items.BaubleliciousItems;
import com.baublelicious.recipes.BaubleliciousRecipe;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

import java.util.List;

public class CommonProxy {
  public void preInit(FMLPreInitializationEvent event) {
    BaubleliciousItems.init();
    BaubleliciousBlocks.init();
    BaubleliciousRecipe.init();


  }

  public void init() {

  }

  public void initRenderers() {

  }

  public void registerRenderThings() {

  }

  public World getWorldForId(int id) {
    return MinecraftServer.getServer().worldServerForDimension(id);
  }

  @SuppressWarnings("unchecked")
  public EntityPlayer getPlayerFromUUID(String uuid) {
    List<EntityPlayerMP> playerList = MinecraftServer.getServer().getConfigurationManager().playerEntityList;
    for (EntityPlayerMP player : playerList) {
      if (player.getUniqueID().toString().equals(uuid)) {
        return player;
      }
    }

    return null;
  }
}