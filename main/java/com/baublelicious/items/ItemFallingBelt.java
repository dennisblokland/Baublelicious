package com.baublelicious.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import baubles.api.BaubleType;

public class ItemFallingBelt extends ItemBaubles{
	
	public ItemFallingBelt(){
		setMaxDamage(1000);
		setUnlocalizedName("ItemFallingBelt");
	}
	
	@Override
	public BaubleType getBaubleType(ItemStack arg0) {
		return BaubleType.BELT;
		
		
	}
	public void onWornTick(ItemStack stack, EntityLivingBase player) {
		EntityPlayer player1 = (EntityPlayer) player;
		//if (player1)
		player1.fallDistance = 0;
		
		
		
	       
	    }
	}


