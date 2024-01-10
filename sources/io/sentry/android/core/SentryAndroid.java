package io.sentry.android.core;

import android.content.Context;
import io.sentry.ILogger;
import io.sentry.OptionsContainer;
import io.sentry.Sentry;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.lang.reflect.InvocationTargetException;

public final class SentryAndroid {
    static /* synthetic */ void lambda$init$0(SentryAndroidOptions sentryAndroidOptions) {
    }

    private SentryAndroid() {
    }

    public static void init(Context context) {
        init(context, (ILogger) new AndroidLogger());
    }

    public static void init(Context context, ILogger iLogger) {
        init(context, iLogger, $$Lambda$SentryAndroid$1tDpu4BrZ9ZUeZ0tE52kgN3Zx10.INSTANCE);
    }

    public static void init(Context context, Sentry.OptionsConfiguration<SentryAndroidOptions> optionsConfiguration) {
        init(context, new AndroidLogger(), optionsConfiguration);
    }

    public static void init(Context context, ILogger iLogger, Sentry.OptionsConfiguration<SentryAndroidOptions> optionsConfiguration) {
        try {
            Sentry.init(OptionsContainer.create(SentryAndroidOptions.class), new Sentry.OptionsConfiguration(context, iLogger, optionsConfiguration) {
                public final /* synthetic */ Context f$0;
                public final /* synthetic */ ILogger f$1;
                public final /* synthetic */ Sentry.OptionsConfiguration f$2;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void configure(SentryOptions sentryOptions) {
                    SentryAndroid.lambda$init$1(this.f$0, this.f$1, this.f$2, (SentryAndroidOptions) sentryOptions);
                }
            }, true);
        } catch (IllegalAccessException e) {
            iLogger.log(SentryLevel.FATAL, "Fatal error during SentryAndroid.init(...)", (Throwable) e);
            throw new RuntimeException("Failed to initialize Sentry's SDK", e);
        } catch (InstantiationException e2) {
            iLogger.log(SentryLevel.FATAL, "Fatal error during SentryAndroid.init(...)", (Throwable) e2);
            throw new RuntimeException("Failed to initialize Sentry's SDK", e2);
        } catch (NoSuchMethodException e3) {
            iLogger.log(SentryLevel.FATAL, "Fatal error during SentryAndroid.init(...)", (Throwable) e3);
            throw new RuntimeException("Failed to initialize Sentry's SDK", e3);
        } catch (InvocationTargetException e4) {
            iLogger.log(SentryLevel.FATAL, "Fatal error during SentryAndroid.init(...)", (Throwable) e4);
            throw new RuntimeException("Failed to initialize Sentry's SDK", e4);
        }
    }

    static /* synthetic */ void lambda$init$1(Context context, ILogger iLogger, Sentry.OptionsConfiguration optionsConfiguration, SentryAndroidOptions sentryAndroidOptions) {
        AndroidOptionsInitializer.init(sentryAndroidOptions, context, iLogger);
        optionsConfiguration.configure(sentryAndroidOptions);
    }
}
