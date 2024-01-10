package io.intercom.android.sdk.models.carousel;

import io.intercom.android.sdk.models.carousel.Carousel;

public abstract class CarouselResponse {
    public abstract Carousel.Builder carousel();

    static CarouselResponse create(Carousel.Builder builder) {
        return new AutoValue_CarouselResponse(builder);
    }

    public static final class Builder {
        Carousel.Builder carousel;

        public Builder withCarousel(Carousel.Builder builder) {
            this.carousel = builder;
            return this;
        }

        public CarouselResponse build() {
            Carousel.Builder builder = this.carousel;
            if (builder == null) {
                builder = Carousel.NULL_BUILDER;
            }
            return CarouselResponse.create(builder);
        }
    }
}
