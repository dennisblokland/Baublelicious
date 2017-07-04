package com.baublelicious.items;

import baubles.api.BaubleType;
import net.minecraft.item.ItemStack;
import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemRingOfFlight extends BaubleliciousBaublesItem {
    public ItemRingOfFlight() {
        this.setUnlocalizedName("ItemRingOfFlight");

    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.RING;
    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase entity) {
        stopFlying((EntityPlayer) entity);
    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase entity) {
        startFlying((EntityPlayer) entity);
    }


    private void startFlying(EntityPlayer player) {
        player.capabilities.allowFlying = true;
        if (!player.getEntityWorld().isRemote) {
            player.sendPlayerAbilities();
        }
    }

    private void stopFlying(EntityPlayer player) {
        player.capabilities.isFlying = false;
        player.capabilities.allowFlying = false;

        if (!player.getEntityWorld().isRemote) {
            player.sendPlayerAbilities();
        }
    }

    @Override
    public void onWornTick(ItemStack stack, EntityLivingBase entity) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = ((EntityPlayer) entity);
            if (!player.capabilities.allowFlying) {
                startFlying(player);
            }
        }
    }

}