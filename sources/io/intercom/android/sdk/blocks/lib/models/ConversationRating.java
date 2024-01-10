package io.intercom.android.sdk.blocks.lib.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class ConversationRating implements Parcelable {
    public static final Parcelable.Creator<ConversationRating> CREATOR = new Parcelable.Creator<ConversationRating>() {
        public ConversationRating createFromParcel(Parcel parcel) {
            return new ConversationRating(parcel);
        }

        public ConversationRating[] newArray(int i) {
            return new ConversationRating[i];
        }
    };
    private final List<ConversationRatingOption> options;
    private int ratingIndex;
    private String remark;

    public int describeContents() {
        return 0;
    }

    ConversationRating(int i, String str, List<ConversationRatingOption> list) {
        this.ratingIndex = i;
        this.remark = str;
        this.options = list;
    }

    public static ConversationRating fromBlock(Block block) {
        if (block == null) {
            return new ConversationRating(-1, "", new ArrayList());
        }
        return new ConversationRating(block.getRatingIndex(), block.getRemark(), block.getOptions());
    }

    public Integer getRatingIndex() {
        return Integer.valueOf(this.ratingIndex);
    }

    public void setRatingIndex(int i) {
        this.ratingIndex = i;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public List<ConversationRatingOption> getOptions() {
        return this.options;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ConversationRating conversationRating = (ConversationRating) obj;
        if (this.ratingIndex != conversationRating.ratingIndex) {
            return false;
        }
        String str = this.remark;
        if (str == null ? conversationRating.remark != null : !str.equals(conversationRating.remark)) {
            return false;
        }
        List<ConversationRatingOption> list = this.options;
        List<ConversationRatingOption> list2 = conversationRating.options;
        if (list != null) {
            return list.equals(list2);
        }
        if (list2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.ratingIndex * 31;
        String str = this.remark;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        List<ConversationRatingOption> list = this.options;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    protected ConversationRating(Parcel parcel) {
        this.ratingIndex = parcel.readInt();
        this.remark = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.options = arrayList;
        parcel.readList(arrayList, ConversationRatingOption.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.ratingIndex);
        parcel.writeString(this.remark);
        parcel.writeList(this.options);
    }
}
