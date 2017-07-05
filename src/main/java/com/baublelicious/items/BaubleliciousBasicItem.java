package com.baublelicious.items;

import com.baublelicious.Baublelicious;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BaubleliciousBasicItem extends Item {

    protected String name;

    public BaubleliciousBasicItem() {
        super();
            setCreativeTab(Baublelicious.BaubleliciousTab);
    }
    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        return super.getUnlocalizedName();
    }

    public void registerItemModel(Item item) {
        Baublelicious.proxy.registerItemRenderer(item, 0, name);
    }



}