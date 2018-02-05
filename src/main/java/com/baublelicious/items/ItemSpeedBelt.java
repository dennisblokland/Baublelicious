package com.baublelicious.items;


import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSpeedBelt extends BaubleliciousBaublesItem {
    final float speed;
    final float jump;
    final float fallBuffer;

    public ItemSpeedBelt() {
        this("ItemSpeedBelt",  0.035F, 0.2F, 2F);
        this.setUnlocalizedName("ItemSpeedBelt");
        setRegistryName("ItemSpeedBelt");
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
            if((player.onGround || player.capabilities.isFlying) && player.moveForward > 0F && !player.isInsideOfMaterial(Material.WATER)) {
                player.moveRelative(0F, 0F, 1F, speed );
                player.stepHeight = 1F;
            } else {
                player.stepHeight = 0.5F;
            }
        }

    }

    @SubscribeEvent
    public void onPlayerJump(LivingJumpEvent event) {
        if(event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();
            ItemStack belt = BaublesApi.getBaublesHandler(player).getStackInSlot(3);

            if (belt != null) {
                if (belt.getItem() == this) {
                    player.motionY += jump;
                    player.fallDistance = -fallBuffer;
                }
            }
        }
    }

    @Override
    public void onEquipped(ItemStack stack, EntityLivingBase player) {
        player.stepHeight = 1F;
    }

    @Override
    public void onUnequipped(ItemStack stack, EntityLivingBase player) {
        player.stepHeight = 0.5F;
    }
}