package io.intercom.android.sdk.utilities;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.logger.LumberMill;

public class IntentUtils {
    private static final Twig twig = LumberMill.getLogger();

    public static void safelyOpenIntent(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 30) {
            intent.addCategory("android.intent.category.BROWSABLE");
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                twig.i("This device has no application that can handle the Uri passed in", new Object[0]);
            }
        } else if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
            twig.i("This device has no application that can handle the Uri passed in", new Object[0]);
        } else {
            context.startActivity(intent);
        }
    }
}
