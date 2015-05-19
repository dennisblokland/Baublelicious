package com.baublelicious.network.messages;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

public class MessageTile implements IMessage {
  public int dimensionId, x, y, z;

  public MessageTile() {
  }

  public MessageTile(TileEntity tileEntity) {
    dimensionId = tileEntity.getWorldObj().provider.dimensionId;
    x = tileEntity.xCoord;
    y = tileEntity.yCoord;
    z = tileEntity.zCoord;
  }

  @Override
  public void fromBytes(ByteBuf buf) {
    dimensionId = buf.readInt();
    x = buf.readInt();
    y = buf.readInt();
    z = buf.readInt();
  }

  @Override
  public void toBytes(ByteBuf buf) {
    buf.writeInt(dimensionId);
    buf.writeInt(x);
    buf.writeInt(y);
    buf.writeInt(z);
  }
}
