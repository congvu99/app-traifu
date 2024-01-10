package io.intercom.android.sdk.activities;

import android.app.Activity;
import io.intercom.android.sdk.views.IntercomToolbar;

class InAppToolbarListener implements IntercomToolbar.Listener {
    private final Activity activity;

    public void onInboxClicked() {
    }

    public void onToolbarClicked() {
    }

    InAppToolbarListener(Activity activity2) {
        this.activity = activity2;
    }

    public void onCloseClicked() {
        this.activity.onBackPressed();
    }
}
