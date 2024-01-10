package io.intercom.android.sdk.models;

final class AutoValue_Avatar extends Avatar {
    private final String imageUrl;
    private final String initials;

    AutoValue_Avatar(String str, String str2) {
        if (str != null) {
            this.imageUrl = str;
            if (str2 != null) {
                this.initials = str2;
                return;
            }
            throw new NullPointerException("Null initials");
        }
        throw new NullPointerException("Null imageUrl");
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getInitials() {
        return this.initials;
    }

    public String toString() {
        return "Avatar{imageUrl=" + this.imageUrl + ", initials=" + this.initials + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Avatar)) {
            return false;
        }
        Avatar avatar = (Avatar) obj;
        if (!this.imageUrl.equals(avatar.getImageUrl()) || !this.initials.equals(avatar.getInitials())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.imageUrl.hashCode() ^ 1000003) * 1000003) ^ this.initials.hashCode();
    }
}
