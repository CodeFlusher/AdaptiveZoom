package me.codeflusher.adaptivezoom;

import me.codeflusher.adaptivezoom.events.TickEventListener;
import me.codeflusher.adaptivezoom.settings.ModKeyBinds;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "adaptivezoom", useMetadata=true)
public class AdaptiveZoom {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModKeyBinds.init();
        MinecraftForge.EVENT_BUS.register(new TickEventListener());
    }


}
