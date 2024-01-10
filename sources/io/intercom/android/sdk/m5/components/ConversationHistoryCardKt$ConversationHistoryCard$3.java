package io.intercom.android.sdk.m5.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.models.Conversation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConversationHistoryCard.kt */
final class ConversationHistoryCardKt$ConversationHistoryCard$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ String $cardTitle;
    final /* synthetic */ List<Conversation> $conversations;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Conversation, Unit> $onConversationClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationHistoryCardKt$ConversationHistoryCard$3(Modifier modifier, String str, List<? extends Conversation> list, Function1<? super Conversation, Unit> function1, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$cardTitle = str;
        this.$conversations = list;
        this.$onConversationClick = function1;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ConversationHistoryCardKt.ConversationHistoryCard(this.$modifier, this.$cardTitle, this.$conversations, this.$onConversationClick, composer, this.$$changed | 1, this.$$default);
    }
}
