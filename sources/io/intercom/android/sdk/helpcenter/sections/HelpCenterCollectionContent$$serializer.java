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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"io/intercom/android/sdk/helpcenter/sections/HelpCenterCollectionContent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/intercom/android/sdk/helpcenter/sections/HelpCenterCollectionContent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: HelpCenterCollectionContent.kt */
public final class HelpCenterCollectionContent$$serializer implements GeneratedSerializer<HelpCenterCollectionContent> {
    public static final int $stable = 8;
    public static final HelpCenterCollectionContent$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HelpCenterCollectionContent$$serializer helpCenterCollectionContent$$serializer = new HelpCenterCollectionContent$$serializer();
        INSTANCE = helpCenterCollectionContent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.intercom.android.sdk.helpcenter.sections.HelpCenterCollectionContent", helpCenterCollectionContent$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement("description", true);
        pluginGeneratedSerialDescriptor.addElement("articles", true);
        pluginGeneratedSerialDescriptor.addElement("sections", true);
        pluginGeneratedSerialDescriptor.addElement("article_count", false);
        pluginGeneratedSerialDescriptor.addElement("authors", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private HelpCenterCollectionContent$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, new ArrayListSerializer(HelpCenterArticle$$serializer.INSTANCE), new ArrayListSerializer(HelpCenterSection$$serializer.INSTANCE), IntSerializer.INSTANCE, new ArrayListSerializer(Author$$serializer.INSTANCE)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.intercom.android.sdk.helpcenter.sections.HelpCenterCollectionContent deserialize(kotlinx.serialization.encoding.Decoder r20) {
        /*
            r19 = this;
            r0 = r20
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r19.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 6
            r4 = 5
            r5 = 3
            r6 = 4
            r7 = 2
            r8 = 1
            r9 = 0
            r10 = 0
            if (r2 == 0) goto L_0x0065
            java.lang.String r2 = r0.decodeStringElement(r1, r9)
            java.lang.String r8 = r0.decodeStringElement(r1, r8)
            java.lang.String r7 = r0.decodeStringElement(r1, r7)
            kotlinx.serialization.internal.ArrayListSerializer r9 = new kotlinx.serialization.internal.ArrayListSerializer
            io.intercom.android.sdk.helpcenter.sections.HelpCenterArticle$$serializer r11 = io.intercom.android.sdk.helpcenter.sections.HelpCenterArticle$$serializer.INSTANCE
            kotlinx.serialization.KSerializer r11 = (kotlinx.serialization.KSerializer) r11
            r9.<init>(r11)
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r5 = r0.decodeSerializableElement(r1, r5, r9, r10)
            kotlinx.serialization.internal.ArrayListSerializer r9 = new kotlinx.serialization.internal.ArrayListSerializer
            io.intercom.android.sdk.helpcenter.sections.HelpCenterSection$$serializer r11 = io.intercom.android.sdk.helpcenter.sections.HelpCenterSection$$serializer.INSTANCE
            kotlinx.serialization.KSerializer r11 = (kotlinx.serialization.KSerializer) r11
            r9.<init>(r11)
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r6 = r0.decodeSerializableElement(r1, r6, r9, r10)
            int r4 = r0.decodeIntElement(r1, r4)
            kotlinx.serialization.internal.ArrayListSerializer r9 = new kotlinx.serialization.internal.ArrayListSerializer
            io.intercom.android.sdk.helpcenter.sections.Author$$serializer r11 = io.intercom.android.sdk.helpcenter.sections.Author$$serializer.INSTANCE
            kotlinx.serialization.KSerializer r11 = (kotlinx.serialization.KSerializer) r11
            r9.<init>(r11)
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r3 = r0.decodeSerializableElement(r1, r3, r9, r10)
            r9 = 127(0x7f, float:1.78E-43)
            r11 = r2
            r16 = r4
            r13 = r7
            r12 = r8
            r10 = 127(0x7f, float:1.78E-43)
            goto L_0x00e1
        L_0x0065:
            r9 = r10
            r11 = r9
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r2 = 0
            r10 = 0
            r16 = 1
        L_0x006f:
            if (r16 == 0) goto L_0x00dc
            int r8 = r0.decodeElementIndex(r1)
            switch(r8) {
                case -1: goto L_0x00d8;
                case 0: goto L_0x00cd;
                case 1: goto L_0x00c5;
                case 2: goto L_0x00be;
                case 3: goto L_0x00ab;
                case 4: goto L_0x0099;
                case 5: goto L_0x0092;
                case 6: goto L_0x007e;
                default: goto L_0x0078;
            }
        L_0x0078:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r8)
            throw r0
        L_0x007e:
            kotlinx.serialization.internal.ArrayListSerializer r8 = new kotlinx.serialization.internal.ArrayListSerializer
            io.intercom.android.sdk.helpcenter.sections.Author$$serializer r18 = io.intercom.android.sdk.helpcenter.sections.Author$$serializer.INSTANCE
            r7 = r18
            kotlinx.serialization.KSerializer r7 = (kotlinx.serialization.KSerializer) r7
            r8.<init>(r7)
            kotlinx.serialization.DeserializationStrategy r8 = (kotlinx.serialization.DeserializationStrategy) r8
            java.lang.Object r9 = r0.decodeSerializableElement(r1, r3, r8, r9)
            r10 = r10 | 64
            goto L_0x00bc
        L_0x0092:
            int r2 = r0.decodeIntElement(r1, r4)
            r10 = r10 | 32
            goto L_0x00bc
        L_0x0099:
            kotlinx.serialization.internal.ArrayListSerializer r7 = new kotlinx.serialization.internal.ArrayListSerializer
            io.intercom.android.sdk.helpcenter.sections.HelpCenterSection$$serializer r8 = io.intercom.android.sdk.helpcenter.sections.HelpCenterSection$$serializer.INSTANCE
            kotlinx.serialization.KSerializer r8 = (kotlinx.serialization.KSerializer) r8
            r7.<init>(r8)
            kotlinx.serialization.DeserializationStrategy r7 = (kotlinx.serialization.DeserializationStrategy) r7
            java.lang.Object r15 = r0.decodeSerializableElement(r1, r6, r7, r15)
            r10 = r10 | 16
            goto L_0x00bc
        L_0x00ab:
            kotlinx.serialization.internal.ArrayListSerializer r7 = new kotlinx.serialization.internal.ArrayListSerializer
            io.intercom.android.sdk.helpcenter.sections.HelpCenterArticle$$serializer r8 = io.intercom.android.sdk.helpcenter.sections.HelpCenterArticle$$serializer.INSTANCE
            kotlinx.serialization.KSerializer r8 = (kotlinx.serialization.KSerializer) r8
            r7.<init>(r8)
            kotlinx.serialization.DeserializationStrategy r7 = (kotlinx.serialization.DeserializationStrategy) r7
            java.lang.Object r14 = r0.decodeSerializableElement(r1, r5, r7, r14)
            r10 = r10 | 8
        L_0x00bc:
            r7 = 2
            goto L_0x00da
        L_0x00be:
            java.lang.String r13 = r0.decodeStringElement(r1, r7)
            r10 = r10 | 4
            goto L_0x00da
        L_0x00c5:
            r8 = 1
            java.lang.String r12 = r0.decodeStringElement(r1, r8)
            r10 = r10 | 2
            goto L_0x006f
        L_0x00cd:
            r8 = 1
            r11 = 0
            java.lang.String r17 = r0.decodeStringElement(r1, r11)
            r10 = r10 | 1
            r11 = r17
            goto L_0x006f
        L_0x00d8:
            r16 = 0
        L_0x00da:
            r8 = 1
            goto L_0x006f
        L_0x00dc:
            r16 = r2
            r3 = r9
            r5 = r14
            r6 = r15
        L_0x00e1:
            r0.endStructure(r1)
            io.intercom.android.sdk.helpcenter.sections.HelpCenterCollectionContent r0 = new io.intercom.android.sdk.helpcenter.sections.HelpCenterCollectionContent
            r14 = r5
            java.util.List r14 = (java.util.List) r14
            r15 = r6
            java.util.List r15 = (java.util.List) r15
            r17 = r3
            java.util.List r17 = (java.util.List) r17
            r18 = 0
            r9 = r0
            r9.<init>((int) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (java.util.List) r14, (java.util.List) r15, (int) r16, (java.util.List) r17, (kotlinx.serialization.internal.SerializationConstructorMarker) r18)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.helpcenter.sections.HelpCenterCollectionContent$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):io.intercom.android.sdk.helpcenter.sections.HelpCenterCollectionContent");
    }

    public void serialize(Encoder encoder, HelpCenterCollectionContent helpCenterCollectionContent) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(helpCenterCollectionContent, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        HelpCenterCollectionContent.write$Self(helpCenterCollectionContent, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
