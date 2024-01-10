package io.intercom.android.sdk.helpcenter.component;

import io.intercom.android.sdk.R;
import io.intercom.android.sdk.helpcenter.articles.ArticleViewState;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.models.TeamPresence;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0000¨\u0006\f"}, d2 = {"computeViewState", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "articleId", "", "currentState", "appConfig", "Lio/intercom/android/sdk/identity/AppConfig;", "teamPresence", "Lio/intercom/android/sdk/models/TeamPresence;", "metricPlace", "isFromSearchBrowse", "", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TeammateHelp.kt */
public final class TeammateHelpKt {
    public static final ArticleViewState.TeamPresenceState computeViewState(String str, ArticleViewState.TeamPresenceState teamPresenceState, AppConfig appConfig, TeamPresence teamPresence, String str2, boolean z) {
        String str3;
        int i;
        Intrinsics.checkNotNullParameter(str, "articleId");
        Intrinsics.checkNotNullParameter(teamPresenceState, "currentState");
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(teamPresence, "teamPresence");
        Intrinsics.checkNotNullParameter(str2, "metricPlace");
        int messageButtonText = teamPresenceState.getMessageButtonText();
        int messageButtonIcon = teamPresenceState.getMessageButtonIcon();
        int messageTitleText = teamPresenceState.getMessageTitleText();
        if (!appConfig.isAccessToTeammateEnabled()) {
            messageButtonText = R.string.intercom_ask_a_question;
            messageButtonIcon = R.drawable.intercom_conversation_card_question;
            messageTitleText = R.string.intercom_bot_expectation_text;
            str3 = MetricTracker.Context.STYLE_BOT;
            i = 8;
        } else {
            str3 = MetricTracker.Context.STYLE_HUMAN;
            i = 0;
        }
        int i2 = messageButtonIcon;
        int i3 = messageButtonText;
        ArticleViewState.Companion companion = ArticleViewState.Companion;
        List<Participant> activeAdmins = teamPresence.getActiveAdmins();
        Intrinsics.checkNotNullExpressionValue(activeAdmins, "teamPresence.activeAdmins");
        List<ArticleViewState.AvatarState> computeAvatarState = companion.computeAvatarState(activeAdmins);
        return ArticleViewState.TeamPresenceState.copy$default(teamPresenceState, str, (ArticleViewState.ConversationState) null, messageTitleText, i3, i2, appConfig.getPrimaryColor(), i, computeAvatarState, str2, str3, z, 2, (Object) null);
    }
}
