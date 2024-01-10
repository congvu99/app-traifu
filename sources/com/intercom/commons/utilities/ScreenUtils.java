package com.intercom.commons.utilities;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

public class ScreenUtils {
    @Deprecated
    public static int convertDpToPixel(float f, Context context) {
        return dpToPx(f, context);
    }

    public static int dpToPx(float f, Context context) {
        return (int) (f * context.getResources().getDisplayMetrics().density);
    }

    @Deprecated
    public static int convertPixelsToDp(float f, Context context) {
        return pxToDp(f, context);
    }

    public static int pxToDp(float f, Context context) {
        return (int) (f / context.getResources().getDisplayMetrics().density);
    }

    public static Point getScreenDimensions(Context context) {
        Point point = new Point();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getSize(point);
        return point;
    }
}
