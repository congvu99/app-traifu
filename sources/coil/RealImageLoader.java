package coil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import coil.EventListener;
import coil.ImageLoader;
import coil.decode.BitmapFactoryDecoder;
import coil.decode.Decoder;
import coil.disk.DiskCache;
import coil.fetch.AssetUriFetcher;
import coil.fetch.BitmapFetcher;
import coil.fetch.ByteBufferFetcher;
import coil.fetch.ContentUriFetcher;
import coil.fetch.DrawableFetcher;
import coil.fetch.FileFetcher;
import coil.fetch.HttpUriFetcher;
import coil.fetch.ResourceUriFetcher;
import coil.intercept.EngineInterceptor;
import coil.intercept.Interceptor;
import coil.key.FileKeyer;
import coil.key.UriKeyer;
import coil.map.FileUriMapper;
import coil.map.HttpUrlMapper;
import coil.map.ResourceIntMapper;
import coil.map.ResourceUriMapper;
import coil.map.StringMapper;
import coil.memory.MemoryCache;
import coil.request.DefaultRequestOptions;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.OneShotDisposable;
import coil.request.RequestService;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.transition.NoneTransition;
import coil.transition.Transition;
import coil.transition.TransitionTarget;
import coil.util.ImageLoaderOptions;
import coil.util.Logger;
import coil.util.SystemCallbacks;
import coil.util.Utils;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.Call;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \\2\u00020\u0001:\u0001\\Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J\u0019\u0010@\u001a\u00020A2\u0006\u0010>\u001a\u00020?H@ø\u0001\u0000¢\u0006\u0002\u0010BJ!\u0010C\u001a\u00020A2\u0006\u0010D\u001a\u00020?2\u0006\u0010E\u001a\u00020FH@ø\u0001\u0000¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u00020IH\u0016J\u0018\u0010J\u001a\u00020K2\u0006\u0010>\u001a\u00020?2\u0006\u0010L\u001a\u00020MH\u0002J\"\u0010N\u001a\u00020K2\u0006\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010L\u001a\u00020MH\u0002J\"\u0010S\u001a\u00020K2\u0006\u0010O\u001a\u00020T2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010L\u001a\u00020MH\u0002J\u0015\u0010U\u001a\u00020K2\u0006\u0010V\u001a\u00020FH\u0000¢\u0006\u0002\bWJ\b\u0010X\u001a\u00020KH\u0016J1\u0010Y\u001a\u00020K2\u0006\u0010O\u001a\u00020A2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010L\u001a\u00020M2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020K0[H\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010 \u001a\u0004\u0018\u00010\n8VX\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001d\u0010/\u001a\u0004\u0018\u00010\b8VX\u0002¢\u0006\f\n\u0004\b2\u0010$\u001a\u0004\b0\u00101R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u000e\u00106\u001a\u000207X\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006]"}, d2 = {"Lcoil/RealImageLoader;", "Lcoil/ImageLoader;", "context", "Landroid/content/Context;", "defaults", "Lcoil/request/DefaultRequestOptions;", "memoryCacheLazy", "Lkotlin/Lazy;", "Lcoil/memory/MemoryCache;", "diskCacheLazy", "Lcoil/disk/DiskCache;", "callFactoryLazy", "Lokhttp3/Call$Factory;", "eventListenerFactory", "Lcoil/EventListener$Factory;", "componentRegistry", "Lcoil/ComponentRegistry;", "options", "Lcoil/util/ImageLoaderOptions;", "logger", "Lcoil/util/Logger;", "(Landroid/content/Context;Lcoil/request/DefaultRequestOptions;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil/EventListener$Factory;Lcoil/ComponentRegistry;Lcoil/util/ImageLoaderOptions;Lcoil/util/Logger;)V", "getCallFactoryLazy", "()Lkotlin/Lazy;", "getComponentRegistry", "()Lcoil/ComponentRegistry;", "components", "getComponents", "getContext", "()Landroid/content/Context;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "diskCache", "getDiskCache", "()Lcoil/disk/DiskCache;", "diskCache$delegate", "Lkotlin/Lazy;", "getDiskCacheLazy", "getEventListenerFactory", "()Lcoil/EventListener$Factory;", "interceptors", "", "Lcoil/intercept/Interceptor;", "isShutdown", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getLogger", "()Lcoil/util/Logger;", "memoryCache", "getMemoryCache", "()Lcoil/memory/MemoryCache;", "memoryCache$delegate", "getMemoryCacheLazy", "getOptions", "()Lcoil/util/ImageLoaderOptions;", "requestService", "Lcoil/request/RequestService;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "systemCallbacks", "Lcoil/util/SystemCallbacks;", "enqueue", "Lcoil/request/Disposable;", "request", "Lcoil/request/ImageRequest;", "execute", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeMain", "initialRequest", "type", "", "(Lcoil/request/ImageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newBuilder", "Lcoil/ImageLoader$Builder;", "onCancel", "", "eventListener", "Lcoil/EventListener;", "onError", "result", "Lcoil/request/ErrorResult;", "target", "Lcoil/target/Target;", "onSuccess", "Lcoil/request/SuccessResult;", "onTrimMemory", "level", "onTrimMemory$coil_base_release", "shutdown", "transition", "setDrawable", "Lkotlin/Function0;", "Companion", "coil-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RealImageLoader.kt */
public final class RealImageLoader implements ImageLoader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int REQUEST_TYPE_ENQUEUE = 0;
    private static final int REQUEST_TYPE_EXECUTE = 1;
    private static final String TAG = "RealImageLoader";
    private final Lazy<Call.Factory> callFactoryLazy;
    private final ComponentRegistry componentRegistry;
    private final ComponentRegistry components;
    private final Context context;
    private final DefaultRequestOptions defaults;
    private final Lazy diskCache$delegate;
    private final Lazy<DiskCache> diskCacheLazy;
    private final EventListener.Factory eventListenerFactory;
    /* access modifiers changed from: private */
    public final List<Interceptor> interceptors;
    private final AtomicBoolean isShutdown;
    private final Logger logger;
    private final Lazy memoryCache$delegate;
    private final Lazy<MemoryCache> memoryCacheLazy;
    private final ImageLoaderOptions options;
    private final RequestService requestService;
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()).plus(new RealImageLoader$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this)));
    private final SystemCallbacks systemCallbacks;

    public RealImageLoader(Context context2, DefaultRequestOptions defaultRequestOptions, Lazy<? extends MemoryCache> lazy, Lazy<? extends DiskCache> lazy2, Lazy<? extends Call.Factory> lazy3, EventListener.Factory factory, ComponentRegistry componentRegistry2, ImageLoaderOptions imageLoaderOptions, Logger logger2) {
        this.context = context2;
        this.defaults = defaultRequestOptions;
        this.memoryCacheLazy = lazy;
        this.diskCacheLazy = lazy2;
        this.callFactoryLazy = lazy3;
        this.eventListenerFactory = factory;
        this.componentRegistry = componentRegistry2;
        this.options = imageLoaderOptions;
        this.logger = logger2;
        SystemCallbacks systemCallbacks2 = new SystemCallbacks(this, this.context, this.options.getNetworkObserverEnabled());
        this.systemCallbacks = systemCallbacks2;
        ImageLoader imageLoader = this;
        this.requestService = new RequestService(imageLoader, systemCallbacks2, this.logger);
        this.memoryCache$delegate = this.memoryCacheLazy;
        this.diskCache$delegate = this.diskCacheLazy;
        this.components = this.componentRegistry.newBuilder().add(new HttpUrlMapper(), HttpUrl.class).add(new StringMapper(), String.class).add(new FileUriMapper(), Uri.class).add(new ResourceUriMapper(), Uri.class).add(new ResourceIntMapper(), Integer.class).add(new UriKeyer(), Uri.class).add(new FileKeyer(this.options.getAddLastModifiedToFileCacheKey()), File.class).add(new HttpUriFetcher.Factory(this.callFactoryLazy, this.diskCacheLazy, this.options.getRespectCacheHeaders()), Uri.class).add(new FileFetcher.Factory(), File.class).add(new AssetUriFetcher.Factory(), Uri.class).add(new ContentUriFetcher.Factory(), Uri.class).add(new ResourceUriFetcher.Factory(), Uri.class).add(new DrawableFetcher.Factory(), Drawable.class).add(new BitmapFetcher.Factory(), Bitmap.class).add(new ByteBufferFetcher.Factory(), ByteBuffer.class).add((Decoder.Factory) new BitmapFactoryDecoder.Factory(this.options.getBitmapFactoryMaxParallelism())).build();
        this.interceptors = CollectionsKt.plus(getComponents().getInterceptors(), new EngineInterceptor(imageLoader, this.requestService, this.logger));
        this.isShutdown = new AtomicBoolean(false);
    }

    public final Context getContext() {
        return this.context;
    }

    public DefaultRequestOptions getDefaults() {
        return this.defaults;
    }

    public final Lazy<MemoryCache> getMemoryCacheLazy() {
        return this.memoryCacheLazy;
    }

    public final Lazy<DiskCache> getDiskCacheLazy() {
        return this.diskCacheLazy;
    }

    public final Lazy<Call.Factory> getCallFactoryLazy() {
        return this.callFactoryLazy;
    }

    public final EventListener.Factory getEventListenerFactory() {
        return this.eventListenerFactory;
    }

    public final ComponentRegistry getComponentRegistry() {
        return this.componentRegistry;
    }

    public final ImageLoaderOptions getOptions() {
        return this.options;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public MemoryCache getMemoryCache() {
        return (MemoryCache) this.memoryCache$delegate.getValue();
    }

    public DiskCache getDiskCache() {
        return (DiskCache) this.diskCache$delegate.getValue();
    }

    public ComponentRegistry getComponents() {
        return this.components;
    }

    public Disposable enqueue(ImageRequest imageRequest) {
        Deferred async$default = BuildersKt__Builders_commonKt.async$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new RealImageLoader$enqueue$job$1(this, imageRequest, (Continuation<? super RealImageLoader$enqueue$job$1>) null), 3, (Object) null);
        if (imageRequest.getTarget() instanceof ViewTarget) {
            return Utils.getRequestManager(((ViewTarget) imageRequest.getTarget()).getView()).getDisposable(async$default);
        }
        return new OneShotDisposable(async$default);
    }

    public Object execute(ImageRequest imageRequest, Continuation<? super ImageResult> continuation) {
        return CoroutineScopeKt.coroutineScope(new RealImageLoader$execute$2(imageRequest, this, (Continuation<? super RealImageLoader$execute$2>) null), continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: coil.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: coil.request.ImageRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v34, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: coil.request.RequestDelegate} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v35, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: coil.RealImageLoader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v40, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: coil.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v41, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: coil.request.ImageRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v42, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: coil.request.RequestDelegate} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v43, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: coil.RealImageLoader} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fb A[Catch:{ all -> 0x01b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0110 A[Catch:{ all -> 0x01b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0112 A[Catch:{ all -> 0x01b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0121 A[Catch:{ all -> 0x01b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0126 A[Catch:{ all -> 0x01b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x012f A[Catch:{ all -> 0x01b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0130 A[Catch:{ all -> 0x01b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x013c A[Catch:{ all -> 0x01b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x013d A[Catch:{ all -> 0x01b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0159 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x018f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x019a A[Catch:{ all -> 0x004c }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01a5 A[Catch:{ all -> 0x004c }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01cb A[Catch:{ all -> 0x01e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01dc A[SYNTHETIC, Splitter:B:98:0x01dc] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object executeMain(coil.request.ImageRequest r21, int r22, kotlin.coroutines.Continuation<? super coil.request.ImageResult> r23) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r23
            boolean r3 = r2 instanceof coil.RealImageLoader$executeMain$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            coil.RealImageLoader$executeMain$1 r3 = (coil.RealImageLoader$executeMain$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            coil.RealImageLoader$executeMain$1 r3 = new coil.RealImageLoader$executeMain$1
            r3.<init>(r1, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 3
            r7 = 2
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L_0x0098
            if (r5 == r8) goto L_0x0079
            if (r5 == r7) goto L_0x0057
            if (r5 != r6) goto L_0x004f
            java.lang.Object r0 = r3.L$3
            r4 = r0
            coil.EventListener r4 = (coil.EventListener) r4
            java.lang.Object r0 = r3.L$2
            r5 = r0
            coil.request.ImageRequest r5 = (coil.request.ImageRequest) r5
            java.lang.Object r0 = r3.L$1
            r6 = r0
            coil.request.RequestDelegate r6 = (coil.request.RequestDelegate) r6
            java.lang.Object r0 = r3.L$0
            r3 = r0
            coil.RealImageLoader r3 = (coil.RealImageLoader) r3
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x004c }
            goto L_0x0194
        L_0x004c:
            r0 = move-exception
            goto L_0x01c7
        L_0x004f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0057:
            java.lang.Object r0 = r3.L$4
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            java.lang.Object r5 = r3.L$3
            coil.EventListener r5 = (coil.EventListener) r5
            java.lang.Object r7 = r3.L$2
            coil.request.ImageRequest r7 = (coil.request.ImageRequest) r7
            java.lang.Object r8 = r3.L$1
            coil.request.RequestDelegate r8 = (coil.request.RequestDelegate) r8
            java.lang.Object r10 = r3.L$0
            coil.RealImageLoader r10 = (coil.RealImageLoader) r10
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0072 }
            r17 = r0
            goto L_0x0163
        L_0x0072:
            r0 = move-exception
            r4 = r5
            r5 = r7
            r6 = r8
            r3 = r10
            goto L_0x01c7
        L_0x0079:
            java.lang.Object r0 = r3.L$3
            r5 = r0
            coil.EventListener r5 = (coil.EventListener) r5
            java.lang.Object r0 = r3.L$2
            r8 = r0
            coil.request.ImageRequest r8 = (coil.request.ImageRequest) r8
            java.lang.Object r0 = r3.L$1
            r10 = r0
            coil.request.RequestDelegate r10 = (coil.request.RequestDelegate) r10
            java.lang.Object r0 = r3.L$0
            r11 = r0
            coil.RealImageLoader r11 = (coil.RealImageLoader) r11
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0091 }
            goto L_0x00ee
        L_0x0091:
            r0 = move-exception
            r4 = r5
            r5 = r8
            r6 = r10
        L_0x0095:
            r3 = r11
            goto L_0x01c7
        L_0x0098:
            kotlin.ResultKt.throwOnFailure(r2)
            coil.request.RequestService r2 = r1.requestService
            kotlin.coroutines.CoroutineContext r5 = r3.getContext()
            kotlinx.coroutines.Job r5 = kotlinx.coroutines.JobKt.getJob(r5)
            coil.request.RequestDelegate r2 = r2.requestDelegate(r0, r5)
            r2.assertActive()
            coil.request.ImageRequest$Builder r0 = coil.request.ImageRequest.newBuilder$default(r0, r9, r8, r9)
            coil.request.DefaultRequestOptions r5 = r20.getDefaults()
            coil.request.ImageRequest$Builder r0 = r0.defaults(r5)
            coil.request.ImageRequest r5 = r0.build()
            coil.EventListener$Factory r0 = r20.getEventListenerFactory()
            coil.EventListener r10 = r0.create(r5)
            java.lang.Object r0 = r5.getData()     // Catch:{ all -> 0x01c3 }
            coil.request.NullRequestData r11 = coil.request.NullRequestData.INSTANCE     // Catch:{ all -> 0x01c3 }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r11)     // Catch:{ all -> 0x01c3 }
            if (r0 != 0) goto L_0x01bd
            r2.start()     // Catch:{ all -> 0x01c3 }
            if (r22 != 0) goto L_0x00f0
            androidx.lifecycle.Lifecycle r0 = r5.getLifecycle()     // Catch:{ all -> 0x01c3 }
            r3.L$0 = r1     // Catch:{ all -> 0x01c3 }
            r3.L$1 = r2     // Catch:{ all -> 0x01c3 }
            r3.L$2 = r5     // Catch:{ all -> 0x01c3 }
            r3.L$3 = r10     // Catch:{ all -> 0x01c3 }
            r3.label = r8     // Catch:{ all -> 0x01c3 }
            java.lang.Object r0 = coil.util.Lifecycles.awaitStarted(r0, r3)     // Catch:{ all -> 0x01c3 }
            if (r0 != r4) goto L_0x00ea
            return r4
        L_0x00ea:
            r11 = r1
            r8 = r5
            r5 = r10
            r10 = r2
        L_0x00ee:
            r2 = r10
            goto L_0x00f3
        L_0x00f0:
            r11 = r1
            r8 = r5
            r5 = r10
        L_0x00f3:
            coil.memory.MemoryCache r0 = r11.getMemoryCache()     // Catch:{ all -> 0x01b7 }
            if (r0 != 0) goto L_0x00fb
        L_0x00f9:
            r0 = r9
            goto L_0x010e
        L_0x00fb:
            coil.memory.MemoryCache$Key r10 = r8.getPlaceholderMemoryCacheKey()     // Catch:{ all -> 0x01b7 }
            if (r10 != 0) goto L_0x0103
            r0 = r9
            goto L_0x0107
        L_0x0103:
            coil.memory.MemoryCache$Value r0 = r0.get(r10)     // Catch:{ all -> 0x01b7 }
        L_0x0107:
            if (r0 != 0) goto L_0x010a
            goto L_0x00f9
        L_0x010a:
            android.graphics.Bitmap r0 = r0.getBitmap()     // Catch:{ all -> 0x01b7 }
        L_0x010e:
            if (r0 != 0) goto L_0x0112
            r12 = r9
            goto L_0x011f
        L_0x0112:
            android.content.Context r10 = r8.getContext()     // Catch:{ all -> 0x01b7 }
            android.content.res.Resources r10 = r10.getResources()     // Catch:{ all -> 0x01b7 }
            android.graphics.drawable.BitmapDrawable r12 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x01b7 }
            r12.<init>(r10, r0)     // Catch:{ all -> 0x01b7 }
        L_0x011f:
            if (r12 != 0) goto L_0x0126
            android.graphics.drawable.Drawable r10 = r8.getPlaceholder()     // Catch:{ all -> 0x01b7 }
            goto L_0x0129
        L_0x0126:
            r10 = r12
            android.graphics.drawable.Drawable r10 = (android.graphics.drawable.Drawable) r10     // Catch:{ all -> 0x01b7 }
        L_0x0129:
            coil.target.Target r12 = r8.getTarget()     // Catch:{ all -> 0x01b7 }
            if (r12 != 0) goto L_0x0130
            goto L_0x0133
        L_0x0130:
            r12.onStart(r10)     // Catch:{ all -> 0x01b7 }
        L_0x0133:
            r5.onStart(r8)     // Catch:{ all -> 0x01b7 }
            coil.request.ImageRequest$Listener r10 = r8.getListener()     // Catch:{ all -> 0x01b7 }
            if (r10 != 0) goto L_0x013d
            goto L_0x0140
        L_0x013d:
            r10.onStart(r8)     // Catch:{ all -> 0x01b7 }
        L_0x0140:
            r5.resolveSizeStart(r8)     // Catch:{ all -> 0x01b7 }
            coil.size.SizeResolver r10 = r8.getSizeResolver()     // Catch:{ all -> 0x01b7 }
            r3.L$0 = r11     // Catch:{ all -> 0x01b7 }
            r3.L$1 = r2     // Catch:{ all -> 0x01b7 }
            r3.L$2 = r8     // Catch:{ all -> 0x01b7 }
            r3.L$3 = r5     // Catch:{ all -> 0x01b7 }
            r3.L$4 = r0     // Catch:{ all -> 0x01b7 }
            r3.label = r7     // Catch:{ all -> 0x01b7 }
            java.lang.Object r7 = r10.size(r3)     // Catch:{ all -> 0x01b7 }
            if (r7 != r4) goto L_0x015a
            return r4
        L_0x015a:
            r17 = r0
            r10 = r11
            r19 = r8
            r8 = r2
            r2 = r7
            r7 = r19
        L_0x0163:
            r15 = r2
            coil.size.Size r15 = (coil.size.Size) r15     // Catch:{ all -> 0x0072 }
            r5.resolveSizeEnd(r7, r15)     // Catch:{ all -> 0x0072 }
            kotlinx.coroutines.CoroutineDispatcher r0 = r7.getInterceptorDispatcher()     // Catch:{ all -> 0x0072 }
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0     // Catch:{ all -> 0x0072 }
            coil.RealImageLoader$executeMain$result$1 r2 = new coil.RealImageLoader$executeMain$result$1     // Catch:{ all -> 0x0072 }
            r18 = 0
            r12 = r2
            r13 = r7
            r14 = r10
            r16 = r5
            r12.<init>(r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x0072 }
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch:{ all -> 0x0072 }
            r3.L$0 = r10     // Catch:{ all -> 0x0072 }
            r3.L$1 = r8     // Catch:{ all -> 0x0072 }
            r3.L$2 = r7     // Catch:{ all -> 0x0072 }
            r3.L$3 = r5     // Catch:{ all -> 0x0072 }
            r3.L$4 = r9     // Catch:{ all -> 0x0072 }
            r3.label = r6     // Catch:{ all -> 0x0072 }
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.withContext(r0, r2, r3)     // Catch:{ all -> 0x0072 }
            if (r2 != r4) goto L_0x0190
            return r4
        L_0x0190:
            r4 = r5
            r5 = r7
            r6 = r8
            r3 = r10
        L_0x0194:
            coil.request.ImageResult r2 = (coil.request.ImageResult) r2     // Catch:{ all -> 0x004c }
            boolean r0 = r2 instanceof coil.request.SuccessResult     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x01a5
            r0 = r2
            coil.request.SuccessResult r0 = (coil.request.SuccessResult) r0     // Catch:{ all -> 0x004c }
            coil.target.Target r7 = r5.getTarget()     // Catch:{ all -> 0x004c }
            r3.onSuccess(r0, r7, r4)     // Catch:{ all -> 0x004c }
            goto L_0x01b3
        L_0x01a5:
            boolean r0 = r2 instanceof coil.request.ErrorResult     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x01b3
            r0 = r2
            coil.request.ErrorResult r0 = (coil.request.ErrorResult) r0     // Catch:{ all -> 0x004c }
            coil.target.Target r7 = r5.getTarget()     // Catch:{ all -> 0x004c }
            r3.onError(r0, r7, r4)     // Catch:{ all -> 0x004c }
        L_0x01b3:
            r6.complete()
            return r2
        L_0x01b7:
            r0 = move-exception
            r6 = r2
            r4 = r5
            r5 = r8
            goto L_0x0095
        L_0x01bd:
            coil.request.NullRequestDataException r0 = new coil.request.NullRequestDataException     // Catch:{ all -> 0x01c3 }
            r0.<init>()     // Catch:{ all -> 0x01c3 }
            throw r0     // Catch:{ all -> 0x01c3 }
        L_0x01c3:
            r0 = move-exception
            r3 = r1
            r6 = r2
            r4 = r10
        L_0x01c7:
            boolean r2 = r0 instanceof java.util.concurrent.CancellationException     // Catch:{ all -> 0x01e0 }
            if (r2 != 0) goto L_0x01dc
            coil.request.RequestService r2 = r3.requestService     // Catch:{ all -> 0x01e0 }
            coil.request.ErrorResult r0 = r2.errorResult(r5, r0)     // Catch:{ all -> 0x01e0 }
            coil.target.Target r2 = r5.getTarget()     // Catch:{ all -> 0x01e0 }
            r3.onError(r0, r2, r4)     // Catch:{ all -> 0x01e0 }
            r6.complete()
            return r0
        L_0x01dc:
            r3.onCancel(r5, r4)     // Catch:{ all -> 0x01e0 }
            throw r0     // Catch:{ all -> 0x01e0 }
        L_0x01e0:
            r0 = move-exception
            r6.complete()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.executeMain(coil.request.ImageRequest, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onTrimMemory$coil_base_release(int i) {
        MemoryCache value;
        Lazy<MemoryCache> lazy = this.memoryCacheLazy;
        if (lazy != null && (value = lazy.getValue()) != null) {
            value.trimMemory(i);
        }
    }

    public void shutdown() {
        if (!this.isShutdown.getAndSet(true)) {
            CoroutineScopeKt.cancel$default(this.scope, (CancellationException) null, 1, (Object) null);
            this.systemCallbacks.shutdown();
            MemoryCache memoryCache = getMemoryCache();
            if (memoryCache != null) {
                memoryCache.clear();
            }
        }
    }

    public ImageLoader.Builder newBuilder() {
        return new ImageLoader.Builder(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0046, code lost:
        if (r8 == null) goto L_0x0078;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onSuccess(coil.request.SuccessResult r7, coil.target.Target r8, coil.EventListener r9) {
        /*
            r6 = this;
            coil.request.ImageRequest r0 = r7.getRequest()
            coil.decode.DataSource r1 = r7.getDataSource()
            coil.util.Logger r2 = r6.logger
            if (r2 != 0) goto L_0x000d
            goto L_0x0042
        L_0x000d:
            r3 = 4
            int r4 = r2.getLevel()
            if (r4 > r3) goto L_0x0042
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = coil.util.Utils.getEmoji(r1)
            r4.append(r5)
            java.lang.String r5 = " Successful ("
            r4.append(r5)
            java.lang.String r1 = r1.name()
            r4.append(r1)
            java.lang.String r1 = ") - "
            r4.append(r1)
            java.lang.Object r1 = r0.getData()
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r4 = 0
            java.lang.String r5 = "RealImageLoader"
            r2.log(r5, r3, r1, r4)
        L_0x0042:
            boolean r1 = r8 instanceof coil.transition.TransitionTarget
            if (r1 != 0) goto L_0x0049
            if (r8 != 0) goto L_0x005f
            goto L_0x0078
        L_0x0049:
            r1 = r7
            coil.request.ImageResult r1 = (coil.request.ImageResult) r1
            coil.request.ImageRequest r2 = r1.getRequest()
            coil.transition.Transition$Factory r2 = r2.getTransitionFactory()
            r3 = r8
            coil.transition.TransitionTarget r3 = (coil.transition.TransitionTarget) r3
            coil.transition.Transition r2 = r2.create(r3, r1)
            boolean r3 = r2 instanceof coil.transition.NoneTransition
            if (r3 == 0) goto L_0x0067
        L_0x005f:
            android.graphics.drawable.Drawable r1 = r7.getDrawable()
            r8.onSuccess(r1)
            goto L_0x0078
        L_0x0067:
            coil.request.ImageRequest r8 = r1.getRequest()
            r9.transitionStart(r8, r2)
            r2.transition()
            coil.request.ImageRequest r8 = r1.getRequest()
            r9.transitionEnd(r8, r2)
        L_0x0078:
            r9.onSuccess(r0, r7)
            coil.request.ImageRequest$Listener r8 = r0.getListener()
            if (r8 != 0) goto L_0x0082
            goto L_0x0085
        L_0x0082:
            r8.onSuccess(r0, r7)
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.onSuccess(coil.request.SuccessResult, coil.target.Target, coil.EventListener):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003c, code lost:
        if (r8 == null) goto L_0x006e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onError(coil.request.ErrorResult r7, coil.target.Target r8, coil.EventListener r9) {
        /*
            r6 = this;
            coil.request.ImageRequest r0 = r7.getRequest()
            coil.util.Logger r1 = r6.logger
            if (r1 != 0) goto L_0x0009
            goto L_0x0038
        L_0x0009:
            r2 = 4
            int r3 = r1.getLevel()
            if (r3 > r2) goto L_0x0038
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "🚨 Failed - "
            r3.append(r4)
            java.lang.Object r4 = r0.getData()
            r3.append(r4)
            java.lang.String r4 = " - "
            r3.append(r4)
            java.lang.Throwable r4 = r7.getThrowable()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r4 = 0
            java.lang.String r5 = "RealImageLoader"
            r1.log(r5, r2, r3, r4)
        L_0x0038:
            boolean r1 = r8 instanceof coil.transition.TransitionTarget
            if (r1 != 0) goto L_0x003f
            if (r8 != 0) goto L_0x0055
            goto L_0x006e
        L_0x003f:
            r1 = r7
            coil.request.ImageResult r1 = (coil.request.ImageResult) r1
            coil.request.ImageRequest r2 = r1.getRequest()
            coil.transition.Transition$Factory r2 = r2.getTransitionFactory()
            r3 = r8
            coil.transition.TransitionTarget r3 = (coil.transition.TransitionTarget) r3
            coil.transition.Transition r2 = r2.create(r3, r1)
            boolean r3 = r2 instanceof coil.transition.NoneTransition
            if (r3 == 0) goto L_0x005d
        L_0x0055:
            android.graphics.drawable.Drawable r1 = r7.getDrawable()
            r8.onError(r1)
            goto L_0x006e
        L_0x005d:
            coil.request.ImageRequest r8 = r1.getRequest()
            r9.transitionStart(r8, r2)
            r2.transition()
            coil.request.ImageRequest r8 = r1.getRequest()
            r9.transitionEnd(r8, r2)
        L_0x006e:
            r9.onError(r0, r7)
            coil.request.ImageRequest$Listener r8 = r0.getListener()
            if (r8 != 0) goto L_0x0078
            goto L_0x007b
        L_0x0078:
            r8.onError(r0, r7)
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.onError(coil.request.ErrorResult, coil.target.Target, coil.EventListener):void");
    }

    private final void onCancel(ImageRequest imageRequest, EventListener eventListener) {
        Logger logger2 = this.logger;
        if (logger2 != null && logger2.getLevel() <= 4) {
            logger2.log(TAG, 4, Intrinsics.stringPlus("🏗  Cancelled - ", imageRequest.getData()), (Throwable) null);
        }
        eventListener.onCancel(imageRequest);
        ImageRequest.Listener listener = imageRequest.getListener();
        if (listener != null) {
            listener.onCancel(imageRequest);
        }
    }

    private final void transition(ImageResult imageResult, Target target, EventListener eventListener, Function0<Unit> function0) {
        if (!(target instanceof TransitionTarget)) {
            function0.invoke();
            return;
        }
        Transition create = imageResult.getRequest().getTransitionFactory().create((TransitionTarget) target, imageResult);
        if (create instanceof NoneTransition) {
            function0.invoke();
            return;
        }
        eventListener.transitionStart(imageResult.getRequest(), create);
        create.transition();
        eventListener.transitionEnd(imageResult.getRequest(), create);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcoil/RealImageLoader$Companion;", "", "()V", "REQUEST_TYPE_ENQUEUE", "", "REQUEST_TYPE_EXECUTE", "TAG", "", "coil-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RealImageLoader.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
