package io.intercom.android.sdk.m5.components;

import io.intercom.android.sdk.models.Conversation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConversationHistoryCard.kt */
final class ConversationHistoryCardKt$ConversationHistoryCard$2$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Conversation $it;
    final /* synthetic */ Function1<Conversation, Unit> $onConversationClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationHistoryCardKt$ConversationHistoryCard$2$1$1$1(Function1<? super Conversation, Unit> function1, Conversation conversation) {
        super(0);
        this.$onConversationClick = function1;
        this.$it = conversation;
    }

    public final void invoke() {
        this.$onConversationClick.invoke(this.$it);
    }
}
