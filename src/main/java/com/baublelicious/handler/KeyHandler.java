package com.baublelicious.handler;

import com.baublelicious.items.BaubleliciousItems;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemStack;
import org.lwjgl.input.Keyboard;

public class KeyHandler {

  private static Minecraft mc = Minecraft.getMinecraft();
  private static KeyBinding keyToggle = new KeyBinding("Turn on/off Growth Amulet", Keyboard.KEY_G, "Baublelicious");

  public KeyHandler() {
    ClientRegistry.registerKeyBinding(keyToggle);
  }


  @SubscribeEvent
  public void onKey(KeyInputEvent evt) {

    boolean toggle = keyToggle.isPressed();
    ItemStack stack = new ItemStack(BaubleliciousItems.ItemAmuletGrowth);


    if (toggle) {
      PacketHandler.instance.sendToServer(new MessageToggleGrowthAmulet());

 /*       	        if (stack.stackTagCompound == null)
                  {
        	        	stack.setTagCompound(new NBTTagCompound());
        	        

        	        NBTTagCompound tag = stack.stackTagCompound;
        	        tag.setBoolean("isActive", (tag.getBoolean("isActive")));

        	        if (tag.getBoolean("isActive"))
        	        {
        	           System.out.print("yay");
        	          tag.setBoolean("isActive",true);
        	            
        	            
        	        } else
        	        {
        	        	System.out.print("nah");
        	        	 tag.setBoolean("isActive",false);
        	        }

        	    }
            return;
                    
                }
            }
        */

    }

  }
}