package io.sentry;

import androidx.work.WorkRequest;
import com.github.mikephil.charting.utils.Utils;
import io.sentry.cache.IEnvelopeCache;
import io.sentry.config.PropertiesProvider;
import io.sentry.protocol.SdkVersion;
import io.sentry.transport.ITransportGate;
import io.sentry.transport.NoOpEnvelopeCache;
import io.sentry.transport.NoOpTransportGate;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public class SentryOptions {
    static final SentryLevel DEFAULT_DIAGNOSTIC_LEVEL = SentryLevel.DEBUG;
    private static final String PROXY_PORT_DEFAULT = "80";
    private boolean attachServerName = true;
    private boolean attachStacktrace = true;
    private boolean attachThreads;
    private BeforeBreadcrumbCallback beforeBreadcrumb;
    private BeforeSendCallback beforeSend;
    private String cacheDirPath;
    private int cacheDirSize = 30;
    private int connectionTimeoutMillis = 5000;
    private Boolean debug;
    private SentryLevel diagnosticLevel = DEFAULT_DIAGNOSTIC_LEVEL;
    private String dist;
    private String distinctId;
    private String dsn;
    private boolean enableExternalConfiguration;
    private boolean enableNdk = true;
    private boolean enableScopeSync;
    private boolean enableSessionTracking = true;
    private Boolean enableUncaughtExceptionHandler = true;
    private IEnvelopeCache envelopeDiskCache = NoOpEnvelopeCache.getInstance();
    private IEnvelopeReader envelopeReader = new EnvelopeReader();
    private String environment;
    private final List<EventProcessor> eventProcessors = new CopyOnWriteArrayList();
    private ISentryExecutorService executorService = new SentryExecutorService();
    private long flushTimeoutMillis = 15000;
    private HostnameVerifier hostnameVerifier;
    private final List<String> inAppExcludes = new CopyOnWriteArrayList();
    private final List<String> inAppIncludes = new CopyOnWriteArrayList();
    private final List<Integration> integrations = new CopyOnWriteArrayList();
    private ILogger logger = NoOpLogger.getInstance();
    private long maxAttachmentSize = 20971520;
    private int maxBreadcrumbs = 100;
    private int maxQueueSize = 30;
    private final List<IScopeObserver> observers = new ArrayList();
    private Proxy proxy;
    private int readTimeoutMillis = 5000;
    private String release;
    private Double sampleRate;
    private SdkVersion sdkVersion;
    private boolean sendDefaultPii = false;
    private String sentryClientName;
    private ISerializer serializer = new GsonSerializer(this.logger, this.envelopeReader);
    private String serverName;
    private long sessionTrackingIntervalMillis = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
    private long shutdownTimeout = 2000;
    private SSLSocketFactory sslSocketFactory;
    private final Map<String, String> tags = new ConcurrentHashMap();
    private Double tracesSampleRate;
    private TracesSamplerCallback tracesSampler;
    private ITransportFactory transportFactory = NoOpTransportFactory.getInstance();
    private ITransportGate transportGate = NoOpTransportGate.getInstance();

    public interface BeforeBreadcrumbCallback {
        Breadcrumb execute(Breadcrumb breadcrumb, Object obj);
    }

    public interface BeforeSendCallback {
        SentryEvent execute(SentryEvent sentryEvent, Object obj);
    }

    public interface TracesSamplerCallback {
        Double sample(SamplingContext samplingContext);
    }

    public static SentryOptions from(PropertiesProvider propertiesProvider) {
        SentryOptions sentryOptions = new SentryOptions();
        sentryOptions.setDsn(propertiesProvider.getProperty("dsn"));
        sentryOptions.setEnvironment(propertiesProvider.getProperty("environment"));
        sentryOptions.setRelease(propertiesProvider.getProperty("release"));
        sentryOptions.setDist(propertiesProvider.getProperty("dist"));
        sentryOptions.setServerName(propertiesProvider.getProperty("servername"));
        sentryOptions.setEnableUncaughtExceptionHandler(propertiesProvider.getBooleanProperty("uncaught.handler.enabled"));
        sentryOptions.setTracesSampleRate(propertiesProvider.getDoubleProperty("traces-sample-rate"));
        sentryOptions.setDebug(propertiesProvider.getBooleanProperty("debug"));
        for (Map.Entry next : propertiesProvider.getMap("tags").entrySet()) {
            sentryOptions.setTag((String) next.getKey(), (String) next.getValue());
        }
        String property = propertiesProvider.getProperty("proxy.host");
        String property2 = propertiesProvider.getProperty("proxy.user");
        String property3 = propertiesProvider.getProperty("proxy.pass");
        String property4 = propertiesProvider.getProperty("proxy.port", PROXY_PORT_DEFAULT);
        if (property != null) {
            sentryOptions.setProxy(new Proxy(property, property4, property2, property3));
        }
        for (String addInAppInclude : propertiesProvider.getList("in-app-includes")) {
            sentryOptions.addInAppInclude(addInAppInclude);
        }
        for (String addInAppExclude : propertiesProvider.getList("in-app-excludes")) {
            sentryOptions.addInAppExclude(addInAppExclude);
        }
        return sentryOptions;
    }

    public void addEventProcessor(EventProcessor eventProcessor) {
        this.eventProcessors.add(eventProcessor);
    }

    public List<EventProcessor> getEventProcessors() {
        return this.eventProcessors;
    }

    public void addIntegration(Integration integration) {
        this.integrations.add(integration);
    }

    public List<Integration> getIntegrations() {
        return this.integrations;
    }

    public String getDsn() {
        return this.dsn;
    }

    public void setDsn(String str) {
        this.dsn = str;
    }

    public boolean isDebug() {
        return Boolean.TRUE.equals(this.debug);
    }

    public void setDebug(Boolean bool) {
        this.debug = bool;
    }

    private Boolean getDebug() {
        return this.debug;
    }

    public ILogger getLogger() {
        return this.logger;
    }

    public void setLogger(ILogger iLogger) {
        this.logger = iLogger == null ? NoOpLogger.getInstance() : new DiagnosticLogger(this, iLogger);
    }

    public SentryLevel getDiagnosticLevel() {
        return this.diagnosticLevel;
    }

    public void setDiagnosticLevel(SentryLevel sentryLevel) {
        if (sentryLevel == null) {
            sentryLevel = DEFAULT_DIAGNOSTIC_LEVEL;
        }
        this.diagnosticLevel = sentryLevel;
    }

    public ISerializer getSerializer() {
        return this.serializer;
    }

    public void setSerializer(ISerializer iSerializer) {
        if (iSerializer == null) {
            iSerializer = NoOpSerializer.getInstance();
        }
        this.serializer = iSerializer;
    }

    public IEnvelopeReader getEnvelopeReader() {
        return this.envelopeReader;
    }

    public void setEnvelopeReader(IEnvelopeReader iEnvelopeReader) {
        if (iEnvelopeReader == null) {
            iEnvelopeReader = NoOpEnvelopeReader.getInstance();
        }
        this.envelopeReader = iEnvelopeReader;
    }

    public boolean isEnableNdk() {
        return this.enableNdk;
    }

    public void setEnableNdk(boolean z) {
        this.enableNdk = z;
    }

    public long getShutdownTimeout() {
        return this.shutdownTimeout;
    }

    public void setShutdownTimeout(long j) {
        this.shutdownTimeout = j;
    }

    public String getSentryClientName() {
        return this.sentryClientName;
    }

    public void setSentryClientName(String str) {
        this.sentryClientName = str;
    }

    public BeforeSendCallback getBeforeSend() {
        return this.beforeSend;
    }

    public void setBeforeSend(BeforeSendCallback beforeSendCallback) {
        this.beforeSend = beforeSendCallback;
    }

    public BeforeBreadcrumbCallback getBeforeBreadcrumb() {
        return this.beforeBreadcrumb;
    }

    public void setBeforeBreadcrumb(BeforeBreadcrumbCallback beforeBreadcrumbCallback) {
        this.beforeBreadcrumb = beforeBreadcrumbCallback;
    }

    public String getCacheDirPath() {
        return this.cacheDirPath;
    }

    public String getOutboxPath() {
        String str = this.cacheDirPath;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return this.cacheDirPath + File.separator + "outbox";
    }

    public void setCacheDirPath(String str) {
        this.cacheDirPath = str;
    }

    public int getCacheDirSize() {
        return this.cacheDirSize;
    }

    public void setCacheDirSize(int i) {
        this.cacheDirSize = i;
    }

    public int getMaxBreadcrumbs() {
        return this.maxBreadcrumbs;
    }

    public void setMaxBreadcrumbs(int i) {
        this.maxBreadcrumbs = i;
    }

    public String getRelease() {
        return this.release;
    }

    public void setRelease(String str) {
        this.release = str;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public void setEnvironment(String str) {
        this.environment = str;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setProxy(Proxy proxy2) {
        this.proxy = proxy2;
    }

    public Double getSampleRate() {
        return this.sampleRate;
    }

    public void setSampleRate(Double d) {
        validateRate(d);
        this.sampleRate = d;
    }

    public Double getTracesSampleRate() {
        return this.tracesSampleRate;
    }

    public void setTracesSampleRate(Double d) {
        validateRate(d);
        this.tracesSampleRate = d;
    }

    public TracesSamplerCallback getTracesSampler() {
        return this.tracesSampler;
    }

    public void setTracesSampler(TracesSamplerCallback tracesSamplerCallback) {
        this.tracesSampler = tracesSamplerCallback;
    }

    public List<String> getInAppExcludes() {
        return this.inAppExcludes;
    }

    public void addInAppExclude(String str) {
        this.inAppExcludes.add(str);
    }

    public List<String> getInAppIncludes() {
        return this.inAppIncludes;
    }

    public void addInAppInclude(String str) {
        this.inAppIncludes.add(str);
    }

    public ITransportFactory getTransportFactory() {
        return this.transportFactory;
    }

    public void setTransportFactory(ITransportFactory iTransportFactory) {
        if (iTransportFactory == null) {
            iTransportFactory = NoOpTransportFactory.getInstance();
        }
        this.transportFactory = iTransportFactory;
    }

    public String getDist() {
        return this.dist;
    }

    public void setDist(String str) {
        this.dist = str;
    }

    public ITransportGate getTransportGate() {
        return this.transportGate;
    }

    public void setTransportGate(ITransportGate iTransportGate) {
        if (iTransportGate == null) {
            iTransportGate = NoOpTransportGate.getInstance();
        }
        this.transportGate = iTransportGate;
    }

    public boolean isAttachStacktrace() {
        return this.attachStacktrace;
    }

    public void setAttachStacktrace(boolean z) {
        this.attachStacktrace = z;
    }

    public boolean isAttachThreads() {
        return this.attachThreads;
    }

    public void setAttachThreads(boolean z) {
        this.attachThreads = z;
    }

    public boolean isEnableSessionTracking() {
        return this.enableSessionTracking;
    }

    public void setEnableSessionTracking(boolean z) {
        this.enableSessionTracking = z;
    }

    public String getServerName() {
        return this.serverName;
    }

    public void setServerName(String str) {
        this.serverName = str;
    }

    public boolean isAttachServerName() {
        return this.attachServerName;
    }

    public void setAttachServerName(boolean z) {
        this.attachServerName = z;
    }

    public long getSessionTrackingIntervalMillis() {
        return this.sessionTrackingIntervalMillis;
    }

    public void setSessionTrackingIntervalMillis(long j) {
        this.sessionTrackingIntervalMillis = j;
    }

    public String getDistinctId() {
        return this.distinctId;
    }

    public void setDistinctId(String str) {
        this.distinctId = str;
    }

    public long getFlushTimeoutMillis() {
        return this.flushTimeoutMillis;
    }

    public void setFlushTimeoutMillis(long j) {
        this.flushTimeoutMillis = j;
    }

    public boolean isEnableUncaughtExceptionHandler() {
        return Boolean.TRUE.equals(this.enableUncaughtExceptionHandler);
    }

    public Boolean getEnableUncaughtExceptionHandler() {
        return this.enableUncaughtExceptionHandler;
    }

    public void setEnableUncaughtExceptionHandler(Boolean bool) {
        this.enableUncaughtExceptionHandler = bool;
    }

    /* access modifiers changed from: package-private */
    public ISentryExecutorService getExecutorService() {
        return this.executorService;
    }

    /* access modifiers changed from: package-private */
    public void setExecutorService(ISentryExecutorService iSentryExecutorService) {
        if (iSentryExecutorService != null) {
            this.executorService = iSentryExecutorService;
        }
    }

    public int getConnectionTimeoutMillis() {
        return this.connectionTimeoutMillis;
    }

    public void setConnectionTimeoutMillis(int i) {
        this.connectionTimeoutMillis = i;
    }

    public int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public void setReadTimeoutMillis(int i) {
        this.readTimeoutMillis = i;
    }

    public IEnvelopeCache getEnvelopeDiskCache() {
        return this.envelopeDiskCache;
    }

    public void setEnvelopeDiskCache(IEnvelopeCache iEnvelopeCache) {
        if (iEnvelopeCache == null) {
            iEnvelopeCache = NoOpEnvelopeCache.getInstance();
        }
        this.envelopeDiskCache = iEnvelopeCache;
    }

    public int getMaxQueueSize() {
        return this.maxQueueSize;
    }

    public void setMaxQueueSize(int i) {
        if (i > 0) {
            this.maxQueueSize = i;
        }
    }

    public SdkVersion getSdkVersion() {
        return this.sdkVersion;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier2) {
        this.hostnameVerifier = hostnameVerifier2;
    }

    public void setSdkVersion(SdkVersion sdkVersion2) {
        this.sdkVersion = sdkVersion2;
    }

    public boolean isSendDefaultPii() {
        return this.sendDefaultPii;
    }

    public void setSendDefaultPii(boolean z) {
        this.sendDefaultPii = z;
    }

    public void addScopeObserver(IScopeObserver iScopeObserver) {
        this.observers.add(iScopeObserver);
    }

    /* access modifiers changed from: package-private */
    public List<IScopeObserver> getScopeObservers() {
        return this.observers;
    }

    public boolean isEnableScopeSync() {
        return this.enableScopeSync;
    }

    public void setEnableScopeSync(boolean z) {
        this.enableScopeSync = z;
    }

    public boolean isEnableExternalConfiguration() {
        return this.enableExternalConfiguration;
    }

    public void setEnableExternalConfiguration(boolean z) {
        this.enableExternalConfiguration = z;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public void setTag(String str, String str2) {
        this.tags.put(str, str2);
    }

    public long getMaxAttachmentSize() {
        return this.maxAttachmentSize;
    }

    public void setMaxAttachmentSize(long j) {
        this.maxAttachmentSize = j;
    }

    public SentryOptions() {
        this.integrations.add(new UncaughtExceptionHandlerIntegration());
        this.integrations.add(new ShutdownHookIntegration());
        this.eventProcessors.add(new MainEventProcessor(this));
        this.eventProcessors.add(new DuplicateEventDetectionEventProcessor(this));
        setSentryClientName("sentry.java/4.1.0");
        setSdkVersion(createSdkVersion());
    }

    /* access modifiers changed from: package-private */
    public void merge(SentryOptions sentryOptions) {
        if (sentryOptions.getDsn() != null) {
            setDsn(sentryOptions.getDsn());
        }
        if (sentryOptions.getEnvironment() != null) {
            setEnvironment(sentryOptions.getEnvironment());
        }
        if (sentryOptions.getRelease() != null) {
            setRelease(sentryOptions.getRelease());
        }
        if (sentryOptions.getDist() != null) {
            setDist(sentryOptions.getDist());
        }
        if (sentryOptions.getServerName() != null) {
            setServerName(sentryOptions.getServerName());
        }
        if (sentryOptions.getProxy() != null) {
            setProxy(sentryOptions.getProxy());
        }
        if (sentryOptions.getEnableUncaughtExceptionHandler() != null) {
            setEnableUncaughtExceptionHandler(sentryOptions.getEnableUncaughtExceptionHandler());
        }
        if (sentryOptions.getTracesSampleRate() != null) {
            setTracesSampleRate(sentryOptions.getTracesSampleRate());
        }
        if (sentryOptions.getDebug() != null) {
            setDebug(sentryOptions.getDebug());
        }
        for (Map.Entry entry : new HashMap(sentryOptions.getTags()).entrySet()) {
            this.tags.put((String) entry.getKey(), (String) entry.getValue());
        }
    }

    private SdkVersion createSdkVersion() {
        SdkVersion sdkVersion2 = new SdkVersion(BuildConfig.SENTRY_JAVA_SDK_NAME, "4.1.0");
        sdkVersion2.setVersion("4.1.0");
        sdkVersion2.addPackage("maven:sentry", "4.1.0");
        return sdkVersion2;
    }

    private void validateRate(Double d) {
        if (d == null) {
            return;
        }
        if (d.doubleValue() > 1.0d || d.doubleValue() <= Utils.DOUBLE_EPSILON) {
            throw new IllegalArgumentException("The value " + d + " is not valid. Use null to disable or values between 0.01 (inclusive) and 1.0 (exclusive).");
        }
    }

    public static final class Proxy {
        private String host;
        private String pass;
        private String port;
        private String user;

        public Proxy(String str, String str2, String str3, String str4) {
            this.host = str;
            this.port = str2;
            this.user = str3;
            this.pass = str4;
        }

        public Proxy() {
            this((String) null, (String) null, (String) null, (String) null);
        }

        public Proxy(String str, String str2) {
            this(str, str2, (String) null, (String) null);
        }

        public String getHost() {
            return this.host;
        }

        public void setHost(String str) {
            this.host = str;
        }

        public String getPort() {
            return this.port;
        }

        public void setPort(String str) {
            this.port = str;
        }

        public String getUser() {
            return this.user;
        }

        public void setUser(String str) {
            this.user = str;
        }

        public String getPass() {
            return this.pass;
        }

        public void setPass(String str) {
            this.pass = str;
        }
    }
}
