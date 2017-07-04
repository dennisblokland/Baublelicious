package com.baublelicious.items;

import baubles.api.BaubleType;
import net.minecraft.item.ItemStack;

public class ItemRing extends BaubleliciousBaublesItem {
    public ItemRing() {
        this.setUnlocalizedName("ItemRing");

    }

    @Override
    public BaubleType getBaubleType(ItemStack arg0) {
        return BaubleType.RING;
    }

}