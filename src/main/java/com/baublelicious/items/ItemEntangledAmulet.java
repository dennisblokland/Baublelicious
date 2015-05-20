package com.baublelicious.items;

import baubles.api.BaubleType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemEntangledAmulet extends ItemEntangledBauble {
  public ItemEntangledAmulet(String key) {
    super(key);
  }

  @Override
  public BaubleType getBaubleType(ItemStack itemStack) {
    return BaubleType.AMULET;
  }

  @Override
  public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean bool) {
    super.addInformationForBaubles("No Amulets", stack, lines);
  }
}
