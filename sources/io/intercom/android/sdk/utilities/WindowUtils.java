package io.intercom.android.sdk.utilities;

import android.content.res.Resources;
import com.facebook.appevents.codeless.internal.Constants;

public class WindowUtils {
    public static int getStatusBarHeight(Resources resources) {
        int identifier = resources.getIdentifier("status_bar_height", "dimen", Constants.PLATFORM);
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
