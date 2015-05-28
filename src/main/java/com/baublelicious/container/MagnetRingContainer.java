package com.baublelicious.container;

import com.baublelicious.helpers.NBTHelper;
import com.baublelicious.items.BaubleliciousItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class MagnetRingContainer extends Container {
  public FakeInventory fakeInventory = new FakeInventory(1);
  public int heldItem;
  public InventoryPlayer inventoryPlayer;

  public MagnetRingContainer(int heldItem, InventoryPlayer inventoryPlayer) {
    this.heldItem = heldItem;
    this.inventoryPlayer = inventoryPlayer;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 9; j++) {
        addSlotToContainer(new SlotNoMagnetRing(heldItem, inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 30 + i * 18));
      }
    }

    for (int i = 0; i < 9; i++) {
      if (i == heldItem) {
        addSlotToContainer(new SlotMagnetRing(heldItem, inventoryPlayer, i, 8 + i * 18, 88));
      } else {
        addSlotToContainer(new SlotNoMagnetRing(heldItem, inventoryPlayer, i, 8 + i * 18, 88));
      }
    }

    addSlotToContainer(new Slot(fakeInventory, 0, 8, 8));
  }

  @Override
  public boolean canInteractWith(EntityPlayer player) {
    return true;
  }

  @Override
  public void onContainerClosed(EntityPlayer player) {
    if (!player.getEntityWorld().isRemote && fakeInventory.getStackInSlot(0) != null) {
      player.dropPlayerItemWithRandomChoice(fakeInventory.getStackInSlotOnClosing(0), false);
    }
    super.onContainerClosed(player);
  }

  @Override
  public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
    return null;
  }

  public void addToBlacklist(byte compareType) {
    ItemStack ring = inventoryPlayer.getStackInSlot(heldItem);
    if (ring != null && ring.isItemEqual(new ItemStack(BaubleliciousItems.magnetRing))) {
      NBTTagCompound compound = NBTHelper.getItemStackCompound(ring);
      if (compareType == -1) {
        compound.setTag("MagnetBlacklist", new NBTTagList());
      } else {
        if (fakeInventory.getStackInSlot(0) != null) {
          NBTTagList blacklist = compound.getTagList("MagnetBlacklist", Constants.NBT.TAG_COMPOUND);
          NBTTagCompound itemTag = new NBTTagCompound();
          itemTag.setByte("CompareType", compareType);
          fakeInventory.getStackInSlot(0).writeToNBT(itemTag);
          blacklist.appendTag(itemTag);
          compound.setTag("MagnetBlacklist", blacklist);
        }
      }
    }
  }
}
