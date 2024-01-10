package io.intercom.android.sdk.carousel;

import io.intercom.android.sdk.models.carousel.ScreenAction;

public interface CarouselListener {
    void dismissCarousel(String str);

    void openLink(String str);

    void requestPermissions(ScreenAction screenAction);

    void selectNextScreen(String str);

    void skipPermissionScreen();

    void startChat();

    void trackActionButtonTappedStats();
}
