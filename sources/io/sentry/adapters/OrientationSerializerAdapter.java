package io.sentry.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.protocol.Device;
import java.lang.reflect.Type;
import java.util.Locale;

public final class OrientationSerializerAdapter implements JsonSerializer<Device.DeviceOrientation> {
    private final ILogger logger;

    public OrientationSerializerAdapter(ILogger iLogger) {
        this.logger = iLogger;
    }

    public JsonElement serialize(Device.DeviceOrientation deviceOrientation, Type type, JsonSerializationContext jsonSerializationContext) {
        if (deviceOrientation == null) {
            return null;
        }
        try {
            return new JsonPrimitive(deviceOrientation.name().toLowerCase(Locale.ROOT));
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error when serializing DeviceOrientation", (Throwable) e);
            return null;
        }
    }
}
