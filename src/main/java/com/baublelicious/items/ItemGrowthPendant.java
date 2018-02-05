package com.baublelicious.items;


import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import com.baublelicious.Baublelicious;
import com.baublelicious.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.IPlantable;
import net.minecraft.block.IGrowable;
import java.util.List;

public class ItemGrowthPendant extends BaubleliciousBaublesItem {
    public static String isActive;
    private int tickDelay = 100;
    public ItemGrowthPendant() {
        this.setUnlocalizedName("ItemGrowthPendant");
        setRegistryName("ItemGrowthPendant");
        setMaxDamage(365);

        //this.canRepair = true;

    }

    public static void onCreation(ItemStack itemstack, World world, EntityPlayer player) {


    }

    @Override
    public BaubleType getBaubleType(ItemStack arg0) {
        return BaubleType.AMULET;
    }



    @Override
    public void onWornTick(ItemStack stack, EntityLivingBase entity) {
    ;
        if (!(entity instanceof EntityPlayer) || entity.world.isRemote) {
            return;
        }

        World world = ((EntityPlayer) entity).world;
        EntityPlayer player = (EntityPlayer) entity;
        ItemStack amulet = BaublesApi.getBaublesHandler(player).getStackInSlot(0);


        if (!(entity instanceof EntityPlayer)) {
            return;
        }
        int tileRange = 5;
        int fullPotencyRange = 3;
        EntityPlayer par3EntityPlayer = (EntityPlayer) entity;
        int xO = (int) Math.round(entity.posX - 0.5f);
        int yO = (int) entity.posY;
        int zO = (int) Math.round(entity.posZ - 0.5f);
        if (world.rand.nextInt(20) == 0) {
        for(int xD = -tileRange; xD <= tileRange; xD++) {
            for(int yD = -1; yD <= tileRange; yD++) {
                for(int zD = -tileRange; zD <= tileRange; zD++) {
                    int x = xO + xD;
                    int y = yO + yD;
                    int z = zO + zD;

                    double distance = Math.sqrt(Math.pow(x - xO, 2) + Math.pow(y - yO, 2) + Math.pow(z - zO, 2));
                    distance -= fullPotencyRange;
                    distance = Math.min(1D, distance);
                    double distanceCoefficient = 1D - (distance / tileRange);

                    IBlockState cropState = world.getBlockState(new BlockPos(x, y, z));
                    Block cropBlock = cropState.getBlock();

                    if(cropBlock instanceof IPlantable || cropBlock instanceof IGrowable) {

                            //it schedules the next tick.
                            world.scheduleBlockUpdate(new BlockPos(x, y, z), cropBlock, (int) (distanceCoefficient * (float) 1 * 20F), 1);
                            cropBlock.updateTick(world, new BlockPos(x, y, z), cropState, world.rand);

                    }
                }
            }
        }




        }
        if (amulet != null && amulet.getItem() == this) if (world.rand.nextInt(40) == 0) {

            stack.damageItem(1, par3EntityPlayer);
            if (stack.getItemDamage() == 1001)

               // baubles.setInventorySlotContents(0, null);
            if (amulet.getItem() == null)   player.playSound(SoundEvents.ENTITY_ITEM_BREAK, .75F, 2f);;


        }


    }


}
