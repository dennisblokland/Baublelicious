package com.baublelicious.items;

import net.minecraft.item.ItemStack;
import baubles.api.BaubleType;

public class ItemBelt extends ItemBaubles {
	public ItemBelt() {
		setUnlocalizedName("ItemBelt");
	}

	@Override
	public BaubleType getBaubleType(ItemStack arg0) {
		return BaubleType.BELT;
	}

}
