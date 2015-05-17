package com.baublelicious.items;

import com.baublelicious.baublelicious;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;



public class BaubleliciousItems {
	public static baublelicious instance;
	public static Item ItemBeltStepAssist;
	public static Item ItemBeltWaterWalking;
	public static Item ItemNecklesDiving;
	public static Item ItemFlyingRing;
	public static Item ItemSpeedBelt;
	public static Item ItemBelt;
	public static Item ItemRing;
	public static Item ItemAmulet;
	public static Item ItemFallingBelt;
	public static Item ItemMagnetRing;
	public static Item ItemAmuletMining;
	public static Item ItemAmuletGrowth;
	public static Item ItemPhantomAmulet;
	public static Item ItemMagicCore;
	public static Item ItemsAmuletNightvision;
	public static Item ItemBindingGem;


	
public static void init() {
ItemAmulet = new ItemAmulet();
ItemRing = new ItemRing();
ItemBelt = new ItemBelt();
//ItemBindingGem = new ItemBindingGem();
ItemBeltStepAssist = new ItemBeltStepAssist();
ItemBeltWaterWalking = new ItemBeltWaterWalking();
ItemNecklesDiving = new ItemNecklesDiving();
ItemFlyingRing = new ItemFlyingRing();
ItemSpeedBelt = new ItemSpeedBelt();
ItemFallingBelt = new ItemFallingBelt();
ItemMagnetRing = new ItemMagnetRing();
ItemAmuletGrowth = new ItemAmuletGrowth();
ItemMagicCore = new ItemMagicCore();
ItemsAmuletNightvision = new ItemsAmuletNightvision();



GameRegistry.registerItem(ItemMagicCore, "ItemMagicCore");
//GameRegistry.registerItem(ItemBindingGem, "ItemBindingGem");



}


}







