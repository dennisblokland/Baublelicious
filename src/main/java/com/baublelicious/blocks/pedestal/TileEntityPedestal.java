package com.baublelicious.blocks.pedestal;

import baubles.api.IBauble;
import com.baublelicious.Baublelicious;
import com.baublelicious.helpers.NBTHelper;
import com.baublelicious.helpers.PlayerHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.lang.ref.WeakReference;

public class TileEntityPedestal extends TileEntity implements ITickable , IInventory{
    private static final int RANGE = 32;
    private ItemStack[] contents = new ItemStack[getSizeInventory()];
    public WeakReference<EntityPlayer> cachedPlayer = new WeakReference<>(null);
    public ItemStack cachedBauble = null;

    public ItemStackHandler inventory = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            if (!world.isRemote) {
                lastChangeTime = world.getTotalWorldTime();
                // Baublelicious.network.sendToAllAround(new PacketUpdatePedestal(TileEntityPedestal.this), new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 64));
            }
        }
    };
    public boolean isActive = false;

    public long lastChangeTime;
    @Override
    public int getSizeInventory() {
        return 2;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return contents[i];
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return null;
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        this.contents[index] = stack;
        this.markDirty();
    }

    @Override
    public int getInventoryStackLimit() {
        return 0;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return false;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return false;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 2;
    }

    @Override
    public void clear() {

    }

    @Override
    public void update() {
        if (this.hasWorld()) baublesUpdate();
    }
    private void activateBauble(ItemStack bauble, EntityPlayer player) {
        isActive = true;
        cachedBauble = bauble.copy();
        cachedPlayer = new WeakReference<>(player);
        ((IBauble) bauble.getItem()).onEquipped(bauble, player);
    }

    private void deactivateBauble(EntityPlayer player) {
        isActive = false;
        cachedPlayer = new WeakReference<>(null);
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
    @SuppressWarnings("unchecked")
    private void baublesUpdate() {
        int xCoord = this.pos.getX();
        int yCoord = this.pos.getY();
        int zCoord = this.pos.getZ();
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
    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(getPos(), getPos().add(1, 2, 1));
    }

    @Override
    public void onLoad() {
        if (world.isRemote) {
            //TutorialMod.network.sendToServer(new PacketRequestUpdatePedestal(this));
        }
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
                contents[j] = new ItemStack(itemTag);
            }
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {

        writeItemsToNBT(compound);
        return super.writeToNBT(compound);
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
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) || super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T)inventory : super.getCapability(capability, facing);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }
}
