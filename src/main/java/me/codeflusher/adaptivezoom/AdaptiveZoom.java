package me.codeflusher.adaptivezoom;

import me.codeflusher.adaptivezoom.config.ModConfig;
import me.codeflusher.adaptivezoom.events.ButtonsEventListener;
import me.codeflusher.adaptivezoom.events.TickEventListener;
import me.codeflusher.adaptivezoom.settings.ModKeyBinds;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "adaptivezoom", useMetadata = true)
public class AdaptiveZoom {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModConfig.init(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModKeyBinds.init();
        MinecraftForge.EVENT_BUS.register(new TickEventListener());
        MinecraftForge.EVENT_BUS.register(new ButtonsEventListener());
    }

}
