package com.baublelicious.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
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
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if(player instanceof EntityPlayer) {
			if((player.onGround) && player.moveForward > 0F)
			
				player.stepHeight = 1F;
		}
		
	}
	@Override
	public void onUnequipped(ItemStack stack, EntityLivingBase player) {
		player.stepHeight = 0.5F;
	}


	@Override
	public void onEquippedOrLoadedIntoWorld(ItemStack stack, EntityLivingBase player) {
		player.stepHeight = 1F;
	}

	}
	

