package com.baublelicious.blocks;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TileentityPedistalEntity extends TileEntity implements IInventory {

        private ItemStack[] inv;
		public EntityItem itemEnt = null;
		public ItemStack object;
		private boolean hasObject;
		
		 
		    
        public TileentityPedistalEntity(){
                inv = new ItemStack[9];
                this.hasObject = false;
                this.object = new ItemStack(Item.getItemById(0), 0, 0);
        }
        
        @Override
        public int getSizeInventory() {
                return inv.length;
        }
        @Override
        public ItemStack getStackInSlot(int slot)
        {
            return inv[slot];
        }
        @Override
        public void setInventorySlotContents(int slot, ItemStack stack) {
                inv[slot] = stack;
                if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                        stack.stackSize = getInventoryStackLimit();
                }               
        }

        @Override
        public ItemStack decrStackSize(int slot, int amt) {
                ItemStack stack = getStackInSlot(slot);
                if (stack != null) {
                        if (stack.stackSize <= amt) {
                                setInventorySlotContents(slot, null);
                        } else {
                                stack = stack.splitStack(amt);
                                if (stack.stackSize == 0) {
                                        setInventorySlotContents(slot, null);
                                }
                        }
                }
                return stack;
        }

        @Override
        public ItemStack getStackInSlotOnClosing(int slot) {
                ItemStack stack = getStackInSlot(slot);
                if (stack != null) {
                        setInventorySlotContents(slot, null);
                }
                return stack;
        }
        
        @Override
        public int getInventoryStackLimit() {
                return 64;
        }

        @Override
        public boolean isUseableByPlayer(EntityPlayer player) {
                return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this &&
                player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
        }

   
        
        @Override
        public void readFromNBT(NBTTagCompound nbttagcompound)
        {
            super.readFromNBT(nbttagcompound);
            NBTTagList nbttaglist = nbttagcompound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
            inv = new ItemStack[getSizeInventory()];
            for (int i = 0; i < nbttaglist.tagCount(); i++)
            {
                NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
                int j = nbttagcompound1.getByte("Slot") & 0xff;
                if (j >= 0 && j < inv.length)
                {
                    inv[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
                }
            }
           
        }
        @Override
        public void writeToNBT(NBTTagCompound tagCompound) {
                super.writeToNBT(tagCompound);
                                
                NBTTagList itemList = new NBTTagList();
                for (int i = 0; i < inv.length; i++) {
                        ItemStack stack = inv[i];
                        if (stack != null) {
                                NBTTagCompound tag = new NBTTagCompound();
                                tag.setByte("Slot", (byte) i);
                                stack.writeToNBT(tag);
                                itemList.appendTag(tag);
                        }
                }
                tagCompound.setTag("Inventory", itemList);
        }

                

				@Override
				public String getInventoryName() {
					// TODO Auto-generated method stub
					return "test";
				}

				@Override
				public boolean hasCustomInventoryName() {
					// TODO Auto-generated method stub
					return true;
				}

				@Override
				public void openInventory() {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void closeInventory() {
					// TODO Auto-generated method stub
					
				}

				@Override
				public boolean isItemValidForSlot(int p_94041_1_,
						ItemStack p_94041_2_) {
					// TODO Auto-generated method stub
					return true;
				}
}