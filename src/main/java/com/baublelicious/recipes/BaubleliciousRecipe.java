package com.baublelicious.recipes;

import baubles.api.BaubleType;
import com.baublelicious.items.BaubleliciousItems;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.*;


public class BaubleliciousRecipe {
    public static void init() {

//
//       // GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.magnetRing), " M ", "IRI", " C ", 'C', Items.compass, 'R', BaubleliciousItems.ItemRing, 'I', "ingotIron", 'M', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1)));
       GameRegistry.addShapedRecipe(
               BaubleliciousItems.ItemSpeedBelt.getRegistryName(),
               new ResourceLocation("ItemSpeedBelt"),
               new ItemStack(BaubleliciousItems.ItemSpeedBelt),
               new Object[]{" P ", "SBS", " C ",
               'P', PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.STRONG_SWIFTNESS),
               'B', BaubleliciousItems.ItemBelt,
               'S', Items.SUGAR,
               'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1)});

        GameRegistry.addShapedRecipe(
                BaubleliciousItems.ItemAmuletNightvision.getRegistryName(),
                new ResourceLocation("ItemAmuletNightvision"),
                new ItemStack(BaubleliciousItems.ItemAmuletNightvision),
                new Object[]{" P ", "SBS", " C ",
                        'P', PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.NIGHT_VISION),
                        'B', BaubleliciousItems.ItemAmulet,
                        'S', Items.GOLDEN_CARROT,
                        'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1)});
        GameRegistry.addShapedRecipe(
                BaubleliciousItems.ItemAmuletFieryCore.getRegistryName(),
                new ResourceLocation("ItemAmuletFieryCore"),
                new ItemStack(BaubleliciousItems.ItemAmuletFieryCore),
                new Object[]{" P ", "SBS", " C ",
                        'P', PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.LONG_FIRE_RESISTANCE),
                        'B', BaubleliciousItems.ItemAmulet,
                        'S', Items.FIRE_CHARGE,
                        'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 2)});

//
        GameRegistry.addShapedRecipe(new ResourceLocation("baublelicious:ItemMagicCore1"),
                new ResourceLocation("ItemMagicCore"),new ItemStack(BaubleliciousItems.ItemMagicCore, 1), " R ", "GDG", " R ", 'R', "dustRedstone", 'G', "dustGlowstone", 'D', "gemDiamond");
        GameRegistry.addShapedRecipe(new ResourceLocation("baublelicious:ItemMagicCore2"),
                new ResourceLocation("ItemMagicCore"),new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1), " D ", "RGR", " D ", 'R', "dustRedstone", 'G', "blockGold", 'D', "gemDiamond");
        GameRegistry.addShapedRecipe(new ResourceLocation("baublelicious:ItemMagicCore3"),
                new ResourceLocation("ItemMagicCore"),new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 2), " G ", "RNR", " G ", 'R', "dustRedstone", 'G', "ingotGold", 'N', Items.NETHER_STAR);
//
//        //blocks

    }
}