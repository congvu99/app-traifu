package io.intercom.android.sdk;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lio/intercom/android/sdk/IntercomError;", "", "errorCode", "", "errorMessage", "", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomStatusCallback.kt */
public final class IntercomError {
    public static final int $stable = 0;
    private final int errorCode;
    private final String errorMessage;

    public IntercomError() {
        this(0, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ IntercomError copy$default(IntercomError intercomError, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = intercomError.errorCode;
        }
        if ((i2 & 2) != 0) {
            str = intercomError.errorMessage;
        }
        return intercomError.copy(i, str);
    }

    public final int component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final IntercomError copy(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        return new IntercomError(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntercomError)) {
            return false;
        }
        IntercomError intercomError = (IntercomError) obj;
        return this.errorCode == intercomError.errorCode && Intrinsics.areEqual((Object) this.errorMessage, (Object) intercomError.errorMessage);
    }

    public int hashCode() {
        return (this.errorCode * 31) + this.errorMessage.hashCode();
    }

    public String toString() {
        return "IntercomError(errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ')';
    }

    public IntercomError(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        this.errorCode = i;
        this.errorMessage = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IntercomError(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str);
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }
}
