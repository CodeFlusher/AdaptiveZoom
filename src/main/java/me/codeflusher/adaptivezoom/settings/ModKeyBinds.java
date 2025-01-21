package me.codeflusher.adaptivezoom.settings;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class ModKeyBinds {

    public static KeyBinding zoom;
    public static KeyBinding toggleMode;

    public static void init(){
        zoom = new KeyBinding("key.adaptivezoom.zoom", Keyboard.KEY_C, "key.categories.adaptivezoom");
        toggleMode = new KeyBinding("key.adaptivezoom.toggle", Keyboard.KEY_TAB, "key.categories.adaptivezoom");
        ClientRegistry.registerKeyBinding(zoom);
        ClientRegistry.registerKeyBinding(toggleMode);
    }

}
