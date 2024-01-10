package io.sentry.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.lang.reflect.Type;
import java.util.Locale;

public final class SentryLevelDeserializerAdapter implements JsonDeserializer<SentryLevel> {
    private final ILogger logger;

    public SentryLevelDeserializerAdapter(ILogger iLogger) {
        this.logger = iLogger;
    }

    public SentryLevel deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement == null) {
            return null;
        }
        try {
            return SentryLevel.valueOf(jsonElement.getAsString().toUpperCase(Locale.ROOT));
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error when deserializing SentryLevel", (Throwable) e);
            return null;
        }
    }
}
