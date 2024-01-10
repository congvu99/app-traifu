package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ReactSoftExceptionLogger {
    private static final List<ReactSoftExceptionListener> sListeners = new CopyOnWriteArrayList();

    public interface ReactSoftExceptionListener {
        void logSoftException(String str, Throwable th);
    }

    public static void addListener(ReactSoftExceptionListener reactSoftExceptionListener) {
        if (!sListeners.contains(reactSoftExceptionListener)) {
            sListeners.add(reactSoftExceptionListener);
        }
    }

    public static void removeListener(ReactSoftExceptionListener reactSoftExceptionListener) {
        sListeners.remove(reactSoftExceptionListener);
    }

    public static void clearListeners() {
        sListeners.clear();
    }

    public static void logSoftException(String str, Throwable th) {
        if (sListeners.size() > 0) {
            for (ReactSoftExceptionListener logSoftException : sListeners) {
                logSoftException.logSoftException(str, th);
            }
            return;
        }
        FLog.e(str, "Unhandled SoftException", th);
    }

    private static void logNoThrowSoftExceptionWithMessage(String str, String str2) {
        logSoftException(str, new ReactNoCrashSoftException(str2));
    }
}
