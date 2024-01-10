package io.intercom.android.sdk;

import android.app.Application;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.intercom.twig.Twig;
import com.trainerfu.utils.ResultCode;
import io.intercom.android.nexus.NexusClient;
import io.intercom.android.sdk.IntercomContent;
import io.intercom.android.sdk.IntercomPushManager;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.activities.IntercomCarouselActivity;
import io.intercom.android.sdk.activities.IntercomConversationActivity;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.api.DeDuper;
import io.intercom.android.sdk.api.UserUpdateRequest;
import io.intercom.android.sdk.api.UserUpdater;
import io.intercom.android.sdk.errorreporting.ErrorReporter;
import io.intercom.android.sdk.helpcenter.api.CollectionContentRequestCallback;
import io.intercom.android.sdk.helpcenter.api.CollectionRequestCallback;
import io.intercom.android.sdk.helpcenter.api.HelpCenterApiWrapper;
import io.intercom.android.sdk.helpcenter.api.SearchRequestCallback;
import io.intercom.android.sdk.helpcenter.articles.ArticleActivity;
import io.intercom.android.sdk.helpcenter.utils.HelpCenterUrlUtilsKt;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.FeatureFlag;
import io.intercom.android.sdk.identity.Registration;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.m5.IntercomRootActivityLauncher;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.overlay.LauncherOpenBehaviour;
import io.intercom.android.sdk.overlay.OverlayPresenter;
import io.intercom.android.sdk.push.SystemNotificationManager;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.store.UnreadCountTracker;
import io.intercom.android.sdk.survey.ui.IntercomSurveyActivity;
import io.intercom.android.sdk.user.DeviceData;
import io.intercom.android.sdk.utilities.ActivityFinisher;
import io.intercom.android.sdk.utilities.AttributeSanitiser;
import io.intercom.android.sdk.utilities.PreferenceKeys;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 w2\u00020\u0001:\u0003wxyB\u0001\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#¢\u0006\u0002\u0010$J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/H\u0007J\u0012\u00100\u001a\u00020*2\b\u00101\u001a\u0004\u0018\u00010/H\u0007J\b\u00102\u001a\u00020*H\u0007J\b\u00103\u001a\u00020*H\u0007J\u001a\u00104\u001a\u00020*2\u0010\u00105\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010/\u0018\u000106H\u0007J\u0006\u00107\u001a\u00020*J\u0010\u00107\u001a\u00020*2\b\u00108\u001a\u0004\u0018\u00010/J\b\u00109\u001a\u00020*H\u0007J\u0010\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u00020/H\u0007J\u001a\u0010<\u001a\u00020*2\b\u0010=\u001a\u0004\u0018\u00010/2\b\u0010>\u001a\u0004\u0018\u00010?J\u0010\u0010@\u001a\u00020*2\b\u0010A\u001a\u0004\u0018\u00010BJ\u0006\u0010C\u001a\u00020*J\u0010\u0010C\u001a\u00020*2\b\u0010D\u001a\u0004\u0018\u00010EJ\u0006\u0010F\u001a\u00020*J\u0010\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020/H\u0002J\u000e\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020/J$\u0010I\u001a\u00020*2\b\u0010J\u001a\u0004\u0018\u00010/2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0002\b\u0003\u0018\u00010LJ$\u0010M\u001a\u00020*2\b\u0010J\u001a\u0004\u0018\u00010/2\u0010\u0010N\u001a\f\u0012\u0004\u0012\u00020/\u0012\u0002\b\u00030LH\u0002J\u0018\u0010O\u001a\u00020*2\u0006\u0010P\u001a\u00020Q2\b\b\u0002\u0010R\u001a\u00020SJ\u0010\u0010T\u001a\u00020*2\b\b\u0002\u0010R\u001a\u00020SJ\u0006\u0010U\u001a\u00020*J\b\u0010V\u001a\u00020WH\u0002J\u001c\u0010X\u001a\u00020*2\b\u0010Y\u001a\u0004\u0018\u00010/2\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J&\u0010Z\u001a\u00020*2\u0014\u0010[\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0006\u0012\u0004\u0018\u00010\u00010L2\u0006\u0010R\u001a\u00020SH\u0002J\u0012\u0010\\\u001a\u00020*2\b\b\u0002\u0010]\u001a\u00020^H\u0007J\u000e\u0010_\u001a\u00020*2\u0006\u0010`\u001a\u00020aJ\u0012\u0010b\u001a\u00020*2\b\u0010P\u001a\u0004\u0018\u00010QH\u0007J\b\u0010c\u001a\u00020*H\u0007J\u0010\u0010d\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,J\b\u0010e\u001a\u00020*H\u0007J\u001a\u0010f\u001a\u00020*2\b\u0010g\u001a\u0004\u0018\u00010/2\b\u0010h\u001a\u0004\u0018\u00010iJ\u000e\u0010j\u001a\u00020*2\u0006\u0010k\u001a\u00020&J\u0010\u0010l\u001a\u00020*2\b\u0010m\u001a\u0004\u0018\u00010nJ\u0010\u0010o\u001a\u00020*2\b\u0010m\u001a\u0004\u0018\u00010nJ\u000e\u0010p\u001a\u00020*2\u0006\u0010q\u001a\u00020/J\b\u0010r\u001a\u00020WH\u0002J\b\u0010s\u001a\u00020*H\u0002J\u0018\u0010t\u001a\u00020*2\u0006\u0010[\u001a\u00020u2\b\b\u0002\u0010R\u001a\u00020SJ\u0012\u0010t\u001a\u00020*2\b\u0010[\u001a\u0004\u0018\u00010uH\u0007J\u0010\u0010v\u001a\u00020W2\u0006\u0010P\u001a\u00020QH\u0002R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006z"}, d2 = {"Lio/intercom/android/sdk/Intercom;", "", "superDeDuper", "Lio/intercom/android/sdk/api/DeDuper;", "apiProvider", "Lio/intercom/android/sdk/Provider;", "Lio/intercom/android/sdk/api/Api;", "nexusClient", "Lio/intercom/android/nexus/NexusClient;", "store", "Lio/intercom/android/sdk/store/Store;", "Lio/intercom/android/sdk/state/State;", "unreadCountTracker", "Lio/intercom/android/sdk/store/UnreadCountTracker;", "metricTracker", "Lio/intercom/android/sdk/metrics/MetricTracker;", "errorReporter", "Lio/intercom/android/sdk/errorreporting/ErrorReporter;", "context", "Landroid/content/Context;", "overlayPresenter", "Lio/intercom/android/sdk/overlay/OverlayPresenter;", "appConfigProvider", "Lio/intercom/android/sdk/identity/AppConfig;", "userIdentity", "Lio/intercom/android/sdk/identity/UserIdentity;", "systemNotificationManager", "Lio/intercom/android/sdk/push/SystemNotificationManager;", "userUpdater", "Lio/intercom/android/sdk/api/UserUpdater;", "resetManager", "Lio/intercom/android/sdk/ResetManager;", "twig", "Lcom/intercom/twig/Twig;", "activityFinisher", "Lio/intercom/android/sdk/utilities/ActivityFinisher;", "(Lio/intercom/android/sdk/api/DeDuper;Lio/intercom/android/sdk/Provider;Lio/intercom/android/nexus/NexusClient;Lio/intercom/android/sdk/store/Store;Lio/intercom/android/sdk/store/UnreadCountTracker;Lio/intercom/android/sdk/metrics/MetricTracker;Lio/intercom/android/sdk/errorreporting/ErrorReporter;Landroid/content/Context;Lio/intercom/android/sdk/overlay/OverlayPresenter;Lio/intercom/android/sdk/Provider;Lio/intercom/android/sdk/identity/UserIdentity;Lio/intercom/android/sdk/push/SystemNotificationManager;Lio/intercom/android/sdk/Provider;Lio/intercom/android/sdk/ResetManager;Lcom/intercom/twig/Twig;Lio/intercom/android/sdk/utilities/ActivityFinisher;)V", "unreadConversationCount", "", "getUnreadConversationCount", "()I", "addUnreadConversationCountListener", "", "listener", "Lio/intercom/android/sdk/UnreadConversationCountListener;", "displayArticle", "articleId", "", "displayCarousel", "carouselId", "displayConversationsList", "displayHelpCenter", "displayHelpCenterCollections", "collectionIds", "", "displayMessageComposer", "initialMessage", "displayMessenger", "displaySurvey", "surveyId", "fetchHelpCenterCollection", "collectionId", "collectionContentRequestCallback", "Lio/intercom/android/sdk/helpcenter/api/CollectionContentRequestCallback;", "fetchHelpCenterCollections", "collectionRequestCallback", "Lio/intercom/android/sdk/helpcenter/api/CollectionRequestCallback;", "handlePushMessage", "customStack", "Landroid/app/TaskStackBuilder;", "hideIntercom", "logErrorAndOpenInbox", "error", "logEvent", "name", "metaData", "", "logEventWithValidation", "metadata", "loginIdentifiedUser", "userRegistration", "Lio/intercom/android/sdk/identity/Registration;", "intercomStatusCallback", "Lio/intercom/android/sdk/IntercomStatusCallback;", "loginUnidentifiedUser", "logout", "noUserRegistered", "", "openIntercomChatPush", "pushDataString", "performUpdate", "userAttributes", "present", "space", "Lio/intercom/android/sdk/IntercomSpace;", "presentContent", "content", "Lio/intercom/android/sdk/IntercomContent;", "registerIdentifiedUser", "registerUnidentifiedUser", "removeUnreadConversationCountListener", "reset", "searchHelpCenter", "searchTerm", "searchRequestCallback", "Lio/intercom/android/sdk/helpcenter/api/SearchRequestCallback;", "setBottomPadding", "bottomPadding", "setInAppMessageVisibility", "visibility", "Lio/intercom/android/sdk/Intercom$Visibility;", "setLauncherVisibility", "setUserHash", "userHash", "shouldDisableErrorReporting", "softRegister", "updateUser", "Lio/intercom/android/sdk/UserAttributes;", "userIsRegistered", "Companion", "LogLevel", "Visibility", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Intercom.kt */
public final class Intercom {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final Visibility GONE = Visibility.GONE;
    public static final String PUSH_RECEIVER = "intercom_sdk";
    /* access modifiers changed from: private */
    public static final Twig TWIG = LumberMill.getLogger();
    public static final Visibility VISIBLE = Visibility.VISIBLE;
    /* access modifiers changed from: private */
    public static Intercom instance;
    private final ActivityFinisher activityFinisher;
    private final Provider<Api> apiProvider;
    private final Provider<AppConfig> appConfigProvider;
    private final Context context;
    private final MetricTracker metricTracker;
    private final NexusClient nexusClient;
    private final OverlayPresenter overlayPresenter;
    private final ResetManager resetManager;
    private final Store<State> store;
    private final DeDuper superDeDuper;
    private final SystemNotificationManager systemNotificationManager;
    private final Twig twig;
    private final UnreadCountTracker unreadCountTracker;
    private final UserIdentity userIdentity;
    private final Provider<UserUpdater> userUpdater;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lio/intercom/android/sdk/Intercom$Visibility;", "", "(Ljava/lang/String;I)V", "GONE", "VISIBLE", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Intercom.kt */
    public enum Visibility {
        GONE,
        VISIBLE
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Intercom.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[IntercomPushManager.IntercomPushIntegrationType.values().length];
            iArr[IntercomPushManager.IntercomPushIntegrationType.FCM.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[IntercomSpace.values().length];
            iArr2[IntercomSpace.HelpCenter.ordinal()] = 1;
            iArr2[IntercomSpace.Home.ordinal()] = 2;
            iArr2[IntercomSpace.Messages.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @JvmStatic
    public static final synchronized Intercom client() {
        Intercom client;
        synchronized (Intercom.class) {
            client = Companion.client();
        }
        return client;
    }

    @JvmStatic
    public static final synchronized void initialize(Application application, String str, String str2) {
        synchronized (Intercom.class) {
            Companion.initialize(application, str, str2);
        }
    }

    @JvmStatic
    public static final synchronized void registerForLaterInitialisation(Application application) {
        synchronized (Intercom.class) {
            Companion.registerForLaterInitialisation(application);
        }
    }

    @JvmStatic
    public static final void setLogLevel(@LogLevel int i) {
        Companion.setLogLevel(i);
    }

    @JvmStatic
    public static final void unregisterForLateInitialisation(Application application) {
        Companion.unregisterForLateInitialisation(application);
    }

    public final void present() {
        present$default(this, (IntercomSpace) null, 1, (Object) null);
    }

    public Intercom(DeDuper deDuper, Provider<Api> provider, NexusClient nexusClient2, Store<State> store2, UnreadCountTracker unreadCountTracker2, MetricTracker metricTracker2, ErrorReporter errorReporter, Context context2, OverlayPresenter overlayPresenter2, Provider<AppConfig> provider2, UserIdentity userIdentity2, SystemNotificationManager systemNotificationManager2, Provider<UserUpdater> provider3, ResetManager resetManager2, Twig twig2, ActivityFinisher activityFinisher2) {
        DeDuper deDuper2 = deDuper;
        Provider<Api> provider4 = provider;
        NexusClient nexusClient3 = nexusClient2;
        Store<State> store3 = store2;
        UnreadCountTracker unreadCountTracker3 = unreadCountTracker2;
        Context context3 = context2;
        OverlayPresenter overlayPresenter3 = overlayPresenter2;
        Provider<AppConfig> provider5 = provider2;
        UserIdentity userIdentity3 = userIdentity2;
        SystemNotificationManager systemNotificationManager3 = systemNotificationManager2;
        Provider<UserUpdater> provider6 = provider3;
        ResetManager resetManager3 = resetManager2;
        Twig twig3 = twig2;
        ActivityFinisher activityFinisher3 = activityFinisher2;
        Intrinsics.checkNotNullParameter(deDuper2, "superDeDuper");
        Intrinsics.checkNotNullParameter(provider4, "apiProvider");
        Intrinsics.checkNotNullParameter(nexusClient3, "nexusClient");
        Intrinsics.checkNotNullParameter(store3, "store");
        Intrinsics.checkNotNullParameter(unreadCountTracker3, "unreadCountTracker");
        Intrinsics.checkNotNullParameter(metricTracker2, "metricTracker");
        Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        Intrinsics.checkNotNullParameter(context3, "context");
        Intrinsics.checkNotNullParameter(overlayPresenter3, "overlayPresenter");
        Intrinsics.checkNotNullParameter(provider5, "appConfigProvider");
        Intrinsics.checkNotNullParameter(userIdentity3, "userIdentity");
        Intrinsics.checkNotNullParameter(systemNotificationManager3, "systemNotificationManager");
        Intrinsics.checkNotNullParameter(provider6, "userUpdater");
        Intrinsics.checkNotNullParameter(resetManager3, "resetManager");
        Intrinsics.checkNotNullParameter(twig3, "twig");
        Intrinsics.checkNotNullParameter(activityFinisher3, "activityFinisher");
        this.superDeDuper = deDuper2;
        this.apiProvider = provider4;
        this.nexusClient = nexusClient3;
        this.store = store3;
        this.unreadCountTracker = unreadCountTracker3;
        this.metricTracker = metricTracker2;
        this.context = context3;
        this.overlayPresenter = overlayPresenter3;
        this.appConfigProvider = provider5;
        this.userIdentity = userIdentity3;
        this.systemNotificationManager = systemNotificationManager3;
        this.userUpdater = provider6;
        this.resetManager = resetManager3;
        this.twig = twig3;
        this.activityFinisher = activityFinisher3;
        IntercomPushManager.IntercomPushIntegrationType installedModuleType = IntercomPushManager.getInstalledModuleType();
        if ((installedModuleType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[installedModuleType.ordinal()]) == 1) {
            this.twig.i("Enabling FCM for cloud messaging", new Object[0]);
            this.systemNotificationManager.setUpNotificationChannelsIfSupported(this.context);
        } else {
            this.twig.internal("No FCM integration detected");
        }
        if (shouldDisableErrorReporting()) {
            errorReporter.disableExceptionHandler();
        } else {
            errorReporter.enableExceptionHandler();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/Intercom$LogLevel;", "", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: Intercom.kt */
    public @interface LogLevel {
        public static final int ASSERT = 7;
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int DEBUG = 3;
        public static final int DISABLED = 8;
        public static final int ERROR = 6;
        public static final int INFO = 4;
        public static final int VERBOSE = 2;
        public static final int WARN = 5;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/intercom/android/sdk/Intercom$LogLevel$Companion;", "", "()V", "ASSERT", "", "DEBUG", "DISABLED", "ERROR", "INFO", "VERBOSE", "WARN", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: Intercom.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int ASSERT = 7;
            public static final int DEBUG = 3;
            public static final int DISABLED = 8;
            public static final int ERROR = 6;
            public static final int INFO = 4;
            public static final int VERBOSE = 2;
            public static final int WARN = 5;

            private Companion() {
            }
        }
    }

    private final boolean shouldDisableErrorReporting() {
        return this.appConfigProvider.get().hasFeature(FeatureFlag.DISABLE_ERROR_REPORTING);
    }

    public static /* synthetic */ void present$default(Intercom intercom, IntercomSpace intercomSpace, int i, Object obj) {
        if ((i & 1) != 0) {
            intercomSpace = IntercomSpace.Home;
        }
        intercom.present(intercomSpace);
    }

    public final void present(IntercomSpace intercomSpace) {
        Intrinsics.checkNotNullParameter(intercomSpace, "space");
        if (noUserRegistered()) {
            TWIG.e("Intercom was presented but there was no user registered on this device.Please call registerUnidentifiedUser() or registerIdentifiedUser(Registration).", new Object[0]);
            return;
        }
        Injector.get().getMetricTracker().presentAPICall(intercomSpace);
        int i = WhenMappings.$EnumSwitchMapping$1[intercomSpace.ordinal()];
        if (i == 1) {
            HelpCenterUrlUtilsKt.openCollections(this.context, CollectionsKt.emptyList(), MetricTracker.Place.API);
        } else if (i == 2) {
            IntercomRootActivityLauncher.INSTANCE.startHome(this.context);
        } else if (i == 3) {
            IntercomRootActivityLauncher.INSTANCE.startMessages(this.context);
        }
    }

    public final void presentContent(IntercomContent intercomContent) {
        Intrinsics.checkNotNullParameter(intercomContent, "content");
        if (!Injector.isNotInitialised() && !noUserRegistered()) {
            Injector.get().getMetricTracker().presentContentAPICall(intercomContent);
        }
        if (intercomContent instanceof IntercomContent.Article) {
            this.context.startActivity(ArticleActivity.Companion.buildIntent(this.context, new ArticleActivity.ArticleActivityArguments(((IntercomContent.Article) intercomContent).getId(), MetricTracker.Place.API, false, 4, (DefaultConstructorMarker) null)));
        } else if (intercomContent instanceof IntercomContent.Carousel) {
            Context context2 = this.context;
            context2.startActivity(IntercomCarouselActivity.buildIntent(context2, ((IntercomContent.Carousel) intercomContent).getId()));
        } else if (intercomContent instanceof IntercomContent.Survey) {
            this.context.startActivity(IntercomSurveyActivity.Companion.buildIntent(this.context, ((IntercomContent.Survey) intercomContent).getId()));
        } else if (intercomContent instanceof IntercomContent.HelpCenterCollections) {
            HelpCenterUrlUtilsKt.openCollections(this.context, ((IntercomContent.HelpCenterCollections) intercomContent).getIds(), MetricTracker.Place.API);
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use loginUnidentifiedUser instead.", replaceWith = @ReplaceWith(expression = "loginUnidentifiedUser()", imports = {}))
    public final void registerUnidentifiedUser() {
        this.metricTracker.registerUnidentifiedUserAPICall();
        loginUnidentifiedUser(IntercomStatusCallbackKt.getNoStatusCallback());
    }

    public static /* synthetic */ void loginUnidentifiedUser$default(Intercom intercom, IntercomStatusCallback intercomStatusCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            intercomStatusCallback = IntercomStatusCallbackKt.getNoStatusCallback();
        }
        intercom.loginUnidentifiedUser(intercomStatusCallback);
    }

    public final void loginUnidentifiedUser(IntercomStatusCallback intercomStatusCallback) {
        Intrinsics.checkNotNullParameter(intercomStatusCallback, "intercomStatusCallback");
        this.metricTracker.loginUnidentifiedUserAPICall();
        if (this.userIdentity.canRegisterUnidentifiedUser()) {
            this.resetManager.hardReset();
            this.userIdentity.registerUnidentifiedUser();
            this.nexusClient.disconnect();
            Boolean bool = (Boolean) this.store.select(Selectors.APP_IS_BACKGROUNDED);
            Intrinsics.checkNotNullExpressionValue(bool, "isBackgrounded");
            this.userUpdater.get().updateUser(UserUpdateRequest.create(!((Boolean) this.store.select(Selectors.SESSION_STARTED_SINCE_LAST_BACKGROUNDED)).booleanValue(), bool.booleanValue(), true), intercomStatusCallback);
            return;
        }
        this.twig.i("Failed to register user. We already have a registered user. If you are attempting to register a new user, call logout() before this. If you are attempting to register an identified user call: registerIdentifiedUser(Registration)", new Object[0]);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use loginIdentifiedUser with callback instead.", replaceWith = @ReplaceWith(expression = "loginIdentifiedUser(userRegistration)", imports = {}))
    public final void registerIdentifiedUser(Registration registration) {
        this.metricTracker.registerIdentifiedUserAPICall();
        if (registration == null) {
            LumberMill.getLogger().e("The registration object passed is null. An example successful call is registerIdentifiedUser(Registration.create().withEmail(email));", new Object[0]);
        } else {
            loginIdentifiedUser(registration, IntercomStatusCallbackKt.getNoStatusCallback());
        }
    }

    public static /* synthetic */ void loginIdentifiedUser$default(Intercom intercom, Registration registration, IntercomStatusCallback intercomStatusCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            intercomStatusCallback = IntercomStatusCallbackKt.getNoStatusCallback();
        }
        intercom.loginIdentifiedUser(registration, intercomStatusCallback);
    }

    public final void loginIdentifiedUser(Registration registration, IntercomStatusCallback intercomStatusCallback) {
        UserUpdateRequest userUpdateRequest;
        Intrinsics.checkNotNullParameter(registration, "userRegistration");
        Intrinsics.checkNotNullParameter(intercomStatusCallback, "intercomStatusCallback");
        this.metricTracker.loginIdentifiedUserAPICall();
        if (userIsRegistered(registration)) {
            softRegister();
            intercomStatusCallback.onSuccess();
            return;
        }
        this.resetManager.hardReset();
        if (this.userIdentity.canRegisterIdentifiedUser(registration)) {
            this.userIdentity.registerIdentifiedUser(registration);
            this.nexusClient.disconnect();
            boolean z = !((Boolean) this.store.select(Selectors.SESSION_STARTED_SINCE_LAST_BACKGROUNDED)).booleanValue();
            Boolean bool = (Boolean) this.store.select(Selectors.APP_IS_BACKGROUNDED);
            if (registration.getAttributes() != null) {
                Intrinsics.checkNotNullExpressionValue(bool, "isInBackground");
                boolean booleanValue = bool.booleanValue();
                UserAttributes attributes = registration.getAttributes();
                Intrinsics.checkNotNull(attributes);
                userUpdateRequest = UserUpdateRequest.create(z, booleanValue, attributes.toMap(), true);
                Intrinsics.checkNotNullExpressionValue(userUpdateRequest, "{\n                    Us…      )\n                }");
            } else {
                Intrinsics.checkNotNullExpressionValue(bool, "isInBackground");
                userUpdateRequest = UserUpdateRequest.create(z, bool.booleanValue(), true);
                Intrinsics.checkNotNullExpressionValue(userUpdateRequest, "{\n                    Us…, true)\n                }");
            }
            this.userUpdater.get().updateUser(userUpdateRequest, intercomStatusCallback);
        } else if (this.userIdentity.registrationHasAttributes(registration)) {
            this.twig.i("We already have a registered user. Updating this user with the attributes provided.", new Object[0]);
            UserAttributes attributes2 = registration.getAttributes();
            Intrinsics.checkNotNull(attributes2);
            updateUser(attributes2, intercomStatusCallback);
        } else {
            intercomStatusCallback.onFailure(new IntercomError(ResultCode.WORKOUT_PLAN_DAY_FRAGMENT_SELECT_TEMPLATE, "ERROR - Failed to register user. We already have a registered user. If you are attempting to register a new user, call logout() before this."));
        }
    }

    private final boolean userIsRegistered(Registration registration) {
        return this.userIdentity.isSoftReset() && this.userIdentity.isSameUser(registration);
    }

    private final void softRegister() {
        String deviceToken = DeviceData.getDeviceToken(this.context);
        Intrinsics.checkNotNullExpressionValue(deviceToken, "deviceToken");
        if (deviceToken.length() > 0) {
            this.apiProvider.get().setDeviceToken(deviceToken);
        }
        this.nexusClient.connect(this.appConfigProvider.get().getRealTimeConfig(), true);
        this.userIdentity.softRestart();
        this.resetManager.clear();
        $$Lambda$Intercom$GAWZigRMaglo2QrP2XhZS0Mhn2A r0 = new Runnable() {
            public final void run() {
                Intercom.m5091softRegister$lambda0(Intercom.this);
            }
        };
        if (Intrinsics.areEqual((Object) Looper.myLooper(), (Object) Looper.getMainLooper())) {
            r0.run();
        } else {
            new Handler(Looper.getMainLooper()).post(r0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: softRegister$lambda-0  reason: not valid java name */
    public static final void m5091softRegister$lambda0(Intercom intercom) {
        Intrinsics.checkNotNullParameter(intercom, "this$0");
        intercom.overlayPresenter.refreshStateBecauseUserIdentityIsNotInStoreYet();
    }

    public final void setUserHash(String str) {
        Intrinsics.checkNotNullParameter(str, "userHash");
        this.metricTracker.setUserHashAPICall();
        if (str.length() == 0) {
            this.twig.w("The user hash you sent us to verify was empty, we will not be able to authenticate your requests without a valid user hash.", new Object[0]);
        } else if (Intrinsics.areEqual((Object) this.userIdentity.getHmac(), (Object) str)) {
            this.twig.i("The user hash set matches the existing user identity hash value", new Object[0]);
        } else {
            if (this.userIdentity.softUserIdentityHmacDiffers(str)) {
                this.resetManager.hardReset();
            }
            this.userIdentity.setUserHash(str);
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use updateUser with callback instead.", replaceWith = @ReplaceWith(expression = "updateUser(userAttributes, statusCallback)", imports = {}))
    public final void updateUser(UserAttributes userAttributes) {
        this.metricTracker.updateUserAPICall();
        if (userAttributes == null) {
            LumberMill.getLogger().e("updateUser method failed: the UserAttributes object provided is null", new Object[0]);
        } else {
            updateUser(userAttributes, IntercomStatusCallbackKt.getNoStatusCallback());
        }
    }

    public static /* synthetic */ void updateUser$default(Intercom intercom, UserAttributes userAttributes, IntercomStatusCallback intercomStatusCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            intercomStatusCallback = IntercomStatusCallbackKt.getNoStatusCallback();
        }
        intercom.updateUser(userAttributes, intercomStatusCallback);
    }

    public final void updateUser(UserAttributes userAttributes, IntercomStatusCallback intercomStatusCallback) {
        Intrinsics.checkNotNullParameter(userAttributes, "userAttributes");
        Intrinsics.checkNotNullParameter(intercomStatusCallback, "intercomStatusCallback");
        this.metricTracker.updateUserCallbackAPICall();
        Map<String, Object> map = userAttributes.toMap();
        Intrinsics.checkNotNullExpressionValue(map, "userAttributes.toMap()");
        performUpdate(map, intercomStatusCallback);
    }

    private final void performUpdate(Map<String, ? extends Object> map, IntercomStatusCallback intercomStatusCallback) {
        if (this.userIdentity.isUnidentified()) {
            AttributeSanitiser.anonymousSanitisation(map);
        }
        if (this.superDeDuper.shouldUpdateUser(map)) {
            this.superDeDuper.update(map);
            Boolean bool = (Boolean) this.store.select(Selectors.APP_IS_BACKGROUNDED);
            Intrinsics.checkNotNullExpressionValue(bool, "isBackgrounded");
            this.userUpdater.get().updateUser(UserUpdateRequest.create(false, bool.booleanValue(), map, false), intercomStatusCallback);
            this.twig.internal("dupe", "updated user");
            return;
        }
        intercomStatusCallback.onSuccess();
        this.twig.internal("dupe", "dropped dupe");
    }

    public final void logEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.metricTracker.logEventAPICall();
        logEventWithValidation(str, MapsKt.emptyMap());
    }

    public final void logEvent(String str, Map<String, ?> map) {
        this.metricTracker.logEventMetadataAPICall();
        if (map == null) {
            this.twig.i("The metadata provided is null, logging event with no metadata", new Object[0]);
        } else if (map.isEmpty()) {
            this.twig.i("The metadata provided is empty, logging event with no metadata", new Object[0]);
        }
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        logEventWithValidation(str, map);
    }

    private final void logEventWithValidation(String str, Map<String, ?> map) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            this.twig.e("The event name is null or empty. We can't log an event with this string.", new Object[0]);
        } else {
            this.apiProvider.get().logEvent(str, map);
        }
    }

    @Deprecated(message = "Use present() instead.")
    public final void displayMessenger() {
        this.metricTracker.displayMessengerAPICall();
        if (noUserRegistered()) {
            logErrorAndOpenInbox("The messenger was opened but there was no user registered on this device.Please call registerUnidentifiedUser() or registerIdentifiedUser(Registration).");
        } else {
            new LauncherOpenBehaviour(this.store, LauncherOpenBehaviour.LauncherType.CUSTOM, this.metricTracker, this.appConfigProvider).openMessenger(this.context);
        }
    }

    public final void displayMessageComposer() {
        this.metricTracker.displayMessageComposerAPICall();
        displayMessageComposer("");
    }

    public final void displayMessageComposer(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            this.metricTracker.displayMessageComposerInitialMessageAPICall();
        }
        if (noUserRegistered()) {
            logErrorAndOpenInbox("The messenger was opened but there was no user registered on this device. Please call registerUnidentifiedUser() or registerIdentifiedUser(Registration).");
        } else if (!this.appConfigProvider.get().isReceivedFromServer()) {
            logErrorAndOpenInbox("It appears your app has not received a successful response from Intercom. Please check you are using the correct Android app ID and API Key from the Intercom settings.");
        } else if (!this.appConfigProvider.get().isInboundMessages()) {
            logErrorAndOpenInbox("It appears your app is not on a plan that allows message composing. As a fallback we are calling displayConversationsList()");
        } else {
            this.metricTracker.openedMessengerNewConversation(LauncherOpenBehaviour.LauncherType.CUSTOM);
            Context context2 = this.context;
            IntercomConversationActivity.Companion companion = IntercomConversationActivity.Companion;
            Context context3 = this.context;
            if (str == null) {
                str = "";
            }
            context2.startActivity(companion.openComposer(context3, str));
        }
    }

    private final boolean noUserRegistered() {
        return !this.userIdentity.identityExists() || this.userIdentity.isSoftReset();
    }

    private final void logErrorAndOpenInbox(String str) {
        this.twig.e(str, new Object[0]);
        displayConversationsList();
    }

    @Deprecated(message = "Use present(IntercomSpace.Messages) instead.")
    public final void displayConversationsList() {
        this.metricTracker.displayConversationsListAPICall();
        this.metricTracker.openedMessengerConversationList(LauncherOpenBehaviour.LauncherType.CUSTOM);
        IntercomRootActivityLauncher.INSTANCE.startMessages(this.context);
    }

    @Deprecated(message = "Use present(IntercomSpace.HelpCenter) instead.")
    public final void displayHelpCenter() {
        this.metricTracker.displayHelpCenterAPICall();
        displayHelpCenterCollections(CollectionsKt.emptyList());
    }

    @Deprecated(message = "Use presentContent(IntercomContent.HelpCenterCollections(ids)) instead.")
    public final void displayHelpCenterCollections(List<String> list) {
        this.metricTracker.displayHelpCenterCollectionsAPICall();
        Context context2 = this.context;
        List filterNotNull = list != null ? CollectionsKt.filterNotNull(list) : null;
        if (filterNotNull == null) {
            filterNotNull = CollectionsKt.emptyList();
        }
        HelpCenterUrlUtilsKt.openCollections(context2, filterNotNull, MetricTracker.Place.API);
    }

    @Deprecated(message = "Use presentContent(IntercomContent.Carousel(id)) instead.")
    public final void displayCarousel(String str) {
        this.metricTracker.displayCarouselAPICall();
        Context context2 = this.context;
        context2.startActivity(IntercomCarouselActivity.buildIntent(context2, str));
    }

    @Deprecated(message = "Use presentContent(IntercomContent.Survey(id)) instead.")
    public final void displaySurvey(String str) {
        Intrinsics.checkNotNullParameter(str, "surveyId");
        this.metricTracker.displaySurveyAPICall();
        this.context.startActivity(IntercomSurveyActivity.Companion.buildIntent(this.context, str));
    }

    public final void setBottomPadding(int i) {
        this.metricTracker.setBottomPaddingAPICall();
        this.store.dispatch(Actions.setBottomPadding(i));
    }

    public final void setInAppMessageVisibility(Visibility visibility) {
        this.metricTracker.setInAppMessageVisibilityAPICall();
        this.store.dispatch(Actions.setInAppNotificationVisibility(visibility));
    }

    public final void setLauncherVisibility(Visibility visibility) {
        this.metricTracker.setLauncherVisibilityAPICall();
        this.store.dispatch(Actions.setLauncherVisibility(visibility));
    }

    public final void hideIntercom() {
        this.metricTracker.hideIntercomAPICall();
        this.activityFinisher.finishActivities();
    }

    public final void handlePushMessage() {
        this.metricTracker.handlePushMessageAPICall();
        handlePushMessage((TaskStackBuilder) null);
    }

    public final void handlePushMessage(TaskStackBuilder taskStackBuilder) {
        if (taskStackBuilder != null) {
            this.metricTracker.handlePushMessageCustomStackAPICall();
        }
        boolean z = false;
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(PreferenceKeys.INTERCOM_PUSH_PREFS, 0);
        String string = sharedPreferences.getString(IntercomPushManager.INTERCOM_PUSH_PATH, "");
        CharSequence charSequence = string;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            z = true;
        }
        if (z) {
            this.twig.internal("No Uri found");
            return;
        }
        openIntercomChatPush(string, taskStackBuilder);
        sharedPreferences.edit().clear().apply();
    }

    private final void openIntercomChatPush(String str, TaskStackBuilder taskStackBuilder) {
        if (Intrinsics.areEqual((Object) str, (Object) IntercomPushManager.MULTIPLE_NOTIFICATIONS)) {
            IntercomRootActivityLauncher.INSTANCE.startMessages(this.context);
        } else {
            Intent openConversation = IntercomConversationActivity.Companion.openConversation(this.context, str, LastParticipatingAdmin.NULL);
            if (taskStackBuilder != null) {
                taskStackBuilder.addNextIntent(openConversation);
                this.context.startActivities(taskStackBuilder.getIntents());
            } else {
                this.context.startActivity(openConversation);
            }
        }
        this.metricTracker.viewedPushNotification(str);
        this.systemNotificationManager.clear();
    }

    @Deprecated(message = "call {@link #logout()} instead")
    public final void reset() {
        this.metricTracker.resetAPICall();
        logout();
    }

    public final void logout() {
        this.metricTracker.logoutAPICall();
        if (!this.userIdentity.isSoftReset()) {
            this.resetManager.softReset();
        }
    }

    public final int getUnreadConversationCount() {
        this.metricTracker.unreadConversationCountAPICall();
        return this.store.state().unreadConversationIds().size();
    }

    public final void addUnreadConversationCountListener(UnreadConversationCountListener unreadConversationCountListener) {
        Intrinsics.checkNotNullParameter(unreadConversationCountListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.metricTracker.addUnreadConversationCountListenerAPICall();
        this.unreadCountTracker.addListener(unreadConversationCountListener);
    }

    public final void removeUnreadConversationCountListener(UnreadConversationCountListener unreadConversationCountListener) {
        this.metricTracker.removeUnreadConversationCountListenerAPICall();
        if (unreadConversationCountListener != null) {
            this.unreadCountTracker.removeListener(unreadConversationCountListener);
        }
    }

    @Deprecated(message = "Use presentContent(IntercomContent.Article(id)) instead.")
    public final void displayArticle(String str) {
        Intrinsics.checkNotNullParameter(str, "articleId");
        this.metricTracker.displayArticleAPICall();
        this.context.startActivity(ArticleActivity.Companion.buildIntent(this.context, new ArticleActivity.ArticleActivityArguments(str, MetricTracker.Place.API, false, 4, (DefaultConstructorMarker) null)));
    }

    public final void fetchHelpCenterCollections(CollectionRequestCallback collectionRequestCallback) {
        this.metricTracker.fetchHelpCenterCollectionsAPICall();
        HelpCenterApiWrapper helpCenterApiWrapper = HelpCenterApiWrapper.INSTANCE;
        MetricTracker metricTracker2 = this.metricTracker;
        Intrinsics.checkNotNull(collectionRequestCallback);
        helpCenterApiWrapper.fetchHelpCenterCollections(metricTracker2, collectionRequestCallback);
    }

    public final void fetchHelpCenterCollection(String str, CollectionContentRequestCallback collectionContentRequestCallback) {
        this.metricTracker.fetchHelpCenterCollectionAPICall();
        HelpCenterApiWrapper helpCenterApiWrapper = HelpCenterApiWrapper.INSTANCE;
        MetricTracker metricTracker2 = this.metricTracker;
        Intrinsics.checkNotNull(str);
        Intrinsics.checkNotNull(collectionContentRequestCallback);
        helpCenterApiWrapper.fetchHelpCenterCollection(metricTracker2, str, collectionContentRequestCallback);
    }

    public final void searchHelpCenter(String str, SearchRequestCallback searchRequestCallback) {
        this.metricTracker.searchHelpCenterAPICall();
        HelpCenterApiWrapper helpCenterApiWrapper = HelpCenterApiWrapper.INSTANCE;
        MetricTracker metricTracker2 = this.metricTracker;
        Intrinsics.checkNotNull(str);
        Intrinsics.checkNotNull(searchRequestCallback);
        helpCenterApiWrapper.fetchHelpCenterResultsForSearchTerm(metricTracker2, str, searchRequestCallback);
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\fH\u0007J$\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0002J&\u0010\u0013\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010\u0016\u001a\u00020\u00142\b\b\u0001\u0010\u0017\u001a\u00020\u0018H\u0007J\u0012\u0010\u0019\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lio/intercom/android/sdk/Intercom$Companion;", "", "()V", "GONE", "Lio/intercom/android/sdk/Intercom$Visibility;", "PUSH_RECEIVER", "", "TWIG", "Lcom/intercom/twig/Twig;", "kotlin.jvm.PlatformType", "VISIBLE", "instance", "Lio/intercom/android/sdk/Intercom;", "client", "create", "application", "Landroid/app/Application;", "apiKey", "appId", "initialize", "", "registerForLaterInitialisation", "setLogLevel", "logLevel", "", "unregisterForLateInitialisation", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Intercom.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
            return;
         */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized void initialize(android.app.Application r3, java.lang.String r4, java.lang.String r5) {
            /*
                r2 = this;
                monitor-enter(r2)
                io.intercom.android.sdk.Intercom r0 = io.intercom.android.sdk.Intercom.instance     // Catch:{ all -> 0x0049 }
                r1 = 0
                if (r0 == 0) goto L_0x0015
                com.intercom.twig.Twig r3 = io.intercom.android.sdk.Intercom.TWIG     // Catch:{ all -> 0x0049 }
                java.lang.String r4 = "Intercom has already been initialized"
                java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x0049 }
                r3.i(r4, r5)     // Catch:{ all -> 0x0049 }
                monitor-exit(r2)
                return
            L_0x0015:
                boolean r0 = io.intercom.android.sdk.utilities.ValidatorUtil.isValidConstructorParams(r3, r4, r5)     // Catch:{ all -> 0x0049 }
                if (r0 == 0) goto L_0x003c
                kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ all -> 0x0049 }
                io.intercom.android.sdk.Intercom r4 = r2.create(r3, r4, r5)     // Catch:{ all -> 0x0049 }
                io.intercom.android.sdk.Intercom.instance = r4     // Catch:{ all -> 0x0049 }
                io.intercom.android.sdk.LateInitializationPreparer r4 = io.intercom.android.sdk.LateInitializationPreparer.getInstance()     // Catch:{ all -> 0x0049 }
                io.intercom.android.sdk.Injector r5 = io.intercom.android.sdk.Injector.get()     // Catch:{ all -> 0x0049 }
                r4.handlePastLifecycleEvents(r3, r5)     // Catch:{ all -> 0x0049 }
                io.intercom.android.sdk.Injector r3 = io.intercom.android.sdk.Injector.get()     // Catch:{ all -> 0x0049 }
                io.intercom.android.sdk.metrics.MetricTracker r3 = r3.getMetricTracker()     // Catch:{ all -> 0x0049 }
                r3.initialiseAPICall()     // Catch:{ all -> 0x0049 }
                goto L_0x0047
            L_0x003c:
                com.intercom.twig.Twig r3 = io.intercom.android.sdk.Intercom.TWIG     // Catch:{ all -> 0x0049 }
                java.lang.String r4 = "Intercom has been initialized incorrectly. Please make sure that you're passing in the correct app ID and API key"
                java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x0049 }
                r3.e(r4, r5)     // Catch:{ all -> 0x0049 }
            L_0x0047:
                monitor-exit(r2)
                return
            L_0x0049:
                r3 = move-exception
                monitor-exit(r2)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.Intercom.Companion.initialize(android.app.Application, java.lang.String, java.lang.String):void");
        }

        @JvmStatic
        public final synchronized void registerForLaterInitialisation(Application application) {
            if (Intercom.instance != null) {
                Intercom.TWIG.i("Intercom has already been initialized", new Object[0]);
            } else if (application != null) {
                LateInitializationPreparer.getInstance().register(application);
            } else {
                throw new NullPointerException("Cannot call registerForLaterInitialisation() with a null Application");
            }
        }

        @JvmStatic
        public final void unregisterForLateInitialisation(Application application) {
            Injector.get().getMetricTracker().unRegisterForLateInitialisationAPICall();
            if (application != null) {
                LateInitializationPreparer.getInstance().unregister(application);
                return;
            }
            throw new NullPointerException("Cannot call unregisterForLateInitialisation() with a null Application");
        }

        @JvmStatic
        public final synchronized Intercom client() {
            Intercom access$getInstance$cp;
            access$getInstance$cp = Intercom.instance;
            if (access$getInstance$cp == null) {
                throw new IllegalStateException("Intercom has been initialized incorrectly. Please make sure the first Intercom method you call is initialize() and that you're passing in the correct app ID and API key".toString());
            }
            return access$getInstance$cp;
        }

        @JvmStatic
        public final void setLogLevel(@LogLevel int i) {
            Injector.get().getMetricTracker().setLogLevelAPICall();
            LumberMill.setLogLevel(i);
        }

        private final Intercom create(Application application, String str, String str2) {
            Injector.initWithAppCredentials(application, str, str2);
            Injector injector = Injector.get();
            UserIdentity userIdentity = injector.getUserIdentity();
            UserIdentity userIdentity2 = userIdentity;
            Store<State> store = injector.getStore();
            DeDuper deDuper = injector.getDeDuper();
            DeDuper deDuper2 = deDuper;
            Intrinsics.checkNotNullExpressionValue(deDuper, "injector.deDuper");
            Provider<Api> apiProvider = injector.getApiProvider();
            Provider<Api> provider = apiProvider;
            Intrinsics.checkNotNullExpressionValue(apiProvider, "injector.apiProvider");
            NexusClient nexusClient = injector.getNexusClient();
            NexusClient nexusClient2 = nexusClient;
            Intrinsics.checkNotNullExpressionValue(nexusClient, "injector.nexusClient");
            Intrinsics.checkNotNullExpressionValue(store, "store");
            UnreadCountTracker unreadCountTracker = r8;
            UnreadCountTracker unreadCountTracker2 = new UnreadCountTracker(store);
            MetricTracker metricTracker = injector.getMetricTracker();
            Intrinsics.checkNotNullExpressionValue(metricTracker, "injector.metricTracker");
            ErrorReporter errorReporter = injector.getErrorReporter();
            Intrinsics.checkNotNullExpressionValue(errorReporter, "injector.errorReporter");
            OverlayPresenter overlayPresenter = injector.getOverlayPresenter();
            OverlayPresenter overlayPresenter2 = overlayPresenter;
            Intrinsics.checkNotNullExpressionValue(overlayPresenter, "injector.overlayPresenter");
            Provider<AppConfig> appConfigProvider = injector.getAppConfigProvider();
            Provider<AppConfig> provider2 = appConfigProvider;
            Intrinsics.checkNotNullExpressionValue(appConfigProvider, "injector.appConfigProvider");
            Intrinsics.checkNotNullExpressionValue(userIdentity, "userIdentity");
            SystemNotificationManager systemNotificationManager = injector.getSystemNotificationManager();
            SystemNotificationManager systemNotificationManager2 = systemNotificationManager;
            Intrinsics.checkNotNullExpressionValue(systemNotificationManager, "injector.systemNotificationManager");
            Provider<UserUpdater> userUpdaterProvider = injector.getUserUpdaterProvider();
            Provider<UserUpdater> provider3 = userUpdaterProvider;
            Intrinsics.checkNotNullExpressionValue(userUpdaterProvider, "injector.userUpdaterProvider");
            ResetManager resetManager = injector.getResetManager();
            ResetManager resetManager2 = resetManager;
            Intrinsics.checkNotNullExpressionValue(resetManager, "injector.resetManager");
            Twig logger = LumberMill.getLogger();
            Intrinsics.checkNotNullExpressionValue(logger, "getLogger()");
            ActivityFinisher activityFinisher = injector.getActivityFinisher();
            Intrinsics.checkNotNullExpressionValue(activityFinisher, "injector.activityFinisher");
            return new Intercom(deDuper2, provider, nexusClient2, store, unreadCountTracker, metricTracker, errorReporter, application, overlayPresenter2, provider2, userIdentity2, systemNotificationManager2, provider3, resetManager2, logger, activityFinisher);
        }
    }
}
