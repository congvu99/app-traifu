package io.intercom.android.sdk.state;

import io.intercom.android.sdk.state.ProgrammaticCarouselState;

final class AutoValue_ProgrammaticCarouselState_Loading extends ProgrammaticCarouselState.Loading {
    private final String carouselId;

    AutoValue_ProgrammaticCarouselState_Loading(String str) {
        if (str != null) {
            this.carouselId = str;
            return;
        }
        throw new NullPointerException("Null carouselId");
    }

    public String carouselId() {
        return this.carouselId;
    }

    public String toString() {
        return "Loading{carouselId=" + this.carouselId + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ProgrammaticCarouselState.Loading) {
            return this.carouselId.equals(((ProgrammaticCarouselState.Loading) obj).carouselId());
        }
        return false;
    }

    public int hashCode() {
        return this.carouselId.hashCode() ^ 1000003;
    }
}
