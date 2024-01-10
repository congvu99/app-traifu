package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.soloader.SysUtil;
import com.facebook.soloader.nativeloader.NativeLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Nullable;

public class SoLoader {
    static final boolean DEBUG = false;
    private static final String[] DEFAULT_DENY_LIST = {System.mapLibraryName("breakpad")};
    public static final int SOLOADER_ALLOW_ASYNC_INIT = 2;
    public static final int SOLOADER_DISABLE_BACKUP_SOSOURCE = 8;
    public static final int SOLOADER_DONT_TREAT_AS_SYSTEMAPP = 32;
    public static final int SOLOADER_ENABLE_DIRECT_SOSOURCE = 64;
    public static final int SOLOADER_ENABLE_EXOPACKAGE = 1;
    public static final int SOLOADER_EXPLICITLY_ENABLE_BACKUP_SOSOURCE = 128;
    public static final int SOLOADER_LOOK_IN_ZIP = 4;
    public static final int SOLOADER_SKIP_MERGED_JNI_ONLOAD = 16;
    private static final String SO_STORE_NAME_MAIN = "lib-main";
    private static final String SO_STORE_NAME_SPLIT = "lib-";
    static final boolean SYSTRACE_LIBRARY_LOADING;
    static final String TAG = "SoLoader";
    private static int sAppType = 0;
    @Nullable
    private static ApplicationSoSource sApplicationSoSource;
    @Nullable
    private static UnpackingSoSource[] sBackupSoSources;
    private static int sFlags;
    private static final Set<String> sLoadedAndMergedLibraries = Collections.newSetFromMap(new ConcurrentHashMap());
    /* access modifiers changed from: private */
    public static final HashSet<String> sLoadedLibraries = new HashSet<>();
    /* access modifiers changed from: private */
    public static final Map<String, Object> sLoadingLibraries = new HashMap();
    @Nullable
    static SoFileLoader sSoFileLoader;
    /* access modifiers changed from: private */
    @Nullable
    public static volatile SoSource[] sSoSources = null;
    /* access modifiers changed from: private */
    public static final ReentrantReadWriteLock sSoSourcesLock = new ReentrantReadWriteLock();
    /* access modifiers changed from: private */
    public static final AtomicInteger sSoSourcesVersion = new AtomicInteger(0);
    @Nullable
    private static SystemLoadLibraryWrapper sSystemLoadLibraryWrapper = null;

    interface AppType {
        public static final int SYSTEM_APP = 2;
        public static final int THIRD_PARTY_APP = 1;
        public static final int UNSET = 0;
        public static final int UPDATED_SYSTEM_APP = 3;
    }

    static {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                z = true;
            }
        } catch (NoClassDefFoundError | UnsatisfiedLinkError unused) {
        }
        SYSTRACE_LIBRARY_LOADING = z;
    }

    public static void init(Context context, int i) throws IOException {
        init(context, i, (SoFileLoader) null, DEFAULT_DENY_LIST);
    }

    public static void init(Context context, int i, @Nullable SoFileLoader soFileLoader) throws IOException {
        init(context, i, soFileLoader, DEFAULT_DENY_LIST);
    }

    public static void init(Context context, int i, @Nullable SoFileLoader soFileLoader, String[] strArr) throws IOException {
        if (!isInitialized()) {
            StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
            try {
                int appType = getAppType(context, i);
                sAppType = appType;
                if ((i & 128) == 0 && SysUtil.isSupportedDirectLoad(context, appType)) {
                    i |= 72;
                }
                initSoLoader(soFileLoader);
                initSoSources(context, i, strArr);
                NativeLoader.initIfUninitialized(new NativeLoaderToSoLoaderDelegate());
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
            }
        }
    }

    public static void init(Context context, boolean z) {
        try {
            init(context, z ? 1 : 0, (SoFileLoader) null, DEFAULT_DENY_LIST);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void initSoSources(Context context, int i, String[] strArr) throws IOException {
        if (sSoSources == null) {
            sSoSourcesLock.writeLock().lock();
            if (sSoSources != null) {
                sSoSourcesLock.writeLock().unlock();
                return;
            }
            try {
                sFlags = i;
                ArrayList arrayList = new ArrayList();
                AddSystemLibSoSource(arrayList, strArr);
                if (context != null) {
                    if ((i & 1) != 0) {
                        sBackupSoSources = null;
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "adding exo package source: lib-main");
                        }
                        arrayList.add(0, new ExoSoSource(context, SO_STORE_NAME_MAIN));
                    } else {
                        if ((i & 64) != 0) {
                            addDirectApkSoSource(context, arrayList);
                        }
                        addApplicationSoSource(context, arrayList, getApplicationSoSourceFlags());
                        AddBackupSoSource(context, arrayList, 1);
                    }
                }
                SoSource[] soSourceArr = (SoSource[]) arrayList.toArray(new SoSource[arrayList.size()]);
                int makePrepareFlags = makePrepareFlags();
                int length = soSourceArr.length;
                while (true) {
                    int i2 = length - 1;
                    if (length <= 0) {
                        break;
                    }
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Preparing SO source: " + soSourceArr[i2]);
                    }
                    if (SYSTRACE_LIBRARY_LOADING) {
                        Api18TraceUtils.beginTraceSection(TAG, "_", soSourceArr[i2].getClass().getSimpleName());
                    }
                    soSourceArr[i2].prepare(makePrepareFlags);
                    if (SYSTRACE_LIBRARY_LOADING) {
                        Api18TraceUtils.endSection();
                    }
                    length = i2;
                }
                sSoSources = soSourceArr;
                sSoSourcesVersion.getAndIncrement();
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "init finish: " + sSoSources.length + " SO sources prepared");
                }
            } finally {
                sSoSourcesLock.writeLock().unlock();
            }
        }
    }

    private static int getApplicationSoSourceFlags() {
        int i = sAppType;
        if (i == 1) {
            return 0;
        }
        if (i == 2 || i == 3) {
            return 1;
        }
        throw new RuntimeException("Unsupported app type, we should not reach here");
    }

    private static void addDirectApkSoSource(Context context, ArrayList<SoSource> arrayList) {
        if (Build.VERSION.SDK_INT >= 21 && context.getApplicationInfo().splitSourceDirs != null) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "adding directApk sources from split apks");
            }
            for (String file : context.getApplicationInfo().splitSourceDirs) {
                DirectApkSoSource directApkSoSource = new DirectApkSoSource(new File(file));
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "adding directApk source: " + directApkSoSource.toString());
                }
                arrayList.add(0, directApkSoSource);
            }
        }
        DirectApkSoSource directApkSoSource2 = new DirectApkSoSource(context);
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "adding directApk source: " + directApkSoSource2.toString());
        }
        arrayList.add(0, directApkSoSource2);
    }

    private static void addApplicationSoSource(Context context, ArrayList<SoSource> arrayList, int i) {
        if (Build.VERSION.SDK_INT <= 17) {
            i |= 1;
        }
        sApplicationSoSource = new ApplicationSoSource(context, i);
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "adding application source: " + sApplicationSoSource.toString());
        }
        arrayList.add(0, sApplicationSoSource);
    }

    private static void AddBackupSoSource(Context context, ArrayList<SoSource> arrayList, int i) throws IOException {
        if ((sFlags & 8) != 0) {
            sBackupSoSources = null;
            File soStorePath = UnpackingSoSource.getSoStorePath(context, SO_STORE_NAME_MAIN);
            try {
                SysUtil.dumbDeleteRecursive(soStorePath);
            } catch (IOException e) {
                Log.w(TAG, "Failed to delete " + soStorePath.getCanonicalPath(), e);
            }
        } else {
            File file = new File(context.getApplicationInfo().sourceDir);
            ArrayList arrayList2 = new ArrayList();
            ApkSoSource apkSoSource = new ApkSoSource(context, file, SO_STORE_NAME_MAIN, i);
            arrayList2.add(apkSoSource);
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "adding backup source from : " + apkSoSource.toString());
            }
            addBackupSoSourceFromSplitApk(context, i, arrayList2);
            sBackupSoSources = (UnpackingSoSource[]) arrayList2.toArray(new UnpackingSoSource[arrayList2.size()]);
            arrayList.addAll(0, arrayList2);
        }
    }

    private static void addBackupSoSourceFromSplitApk(Context context, int i, ArrayList<UnpackingSoSource> arrayList) {
        if (Build.VERSION.SDK_INT >= 21 && context.getApplicationInfo().splitSourceDirs != null) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "adding backup sources from split apks");
            }
            String[] strArr = context.getApplicationInfo().splitSourceDirs;
            int length = strArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                File file = new File(strArr[i2]);
                StringBuilder sb = new StringBuilder();
                sb.append(SO_STORE_NAME_SPLIT);
                int i4 = i3 + 1;
                sb.append(i3);
                ApkSoSource apkSoSource = new ApkSoSource(context, file, sb.toString(), i);
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "adding backup source: " + apkSoSource.toString());
                }
                arrayList.add(apkSoSource);
                i2++;
                i3 = i4;
            }
        }
    }

    private static void AddSystemLibSoSource(ArrayList<SoSource> arrayList, String[] strArr) {
        String str = SysUtil.is64Bit() ? "/system/lib64:/vendor/lib64" : "/system/lib:/vendor/lib";
        String str2 = System.getenv("LD_LIBRARY_PATH");
        if (str2 != null && !str2.equals("")) {
            str = str + CertificateUtil.DELIMITER + str2;
        }
        for (String str3 : new HashSet(Arrays.asList(str.split(CertificateUtil.DELIMITER)))) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "adding system library source: " + str3);
            }
            arrayList.add(new DirectorySoSource(new File(str3), 2, strArr));
        }
    }

    private static int makePrepareFlags() {
        sSoSourcesLock.writeLock().lock();
        try {
            return (sFlags & 2) != 0 ? 1 : 0;
        } finally {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    private static synchronized void initSoLoader(@Nullable SoFileLoader soFileLoader) {
        synchronized (SoLoader.class) {
            if (soFileLoader == null) {
                if (sSoFileLoader != null) {
                    return;
                }
            }
            if (soFileLoader != null) {
                sSoFileLoader = soFileLoader;
                return;
            }
            final Runtime runtime = Runtime.getRuntime();
            final Method nativeLoadRuntimeMethod = getNativeLoadRuntimeMethod();
            final boolean z = nativeLoadRuntimeMethod != null;
            final String classLoaderLdLoadLibrary = z ? SysUtil.Api14Utils.getClassLoaderLdLoadLibrary() : null;
            final String makeNonZipPath = makeNonZipPath(classLoaderLdLoadLibrary);
            sSoFileLoader = new SoFileLoader() {
                public void loadBytes(String str, ElfByteChannel elfByteChannel, int i) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARNING: type inference failed for: r1v0 */
                /* JADX WARNING: type inference failed for: r1v10 */
                /* JADX WARNING: type inference failed for: r1v12 */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
                    if (r1 == null) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
                    android.util.Log.e(com.facebook.soloader.SoLoader.TAG, "Error when loading lib: " + r1 + " lib hash: " + getLibHash(r9) + " search path is " + r10);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
                    return;
                 */
                /* JADX WARNING: Removed duplicated region for block: B:39:0x009e  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void load(java.lang.String r9, int r10) {
                    /*
                        r8 = this;
                        boolean r0 = r2
                        if (r0 == 0) goto L_0x00c9
                        r0 = 4
                        r10 = r10 & r0
                        r1 = 1
                        r2 = 0
                        if (r10 != r0) goto L_0x000c
                        r10 = 1
                        goto L_0x000d
                    L_0x000c:
                        r10 = 0
                    L_0x000d:
                        if (r10 == 0) goto L_0x0012
                        java.lang.String r10 = r3
                        goto L_0x0014
                    L_0x0012:
                        java.lang.String r10 = r4
                    L_0x0014:
                        r0 = 0
                        java.lang.Runtime r3 = r5     // Catch:{ IllegalAccessException -> 0x0080, IllegalArgumentException -> 0x007e, InvocationTargetException -> 0x007c, all -> 0x0077 }
                        monitor-enter(r3)     // Catch:{ IllegalAccessException -> 0x0080, IllegalArgumentException -> 0x007e, InvocationTargetException -> 0x007c, all -> 0x0077 }
                        java.lang.reflect.Method r4 = r6     // Catch:{ all -> 0x0069 }
                        java.lang.Runtime r5 = r5     // Catch:{ all -> 0x0069 }
                        r6 = 3
                        java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0069 }
                        r6[r2] = r9     // Catch:{ all -> 0x0069 }
                        java.lang.Class<com.facebook.soloader.SoLoader> r2 = com.facebook.soloader.SoLoader.class
                        java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ all -> 0x0069 }
                        r6[r1] = r2     // Catch:{ all -> 0x0069 }
                        r1 = 2
                        r6[r1] = r10     // Catch:{ all -> 0x0069 }
                        java.lang.Object r1 = r4.invoke(r5, r6)     // Catch:{ all -> 0x0069 }
                        java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0069 }
                        if (r1 != 0) goto L_0x0063
                        monitor-exit(r3)     // Catch:{ all -> 0x0075 }
                        if (r1 == 0) goto L_0x00cc
                        java.lang.String r0 = "SoLoader"
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        java.lang.String r3 = "Error when loading lib: "
                        r2.append(r3)
                        r2.append(r1)
                        java.lang.String r1 = " lib hash: "
                        r2.append(r1)
                        java.lang.String r9 = r8.getLibHash(r9)
                        r2.append(r9)
                        java.lang.String r9 = " search path is "
                        r2.append(r9)
                        r2.append(r10)
                        java.lang.String r9 = r2.toString()
                        android.util.Log.e(r0, r9)
                        goto L_0x00cc
                    L_0x0063:
                        java.lang.UnsatisfiedLinkError r0 = new java.lang.UnsatisfiedLinkError     // Catch:{ all -> 0x0075 }
                        r0.<init>(r1)     // Catch:{ all -> 0x0075 }
                        throw r0     // Catch:{ all -> 0x0075 }
                    L_0x0069:
                        r1 = move-exception
                        r7 = r1
                        r1 = r0
                        r0 = r7
                    L_0x006d:
                        monitor-exit(r3)     // Catch:{ all -> 0x0075 }
                        throw r0     // Catch:{ IllegalAccessException -> 0x0073, IllegalArgumentException -> 0x0071, InvocationTargetException -> 0x006f }
                    L_0x006f:
                        r0 = move-exception
                        goto L_0x0084
                    L_0x0071:
                        r0 = move-exception
                        goto L_0x0084
                    L_0x0073:
                        r0 = move-exception
                        goto L_0x0084
                    L_0x0075:
                        r0 = move-exception
                        goto L_0x006d
                    L_0x0077:
                        r1 = move-exception
                        r7 = r1
                        r1 = r0
                        r0 = r7
                        goto L_0x009c
                    L_0x007c:
                        r1 = move-exception
                        goto L_0x0081
                    L_0x007e:
                        r1 = move-exception
                        goto L_0x0081
                    L_0x0080:
                        r1 = move-exception
                    L_0x0081:
                        r7 = r1
                        r1 = r0
                        r0 = r7
                    L_0x0084:
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x009b }
                        r2.<init>()     // Catch:{ all -> 0x009b }
                        java.lang.String r3 = "Error: Cannot load "
                        r2.append(r3)     // Catch:{ all -> 0x009b }
                        r2.append(r9)     // Catch:{ all -> 0x009b }
                        java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x009b }
                        java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x009b }
                        r2.<init>(r1, r0)     // Catch:{ all -> 0x009b }
                        throw r2     // Catch:{ all -> 0x009b }
                    L_0x009b:
                        r0 = move-exception
                    L_0x009c:
                        if (r1 == 0) goto L_0x00c8
                        java.lang.String r2 = "SoLoader"
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                        r3.<init>()
                        java.lang.String r4 = "Error when loading lib: "
                        r3.append(r4)
                        r3.append(r1)
                        java.lang.String r1 = " lib hash: "
                        r3.append(r1)
                        java.lang.String r9 = r8.getLibHash(r9)
                        r3.append(r9)
                        java.lang.String r9 = " search path is "
                        r3.append(r9)
                        r3.append(r10)
                        java.lang.String r9 = r3.toString()
                        android.util.Log.e(r2, r9)
                    L_0x00c8:
                        throw r0
                    L_0x00c9:
                        java.lang.System.load(r9)
                    L_0x00cc:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.AnonymousClass1.load(java.lang.String, int):void");
                }

                private String getLibHash(String str) {
                    FileInputStream fileInputStream;
                    try {
                        File file = new File(str);
                        MessageDigest instance = MessageDigest.getInstance("MD5");
                        fileInputStream = new FileInputStream(file);
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read > 0) {
                                instance.update(bArr, 0, read);
                            } else {
                                String format = String.format("%32x", new Object[]{new BigInteger(1, instance.digest())});
                                fileInputStream.close();
                                return format;
                            }
                        }
                    } catch (IOException | SecurityException | NoSuchAlgorithmException e) {
                        return e.toString();
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                    throw th;
                }
            };
        }
    }

    @Nullable
    private static Method getNativeLoadRuntimeMethod() {
        if (Build.VERSION.SDK_INT >= 23 && Build.VERSION.SDK_INT <= 27) {
            try {
                Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", new Class[]{String.class, ClassLoader.class, String.class});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException | SecurityException e) {
                Log.w(TAG, "Cannot get nativeLoad method", e);
            }
        }
        return null;
    }

    private static int getAppType(Context context, int i) {
        int i2 = sAppType;
        if (i2 != 0) {
            return i2;
        }
        int i3 = 1;
        if ((i & 32) == 0 && context != null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if ((applicationInfo.flags & 1) != 0) {
                i3 = (applicationInfo.flags & 128) != 0 ? 3 : 2;
            }
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "ApplicationInfo.flags is: " + applicationInfo.flags + " appType is: " + i3);
            }
        }
        return i3;
    }

    public static void setInTestMode() {
        TestOnlyUtils.setSoSources(new SoSource[]{new NoopSoSource()});
    }

    public static void deinitForTest() {
        TestOnlyUtils.setSoSources((SoSource[]) null);
    }

    static class TestOnlyUtils {
        TestOnlyUtils() {
        }

        static void setSoSources(SoSource[] soSourceArr) {
            SoLoader.sSoSourcesLock.writeLock().lock();
            try {
                SoSource[] unused = SoLoader.sSoSources = soSourceArr;
                SoLoader.sSoSourcesVersion.getAndIncrement();
            } finally {
                SoLoader.sSoSourcesLock.writeLock().unlock();
            }
        }

        static void setSoFileLoader(SoFileLoader soFileLoader) {
            SoLoader.sSoFileLoader = soFileLoader;
        }

        static void resetStatus() {
            synchronized (SoLoader.class) {
                SoLoader.sLoadedLibraries.clear();
                SoLoader.sLoadingLibraries.clear();
                SoLoader.sSoFileLoader = null;
            }
            setSoSources((SoSource[]) null);
        }
    }

    public static void setSystemLoadLibraryWrapper(SystemLoadLibraryWrapper systemLoadLibraryWrapper) {
        sSystemLoadLibraryWrapper = systemLoadLibraryWrapper;
    }

    public static final class WrongAbiError extends UnsatisfiedLinkError {
        WrongAbiError(Throwable th, String str) {
            super("APK was built for a different platform. Supported ABIs: " + Arrays.toString(SysUtil.getSupportedAbis()) + " error: " + str);
            initCause(th);
        }
    }

    @Nullable
    public static String getLibraryPath(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            String str2 = null;
            if (sSoSources != null) {
                int i = 0;
                while (str2 == null && i < sSoSources.length) {
                    str2 = sSoSources[i].getLibraryPath(str);
                    i++;
                }
            }
            return str2;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    @Nullable
    public static String[] getLibraryDependencies(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            String[] strArr = null;
            if (sSoSources != null) {
                int i = 0;
                while (strArr == null && i < sSoSources.length) {
                    strArr = sSoSources[i].getLibraryDependencies(str);
                    i++;
                }
            }
            return strArr;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    @Nullable
    public static File getSoFile(String str) {
        String mapLibName = MergedSoMapping.mapLibName(str);
        if (mapLibName != null) {
            str = mapLibName;
        }
        String mapLibraryName = System.mapLibraryName(str);
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources != null) {
                int i = 0;
                while (i < sSoSources.length) {
                    try {
                        File soFileByName = sSoSources[i].getSoFileByName(mapLibraryName);
                        if (soFileByName != null) {
                            return soFileByName;
                        }
                        i++;
                    } catch (IOException unused) {
                    }
                }
            }
            sSoSourcesLock.readLock().unlock();
            return null;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static boolean loadLibrary(String str) {
        return loadLibrary(str, 0);
    }

    public static boolean loadLibrary(String str, int i) throws UnsatisfiedLinkError {
        SystemLoadLibraryWrapper systemLoadLibraryWrapper;
        Boolean loadLibraryOnNonAndroid = loadLibraryOnNonAndroid(str);
        if (loadLibraryOnNonAndroid != null) {
            return loadLibraryOnNonAndroid.booleanValue();
        }
        int i2 = sAppType;
        if ((i2 == 2 || i2 == 3) && (systemLoadLibraryWrapper = sSystemLoadLibraryWrapper) != null) {
            systemLoadLibraryWrapper.loadLibrary(str);
            return true;
        }
        String mapLibName = MergedSoMapping.mapLibName(str);
        return loadLibraryBySoName(System.mapLibraryName(mapLibName != null ? mapLibName : str), str, mapLibName, i, (StrictMode.ThreadPolicy) null);
    }

    @Nullable
    private static Boolean loadLibraryOnNonAndroid(String str) {
        Boolean valueOf;
        if (sSoSources != null) {
            return null;
        }
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    assertInitialized();
                } else {
                    synchronized (SoLoader.class) {
                        boolean z = !sLoadedLibraries.contains(str);
                        if (z) {
                            if (sSystemLoadLibraryWrapper != null) {
                                sSystemLoadLibraryWrapper.loadLibrary(str);
                            } else {
                                System.loadLibrary(str);
                            }
                        }
                        valueOf = Boolean.valueOf(z);
                    }
                    sSoSourcesLock.readLock().unlock();
                    return valueOf;
                }
            }
            sSoSourcesLock.readLock().unlock();
            return null;
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    static void loadLibraryBySoName(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        loadLibraryBySoNameImpl(str, (String) null, (String) null, i, threadPolicy);
    }

    private static boolean loadLibraryBySoName(String str, @Nullable String str2, @Nullable String str3, int i, @Nullable StrictMode.ThreadPolicy threadPolicy) {
        boolean z;
        boolean z2 = false;
        do {
            try {
                z2 = loadLibraryBySoNameImpl(str, str2, str3, i, threadPolicy);
                z = false;
                continue;
            } catch (UnsatisfiedLinkError e) {
                int i2 = sSoSourcesVersion.get();
                sSoSourcesLock.writeLock().lock();
                try {
                    if (sApplicationSoSource == null || !sApplicationSoSource.checkAndMaybeUpdate()) {
                        z = false;
                    } else {
                        Log.w(TAG, "sApplicationSoSource updated during load: " + str + ", attempting load again.");
                        sSoSourcesVersion.getAndIncrement();
                        z = true;
                    }
                    sSoSourcesLock.writeLock().unlock();
                    if (sSoSourcesVersion.get() == i2) {
                        throw e;
                    }
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                } catch (Throwable th) {
                    sSoSourcesLock.writeLock().unlock();
                    throw th;
                }
            }
        } while (z);
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0153, code lost:
        if (SYSTRACE_LIBRARY_LOADING != false) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0155, code lost:
        com.facebook.soloader.Api18TraceUtils.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0158, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0159, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x015a, code lost:
        sSoSourcesLock.readLock().unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0165, code lost:
        return !r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0169, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x016a, code lost:
        sSoSourcesLock.readLock().unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0173, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003d, code lost:
        sSoSourcesLock.readLock().lock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
        if (r1 != false) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0051, code lost:
        if (sLoadedLibraries.contains(r9) == false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0053, code lost:
        if (r11 != null) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0055, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0060, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0061, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0063, code lost:
        if (r1 != false) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x006b, code lost:
        if (android.util.Log.isLoggable(TAG, 3) == false) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006d, code lost:
        android.util.Log.d(TAG, "About to load: " + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0083, code lost:
        doLoadLibraryBySoName(r9, r12, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x008c, code lost:
        if (android.util.Log.isLoggable(TAG, 3) == false) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x008e, code lost:
        android.util.Log.d(TAG, "Loaded: " + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a4, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        sLoadedLibraries.add(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00aa, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00af, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00b0, code lost:
        r10 = r9.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00b4, code lost:
        if (r10 == null) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00cd, code lost:
        throw new com.facebook.soloader.SoLoader.WrongAbiError(r9, r10.substring(r10.lastIndexOf("unexpected e_machine:")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00ce, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00d4, code lost:
        if ((r12 & 16) != 0) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00da, code lost:
        if (android.text.TextUtils.isEmpty(r10) != false) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00e2, code lost:
        if (sLoadedAndMergedLibraries.contains(r10) == false) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00e4, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00e5, code lost:
        if (r11 == null) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00e7, code lost:
        if (r2 != false) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x00eb, code lost:
        if (SYSTRACE_LIBRARY_LOADING == false) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x00ed, code lost:
        com.facebook.soloader.Api18TraceUtils.beginTraceSection("MergedSoMapping.invokeJniOnload[", r10, "]");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x00fa, code lost:
        if (android.util.Log.isLoggable(TAG, 3) == false) goto L_0x011a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x00fc, code lost:
        android.util.Log.d(TAG, "About to merge: " + r10 + " / " + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x011a, code lost:
        com.facebook.soloader.MergedSoMapping.invokeJniOnload(r10);
        sLoadedAndMergedLibraries.add(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0124, code lost:
        if (SYSTRACE_LIBRARY_LOADING == false) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0126, code lost:
        com.facebook.soloader.Api18TraceUtils.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x012a, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x012c, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0150, code lost:
        throw new java.lang.RuntimeException("Failed to call JNI_OnLoad from '" + r10 + "', which has been merged into '" + r9 + "'.  See comment for details.", r11);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean loadLibraryBySoNameImpl(java.lang.String r9, @javax.annotation.Nullable java.lang.String r10, @javax.annotation.Nullable java.lang.String r11, int r12, @javax.annotation.Nullable android.os.StrictMode.ThreadPolicy r13) {
        /*
            java.lang.Class<com.facebook.soloader.SoLoader> r0 = com.facebook.soloader.SoLoader.class
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            r2 = 0
            if (r1 != 0) goto L_0x0012
            java.util.Set<java.lang.String> r1 = sLoadedAndMergedLibraries
            boolean r1 = r1.contains(r10)
            if (r1 == 0) goto L_0x0012
            return r2
        L_0x0012:
            monitor-enter(r0)
            java.util.HashSet<java.lang.String> r1 = sLoadedLibraries     // Catch:{ all -> 0x0174 }
            boolean r1 = r1.contains(r9)     // Catch:{ all -> 0x0174 }
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r11 != 0) goto L_0x0020
            monitor-exit(r0)     // Catch:{ all -> 0x0174 }
            return r2
        L_0x0020:
            r1 = 1
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            java.util.Map<java.lang.String, java.lang.Object> r4 = sLoadingLibraries     // Catch:{ all -> 0x0174 }
            boolean r4 = r4.containsKey(r9)     // Catch:{ all -> 0x0174 }
            if (r4 == 0) goto L_0x0032
            java.util.Map<java.lang.String, java.lang.Object> r4 = sLoadingLibraries     // Catch:{ all -> 0x0174 }
            java.lang.Object r4 = r4.get(r9)     // Catch:{ all -> 0x0174 }
            goto L_0x003c
        L_0x0032:
            java.lang.Object r4 = new java.lang.Object     // Catch:{ all -> 0x0174 }
            r4.<init>()     // Catch:{ all -> 0x0174 }
            java.util.Map<java.lang.String, java.lang.Object> r5 = sLoadingLibraries     // Catch:{ all -> 0x0174 }
            r5.put(r9, r4)     // Catch:{ all -> 0x0174 }
        L_0x003c:
            monitor-exit(r0)     // Catch:{ all -> 0x0174 }
            java.util.concurrent.locks.ReentrantReadWriteLock r5 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r5 = r5.readLock()
            r5.lock()
            monitor-enter(r4)     // Catch:{ all -> 0x0169 }
            r5 = 3
            if (r1 != 0) goto L_0x00d2
            monitor-enter(r0)     // Catch:{ all -> 0x0166 }
            java.util.HashSet<java.lang.String> r6 = sLoadedLibraries     // Catch:{ all -> 0x00cf }
            boolean r6 = r6.contains(r9)     // Catch:{ all -> 0x00cf }
            if (r6 == 0) goto L_0x0062
            if (r11 != 0) goto L_0x0061
            monitor-exit(r0)     // Catch:{ all -> 0x00cf }
            monitor-exit(r4)     // Catch:{ all -> 0x0166 }
            java.util.concurrent.locks.ReentrantReadWriteLock r9 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r9 = r9.readLock()
            r9.unlock()
            return r2
        L_0x0061:
            r1 = 1
        L_0x0062:
            monitor-exit(r0)     // Catch:{ all -> 0x00cf }
            if (r1 != 0) goto L_0x00d2
            java.lang.String r6 = "SoLoader"
            boolean r6 = android.util.Log.isLoggable(r6, r5)     // Catch:{ UnsatisfiedLinkError -> 0x00af }
            if (r6 == 0) goto L_0x0083
            java.lang.String r6 = "SoLoader"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x00af }
            r7.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x00af }
            java.lang.String r8 = "About to load: "
            r7.append(r8)     // Catch:{ UnsatisfiedLinkError -> 0x00af }
            r7.append(r9)     // Catch:{ UnsatisfiedLinkError -> 0x00af }
            java.lang.String r7 = r7.toString()     // Catch:{ UnsatisfiedLinkError -> 0x00af }
            android.util.Log.d(r6, r7)     // Catch:{ UnsatisfiedLinkError -> 0x00af }
        L_0x0083:
            doLoadLibraryBySoName(r9, r12, r13)     // Catch:{ UnsatisfiedLinkError -> 0x00af }
            java.lang.String r13 = "SoLoader"
            boolean r13 = android.util.Log.isLoggable(r13, r5)     // Catch:{ all -> 0x0166 }
            if (r13 == 0) goto L_0x00a4
            java.lang.String r13 = "SoLoader"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0166 }
            r6.<init>()     // Catch:{ all -> 0x0166 }
            java.lang.String r7 = "Loaded: "
            r6.append(r7)     // Catch:{ all -> 0x0166 }
            r6.append(r9)     // Catch:{ all -> 0x0166 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0166 }
            android.util.Log.d(r13, r6)     // Catch:{ all -> 0x0166 }
        L_0x00a4:
            monitor-enter(r0)     // Catch:{ all -> 0x0166 }
            java.util.HashSet<java.lang.String> r13 = sLoadedLibraries     // Catch:{ all -> 0x00ac }
            r13.add(r9)     // Catch:{ all -> 0x00ac }
            monitor-exit(r0)     // Catch:{ all -> 0x00ac }
            goto L_0x00d2
        L_0x00ac:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ac }
            throw r9     // Catch:{ all -> 0x0166 }
        L_0x00af:
            r9 = move-exception
            java.lang.String r10 = r9.getMessage()     // Catch:{ all -> 0x0166 }
            if (r10 == 0) goto L_0x00ce
            java.lang.String r11 = "unexpected e_machine:"
            boolean r11 = r10.contains(r11)     // Catch:{ all -> 0x0166 }
            if (r11 == 0) goto L_0x00ce
            java.lang.String r11 = "unexpected e_machine:"
            int r11 = r10.lastIndexOf(r11)     // Catch:{ all -> 0x0166 }
            java.lang.String r10 = r10.substring(r11)     // Catch:{ all -> 0x0166 }
            com.facebook.soloader.SoLoader$WrongAbiError r11 = new com.facebook.soloader.SoLoader$WrongAbiError     // Catch:{ all -> 0x0166 }
            r11.<init>(r9, r10)     // Catch:{ all -> 0x0166 }
            throw r11     // Catch:{ all -> 0x0166 }
        L_0x00ce:
            throw r9     // Catch:{ all -> 0x0166 }
        L_0x00cf:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00cf }
            throw r9     // Catch:{ all -> 0x0166 }
        L_0x00d2:
            r12 = r12 & 16
            if (r12 != 0) goto L_0x0159
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0166 }
            if (r12 != 0) goto L_0x00e5
            java.util.Set<java.lang.String> r12 = sLoadedAndMergedLibraries     // Catch:{ all -> 0x0166 }
            boolean r12 = r12.contains(r10)     // Catch:{ all -> 0x0166 }
            if (r12 == 0) goto L_0x00e5
            r2 = 1
        L_0x00e5:
            if (r11 == 0) goto L_0x0159
            if (r2 != 0) goto L_0x0159
            boolean r11 = SYSTRACE_LIBRARY_LOADING     // Catch:{ all -> 0x0166 }
            if (r11 == 0) goto L_0x00f4
            java.lang.String r11 = "MergedSoMapping.invokeJniOnload["
            java.lang.String r12 = "]"
            com.facebook.soloader.Api18TraceUtils.beginTraceSection(r11, r10, r12)     // Catch:{ all -> 0x0166 }
        L_0x00f4:
            java.lang.String r11 = "SoLoader"
            boolean r11 = android.util.Log.isLoggable(r11, r5)     // Catch:{ UnsatisfiedLinkError -> 0x012c }
            if (r11 == 0) goto L_0x011a
            java.lang.String r11 = "SoLoader"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x012c }
            r12.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x012c }
            java.lang.String r13 = "About to merge: "
            r12.append(r13)     // Catch:{ UnsatisfiedLinkError -> 0x012c }
            r12.append(r10)     // Catch:{ UnsatisfiedLinkError -> 0x012c }
            java.lang.String r13 = " / "
            r12.append(r13)     // Catch:{ UnsatisfiedLinkError -> 0x012c }
            r12.append(r9)     // Catch:{ UnsatisfiedLinkError -> 0x012c }
            java.lang.String r12 = r12.toString()     // Catch:{ UnsatisfiedLinkError -> 0x012c }
            android.util.Log.d(r11, r12)     // Catch:{ UnsatisfiedLinkError -> 0x012c }
        L_0x011a:
            com.facebook.soloader.MergedSoMapping.invokeJniOnload(r10)     // Catch:{ UnsatisfiedLinkError -> 0x012c }
            java.util.Set<java.lang.String> r11 = sLoadedAndMergedLibraries     // Catch:{ UnsatisfiedLinkError -> 0x012c }
            r11.add(r10)     // Catch:{ UnsatisfiedLinkError -> 0x012c }
            boolean r9 = SYSTRACE_LIBRARY_LOADING     // Catch:{ all -> 0x0166 }
            if (r9 == 0) goto L_0x0159
            com.facebook.soloader.Api18TraceUtils.endSection()     // Catch:{ all -> 0x0166 }
            goto L_0x0159
        L_0x012a:
            r9 = move-exception
            goto L_0x0151
        L_0x012c:
            r11 = move-exception
            java.lang.RuntimeException r12 = new java.lang.RuntimeException     // Catch:{ all -> 0x012a }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
            r13.<init>()     // Catch:{ all -> 0x012a }
            java.lang.String r0 = "Failed to call JNI_OnLoad from '"
            r13.append(r0)     // Catch:{ all -> 0x012a }
            r13.append(r10)     // Catch:{ all -> 0x012a }
            java.lang.String r10 = "', which has been merged into '"
            r13.append(r10)     // Catch:{ all -> 0x012a }
            r13.append(r9)     // Catch:{ all -> 0x012a }
            java.lang.String r9 = "'.  See comment for details."
            r13.append(r9)     // Catch:{ all -> 0x012a }
            java.lang.String r9 = r13.toString()     // Catch:{ all -> 0x012a }
            r12.<init>(r9, r11)     // Catch:{ all -> 0x012a }
            throw r12     // Catch:{ all -> 0x012a }
        L_0x0151:
            boolean r10 = SYSTRACE_LIBRARY_LOADING     // Catch:{ all -> 0x0166 }
            if (r10 == 0) goto L_0x0158
            com.facebook.soloader.Api18TraceUtils.endSection()     // Catch:{ all -> 0x0166 }
        L_0x0158:
            throw r9     // Catch:{ all -> 0x0166 }
        L_0x0159:
            monitor-exit(r4)     // Catch:{ all -> 0x0166 }
            java.util.concurrent.locks.ReentrantReadWriteLock r9 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r9 = r9.readLock()
            r9.unlock()
            r9 = r1 ^ 1
            return r9
        L_0x0166:
            r9 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0166 }
            throw r9     // Catch:{ all -> 0x0169 }
        L_0x0169:
            r9 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock r10 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r10 = r10.readLock()
            r10.unlock()
            throw r9
        L_0x0174:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0174 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.loadLibraryBySoNameImpl(java.lang.String, java.lang.String, java.lang.String, int, android.os.StrictMode$ThreadPolicy):boolean");
    }

    public static File unpackLibraryAndDependencies(String str) throws UnsatisfiedLinkError {
        assertInitialized();
        try {
            return unpackLibraryBySoName(System.mapLibraryName(str));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x013f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void doLoadLibraryBySoName(java.lang.String r12, int r13, @javax.annotation.Nullable android.os.StrictMode.ThreadPolicy r14) throws java.lang.UnsatisfiedLinkError {
        /*
            java.lang.String r0 = " result: "
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()
            r1.lock()
            com.facebook.soloader.SoSource[] r1 = sSoSources     // Catch:{ all -> 0x0192 }
            java.lang.String r2 = "couldn't find DSO to load: "
            java.lang.String r3 = "SoLoader"
            if (r1 == 0) goto L_0x0164
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()
            r1.unlock()
            r1 = 1
            r4 = 0
            if (r14 != 0) goto L_0x0026
            android.os.StrictMode$ThreadPolicy r14 = android.os.StrictMode.allowThreadDiskReads()
            r5 = 1
            goto L_0x0027
        L_0x0026:
            r5 = 0
        L_0x0027:
            boolean r6 = SYSTRACE_LIBRARY_LOADING
            if (r6 == 0) goto L_0x0032
            java.lang.String r6 = "SoLoader.loadLibrary["
            java.lang.String r7 = "]"
            com.facebook.soloader.Api18TraceUtils.beginTraceSection(r6, r12, r7)
        L_0x0032:
            r6 = 3
            java.util.concurrent.locks.ReentrantReadWriteLock r7 = sSoSourcesLock     // Catch:{ all -> 0x011b }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r7 = r7.readLock()     // Catch:{ all -> 0x011b }
            r7.lock()     // Catch:{ all -> 0x011b }
            r7 = 0
            r8 = 0
        L_0x003e:
            if (r7 != 0) goto L_0x0092
            com.facebook.soloader.SoSource[] r9 = sSoSources     // Catch:{ all -> 0x0086 }
            int r9 = r9.length     // Catch:{ all -> 0x0086 }
            if (r8 >= r9) goto L_0x0092
            com.facebook.soloader.SoSource[] r9 = sSoSources     // Catch:{ all -> 0x0086 }
            r9 = r9[r8]     // Catch:{ all -> 0x0086 }
            int r7 = r9.loadLibrary(r12, r13, r14)     // Catch:{ all -> 0x0086 }
            if (r7 != r6) goto L_0x0083
            com.facebook.soloader.UnpackingSoSource[] r9 = sBackupSoSources     // Catch:{ all -> 0x0086 }
            if (r9 == 0) goto L_0x0083
            boolean r8 = android.util.Log.isLoggable(r3, r6)     // Catch:{ all -> 0x0086 }
            if (r8 == 0) goto L_0x006d
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0086 }
            r8.<init>()     // Catch:{ all -> 0x0086 }
            java.lang.String r9 = "Trying backup SoSource for "
            r8.append(r9)     // Catch:{ all -> 0x0086 }
            r8.append(r12)     // Catch:{ all -> 0x0086 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0086 }
            android.util.Log.d(r3, r8)     // Catch:{ all -> 0x0086 }
        L_0x006d:
            com.facebook.soloader.UnpackingSoSource[] r8 = sBackupSoSources     // Catch:{ all -> 0x0086 }
            int r9 = r8.length     // Catch:{ all -> 0x0086 }
            r10 = 0
        L_0x0071:
            if (r10 >= r9) goto L_0x0092
            r11 = r8[r10]     // Catch:{ all -> 0x0086 }
            r11.prepare((java.lang.String) r12)     // Catch:{ all -> 0x0086 }
            int r11 = r11.loadLibrary(r12, r13, r14)     // Catch:{ all -> 0x0086 }
            if (r11 != r1) goto L_0x0080
            r7 = r11
            goto L_0x0092
        L_0x0080:
            int r10 = r10 + 1
            goto L_0x0071
        L_0x0083:
            int r8 = r8 + 1
            goto L_0x003e
        L_0x0086:
            r13 = move-exception
            r4 = r7
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = sSoSourcesLock     // Catch:{ all -> 0x011b }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()     // Catch:{ all -> 0x011b }
            r1.unlock()     // Catch:{ all -> 0x011b }
            throw r13     // Catch:{ all -> 0x011b }
        L_0x0092:
            java.util.concurrent.locks.ReentrantReadWriteLock r13 = sSoSourcesLock     // Catch:{ all -> 0x0118 }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r13 = r13.readLock()     // Catch:{ all -> 0x0118 }
            r13.unlock()     // Catch:{ all -> 0x0118 }
            boolean r13 = SYSTRACE_LIBRARY_LOADING
            if (r13 == 0) goto L_0x00a2
            com.facebook.soloader.Api18TraceUtils.endSection()
        L_0x00a2:
            if (r5 == 0) goto L_0x00a7
            android.os.StrictMode.setThreadPolicy(r14)
        L_0x00a7:
            if (r7 == 0) goto L_0x00ab
            if (r7 != r6) goto L_0x012d
        L_0x00ab:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r2)
            r13.append(r12)
            java.util.concurrent.locks.ReentrantReadWriteLock r12 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r12 = r12.readLock()
            r12.lock()
        L_0x00bf:
            com.facebook.soloader.SoSource[] r12 = sSoSources
            int r12 = r12.length
            if (r4 >= r12) goto L_0x00df
            java.lang.String r12 = "\n\tSoSource "
            r13.append(r12)
            r13.append(r4)
            java.lang.String r12 = ": "
            r13.append(r12)
            com.facebook.soloader.SoSource[] r12 = sSoSources
            r12 = r12[r4]
            java.lang.String r12 = r12.toString()
            r13.append(r12)
            int r4 = r4 + 1
            goto L_0x00bf
        L_0x00df:
            com.facebook.soloader.ApplicationSoSource r12 = sApplicationSoSource
            if (r12 == 0) goto L_0x00fc
            android.content.Context r12 = r12.getUpdatedContext()
            java.io.File r12 = com.facebook.soloader.ApplicationSoSource.getNativeLibDirFromContext(r12)
            java.lang.String r14 = "\n\tNative lib dir: "
            r13.append(r14)
            java.lang.String r12 = r12.getAbsolutePath()
            r13.append(r12)
            java.lang.String r12 = "\n"
            r13.append(r12)
        L_0x00fc:
            java.util.concurrent.locks.ReentrantReadWriteLock r12 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r12 = r12.readLock()
            r12.unlock()
            r13.append(r0)
            r13.append(r7)
            java.lang.String r12 = r13.toString()
            android.util.Log.e(r3, r12)
            java.lang.UnsatisfiedLinkError r13 = new java.lang.UnsatisfiedLinkError
            r13.<init>(r12)
            throw r13
        L_0x0118:
            r13 = move-exception
            r4 = r7
            goto L_0x011c
        L_0x011b:
            r13 = move-exception
        L_0x011c:
            boolean r1 = SYSTRACE_LIBRARY_LOADING
            if (r1 == 0) goto L_0x0123
            com.facebook.soloader.Api18TraceUtils.endSection()
        L_0x0123:
            if (r5 == 0) goto L_0x0128
            android.os.StrictMode.setThreadPolicy(r14)
        L_0x0128:
            if (r4 == 0) goto L_0x012e
            if (r4 != r6) goto L_0x012d
            goto L_0x012e
        L_0x012d:
            return
        L_0x012e:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r2)
            r14.append(r12)
            java.lang.String r12 = r13.getMessage()
            if (r12 != 0) goto L_0x0143
            java.lang.String r12 = r13.toString()
        L_0x0143:
            java.lang.String r1 = " caused by: "
            r14.append(r1)
            r14.append(r12)
            r13.printStackTrace()
            r14.append(r0)
            r14.append(r4)
            java.lang.String r12 = r14.toString()
            android.util.Log.e(r3, r12)
            java.lang.UnsatisfiedLinkError r14 = new java.lang.UnsatisfiedLinkError
            r14.<init>(r12)
            r14.initCause(r13)
            throw r14
        L_0x0164:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0192 }
            r13.<init>()     // Catch:{ all -> 0x0192 }
            java.lang.String r14 = "Could not load: "
            r13.append(r14)     // Catch:{ all -> 0x0192 }
            r13.append(r12)     // Catch:{ all -> 0x0192 }
            java.lang.String r14 = " because no SO source exists"
            r13.append(r14)     // Catch:{ all -> 0x0192 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0192 }
            android.util.Log.e(r3, r13)     // Catch:{ all -> 0x0192 }
            java.lang.UnsatisfiedLinkError r13 = new java.lang.UnsatisfiedLinkError     // Catch:{ all -> 0x0192 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0192 }
            r14.<init>()     // Catch:{ all -> 0x0192 }
            r14.append(r2)     // Catch:{ all -> 0x0192 }
            r14.append(r12)     // Catch:{ all -> 0x0192 }
            java.lang.String r12 = r14.toString()     // Catch:{ all -> 0x0192 }
            r13.<init>(r12)     // Catch:{ all -> 0x0192 }
            throw r13     // Catch:{ all -> 0x0192 }
        L_0x0192:
            r12 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock r13 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r13 = r13.readLock()
            r13.unlock()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.doLoadLibraryBySoName(java.lang.String, int, android.os.StrictMode$ThreadPolicy):void");
    }

    @Nullable
    public static String makeNonZipPath(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(CertificateUtil.DELIMITER);
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            if (!str2.contains("!")) {
                arrayList.add(str2);
            }
        }
        return TextUtils.join(CertificateUtil.DELIMITER, arrayList);
    }

    static File unpackLibraryBySoName(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            for (SoSource unpackLibrary : sSoSources) {
                File unpackLibrary2 = unpackLibrary.unpackLibrary(str);
                if (unpackLibrary2 != null) {
                    return unpackLibrary2;
                }
            }
            sSoSourcesLock.readLock().unlock();
            throw new FileNotFoundException(str);
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    private static void assertInitialized() {
        if (!isInitialized()) {
            throw new IllegalStateException("SoLoader.init() not yet called");
        }
    }

    public static boolean isInitialized() {
        boolean z = true;
        if (sSoSources != null) {
            return true;
        }
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources == null) {
                z = false;
            }
            return z;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static int getSoSourcesVersion() {
        return sSoSourcesVersion.get();
    }

    public static void prependSoSource(SoSource soSource) throws IOException {
        sSoSourcesLock.writeLock().lock();
        try {
            assertInitialized();
            soSource.prepare(makePrepareFlags());
            SoSource[] soSourceArr = new SoSource[(sSoSources.length + 1)];
            soSourceArr[0] = soSource;
            System.arraycopy(sSoSources, 0, soSourceArr, 1, sSoSources.length);
            sSoSources = soSourceArr;
            sSoSourcesVersion.getAndIncrement();
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Prepended to SO sources: " + soSource);
            }
        } finally {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    public static String makeLdLibraryPath() {
        sSoSourcesLock.readLock().lock();
        try {
            assertInitialized();
            ArrayList arrayList = new ArrayList();
            SoSource[] soSourceArr = sSoSources;
            if (soSourceArr != null) {
                for (SoSource addToLdLibraryPath : soSourceArr) {
                    addToLdLibraryPath.addToLdLibraryPath(arrayList);
                }
            }
            String join = TextUtils.join(CertificateUtil.DELIMITER, arrayList);
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "makeLdLibraryPath final path: " + join);
            }
            return join;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static boolean areSoSourcesAbisSupported() {
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources != null) {
                String[] supportedAbis = SysUtil.getSupportedAbis();
                for (SoSource soSourceAbis : sSoSources) {
                    String[] soSourceAbis2 = soSourceAbis.getSoSourceAbis();
                    int length = soSourceAbis2.length;
                    int i = 0;
                    while (i < length) {
                        String str = soSourceAbis2[i];
                        boolean z = false;
                        for (int i2 = 0; i2 < supportedAbis.length && !z; i2++) {
                            z = str.equals(supportedAbis[i2]);
                        }
                        if (!z) {
                            Log.e(TAG, "abi not supported: " + str);
                        } else {
                            i++;
                        }
                    }
                }
                sSoSourcesLock.readLock().unlock();
                return true;
            }
            return false;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static boolean useDepsFile(Context context, boolean z, boolean z2) {
        return NativeDeps.useDepsFile(context, z, z2);
    }

    public static int getLoadedLibrariesCount() {
        return sLoadedLibraries.size();
    }
}
