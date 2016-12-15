package com.baublelicious.items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemAmuletFieryCore extends ItemBaubles implements IBauble {

	public ItemAmuletFieryCore(){
		   this.setUnlocalizedName("ItemAmuletFieryCore");
		    setMaxDamage(2002);
	}
	public static final String[] IS_IMMUNE_TO_FIRE = new String[] { "isImmuneToFire", "field_70178_ae", "ag" };
	@Override
	public void onWornTick(ItemStack stack, EntityLivingBase player) {
		  World par2World = player.worldObj;
		    World world = player.worldObj;
		    int x = MathHelper.floor_double(player.posX);
		    int y = MathHelper.floor_double(player.boundingBox.minY);
		    int z = MathHelper.floor_double(player.posZ);
		    Material mlava = world.getBlock(x, y, z).getMaterial();
	    EntityPlayer playerEntity = (EntityPlayer) player;
	    ItemStack amulet = PlayerHandler.getPlayerBaubles(playerEntity).getStackInSlot(0);
	    InventoryBaubles baubles = PlayerHandler.getPlayerBaubles(playerEntity);
	    if(mlava == Material.lava){

			
		


            stack.damageItem(1, playerEntity);
            
            if (stack.getItemDamage() == 2002)
              baubles.setInventorySlotContents(0, null);
            setImmunity(player, false);
            if (amulet.getItem() == null) par2World.playSoundAtEntity(playerEntity, "random.break", 1.0F, 1.0F);
           

          }
		  setImmunity(player, true);
		
	}

	@Override
	public void onUnequipped(ItemStack stack, EntityLivingBase player) {
		setImmunity(player, false);
	}

	private void setImmunity(Entity entity, boolean immune) {
		ReflectionHelper.setPrivateValue(Entity.class, entity, immune, IS_IMMUNE_TO_FIRE);
	}	
	@Override
	public BaubleType getBaubleType(ItemStack arg0) {
		return BaubleType.AMULET;
	}

}
