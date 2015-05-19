package com.baublelicious.network.handlers;

import com.baublelicious.Baublelicious;
import com.baublelicious.network.messages.MessageTileNBT;
import com.baublelicious.network.receivers.ITileNBTReceiver;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class HandlerTileNBT implements IMessageHandler<MessageTileNBT, IMessage> {
  @Override
  public IMessage onMessage(MessageTileNBT message, MessageContext ctx) {
    World world = Baublelicious.proxy.getWorldForId(message.dimensionId);
    if (world != null) {
      TileEntity tile = world.getTileEntity(message.x, message.y, message.z);
      if (tile instanceof ITileNBTReceiver) {
        ((ITileNBTReceiver) tile).onTileNBT(message.compound);
      }
    }
    return null;
  }
}
