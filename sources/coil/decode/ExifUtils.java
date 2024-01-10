package coil.decode;

import android.graphics.Paint;
import androidx.exifinterface.media.ExifInterface;
import coil.util.Utils;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import okio.BufferedSource;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0012"}, d2 = {"Lcoil/decode/ExifUtils;", "", "()V", "PAINT", "Landroid/graphics/Paint;", "SUPPORTED_MIME_TYPES", "", "", "[Ljava/lang/String;", "readData", "Lcoil/decode/ExifData;", "mimeType", "source", "Lokio/BufferedSource;", "reverseTransformations", "Landroid/graphics/Bitmap;", "inBitmap", "exifData", "coil-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExifUtils.kt */
public final class ExifUtils {
    public static final ExifUtils INSTANCE = new ExifUtils();
    private static final Paint PAINT = new Paint(3);
    private static final String[] SUPPORTED_MIME_TYPES = {Utils.MIME_TYPE_JPEG, Utils.MIME_TYPE_WEBP, Utils.MIME_TYPE_HEIC, Utils.MIME_TYPE_HEIF};

    private ExifUtils() {
    }

    public final ExifData readData(String str, BufferedSource bufferedSource) {
        if (str == null || !ArraysKt.contains((T[]) SUPPORTED_MIME_TYPES, str)) {
            return ExifData.NONE;
        }
        ExifInterface exifInterface = new ExifInterface((InputStream) new ExifInterfaceInputStream(bufferedSource.peek().inputStream()));
        return new ExifData(exifInterface.isFlipped(), exifInterface.getRotationDegrees());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0063, code lost:
        if (r3 == false) goto L_0x0065;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap reverseTransformations(android.graphics.Bitmap r7, coil.decode.ExifData r8) {
        /*
            r6 = this;
            boolean r0 = r8.isFlipped()
            if (r0 != 0) goto L_0x000d
            boolean r0 = coil.decode.ExifUtilsKt.isRotated(r8)
            if (r0 != 0) goto L_0x000d
            return r7
        L_0x000d:
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            int r1 = r7.getWidth()
            float r1 = (float) r1
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            int r3 = r7.getHeight()
            float r3 = (float) r3
            float r3 = r3 / r2
            boolean r2 = r8.isFlipped()
            if (r2 == 0) goto L_0x002d
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            r4 = 1065353216(0x3f800000, float:1.0)
            r0.postScale(r2, r4, r1, r3)
        L_0x002d:
            boolean r2 = coil.decode.ExifUtilsKt.isRotated(r8)
            if (r2 == 0) goto L_0x003b
            int r2 = r8.getRotationDegrees()
            float r2 = (float) r2
            r0.postRotate(r2, r1, r3)
        L_0x003b:
            android.graphics.RectF r1 = new android.graphics.RectF
            int r2 = r7.getWidth()
            float r2 = (float) r2
            int r3 = r7.getHeight()
            float r3 = (float) r3
            r4 = 0
            r1.<init>(r4, r4, r2, r3)
            r0.mapRect(r1)
            float r2 = r1.left
            r3 = 1
            r5 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0058
            r2 = 1
            goto L_0x0059
        L_0x0058:
            r2 = 0
        L_0x0059:
            if (r2 == 0) goto L_0x0065
            float r2 = r1.top
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r3 = 0
        L_0x0063:
            if (r3 != 0) goto L_0x006e
        L_0x0065:
            float r2 = r1.left
            float r2 = -r2
            float r1 = r1.top
            float r1 = -r1
            r0.postTranslate(r2, r1)
        L_0x006e:
            boolean r8 = coil.decode.ExifUtilsKt.isSwapped(r8)
            java.lang.String r1 = "createBitmap(width, height, config)"
            if (r8 == 0) goto L_0x008a
            int r8 = r7.getHeight()
            int r2 = r7.getWidth()
            android.graphics.Bitmap$Config r3 = coil.util.Bitmaps.getSafeConfig(r7)
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r8, r2, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
            goto L_0x009d
        L_0x008a:
            int r8 = r7.getWidth()
            int r2 = r7.getHeight()
            android.graphics.Bitmap$Config r3 = coil.util.Bitmaps.getSafeConfig(r7)
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r8, r2, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
        L_0x009d:
            android.graphics.Canvas r1 = new android.graphics.Canvas
            r1.<init>(r8)
            android.graphics.Paint r2 = PAINT
            r1.drawBitmap(r7, r0, r2)
            r7.recycle()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.ExifUtils.reverseTransformations(android.graphics.Bitmap, coil.decode.ExifData):android.graphics.Bitmap");
    }
}
