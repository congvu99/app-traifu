package kotlinx.serialization.internal;

import com.facebook.appevents.AppEventsConstants;
import com.google.common.base.Ascii;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/serialization/internal/InternalHexConverter;", "", "()V", "hexCode", "", "hexToInt", "", "ch", "", "parseHexBinary", "", "s", "printHexBinary", "data", "lowerCase", "", "toHexString", "n", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Platform.common.kt */
public final class InternalHexConverter {
    public static final InternalHexConverter INSTANCE = new InternalHexConverter();
    private static final String hexCode = "0123456789ABCDEF";

    private final int hexToInt(char c) {
        boolean z = true;
        if ('0' <= c && c <= '9') {
            return c - '0';
        }
        char c2 = 'A';
        if (!('A' <= c && c <= 'F')) {
            c2 = 'a';
            if ('a' > c || c > 'f') {
                z = false;
            }
            if (!z) {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    private InternalHexConverter() {
    }

    public final byte[] parseHexBinary(String str) {
        Intrinsics.checkNotNullParameter(str, "s");
        int length = str.length();
        if (length % 2 == 0) {
            byte[] bArr = new byte[(length / 2)];
            int i = 0;
            while (i < length) {
                int hexToInt = hexToInt(str.charAt(i));
                int i2 = i + 1;
                int hexToInt2 = hexToInt(str.charAt(i2));
                if ((hexToInt == -1 || hexToInt2 == -1) ? false : true) {
                    bArr[i / 2] = (byte) ((hexToInt << 4) + hexToInt2);
                    i += 2;
                } else {
                    throw new IllegalArgumentException(("Invalid hex chars: " + str.charAt(i) + str.charAt(i2)).toString());
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("HexBinary string must be even length".toString());
    }

    public static /* synthetic */ String printHexBinary$default(InternalHexConverter internalHexConverter, byte[] bArr, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return internalHexConverter.printHexBinary(bArr, z);
    }

    public final String printHexBinary(byte[] bArr, boolean z) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            byte b = bArr[i];
            i++;
            sb.append(hexCode.charAt((b >> 4) & 15));
            sb.append(hexCode.charAt(b & Ascii.SI));
        }
        if (z) {
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "r.toString()");
            String lowerCase = sb2.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
            return lowerCase;
        }
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "r.toString()");
        return sb3;
    }

    public final String toHexString(int i) {
        byte[] bArr = new byte[4];
        boolean z = false;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            bArr[i2] = (byte) (i >> (24 - (i2 * 8)));
            if (i3 >= 4) {
                break;
            }
            i2 = i3;
        }
        String trimStart = StringsKt.trimStart(printHexBinary(bArr, true), '0');
        if (trimStart.length() > 0) {
            z = true;
        }
        if (!z) {
            trimStart = null;
        }
        return trimStart == null ? AppEventsConstants.EVENT_PARAM_VALUE_NO : trimStart;
    }
}
