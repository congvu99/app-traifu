package com.uploadcare.android.widget.viewmodels;

import com.uploadcare.android.widget.data.SocialSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/uploadcare/android/widget/viewmodels/SocialData;", "", "socialSource", "Lcom/uploadcare/android/widget/data/SocialSource;", "storeUponUpload", "", "cancelable", "showProgress", "backgroundUpload", "(Lcom/uploadcare/android/widget/data/SocialSource;ZZZZ)V", "getBackgroundUpload", "()Z", "getCancelable", "getShowProgress", "getSocialSource", "()Lcom/uploadcare/android/widget/data/SocialSource;", "getStoreUponUpload", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareViewModel.kt */
public final class SocialData {
    private final boolean backgroundUpload;
    private final boolean cancelable;
    private final boolean showProgress;
    private final SocialSource socialSource;
    private final boolean storeUponUpload;

    public static /* synthetic */ SocialData copy$default(SocialData socialData, SocialSource socialSource2, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            socialSource2 = socialData.socialSource;
        }
        if ((i & 2) != 0) {
            z = socialData.storeUponUpload;
        }
        boolean z5 = z;
        if ((i & 4) != 0) {
            z2 = socialData.cancelable;
        }
        boolean z6 = z2;
        if ((i & 8) != 0) {
            z3 = socialData.showProgress;
        }
        boolean z7 = z3;
        if ((i & 16) != 0) {
            z4 = socialData.backgroundUpload;
        }
        return socialData.copy(socialSource2, z5, z6, z7, z4);
    }

    public final SocialSource component1() {
        return this.socialSource;
    }

    public final boolean component2() {
        return this.storeUponUpload;
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

    public final SocialData copy(SocialSource socialSource2, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(socialSource2, "socialSource");
        return new SocialData(socialSource2, z, z2, z3, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SocialData)) {
            return false;
        }
        SocialData socialData = (SocialData) obj;
        return Intrinsics.areEqual((Object) this.socialSource, (Object) socialData.socialSource) && this.storeUponUpload == socialData.storeUponUpload && this.cancelable == socialData.cancelable && this.showProgress == socialData.showProgress && this.backgroundUpload == socialData.backgroundUpload;
    }

    public int hashCode() {
        SocialSource socialSource2 = this.socialSource;
        int hashCode = (socialSource2 != null ? socialSource2.hashCode() : 0) * 31;
        boolean z = this.storeUponUpload;
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
        return "SocialData(socialSource=" + this.socialSource + ", storeUponUpload=" + this.storeUponUpload + ", cancelable=" + this.cancelable + ", showProgress=" + this.showProgress + ", backgroundUpload=" + this.backgroundUpload + ")";
    }

    public SocialData(SocialSource socialSource2, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(socialSource2, "socialSource");
        this.socialSource = socialSource2;
        this.storeUponUpload = z;
        this.cancelable = z2;
        this.showProgress = z3;
        this.backgroundUpload = z4;
    }

    public final SocialSource getSocialSource() {
        return this.socialSource;
    }

    public final boolean getStoreUponUpload() {
        return this.storeUponUpload;
    }

    public final boolean getCancelable() {
        return this.cancelable;
    }

    public final boolean getShowProgress() {
        return this.showProgress;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SocialData(SocialSource socialSource2, boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(socialSource2, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4);
    }

    public final boolean getBackgroundUpload() {
        return this.backgroundUpload;
    }
}
