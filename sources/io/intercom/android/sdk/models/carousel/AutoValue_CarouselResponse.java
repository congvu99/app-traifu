package io.intercom.android.sdk.models.carousel;

import io.intercom.android.sdk.models.carousel.Carousel;

final class AutoValue_CarouselResponse extends CarouselResponse {
    private final Carousel.Builder carousel;

    AutoValue_CarouselResponse(Carousel.Builder builder) {
        if (builder != null) {
            this.carousel = builder;
            return;
        }
        throw new NullPointerException("Null carousel");
    }

    public Carousel.Builder carousel() {
        return this.carousel;
    }

    public String toString() {
        return "CarouselResponse{carousel=" + this.carousel + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CarouselResponse) {
            return this.carousel.equals(((CarouselResponse) obj).carousel());
        }
        return false;
    }

    public int hashCode() {
        return this.carousel.hashCode() ^ 1000003;
    }
}
