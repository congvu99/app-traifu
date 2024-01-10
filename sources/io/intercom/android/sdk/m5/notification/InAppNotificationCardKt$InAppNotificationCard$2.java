package io.intercom.android.sdk.m5.notification;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.models.Conversation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppNotificationCard.kt */
final class InAppNotificationCardKt$InAppNotificationCard$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Conversation $conversation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppNotificationCardKt$InAppNotificationCard$2(Conversation conversation, int i) {
        super(2);
        this.$conversation = conversation;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        InAppNotificationCardKt.InAppNotificationCard(this.$conversation, composer, this.$$changed | 1);
    }
}
