package com.uploadcare.android.widget.utils;

import androidx.fragment.app.FragmentManager;
import com.uploadcare.android.widget.controller.FileType;
import com.uploadcare.android.widget.data.SocialSource;
import com.uploadcare.android.widget.dialogs.ProgressDialog;
import com.uploadcare.android.widget.dialogs.SocialSourcesDialog;
import com.uploadcare.android.widget.viewmodels.ProgressData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/uploadcare/android/widget/utils/NavigationHelper;", "", "()V", "Companion", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: NavigationHelper.kt */
public final class NavigationHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    private NavigationHelper() {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ,\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015¨\u0006\u0016"}, d2 = {"Lcom/uploadcare/android/widget/utils/NavigationHelper$Companion;", "", "()V", "dismissProgressDialog", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "dismissSocialSourcesDialog", "showProgressDialog", "progressData", "Lcom/uploadcare/android/widget/viewmodels/ProgressData;", "showSocialSourcesDialog", "sources", "", "Lcom/uploadcare/android/widget/data/SocialSource;", "title", "", "fileType", "Lcom/uploadcare/android/widget/controller/FileType;", "updateProgressDialogProgress", "progress", "", "widget_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: NavigationHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void showProgressDialog(FragmentManager fragmentManager, ProgressData progressData) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(progressData, "progressData");
            if (((ProgressDialog) fragmentManager.findFragmentByTag(Reflection.getOrCreateKotlinClass(ProgressDialog.class).getSimpleName())) == null && !fragmentManager.isStateSaved()) {
                ProgressDialog.Companion.newInstance(progressData).show(fragmentManager, Reflection.getOrCreateKotlinClass(ProgressDialog.class).getSimpleName());
            }
        }

        public final void dismissProgressDialog(FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            ProgressDialog progressDialog = (ProgressDialog) fragmentManager.findFragmentByTag(Reflection.getOrCreateKotlinClass(ProgressDialog.class).getSimpleName());
            if (progressDialog != null) {
                progressDialog.dismissAllowingStateLoss();
            }
        }

        public final void updateProgressDialogProgress(FragmentManager fragmentManager, int i) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            ProgressDialog progressDialog = (ProgressDialog) fragmentManager.findFragmentByTag(Reflection.getOrCreateKotlinClass(ProgressDialog.class).getSimpleName());
            if (progressDialog != null) {
                progressDialog.updateProgress(i);
            }
        }

        public final void showSocialSourcesDialog(FragmentManager fragmentManager, List<SocialSource> list, String str, FileType fileType) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(list, "sources");
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(fileType, "fileType");
            if (((SocialSourcesDialog) fragmentManager.findFragmentByTag(Reflection.getOrCreateKotlinClass(SocialSourcesDialog.class).getSimpleName())) == null && !fragmentManager.isStateSaved()) {
                SocialSourcesDialog.Companion.newInstance(list, str, fileType).show(fragmentManager, Reflection.getOrCreateKotlinClass(SocialSourcesDialog.class).getSimpleName());
            }
        }

        public final void dismissSocialSourcesDialog(FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            SocialSourcesDialog socialSourcesDialog = (SocialSourcesDialog) fragmentManager.findFragmentByTag(Reflection.getOrCreateKotlinClass(SocialSourcesDialog.class).getSimpleName());
            if (socialSourcesDialog != null) {
                socialSourcesDialog.dismissAllowingStateLoss();
            }
        }
    }
}
