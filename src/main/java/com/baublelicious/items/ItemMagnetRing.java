package com.baublelicious.items;

import baubles.api.BaubleType;
import com.baublelicious.Baublelicious;
import com.baublelicious.config.Config;
import com.baublelicious.helpers.NBTHelper;
import com.baublelicious.helpers.Vector3d;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class ItemMagnetRing extends ItemBauble {
  public static final float RANGE = 10f;

  public ItemMagnetRing(String key) {
    super(key);
  }

  @Override
  public BaubleType getBaubleType(ItemStack arg0) {
    return BaubleType.RING;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void onWornTick(ItemStack bauble, EntityLivingBase entity) {
    EntityPlayer player = (EntityPlayer) entity;

    AxisAlignedBB bounds = player.boundingBox.expand(RANGE, RANGE, RANGE);

    List<EntityItem> itemEntities = player.worldObj.getEntitiesWithinAABB(EntityItem.class, bounds);
    List<EntityXPOrb> xpEntities = player.worldObj.getEntitiesWithinAABB(EntityXPOrb.class, bounds);

    for (EntityItem entityItem : itemEntities) {
      boolean ignore = false;
      ItemStack stack = entityItem.getEntityItem();
      List<ItemStack> blacklist = getBlacklist(bauble);
      List<Byte> compareTypes = getBlacklistCompareTypes(bauble);
      for (int i = 0; i < blacklist.size(); i++) {
        int compareType = compareTypes.get(i);
        ItemStack compareStack = blacklist.get(i);
        if (compareType == 0) {
          if (stack.getItem() == compareStack.getItem()) {
            ignore = true;
          }
        } else if (compareType == 1) {
          if (stack.isItemEqual(compareStack)) {
            ignore = true;
          }
        } else if (compareType == 2) {
          if (stack.getItem() == compareStack.getItem() && ItemStack.areItemStackTagsEqual(stack, compareStack)) {
            ignore = true;
          }
        } else if (compareType == 3) {
          if (stack.isItemEqual(compareStack) && ItemStack.areItemStackTagsEqual(stack, compareStack)) {
            ignore = true;
          }
        }
      }
      if (!ignore && entityItem.age >= 30) {
        suckEntityToPlayer(entityItem, player);
      }
    }

    for (EntityXPOrb entityXP : xpEntities) {
      suckEntityToPlayer(entityXP, player);
    }
  }

  public void suckEntityToPlayer(Entity entity, EntityPlayer player) {
    moveEntityTo(entity, new Vector3d((float) player.posX, (float) (player.posY - (player.worldObj.isRemote ? 1.62D : 0.0D) + 0.75D), (float) player.posZ), 0.45f);

    if (player.worldObj.isRemote && Config.soundEffectChance > 0 && player.worldObj.rand.nextInt(Config.soundEffectChance) == 0) {
      float pitch = 0.85f - player.worldObj.rand.nextFloat() * 3f / 10f;
      player.worldObj.playSoundEffect(entity.posX, entity.posY, entity.posZ, "mob.endermen.portal", 0.6f, pitch);
    }
  }

  public void moveEntityTo(Entity entity, Vector3d position, double speed) {
    Vector3d entityPos = new Vector3d(entity.posX, entity.posY - entity.yOffset + entity.height / 2f, entity.posZ);
    Vector3d motionVector = position.sub(entityPos);
    if (motionVector.magnitude() > 1.0D) {
      motionVector.normalise();
    }

    entity.motionX = motionVector.x * speed;
    entity.motionY = motionVector.y * speed;
    entity.motionZ = motionVector.z * speed;
  }

  @Override
  public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
    if (player.isSneaking()) {
      FMLNetworkHandler.openGui(player, Baublelicious.instance, 1, world, player.inventory.currentItem, 0, 0);
      return stack;
    } else {
      return super.onItemRightClick(stack, world, player);
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean p_77624_4_) {
    lines.add(EnumChatFormatting.GREEN + "Sneak Right Click");
    lines.add(EnumChatFormatting.GREEN + "To Configure Blacklist");
    List<ItemStack> blacklist = getBlacklist(stack);
    List<Byte> compareTypes = getBlacklistCompareTypes(stack);
    if (blacklist.size() != 0) {
      for (int i = 0; i < blacklist.size(); i++) {
        ItemStack item = blacklist.get(i);
        byte compareType = compareTypes.get(i);
        String info = "";
        if (compareType == 1) {
          info += " - M";
        } else if (compareType == 2) {
          info += " - N";
        } else if (compareType == 3) {
          info += " - MN";
        }
        lines.add(EnumChatFormatting.DARK_RED + item.getDisplayName() + info);
      }
    }
  }

  public static List<ItemStack> getBlacklist(ItemStack stack) {
    List<ItemStack> blacklist = new ArrayList<>();
    NBTTagCompound compound = NBTHelper.getItemStackCompound(stack);
    if (compound.hasKey("MagnetBlacklist")) {
      NBTTagList blacklistList = compound.getTagList("MagnetBlacklist", Constants.NBT.TAG_COMPOUND);
      for (int i = 0; i < blacklistList.tagCount(); i++) {
        NBTTagCompound itemTag = blacklistList.getCompoundTagAt(i);
        blacklist.add(ItemStack.loadItemStackFromNBT(itemTag));
      }
    }
    return blacklist;
  }

  public static List<Byte> getBlacklistCompareTypes(ItemStack stack) {
    List<Byte> blacklist = new ArrayList<>();
    NBTTagCompound compound = NBTHelper.getItemStackCompound(stack);
    if (compound.hasKey("MagnetBlacklist")) {
      NBTTagList blacklistList = compound.getTagList("MagnetBlacklist", Constants.NBT.TAG_COMPOUND);
      for (int i = 0; i < blacklistList.tagCount(); i++) {
        NBTTagCompound itemTag = blacklistList.getCompoundTagAt(i);
        blacklist.add(itemTag.getByte("CompareType"));
      }
    }
    return blacklist;
  }
}