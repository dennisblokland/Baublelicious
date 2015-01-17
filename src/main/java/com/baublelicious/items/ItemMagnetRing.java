package com.baublelicious.items;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import baubles.api.BaubleType;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class ItemMagnetRing extends ItemBaubles{
	private final float fudgeFactor = 0.0f;
	private float rangeBase;
	public ItemMagnetRing(){
	this.rangeBase = 7f;
	

	setUnlocalizedName("ItemMagnetRing");
}

	
	@Override
	public BaubleType getBaubleType(ItemStack arg0) {
		return BaubleType.RING;
	}
	public void onWornTick(ItemStack stack, EntityLivingBase entity) { 
		{
			EntityPlayer player = (EntityPlayer)entity;
			World world = entity.worldObj;
			
				
				int dragCount = player.getCommandSenderName().hashCode();
				float radius = rangeBase;
				AxisAlignedBB bounds = player.boundingBox.expand(radius, radius, radius);
				
				if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER)
				{
					bounds.expand(fudgeFactor, fudgeFactor, fudgeFactor);

				List<EntityItem> list = world.getEntitiesWithinAABB(EntityItem.class, bounds);
				List<EntityXPOrb> listXP = world.getEntitiesWithinAABB(EntityXPOrb.class, bounds);
				
				for (EntityItem e : list)
				{
					if (e.age >= 10)
					{
						double x = entity.posX - e.posX;
						double y = entity.posY - e.posY;
						double z = entity.posZ - e.posZ;
						
						double length = Math.sqrt(x * x + y * y + z * z) * 2;
						
						x = x / length + entity.motionX / 2;
						y = y / length + entity.motionY / 2;
						z = z / length + entity.motionZ / 2;
						
						e.motionX =+ x;
						e.motionY =+ y;
						e.motionZ =+ z;
						e.isAirBorne = true;
						
						if (e.isCollidedHorizontally)
						{
							e.motionY += 1;
						}
						
						if (world.rand.nextInt(200) == 0)
						{
							float pitch = 0.85f - world.rand.nextFloat() * 3f / 10f;
				            world.playSoundEffect(e.posX, e.posY, e.posZ, "mob.endermen.portal", 0.6f, pitch);
						}
					
					}
				}
				for (EntityXPOrb XP : listXP)
				{
					
					{
						double x = entity.posX - XP.posX;
						double y = entity.posY - XP.posY;
						double z = entity.posZ - XP.posZ;
						
						double length = Math.sqrt(x * x + y * y + z * z) * 2;
						
						x = x / length + entity.motionX / 2;
						y = y / length + entity.motionY / 2;
						z = z / length + entity.motionZ / 2;
						
						XP.motionX =+ x;
						XP.motionY =+ y;
						XP.motionZ =+ z;
						XP.isAirBorne = true;
						
						if (XP.isCollidedHorizontally)
						{
							XP.motionY += 1;
						}
						
						if (world.rand.nextInt(200) == 0)
						{
							float pitch = 0.85f - world.rand.nextFloat() * 3f / 10f;
				            world.playSoundEffect(XP.posX, XP.posY, XP.posZ, "mob.endermen.portal", 0.6f, pitch);
						}
				}
		
	}
	
				}
		}
		
	}
}

				
			
		
		

