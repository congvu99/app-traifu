package io.intercom.android.sdk.views.holder;

import android.content.Context;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.utilities.LinkOpener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TeamPresenceViewHolder.kt */
final class TeamPresenceViewHolderKt$TeamPresenceAvatars$1$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ TeamPresenceState $teamPresenceState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TeamPresenceViewHolderKt$TeamPresenceAvatars$1$3(TeamPresenceState teamPresenceState, Context context) {
        super(0);
        this.$teamPresenceState = teamPresenceState;
        this.$context = context;
    }

    public final void invoke() {
        LinkOpener.handleUrl(this.$teamPresenceState.getTwitter().getProfileUrl(), this.$context, Injector.get().getApi());
    }
}
