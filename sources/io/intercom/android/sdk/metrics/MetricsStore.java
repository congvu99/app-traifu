package io.intercom.android.sdk.metrics;

import android.content.Context;
import com.google.gson.Gson;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.ops.OpsMetricObject;
import io.intercom.android.sdk.persistence.JsonStorage;
import io.intercom.android.sdk.utilities.IoUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MetricsStore {
    private static final String METRICS_DIR = "intercomMetrics";
    private static final String OPS_METRICS_DIR = "intercomOpsMetrics";
    private static final int STORED_METRIC_LIMIT = 200;
    private static final int STORED_OP_METRIC_LIMIT = 100;
    private final Provider<Api> apiProvider;
    private final Provider<AppConfig> appConfigProvider;
    private final JsonStorage.LoadFailureHandler deleteOnFailureHandler;
    /* access modifiers changed from: private */
    public final Executor executor;
    private final String installerPackageName;
    private final boolean isDebugBuild;
    private final File metricsDir;
    private final File opsMetricsDir;
    /* access modifiers changed from: private */
    public final JsonStorage storage;
    /* access modifiers changed from: private */
    public final Twig twig;

    public MetricsStore(Context context, Provider<Api> provider, Provider<AppConfig> provider2) {
        this(provider, provider2, Executors.newSingleThreadExecutor(), new JsonStorage(new Gson()), new File(context.getCacheDir(), METRICS_DIR), new File(context.getCacheDir(), OPS_METRICS_DIR), AppTypeDetector.isDebugBuild(context), AppTypeDetector.getInstallerPackageName(context), LumberMill.getLogger());
    }

    MetricsStore(Provider<Api> provider, Provider<AppConfig> provider2, Executor executor2, JsonStorage jsonStorage, File file, File file2, boolean z, String str, Twig twig2) {
        this.deleteOnFailureHandler = new JsonStorage.LoadFailureHandler() {
            public void onLoadFailed(File file, Exception exc) {
                IoUtils.safelyDelete(file);
                Twig access$800 = MetricsStore.this.twig;
                access$800.v(exc, "Couldn't load file " + file.getAbsolutePath(), new Object[0]);
            }
        };
        this.apiProvider = provider;
        this.appConfigProvider = provider2;
        this.executor = executor2;
        this.storage = jsonStorage;
        this.metricsDir = file;
        this.opsMetricsDir = file2;
        this.isDebugBuild = z;
        this.installerPackageName = str;
        this.twig = twig2;
    }

    public void track(final MetricObject metricObject) {
        if (!isDisabled()) {
            metricObject.addInstallerPackageName(this.installerPackageName).addIsDebugBuild(this.isDebugBuild);
            this.executor.execute(new Runnable() {
                public void run() {
                    if (!MetricsStore.this.hasReachedMetricStorageLimit()) {
                        JsonStorage access$200 = MetricsStore.this.storage;
                        MetricObject metricObject = metricObject;
                        access$200.saveToFileAsJson(metricObject, MetricsStore.this.getFile(metricObject));
                    }
                }
            });
        }
    }

    public void track(final OpsMetricObject opsMetricObject) {
        if (!isDisabled()) {
            this.executor.execute(new Runnable() {
                public void run() {
                    if (!MetricsStore.this.hasReachedOpsMetricStorageLimit()) {
                        JsonStorage access$200 = MetricsStore.this.storage;
                        OpsMetricObject opsMetricObject = opsMetricObject;
                        access$200.saveToFileAsJson(opsMetricObject, MetricsStore.this.getFile(opsMetricObject));
                    }
                }
            });
        }
    }

    private boolean isDisabled() {
        return !this.appConfigProvider.get().isMetricsEnabled();
    }

    /* access modifiers changed from: private */
    public boolean hasReachedMetricStorageLimit() {
        return this.storage.getDirectoryFileCount(this.metricsDir) > 200;
    }

    /* access modifiers changed from: private */
    public boolean hasReachedOpsMetricStorageLimit() {
        return this.storage.getDirectoryFileCount(this.opsMetricsDir) > 100;
    }

    /* access modifiers changed from: private */
    public File getFile(MetricObject metricObject) {
        File file = this.metricsDir;
        return new File(file, metricObject.getId() + ".json");
    }

    /* access modifiers changed from: private */
    public File getFile(OpsMetricObject opsMetricObject) {
        File file = this.opsMetricsDir;
        return new File(file, opsMetricObject.getId() + ".json");
    }

    public void loadAndSendMetrics() {
        this.executor.execute(new Runnable() {
            public void run() {
                List<MetricObject> loadMetrics = MetricsStore.this.loadMetrics();
                List<OpsMetricObject> loadOpsMetrics = MetricsStore.this.loadOpsMetrics();
                if (!loadMetrics.isEmpty() || !loadOpsMetrics.isEmpty()) {
                    MetricsStore.this.uploadMetrics(loadMetrics, loadOpsMetrics);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void uploadMetrics(final List<MetricObject> list, final List<OpsMetricObject> list2) {
        this.apiProvider.get().sendMetrics(list, list2, new Callback<Void>() {
            public void onFailure(Call<Void> call, Throwable th) {
            }

            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful() || response.code() == 400) {
                    MetricsStore.this.executor.execute(new Runnable() {
                        public void run() {
                            MetricsStore.this.deleteFilesFor(list, list2);
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public List<MetricObject> loadMetrics() {
        final ArrayList arrayList = new ArrayList();
        this.storage.loadFilesInDirectory(this.metricsDir, MetricObject.class, new JsonStorage.LoadHandler<List<MetricObject>>() {
            public void onLoad(List<MetricObject> list) {
                MetricsStore.copyNonNullItems(list, arrayList);
            }
        }, this.deleteOnFailureHandler);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<OpsMetricObject> loadOpsMetrics() {
        final ArrayList arrayList = new ArrayList();
        this.storage.loadFilesInDirectory(this.opsMetricsDir, OpsMetricObject.class, new JsonStorage.LoadHandler<List<OpsMetricObject>>() {
            public void onLoad(List<OpsMetricObject> list) {
                MetricsStore.copyNonNullItems(list, arrayList);
            }
        }, this.deleteOnFailureHandler);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static <T> void copyNonNullItems(List<T> list, List<T> list2) {
        for (T next : list) {
            if (next != null) {
                list2.add(next);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void deleteFilesFor(List<MetricObject> list, List<OpsMetricObject> list2) {
        for (MetricObject file : list) {
            IoUtils.safelyDelete(getFile(file));
        }
        for (OpsMetricObject file2 : list2) {
            IoUtils.safelyDelete(getFile(file2));
        }
    }
}
