package com.baublelicious.items;

import com.baublelicious.baublelicious;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemMagicCore extends Item {
  public static String[] en_USNames = { "tier1", "tier2", "tier3" };
  @SideOnly(Side.CLIENT)
  private IIcon[] icons;

  public ItemMagicCore() {
    super();
    this.setHasSubtypes(true);
    this.setCreativeTab(baublelicious.TabBaublelicious);
    this.setUnlocalizedName("ItemMagicCore");
  }

  @SideOnly(Side.CLIENT)
  @Override
  public void registerIcons(IIconRegister par1IconRegister) {
    icons = new IIcon[3];

    for (int i = 0; i < icons.length; i++) {
      icons[i] = par1IconRegister.registerIcon(baublelicious.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
    }
  }

  @Override
  public void getSubItems(Item item, CreativeTabs tabs, List itemList) {
    for (int counter = 0; counter <= 2; ++counter) {
      itemList.add(new ItemStack(item, 1, counter));
    }
  }

  @Override
  public String getUnlocalizedName(ItemStack itemstack) {
    return getUnlocalizedName() + "." + en_USNames[itemstack.getItemDamage()];
  }


  @Override
  public IIcon getIconFromDamage(int par1) {
    return icons[par1];
  }

  @Override
  public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    par3List.add(en_USNames[par1ItemStack.getItemDamage()].replaceAll("tier", "Tier "));
  }


}

	



