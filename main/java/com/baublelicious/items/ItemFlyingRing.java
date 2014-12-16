package com.baublelicious.items;


import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import baubles.api.BaubleType;
import baubles.api.IBauble;


public class ItemFlyingRing  extends ItemBaubles implements IBauble
{

	public ItemFlyingRing()
	{
		super();
		setUnlocalizedName("ItemFlyingRing");
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RING;
	}
	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase entity) {
		EntityPlayer player = (EntityPlayer) entity;
		
		player.capabilities.isFlying = false;
		player.capabilities.allowFlying = false;

	}
	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase entity) {
		EntityPlayer player = (EntityPlayer) entity;
		player.capabilities.allowFlying = true;

	}
	
	@Override
	public void onWornTick(ItemStack stack, EntityLivingBase entity) {
		EntityPlayer player = (EntityPlayer) entity;
		player.capabilities.allowFlying = true;
	}
	@Override
	public void onEquippedOrLoadedIntoWorld(ItemStack stack, EntityLivingBase entity) {
		EntityPlayer player = (EntityPlayer) entity;
		player.capabilities.allowFlying = true;
	}

	}

		
	
	


	
	

	
	

