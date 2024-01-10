package io.intercom.android.sdk.m5.helpcenter.components;

import android.content.Context;
import io.intercom.android.sdk.helpcenter.articles.ArticleViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TeamPresenceComponent.kt */
final class TeamPresenceComponentKt$TeamPresenceComponent$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ArticleViewState.TeamPresenceState $teamPresenceState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TeamPresenceComponentKt$TeamPresenceComponent$1$2(ArticleViewState.TeamPresenceState teamPresenceState, Context context) {
        super(0);
        this.$teamPresenceState = teamPresenceState;
        this.$context = context;
    }

    public final void invoke() {
        TeamPresenceComponentKt.TeamPresenceComponent$onClick(this.$context, this.$teamPresenceState);
    }
}
