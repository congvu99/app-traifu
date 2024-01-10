package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import io.intercom.android.sdk.utilities.NullSafety;

public abstract class ComposerState implements Parcelable {
    public static final Parcelable.Creator<ComposerState> CREATOR = new Parcelable.Creator<ComposerState>() {
        public ComposerState createFromParcel(Parcel parcel) {
            return ComposerState.create(parcel.readByte() != 0);
        }

        public ComposerState[] newArray(int i) {
            return new ComposerState[i];
        }
    };
    public static final ComposerState NULL = new Builder().build();

    public int describeContents() {
        return 0;
    }

    public abstract boolean isVisible();

    static ComposerState create(boolean z) {
        return new AutoValue_ComposerState(z);
    }

    public static final class Builder {
        Boolean visible;

        public Builder withVisible(Boolean bool) {
            this.visible = bool;
            return this;
        }

        public ComposerState build() {
            return ComposerState.create(NullSafety.valueOrDefault(this.visible, true));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(isVisible() ? (byte) 1 : 0);
    }
}
