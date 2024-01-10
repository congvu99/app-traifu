package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import io.intercom.android.sdk.utilities.NullSafety;

public abstract class ReplyOption implements Parcelable {
    public static final Parcelable.Creator<ReplyOption> CREATOR = new Parcelable.Creator<ReplyOption>() {
        public ReplyOption createFromParcel(Parcel parcel) {
            return ReplyOption.create(parcel.readString(), parcel.readString());
        }

        public ReplyOption[] newArray(int i) {
            return new ReplyOption[i];
        }
    };

    public int describeContents() {
        return 0;
    }

    public abstract String text();

    public abstract String uuid();

    static ReplyOption create(String str, String str2) {
        return new AutoValue_ReplyOption(str, str2);
    }

    public static final class Builder {
        String text;
        String uuid;

        public Builder withText(String str) {
            this.text = str;
            return this;
        }

        public Builder withUuid(String str) {
            this.uuid = str;
            return this;
        }

        public ReplyOption build() {
            return ReplyOption.create(NullSafety.valueOrEmpty(this.text), NullSafety.valueOrEmpty(this.uuid));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(text());
        parcel.writeString(uuid());
    }
}
