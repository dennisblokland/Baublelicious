package com.baublelicious.items;

import baubles.api.BaubleType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemsAmuletNightvision extends ItemBaubles {

  public ItemsAmuletNightvision() {
    this.setUnlocalizedName("ItemsAmuletNightvision");

  }

  @Override
  public BaubleType getBaubleType(ItemStack arg0) {
    // TODO Auto-generated method stub
    return BaubleType.AMULET;
  }

  @Override
  public void onWornTick(ItemStack stack, EntityLivingBase entity) {
    EntityPlayer player = (EntityPlayer) entity;
    player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 4, 1, true));
  }

}
