package kotlinx.serialization;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.Grouping;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BG\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00070\t\u0012\u0014\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\t¢\u0006\u0002\u0010\fJ$\u0010\u0016\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0016J%\u0010\u0016\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkotlinx/serialization/SealedClassSerializer;", "T", "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "serialName", "", "baseClass", "Lkotlin/reflect/KClass;", "subclasses", "", "subclassSerializers", "Lkotlinx/serialization/KSerializer;", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)V", "getBaseClass", "()Lkotlin/reflect/KClass;", "class2Serializer", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName2Serializer", "findPolymorphicSerializerOrNull", "Lkotlinx/serialization/DeserializationStrategy;", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "klassName", "Lkotlinx/serialization/SerializationStrategy;", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
@InternalSerializationApi
/* compiled from: SealedSerializer.kt */
public final class SealedClassSerializer<T> extends AbstractPolymorphicSerializer<T> {
    private final KClass<T> baseClass;
    private final Map<KClass<? extends T>, KSerializer<? extends T>> class2Serializer;
    private final SerialDescriptor descriptor;
    private final Map<String, KSerializer<? extends T>> serialName2Serializer;

    public KClass<T> getBaseClass() {
        return this.baseClass;
    }

    public SealedClassSerializer(String str, KClass<T> kClass, KClass<? extends T>[] kClassArr, KSerializer<? extends T>[] kSerializerArr) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(kClassArr, "subclasses");
        Intrinsics.checkNotNullParameter(kSerializerArr, "subclassSerializers");
        this.baseClass = kClass;
        this.descriptor = SerialDescriptorsKt.buildSerialDescriptor(str, PolymorphicKind.SEALED.INSTANCE, new SerialDescriptor[0], new SealedClassSerializer$descriptor$1(this, kSerializerArr));
        if (kClassArr.length == kSerializerArr.length) {
            Map<KClass<? extends T>, KSerializer<? extends T>> map = MapsKt.toMap(ArraysKt.zip((T[]) kClassArr, (R[]) kSerializerArr));
            this.class2Serializer = map;
            Grouping sealedClassSerializer$special$$inlined$groupingBy$1 = new SealedClassSerializer$special$$inlined$groupingBy$1(map.entrySet());
            Map linkedHashMap = new LinkedHashMap();
            Iterator sourceIterator = sealedClassSerializer$special$$inlined$groupingBy$1.sourceIterator();
            while (sourceIterator.hasNext()) {
                Object next = sourceIterator.next();
                Object keyOf = sealedClassSerializer$special$$inlined$groupingBy$1.keyOf(next);
                Object obj = linkedHashMap.get(keyOf);
                if (obj == null) {
                    boolean containsKey = linkedHashMap.containsKey(keyOf);
                }
                Map.Entry entry = (Map.Entry) next;
                Map.Entry entry2 = (Map.Entry) obj;
                String str2 = (String) keyOf;
                if (entry2 == null) {
                    linkedHashMap.put(keyOf, entry);
                } else {
                    throw new IllegalStateException(("Multiple sealed subclasses of '" + getBaseClass() + "' have the same serial name '" + str2 + "': '" + entry2.getKey() + "', '" + entry.getKey() + '\'').toString());
                }
            }
            Map<String, KSerializer<? extends T>> linkedHashMap2 = new LinkedHashMap<>(MapsKt.mapCapacity(linkedHashMap.size()));
            for (Map.Entry entry3 : linkedHashMap.entrySet()) {
                linkedHashMap2.put(entry3.getKey(), (KSerializer) ((Map.Entry) entry3.getValue()).getValue());
            }
            this.serialName2Serializer = linkedHashMap2;
            return;
        }
        throw new IllegalArgumentException("All subclasses of sealed class " + getBaseClass().getSimpleName() + " should be marked @Serializable");
    }

    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public DeserializationStrategy<? extends T> findPolymorphicSerializerOrNull(CompositeDecoder compositeDecoder, String str) {
        Intrinsics.checkNotNullParameter(compositeDecoder, "decoder");
        KSerializer kSerializer = this.serialName2Serializer.get(str);
        return kSerializer == null ? super.findPolymorphicSerializerOrNull(compositeDecoder, str) : kSerializer;
    }

    public SerializationStrategy<T> findPolymorphicSerializerOrNull(Encoder encoder, T t) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(t, "value");
        KSerializer kSerializer = this.class2Serializer.get(Reflection.getOrCreateKotlinClass(t.getClass()));
        SerializationStrategy<T> findPolymorphicSerializerOrNull = kSerializer == null ? super.findPolymorphicSerializerOrNull(encoder, t) : kSerializer;
        if (findPolymorphicSerializerOrNull == null) {
            return null;
        }
        return findPolymorphicSerializerOrNull;
    }
}
