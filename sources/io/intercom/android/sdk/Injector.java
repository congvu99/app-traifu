package io.intercom.android.sdk;

import android.app.Application;
import android.app.NotificationManager;
import com.google.gson.Gson;
import com.intercom.commons.utilities.TimeProvider;
import com.intercom.twig.Twig;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;
import io.intercom.android.nexus.NexusClient;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.api.ApiFactory;
import io.intercom.android.sdk.api.DeDuper;
import io.intercom.android.sdk.api.MessengerApi;
import io.intercom.android.sdk.api.SurveyApi;
import io.intercom.android.sdk.api.TaggingSocketFactory;
import io.intercom.android.sdk.api.UserUpdater;
import io.intercom.android.sdk.conversation.SoundPlayer;
import io.intercom.android.sdk.errorreporting.ErrorReporter;
import io.intercom.android.sdk.exceptions.IntercomIntegrationException;
import io.intercom.android.sdk.helpcenter.api.HelpCenterApi;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.AppIdentity;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.metrics.MetricsStore;
import io.intercom.android.sdk.metrics.ops.OpsMetricTracker;
import io.intercom.android.sdk.overlay.OverlayPresenter;
import io.intercom.android.sdk.push.SystemNotificationManager;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.store.StoreFactory;
import io.intercom.android.sdk.tickets.create.data.TicketApi;
import io.intercom.android.sdk.utilities.ActivityFinisher;
import io.intercom.android.sdk.utilities.PreferenceKeys;
import io.intercom.android.sdk.utilities.SystemSettings;
import io.intercom.android.sdk.utilities.UuidStringProvider;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;

public class Injector {
    private static final int NEXUS_TRAFFIC_TAG = 63987;
    private static final Twig TWIG = LumberMill.getLogger();
    private static Injector instance;
    private final ActivityFinisher activityFinisher = new ActivityFinisher();
    private Api api;
    private final Provider<Api> apiProvider = new Provider<Api>() {
        public Api get() {
            return Injector.this.getApi();
        }
    };
    /* access modifiers changed from: private */
    public final AppConfig appConfig;
    private final Provider<AppConfig> appConfigProvider = new Provider<AppConfig>() {
        public AppConfig get() {
            return Injector.this.appConfig;
        }
    };
    private final AppIdentity appIdentity;
    private final Application application;
    private MainThreadBus bus;
    private ErrorReporter errorReporter;
    private Gson gson;
    private HelpCenterApi helpCenterApi;
    private LifecycleTracker lifecycleTracker;
    private MessengerApi messengerApi;
    private MetricTracker metricTracker;
    private final Provider<MetricTracker> metricTrackerProvider = new Provider<MetricTracker>() {
        public MetricTracker get() {
            return Injector.this.getMetricTracker();
        }
    };
    private MetricsStore metricsStore;
    private NexusWrapper nexusClient;
    private final Provider<NexusClient> nexusClientProvider = new Provider<NexusClient>() {
        public NexusClient get() {
            return Injector.this.getNexusClient();
        }
    };
    private OpsMetricTracker opsMetricTracker;
    private final Provider<OverlayPresenter> overlayManagerProvider = new Provider<OverlayPresenter>() {
        public OverlayPresenter get() {
            return Injector.this.getOverlayPresenter();
        }
    };
    private OverlayPresenter overlayPresenter;
    private ResetManager resetManager;
    private Store<State> store;
    private DeDuper superDeDuper;
    private SurveyApi surveyApi;
    private SystemNotificationManager systemNotificationManager;
    private TicketApi ticketApi;
    private final UserIdentity userIdentity;
    private final Provider<UserIdentity> userIdentityProvider = new Provider<UserIdentity>() {
        public UserIdentity get() {
            return Injector.this.getUserIdentity();
        }
    };
    private UserUpdater userUpdater;
    private final Provider<UserUpdater> userUpdaterProvider = new Provider<UserUpdater>() {
        public UserUpdater get() {
            return Injector.this.getUserUpdater();
        }
    };

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void initIfCachedCredentials(android.app.Application r4) {
        /*
            java.lang.Class<io.intercom.android.sdk.Injector> r0 = io.intercom.android.sdk.Injector.class
            monitor-enter(r0)
            io.intercom.android.sdk.Injector r1 = instance     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            io.intercom.android.sdk.identity.AppIdentity r1 = io.intercom.android.sdk.identity.AppIdentity.loadFromDevice(r4)     // Catch:{ all -> 0x0026 }
            java.lang.String r2 = r1.apiKey()     // Catch:{ all -> 0x0026 }
            java.lang.String r1 = r1.appId()     // Catch:{ all -> 0x0026 }
            boolean r3 = r1.isEmpty()     // Catch:{ all -> 0x0026 }
            if (r3 != 0) goto L_0x0024
            boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x0026 }
            if (r3 != 0) goto L_0x0024
            initWithAppCredentials(r4, r2, r1)     // Catch:{ all -> 0x0026 }
        L_0x0024:
            monitor-exit(r0)
            return
        L_0x0026:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.Injector.initIfCachedCredentials(android.app.Application):void");
    }

    public static synchronized void initWithAppCredentials(Application application2, String str, String str2) {
        synchronized (Injector.class) {
            if (instance == null) {
                TWIG.internal("Injector", "Initializing");
                AppIdentity create = AppIdentity.create(str, str2);
                create.persist(application2);
                Injector injector = new Injector(application2, create, new AppConfig(application2), new UserIdentity(application2));
                instance = injector;
                application2.registerActivityLifecycleCallbacks(injector.getLifecycleTracker());
            }
        }
    }

    protected Injector(Application application2, AppIdentity appIdentity2, AppConfig appConfig2, UserIdentity userIdentity2) {
        this.application = application2;
        this.appIdentity = appIdentity2;
        this.appConfig = appConfig2;
        this.userIdentity = userIdentity2;
    }

    public static synchronized boolean isNotInitialised() {
        boolean z;
        synchronized (Injector.class) {
            z = instance == null;
        }
        return z;
    }

    public static synchronized Injector get() {
        Injector injector;
        synchronized (Injector.class) {
            if (instance != null) {
                injector = instance;
            } else {
                throw new IntercomIntegrationException("Intercom was not initialized correctly, Intercom.initialize() needs to be called in onCreate() in your Application class.");
            }
        }
        return injector;
    }

    public Application getApplication() {
        return this.application;
    }

    public Provider<AppConfig> getAppConfigProvider() {
        return this.appConfigProvider;
    }

    public AppIdentity getAppIdentity() {
        return this.appIdentity;
    }

    public UserIdentity getUserIdentity() {
        return this.userIdentity;
    }

    public synchronized Bus getBus() {
        if (this.bus == null) {
            this.bus = new MainThreadBus(ThreadEnforcer.ANY);
        }
        return this.bus;
    }

    public synchronized NexusClient getNexusClient() {
        if (this.nexusClient == null) {
            this.nexusClient = new NexusWrapper(LumberMill.getNexusTwig(), NexusClient.defaultOkHttpClientBuilder().socketFactory(new TaggingSocketFactory(SocketFactory.getDefault(), NEXUS_TRAFFIC_TAG)).build(), getBus(), getStore(), getApi(), getNexusDebouncePeriod());
        }
        return this.nexusClient;
    }

    /* access modifiers changed from: protected */
    public long getNexusDebouncePeriod() {
        return TimeUnit.SECONDS.toMillis(1);
    }

    public synchronized DeDuper getDeDuper() {
        if (this.superDeDuper == null) {
            DeDuper deDuper = new DeDuper(this.appConfigProvider, this.application.getSharedPreferences(PreferenceKeys.INTERCOM_DEDUPER_PREFS, 0));
            this.superDeDuper = deDuper;
            deDuper.readPersistedCachedAttributes();
        }
        return this.superDeDuper;
    }

    public synchronized Api getApi() {
        if (this.api == null) {
            this.api = ApiFactory.create(getApplication(), this.appIdentity, this.userIdentity, getBus(), getStore(), ApiFactory.getServerUrl(this.appIdentity, this.application), this.appConfigProvider, getGson(), getOpsMetricTracker());
            this.messengerApi = ApiFactory.messengerApi;
        }
        this.api.updateMaxRequests();
        return this.api;
    }

    public synchronized HelpCenterApi getHelpCenterApi() {
        if (this.helpCenterApi == null) {
            this.helpCenterApi = ApiFactory.createHelpCenterApi(getApplication(), this.appIdentity, this.userIdentity, ApiFactory.getServerUrl(this.appIdentity, this.application), getGson());
        }
        return this.helpCenterApi;
    }

    public synchronized SurveyApi getSurveyApi() {
        if (this.surveyApi == null) {
            this.surveyApi = ApiFactory.createSurveyApi(getApplication(), this.appIdentity, this.userIdentity, ApiFactory.getServerUrl(this.appIdentity, this.application), getGson());
        }
        return this.surveyApi;
    }

    public synchronized TicketApi getTicketApi() {
        if (this.ticketApi == null) {
            this.ticketApi = ApiFactory.createTicketApi(getApplication(), this.appIdentity, this.userIdentity, ApiFactory.getServerUrl(this.appIdentity, this.application), getGson());
        }
        return this.ticketApi;
    }

    public synchronized Gson getGson() {
        if (this.gson == null) {
            this.gson = new Gson();
        }
        return this.gson;
    }

    public synchronized MetricTracker getMetricTracker() {
        if (this.metricTracker == null) {
            this.metricTracker = new MetricTracker(this.userIdentity, getMetricsStore(), getApplication());
        }
        return this.metricTracker;
    }

    public synchronized MetricsStore getMetricsStore() {
        if (this.metricsStore == null) {
            this.metricsStore = new MetricsStore(getApplication(), getApiProvider(), this.appConfigProvider);
        }
        return this.metricsStore;
    }

    public synchronized OpsMetricTracker getOpsMetricTracker() {
        if (this.opsMetricTracker == null) {
            this.opsMetricTracker = new OpsMetricTracker(getMetricsStore(), getTimeProvider(), UuidStringProvider.SYSTEM);
        }
        return this.opsMetricTracker;
    }

    public synchronized OverlayPresenter getOverlayPresenter() {
        if (this.overlayPresenter == null) {
            this.overlayPresenter = new OverlayPresenter(getApplication(), getBus(), getStore(), this.appConfigProvider, getMetricTracker(), this.userIdentity);
        }
        return this.overlayPresenter;
    }

    public synchronized Store<State> getStore() {
        if (this.store == null) {
            this.store = StoreFactory.createStore(this.apiProvider, this.appConfigProvider, this.nexusClientProvider, this.overlayManagerProvider, this.userUpdaterProvider, new SoundPlayer(this.application, this.appConfigProvider), this.userIdentityProvider, this.application, LumberMill.getLogger(), getBus(), this.metricTrackerProvider);
        }
        return this.store;
    }

    public TimeProvider getTimeProvider() {
        return TimeProvider.SYSTEM;
    }

    public synchronized SystemNotificationManager getSystemNotificationManager() {
        if (this.systemNotificationManager == null) {
            this.systemNotificationManager = new SystemNotificationManager((NotificationManager) this.application.getSystemService("notification"));
        }
        return this.systemNotificationManager;
    }

    public synchronized LifecycleTracker getLifecycleTracker() {
        if (this.lifecycleTracker == null) {
            this.lifecycleTracker = LifecycleTracker.create(getSystemNotificationManager(), getMetricsStore(), getErrorReporter(), getDeDuper(), getTimeProvider(), getUserUpdater(), getStore(), getResetManager(), SystemSettings.getTransitionScale(this.application));
        }
        return this.lifecycleTracker;
    }

    public synchronized ErrorReporter getErrorReporter() {
        if (this.errorReporter == null) {
            this.errorReporter = ErrorReporter.create(this.application, getGson(), this.apiProvider);
        }
        return this.errorReporter;
    }

    public synchronized UserUpdater getUserUpdater() {
        if (this.userUpdater == null) {
            this.userUpdater = new UserUpdater(getApiProvider(), getStore(), getOpsMetricTracker());
        }
        return this.userUpdater;
    }

    public synchronized ResetManager getResetManager() {
        if (this.resetManager == null) {
            this.resetManager = new ResetManager(getApiProvider(), getUserIdentity(), getOverlayPresenter(), this.appConfigProvider, getStore(), getUserUpdater(), this.application, this.activityFinisher);
        }
        return this.resetManager;
    }

    public Provider<UserUpdater> getUserUpdaterProvider() {
        return this.userUpdaterProvider;
    }

    public Provider<Api> getApiProvider() {
        return this.apiProvider;
    }

    public ActivityFinisher getActivityFinisher() {
        return this.activityFinisher;
    }

    static void setSharedInstance(Injector injector) {
        instance = injector;
    }

    public MessengerApi getMessengerApi() {
        if (this.messengerApi == null) {
            this.messengerApi = ApiFactory.messengerApi;
        }
        return this.messengerApi;
    }
}
