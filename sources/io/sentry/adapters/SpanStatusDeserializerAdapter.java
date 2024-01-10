package io.sentry.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.SpanStatus;
import java.lang.reflect.Type;
import java.util.Locale;

public final class SpanStatusDeserializerAdapter implements JsonDeserializer<SpanStatus> {
    private final ILogger logger;

    public SpanStatusDeserializerAdapter(ILogger iLogger) {
        this.logger = iLogger;
    }

    public SpanStatus deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement == null) {
            return null;
        }
        try {
            return SpanStatus.valueOf(jsonElement.getAsString().toUpperCase(Locale.ROOT));
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error when deserializing SpanStatus", (Throwable) e);
            return null;
        }
    }
}
