package net.hockeyapp.android;

import android.os.Process;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.Date;
import java.util.UUID;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler defaultExceptionHandler;
    private boolean ignoreDefaultHandler = false;
    private CrashManagerListener listener;

    public ExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, CrashManagerListener crashManagerListener, boolean z) {
        this.defaultExceptionHandler = uncaughtExceptionHandler;
        this.ignoreDefaultHandler = z;
        this.listener = crashManagerListener;
    }

    public void setListener(CrashManagerListener crashManagerListener) {
        this.listener = crashManagerListener;
    }

    public static void saveException(Throwable th, CrashManagerListener crashManagerListener) {
        Date date = new Date();
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        try {
            String uuid = UUID.randomUUID().toString();
            String str = Constants.FILES_PATH + "/" + uuid + ".stacktrace";
            Log.d(Constants.TAG, "Writing unhandled exception to: " + str);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str));
            bufferedWriter.write("Package: " + Constants.APP_PACKAGE + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            bufferedWriter.write("Version: " + Constants.APP_VERSION + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            if (crashManagerListener == null || crashManagerListener.includeDeviceData()) {
                bufferedWriter.write("Android: " + Constants.ANDROID_VERSION + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                bufferedWriter.write("Manufacturer: " + Constants.PHONE_MANUFACTURER + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                bufferedWriter.write("Model: " + Constants.PHONE_MODEL + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            }
            bufferedWriter.write("Date: " + date + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            bufferedWriter.write(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            bufferedWriter.write(stringWriter.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
            if (crashManagerListener != null) {
                writeValueToFile(limitedString(crashManagerListener.getUserID()), uuid + ".user");
                writeValueToFile(limitedString(crashManagerListener.getContact()), uuid + ".contact");
                writeValueToFile(crashManagerListener.getDescription(), uuid + ".description");
            }
        } catch (Exception e) {
            Log.e(Constants.TAG, "Error saving exception stacktrace!\n", e);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (Constants.FILES_PATH == null) {
            this.defaultExceptionHandler.uncaughtException(thread, th);
            return;
        }
        saveException(th, this.listener);
        if (!this.ignoreDefaultHandler) {
            this.defaultExceptionHandler.uncaughtException(thread, th);
            return;
        }
        Process.killProcess(Process.myPid());
        System.exit(10);
    }

    private static void writeValueToFile(String str, String str2) {
        try {
            String str3 = Constants.FILES_PATH + "/" + str2;
            if (str.trim().length() > 0) {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str3));
                bufferedWriter.write(str);
                bufferedWriter.flush();
                bufferedWriter.close();
            }
        } catch (Exception unused) {
        }
    }

    private static String limitedString(String str) {
        return (str == null || str.length() <= 255) ? str : str.substring(0, 255);
    }
}
