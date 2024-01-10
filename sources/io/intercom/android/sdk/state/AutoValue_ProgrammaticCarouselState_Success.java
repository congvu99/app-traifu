package io.intercom.android.sdk.state;

import io.intercom.android.sdk.models.carousel.Carousel;
import io.intercom.android.sdk.state.ProgrammaticCarouselState;

final class AutoValue_ProgrammaticCarouselState_Success extends ProgrammaticCarouselState.Success {
    private final Carousel carousel;

    AutoValue_ProgrammaticCarouselState_Success(Carousel carousel2) {
        if (carousel2 != null) {
            this.carousel = carousel2;
            return;
        }
        throw new NullPointerException("Null carousel");
    }

    public Carousel carousel() {
        return this.carousel;
    }

    public String toString() {
        return "Success{carousel=" + this.carousel + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ProgrammaticCarouselState.Success) {
            return this.carousel.equals(((ProgrammaticCarouselState.Success) obj).carousel());
        }
        return false;
    }

    public int hashCode() {
        return this.carousel.hashCode() ^ 1000003;
    }
}
