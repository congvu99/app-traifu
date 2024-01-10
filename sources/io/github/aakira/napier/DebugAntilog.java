package io.github.aakira.napier;

import android.os.Build;
import io.github.aakira.napier.Napier;
import io.sentry.protocol.App;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u000eJ.\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0014J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0012H\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\u00020\u0003*\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lio/github/aakira/napier/DebugAntilog;", "Lio/github/aakira/napier/Antilog;", "defaultTag", "", "(Ljava/lang/String;)V", "anonymousClass", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "stackTraceString", "", "getStackTraceString", "(Ljava/lang/Throwable;)Ljava/lang/String;", "createStackElementTag", "className", "createStackElementTag$napier_release", "performLog", "", "priority", "Lio/github/aakira/napier/Napier$Level;", "tag", "throwable", "message", "performTag", "toValue", "", "Companion", "napier_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: DebugAntilog.kt */
public final class DebugAntilog extends Antilog {
    private static final int CALL_STACK_INDEX = 9;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_LOG_LENGTH = 4000;
    private static final int MAX_TAG_LENGTH = 23;
    private final Pattern anonymousClass;
    private final String defaultTag;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Napier.Level.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Napier.Level.VERBOSE.ordinal()] = 1;
            $EnumSwitchMapping$0[Napier.Level.DEBUG.ordinal()] = 2;
            $EnumSwitchMapping$0[Napier.Level.INFO.ordinal()] = 3;
            $EnumSwitchMapping$0[Napier.Level.WARNING.ordinal()] = 4;
            $EnumSwitchMapping$0[Napier.Level.ERROR.ordinal()] = 5;
            $EnumSwitchMapping$0[Napier.Level.ASSERT.ordinal()] = 6;
        }
    }

    public DebugAntilog() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public DebugAntilog(String str) {
        Intrinsics.checkNotNullParameter(str, "defaultTag");
        this.defaultTag = str;
        this.anonymousClass = Pattern.compile("(\\$\\d+)+$");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DebugAntilog(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? App.TYPE : str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lio/github/aakira/napier/DebugAntilog$Companion;", "", "()V", "CALL_STACK_INDEX", "", "MAX_LOG_LENGTH", "MAX_TAG_LENGTH", "napier_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DebugAntilog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0085, code lost:
        r0 = r2 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void performLog(io.github.aakira.napier.Napier.Level r8, java.lang.String r9, java.lang.Throwable r10, java.lang.String r11) {
        /*
            r7 = this;
            java.lang.String r0 = "priority"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            if (r9 == 0) goto L_0x0008
            goto L_0x000e
        L_0x0008:
            java.lang.String r9 = r7.defaultTag
            java.lang.String r9 = r7.performTag(r9)
        L_0x000e:
            if (r11 == 0) goto L_0x002b
            if (r10 == 0) goto L_0x0033
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            r11 = 10
            r0.append(r11)
            java.lang.String r10 = r7.getStackTraceString(r10)
            r0.append(r10)
            java.lang.String r11 = r0.toString()
            goto L_0x0033
        L_0x002b:
            if (r10 == 0) goto L_0x0092
            java.lang.String r11 = r7.getStackTraceString(r10)
            if (r11 == 0) goto L_0x0092
        L_0x0033:
            int r10 = r11.length()
            r0 = 4000(0xfa0, float:5.605E-42)
            if (r10 > r0) goto L_0x004b
            io.github.aakira.napier.Napier$Level r10 = io.github.aakira.napier.Napier.Level.ASSERT
            if (r8 != r10) goto L_0x0043
            android.util.Log.wtf(r9, r11)
            goto L_0x004a
        L_0x0043:
            int r8 = r7.toValue(r8)
            android.util.Log.println(r8, r9, r11)
        L_0x004a:
            return
        L_0x004b:
            r0 = 0
        L_0x004c:
            if (r0 >= r10) goto L_0x0092
            r1 = r11
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 10
            r4 = 0
            r5 = 4
            r6 = 0
            r3 = r0
            int r1 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r1, (char) r2, (int) r3, (boolean) r4, (int) r5, (java.lang.Object) r6)
            r2 = -1
            if (r1 == r2) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r1 = r10
        L_0x0060:
            int r2 = r0 + 4000
            int r2 = java.lang.Math.min(r1, r2)
            if (r11 == 0) goto L_0x008a
            java.lang.String r0 = r11.substring(r0, r2)
            java.lang.String r3 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            int r3 = r7.toValue(r8)
            r4 = 7
            if (r3 != r4) goto L_0x007c
            android.util.Log.wtf(r9, r0)
            goto L_0x0083
        L_0x007c:
            int r3 = r7.toValue(r8)
            android.util.Log.println(r3, r9, r0)
        L_0x0083:
            if (r2 < r1) goto L_0x0088
            int r0 = r2 + 1
            goto L_0x004c
        L_0x0088:
            r0 = r2
            goto L_0x0060
        L_0x008a:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type java.lang.String"
            r8.<init>(r9)
            throw r8
        L_0x0092:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.github.aakira.napier.DebugAntilog.performLog(io.github.aakira.napier.Napier$Level, java.lang.String, java.lang.Throwable, java.lang.String):void");
    }

    private final String performTag(String str) {
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        if (stackTrace == null || stackTrace.length < 9) {
            return str;
        }
        StackTraceElement stackTraceElement = stackTrace[9];
        StringBuilder sb = new StringBuilder();
        String className = stackTraceElement.getClassName();
        Intrinsics.checkNotNullExpressionValue(className, "className");
        sb.append(createStackElementTag$napier_release(className));
        sb.append(Typography.dollar);
        sb.append(stackTraceElement.getMethodName());
        return sb.toString();
    }

    public final String createStackElementTag$napier_release(String str) {
        Intrinsics.checkNotNullParameter(str, "className");
        Matcher matcher = this.anonymousClass.matcher(str);
        if (matcher.find()) {
            str = matcher.replaceAll("");
            Intrinsics.checkNotNullExpressionValue(str, "m.replaceAll(\"\")");
        }
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null) + 1;
        if (str != null) {
            String substring = str.substring(lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            if (substring.length() <= 23 || Build.VERSION.SDK_INT >= 24) {
                return substring;
            }
            if (substring != null) {
                String substring2 = substring.substring(0, 23);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring2;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private final String getStackTraceString(Throwable th) {
        StringWriter stringWriter = new StringWriter(256);
        PrintWriter printWriter = new PrintWriter(stringWriter, false);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "sw.toString()");
        return stringWriter2;
    }

    private final int toValue(Napier.Level level) {
        switch (WhenMappings.$EnumSwitchMapping$0[level.ordinal()]) {
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
