package io.sentry;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Excluder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

final class UnknownPropertiesTypeAdapterFactory implements TypeAdapterFactory {
    private static final TypeAdapterFactory instance = new UnknownPropertiesTypeAdapterFactory();

    private UnknownPropertiesTypeAdapterFactory() {
    }

    static TypeAdapterFactory get() {
        return instance;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        if (!IUnknownPropertiesConsumer.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        return UnknownPropertiesTypeAdapter.create(typeToken.getRawType(), gson.getDelegateAdapter(this, typeToken), gson.excluder(), gson.fieldNamingStrategy());
    }

    private static final class UnknownPropertiesTypeAdapter<T extends IUnknownPropertiesConsumer> extends TypeAdapter<T> {
        private final Collection<String> propertyNames;
        private final TypeAdapter<T> typeAdapter;

        private UnknownPropertiesTypeAdapter(TypeAdapter<T> typeAdapter2, Collection<String> collection) {
            this.typeAdapter = typeAdapter2;
            this.propertyNames = collection;
        }

        /* access modifiers changed from: private */
        public static <T extends IUnknownPropertiesConsumer> TypeAdapter<T> create(Class<? super T> cls, TypeAdapter<T> typeAdapter2, Excluder excluder, FieldNamingStrategy fieldNamingStrategy) {
            return new UnknownPropertiesTypeAdapter(typeAdapter2, getPropertyNames(cls, excluder, fieldNamingStrategy));
        }

        private static Collection<String> getPropertyNames(Class<?> cls, Excluder excluder, FieldNamingStrategy fieldNamingStrategy) {
            ArrayList arrayList = new ArrayList();
            Class<? super Object> cls2 = cls;
            while (cls2.getSuperclass() != null && cls2 != Object.class) {
                for (Field field : cls2.getDeclaredFields()) {
                    if (!excluder.excludeField(field, false)) {
                        arrayList.add(fieldNamingStrategy.translateName(field));
                    }
                }
                cls2 = cls2.getSuperclass();
            }
            return arrayList;
        }

        public void write(JsonWriter jsonWriter, T t) throws IOException {
            this.typeAdapter.write(jsonWriter, t);
        }

        public T read(JsonReader jsonReader) {
            JsonElement parse = new JsonParser().parse(jsonReader);
            if (parse == null || parse.isJsonNull()) {
                return null;
            }
            JsonObject asJsonObject = parse.getAsJsonObject();
            HashMap hashMap = new HashMap();
            for (Map.Entry next : asJsonObject.entrySet()) {
                String str = (String) next.getKey();
                if (!this.propertyNames.contains(str)) {
                    hashMap.put(str, next.getValue());
                }
            }
            T t = (IUnknownPropertiesConsumer) this.typeAdapter.fromJsonTree(asJsonObject);
            if (!hashMap.isEmpty()) {
                t.acceptUnknownProperties(hashMap);
            }
            return t;
        }
    }
}
