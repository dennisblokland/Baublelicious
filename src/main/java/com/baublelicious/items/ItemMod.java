package com.baublelicious.items;

import com.baublelicious.Baublelicious;
import com.baublelicious.IconHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemMod extends Item {
  public ItemMod() {
    setCreativeTab(Baublelicious.tabBaublelicious);
  }

  @Override
  public Item setUnlocalizedName(String par1Str) {
    GameRegistry.registerItem(this, par1Str);
    return super.setUnlocalizedName(par1Str);
  }

  @Override
  @SideOnly(Side.CLIENT)
  public void registerIcons(IIconRegister par1IconRegister) {
    itemIcon = IconHelper.forItem(par1IconRegister, this);
  }
}

