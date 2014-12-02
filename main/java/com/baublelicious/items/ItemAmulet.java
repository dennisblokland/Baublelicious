package com.baublelicious.items;

import net.minecraft.item.ItemStack;
import baubles.api.BaubleType;

public class ItemAmulet extends ItemBaubles {
	public ItemAmulet() {
		setUnlocalizedName("ItemAmulet");
	}
	@Override
	public BaubleType getBaubleType(ItemStack arg0) {
		return BaubleType.AMULET;
	}

}
