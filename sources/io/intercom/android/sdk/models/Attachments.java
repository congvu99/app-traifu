package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import io.intercom.android.sdk.utilities.NullSafety;

public abstract class Attachments implements Parcelable {
    public static final Parcelable.Creator<Attachments> CREATOR = new Parcelable.Creator<Attachments>() {
        public Attachments createFromParcel(Parcel parcel) {
            return Attachments.create(parcel.readString(), parcel.readString(), parcel.readString());
        }

        public Attachments[] newArray(int i) {
            return new Attachments[i];
        }
    };

    public int describeContents() {
        return 0;
    }

    public abstract String getContentType();

    public abstract String getName();

    public abstract String getUrl();

    static Attachments create(String str, String str2, String str3) {
        return new AutoValue_Attachments(str, str2, str3);
    }

    public static final class Builder {
        String content_type;
        String name;
        String url;

        public Attachments build() {
            return Attachments.create(NullSafety.valueOrEmpty(this.name), NullSafety.valueOrEmpty(this.url), NullSafety.valueOrEmpty(this.content_type));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getName());
        parcel.writeString(getUrl());
        parcel.writeString(getContentType());
    }
}
