package io.sentry.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.SpanContext;
import io.sentry.protocol.App;
import io.sentry.protocol.Browser;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.Device;
import io.sentry.protocol.Gpu;
import io.sentry.protocol.OperatingSystem;
import io.sentry.protocol.SentryRuntime;
import java.lang.reflect.Type;

public final class ContextsDeserializerAdapter implements JsonDeserializer<Contexts> {
    private final ILogger logger;

    public ContextsDeserializerAdapter(ILogger iLogger) {
        this.logger = iLogger;
    }

    public Contexts deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement == null) {
            return null;
        }
        try {
            if (jsonElement.isJsonNull()) {
                return null;
            }
            Contexts contexts = new Contexts();
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            if (asJsonObject != null && !asJsonObject.isJsonNull()) {
                for (String next : asJsonObject.keySet()) {
                    char c = 65535;
                    switch (next.hashCode()) {
                        case -1335157162:
                            if (next.equals(Device.TYPE)) {
                                c = 2;
                                break;
                            }
                            break;
                        case 3556:
                            if (next.equals(OperatingSystem.TYPE)) {
                                c = 3;
                                break;
                            }
                            break;
                        case 96801:
                            if (next.equals(App.TYPE)) {
                                c = 0;
                                break;
                            }
                            break;
                        case 102572:
                            if (next.equals(Gpu.TYPE)) {
                                c = 5;
                                break;
                            }
                            break;
                        case 110620997:
                            if (next.equals(SpanContext.TYPE)) {
                                c = 6;
                                break;
                            }
                            break;
                        case 150940456:
                            if (next.equals(Browser.TYPE)) {
                                c = 1;
                                break;
                            }
                            break;
                        case 1550962648:
                            if (next.equals(SentryRuntime.TYPE)) {
                                c = 4;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            App app = (App) parseObject(jsonDeserializationContext, asJsonObject, next, App.class);
                            if (app == null) {
                                break;
                            } else {
                                contexts.setApp(app);
                                break;
                            }
                        case 1:
                            Browser browser = (Browser) parseObject(jsonDeserializationContext, asJsonObject, next, Browser.class);
                            if (browser == null) {
                                break;
                            } else {
                                contexts.setBrowser(browser);
                                break;
                            }
                        case 2:
                            Device device = (Device) parseObject(jsonDeserializationContext, asJsonObject, next, Device.class);
                            if (device == null) {
                                break;
                            } else {
                                contexts.setDevice(device);
                                break;
                            }
                        case 3:
                            OperatingSystem operatingSystem = (OperatingSystem) parseObject(jsonDeserializationContext, asJsonObject, next, OperatingSystem.class);
                            if (operatingSystem == null) {
                                break;
                            } else {
                                contexts.setOperatingSystem(operatingSystem);
                                break;
                            }
                        case 4:
                            SentryRuntime sentryRuntime = (SentryRuntime) parseObject(jsonDeserializationContext, asJsonObject, next, SentryRuntime.class);
                            if (sentryRuntime == null) {
                                break;
                            } else {
                                contexts.setRuntime(sentryRuntime);
                                break;
                            }
                        case 5:
                            Gpu gpu = (Gpu) parseObject(jsonDeserializationContext, asJsonObject, next, Gpu.class);
                            if (gpu == null) {
                                break;
                            } else {
                                contexts.setGpu(gpu);
                                break;
                            }
                        case 6:
                            SpanContext spanContext = (SpanContext) parseObject(jsonDeserializationContext, asJsonObject, next, SpanContext.class);
                            if (spanContext == null) {
                                break;
                            } else {
                                contexts.setTrace(spanContext);
                                break;
                            }
                        default:
                            JsonElement jsonElement2 = asJsonObject.get(next);
                            if (jsonElement2 != null && !jsonElement2.isJsonNull()) {
                                try {
                                    contexts.put(next, jsonDeserializationContext.deserialize(jsonElement2, Object.class));
                                    break;
                                } catch (JsonParseException e) {
                                    this.logger.log(SentryLevel.ERROR, e, "Error when deserializing the %s key.", next);
                                    break;
                                }
                            }
                    }
                }
            }
            return contexts;
        } catch (Exception e2) {
            this.logger.log(SentryLevel.ERROR, "Error when deserializing Contexts", (Throwable) e2);
            return null;
        }
    }

    private <T> T parseObject(JsonDeserializationContext jsonDeserializationContext, JsonObject jsonObject, String str, Class<T> cls) throws JsonParseException {
        JsonObject asJsonObject = jsonObject.getAsJsonObject(str);
        if (asJsonObject == null || asJsonObject.isJsonNull()) {
            return null;
        }
        return jsonDeserializationContext.deserialize(asJsonObject, cls);
    }
}
