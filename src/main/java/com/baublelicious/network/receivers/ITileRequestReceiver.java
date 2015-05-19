package com.baublelicious.network.receivers;

import net.minecraft.entity.player.EntityPlayerMP;

public interface ITileRequestReceiver {
  void onTileRequest(int id, EntityPlayerMP player);
}
