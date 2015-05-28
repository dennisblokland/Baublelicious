package com.baublelicious.network.handlers;

import com.baublelicious.container.MagnetRingContainer;
import com.baublelicious.network.messages.MessageBlacklistAdd;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.inventory.Container;

public class HandlerBlacklistAdd implements IMessageHandler<MessageBlacklistAdd, IMessage> {
  @Override
  public IMessage onMessage(MessageBlacklistAdd message, MessageContext ctx) {
    if (ctx.side.isServer()) {
      Container openContainer = ctx.getServerHandler().playerEntity.openContainer;
      if (openContainer instanceof MagnetRingContainer) {
        ((MagnetRingContainer) openContainer).addToBlacklist(message.compareType);
      }
    }
    return null;
  }
}
