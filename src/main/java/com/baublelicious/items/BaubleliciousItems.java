package com.baublelicious.items;

import com.baublelicious.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.util.ResourceLocation;


public class BaubleliciousItems {

    //normal items
    public static Item ItemMagicCore;

    //bauble items
    public static Item ItemRing;
    public static Item ItemAmulet;
    public static Item ItemBelt;
    public static Item ItemSpeedBelt;
    public static Item ItemGrowthPendant;
    public static Item ItemRingOfFlight;
    public static Item ItemBeltWaterWalking;
    public static Item ItemDivingAmulet;
    public static Item ItemFallingBelt;
    public static Item ItemAmuletNightvision;
    public static Item ItemAmuletFieryCore;

    public static void init() {


        ItemMagicCore = new ItemMagicCore();
        ItemMagicCore.setRegistryName(new ResourceLocation(ModInfo.MOD_ID, ItemMagicCore.getUnlocalizedName()));
        GameRegistry.register(ItemMagicCore);


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