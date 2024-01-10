package io.sentry;

import io.sentry.cache.EnvelopeCache;
import io.sentry.util.Objects;
import java.io.File;

public final class EnvelopeSender extends DirectoryProcessor implements IEnvelopeSender {
    private final IHub hub;
    private final ILogger logger;
    private final ISerializer serializer;

    public /* bridge */ /* synthetic */ void processDirectory(File file) {
        super.processDirectory(file);
    }

    public EnvelopeSender(IHub iHub, ISerializer iSerializer, ILogger iLogger, long j) {
        super(iLogger, j);
        this.hub = (IHub) Objects.requireNonNull(iHub, "Hub is required.");
        this.serializer = (ISerializer) Objects.requireNonNull(iSerializer, "Serializer is required.");
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "Logger is required.");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c1, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ca, code lost:
        throw r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processFile(java.io.File r12, java.lang.Object r13) {
        /*
            r11 = this;
            java.lang.String r0 = "Deleted file %s."
            java.lang.String r1 = "after trying to capture it"
            java.lang.String r2 = "File not deleted since retry was marked. %s."
            boolean r3 = r12.isFile()
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0020
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r1[r5] = r12
            java.lang.String r12 = "'%s' is not a file."
            r13.log((io.sentry.SentryLevel) r0, (java.lang.String) r12, (java.lang.Object[]) r1)
            return
        L_0x0020:
            java.lang.String r3 = r12.getName()
            boolean r3 = r11.isRelevantFileName(r3)
            if (r3 != 0) goto L_0x003c
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r1[r5] = r12
            java.lang.String r12 = "File '%s' doesn't match extension expected."
            r13.log((io.sentry.SentryLevel) r0, (java.lang.String) r12, (java.lang.Object[]) r1)
            return
        L_0x003c:
            java.io.File r3 = r12.getParentFile()
            boolean r3 = r3.canWrite()
            if (r3 != 0) goto L_0x0058
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.WARNING
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r1[r5] = r12
            java.lang.String r12 = "File '%s' cannot be deleted so it will not be processed."
            r13.log((io.sentry.SentryLevel) r0, (java.lang.String) r12, (java.lang.Object[]) r1)
            return
        L_0x0058:
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x0173, IOException -> 0x0132, Exception -> 0x00ce }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0173, IOException -> 0x0132, Exception -> 0x00ce }
            r6.<init>(r12)     // Catch:{ FileNotFoundException -> 0x0173, IOException -> 0x0132, Exception -> 0x00ce }
            r3.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0173, IOException -> 0x0132, Exception -> 0x00ce }
            io.sentry.ISerializer r6 = r11.serializer     // Catch:{ all -> 0x00bf }
            io.sentry.SentryEnvelope r6 = r6.deserializeEnvelope(r3)     // Catch:{ all -> 0x00bf }
            io.sentry.IHub r7 = r11.hub     // Catch:{ all -> 0x00bf }
            r7.captureEnvelope(r6, r13)     // Catch:{ all -> 0x00bf }
            boolean r6 = r13 instanceof io.sentry.hints.Flushable     // Catch:{ all -> 0x00bf }
            if (r6 == 0) goto L_0x0086
            r6 = r13
            io.sentry.hints.Flushable r6 = (io.sentry.hints.Flushable) r6     // Catch:{ all -> 0x00bf }
            boolean r6 = r6.waitFlush()     // Catch:{ all -> 0x00bf }
            if (r6 != 0) goto L_0x008b
            io.sentry.ILogger r6 = r11.logger     // Catch:{ all -> 0x00bf }
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.WARNING     // Catch:{ all -> 0x00bf }
            java.lang.String r8 = "Timed out waiting for envelope submission."
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ all -> 0x00bf }
            r6.log((io.sentry.SentryLevel) r7, (java.lang.String) r8, (java.lang.Object[]) r9)     // Catch:{ all -> 0x00bf }
            goto L_0x008b
        L_0x0086:
            io.sentry.ILogger r6 = r11.logger     // Catch:{ all -> 0x00bf }
            io.sentry.util.LogUtils.logIfNotFlushable(r6, r13)     // Catch:{ all -> 0x00bf }
        L_0x008b:
            r3.close()     // Catch:{ FileNotFoundException -> 0x0173, IOException -> 0x0132, Exception -> 0x00ce }
            boolean r3 = r13 instanceof io.sentry.hints.Retryable
            if (r3 == 0) goto L_0x01b4
            io.sentry.hints.Retryable r13 = (io.sentry.hints.Retryable) r13
            boolean r13 = r13.isRetry()
            if (r13 != 0) goto L_0x00ae
            r11.safeDelete(r12, r1)
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r2[r5] = r12
            r13.log((io.sentry.SentryLevel) r1, (java.lang.String) r0, (java.lang.Object[]) r2)
            goto L_0x01b9
        L_0x00ae:
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.INFO
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r1[r5] = r12
            r13.log((io.sentry.SentryLevel) r0, (java.lang.String) r2, (java.lang.Object[]) r1)
            goto L_0x01b9
        L_0x00bf:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x00c1 }
        L_0x00c1:
            r7 = move-exception
            r3.close()     // Catch:{ all -> 0x00c6 }
            goto L_0x00ca
        L_0x00c6:
            r3 = move-exception
            r6.addSuppressed(r3)     // Catch:{ FileNotFoundException -> 0x0173, IOException -> 0x0132, Exception -> 0x00ce }
        L_0x00ca:
            throw r7     // Catch:{ FileNotFoundException -> 0x0173, IOException -> 0x0132, Exception -> 0x00ce }
        L_0x00cb:
            r3 = move-exception
            goto L_0x01ba
        L_0x00ce:
            r3 = move-exception
            io.sentry.ILogger r6 = r11.logger     // Catch:{ all -> 0x00cb }
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x00cb }
            java.lang.String r8 = "Failed to capture cached envelope %s"
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x00cb }
            java.lang.String r10 = r12.getAbsolutePath()     // Catch:{ all -> 0x00cb }
            r9[r5] = r10     // Catch:{ all -> 0x00cb }
            r6.log(r7, r3, r8, r9)     // Catch:{ all -> 0x00cb }
            boolean r6 = r13 instanceof io.sentry.hints.Retryable     // Catch:{ all -> 0x00cb }
            if (r6 == 0) goto L_0x00fc
            r6 = r13
            io.sentry.hints.Retryable r6 = (io.sentry.hints.Retryable) r6     // Catch:{ all -> 0x00cb }
            r6.setRetry(r5)     // Catch:{ all -> 0x00cb }
            io.sentry.ILogger r6 = r11.logger     // Catch:{ all -> 0x00cb }
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.INFO     // Catch:{ all -> 0x00cb }
            java.lang.String r8 = "File '%s' won't retry."
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x00cb }
            java.lang.String r10 = r12.getAbsolutePath()     // Catch:{ all -> 0x00cb }
            r9[r5] = r10     // Catch:{ all -> 0x00cb }
            r6.log(r7, r3, r8, r9)     // Catch:{ all -> 0x00cb }
            goto L_0x0101
        L_0x00fc:
            io.sentry.ILogger r3 = r11.logger     // Catch:{ all -> 0x00cb }
            io.sentry.util.LogUtils.logIfNotRetryable(r3, r13)     // Catch:{ all -> 0x00cb }
        L_0x0101:
            boolean r3 = r13 instanceof io.sentry.hints.Retryable
            if (r3 == 0) goto L_0x01b4
            io.sentry.hints.Retryable r13 = (io.sentry.hints.Retryable) r13
            boolean r13 = r13.isRetry()
            if (r13 != 0) goto L_0x0121
            r11.safeDelete(r12, r1)
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r2[r5] = r12
            r13.log((io.sentry.SentryLevel) r1, (java.lang.String) r0, (java.lang.Object[]) r2)
            goto L_0x01b9
        L_0x0121:
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.INFO
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r1[r5] = r12
            r13.log((io.sentry.SentryLevel) r0, (java.lang.String) r2, (java.lang.Object[]) r1)
            goto L_0x01b9
        L_0x0132:
            r3 = move-exception
            io.sentry.ILogger r6 = r11.logger     // Catch:{ all -> 0x00cb }
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x00cb }
            java.lang.String r8 = "I/O on file '%s' failed."
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x00cb }
            java.lang.String r10 = r12.getAbsolutePath()     // Catch:{ all -> 0x00cb }
            r9[r5] = r10     // Catch:{ all -> 0x00cb }
            r6.log(r7, r3, r8, r9)     // Catch:{ all -> 0x00cb }
            boolean r3 = r13 instanceof io.sentry.hints.Retryable
            if (r3 == 0) goto L_0x01b4
            io.sentry.hints.Retryable r13 = (io.sentry.hints.Retryable) r13
            boolean r13 = r13.isRetry()
            if (r13 != 0) goto L_0x0163
            r11.safeDelete(r12, r1)
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r2[r5] = r12
            r13.log((io.sentry.SentryLevel) r1, (java.lang.String) r0, (java.lang.Object[]) r2)
            goto L_0x01b9
        L_0x0163:
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.INFO
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r1[r5] = r12
            r13.log((io.sentry.SentryLevel) r0, (java.lang.String) r2, (java.lang.Object[]) r1)
            goto L_0x01b9
        L_0x0173:
            r3 = move-exception
            io.sentry.ILogger r6 = r11.logger     // Catch:{ all -> 0x00cb }
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x00cb }
            java.lang.String r8 = "File '%s' cannot be found."
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x00cb }
            java.lang.String r10 = r12.getAbsolutePath()     // Catch:{ all -> 0x00cb }
            r9[r5] = r10     // Catch:{ all -> 0x00cb }
            r6.log(r7, r3, r8, r9)     // Catch:{ all -> 0x00cb }
            boolean r3 = r13 instanceof io.sentry.hints.Retryable
            if (r3 == 0) goto L_0x01b4
            io.sentry.hints.Retryable r13 = (io.sentry.hints.Retryable) r13
            boolean r13 = r13.isRetry()
            if (r13 != 0) goto L_0x01a4
            r11.safeDelete(r12, r1)
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r2[r5] = r12
            r13.log((io.sentry.SentryLevel) r1, (java.lang.String) r0, (java.lang.Object[]) r2)
            goto L_0x01b9
        L_0x01a4:
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.INFO
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r1[r5] = r12
            r13.log((io.sentry.SentryLevel) r0, (java.lang.String) r2, (java.lang.Object[]) r1)
            goto L_0x01b9
        L_0x01b4:
            io.sentry.ILogger r12 = r11.logger
            io.sentry.util.LogUtils.logIfNotRetryable(r12, r13)
        L_0x01b9:
            return
        L_0x01ba:
            boolean r6 = r13 instanceof io.sentry.hints.Retryable
            if (r6 == 0) goto L_0x01e9
            io.sentry.hints.Retryable r13 = (io.sentry.hints.Retryable) r13
            boolean r13 = r13.isRetry()
            if (r13 != 0) goto L_0x01d9
            r11.safeDelete(r12, r1)
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r2[r5] = r12
            r13.log((io.sentry.SentryLevel) r1, (java.lang.String) r0, (java.lang.Object[]) r2)
            goto L_0x01ee
        L_0x01d9:
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.INFO
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r1[r5] = r12
            r13.log((io.sentry.SentryLevel) r0, (java.lang.String) r2, (java.lang.Object[]) r1)
            goto L_0x01ee
        L_0x01e9:
            io.sentry.ILogger r12 = r11.logger
            io.sentry.util.LogUtils.logIfNotRetryable(r12, r13)
        L_0x01ee:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.EnvelopeSender.processFile(java.io.File, java.lang.Object):void");
    }

    /* access modifiers changed from: protected */
    public boolean isRelevantFileName(String str) {
        return str.endsWith(EnvelopeCache.SUFFIX_ENVELOPE_FILE);
    }

    public void processEnvelopeFile(String str, Object obj) {
        Objects.requireNonNull(str, "Path is required.");
        processFile(new File(str), obj);
    }

    private void safeDelete(File file, String str) {
        try {
            if (!file.delete()) {
                this.logger.log(SentryLevel.ERROR, "Failed to delete '%s' %s", file.getAbsolutePath(), str);
            }
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, e, "Failed to delete '%s' %s", file.getAbsolutePath(), str);
        }
    }
}
