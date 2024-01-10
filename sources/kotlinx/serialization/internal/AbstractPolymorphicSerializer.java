package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007\b\u0000¢\u0006\u0002\u0010\u0004J\u0015\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J$\u0010\u0011\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0017J%\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0017¢\u0006\u0002\u0010\u0019J\u001b\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cR\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u001d"}, d2 = {"Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "()V", "baseClass", "Lkotlin/reflect/KClass;", "getBaseClass", "()Lkotlin/reflect/KClass;", "decodeSequentially", "compositeDecoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "(Lkotlinx/serialization/encoding/CompositeDecoder;)Ljava/lang/Object;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "findPolymorphicSerializerOrNull", "Lkotlinx/serialization/DeserializationStrategy;", "klassName", "", "Lkotlinx/serialization/SerializationStrategy;", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "serialize", "", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
@InternalSerializationApi
/* compiled from: AbstractPolymorphicSerializer.kt */
public abstract class AbstractPolymorphicSerializer<T> implements KSerializer<T> {
    public abstract KClass<T> getBaseClass();

    public final void serialize(Encoder encoder, T t) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(t, "value");
        SerializationStrategy findPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer(this, encoder, t);
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor);
        beginStructure.encodeStringElement(getDescriptor(), 0, findPolymorphicSerializer.getDescriptor().getSerialName());
        beginStructure.encodeSerializableElement(getDescriptor(), 1, findPolymorphicSerializer, t);
        beginStructure.endStructure(descriptor);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008d, code lost:
        if (r1 == null) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008f, code lost:
        r10.endStructure(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0092, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a6, code lost:
        throw new java.lang.IllegalArgumentException(kotlin.jvm.internal.Intrinsics.stringPlus("Polymorphic value has not been read for class ", r8.element).toString());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T deserialize(kotlinx.serialization.encoding.Decoder r10) {
        /*
            r9 = this;
            java.lang.String r0 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r9.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r10 = r10.beginStructure(r0)
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x00a7 }
            r8.<init>()     // Catch:{ all -> 0x00a7 }
            r1 = 0
            boolean r2 = r10.decodeSequentially()     // Catch:{ all -> 0x00a7 }
            if (r2 == 0) goto L_0x0021
            java.lang.Object r1 = r9.decodeSequentially(r10)     // Catch:{ all -> 0x00a7 }
            r10.endStructure(r0)
            return r1
        L_0x0021:
            kotlinx.serialization.descriptors.SerialDescriptor r2 = r9.getDescriptor()     // Catch:{ all -> 0x00a7 }
            int r3 = r10.decodeElementIndex(r2)     // Catch:{ all -> 0x00a7 }
            r2 = -1
            if (r3 == r2) goto L_0x008d
            if (r3 == 0) goto L_0x0082
            r1 = 1
            if (r3 == r1) goto L_0x0058
            kotlinx.serialization.SerializationException r10 = new kotlinx.serialization.SerializationException     // Catch:{ all -> 0x00a7 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a7 }
            r0.<init>()     // Catch:{ all -> 0x00a7 }
            java.lang.String r1 = "Invalid index in polymorphic deserialization of "
            r0.append(r1)     // Catch:{ all -> 0x00a7 }
            T r1 = r8.element     // Catch:{ all -> 0x00a7 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00a7 }
            if (r1 != 0) goto L_0x0045
            java.lang.String r1 = "unknown class"
        L_0x0045:
            r0.append(r1)     // Catch:{ all -> 0x00a7 }
            java.lang.String r1 = "\n Expected 0, 1 or DECODE_DONE(-1), but found "
            r0.append(r1)     // Catch:{ all -> 0x00a7 }
            r0.append(r3)     // Catch:{ all -> 0x00a7 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00a7 }
            r10.<init>((java.lang.String) r0)     // Catch:{ all -> 0x00a7 }
            throw r10     // Catch:{ all -> 0x00a7 }
        L_0x0058:
            T r1 = r8.element     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x0074
            r8.element = r1     // Catch:{ all -> 0x00a7 }
            T r1 = r8.element     // Catch:{ all -> 0x00a7 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00a7 }
            kotlinx.serialization.DeserializationStrategy r4 = kotlinx.serialization.PolymorphicSerializerKt.findPolymorphicSerializer(r9, (kotlinx.serialization.encoding.CompositeDecoder) r10, (java.lang.String) r1)     // Catch:{ all -> 0x00a7 }
            kotlinx.serialization.descriptors.SerialDescriptor r2 = r9.getDescriptor()     // Catch:{ all -> 0x00a7 }
            r5 = 0
            r6 = 8
            r7 = 0
            r1 = r10
            java.lang.Object r1 = kotlinx.serialization.encoding.CompositeDecoder.DefaultImpls.decodeSerializableElement$default(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00a7 }
            goto L_0x0021
        L_0x0074:
            java.lang.String r10 = "Cannot read polymorphic value before its type token"
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00a7 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00a7 }
            r0.<init>(r10)     // Catch:{ all -> 0x00a7 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x00a7 }
            throw r0     // Catch:{ all -> 0x00a7 }
        L_0x0082:
            kotlinx.serialization.descriptors.SerialDescriptor r2 = r9.getDescriptor()     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = r10.decodeStringElement(r2, r3)     // Catch:{ all -> 0x00a7 }
            r8.element = r2     // Catch:{ all -> 0x00a7 }
            goto L_0x0021
        L_0x008d:
            if (r1 == 0) goto L_0x0093
            r10.endStructure(r0)
            return r1
        L_0x0093:
            java.lang.String r10 = "Polymorphic value has not been read for class "
            T r0 = r8.element     // Catch:{ all -> 0x00a7 }
            java.lang.String r10 = kotlin.jvm.internal.Intrinsics.stringPlus(r10, r0)     // Catch:{ all -> 0x00a7 }
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00a7 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00a7 }
            r0.<init>(r10)     // Catch:{ all -> 0x00a7 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x00a7 }
            throw r0     // Catch:{ all -> 0x00a7 }
        L_0x00a7:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x00a9 }
        L_0x00a9:
            r10 = move-exception
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.AbstractPolymorphicSerializer.deserialize(kotlinx.serialization.encoding.Decoder):java.lang.Object");
    }

    private final T decodeSequentially(CompositeDecoder compositeDecoder) {
        return CompositeDecoder.DefaultImpls.decodeSerializableElement$default(compositeDecoder, getDescriptor(), 1, PolymorphicSerializerKt.findPolymorphicSerializer(this, compositeDecoder, compositeDecoder.decodeStringElement(getDescriptor(), 0)), (Object) null, 8, (Object) null);
    }

    @InternalSerializationApi
    public DeserializationStrategy<? extends T> findPolymorphicSerializerOrNull(CompositeDecoder compositeDecoder, String str) {
        Intrinsics.checkNotNullParameter(compositeDecoder, "decoder");
        return compositeDecoder.getSerializersModule().getPolymorphic(getBaseClass(), str);
    }

    @InternalSerializationApi
    public SerializationStrategy<T> findPolymorphicSerializerOrNull(Encoder encoder, T t) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(t, "value");
        return encoder.getSerializersModule().getPolymorphic(getBaseClass(), t);
    }
}
