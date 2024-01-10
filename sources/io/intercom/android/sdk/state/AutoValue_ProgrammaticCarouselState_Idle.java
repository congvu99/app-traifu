package io.intercom.android.sdk.state;

import io.intercom.android.sdk.state.ProgrammaticCarouselState;

final class AutoValue_ProgrammaticCarouselState_Idle extends ProgrammaticCarouselState.Idle {
    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "Idle{}";
    }

    AutoValue_ProgrammaticCarouselState_Idle() {
    }

    public boolean equals(Object obj) {
        return obj == this || (obj instanceof ProgrammaticCarouselState.Idle);
    }
}
