package com.baublelicious.items;

import com.baublelicious.Baublelicious;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BaubleliciousBasicItem extends Item {

    protected String name;

    public BaubleliciousBasicItem(String name) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void registerItemModel(Item item) {
        Baublelicious.proxy.registerItemRenderer(item, 0, name);
    }

    @Override
    public BaubleliciousBasicItem setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

}