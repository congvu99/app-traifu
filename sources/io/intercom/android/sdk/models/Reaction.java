package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import io.intercom.android.sdk.utilities.NullSafety;

public abstract class Reaction implements Parcelable {
    public static final Parcelable.Creator<Reaction> CREATOR = new Parcelable.Creator<Reaction>() {
        public Reaction createFromParcel(Parcel parcel) {
            return Reaction.create(parcel.readInt(), parcel.readString());
        }

        public Reaction[] newArray(int i) {
            return new Reaction[i];
        }
    };

    public int describeContents() {
        return 0;
    }

    public abstract String getImageUrl();

    public abstract int getIndex();

    public static Reaction create(int i, String str) {
        return new AutoValue_Reaction(i, str);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getIndex());
        parcel.writeString(getImageUrl());
    }

    public static final class Builder {
        String image_url;
        int index;

        public Reaction build() {
            return Reaction.create(this.index, NullSafety.valueOrEmpty(this.image_url));
        }
    }
}
