package io.intercom.android.sdk.m5.components;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NewConversationCard.kt */
final class NewConversationCard$Content$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ NewConversationCard $tmp0_rcvr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewConversationCard$Content$2(NewConversationCard newConversationCard, int i) {
        super(2);
        this.$tmp0_rcvr = newConversationCard;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        this.$tmp0_rcvr.Content(composer, this.$$changed | 1);
    }
}
