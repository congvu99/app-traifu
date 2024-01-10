package com.anggrayudi.storage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/anggrayudi/storage/FragmentWrapper;", "Lcom/anggrayudi/storage/ComponentWrapper;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "requestCode", "", "getRequestCode", "()I", "setRequestCode", "(I)V", "storage", "Lcom/anggrayudi/storage/SimpleStorage;", "getStorage", "()Lcom/anggrayudi/storage/SimpleStorage;", "setStorage", "(Lcom/anggrayudi/storage/SimpleStorage;)V", "startActivityForResult", "", "intent", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FragmentWrapper.kt */
public final class FragmentWrapper implements ComponentWrapper {
    private final ActivityResultLauncher<Intent> activityResultLauncher;
    private final Fragment fragment;
    private int requestCode;
    public SimpleStorage storage;

    public FragmentWrapper(Fragment fragment2) {
        Intrinsics.checkNotNullParameter(fragment2, "fragment");
        this.fragment = fragment2;
        ActivityResultLauncher<Intent> registerForActivityResult = fragment2.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() {
            public final void onActivityResult(Object obj) {
                FragmentWrapper.m5032activityResultLauncher$lambda0(FragmentWrapper.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "fragment.registerForActi…esultCode, it.data)\n    }");
        this.activityResultLauncher = registerForActivityResult;
    }

    public final SimpleStorage getStorage() {
        SimpleStorage simpleStorage = this.storage;
        if (simpleStorage != null) {
            return simpleStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("storage");
        return null;
    }

    public final void setStorage(SimpleStorage simpleStorage) {
        Intrinsics.checkNotNullParameter(simpleStorage, "<set-?>");
        this.storage = simpleStorage;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final void setRequestCode(int i) {
        this.requestCode = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: activityResultLauncher$lambda-0  reason: not valid java name */
    public static final void m5032activityResultLauncher$lambda0(FragmentWrapper fragmentWrapper, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(fragmentWrapper, "this$0");
        fragmentWrapper.getStorage().onActivityResult(fragmentWrapper.requestCode, activityResult.getResultCode(), activityResult.getData());
    }

    public Context getContext() {
        Context requireContext = this.fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
        return requireContext;
    }

    public FragmentActivity getActivity() {
        FragmentActivity requireActivity = this.fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        return requireActivity;
    }

    public boolean startActivityForResult(Intent intent, int i) {
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        try {
            this.activityResultLauncher.launch(intent);
            this.requestCode = i;
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }
}
