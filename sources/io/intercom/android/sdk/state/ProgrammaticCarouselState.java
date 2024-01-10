package io.intercom.android.sdk.state;

import io.intercom.android.sdk.models.carousel.Carousel;

public abstract class ProgrammaticCarouselState {

    public static abstract class Idle extends ProgrammaticCarouselState {
        public static Idle create() {
            return new AutoValue_ProgrammaticCarouselState_Idle();
        }
    }

    public static abstract class Loading extends ProgrammaticCarouselState {
        public abstract String carouselId();

        public static Loading create(String str) {
            return new AutoValue_ProgrammaticCarouselState_Loading(str);
        }
    }

    public static abstract class Success extends ProgrammaticCarouselState {
        public abstract Carousel carousel();

        public static Success create(Carousel carousel) {
            return new AutoValue_ProgrammaticCarouselState_Success(carousel);
        }
    }

    public static abstract class Error extends ProgrammaticCarouselState {
        public abstract String carouselId();

        public abstract int errorCode();

        public static Error create(String str, int i) {
            return new AutoValue_ProgrammaticCarouselState_Error(str, i);
        }
    }
}
