package com.baublelicious.network.messages;

import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

public class MessageTileRequest extends MessageTile {
  public int id;

  public MessageTileRequest() {
  }
  
  public MessageTileRequest(TileEntity tileEntity, int id) {
    super(tileEntity);
    this.id = id;
  }

  @Override
  public void fromBytes(ByteBuf buf) {
    super.fromBytes(buf);
    id = buf.readInt();
  }

  @Override
  public void toBytes(ByteBuf buf) {
    super.toBytes(buf);
    buf.writeInt(id);
  }
}
