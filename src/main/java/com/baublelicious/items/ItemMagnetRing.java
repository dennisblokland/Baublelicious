package com.baublelicious.items;

import baubles.api.BaubleType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.util.vector.Vector3f;

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
  public void onWornTick(ItemStack stack, EntityLivingBase entity) {
    EntityPlayer player = (EntityPlayer) entity;

    AxisAlignedBB bounds = player.boundingBox.expand(RANGE, RANGE, RANGE);

    List<EntityItem> itemEntities = player.worldObj.getEntitiesWithinAABB(EntityItem.class, bounds);
    List<EntityXPOrb> xpEntities = player.worldObj.getEntitiesWithinAABB(EntityXPOrb.class, bounds);

    for (EntityItem entityItem : itemEntities) {
      if (entityItem.age >= 30) {
        suckEntityToPlayer(entityItem, player);
      }
    }

    for (EntityXPOrb entityXP : xpEntities) {
      suckEntityToPlayer(entityXP, player);
    }
  }

  public void suckEntityToPlayer(Entity entity, EntityPlayer player) {
    moveEntityTo(entity, new Vector3f((float) player.posX, (float) (player.posY - (player.worldObj.isRemote ? 1.62D : 0.0D) + 0.75D), (float) player.posZ), 0.45f);

    if (player.worldObj.rand.nextInt(200) == 0) {
      float pitch = 0.85f - player.worldObj.rand.nextFloat() * 3f / 10f;
      player.worldObj.playSoundEffect(entity.posX, entity.posY, entity.posZ, "mob.endermen.portal", 0.6f, pitch);
    }
  }

  public void moveEntityTo(Entity entity, Vector3f position, double speed) {
    Vector3f entityPos = new Vector3f((float) entity.posX, (float) (entity.posY - entity.yOffset + entity.height / 2f), (float) entity.posZ);
    Vector3f motionVector = Vector3f.sub(position, entityPos, null);
    if (motionVector.length() > 1.0D) {
      motionVector.normalise();
    }

    entity.motionX = motionVector.x * speed;
    entity.motionY = motionVector.y * speed;
    entity.motionZ = motionVector.z * speed;
  }
}

				
			
		
		

