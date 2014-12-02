package com.baublelicious.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import baubles.api.BaubleType;
import baubles.api.IBauble;

public class ItemBeltStepAssist  extends ItemBaubles implements IBauble
{

	public ItemBeltStepAssist()
	{
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
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
	
	}



	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		player.stepHeight = 1.0F;
		
	}

	

	}
	

