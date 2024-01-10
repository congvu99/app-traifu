package io.intercom.android.sdk.m5.helpcenter.components;

import android.content.Context;
import io.intercom.android.sdk.m5.IntercomRootActivityLauncher;
import io.intercom.android.sdk.metrics.MetricTracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BrowseAllHelpTopicsComponent.kt */
final class BrowseAllHelpTopicsComponentKt$BrowseAllHelpTopicsAsItem$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BrowseAllHelpTopicsComponentKt$BrowseAllHelpTopicsAsItem$1(Context context) {
        super(0);
        this.$context = context;
    }

    public final void invoke() {
        IntercomRootActivityLauncher.INSTANCE.startHelpCenterCollections(this.$context, CollectionsKt.emptyList(), MetricTracker.Place.COLLECTION_LIST);
    }
}
