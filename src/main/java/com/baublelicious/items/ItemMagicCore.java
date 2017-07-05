package com.baublelicious.items;

import com.baublelicious.Baublelicious;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.util.NonNullList;


import java.util.List;

public class ItemMagicCore extends BaubleliciousBasicItem {
    public static String[] en_USNames = { "tier1", "tier2", "tier3" };


    public ItemMagicCore() {
        super();
        this.setHasSubtypes(true);
        this.setCreativeTab(Baublelicious.BaubleliciousTab);
        this.setUnlocalizedName("ItemMagicCore");

    }
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item par1, CreativeTabs par2CreativeTab, NonNullList<ItemStack> par3NonNullList) {
        for (int counter = 0; counter <= 2; ++counter) {
            par3NonNullList.add(new ItemStack(this, 1, counter));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "." + en_USNames[itemstack.getItemDamage()];
    }
    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }


    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add(en_USNames[par1ItemStack.getItemDamage()].replaceAll("tier", "Tier "));
    }

}
