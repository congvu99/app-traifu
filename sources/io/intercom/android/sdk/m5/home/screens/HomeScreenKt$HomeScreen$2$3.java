package io.intercom.android.sdk.m5.home.screens;

import android.content.Context;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.m5.components.intercombadge.IntercomBadgeState;
import io.intercom.android.sdk.utilities.LinkOpener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeScreen.kt */
final class HomeScreenKt$HomeScreen$2$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ IntercomBadgeState $badgeStateValue;
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeScreenKt$HomeScreen$2$3(IntercomBadgeState intercomBadgeState, Context context) {
        super(0);
        this.$badgeStateValue = intercomBadgeState;
        this.$context = context;
    }

    public final void invoke() {
        Injector.get().getMetricTracker().clickedPoweredBy();
        LinkOpener.handleUrl(((IntercomBadgeState.Shown) this.$badgeStateValue).getUrl(), this.$context, Injector.get().getApi());
    }
}
