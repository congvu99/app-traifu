package kotlinx.serialization.encoding;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a<\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u00030\b¢\u0006\u0002\b\nH\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\f"}, d2 = {"decodeMethodDeprecated", "", "decodeStructure", "T", "Lkotlinx/serialization/encoding/Decoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "block", "Lkotlin/Function1;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/serialization/encoding/Decoder;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: Decoding.kt */
public final class DecodingKt {
    private static final String decodeMethodDeprecated = "Please migrate to decodeElement method which accepts old value.Feel free to ignore it if your format does not support updates.";

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T decodeStructure(kotlinx.serialization.encoding.Decoder r1, kotlinx.serialization.descriptors.SerialDescriptor r2, kotlin.jvm.functions.Function1<? super kotlinx.serialization.encoding.CompositeDecoder, ? extends T> r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlinx.serialization.encoding.CompositeDecoder r1 = r1.beginStructure(r2)
            r0 = 1
            java.lang.Object r3 = r3.invoke(r1)     // Catch:{ all -> 0x0022 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            r1.endStructure(r2)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            return r3
        L_0x0022:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.encoding.DecodingKt.decodeStructure(kotlinx.serialization.encoding.Decoder, kotlinx.serialization.descriptors.SerialDescriptor, kotlin.jvm.functions.Function1):java.lang.Object");
    }
}
