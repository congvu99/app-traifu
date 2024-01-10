package com.facebook.appevents.codeless.internal;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;

public class SensitiveUserDataUtils {
    public static boolean isSensitiveUserData(View view) {
        Class<SensitiveUserDataUtils> cls = SensitiveUserDataUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            if (!(view instanceof TextView)) {
                return false;
            }
            TextView textView = (TextView) view;
            if (isPassword(textView) || isCreditCard(textView) || isPersonName(textView) || isPostalAddress(textView) || isPhoneNumber(textView) || isEmail(textView)) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    private static boolean isPassword(TextView textView) {
        Class<SensitiveUserDataUtils> cls = SensitiveUserDataUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            if (textView.getInputType() == 128) {
                return true;
            }
            return textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    private static boolean isEmail(TextView textView) {
        Class<SensitiveUserDataUtils> cls = SensitiveUserDataUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            if (textView.getInputType() == 32) {
                return true;
            }
            String textOfView = ViewHierarchy.getTextOfView(textView);
            if (textOfView != null) {
                if (textOfView.length() != 0) {
                    return Patterns.EMAIL_ADDRESS.matcher(textOfView).matches();
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    private static boolean isPersonName(TextView textView) {
        Class<SensitiveUserDataUtils> cls = SensitiveUserDataUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return textView.getInputType() == 96;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    private static boolean isPostalAddress(TextView textView) {
        Class<SensitiveUserDataUtils> cls = SensitiveUserDataUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return textView.getInputType() == 112;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    private static boolean isPhoneNumber(TextView textView) {
        Class<SensitiveUserDataUtils> cls = SensitiveUserDataUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return textView.getInputType() == 3;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    private static boolean isCreditCard(TextView textView) {
        Class<SensitiveUserDataUtils> cls = SensitiveUserDataUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            String replaceAll = ViewHierarchy.getTextOfView(textView).replaceAll("\\s", "");
            int length = replaceAll.length();
            if (length < 12) {
                return false;
            }
            if (length > 19) {
                return false;
            }
            int i = length - 1;
            int i2 = 0;
            boolean z = false;
            while (i >= 0) {
                char charAt = replaceAll.charAt(i);
                if (charAt >= '0') {
                    if (charAt <= '9') {
                        int i3 = charAt - '0';
                        if (z && (i3 = i3 * 2) > 9) {
                            i3 = (i3 % 10) + 1;
                        }
                        i2 += i3;
                        z = !z;
                        i--;
                    }
                }
                return false;
            }
            if (i2 % 10 == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }
}
