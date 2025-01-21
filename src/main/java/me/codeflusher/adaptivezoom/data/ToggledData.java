package me.codeflusher.adaptivezoom.data;

public class ToggledData {

    public static final SensMode[] sensModes = new SensMode[

    ]{
            new SensMode((scroll) -> 1, "ui.adaptivezoom.scrollmode.none"),
            new SensMode((scroll) -> scroll*2, "ui.adaptivezoom.scrollmode.linear.2"),
            new SensMode((scroll) -> scroll*3, "ui.adaptivezoom.scrollmode.linear.3"),
            new SensMode((scroll) -> scroll*4, "ui.adaptivezoom.scrollmode.linear.4"),
            new SensMode((scroll) -> (float) Math.pow(2, scroll), "ui.adaptivezoom.scrollmode.exponential.2"),
            new SensMode((scroll) -> (float) Math.pow(3, scroll), "ui.adaptivezoom.scrollmode.exponential.3"),
            new SensMode((scroll) -> (float) Math.pow(4, scroll), "ui.adaptivezoom.scrollmode.exponential.4"),
    };

    private static int mode = 0;

    public static SensMode toggle(){
        mode++;
        if (mode>=sensModes.length){
            mode = 0;
        }
        return sensModes[mode];
    }

    public static SensMode getMode(){
        return sensModes[mode];
    }

}
