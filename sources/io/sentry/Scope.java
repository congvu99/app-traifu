package io.sentry;

import io.sentry.SentryOptions;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.User;
import io.sentry.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class Scope implements Cloneable {
    private List<Attachment> attachments = new CopyOnWriteArrayList();
    private Queue<Breadcrumb> breadcrumbs;
    private Contexts contexts = new Contexts();
    private List<EventProcessor> eventProcessors = new CopyOnWriteArrayList();
    private Map<String, Object> extra = new ConcurrentHashMap();
    private List<String> fingerprint = new ArrayList();
    private SentryLevel level;
    private final SentryOptions options;
    private volatile Session session;
    private final Object sessionLock = new Object();
    private Map<String, String> tags = new ConcurrentHashMap();
    private ITransaction transaction;
    private String transactionName;
    private User user;

    interface IWithSession {
        void accept(Session session);
    }

    public Scope(SentryOptions sentryOptions) {
        this.options = sentryOptions;
        this.breadcrumbs = createBreadcrumbsList(sentryOptions.getMaxBreadcrumbs());
    }

    public SentryLevel getLevel() {
        return this.level;
    }

    public void setLevel(SentryLevel sentryLevel) {
        this.level = sentryLevel;
    }

    public String getTransactionName() {
        ITransaction iTransaction = this.transaction;
        return iTransaction != null ? iTransaction.getTransaction() : this.transactionName;
    }

    public void setTransaction(String str) {
        ITransaction iTransaction = this.transaction;
        if (iTransaction != null) {
            iTransaction.setName(str);
        }
        this.transactionName = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r0.getLatestActiveSpan();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.sentry.ISpan getSpan() {
        /*
            r2 = this;
            io.sentry.ITransaction r0 = r2.transaction
            if (r0 == 0) goto L_0x000b
            io.sentry.Span r1 = r0.getLatestActiveSpan()
            if (r1 == 0) goto L_0x000b
            return r1
        L_0x000b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.Scope.getSpan():io.sentry.ISpan");
    }

    public void setTransaction(ITransaction iTransaction) {
        this.transaction = (ITransaction) Objects.requireNonNull(iTransaction, "transaction is required");
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user2) {
        this.user = user2;
        if (this.options.isEnableScopeSync()) {
            for (IScopeObserver user3 : this.options.getScopeObservers()) {
                user3.setUser(user2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public List<String> getFingerprint() {
        return this.fingerprint;
    }

    public void setFingerprint(List<String> list) {
        if (list != null) {
            this.fingerprint = list;
        }
    }

    /* access modifiers changed from: package-private */
    public Queue<Breadcrumb> getBreadcrumbs() {
        return this.breadcrumbs;
    }

    private Breadcrumb executeBeforeBreadcrumb(SentryOptions.BeforeBreadcrumbCallback beforeBreadcrumbCallback, Breadcrumb breadcrumb, Object obj) {
        try {
            return beforeBreadcrumbCallback.execute(breadcrumb, obj);
        } catch (Exception e) {
            this.options.getLogger().log(SentryLevel.ERROR, "The BeforeBreadcrumbCallback callback threw an exception. It will be added as breadcrumb and continue.", (Throwable) e);
            breadcrumb.setData("sentry:message", e.getMessage());
            return breadcrumb;
        }
    }

    public void addBreadcrumb(Breadcrumb breadcrumb, Object obj) {
        if (breadcrumb != null) {
            SentryOptions.BeforeBreadcrumbCallback beforeBreadcrumb = this.options.getBeforeBreadcrumb();
            if (beforeBreadcrumb != null) {
                breadcrumb = executeBeforeBreadcrumb(beforeBreadcrumb, breadcrumb, obj);
            }
            if (breadcrumb != null) {
                this.breadcrumbs.add(breadcrumb);
                if (this.options.isEnableScopeSync()) {
                    for (IScopeObserver addBreadcrumb : this.options.getScopeObservers()) {
                        addBreadcrumb.addBreadcrumb(breadcrumb);
                    }
                    return;
                }
                return;
            }
            this.options.getLogger().log(SentryLevel.INFO, "Breadcrumb was dropped by beforeBreadcrumb", new Object[0]);
        }
    }

    public void addBreadcrumb(Breadcrumb breadcrumb) {
        addBreadcrumb(breadcrumb, (Object) null);
    }

    public void clearBreadcrumbs() {
        this.breadcrumbs.clear();
    }

    public void clearTransaction() {
        this.transaction = null;
        this.transactionName = null;
    }

    public ITransaction getTransaction() {
        return this.transaction;
    }

    public void clear() {
        this.level = null;
        this.transaction = null;
        this.user = null;
        this.fingerprint.clear();
        this.breadcrumbs.clear();
        this.tags.clear();
        this.extra.clear();
        this.eventProcessors.clear();
        clearTransaction();
        this.attachments.clear();
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> getTags() {
        return this.tags;
    }

    public void setTag(String str, String str2) {
        this.tags.put(str, str2);
        if (this.options.isEnableScopeSync()) {
            for (IScopeObserver tag : this.options.getScopeObservers()) {
                tag.setTag(str, str2);
            }
        }
    }

    public void removeTag(String str) {
        this.tags.remove(str);
        if (this.options.isEnableScopeSync()) {
            for (IScopeObserver removeTag : this.options.getScopeObservers()) {
                removeTag.removeTag(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getExtras() {
        return this.extra;
    }

    public void setExtra(String str, String str2) {
        this.extra.put(str, str2);
        if (this.options.isEnableScopeSync()) {
            for (IScopeObserver extra2 : this.options.getScopeObservers()) {
                extra2.setExtra(str, str2);
            }
        }
    }

    public void removeExtra(String str) {
        this.extra.remove(str);
        if (this.options.isEnableScopeSync()) {
            for (IScopeObserver removeExtra : this.options.getScopeObservers()) {
                removeExtra.removeExtra(str);
            }
        }
    }

    public Contexts getContexts() {
        return this.contexts;
    }

    public void setContexts(String str, Object obj) {
        this.contexts.put(str, obj);
    }

    public void setContexts(String str, Boolean bool) {
        HashMap hashMap = new HashMap();
        hashMap.put("value", bool);
        setContexts(str, (Object) hashMap);
    }

    public void setContexts(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("value", str2);
        setContexts(str, (Object) hashMap);
    }

    public void setContexts(String str, Number number) {
        HashMap hashMap = new HashMap();
        hashMap.put("value", number);
        setContexts(str, (Object) hashMap);
    }

    public void removeContexts(String str) {
        this.contexts.remove(str);
    }

    /* access modifiers changed from: package-private */
    public List<Attachment> getAttachments() {
        return new CopyOnWriteArrayList(this.attachments);
    }

    public void addAttachment(Attachment attachment) {
        this.attachments.add(attachment);
    }

    private Queue<Breadcrumb> createBreadcrumbsList(int i) {
        return SynchronizedQueue.synchronizedQueue(new CircularFifoQueue(i));
    }

    public Scope clone() throws CloneNotSupportedException {
        Scope scope = (Scope) super.clone();
        SentryLevel sentryLevel = this.level;
        User user2 = null;
        scope.level = sentryLevel != null ? SentryLevel.valueOf(sentryLevel.name().toUpperCase(Locale.ROOT)) : null;
        User user3 = this.user;
        if (user3 != null) {
            user2 = user3.clone();
        }
        scope.user = user2;
        scope.fingerprint = new ArrayList(this.fingerprint);
        scope.eventProcessors = new CopyOnWriteArrayList(this.eventProcessors);
        Queue<Breadcrumb> queue = this.breadcrumbs;
        Queue<Breadcrumb> createBreadcrumbsList = createBreadcrumbsList(this.options.getMaxBreadcrumbs());
        for (Breadcrumb clone : queue) {
            createBreadcrumbsList.add(clone.clone());
        }
        scope.breadcrumbs = createBreadcrumbsList;
        Map<String, String> map = this.tags;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (next != null) {
                concurrentHashMap.put((String) next.getKey(), (String) next.getValue());
            }
        }
        scope.tags = concurrentHashMap;
        Map<String, Object> map2 = this.extra;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        for (Map.Entry next2 : map2.entrySet()) {
            if (next2 != null) {
                concurrentHashMap2.put((String) next2.getKey(), next2.getValue());
            }
        }
        scope.extra = concurrentHashMap2;
        scope.contexts = this.contexts.clone();
        scope.attachments = new CopyOnWriteArrayList(this.attachments);
        return scope;
    }

    /* access modifiers changed from: package-private */
    public List<EventProcessor> getEventProcessors() {
        return this.eventProcessors;
    }

    public void addEventProcessor(EventProcessor eventProcessor) {
        this.eventProcessors.add(eventProcessor);
    }

    /* access modifiers changed from: package-private */
    public Session withSession(IWithSession iWithSession) {
        Session clone;
        synchronized (this.sessionLock) {
            iWithSession.accept(this.session);
            clone = this.session != null ? this.session.clone() : null;
        }
        return clone;
    }

    /* access modifiers changed from: package-private */
    public SessionPair startSession() {
        SessionPair sessionPair;
        synchronized (this.sessionLock) {
            if (this.session != null) {
                this.session.end();
            }
            Session session2 = this.session;
            this.session = new Session(this.options.getDistinctId(), this.user, this.options.getEnvironment(), this.options.getRelease());
            sessionPair = new SessionPair(this.session.clone(), session2 != null ? session2.clone() : null);
        }
        return sessionPair;
    }

    static final class SessionPair {
        private final Session current;
        private final Session previous;

        public SessionPair(Session session, Session session2) {
            this.current = session;
            this.previous = session2;
        }

        public Session getPrevious() {
            return this.previous;
        }

        public Session getCurrent() {
            return this.current;
        }
    }

    /* access modifiers changed from: package-private */
    public Session endSession() {
        Session session2;
        synchronized (this.sessionLock) {
            session2 = null;
            if (this.session != null) {
                this.session.end();
                Session clone = this.session.clone();
                this.session = null;
                session2 = clone;
            }
        }
        return session2;
    }
}
