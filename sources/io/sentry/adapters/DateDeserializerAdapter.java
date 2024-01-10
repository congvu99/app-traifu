package io.sentry.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import io.sentry.DateUtils;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.lang.reflect.Type;
import java.util.Date;

public final class DateDeserializerAdapter implements JsonDeserializer<Date> {
    private final ILogger logger;

    public DateDeserializerAdapter(ILogger iLogger) {
        this.logger = iLogger;
    }

    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement == null) {
            return null;
        }
        try {
            return DateUtils.getDateTime(jsonElement.getAsString());
        } catch (Exception e) {
            this.logger.log(SentryLevel.DEBUG, "Error when deserializing UTC timestamp format, it might be millis timestamp format.", (Throwable) e);
            try {
                return DateUtils.getDateTimeWithMillisPrecision(jsonElement.getAsString());
            } catch (Exception e2) {
                this.logger.log(SentryLevel.ERROR, "Error when deserializing millis timestamp format.", (Throwable) e2);
                return null;
            }
        }
    }
}
