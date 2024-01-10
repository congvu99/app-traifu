package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import io.intercom.android.sdk.utilities.NullSafety;

public abstract class Suggestion implements Parcelable {
    public static final Parcelable.Creator<Suggestion> CREATOR = new Parcelable.Creator<Suggestion>() {
        public Suggestion createFromParcel(Parcel parcel) {
            return Suggestion.create(parcel.readString(), parcel.readString(), parcel.readString());
        }

        public Suggestion[] newArray(int i) {
            return new Suggestion[i];
        }
    };

    public int describeContents() {
        return 0;
    }

    public abstract String getPreAction();

    public abstract String getText();

    public abstract String getUuid();

    public static Suggestion create(String str, String str2, String str3) {
        return new AutoValue_Suggestion(str, str2, str3);
    }

    public static final class Builder {
        String pre_action;
        String text;
        String uuid;

        public Builder withPreAction(String str) {
            this.pre_action = str;
            return this;
        }

        public Builder withText(String str) {
            this.text = str;
            return this;
        }

        public Builder withUuid(String str) {
            this.uuid = str;
            return this;
        }

        public Suggestion build() {
            return Suggestion.create(NullSafety.valueOrEmpty(this.pre_action), NullSafety.valueOrEmpty(this.text), NullSafety.valueOrEmpty(this.uuid));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getPreAction());
        parcel.writeString(getText());
        parcel.writeString(getUuid());
    }
}
