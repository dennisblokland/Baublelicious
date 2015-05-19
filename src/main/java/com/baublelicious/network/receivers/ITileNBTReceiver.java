package com.baublelicious.network.receivers;

import net.minecraft.nbt.NBTTagCompound;

public interface ITileNBTReceiver {
  void onTileNBT(NBTTagCompound compound);
}
