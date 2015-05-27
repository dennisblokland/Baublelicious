package com.baublelicious.items;

import com.baublelicious.Baublelicious;
import com.baublelicious.ModInfo;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class BaubleliciousItems {
  public static final String BINDING_GEM_KEY = "bindingGem";
  public static final String ENTANGLED_AMULET_KEY = "entangledAmulet";
  public static final String ENTANGLED_RING_KEY = "entangledRing";
  public static final String ENTANGLED_BELT_KEY = "entangledBelt";
  public static final String MAGNET_RING_KEY = "ItemMagnetRing";

  public static Baublelicious instance;
  public static Item ItemBeltStepAssist;
  public static Item ItemBeltWaterWalking;
  public static Item ItemNecklaceDiving;
  public static Item ItemFlyingRing;
  public static Item ItemSpeedBelt;
  public static Item ItemBelt;
  public static Item ItemRing;
  public static Item ItemAmulet;
  public static Item ItemFallingBelt;
  public static Item magnetRing;
  public static Item ItemAmuletGrowth;
  public static Item ItemMagicCore;
  public static Item ItemsAmuletNightvision;
  public static Item bindingGem;
  public static Item entangledAmulet, entangledRing, entangledBelt;

  public static void init() {
    ItemAmulet = new ItemAmulet();
    ItemRing = new ItemRing();
    ItemBelt = new ItemBelt();
    bindingGem = new ItemBindingGem(ModInfo.MOD_ID + ":" + BINDING_GEM_KEY);
    ItemBeltStepAssist = new ItemBeltStepAssist();
    ItemBeltWaterWalking = new ItemBeltWaterWalking();
    ItemNecklaceDiving = new ItemNecklaceDiving();
    ItemFlyingRing = new ItemFlyingRing();
    ItemSpeedBelt = new ItemSpeedBelt();
    ItemFallingBelt = new ItemFallingBelt();
    magnetRing = new ItemMagnetRing(ModInfo.MOD_ID + ":" + MAGNET_RING_KEY);
    ItemAmuletGrowth = new ItemAmuletGrowth();
    ItemMagicCore = new ItemMagicCore();
    ItemsAmuletNightvision = new ItemsAmuletNightvision();

    entangledAmulet = new ItemEntangledAmulet(ModInfo.MOD_ID + ":" + ENTANGLED_AMULET_KEY);
    entangledRing = new ItemEntangledRing(ModInfo.MOD_ID + ":" + ENTANGLED_RING_KEY);
    entangledBelt = new ItemEntangledBelt(ModInfo.MOD_ID + ":" + ENTANGLED_BELT_KEY);


    GameRegistry.registerItem(ItemMagicCore, "ItemMagicCore");
    GameRegistry.registerItem(bindingGem, BINDING_GEM_KEY);

    GameRegistry.registerItem(magnetRing, MAGNET_RING_KEY);

    GameRegistry.registerItem(entangledAmulet, ENTANGLED_AMULET_KEY);
    GameRegistry.registerItem(entangledRing, ENTANGLED_RING_KEY);
    GameRegistry.registerItem(entangledBelt, ENTANGLED_BELT_KEY);
  }
}







