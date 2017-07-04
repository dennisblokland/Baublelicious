package com.baublelicious.items;


import baubles.api.BaubleType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemFallingBelt extends BaubleliciousBaublesItem {
    public ItemFallingBelt() {
        setMaxDamage(1000);
        setUnlocalizedName("ItemFallingBelt");
    }

    @Override
    public BaubleType getBaubleType(ItemStack arg0) {
        return BaubleType.BELT;


    }

    @Override
    public void onWornTick(ItemStack stack, EntityLivingBase entity) {
        EntityPlayer player = (EntityPlayer) entity;
        player.fallDistance = 0;
    }

}
