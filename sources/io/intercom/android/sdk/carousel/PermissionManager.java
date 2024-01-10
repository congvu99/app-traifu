package io.intercom.android.sdk.carousel;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.logger.LumberMill;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermissionManager {
    private static final String BACKGROUND_LOCATION_PERMISSION = "android.permission.ACCESS_BACKGROUND_LOCATION";
    private static final Twig twig = LumberMill.getLogger();
    private final Activity activity;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionStatus {
        public static final int DENIED_TEMPORARILY = 1;
        public static final int GRANTED = 0;
        public static final int NEVER_ASKED_OR_DENIED_PERMANENTLY = 2;
    }

    public PermissionManager(Activity activity2) {
        this.activity = activity2;
    }

    public void requestPermissions(String[] strArr, int i) {
        ActivityCompat.requestPermissions(this.activity, strArr, i);
    }

    public boolean permissionsGranted(List<String> list) {
        for (String permissionStatus : list) {
            if (getPermissionStatus(permissionStatus) != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean anyPermissionPermanentlyDeniedInResult(String[] strArr, int[] iArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (iArr[i] == -1 && !ActivityCompat.shouldShowRequestPermissionRationale(this.activity, strArr[i])) {
                return true;
            }
        }
        return false;
    }

    public List<String> permissionsExistInManifest(List<String> list) {
        ArrayList arrayList = new ArrayList();
        List<String> permissionsInManifest = permissionsInManifest();
        for (String next : list) {
            if (permissionsInManifest.contains(next)) {
                boolean equals = BACKGROUND_LOCATION_PERMISSION.equals(next);
                boolean z = Build.VERSION.SDK_INT < 29;
                if (!equals || !z) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public int getPermissionStatus(String str) {
        if (ContextCompat.checkSelfPermission(this.activity, str) == 0) {
            return 0;
        }
        return ActivityCompat.shouldShowRequestPermissionRationale(this.activity, str) ? 1 : 2;
    }

    /* access modifiers changed from: package-private */
    public List<String> permissionsInManifest() {
        try {
            return Arrays.asList(this.activity.getPackageManager().getPackageInfo(this.activity.getPackageName(), 4096).requestedPermissions);
        } catch (PackageManager.NameNotFoundException e) {
            Twig twig2 = twig;
            twig2.internal("Package name is unknown, error: " + e.getMessage());
            return new ArrayList();
        }
    }
}
