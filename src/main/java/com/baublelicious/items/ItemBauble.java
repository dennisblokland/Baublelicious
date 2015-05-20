package com.baublelicious.items;

import baubles.api.IBauble;
import com.baublelicious.Baublelicious;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

// TODO: Move all baubles over to this class
public abstract class ItemBauble extends Item implements IBauble {
  public ItemBauble(String key) {
    setUnlocalizedName(key);
    setTextureName(key);
    setCreativeTab(Baublelicious.tabBaublelicious);
    setMaxStackSize(1);
  }

  @Override
  public void onWornTick(ItemStack itemStack, EntityLivingBase entityLivingBase) {

  }

  @Override
  public void onEquipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {

  }

  @Override
  public void onUnequipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {

  }

  @Override
  public boolean canEquip(ItemStack itemStack, EntityLivingBase entityLivingBase) {
    return true;
  }

  @Override
  public boolean canUnequip(ItemStack itemStack, EntityLivingBase entityLivingBase) {
    return true;
  }
}
