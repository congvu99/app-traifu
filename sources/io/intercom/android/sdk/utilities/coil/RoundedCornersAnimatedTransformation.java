package io.intercom.android.sdk.utilities.coil;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import coil.transform.AnimatedTransformation;
import coil.transform.PixelOpacity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lio/intercom/android/sdk/utilities/coil/RoundedCornersAnimatedTransformation;", "Lcoil/transform/AnimatedTransformation;", "radius", "", "(F)V", "getRadius", "()F", "transform", "Lcoil/transform/PixelOpacity;", "canvas", "Landroid/graphics/Canvas;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RoundedCornersAnimatedTransformation.kt */
public final class RoundedCornersAnimatedTransformation implements AnimatedTransformation {
    private final float radius;

    public RoundedCornersAnimatedTransformation(float f) {
        this.radius = f;
    }

    public final float getRadius() {
        return this.radius;
    }

    public PixelOpacity transform(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Paint paint = new Paint(3);
        paint.setColor(0);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        Path path = new Path();
        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        float width = (float) canvas.getWidth();
        float height = (float) canvas.getHeight();
        if (Build.VERSION.SDK_INT >= 21) {
            float f = this.radius;
            path.addRoundRect(0.0f, 0.0f, width, height, f, f, Path.Direction.CW);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            float f2 = this.radius;
            path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
        }
        canvas.drawPath(path, paint);
        return PixelOpacity.TRANSLUCENT;
    }
}
