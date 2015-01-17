package com.baublelicious.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import baubles.api.IBauble;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;


public abstract class ItemBaubles extends ItemMod implements IBauble {

	public static Item instance;
	public ItemBaubles() {
		super();
		setMaxStackSize(1);
		

	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		InventoryBaubles baubles = PlayerHandler.getPlayerBaubles(par3EntityPlayer);
		for(int i = 0; i < baubles.getSizeInventory(); i++) {
			if(baubles.isItemValidForSlot(i, par1ItemStack)) {
				ItemStack stackInSlot = baubles.getStackInSlot(i);
				if(stackInSlot == null || ((IBauble) stackInSlot.getItem()).canUnequip(stackInSlot, par3EntityPlayer)) {
					if(!par2World.isRemote) {
						baubles.setInventorySlotContents(i, par1ItemStack.copy());
						if(!par3EntityPlayer.capabilities.isCreativeMode)
							par3EntityPlayer.inventory.setInventorySlotContents(par3EntityPlayer.inventory.currentItem, null);
					}

					onEquipped(par1ItemStack, par3EntityPlayer);

					if(stackInSlot != null) {
						((IBauble) stackInSlot.getItem()).onUnequipped(stackInSlot, par3EntityPlayer);
						return stackInSlot.copy();
					}
					break;
				}
			}
		}


		return par1ItemStack;
	}
	@Override
	public boolean canEquip(ItemStack stack, EntityLivingBase player) {
		return true;
	}
	@Override
	public boolean canUnequip(ItemStack stack, EntityLivingBase player) {
		return true;
	}
	public void onWornTick(ItemStack stack, EntityLivingBase player) {
		if(player.ticksExisted == 1)
			onEquippedOrLoadedIntoWorld(stack, player);
	}
	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

		if (!player.worldObj.isRemote) {
			player.worldObj.playSoundAtEntity(player, "random.orb", 0.1F, 1.3f);
		}
	
	}
	public void onEquippedOrLoadedIntoWorld(ItemStack stack, EntityLivingBase player) {
		
	}
	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		// TODO Auto-generated method stub
		
	}


	
		
	}
	
