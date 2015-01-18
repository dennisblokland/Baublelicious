package com.baublelicious.container;

import com.baublelicious.entity.TileentityPedestal;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class PedestalContainer extends Container {

        protected TileentityPedestal tileEntity;

        public PedestalContainer (InventoryPlayer inventoryPlayer, TileentityPedestal te){
                tileEntity = te;

                //the Slot constructor takes the IInventory and the slot number in that it binds to
                //and the x-y coordinates it resides on-screen
                addSlotToContainer(new SlotBaubles(tileEntity, 0, 80, 35));
                        
                

                //commonly used vanilla code that adds the player's inventory
                bindPlayerInventory(inventoryPlayer);
        }

        @Override
        public boolean canInteractWith(EntityPlayer player) {
                return tileEntity.isUseableByPlayer(player);
        }


        protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
                for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 9; j++) {
                                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                                                8 + j * 18, 84 + i * 18));
                        }
                }

                for (int i = 0; i < 9; i++) {
                        addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
                }
        }
        @Override
        public ItemStack transferStackInSlot(EntityPlayer p, int i)
        {
            ItemStack itemstack = null;
            Slot slot = (Slot) inventorySlots.get(i);
            if (slot != null && slot.getHasStack())
            {
                ItemStack itemstack1 = slot.getStack();
                itemstack = itemstack1.copy();
                if (i < 1)
                {
                    if (!mergeItemStack(itemstack1, 1, inventorySlots.size(), true))
                    {
                        return null;
                    }
                }
              
                else if (!mergeItemStack(itemstack1, 0, 1, false))
                {
                    return null;
                }
                if (itemstack1.stackSize == 0)
                {
                    slot.putStack(null);
                }
                else
                {
                    slot.onSlotChanged();
                }
            }
            return itemstack;
        }

    	@Override
    	protected boolean mergeItemStack(ItemStack itemstack, int i, int j, boolean flag) {
    		// The default implementation in Slot doesn't take into account the Slot.isItemValid() and Slot.getSlotStackLimit() values.
    		// So here is a modified implementation. I have only modified the parts with a comment.

    		boolean flag1 = false;
    		int k = i;
    		if (flag) {
    			k = j - 1;
    		}
    		if (itemstack.isStackable()) {
    			while (itemstack.stackSize > 0 && (!flag && k < j || flag && k >= i)) {
    				Slot slot = (Slot)inventorySlots.get(k);
    				ItemStack itemstack1 = slot.getStack();

    				if (flag) {
    					k--;
    				}
    				else {
    					k++;
    				}

    				// Check if item is valid:
    				if (!slot.isItemValid(itemstack)) {
    					continue;
    				}

    				if (itemstack1 != null && itemstack1.getItem() == itemstack.getItem() && (!itemstack.getHasSubtypes() || itemstack.getItemDamage() == itemstack1.getItemDamage())
    						&& ItemStack.areItemStackTagsEqual(itemstack, itemstack1)) {
    					//ItemStack.areItemStacksEqual(par0ItemStack, par1ItemStack)
    					//ItemStack.areItemStackTagsEqual(par0ItemStack, par1ItemStack)
    					int i1 = itemstack1.stackSize + itemstack.stackSize;

    					// Don't put more items than the slot can take:
    					int maxItemsInDest = Math.min(itemstack1.getMaxStackSize(), slot.getSlotStackLimit());

    					if (i1 <= maxItemsInDest) {
    						itemstack.stackSize = 0;
    						itemstack1.stackSize = i1;
    						slot.onSlotChanged();
    						flag1 = true;
    					}
    					else if (itemstack1.stackSize < maxItemsInDest) {
    						itemstack.stackSize -= maxItemsInDest - itemstack1.stackSize;
    						itemstack1.stackSize = maxItemsInDest;
    						slot.onSlotChanged();
    						flag1 = true;
    					}
    				}

    			}
    		}
    		if (itemstack.stackSize > 0) {
    			int l;
    			if (flag) {
    				l = j - 1;
    			}
    			else {
    				l = i;
    			}
    			do {
    				if ((flag || l >= j) && (!flag || l < i)) {
    					break;
    				}
    				Slot slot1 = (Slot)inventorySlots.get(l);
    				ItemStack itemstack2 = slot1.getStack();

    				if (flag) {
    					l--;
    				}
    				else {
    					l++;
    				}

    				// Check if item is valid:
    				if (!slot1.isItemValid(itemstack)) {
    					continue;
    				}

    				if (itemstack2 == null) {

    					// Don't put more items than the slot can take:
    					int nbItemsInDest = Math.min(itemstack.stackSize, slot1.getSlotStackLimit());
    					ItemStack itemStack1 = itemstack.copy();
    					itemstack.stackSize -= nbItemsInDest;
    					itemStack1.stackSize = nbItemsInDest;

    					slot1.putStack(itemStack1);
    					slot1.onSlotChanged();
    					// itemstack.stackSize = 0;
    					flag1 = true;
    					break;
    				}
    			} while (true);
    		}
    		return flag1;
    	}
    }
      

    