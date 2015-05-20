package com.baublelicious.items;

import baubles.api.IBauble;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import com.baublelicious.Baublelicious;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

// TODO: Move all baubles over to this class
public abstract class ItemBauble extends Item implements IBauble {
  public ItemBauble(String key) {
    setUnlocalizedName(key);
    setTextureName(key);
    setCreativeTab(Baublelicious.tabBaublelicious);
    setMaxStackSize(1);
  }

  @Override
  public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
    InventoryBaubles baubles = PlayerHandler.getPlayerBaubles(player);
    for (int i = 0; i < baubles.getSizeInventory(); i++) {
      if (baubles.isItemValidForSlot(i, stack)) {
        ItemStack stackInSlot = baubles.getStackInSlot(i);
        if (stackInSlot == null || ((IBauble) stackInSlot.getItem()).canUnequip(stackInSlot, player)) {
          if (!world.isRemote) {
            baubles.setInventorySlotContents(i, stack.copy());
            if (!player.capabilities.isCreativeMode)
              player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
          }

          onEquipped(stack, player);

          if (stackInSlot != null) {
            ((IBauble) stackInSlot.getItem()).onUnequipped(stackInSlot, player);
            return stackInSlot.copy();
          }
          break;
        }
      }
    }

    return stack;
  }

  @Override
  public void onWornTick(ItemStack itemStack, EntityLivingBase entityLivingBase) {

  }

  @Override
  public void onEquipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {

  }

  @Override
  public void onUnequipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {

  }

  @Override
  public boolean canEquip(ItemStack itemStack, EntityLivingBase entityLivingBase) {
    return true;
  }

  @Override
  public boolean canUnequip(ItemStack itemStack, EntityLivingBase entityLivingBase) {
    return true;
  }
}
