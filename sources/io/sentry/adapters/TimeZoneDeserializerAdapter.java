package io.sentry.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.lang.reflect.Type;
import java.util.TimeZone;

public final class TimeZoneDeserializerAdapter implements JsonDeserializer<TimeZone> {
    private final ILogger logger;

    public TimeZoneDeserializerAdapter(ILogger iLogger) {
        this.logger = iLogger;
    }

    public TimeZone deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement == null) {
            return null;
        }
        try {
            return TimeZone.getTimeZone(jsonElement.getAsString());
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error when deserializing TimeZone", (Throwable) e);
            return null;
        }
    }
}
