package io.intercom.android.sdk.blocks;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.ActivityOptionsCompat;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.lightbox.LightBoxActivity;
import io.intercom.android.sdk.utilities.LinkOpener;

public class LightboxOpeningImageClickListener implements ImageClickListener {
    private final Api api;

    public LightboxOpeningImageClickListener(Api api2) {
        this.api = api2;
    }

    public void onImageClicked(String str, String str2, View view, int i, int i2) {
        Context context = view.getContext();
        if (!TextUtils.isEmpty(str2)) {
            LinkOpener.handleUrl(str2, context, this.api);
            return;
        }
        boolean z = false;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if ((activity.getWindow().getAttributes().flags & 1024) != 0) {
                z = true;
            }
            activity.startActivity(LightBoxActivity.imageIntent(activity, str, z), ActivityOptionsCompat.makeSceneTransitionAnimation(activity, view, LightBoxActivity.TRANSITION_KEY).toBundle());
            return;
        }
        context.startActivity(LightBoxActivity.imageIntent(context, str, false));
    }
}
