package com.baublelicious;


import com.baublelicious.items.BaubleliciousItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;



public class BaubleliciousTab extends CreativeTabs{

    public BaubleliciousTab(int par1, String par2Str) {
        super(par1, par2Str);

    }

    @Override

    public ItemStack getTabIconItem(){
// Here you make the Icon of the creative Tab
        return new ItemStack(BaubleliciousItems.ItemGrowthPendant, 1, 0);
    }

}
