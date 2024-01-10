package io.sentry.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.SpanStatus;
import java.lang.reflect.Type;
import java.util.Locale;

public final class SpanStatusSerializerAdapter implements JsonSerializer<SpanStatus> {
    private final ILogger logger;

    public SpanStatusSerializerAdapter(ILogger iLogger) {
        this.logger = iLogger;
    }

    public JsonElement serialize(SpanStatus spanStatus, Type type, JsonSerializationContext jsonSerializationContext) {
        if (spanStatus == null) {
            return null;
        }
        try {
            return new JsonPrimitive(spanStatus.name().toLowerCase(Locale.ROOT));
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error when serializing SpanStatus", (Throwable) e);
            return null;
        }
    }
}
