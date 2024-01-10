package io.sentry.android.core;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import io.sentry.ILogger;
import io.sentry.SendCachedEnvelopeFireAndForgetIntegration;
import io.sentry.SendFireAndForgetEnvelopeSender;
import io.sentry.SendFireAndForgetOutboxSender;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.util.Objects;
import java.io.File;

final class AndroidOptionsInitializer {
    private AndroidOptionsInitializer() {
    }

    static void init(SentryAndroidOptions sentryAndroidOptions, Context context) {
        Objects.requireNonNull(context, "The application context is required.");
        Objects.requireNonNull(sentryAndroidOptions, "The options object is required.");
        init(sentryAndroidOptions, context, new AndroidLogger());
    }

    static void init(SentryAndroidOptions sentryAndroidOptions, Context context, ILogger iLogger) {
        init(sentryAndroidOptions, context, iLogger, new BuildInfoProvider());
    }

    static void init(SentryAndroidOptions sentryAndroidOptions, Context context, ILogger iLogger, IBuildInfoProvider iBuildInfoProvider) {
        init(sentryAndroidOptions, context, iLogger, iBuildInfoProvider, new LoadClass());
    }

    static void init(SentryAndroidOptions sentryAndroidOptions, Context context, ILogger iLogger, IBuildInfoProvider iBuildInfoProvider, ILoadClass iLoadClass) {
        Objects.requireNonNull(context, "The context is required.");
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        Objects.requireNonNull(sentryAndroidOptions, "The options object is required.");
        Objects.requireNonNull(iLogger, "The ILogger object is required.");
        sentryAndroidOptions.setLogger(iLogger);
        ManifestMetadataReader.applyMetadata(context, sentryAndroidOptions);
        initializeCacheDirs(context, sentryAndroidOptions);
        installDefaultIntegrations(context, sentryAndroidOptions, iBuildInfoProvider, iLoadClass);
        readDefaultOptionValues(sentryAndroidOptions, context);
        sentryAndroidOptions.addEventProcessor(new DefaultAndroidEventProcessor(context, iLogger, iBuildInfoProvider));
        sentryAndroidOptions.setTransportGate(new AndroidTransportGate(context, sentryAndroidOptions.getLogger()));
    }

    private static void installDefaultIntegrations(Context context, SentryOptions sentryOptions, IBuildInfoProvider iBuildInfoProvider, ILoadClass iLoadClass) {
        sentryOptions.addIntegration(new SendCachedEnvelopeFireAndForgetIntegration(new SendFireAndForgetEnvelopeSender(new SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetDirPath() {
            public final String getDirPath() {
                return SentryOptions.this.getCacheDirPath();
            }
        })));
        sentryOptions.addIntegration(new NdkIntegration(loadNdkIfAvailable(sentryOptions, iBuildInfoProvider, iLoadClass)));
        sentryOptions.addIntegration(EnvelopeFileObserverIntegration.getOutboxFileObserver());
        sentryOptions.addIntegration(new SendCachedEnvelopeFireAndForgetIntegration(new SendFireAndForgetOutboxSender(new SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetDirPath() {
            public final String getDirPath() {
                return SentryOptions.this.getOutboxPath();
            }
        })));
        sentryOptions.addIntegration(new AnrIntegration(context));
        sentryOptions.addIntegration(new AppLifecycleIntegration());
        if (context instanceof Application) {
            sentryOptions.addIntegration(new ActivityBreadcrumbsIntegration((Application) context));
        } else {
            sentryOptions.getLogger().log(SentryLevel.WARNING, "ActivityBreadcrumbsIntegration needs an Application class to be installed.", new Object[0]);
        }
        sentryOptions.addIntegration(new AppComponentsBreadcrumbsIntegration(context));
        sentryOptions.addIntegration(new SystemEventsBreadcrumbsIntegration(context));
        sentryOptions.addIntegration(new TempSensorBreadcrumbsIntegration(context));
        sentryOptions.addIntegration(new PhoneStateBreadcrumbsIntegration(context));
    }

    private static void readDefaultOptionValues(SentryAndroidOptions sentryAndroidOptions, Context context) {
        PackageInfo packageInfo = ContextUtils.getPackageInfo(context, sentryAndroidOptions.getLogger());
        if (packageInfo != null) {
            if (sentryAndroidOptions.getRelease() == null) {
                sentryAndroidOptions.setRelease(getSentryReleaseVersion(packageInfo, ContextUtils.getVersionCode(packageInfo)));
            }
            String str = packageInfo.packageName;
            if (str != null && !str.startsWith("android.")) {
                sentryAndroidOptions.addInAppInclude(str);
            }
        }
        if (sentryAndroidOptions.getDistinctId() == null) {
            try {
                sentryAndroidOptions.setDistinctId(Installation.id(context));
            } catch (RuntimeException e) {
                sentryAndroidOptions.getLogger().log(SentryLevel.ERROR, "Could not generate distinct Id.", (Throwable) e);
            }
        }
    }

    private static String getSentryReleaseVersion(PackageInfo packageInfo, String str) {
        return packageInfo.packageName + "@" + packageInfo.versionName + "+" + str;
    }

    private static void initializeCacheDirs(Context context, SentryOptions sentryOptions) {
        sentryOptions.setCacheDirPath(new File(context.getCacheDir(), "sentry").getAbsolutePath());
    }

    private static boolean isNdkAvailable(IBuildInfoProvider iBuildInfoProvider) {
        return iBuildInfoProvider.getSdkInfoVersion() >= 16;
    }

    private static Class<?> loadNdkIfAvailable(SentryOptions sentryOptions, IBuildInfoProvider iBuildInfoProvider, ILoadClass iLoadClass) {
        if (!isNdkAvailable(iBuildInfoProvider)) {
            return null;
        }
        try {
            return iLoadClass.loadClass(NdkIntegration.SENTRY_NDK_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "Failed to load SentryNdk.", (Throwable) e);
            return null;
        } catch (UnsatisfiedLinkError e2) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "Failed to load (UnsatisfiedLinkError) SentryNdk.", (Throwable) e2);
            return null;
        } catch (Throwable th) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "Failed to initialize SentryNdk.", th);
            return null;
        }
    }
}
