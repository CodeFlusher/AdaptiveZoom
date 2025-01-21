package me.codeflusher.adaptivezoom.data;

import me.codeflusher.adaptivezoom.utils.Utils;
import org.lwjgl.input.Mouse;

public class ScrollData {

    private static float scroll = 1.0f;

    public static final float maxScroll = 5.0f;
    public static final float minScroll = 0.5f;

    public static float getRawScroll(){
        return scroll;
    }

    public static float getScroll() {
        scroll = Utils.clamp(scroll + Mouse.getDWheel() / 250f, minScroll, maxScroll);
        return scroll;
    }

}
