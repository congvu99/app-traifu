package io.intercom.android.sdk.tickets;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketDetailScreen.kt */
final class TicketDetailScreenKt$TicketDetailScreen$cardState$2$1 extends Lambda implements Function0<MutableState<CardState>> {
    final /* synthetic */ boolean $showSubmissionCard;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TicketDetailScreenKt$TicketDetailScreen$cardState$2$1(boolean z) {
        super(0);
        this.$showSubmissionCard = z;
    }

    public final MutableState<CardState> invoke() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(this.$showSubmissionCard ? CardState.SubmissionCard : CardState.TimelineCard, (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}
