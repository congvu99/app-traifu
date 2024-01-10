package io.sentry.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.sentry.DateUtils;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.lang.reflect.Type;
import java.util.Date;

public final class DateSerializerAdapter implements JsonSerializer<Date> {
    private final ILogger logger;

    public DateSerializerAdapter(ILogger iLogger) {
        this.logger = iLogger;
    }

    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        if (date == null) {
            return null;
        }
        try {
            return new JsonPrimitive(DateUtils.getTimestamp(date));
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error when serializing Date", (Throwable) e);
            return null;
        }
    }
}
