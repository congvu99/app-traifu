package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.intercom.commons.utilities.CollectionUtils;
import io.intercom.android.sdk.models.Reaction;
import java.util.ArrayList;
import java.util.List;

public class ReactionReply implements Parcelable {
    public static final Parcelable.Creator<ReactionReply> CREATOR = new Parcelable.Creator<ReactionReply>() {
        public ReactionReply createFromParcel(Parcel parcel) {
            return new ReactionReply(parcel);
        }

        public ReactionReply[] newArray(int i) {
            return new ReactionReply[i];
        }
    };
    public static final ReactionReply NULL = new ReactionReply(new Builder());
    private Integer reactionIndex;
    private final List<Reaction> reactionSet;

    public int describeContents() {
        return 0;
    }

    ReactionReply(Builder builder) {
        this.reactionIndex = builder.reaction_index;
        this.reactionSet = new ArrayList(CollectionUtils.capacityFor(builder.reaction_set));
        if (builder.reaction_set != null) {
            for (Reaction.Builder build : builder.reaction_set) {
                this.reactionSet.add(build.build());
            }
        }
    }

    public List<Reaction> getReactionSet() {
        return this.reactionSet;
    }

    public void setReactionIndex(int i) {
        this.reactionIndex = Integer.valueOf(i);
    }

    public Integer getReactionIndex() {
        return this.reactionIndex;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ReactionReply reactionReply = (ReactionReply) obj;
        if (!this.reactionSet.equals(reactionReply.reactionSet)) {
            return false;
        }
        Integer num = this.reactionIndex;
        Integer num2 = reactionReply.reactionIndex;
        if (num != null) {
            return num.equals(num2);
        }
        if (num2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.reactionSet.hashCode() * 31;
        Integer num = this.reactionIndex;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public static boolean isNull(ReactionReply reactionReply) {
        return NULL.equals(reactionReply) || reactionReply == null;
    }

    ReactionReply(Parcel parcel) {
        this.reactionIndex = parcel.readByte() == 0 ? null : Integer.valueOf(parcel.readInt());
        ArrayList arrayList = new ArrayList();
        this.reactionSet = arrayList;
        parcel.readList(arrayList, Reaction.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.reactionIndex == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.reactionIndex.intValue());
        }
        parcel.writeList(this.reactionSet);
    }

    public static class Builder {
        Integer reaction_index;
        List<Reaction.Builder> reaction_set;

        public ReactionReply build() {
            return new ReactionReply(this);
        }
    }
}
