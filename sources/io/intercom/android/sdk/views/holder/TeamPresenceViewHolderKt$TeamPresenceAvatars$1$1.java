package io.intercom.android.sdk.views.holder;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TeamPresenceViewHolder.kt */
final class TeamPresenceViewHolderKt$TeamPresenceAvatars$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ TeamPresenceState $teamPresenceState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TeamPresenceViewHolderKt$TeamPresenceAvatars$1$1(TeamPresenceState teamPresenceState) {
        super(1);
        this.$teamPresenceState = teamPresenceState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, StringsKt.replace$default(this.$teamPresenceState.getCaption(), "•", "", false, 4, (Object) null));
    }
}
