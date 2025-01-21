package me.codeflusher.adaptivezoom.data;

import me.codeflusher.adaptivezoom.config.ModConfig;

import java.util.ArrayList;
import java.util.List;

public class ToggledData {

    public static final SensMode[] sensModes = new SensMode[

            ]{
            new SensMode((scroll) -> 1, "ui.adaptivezoom.scrollmode.none"),
            new SensMode((scroll) -> scroll * 2, "ui.adaptivezoom.scrollmode.linear.2"),
            new SensMode((scroll) -> scroll * 3, "ui.adaptivezoom.scrollmode.linear.3"),
            new SensMode((scroll) -> scroll * 4, "ui.adaptivezoom.scrollmode.linear.4"),
            new SensMode((scroll) -> (float) Math.pow(2, scroll), "ui.adaptivezoom.scrollmode.exponential.2"),
            new SensMode((scroll) -> (float) Math.pow(3, scroll), "ui.adaptivezoom.scrollmode.exponential.3"),
            new SensMode((scroll) -> (float) Math.pow(4, scroll), "ui.adaptivezoom.scrollmode.exponential.4"),
    };
    private static List<Integer> availableModes;
    private static int mode = 0;

    public static void reload(){
        availableModes = new ArrayList<>();
        availableModes.add(0);
        if (ModConfig.useLinear2) {
            availableModes.add(1);
        }
        if (ModConfig.useLinear3) {
            availableModes.add(2);
        }
        if (ModConfig.useLinear4) {
            availableModes.add(3);
        }
        if (ModConfig.useExponent2) {
            availableModes.add(4);
        }
        if (ModConfig.useExponent3) {
            availableModes.add(5);
        }
        if (ModConfig.useExponent4) {
            availableModes.add(6);
        }

        mode = availableModes.indexOf(ModConfig.currentMode);

        if (mode == -1) {
            mode = 0;
        }
    }

    static {
        reload();
    }


    public static SensMode toggle() {
        mode++;
        if (mode >= availableModes.size()) {
            mode = 0;
        }
        ModConfig.currentMode = availableModes.get(mode);
        ModConfig.save();
        return getMode();
    }

    public static SensMode getMode() {
        return sensModes[availableModes.get(mode)];
    }

}
