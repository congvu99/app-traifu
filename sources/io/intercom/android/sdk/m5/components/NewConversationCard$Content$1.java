package io.intercom.android.sdk.m5.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NewConversationCard.kt */
final class NewConversationCard$Content$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ NewConversationCard this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewConversationCard$Content$1(NewConversationCard newConversationCard) {
        super(2);
        this.this$0 = newConversationCard;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            NewConversationCardKt.NewConversationCard((Modifier) null, this.this$0.getOnNewConversationClick(), composer, 0, 1);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
