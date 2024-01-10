package io.sentry;

import io.sentry.protocol.SentryException;
import io.sentry.protocol.User;
import io.sentry.util.ApplyScopeUtils;
import io.sentry.util.Objects;
import java.util.ArrayList;
import java.util.Map;

public final class MainEventProcessor implements EventProcessor {
    private static final String DEFAULT_ENVIRONMENT = "production";
    public static final String DEFAULT_IP_ADDRESS = "{{auto}}";
    private final HostnameCache hostnameCache;
    private final SentryOptions options;
    private final SentryExceptionFactory sentryExceptionFactory;
    private final SentryThreadFactory sentryThreadFactory;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    MainEventProcessor(SentryOptions sentryOptions) {
        this(sentryOptions, sentryOptions.isAttachServerName() ? new HostnameCache() : null);
    }

    MainEventProcessor(SentryOptions sentryOptions, HostnameCache hostnameCache2) {
        SentryOptions sentryOptions2 = (SentryOptions) Objects.requireNonNull(sentryOptions, "The SentryOptions is required.");
        this.options = sentryOptions2;
        this.hostnameCache = hostnameCache2;
        SentryStackTraceFactory sentryStackTraceFactory = new SentryStackTraceFactory(sentryOptions2.getInAppExcludes(), this.options.getInAppIncludes());
        this.sentryExceptionFactory = new SentryExceptionFactory(sentryStackTraceFactory);
        this.sentryThreadFactory = new SentryThreadFactory(sentryStackTraceFactory, this.options);
    }

    MainEventProcessor(SentryOptions sentryOptions, SentryThreadFactory sentryThreadFactory2, SentryExceptionFactory sentryExceptionFactory2, HostnameCache hostnameCache2) {
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "The SentryOptions is required.");
        this.sentryThreadFactory = (SentryThreadFactory) Objects.requireNonNull(sentryThreadFactory2, "The SentryThreadFactory is required.");
        this.sentryExceptionFactory = (SentryExceptionFactory) Objects.requireNonNull(sentryExceptionFactory2, "The SentryExceptionFactory is required.");
        this.hostnameCache = (HostnameCache) Objects.requireNonNull(hostnameCache2, "The HostnameCache is required");
    }

    public SentryEvent process(SentryEvent sentryEvent, Object obj) {
        if (sentryEvent.getPlatform() == null) {
            sentryEvent.setPlatform("java");
        }
        Throwable throwable = sentryEvent.getThrowable();
        if (throwable != null) {
            sentryEvent.setExceptions(this.sentryExceptionFactory.getSentryExceptions(throwable));
        }
        if (ApplyScopeUtils.shouldApplyScopeData(obj)) {
            processNonCachedEvent(sentryEvent);
        } else {
            this.options.getLogger().log(SentryLevel.DEBUG, "Event was cached so not applying data relevant to the current app execution/version: %s", sentryEvent.getEventId());
        }
        return sentryEvent;
    }

    private void processNonCachedEvent(SentryEvent sentryEvent) {
        if (sentryEvent.getRelease() == null) {
            sentryEvent.setRelease(this.options.getRelease());
        }
        if (sentryEvent.getEnvironment() == null) {
            sentryEvent.setEnvironment(this.options.getEnvironment() != null ? this.options.getEnvironment() : DEFAULT_ENVIRONMENT);
        }
        if (sentryEvent.getServerName() == null) {
            sentryEvent.setServerName(this.options.getServerName());
        }
        if (sentryEvent.getDist() == null) {
            sentryEvent.setDist(this.options.getDist());
        }
        if (sentryEvent.getSdk() == null) {
            sentryEvent.setSdk(this.options.getSdkVersion());
        }
        for (Map.Entry next : this.options.getTags().entrySet()) {
            if (sentryEvent.getTag((String) next.getKey()) == null) {
                sentryEvent.setTag((String) next.getKey(), (String) next.getValue());
            }
        }
        if (sentryEvent.getThreads() == null) {
            ArrayList arrayList = null;
            boolean z = sentryEvent.getExceptions() != null && !sentryEvent.getExceptions().isEmpty();
            if (z) {
                for (SentryException next2 : sentryEvent.getExceptions()) {
                    if (!(next2.getMechanism() == null || next2.getThreadId() == null)) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(next2.getThreadId());
                    }
                }
            }
            if (this.options.isAttachThreads()) {
                sentryEvent.setThreads(this.sentryThreadFactory.getCurrentThreads(arrayList));
            } else if (this.options.isAttachStacktrace() && !z) {
                sentryEvent.setThreads(this.sentryThreadFactory.getCurrentThread());
            }
        }
        if (this.options.isSendDefaultPii()) {
            if (sentryEvent.getUser() == null) {
                User user = new User();
                user.setIpAddress(DEFAULT_IP_ADDRESS);
                sentryEvent.setUser(user);
            } else if (sentryEvent.getUser().getIpAddress() == null) {
                sentryEvent.getUser().setIpAddress(DEFAULT_IP_ADDRESS);
            }
        }
        if (this.options.isAttachServerName() && this.hostnameCache != null && sentryEvent.getServerName() == null) {
            sentryEvent.setServerName(this.hostnameCache.getHostname());
        }
    }
}
