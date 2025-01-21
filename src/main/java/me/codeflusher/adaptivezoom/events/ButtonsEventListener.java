package me.codeflusher.adaptivezoom.events;

import me.codeflusher.adaptivezoom.config.ConfigScreen;
import me.codeflusher.adaptivezoom.settings.ModKeyBinds;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;


public class ButtonsEventListener {

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (ModKeyBinds.openConfig.isKeyDown()) {
            Minecraft.getMinecraft().displayGuiScreen(new ConfigScreen(null));
        }
    }

}
