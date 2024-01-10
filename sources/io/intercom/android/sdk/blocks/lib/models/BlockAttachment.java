package io.intercom.android.sdk.blocks.lib.models;

import android.os.Parcel;
import android.os.Parcelable;

public class BlockAttachment implements Parcelable {
    public static final Parcelable.Creator<BlockAttachment> CREATOR = new Parcelable.Creator<BlockAttachment>() {
        public BlockAttachment createFromParcel(Parcel parcel) {
            return new BlockAttachment(parcel);
        }

        public BlockAttachment[] newArray(int i) {
            return new BlockAttachment[i];
        }
    };
    private final String contentType;
    private final int id;
    private final String name;
    private final long size;
    private final String url;

    public int describeContents() {
        return 0;
    }

    public BlockAttachment() {
        this(new Builder());
    }

    public BlockAttachment(Builder builder) {
        String str = "";
        this.name = builder.name == null ? str : builder.name;
        this.url = builder.url == null ? str : builder.url;
        this.contentType = builder.contentType != null ? builder.contentType : str;
        this.id = builder.id;
        this.size = builder.size;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public String getContentType() {
        return this.contentType;
    }

    public int getId() {
        return this.id;
    }

    public long getSize() {
        return this.size;
    }

    public Builder toBuilder() {
        return new Builder().withName(this.name).withUrl(this.url).withContentType(this.contentType).withId(this.id).withSize(this.size);
    }

    public static final class Builder {
        String contentType;
        int id;
        String name;
        long size;
        String url;

        public Builder withName(String str) {
            this.name = str;
            return this;
        }

        public Builder withUrl(String str) {
            this.url = str;
            return this;
        }

        public Builder withContentType(String str) {
            this.contentType = str;
            return this;
        }

        public Builder withId(int i) {
            this.id = i;
            return this;
        }

        public Builder withSize(long j) {
            this.size = j;
            return this;
        }

        public BlockAttachment build() {
            return new BlockAttachment(this);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BlockAttachment blockAttachment = (BlockAttachment) obj;
        if (this.size != blockAttachment.size || this.id != blockAttachment.id) {
            return false;
        }
        String str = this.name;
        if (str == null ? blockAttachment.name != null : !str.equals(blockAttachment.name)) {
            return false;
        }
        String str2 = this.url;
        if (str2 == null ? blockAttachment.url != null : !str2.equals(blockAttachment.url)) {
            return false;
        }
        String str3 = this.contentType;
        String str4 = blockAttachment.contentType;
        if (str3 != null) {
            return str3.equals(str4);
        }
        if (str4 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.contentType;
        if (str3 != null) {
            i = str3.hashCode();
        }
        long j = this.size;
        return ((((hashCode2 + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.id;
    }

    protected BlockAttachment(Parcel parcel) {
        this.name = parcel.readString();
        this.url = parcel.readString();
        this.contentType = parcel.readString();
        this.id = parcel.readInt();
        this.size = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        parcel.writeString(this.contentType);
        parcel.writeInt(this.id);
        parcel.writeLong(this.size);
    }
}
