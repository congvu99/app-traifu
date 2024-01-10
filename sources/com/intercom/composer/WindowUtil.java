package com.intercom.composer;

import android.view.Window;
import androidx.core.content.ContextCompat;

public class WindowUtil {
    public static void setFullscreenWindow(Window window, int i) {
        window.getDecorView().setSystemUiVisibility(1280);
        setStatusBarColorRes(window, i);
    }

    private static void setStatusBarColor(Window window, int i) {
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i);
    }

    private static void setStatusBarColorRes(Window window, int i) {
        setStatusBarColor(window, ContextCompat.getColor(window.getContext(), i));
    }
}
