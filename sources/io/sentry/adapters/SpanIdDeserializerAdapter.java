package io.sentry.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.SpanId;
import java.lang.reflect.Type;

public final class SpanIdDeserializerAdapter implements JsonDeserializer<SpanId> {
    private final ILogger logger;

    public SpanIdDeserializerAdapter(ILogger iLogger) {
        this.logger = iLogger;
    }

    public SpanId deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement == null) {
            return null;
        }
        try {
            return new SpanId(jsonElement.getAsString());
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error when deserializing SpanId", (Throwable) e);
            return null;
        }
    }
}
