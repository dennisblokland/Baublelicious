package com.baublelicious.items;

import baubles.api.BaubleType;
import net.minecraft.item.ItemStack;

public class ItemAmulet extends BaubleliciousBaublesItem {
    public ItemAmulet() {
        setUnlocalizedName("ItemAmulet");
        setRegistryName("ItemAmulet");

    }

    @Override
    public BaubleType getBaubleType(ItemStack arg0) {
        return BaubleType.AMULET;
    }

}