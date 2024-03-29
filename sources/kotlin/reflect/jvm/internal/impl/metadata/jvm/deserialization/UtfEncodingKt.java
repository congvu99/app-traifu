package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: utfEncoding.kt */
public final class UtfEncodingKt {
    public static final byte[] stringsToBytes(String[] strArr) {
        int i;
        Intrinsics.checkNotNullParameter(strArr, "strings");
        boolean z = false;
        int i2 = 0;
        for (String length : strArr) {
            i2 += length.length();
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (String str : strArr) {
            int length2 = str.length() - 1;
            if (length2 >= 0) {
                int i4 = 0;
                while (true) {
                    i = i3 + 1;
                    bArr[i3] = (byte) str.charAt(i4);
                    if (i4 == length2) {
                        break;
                    }
                    i4++;
                    i3 = i;
                }
                i3 = i;
            }
        }
        if (i3 == i2) {
            z = true;
        }
        if (!_Assertions.ENABLED || z) {
            return bArr;
        }
        throw new AssertionError("Should have reached the end");
    }
}
