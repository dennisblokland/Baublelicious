package com.baublelicious.blocks;

import com.baublelicious.baublelicious;
import com.baublelicious.iconhelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockMod extends Block {

  public BlockMod(Material par2Material) {
    super(par2Material);
    if (registerInCreative()) setCreativeTab(baublelicious.TabBaublelicious);
  }

  @Override
  public Block setBlockName(String par1Str) {
    if (shouldRegisterInNameSet()) GameRegistry.registerBlock(this, par1Str);
    return super.setBlockName(par1Str);
  }

  protected boolean shouldRegisterInNameSet() {
    return true;
  }

  @Override
  @SideOnly(Side.CLIENT)
  public void registerBlockIcons(IIconRegister par1IconRegister) {
    blockIcon = iconhelper.forBlock(par1IconRegister, this);
  }

  boolean registerInCreative() {
    return true;
  }
}