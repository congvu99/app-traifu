package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.facebook.FacebookSdk;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0003\u0012\u0013\u0014B\u0005¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/facebook/internal/AttributionIdentifiers;", "", "()V", "androidAdvertiserId", "", "getAndroidAdvertiserId", "()Ljava/lang/String;", "androidAdvertiserIdValue", "<set-?>", "androidInstallerPackage", "getAndroidInstallerPackage", "attributionId", "getAttributionId", "fetchTime", "", "", "isTrackingLimited", "()Z", "Companion", "GoogleAdInfo", "GoogleAdServiceConnection", "facebook-core_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: AttributionIdentifiers.kt */
public final class AttributionIdentifiers {
    private static final String ANDROID_ID_COLUMN_NAME = "androidid";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
    private static final int CONNECTION_RESULT_SUCCESS = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000;
    private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
    /* access modifiers changed from: private */
    public static final String TAG = AttributionIdentifiers.class.getCanonicalName();
    /* access modifiers changed from: private */
    public static AttributionIdentifiers cachedIdentifiers;
    /* access modifiers changed from: private */
    public String androidAdvertiserIdValue;
    /* access modifiers changed from: private */
    public String androidInstallerPackage;
    /* access modifiers changed from: private */
    public String attributionId;
    /* access modifiers changed from: private */
    public long fetchTime;
    /* access modifiers changed from: private */
    public boolean isTrackingLimited;

    @JvmStatic
    public static final AttributionIdentifiers getAttributionIdentifiers(Context context) {
        return Companion.getAttributionIdentifiers(context);
    }

    @JvmStatic
    public static final boolean isTrackingLimited(Context context) {
        return Companion.isTrackingLimited(context);
    }

    public final String getAttributionId() {
        return this.attributionId;
    }

    public final String getAndroidInstallerPackage() {
        return this.androidInstallerPackage;
    }

    public final boolean isTrackingLimited() {
        return this.isTrackingLimited;
    }

    public final String getAndroidAdvertiserId() {
        if (!FacebookSdk.isInitialized() || !FacebookSdk.getAdvertiserIDCollectionEnabled()) {
            return null;
        }
        return this.androidAdvertiserIdValue;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/facebook/internal/AttributionIdentifiers$Companion;", "", "()V", "ANDROID_ID_COLUMN_NAME", "", "ATTRIBUTION_ID_COLUMN_NAME", "ATTRIBUTION_ID_CONTENT_PROVIDER", "ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI", "CONNECTION_RESULT_SUCCESS", "", "IDENTIFIER_REFRESH_INTERVAL_MILLIS", "", "LIMIT_TRACKING_COLUMN_NAME", "TAG", "<set-?>", "Lcom/facebook/internal/AttributionIdentifiers;", "cachedIdentifiers", "getCachedIdentifiers", "()Lcom/facebook/internal/AttributionIdentifiers;", "setCachedIdentifiers", "(Lcom/facebook/internal/AttributionIdentifiers;)V", "cacheAndReturnIdentifiers", "identifiers", "getAndroidId", "context", "Landroid/content/Context;", "getAndroidIdViaReflection", "getAndroidIdViaService", "getAttributionIdentifiers", "getInstallerPackageName", "isGooglePlayServicesAvailable", "", "isTrackingLimited", "facebook-core_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: AttributionIdentifiers.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void setCachedIdentifiers(AttributionIdentifiers attributionIdentifiers) {
            AttributionIdentifiers.cachedIdentifiers = attributionIdentifiers;
        }

        public final AttributionIdentifiers getCachedIdentifiers() {
            return AttributionIdentifiers.cachedIdentifiers;
        }

        private final AttributionIdentifiers getAndroidId(Context context) {
            Companion companion = this;
            AttributionIdentifiers androidIdViaReflection = companion.getAndroidIdViaReflection(context);
            if (androidIdViaReflection != null) {
                return androidIdViaReflection;
            }
            AttributionIdentifiers androidIdViaService = companion.getAndroidIdViaService(context);
            return androidIdViaService == null ? new AttributionIdentifiers() : androidIdViaService;
        }

        private final AttributionIdentifiers getAndroidIdViaReflection(Context context) {
            Object invokeMethodQuietly;
            try {
                if (!isGooglePlayServicesAvailable(context)) {
                    return null;
                }
                boolean z = false;
                Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", (Class<?>[]) new Class[]{Context.class});
                if (!(methodQuietly == null || (invokeMethodQuietly = Utility.invokeMethodQuietly((Object) null, methodQuietly, context)) == null)) {
                    Method methodQuietly2 = Utility.getMethodQuietly(invokeMethodQuietly.getClass(), "getId", (Class<?>[]) new Class[0]);
                    Method methodQuietly3 = Utility.getMethodQuietly(invokeMethodQuietly.getClass(), "isLimitAdTrackingEnabled", (Class<?>[]) new Class[0]);
                    if (methodQuietly2 != null) {
                        if (methodQuietly3 != null) {
                            AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                            attributionIdentifiers.androidAdvertiserIdValue = (String) Utility.invokeMethodQuietly(invokeMethodQuietly, methodQuietly2, new Object[0]);
                            Boolean bool = (Boolean) Utility.invokeMethodQuietly(invokeMethodQuietly, methodQuietly3, new Object[0]);
                            if (bool != null) {
                                z = bool.booleanValue();
                            }
                            attributionIdentifiers.isTrackingLimited = z;
                            return attributionIdentifiers;
                        }
                    }
                }
                return null;
            } catch (Exception e) {
                Utility.logd("android_id", e);
                return null;
            }
        }

        @JvmStatic
        public final boolean isTrackingLimited(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            AttributionIdentifiers attributionIdentifiers = getAttributionIdentifiers(context);
            return attributionIdentifiers != null && attributionIdentifiers.isTrackingLimited();
        }

        private final boolean isGooglePlayServicesAvailable(Context context) {
            Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
            if (methodQuietly == null) {
                return false;
            }
            Object invokeMethodQuietly = Utility.invokeMethodQuietly((Object) null, methodQuietly, context);
            if (!(invokeMethodQuietly instanceof Integer) || (!Intrinsics.areEqual(invokeMethodQuietly, (Object) 0))) {
                return false;
            }
            return true;
        }

        private final AttributionIdentifiers getAndroidIdViaService(Context context) {
            GoogleAdServiceConnection googleAdServiceConnection = new GoogleAdServiceConnection();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            ServiceConnection serviceConnection = googleAdServiceConnection;
            if (!context.bindService(intent, serviceConnection, 1)) {
                return null;
            }
            try {
                GoogleAdInfo googleAdInfo = new GoogleAdInfo(googleAdServiceConnection.getBinder());
                AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                attributionIdentifiers.androidAdvertiserIdValue = googleAdInfo.getAdvertiserId();
                attributionIdentifiers.isTrackingLimited = googleAdInfo.isTrackingLimited();
                return attributionIdentifiers;
            } catch (Exception e) {
                Utility.logd("android_id", e);
                return null;
            } finally {
                context.unbindService(serviceConnection);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0090 A[Catch:{ Exception -> 0x0101, all -> 0x00ff }] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0095 A[Catch:{ Exception -> 0x0101, all -> 0x00ff }] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x009d A[Catch:{ Exception -> 0x0101, all -> 0x00ff }] */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.facebook.internal.AttributionIdentifiers getAttributionIdentifiers(android.content.Context r14) {
            /*
                r13 = this;
                java.lang.String r0 = "limit_tracking"
                java.lang.String r1 = "androidid"
                java.lang.String r2 = "aid"
                java.lang.String r3 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r3)
                r3 = r13
                com.facebook.internal.AttributionIdentifiers$Companion r3 = (com.facebook.internal.AttributionIdentifiers.Companion) r3
                com.facebook.internal.AttributionIdentifiers r4 = r3.getAndroidId(r14)
                r5 = 0
                r6 = r5
                android.database.Cursor r6 = (android.database.Cursor) r6
                android.os.Looper r7 = android.os.Looper.myLooper()     // Catch:{ Exception -> 0x0101 }
                android.os.Looper r8 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x0101 }
                boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)     // Catch:{ Exception -> 0x0101 }
                if (r7 != 0) goto L_0x00f5
                r7 = r13
                com.facebook.internal.AttributionIdentifiers$Companion r7 = (com.facebook.internal.AttributionIdentifiers.Companion) r7     // Catch:{ Exception -> 0x0101 }
                com.facebook.internal.AttributionIdentifiers r7 = r7.getCachedIdentifiers()     // Catch:{ Exception -> 0x0101 }
                if (r7 == 0) goto L_0x003e
                long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0101 }
                long r10 = r7.fetchTime     // Catch:{ Exception -> 0x0101 }
                long r8 = r8 - r10
                r10 = 3600000(0x36ee80, double:1.7786363E-317)
                int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r12 >= 0) goto L_0x003e
                return r7
            L_0x003e:
                java.lang.String[] r9 = new java.lang.String[]{r2, r1, r0}     // Catch:{ Exception -> 0x0101 }
                r7 = r5
                android.net.Uri r7 = (android.net.Uri) r7     // Catch:{ Exception -> 0x0101 }
                android.content.pm.PackageManager r8 = r14.getPackageManager()     // Catch:{ Exception -> 0x0101 }
                java.lang.String r10 = "com.facebook.katana.provider.AttributionIdProvider"
                r11 = 0
                android.content.pm.ProviderInfo r8 = r8.resolveContentProvider(r10, r11)     // Catch:{ Exception -> 0x0101 }
                android.content.pm.PackageManager r10 = r14.getPackageManager()     // Catch:{ Exception -> 0x0101 }
                java.lang.String r12 = "com.facebook.wakizashi.provider.AttributionIdProvider"
                android.content.pm.ProviderInfo r10 = r10.resolveContentProvider(r12, r11)     // Catch:{ Exception -> 0x0101 }
                if (r8 == 0) goto L_0x0070
                java.lang.String r8 = r8.packageName     // Catch:{ Exception -> 0x0101 }
                java.lang.String r11 = "contentProviderInfo.packageName"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r11)     // Catch:{ Exception -> 0x0101 }
                boolean r8 = com.facebook.internal.FacebookSignatureValidator.validateSignature(r14, r8)     // Catch:{ Exception -> 0x0101 }
                if (r8 == 0) goto L_0x0070
                java.lang.String r7 = "content://com.facebook.katana.provider.AttributionIdProvider"
                android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ Exception -> 0x0101 }
                goto L_0x0086
            L_0x0070:
                if (r10 == 0) goto L_0x0086
                java.lang.String r8 = r10.packageName     // Catch:{ Exception -> 0x0101 }
                java.lang.String r10 = "wakizashiProviderInfo.packageName"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r10)     // Catch:{ Exception -> 0x0101 }
                boolean r8 = com.facebook.internal.FacebookSignatureValidator.validateSignature(r14, r8)     // Catch:{ Exception -> 0x0101 }
                if (r8 == 0) goto L_0x0086
                java.lang.String r7 = "content://com.facebook.wakizashi.provider.AttributionIdProvider"
                android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ Exception -> 0x0101 }
            L_0x0086:
                r8 = r7
                r7 = r13
                com.facebook.internal.AttributionIdentifiers$Companion r7 = (com.facebook.internal.AttributionIdentifiers.Companion) r7     // Catch:{ Exception -> 0x0101 }
                java.lang.String r7 = r7.getInstallerPackageName(r14)     // Catch:{ Exception -> 0x0101 }
                if (r7 == 0) goto L_0x0093
                r4.androidInstallerPackage = r7     // Catch:{ Exception -> 0x0101 }
            L_0x0093:
                if (r8 != 0) goto L_0x009d
                r14 = r13
                com.facebook.internal.AttributionIdentifiers$Companion r14 = (com.facebook.internal.AttributionIdentifiers.Companion) r14     // Catch:{ Exception -> 0x0101 }
                com.facebook.internal.AttributionIdentifiers r14 = r14.cacheAndReturnIdentifiers(r4)     // Catch:{ Exception -> 0x0101 }
                return r14
            L_0x009d:
                android.content.ContentResolver r7 = r14.getContentResolver()     // Catch:{ Exception -> 0x0101 }
                r10 = 0
                r11 = 0
                r12 = 0
                android.database.Cursor r6 = r7.query(r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0101 }
                if (r6 == 0) goto L_0x00e8
                boolean r14 = r6.moveToFirst()     // Catch:{ Exception -> 0x0101 }
                if (r14 != 0) goto L_0x00b1
                goto L_0x00e8
            L_0x00b1:
                int r14 = r6.getColumnIndex(r2)     // Catch:{ Exception -> 0x0101 }
                int r1 = r6.getColumnIndex(r1)     // Catch:{ Exception -> 0x0101 }
                int r0 = r6.getColumnIndex(r0)     // Catch:{ Exception -> 0x0101 }
                java.lang.String r14 = r6.getString(r14)     // Catch:{ Exception -> 0x0101 }
                r4.attributionId = r14     // Catch:{ Exception -> 0x0101 }
                if (r1 <= 0) goto L_0x00e0
                if (r0 <= 0) goto L_0x00e0
                java.lang.String r14 = r4.getAndroidAdvertiserId()     // Catch:{ Exception -> 0x0101 }
                if (r14 != 0) goto L_0x00e0
                java.lang.String r14 = r6.getString(r1)     // Catch:{ Exception -> 0x0101 }
                r4.androidAdvertiserIdValue = r14     // Catch:{ Exception -> 0x0101 }
                java.lang.String r14 = r6.getString(r0)     // Catch:{ Exception -> 0x0101 }
                boolean r14 = java.lang.Boolean.parseBoolean(r14)     // Catch:{ Exception -> 0x0101 }
                r4.isTrackingLimited = r14     // Catch:{ Exception -> 0x0101 }
            L_0x00e0:
                r6.close()
                com.facebook.internal.AttributionIdentifiers r14 = r3.cacheAndReturnIdentifiers(r4)
                return r14
            L_0x00e8:
                r14 = r13
                com.facebook.internal.AttributionIdentifiers$Companion r14 = (com.facebook.internal.AttributionIdentifiers.Companion) r14     // Catch:{ Exception -> 0x0101 }
                com.facebook.internal.AttributionIdentifiers r14 = r14.cacheAndReturnIdentifiers(r4)     // Catch:{ Exception -> 0x0101 }
                if (r6 == 0) goto L_0x00f4
                r6.close()
            L_0x00f4:
                return r14
            L_0x00f5:
                com.facebook.FacebookException r14 = new com.facebook.FacebookException     // Catch:{ Exception -> 0x0101 }
                java.lang.String r0 = "getAttributionIdentifiers cannot be called on the main thread."
                r14.<init>((java.lang.String) r0)     // Catch:{ Exception -> 0x0101 }
                java.lang.Throwable r14 = (java.lang.Throwable) r14     // Catch:{ Exception -> 0x0101 }
                throw r14     // Catch:{ Exception -> 0x0101 }
            L_0x00ff:
                r14 = move-exception
                goto L_0x0120
            L_0x0101:
                r14 = move-exception
                java.lang.String r0 = com.facebook.internal.AttributionIdentifiers.TAG     // Catch:{ all -> 0x00ff }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ff }
                r1.<init>()     // Catch:{ all -> 0x00ff }
                java.lang.String r2 = "Caught unexpected exception in getAttributionId(): "
                r1.append(r2)     // Catch:{ all -> 0x00ff }
                r1.append(r14)     // Catch:{ all -> 0x00ff }
                java.lang.String r14 = r1.toString()     // Catch:{ all -> 0x00ff }
                com.facebook.internal.Utility.logd((java.lang.String) r0, (java.lang.String) r14)     // Catch:{ all -> 0x00ff }
                if (r6 == 0) goto L_0x011f
                r6.close()
            L_0x011f:
                return r5
            L_0x0120:
                if (r6 == 0) goto L_0x0125
                r6.close()
            L_0x0125:
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AttributionIdentifiers.Companion.getAttributionIdentifiers(android.content.Context):com.facebook.internal.AttributionIdentifiers");
        }

        private final AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers attributionIdentifiers) {
            attributionIdentifiers.fetchTime = System.currentTimeMillis();
            setCachedIdentifiers(attributionIdentifiers);
            return attributionIdentifiers;
        }

        private final String getInstallerPackageName(Context context) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getInstallerPackageName(context.getPackageName());
            }
            return null;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/internal/AttributionIdentifiers$GoogleAdServiceConnection;", "Landroid/content/ServiceConnection;", "()V", "binder", "Landroid/os/IBinder;", "getBinder", "()Landroid/os/IBinder;", "consumed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "queue", "Ljava/util/concurrent/BlockingQueue;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "onServiceDisconnected", "facebook-core_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: AttributionIdentifiers.kt */
    private static final class GoogleAdServiceConnection implements ServiceConnection {
        private final AtomicBoolean consumed = new AtomicBoolean(false);
        private final BlockingQueue<IBinder> queue = new LinkedBlockingDeque();

        public void onServiceDisconnected(ComponentName componentName) {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.queue.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        public final IBinder getBinder() throws InterruptedException {
            if (!this.consumed.compareAndSet(true, true)) {
                IBinder take = this.queue.take();
                Intrinsics.checkNotNullExpressionValue(take, "queue.take()");
                return take;
            }
            throw new IllegalStateException("Binder already consumed".toString());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/facebook/internal/AttributionIdentifiers$GoogleAdInfo;", "Landroid/os/IInterface;", "binder", "Landroid/os/IBinder;", "(Landroid/os/IBinder;)V", "advertiserId", "", "getAdvertiserId", "()Ljava/lang/String;", "isTrackingLimited", "", "()Z", "asBinder", "Companion", "facebook-core_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: AttributionIdentifiers.kt */
    private static final class GoogleAdInfo implements IInterface {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final int FIRST_TRANSACTION_CODE = 1;
        private static final int SECOND_TRANSACTION_CODE = 2;
        private final IBinder binder;

        public GoogleAdInfo(IBinder iBinder) {
            Intrinsics.checkNotNullParameter(iBinder, "binder");
            this.binder = iBinder;
        }

        public IBinder asBinder() {
            return this.binder;
        }

        public final String getAdvertiserId() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain, "Parcel.obtain()");
            Parcel obtain2 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain2, "Parcel.obtain()");
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.binder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final boolean isTrackingLimited() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain, "Parcel.obtain()");
            Parcel obtain2 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain2, "Parcel.obtain()");
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.binder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/AttributionIdentifiers$GoogleAdInfo$Companion;", "", "()V", "FIRST_TRANSACTION_CODE", "", "SECOND_TRANSACTION_CODE", "facebook-core_release"}, k = 1, mv = {1, 4, 0})
        /* compiled from: AttributionIdentifiers.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }
}
