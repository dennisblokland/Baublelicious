package com.baublelicious.items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemNecklaceDiving extends ItemBaubles implements IBauble, IPedestalBauble {

  public ItemNecklaceDiving() {
    super();
    this.setMaxStackSize(1);
    this.setUnlocalizedName("ItemNecklaceDiving");
  }


  @Override
  public BaubleType getBaubleType(ItemStack itemstack) {
    return BaubleType.AMULET;
  }


  @Override
  public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
    World world = player.worldObj;
    int i = MathHelper.floor_double(player.posX);
    int j = MathHelper.floor_double(player.boundingBox.minY + 1);
    int k = MathHelper.floor_double(player.posZ);
    Material m = world.getBlock(i, j, k).getMaterial();
    boolean flag = (m == Material.water);


    if (flag) {
      if (itemstack.getItemDamage() == 0 && !player.isPotionActive(Potion.waterBreathing)) {
        if (player.getAir() == 1 && player instanceof EntityPlayer) {
          player.setAir(300);
        }
      }
    }
  }


  @Override
  public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
    if (!player.worldObj.isRemote) {
      player.worldObj.playSoundAtEntity(player, "random.orb", 0.1F, 1.3f);
    }
  }

  @Override
  public void onPedestalTick(ItemStack bauble, EntityPlayer player) {
    onWornTick(bauble, player);
  }
}