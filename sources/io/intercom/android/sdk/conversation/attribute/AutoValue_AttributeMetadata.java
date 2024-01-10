package io.intercom.android.sdk.conversation.attribute;

final class AutoValue_AttributeMetadata extends AttributeMetadata {
    private final int position;
    private final int totalCount;

    AutoValue_AttributeMetadata(int i, int i2) {
        this.position = i;
        this.totalCount = i2;
    }

    public int getPosition() {
        return this.position;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public String toString() {
        return "AttributeMetadata{position=" + this.position + ", totalCount=" + this.totalCount + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeMetadata)) {
            return false;
        }
        AttributeMetadata attributeMetadata = (AttributeMetadata) obj;
        if (this.position == attributeMetadata.getPosition() && this.totalCount == attributeMetadata.getTotalCount()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.position ^ 1000003) * 1000003) ^ this.totalCount;
    }
}
