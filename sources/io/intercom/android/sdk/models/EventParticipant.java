package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.utilities.NullSafety;

public class EventParticipant implements Parcelable {
    public static final Parcelable.Creator<EventParticipant> CREATOR = new Parcelable.Creator<EventParticipant>() {
        public EventParticipant createFromParcel(Parcel parcel) {
            return new EventParticipant(parcel);
        }

        public EventParticipant[] newArray(int i) {
            return new EventParticipant[i];
        }
    };
    public static final EventParticipant NULL = new EventParticipant(new Builder());
    private final Avatar avatar;
    private final String id;
    private final String initial;
    private final String label;
    private final String type;

    public int describeContents() {
        return 0;
    }

    private EventParticipant(Builder builder) {
        this.id = NullSafety.valueOrEmpty(builder.id);
        this.initial = NullSafety.valueOrEmpty(builder.initial);
        this.label = NullSafety.valueOrEmpty(builder.label);
        this.type = NullSafety.valueOrEmpty(builder.type);
        this.avatar = (builder.avatar == null ? new Avatar.Builder() : builder.avatar).build();
    }

    public String getId() {
        return this.id;
    }

    public String getInitial() {
        return this.initial;
    }

    public String getLabel() {
        return this.label;
    }

    public String getType() {
        return this.type;
    }

    public Avatar getAvatar() {
        return this.avatar;
    }

    public static final class Builder {
        Avatar.Builder avatar;
        String id;
        String initial;
        String label;
        String type;

        public EventParticipant build() {
            return new EventParticipant(this);
        }
    }

    protected EventParticipant(Parcel parcel) {
        this.id = parcel.readString();
        this.initial = parcel.readString();
        this.label = parcel.readString();
        this.type = parcel.readString();
        this.avatar = (Avatar) parcel.readValue(Avatar.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.initial);
        parcel.writeString(this.label);
        parcel.writeString(this.type);
        parcel.writeValue(this.avatar);
    }
}
