package com.baublelicious.handler;

import com.baublelicious.network.NetworkRegister;
import com.baublelicious.network.messages.MessageToggleGrowthAmulet;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class KeyHandler {
  private static KeyBinding keyToggle = new KeyBinding("Turn on/off Growth Amulet", Keyboard.KEY_G, "Baublelicious");

  public KeyHandler() {
    ClientRegistry.registerKeyBinding(keyToggle);
  }

  @SubscribeEvent
  public void onKey(KeyInputEvent evt) {
    if (keyToggle.isPressed()) {
      NetworkRegister.wrapper.sendToServer(new MessageToggleGrowthAmulet());
    }
  }
}