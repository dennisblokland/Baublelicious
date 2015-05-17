package com.baublelicious.items;

import baubles.api.BaubleType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemFallingBelt extends ItemBaubles {

  public ItemFallingBelt() {
    setMaxDamage(1000);
    setUnlocalizedName("ItemFallingBelt");
  }

  @Override
  public BaubleType getBaubleType(ItemStack arg0) {
    return BaubleType.BELT;


  }

  @Override
  public void onWornTick(ItemStack stack, EntityLivingBase player) {
    EntityPlayer player1 = (EntityPlayer) player;
    //if (player1)
    player1.fallDistance = 0;


  }
}


