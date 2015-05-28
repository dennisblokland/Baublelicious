package com.baublelicious.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotMagnetRing extends Slot {
  public int heldItemId;

  public SlotMagnetRing(int heldItemId, IInventory inventory, int slotId, int x, int y) {
    super(inventory, slotId, x, y);
    this.heldItemId = heldItemId;
  }

  @Override
  public boolean isItemValid(ItemStack stack) {
    ItemStack magnetStack = inventory.getStackInSlot(heldItemId);
    return stack == magnetStack;
  }

  @Override
  public boolean canTakeStack(EntityPlayer p_82869_1_) {
    return false;
  }

  @Override
  public boolean func_111238_b() {
    return false;
  }

  @Override
  public ItemStack decrStackSize(int slot) {
    return getStack();
  }
}
