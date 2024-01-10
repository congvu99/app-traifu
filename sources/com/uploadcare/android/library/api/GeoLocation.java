package com.uploadcare.android.library.api;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/uploadcare/android/library/api/GeoLocation;", "Landroid/os/Parcelable;", "latitude", "", "longitude", "(FF)V", "getLatitude", "()F", "getLongitude", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareFile.kt */
public final class GeoLocation implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final float latitude;
    private final float longitude;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new GeoLocation(parcel.readFloat(), parcel.readFloat());
        }

        public final Object[] newArray(int i) {
            return new GeoLocation[i];
        }
    }

    public static /* synthetic */ GeoLocation copy$default(GeoLocation geoLocation, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = geoLocation.latitude;
        }
        if ((i & 2) != 0) {
            f2 = geoLocation.longitude;
        }
        return geoLocation.copy(f, f2);
    }

    public final float component1() {
        return this.latitude;
    }

    public final float component2() {
        return this.longitude;
    }

    public final GeoLocation copy(float f, float f2) {
        return new GeoLocation(f, f2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GeoLocation)) {
            return false;
        }
        GeoLocation geoLocation = (GeoLocation) obj;
        return Float.compare(this.latitude, geoLocation.latitude) == 0 && Float.compare(this.longitude, geoLocation.longitude) == 0;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.latitude) * 31) + Float.floatToIntBits(this.longitude);
    }

    public String toString() {
        return "GeoLocation(latitude=" + this.latitude + ", longitude=" + this.longitude + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeFloat(this.latitude);
        parcel.writeFloat(this.longitude);
    }

    public GeoLocation(float f, float f2) {
        this.latitude = f;
        this.longitude = f2;
    }

    public final float getLatitude() {
        return this.latitude;
    }

    public final float getLongitude() {
        return this.longitude;
    }
}
