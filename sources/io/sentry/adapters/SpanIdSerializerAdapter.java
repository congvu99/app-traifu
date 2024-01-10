package io.sentry.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.SpanId;
import java.lang.reflect.Type;

public final class SpanIdSerializerAdapter implements JsonSerializer<SpanId> {
    private final ILogger logger;

    public SpanIdSerializerAdapter(ILogger iLogger) {
        this.logger = iLogger;
    }

    public JsonElement serialize(SpanId spanId, Type type, JsonSerializationContext jsonSerializationContext) {
        if (spanId == null) {
            return null;
        }
        try {
            return new JsonPrimitive(spanId.toString());
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error when serializing SpanId", (Throwable) e);
            return null;
        }
    }
}
