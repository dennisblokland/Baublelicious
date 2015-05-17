package com.baublelicious;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class IconHelper {
  public static IIcon forItem(IIconRegister ir, Item item) {
    return forName(ir, item.getUnlocalizedName().replaceAll("item.", ""));
  }

  public static IIcon forName(IIconRegister ir, String name) {
    return ir.registerIcon(ModInfo.RESOURCE_LOCATION + ":" + name);
  }

  public static IIcon forBlock(IIconRegister ir, Block block) {
    return forName(ir, block.getUnlocalizedName().replaceAll("tile.", ""));
  }

  public static IIcon forBlock(IIconRegister ir, Block block, int i) {
    return forBlock(ir, block, Integer.toString(i));
  }

  public static IIcon forBlock(IIconRegister ir, Block block, int i, String dir) {
    return forBlock(ir, block);
  }

  public static IIcon forBlock(IIconRegister ir, Block block, String s) {
    return forName(ir, block.getUnlocalizedName().replaceAll("tile.", ""));
  }
}
