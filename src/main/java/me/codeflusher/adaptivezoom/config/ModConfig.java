package me.codeflusher.adaptivezoom.config;

import me.codeflusher.adaptivezoom.data.ToggledData;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class ModConfig {
    public static boolean useLinear2 = true;
    public static boolean useLinear3 = true;
    public static boolean useLinear4 = true;
    public static boolean useExponent2 = true;
    public static boolean useExponent3 = true;
    public static boolean useExponent4 = true;

    public static int currentMode = 0;

    private static Configuration config;

    public static void init(FMLPreInitializationEvent event) {
        File configFile = new File(event.getModConfigurationDirectory(), "adaptivezoom/config.cfg");
        config = new Configuration(configFile);

        try {
            config.load();

            useLinear2 = config.getBoolean("Use linear with factor 2", "general", true, "Defines usage of linear sensitivity decrease");
            useLinear3 = config.getBoolean("Use linear with factor 3", "general", true, "Defines usage of linear sensitivity decrease");
            useLinear4 = config.getBoolean("Use linear with factor 4", "general", true, "Defines usage of linear sensitivity decrease");
            useExponent2 = config.getBoolean("Use exponential with base 2", "general", true, "Defines usage of exponential sensitivity decrease");
            useExponent3 = config.getBoolean("Use exponential with base 3", "general", true, "Defines usage of exponential sensitivity decrease");
            useExponent4 = config.getBoolean("Use exponential with base 4", "general", true, "Defines usage of exponential sensitivity decrease");
            currentMode = config.getInt("Current mode", "general", 0, 0, ToggledData.sensModes.length - 1, "Current used mode");
        } catch (Exception e) {
            System.err.println("[AdaptiveZoom] Error in config file: " + e.getMessage());
        } finally {
            if (config.hasChanged()) config.save();
        }
    }

    public static void save() {
        config.get("general", "Use linear with factor 2", true).set(useLinear2);
        config.get("general", "Use linear with factor 3", true).set(useLinear3);
        config.get("general", "Use linear with factor 4", true).set(useLinear4);

        config.get("general", "Use exponential with base 2", true).set(useExponent2);
        config.get("general", "Use exponential with base 3", true).set(useExponent3);
        config.get("general", "Use exponential with base 4", true).set(useExponent4);

        config.get("general", "Current mode", 0).set(currentMode);

        config.save();
    }

}
