package com.uploadcare.android.widget.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavArgs;
import com.uploadcare.android.widget.data.SocialSource;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001 B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006!"}, d2 = {"Lcom/uploadcare/android/widget/fragment/UploadcareFilesFragmentArgs;", "Landroidx/navigation/NavArgs;", "socialsource", "Lcom/uploadcare/android/widget/data/SocialSource;", "store", "", "cancelable", "showProgress", "backgroundUpload", "(Lcom/uploadcare/android/widget/data/SocialSource;ZZZZ)V", "getBackgroundUpload", "()Z", "getCancelable", "getShowProgress", "getSocialsource", "()Lcom/uploadcare/android/widget/data/SocialSource;", "getStore", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toString", "", "Companion", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareFilesFragmentArgs.kt */
public final class UploadcareFilesFragmentArgs implements NavArgs {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean backgroundUpload;
    private final boolean cancelable;
    private final boolean showProgress;
    private final SocialSource socialsource;
    private final boolean store;

    public static /* synthetic */ UploadcareFilesFragmentArgs copy$default(UploadcareFilesFragmentArgs uploadcareFilesFragmentArgs, SocialSource socialSource, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            socialSource = uploadcareFilesFragmentArgs.socialsource;
        }
        if ((i & 2) != 0) {
            z = uploadcareFilesFragmentArgs.store;
        }
        boolean z5 = z;
        if ((i & 4) != 0) {
            z2 = uploadcareFilesFragmentArgs.cancelable;
        }
        boolean z6 = z2;
        if ((i & 8) != 0) {
            z3 = uploadcareFilesFragmentArgs.showProgress;
        }
        boolean z7 = z3;
        if ((i & 16) != 0) {
            z4 = uploadcareFilesFragmentArgs.backgroundUpload;
        }
        return uploadcareFilesFragmentArgs.copy(socialSource, z5, z6, z7, z4);
    }

    @JvmStatic
    public static final UploadcareFilesFragmentArgs fromBundle(Bundle bundle) {
        return Companion.fromBundle(bundle);
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

    public final UploadcareFilesFragmentArgs copy(SocialSource socialSource, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(socialSource, "socialsource");
        return new UploadcareFilesFragmentArgs(socialSource, z, z2, z3, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadcareFilesFragmentArgs)) {
            return false;
        }
        UploadcareFilesFragmentArgs uploadcareFilesFragmentArgs = (UploadcareFilesFragmentArgs) obj;
        return Intrinsics.areEqual((Object) this.socialsource, (Object) uploadcareFilesFragmentArgs.socialsource) && this.store == uploadcareFilesFragmentArgs.store && this.cancelable == uploadcareFilesFragmentArgs.cancelable && this.showProgress == uploadcareFilesFragmentArgs.showProgress && this.backgroundUpload == uploadcareFilesFragmentArgs.backgroundUpload;
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
        return "UploadcareFilesFragmentArgs(socialsource=" + this.socialsource + ", store=" + this.store + ", cancelable=" + this.cancelable + ", showProgress=" + this.showProgress + ", backgroundUpload=" + this.backgroundUpload + ")";
    }

    public UploadcareFilesFragmentArgs(SocialSource socialSource, boolean z, boolean z2, boolean z3, boolean z4) {
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
    public /* synthetic */ UploadcareFilesFragmentArgs(SocialSource socialSource, boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(socialSource, (i & 2) != 0 ? true : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4);
    }

    public final boolean getBackgroundUpload() {
        return this.backgroundUpload;
    }

    public final Bundle toBundle() {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/uploadcare/android/widget/fragment/UploadcareFilesFragmentArgs$Companion;", "", "()V", "fromBundle", "Lcom/uploadcare/android/widget/fragment/UploadcareFilesFragmentArgs;", "bundle", "Landroid/os/Bundle;", "widget_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: UploadcareFilesFragmentArgs.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final UploadcareFilesFragmentArgs fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(UploadcareFilesFragmentArgs.class.getClassLoader());
            if (!bundle.containsKey("socialsource")) {
                throw new IllegalArgumentException("Required argument \"socialsource\" is missing and does not have an android:defaultValue");
            } else if (Parcelable.class.isAssignableFrom(SocialSource.class) || Serializable.class.isAssignableFrom(SocialSource.class)) {
                SocialSource socialSource = (SocialSource) bundle.get("socialsource");
                if (socialSource != null) {
                    return new UploadcareFilesFragmentArgs(socialSource, bundle.containsKey("store") ? bundle.getBoolean("store") : true, bundle.containsKey("cancelable") ? bundle.getBoolean("cancelable") : false, bundle.containsKey("showProgress") ? bundle.getBoolean("showProgress") : false, bundle.containsKey("backgroundUpload") ? bundle.getBoolean("backgroundUpload") : false);
                }
                throw new IllegalArgumentException("Argument \"socialsource\" is marked as non-null but was passed a null value.");
            } else {
                throw new UnsupportedOperationException(SocialSource.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
            }
        }
    }
}
