package com.baublelicious.network;

import com.baublelicious.blocks.baubleliciousBlocks;
import com.baublelicious.items.BaubleliciousItems;
import com.baublelicious.registery.BaubleliciousRecipe;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
  public void preInit(FMLPreInitializationEvent event) {
    BaubleliciousItems.init();
    baubleliciousBlocks.init();
    BaubleliciousRecipe.init();


  }

  public void init() {


  }

  public void initRenderers() {

  }

  public void registerRenderThings() {
    // TODO Auto-generated method stub

  }

}