package io.intercom.android.sdk.helpcenter.sections;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"io/intercom/android/sdk/helpcenter/sections/Author.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/intercom/android/sdk/helpcenter/sections/Author;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: HelpCenterCollectionContent.kt */
public final class Author$$serializer implements GeneratedSerializer<Author> {
    public static final int $stable = 8;
    public static final Author$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Author$$serializer author$$serializer = new Author$$serializer();
        INSTANCE = author$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.intercom.android.sdk.helpcenter.sections.Author", author$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("display_name", true);
        pluginGeneratedSerialDescriptor.addElement("avatar", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Author$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, Avatar$$serializer.INSTANCE};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.intercom.android.sdk.helpcenter.sections.Author deserialize(kotlinx.serialization.encoding.Decoder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r16.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 0
            r4 = 2
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L_0x002e
            java.lang.String r2 = r0.decodeStringElement(r1, r5)
            java.lang.String r5 = r0.decodeStringElement(r1, r6)
            io.intercom.android.sdk.helpcenter.sections.Avatar$$serializer r6 = io.intercom.android.sdk.helpcenter.sections.Avatar$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r6 = (kotlinx.serialization.DeserializationStrategy) r6
            java.lang.Object r3 = r0.decodeSerializableElement(r1, r4, r6, r3)
            r4 = 7
            r12 = r2
            r13 = r5
            r11 = 7
            goto L_0x0066
        L_0x002e:
            r2 = r3
            r7 = r2
            r8 = 0
            r9 = 1
        L_0x0032:
            if (r9 == 0) goto L_0x0062
            int r10 = r0.decodeElementIndex(r1)
            r11 = -1
            if (r10 == r11) goto L_0x0060
            if (r10 == 0) goto L_0x0059
            if (r10 == r6) goto L_0x0052
            if (r10 != r4) goto L_0x004c
            io.intercom.android.sdk.helpcenter.sections.Avatar$$serializer r10 = io.intercom.android.sdk.helpcenter.sections.Avatar$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r10 = (kotlinx.serialization.DeserializationStrategy) r10
            java.lang.Object r7 = r0.decodeSerializableElement(r1, r4, r10, r7)
            r8 = r8 | 4
            goto L_0x0032
        L_0x004c:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r10)
            throw r0
        L_0x0052:
            java.lang.String r2 = r0.decodeStringElement(r1, r6)
            r8 = r8 | 2
            goto L_0x0032
        L_0x0059:
            java.lang.String r3 = r0.decodeStringElement(r1, r5)
            r8 = r8 | 1
            goto L_0x0032
        L_0x0060:
            r9 = 0
            goto L_0x0032
        L_0x0062:
            r13 = r2
            r12 = r3
            r3 = r7
            r11 = r8
        L_0x0066:
            r0.endStructure(r1)
            io.intercom.android.sdk.helpcenter.sections.Author r0 = new io.intercom.android.sdk.helpcenter.sections.Author
            r14 = r3
            io.intercom.android.sdk.helpcenter.sections.Avatar r14 = (io.intercom.android.sdk.helpcenter.sections.Avatar) r14
            r15 = 0
            r10 = r0
            r10.<init>((int) r11, (java.lang.String) r12, (java.lang.String) r13, (io.intercom.android.sdk.helpcenter.sections.Avatar) r14, (kotlinx.serialization.internal.SerializationConstructorMarker) r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.helpcenter.sections.Author$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):io.intercom.android.sdk.helpcenter.sections.Author");
    }

    public void serialize(Encoder encoder, Author author) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(author, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Author.write$Self(author, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
