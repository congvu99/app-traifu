package io.intercom.android.sdk.m5.notification;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppNotificationCard.kt */
final class InAppNotificationCardKt$TicketInAppNotificationContent$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ String $name;
    final /* synthetic */ String $ticketStatus;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppNotificationCardKt$TicketInAppNotificationContent$1(String str, String str2, int i) {
        super(2);
        this.$name = str;
        this.$ticketStatus = str2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        InAppNotificationCardKt.TicketInAppNotificationContent(this.$name, this.$ticketStatus, composer, this.$$changed | 1);
    }
}
