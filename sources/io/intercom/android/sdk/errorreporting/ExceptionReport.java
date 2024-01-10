package io.intercom.android.sdk.errorreporting;

import com.google.gson.annotations.SerializedName;

public class ExceptionReport {
    @SerializedName("class_name")
    private final String className;
    private final String message;
    private final String stacktrace;

    ExceptionReport(String str, String str2, String str3) {
        this.className = str;
        this.message = str2;
        this.stacktrace = str3;
    }

    public String getClassName() {
        return this.className;
    }

    public String getMessage() {
        return this.message;
    }

    public String getStacktrace() {
        return this.stacktrace;
    }
}
