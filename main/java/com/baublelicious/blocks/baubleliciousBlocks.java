package com.baublelicious.blocks;

import com.baublelicious.baublelicious;
import com.baublelicious.items.ItemBeltStepAssist;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;



public class baubleliciousBlocks {
	public static Block BlockPedestal;

public static void init() {
	
	BlockPedestal = new PedestalBlock(0);
	
	GameRegistry.registerBlock(BlockPedestal, "BlockPedestal");
	
}












}
