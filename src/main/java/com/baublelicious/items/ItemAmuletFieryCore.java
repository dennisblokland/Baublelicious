package com.baublelicious.items;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;


public class ItemAmuletFieryCore  extends BaubleliciousBaublesItem{
    public ItemAmuletFieryCore(){
        this.setUnlocalizedName("ItemAmuletFieryCore");
        setMaxDamage(2002);
    }
    public static final String[] IS_IMMUNE_TO_FIRE = new String[] { "isImmuneToFire", "field_70178_ae", "ag" };
    @Override
    public void onWornTick(ItemStack stack, EntityLivingBase player) {

        World world = player.world;
        int x = MathHelper.floor(player.posX);
        int y = MathHelper.floor(player.getEntityBoundingBox().minY);
        int z = MathHelper.floor(player.posZ);
        Material mlava = world.getBlockState(new BlockPos(x, y, z)).getMaterial();
        EntityPlayer playerEntity = (EntityPlayer) player;

        ItemStack amulet = BaublesApi.getBaublesHandler(playerEntity).getStackInSlot(0);

        if(mlava == Material.LAVA){





            stack.damageItem(1, playerEntity);

            if (stack.getItemDamage() == 2002)

            setImmunity(player, false);



        }
        setImmunity(player, true);

    }

    @Override
    public void onUnequipped(ItemStack stack, EntityLivingBase player) {
        setImmunity(player, false);
    }

    private void setImmunity(Entity entity, boolean immune) {
        ObfuscationReflectionHelper.setPrivateValue(Entity.class, entity, immune, IS_IMMUNE_TO_FIRE);
    }
    @Override
    public BaubleType getBaubleType(ItemStack arg0) {
        return BaubleType.AMULET;
    }
}
