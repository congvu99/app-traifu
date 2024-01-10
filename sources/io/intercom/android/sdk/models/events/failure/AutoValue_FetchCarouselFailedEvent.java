package io.intercom.android.sdk.models.events.failure;

import io.intercom.android.sdk.api.ErrorObject;

final class AutoValue_FetchCarouselFailedEvent extends FetchCarouselFailedEvent {
    private final String carouselId;
    private final ErrorObject errorObject;

    AutoValue_FetchCarouselFailedEvent(String str, ErrorObject errorObject2) {
        if (str != null) {
            this.carouselId = str;
            if (errorObject2 != null) {
                this.errorObject = errorObject2;
                return;
            }
            throw new NullPointerException("Null errorObject");
        }
        throw new NullPointerException("Null carouselId");
    }

    public String carouselId() {
        return this.carouselId;
    }

    public ErrorObject errorObject() {
        return this.errorObject;
    }

    public String toString() {
        return "FetchCarouselFailedEvent{carouselId=" + this.carouselId + ", errorObject=" + this.errorObject + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FetchCarouselFailedEvent)) {
            return false;
        }
        FetchCarouselFailedEvent fetchCarouselFailedEvent = (FetchCarouselFailedEvent) obj;
        if (!this.carouselId.equals(fetchCarouselFailedEvent.carouselId()) || !this.errorObject.equals(fetchCarouselFailedEvent.errorObject())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.carouselId.hashCode() ^ 1000003) * 1000003) ^ this.errorObject.hashCode();
    }
}
