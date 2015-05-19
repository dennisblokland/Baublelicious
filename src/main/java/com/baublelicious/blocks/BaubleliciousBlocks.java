package com.baublelicious.blocks;

import com.baublelicious.tiles.TilePedestal;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class BaubleliciousBlocks {
  public static final String PEDESTAL_KEY = "BlockPedestal";

  public static Block BlockPedestal;

  public static void init() {
    BlockPedestal = new BlockPedestal(PEDESTAL_KEY);

    GameRegistry.registerBlock(BlockPedestal, PEDESTAL_KEY);

    GameRegistry.registerTileEntity(TilePedestal.class, PEDESTAL_KEY + "Tile");
  }
}
