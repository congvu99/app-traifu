package io.sentry;

import com.facebook.internal.ServerProtocol;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryPackage;
import java.io.IOException;
import java.util.List;

public final class SentryEnvelopeHeaderAdapter extends TypeAdapter<SentryEnvelopeHeader> {
    public void write(JsonWriter jsonWriter, SentryEnvelopeHeader sentryEnvelopeHeader) throws IOException {
        if (sentryEnvelopeHeader == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        if (sentryEnvelopeHeader.getEventId() != null) {
            jsonWriter.name("event_id");
            jsonWriter.value(sentryEnvelopeHeader.getEventId().toString());
        }
        SdkVersion sdkVersion = sentryEnvelopeHeader.getSdkVersion();
        if (sdkVersion != null && hasValidSdkVersion(sdkVersion)) {
            jsonWriter.name(ServerProtocol.DIALOG_PARAM_SDK_VERSION).beginObject();
            jsonWriter.name("name").value(sdkVersion.getName());
            jsonWriter.name(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION).value(sdkVersion.getVersion());
            List<String> integrations = sdkVersion.getIntegrations();
            if (integrations != null) {
                jsonWriter.name("integrations").beginArray();
                for (String value : integrations) {
                    jsonWriter.value(value);
                }
                jsonWriter.endArray();
            }
            List<SentryPackage> packages = sdkVersion.getPackages();
            if (packages != null) {
                jsonWriter.name("packages").beginArray();
                for (SentryPackage next : packages) {
                    jsonWriter.beginObject();
                    jsonWriter.name("name").value(next.getName());
                    jsonWriter.name(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION).value(next.getVersion());
                    jsonWriter.endObject();
                }
                jsonWriter.endArray();
            }
            jsonWriter.endObject();
        }
        jsonWriter.endObject();
    }

    private boolean hasValidSdkVersion(SdkVersion sdkVersion) {
        return sdkVersion.getName() != null && !sdkVersion.getName().isEmpty() && sdkVersion.getVersion() != null && !sdkVersion.getVersion().isEmpty();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0125  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.sentry.SentryEnvelopeHeader read(com.google.gson.stream.JsonReader r14) throws java.io.IOException {
        /*
            r13 = this;
            com.google.gson.stream.JsonToken r0 = r14.peek()
            com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NULL
            r2 = 0
            if (r0 != r1) goto L_0x000d
            r14.nextNull()
            return r2
        L_0x000d:
            r14.beginObject()
            r0 = r2
            r1 = r0
        L_0x0012:
            boolean r3 = r14.hasNext()
            if (r3 == 0) goto L_0x0130
            java.lang.String r3 = r14.nextName()
            int r4 = r3.hashCode()
            r5 = 113722(0x1bc3a, float:1.59358E-40)
            r6 = 0
            r7 = -1
            r8 = 1
            if (r4 == r5) goto L_0x0038
            r5 = 278118624(0x1093c0e0, float:5.827845E-29)
            if (r4 == r5) goto L_0x002e
            goto L_0x0042
        L_0x002e:
            java.lang.String r4 = "event_id"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0042
            r3 = 0
            goto L_0x0043
        L_0x0038:
            java.lang.String r4 = "sdk"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0042
            r3 = 1
            goto L_0x0043
        L_0x0042:
            r3 = -1
        L_0x0043:
            if (r3 == 0) goto L_0x0125
            if (r3 == r8) goto L_0x004b
            r14.skipValue()
            goto L_0x0012
        L_0x004b:
            r14.beginObject()
            io.sentry.protocol.SdkVersion r1 = new io.sentry.protocol.SdkVersion
            r1.<init>()
        L_0x0053:
            boolean r3 = r14.hasNext()
            if (r3 == 0) goto L_0x0120
            java.lang.String r3 = r14.nextName()
            int r4 = r3.hashCode()
            java.lang.String r5 = "version"
            java.lang.String r9 = "name"
            r10 = 3
            r11 = 2
            switch(r4) {
                case 3373707: goto L_0x0087;
                case 351608024: goto L_0x007f;
                case 750867693: goto L_0x0075;
                case 1487029535: goto L_0x006b;
                default: goto L_0x006a;
            }
        L_0x006a:
            goto L_0x008f
        L_0x006b:
            java.lang.String r4 = "integrations"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x008f
            r3 = 2
            goto L_0x0090
        L_0x0075:
            java.lang.String r4 = "packages"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x008f
            r3 = 3
            goto L_0x0090
        L_0x007f:
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x008f
            r3 = 1
            goto L_0x0090
        L_0x0087:
            boolean r3 = r3.equals(r9)
            if (r3 == 0) goto L_0x008f
            r3 = 0
            goto L_0x0090
        L_0x008f:
            r3 = -1
        L_0x0090:
            if (r3 == 0) goto L_0x0117
            if (r3 == r8) goto L_0x010e
            if (r3 == r11) goto L_0x00f6
            if (r3 == r10) goto L_0x009c
            r14.skipValue()
            goto L_0x0053
        L_0x009c:
            r14.beginArray()
        L_0x009f:
            boolean r3 = r14.hasNext()
            if (r3 == 0) goto L_0x00f1
            r14.beginObject()
            r3 = r2
            r4 = r3
        L_0x00aa:
            boolean r10 = r14.hasNext()
            if (r10 == 0) goto L_0x00e6
            java.lang.String r10 = r14.nextName()
            int r11 = r10.hashCode()
            r12 = 3373707(0x337a8b, float:4.72757E-39)
            if (r11 == r12) goto L_0x00cb
            r12 = 351608024(0x14f51cd8, float:2.4750055E-26)
            if (r11 == r12) goto L_0x00c3
            goto L_0x00d3
        L_0x00c3:
            boolean r10 = r10.equals(r5)
            if (r10 == 0) goto L_0x00d3
            r10 = 1
            goto L_0x00d4
        L_0x00cb:
            boolean r10 = r10.equals(r9)
            if (r10 == 0) goto L_0x00d3
            r10 = 0
            goto L_0x00d4
        L_0x00d3:
            r10 = -1
        L_0x00d4:
            if (r10 == 0) goto L_0x00e1
            if (r10 == r8) goto L_0x00dc
            r14.skipValue()
            goto L_0x00aa
        L_0x00dc:
            java.lang.String r4 = r14.nextString()
            goto L_0x00aa
        L_0x00e1:
            java.lang.String r3 = r14.nextString()
            goto L_0x00aa
        L_0x00e6:
            if (r3 == 0) goto L_0x00ed
            if (r4 == 0) goto L_0x00ed
            r1.addPackage(r3, r4)
        L_0x00ed:
            r14.endObject()
            goto L_0x009f
        L_0x00f1:
            r14.endArray()
            goto L_0x0053
        L_0x00f6:
            r14.beginArray()
        L_0x00f9:
            boolean r3 = r14.hasNext()
            if (r3 == 0) goto L_0x0109
            java.lang.String r3 = r14.nextString()
            if (r3 == 0) goto L_0x00f9
            r1.addIntegration(r3)
            goto L_0x00f9
        L_0x0109:
            r14.endArray()
            goto L_0x0053
        L_0x010e:
            java.lang.String r3 = r14.nextString()
            r1.setVersion(r3)
            goto L_0x0053
        L_0x0117:
            java.lang.String r3 = r14.nextString()
            r1.setName(r3)
            goto L_0x0053
        L_0x0120:
            r14.endObject()
            goto L_0x0012
        L_0x0125:
            io.sentry.protocol.SentryId r0 = new io.sentry.protocol.SentryId
            java.lang.String r3 = r14.nextString()
            r0.<init>((java.lang.String) r3)
            goto L_0x0012
        L_0x0130:
            r14.endObject()
            io.sentry.SentryEnvelopeHeader r14 = new io.sentry.SentryEnvelopeHeader
            r14.<init>(r0, r1)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryEnvelopeHeaderAdapter.read(com.google.gson.stream.JsonReader):io.sentry.SentryEnvelopeHeader");
    }
}
