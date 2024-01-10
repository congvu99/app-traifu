package io.intercom.android.sdk.helpcenter.articles;

import androidx.core.view.ViewCompat;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.models.Participant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00042\u00020\u0001:\t\u0003\u0004\u0005\u0006\u0007\b\t\n\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState;", "", "()V", "AvatarState", "Companion", "Content", "ConversationState", "Error", "Initial", "ReactionState", "TeamPresenceState", "WebViewStatus", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$Content;", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$Error;", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$Initial;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArticleViewState.kt */
public abstract class ArticleViewState {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$WebViewStatus;", "", "(Ljava/lang/String;I)V", "Idle", "Loading", "Ready", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleViewState.kt */
    public enum WebViewStatus {
        Idle,
        Loading,
        Ready
    }

    public /* synthetic */ ArticleViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$Initial;", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleViewState.kt */
    public static final class Initial extends ArticleViewState {
        public static final int $stable = 0;
        public static final Initial INSTANCE = new Initial();

        private Initial() {
            super((DefaultConstructorMarker) null);
        }
    }

    private ArticleViewState() {
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¨\u0006\b"}, d2 = {"Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$Companion;", "", "()V", "computeAvatarState", "", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$AvatarState;", "activeAdmins", "Lio/intercom/android/sdk/models/Participant;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleViewState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<AvatarState> computeAvatarState(List<? extends Participant> list) {
            int i;
            Intrinsics.checkNotNullParameter(list, "activeAdmins");
            Iterable takeLast = CollectionsKt.takeLast(list, 3);
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(takeLast, 10));
            Iterator it = takeLast.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Avatar avatar = ((Participant) it.next()).getAvatar();
                Intrinsics.checkNotNullExpressionValue(avatar, "it.avatar");
                arrayList.add(new AvatarState(0, avatar));
            }
            List<AvatarState> mutableList = CollectionsKt.toMutableList((List) arrayList);
            int size = 3 - mutableList.size();
            for (i = 0; i < size; i++) {
                Avatar build = new Avatar.Builder().build();
                Intrinsics.checkNotNullExpressionValue(build, "Builder().build()");
                mutableList.add(new AvatarState(8, build));
            }
            return mutableList;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$Content;", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState;", "articleUrl", "", "articleId", "webViewStatus", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$WebViewStatus;", "reactionState", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$ReactionState;", "teamPresenceState", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "(Ljava/lang/String;Ljava/lang/String;Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$WebViewStatus;Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$ReactionState;Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;)V", "getArticleId", "()Ljava/lang/String;", "getArticleUrl", "getReactionState", "()Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$ReactionState;", "getTeamPresenceState", "()Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "getWebViewStatus", "()Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$WebViewStatus;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleViewState.kt */
    public static final class Content extends ArticleViewState {
        public static final int $stable = 8;
        private final String articleId;
        private final String articleUrl;
        private final ReactionState reactionState;
        private final TeamPresenceState teamPresenceState;
        private final WebViewStatus webViewStatus;

        public static /* synthetic */ Content copy$default(Content content, String str, String str2, WebViewStatus webViewStatus2, ReactionState reactionState2, TeamPresenceState teamPresenceState2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = content.articleUrl;
            }
            if ((i & 2) != 0) {
                str2 = content.articleId;
            }
            String str3 = str2;
            if ((i & 4) != 0) {
                webViewStatus2 = content.webViewStatus;
            }
            WebViewStatus webViewStatus3 = webViewStatus2;
            if ((i & 8) != 0) {
                reactionState2 = content.reactionState;
            }
            ReactionState reactionState3 = reactionState2;
            if ((i & 16) != 0) {
                teamPresenceState2 = content.teamPresenceState;
            }
            return content.copy(str, str3, webViewStatus3, reactionState3, teamPresenceState2);
        }

        public final String component1() {
            return this.articleUrl;
        }

        public final String component2() {
            return this.articleId;
        }

        public final WebViewStatus component3() {
            return this.webViewStatus;
        }

        public final ReactionState component4() {
            return this.reactionState;
        }

        public final TeamPresenceState component5() {
            return this.teamPresenceState;
        }

        public final Content copy(String str, String str2, WebViewStatus webViewStatus2, ReactionState reactionState2, TeamPresenceState teamPresenceState2) {
            Intrinsics.checkNotNullParameter(str, "articleUrl");
            Intrinsics.checkNotNullParameter(str2, "articleId");
            Intrinsics.checkNotNullParameter(webViewStatus2, "webViewStatus");
            Intrinsics.checkNotNullParameter(reactionState2, "reactionState");
            Intrinsics.checkNotNullParameter(teamPresenceState2, "teamPresenceState");
            return new Content(str, str2, webViewStatus2, reactionState2, teamPresenceState2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Content)) {
                return false;
            }
            Content content = (Content) obj;
            return Intrinsics.areEqual((Object) this.articleUrl, (Object) content.articleUrl) && Intrinsics.areEqual((Object) this.articleId, (Object) content.articleId) && this.webViewStatus == content.webViewStatus && Intrinsics.areEqual((Object) this.reactionState, (Object) content.reactionState) && Intrinsics.areEqual((Object) this.teamPresenceState, (Object) content.teamPresenceState);
        }

        public int hashCode() {
            return (((((((this.articleUrl.hashCode() * 31) + this.articleId.hashCode()) * 31) + this.webViewStatus.hashCode()) * 31) + this.reactionState.hashCode()) * 31) + this.teamPresenceState.hashCode();
        }

        public String toString() {
            return "Content(articleUrl=" + this.articleUrl + ", articleId=" + this.articleId + ", webViewStatus=" + this.webViewStatus + ", reactionState=" + this.reactionState + ", teamPresenceState=" + this.teamPresenceState + ')';
        }

        public final String getArticleUrl() {
            return this.articleUrl;
        }

        public final String getArticleId() {
            return this.articleId;
        }

        public final WebViewStatus getWebViewStatus() {
            return this.webViewStatus;
        }

        public final ReactionState getReactionState() {
            return this.reactionState;
        }

        public final TeamPresenceState getTeamPresenceState() {
            return this.teamPresenceState;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Content(String str, String str2, WebViewStatus webViewStatus2, ReactionState reactionState2, TeamPresenceState teamPresenceState2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "articleUrl");
            Intrinsics.checkNotNullParameter(str2, "articleId");
            Intrinsics.checkNotNullParameter(webViewStatus2, "webViewStatus");
            Intrinsics.checkNotNullParameter(reactionState2, "reactionState");
            Intrinsics.checkNotNullParameter(teamPresenceState2, "teamPresenceState");
            this.articleUrl = str;
            this.articleId = str2;
            this.webViewStatus = webViewStatus2;
            this.reactionState = reactionState2;
            this.teamPresenceState = teamPresenceState2;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\"\b\b\u0018\u0000 32\u00020\u0001:\u00013Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\b\b\u0001\u0010\t\u001a\u00020\u0007\u0012\b\b\u0001\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0012HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\t\u001a\u00020\u00072\b\b\u0003\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u0010/\u001a\u00020\u00122\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0007HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u001cR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015¨\u00064"}, d2 = {"Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "", "articleId", "", "conversationState", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$ConversationState;", "messageTitleText", "", "messageButtonText", "messageButtonIcon", "messageButtonColor", "avatarComponentVisibility", "avatars", "", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$AvatarState;", "metricPlace", "metricContext", "isFromSearchBrowse", "", "(Ljava/lang/String;Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$ConversationState;IIIIILjava/util/List;Ljava/lang/String;Ljava/lang/String;Z)V", "getArticleId", "()Ljava/lang/String;", "getAvatarComponentVisibility", "()I", "getAvatars", "()Ljava/util/List;", "getConversationState", "()Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$ConversationState;", "()Z", "getMessageButtonColor", "getMessageButtonIcon", "getMessageButtonText", "getMessageTitleText", "getMetricContext", "getMetricPlace", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleViewState.kt */
    public static final class TeamPresenceState {
        public static final int $stable = 8;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final TeamPresenceState defaultTeamPresenceState = new TeamPresenceState("", (ConversationState) null, R.string.intercom_the_team_can_help_if_needed, R.string.intercom_send_us_a_message, R.drawable.intercom_new_conversation_send_button, ViewCompat.MEASURED_STATE_MASK, 8, (List) null, "article", MetricTracker.Context.STYLE_HUMAN, false, 128, (DefaultConstructorMarker) null);
        private final String articleId;
        private final int avatarComponentVisibility;
        private final List<AvatarState> avatars;
        private final ConversationState conversationState;
        private final boolean isFromSearchBrowse;
        private final int messageButtonColor;
        private final int messageButtonIcon;
        private final int messageButtonText;
        private final int messageTitleText;
        private final String metricContext;
        private final String metricPlace;

        public static /* synthetic */ TeamPresenceState copy$default(TeamPresenceState teamPresenceState, String str, ConversationState conversationState2, int i, int i2, int i3, int i4, int i5, List list, String str2, String str3, boolean z, int i6, Object obj) {
            TeamPresenceState teamPresenceState2 = teamPresenceState;
            int i7 = i6;
            return teamPresenceState.copy((i7 & 1) != 0 ? teamPresenceState2.articleId : str, (i7 & 2) != 0 ? teamPresenceState2.conversationState : conversationState2, (i7 & 4) != 0 ? teamPresenceState2.messageTitleText : i, (i7 & 8) != 0 ? teamPresenceState2.messageButtonText : i2, (i7 & 16) != 0 ? teamPresenceState2.messageButtonIcon : i3, (i7 & 32) != 0 ? teamPresenceState2.messageButtonColor : i4, (i7 & 64) != 0 ? teamPresenceState2.avatarComponentVisibility : i5, (i7 & 128) != 0 ? teamPresenceState2.avatars : list, (i7 & 256) != 0 ? teamPresenceState2.metricPlace : str2, (i7 & 512) != 0 ? teamPresenceState2.metricContext : str3, (i7 & 1024) != 0 ? teamPresenceState2.isFromSearchBrowse : z);
        }

        public final String component1() {
            return this.articleId;
        }

        public final String component10() {
            return this.metricContext;
        }

        public final boolean component11() {
            return this.isFromSearchBrowse;
        }

        public final ConversationState component2() {
            return this.conversationState;
        }

        public final int component3() {
            return this.messageTitleText;
        }

        public final int component4() {
            return this.messageButtonText;
        }

        public final int component5() {
            return this.messageButtonIcon;
        }

        public final int component6() {
            return this.messageButtonColor;
        }

        public final int component7() {
            return this.avatarComponentVisibility;
        }

        public final List<AvatarState> component8() {
            return this.avatars;
        }

        public final String component9() {
            return this.metricPlace;
        }

        public final TeamPresenceState copy(String str, ConversationState conversationState2, int i, int i2, int i3, int i4, int i5, List<AvatarState> list, String str2, String str3, boolean z) {
            Intrinsics.checkNotNullParameter(str, "articleId");
            List<AvatarState> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "avatars");
            String str4 = str2;
            Intrinsics.checkNotNullParameter(str4, "metricPlace");
            String str5 = str3;
            Intrinsics.checkNotNullParameter(str5, "metricContext");
            return new TeamPresenceState(str, conversationState2, i, i2, i3, i4, i5, list2, str4, str5, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TeamPresenceState)) {
                return false;
            }
            TeamPresenceState teamPresenceState = (TeamPresenceState) obj;
            return Intrinsics.areEqual((Object) this.articleId, (Object) teamPresenceState.articleId) && Intrinsics.areEqual((Object) this.conversationState, (Object) teamPresenceState.conversationState) && this.messageTitleText == teamPresenceState.messageTitleText && this.messageButtonText == teamPresenceState.messageButtonText && this.messageButtonIcon == teamPresenceState.messageButtonIcon && this.messageButtonColor == teamPresenceState.messageButtonColor && this.avatarComponentVisibility == teamPresenceState.avatarComponentVisibility && Intrinsics.areEqual((Object) this.avatars, (Object) teamPresenceState.avatars) && Intrinsics.areEqual((Object) this.metricPlace, (Object) teamPresenceState.metricPlace) && Intrinsics.areEqual((Object) this.metricContext, (Object) teamPresenceState.metricContext) && this.isFromSearchBrowse == teamPresenceState.isFromSearchBrowse;
        }

        public int hashCode() {
            int hashCode = this.articleId.hashCode() * 31;
            ConversationState conversationState2 = this.conversationState;
            int hashCode2 = (((((((((((((((((hashCode + (conversationState2 == null ? 0 : conversationState2.hashCode())) * 31) + this.messageTitleText) * 31) + this.messageButtonText) * 31) + this.messageButtonIcon) * 31) + this.messageButtonColor) * 31) + this.avatarComponentVisibility) * 31) + this.avatars.hashCode()) * 31) + this.metricPlace.hashCode()) * 31) + this.metricContext.hashCode()) * 31;
            boolean z = this.isFromSearchBrowse;
            if (z) {
                z = true;
            }
            return hashCode2 + (z ? 1 : 0);
        }

        public String toString() {
            return "TeamPresenceState(articleId=" + this.articleId + ", conversationState=" + this.conversationState + ", messageTitleText=" + this.messageTitleText + ", messageButtonText=" + this.messageButtonText + ", messageButtonIcon=" + this.messageButtonIcon + ", messageButtonColor=" + this.messageButtonColor + ", avatarComponentVisibility=" + this.avatarComponentVisibility + ", avatars=" + this.avatars + ", metricPlace=" + this.metricPlace + ", metricContext=" + this.metricContext + ", isFromSearchBrowse=" + this.isFromSearchBrowse + ')';
        }

        public TeamPresenceState(String str, ConversationState conversationState2, int i, int i2, int i3, int i4, int i5, List<AvatarState> list, String str2, String str3, boolean z) {
            Intrinsics.checkNotNullParameter(str, "articleId");
            Intrinsics.checkNotNullParameter(list, "avatars");
            Intrinsics.checkNotNullParameter(str2, "metricPlace");
            Intrinsics.checkNotNullParameter(str3, "metricContext");
            this.articleId = str;
            this.conversationState = conversationState2;
            this.messageTitleText = i;
            this.messageButtonText = i2;
            this.messageButtonIcon = i3;
            this.messageButtonColor = i4;
            this.avatarComponentVisibility = i5;
            this.avatars = list;
            this.metricPlace = str2;
            this.metricContext = str3;
            this.isFromSearchBrowse = z;
        }

        public final String getArticleId() {
            return this.articleId;
        }

        public final ConversationState getConversationState() {
            return this.conversationState;
        }

        public final int getMessageTitleText() {
            return this.messageTitleText;
        }

        public final int getMessageButtonText() {
            return this.messageButtonText;
        }

        public final int getMessageButtonIcon() {
            return this.messageButtonIcon;
        }

        public final int getMessageButtonColor() {
            return this.messageButtonColor;
        }

        public final int getAvatarComponentVisibility() {
            return this.avatarComponentVisibility;
        }

        public final List<AvatarState> getAvatars() {
            return this.avatars;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ TeamPresenceState(java.lang.String r16, io.intercom.android.sdk.helpcenter.articles.ArticleViewState.ConversationState r17, int r18, int r19, int r20, int r21, int r22, java.util.List r23, java.lang.String r24, java.lang.String r25, boolean r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
            /*
                r15 = this;
                r0 = r27
                r1 = r0 & 128(0x80, float:1.794E-43)
                r2 = 0
                if (r1 == 0) goto L_0x004f
                r1 = 3
                io.intercom.android.sdk.helpcenter.articles.ArticleViewState$AvatarState[] r1 = new io.intercom.android.sdk.helpcenter.articles.ArticleViewState.AvatarState[r1]
                io.intercom.android.sdk.helpcenter.articles.ArticleViewState$AvatarState r3 = new io.intercom.android.sdk.helpcenter.articles.ArticleViewState$AvatarState
                io.intercom.android.sdk.models.Avatar$Builder r4 = new io.intercom.android.sdk.models.Avatar$Builder
                r4.<init>()
                io.intercom.android.sdk.models.Avatar r4 = r4.build()
                java.lang.String r5 = "Builder().build()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
                r6 = 8
                r3.<init>(r6, r4)
                r1[r2] = r3
                r3 = 1
                io.intercom.android.sdk.helpcenter.articles.ArticleViewState$AvatarState r4 = new io.intercom.android.sdk.helpcenter.articles.ArticleViewState$AvatarState
                io.intercom.android.sdk.models.Avatar$Builder r7 = new io.intercom.android.sdk.models.Avatar$Builder
                r7.<init>()
                io.intercom.android.sdk.models.Avatar r7 = r7.build()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
                r4.<init>(r6, r7)
                r1[r3] = r4
                r3 = 2
                io.intercom.android.sdk.helpcenter.articles.ArticleViewState$AvatarState r4 = new io.intercom.android.sdk.helpcenter.articles.ArticleViewState$AvatarState
                io.intercom.android.sdk.models.Avatar$Builder r7 = new io.intercom.android.sdk.models.Avatar$Builder
                r7.<init>()
                io.intercom.android.sdk.models.Avatar r7 = r7.build()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
                r4.<init>(r6, r7)
                r1[r3] = r4
                java.util.List r1 = kotlin.collections.CollectionsKt.listOf(r1)
                r11 = r1
                goto L_0x0051
            L_0x004f:
                r11 = r23
            L_0x0051:
                r0 = r0 & 1024(0x400, float:1.435E-42)
                if (r0 == 0) goto L_0x0057
                r14 = 0
                goto L_0x0059
            L_0x0057:
                r14 = r26
            L_0x0059:
                r3 = r15
                r4 = r16
                r5 = r17
                r6 = r18
                r7 = r19
                r8 = r20
                r9 = r21
                r10 = r22
                r12 = r24
                r13 = r25
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.helpcenter.articles.ArticleViewState.TeamPresenceState.<init>(java.lang.String, io.intercom.android.sdk.helpcenter.articles.ArticleViewState$ConversationState, int, int, int, int, int, java.util.List, java.lang.String, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getMetricPlace() {
            return this.metricPlace;
        }

        public final String getMetricContext() {
            return this.metricContext;
        }

        public final boolean isFromSearchBrowse() {
            return this.isFromSearchBrowse;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState$Companion;", "", "()V", "defaultTeamPresenceState", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "getDefaultTeamPresenceState", "()Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: ArticleViewState.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final TeamPresenceState getDefaultTeamPresenceState() {
                return TeamPresenceState.defaultTeamPresenceState;
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$ConversationState;", "", "conversationId", "", "lastParticipatingAdmin", "Lio/intercom/android/sdk/models/LastParticipatingAdmin;", "(Ljava/lang/String;Lio/intercom/android/sdk/models/LastParticipatingAdmin;)V", "getConversationId", "()Ljava/lang/String;", "getLastParticipatingAdmin", "()Lio/intercom/android/sdk/models/LastParticipatingAdmin;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleViewState.kt */
    public static final class ConversationState {
        public static final int $stable = 8;
        private final String conversationId;
        private final LastParticipatingAdmin lastParticipatingAdmin;

        public static /* synthetic */ ConversationState copy$default(ConversationState conversationState, String str, LastParticipatingAdmin lastParticipatingAdmin2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = conversationState.conversationId;
            }
            if ((i & 2) != 0) {
                lastParticipatingAdmin2 = conversationState.lastParticipatingAdmin;
            }
            return conversationState.copy(str, lastParticipatingAdmin2);
        }

        public final String component1() {
            return this.conversationId;
        }

        public final LastParticipatingAdmin component2() {
            return this.lastParticipatingAdmin;
        }

        public final ConversationState copy(String str, LastParticipatingAdmin lastParticipatingAdmin2) {
            Intrinsics.checkNotNullParameter(str, "conversationId");
            Intrinsics.checkNotNullParameter(lastParticipatingAdmin2, "lastParticipatingAdmin");
            return new ConversationState(str, lastParticipatingAdmin2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ConversationState)) {
                return false;
            }
            ConversationState conversationState = (ConversationState) obj;
            return Intrinsics.areEqual((Object) this.conversationId, (Object) conversationState.conversationId) && Intrinsics.areEqual((Object) this.lastParticipatingAdmin, (Object) conversationState.lastParticipatingAdmin);
        }

        public int hashCode() {
            return (this.conversationId.hashCode() * 31) + this.lastParticipatingAdmin.hashCode();
        }

        public String toString() {
            return "ConversationState(conversationId=" + this.conversationId + ", lastParticipatingAdmin=" + this.lastParticipatingAdmin + ')';
        }

        public ConversationState(String str, LastParticipatingAdmin lastParticipatingAdmin2) {
            Intrinsics.checkNotNullParameter(str, "conversationId");
            Intrinsics.checkNotNullParameter(lastParticipatingAdmin2, "lastParticipatingAdmin");
            this.conversationId = str;
            this.lastParticipatingAdmin = lastParticipatingAdmin2;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        public final LastParticipatingAdmin getLastParticipatingAdmin() {
            return this.lastParticipatingAdmin;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$ReactionState;", "", "reactionComponentVisibility", "", "transitionState", "teamHelpVisibility", "shouldScrollToBottom", "", "(IIIZ)V", "getReactionComponentVisibility", "()I", "getShouldScrollToBottom", "()Z", "getTeamHelpVisibility", "getTransitionState", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleViewState.kt */
    public static final class ReactionState {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final ReactionState defaultReactionState = new ReactionState(8, R.id.start, 8, false);
        private final int reactionComponentVisibility;
        private final boolean shouldScrollToBottom;
        private final int teamHelpVisibility;
        private final int transitionState;

        public static /* synthetic */ ReactionState copy$default(ReactionState reactionState, int i, int i2, int i3, boolean z, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = reactionState.reactionComponentVisibility;
            }
            if ((i4 & 2) != 0) {
                i2 = reactionState.transitionState;
            }
            if ((i4 & 4) != 0) {
                i3 = reactionState.teamHelpVisibility;
            }
            if ((i4 & 8) != 0) {
                z = reactionState.shouldScrollToBottom;
            }
            return reactionState.copy(i, i2, i3, z);
        }

        public final int component1() {
            return this.reactionComponentVisibility;
        }

        public final int component2() {
            return this.transitionState;
        }

        public final int component3() {
            return this.teamHelpVisibility;
        }

        public final boolean component4() {
            return this.shouldScrollToBottom;
        }

        public final ReactionState copy(int i, int i2, int i3, boolean z) {
            return new ReactionState(i, i2, i3, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReactionState)) {
                return false;
            }
            ReactionState reactionState = (ReactionState) obj;
            return this.reactionComponentVisibility == reactionState.reactionComponentVisibility && this.transitionState == reactionState.transitionState && this.teamHelpVisibility == reactionState.teamHelpVisibility && this.shouldScrollToBottom == reactionState.shouldScrollToBottom;
        }

        public int hashCode() {
            int i = ((((this.reactionComponentVisibility * 31) + this.transitionState) * 31) + this.teamHelpVisibility) * 31;
            boolean z = this.shouldScrollToBottom;
            if (z) {
                z = true;
            }
            return i + (z ? 1 : 0);
        }

        public String toString() {
            return "ReactionState(reactionComponentVisibility=" + this.reactionComponentVisibility + ", transitionState=" + this.transitionState + ", teamHelpVisibility=" + this.teamHelpVisibility + ", shouldScrollToBottom=" + this.shouldScrollToBottom + ')';
        }

        public ReactionState(int i, int i2, int i3, boolean z) {
            this.reactionComponentVisibility = i;
            this.transitionState = i2;
            this.teamHelpVisibility = i3;
            this.shouldScrollToBottom = z;
        }

        public final int getReactionComponentVisibility() {
            return this.reactionComponentVisibility;
        }

        public final int getTransitionState() {
            return this.transitionState;
        }

        public final int getTeamHelpVisibility() {
            return this.teamHelpVisibility;
        }

        public final boolean getShouldScrollToBottom() {
            return this.shouldScrollToBottom;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$ReactionState$Companion;", "", "()V", "defaultReactionState", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$ReactionState;", "getDefaultReactionState", "()Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$ReactionState;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: ArticleViewState.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ReactionState getDefaultReactionState() {
                return ReactionState.defaultReactionState;
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$AvatarState;", "", "visibility", "", "avatar", "Lio/intercom/android/sdk/models/Avatar;", "(ILio/intercom/android/sdk/models/Avatar;)V", "getAvatar", "()Lio/intercom/android/sdk/models/Avatar;", "getVisibility", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleViewState.kt */
    public static final class AvatarState {
        public static final int $stable = 8;
        private final Avatar avatar;
        private final int visibility;

        public static /* synthetic */ AvatarState copy$default(AvatarState avatarState, int i, Avatar avatar2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = avatarState.visibility;
            }
            if ((i2 & 2) != 0) {
                avatar2 = avatarState.avatar;
            }
            return avatarState.copy(i, avatar2);
        }

        public final int component1() {
            return this.visibility;
        }

        public final Avatar component2() {
            return this.avatar;
        }

        public final AvatarState copy(int i, Avatar avatar2) {
            Intrinsics.checkNotNullParameter(avatar2, "avatar");
            return new AvatarState(i, avatar2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AvatarState)) {
                return false;
            }
            AvatarState avatarState = (AvatarState) obj;
            return this.visibility == avatarState.visibility && Intrinsics.areEqual((Object) this.avatar, (Object) avatarState.avatar);
        }

        public int hashCode() {
            return (this.visibility * 31) + this.avatar.hashCode();
        }

        public String toString() {
            return "AvatarState(visibility=" + this.visibility + ", avatar=" + this.avatar + ')';
        }

        public AvatarState(int i, Avatar avatar2) {
            Intrinsics.checkNotNullParameter(avatar2, "avatar");
            this.visibility = i;
            this.avatar = avatar2;
        }

        public final int getVisibility() {
            return this.visibility;
        }

        public final Avatar getAvatar() {
            return this.avatar;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$Error;", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState;", "message", "", "retryButtonVisibility", "retryButtonPrimaryColor", "(III)V", "getMessage", "()I", "getRetryButtonPrimaryColor", "getRetryButtonVisibility", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleViewState.kt */
    public static final class Error extends ArticleViewState {
        public static final int $stable = 0;
        private final int message;
        private final int retryButtonPrimaryColor;
        private final int retryButtonVisibility;

        public static /* synthetic */ Error copy$default(Error error, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = error.message;
            }
            if ((i4 & 2) != 0) {
                i2 = error.retryButtonVisibility;
            }
            if ((i4 & 4) != 0) {
                i3 = error.retryButtonPrimaryColor;
            }
            return error.copy(i, i2, i3);
        }

        public final int component1() {
            return this.message;
        }

        public final int component2() {
            return this.retryButtonVisibility;
        }

        public final int component3() {
            return this.retryButtonPrimaryColor;
        }

        public final Error copy(int i, int i2, int i3) {
            return new Error(i, i2, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return this.message == error.message && this.retryButtonVisibility == error.retryButtonVisibility && this.retryButtonPrimaryColor == error.retryButtonPrimaryColor;
        }

        public int hashCode() {
            return (((this.message * 31) + this.retryButtonVisibility) * 31) + this.retryButtonPrimaryColor;
        }

        public String toString() {
            return "Error(message=" + this.message + ", retryButtonVisibility=" + this.retryButtonVisibility + ", retryButtonPrimaryColor=" + this.retryButtonPrimaryColor + ')';
        }

        public final int getMessage() {
            return this.message;
        }

        public final int getRetryButtonVisibility() {
            return this.retryButtonVisibility;
        }

        public final int getRetryButtonPrimaryColor() {
            return this.retryButtonPrimaryColor;
        }

        public Error(int i, int i2, int i3) {
            super((DefaultConstructorMarker) null);
            this.message = i;
            this.retryButtonVisibility = i2;
            this.retryButtonPrimaryColor = i3;
        }
    }
}
