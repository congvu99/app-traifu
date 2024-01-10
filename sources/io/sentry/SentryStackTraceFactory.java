package io.sentry;

import io.sentry.protocol.SentryStackFrame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class SentryStackTraceFactory {
    private final List<String> inAppExcludes;
    private final List<String> inAppIncludes;

    public SentryStackTraceFactory(List<String> list, List<String> list2) {
        this.inAppExcludes = list;
        this.inAppIncludes = list2;
    }

    /* access modifiers changed from: package-private */
    public List<SentryStackFrame> getStackFrames(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (stackTraceElement != null) {
                String className = stackTraceElement.getClassName();
                if (!className.startsWith("io.sentry.") || className.startsWith("io.sentry.samples.")) {
                    SentryStackFrame sentryStackFrame = new SentryStackFrame();
                    sentryStackFrame.setInApp(Boolean.valueOf(isInApp(className)));
                    sentryStackFrame.setModule(className);
                    sentryStackFrame.setFunction(stackTraceElement.getMethodName());
                    sentryStackFrame.setFilename(stackTraceElement.getFileName());
                    if (stackTraceElement.getLineNumber() >= 0) {
                        sentryStackFrame.setLineno(Integer.valueOf(stackTraceElement.getLineNumber()));
                    }
                    sentryStackFrame.setNative(Boolean.valueOf(stackTraceElement.isNativeMethod()));
                    arrayList.add(sentryStackFrame);
                }
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002e A[LOOP:1: B:15:0x002e->B:18:0x003e, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isInApp(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 1
            if (r4 == 0) goto L_0x0041
            boolean r1 = r4.isEmpty()
            if (r1 == 0) goto L_0x000a
            goto L_0x0041
        L_0x000a:
            java.util.List<java.lang.String> r1 = r3.inAppIncludes
            if (r1 == 0) goto L_0x0025
            java.util.Iterator r1 = r1.iterator()
        L_0x0012:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0025
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = r4.startsWith(r2)
            if (r2 == 0) goto L_0x0012
            return r0
        L_0x0025:
            java.util.List<java.lang.String> r0 = r3.inAppExcludes
            r1 = 0
            if (r0 == 0) goto L_0x0040
            java.util.Iterator r0 = r0.iterator()
        L_0x002e:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0040
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = r4.startsWith(r2)
            if (r2 == 0) goto L_0x002e
        L_0x0040:
            return r1
        L_0x0041:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryStackTraceFactory.isInApp(java.lang.String):boolean");
    }
}
