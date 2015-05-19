package com.baublelicious.network;

import com.baublelicious.client.gui.GuiPedistal;
import com.baublelicious.container.PedestalContainer;
import com.baublelicious.tiles.TilePedestal;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
  //returns an instance of the Container you made earlier
  @Override
  public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
    TileEntity tileEntity = world.getTileEntity(x, y, z);
    if (tileEntity instanceof TilePedestal) {
      return new PedestalContainer(player.inventory, (TilePedestal) tileEntity);
    }
    return null;
  }

  //returns an instance of the Gui you made earlier
  @Override
  public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
    TileEntity tileEntity = world.getTileEntity(x, y, z);
    if (tileEntity instanceof TilePedestal) {
      return new GuiPedistal(player.inventory, (TilePedestal) tileEntity);
    }
    return null;

  }
}