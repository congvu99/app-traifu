package io.intercom.android.sdk.m5.components;

import io.intercom.android.sdk.models.Conversation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConversationHistoryCard.kt */
final class ConversationHistoryCardKt$ConversationHistoryCard$1 extends Lambda implements Function1<Conversation, Unit> {
    public static final ConversationHistoryCardKt$ConversationHistoryCard$1 INSTANCE = new ConversationHistoryCardKt$ConversationHistoryCard$1();

    ConversationHistoryCardKt$ConversationHistoryCard$1() {
        super(1);
    }

    public final void invoke(Conversation conversation) {
        Intrinsics.checkNotNullParameter(conversation, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Conversation) obj);
        return Unit.INSTANCE;
    }
}
