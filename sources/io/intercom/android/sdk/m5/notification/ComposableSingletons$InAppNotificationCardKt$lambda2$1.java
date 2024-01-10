package io.intercom.android.sdk.m5.notification;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.models.Ticket;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.m5.notification.ComposableSingletons$InAppNotificationCardKt$lambda-2$1  reason: invalid class name */
/* compiled from: InAppNotificationCard.kt */
final class ComposableSingletons$InAppNotificationCardKt$lambda2$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$InAppNotificationCardKt$lambda2$1 INSTANCE = new ComposableSingletons$InAppNotificationCardKt$lambda2$1();

    ComposableSingletons$InAppNotificationCardKt$lambda2$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            Conversation build = new Conversation.Builder().withParts(CollectionsKt.listOf(new Part.Builder().withSummary("Hello There"))).withParticipants(CollectionsKt.listOf(new Participant.Builder().withName("Santhosh").withIsBot(false).withType(Participant.ADMIN_TYPE))).withTicket(new Ticket("Feature request", (String) null, (String) null, (String) null, new Ticket.Status("Submitted", MetricTracker.Action.SUBMITTED, (String) null, false, 0, 28, (DefaultConstructorMarker) null), (List) null, (List) null, 0, (Participant.Builder) null, 494, (DefaultConstructorMarker) null)).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder().withParts(\n   …  )\n            ).build()");
            InAppNotificationCardKt.InAppNotificationCard(build, composer, 8);
            return;
        }
        composer.skipToGroupEnd();
    }
}
