package com.baublelicious.items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemDivingAmulet extends BaubleliciousBaublesItem {
    public ItemDivingAmulet() {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName("ItemDivingAmulet");
        setRegistryName("ItemDivingAmulet");
    }


    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.AMULET;
    }


    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        World world = player.world;
        int i = MathHelper.floor(player.posX);
        int j = MathHelper.floor(player.getEntityBoundingBox().minY + 1);
        int k = MathHelper.floor(player.posZ);
        Material m = player.world.getBlockState(new BlockPos(i, j, k)).getMaterial();
        boolean flag = (m == Material.WATER);


        if (flag) {
            if (itemstack.getItemDamage() == 0 && !player.isPotionActive(Potion.getPotionById(13))) {
                if (player.getAir() == 1 && player instanceof EntityPlayer) {
                    player.setAir(300);
                }
            }
        }
    }
}
