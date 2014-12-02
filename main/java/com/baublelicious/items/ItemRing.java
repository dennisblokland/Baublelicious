package com.baublelicious.items;

import net.minecraft.item.ItemStack;
import baubles.api.BaubleType;

public class ItemRing extends ItemBaubles {
public ItemRing(){
	this.setUnlocalizedName("ItemRing");
}
	@Override
	public BaubleType getBaubleType(ItemStack arg0) {
		return BaubleType.RING;
	}

}
