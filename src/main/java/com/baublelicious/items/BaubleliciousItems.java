package com.baublelicious.items;

import com.baublelicious.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.util.ResourceLocation;


public class BaubleliciousItems {


    public static ItemRing ItemRing;
    public static ItemAmulet ItemAmulet;
    public static ItemBelt ItemBelt;
    public static ItemSpeedBelt ItemSpeedBelt;
    public static ItemGrowthPendant ItemGrowthPendant;
    public static ItemRingOfFlight ItemRingOfFlight;
    public static ItemBeltWaterWalking ItemBeltWaterWalking;
    public static ItemDivingAmulet ItemDivingAmulet;
    public static ItemFallingBelt ItemFallingBelt;
    public static ItemAmuletNightvision ItemAmuletNightvision;
    public static  ItemAmuletFieryCore ItemAmuletFieryCore;

    public static void init() {
        ItemRing = register(new ItemRing(), "ItemRing");
        ItemAmulet = register(new ItemAmulet(), "ItemAmulet");
        ItemBelt = register(new ItemBelt(), "ItemBelt");
        ItemSpeedBelt = register(new ItemSpeedBelt(), "ItemSpeedBelt");
        ItemGrowthPendant = register(new ItemGrowthPendant(), "ItemGrowthPendant");
        ItemRingOfFlight = register(new ItemRingOfFlight(), "ItemRingOfFlight");
        ItemBeltWaterWalking = register(new ItemBeltWaterWalking(), "ItemBeltWaterWalking");
        ItemDivingAmulet = register(new ItemDivingAmulet(), "ItemDivingAmulet");
        ItemFallingBelt = register(new ItemFallingBelt(), "ItemFallingBelt");
        ItemAmuletNightvision = register(new ItemAmuletNightvision(), "ItemAmuletNightvision");
        ItemAmuletFieryCore = register(new ItemAmuletFieryCore(), "ItemAmuletFieryCore");
    }

    private static <T extends Item> T register(T item, String name) {
        item.setRegistryName(new ResourceLocation(ModInfo.MOD_ID, name));
        GameRegistry.register(item);

        if (item instanceof BaubleliciousBasicItem) {
            ((BaubleliciousBasicItem)item).registerItemModel(item);
        }
        if (item instanceof BaubleliciousBaublesItem) {
            ((BaubleliciousBaublesItem)item).registerItemModel(item);
        }

        return item;
    }


}