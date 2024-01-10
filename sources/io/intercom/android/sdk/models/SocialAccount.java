package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import io.intercom.android.sdk.utilities.NullSafety;

public abstract class SocialAccount implements Parcelable {
    public static final Parcelable.Creator<SocialAccount> CREATOR = new Parcelable.Creator<SocialAccount>() {
        public SocialAccount createFromParcel(Parcel parcel) {
            return SocialAccount.create(parcel.readString(), parcel.readString());
        }

        public SocialAccount[] newArray(int i) {
            return new SocialAccount[i];
        }
    };
    public static final SocialAccount NULL = create("", "");

    public int describeContents() {
        return 0;
    }

    public abstract String getProfileUrl();

    public abstract String getProvider();

    public static SocialAccount create(String str, String str2) {
        return new AutoValue_SocialAccount(str, str2);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getProvider());
        parcel.writeString(getProfileUrl());
    }

    public static final class Builder {
        String profile_url;
        String provider;

        public SocialAccount build() {
            return SocialAccount.create(NullSafety.valueOrEmpty(this.provider), NullSafety.valueOrEmpty(this.profile_url));
        }
    }
}
