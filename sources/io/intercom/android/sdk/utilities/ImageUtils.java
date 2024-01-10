package io.intercom.android.sdk.utilities;

import android.text.TextUtils;
import com.github.mikephil.charting.utils.Utils;

public class ImageUtils {
    public static int getAspectHeight(int i, double d) {
        return (int) (((double) i) * d);
    }

    public static double getAspectRatio(int i, int i2) {
        if (i2 == 0 || i == 0) {
            return 1.0d;
        }
        double d = (((double) i2) * 1.0d) / ((double) i);
        return Double.isNaN(d) ? Utils.DOUBLE_EPSILON : d;
    }

    public static boolean isGif(String str) {
        return !TextUtils.isEmpty(str) && str.endsWith(".gif");
    }
}
