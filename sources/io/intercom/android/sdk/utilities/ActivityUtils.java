package io.intercom.android.sdk.utilities;

import android.app.Activity;
import com.intercom.composer.ComposerFragment;
import com.intercom.input.gallery.GalleryInput;
import io.intercom.android.sdk.Intercom;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lio/intercom/android/sdk/utilities/ActivityUtils;", "", "()V", "COMPOSER_INPUT_PACKAGE_NAME", "", "kotlin.jvm.PlatformType", "COMPOSER_PACKAGE_NAME", "INTERCOM_PACKAGES", "", "[Ljava/lang/String;", "PACKAGE_NAME", "isHostActivity", "", "activity", "Landroid/app/Activity;", "isInHostAppPackage", "activityName", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ActivityUtils.kt */
public final class ActivityUtils {
    private static final String COMPOSER_INPUT_PACKAGE_NAME;
    private static final String COMPOSER_PACKAGE_NAME = ComposerFragment.class.getPackage().getName();
    public static final ActivityUtils INSTANCE = new ActivityUtils();
    private static final String[] INTERCOM_PACKAGES;
    private static final String PACKAGE_NAME = Intercom.class.getPackage().getName();

    private ActivityUtils() {
    }

    static {
        String name = GalleryInput.class.getPackage().getName();
        COMPOSER_INPUT_PACKAGE_NAME = name;
        INTERCOM_PACKAGES = new String[]{PACKAGE_NAME, COMPOSER_PACKAGE_NAME, name};
    }

    @JvmStatic
    public static final boolean isHostActivity(Activity activity) {
        if (activity != null) {
            ActivityUtils activityUtils = INSTANCE;
            String name = activity.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "activity.javaClass.name");
            if (activityUtils.isInHostAppPackage(name)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isInHostAppPackage(String str) {
        for (String str2 : INTERCOM_PACKAGES) {
            Intrinsics.checkNotNullExpressionValue(str2, "packageName");
            if (StringsKt.startsWith$default(str, str2, false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }
}
