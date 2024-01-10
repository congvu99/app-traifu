package io.intercom.android.sdk.models;

import io.intercom.android.sdk.models.UsersResponse;
import io.intercom.android.sdk.models.carousel.Carousel;

public class LogEventResponse extends UsersResponse {
    private final Carousel carousel;

    LogEventResponse(Builder builder) {
        super(builder);
        this.carousel = (builder.carousel == null ? new Carousel.Builder() : builder.carousel).build();
    }

    public Carousel getCarousel() {
        return this.carousel;
    }

    public static final class Builder extends UsersResponse.Builder {
        Carousel.Builder carousel;

        public LogEventResponse build() {
            return new LogEventResponse(this);
        }
    }
}
