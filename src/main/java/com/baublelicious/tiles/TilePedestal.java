package com.baublelicious.tiles;

import baubles.api.IBauble;
import com.baublelicious.helpers.NBTHelper;
import com.baublelicious.helpers.PlayerHelper;
import com.baublelicious.items.BaubleliciousItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

import java.lang.ref.WeakReference;

public class TilePedestal extends TileEntity implements IInventory {
  private static final int RANGE = 32;

  public EntityItem itemEntity = null;
  public ItemStack cachedBauble = null;
  public boolean isActive = false;
  public WeakReference<EntityPlayer> cachedPlayer = new WeakReference<>(null);
  private ItemStack[] contents = new ItemStack[getSizeInventory()];

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
    if (hasWorldObj()) baublesUpdate();
  }

  @SuppressWarnings("unchecked")
  private void baublesUpdate() {
    if (isActive) {
      EntityPlayer player = cachedPlayer.get();
      if (player != null) {
        ItemStack bauble = getStackInSlot(0);
        if (bauble != null && bauble.isItemEqual(cachedBauble)) {
          if (getUUIDFromGem().equals(player.getUniqueID().toString())) {
            Item baubleItem = bauble.getItem();
            if (baubleItem instanceof IBauble) {
              if (PlayerHelper.isWithinRangeOf(player, xCoord, yCoord, zCoord, RANGE)) {
                if (!PlayerHelper.isWearingBauble(player, (IBauble) cachedBauble.getItem()))
                  ((IBauble) bauble.getItem()).onWornTick(bauble, player);
              } else {
                if (!PlayerHelper.isWearingBauble(player, (IBauble) cachedBauble.getItem())) deactivateBauble(player);
              }
            }
          } else {
            if (!PlayerHelper.isWearingBauble(player, (IBauble) cachedBauble.getItem())) deactivateBauble(player);
          }
        } else {
          if (!PlayerHelper.isWearingBauble(player, (IBauble) cachedBauble.getItem())) deactivateBauble(player);
        }
      } else {
        isActive = false;
        cachedPlayer = null;
        cachedBauble = null;
      }
    } else {
      ItemStack bauble = getStackInSlot(0);
      if (bauble != null) {
        Item baubleItem = bauble.getItem();
        if (baubleItem instanceof IBauble) {
          EntityPlayer player = PlayerHelper.getPlayerFromUUID(getUUIDFromGem());
          if (player != null && PlayerHelper.isWithinRangeOf(player, xCoord, yCoord, zCoord, RANGE)) {
            if (!PlayerHelper.isWearingBauble(player, (IBauble) baubleItem)) activateBauble(bauble, player);
          }
        }
      }
    }

  }

  private void activateBauble(ItemStack bauble, EntityPlayer player) {
    isActive = true;
    cachedBauble = bauble.copy();
    cachedPlayer = new WeakReference<>(player);
    ((IBauble) bauble.getItem()).onEquipped(bauble, player);
  }

  private void deactivateBauble(EntityPlayer player) {
    isActive = false;
    cachedPlayer = null;
    ((IBauble) cachedBauble.getItem()).onUnequipped(cachedBauble, player);
    cachedBauble = null;
  }

  public String getUUIDFromGem() {
    ItemStack gem = getStackInSlot(1);
    if (gem != null) {
      NBTTagCompound gemCompound = NBTHelper.getItemStackCompound(gem);
      if (gemCompound.hasKey("PlayerUUID")) {
        return gemCompound.getString("PlayerUUID");
      }
    }
    return "";
  }

  public void onBlockBreak() {
    EntityPlayer player = cachedPlayer.get();
    if (player != null) {
      deactivateBauble(player);
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
  public boolean isItemValidForSlot(int slot, ItemStack stack) {
    switch (slot) {
      case 0:
        return stack != null && stack.getItem() instanceof IBauble;
      case 1:
        return stack != null && stack.getItem() == BaubleliciousItems.bindingGem;
    }

    return false;
  }

  @Override
  public void readFromNBT(NBTTagCompound compound) {
    super.readFromNBT(compound);
    readItemsFromNBT(compound);
  }

  public void readItemsFromNBT(NBTTagCompound compound) {
    NBTTagList itemsList = compound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
    contents = new ItemStack[getSizeInventory()];
    for (int i = 0; i < itemsList.tagCount(); i++) {
      NBTTagCompound itemTag = itemsList.getCompoundTagAt(i);
      int j = itemTag.getByte("Slot") & 0xff;
      if (j >= 0 && j < contents.length) {
        contents[j] = ItemStack.loadItemStackFromNBT(itemTag);
      }
    }
  }

  @Override
  public void writeToNBT(NBTTagCompound compound) {
    super.writeToNBT(compound);
    writeItemsToNBT(compound);
  }

  public void writeItemsToNBT(NBTTagCompound compound) {
    NBTTagList itemsList = new NBTTagList();
    for (int i = 0; i < contents.length; i++) {
      if (contents[i] != null) {
        NBTTagCompound itemTag = new NBTTagCompound();
        itemTag.setByte("Slot", (byte) i);
        contents[i].writeToNBT(itemTag);
        itemsList.appendTag(itemTag);
      }
    }
    compound.setTag("Items", itemsList);
  }

  @Override
  //Used to be onInventoryChanged
  public void markDirty() {
    super.markDirty();
    if (hasWorldObj() && worldObj.isRemote) {
      if (contents[0] != null) {
        itemEntity = new EntityItem(this.worldObj, this.xCoord, this.yCoord, this.zCoord, contents[0]);
        itemEntity.hoverStart = 0;
        itemEntity.rotationYaw = 0;
        itemEntity.motionX = 0;
        itemEntity.motionY = 0;
        itemEntity.motionZ = 0;
      } else {
        itemEntity = null;
      }
    }
  }

  @Override
  public Packet getDescriptionPacket() {
    NBTTagCompound compound = new NBTTagCompound();
    writeItemsToNBT(compound);
    return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, compound);
  }

  @Override
  public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
    readItemsFromNBT(packet.func_148857_g());
  }
}

