package com.baublelicious.network.messages;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class MessageTileNBT extends MessageTile {
  public NBTTagCompound compound;

  public MessageTileNBT() {
  }

  public MessageTileNBT(TileEntity tileEntity, NBTTagCompound compound) {
    super(tileEntity);
    this.compound = compound;
  }

  @Override
  public void fromBytes(ByteBuf buf) {
    super.fromBytes(buf);
    compound = ByteBufUtils.readTag(buf);
  }

  @Override
  public void toBytes(ByteBuf buf) {
    super.toBytes(buf);
    ByteBufUtils.writeTag(buf, compound);
  }
}
