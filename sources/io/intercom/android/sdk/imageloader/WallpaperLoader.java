package io.intercom.android.sdk.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import coil.request.ImageRequest;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.BitmapUtilsKt;
import io.intercom.android.sdk.utilities.IntercomCoilKt;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class WallpaperLoader {
    private final Provider<AppConfig> appConfigProvider;

    public static WallpaperLoader create(Context context, Provider<AppConfig> provider) {
        return new WallpaperLoader(provider);
    }

    WallpaperLoader(Provider<AppConfig> provider) {
        this.appConfigProvider = provider;
    }

    public void loadWallpaperInto(ImageView imageView) {
        String wallpaper = this.appConfigProvider.get().getWallpaper();
        if (!TextUtils.isEmpty(wallpaper)) {
            IntercomCoilKt.loadIntercomImage(imageView.getContext(), new ImageRequest.Builder(imageView.getContext()).data(wallpaper).target($$Lambda$WallpaperLoader$eEeNVahP_N8CzoWVHipOEI9uKQM.INSTANCE, $$Lambda$WallpaperLoader$Y75_KZI2cE9_tAl5aGHaIjxJKeA.INSTANCE, new Function1(imageView) {
                public final /* synthetic */ ImageView f$0;

                {
                    this.f$0 = r1;
                }

                public final Object invoke(Object obj) {
                    return WallpaperLoader.lambda$loadWallpaperInto$2(this.f$0, (Drawable) obj);
                }
            }).build());
        }
    }

    static /* synthetic */ Unit lambda$loadWallpaperInto$2(ImageView imageView, Drawable drawable) {
        Bitmap drawableToBitmap = BitmapUtilsKt.drawableToBitmap(drawable, 1, 1);
        drawableToBitmap.setDensity(160);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(imageView.getContext().getResources(), drawableToBitmap);
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        imageView.setBackground(bitmapDrawable);
        return Unit.INSTANCE;
    }

    public void close() throws IOException {
        IntercomCoilKt.cleanUp();
    }
}
