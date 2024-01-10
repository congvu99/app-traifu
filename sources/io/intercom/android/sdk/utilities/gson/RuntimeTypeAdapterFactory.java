package io.intercom.android.sdk.utilities.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public final class RuntimeTypeAdapterFactory<T> implements TypeAdapterFactory {
    /* access modifiers changed from: private */
    public final Class<?> baseType;
    private final Map<String, Class<?>> labelToIgnoreSubtype = new LinkedHashMap();
    private final Map<String, Class<?>> labelToSubtype = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final boolean maintainType;
    private final Map<Class<?>, String> subtypeToIgnoreLabel = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final Map<Class<?>, String> subtypeToLabel = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final String typeFieldName;

    private RuntimeTypeAdapterFactory(Class<?> cls, String str, boolean z) {
        if (str == null || cls == null) {
            throw null;
        }
        this.baseType = cls;
        this.typeFieldName = str;
        this.maintainType = z;
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> cls, String str, boolean z) {
        return new RuntimeTypeAdapterFactory<>(cls, str, z);
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> cls, String str) {
        return new RuntimeTypeAdapterFactory<>(cls, str, false);
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> cls) {
        return new RuntimeTypeAdapterFactory<>(cls, "type", false);
    }

    public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> cls, String str) {
        if (cls == null || str == null) {
            throw null;
        } else if (this.subtypeToLabel.containsKey(cls) || this.labelToSubtype.containsKey(str)) {
            throw new IllegalArgumentException("types and labels must be unique");
        } else {
            this.labelToSubtype.put(str, cls);
            this.subtypeToLabel.put(cls, str);
            return this;
        }
    }

    public RuntimeTypeAdapterFactory<T> registerIgnoredSubtype(Class<? extends T> cls, String str) {
        if (cls == null || str == null) {
            throw null;
        } else if (this.subtypeToIgnoreLabel.containsKey(cls) || this.labelToIgnoreSubtype.containsKey(str)) {
            throw new IllegalArgumentException("types and labels must be unique");
        } else {
            this.labelToIgnoreSubtype.put(str, cls);
            this.subtypeToIgnoreLabel.put(cls, str);
            return this;
        }
    }

    public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> cls) {
        return registerSubtype(cls, cls.getSimpleName());
    }

    public <R> TypeAdapter<R> create(Gson gson, TypeToken<R> typeToken) {
        if (typeToken.getRawType() != this.baseType) {
            return null;
        }
        final TypeAdapter<JsonElement> adapter = gson.getAdapter(JsonElement.class);
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        final LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        for (Map.Entry next : this.labelToSubtype.entrySet()) {
            TypeAdapter delegateAdapter = gson.getDelegateAdapter(this, TypeToken.get((Class) next.getValue()));
            linkedHashMap.put((String) next.getKey(), delegateAdapter);
            linkedHashMap2.put((Class) next.getValue(), delegateAdapter);
        }
        for (Map.Entry next2 : this.labelToIgnoreSubtype.entrySet()) {
            TypeAdapter delegateAdapter2 = gson.getDelegateAdapter(this, TypeToken.get((Class) next2.getValue()));
            linkedHashMap3.put((String) next2.getKey(), delegateAdapter2);
            linkedHashMap4.put((Class) next2.getValue(), delegateAdapter2);
        }
        return new TypeAdapter<R>() {
            public R read(JsonReader jsonReader) throws IOException {
                JsonElement jsonElement;
                JsonElement jsonElement2 = (JsonElement) adapter.read(jsonReader);
                if (RuntimeTypeAdapterFactory.this.maintainType) {
                    jsonElement = jsonElement2.getAsJsonObject().get(RuntimeTypeAdapterFactory.this.typeFieldName);
                } else {
                    jsonElement = jsonElement2.getAsJsonObject().remove(RuntimeTypeAdapterFactory.this.typeFieldName);
                }
                if (jsonElement != null) {
                    TypeAdapter typeAdapter = (TypeAdapter) linkedHashMap.get(jsonElement.getAsString());
                    if (typeAdapter == null) {
                        typeAdapter = (TypeAdapter) linkedHashMap3.get("UnSupported");
                    }
                    return typeAdapter.fromJsonTree(jsonElement2);
                }
                throw new JsonParseException("cannot deserialize " + RuntimeTypeAdapterFactory.this.baseType + " because it does not define a field named " + RuntimeTypeAdapterFactory.this.typeFieldName);
            }

            public void write(JsonWriter jsonWriter, R r) throws IOException {
                Class<?> cls = r.getClass();
                String str = (String) RuntimeTypeAdapterFactory.this.subtypeToLabel.get(cls);
                TypeAdapter typeAdapter = (TypeAdapter) linkedHashMap2.get(cls);
                if (typeAdapter != null) {
                    JsonObject asJsonObject = typeAdapter.toJsonTree(r).getAsJsonObject();
                    if (RuntimeTypeAdapterFactory.this.maintainType) {
                        adapter.write(jsonWriter, asJsonObject);
                        return;
                    }
                    JsonObject jsonObject = new JsonObject();
                    if (!asJsonObject.has(RuntimeTypeAdapterFactory.this.typeFieldName)) {
                        jsonObject.add(RuntimeTypeAdapterFactory.this.typeFieldName, new JsonPrimitive(str));
                        for (Map.Entry next : asJsonObject.entrySet()) {
                            jsonObject.add((String) next.getKey(), (JsonElement) next.getValue());
                        }
                        adapter.write(jsonWriter, jsonObject);
                        return;
                    }
                    throw new JsonParseException("cannot serialize " + cls.getName() + " because it already defines a field named " + RuntimeTypeAdapterFactory.this.typeFieldName);
                }
                throw new JsonParseException("cannot serialize " + cls.getName() + "; did you forget to register a subtype?");
            }
        }.nullSafe();
    }
}
