package com.baublelicious.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotNoMagnetRing extends Slot {
  public int heldItemId;

  public SlotNoMagnetRing(int heldItemId, IInventory inventory, int slotId, int x, int y) {
    super(inventory, slotId, x, y);
    this.heldItemId = heldItemId;
  }

  @Override
  public boolean isItemValid(ItemStack stack) {
    ItemStack magnetStack = inventory.getStackInSlot(heldItemId);
    return stack != magnetStack;
  }
}
