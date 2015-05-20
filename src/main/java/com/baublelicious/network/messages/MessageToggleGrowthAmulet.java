package com.baublelicious.network.messages;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class MessageToggleGrowthAmulet implements IMessage {
  public int keyId;

  public MessageToggleGrowthAmulet() {
  }

  @Override
  public void fromBytes(ByteBuf buf) {
    this.keyId = buf.readInt();
  }

  @Override
  public void toBytes(ByteBuf buf) {
    buf.writeInt(this.keyId);
  }
}
    

