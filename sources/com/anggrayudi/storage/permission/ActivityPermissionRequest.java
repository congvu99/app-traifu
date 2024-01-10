package com.anggrayudi.storage.permission;

import android.app.Activity;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J)\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\u001c\u0010\u0014\u001a\u00020\u00122\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0016\u0010\u001b\u001a\u00020\u00122\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R<\u0010\f\u001a0\u0012*\u0012(\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00060\u0006 \u000e*\u0014\u0012\u000e\b\u0001\u0012\n \u000e*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u0005\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006 "}, d2 = {"Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "Lcom/anggrayudi/storage/permission/PermissionRequest;", "activity", "Landroid/app/Activity;", "permissions", "", "", "requestCode", "", "callback", "Lcom/anggrayudi/storage/permission/PermissionCallback;", "(Landroid/app/Activity;[Ljava/lang/String;Ljava/lang/Integer;Lcom/anggrayudi/storage/permission/PermissionCallback;)V", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "Ljava/lang/Integer;", "check", "", "continueToPermissionRequest", "onRequestPermissionsResult", "grantResults", "", "(I[Ljava/lang/String;[I)V", "result", "", "", "reportResult", "reports", "", "Lcom/anggrayudi/storage/permission/PermissionReport;", "Builder", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActivityPermissionRequest.kt */
public final class ActivityPermissionRequest implements PermissionRequest {
    private final Activity activity;
    private final PermissionCallback callback;
    private final ActivityResultLauncher<String[]> launcher;
    private final String[] permissions;
    private final Integer requestCode;

    public /* synthetic */ ActivityPermissionRequest(Activity activity2, String[] strArr, Integer num, PermissionCallback permissionCallback, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity2, strArr, num, permissionCallback);
    }

    private ActivityPermissionRequest(Activity activity2, String[] strArr, Integer num, PermissionCallback permissionCallback) {
        this.activity = activity2;
        this.permissions = strArr;
        this.requestCode = num;
        this.callback = permissionCallback;
        this.launcher = activity2 instanceof ComponentActivity ? ((ComponentActivity) activity2).registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() {
            public final void onActivityResult(Object obj) {
                ActivityPermissionRequest.m5043launcher$lambda0(ActivityPermissionRequest.this, (Map) obj);
            }
        }) : null;
    }

    /* access modifiers changed from: private */
    /* renamed from: launcher$lambda-0  reason: not valid java name */
    public static final void m5043launcher$lambda0(ActivityPermissionRequest activityPermissionRequest, Map map) {
        Intrinsics.checkNotNullParameter(activityPermissionRequest, "this$0");
        Intrinsics.checkNotNullExpressionValue(map, "it");
        activityPermissionRequest.onRequestPermissionsResult(map);
    }

    public void check() {
        boolean z;
        boolean z2;
        String[] strArr = this.permissions;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = true;
                break;
            }
            String str = strArr[i];
            i++;
            if (ContextCompat.checkSelfPermission(this.activity, str) == 0) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (!z2) {
                z = false;
                break;
            }
        }
        if (z) {
            PermissionCallback permissionCallback = this.callback;
            String[] strArr2 = this.permissions;
            Collection arrayList = new ArrayList(strArr2.length);
            int length2 = strArr2.length;
            int i2 = 0;
            while (i2 < length2) {
                String str2 = strArr2[i2];
                i2++;
                arrayList.add(new PermissionReport(str2, true, false));
            }
            permissionCallback.onPermissionsChecked(new PermissionResult((List) arrayList), false);
            return;
        }
        this.callback.onDisplayConsentDialog(this);
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        Integer num = this.requestCode;
        if (num == null || i != num.intValue()) {
            return;
        }
        if (this.launcher == null) {
            Collection arrayList = new ArrayList(strArr.length);
            int length = strArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                String str = strArr[i2];
                i2++;
                int i4 = i3 + 1;
                boolean z = true;
                boolean z2 = iArr[i3] == 0;
                if (z2 || ActivityCompat.shouldShowRequestPermissionRationale(this.activity, str)) {
                    z = false;
                }
                arrayList.add(new PermissionReport(str, z2, z));
                i3 = i4;
            }
            reportResult((List) arrayList);
            return;
        }
        throw new IllegalAccessException("Do not call onRequestPermissionsResult() in ComponentActivity");
    }

    private final void reportResult(List<PermissionReport> list) {
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (((PermissionReport) next).getDeniedPermanently()) {
                arrayList.add(next);
            }
        }
        List list2 = (List) arrayList;
        if (list2.isEmpty()) {
            this.callback.onPermissionsChecked(new PermissionResult(list), true);
        } else {
            this.callback.onShouldRedirectToSystemSettings(list2);
        }
    }

    public void continueToPermissionRequest() {
        String[] strArr = this.permissions;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            i++;
            if (ContextCompat.checkSelfPermission(this.activity, str) != 0) {
                ActivityResultLauncher<String[]> activityResultLauncher = this.launcher;
                if (activityResultLauncher != null) {
                    activityResultLauncher.launch(this.permissions);
                    return;
                }
                Activity activity2 = this.activity;
                String[] strArr2 = this.permissions;
                Integer num = this.requestCode;
                if (num != null) {
                    ActivityCompat.requestPermissions(activity2, strArr2, num.intValue());
                    return;
                }
                throw new IllegalStateException("Request code hasn't been set yet");
            }
        }
        PermissionCallback permissionCallback = this.callback;
        String[] strArr3 = this.permissions;
        Collection arrayList = new ArrayList(strArr3.length);
        int length2 = strArr3.length;
        int i2 = 0;
        while (i2 < length2) {
            String str2 = strArr3[i2];
            i2++;
            arrayList.add(new PermissionReport(str2, true, false));
        }
        permissionCallback.onPermissionsChecked(new PermissionResult((List) arrayList), false);
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u001f\u0010\u0014\u001a\u00020\u00002\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0015\"\u00020\r¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/anggrayudi/storage/permission/ActivityPermissionRequest$Builder;", "", "activity", "Landroid/app/Activity;", "requestCode", "", "(Landroid/app/Activity;I)V", "Landroidx/activity/ComponentActivity;", "(Landroidx/activity/ComponentActivity;)V", "callback", "Lcom/anggrayudi/storage/permission/PermissionCallback;", "permissions", "", "", "Ljava/lang/Integer;", "build", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "check", "", "withCallback", "withPermissions", "", "([Ljava/lang/String;)Lcom/anggrayudi/storage/permission/ActivityPermissionRequest$Builder;", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ActivityPermissionRequest.kt */
    public static final class Builder {
        private final Activity activity;
        private PermissionCallback callback;
        private Set<String> permissions = SetsKt.emptySet();
        private final Integer requestCode;

        public Builder(Activity activity2, int i) {
            Intrinsics.checkNotNullParameter(activity2, "activity");
            this.activity = activity2;
            this.requestCode = Integer.valueOf(i);
        }

        public Builder(ComponentActivity componentActivity) {
            Intrinsics.checkNotNullParameter(componentActivity, "activity");
            this.activity = componentActivity;
            this.requestCode = null;
        }

        public final Builder withPermissions(String... strArr) {
            Intrinsics.checkNotNullParameter(strArr, "permissions");
            Builder builder = this;
            builder.permissions = ArraysKt.toSet((T[]) strArr);
            return builder;
        }

        public final Builder withCallback(PermissionCallback permissionCallback) {
            Intrinsics.checkNotNullParameter(permissionCallback, "callback");
            Builder builder = this;
            builder.callback = permissionCallback;
            return builder;
        }

        public final ActivityPermissionRequest build() {
            Activity activity2 = this.activity;
            Object[] array = this.permissions.toArray(new String[0]);
            if (array != null) {
                Integer num = this.requestCode;
                PermissionCallback permissionCallback = this.callback;
                Intrinsics.checkNotNull(permissionCallback);
                return new ActivityPermissionRequest(activity2, (String[]) array, num, permissionCallback, (DefaultConstructorMarker) null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        public final void check() {
            build().check();
        }
    }

    private final void onRequestPermissionsResult(Map<String, Boolean> map) {
        Collection arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(new PermissionReport((String) next.getKey(), ((Boolean) next.getValue()).booleanValue(), !((Boolean) next.getValue()).booleanValue() && !ActivityCompat.shouldShowRequestPermissionRationale(this.activity, (String) next.getKey())));
        }
        reportResult((List) arrayList);
    }
}
