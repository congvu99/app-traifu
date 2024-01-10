package com.intercom.composer.keyboard;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.intercom.composer.R;

class KeyboardManager implements ViewTreeObserver.OnGlobalLayoutListener, OnKeyboardVisibilityListener {
    private static final String KEY_KEYBOARD_HEIGHT_PORTRAIT = "keyboard_height_portrait";
    private static final String PREFERENCES_NAME = "keyboard";
    private final InputMethodManager inputMethodManager;
    private OnKeyboardVisibilityListener onKeyboardVisibilityListener;
    private final OrientationProvider orientationProvider;
    int previousRelayoutOrientation;
    private final SharedPreferences sharedPreferences;
    boolean wasOpened;
    private final Window window;
    private final WindowManager windowManager;

    KeyboardManager(Activity activity, OrientationProvider orientationProvider2) {
        this(activity.getWindow(), (WindowManager) activity.getSystemService("window"), (InputMethodManager) activity.getSystemService("input_method"), activity.getSharedPreferences(PREFERENCES_NAME, 0), orientationProvider2);
    }

    KeyboardManager(Window window2, WindowManager windowManager2, InputMethodManager inputMethodManager2, SharedPreferences sharedPreferences2, OrientationProvider orientationProvider2) {
        this.window = window2;
        this.windowManager = windowManager2;
        this.inputMethodManager = inputMethodManager2;
        this.sharedPreferences = sharedPreferences2;
        this.orientationProvider = orientationProvider2;
        window2.getDecorView().getRootView().getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    /* access modifiers changed from: package-private */
    public void hideSoftInput(View view) {
        this.inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /* access modifiers changed from: package-private */
    public int getKeyboardHeight(int i) {
        Resources resources = this.window.getContext().getResources();
        if (i != 1) {
            return resources.getDimensionPixelSize(R.dimen.intercom_composer_keyboard_landscape_height);
        }
        return this.sharedPreferences.getInt(KEY_KEYBOARD_HEIGHT_PORTRAIT, resources.getDimensionPixelSize(R.dimen.intercom_composer_keyboard_portrait_height));
    }

    private int getCurrentKeyboardHeight() {
        View decorView = this.window.getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        return (decorView.getRootView().getHeight() - rect.bottom) - getSoftButtonsBarHeight();
    }

    /* access modifiers changed from: package-private */
    public boolean isShowingKeyboard() {
        return getCurrentKeyboardHeight() > 0;
    }

    /* access modifiers changed from: package-private */
    public void removeGlobalLayoutListener() {
        Window window2 = this.window;
        if (window2 != null) {
            window2.getDecorView().getRootView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    private int getSoftButtonsBarHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = this.windowManager.getDefaultDisplay();
        defaultDisplay.getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        defaultDisplay.getRealMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        if (i2 > i) {
            return i2 - i;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void setOnKeyboardVisibilityListener(OnKeyboardVisibilityListener onKeyboardVisibilityListener2) {
        this.onKeyboardVisibilityListener = onKeyboardVisibilityListener2;
    }

    public void onGlobalLayout() {
        int currentKeyboardHeight = getCurrentKeyboardHeight();
        boolean z = currentKeyboardHeight > 0;
        int orientation = this.orientationProvider.getOrientation();
        if (z != this.wasOpened || orientation != this.previousRelayoutOrientation) {
            this.wasOpened = z;
            this.previousRelayoutOrientation = orientation;
            onKeyboardVisibilityChanged(z, currentKeyboardHeight);
            OnKeyboardVisibilityListener onKeyboardVisibilityListener2 = this.onKeyboardVisibilityListener;
            if (onKeyboardVisibilityListener2 != null) {
                onKeyboardVisibilityListener2.onKeyboardVisibilityChanged(z, currentKeyboardHeight);
            }
        }
    }

    public void onKeyboardVisibilityChanged(boolean z, int i) {
        if (z && this.orientationProvider.getOrientation() == 1) {
            this.sharedPreferences.edit().putInt(KEY_KEYBOARD_HEIGHT_PORTRAIT, i).apply();
        }
    }
}
