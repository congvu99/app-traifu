package com.loopj.android.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpVersion;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;

public class MySSLSocketFactory extends SSLSocketFactory {
    SSLContext sslContext = SSLContext.getInstance("TLS");

    public MySSLSocketFactory(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        AnonymousClass1 r4 = new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        this.sslContext.init((KeyManager[]) null, new TrustManager[]{r4}, (SecureRandom) null);
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return this.sslContext.getSocketFactory().createSocket(socket, str, i, z);
    }

    public Socket createSocket() throws IOException {
        return this.sslContext.getSocketFactory().createSocket();
    }

    public void fixHttpsURLConnection() {
        HttpsURLConnection.setDefaultSSLSocketFactory(this.sslContext.getSocketFactory());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.security.KeyStore} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.security.KeyStore} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.io.BufferedInputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0024 A[SYNTHETIC, Splitter:B:16:0x0024] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x004b A[SYNTHETIC, Splitter:B:33:0x004b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.KeyStore getKeystoreOfCA(java.io.InputStream r3) {
        /*
            r0 = 0
            java.lang.String r1 = "X.509"
            java.security.cert.CertificateFactory r1 = java.security.cert.CertificateFactory.getInstance(r1)     // Catch:{ CertificateException -> 0x001d, all -> 0x001b }
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ CertificateException -> 0x001d, all -> 0x001b }
            r2.<init>(r3)     // Catch:{ CertificateException -> 0x001d, all -> 0x001b }
            java.security.cert.Certificate r3 = r1.generateCertificate(r2)     // Catch:{ CertificateException -> 0x0019 }
            r2.close()     // Catch:{ IOException -> 0x0014 }
            goto L_0x002d
        L_0x0014:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x002d
        L_0x0019:
            r3 = move-exception
            goto L_0x001f
        L_0x001b:
            r3 = move-exception
            goto L_0x0049
        L_0x001d:
            r3 = move-exception
            r2 = r0
        L_0x001f:
            r3.printStackTrace()     // Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x002c
            r2.close()     // Catch:{ IOException -> 0x0028 }
            goto L_0x002c
        L_0x0028:
            r3 = move-exception
            r3.printStackTrace()
        L_0x002c:
            r3 = r0
        L_0x002d:
            java.lang.String r1 = java.security.KeyStore.getDefaultType()
            java.security.KeyStore r1 = java.security.KeyStore.getInstance(r1)     // Catch:{ Exception -> 0x0041 }
            r1.load(r0, r0)     // Catch:{ Exception -> 0x003e }
            java.lang.String r0 = "ca"
            r1.setCertificateEntry(r0, r3)     // Catch:{ Exception -> 0x003e }
            goto L_0x0046
        L_0x003e:
            r3 = move-exception
            r0 = r1
            goto L_0x0042
        L_0x0041:
            r3 = move-exception
        L_0x0042:
            r3.printStackTrace()
            r1 = r0
        L_0x0046:
            return r1
        L_0x0047:
            r3 = move-exception
            r0 = r2
        L_0x0049:
            if (r0 == 0) goto L_0x0053
            r0.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0053:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loopj.android.http.MySSLSocketFactory.getKeystoreOfCA(java.io.InputStream):java.security.KeyStore");
    }

    public static KeyStore getKeystore() {
        KeyStore keyStore;
        Throwable th;
        try {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            try {
                keyStore.load((InputStream) null, (char[]) null);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            keyStore = null;
            th = th4;
            th.printStackTrace();
            return keyStore;
        }
        return keyStore;
    }

    public static SSLSocketFactory getFixedSocketFactory() {
        try {
            MySSLSocketFactory mySSLSocketFactory = new MySSLSocketFactory(getKeystore());
            mySSLSocketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            return mySSLSocketFactory;
        } catch (Throwable th) {
            th.printStackTrace();
            return SSLSocketFactory.getSocketFactory();
        }
    }

    public static DefaultHttpClient getNewHttpClient(KeyStore keyStore) {
        try {
            MySSLSocketFactory mySSLSocketFactory = new MySSLSocketFactory(keyStore);
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", mySSLSocketFactory, 443));
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
            return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        } catch (Exception unused) {
            return new DefaultHttpClient();
        }
    }
}
