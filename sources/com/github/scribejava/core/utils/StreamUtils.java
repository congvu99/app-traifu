package com.github.scribejava.core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public abstract class StreamUtils {
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getStreamContents(java.io.InputStream r5) {
        /*
            java.lang.String r0 = "Cannot get String from a null object"
            com.github.scribejava.core.utils.Preconditions.checkNotNull(r5, r0)
            r0 = 65536(0x10000, float:9.18355E-41)
            char[] r1 = new char[r0]     // Catch:{ IOException -> 0x0035 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0035 }
            r2.<init>()     // Catch:{ IOException -> 0x0035 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0035 }
            java.lang.String r4 = "UTF-8"
            r3.<init>(r5, r4)     // Catch:{ IOException -> 0x0035 }
        L_0x0015:
            r5 = 0
            int r4 = r3.read(r1, r5, r0)     // Catch:{ all -> 0x0029 }
            if (r4 <= 0) goto L_0x001f
            r2.append(r1, r5, r4)     // Catch:{ all -> 0x0029 }
        L_0x001f:
            if (r4 >= 0) goto L_0x0015
            r3.close()     // Catch:{ IOException -> 0x0035 }
            java.lang.String r5 = r2.toString()     // Catch:{ IOException -> 0x0035 }
            return r5
        L_0x0029:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x002b }
        L_0x002b:
            r0 = move-exception
            r3.close()     // Catch:{ all -> 0x0030 }
            goto L_0x0034
        L_0x0030:
            r1 = move-exception
            r5.addSuppressed(r1)     // Catch:{ IOException -> 0x0035 }
        L_0x0034:
            throw r0     // Catch:{ IOException -> 0x0035 }
        L_0x0035:
            r5 = move-exception
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Error while reading response body"
            r0.<init>(r1, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.scribejava.core.utils.StreamUtils.getStreamContents(java.io.InputStream):java.lang.String");
    }

    public static String getGzipStreamContents(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream, "Cannot get String from a null object");
        try {
            return getStreamContents(new GZIPInputStream(inputStream));
        } catch (IOException e) {
            throw new IllegalStateException("Error while reading response body", e);
        }
    }
}
