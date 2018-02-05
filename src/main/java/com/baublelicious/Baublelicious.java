package com.baublelicious;

import com.baublelicious.client.ClientProxy;
import com.baublelicious.items.BaubleliciousItems;

import com.baublelicious.recipes.BaubleliciousRecipe;
import net.minecraft.block.Block;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.NAME, version = ModInfo.VERSION)

public class Baublelicious
{
    @SidedProxy(clientSide = "com.baublelicious.client.ClientProxy", serverSide = "com.baublelicious.CommonProxy")
    public static CommonProxy proxy;
    public static final CreativeTabs BaubleliciousTab = new BaubleliciousTab(CreativeTabs.getNextID(), "Baublelicious");
    @Mod.Instance(ModInfo.MOD_ID)
    public static Baublelicious instance;
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {

        proxy.registerModels();
        BaubleliciousRecipe.init();

    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }


    @Mod.EventBusSubscriber
    public static class RegsitrationHandler {

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            BaubleliciousItems.register(event.getRegistry());
          //  Ba.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
         //   ModBlocks.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
           // BaubleliciousItems.registerModels();
         //  ModBlocks.registerModels();
        }

    }
}