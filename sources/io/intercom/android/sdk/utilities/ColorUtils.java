package io.intercom.android.sdk.utilities;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;

public class ColorUtils {
    private static final double ACCESSIBILITY_CONTRAST_RATIO = 4.5d;
    private static final float BRIGHTNESS_CUTOFF = 0.7f;
    private static final char COLOR_PREFIX = '#';
    private static final String SHORT_COLOR_REGEX = String.format("%s([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])", new Object[]{Character.valueOf(COLOR_PREFIX)});
    private static final int SHORT_COLOR_WITH_PREFIX_LENGTH = 4;

    public static boolean isColorLight(String str) {
        return androidx.core.graphics.ColorUtils.calculateLuminance(Color.parseColor(str)) > 0.699999988079071d;
    }

    public static boolean isColorLight(int i) {
        return 1.05d / (androidx.core.graphics.ColorUtils.calculateLuminance(i) + 0.05d) < ACCESSIBILITY_CONTRAST_RATIO;
    }

    public static boolean isComparedColorsLowerThanAccessibilityContrastRatio(int i, int i2) {
        return androidx.core.graphics.ColorUtils.calculateContrast(i, i2) < ACCESSIBILITY_CONTRAST_RATIO;
    }

    public static int lightenColor(int i) {
        return Color.argb(Color.alpha(i), (Color.red(i) + 255) / 2, (Color.green(i) + 255) / 2, (Color.blue(i) + 255) / 2);
    }

    private static int lightenColor(int i, float f) {
        float[] fArr = new float[3];
        androidx.core.graphics.ColorUtils.colorToHSL(i, fArr);
        fArr[2] = fArr[2] + f;
        fArr[2] = Math.max(0.0f, Math.min(fArr[2], 1.0f));
        return androidx.core.graphics.ColorUtils.HSLToColor(fArr);
    }

    public static int darkenColor(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[2] = fArr[2] * 0.79f;
        return Color.HSVToColor(fArr);
    }

    private static int darkenColor(int i, float f) {
        float[] fArr = new float[3];
        androidx.core.graphics.ColorUtils.colorToHSL(i, fArr);
        fArr[2] = fArr[2] - f;
        fArr[2] = Math.max(0.0f, Math.min(fArr[2], 1.0f));
        return androidx.core.graphics.ColorUtils.HSLToColor(fArr);
    }

    public static int buttonTextColorVariant(int i) {
        float[] fArr = new float[3];
        androidx.core.graphics.ColorUtils.colorToHSL(i, fArr);
        float f = fArr[2];
        float f2 = f - 0.3f;
        double d = (double) f;
        if (d > 0.9d) {
            return darkenColor(i, f2);
        }
        if (d < 0.35d) {
            return i;
        }
        return darkenColor(i, f2);
    }

    public static int buttonBackgroundColorVariant(int i) {
        float[] fArr = new float[3];
        androidx.core.graphics.ColorUtils.colorToHSL(i, fArr);
        float f = fArr[2];
        float f2 = 0.95f - f;
        float f3 = f - 0.85f;
        double d = (double) f;
        if (d > 0.9d) {
            return darkenColor(i, f3);
        }
        if (d < 0.35d) {
            return lightenColor(i, f2);
        }
        return lightenColor(i, f2);
    }

    public static ColorFilter newGreyscaleFilter() {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        return new ColorMatrixColorFilter(colorMatrix);
    }

    public static void setTextColorWhiteOrBlack(TextView textView, boolean z) {
        int whiteOrBlackColor = whiteOrBlackColor(textView.getContext(), z);
        textView.setTextColor(whiteOrBlackColor);
        textView.setLinkTextColor(whiteOrBlackColor);
    }

    public static void setTextColorWhiteOrDark(TextView textView, boolean z) {
        int whiteOrDarkColor = whiteOrDarkColor(textView.getContext(), z);
        textView.setTextColor(whiteOrDarkColor);
        textView.setLinkTextColor(whiteOrDarkColor);
    }

    public static void setTextColorPrimaryOrDark(TextView textView, AppConfig appConfig) {
        int primaryOrDarkColor = primaryOrDarkColor(textView.getContext(), appConfig);
        textView.setTextColor(primaryOrDarkColor);
        textView.setLinkTextColor(primaryOrDarkColor);
    }

    public static void setTextColorPrimaryOrBlack(TextView textView, AppConfig appConfig) {
        int primaryOrBlackColor = primaryOrBlackColor(textView.getContext(), appConfig);
        textView.setTextColor(primaryOrBlackColor);
        textView.setLinkTextColor(primaryOrBlackColor);
    }

    public static int primaryOrGreyAccessibility(Context context, AppConfig appConfig) {
        if (isColorLight(appConfig.getPrimaryColor())) {
            return ContextCompat.getColor(context, R.color.intercom_accessibility_grey);
        }
        return appConfig.getPrimaryColor();
    }

    public static int primaryOrBlackAccessibility(Context context, AppConfig appConfig) {
        if (isColorLight(appConfig.getPrimaryColor())) {
            return ContextCompat.getColor(context, R.color.intercom_accessibility_black);
        }
        return appConfig.getPrimaryColor();
    }

    public static int whiteOrBlackAccessibility(Context context, AppConfig appConfig) {
        if (isColorLight(appConfig.getPrimaryColor())) {
            return ContextCompat.getColor(context, R.color.intercom_accessibility_black);
        }
        return ContextCompat.getColor(context, R.color.intercom_white);
    }

    public static int primaryOrDarkColor(Context context, AppConfig appConfig) {
        if (appConfig.primaryColorRenderDarkText()) {
            return ContextCompat.getColor(context, darkColorRes());
        }
        return appConfig.getPrimaryColor();
    }

    public static Drawable getCloseBackground(Context context, AppConfig appConfig) {
        if (!appConfig.secondaryColorRenderDarkText()) {
            return ContextCompat.getDrawable(context, R.drawable.intercom_transparent_dark_circle);
        }
        return ContextCompat.getDrawable(context, R.drawable.intercom_transparent_light_circle);
    }

    private static int primaryOrBlackColor(Context context, AppConfig appConfig) {
        if (appConfig.primaryColorRenderDarkText()) {
            return ContextCompat.getColor(context, R.color.intercom_black);
        }
        return appConfig.getPrimaryColor();
    }

    public static int whiteOrDarkColor(Context context, boolean z) {
        if (z) {
            return ContextCompat.getColor(context, darkColorRes());
        }
        return ContextCompat.getColor(context, R.color.intercom_white);
    }

    public static int whiteOrBlackColor(Context context, boolean z) {
        int i;
        if (z) {
            i = R.color.intercom_accessibility_black;
        } else {
            i = R.color.intercom_white;
        }
        return ContextCompat.getColor(context, i);
    }

    public static void setImageColorWhiteOrBlack(ImageView imageView, boolean z) {
        imageView.setColorFilter(whiteOrBlackColor(imageView.getContext(), z));
    }

    public static void setImageSrcColorWhiteOrDark(ImageView imageView, boolean z) {
        int color = ContextCompat.getColor(imageView.getContext(), z ? darkColorRes() : R.color.intercom_white);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        }
    }

    public static void updateLeftDrawableColorAccordingToBrightness(TextView textView, int i) {
        if (isColorLight(i)) {
            i = ContextCompat.getColor(textView.getContext(), R.color.intercom_accessibility_black);
        }
        updateLeftDrawableColor(textView, i);
    }

    public static void updateLeftDrawableColorAccordingToContrast(TextView textView, int i, int i2) {
        if (isComparedColorsLowerThanAccessibilityContrastRatio(i, i2)) {
            if (isColorLight(i)) {
                ContextCompat.getColor(textView.getContext(), R.color.intercom_accessibility_black);
            } else {
                ContextCompat.getColor(textView.getContext(), R.color.intercom_white);
            }
        }
        updateLeftDrawableColor(textView, i);
    }

    public static void updateLeftDrawableColor(TextView textView, int i) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            }
        }
        for (Drawable drawable2 : textView.getCompoundDrawablesRelative()) {
            if (drawable2 != null) {
                drawable2.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            }
        }
    }

    public static int parseColor(String str) {
        if (str.length() == 4 && str.charAt(0) == '#') {
            str = str.replaceAll(SHORT_COLOR_REGEX, String.format("%s$1$1$2$2$3$3", new Object[]{Character.valueOf(COLOR_PREFIX)}));
        }
        return Color.parseColor(str);
    }

    public static int adjustAlpha(int i, float f) {
        return Color.argb(Math.round(((float) Color.alpha(i)) * f), Color.red(i), Color.green(i), Color.blue(i));
    }

    private static int darkColorRes() {
        return R.color.intercom_accessibility_black;
    }
}
