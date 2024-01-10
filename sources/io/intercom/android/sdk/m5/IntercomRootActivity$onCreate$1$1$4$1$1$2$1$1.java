package io.intercom.android.sdk.m5;

import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.activities.IntercomConversationActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomRootActivity.kt */
final class IntercomRootActivity$onCreate$1$1$4$1$1$2$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ IntercomRootActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomRootActivity$onCreate$1$1$4$1$1$2$1$1(IntercomRootActivity intercomRootActivity) {
        super(0);
        this.this$0 = intercomRootActivity;
    }

    public final void invoke() {
        Injector.get().getMetricTracker().clickedNewConversation("messages");
        this.this$0.startActivity(IntercomConversationActivity.Companion.openComposer(this.this$0, ""));
    }
}
