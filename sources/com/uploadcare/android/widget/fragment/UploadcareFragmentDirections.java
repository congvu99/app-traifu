package com.uploadcare.android.widget.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavDirections;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.data.SocialSource;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/uploadcare/android/widget/fragment/UploadcareFragmentDirections;", "", "()V", "ActionUploadcareFragmentToUploadcareFilesFragment", "Companion", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareFragmentDirections.kt */
public final class UploadcareFragmentDirections {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\t\u0010\u001e\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006!"}, d2 = {"Lcom/uploadcare/android/widget/fragment/UploadcareFragmentDirections$ActionUploadcareFragmentToUploadcareFilesFragment;", "Landroidx/navigation/NavDirections;", "socialsource", "Lcom/uploadcare/android/widget/data/SocialSource;", "store", "", "cancelable", "showProgress", "backgroundUpload", "(Lcom/uploadcare/android/widget/data/SocialSource;ZZZZ)V", "getBackgroundUpload", "()Z", "getCancelable", "getShowProgress", "getSocialsource", "()Lcom/uploadcare/android/widget/data/SocialSource;", "getStore", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "getActionId", "", "getArguments", "Landroid/os/Bundle;", "hashCode", "toString", "", "widget_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: UploadcareFragmentDirections.kt */
    private static final class ActionUploadcareFragmentToUploadcareFilesFragment implements NavDirections {
        private final boolean backgroundUpload;
        private final boolean cancelable;
        private final boolean showProgress;
        private final SocialSource socialsource;
        private final boolean store;

        public static /* synthetic */ ActionUploadcareFragmentToUploadcareFilesFragment copy$default(ActionUploadcareFragmentToUploadcareFilesFragment actionUploadcareFragmentToUploadcareFilesFragment, SocialSource socialSource, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                socialSource = actionUploadcareFragmentToUploadcareFilesFragment.socialsource;
            }
            if ((i & 2) != 0) {
                z = actionUploadcareFragmentToUploadcareFilesFragment.store;
            }
            boolean z5 = z;
            if ((i & 4) != 0) {
                z2 = actionUploadcareFragmentToUploadcareFilesFragment.cancelable;
            }
            boolean z6 = z2;
            if ((i & 8) != 0) {
                z3 = actionUploadcareFragmentToUploadcareFilesFragment.showProgress;
            }
            boolean z7 = z3;
            if ((i & 16) != 0) {
                z4 = actionUploadcareFragmentToUploadcareFilesFragment.backgroundUpload;
            }
            return actionUploadcareFragmentToUploadcareFilesFragment.copy(socialSource, z5, z6, z7, z4);
        }

        public final SocialSource component1() {
            return this.socialsource;
        }

        public final boolean component2() {
            return this.store;
        }

        public final boolean component3() {
            return this.cancelable;
        }

        public final boolean component4() {
            return this.showProgress;
        }

        public final boolean component5() {
            return this.backgroundUpload;
        }

        public final ActionUploadcareFragmentToUploadcareFilesFragment copy(SocialSource socialSource, boolean z, boolean z2, boolean z3, boolean z4) {
            Intrinsics.checkNotNullParameter(socialSource, "socialsource");
            return new ActionUploadcareFragmentToUploadcareFilesFragment(socialSource, z, z2, z3, z4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionUploadcareFragmentToUploadcareFilesFragment)) {
                return false;
            }
            ActionUploadcareFragmentToUploadcareFilesFragment actionUploadcareFragmentToUploadcareFilesFragment = (ActionUploadcareFragmentToUploadcareFilesFragment) obj;
            return Intrinsics.areEqual((Object) this.socialsource, (Object) actionUploadcareFragmentToUploadcareFilesFragment.socialsource) && this.store == actionUploadcareFragmentToUploadcareFilesFragment.store && this.cancelable == actionUploadcareFragmentToUploadcareFilesFragment.cancelable && this.showProgress == actionUploadcareFragmentToUploadcareFilesFragment.showProgress && this.backgroundUpload == actionUploadcareFragmentToUploadcareFilesFragment.backgroundUpload;
        }

        public int hashCode() {
            SocialSource socialSource = this.socialsource;
            int hashCode = (socialSource != null ? socialSource.hashCode() : 0) * 31;
            boolean z = this.store;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int i = (hashCode + (z ? 1 : 0)) * 31;
            boolean z3 = this.cancelable;
            if (z3) {
                z3 = true;
            }
            int i2 = (i + (z3 ? 1 : 0)) * 31;
            boolean z4 = this.showProgress;
            if (z4) {
                z4 = true;
            }
            int i3 = (i2 + (z4 ? 1 : 0)) * 31;
            boolean z5 = this.backgroundUpload;
            if (!z5) {
                z2 = z5;
            }
            return i3 + (z2 ? 1 : 0);
        }

        public String toString() {
            return "ActionUploadcareFragmentToUploadcareFilesFragment(socialsource=" + this.socialsource + ", store=" + this.store + ", cancelable=" + this.cancelable + ", showProgress=" + this.showProgress + ", backgroundUpload=" + this.backgroundUpload + ")";
        }

        public ActionUploadcareFragmentToUploadcareFilesFragment(SocialSource socialSource, boolean z, boolean z2, boolean z3, boolean z4) {
            Intrinsics.checkNotNullParameter(socialSource, "socialsource");
            this.socialsource = socialSource;
            this.store = z;
            this.cancelable = z2;
            this.showProgress = z3;
            this.backgroundUpload = z4;
        }

        public final SocialSource getSocialsource() {
            return this.socialsource;
        }

        public final boolean getStore() {
            return this.store;
        }

        public final boolean getCancelable() {
            return this.cancelable;
        }

        public final boolean getShowProgress() {
            return this.showProgress;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ActionUploadcareFragmentToUploadcareFilesFragment(SocialSource socialSource, boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(socialSource, (i & 2) != 0 ? true : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4);
        }

        public final boolean getBackgroundUpload() {
            return this.backgroundUpload;
        }

        public int getActionId() {
            return R.id.action_uploadcareFragment_to_uploadcareFilesFragment;
        }

        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            if (Parcelable.class.isAssignableFrom(SocialSource.class)) {
                SocialSource socialSource = this.socialsource;
                if (socialSource != null) {
                    bundle.putParcelable("socialsource", socialSource);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.os.Parcelable");
                }
            } else if (Serializable.class.isAssignableFrom(SocialSource.class)) {
                SocialSource socialSource2 = this.socialsource;
                if (socialSource2 != null) {
                    bundle.putSerializable("socialsource", (Serializable) socialSource2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.io.Serializable");
                }
            } else {
                throw new UnsupportedOperationException(SocialSource.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
            }
            bundle.putBoolean("store", this.store);
            bundle.putBoolean("cancelable", this.cancelable);
            bundle.putBoolean("showProgress", this.showProgress);
            bundle.putBoolean("backgroundUpload", this.backgroundUpload);
            return bundle;
        }
    }

    private UploadcareFragmentDirections() {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/uploadcare/android/widget/fragment/UploadcareFragmentDirections$Companion;", "", "()V", "actionUploadcareFragmentToUploadcareFilesFragment", "Landroidx/navigation/NavDirections;", "socialsource", "Lcom/uploadcare/android/widget/data/SocialSource;", "store", "", "cancelable", "showProgress", "backgroundUpload", "widget_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: UploadcareFragmentDirections.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NavDirections actionUploadcareFragmentToUploadcareFilesFragment$default(Companion companion, SocialSource socialSource, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            return companion.actionUploadcareFragmentToUploadcareFilesFragment(socialSource, (i & 2) != 0 ? true : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4);
        }

        public final NavDirections actionUploadcareFragmentToUploadcareFilesFragment(SocialSource socialSource, boolean z, boolean z2, boolean z3, boolean z4) {
            Intrinsics.checkNotNullParameter(socialSource, "socialsource");
            return new ActionUploadcareFragmentToUploadcareFilesFragment(socialSource, z, z2, z3, z4);
        }
    }
}
