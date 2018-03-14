package com.baublelicious.blocks;

import com.baublelicious.Baublelicious;
import com.baublelicious.BaubleliciousTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BaubleliciousBasicBlock extends Block {

    protected String name;

    public BaubleliciousBasicBlock(Material material, String name) {
        super(material);

        this.name = name;

        setUnlocalizedName(name);
        setRegistryName(name);

        setCreativeTab(Baublelicious.BaubleliciousTab);
    }

    public void registerItemModel(Item itemBlock) {
        Baublelicious.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @Override
    public BaubleliciousBasicBlock setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
