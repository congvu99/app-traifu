package io.sentry.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.protocol.Contexts;
import java.lang.reflect.Type;
import java.util.Map;

public final class ContextsSerializerAdapter implements JsonSerializer<Contexts> {
    private final ILogger logger;

    public ContextsSerializerAdapter(ILogger iLogger) {
        this.logger = iLogger;
    }

    public JsonElement serialize(Contexts contexts, Type type, JsonSerializationContext jsonSerializationContext) {
        if (contexts == null) {
            return null;
        }
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry entry : contexts.entrySet()) {
            try {
                JsonElement serialize = jsonSerializationContext.serialize(entry.getValue(), Object.class);
                if (serialize != null) {
                    jsonObject.add((String) entry.getKey(), serialize);
                }
            } catch (JsonParseException unused) {
                this.logger.log(SentryLevel.ERROR, "%s context key isn't serializable.", new Object[0]);
            }
        }
        return jsonObject;
    }
}
