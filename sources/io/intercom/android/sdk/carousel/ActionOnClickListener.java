package io.intercom.android.sdk.carousel;

import android.view.View;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.carousel.ActionType;
import io.intercom.android.sdk.models.carousel.ScreenAction;

class ActionOnClickListener implements View.OnClickListener {
    private final CarouselListener listener;
    private final ScreenAction screenAction;

    ActionOnClickListener(ScreenAction screenAction2, CarouselListener carouselListener) {
        this.screenAction = screenAction2;
        this.listener = carouselListener;
    }

    public void onClick(View view) {
        if (this.screenAction.isPermissionAction()) {
            this.listener.requestPermissions(this.screenAction);
            return;
        }
        String type = this.screenAction.getType();
        char c = 65535;
        switch (type.hashCode()) {
            case -1573653227:
                if (type.equals(ActionType.START_CHAT)) {
                    c = 2;
                    break;
                }
                break;
            case -567202649:
                if (type.equals(ActionType.CONTINUE)) {
                    c = 4;
                    break;
                }
                break;
            case 3321850:
                if (type.equals("link")) {
                    c = 1;
                    break;
                }
                break;
            case 3532159:
                if (type.equals(ActionType.SKIP)) {
                    c = 3;
                    break;
                }
                break;
            case 1671672458:
                if (type.equals(ActionType.DISMISS)) {
                    c = 0;
                    break;
                }
                break;
        }
        if (c == 0) {
            this.listener.trackActionButtonTappedStats();
            this.listener.dismissCarousel(MetricTracker.Context.FROM_CTA);
        } else if (c == 1) {
            this.listener.trackActionButtonTappedStats();
            this.listener.openLink(this.screenAction.getUri());
        } else if (c == 2) {
            this.listener.trackActionButtonTappedStats();
            this.listener.startChat();
        } else if (c != 3) {
            this.listener.selectNextScreen(MetricTracker.Context.FROM_CTA);
        } else {
            this.listener.skipPermissionScreen();
        }
    }
}
