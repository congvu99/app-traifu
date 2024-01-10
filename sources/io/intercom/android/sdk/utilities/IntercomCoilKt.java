package io.intercom.android.sdk.utilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import coil.ComponentRegistry;
import coil.ImageLoader;
import coil.ImageLoaders;
import coil.decode.Decoder;
import coil.decode.GifDecoder;
import coil.decode.ImageDecoderDecoder;
import coil.decode.VideoFrameDecoder;
import coil.request.ImageRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0000\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"imageLoader", "Lcoil/ImageLoader;", "cleanUp", "", "clearIntercomImage", "imageView", "Landroid/widget/ImageView;", "getImageLoader", "context", "Landroid/content/Context;", "loadIntercomImage", "imageRequest", "Lcoil/request/ImageRequest;", "loadIntercomImageBlocking", "Landroid/graphics/drawable/Drawable;", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomCoil.kt */
public final class IntercomCoilKt {
    private static ImageLoader imageLoader;

    public static final void cleanUp() {
    }

    public static final void loadIntercomImage(Context context, ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        getImageLoader(context).enqueue(imageRequest);
    }

    public static final Drawable loadIntercomImageBlocking(Context context, ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return ImageLoaders.executeBlocking(getImageLoader(context), imageRequest).getDrawable();
    }

    public static final void clearIntercomImage(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "imageView.context");
        ImageRequest build = new ImageRequest.Builder(context).data((Object) null).build();
        Context context2 = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "imageView.context");
        getImageLoader(context2).enqueue(build);
    }

    public static final ImageLoader getImageLoader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (imageLoader == null) {
            ImageLoader.Builder bitmapConfig = new ImageLoader.Builder(context).bitmapConfig(Bitmap.Config.ARGB_8888);
            ComponentRegistry.Builder builder = new ComponentRegistry.Builder();
            if (Build.VERSION.SDK_INT >= 28) {
                builder.add((Decoder.Factory) new ImageDecoderDecoder.Factory(false, 1, (DefaultConstructorMarker) null));
            } else {
                builder.add((Decoder.Factory) new GifDecoder.Factory(false, 1, (DefaultConstructorMarker) null));
            }
            builder.add((Decoder.Factory) new VideoFrameDecoder.Factory());
            imageLoader = bitmapConfig.components(builder.build()).build();
        }
        ImageLoader imageLoader2 = imageLoader;
        Intrinsics.checkNotNull(imageLoader2);
        return imageLoader2;
    }
}
