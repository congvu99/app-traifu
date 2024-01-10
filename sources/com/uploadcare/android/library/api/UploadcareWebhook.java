package com.uploadcare.android.library.api;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.squareup.moshi.Json;
import java.net.URI;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003JS\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006-"}, d2 = {"Lcom/uploadcare/android/library/api/UploadcareWebhook;", "Landroid/os/Parcelable;", "id", "", "event", "", "targetUrl", "Ljava/net/URI;", "isActive", "", "project", "created", "Ljava/util/Date;", "updated", "(ILjava/lang/String;Ljava/net/URI;ZILjava/util/Date;Ljava/util/Date;)V", "getCreated", "()Ljava/util/Date;", "getEvent", "()Ljava/lang/String;", "getId", "()I", "()Z", "getProject", "getTargetUrl", "()Ljava/net/URI;", "getUpdated", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareWebhook.kt */
public final class UploadcareWebhook implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final Date created;
    private final String event;
    private final int id;
    private final boolean isActive;
    private final int project;
    private final URI targetUrl;
    private final Date updated;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new UploadcareWebhook(parcel.readInt(), parcel.readString(), (URI) parcel.readSerializable(), parcel.readInt() != 0, parcel.readInt(), (Date) parcel.readSerializable(), (Date) parcel.readSerializable());
        }

        public final Object[] newArray(int i) {
            return new UploadcareWebhook[i];
        }
    }

    public static /* synthetic */ UploadcareWebhook copy$default(UploadcareWebhook uploadcareWebhook, int i, String str, URI uri, boolean z, int i2, Date date, Date date2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = uploadcareWebhook.id;
        }
        if ((i3 & 2) != 0) {
            str = uploadcareWebhook.event;
        }
        String str2 = str;
        if ((i3 & 4) != 0) {
            uri = uploadcareWebhook.targetUrl;
        }
        URI uri2 = uri;
        if ((i3 & 8) != 0) {
            z = uploadcareWebhook.isActive;
        }
        boolean z2 = z;
        if ((i3 & 16) != 0) {
            i2 = uploadcareWebhook.project;
        }
        int i4 = i2;
        if ((i3 & 32) != 0) {
            date = uploadcareWebhook.created;
        }
        Date date3 = date;
        if ((i3 & 64) != 0) {
            date2 = uploadcareWebhook.updated;
        }
        return uploadcareWebhook.copy(i, str2, uri2, z2, i4, date3, date2);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.event;
    }

    public final URI component3() {
        return this.targetUrl;
    }

    public final boolean component4() {
        return this.isActive;
    }

    public final int component5() {
        return this.project;
    }

    public final Date component6() {
        return this.created;
    }

    public final Date component7() {
        return this.updated;
    }

    public final UploadcareWebhook copy(int i, String str, @Json(name = "target_url") URI uri, @Json(name = "is_active") boolean z, int i2, Date date, Date date2) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_EVENT);
        Intrinsics.checkNotNullParameter(uri, "targetUrl");
        return new UploadcareWebhook(i, str, uri, z, i2, date, date2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadcareWebhook)) {
            return false;
        }
        UploadcareWebhook uploadcareWebhook = (UploadcareWebhook) obj;
        return this.id == uploadcareWebhook.id && Intrinsics.areEqual((Object) this.event, (Object) uploadcareWebhook.event) && Intrinsics.areEqual((Object) this.targetUrl, (Object) uploadcareWebhook.targetUrl) && this.isActive == uploadcareWebhook.isActive && this.project == uploadcareWebhook.project && Intrinsics.areEqual((Object) this.created, (Object) uploadcareWebhook.created) && Intrinsics.areEqual((Object) this.updated, (Object) uploadcareWebhook.updated);
    }

    public int hashCode() {
        int i = this.id * 31;
        String str = this.event;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        URI uri = this.targetUrl;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        boolean z = this.isActive;
        if (z) {
            z = true;
        }
        int i3 = (((hashCode2 + (z ? 1 : 0)) * 31) + this.project) * 31;
        Date date = this.created;
        int hashCode3 = (i3 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.updated;
        if (date2 != null) {
            i2 = date2.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        return "UploadcareWebhook(id=" + this.id + ", event=" + this.event + ", targetUrl=" + this.targetUrl + ", isActive=" + this.isActive + ", project=" + this.project + ", created=" + this.created + ", updated=" + this.updated + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.id);
        parcel.writeString(this.event);
        parcel.writeSerializable(this.targetUrl);
        parcel.writeInt(this.isActive ? 1 : 0);
        parcel.writeInt(this.project);
        parcel.writeSerializable(this.created);
        parcel.writeSerializable(this.updated);
    }

    public UploadcareWebhook(int i, String str, @Json(name = "target_url") URI uri, @Json(name = "is_active") boolean z, int i2, Date date, Date date2) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_EVENT);
        Intrinsics.checkNotNullParameter(uri, "targetUrl");
        this.id = i;
        this.event = str;
        this.targetUrl = uri;
        this.isActive = z;
        this.project = i2;
        this.created = date;
        this.updated = date2;
    }

    public final int getId() {
        return this.id;
    }

    public final String getEvent() {
        return this.event;
    }

    public final URI getTargetUrl() {
        return this.targetUrl;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final int getProject() {
        return this.project;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UploadcareWebhook(int i, String str, URI uri, boolean z, int i2, Date date, Date date2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, uri, z, i2, (i3 & 32) != 0 ? null : date, (i3 & 64) != 0 ? null : date2);
    }

    public final Date getCreated() {
        return this.created;
    }

    public final Date getUpdated() {
        return this.updated;
    }
}
