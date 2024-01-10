package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import io.intercom.android.sdk.models.EventParticipant;

public class EventData implements Parcelable {
    public static final Parcelable.Creator<EventData> CREATOR = new Parcelable.Creator<EventData>() {
        public EventData createFromParcel(Parcel parcel) {
            return new EventData(parcel);
        }

        public EventData[] newArray(int i) {
            return new EventData[i];
        }
    };
    public static final EventData NULL = new EventData(new Builder());
    private final String eventAsPlainText;
    private final EventParticipant participant;
    private final String status;

    public int describeContents() {
        return 0;
    }

    private EventData(Builder builder) {
        this.participant = builder.participant == null ? EventParticipant.NULL : builder.participant.build();
        String str = "";
        this.eventAsPlainText = builder.eventAsPlainText == null ? str : builder.eventAsPlainText;
        this.status = builder.status != null ? builder.status : str;
    }

    public EventParticipant getParticipant() {
        return this.participant;
    }

    public String getEventAsPlainText() {
        return this.eventAsPlainText;
    }

    public String getStatus() {
        return this.status;
    }

    public static final class Builder {
        String eventAsPlainText;
        EventParticipant.Builder participant;
        String status;

        public EventData build() {
            return new EventData(this);
        }
    }

    protected EventData(Parcel parcel) {
        this.participant = (EventParticipant) parcel.readValue(EventParticipant.class.getClassLoader());
        this.eventAsPlainText = parcel.readString();
        this.status = "";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.participant);
        parcel.writeString(this.eventAsPlainText);
    }
}
