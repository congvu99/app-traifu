package io.intercom.android.sdk.m5;

import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.activities.IntercomConversationActivity;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomRootActivity.kt */
final class IntercomRootActivity$onCreate$1$1$4$1$1$1$7$1 extends Lambda implements Function1<Conversation, Unit> {
    final /* synthetic */ IntercomRootActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomRootActivity$onCreate$1$1$4$1$1$1$7$1(IntercomRootActivity intercomRootActivity) {
        super(1);
        this.this$0 = intercomRootActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Conversation) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Conversation conversation) {
        Intrinsics.checkNotNullParameter(conversation, "it");
        Injector.get().getMetricTracker().clickedConversation("home", conversation);
        this.this$0.startActivity(IntercomConversationActivity.Companion.openConversation(this.this$0, conversation.getId(), (LastParticipatingAdmin) null));
    }
}
