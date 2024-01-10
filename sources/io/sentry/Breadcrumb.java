package io.sentry;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.util.CollectionUtils;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Breadcrumb implements Cloneable, IUnknownPropertiesConsumer {
    private String category;
    private Map<String, Object> data;
    private SentryLevel level;
    private String message;
    private final Date timestamp;
    private String type;
    private Map<String, Object> unknown;

    public Breadcrumb(Date date) {
        this.data = new ConcurrentHashMap();
        this.timestamp = date;
    }

    public static Breadcrumb http(String str, String str2) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType("http");
        breadcrumb.setCategory("http");
        breadcrumb.setData("url", str);
        breadcrumb.setData(FirebaseAnalytics.Param.METHOD, str2.toUpperCase(Locale.ROOT));
        return breadcrumb;
    }

    public Breadcrumb() {
        this(DateUtils.getCurrentDateTime());
    }

    public Breadcrumb(String str) {
        this();
        this.message = str;
    }

    public Date getTimestamp() {
        return (Date) this.timestamp.clone();
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public Object getData(String str) {
        return this.data.get(str);
    }

    public void setData(String str, Object obj) {
        this.data.put(str, obj);
    }

    public void removeData(String str) {
        this.data.remove(str);
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public SentryLevel getLevel() {
        return this.level;
    }

    public void setLevel(SentryLevel sentryLevel) {
        this.level = sentryLevel;
    }

    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = new ConcurrentHashMap(map);
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public Breadcrumb clone() throws CloneNotSupportedException {
        Breadcrumb breadcrumb = (Breadcrumb) super.clone();
        breadcrumb.data = CollectionUtils.shallowCopy(this.data);
        breadcrumb.unknown = CollectionUtils.shallowCopy(this.unknown);
        SentryLevel sentryLevel = this.level;
        breadcrumb.level = sentryLevel != null ? SentryLevel.valueOf(sentryLevel.name().toUpperCase(Locale.ROOT)) : null;
        return breadcrumb;
    }
}
