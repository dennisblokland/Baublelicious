package com.baublelicious.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class BaubleliciousBlocks {
  public static Block BlockPedestal;

  public static void init() {
    BlockPedestal = new PedestalBlock(0);

    GameRegistry.registerBlock(BlockPedestal, "BlockPedestal");
  }
}
