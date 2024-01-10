package com.anggrayudi.storage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/anggrayudi/storage/ComponentActivityWrapper;", "Lcom/anggrayudi/storage/ComponentWrapper;", "_activity", "Landroidx/activity/ComponentActivity;", "(Landroidx/activity/ComponentActivity;)V", "activity", "getActivity", "()Landroidx/activity/ComponentActivity;", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "requestCode", "", "getRequestCode", "()I", "setRequestCode", "(I)V", "storage", "Lcom/anggrayudi/storage/SimpleStorage;", "getStorage", "()Lcom/anggrayudi/storage/SimpleStorage;", "setStorage", "(Lcom/anggrayudi/storage/SimpleStorage;)V", "startActivityForResult", "", "intent", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComponentActivityWrapper.kt */
public final class ComponentActivityWrapper implements ComponentWrapper {
    private final ComponentActivity _activity;
    private final ActivityResultLauncher<Intent> activityResultLauncher;
    private int requestCode;
    public SimpleStorage storage;

    public ComponentActivityWrapper(ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter(componentActivity, "_activity");
        this._activity = componentActivity;
        ActivityResultLauncher<Intent> registerForActivityResult = componentActivity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() {
            public final void onActivityResult(Object obj) {
                ComponentActivityWrapper.m5031activityResultLauncher$lambda0(ComponentActivityWrapper.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "_activity.registerForAct…esultCode, it.data)\n    }");
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
    public static final void m5031activityResultLauncher$lambda0(ComponentActivityWrapper componentActivityWrapper, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(componentActivityWrapper, "this$0");
        componentActivityWrapper.getStorage().onActivityResult(componentActivityWrapper.requestCode, activityResult.getResultCode(), activityResult.getData());
    }

    public Context getContext() {
        return this._activity;
    }

    public ComponentActivity getActivity() {
        return this._activity;
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
