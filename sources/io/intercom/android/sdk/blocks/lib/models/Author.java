package io.intercom.android.sdk.blocks.lib.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Author implements Parcelable {
    public static final Parcelable.Creator<Author> CREATOR = new Parcelable.Creator<Author>() {
        public Author createFromParcel(Parcel parcel) {
            return new Author(parcel);
        }

        public Author[] newArray(int i) {
            return new Author[i];
        }
    };
    private final String avatar;
    private final String firstName;
    private final String lastName;
    private final String name;

    public int describeContents() {
        return 0;
    }

    Author() {
        this(new Builder());
    }

    private Author(Builder builder) {
        String str = "";
        this.name = builder.name == null ? str : builder.name;
        this.avatar = builder.avatar == null ? str : builder.avatar;
        this.firstName = builder.firstName == null ? str : builder.firstName;
        this.lastName = builder.lastName != null ? builder.lastName : str;
    }

    public String getName() {
        return this.name;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public static final class Builder {
        String avatar;
        String firstName;
        String lastName;
        String name;

        public Builder withName(String str) {
            this.name = str;
            return this;
        }

        public Builder withAvatar(String str) {
            this.avatar = str;
            return this;
        }

        public Builder withFirstName(String str) {
            this.firstName = str;
            return this;
        }

        public Builder withLastName(String str) {
            this.lastName = str;
            return this;
        }

        public Author build() {
            return new Author(this);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Author author = (Author) obj;
        String str = this.name;
        if (str == null ? author.name != null : !str.equals(author.name)) {
            return false;
        }
        String str2 = this.firstName;
        if (str2 == null ? author.firstName != null : !str2.equals(author.firstName)) {
            return false;
        }
        String str3 = this.lastName;
        if (str3 == null ? author.lastName != null : !str3.equals(author.lastName)) {
            return false;
        }
        String str4 = this.avatar;
        String str5 = author.avatar;
        if (str4 != null) {
            if (!str4.equals(str5)) {
                return false;
            }
            return true;
        } else if (str5 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.firstName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.lastName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.avatar;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    protected Author(Parcel parcel) {
        this.name = parcel.readString();
        this.avatar = parcel.readString();
        this.firstName = parcel.readString();
        this.lastName = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.avatar);
        parcel.writeString(this.firstName);
        parcel.writeString(this.lastName);
    }
}
