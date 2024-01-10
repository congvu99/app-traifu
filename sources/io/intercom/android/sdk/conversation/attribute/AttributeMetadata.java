package io.intercom.android.sdk.conversation.attribute;

public abstract class AttributeMetadata {
    public static final AttributeMetadata SINGLE_ATTRIBUTE_METADATA = new Builder().withPosition(0).withTotalCount(1).build();

    public abstract int getPosition();

    public abstract int getTotalCount();

    public static final class Builder {
        private int position;
        private int totalCount;

        public Builder withPosition(int i) {
            this.position = i;
            return this;
        }

        public Builder withTotalCount(int i) {
            this.totalCount = i;
            return this;
        }

        public AttributeMetadata build() {
            return new AutoValue_AttributeMetadata(this.position, this.totalCount);
        }
    }
}
