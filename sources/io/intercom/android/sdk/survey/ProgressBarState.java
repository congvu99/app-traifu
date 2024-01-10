package io.intercom.android.sdk.survey;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lio/intercom/android/sdk/survey/ProgressBarState;", "", "isVisible", "", "progress", "", "(ZF)V", "()Z", "getProgress", "()F", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyViewModel.kt */
public final class ProgressBarState {
    private final boolean isVisible;
    private final float progress;

    public ProgressBarState() {
        this(false, 0.0f, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ProgressBarState copy$default(ProgressBarState progressBarState, boolean z, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            z = progressBarState.isVisible;
        }
        if ((i & 2) != 0) {
            f = progressBarState.progress;
        }
        return progressBarState.copy(z, f);
    }

    public final boolean component1() {
        return this.isVisible;
    }

    public final float component2() {
        return this.progress;
    }

    public final ProgressBarState copy(boolean z, float f) {
        return new ProgressBarState(z, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgressBarState)) {
            return false;
        }
        ProgressBarState progressBarState = (ProgressBarState) obj;
        return this.isVisible == progressBarState.isVisible && Intrinsics.areEqual((Object) Float.valueOf(this.progress), (Object) Float.valueOf(progressBarState.progress));
    }

    public int hashCode() {
        boolean z = this.isVisible;
        if (z) {
            z = true;
        }
        return ((z ? 1 : 0) * true) + Float.floatToIntBits(this.progress);
    }

    public String toString() {
        return "ProgressBarState(isVisible=" + this.isVisible + ", progress=" + this.progress + ')';
    }

    public ProgressBarState(boolean z, float f) {
        this.isVisible = z;
        this.progress = f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProgressBarState(boolean z, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? 0.0f : f);
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final float getProgress() {
        return this.progress;
    }
}
