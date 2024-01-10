package io.intercom.android.sdk.blocks.lib.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ConversationRatingOption implements Parcelable {
    public static final Parcelable.Creator<ConversationRatingOption> CREATOR = new Parcelable.Creator<ConversationRatingOption>() {
        public ConversationRatingOption createFromParcel(Parcel parcel) {
            return new ConversationRatingOption(parcel);
        }

        public ConversationRatingOption[] newArray(int i) {
            return new ConversationRatingOption[i];
        }
    };
    private final String emoji;
    private final int index;
    private final String unicode;

    public int describeContents() {
        return 0;
    }

    private ConversationRatingOption(Builder builder) {
        this.index = builder.index == null ? -1 : builder.index.intValue();
        String str = "";
        this.emoji = builder.emoji == null ? str : builder.emoji;
        this.unicode = builder.unicode != null ? builder.unicode : str;
    }

    public static final class Builder {
        String emoji;
        Integer index;
        String unicode;

        public Builder withIndex(Integer num) {
            this.index = num;
            return this;
        }

        public Builder withEmoji(String str) {
            this.emoji = str;
            return this;
        }

        public Builder withUnicode(String str) {
            this.unicode = str;
            return this;
        }

        public ConversationRatingOption build() {
            return new ConversationRatingOption(this);
        }
    }

    public Integer getIndex() {
        return Integer.valueOf(this.index);
    }

    public String getEmoji() {
        return this.emoji;
    }

    public String getUnicode() {
        return this.unicode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ConversationRatingOption conversationRatingOption = (ConversationRatingOption) obj;
        if (this.index != conversationRatingOption.index) {
            return false;
        }
        String str = this.emoji;
        if (str == null ? conversationRatingOption.emoji != null : !str.equals(conversationRatingOption.emoji)) {
            return false;
        }
        String str2 = this.unicode;
        String str3 = conversationRatingOption.unicode;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.index * 31;
        String str = this.emoji;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.unicode;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    protected ConversationRatingOption(Parcel parcel) {
        this.index = parcel.readInt();
        this.emoji = parcel.readString();
        this.unicode = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.index);
        parcel.writeString(this.emoji);
        parcel.writeString(this.unicode);
    }
}
