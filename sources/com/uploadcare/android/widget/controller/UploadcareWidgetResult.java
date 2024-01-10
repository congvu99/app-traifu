package com.uploadcare.android.widget.controller;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.uploadcare.android.library.api.UploadcareFile;
import com.uploadcare.android.library.exceptions.UploadcareException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\u0006\u0010\u0019\u001a\u00020\u0016J\t\u0010\u001a\u001a\u00020\u0014HÖ\u0001J\u0006\u0010\u001b\u001a\u00020\u0016J\u0006\u0010\u001c\u001a\u00020\u0016J\u0006\u0010\u001d\u001a\u00020\u0016J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006&"}, d2 = {"Lcom/uploadcare/android/widget/controller/UploadcareWidgetResult;", "Landroid/os/Parcelable;", "uploadcareFile", "Lcom/uploadcare/android/library/api/UploadcareFile;", "backgroundUploadUUID", "Ljava/util/UUID;", "exception", "Lcom/uploadcare/android/library/exceptions/UploadcareException;", "(Lcom/uploadcare/android/library/api/UploadcareFile;Ljava/util/UUID;Lcom/uploadcare/android/library/exceptions/UploadcareException;)V", "getBackgroundUploadUUID", "()Ljava/util/UUID;", "getException", "()Lcom/uploadcare/android/library/exceptions/UploadcareException;", "getUploadcareFile", "()Lcom/uploadcare/android/library/api/UploadcareFile;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hasFile", "hashCode", "isBackgroundUpload", "isFailed", "isSuccess", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareWidget.kt */
public final class UploadcareWidgetResult implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final UUID backgroundUploadUUID;
    private final UploadcareException exception;
    private final UploadcareFile uploadcareFile;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new UploadcareWidgetResult((UploadcareFile) parcel.readParcelable(UploadcareWidgetResult.class.getClassLoader()), (UUID) parcel.readSerializable(), (UploadcareException) parcel.readParcelable(UploadcareWidgetResult.class.getClassLoader()));
        }

        public final Object[] newArray(int i) {
            return new UploadcareWidgetResult[i];
        }
    }

    public UploadcareWidgetResult() {
        this((UploadcareFile) null, (UUID) null, (UploadcareException) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UploadcareWidgetResult copy$default(UploadcareWidgetResult uploadcareWidgetResult, UploadcareFile uploadcareFile2, UUID uuid, UploadcareException uploadcareException, int i, Object obj) {
        if ((i & 1) != 0) {
            uploadcareFile2 = uploadcareWidgetResult.uploadcareFile;
        }
        if ((i & 2) != 0) {
            uuid = uploadcareWidgetResult.backgroundUploadUUID;
        }
        if ((i & 4) != 0) {
            uploadcareException = uploadcareWidgetResult.exception;
        }
        return uploadcareWidgetResult.copy(uploadcareFile2, uuid, uploadcareException);
    }

    @JvmStatic
    public static final UploadcareWidgetResult fromIntent(Intent intent) {
        return Companion.fromIntent(intent);
    }

    public final UploadcareFile component1() {
        return this.uploadcareFile;
    }

    public final UUID component2() {
        return this.backgroundUploadUUID;
    }

    public final UploadcareException component3() {
        return this.exception;
    }

    public final UploadcareWidgetResult copy(UploadcareFile uploadcareFile2, UUID uuid, UploadcareException uploadcareException) {
        return new UploadcareWidgetResult(uploadcareFile2, uuid, uploadcareException);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadcareWidgetResult)) {
            return false;
        }
        UploadcareWidgetResult uploadcareWidgetResult = (UploadcareWidgetResult) obj;
        return Intrinsics.areEqual((Object) this.uploadcareFile, (Object) uploadcareWidgetResult.uploadcareFile) && Intrinsics.areEqual((Object) this.backgroundUploadUUID, (Object) uploadcareWidgetResult.backgroundUploadUUID) && Intrinsics.areEqual((Object) this.exception, (Object) uploadcareWidgetResult.exception);
    }

    public int hashCode() {
        UploadcareFile uploadcareFile2 = this.uploadcareFile;
        int i = 0;
        int hashCode = (uploadcareFile2 != null ? uploadcareFile2.hashCode() : 0) * 31;
        UUID uuid = this.backgroundUploadUUID;
        int hashCode2 = (hashCode + (uuid != null ? uuid.hashCode() : 0)) * 31;
        UploadcareException uploadcareException = this.exception;
        if (uploadcareException != null) {
            i = uploadcareException.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "UploadcareWidgetResult(uploadcareFile=" + this.uploadcareFile + ", backgroundUploadUUID=" + this.backgroundUploadUUID + ", exception=" + this.exception + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.uploadcareFile, i);
        parcel.writeSerializable(this.backgroundUploadUUID);
        parcel.writeParcelable(this.exception, i);
    }

    public UploadcareWidgetResult(UploadcareFile uploadcareFile2, UUID uuid, UploadcareException uploadcareException) {
        this.uploadcareFile = uploadcareFile2;
        this.backgroundUploadUUID = uuid;
        this.exception = uploadcareException;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UploadcareWidgetResult(UploadcareFile uploadcareFile2, UUID uuid, UploadcareException uploadcareException, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : uploadcareFile2, (i & 2) != 0 ? null : uuid, (i & 4) != 0 ? null : uploadcareException);
    }

    public final UploadcareFile getUploadcareFile() {
        return this.uploadcareFile;
    }

    public final UUID getBackgroundUploadUUID() {
        return this.backgroundUploadUUID;
    }

    public final UploadcareException getException() {
        return this.exception;
    }

    public final boolean isSuccess() {
        return (this.uploadcareFile == null && this.backgroundUploadUUID == null) ? false : true;
    }

    public final boolean hasFile() {
        return this.uploadcareFile != null;
    }

    public final boolean isBackgroundUpload() {
        return this.backgroundUploadUUID != null;
    }

    public final boolean isFailed() {
        return this.exception != null;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/uploadcare/android/widget/controller/UploadcareWidgetResult$Companion;", "", "()V", "fromIntent", "Lcom/uploadcare/android/widget/controller/UploadcareWidgetResult;", "intent", "Landroid/content/Intent;", "widget_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: UploadcareWidget.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final UploadcareWidgetResult fromIntent(Intent intent) {
            if (intent != null) {
                return (UploadcareWidgetResult) intent.getParcelableExtra("result");
            }
            return null;
        }
    }
}
