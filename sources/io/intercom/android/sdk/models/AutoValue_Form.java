package io.intercom.android.sdk.models;

import java.util.List;

final class AutoValue_Form extends Form {
    private final List<Attribute> attributes;
    private final String type;

    AutoValue_Form(List<Attribute> list, String str) {
        if (list != null) {
            this.attributes = list;
            if (str != null) {
                this.type = str;
                return;
            }
            throw new NullPointerException("Null type");
        }
        throw new NullPointerException("Null attributes");
    }

    public List<Attribute> getAttributes() {
        return this.attributes;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return "Form{attributes=" + this.attributes + ", type=" + this.type + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Form)) {
            return false;
        }
        Form form = (Form) obj;
        if (!this.attributes.equals(form.getAttributes()) || !this.type.equals(form.getType())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.attributes.hashCode() ^ 1000003) * 1000003) ^ this.type.hashCode();
    }
}
