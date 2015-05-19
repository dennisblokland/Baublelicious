package com.baublelicious.network.handlers;

import com.baublelicious.network.messages.MessageTileNBT;
import com.baublelicious.network.messages.MessageTileRequest;
import com.baublelicious.network.receivers.ITileNBTReceiver;
import com.baublelicious.network.receivers.ITileRequestReceiver;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class HandlerTileNBT implements IMessageHandler<MessageTileNBT, IMessage> {
  @Override
  public IMessage onMessage(MessageTileNBT message, MessageContext ctx) {
    World world = ctx.side.isServer() ? MinecraftServer.getServer().worldServerForDimension(message.dimensionId) : Minecraft.getMinecraft().theWorld;
    if (world.provider.dimensionId == message.dimensionId) {
      TileEntity tile = world.getTileEntity(message.x, message.y, message.z);
      if (tile instanceof ITileNBTReceiver) {
        ((ITileNBTReceiver) tile).onTileNBT(message.compound);
      }
    }
    return null;
  }
}
