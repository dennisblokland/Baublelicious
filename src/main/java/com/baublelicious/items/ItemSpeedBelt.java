package com.baublelicious.items;

import baubles.api.BaubleType;
import baubles.common.lib.PlayerHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;

public class ItemSpeedBelt extends ItemBaubles {
  final float speed;
  final float jump;
  final float fallBuffer;

  public ItemSpeedBelt() {
    this("ItemSpeedBelt", 0.035F, 0.2F, 2F);
    this.setUnlocalizedName("ItemSpeedBelt");
  }

  public ItemSpeedBelt(String name, float speed, float jump, float fallBuffer) {
    super();
    this.speed = speed;
    this.jump = jump;
    this.fallBuffer = fallBuffer;
    MinecraftForge.EVENT_BUS.register(this);
  }

  @Override
  public BaubleType getBaubleType(ItemStack itemstack) {
    return BaubleType.BELT;
  }

  @Override
  public void onWornTick(ItemStack stack, EntityLivingBase entity) {
    super.onWornTick(stack, entity);

    if (entity instanceof EntityPlayer) {
      EntityPlayer player = (EntityPlayer) entity;
      if ((player.onGround || player.capabilities.isFlying) && player.moveForward > 0F && !player.isInWater()) {
        player.moveFlying(0F, 1F, player.capabilities.isFlying ? speed : speed * 2);
        player.stepHeight = 1F;
      } else {
        player.stepHeight = 0.5F;
      }
    }

  }

  @SubscribeEvent
  public void onPlayerJump(LivingJumpEvent event) {
    if (event.entityLiving instanceof EntityPlayer) {
      EntityPlayer player = (EntityPlayer) event.entityLiving;
      ItemStack belt = PlayerHandler.getPlayerBaubles(player).getStackInSlot(3);

      if (belt != null) {
        if (belt.getItem() == this || (belt.getItem() == BaubleliciousItems.entangledBelt && ItemEntangledBauble.containsBauble(belt, this))) {
          player.motionY += jump;
          player.fallDistance = -fallBuffer;
        }
      }
    }
  }

  @Override
  public void onEquippedOrLoadedIntoWorld(ItemStack stack, EntityLivingBase player) {
    player.stepHeight = 1F;
  }

  @Override
  public void onUnequipped(ItemStack stack, EntityLivingBase player) {
    player.stepHeight = 0.5F;
  }
}