package io.intercom.android.sdk.state;

import io.intercom.android.sdk.state.ProgrammaticCarouselState;

final class AutoValue_ProgrammaticCarouselState_Error extends ProgrammaticCarouselState.Error {
    private final String carouselId;
    private final int errorCode;

    AutoValue_ProgrammaticCarouselState_Error(String str, int i) {
        if (str != null) {
            this.carouselId = str;
            this.errorCode = i;
            return;
        }
        throw new NullPointerException("Null carouselId");
    }

    public String carouselId() {
        return this.carouselId;
    }

    public int errorCode() {
        return this.errorCode;
    }

    public String toString() {
        return "Error{carouselId=" + this.carouselId + ", errorCode=" + this.errorCode + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProgrammaticCarouselState.Error)) {
            return false;
        }
        ProgrammaticCarouselState.Error error = (ProgrammaticCarouselState.Error) obj;
        if (!this.carouselId.equals(error.carouselId()) || this.errorCode != error.errorCode()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.carouselId.hashCode() ^ 1000003) * 1000003) ^ this.errorCode;
    }
}
