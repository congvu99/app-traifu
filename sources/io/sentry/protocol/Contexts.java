package io.sentry.protocol;

import io.sentry.SpanContext;
import io.sentry.util.Objects;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Contexts extends ConcurrentHashMap<String, Object> implements Cloneable {
    private static final long serialVersionUID = 252445813254943011L;

    private <T> T toContextType(String str, Class<T> cls) {
        Object obj = get(str);
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        return null;
    }

    public SpanContext getTrace() {
        return (SpanContext) toContextType(SpanContext.TYPE, SpanContext.class);
    }

    public void setTrace(SpanContext spanContext) {
        Objects.requireNonNull(spanContext, "traceContext is required");
        put(SpanContext.TYPE, spanContext);
    }

    public App getApp() {
        return (App) toContextType(App.TYPE, App.class);
    }

    public void setApp(App app) {
        put(App.TYPE, app);
    }

    public Browser getBrowser() {
        return (Browser) toContextType(Browser.TYPE, Browser.class);
    }

    public void setBrowser(Browser browser) {
        put(Browser.TYPE, browser);
    }

    public Device getDevice() {
        return (Device) toContextType(Device.TYPE, Device.class);
    }

    public void setDevice(Device device) {
        put(Device.TYPE, device);
    }

    public OperatingSystem getOperatingSystem() {
        return (OperatingSystem) toContextType(OperatingSystem.TYPE, OperatingSystem.class);
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        put(OperatingSystem.TYPE, operatingSystem);
    }

    public SentryRuntime getRuntime() {
        return (SentryRuntime) toContextType(SentryRuntime.TYPE, SentryRuntime.class);
    }

    public void setRuntime(SentryRuntime sentryRuntime) {
        put(SentryRuntime.TYPE, sentryRuntime);
    }

    public Gpu getGpu() {
        return (Gpu) toContextType(Gpu.TYPE, Gpu.class);
    }

    public void setGpu(Gpu gpu) {
        put(Gpu.TYPE, gpu);
    }

    public Contexts clone() throws CloneNotSupportedException {
        Contexts contexts = new Contexts();
        for (Map.Entry entry : entrySet()) {
            if (entry != null) {
                Object value = entry.getValue();
                if (App.TYPE.equals(entry.getKey()) && (value instanceof App)) {
                    contexts.setApp(((App) value).clone());
                } else if (Browser.TYPE.equals(entry.getKey()) && (value instanceof Browser)) {
                    contexts.setBrowser(((Browser) value).clone());
                } else if (Device.TYPE.equals(entry.getKey()) && (value instanceof Device)) {
                    contexts.setDevice(((Device) value).clone());
                } else if (OperatingSystem.TYPE.equals(entry.getKey()) && (value instanceof OperatingSystem)) {
                    contexts.setOperatingSystem(((OperatingSystem) value).clone());
                } else if (SentryRuntime.TYPE.equals(entry.getKey()) && (value instanceof SentryRuntime)) {
                    contexts.setRuntime(((SentryRuntime) value).clone());
                } else if (Gpu.TYPE.equals(entry.getKey()) && (value instanceof Gpu)) {
                    contexts.setGpu(((Gpu) value).clone());
                } else if (!SpanContext.TYPE.equals(entry.getKey()) || !(value instanceof SpanContext)) {
                    contexts.put((String) entry.getKey(), value);
                } else {
                    contexts.setTrace(((SpanContext) value).clone());
                }
            }
        }
        return contexts;
    }
}
