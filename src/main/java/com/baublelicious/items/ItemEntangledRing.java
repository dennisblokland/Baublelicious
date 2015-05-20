package com.baublelicious.items;

import baubles.api.BaubleType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemEntangledRing extends ItemEntangledBauble {
  public ItemEntangledRing(String key) {
    super(key);
  }

  @Override
  public BaubleType getBaubleType(ItemStack itemStack) {
    return BaubleType.RING;
  }

  @Override
  public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean bool) {
    super.addInformationForBaubles("No Rings", stack, lines);
  }
}
