package com.baublelicious.registery;

import thaumcraft.common.items.baubles.ItemRingRunic;

import com.baublelicious.items.BaubleliciousItems;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;




public abstract class BaubleliciousRecipe {
	
	 


	public static void init() {
		GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemAmulet), " G ", "G G", 'G', Items.gold_ingot);
		GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemAmuletGrowth), " A ", "BCB", " S ",
				'A' , BaubleliciousItems.ItemAmulet, 'S', Blocks.sapling, 'B',  new ItemStack(Items.dye,0,15),  'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 2));
		
		GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemBelt), " L ", "L L"," L ", 'L', Items.leather);
		GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemBeltStepAssist),"LBL"," C ", "   ", 'L', Items.leather_boots, 'B', BaubleliciousItems.ItemBelt, 'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1));
        GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemBeltWaterWalking), " D ", "LBL"," C ", 'L', Items.water_bucket, 'B', BaubleliciousItems.ItemBelt, 'D', Items.diamond, 'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 2));
        GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemFallingBelt), " L ", "FBF"," C ", 'L', Items.leather_boots, 'B', BaubleliciousItems.ItemBelt, 'F', Items.feather,  'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1));
        GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemFlyingRing), " C ", "FRF"," D ", 'N', Items.nether_star, 'R', BaubleliciousItems.ItemRing, 'D', Items.diamond, 'F', Items.feather, 'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 2));
        GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemMagnetRing), " M ", "IRI"," C ", 'C', Items.compass, 'R', BaubleliciousItems.ItemRing, 'I', Items.iron_ingot, 'M', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1));
        GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemNecklesDiving), " C ", "DAD"," B ", 'B', Items.glass_bottle, 'A', BaubleliciousItems.ItemAmulet, 'D', Items.diamond, 'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 2));
        GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemRing), " G ", "I I"," G ", 'G', Items.gold_nugget, 'I', Items.iron_ingot);
        GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemSpeedBelt), " P ", "SBS"," C ", 'P', new ItemStack(Items.potionitem,1,8226), 'B', BaubleliciousItems.ItemBelt, 'S', Items.sugar, 'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1));
        GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemMagicCore, 1)," R ", "GDG"," R ", 'R', Items.redstone, 'G', Items.glowstone_dust, 'D', Items.diamond);
        GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1)," D ", "RGR"," D ", 'R', Items.redstone, 'G', Blocks.gold_block, 'D', Items.diamond);
        GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 2)," G ", "RNR"," G ", 'R', Items.redstone, 'G', Items.gold_ingot, 'N', Items.nether_star);
	
	
	}


	
		
	}


	
	

