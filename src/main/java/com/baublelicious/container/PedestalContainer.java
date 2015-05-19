package com.baublelicious.container;

import com.baublelicious.tiles.TilePedestal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class PedestalContainer extends Container {
  public TilePedestal pedestal;

  public PedestalContainer(InventoryPlayer inventoryPlayer, TilePedestal te) {
    pedestal = te;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 9; j++) {
        addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
      }
    }

    for (int i = 0; i < 9; i++) {
      addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
    }

    addSlotToContainer(new SlotValid(pedestal, 0, 80, 18));
    addSlotToContainer(new SlotValid(pedestal, 1, 80, 52));
  }

  @Override
  public boolean canInteractWith(EntityPlayer player) {
    return pedestal.isUseableByPlayer(player);
  }

  @Override
  public ItemStack transferStackInSlot(EntityPlayer player, int i) {
    Slot slot = getSlot(i);
    if (slot != null && slot.getHasStack()) {
      ItemStack stack = slot.getStack();
      ItemStack result = stack.copy();
      if (i >= 36) {
        if (!mergeItemStack(stack, 0, 36, false)) return null;
      } else {
        if (pedestal.isItemValidForSlot(0, stack)) {
          if (!mergeItemStack(stack, 36, 37, false)) return null;
        } else if (pedestal.isItemValidForSlot(1, stack)) {
          if (!mergeItemStack(stack, 37, 38, false)) return null;
        } else {
          return null;
        }
      }
      if (stack.stackSize == 0) slot.putStack(null);
      else slot.onSlotChanged();
      slot.onPickupFromSlot(player, stack);
      return result;
    }
    return null;
  }
}
      

    