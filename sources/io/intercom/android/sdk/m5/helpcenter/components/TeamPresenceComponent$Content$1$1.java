package io.intercom.android.sdk.m5.helpcenter.components;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.helpcenter.articles.ArticleViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TeamPresenceComponent.kt */
final class TeamPresenceComponent$Content$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ ArticleViewState.TeamPresenceState $it;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TeamPresenceComponent$Content$1$1(ArticleViewState.TeamPresenceState teamPresenceState) {
        super(2);
        this.$it = teamPresenceState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            TeamPresenceComponentKt.TeamPresenceComponent(this.$it, composer, 8);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
