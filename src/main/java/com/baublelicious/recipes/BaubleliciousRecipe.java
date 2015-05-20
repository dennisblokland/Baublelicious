package com.baublelicious.recipes;

import baubles.api.BaubleType;
import com.baublelicious.blocks.BaubleliciousBlocks;
import com.baublelicious.items.BaubleliciousItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class BaubleliciousRecipe {
  public static void init() {
    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.ItemRing), " G ", "I I", " G ", 'G', "nuggetGold", 'I', "ingotIron"));
    GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemBelt), " L ", "L L", " L ", 'L', Items.leather);
    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.ItemAmulet), " L ", "L L", " I ", 'L', Items.leather, 'I', "ingotIron"));
    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.bindingGem), " r ", "ede", " 2 ", 'r', "dustRedstone", 'e', Items.ender_pearl, 'd', "gemDiamond", '2', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1)));

    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.ItemAmuletGrowth), " A ", "BCB", " S ", 'A', BaubleliciousItems.ItemAmulet, 'S', "treeSapling", 'B', "dyeWhite", 'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 2)));
    GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemBeltStepAssist), "LBL", " C ", "   ", 'L', Items.leather_boots, 'B', BaubleliciousItems.ItemBelt, 'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1));
    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.ItemBeltWaterWalking), " D ", "LBL", " C ", 'L', Items.water_bucket, 'B', BaubleliciousItems.ItemBelt, 'D', "gemDiamond", 'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 2)));
    GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemFallingBelt), " L ", "FBF", " C ", 'L', Items.leather_boots, 'B', BaubleliciousItems.ItemBelt, 'F', Items.feather, 'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1));
    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.ItemFlyingRing), " C ", "FRF", " D ", 'N', Items.nether_star, 'R', BaubleliciousItems.ItemRing, 'D', "gemDiamond", 'F', Items.feather, 'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 2)));
    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.ItemMagnetRing), " M ", "IRI", " C ", 'C', Items.compass, 'R', BaubleliciousItems.ItemRing, 'I', "ingotIron", 'M', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1)));
    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.ItemNecklaceDiving), " C ", "DAD", " B ", 'B', Items.glass_bottle, 'A', BaubleliciousItems.ItemAmulet, 'D', "gemDiamond", 'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 2)));
    GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.ItemSpeedBelt), " P ", "SBS", " C ", 'P', new ItemStack(Items.potionitem, 1, 8226), 'B', BaubleliciousItems.ItemBelt, 'S', Items.sugar, 'C', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1));
    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.ItemMagicCore, 1), " R ", "GDG", " R ", 'R', "dustRedstone", 'G', "dustGlowstone", 'D', "gemDiamond"));
    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1), " D ", "RGR", " D ", 'R', "dustRedstone", 'G', "blockGold", 'D', "gemDiamond"));
    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 2), " G ", "RNR", " G ", 'R', "dustRedstone", 'G', "ingotGold", 'N', Items.nether_star));

    GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.entangledAmulet), " 3 ", "1a2", " e ", 'a', BaubleliciousItems.ItemAmulet, '3', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 2), '2', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1), '1', new ItemStack(BaubleliciousItems.ItemMagicCore, 1), 'e', Items.ender_pearl);
    GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.entangledRing), " 3 ", "1r2", " e ", 'r', BaubleliciousItems.ItemRing, '3', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 2), '2', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1), '1', new ItemStack(BaubleliciousItems.ItemMagicCore, 1), 'e', Items.ender_pearl);
    GameRegistry.addRecipe(new ItemStack(BaubleliciousItems.entangledBelt), " 3 ", "1b2", " e ", 'b', BaubleliciousItems.ItemBelt, '3', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 2), '2', new ItemStack(BaubleliciousItems.ItemMagicCore, 1, 1), '1', new ItemStack(BaubleliciousItems.ItemMagicCore, 1), 'e', Items.ender_pearl);

    //blocks
    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BaubleliciousBlocks.BlockPedestal), " G ", " p ", "QQQ", 'G', "blockGlassColorless", 'Q', new ItemStack(Blocks.quartz_block, 1, 0), 'p', new ItemStack(Blocks.quartz_block, 1, 2)));

    GameRegistry.addRecipe(new RecipeEntangledBauble(new ItemStack(BaubleliciousItems.entangledAmulet), BaubleType.AMULET));
    GameRegistry.addRecipe(new RecipeEntangledBauble(new ItemStack(BaubleliciousItems.entangledRing), BaubleType.RING));
    GameRegistry.addRecipe(new RecipeEntangledBauble(new ItemStack(BaubleliciousItems.entangledBelt), BaubleType.BELT));
  }
}