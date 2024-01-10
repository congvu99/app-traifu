package com.facebook.rebound;

import com.github.mikephil.charting.utils.Utils;

public class OrigamiValueConverter {
    public static double frictionFromOrigamiValue(double d) {
        return d == Utils.DOUBLE_EPSILON ? Utils.DOUBLE_EPSILON : 25.0d + ((d - 8.0d) * 3.0d);
    }

    public static double origamiValueFromFriction(double d) {
        return d == Utils.DOUBLE_EPSILON ? Utils.DOUBLE_EPSILON : 8.0d + ((d - 25.0d) / 3.0d);
    }

    public static double origamiValueFromTension(double d) {
        return d == Utils.DOUBLE_EPSILON ? Utils.DOUBLE_EPSILON : 30.0d + ((d - 194.0d) / 3.62d);
    }

    public static double tensionFromOrigamiValue(double d) {
        return d == Utils.DOUBLE_EPSILON ? Utils.DOUBLE_EPSILON : 194.0d + ((d - 30.0d) * 3.62d);
    }
}
