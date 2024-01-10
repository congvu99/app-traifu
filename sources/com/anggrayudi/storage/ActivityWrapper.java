package com.anggrayudi.storage;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/anggrayudi/storage/ActivityWrapper;", "Lcom/anggrayudi/storage/ComponentWrapper;", "_activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activity", "getActivity", "()Landroid/app/Activity;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "startActivityForResult", "", "intent", "Landroid/content/Intent;", "requestCode", "", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActivityWrapper.kt */
public final class ActivityWrapper implements ComponentWrapper {
    private final Activity _activity;

    public ActivityWrapper(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "_activity");
        this._activity = activity;
    }

    public Context getContext() {
        return this._activity;
    }

    public Activity getActivity() {
        return this._activity;
    }

    public boolean startActivityForResult(Intent intent, int i) {
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        try {
            this._activity.startActivityForResult(intent, i);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }
}
