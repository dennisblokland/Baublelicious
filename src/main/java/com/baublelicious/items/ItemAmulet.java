package com.baublelicious.items;

import baubles.api.BaubleType;
import net.minecraft.item.ItemStack;

public class ItemAmulet extends ItemBaubles {
  public ItemAmulet() {
    setUnlocalizedName("ItemAmulet");
  }

  @Override
  public BaubleType getBaubleType(ItemStack arg0) {
    return BaubleType.AMULET;
  }

}
