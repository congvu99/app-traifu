package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import io.intercom.android.sdk.utilities.NullSafety;

public abstract class Location implements Parcelable {
    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {
        public Location createFromParcel(Parcel parcel) {
            return Location.create(parcel.readString(), parcel.readString(), parcel.readByte() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        public Location[] newArray(int i) {
            return new Location[i];
        }
    };

    public int describeContents() {
        return 0;
    }

    public abstract String getCityName();

    public abstract String getCountryName();

    public abstract Integer getTimezoneOffset();

    public static Location create(String str, String str2, Integer num) {
        return new AutoValue_Location(str, str2, num);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getCityName());
        parcel.writeString(getCountryName());
        Integer timezoneOffset = getTimezoneOffset();
        if (timezoneOffset == null) {
            parcel.writeByte((byte) 0);
            return;
        }
        parcel.writeByte((byte) 1);
        parcel.writeInt(timezoneOffset.intValue());
    }

    public static final class Builder {
        String city_name;
        String country_name;
        Integer timezone_offset;

        public Location build() {
            return Location.create(NullSafety.valueOrEmpty(this.city_name), NullSafety.valueOrEmpty(this.country_name), this.timezone_offset);
        }
    }
}
