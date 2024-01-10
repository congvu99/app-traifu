package io.intercom.android.sdk.conversation.composer.galleryinput;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import coil.request.ImageRequest;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.intercom.composer.ImageLoader;
import com.intercom.input.gallery.GalleryImage;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.utilities.IntercomCoilKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lio/intercom/android/sdk/conversation/composer/galleryinput/GalleryImageLoader;", "Lcom/intercom/composer/ImageLoader;", "()V", "clear", "", "imageView", "Landroid/widget/ImageView;", "getBitmapFromDrawable", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "getBitmapFromView", "loadImageIntoView", "image", "Lcom/intercom/input/gallery/GalleryImage;", "view", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GalleryImageLoader.kt */
public final class GalleryImageLoader implements ImageLoader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final GalleryImageLoader create() {
        return Companion.create();
    }

    public void loadImageIntoView(GalleryImage galleryImage, ImageView imageView) {
        Intrinsics.checkNotNullParameter(galleryImage, "image");
        Intrinsics.checkNotNullParameter(imageView, ViewHierarchyConstants.VIEW_KEY);
        String previewPath = galleryImage.getPreviewPath();
        Uri uri = TextUtils.isEmpty(previewPath) ? galleryImage.getUri() : Uri.parse(previewPath);
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        IntercomCoilKt.loadIntercomImage(context, new ImageRequest.Builder(context).data(uri).target(imageView).crossfade(true).placeholder((Drawable) new ColorDrawable(ContextCompat.getColor(context, R.color.intercom_search_bg_grey))).build());
    }

    public void clear(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        IntercomCoilKt.clearIntercomImage(imageView);
    }

    public Bitmap getBitmapFromView(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof TransitionDrawable) {
            TransitionDrawable transitionDrawable = (TransitionDrawable) drawable;
            int numberOfLayers = transitionDrawable.getNumberOfLayers();
            while (true) {
                numberOfLayers--;
                if (-1 >= numberOfLayers) {
                    return null;
                }
                Drawable drawable2 = transitionDrawable.getDrawable(numberOfLayers);
                Intrinsics.checkNotNullExpressionValue(drawable2, "drawable.getDrawable(i)");
                Bitmap bitmapFromDrawable = getBitmapFromDrawable(drawable2);
                if (bitmapFromDrawable != null) {
                    return bitmapFromDrawable;
                }
            }
        } else {
            Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
            return getBitmapFromDrawable(drawable);
        }
    }

    private final Bitmap getBitmapFromDrawable(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lio/intercom/android/sdk/conversation/composer/galleryinput/GalleryImageLoader$Companion;", "", "()V", "create", "Lio/intercom/android/sdk/conversation/composer/galleryinput/GalleryImageLoader;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: GalleryImageLoader.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GalleryImageLoader create() {
            return new GalleryImageLoader();
        }
    }
}
