package io.sentry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.nio.charset.Charset;

public final class EnvelopeReader implements IEnvelopeReader {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final Gson gson = new GsonBuilder().registerTypeAdapter(SentryEnvelopeHeader.class, new SentryEnvelopeHeaderAdapter()).registerTypeAdapter(SentryEnvelopeItemHeader.class, new SentryEnvelopeItemHeaderAdapter()).create();

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r11 = r1.toByteArray();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (r11.length == 0) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        if (r4 == -1) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        r0 = deserializeEnvelopeHeader(r11, 0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        if (r0 == null) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        r4 = r4 + 1;
        r2 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0041, code lost:
        if (r5 >= r11.length) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0045, code lost:
        if (r11[r5] != 10) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004b, code lost:
        r5 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004c, code lost:
        if (r5 == -1) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
        r4 = deserializeEnvelopeItemHeader(r11, r4, r5 - r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0058, code lost:
        if (r4.getLength() <= 0) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005a, code lost:
        r6 = (r4.getLength() + r5) + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0062, code lost:
        if (r6 > r11.length) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0064, code lost:
        r2.add(new io.sentry.SentryEnvelopeItem(r4, java.util.Arrays.copyOfRange(r11, r5 + 1, r6)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0073, code lost:
        if (r6 != r11.length) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0076, code lost:
        r4 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0079, code lost:
        if (r4 != r11.length) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007d, code lost:
        if (r11[r6] != 10) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007f, code lost:
        r11 = new io.sentry.SentryEnvelope(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0084, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0087, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x008f, code lost:
        throw new java.lang.IllegalArgumentException("Envelope has invalid data following an item.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c0, code lost:
        throw new java.lang.IllegalArgumentException("Invalid length for item at index '" + r2.size() + "'. Item is '" + r6 + "' bytes. There are '" + r11.length + "' in the buffer.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ec, code lost:
        throw new java.lang.IllegalArgumentException("Item header at index '" + r2.size() + "' has an invalid value: '" + r4.getLength() + "'.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010c, code lost:
        throw new java.lang.IllegalArgumentException("Invalid envelope. Item at index '" + r2.size() + "'. has no header delimiter.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0114, code lost:
        throw new java.lang.IllegalArgumentException("Envelope header is null.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x011c, code lost:
        throw new java.lang.IllegalArgumentException("Envelope contains no header.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0124, code lost:
        throw new java.lang.IllegalArgumentException("Empty stream.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0127, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x012c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x012d, code lost:
        r11.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0130, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.sentry.SentryEnvelope read(java.io.InputStream r11) throws java.io.IOException {
        /*
            r10 = this;
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r2 = 0
            r3 = -1
            r4 = -1
            r5 = 0
        L_0x000d:
            int r6 = r11.read(r0)     // Catch:{ all -> 0x0125 }
            r7 = 10
            if (r6 <= 0) goto L_0x0029
            r8 = 0
        L_0x0016:
            if (r4 != r3) goto L_0x0024
            if (r8 >= r6) goto L_0x0024
            byte r9 = r0[r8]     // Catch:{ all -> 0x0125 }
            if (r9 != r7) goto L_0x0021
            int r4 = r5 + r8
            goto L_0x0024
        L_0x0021:
            int r8 = r8 + 1
            goto L_0x0016
        L_0x0024:
            r1.write(r0, r2, r6)     // Catch:{ all -> 0x0125 }
            int r5 = r5 + r6
            goto L_0x000d
        L_0x0029:
            byte[] r11 = r1.toByteArray()     // Catch:{ all -> 0x0125 }
            int r0 = r11.length     // Catch:{ all -> 0x0125 }
            if (r0 == 0) goto L_0x011d
            if (r4 == r3) goto L_0x0115
            io.sentry.SentryEnvelopeHeader r0 = r10.deserializeEnvelopeHeader(r11, r2, r4)     // Catch:{ all -> 0x0125 }
            if (r0 == 0) goto L_0x010d
            int r4 = r4 + 1
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0125 }
            r2.<init>()     // Catch:{ all -> 0x0125 }
        L_0x003f:
            r5 = r4
        L_0x0040:
            int r6 = r11.length     // Catch:{ all -> 0x0125 }
            if (r5 >= r6) goto L_0x004b
            byte r6 = r11[r5]     // Catch:{ all -> 0x0125 }
            if (r6 != r7) goto L_0x0048
            goto L_0x004c
        L_0x0048:
            int r5 = r5 + 1
            goto L_0x0040
        L_0x004b:
            r5 = -1
        L_0x004c:
            if (r5 == r3) goto L_0x00ed
            int r6 = r5 - r4
            io.sentry.SentryEnvelopeItemHeader r4 = r10.deserializeEnvelopeItemHeader(r11, r4, r6)     // Catch:{ all -> 0x0125 }
            int r6 = r4.getLength()     // Catch:{ all -> 0x0125 }
            if (r6 <= 0) goto L_0x00c1
            int r6 = r4.getLength()     // Catch:{ all -> 0x0125 }
            int r6 = r6 + r5
            int r6 = r6 + 1
            int r8 = r11.length     // Catch:{ all -> 0x0125 }
            if (r6 > r8) goto L_0x0090
            int r5 = r5 + 1
            byte[] r5 = java.util.Arrays.copyOfRange(r11, r5, r6)     // Catch:{ all -> 0x0125 }
            io.sentry.SentryEnvelopeItem r8 = new io.sentry.SentryEnvelopeItem     // Catch:{ all -> 0x0125 }
            r8.<init>((io.sentry.SentryEnvelopeItemHeader) r4, (byte[]) r5)     // Catch:{ all -> 0x0125 }
            r2.add(r8)     // Catch:{ all -> 0x0125 }
            int r4 = r11.length     // Catch:{ all -> 0x0125 }
            if (r6 != r4) goto L_0x0076
            goto L_0x007f
        L_0x0076:
            int r4 = r6 + 1
            int r5 = r11.length     // Catch:{ all -> 0x0125 }
            if (r4 != r5) goto L_0x003f
            byte r11 = r11[r6]     // Catch:{ all -> 0x0125 }
            if (r11 != r7) goto L_0x0088
        L_0x007f:
            io.sentry.SentryEnvelope r11 = new io.sentry.SentryEnvelope     // Catch:{ all -> 0x0125 }
            r11.<init>(r0, r2)     // Catch:{ all -> 0x0125 }
            r1.close()
            return r11
        L_0x0088:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0125 }
            java.lang.String r0 = "Envelope has invalid data following an item."
            r11.<init>(r0)     // Catch:{ all -> 0x0125 }
            throw r11     // Catch:{ all -> 0x0125 }
        L_0x0090:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0125 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0125 }
            r3.<init>()     // Catch:{ all -> 0x0125 }
            java.lang.String r4 = "Invalid length for item at index '"
            r3.append(r4)     // Catch:{ all -> 0x0125 }
            int r2 = r2.size()     // Catch:{ all -> 0x0125 }
            r3.append(r2)     // Catch:{ all -> 0x0125 }
            java.lang.String r2 = "'. Item is '"
            r3.append(r2)     // Catch:{ all -> 0x0125 }
            r3.append(r6)     // Catch:{ all -> 0x0125 }
            java.lang.String r2 = "' bytes. There are '"
            r3.append(r2)     // Catch:{ all -> 0x0125 }
            int r11 = r11.length     // Catch:{ all -> 0x0125 }
            r3.append(r11)     // Catch:{ all -> 0x0125 }
            java.lang.String r11 = "' in the buffer."
            r3.append(r11)     // Catch:{ all -> 0x0125 }
            java.lang.String r11 = r3.toString()     // Catch:{ all -> 0x0125 }
            r0.<init>(r11)     // Catch:{ all -> 0x0125 }
            throw r0     // Catch:{ all -> 0x0125 }
        L_0x00c1:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0125 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0125 }
            r0.<init>()     // Catch:{ all -> 0x0125 }
            java.lang.String r3 = "Item header at index '"
            r0.append(r3)     // Catch:{ all -> 0x0125 }
            int r2 = r2.size()     // Catch:{ all -> 0x0125 }
            r0.append(r2)     // Catch:{ all -> 0x0125 }
            java.lang.String r2 = "' has an invalid value: '"
            r0.append(r2)     // Catch:{ all -> 0x0125 }
            int r2 = r4.getLength()     // Catch:{ all -> 0x0125 }
            r0.append(r2)     // Catch:{ all -> 0x0125 }
            java.lang.String r2 = "'."
            r0.append(r2)     // Catch:{ all -> 0x0125 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0125 }
            r11.<init>(r0)     // Catch:{ all -> 0x0125 }
            throw r11     // Catch:{ all -> 0x0125 }
        L_0x00ed:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0125 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0125 }
            r0.<init>()     // Catch:{ all -> 0x0125 }
            java.lang.String r3 = "Invalid envelope. Item at index '"
            r0.append(r3)     // Catch:{ all -> 0x0125 }
            int r2 = r2.size()     // Catch:{ all -> 0x0125 }
            r0.append(r2)     // Catch:{ all -> 0x0125 }
            java.lang.String r2 = "'. has no header delimiter."
            r0.append(r2)     // Catch:{ all -> 0x0125 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0125 }
            r11.<init>(r0)     // Catch:{ all -> 0x0125 }
            throw r11     // Catch:{ all -> 0x0125 }
        L_0x010d:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0125 }
            java.lang.String r0 = "Envelope header is null."
            r11.<init>(r0)     // Catch:{ all -> 0x0125 }
            throw r11     // Catch:{ all -> 0x0125 }
        L_0x0115:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0125 }
            java.lang.String r0 = "Envelope contains no header."
            r11.<init>(r0)     // Catch:{ all -> 0x0125 }
            throw r11     // Catch:{ all -> 0x0125 }
        L_0x011d:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0125 }
            java.lang.String r0 = "Empty stream."
            r11.<init>(r0)     // Catch:{ all -> 0x0125 }
            throw r11     // Catch:{ all -> 0x0125 }
        L_0x0125:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x0127 }
        L_0x0127:
            r0 = move-exception
            r1.close()     // Catch:{ all -> 0x012c }
            goto L_0x0130
        L_0x012c:
            r1 = move-exception
            r11.addSuppressed(r1)
        L_0x0130:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.EnvelopeReader.read(java.io.InputStream):io.sentry.SentryEnvelope");
    }

    private SentryEnvelopeHeader deserializeEnvelopeHeader(byte[] bArr, int i, int i2) {
        return (SentryEnvelopeHeader) this.gson.fromJson(new String(bArr, i, i2, UTF_8), SentryEnvelopeHeader.class);
    }

    private SentryEnvelopeItemHeader deserializeEnvelopeItemHeader(byte[] bArr, int i, int i2) {
        return (SentryEnvelopeItemHeader) this.gson.fromJson(new String(bArr, i, i2, UTF_8), SentryEnvelopeItemHeader.class);
    }
}
