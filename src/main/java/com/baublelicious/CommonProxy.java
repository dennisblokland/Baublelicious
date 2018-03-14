package com.baublelicious;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.List;
import java.util.UUID;

public class CommonProxy {

    public void registerItemRenderer(Item item, int meta, String id) {

    }
    public void registerModels()
    {

    }
    @SuppressWarnings("unchecked")
    public EntityPlayer getPlayerFromUUID(String uuid) {
        UUID uid = UUID.fromString(uuid);
        return FMLCommonHandler.instance ().getMinecraftServerInstance ().getPlayerList ().getPlayerByUUID(uid);


    }
}