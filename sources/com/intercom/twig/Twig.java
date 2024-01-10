package com.intercom.twig;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Twig {
    public static final int DISABLED = 8;
    private static final int MAX_LOG_LENGTH = 4000;
    private final boolean internalLoggingEnabled;
    private int logLevel;
    private final String tag;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    public Twig(int i, String str, boolean z) {
        this.logLevel = i;
        this.tag = str == null ? "Twig" : str;
        this.internalLoggingEnabled = z;
    }

    public void v(String str, Object... objArr) {
        prepareLog(2, (Throwable) null, str, objArr);
    }

    public void v(Throwable th, String str, Object... objArr) {
        prepareLog(2, th, str, objArr);
    }

    public void v(Throwable th) {
        prepareLog(2, th, (String) null, new Object[0]);
    }

    public void d(String str, Object... objArr) {
        prepareLog(3, (Throwable) null, str, objArr);
    }

    public void d(Throwable th, String str, Object... objArr) {
        prepareLog(3, th, str, objArr);
    }

    public void d(Throwable th) {
        prepareLog(3, th, (String) null, new Object[0]);
    }

    public void i(String str, Object... objArr) {
        prepareLog(4, (Throwable) null, str, objArr);
    }

    public void i(Throwable th, String str, Object... objArr) {
        prepareLog(4, th, str, objArr);
    }

    public void i(Throwable th) {
        prepareLog(4, th, (String) null, new Object[0]);
    }

    public void w(String str, Object... objArr) {
        prepareLog(5, (Throwable) null, str, objArr);
    }

    public void w(Throwable th, String str, Object... objArr) {
        prepareLog(5, th, str, objArr);
    }

    public void w(Throwable th) {
        prepareLog(5, th, (String) null, new Object[0]);
    }

    public void e(String str, Object... objArr) {
        prepareLog(6, (Throwable) null, str, objArr);
    }

    public void e(Throwable th, String str, Object... objArr) {
        prepareLog(6, th, str, objArr);
    }

    public void e(Throwable th) {
        prepareLog(6, th, (String) null, new Object[0]);
    }

    public void wtf(String str, Object... objArr) {
        prepareLog(7, (Throwable) null, str, objArr);
    }

    public void wtf(Throwable th, String str, Object... objArr) {
        prepareLog(7, th, str, objArr);
    }

    public void wtf(Throwable th) {
        prepareLog(7, th, (String) null, new Object[0]);
    }

    public void internal(String str) {
        internal(this.tag, str);
    }

    public void internal(String str, String str2) {
        if (this.internalLoggingEnabled) {
            Log.d(str, "INTERNAL: " + str2);
        }
    }

    public void setLogLevel(int i) {
        this.logLevel = i;
    }

    /* access modifiers changed from: package-private */
    public int getLogLevel() {
        return this.logLevel;
    }

    public String getTag() {
        return this.tag;
    }

    private void prepareLog(int i, Throwable th, String str, Object... objArr) {
        String str2;
        if (i >= this.logLevel) {
            String tag2 = getTag();
            if (str != null && str.length() == 0) {
                str = null;
            }
            if (str != null) {
                if (objArr.length > 0) {
                    str = String.format(str, objArr);
                }
                if (th != null) {
                    str2 = str + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE + getStackTraceString(th);
                } else {
                    str2 = str;
                }
            } else if (th != null) {
                str2 = getStackTraceString(th);
            } else {
                return;
            }
            log(i, tag2, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void log(int i, String str, Object... objArr) {
        prepareLog(i, (Throwable) null, str, objArr);
    }

    private void log(int i, String str, String str2) {
        int min;
        if (str2.length() < MAX_LOG_LENGTH) {
            printLog(i, str, str2);
            return;
        }
        int i2 = 0;
        int length = str2.length();
        while (i2 < length) {
            int indexOf = str2.indexOf(10, i2);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i2 + MAX_LOG_LENGTH);
                printLog(i, str, str2.substring(i2, min));
                if (min >= indexOf) {
                    break;
                }
                i2 = min;
            }
            i2 = min + 1;
        }
    }

    private void printLog(int i, String str, String str2) {
        if (i == 7) {
            Log.wtf(str, str2);
        } else {
            Log.println(i, str, str2);
        }
    }

    private String getStackTraceString(Throwable th) {
        StringWriter stringWriter = new StringWriter(256);
        PrintWriter printWriter = new PrintWriter(stringWriter, false);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }
}
