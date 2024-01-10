package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import io.intercom.android.sdk.utilities.NullSafety;
import java.util.Objects;

public abstract class Avatar implements Parcelable {
    public static final Parcelable.Creator<Avatar> CREATOR = new Parcelable.Creator<Avatar>() {
        public Avatar createFromParcel(Parcel parcel) {
            return Avatar.create(parcel.readString(), parcel.readString());
        }

        public Avatar[] newArray(int i) {
            return new Avatar[i];
        }
    };
    public static final Avatar NULL = create("", "");

    public int describeContents() {
        return 0;
    }

    public abstract String getImageUrl();

    public abstract String getInitials();

    public static Avatar create(String str, String str2) {
        return new AutoValue_Avatar(str, str2);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getImageUrl());
        parcel.writeString(getInitials());
    }

    public static final class Builder {
        String image_url;
        String initials;
        String square_128;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Builder builder = (Builder) obj;
            if (!Objects.equals(this.image_url, builder.image_url) || !Objects.equals(this.initials, builder.initials) || !Objects.equals(this.square_128, builder.square_128)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.image_url, this.initials, this.square_128});
        }

        public Builder withInitials(String str) {
            this.initials = str;
            return this;
        }

        public Builder withImageUrl(String str) {
            this.image_url = str;
            return this;
        }

        public Avatar build() {
            String str = this.image_url;
            if (str == null) {
                str = this.square_128;
            }
            return Avatar.create(NullSafety.valueOrEmpty(str), NullSafety.valueOrEmpty(this.initials));
        }
    }
}
