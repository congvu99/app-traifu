package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.utilities.NameUtils;
import io.intercom.android.sdk.utilities.NullSafety;
import java.util.Objects;

public abstract class Participant implements Parcelable {
    public static final String ADMIN_TYPE = "admin";
    public static final Parcelable.Creator<Participant> CREATOR = new Parcelable.Creator<Participant>() {
        public Participant createFromParcel(Parcel parcel) {
            return Participant.create(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Avatar) parcel.readValue(Avatar.class.getClassLoader()), Boolean.valueOf(parcel.readByte() == 0));
        }

        public Participant[] newArray(int i) {
            return new Participant[i];
        }
    };
    public static final Participant NULL = create("", "", "", "", Avatar.create("", ""), false);
    public static final String USER_TYPE = "user";

    public int describeContents() {
        return 0;
    }

    public abstract Avatar getAvatar();

    public abstract String getEmail();

    public abstract String getId();

    public abstract String getName();

    public abstract String getType();

    public abstract Boolean isBot();

    public static Participant create(String str, String str2, String str3, String str4, Avatar avatar, Boolean bool) {
        return new AutoValue_Participant(str, str2, str3, str4, avatar, bool);
    }

    public boolean isAdmin() {
        return ADMIN_TYPE.equals(getType());
    }

    /* access modifiers changed from: package-private */
    public String nameOrEmail() {
        return getName().isEmpty() ? getEmail() : getName();
    }

    public String getForename() {
        return nameOrEmail().trim().split(" ")[0];
    }

    public boolean isUserWithId(String str) {
        return USER_TYPE.equals(getType()) && getId().equals(str);
    }

    public static final class Builder {
        Avatar.Builder avatar;
        String email;
        String id;
        Boolean is_bot;
        String name;
        String type;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Builder builder = (Builder) obj;
            if (!Objects.equals(this.id, builder.id) || !Objects.equals(this.name, builder.name) || !Objects.equals(this.type, builder.type) || !Objects.equals(this.email, builder.email) || !Objects.equals(this.avatar, builder.avatar) || !Objects.equals(this.is_bot, builder.is_bot)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.id, this.name, this.type, this.email, this.avatar, this.is_bot});
        }

        public Participant build() {
            String str;
            Avatar avatar2;
            String str2 = this.type;
            if (str2 == null) {
                str2 = Participant.USER_TYPE;
            }
            String str3 = str2;
            String valueOrEmpty = NullSafety.valueOrEmpty(this.name);
            String valueOrEmpty2 = NullSafety.valueOrEmpty(this.email);
            Avatar.Builder builder = this.avatar;
            if (NullSafety.valueOrEmpty(builder != null ? builder.initials : null).isEmpty()) {
                str = NameUtils.getInitial(valueOrEmpty.isEmpty() ? valueOrEmpty2 : valueOrEmpty);
            } else {
                str = this.avatar.initials;
            }
            Avatar.Builder builder2 = this.avatar;
            if (builder2 == null) {
                avatar2 = Avatar.create("", str);
            } else {
                avatar2 = builder2.withInitials(str).build();
            }
            return Participant.create(NullSafety.valueOrEmpty(this.id), valueOrEmpty, str3, valueOrEmpty2, avatar2, Boolean.valueOf(NullSafety.valueOrDefault(this.is_bot, false)));
        }

        public Builder withId(String str) {
            this.id = str;
            return this;
        }

        public Builder withName(String str) {
            this.name = str;
            return this;
        }

        public Builder withEmail(String str) {
            this.email = str;
            return this;
        }

        public Builder withType(String str) {
            this.type = str;
            return this;
        }

        public Builder withIsBot(boolean z) {
            this.is_bot = Boolean.valueOf(z);
            return this;
        }

        public Builder withAvatar(Avatar.Builder builder) {
            this.avatar = builder;
            return this;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getId());
        parcel.writeString(getName());
        parcel.writeString(getType());
        parcel.writeString(getEmail());
        parcel.writeValue(getAvatar());
        parcel.writeByte(isBot().booleanValue() ? (byte) 1 : 0);
    }
}
