package com.baublelicious.blocks;

import com.baublelicious.blocks.pedestal.BlockPedestal;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class BaubleliciousBlocks {

    public static BlockPedestal pedestal = new BlockPedestal();

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                pedestal);

        GameRegistry.registerTileEntity(pedestal.getTileEntityClass(), pedestal.getRegistryName().toString());
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                // ...
                pedestal.createItemBlock()
        );
    }

    public static void registerModels() {
            pedestal.registerItemModel(Item.getItemFromBlock(pedestal));
    }
}
