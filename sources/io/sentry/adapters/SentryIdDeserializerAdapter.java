package io.sentry.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.protocol.SentryId;
import java.lang.reflect.Type;

public final class SentryIdDeserializerAdapter implements JsonDeserializer<SentryId> {
    private final ILogger logger;

    public SentryIdDeserializerAdapter(ILogger iLogger) {
        this.logger = iLogger;
    }

    public SentryId deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement == null) {
            return null;
        }
        try {
            return new SentryId(jsonElement.getAsString());
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error when deserializing SentryId", (Throwable) e);
            return null;
        }
    }
}
