package io.sentry.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.lang.reflect.Type;
import java.util.TimeZone;

public final class TimeZoneSerializerAdapter implements JsonSerializer<TimeZone> {
    private final ILogger logger;

    public TimeZoneSerializerAdapter(ILogger iLogger) {
        this.logger = iLogger;
    }

    public JsonElement serialize(TimeZone timeZone, Type type, JsonSerializationContext jsonSerializationContext) {
        if (timeZone == null) {
            return null;
        }
        try {
            return new JsonPrimitive(timeZone.getID());
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error when serializing TimeZone", (Throwable) e);
            return null;
        }
    }
}
