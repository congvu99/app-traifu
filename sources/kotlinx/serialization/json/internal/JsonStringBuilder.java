package kotlinx.serialization.json.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\u0006\u0010\u0017\u001a\u00020\bJ\b\u0010\u0018\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlinx/serialization/json/internal/JsonStringBuilder;", "", "()V", "array", "", "size", "", "append", "", "ch", "", "value", "", "string", "", "appendQuoted", "appendStringSlowPath", "firstEscapedChar", "currentSize", "ensureAdditionalCapacity", "expected", "ensureTotalCapacity", "newSize", "release", "toString", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: JsonStringBuilder.kt */
public final class JsonStringBuilder {
    private char[] array = CharArrayPool.INSTANCE.take();
    private int size;

    public final void append(long j) {
        append(String.valueOf(j));
    }

    public final void append(char c) {
        ensureAdditionalCapacity(1);
        char[] cArr = this.array;
        int i = this.size;
        this.size = i + 1;
        cArr[i] = c;
    }

    public final void append(String str) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        int length = str.length();
        ensureAdditionalCapacity(length);
        str.getChars(0, str.length(), this.array, this.size);
        this.size += length;
    }

    public final void appendQuoted(String str) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        ensureAdditionalCapacity(str.length() + 2);
        char[] cArr = this.array;
        int i = this.size;
        int i2 = i + 1;
        cArr[i] = '\"';
        int length = str.length();
        str.getChars(0, length, cArr, i2);
        int i3 = length + i2;
        if (i2 < i3) {
            int i4 = i2;
            while (true) {
                int i5 = i4 + 1;
                char c = cArr[i4];
                if (c < StringOpsKt.getESCAPE_MARKERS().length && StringOpsKt.getESCAPE_MARKERS()[c] != 0) {
                    appendStringSlowPath(i4 - i2, i4, str);
                    return;
                } else if (i5 >= i3) {
                    break;
                } else {
                    i4 = i5;
                }
            }
        }
        cArr[i3] = '\"';
        this.size = i3 + 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0072 A[LOOP:0: B:2:0x0006->B:18:0x0072, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0074 A[EDGE_INSN: B:22:0x0074->B:19:0x0074 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void appendStringSlowPath(int r6, int r7, java.lang.String r8) {
        /*
            r5 = this;
            int r0 = r8.length()
            if (r6 >= r0) goto L_0x0074
        L_0x0006:
            int r1 = r6 + 1
            int r2 = r7 + 2
            r5.ensureTotalCapacity(r2)
            char r6 = r8.charAt(r6)
            byte[] r3 = kotlinx.serialization.json.internal.StringOpsKt.getESCAPE_MARKERS()
            int r3 = r3.length
            if (r6 >= r3) goto L_0x0067
            byte[] r3 = kotlinx.serialization.json.internal.StringOpsKt.getESCAPE_MARKERS()
            byte r3 = r3[r6]
            if (r3 != 0) goto L_0x0028
            char[] r2 = r5.array
            int r3 = r7 + 1
            char r6 = (char) r6
            r2[r7] = r6
            goto L_0x006e
        L_0x0028:
            r4 = 1
            if (r3 != r4) goto L_0x0058
            java.lang.String[] r2 = kotlinx.serialization.json.internal.StringOpsKt.getESCAPE_STRINGS()
            r6 = r2[r6]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            int r2 = r6.length()
            int r2 = r2 + r7
            r5.ensureTotalCapacity(r2)
            char[] r2 = r5.array
            r3 = 0
            int r4 = r6.length()
            if (r6 == 0) goto L_0x0050
            r6.getChars(r3, r4, r2, r7)
            int r6 = r6.length()
            int r7 = r7 + r6
            r5.size = r7
            goto L_0x006f
        L_0x0050:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r7 = "null cannot be cast to non-null type java.lang.String"
            r6.<init>(r7)
            throw r6
        L_0x0058:
            char[] r6 = r5.array
            r4 = 92
            r6[r7] = r4
            int r7 = r7 + 1
            char r3 = (char) r3
            r6[r7] = r3
            r5.size = r2
            r7 = r2
            goto L_0x006f
        L_0x0067:
            char[] r2 = r5.array
            int r3 = r7 + 1
            char r6 = (char) r6
            r2[r7] = r6
        L_0x006e:
            r7 = r3
        L_0x006f:
            if (r1 < r0) goto L_0x0072
            goto L_0x0074
        L_0x0072:
            r6 = r1
            goto L_0x0006
        L_0x0074:
            int r6 = r7 + 1
            r5.ensureTotalCapacity(r6)
            char[] r8 = r5.array
            r0 = 34
            r8[r7] = r0
            r5.size = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonStringBuilder.appendStringSlowPath(int, int, java.lang.String):void");
    }

    public String toString() {
        return new String(this.array, 0, this.size);
    }

    private final void ensureAdditionalCapacity(int i) {
        ensureTotalCapacity(this.size + i);
    }

    private final void ensureTotalCapacity(int i) {
        char[] cArr = this.array;
        if (cArr.length <= i) {
            char[] copyOf = Arrays.copyOf(cArr, RangesKt.coerceAtLeast(i, this.size * 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            this.array = copyOf;
        }
    }

    public final void release() {
        CharArrayPool.INSTANCE.release(this.array);
    }
}
