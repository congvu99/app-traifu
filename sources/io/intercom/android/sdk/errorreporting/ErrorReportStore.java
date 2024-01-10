package io.intercom.android.sdk.errorreporting;

import android.content.Context;
import android.os.AsyncTask;
import com.google.gson.Gson;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.persistence.JsonStorage;
import java.io.File;
import java.util.concurrent.RejectedExecutionException;

class ErrorReportStore {
    private static final String REPORT_FILE_PATH = "intercom-error.json";
    private static final Twig TWIG = LumberMill.getLogger();
    /* access modifiers changed from: private */
    public final File reportFile;
    private final JsonStorage storage;

    public static ErrorReportStore create(Context context, Gson gson) {
        return new ErrorReportStore(new File(context.getCacheDir(), REPORT_FILE_PATH), new JsonStorage(gson));
    }

    ErrorReportStore(File file, JsonStorage jsonStorage) {
        this.reportFile = file;
        this.storage = jsonStorage;
    }

    /* access modifiers changed from: package-private */
    public void sendSavedReport(final Provider<Api> provider) {
        try {
            AsyncTask.execute(new Runnable() {
                public void run() {
                    if (ErrorReportStore.this.reportFile.exists()) {
                        ErrorReportStore.this.readAndSendReport((Api) provider.get());
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            Twig twig = TWIG;
            twig.internal("Couldn't queue up sending of event: " + e);
        }
    }

    /* access modifiers changed from: private */
    public void readAndSendReport(final Api api) {
        this.storage.loadThenDelete(this.reportFile, ErrorReport.class, new JsonStorage.LoadHandler<ErrorReport>() {
            public void onLoad(ErrorReport errorReport) {
                api.sendErrorReport(errorReport);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void saveToDisk(ErrorReport errorReport) {
        this.storage.saveToFileAsJson(errorReport, this.reportFile);
    }

    /* access modifiers changed from: package-private */
    public void deleteFromDisk() {
        this.storage.loadThenDelete(this.reportFile, ErrorReport.class, new JsonStorage.LoadHandler<ErrorReport>() {
            public void onLoad(ErrorReport errorReport) {
            }
        });
    }
}
