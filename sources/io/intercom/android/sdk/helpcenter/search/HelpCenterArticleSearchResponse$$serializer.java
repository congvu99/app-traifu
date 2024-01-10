package io.intercom.android.sdk.helpcenter.search;

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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"io/intercom/android/sdk/helpcenter/search/HelpCenterArticleSearchResponse.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/intercom/android/sdk/helpcenter/search/HelpCenterArticleSearchResponse;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: HelpCenterArticleSearchResponse.kt */
public final class HelpCenterArticleSearchResponse$$serializer implements GeneratedSerializer<HelpCenterArticleSearchResponse> {
    public static final int $stable = 8;
    public static final HelpCenterArticleSearchResponse$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HelpCenterArticleSearchResponse$$serializer helpCenterArticleSearchResponse$$serializer = new HelpCenterArticleSearchResponse$$serializer();
        INSTANCE = helpCenterArticleSearchResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.intercom.android.sdk.helpcenter.search.HelpCenterArticleSearchResponse", helpCenterArticleSearchResponse$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("summary", true);
        pluginGeneratedSerialDescriptor.addElement("title", true);
        pluginGeneratedSerialDescriptor.addElement("url", true);
        pluginGeneratedSerialDescriptor.addElement("highlight", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private HelpCenterArticleSearchResponse$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, HelpCenterArticleSearchResponse$Highlight$$serializer.INSTANCE};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.intercom.android.sdk.helpcenter.search.HelpCenterArticleSearchResponse deserialize(kotlinx.serialization.encoding.Decoder r23) {
        /*
            r22 = this;
            r0 = r23
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r22.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 3
            r4 = 4
            r5 = 2
            r6 = 0
            r7 = 0
            r8 = 1
            if (r2 == 0) goto L_0x0040
            java.lang.String r2 = r0.decodeStringElement(r1, r6)
            java.lang.String r6 = r0.decodeStringElement(r1, r8)
            java.lang.String r5 = r0.decodeStringElement(r1, r5)
            java.lang.String r3 = r0.decodeStringElement(r1, r3)
            io.intercom.android.sdk.helpcenter.search.HelpCenterArticleSearchResponse$Highlight$$serializer r8 = io.intercom.android.sdk.helpcenter.search.HelpCenterArticleSearchResponse$Highlight$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r8 = (kotlinx.serialization.DeserializationStrategy) r8
            java.lang.Object r4 = r0.decodeSerializableElement(r1, r4, r8, r7)
            r7 = 31
            r16 = r2
            r19 = r3
            r18 = r5
            r17 = r6
            r15 = 31
            goto L_0x0093
        L_0x0040:
            r2 = r7
            r9 = r2
            r10 = r9
            r11 = r10
            r12 = r11
            r7 = 0
            r13 = 1
        L_0x0047:
            if (r13 == 0) goto L_0x0089
            int r14 = r0.decodeElementIndex(r1)
            r15 = -1
            if (r14 == r15) goto L_0x0087
            if (r14 == 0) goto L_0x0080
            if (r14 == r8) goto L_0x0079
            if (r14 == r5) goto L_0x0072
            if (r14 == r3) goto L_0x006b
            if (r14 != r4) goto L_0x0065
            io.intercom.android.sdk.helpcenter.search.HelpCenterArticleSearchResponse$Highlight$$serializer r14 = io.intercom.android.sdk.helpcenter.search.HelpCenterArticleSearchResponse$Highlight$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r12 = r0.decodeSerializableElement(r1, r4, r14, r12)
            r7 = r7 | 16
            goto L_0x0047
        L_0x0065:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r14)
            throw r0
        L_0x006b:
            java.lang.String r11 = r0.decodeStringElement(r1, r3)
            r7 = r7 | 8
            goto L_0x0047
        L_0x0072:
            java.lang.String r10 = r0.decodeStringElement(r1, r5)
            r7 = r7 | 4
            goto L_0x0047
        L_0x0079:
            java.lang.String r9 = r0.decodeStringElement(r1, r8)
            r7 = r7 | 2
            goto L_0x0047
        L_0x0080:
            java.lang.String r2 = r0.decodeStringElement(r1, r6)
            r7 = r7 | 1
            goto L_0x0047
        L_0x0087:
            r13 = 0
            goto L_0x0047
        L_0x0089:
            r16 = r2
            r15 = r7
            r17 = r9
            r18 = r10
            r19 = r11
            r4 = r12
        L_0x0093:
            r0.endStructure(r1)
            io.intercom.android.sdk.helpcenter.search.HelpCenterArticleSearchResponse r0 = new io.intercom.android.sdk.helpcenter.search.HelpCenterArticleSearchResponse
            r20 = r4
            io.intercom.android.sdk.helpcenter.search.HelpCenterArticleSearchResponse$Highlight r20 = (io.intercom.android.sdk.helpcenter.search.HelpCenterArticleSearchResponse.Highlight) r20
            r21 = 0
            r14 = r0
            r14.<init>((int) r15, (java.lang.String) r16, (java.lang.String) r17, (java.lang.String) r18, (java.lang.String) r19, (io.intercom.android.sdk.helpcenter.search.HelpCenterArticleSearchResponse.Highlight) r20, (kotlinx.serialization.internal.SerializationConstructorMarker) r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.helpcenter.search.HelpCenterArticleSearchResponse$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):io.intercom.android.sdk.helpcenter.search.HelpCenterArticleSearchResponse");
    }

    public void serialize(Encoder encoder, HelpCenterArticleSearchResponse helpCenterArticleSearchResponse) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(helpCenterArticleSearchResponse, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        HelpCenterArticleSearchResponse.write$Self(helpCenterArticleSearchResponse, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
