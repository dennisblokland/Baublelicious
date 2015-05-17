package com.baublelicious.items;

import com.baublelicious.Baublelicious;
import com.baublelicious.helpers.NBTHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemBindingGem extends Item {
  public ItemBindingGem(String key) {
    setUnlocalizedName(key);
    setTextureName(key);
    setCreativeTab(Baublelicious.tabBaublelicious);
    setMaxStackSize(1);
  }

  @Override
  public boolean hasEffect(ItemStack stack, int pass) {
    return pass == 0 && NBTHelper.getItemStackCompound(stack).hasKey("PlayerUUID");
  }

  @Override
  public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
    NBTTagCompound itemCompound = NBTHelper.getItemStackCompound(stack);
    if (player.isSneaking()) {
      if (itemCompound.hasKey("PlayerUUID")) {
        itemCompound.removeTag("PlayerUsername");
        itemCompound.removeTag("PlayerUUID");
        player.worldObj.playSoundAtEntity(player, "random.successful_hit", 1, 0.2f);
      }
    } else {
      if (!itemCompound.hasKey("PlayerUUID")) {
        itemCompound.setString("PlayerUsername", player.getDisplayName());
        itemCompound.setString("PlayerUUID", player.getUniqueID().toString());
        player.worldObj.playSoundAtEntity(player, "random.successful_hit", 1, 1);
      }
    }
    return stack;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean bool) {
    NBTTagCompound itemCompound = NBTHelper.getItemStackCompound(stack);
    if (itemCompound.hasKey("PlayerUUID")) {
      lines.add("Bound to " + EnumChatFormatting.GREEN + itemCompound.getString("PlayerUsername"));
      lines.add("Sneak Right Click to Unbind");
    } else {
      lines.add("Right Click to Bind");
    }
  }
}
