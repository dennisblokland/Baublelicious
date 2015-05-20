package com.baublelicious.network.handlers;

import baubles.common.lib.PlayerHandler;
import com.baublelicious.items.BaubleliciousItems;
import com.baublelicious.network.messages.MessageToggleGrowthAmulet;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class HandlerToggleGrowthAmulet implements IMessageHandler<MessageToggleGrowthAmulet, IMessage> {
  @Override
  public IMessage onMessage(MessageToggleGrowthAmulet message, MessageContext ctx) {
    EntityPlayer entityPlayer = ctx.getServerHandler().playerEntity;
    if (entityPlayer != null) {
      ItemStack baubles = PlayerHandler.getPlayerBaubles(entityPlayer).getStackInSlot(0);
      if (baubles != null) if (baubles.getItem() == BaubleliciousItems.ItemAmuletGrowth) {
        NBTTagCompound tag = baubles.getTagCompound();
        tag.setBoolean("isActive", !(tag.getBoolean("isActive")));
      }

    }
    return null;
  }
}
