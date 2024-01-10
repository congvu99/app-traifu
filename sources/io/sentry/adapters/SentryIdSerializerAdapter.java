package io.sentry.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.protocol.SentryId;
import java.lang.reflect.Type;

public final class SentryIdSerializerAdapter implements JsonSerializer<SentryId> {
    private final ILogger logger;

    public SentryIdSerializerAdapter(ILogger iLogger) {
        this.logger = iLogger;
    }

    public JsonElement serialize(SentryId sentryId, Type type, JsonSerializationContext jsonSerializationContext) {
        if (sentryId == null) {
            return null;
        }
        try {
            return new JsonPrimitive(sentryId.toString());
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error when serializing SentryId", (Throwable) e);
            return null;
        }
    }
}
