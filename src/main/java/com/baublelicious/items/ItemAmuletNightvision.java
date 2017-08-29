package com.baublelicious.items;

import baubles.api.BaubleType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemAmuletNightvision extends BaubleliciousBaublesItem{

    public ItemAmuletNightvision() {
        setUnlocalizedName("ItemAmuletNightvision");
    }

    @Override
    public BaubleType getBaubleType(ItemStack stack) {
        return BaubleType.AMULET;
    }

    @Override
    public void onWornTick(ItemStack stack, EntityLivingBase entity) {
        PotionEffect effect = entity.getActivePotionEffect(Potion.getPotionById(16));
        if (effect == null || effect.getDuration() < 900) entity.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 999999, 0, false, false));

    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
        player.removePotionEffect(Potion.getPotionById(16));
    }
}
