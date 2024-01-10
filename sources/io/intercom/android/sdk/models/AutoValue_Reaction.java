package io.intercom.android.sdk.models;

final class AutoValue_Reaction extends Reaction {
    private final String imageUrl;
    private final int index;

    AutoValue_Reaction(int i, String str) {
        this.index = i;
        if (str != null) {
            this.imageUrl = str;
            return;
        }
        throw new NullPointerException("Null imageUrl");
    }

    public int getIndex() {
        return this.index;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String toString() {
        return "Reaction{index=" + this.index + ", imageUrl=" + this.imageUrl + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Reaction)) {
            return false;
        }
        Reaction reaction = (Reaction) obj;
        if (this.index != reaction.getIndex() || !this.imageUrl.equals(reaction.getImageUrl())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.index ^ 1000003) * 1000003) ^ this.imageUrl.hashCode();
    }
}
