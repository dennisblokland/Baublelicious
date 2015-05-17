package com.baublelicious.items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemBeltStepAssist extends ItemBaubles implements IBauble, IPedestalBauble {
  public ItemBeltStepAssist() {
    super();
    setUnlocalizedName("ItemBeltStepAssist");
  }

  @Override
  public BaubleType getBaubleType(ItemStack itemstack) {
    return BaubleType.BELT;
  }

  @Override
  public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
    if (!player.worldObj.isRemote) {
      player.worldObj.playSoundAtEntity(player, "random.orb", 0.1F, 1.3f);
    }
  }


  @Override
  public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
    if (player instanceof EntityPlayer) {
      if ((player.onGround) && player.moveForward > 0F){
        player.stepHeight = 1F;
      }
    }
  }

  @Override
  public void onUnequipped(ItemStack stack, EntityLivingBase player) {
    player.stepHeight = 0.5f;
  }


  @Override
  public void onEquippedOrLoadedIntoWorld(ItemStack stack, EntityLivingBase player) {
    player.stepHeight = 1F;
  }

  @Override
  public void onPedestalTick(ItemStack bauble, EntityPlayer player) {
    if ((player.onGround) && player.moveForward > 0F){
      player.stepHeight = 1F;
    } else {
      player.stepHeight = 0.5f;
    }
  }
}


