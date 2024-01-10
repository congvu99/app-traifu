package io.intercom.android.sdk.push;

import android.content.Context;
import android.graphics.Bitmap;
import com.intercom.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.AvatarUtils;
import io.intercom.android.sdk.utilities.BitmapUtilsKt;
import io.intercom.android.sdk.utilities.NameUtils;

class PushAvatarUtils {
    private static final int LARGE_ICON_SIZE_DP = 48;

    PushAvatarUtils() {
    }

    public static Bitmap getNotificationInitialsBitmap(Context context, String str, AppConfig appConfig) {
        int dpToPx = ScreenUtils.dpToPx(48.0f, context);
        return BitmapUtilsKt.drawableToBitmap(AvatarUtils.getInitialsDrawable(NameUtils.getInitial(str), appConfig), dpToPx, dpToPx);
    }

    public static Bitmap getNotificationDefaultBitmap(Context context, AppConfig appConfig) {
        int dpToPx = ScreenUtils.dpToPx(48.0f, context);
        return BitmapUtilsKt.drawableToBitmap(AvatarUtils.getDefaultDrawable(context, appConfig), dpToPx, dpToPx);
    }
}
