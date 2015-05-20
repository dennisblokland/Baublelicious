package com.baublelicious.items;

import baubles.api.IBauble;
import com.baublelicious.helpers.NBTHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

import java.util.ArrayList;
import java.util.List;

public abstract class ItemEntangledBauble extends ItemBauble {
  public ItemEntangledBauble(String key) {
    super(key);
  }

  @Override
  public void onWornTick(ItemStack stack, EntityLivingBase player) {
    for (ItemStack bauble : getBaublesFromStack(stack)) {
      ((IBauble) bauble.getItem()).onWornTick(bauble, player);
    }
  }

  @Override
  public void onEquipped(ItemStack stack, EntityLivingBase player) {
    for (ItemStack bauble : getBaublesFromStack(stack)) {
      ((IBauble) bauble.getItem()).onEquipped(bauble, player);
    }
  }

  @Override
  public void onUnequipped(ItemStack stack, EntityLivingBase player) {
    for (ItemStack bauble : getBaublesFromStack(stack)) {
      ((IBauble) bauble.getItem()).onUnequipped(bauble, player);
    }
  }

  @SuppressWarnings("unchecked")
  public void addInformationForBaubles(String empty, ItemStack stack, List lines) {
    List<ItemStack> baubles = getBaublesFromStack(stack);
    if (baubles.size() == 0) {
      lines.add(empty);
    } else {
      for (ItemStack bauble : baubles) {
        lines.add(bauble.getDisplayName());
      }
    }
  }

  @Override
  public boolean hasEffect(ItemStack stack, int pass) {
    return pass == 0 && getBaublesFromStack(stack).size() > 0;
  }


  public static List<ItemStack> getBaublesFromStack(ItemStack stack) {
    List<ItemStack> baubles = new ArrayList<>();
    NBTTagCompound compound = NBTHelper.getItemStackCompound(stack);
    if (compound.hasKey("EntangledBaubles")) {
      NBTTagList baublesList = compound.getTagList("EntangledBaubles", Constants.NBT.TAG_COMPOUND);
      for (int i = 0; i < baublesList.tagCount(); i++) {
        NBTTagCompound itemTag = baublesList.getCompoundTagAt(i);
        baubles.add(ItemStack.loadItemStackFromNBT(itemTag));
      }
    }
    return baubles;
  }

  public static boolean containsBauble(ItemStack stack, IBauble bauble) {
    NBTTagCompound compound = NBTHelper.getItemStackCompound(stack);
    if (compound.hasKey("EntangledBaubles")) {
      NBTTagList baublesList = compound.getTagList("EntangledBaubles", Constants.NBT.TAG_COMPOUND);
      for (int i = 0; i < baublesList.tagCount(); i++) {
        NBTTagCompound itemTag = baublesList.getCompoundTagAt(i);
        if (ItemStack.loadItemStackFromNBT(itemTag).getItem() == bauble) {
          return true;
        }
      }
    }

    return false;
  }
}
