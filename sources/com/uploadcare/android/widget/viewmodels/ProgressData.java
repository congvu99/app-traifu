package com.uploadcare.android.widget.viewmodels;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/uploadcare/android/widget/viewmodels/ProgressData;", "", "show", "", "message", "", "cancelable", "showProgress", "(ZLjava/lang/String;ZZ)V", "getCancelable", "()Z", "getMessage", "()Ljava/lang/String;", "getShow", "getShowProgress", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareViewModel.kt */
public final class ProgressData {
    private final boolean cancelable;
    private final String message;
    private final boolean show;
    private final boolean showProgress;

    public static /* synthetic */ ProgressData copy$default(ProgressData progressData, boolean z, String str, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = progressData.show;
        }
        if ((i & 2) != 0) {
            str = progressData.message;
        }
        if ((i & 4) != 0) {
            z2 = progressData.cancelable;
        }
        if ((i & 8) != 0) {
            z3 = progressData.showProgress;
        }
        return progressData.copy(z, str, z2, z3);
    }

    public final boolean component1() {
        return this.show;
    }

    public final String component2() {
        return this.message;
    }

    public final boolean component3() {
        return this.cancelable;
    }

    public final boolean component4() {
        return this.showProgress;
    }

    public final ProgressData copy(boolean z, String str, boolean z2, boolean z3) {
        return new ProgressData(z, str, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgressData)) {
            return false;
        }
        ProgressData progressData = (ProgressData) obj;
        return this.show == progressData.show && Intrinsics.areEqual((Object) this.message, (Object) progressData.message) && this.cancelable == progressData.cancelable && this.showProgress == progressData.showProgress;
    }

    public int hashCode() {
        boolean z = this.show;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        String str = this.message;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z3 = this.cancelable;
        if (z3) {
            z3 = true;
        }
        int i2 = (hashCode + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.showProgress;
        if (!z4) {
            z2 = z4;
        }
        return i2 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "ProgressData(show=" + this.show + ", message=" + this.message + ", cancelable=" + this.cancelable + ", showProgress=" + this.showProgress + ")";
    }

    public ProgressData(boolean z, String str, boolean z2, boolean z3) {
        this.show = z;
        this.message = str;
        this.cancelable = z2;
        this.showProgress = z3;
    }

    public final boolean getShow() {
        return this.show;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProgressData(boolean z, String str, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3);
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getCancelable() {
        return this.cancelable;
    }

    public final boolean getShowProgress() {
        return this.showProgress;
    }
}
