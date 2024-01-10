package io.intercom.android.sdk.errorreporting;

import android.content.Context;
import com.google.gson.Gson;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.api.Api;

public class ErrorReporter {
    private final Provider<Api> apiProvider;
    private final ExceptionParser exceptionParser;
    private final ErrorReportStore reportStore;

    public static ErrorReporter create(Context context, Gson gson, Provider<Api> provider) {
        return new ErrorReporter(ErrorReportStore.create(context.getApplicationContext(), gson), provider, new ExceptionParser());
    }

    ErrorReporter(ErrorReportStore errorReportStore, Provider<Api> provider, ExceptionParser exceptionParser2) {
        this.reportStore = errorReportStore;
        this.apiProvider = provider;
        this.exceptionParser = exceptionParser2;
    }

    /* access modifiers changed from: package-private */
    public void saveReport(Throwable th) {
        if (this.exceptionParser.containsIntercomMethod(th)) {
            this.reportStore.saveToDisk(this.exceptionParser.createReportFrom(th));
        }
    }

    public void sendSavedReport() {
        this.reportStore.sendSavedReport(this.apiProvider);
    }

    public void enableExceptionHandler() {
        IntercomExceptionHandler.enable(this);
    }

    public void disableExceptionHandler() {
        IntercomExceptionHandler.disable();
        this.reportStore.deleteFromDisk();
    }
}
