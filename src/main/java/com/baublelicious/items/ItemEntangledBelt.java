package com.baublelicious.items;

import baubles.api.BaubleType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemEntangledBelt extends ItemEntangledBauble {
  public ItemEntangledBelt(String key) {
    super(key);
  }

  @Override
  public BaubleType getBaubleType(ItemStack itemStack) {
    return BaubleType.BELT;
  }

  @Override
  public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean bool) {
    super.addInformationForBaubles("No Belts", stack, lines);
  }
}
