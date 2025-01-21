package me.codeflusher.adaptivezoom.utils;

import me.codeflusher.adaptivezoom.data.ScrollData;
import me.codeflusher.adaptivezoom.data.ToggledData;

public class Utils {

    public static float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(max, value));
    }

    public static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }

    public static int computeDelta(int value) {
        float multiplier = ToggledData.getMode().getPredicate().evaluate(ScrollData.getRawScroll());
        return (int) (Math.ceil((Math.abs(value) / multiplier)) * Math.signum(value));
    }

}
