package io.sentry;

import io.sentry.cache.EnvelopeCache;
import io.sentry.hints.Flushable;
import io.sentry.util.LogUtils;
import io.sentry.util.Objects;
import java.io.File;
import java.nio.charset.Charset;

public final class OutboxSender extends DirectoryProcessor implements IEnvelopeSender {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final IEnvelopeReader envelopeReader;
    private final IHub hub;
    private final ILogger logger;
    private final ISerializer serializer;

    public /* bridge */ /* synthetic */ void processDirectory(File file) {
        super.processDirectory(file);
    }

    public OutboxSender(IHub iHub, IEnvelopeReader iEnvelopeReader, ISerializer iSerializer, ILogger iLogger, long j) {
        super(iLogger, j);
        this.hub = (IHub) Objects.requireNonNull(iHub, "Hub is required.");
        this.envelopeReader = (IEnvelopeReader) Objects.requireNonNull(iEnvelopeReader, "Envelope reader is required.");
        this.serializer = (ISerializer) Objects.requireNonNull(iSerializer, "Serializer is required.");
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "Logger is required.");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0096, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        $closeResource(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009a, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processFile(java.io.File r11, java.lang.Object r12) {
        /*
            r10 = this;
            java.lang.String r0 = "Failed to delete: %s"
            java.lang.String r1 = "File is required."
            io.sentry.util.Objects.requireNonNull(r11, r1)
            java.lang.String r1 = r11.getName()
            boolean r1 = r10.isRelevantFileName(r1)
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0025
            io.sentry.ILogger r12 = r10.logger
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r11 = r11.getAbsolutePath()
            r1[r2] = r11
            java.lang.String r11 = "File '%s' should be ignored."
            r12.log((io.sentry.SentryLevel) r0, (java.lang.String) r11, (java.lang.Object[]) r1)
            return
        L_0x0025:
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x009d }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x009d }
            r4.<init>(r11)     // Catch:{ IOException -> 0x009d }
            r1.<init>(r4)     // Catch:{ IOException -> 0x009d }
            r4 = 0
            io.sentry.IEnvelopeReader r5 = r10.envelopeReader     // Catch:{ all -> 0x0094 }
            io.sentry.SentryEnvelope r5 = r5.read(r1)     // Catch:{ all -> 0x0094 }
            if (r5 != 0) goto L_0x004a
            io.sentry.ILogger r5 = r10.logger     // Catch:{ all -> 0x0094 }
            io.sentry.SentryLevel r6 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x0094 }
            java.lang.String r7 = "Stream from path %s resulted in a null envelope."
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ all -> 0x0094 }
            java.lang.String r9 = r11.getAbsolutePath()     // Catch:{ all -> 0x0094 }
            r8[r2] = r9     // Catch:{ all -> 0x0094 }
            r5.log((io.sentry.SentryLevel) r6, (java.lang.String) r7, (java.lang.Object[]) r8)     // Catch:{ all -> 0x0094 }
            goto L_0x005e
        L_0x004a:
            r10.processEnvelope(r5, r12)     // Catch:{ all -> 0x0094 }
            io.sentry.ILogger r5 = r10.logger     // Catch:{ all -> 0x0094 }
            io.sentry.SentryLevel r6 = io.sentry.SentryLevel.DEBUG     // Catch:{ all -> 0x0094 }
            java.lang.String r7 = "File '%s' is done."
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ all -> 0x0094 }
            java.lang.String r9 = r11.getAbsolutePath()     // Catch:{ all -> 0x0094 }
            r8[r2] = r9     // Catch:{ all -> 0x0094 }
            r5.log((io.sentry.SentryLevel) r6, (java.lang.String) r7, (java.lang.Object[]) r8)     // Catch:{ all -> 0x0094 }
        L_0x005e:
            $closeResource(r4, r1)     // Catch:{ IOException -> 0x009d }
            boolean r1 = r12 instanceof io.sentry.hints.Retryable
            if (r1 == 0) goto L_0x00da
            io.sentry.hints.Retryable r12 = (io.sentry.hints.Retryable) r12
            boolean r12 = r12.isRetry()
            if (r12 != 0) goto L_0x00df
            boolean r12 = r11.delete()     // Catch:{ RuntimeException -> 0x0083 }
            if (r12 != 0) goto L_0x00df
            io.sentry.ILogger r12 = r10.logger     // Catch:{ RuntimeException -> 0x0083 }
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.ERROR     // Catch:{ RuntimeException -> 0x0083 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ RuntimeException -> 0x0083 }
            java.lang.String r5 = r11.getAbsolutePath()     // Catch:{ RuntimeException -> 0x0083 }
            r4[r2] = r5     // Catch:{ RuntimeException -> 0x0083 }
            r12.log((io.sentry.SentryLevel) r1, (java.lang.String) r0, (java.lang.Object[]) r4)     // Catch:{ RuntimeException -> 0x0083 }
            goto L_0x00df
        L_0x0083:
            r12 = move-exception
            io.sentry.ILogger r1 = r10.logger
            io.sentry.SentryLevel r4 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r11 = r11.getAbsolutePath()
            r3[r2] = r11
            r1.log(r4, r12, r0, r3)
            goto L_0x00df
        L_0x0094:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0096 }
        L_0x0096:
            r5 = move-exception
            $closeResource(r4, r1)     // Catch:{ IOException -> 0x009d }
            throw r5     // Catch:{ IOException -> 0x009d }
        L_0x009b:
            r1 = move-exception
            goto L_0x00e0
        L_0x009d:
            r1 = move-exception
            io.sentry.ILogger r4 = r10.logger     // Catch:{ all -> 0x009b }
            io.sentry.SentryLevel r5 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x009b }
            java.lang.String r6 = "Error processing envelope."
            r4.log((io.sentry.SentryLevel) r5, (java.lang.String) r6, (java.lang.Throwable) r1)     // Catch:{ all -> 0x009b }
            boolean r1 = r12 instanceof io.sentry.hints.Retryable
            if (r1 == 0) goto L_0x00da
            io.sentry.hints.Retryable r12 = (io.sentry.hints.Retryable) r12
            boolean r12 = r12.isRetry()
            if (r12 != 0) goto L_0x00df
            boolean r12 = r11.delete()     // Catch:{ RuntimeException -> 0x00c9 }
            if (r12 != 0) goto L_0x00df
            io.sentry.ILogger r12 = r10.logger     // Catch:{ RuntimeException -> 0x00c9 }
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.ERROR     // Catch:{ RuntimeException -> 0x00c9 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ RuntimeException -> 0x00c9 }
            java.lang.String r5 = r11.getAbsolutePath()     // Catch:{ RuntimeException -> 0x00c9 }
            r4[r2] = r5     // Catch:{ RuntimeException -> 0x00c9 }
            r12.log((io.sentry.SentryLevel) r1, (java.lang.String) r0, (java.lang.Object[]) r4)     // Catch:{ RuntimeException -> 0x00c9 }
            goto L_0x00df
        L_0x00c9:
            r12 = move-exception
            io.sentry.ILogger r1 = r10.logger
            io.sentry.SentryLevel r4 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r11 = r11.getAbsolutePath()
            r3[r2] = r11
            r1.log(r4, r12, r0, r3)
            goto L_0x00df
        L_0x00da:
            io.sentry.ILogger r11 = r10.logger
            io.sentry.util.LogUtils.logIfNotRetryable(r11, r12)
        L_0x00df:
            return
        L_0x00e0:
            boolean r4 = r12 instanceof io.sentry.hints.Retryable
            if (r4 == 0) goto L_0x0113
            io.sentry.hints.Retryable r12 = (io.sentry.hints.Retryable) r12
            boolean r12 = r12.isRetry()
            if (r12 != 0) goto L_0x0118
            boolean r12 = r11.delete()     // Catch:{ RuntimeException -> 0x0102 }
            if (r12 != 0) goto L_0x0118
            io.sentry.ILogger r12 = r10.logger     // Catch:{ RuntimeException -> 0x0102 }
            io.sentry.SentryLevel r4 = io.sentry.SentryLevel.ERROR     // Catch:{ RuntimeException -> 0x0102 }
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ RuntimeException -> 0x0102 }
            java.lang.String r6 = r11.getAbsolutePath()     // Catch:{ RuntimeException -> 0x0102 }
            r5[r2] = r6     // Catch:{ RuntimeException -> 0x0102 }
            r12.log((io.sentry.SentryLevel) r4, (java.lang.String) r0, (java.lang.Object[]) r5)     // Catch:{ RuntimeException -> 0x0102 }
            goto L_0x0118
        L_0x0102:
            r12 = move-exception
            io.sentry.ILogger r4 = r10.logger
            io.sentry.SentryLevel r5 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r11 = r11.getAbsolutePath()
            r3[r2] = r11
            r4.log(r5, r12, r0, r3)
            goto L_0x0118
        L_0x0113:
            io.sentry.ILogger r11 = r10.logger
            io.sentry.util.LogUtils.logIfNotRetryable(r11, r12)
        L_0x0118:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.OutboxSender.processFile(java.io.File, java.lang.Object):void");
    }

    private static /* synthetic */ void $closeResource(Throwable th, AutoCloseable autoCloseable) {
        if (th != null) {
            try {
                autoCloseable.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            autoCloseable.close();
        }
    }

    /* access modifiers changed from: protected */
    public boolean isRelevantFileName(String str) {
        return str != null && !str.startsWith(EnvelopeCache.PREFIX_CURRENT_SESSION_FILE);
    }

    public void processEnvelopeFile(String str, Object obj) {
        Objects.requireNonNull(str, "Path is required.");
        processFile(new File(str), obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0113, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        $closeResource(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0117, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void processEnvelope(io.sentry.SentryEnvelope r14, java.lang.Object r15) throws java.io.IOException {
        /*
            r13 = this;
            io.sentry.ILogger r0 = r13.logger
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.Iterable r4 = r14.getItems()
            int r4 = io.sentry.util.CollectionUtils.size(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 0
            r3[r5] = r4
            java.lang.String r4 = "Processing Envelope with %d item(s)"
            r0.log((io.sentry.SentryLevel) r1, (java.lang.String) r4, (java.lang.Object[]) r3)
            java.lang.Iterable r0 = r14.getItems()
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x0024:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x01a7
            java.lang.Object r3 = r0.next()
            io.sentry.SentryEnvelopeItem r3 = (io.sentry.SentryEnvelopeItem) r3
            int r1 = r1 + r2
            io.sentry.SentryEnvelopeItemHeader r4 = r3.getHeader()
            if (r4 != 0) goto L_0x0049
            io.sentry.ILogger r3 = r13.logger
            io.sentry.SentryLevel r4 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
            r6[r5] = r7
            java.lang.String r7 = "Item %d has no header"
            r3.log((io.sentry.SentryLevel) r4, (java.lang.String) r7, (java.lang.Object[]) r6)
            goto L_0x0024
        L_0x0049:
            io.sentry.SentryItemType r4 = io.sentry.SentryItemType.Event
            io.sentry.SentryEnvelopeItemHeader r6 = r3.getHeader()
            io.sentry.SentryItemType r6 = r6.getType()
            boolean r4 = r4.equals(r6)
            r6 = 2
            if (r4 == 0) goto L_0x0123
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0118 }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0118 }
            java.io.ByteArrayInputStream r8 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0118 }
            byte[] r9 = r3.getData()     // Catch:{ Exception -> 0x0118 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x0118 }
            java.nio.charset.Charset r9 = UTF_8     // Catch:{ Exception -> 0x0118 }
            r7.<init>(r8, r9)     // Catch:{ Exception -> 0x0118 }
            r4.<init>(r7)     // Catch:{ Exception -> 0x0118 }
            r7 = 0
            io.sentry.ISerializer r8 = r13.serializer     // Catch:{ all -> 0x0111 }
            java.lang.Class<io.sentry.SentryEvent> r9 = io.sentry.SentryEvent.class
            java.lang.Object r8 = r8.deserialize(r4, r9)     // Catch:{ all -> 0x0111 }
            io.sentry.SentryEvent r8 = (io.sentry.SentryEvent) r8     // Catch:{ all -> 0x0111 }
            if (r8 != 0) goto L_0x0098
            io.sentry.ILogger r8 = r13.logger     // Catch:{ all -> 0x0111 }
            io.sentry.SentryLevel r9 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x0111 }
            java.lang.String r10 = "Item %d of type %s returned null by the parser."
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0111 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0111 }
            r6[r5] = r11     // Catch:{ all -> 0x0111 }
            io.sentry.SentryEnvelopeItemHeader r3 = r3.getHeader()     // Catch:{ all -> 0x0111 }
            io.sentry.SentryItemType r3 = r3.getType()     // Catch:{ all -> 0x0111 }
            r6[r2] = r3     // Catch:{ all -> 0x0111 }
            r8.log((io.sentry.SentryLevel) r9, (java.lang.String) r10, (java.lang.Object[]) r6)     // Catch:{ all -> 0x0111 }
            goto L_0x010d
        L_0x0098:
            io.sentry.SentryEnvelopeHeader r3 = r14.getHeader()     // Catch:{ all -> 0x0111 }
            io.sentry.protocol.SentryId r3 = r3.getEventId()     // Catch:{ all -> 0x0111 }
            if (r3 == 0) goto L_0x00db
            io.sentry.SentryEnvelopeHeader r3 = r14.getHeader()     // Catch:{ all -> 0x0111 }
            io.sentry.protocol.SentryId r3 = r3.getEventId()     // Catch:{ all -> 0x0111 }
            io.sentry.protocol.SentryId r9 = r8.getEventId()     // Catch:{ all -> 0x0111 }
            boolean r3 = r3.equals(r9)     // Catch:{ all -> 0x0111 }
            if (r3 != 0) goto L_0x00db
            io.sentry.ILogger r3 = r13.logger     // Catch:{ all -> 0x0111 }
            io.sentry.SentryLevel r9 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x0111 }
            java.lang.String r10 = "Item %d of has a different event id (%s) to the envelope header (%s)"
            r11 = 3
            java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ all -> 0x0111 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0111 }
            r11[r5] = r12     // Catch:{ all -> 0x0111 }
            io.sentry.SentryEnvelopeHeader r12 = r14.getHeader()     // Catch:{ all -> 0x0111 }
            io.sentry.protocol.SentryId r12 = r12.getEventId()     // Catch:{ all -> 0x0111 }
            r11[r2] = r12     // Catch:{ all -> 0x0111 }
            io.sentry.protocol.SentryId r8 = r8.getEventId()     // Catch:{ all -> 0x0111 }
            r11[r6] = r8     // Catch:{ all -> 0x0111 }
            r3.log((io.sentry.SentryLevel) r9, (java.lang.String) r10, (java.lang.Object[]) r11)     // Catch:{ all -> 0x0111 }
            $closeResource(r7, r4)     // Catch:{ Exception -> 0x0118 }
            goto L_0x0024
        L_0x00db:
            io.sentry.IHub r3 = r13.hub     // Catch:{ all -> 0x0111 }
            r3.captureEvent(r8, r15)     // Catch:{ all -> 0x0111 }
            io.sentry.ILogger r3 = r13.logger     // Catch:{ all -> 0x0111 }
            io.sentry.SentryLevel r6 = io.sentry.SentryLevel.DEBUG     // Catch:{ all -> 0x0111 }
            java.lang.String r9 = "Item %d is being captured."
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch:{ all -> 0x0111 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0111 }
            r10[r5] = r11     // Catch:{ all -> 0x0111 }
            r3.log((io.sentry.SentryLevel) r6, (java.lang.String) r9, (java.lang.Object[]) r10)     // Catch:{ all -> 0x0111 }
            boolean r3 = r13.waitFlush(r15)     // Catch:{ all -> 0x0111 }
            if (r3 != 0) goto L_0x010d
            io.sentry.ILogger r3 = r13.logger     // Catch:{ all -> 0x0111 }
            io.sentry.SentryLevel r6 = io.sentry.SentryLevel.WARNING     // Catch:{ all -> 0x0111 }
            java.lang.String r9 = "Timed out waiting for event submission: %s"
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch:{ all -> 0x0111 }
            io.sentry.protocol.SentryId r8 = r8.getEventId()     // Catch:{ all -> 0x0111 }
            r10[r5] = r8     // Catch:{ all -> 0x0111 }
            r3.log((io.sentry.SentryLevel) r6, (java.lang.String) r9, (java.lang.Object[]) r10)     // Catch:{ all -> 0x0111 }
            $closeResource(r7, r4)     // Catch:{ Exception -> 0x0118 }
            goto L_0x01a7
        L_0x010d:
            $closeResource(r7, r4)     // Catch:{ Exception -> 0x0118 }
            goto L_0x017c
        L_0x0111:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0113 }
        L_0x0113:
            r6 = move-exception
            $closeResource(r3, r4)     // Catch:{ Exception -> 0x0118 }
            throw r6     // Catch:{ Exception -> 0x0118 }
        L_0x0118:
            r3 = move-exception
            io.sentry.ILogger r4 = r13.logger
            io.sentry.SentryLevel r6 = io.sentry.SentryLevel.ERROR
            java.lang.String r7 = "Item failed to process."
            r4.log((io.sentry.SentryLevel) r6, (java.lang.String) r7, (java.lang.Throwable) r3)
            goto L_0x017c
        L_0x0123:
            io.sentry.SentryEnvelope r4 = new io.sentry.SentryEnvelope
            io.sentry.SentryEnvelopeHeader r7 = r14.getHeader()
            io.sentry.protocol.SentryId r7 = r7.getEventId()
            io.sentry.SentryEnvelopeHeader r8 = r14.getHeader()
            io.sentry.protocol.SdkVersion r8 = r8.getSdkVersion()
            r4.<init>((io.sentry.protocol.SentryId) r7, (io.sentry.protocol.SdkVersion) r8, (io.sentry.SentryEnvelopeItem) r3)
            io.sentry.IHub r7 = r13.hub
            r7.captureEnvelope(r4, r15)
            io.sentry.ILogger r4 = r13.logger
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r6 = new java.lang.Object[r6]
            io.sentry.SentryEnvelopeItemHeader r8 = r3.getHeader()
            io.sentry.SentryItemType r8 = r8.getType()
            java.lang.String r8 = r8.getItemType()
            r6[r5] = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r1)
            r6[r2] = r8
            java.lang.String r8 = "%s item %d is being captured."
            r4.log((io.sentry.SentryLevel) r7, (java.lang.String) r8, (java.lang.Object[]) r6)
            boolean r4 = r13.waitFlush(r15)
            if (r4 != 0) goto L_0x017c
            io.sentry.ILogger r14 = r13.logger
            io.sentry.SentryLevel r15 = io.sentry.SentryLevel.WARNING
            java.lang.Object[] r0 = new java.lang.Object[r2]
            io.sentry.SentryEnvelopeItemHeader r1 = r3.getHeader()
            io.sentry.SentryItemType r1 = r1.getType()
            java.lang.String r1 = r1.getItemType()
            r0[r5] = r1
            java.lang.String r1 = "Timed out waiting for item type submission: %s"
            r14.log((io.sentry.SentryLevel) r15, (java.lang.String) r1, (java.lang.Object[]) r0)
            goto L_0x01a7
        L_0x017c:
            boolean r3 = r15 instanceof io.sentry.hints.SubmissionResult
            if (r3 == 0) goto L_0x019b
            r3 = r15
            io.sentry.hints.SubmissionResult r3 = (io.sentry.hints.SubmissionResult) r3
            boolean r3 = r3.isSuccess()
            if (r3 != 0) goto L_0x019b
            io.sentry.ILogger r14 = r13.logger
            io.sentry.SentryLevel r15 = io.sentry.SentryLevel.WARNING
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0[r5] = r1
            java.lang.String r1 = "Envelope had a failed capture at item %d. No more items will be sent."
            r14.log((io.sentry.SentryLevel) r15, (java.lang.String) r1, (java.lang.Object[]) r0)
            goto L_0x01a7
        L_0x019b:
            boolean r3 = r15 instanceof io.sentry.hints.Resettable
            if (r3 == 0) goto L_0x0024
            r3 = r15
            io.sentry.hints.Resettable r3 = (io.sentry.hints.Resettable) r3
            r3.reset()
            goto L_0x0024
        L_0x01a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.OutboxSender.processEnvelope(io.sentry.SentryEnvelope, java.lang.Object):void");
    }

    private boolean waitFlush(Object obj) {
        if (obj instanceof Flushable) {
            return ((Flushable) obj).waitFlush();
        }
        LogUtils.logIfNotFlushable(this.logger, obj);
        return true;
    }
}
