package io.intercom.android.sdk.utilities;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lio/intercom/android/sdk/utilities/AccessibilityUtils;", "", "()V", "addClickAbilityAnnouncement", "", "view", "Landroid/view/View;", "addHeadingAnnouncement", "removeClickAbilityAnnouncement", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AccessibilityUtils.kt */
public final class AccessibilityUtils {
    public static final AccessibilityUtils INSTANCE = new AccessibilityUtils();

    private AccessibilityUtils() {
    }

    public final void addClickAbilityAnnouncement(View view) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        ViewCompat.setAccessibilityDelegate(view, new AccessibilityUtils$addClickAbilityAnnouncement$1());
    }

    public final void removeClickAbilityAnnouncement(View view) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        ViewCompat.setAccessibilityDelegate(view, new AccessibilityUtils$removeClickAbilityAnnouncement$1());
    }

    public final void addHeadingAnnouncement(View view) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        ViewCompat.setAccessibilityDelegate(view, new AccessibilityUtils$addHeadingAnnouncement$1());
    }
}
