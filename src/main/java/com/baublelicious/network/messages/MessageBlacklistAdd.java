package com.baublelicious.network.messages;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class MessageBlacklistAdd implements IMessage {
  public byte compareType;

  public MessageBlacklistAdd() {}

  public MessageBlacklistAdd(byte compareType) {
    this.compareType = compareType;
  }

  @Override
  public void fromBytes(ByteBuf buf) {
    compareType = buf.readByte();
  }

  @Override
  public void toBytes(ByteBuf buf) {
    buf.writeByte(compareType);
  }
}
