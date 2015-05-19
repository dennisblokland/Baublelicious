package com.baublelicious.network.handlers;

import com.baublelicious.network.messages.MessageTileRequest;
import com.baublelicious.network.receivers.ITileRequestReceiver;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class HandlerTileRequest implements IMessageHandler<MessageTileRequest, IMessage> {
  @Override
  public IMessage onMessage(MessageTileRequest message, MessageContext ctx) {
    World world = MinecraftServer.getServer().worldServerForDimension(message.dimensionId);
    if (world.provider.dimensionId == message.dimensionId) {
      TileEntity tile = world.getTileEntity(message.x, message.y, message.z);
      if (tile instanceof ITileRequestReceiver) {
        ((ITileRequestReceiver) tile).onTileRequest(message.id, ctx.getServerHandler().playerEntity);
      }
    }
    return null;
  }
}
