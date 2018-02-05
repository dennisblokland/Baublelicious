package com.baublelicious.items;
import net.minecraftforge.registries.IForgeRegistry;
import com.baublelicious.Baublelicious;
import com.baublelicious.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.util.ResourceLocation;


public class BaubleliciousItems {

    //normal items
    public static Item ItemMagicCore = new ItemMagicCore();;

    //bauble items
    public static Item ItemRing = new ItemRing();
    public static Item ItemAmulet = new ItemAmulet();
    public static Item ItemBelt = new ItemBelt();
    public static Item ItemSpeedBelt = new ItemSpeedBelt();
    public static Item ItemGrowthPendant = new ItemGrowthPendant();
    public static Item ItemRingOfFlight = new ItemRingOfFlight();
    public static Item ItemBeltWaterWalking =  new ItemBeltWaterWalking();
    public static Item ItemDivingAmulet = new ItemDivingAmulet();
    public static Item ItemFallingBelt = new ItemFallingBelt();
    public static Item ItemAmuletNightvision =  new ItemAmuletNightvision();
    public static Item ItemAmuletFieryCore = new ItemAmuletFieryCore();

    public static void register(IForgeRegistry<Item> registry) {
        ItemMagicCore.setRegistryName(new ResourceLocation(ModInfo.MOD_ID, ItemMagicCore.getUnlocalizedName()));
        registry.registerAll(
                ItemRing,
                ItemAmulet,
                ItemBelt,
                ItemSpeedBelt,
                ItemGrowthPendant,
                ItemRingOfFlight,
                ItemBeltWaterWalking,
                ItemDivingAmulet,
                ItemFallingBelt,
                ItemAmuletNightvision,
                ItemAmuletFieryCore,
                ItemMagicCore
        );
        ((BaubleliciousBaublesItem)ItemRing).registerItemModel(ItemRing);
        ((BaubleliciousBaublesItem)ItemAmulet).registerItemModel(ItemAmulet);
        ((BaubleliciousBaublesItem)ItemBelt).registerItemModel(ItemBelt);
        ((BaubleliciousBaublesItem)ItemSpeedBelt).registerItemModel(ItemSpeedBelt);
        ((BaubleliciousBaublesItem)ItemGrowthPendant).registerItemModel(ItemGrowthPendant);
        ((BaubleliciousBaublesItem)ItemRingOfFlight).registerItemModel(ItemRingOfFlight);
        ((BaubleliciousBaublesItem)ItemBeltWaterWalking).registerItemModel(ItemBeltWaterWalking);
        ((BaubleliciousBaublesItem)ItemDivingAmulet).registerItemModel(ItemDivingAmulet);
        ((BaubleliciousBaublesItem)ItemFallingBelt).registerItemModel(ItemFallingBelt);
        ((BaubleliciousBaublesItem)ItemAmuletNightvision).registerItemModel(ItemAmuletNightvision);
        ((BaubleliciousBaublesItem)ItemAmuletFieryCore).registerItemModel(ItemAmuletFieryCore);
        //basic items
        ((BaubleliciousBasicItem)ItemMagicCore).registerItemModel(ItemMagicCore);

    }




}