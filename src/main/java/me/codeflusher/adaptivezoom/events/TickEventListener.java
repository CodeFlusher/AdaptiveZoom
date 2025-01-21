package me.codeflusher.adaptivezoom.events;

import me.codeflusher.adaptivezoom.data.ScrollData;
import me.codeflusher.adaptivezoom.data.SensMode;
import me.codeflusher.adaptivezoom.data.ToggledData;
import me.codeflusher.adaptivezoom.settings.ModKeyBinds;
import me.codeflusher.adaptivezoom.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Mouse;

public class TickEventListener {

    private boolean toggledButton = false;

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (!ModKeyBinds.toggleMode.isKeyDown() || !(ModKeyBinds.zoom.isKeyDown())) {
                toggledButton = false;
                return;
            }

            if (ModKeyBinds.toggleMode.isKeyDown() && ModKeyBinds.zoom.isKeyDown() && !toggledButton) {
                SensMode mode = ToggledData.toggle();
                Minecraft.getMinecraft().thePlayer.sendChatMessage(mode.getTranslated());
                toggledButton = true;
            }

        }
    }
}

