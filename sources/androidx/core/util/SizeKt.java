package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0005H\n\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\n\u001a\r\u0010\u0006\u001a\u00020\u0003*\u00020\u0004H\n\u001a\r\u0010\u0006\u001a\u00020\u0003*\u00020\u0005H\n¨\u0006\u0007"}, d2 = {"component1", "", "Landroid/util/Size;", "", "Landroid/util/SizeF;", "Landroidx/core/util/SizeFCompat;", "component2", "core-ktx_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Size.kt */
public final class SizeKt {
    public static final int component1(Size size) {
        Intrinsics.checkNotNullParameter(size, "<this>");
        return size.getWidth();
    }

    public static final int component2(Size size) {
        Intrinsics.checkNotNullParameter(size, "<this>");
        return size.getHeight();
    }

    public static final float component1(SizeF sizeF) {
        Intrinsics.checkNotNullParameter(sizeF, "<this>");
        return sizeF.getWidth();
    }

    public static final float component2(SizeF sizeF) {
        Intrinsics.checkNotNullParameter(sizeF, "<this>");
        return sizeF.getHeight();
    }

    public static final float component1(SizeFCompat sizeFCompat) {
        Intrinsics.checkNotNullParameter(sizeFCompat, "<this>");
        return sizeFCompat.getWidth();
    }

    public static final float component2(SizeFCompat sizeFCompat) {
        Intrinsics.checkNotNullParameter(sizeFCompat, "<this>");
        return sizeFCompat.getHeight();
    }
}
