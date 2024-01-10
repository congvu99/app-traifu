package io.sentry.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.protocol.Device;
import java.lang.reflect.Type;
import java.util.Locale;

public final class OrientationDeserializerAdapter implements JsonDeserializer<Device.DeviceOrientation> {
    private final ILogger logger;

    public OrientationDeserializerAdapter(ILogger iLogger) {
        this.logger = iLogger;
    }

    public Device.DeviceOrientation deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement == null) {
            return null;
        }
        try {
            return Device.DeviceOrientation.valueOf(jsonElement.getAsString().toUpperCase(Locale.ROOT));
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error when deserializing DeviceOrientation", (Throwable) e);
            return null;
        }
    }
}
