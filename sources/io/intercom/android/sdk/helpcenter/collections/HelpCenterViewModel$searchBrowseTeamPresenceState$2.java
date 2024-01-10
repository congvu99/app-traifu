package io.intercom.android.sdk.helpcenter.collections;

import io.intercom.android.sdk.helpcenter.articles.ArticleViewState;
import io.intercom.android.sdk.helpcenter.component.TeammateHelpKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterViewModel.kt */
final class HelpCenterViewModel$searchBrowseTeamPresenceState$2 extends Lambda implements Function0<ArticleViewState.TeamPresenceState> {
    final /* synthetic */ HelpCenterViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterViewModel$searchBrowseTeamPresenceState$2(HelpCenterViewModel helpCenterViewModel) {
        super(0);
        this.this$0 = helpCenterViewModel;
    }

    public final ArticleViewState.TeamPresenceState invoke() {
        return TeammateHelpKt.computeViewState("", ArticleViewState.TeamPresenceState.Companion.getDefaultTeamPresenceState(), this.this$0.appConfig, this.this$0.teamPresence, this.this$0.place, true);
    }
}
