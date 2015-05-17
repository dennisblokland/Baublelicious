package com.baublelicious.blocks;

import com.baublelicious.Baublelicious;
import com.baublelicious.ModInfo;
import com.baublelicious.tiles.TilePedestal;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;


public class PedestalBlock extends BlockContainer {
  public PedestalBlock(String key) {
    super(Material.wood);
    setBlockName(key);
    setBlockTextureName(ModInfo.RESOURCE_LOCATION  + ":" + key);
    setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9444444F, 1.0F);
    setCreativeTab(Baublelicious.TabBaublelicious);
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
  public TileEntity createNewTileEntity(World world, int meta) {
    return new TilePedestal();
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
    TileEntity tileEntity = world.getTileEntity(x, y, z);
    if (!player.isSneaking() && tileEntity instanceof TilePedestal) {
      FMLNetworkHandler.openGui(player, Baublelicious.instance, 0, world, x, y, z);
      return true;
    }
    return false;
  }

  @Override
  public void breakBlock(World world, int x, int y, int z, Block block, int par6) {
    dropItems(world, x, y, z);
    super.breakBlock(world, x, y, z, block, par6);
  }

  private void dropItems(World world, int x, int y, int z) {
    Random rand = new Random();

    TileEntity tileEntity = world.getTileEntity(x, y, z);
    if (tileEntity instanceof IInventory) {
      IInventory inventory = (IInventory) tileEntity;

      for (int i = 0; i < inventory.getSizeInventory(); i++) {
        ItemStack item = inventory.getStackInSlot(i);

        if (item != null && item.stackSize > 0) {
          float rx = rand.nextFloat() * 0.8F + 0.1F;
          float ry = rand.nextFloat() * 0.8F + 0.1F;
          float rz = rand.nextFloat() * 0.8F + 0.1F;

          EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z + rz, item.copy());

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
}
