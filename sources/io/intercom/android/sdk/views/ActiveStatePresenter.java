package io.intercom.android.sdk.views;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.BackgroundUtils;

public class ActiveStatePresenter {
    private static final String ENGLISH_LOCALE = "en";

    public void presentStateDot(boolean z, View view, AppConfig appConfig) {
        int i;
        if (!ENGLISH_LOCALE.equals(appConfig.getLocale())) {
            view.setBackgroundResource(0);
            return;
        }
        Context context = view.getContext();
        if (z) {
            i = R.color.intercom_active_state;
        } else {
            i = R.color.intercom_away_state;
        }
        BackgroundUtils.setBackground(view, new ActiveStateDrawable(ContextCompat.getColor(context, i), ContextCompat.getColor(view.getContext(), R.color.intercom_white), view.getResources().getDisplayMetrics().density * 1.0f));
    }
}
