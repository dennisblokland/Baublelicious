package com.baublelicious.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IPedestalBauble {
  void onPedestalTick(ItemStack bauble, EntityPlayer player);
}
