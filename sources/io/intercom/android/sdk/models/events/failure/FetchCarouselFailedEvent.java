package io.intercom.android.sdk.models.events.failure;

import io.intercom.android.sdk.api.ErrorObject;

public abstract class FetchCarouselFailedEvent {
    public abstract String carouselId();

    public abstract ErrorObject errorObject();

    public static FetchCarouselFailedEvent create(String str, ErrorObject errorObject) {
        return new AutoValue_FetchCarouselFailedEvent(str, errorObject);
    }
}
