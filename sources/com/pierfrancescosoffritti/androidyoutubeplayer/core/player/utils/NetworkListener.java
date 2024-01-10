package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/NetworkListener;", "Landroid/content/BroadcastReceiver;", "()V", "onNetworkAvailable", "Lkotlin/Function0;", "", "getOnNetworkAvailable", "()Lkotlin/jvm/functions/Function0;", "setOnNetworkAvailable", "(Lkotlin/jvm/functions/Function0;)V", "onNetworkUnavailable", "getOnNetworkUnavailable", "setOnNetworkUnavailable", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: NetworkListener.kt */
public final class NetworkListener extends BroadcastReceiver {
    private Function0<Unit> onNetworkAvailable = NetworkListener$onNetworkAvailable$1.INSTANCE;
    private Function0<Unit> onNetworkUnavailable = NetworkListener$onNetworkUnavailable$1.INSTANCE;

    public final Function0<Unit> getOnNetworkUnavailable() {
        return this.onNetworkUnavailable;
    }

    public final void setOnNetworkUnavailable(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "<set-?>");
        this.onNetworkUnavailable = function0;
    }

    public final Function0<Unit> getOnNetworkAvailable() {
        return this.onNetworkAvailable;
    }

    public final void setOnNetworkAvailable(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "<set-?>");
        this.onNetworkAvailable = function0;
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(intent, SDKConstants.PARAM_INTENT);
        if (Utils.INSTANCE.isOnline(context)) {
            this.onNetworkAvailable.invoke();
        } else {
            this.onNetworkUnavailable.invoke();
        }
    }
}
