package com.baublelicious.handler;

import baubles.common.lib.PlayerHandler;

import com.baublelicious.items.BaubleliciousItems;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageToggleGrowthAmulet implements IMessage, IMessageHandler<MessageToggleGrowthAmulet, IMessage> {

    public int keyId;
    public boolean showInChat;

    public MessageToggleGrowthAmulet() {
    }

    public MessageToggleGrowthAmulet(boolean showInChat) {
       
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.keyId = buf.readInt();
        this.showInChat = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.keyId);
        buf.writeBoolean(this.showInChat);
    }

    @Override
    public IMessage onMessage(MessageToggleGrowthAmulet message, MessageContext ctx) {
        EntityPlayer entityPlayer = ctx.getServerHandler().playerEntity;
        if (entityPlayer != null) {
            ItemStack baubles = PlayerHandler.getPlayerBaubles(entityPlayer).getStackInSlot(0);
            if (baubles != null)
            if (baubles.getItem() == BaubleliciousItems.ItemAmuletGrowth) {
            	
         	        NBTTagCompound tag = baubles.getTagCompound();
         	        World world = entityPlayer.worldObj;
        	        tag.setBoolean("isActive", !(tag.getBoolean("isActive")));

        	        if (tag.getBoolean("isActive"))
        	        {
        	        	
        	        } else
        	        	
        	        {
        	        }
}

    }
		return null;
}
}
    

