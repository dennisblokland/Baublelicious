package com.baublelicious.items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemFlyingRing extends ItemBaubles implements IBauble {
  public ItemFlyingRing() {
    super();
    setUnlocalizedName("ItemFlyingRing");
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

  @Override
  public void onWornTick(ItemStack stack, EntityLivingBase entity) {
    EntityPlayer player = (EntityPlayer) entity;
    if (!player.capabilities.allowFlying) {
      startFlying(player);
    }
  }

  @Override
  public void onEquippedOrLoadedIntoWorld(ItemStack stack, EntityLivingBase entity) {

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
}

		
	
	


	
	

	
	

