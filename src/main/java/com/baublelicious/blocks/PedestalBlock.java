package com.baublelicious.blocks;

import com.baublelicious.baublelicious;
import com.baublelicious.entity.TileentityPedestal;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;


public class PedestalBlock extends BlockContainer {

  public int rotation = 0;
  private String player;

  public PedestalBlock(int id) {
    super(Material.wood);
    this.setBlockName("PedestalBlock");
    this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9444444F, 1.0F);
    this.setCreativeTab(baublelicious.TabBaublelicious);
    setHardness(1.0F);
  }


  @Override
  public int getRenderType() {
    return -1;
  }

  @Override
  public boolean isOpaqueCube() {
    return false;
  }

  @Override
  public boolean renderAsNormalBlock() {
    return false;
  }

  @Override
  public boolean hasTileEntity() {
    return true;
  }

  @Override
  @SideOnly(Side.CLIENT)
  public void registerBlockIcons(IIconRegister iconRegister) {
    this.blockIcon = iconRegister.registerIcon("baublelicious:PedistalBlock");
  }


  @Override
  public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
    return new TileentityPedestal();
  }

  @Override
  public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
    int l = MathHelper.floor_double(entity.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

    if (l == 0) world.setBlockMetadataWithNotify(x, y, z, 2, 2);
    else if (l == 1) world.setBlockMetadataWithNotify(x, y, z, 3, 2);
    else if (l == 2) world.setBlockMetadataWithNotify(x, y, z, 0, 2);
    else if (l == 3) world.setBlockMetadataWithNotify(x, y, z, 1, 2);
  }

  @Override
  public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
    int meta = world.getBlockMetadata(x, y, z);
    System.out.print(meta);
    TileEntity tileEntity = world.getTileEntity(x, y, z);
    if (tileEntity == null || player.isSneaking()) {
      return false;
    }
    //code to open gui explained later
    player.openGui(baublelicious.instance, 0, world, x, y, z);
    return true;
  }


  @Override
  public void breakBlock(World world, int x, int y, int z, Block block, int par6) {
    dropItems(world, x, y, z);
    super.breakBlock(world, x, y, z, block, par6);
  }

  private void dropItems(World world, int x, int y, int z) {
    Random rand = new Random();

    TileEntity tileEntity = world.getTileEntity(x, y, z);
    if (!(tileEntity instanceof IInventory)) {
      return;
    }
    IInventory inventory = (IInventory) tileEntity;

    for (int i = 0; i < inventory.getSizeInventory(); i++) {
      ItemStack item = inventory.getStackInSlot(i);

      if (item != null && item.stackSize > 0) {
        float rx = rand.nextFloat() * 0.8F + 0.1F;
        float ry = rand.nextFloat() * 0.8F + 0.1F;
        float rz = rand.nextFloat() * 0.8F + 0.1F;

        EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z + rz, new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));

        if (item.hasTagCompound()) {
          entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
        }

        float factor = 0.05F;
        entityItem.motionX = rand.nextGaussian() * factor;
        entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
        entityItem.motionZ = rand.nextGaussian() * factor;
        world.spawnEntityInWorld(entityItem);
        item.stackSize = 0;
      }
    }
  }


}
