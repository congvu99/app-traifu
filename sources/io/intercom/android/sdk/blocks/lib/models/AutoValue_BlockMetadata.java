package io.intercom.android.sdk.blocks.lib.models;

import io.intercom.android.sdk.models.carousel.Appearance;

final class AutoValue_BlockMetadata extends BlockMetadata {
    private final Appearance appearance;
    private final boolean firstObject;
    private final boolean lastObject;

    AutoValue_BlockMetadata(boolean z, boolean z2, Appearance appearance2) {
        this.firstObject = z;
        this.lastObject = z2;
        if (appearance2 != null) {
            this.appearance = appearance2;
            return;
        }
        throw new NullPointerException("Null appearance");
    }

    public boolean isFirstObject() {
        return this.firstObject;
    }

    public boolean isLastObject() {
        return this.lastObject;
    }

    public Appearance getAppearance() {
        return this.appearance;
    }

    public String toString() {
        return "BlockMetadata{firstObject=" + this.firstObject + ", lastObject=" + this.lastObject + ", appearance=" + this.appearance + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BlockMetadata)) {
            return false;
        }
        BlockMetadata blockMetadata = (BlockMetadata) obj;
        if (this.firstObject == blockMetadata.isFirstObject() && this.lastObject == blockMetadata.isLastObject() && this.appearance.equals(blockMetadata.getAppearance())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 1231;
        int i2 = ((this.firstObject ? 1231 : 1237) ^ 1000003) * 1000003;
        if (!this.lastObject) {
            i = 1237;
        }
        return ((i2 ^ i) * 1000003) ^ this.appearance.hashCode();
    }
}
