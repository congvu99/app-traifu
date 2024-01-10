package com.intercom.commons.utilities;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

public class BitmapUtils {

    public interface BitmapCache {
        Bitmap get(int i, int i2, Bitmap.Config config);
    }

    public static Bitmap transformRound(Bitmap bitmap, BitmapCache bitmapCache) {
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        int width = (bitmap.getWidth() - min) / 2;
        int height = (bitmap.getHeight() - min) / 2;
        Bitmap bitmap2 = bitmapCache.get(min, min, Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        if (!(width == 0 && height == 0)) {
            Matrix matrix = new Matrix();
            matrix.setTranslate((float) (-width), (float) (-height));
            bitmapShader.setLocalMatrix(matrix);
        }
        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);
        float f = ((float) min) / 2.0f;
        canvas.drawCircle(f, f, f, paint);
        return bitmap2;
    }

    public static Bitmap transformRound(Bitmap bitmap, BitmapCache bitmapCache, int i, int i2) {
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        float f = ((float) min) / 2.0f;
        Bitmap bitmap2 = bitmapCache.get(min, min, Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        Canvas canvas = new Canvas(bitmap2);
        int i3 = i2 / 2;
        float width = (float) (((bitmap.getWidth() - i2) / 2) + i3);
        float height = (float) (((bitmap.getHeight() - i2) / 2) + i3);
        float f2 = f - ((float) i2);
        canvas.drawCircle(width, height, f2, paint);
        Paint paint2 = new Paint();
        paint2.setColor(i);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(2.0f);
        canvas.drawCircle(width, height, f2, paint2);
        return bitmap2;
    }

    public static Bitmap transformRoundCorners(Bitmap bitmap, BitmapCache bitmapCache, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmap2 = bitmapCache.get(width, height, Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        float f = (float) i;
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) width, (float) height), f, f, paint);
        return bitmap2;
    }

    public static Bitmap transformRoundCorners(Bitmap bitmap, BitmapCache bitmapCache, int i, int i2, int i3, int i4, int i5) {
        Bitmap bitmap2 = bitmapCache.get(i, i2, Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(Bitmap.createScaledBitmap(bitmap, i, i2, false), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        float f = (float) i5;
        RectF rectF = new RectF(f, f, (float) (i - i5), (float) (i2 - i5));
        float f2 = (float) i3;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        Paint paint2 = new Paint();
        paint2.setColor(i4);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(f);
        canvas.drawRoundRect(rectF, f2, f2, paint2);
        return bitmap2;
    }
}
