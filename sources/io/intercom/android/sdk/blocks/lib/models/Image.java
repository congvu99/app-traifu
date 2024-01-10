package io.intercom.android.sdk.blocks.lib.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Image implements Parcelable {
    public static final Parcelable.Creator<Image> CREATOR = new Parcelable.Creator<Image>() {
        public Image createFromParcel(Parcel parcel) {
            return new Image(parcel);
        }

        public Image[] newArray(int i) {
            return new Image[i];
        }
    };
    private final String alt;
    private final String attribution;
    private final int height;
    private final String previewUrl;
    private final String url;
    private final int width;

    public int describeContents() {
        return 0;
    }

    Image() {
        this(new Builder());
    }

    private Image(Builder builder) {
        String str = "";
        this.alt = builder.alt == null ? str : builder.alt;
        this.url = builder.url == null ? str : builder.url;
        this.previewUrl = builder.previewUrl == null ? str : builder.previewUrl;
        this.attribution = builder.attribution != null ? builder.attribution : str;
        this.width = builder.width;
        this.height = builder.height;
    }

    public String getAlt() {
        return this.alt;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String getPreviewUrl() {
        return this.previewUrl;
    }

    public String getAttribution() {
        return this.attribution;
    }

    public static final class Builder {
        String alt;
        String attribution;
        int height;
        String previewUrl;
        String url;
        int width;

        public Builder withAlt(String str) {
            this.alt = str;
            return this;
        }

        public Builder withUrl(String str) {
            this.url = str;
            return this;
        }

        public Builder withWidth(int i) {
            this.width = i;
            return this;
        }

        public Builder withHeight(int i) {
            this.height = i;
            return this;
        }

        public Builder withPreviewUrl(String str) {
            this.previewUrl = str;
            return this;
        }

        public Builder withAttribution(String str) {
            this.attribution = str;
            return this;
        }

        public Image build() {
            return new Image(this);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Image image = (Image) obj;
        String str = this.alt;
        if (str == null ? image.alt != null : !str.equals(image.alt)) {
            return false;
        }
        String str2 = this.previewUrl;
        if (str2 == null ? image.previewUrl != null : !str2.equals(image.previewUrl)) {
            return false;
        }
        String str3 = this.attribution;
        if (str3 == null ? image.attribution != null : !str3.equals(image.attribution)) {
            return false;
        }
        if (this.width != image.width || this.height != image.height) {
            return false;
        }
        String str4 = this.url;
        String str5 = image.url;
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
        String str = this.alt;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.previewUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.attribution;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return ((((hashCode3 + i) * 31) + this.width) * 31) + this.height;
    }

    protected Image(Parcel parcel) {
        this.attribution = parcel.readString();
        this.previewUrl = parcel.readString();
        this.alt = parcel.readString();
        this.url = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.attribution);
        parcel.writeString(this.previewUrl);
        parcel.writeString(this.alt);
        parcel.writeString(this.url);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }
}
