package com.baublelicious.items;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import baubles.api.BaubleType;
import baubles.api.IBauble;

public class ItemBeltWaterWalking  extends ItemBaubles implements IBauble
{

	public ItemBeltWaterWalking()
	{
		super();
		setUnlocalizedName("ItemBeltWaterWalking");
		
	}

	

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.BELT;
	}






	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		World world = player.worldObj;
		int i = MathHelper.floor_double(player.posX);
		int j = MathHelper.floor_double(player.boundingBox.minY - 1);
		int k = MathHelper.floor_double(player.posZ);
		Material m = world.getBlock(i, j, k).getMaterial();
		boolean flag = (m == Material.water);
		

		
			if( flag && player.motionY < 0.0D && player.isSneaking() == false){
				
				player.posY += -player.motionY; 
				player.motionY = 0.0D; 
				player.fallDistance = 0.0F; 
				
		}
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

	

}