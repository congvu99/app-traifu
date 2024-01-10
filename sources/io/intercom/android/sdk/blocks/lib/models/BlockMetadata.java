package io.intercom.android.sdk.blocks.lib.models;

import io.intercom.android.sdk.models.carousel.Appearance;
import io.intercom.android.sdk.utilities.NullSafety;

public abstract class BlockMetadata {
    public static BlockMetadata NULL = new Builder().build();

    public abstract Appearance getAppearance();

    public abstract boolean isFirstObject();

    public abstract boolean isLastObject();

    static BlockMetadata create(boolean z, boolean z2, Appearance appearance) {
        return new AutoValue_BlockMetadata(z, z2, appearance);
    }

    public boolean isSingleObject() {
        return isFirstObject() && isLastObject();
    }

    public static final class Builder {
        Appearance.Builder appearance;
        Boolean isFirstObject;
        Boolean isLastObject;

        public Builder isFirstObject(Boolean bool) {
            this.isFirstObject = bool;
            return this;
        }

        public Builder isLastObject(Boolean bool) {
            this.isLastObject = bool;
            return this;
        }

        public Builder withAppearance(Appearance.Builder builder) {
            this.appearance = builder;
            return this;
        }

        public BlockMetadata build() {
            Appearance.Builder builder = this.appearance;
            return BlockMetadata.create(NullSafety.valueOrDefault(this.isFirstObject, false), NullSafety.valueOrDefault(this.isLastObject, false), builder == null ? Appearance.NULL : builder.build());
        }
    }
}
