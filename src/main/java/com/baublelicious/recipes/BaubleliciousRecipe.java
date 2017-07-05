package com.baublelicious.recipes;

import baubles.api.BaubleType;
import com.baublelicious.items.BaubleliciousItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;

import net.minecraft.potion.PotionUtils;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BaubleliciousRecipe {
    public static void init() {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.ItemRing), " G ", "I I", " G ", 'G', "nuggetGold", 'I', "ingotIron"));
        GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemBelt), " L ", "L L", " L ", 'L', Items.LEATHER);
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.ItemAmulet), " L ", "L L", " I ", 'L', Items.LEATHER, 'I', "ingotIron"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.ItemGrowthPendant), " A ", "BCB", " S ", 'A', BaubleliciousItems.ItemAmulet, 'S', "treeSapling", 'B', "dyeWhite", 'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.ItemBeltWaterWalking), " D ", "LBL", " C ", 'L', Items.WATER_BUCKET, 'B', BaubleliciousItems.ItemBelt, 'D', "gemDiamond", 'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1)));
        GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemFallingBelt), " L ", "FBF", " C ", 'L', Items.LEATHER_BOOTS, 'B', BaubleliciousItems.ItemBelt, 'F', Items.FEATHER, 'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.ItemRingOfFlight), " C ", "FRF", " D ", 'N', Items.NETHER_STAR, 'R', BaubleliciousItems.ItemRing, 'D', "gemDiamond", 'F', Items.FEATHER, 'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 2)));
       // GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.magnetRing), " M ", "IRI", " C ", 'C', Items.compass, 'R', BaubleliciousItems.ItemRing, 'I', "ingotIron", 'M', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.ItemDivingAmulet), " C ", "DAD", " B ", 'B', Items.GLASS_BOTTLE, 'A', BaubleliciousItems.ItemAmulet, 'D', "gemDiamond", 'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1)));
        GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemSpeedBelt), " P ", "SBS", " C ", 'P',  PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.SWIFTNESS), 'B', BaubleliciousItems.ItemBelt, 'S', Items.SUGAR, 'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1));
        GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemAmuletNightvision), " 2 ", "cac", " n ", 'c', Items.GOLDEN_CARROT, 'n',  PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.NIGHT_VISION), 'a', BaubleliciousItems.ItemAmulet, '2', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1));
        GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemAmuletFieryCore), " 2 ", "cac", " n ", 'c', Items.FIRE_CHARGE, 'n',  PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.LONG_FIRE_RESISTANCE), 'a', BaubleliciousItems.ItemAmulet, '2', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 2));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.ItemMagicCore, 1), " R ", "GDG", " R ", 'R', "dustRedstone", 'G', "dustGlowstone", 'D', "gemDiamond"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1), " D ", "RGR", " D ", 'R', "dustRedstone", 'G', "blockGold", 'D', "gemDiamond"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 2), " G ", "RNR", " G ", 'R', "dustRedstone", 'G', "ingotGold", 'N', Items.NETHER_STAR));


        //blocks

    }
}