package io.sentry;

import io.sentry.protocol.DebugMeta;
import io.sentry.protocol.Message;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryThread;
import io.sentry.protocol.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SentryEvent extends SentryBaseEvent implements IUnknownPropertiesConsumer {
    private List<Breadcrumb> breadcrumbs;
    private DebugMeta debugMeta;
    private String dist;
    private SentryValues<SentryException> exception;
    private Map<String, Object> extra;
    private List<String> fingerprint;
    private SentryLevel level;
    private String logger;
    private Message message;
    private Map<String, String> modules;
    private String platform;
    private String serverName;
    private SentryValues<SentryThread> threads;
    private final Date timestamp;
    private String transaction;
    private Map<String, Object> unknown;
    private User user;

    SentryEvent(SentryId sentryId, Date date) {
        super(sentryId);
        this.timestamp = date;
    }

    public SentryEvent(Throwable th) {
        this();
        this.throwable = th;
    }

    public SentryEvent() {
        this(new SentryId(), DateUtils.getCurrentDateTime());
    }

    public SentryEvent(Date date) {
        this(new SentryId(), date);
    }

    public Date getTimestamp() {
        return (Date) this.timestamp.clone();
    }

    public Message getMessage() {
        return this.message;
    }

    public void setMessage(Message message2) {
        this.message = message2;
    }

    public String getServerName() {
        return this.serverName;
    }

    public void setServerName(String str) {
        this.serverName = str;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public String getDist() {
        return this.dist;
    }

    public void setDist(String str) {
        this.dist = str;
    }

    public String getLogger() {
        return this.logger;
    }

    public void setLogger(String str) {
        this.logger = str;
    }

    public List<SentryThread> getThreads() {
        SentryValues<SentryThread> sentryValues = this.threads;
        if (sentryValues != null) {
            return sentryValues.getValues();
        }
        return null;
    }

    public void setThreads(List<SentryThread> list) {
        this.threads = new SentryValues<>(list);
    }

    public List<SentryException> getExceptions() {
        SentryValues<SentryException> sentryValues = this.exception;
        if (sentryValues == null) {
            return null;
        }
        return sentryValues.getValues();
    }

    public void setExceptions(List<SentryException> list) {
        this.exception = new SentryValues<>(list);
    }

    public SentryLevel getLevel() {
        return this.level;
    }

    public void setLevel(SentryLevel sentryLevel) {
        this.level = sentryLevel;
    }

    public String getTransaction() {
        return this.transaction;
    }

    public void setTransaction(String str) {
        this.transaction = str;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user2) {
        this.user = user2;
    }

    public List<String> getFingerprints() {
        return this.fingerprint;
    }

    public void setFingerprints(List<String> list) {
        this.fingerprint = list;
    }

    public List<Breadcrumb> getBreadcrumbs() {
        return this.breadcrumbs;
    }

    public void setBreadcrumbs(List<Breadcrumb> list) {
        this.breadcrumbs = list;
    }

    public void addBreadcrumb(Breadcrumb breadcrumb) {
        if (this.breadcrumbs == null) {
            this.breadcrumbs = new ArrayList();
        }
        this.breadcrumbs.add(breadcrumb);
    }

    public void addBreadcrumb(String str) {
        addBreadcrumb(new Breadcrumb(str));
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getExtras() {
        return this.extra;
    }

    public void setExtras(Map<String, Object> map) {
        this.extra = map;
    }

    public void setExtra(String str, Object obj) {
        if (this.extra == null) {
            this.extra = new HashMap();
        }
        this.extra.put(str, obj);
    }

    public void removeExtra(String str) {
        Map<String, Object> map = this.extra;
        if (map != null) {
            map.remove(str);
        }
    }

    public Object getExtra(String str) {
        Map<String, Object> map = this.extra;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = map;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> getModules() {
        return this.modules;
    }

    public void setModules(Map<String, String> map) {
        this.modules = map;
    }

    public void setModule(String str, String str2) {
        if (this.modules == null) {
            this.modules = new HashMap();
        }
        this.modules.put(str, str2);
    }

    public void removeModule(String str) {
        Map<String, String> map = this.modules;
        if (map != null) {
            map.remove(str);
        }
    }

    public String getModule(String str) {
        Map<String, String> map = this.modules;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public DebugMeta getDebugMeta() {
        return this.debugMeta;
    }

    public void setDebugMeta(DebugMeta debugMeta2) {
        this.debugMeta = debugMeta2;
    }

    public boolean isCrashed() {
        SentryValues<SentryException> sentryValues = this.exception;
        if (sentryValues == null) {
            return false;
        }
        for (SentryException next : sentryValues.getValues()) {
            if (next.getMechanism() != null && next.getMechanism().isHandled() != null && !next.getMechanism().isHandled().booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public boolean isErrored() {
        SentryValues<SentryException> sentryValues = this.exception;
        return sentryValues != null && !sentryValues.getValues().isEmpty();
    }
}
