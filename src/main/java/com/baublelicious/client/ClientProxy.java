package com.baublelicious.client;

import com.baublelicious.Baublelicious;
import com.baublelicious.CommonProxy;
import com.baublelicious.ModInfo;

import com.baublelicious.items.BaubleliciousItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));

    }

    @Override
    public void registerModels()
    {
        ModelLoader.setCustomModelResourceLocation(BaubleliciousItems.ItemMagicCore, 0, new ModelResourceLocation("baublelicious:ItemMagicCore0"));
        ModelLoader.setCustomModelResourceLocation(BaubleliciousItems.ItemMagicCore, 1, new ModelResourceLocation("baublelicious:ItemMagicCore1"));
        ModelLoader.setCustomModelResourceLocation(BaubleliciousItems.ItemMagicCore, 2, new ModelResourceLocation("baublelicious:ItemMagicCore2"));
    }

}