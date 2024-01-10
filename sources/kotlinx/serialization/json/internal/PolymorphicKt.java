package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.JsonInternalDependenciesKt;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u001a*\u0010\n\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002\u001a%\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u0011*\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0014H\u0000¢\u0006\u0002\u0010\u0015\u001a?\u0010\u0016\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0011*\u00020\u00172\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00110\f2\u0006\u0010\u0018\u001a\u0002H\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u001aH\bø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001a(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\f*\u00020\u00172\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001d"}, d2 = {"checkKind", "", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "throwSerializerNotFound", "", "type", "", "jsonTree", "Lkotlinx/serialization/json/JsonObject;", "validateIfSealed", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "actualSerializer", "", "classDiscriminator", "decodeSerializableValuePolymorphic", "T", "Lkotlinx/serialization/json/JsonDecoder;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/json/JsonDecoder;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "encodePolymorphically", "Lkotlinx/serialization/json/JsonEncoder;", "value", "ifPolymorphic", "Lkotlin/Function0;", "(Lkotlinx/serialization/json/JsonEncoder;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "findActualSerializer", "kotlinx-serialization-json"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: Polymorphic.kt */
public final class PolymorphicKt {
    public static final <T> void encodePolymorphically(JsonEncoder jsonEncoder, SerializationStrategy<? super T> serializationStrategy, T t, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(jsonEncoder, "<this>");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        Intrinsics.checkNotNullParameter(function0, "ifPolymorphic");
        if (!(serializationStrategy instanceof AbstractPolymorphicSerializer) || jsonEncoder.getJson().getConfiguration().getUseArrayPolymorphism()) {
            serializationStrategy.serialize(jsonEncoder, t);
        } else if (t != null) {
            SerializationStrategy access$findActualSerializer = findActualSerializer(jsonEncoder, serializationStrategy, t);
            function0.invoke();
            access$findActualSerializer.serialize(jsonEncoder, t);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
        }
    }

    /* access modifiers changed from: private */
    public static final SerializationStrategy<Object> findActualSerializer(JsonEncoder jsonEncoder, SerializationStrategy<Object> serializationStrategy, Object obj) {
        AbstractPolymorphicSerializer abstractPolymorphicSerializer = (AbstractPolymorphicSerializer) serializationStrategy;
        SerializationStrategy<Object> findPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer(abstractPolymorphicSerializer, (Encoder) jsonEncoder, obj);
        validateIfSealed(abstractPolymorphicSerializer, findPolymorphicSerializer, jsonEncoder.getJson().getConfiguration().getClassDiscriminator());
        checkKind(findPolymorphicSerializer.getDescriptor().getKind());
        return findPolymorphicSerializer;
    }

    private static final void validateIfSealed(SerializationStrategy<?> serializationStrategy, SerializationStrategy<Object> serializationStrategy2, String str) {
        if ((serializationStrategy instanceof SealedClassSerializer) && JsonInternalDependenciesKt.jsonCachedSerialNames(serializationStrategy2.getDescriptor()).contains(str)) {
            String serialName = serializationStrategy.getDescriptor().getSerialName();
            String serialName2 = serializationStrategy2.getDescriptor().getSerialName();
            throw new IllegalStateException(("Sealed class '" + serialName2 + "' cannot be serialized as base class '" + serialName + "' because it has property name that conflicts with JSON class discriminator '" + str + "'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism").toString());
        }
    }

    public static final void checkKind(SerialKind serialKind) {
        Intrinsics.checkNotNullParameter(serialKind, "kind");
        if (serialKind instanceof SerialKind.ENUM) {
            throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
        } else if (serialKind instanceof PrimitiveKind) {
            throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
        } else if (serialKind instanceof PolymorphicKind) {
            throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself".toString());
        }
    }

    public static final <T> T decodeSerializableValuePolymorphic(JsonDecoder jsonDecoder, DeserializationStrategy<T> deserializationStrategy) {
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter(jsonDecoder, "<this>");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        if (!(deserializationStrategy instanceof AbstractPolymorphicSerializer) || jsonDecoder.getJson().getConfiguration().getUseArrayPolymorphism()) {
            return deserializationStrategy.deserialize(jsonDecoder);
        }
        JsonElement decodeJsonElement = jsonDecoder.decodeJsonElement();
        SerialDescriptor descriptor = deserializationStrategy.getDescriptor();
        if (decodeJsonElement instanceof JsonObject) {
            JsonObject jsonObject = (JsonObject) decodeJsonElement;
            String classDiscriminator = jsonDecoder.getJson().getConfiguration().getClassDiscriminator();
            JsonElement jsonElement = (JsonElement) jsonObject.get((Object) classDiscriminator);
            String str = null;
            if (!(jsonElement == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) == null)) {
                str = jsonPrimitive.getContent();
            }
            DeserializationStrategy findPolymorphicSerializerOrNull = ((AbstractPolymorphicSerializer) deserializationStrategy).findPolymorphicSerializerOrNull((CompositeDecoder) jsonDecoder, str);
            if (findPolymorphicSerializerOrNull != null) {
                return TreeJsonDecoderKt.readPolymorphicJson(jsonDecoder.getJson(), classDiscriminator, jsonObject, findPolymorphicSerializerOrNull);
            }
            throwSerializerNotFound(str, jsonObject);
            throw new KotlinNothingValueException();
        }
        throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(decodeJsonElement.getClass()));
    }

    private static final Void throwSerializerNotFound(String str, JsonObject jsonObject) {
        String str2;
        if (str == null) {
            str2 = "missing class discriminator ('null')";
        } else {
            str2 = "class discriminator '" + str + '\'';
        }
        throw JsonExceptionsKt.JsonDecodingException(-1, Intrinsics.stringPlus("Polymorphic serializer was not found for ", str2), jsonObject.toString());
    }
}
