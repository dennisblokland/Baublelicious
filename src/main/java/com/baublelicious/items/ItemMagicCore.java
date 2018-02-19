package com.baublelicious.items;

import com.baublelicious.Baublelicious;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.util.NonNullList;


import javax.annotation.Nullable;
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
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if(this.isInCreativeTab(tab)){
            for (int counter = 0; counter <= 2; ++counter) {
                items.add(new ItemStack(this, 1, counter));
            }
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

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add(en_USNames[stack.getItemDamage()].replaceAll("tier", "Tier "));
    }
}
