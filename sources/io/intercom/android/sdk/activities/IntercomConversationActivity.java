package io.intercom.android.sdk.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.conversation.ConversationFragment;
import io.intercom.android.sdk.helpcenter.articles.ArticleStatsArguments;
import io.intercom.android.sdk.models.ConfigModules;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.utilities.ApplyStatusBarColorKt;
import io.intercom.android.sdk.utilities.ColorUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016R?\u0010\u0004\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00058BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lio/intercom/android/sdk/activities/IntercomConversationActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lio/intercom/android/sdk/conversation/ConversationFragment$Listener;", "()V", "store", "Lio/intercom/android/sdk/store/Store;", "Lio/intercom/android/sdk/state/State;", "kotlin.jvm.PlatformType", "getStore", "()Lio/intercom/android/sdk/store/Store;", "store$delegate", "Lkotlin/Lazy;", "onBackClicked", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStartAnotherConversation", "closedConversationId", "", "onToolbarCloseClicked", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomConversationActivity.kt */
public final class IntercomConversationActivity extends AppCompatActivity implements ConversationFragment.Listener {
    /* access modifiers changed from: private */
    public static final String ARTICLE_ARGS = "articleArgs";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String LAST_PARTICIPANT = "last_participant";
    /* access modifiers changed from: private */
    public static final String PARCEL_CONVERSATION_ID = "parcel_conversation_id";
    /* access modifiers changed from: private */
    public static final String PARCEL_INITIAL_MESSAGE = "parcel_initial_message";
    /* access modifiers changed from: private */
    public static final String SHOW_HOME_SCREEN = "showHomeScreen";
    /* access modifiers changed from: private */
    public static final String SHOW_INBOX = "showInbox";
    private final Lazy store$delegate = LazyKt.lazy(IntercomConversationActivity$store$2.INSTANCE);

    private final Store<State> getStore() {
        return (Store) this.store$delegate.getValue();
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004J\u0016\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aJ\"\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u001f"}, d2 = {"Lio/intercom/android/sdk/activities/IntercomConversationActivity$Companion;", "", "()V", "ARTICLE_ARGS", "", "getARTICLE_ARGS", "()Ljava/lang/String;", "LAST_PARTICIPANT", "getLAST_PARTICIPANT", "PARCEL_CONVERSATION_ID", "getPARCEL_CONVERSATION_ID$annotations", "getPARCEL_CONVERSATION_ID", "PARCEL_INITIAL_MESSAGE", "getPARCEL_INITIAL_MESSAGE$annotations", "getPARCEL_INITIAL_MESSAGE", "SHOW_HOME_SCREEN", "getSHOW_HOME_SCREEN", "SHOW_INBOX", "getSHOW_INBOX", "openComposer", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "initialMessage", "openComposerFromArticle", "articleArgs", "Lio/intercom/android/sdk/helpcenter/articles/ArticleStatsArguments;", "openConversation", "conversationId", "lastParticipatingAdmin", "Lio/intercom/android/sdk/models/LastParticipatingAdmin;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomConversationActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getPARCEL_CONVERSATION_ID$annotations() {
        }

        public static /* synthetic */ void getPARCEL_INITIAL_MESSAGE$annotations() {
        }

        private Companion() {
        }

        public final String getPARCEL_CONVERSATION_ID() {
            return IntercomConversationActivity.PARCEL_CONVERSATION_ID;
        }

        public final String getPARCEL_INITIAL_MESSAGE() {
            return IntercomConversationActivity.PARCEL_INITIAL_MESSAGE;
        }

        public final String getSHOW_HOME_SCREEN() {
            return IntercomConversationActivity.SHOW_HOME_SCREEN;
        }

        public final String getSHOW_INBOX() {
            return IntercomConversationActivity.SHOW_INBOX;
        }

        public final String getARTICLE_ARGS() {
            return IntercomConversationActivity.ARTICLE_ARGS;
        }

        public final String getLAST_PARTICIPANT() {
            return IntercomConversationActivity.LAST_PARTICIPANT;
        }

        public final Intent openConversation(Context context, String str, LastParticipatingAdmin lastParticipatingAdmin) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent putExtra = new Intent(context, IntercomConversationActivity.class).setFlags(268435456).putExtra(getSHOW_INBOX(), false);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, Intercom…tExtra(SHOW_INBOX, false)");
            if (!TextUtils.isEmpty(str)) {
                putExtra.putExtra(getPARCEL_CONVERSATION_ID(), str);
            }
            if (!LastParticipatingAdmin.isNull(lastParticipatingAdmin)) {
                putExtra.putExtra(getLAST_PARTICIPANT(), lastParticipatingAdmin);
            }
            putExtra.setExtrasClassLoader(LastParticipatingAdmin.class.getClassLoader());
            return putExtra;
        }

        public final Intent openComposer(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "initialMessage");
            Intent putExtra = new Intent(context, IntercomConversationActivity.class).setFlags(268435456).putExtra(getSHOW_INBOX(), false);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, Intercom…tExtra(SHOW_INBOX, false)");
            if (!TextUtils.isEmpty(str)) {
                putExtra.putExtra(getPARCEL_INITIAL_MESSAGE(), str);
            }
            return putExtra;
        }

        public final Intent openComposerFromArticle(Context context, ArticleStatsArguments articleStatsArguments) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(articleStatsArguments, "articleArgs");
            Intent intent = new Intent(context, IntercomConversationActivity.class);
            intent.setFlags(268435456);
            intent.putExtra(IntercomConversationActivity.Companion.getARTICLE_ARGS(), articleStatsArguments);
            intent.putExtra(IntercomConversationActivity.Companion.getSHOW_INBOX(), false);
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.intercom_conversation_view);
        ConfigModules configModules = Injector.get().getAppConfigProvider().get().getConfigModules();
        if (configModules != null) {
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "window");
            ApplyStatusBarColorKt.applyStatusBarColor(window, ColorUtils.parseColor(configModules.getCustomization().getHeader().getBackgroundColor()));
        }
        Bundle extras = getIntent().getExtras();
        Intrinsics.checkNotNull(extras);
        extras.setClassLoader(Part.class.getClassLoader());
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, ConversationFragment.newInstance(extras.getString(PARCEL_CONVERSATION_ID, ""), extras.containsKey(LAST_PARTICIPANT) ? (LastParticipatingAdmin) extras.getParcelable(LAST_PARTICIPANT) : null, false, extras.getString(PARCEL_INITIAL_MESSAGE, ""), CollectionsKt.emptyList(), "", extras.containsKey(ARTICLE_ARGS) ? (ArticleStatsArguments) extras.getParcelable(ARTICLE_ARGS) : null)).commit();
        overridePendingTransition(R.anim.intercom_fade_in, R.anim.intercom_fade_out);
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.intercom_fade_in, R.anim.intercom_fade_out);
    }

    public void onToolbarCloseClicked() {
        onBackPressed();
    }

    public void onBackClicked() {
        onBackPressed();
    }

    public void onStartAnotherConversation(String str) {
        Intrinsics.checkNotNullParameter(str, "closedConversationId");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, ConversationFragment.newInstance("", LastParticipatingAdmin.NULL, false, "", CollectionsKt.emptyList(), str, (ArticleStatsArguments) null)).commit();
    }
}
