package com.baublelicious.recipes;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import com.baublelicious.helpers.NBTHelper;
import com.baublelicious.items.BaubleliciousItems;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class RecipeEntangledBauble implements IRecipe {
  public ItemStack entangledStack;
  public BaubleType baubleType;

  public RecipeEntangledBauble(ItemStack entangledStack, BaubleType type) {
    this.entangledStack = entangledStack;
    this.baubleType = type;
  }

  @Override
  public boolean matches(InventoryCrafting inventory, World world) {
    boolean foundEntangledBauble = false;
    boolean foundBauble = false;
    for (int i = 0; i < inventory.getSizeInventory(); i++) {
      ItemStack stack = inventory.getStackInSlot(i);
      if (stack != null) {
        if (entangledStack.getItem() == stack.getItem()) {
          if (foundEntangledBauble) {
            return false;
          }
          foundEntangledBauble = true;
        } else if (stack.getItem() instanceof IBauble) {
          if (((IBauble) stack.getItem()).getBaubleType(stack) == baubleType) {
            if (foundBauble) {
              return false;
            }
            foundBauble = true;
          } else {
            return false;
          }
        } else {
          return false;
        }
      }
    }
    return foundBauble && foundEntangledBauble;
  }

  @Override
  public ItemStack getCraftingResult(InventoryCrafting inventory) {
    boolean foundEntangledBauble = false;
    boolean foundBauble = false;
    ItemStack result = null;
    ItemStack bauble = null;
    for (int i = 0; i < inventory.getSizeInventory(); i++) {
      ItemStack stack = inventory.getStackInSlot(i);
      if (stack != null) {
        if (entangledStack.getItem() == stack.getItem()) {
          if (foundEntangledBauble) {
            return null;
          }
          foundEntangledBauble = true;
          result = stack.copy();
        } else if (stack.getItem() instanceof IBauble) {
          if (((IBauble) stack.getItem()).getBaubleType(stack) == baubleType) {
            if (foundBauble) {
              return null;
            }
            foundBauble = true;
            bauble = stack.copy();
          } else {
            return null;
          }
        } else {
          return null;
        }
      }
    }

    if (!foundBauble || !foundEntangledBauble) {
      return null;
    }

    NBTTagCompound compound = NBTHelper.getItemStackCompound(result);

    NBTTagList itemsList = compound.getTagList("EntangledBaubles", Constants.NBT.TAG_COMPOUND);
    NBTTagCompound itemTag = new NBTTagCompound();
    bauble.writeToNBT(itemTag);
    itemsList.appendTag(itemTag);
    compound.setTag("EntangledBaubles", itemsList);
    return result;
  }

  @Override
  public int getRecipeSize() {
    return 2;
  }

  @Override
  public ItemStack getRecipeOutput() {
    return new ItemStack(BaubleliciousItems.entangledBelt);
  }
}
