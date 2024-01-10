package com.google.android.material.color;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import com.google.android.material.R;
import com.google.android.material.color.DynamicColorsOptions;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DynamicColors {
    private static final DeviceSupportCondition DEFAULT_DEVICE_SUPPORT_CONDITION = new DeviceSupportCondition() {
        public boolean isSupported() {
            return true;
        }
    };
    private static final Map<String, DeviceSupportCondition> DYNAMIC_COLOR_SUPPORTED_BRANDS;
    private static final Map<String, DeviceSupportCondition> DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS;
    private static final int[] DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE = {R.attr.dynamicColorThemeOverlay};
    private static final DeviceSupportCondition SAMSUNG_DEVICE_SUPPORT_CONDITION = new DeviceSupportCondition() {
        private Long version;

        public boolean isSupported() {
            if (this.version == null) {
                try {
                    Method declaredMethod = Build.class.getDeclaredMethod("getLong", new Class[]{String.class});
                    declaredMethod.setAccessible(true);
                    this.version = Long.valueOf(((Long) declaredMethod.invoke((Object) null, new Object[]{"ro.build.version.oneui"})).longValue());
                } catch (Exception unused) {
                    this.version = -1L;
                }
            }
            if (this.version.longValue() >= 40100) {
                return true;
            }
            return false;
        }
    };
    private static final int USE_DEFAULT_THEME_OVERLAY = 0;

    private interface DeviceSupportCondition {
        boolean isSupported();
    }

    public interface OnAppliedCallback {
        void onApplied(Activity activity);
    }

    public interface Precondition {
        boolean shouldApplyDynamicColors(Activity activity, int i);
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("google", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("hmd global", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("infinix", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("infinix mobility limited", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("itel", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("kyocera", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("lenovo", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("lge", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("motorola", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("nothing", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("oneplus", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("oppo", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("realme", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("robolectric", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("samsung", SAMSUNG_DEVICE_SUPPORT_CONDITION);
        hashMap.put("sharp", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("sony", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("tcl", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("tecno", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("tecno mobile limited", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("vivo", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("xiaomi", DEFAULT_DEVICE_SUPPORT_CONDITION);
        DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("asus", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap2.put("jio", DEFAULT_DEVICE_SUPPORT_CONDITION);
        DYNAMIC_COLOR_SUPPORTED_BRANDS = Collections.unmodifiableMap(hashMap2);
    }

    private DynamicColors() {
    }

    public static void applyToActivitiesIfAvailable(Application application) {
        applyToActivitiesIfAvailable(application, new DynamicColorsOptions.Builder().build());
    }

    @Deprecated
    public static void applyToActivitiesIfAvailable(Application application, int i) {
        applyToActivitiesIfAvailable(application, new DynamicColorsOptions.Builder().setThemeOverlay(i).build());
    }

    @Deprecated
    public static void applyToActivitiesIfAvailable(Application application, Precondition precondition) {
        applyToActivitiesIfAvailable(application, new DynamicColorsOptions.Builder().setPrecondition(precondition).build());
    }

    @Deprecated
    public static void applyToActivitiesIfAvailable(Application application, int i, Precondition precondition) {
        applyToActivitiesIfAvailable(application, new DynamicColorsOptions.Builder().setThemeOverlay(i).setPrecondition(precondition).build());
    }

    public static void applyToActivitiesIfAvailable(Application application, DynamicColorsOptions dynamicColorsOptions) {
        application.registerActivityLifecycleCallbacks(new DynamicColorsActivityLifecycleCallbacks(dynamicColorsOptions));
    }

    @Deprecated
    public static void applyIfAvailable(Activity activity) {
        applyToActivityIfAvailable(activity);
    }

    @Deprecated
    public static void applyIfAvailable(Activity activity, int i) {
        applyToActivityIfAvailable(activity, new DynamicColorsOptions.Builder().setThemeOverlay(i).build());
    }

    @Deprecated
    public static void applyIfAvailable(Activity activity, Precondition precondition) {
        applyToActivityIfAvailable(activity, new DynamicColorsOptions.Builder().setPrecondition(precondition).build());
    }

    public static void applyToActivityIfAvailable(Activity activity) {
        applyToActivityIfAvailable(activity, new DynamicColorsOptions.Builder().build());
    }

    public static void applyToActivityIfAvailable(Activity activity, DynamicColorsOptions dynamicColorsOptions) {
        applyToActivityIfAvailable(activity, dynamicColorsOptions.getThemeOverlay(), dynamicColorsOptions.getPrecondition(), dynamicColorsOptions.getOnAppliedCallback());
    }

    /* access modifiers changed from: private */
    public static void applyToActivityIfAvailable(Activity activity, int i, Precondition precondition, OnAppliedCallback onAppliedCallback) {
        if (isDynamicColorAvailable()) {
            if (i == 0) {
                i = getDefaultThemeOverlay(activity);
            }
            if (i != 0 && precondition.shouldApplyDynamicColors(activity, i)) {
                ThemeUtils.applyThemeOverlay(activity, i);
                onAppliedCallback.onApplied(activity);
            }
        }
    }

    public static Context wrapContextIfAvailable(Context context) {
        return wrapContextIfAvailable(context, 0);
    }

    public static Context wrapContextIfAvailable(Context context, int i) {
        if (!isDynamicColorAvailable()) {
            return context;
        }
        if (i == 0) {
            i = getDefaultThemeOverlay(context);
        }
        return i == 0 ? context : new ContextThemeWrapper(context, i);
    }

    public static boolean isDynamicColorAvailable() {
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        DeviceSupportCondition deviceSupportCondition = DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS.get(Build.MANUFACTURER.toLowerCase());
        if (deviceSupportCondition == null) {
            deviceSupportCondition = DYNAMIC_COLOR_SUPPORTED_BRANDS.get(Build.BRAND.toLowerCase());
        }
        if (deviceSupportCondition == null || !deviceSupportCondition.isSupported()) {
            return false;
        }
        return true;
    }

    private static int getDefaultThemeOverlay(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static class DynamicColorsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        private final DynamicColorsOptions dynamicColorsOptions;

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        DynamicColorsActivityLifecycleCallbacks(DynamicColorsOptions dynamicColorsOptions2) {
            this.dynamicColorsOptions = dynamicColorsOptions2;
        }

        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            DynamicColors.applyToActivityIfAvailable(activity, this.dynamicColorsOptions.getThemeOverlay(), this.dynamicColorsOptions.getPrecondition(), this.dynamicColorsOptions.getOnAppliedCallback());
        }
    }
}