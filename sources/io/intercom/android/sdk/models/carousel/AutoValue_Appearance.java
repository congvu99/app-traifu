package io.intercom.android.sdk.models.carousel;

final class AutoValue_Appearance extends Appearance {
    private final String alignment;
    private final String textColor;
    private final String type;

    AutoValue_Appearance(String str, String str2, String str3) {
        if (str != null) {
            this.type = str;
            if (str2 != null) {
                this.alignment = str2;
                if (str3 != null) {
                    this.textColor = str3;
                    return;
                }
                throw new NullPointerException("Null textColor");
            }
            throw new NullPointerException("Null alignment");
        }
        throw new NullPointerException("Null type");
    }

    public String getType() {
        return this.type;
    }

    public String getAlignment() {
        return this.alignment;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public String toString() {
        return "Appearance{type=" + this.type + ", alignment=" + this.alignment + ", textColor=" + this.textColor + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Appearance)) {
            return false;
        }
        Appearance appearance = (Appearance) obj;
        if (!this.type.equals(appearance.getType()) || !this.alignment.equals(appearance.getAlignment()) || !this.textColor.equals(appearance.getTextColor())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.type.hashCode() ^ 1000003) * 1000003) ^ this.alignment.hashCode()) * 1000003) ^ this.textColor.hashCode();
    }
}
