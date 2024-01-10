package io.intercom.android.sdk.profile;

import android.content.Context;
import android.view.View;
import com.google.android.material.appbar.AppBarLayout;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.utilities.WindowUtils;

abstract class ProfileToolbarBehavior implements AppBarLayout.OnOffsetChangedListener {
    float toolbarHeight;

    public ProfileToolbarBehavior(Context context) {
        float dimension = context.getResources().getDimension(R.dimen.intercom_toolbar_height);
        this.toolbarHeight = dimension;
        this.toolbarHeight = dimension + ((float) WindowUtils.getStatusBarHeight(context.getResources()));
    }

    /* access modifiers changed from: protected */
    public void setAlphaAsPercentageOfScroll(View view, View view2, float f, boolean z) {
        float scrollPercentage = getScrollPercentage(view2);
        if (z) {
            scrollPercentage = 100.0f - scrollPercentage;
        }
        view.setAlpha((f / 100.0f) * scrollPercentage);
    }

    /* access modifiers changed from: protected */
    public float getScrollPercentage(View view) {
        return ((((float) view.getBottom()) - this.toolbarHeight) / (((float) view.getHeight()) - this.toolbarHeight)) * 100.0f;
    }
}
