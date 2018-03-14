package com.baublelicious.helpers;

import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.inv.BaublesInventoryWrapper;

import com.baublelicious.Baublelicious;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

import java.util.List;
import java.util.UUID;

public class PlayerHelper {
    public static EntityPlayer getPlayerFromUUID(UUID uuid) {
        return getPlayerFromUUID(uuid.toString());
    }

    @SuppressWarnings("unchecked")
    public static EntityPlayer getPlayerFromUUID(String uuid) {
        return Baublelicious.proxy.getPlayerFromUUID(uuid);
    }

    public static boolean isWithinRangeOf(EntityPlayer player, int x, int y, int z, int range) {
        return player.posX >= x - range && player.posX <= x + range + 1 && player.posY >= y - range && player.posY <= y + range + 1 && player.posZ >= z - range && player.posZ <= z + range + 1;
    }

    public static boolean isWearingBauble(EntityPlayer player, IBauble bauble) {
        IInventory inventory = BaublesApi.getBaubles(player);
        for (int slot = 0; slot < inventory.getSizeInventory(); slot++) {
            ItemStack stack = inventory.getStackInSlot(slot);
            if (stack != null && stack.getItem() == bauble) {
                return true;
            }
        }
        return false;
    }
}