package io.intercom.android.sdk.utilities;

import android.graphics.Typeface;
import android.widget.TextView;

public class FontUtils {
    public static void setRobotoMediumTypeface(TextView textView) {
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
    }

    public static void setRobotoLightTypeface(TextView textView) {
        textView.setTypeface(Typeface.create("sans-serif-light", 0));
    }
}
