package com.baublelicious.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotValid extends Slot {
  public SlotValid(IInventory inventory, int id, int x, int y) {
    super(inventory, id, x, y);
  }

  @Override
  public boolean isItemValid(ItemStack stack) {
    return inventory.isItemValidForSlot(getSlotIndex(), stack);
  }
}
