package com.anggrayudi.storage.permission;

import android.content.Context;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u001c\u0010\u0013\u001a\u00020\u00112\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0015H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R:\u0010\f\u001a.\u0012*\u0012(\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00060\u0006 \u000e*\u0014\u0012\u000e\b\u0001\u0012\n \u000e*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00050\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "Lcom/anggrayudi/storage/permission/PermissionRequest;", "fragment", "Landroidx/fragment/app/Fragment;", "permissions", "", "", "options", "Landroidx/core/app/ActivityOptionsCompat;", "callback", "Lcom/anggrayudi/storage/permission/PermissionCallback;", "(Landroidx/fragment/app/Fragment;[Ljava/lang/String;Landroidx/core/app/ActivityOptionsCompat;Lcom/anggrayudi/storage/permission/PermissionCallback;)V", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "check", "", "continueToPermissionRequest", "onRequestPermissionsResult", "result", "", "", "Builder", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FragmentPermissionRequest.kt */
public final class FragmentPermissionRequest implements PermissionRequest {
    private final PermissionCallback callback;
    private final Fragment fragment;
    private final ActivityResultLauncher<String[]> launcher;
    private final ActivityOptionsCompat options;
    private final String[] permissions;

    public /* synthetic */ FragmentPermissionRequest(Fragment fragment2, String[] strArr, ActivityOptionsCompat activityOptionsCompat, PermissionCallback permissionCallback, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment2, strArr, activityOptionsCompat, permissionCallback);
    }

    private FragmentPermissionRequest(Fragment fragment2, String[] strArr, ActivityOptionsCompat activityOptionsCompat, PermissionCallback permissionCallback) {
        this.fragment = fragment2;
        this.permissions = strArr;
        this.options = activityOptionsCompat;
        this.callback = permissionCallback;
        ActivityResultLauncher<String[]> registerForActivityResult = fragment2.registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() {
            public final void onActivityResult(Object obj) {
                FragmentPermissionRequest.m5044launcher$lambda0(FragmentPermissionRequest.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "fragment.registerForActi…rmissionsResult(it)\n    }");
        this.launcher = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    /* renamed from: launcher$lambda-0  reason: not valid java name */
    public static final void m5044launcher$lambda0(FragmentPermissionRequest fragmentPermissionRequest, Map map) {
        Intrinsics.checkNotNullParameter(fragmentPermissionRequest, "this$0");
        Intrinsics.checkNotNullExpressionValue(map, "it");
        fragmentPermissionRequest.onRequestPermissionsResult(map);
    }

    public void check() {
        boolean z;
        boolean z2;
        Context requireContext = this.fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
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
            if (ContextCompat.checkSelfPermission(requireContext, str) == 0) {
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

    private final void onRequestPermissionsResult(Map<String, Boolean> map) {
        FragmentActivity requireActivity = this.fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        Collection arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<String, Boolean>> it = map.entrySet().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry next = it.next();
            String str = (String) next.getKey();
            boolean booleanValue = ((Boolean) next.getValue()).booleanValue();
            if (((Boolean) next.getValue()).booleanValue() || ActivityCompat.shouldShowRequestPermissionRationale(requireActivity, (String) next.getKey())) {
                z = false;
            }
            arrayList.add(new PermissionReport(str, booleanValue, z));
        }
        List list = (List) arrayList;
        Collection arrayList2 = new ArrayList();
        for (Object next2 : list) {
            if (((PermissionReport) next2).getDeniedPermanently()) {
                arrayList2.add(next2);
            }
        }
        List list2 = (List) arrayList2;
        if (list2.isEmpty()) {
            this.callback.onPermissionsChecked(new PermissionResult(list), true);
        } else {
            this.callback.onShouldRedirectToSystemSettings(list2);
        }
    }

    public void continueToPermissionRequest() {
        FragmentActivity requireActivity = this.fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        String[] strArr = this.permissions;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            i++;
            if (ContextCompat.checkSelfPermission(requireActivity, str) != 0) {
                this.launcher.launch(this.permissions, this.options);
                return;
            }
        }
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
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u001f\u0010\u0012\u001a\u00020\u00002\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0013\"\u00020\u000b¢\u0006\u0002\u0010\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/anggrayudi/storage/permission/FragmentPermissionRequest$Builder;", "", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "callback", "Lcom/anggrayudi/storage/permission/PermissionCallback;", "options", "Landroidx/core/app/ActivityOptionsCompat;", "permissions", "", "", "build", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "check", "", "withActivityOptions", "withCallback", "withPermissions", "", "([Ljava/lang/String;)Lcom/anggrayudi/storage/permission/FragmentPermissionRequest$Builder;", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FragmentPermissionRequest.kt */
    public static final class Builder {
        private PermissionCallback callback;
        private final Fragment fragment;
        private ActivityOptionsCompat options;
        private Set<String> permissions = SetsKt.emptySet();

        public Builder(Fragment fragment2) {
            Intrinsics.checkNotNullParameter(fragment2, "fragment");
            this.fragment = fragment2;
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

        public final Builder withActivityOptions(ActivityOptionsCompat activityOptionsCompat) {
            Builder builder = this;
            builder.options = activityOptionsCompat;
            return builder;
        }

        public final FragmentPermissionRequest build() {
            Fragment fragment2 = this.fragment;
            Object[] array = this.permissions.toArray(new String[0]);
            if (array != null) {
                ActivityOptionsCompat activityOptionsCompat = this.options;
                PermissionCallback permissionCallback = this.callback;
                Intrinsics.checkNotNull(permissionCallback);
                return new FragmentPermissionRequest(fragment2, (String[]) array, activityOptionsCompat, permissionCallback, (DefaultConstructorMarker) null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        public final void check() {
            build().check();
        }
    }
}
