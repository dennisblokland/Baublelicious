package com.baublelicious.entity;

import baubles.api.IBauble;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.Constants;

import java.util.*;


public class TileentityPedestal extends TileEntity implements IInventory {


  public EntityItem itemEnt = null;
  ;
  public UUID owner = new UUID(0, 0);
  public int rotation = 0;
  private ItemStack[] contents = new ItemStack[getSizeInventory()];


  public TileentityPedestal() {


  }

  @Override
  public int getSizeInventory() {
    return 2;
  }

  @Override
  public ItemStack getStackInSlot(int i) {

    return contents[i];
  }

  @Override
  public void updateEntity() {
    super.updateEntity();

    this.baublesUpdate();


  }


  private void baublesUpdate() {
    TileEntity te = this;
    TileentityPedestal tileAltar = (TileentityPedestal) te;

    ItemStack baubles = tileAltar.getStackInSlot(0);

    AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox(this.xCoord - 25, this.yCoord - 25, this.zCoord - 25, this.xCoord + 25, this.yCoord + 25, this.zCoord + 25);
    axisalignedbb.maxY = this.worldObj.getHeight();
    List list = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);
    Iterator iterator = list.iterator();
    EntityPlayer entityplayer;
    //System.out.println("list" + list);


    ItemStack gem = tileAltar.getStackInSlot(1);
    if (gem != null) {

      while (iterator.hasNext()) {


        String name = gem.getTagCompound().getString("name");

        entityplayer = (EntityPlayer) iterator.next();
        String PLayerName = entityplayer.getDisplayName();
        Set<String> playersInArea = new HashSet<String>();
        playersInArea.add(PLayerName);
        System.out.println("playersInArea" + playersInArea);
        if (baubles != null && baubles.getItem() instanceof IBauble) {
          if (entityplayer.getDisplayName().equals(name)) {
            ((IBauble) baubles.getItem()).onWornTick(baubles, entityplayer);


          }
        }
      }
    }
  }


  @Override
  public ItemStack decrStackSize(int i, int j) {
    if (this.contents[i] != null) {
      ItemStack itemstack;

      if (this.contents[i].stackSize <= j) {
        itemstack = this.contents[i];
        this.contents[i] = null;
        this.markDirty();
        return itemstack;
      } else {
        itemstack = this.contents[i].splitStack(j);

        if (this.contents[i].stackSize == 0) {
          this.contents[i] = null;
        }

        this.markDirty();
        return itemstack;
      }
    } else {
      return null;
    }
  }

  @Override
  public ItemStack getStackInSlotOnClosing(int i) {
    if (this.contents[i] != null) {
      ItemStack itemstack = this.contents[i];
      this.contents[i] = null;
      return itemstack;
    } else {
      return null;
    }
  }

  @Override
  public void setInventorySlotContents(int i, ItemStack itemstack) {
    this.contents[i] = itemstack;

    if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
      itemstack.stackSize = this.getInventoryStackLimit();
    }

    this.markDirty();
  }

  @Override
  public String getInventoryName() {
    return "Pedestal";
  }

  @Override
  public boolean hasCustomInventoryName() {
    return false;
  }

  @Override
  public int getInventoryStackLimit() {
    return 2;
  }

  @Override
  public boolean isUseableByPlayer(EntityPlayer entityplayer) {
    return true;
  }

  @Override
  public void openInventory() {

  }

  @Override
  public void closeInventory() {

  }

  @Override
  public boolean isItemValidForSlot(int i, ItemStack itemstack) {
    return itemstack != null && itemstack.getItem() instanceof IBauble;

  }

  @Override
  public void readFromNBT(NBTTagCompound nbttagcompound) {
    super.readFromNBT(nbttagcompound);
    NBTTagList nbttaglist = nbttagcompound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
    contents = new ItemStack[getSizeInventory()];
    for (int i = 0; i < nbttaglist.tagCount(); i++) {
      NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
      int j = nbttagcompound1.getByte("Slot") & 0xff;
      if (j >= 0 && j < contents.length) {
        contents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
      }
    }

  }

  @Override
  public void writeToNBT(NBTTagCompound nbttagcompound) {
    super.writeToNBT(nbttagcompound);
    NBTTagList nbttaglist = new NBTTagList();
    for (int i = 0; i < contents.length; i++) {
      if (contents[i] != null) {
        NBTTagCompound nbttagcompound1 = new NBTTagCompound();
        nbttagcompound1.setByte("Slot", (byte) i);
        contents[i].writeToNBT(nbttagcompound1);
        nbttaglist.appendTag(nbttagcompound1);
      }
    }

    nbttagcompound.setTag("Items", nbttaglist);

  }


  public String getModelTexture() {
    return "baublelicious:textures/blocks/pedestal.png";
  }

  @Override
  //Used to be onInventoryChanged
  public void markDirty() {
    super.markDirty();
    if (worldObj != null && contents[0] != null) {
      itemEnt = new EntityItem(this.worldObj, this.xCoord, this.yCoord, this.zCoord, contents[0]);
      itemEnt.hoverStart = 0;
      itemEnt.rotationYaw = 0;
      itemEnt.motionX = 0;
      itemEnt.motionY = 0;
      itemEnt.motionZ = 0;
    } else {
      itemEnt = null;
    }
  }

  @Override
  public Packet getDescriptionPacket() {
    NBTTagCompound nbtTag = new NBTTagCompound();
    this.writeToNBT(nbtTag);
    return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
  }


}

