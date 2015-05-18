package com.baublelicious.items;

import baubles.api.BaubleType;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

import java.util.List;

public class ItemAmuletGrowth extends ItemBaubles {

  public static String isActive;
  private int tickDelay = 100;
  public ItemAmuletGrowth() {
    this.setUnlocalizedName("ItemAmuletGrowth");
    setMaxDamage(1001);

    //this.canRepair = true;

  }

  public static void onCreation(ItemStack itemstack, World world, EntityPlayer player) {
    itemstack.stackTagCompound = new NBTTagCompound();

    itemstack.stackTagCompound.setBoolean(isActive, true);


  }

  @Override
  public BaubleType getBaubleType(ItemStack arg0) {
    return BaubleType.AMULET;
  }

  @Override
  public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {


    if (!(par1ItemStack.stackTagCompound == null)) {
      if (par1ItemStack.stackTagCompound.getBoolean("isActive")) {
        par3List.add("Activated");
      } else {
        par3List.add("Deactivated");
      }

    }
  }

  @Override
  public void onWornTick(ItemStack stack, EntityLivingBase entity) {
    World par2World = entity.worldObj;
    if (!(entity instanceof EntityPlayer) || par2World.isRemote) {
      return;
    }


    EntityPlayer player = (EntityPlayer) entity;
    ItemStack belt = PlayerHandler.getPlayerBaubles(player).getStackInSlot(0);
    InventoryBaubles baubles = PlayerHandler.getPlayerBaubles(player);

    Item item = stack.getItem();

    if (!(entity instanceof EntityPlayer)) {
      return;
    }

    EntityPlayer par3EntityPlayer = (EntityPlayer) entity;

    if (stack.stackTagCompound == null) {
      stack.setTagCompound(new NBTTagCompound());
    }
    {
      if (stack.stackTagCompound.getBoolean("isActive")) {

        int range = 5;
        int verticalRange = 2;
        int posX = (int) Math.round(entity.posX - 0.5f);
        int posY = (int) entity.posY;
        int posZ = (int) Math.round(entity.posZ - 0.5f);

        for (int ix = posX - range; ix <= posX + range; ix++) {
          for (int iz = posZ - range; iz <= posZ + range; iz++) {
            for (int iy = posY - verticalRange; iy <= posY + verticalRange; iy++) {
              Block block = par2World.getBlock(ix, iy, iz);


              if (block instanceof IPlantable) {

                if (par2World.rand.nextInt(20) == 0) {


                  block.updateTick(par2World, ix, iy, iz, par2World.rand);
                }
                if (belt != null && belt.getItem() == this) if (par2World.rand.nextInt(80) == 0) {

                  stack.damageItem(1, par3EntityPlayer);
                  if (stack.getItemDamage() == 1001)

                    baubles.setInventorySlotContents(0, null);
                  if (belt.getItem() == null) par2World.playSoundAtEntity(par3EntityPlayer, "random.break", 1.0F, 1.0F);


                }
              }

            }
          }
        }
      }
    }


    return;

  }


  @Override
  public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {

    if (par2World.isRemote) {
      return par1ItemStack;
    }


    if (par1ItemStack.stackTagCompound == null) {
      par1ItemStack.setTagCompound(new NBTTagCompound());
    }

    NBTTagCompound tag = par1ItemStack.stackTagCompound;
    tag.setBoolean("isActive", !(tag.getBoolean("isActive")));

    if (tag.getBoolean("isActive")) {


    } else {

    }

    return par1ItemStack;
  }
}