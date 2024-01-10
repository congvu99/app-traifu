package coil;

import android.content.Context;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\r\u0010\u0011\u001a\u00020\u0012H\u0001¢\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0006H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcoil/Coil;", "", "()V", "imageLoader", "Lcoil/ImageLoader;", "imageLoaderFactory", "Lcoil/ImageLoaderFactory;", "enqueue", "Lcoil/request/Disposable;", "request", "Lcoil/request/ImageRequest;", "execute", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "context", "Landroid/content/Context;", "newImageLoader", "reset", "", "reset$coil_singleton_release", "setImageLoader", "factory", "coil-singleton_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Coil.kt */
public final class Coil {
    public static final Coil INSTANCE = new Coil();
    private static ImageLoader imageLoader;
    private static ImageLoaderFactory imageLoaderFactory;

    private Coil() {
    }

    @JvmStatic
    public static final ImageLoader imageLoader(Context context) {
        ImageLoader imageLoader2 = imageLoader;
        return imageLoader2 == null ? INSTANCE.newImageLoader(context) : imageLoader2;
    }

    @JvmStatic
    public static final synchronized void setImageLoader(ImageLoader imageLoader2) {
        synchronized (Coil.class) {
            imageLoaderFactory = null;
            imageLoader = imageLoader2;
        }
    }

    @JvmStatic
    public static final synchronized void setImageLoader(ImageLoaderFactory imageLoaderFactory2) {
        synchronized (Coil.class) {
            imageLoaderFactory = imageLoaderFactory2;
            imageLoader = null;
        }
    }

    private final synchronized ImageLoader newImageLoader(Context context) {
        ImageLoader imageLoader2 = imageLoader;
        if (imageLoader2 != null) {
            return imageLoader2;
        }
        ImageLoaderFactory imageLoaderFactory2 = imageLoaderFactory;
        ImageLoader newImageLoader = imageLoaderFactory2 == null ? null : imageLoaderFactory2.newImageLoader();
        if (newImageLoader == null) {
            Context applicationContext = context.getApplicationContext();
            ImageLoaderFactory imageLoaderFactory3 = applicationContext instanceof ImageLoaderFactory ? (ImageLoaderFactory) applicationContext : null;
            newImageLoader = imageLoaderFactory3 == null ? null : imageLoaderFactory3.newImageLoader();
            if (newImageLoader == null) {
                newImageLoader = ImageLoaders.create(context);
            }
        }
        imageLoaderFactory = null;
        imageLoader = newImageLoader;
        return newImageLoader;
    }

    public final synchronized void reset$coil_singleton_release() {
        imageLoader = null;
        imageLoaderFactory = null;
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.ERROR, message = "Replace with 'context.imageLoader.enqueue(request)'.", replaceWith = @ReplaceWith(expression = "request.context.imageLoader.enqueue(request)", imports = {"coil.imageLoader"}))
    public static final Disposable enqueue(ImageRequest imageRequest) {
        throw new IllegalStateException("Unsupported".toString());
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.ERROR, message = "Replace with 'context.imageLoader.execute(request)'.", replaceWith = @ReplaceWith(expression = "request.context.imageLoader.execute(request)", imports = {"coil.imageLoader"}))
    public static final Object execute(ImageRequest imageRequest, Continuation<? super ImageResult> continuation) {
        throw new IllegalStateException("Unsupported".toString());
    }
}
