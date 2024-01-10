package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.DisplayMetrics;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.DateUtils;
import io.sentry.EventProcessor;
import io.sentry.ILogger;
import io.sentry.SentryEvent;
import io.sentry.SentryLevel;
import io.sentry.android.core.util.ConnectivityChecker;
import io.sentry.android.core.util.DeviceOrientations;
import io.sentry.android.core.util.MainThreadChecker;
import io.sentry.android.core.util.RootChecker;
import io.sentry.protocol.App;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.DebugMeta;
import io.sentry.protocol.Device;
import io.sentry.protocol.OperatingSystem;
import io.sentry.protocol.SentryThread;
import io.sentry.protocol.User;
import io.sentry.util.ApplyScopeUtils;
import io.sentry.util.Objects;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

final class DefaultAndroidEventProcessor implements EventProcessor {
    static final String ANDROID_ID = "androidId";
    static final String EMULATOR = "emulator";
    static final String KERNEL_VERSION = "kernelVersion";
    static final String PROGUARD_UUID = "proGuardUuids";
    static final String ROOTED = "rooted";
    static final String SIDE_LOADED = "sideLoaded";
    private static final Date appStartTime = DateUtils.getCurrentDateTime();
    private final IBuildInfoProvider buildInfoProvider;
    final Context context;
    final Future<Map<String, Object>> contextData;
    private final ILogger logger;
    private final RootChecker rootChecker;

    public DefaultAndroidEventProcessor(Context context2, ILogger iLogger, IBuildInfoProvider iBuildInfoProvider) {
        this(context2, iLogger, iBuildInfoProvider, new RootChecker(context2, iBuildInfoProvider, iLogger));
    }

    DefaultAndroidEventProcessor(Context context2, ILogger iLogger, IBuildInfoProvider iBuildInfoProvider, RootChecker rootChecker2) {
        this.context = (Context) Objects.requireNonNull(context2, "The application context is required.");
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "The Logger is required.");
        this.buildInfoProvider = (IBuildInfoProvider) Objects.requireNonNull(iBuildInfoProvider, "The BuildInfoProvider is required.");
        this.rootChecker = (RootChecker) Objects.requireNonNull(rootChecker2, "The RootChecker is required.");
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.contextData = newSingleThreadExecutor.submit(new Callable() {
            public final Object call() {
                return DefaultAndroidEventProcessor.this.lambda$new$0$DefaultAndroidEventProcessor();
            }
        });
        newSingleThreadExecutor.shutdown();
    }

    /* access modifiers changed from: private */
    /* renamed from: loadContextData */
    public Map<String, Object> lambda$new$0$DefaultAndroidEventProcessor() {
        HashMap hashMap = new HashMap();
        String[] proguardUUIDs = getProguardUUIDs();
        if (proguardUUIDs != null) {
            hashMap.put(PROGUARD_UUID, proguardUUIDs);
        }
        hashMap.put(ROOTED, Boolean.valueOf(this.rootChecker.isDeviceRooted()));
        String androidId = getAndroidId();
        if (androidId != null) {
            hashMap.put(ANDROID_ID, androidId);
        }
        String kernelVersion = getKernelVersion();
        if (kernelVersion != null) {
            hashMap.put(KERNEL_VERSION, kernelVersion);
        }
        hashMap.put(EMULATOR, isEmulator());
        Map<String, String> sideLoadedInfo = getSideLoadedInfo();
        if (sideLoadedInfo != null) {
            hashMap.put(SIDE_LOADED, sideLoadedInfo);
        }
        return hashMap;
    }

    public SentryEvent process(SentryEvent sentryEvent, Object obj) {
        if (ApplyScopeUtils.shouldApplyScopeData(obj)) {
            processNonCachedEvent(sentryEvent);
        } else {
            this.logger.log(SentryLevel.DEBUG, "Event was cached so not applying data relevant to the current app execution/version: %s", sentryEvent.getEventId());
        }
        User user = sentryEvent.getUser();
        if (user == null) {
            sentryEvent.setUser(getDefaultUser());
        } else if (user.getId() == null) {
            user.setId(getDeviceId());
        }
        if (sentryEvent.getContexts().getDevice() == null) {
            sentryEvent.getContexts().setDevice(getDevice());
        }
        if (sentryEvent.getContexts().getOperatingSystem() == null) {
            sentryEvent.getContexts().setOperatingSystem(getOperatingSystem());
        }
        setSideLoadedInfo(sentryEvent);
        return sentryEvent;
    }

    private void processNonCachedEvent(SentryEvent sentryEvent) {
        App app = sentryEvent.getContexts().getApp();
        if (app == null) {
            app = new App();
        }
        setAppExtras(app);
        mergeDebugImages(sentryEvent);
        PackageInfo packageInfo = ContextUtils.getPackageInfo(this.context, this.logger);
        if (packageInfo != null) {
            String versionCode = ContextUtils.getVersionCode(packageInfo);
            if (sentryEvent.getDist() == null) {
                sentryEvent.setDist(versionCode);
            }
            setAppPackageInfo(app, packageInfo);
        }
        sentryEvent.getContexts().setApp(app);
        if (sentryEvent.getThreads() != null) {
            for (SentryThread next : sentryEvent.getThreads()) {
                next.setCurrent(Boolean.valueOf(MainThreadChecker.isMainThread(next)));
            }
        }
    }

    private void mergeDebugImages(SentryEvent sentryEvent) {
        List<DebugImage> debugImages = getDebugImages();
        if (debugImages != null) {
            DebugMeta debugMeta = sentryEvent.getDebugMeta();
            if (debugMeta == null) {
                debugMeta = new DebugMeta();
            }
            if (debugMeta.getImages() == null) {
                debugMeta.setImages(debugImages);
            } else {
                debugMeta.getImages().addAll(debugImages);
            }
            sentryEvent.setDebugMeta(debugMeta);
        }
    }

    private List<DebugImage> getDebugImages() {
        ArrayList arrayList = null;
        try {
            Object obj = this.contextData.get().get(PROGUARD_UUID);
            String[] strArr = obj != null ? (String[]) obj : null;
            if (!(strArr == null || strArr.length == 0)) {
                arrayList = new ArrayList();
                for (String uuid : strArr) {
                    DebugImage debugImage = new DebugImage();
                    debugImage.setType("proguard");
                    debugImage.setUuid(uuid);
                    arrayList.add(debugImage);
                }
            }
            return arrayList;
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting Proguard UUIDs.", (Throwable) e);
            return null;
        }
    }

    private void setAppExtras(App app) {
        app.setAppName(getApplicationName());
        app.setAppStartTime(appStartTime);
    }

    private String getAbi() {
        return Build.CPU_ABI;
    }

    private String getAbi2() {
        return Build.CPU_ABI2;
    }

    private void setArchitectures(Device device) {
        if (Build.VERSION.SDK_INT >= 21) {
            device.setArchs(Build.SUPPORTED_ABIS);
            return;
        }
        device.setArchs(new String[]{getAbi(), getAbi2()});
    }

    private Long getMemorySize(ActivityManager.MemoryInfo memoryInfo) {
        if (Build.VERSION.SDK_INT >= 16) {
            return Long.valueOf(memoryInfo.totalMem);
        }
        return Long.valueOf(Runtime.getRuntime().totalMemory());
    }

    private Device getDevice() {
        boolean z;
        Device device = new Device();
        device.setName(getDeviceName());
        device.setManufacturer(Build.MANUFACTURER);
        device.setBrand(Build.BRAND);
        device.setFamily(getFamily());
        device.setModel(Build.MODEL);
        device.setModelId(Build.ID);
        setArchitectures(device);
        Intent batteryIntent = getBatteryIntent();
        if (batteryIntent != null) {
            device.setBatteryLevel(getBatteryLevel(batteryIntent));
            device.setCharging(isCharging(batteryIntent));
            device.setBatteryTemperature(getBatteryTemperature(batteryIntent));
        }
        int i = AnonymousClass1.$SwitchMap$io$sentry$android$core$util$ConnectivityChecker$Status[ConnectivityChecker.getConnectionStatus(this.context, this.logger).ordinal()];
        if (i == 1) {
            z = false;
        } else if (i != 2) {
            z = null;
        } else {
            z = true;
        }
        device.setOnline(z);
        device.setOrientation(getOrientation());
        try {
            Object obj = this.contextData.get().get(EMULATOR);
            if (obj != null) {
                device.setSimulator((Boolean) obj);
            }
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting emulator.", (Throwable) e);
        }
        ActivityManager.MemoryInfo memInfo = getMemInfo();
        if (memInfo != null) {
            device.setMemorySize(getMemorySize(memInfo));
            device.setFreeMemory(Long.valueOf(memInfo.availMem));
            device.setLowMemory(Boolean.valueOf(memInfo.lowMemory));
        }
        File externalFilesDir = this.context.getExternalFilesDir((String) null);
        if (externalFilesDir != null) {
            StatFs statFs = new StatFs(externalFilesDir.getPath());
            device.setStorageSize(getTotalInternalStorage(statFs));
            device.setFreeStorage(getUnusedInternalStorage(statFs));
        }
        StatFs externalStorageStat = getExternalStorageStat(externalFilesDir);
        if (externalStorageStat != null) {
            device.setExternalStorageSize(getTotalExternalStorage(externalStorageStat));
            device.setExternalFreeStorage(getUnusedExternalStorage(externalStorageStat));
        }
        DisplayMetrics displayMetrics = getDisplayMetrics();
        if (displayMetrics != null) {
            device.setScreenWidthPixels(Integer.valueOf(displayMetrics.widthPixels));
            device.setScreenHeightPixels(Integer.valueOf(displayMetrics.heightPixels));
            device.setScreenDensity(Float.valueOf(displayMetrics.density));
            device.setScreenDpi(Integer.valueOf(displayMetrics.densityDpi));
        }
        device.setBootTime(getBootTime());
        device.setTimezone(getTimeZone());
        if (device.getId() == null) {
            device.setId(getDeviceId());
        }
        if (device.getLanguage() == null) {
            device.setLanguage(Locale.getDefault().toString());
        }
        if (device.getConnectionType() == null) {
            device.setConnectionType(ConnectivityChecker.getConnectionType(this.context, this.logger, this.buildInfoProvider));
        }
        return device;
    }

    /* renamed from: io.sentry.android.core.DefaultAndroidEventProcessor$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$sentry$android$core$util$ConnectivityChecker$Status;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.sentry.android.core.util.ConnectivityChecker$Status[] r0 = io.sentry.android.core.util.ConnectivityChecker.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$sentry$android$core$util$ConnectivityChecker$Status = r0
                io.sentry.android.core.util.ConnectivityChecker$Status r1 = io.sentry.android.core.util.ConnectivityChecker.Status.NOT_CONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$sentry$android$core$util$ConnectivityChecker$Status     // Catch:{ NoSuchFieldError -> 0x001d }
                io.sentry.android.core.util.ConnectivityChecker$Status r1 = io.sentry.android.core.util.ConnectivityChecker.Status.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.DefaultAndroidEventProcessor.AnonymousClass1.<clinit>():void");
        }
    }

    private String getDeviceName() {
        if (Build.VERSION.SDK_INT >= 17) {
            return Settings.Global.getString(this.context.getContentResolver(), "device_name");
        }
        return null;
    }

    private TimeZone getTimeZone() {
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList locales = this.context.getResources().getConfiguration().getLocales();
            if (!locales.isEmpty()) {
                return Calendar.getInstance(locales.get(0)).getTimeZone();
            }
        }
        return Calendar.getInstance().getTimeZone();
    }

    private Date getBootTime() {
        try {
            return DateUtils.getDateTime(System.currentTimeMillis() - SystemClock.elapsedRealtime());
        } catch (IllegalArgumentException e) {
            this.logger.log(SentryLevel.ERROR, e, "Error getting the device's boot time.", new Object[0]);
            return null;
        }
    }

    private ActivityManager.MemoryInfo getMemInfo() {
        try {
            ActivityManager activityManager = (ActivityManager) this.context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
            this.logger.log(SentryLevel.INFO, "Error getting MemoryInfo.", new Object[0]);
            return null;
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting MemoryInfo.", (Throwable) e);
            return null;
        }
    }

    private Intent getBatteryIntent() {
        return this.context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    private String getFamily() {
        try {
            return Build.MODEL.split(" ", -1)[0];
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting device family.", (Throwable) e);
            return null;
        }
    }

    private Float getBatteryLevel(Intent intent) {
        try {
            int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            if (intExtra != -1) {
                if (intExtra2 != -1) {
                    return Float.valueOf((((float) intExtra) / ((float) intExtra2)) * 100.0f);
                }
            }
            return null;
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting device battery level.", (Throwable) e);
            return null;
        }
    }

    private Boolean isCharging(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("plugged", -1);
            boolean z = true;
            if (intExtra != 1) {
                if (intExtra != 2) {
                    z = false;
                }
            }
            return Boolean.valueOf(z);
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting device charging state.", (Throwable) e);
            return null;
        }
    }

    private Float getBatteryTemperature(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("temperature", -1);
            if (intExtra != -1) {
                return Float.valueOf(((float) intExtra) / 10.0f);
            }
            return null;
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting battery temperature.", (Throwable) e);
            return null;
        }
    }

    private Device.DeviceOrientation getOrientation() {
        Device.DeviceOrientation deviceOrientation;
        Exception e;
        try {
            deviceOrientation = DeviceOrientations.getOrientation(this.context.getResources().getConfiguration().orientation);
            if (deviceOrientation == null) {
                try {
                    this.logger.log(SentryLevel.INFO, "No device orientation available (ORIENTATION_SQUARE|ORIENTATION_UNDEFINED)", new Object[0]);
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    this.logger.log(SentryLevel.ERROR, "Error getting device orientation.", (Throwable) e);
                    return deviceOrientation;
                }
            }
        } catch (Exception e3) {
            Exception exc = e3;
            deviceOrientation = null;
            e = exc;
            this.logger.log(SentryLevel.ERROR, "Error getting device orientation.", (Throwable) e);
            return deviceOrientation;
        }
        return deviceOrientation;
    }

    private Boolean isEmulator() {
        boolean z;
        try {
            if ((!Build.BRAND.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) || !Build.DEVICE.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)) && !Build.FINGERPRINT.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) && !Build.FINGERPRINT.startsWith("unknown") && !Build.HARDWARE.contains("goldfish") && !Build.HARDWARE.contains("ranchu") && !Build.MODEL.contains("google_sdk") && !Build.MODEL.contains("Emulator") && !Build.MODEL.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion") && !Build.PRODUCT.contains("sdk_google") && !Build.PRODUCT.contains("google_sdk") && !Build.PRODUCT.contains(ServerProtocol.DIALOG_PARAM_SDK_VERSION) && !Build.PRODUCT.contains("sdk_x86") && !Build.PRODUCT.contains("vbox86p") && !Build.PRODUCT.contains(EMULATOR)) {
                if (!Build.PRODUCT.contains("simulator")) {
                    z = false;
                    return Boolean.valueOf(z);
                }
            }
            z = true;
            return Boolean.valueOf(z);
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error checking whether application is running in an emulator.", (Throwable) e);
            return null;
        }
    }

    private Long getTotalInternalStorage(StatFs statFs) {
        try {
            return Long.valueOf(getBlockCountLong(statFs) * getBlockSizeLong(statFs));
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting total internal storage amount.", (Throwable) e);
            return null;
        }
    }

    private long getBlockSizeLong(StatFs statFs) {
        if (Build.VERSION.SDK_INT >= 18) {
            return statFs.getBlockSizeLong();
        }
        return (long) getBlockSizeDep(statFs);
    }

    private int getBlockSizeDep(StatFs statFs) {
        return statFs.getBlockSize();
    }

    private long getBlockCountLong(StatFs statFs) {
        if (Build.VERSION.SDK_INT >= 18) {
            return statFs.getBlockCountLong();
        }
        return (long) getBlockCountDep(statFs);
    }

    private int getBlockCountDep(StatFs statFs) {
        return statFs.getBlockCount();
    }

    private long getAvailableBlocksLong(StatFs statFs) {
        if (Build.VERSION.SDK_INT >= 18) {
            return statFs.getAvailableBlocksLong();
        }
        return (long) getAvailableBlocksDep(statFs);
    }

    private int getAvailableBlocksDep(StatFs statFs) {
        return statFs.getAvailableBlocks();
    }

    private Long getUnusedInternalStorage(StatFs statFs) {
        try {
            return Long.valueOf(getAvailableBlocksLong(statFs) * getBlockSizeLong(statFs));
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting unused internal storage amount.", (Throwable) e);
            return null;
        }
    }

    private StatFs getExternalStorageStat(File file) {
        if (!isExternalStorageMounted()) {
            File externalStorageDep = getExternalStorageDep(file);
            if (externalStorageDep != null) {
                return new StatFs(externalStorageDep.getPath());
            }
            this.logger.log(SentryLevel.INFO, "Not possible to read external files directory", new Object[0]);
            return null;
        }
        this.logger.log(SentryLevel.INFO, "External storage is not mounted or emulated.", new Object[0]);
        return null;
    }

    private File[] getExternalFilesDirs() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.context.getExternalFilesDirs((String) null);
        }
        File externalFilesDir = this.context.getExternalFilesDir((String) null);
        if (externalFilesDir == null) {
            return null;
        }
        return new File[]{externalFilesDir};
    }

    private File getExternalStorageDep(File file) {
        File[] externalFilesDirs = getExternalFilesDirs();
        if (externalFilesDirs != null) {
            String absolutePath = file != null ? file.getAbsolutePath() : null;
            for (File file2 : externalFilesDirs) {
                if (file2 != null && (absolutePath == null || absolutePath.isEmpty() || !file2.getAbsolutePath().contains(absolutePath))) {
                    return file2;
                }
            }
        } else {
            this.logger.log(SentryLevel.INFO, "Not possible to read getExternalFilesDirs", new Object[0]);
        }
        return null;
    }

    private Long getTotalExternalStorage(StatFs statFs) {
        try {
            return Long.valueOf(getBlockCountLong(statFs) * getBlockSizeLong(statFs));
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting total external storage amount.", (Throwable) e);
            return null;
        }
    }

    private boolean isExternalStorageMounted() {
        String externalStorageState = Environment.getExternalStorageState();
        return ("mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) && !Environment.isExternalStorageEmulated();
    }

    private Long getUnusedExternalStorage(StatFs statFs) {
        try {
            return Long.valueOf(getAvailableBlocksLong(statFs) * getBlockSizeLong(statFs));
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting unused external storage amount.", (Throwable) e);
            return null;
        }
    }

    private DisplayMetrics getDisplayMetrics() {
        try {
            return this.context.getResources().getDisplayMetrics();
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting DisplayMetrics.", (Throwable) e);
            return null;
        }
    }

    private OperatingSystem getOperatingSystem() {
        OperatingSystem operatingSystem = new OperatingSystem();
        operatingSystem.setName("Android");
        operatingSystem.setVersion(Build.VERSION.RELEASE);
        operatingSystem.setBuild(Build.DISPLAY);
        try {
            Object obj = this.contextData.get().get(KERNEL_VERSION);
            if (obj != null) {
                operatingSystem.setKernelVersion((String) obj);
            }
            Object obj2 = this.contextData.get().get(ROOTED);
            if (obj2 != null) {
                operatingSystem.setRooted((Boolean) obj2);
            }
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting OperatingSystem.", (Throwable) e);
        }
        return operatingSystem;
    }

    private void setAppPackageInfo(App app, PackageInfo packageInfo) {
        app.setAppIdentifier(packageInfo.packageName);
        app.setAppVersion(packageInfo.versionName);
        app.setAppBuild(ContextUtils.getVersionCode(packageInfo));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        $closeResource(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getKernelVersion() {
        /*
            r5 = this;
            java.lang.String r0 = "os.version"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "/proc/version"
            r1.<init>(r2)
            boolean r2 = r1.canRead()
            if (r2 != 0) goto L_0x0014
            return r0
        L_0x0014:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x002e }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ IOException -> 0x002e }
            r3.<init>(r1)     // Catch:{ IOException -> 0x002e }
            r2.<init>(r3)     // Catch:{ IOException -> 0x002e }
            r1 = 0
            java.lang.String r3 = r2.readLine()     // Catch:{ all -> 0x0027 }
            $closeResource(r1, r2)     // Catch:{ IOException -> 0x002e }
            return r3
        L_0x0027:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0029 }
        L_0x0029:
            r3 = move-exception
            $closeResource(r1, r2)     // Catch:{ IOException -> 0x002e }
            throw r3     // Catch:{ IOException -> 0x002e }
        L_0x002e:
            r1 = move-exception
            io.sentry.ILogger r2 = r5.logger
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.ERROR
            java.lang.String r4 = "Exception while attempting to read kernel information"
            r2.log((io.sentry.SentryLevel) r3, (java.lang.String) r4, (java.lang.Throwable) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.DefaultAndroidEventProcessor.getKernelVersion():java.lang.String");
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

    private String getApplicationName() {
        try {
            ApplicationInfo applicationInfo = this.context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            if (i != 0) {
                return this.context.getString(i);
            }
            if (applicationInfo.nonLocalizedLabel != null) {
                return applicationInfo.nonLocalizedLabel.toString();
            }
            return this.context.getPackageManager().getApplicationLabel(applicationInfo).toString();
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting application name.", (Throwable) e);
            return null;
        }
    }

    public User getDefaultUser() {
        User user = new User();
        user.setId(getDeviceId());
        return user;
    }

    private String getDeviceId() {
        try {
            Object obj = this.contextData.get().get(ANDROID_ID);
            if (obj != null) {
                return (String) obj;
            }
            return null;
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting androidId.", (Throwable) e);
            return null;
        }
    }

    private String getAndroidId() {
        String string = Settings.Secure.getString(this.context.getContentResolver(), "android_id");
        if (string != null && !string.isEmpty() && !string.toLowerCase(Locale.ROOT).contentEquals("9774d56d682e549c")) {
            return string;
        }
        try {
            return Installation.id(this.context);
        } catch (RuntimeException e) {
            this.logger.log(SentryLevel.ERROR, "Could not generate device Id.", (Throwable) e);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        $closeResource(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0060, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String[] getProguardUUIDs() {
        /*
            r11 = this;
            android.content.Context r0 = r11.context
            android.content.res.AssetManager r0 = r0.getAssets()
            r1 = 0
            r2 = 0
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x006c, RuntimeException -> 0x0061 }
            java.lang.String r4 = "sentry-debug-meta.properties"
            java.io.InputStream r0 = r0.open(r4)     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x006c, RuntimeException -> 0x0061 }
            r3.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x006c, RuntimeException -> 0x0061 }
            java.util.Properties r0 = new java.util.Properties     // Catch:{ all -> 0x005a }
            r0.<init>()     // Catch:{ all -> 0x005a }
            r0.load(r3)     // Catch:{ all -> 0x005a }
            java.lang.String r4 = "io.sentry.ProguardUuids"
            java.lang.String r0 = r0.getProperty(r4)     // Catch:{ all -> 0x005a }
            if (r0 == 0) goto L_0x004b
            boolean r4 = r0.isEmpty()     // Catch:{ all -> 0x005a }
            if (r4 != 0) goto L_0x004b
            java.lang.String r4 = "\\|"
            r5 = -1
            java.lang.String[] r0 = r0.split(r4, r5)     // Catch:{ all -> 0x005a }
            int r4 = r0.length     // Catch:{ all -> 0x005a }
            r5 = 0
        L_0x0032:
            if (r5 >= r4) goto L_0x0047
            r6 = r0[r5]     // Catch:{ all -> 0x005a }
            io.sentry.ILogger r7 = r11.logger     // Catch:{ all -> 0x005a }
            io.sentry.SentryLevel r8 = io.sentry.SentryLevel.DEBUG     // Catch:{ all -> 0x005a }
            java.lang.String r9 = "Proguard UUID found: %s"
            r10 = 1
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ all -> 0x005a }
            r10[r2] = r6     // Catch:{ all -> 0x005a }
            r7.log((io.sentry.SentryLevel) r8, (java.lang.String) r9, (java.lang.Object[]) r10)     // Catch:{ all -> 0x005a }
            int r5 = r5 + 1
            goto L_0x0032
        L_0x0047:
            $closeResource(r1, r3)     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x006c, RuntimeException -> 0x0061 }
            return r0
        L_0x004b:
            io.sentry.ILogger r0 = r11.logger     // Catch:{ all -> 0x005a }
            io.sentry.SentryLevel r4 = io.sentry.SentryLevel.INFO     // Catch:{ all -> 0x005a }
            java.lang.String r5 = "io.sentry.ProguardUuids property was not found or it is invalid."
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x005a }
            r0.log((io.sentry.SentryLevel) r4, (java.lang.String) r5, (java.lang.Object[]) r6)     // Catch:{ all -> 0x005a }
            $closeResource(r1, r3)     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x006c, RuntimeException -> 0x0061 }
            goto L_0x0082
        L_0x005a:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x005c }
        L_0x005c:
            r4 = move-exception
            $closeResource(r0, r3)     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x006c, RuntimeException -> 0x0061 }
            throw r4     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x006c, RuntimeException -> 0x0061 }
        L_0x0061:
            r0 = move-exception
            io.sentry.ILogger r2 = r11.logger
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.ERROR
            java.lang.String r4 = "sentry-debug-meta.properties file is malformed."
            r2.log((io.sentry.SentryLevel) r3, (java.lang.String) r4, (java.lang.Throwable) r0)
            goto L_0x0082
        L_0x006c:
            r0 = move-exception
            io.sentry.ILogger r2 = r11.logger
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.ERROR
            java.lang.String r4 = "Error getting Proguard UUIDs."
            r2.log((io.sentry.SentryLevel) r3, (java.lang.String) r4, (java.lang.Throwable) r0)
            goto L_0x0082
        L_0x0077:
            io.sentry.ILogger r0 = r11.logger
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.INFO
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r4 = "sentry-debug-meta.properties file was not found."
            r0.log((io.sentry.SentryLevel) r3, (java.lang.String) r4, (java.lang.Object[]) r2)
        L_0x0082:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.DefaultAndroidEventProcessor.getProguardUUIDs():java.lang.String[]");
    }

    private Map<String, String> getSideLoadedInfo() {
        String str;
        try {
            PackageInfo packageInfo = ContextUtils.getPackageInfo(this.context, this.logger);
            PackageManager packageManager = this.context.getPackageManager();
            if (!(packageInfo == null || packageManager == null)) {
                str = packageInfo.packageName;
                try {
                    String installerPackageName = packageManager.getInstallerPackageName(str);
                    HashMap hashMap = new HashMap();
                    if (installerPackageName != null) {
                        hashMap.put("isSideLoaded", "false");
                        hashMap.put("installerStore", installerPackageName);
                    } else {
                        hashMap.put("isSideLoaded", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                    }
                    return hashMap;
                } catch (IllegalArgumentException unused) {
                    this.logger.log(SentryLevel.DEBUG, "%s package isn't installed.", str);
                    return null;
                }
            }
        } catch (IllegalArgumentException unused2) {
            str = null;
            this.logger.log(SentryLevel.DEBUG, "%s package isn't installed.", str);
            return null;
        }
        return null;
    }

    private void setSideLoadedInfo(SentryEvent sentryEvent) {
        try {
            Object obj = this.contextData.get().get(SIDE_LOADED);
            if (obj instanceof Map) {
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    sentryEvent.setTag((String) entry.getKey(), (String) entry.getValue());
                }
            }
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting side loaded info.", (Throwable) e);
        }
    }
}
