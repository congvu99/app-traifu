package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/Utils;", "", "()V", "isOnline", "", "context", "Landroid/content/Context;", "readHTMLFromUTF8File", "", "inputStream", "Ljava/io/InputStream;", "core_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: Utils.kt */
public final class Utils {
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    public final boolean isOnline(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0043, code lost:
        throw new java.lang.RuntimeException("Can't parse HTML file.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String readHTMLFromUTF8File(java.io.InputStream r4) {
        /*
            r3 = this;
            java.lang.String r0 = "inputStream"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Exception -> 0x003a }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x003a }
            java.lang.String r2 = "utf-8"
            r1.<init>(r4, r2)     // Catch:{ Exception -> 0x003a }
            java.io.Reader r1 = (java.io.Reader) r1     // Catch:{ Exception -> 0x003a }
            r0.<init>(r1)     // Catch:{ Exception -> 0x003a }
            java.lang.String r1 = r0.readLine()     // Catch:{ Exception -> 0x003a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003a }
            r2.<init>()     // Catch:{ Exception -> 0x003a }
        L_0x001c:
            if (r1 == 0) goto L_0x002b
            r2.append(r1)     // Catch:{ Exception -> 0x003a }
            java.lang.String r1 = "\n"
            r2.append(r1)     // Catch:{ Exception -> 0x003a }
            java.lang.String r1 = r0.readLine()     // Catch:{ Exception -> 0x003a }
            goto L_0x001c
        L_0x002b:
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x003a }
            java.lang.String r1 = "sb.toString()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)     // Catch:{ Exception -> 0x003a }
            r4.close()
            return r0
        L_0x0038:
            r0 = move-exception
            goto L_0x0044
        L_0x003a:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0038 }
            java.lang.String r1 = "Can't parse HTML file."
            r0.<init>(r1)     // Catch:{ all -> 0x0038 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x0038 }
            throw r0     // Catch:{ all -> 0x0038 }
        L_0x0044:
            r4.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.Utils.readHTMLFromUTF8File(java.io.InputStream):java.lang.String");
    }
}
