package io.sentry.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.lang.reflect.Type;
import java.util.Locale;

public final class SentryLevelSerializerAdapter implements JsonSerializer<SentryLevel> {
    private final ILogger logger;

    public SentryLevelSerializerAdapter(ILogger iLogger) {
        this.logger = iLogger;
    }

    public JsonElement serialize(SentryLevel sentryLevel, Type type, JsonSerializationContext jsonSerializationContext) {
        if (sentryLevel == null) {
            return null;
        }
        try {
            return new JsonPrimitive(sentryLevel.name().toLowerCase(Locale.ROOT));
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error when serializing SentryLevel", (Throwable) e);
            return null;
        }
    }
}
