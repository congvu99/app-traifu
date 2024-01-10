package coil.compose;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.BitmapPainterKt;
import androidx.compose.ui.graphics.painter.ColorPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import coil.ImageLoader;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import coil.size.Precision;
import coil.size.SizeResolver;
import coil.target.Target;
import coil.transition.CrossfadeTransition;
import coil.transition.Transition;
import com.google.accompanist.drawablepainter.DrawablePainter;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 l2\u00020\u00012\u00020\u0002:\u0002lmB\u0017\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010Y\u001a\u0002092\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010Z\u001a\u0002092\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010[\u001a\u00020@H\u0002J\u001a\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010^\u001a\u00020\f2\u0006\u0010_\u001a\u00020\fH\u0002J\b\u0010`\u001a\u00020@H\u0016J\b\u0010a\u001a\u00020@H\u0016J\b\u0010b\u001a\u00020@H\u0016J\u0010\u0010c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010d\u001a\u00020@2\u0006\u0010e\u001a\u00020\fH\u0002J\f\u0010f\u001a\u00020@*\u00020gH\u0014J\f\u0010h\u001a\u00020\u0001*\u00020iH\u0002J\f\u0010j\u001a\u00020\f*\u00020kH\u0002R\"\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0001@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u000e\u0010\u000fR+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118B@BX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R/\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u00198B@BX\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R%\u0010)\u001a\u00020*X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R+\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068F@@X\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0018\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001d\u00105\u001a\u00020(8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b6\u00107R\u001a\u00108\u001a\u000209X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020@\u0018\u00010?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR/\u0010E\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00018B@BX\u0002¢\u0006\u0012\n\u0004\bI\u0010\u0018\u001a\u0004\bF\u0010G\"\u0004\bH\u0010\u000bR\u0010\u0010J\u001a\u0004\u0018\u00010KX\u000e¢\u0006\u0002\n\u0000R+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00048F@@X\u0002¢\u0006\u0012\n\u0004\bP\u0010\u0018\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR+\u0010Q\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f8F@BX\u0002¢\u0006\u0012\n\u0004\bU\u0010\u0018\u001a\u0004\bR\u0010S\"\u0004\bT\u0010\u000fR&\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010B\"\u0004\bX\u0010D\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006n"}, d2 = {"Lcoil/compose/AsyncImagePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/RememberObserver;", "request", "Lcoil/request/ImageRequest;", "imageLoader", "Lcoil/ImageLoader;", "(Lcoil/request/ImageRequest;Lcoil/ImageLoader;)V", "value", "_painter", "set_painter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "Lcoil/compose/AsyncImagePainter$State;", "_state", "set_state", "(Lcoil/compose/AsyncImagePainter$State;)V", "<set-?>", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "alpha$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "colorFilter$delegate", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "getContentScale$coil_compose_base_release", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale$coil_compose_base_release", "(Landroidx/compose/ui/layout/ContentScale;)V", "drawSize", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/ui/geometry/Size;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getFilterQuality-f-v9h1I$coil_compose_base_release", "()I", "setFilterQuality-vDHp3xo$coil_compose_base_release", "(I)V", "I", "getImageLoader", "()Lcoil/ImageLoader;", "setImageLoader$coil_compose_base_release", "(Lcoil/ImageLoader;)V", "imageLoader$delegate", "intrinsicSize", "getIntrinsicSize-NH-jbRc", "()J", "isPreview", "", "isPreview$coil_compose_base_release", "()Z", "setPreview$coil_compose_base_release", "(Z)V", "onState", "Lkotlin/Function1;", "", "getOnState$coil_compose_base_release", "()Lkotlin/jvm/functions/Function1;", "setOnState$coil_compose_base_release", "(Lkotlin/jvm/functions/Function1;)V", "painter", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "painter$delegate", "rememberScope", "Lkotlinx/coroutines/CoroutineScope;", "getRequest", "()Lcoil/request/ImageRequest;", "setRequest$coil_compose_base_release", "(Lcoil/request/ImageRequest;)V", "request$delegate", "state", "getState", "()Lcoil/compose/AsyncImagePainter$State;", "setState", "state$delegate", "transform", "getTransform$coil_compose_base_release", "setTransform$coil_compose_base_release", "applyAlpha", "applyColorFilter", "clear", "maybeNewCrossfadePainter", "Lcoil/compose/CrossfadePainter;", "previous", "current", "onAbandoned", "onForgotten", "onRemembered", "updateRequest", "updateState", "input", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "toPainter", "Landroid/graphics/drawable/Drawable;", "toState", "Lcoil/request/ImageResult;", "Companion", "State", "coil-compose-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AsyncImagePainter.kt */
public final class AsyncImagePainter extends Painter implements RememberObserver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Function1<State, State> DefaultTransform = AsyncImagePainter$Companion$DefaultTransform$1.INSTANCE;
    private Painter _painter;
    private State _state = State.Empty.INSTANCE;
    private final MutableState alpha$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState colorFilter$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private ContentScale contentScale = ContentScale.Companion.getFit();
    /* access modifiers changed from: private */
    public final MutableStateFlow<Size> drawSize = StateFlowKt.MutableStateFlow(Size.m1740boximpl(Size.Companion.m1761getZeroNHjbRc()));
    private int filterQuality = DrawScope.Companion.m2518getDefaultFilterQualityfv9h1I();
    private final MutableState imageLoader$delegate;
    private boolean isPreview;
    private Function1<? super State, Unit> onState;
    private final MutableState painter$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private CoroutineScope rememberScope;
    private final MutableState request$delegate;
    private final MutableState state$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(State.Empty.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
    private Function1<? super State, ? extends State> transform = DefaultTransform;

    public AsyncImagePainter(ImageRequest imageRequest, ImageLoader imageLoader) {
        this.request$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(imageRequest, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.imageLoader$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(imageLoader, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private final Painter getPainter() {
        return (Painter) this.painter$delegate.getValue();
    }

    private final void setPainter(Painter painter) {
        this.painter$delegate.setValue(painter);
    }

    private final float getAlpha() {
        return ((Number) this.alpha$delegate.getValue()).floatValue();
    }

    private final void setAlpha(float f) {
        this.alpha$delegate.setValue(Float.valueOf(f));
    }

    private final ColorFilter getColorFilter() {
        return (ColorFilter) this.colorFilter$delegate.getValue();
    }

    private final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter$delegate.setValue(colorFilter);
    }

    private final void set_state(State state) {
        this._state = state;
        setState(state);
    }

    private final void set_painter(Painter painter) {
        this._painter = painter;
        setPainter(painter);
    }

    public final Function1<State, State> getTransform$coil_compose_base_release() {
        return this.transform;
    }

    public final void setTransform$coil_compose_base_release(Function1<? super State, ? extends State> function1) {
        this.transform = function1;
    }

    public final Function1<State, Unit> getOnState$coil_compose_base_release() {
        return this.onState;
    }

    public final void setOnState$coil_compose_base_release(Function1<? super State, Unit> function1) {
        this.onState = function1;
    }

    public final ContentScale getContentScale$coil_compose_base_release() {
        return this.contentScale;
    }

    public final void setContentScale$coil_compose_base_release(ContentScale contentScale2) {
        this.contentScale = contentScale2;
    }

    /* renamed from: getFilterQuality-f-v9h1I$coil_compose_base_release  reason: not valid java name */
    public final int m4992getFilterQualityfv9h1I$coil_compose_base_release() {
        return this.filterQuality;
    }

    /* renamed from: setFilterQuality-vDHp3xo$coil_compose_base_release  reason: not valid java name */
    public final void m4994setFilterQualityvDHp3xo$coil_compose_base_release(int i) {
        this.filterQuality = i;
    }

    public final boolean isPreview$coil_compose_base_release() {
        return this.isPreview;
    }

    public final void setPreview$coil_compose_base_release(boolean z) {
        this.isPreview = z;
    }

    private final void setState(State state) {
        this.state$delegate.setValue(state);
    }

    public final State getState() {
        return (State) this.state$delegate.getValue();
    }

    public final ImageRequest getRequest() {
        return (ImageRequest) this.request$delegate.getValue();
    }

    public final void setRequest$coil_compose_base_release(ImageRequest imageRequest) {
        this.request$delegate.setValue(imageRequest);
    }

    public final ImageLoader getImageLoader() {
        return (ImageLoader) this.imageLoader$delegate.getValue();
    }

    public final void setImageLoader$coil_compose_base_release(ImageLoader imageLoader) {
        this.imageLoader$delegate.setValue(imageLoader);
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m4993getIntrinsicSizeNHjbRc() {
        Painter painter = getPainter();
        Size r0 = painter == null ? null : Size.m1740boximpl(painter.m2613getIntrinsicSizeNHjbRc());
        return r0 == null ? Size.Companion.m1760getUnspecifiedNHjbRc() : r0.m1757unboximpl();
    }

    /* access modifiers changed from: protected */
    public void onDraw(DrawScope drawScope) {
        this.drawSize.setValue(Size.m1740boximpl(drawScope.m2478getSizeNHjbRc()));
        Painter painter = getPainter();
        if (painter != null) {
            painter.m2612drawx_KDEd0(drawScope, drawScope.m2478getSizeNHjbRc(), getAlpha(), getColorFilter());
        }
    }

    /* access modifiers changed from: protected */
    public boolean applyAlpha(float f) {
        setAlpha(f);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean applyColorFilter(ColorFilter colorFilter) {
        setColorFilter(colorFilter);
        return true;
    }

    public void onRemembered() {
        if (this.rememberScope == null) {
            Painter painter = null;
            CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
            this.rememberScope = CoroutineScope;
            Painter painter2 = this._painter;
            RememberObserver rememberObserver = painter2 instanceof RememberObserver ? (RememberObserver) painter2 : null;
            if (rememberObserver != null) {
                rememberObserver.onRemembered();
            }
            if (this.isPreview) {
                Drawable placeholder = ImageRequest.newBuilder$default(getRequest(), (Context) null, 1, (Object) null).defaults(getImageLoader().getDefaults()).build().getPlaceholder();
                if (placeholder != null) {
                    painter = toPainter(placeholder);
                }
                updateState(new State.Loading(painter));
                return;
            }
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AsyncImagePainter$onRemembered$1(this, (Continuation<? super AsyncImagePainter$onRemembered$1>) null), 3, (Object) null);
        }
    }

    public void onForgotten() {
        clear();
        Painter painter = this._painter;
        RememberObserver rememberObserver = painter instanceof RememberObserver ? (RememberObserver) painter : null;
        if (rememberObserver != null) {
            rememberObserver.onForgotten();
        }
    }

    public void onAbandoned() {
        clear();
        Painter painter = this._painter;
        RememberObserver rememberObserver = painter instanceof RememberObserver ? (RememberObserver) painter : null;
        if (rememberObserver != null) {
            rememberObserver.onAbandoned();
        }
    }

    private final void clear() {
        CoroutineScope coroutineScope = this.rememberScope;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel$default(coroutineScope, (CancellationException) null, 1, (Object) null);
        }
        this.rememberScope = null;
    }

    /* access modifiers changed from: private */
    public final ImageRequest updateRequest(ImageRequest imageRequest) {
        ImageRequest.Builder target = ImageRequest.newBuilder$default(imageRequest, (Context) null, 1, (Object) null).target((Target) new AsyncImagePainter$updateRequest$$inlined$target$default$1(this));
        if (imageRequest.getDefined().getSizeResolver() == null) {
            target.size((SizeResolver) new AsyncImagePainter$updateRequest$2$1(this));
        }
        if (imageRequest.getDefined().getScale() == null) {
            target.scale(UtilsKt.toScale(getContentScale$coil_compose_base_release()));
        }
        if (imageRequest.getDefined().getPrecision() != Precision.EXACT) {
            target.precision(Precision.INEXACT);
        }
        return target.build();
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [androidx.compose.ui.graphics.painter.Painter] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateState(coil.compose.AsyncImagePainter.State r4) {
        /*
            r3 = this;
            coil.compose.AsyncImagePainter$State r0 = r3._state
            kotlin.jvm.functions.Function1<? super coil.compose.AsyncImagePainter$State, ? extends coil.compose.AsyncImagePainter$State> r1 = r3.transform
            java.lang.Object r4 = r1.invoke(r4)
            coil.compose.AsyncImagePainter$State r4 = (coil.compose.AsyncImagePainter.State) r4
            r3.set_state(r4)
            coil.compose.CrossfadePainter r1 = r3.maybeNewCrossfadePainter(r0, r4)
            if (r1 != 0) goto L_0x0018
            androidx.compose.ui.graphics.painter.Painter r1 = r4.getPainter()
            goto L_0x001a
        L_0x0018:
            androidx.compose.ui.graphics.painter.Painter r1 = (androidx.compose.ui.graphics.painter.Painter) r1
        L_0x001a:
            r3.set_painter(r1)
            kotlinx.coroutines.CoroutineScope r1 = r3.rememberScope
            if (r1 == 0) goto L_0x004f
            androidx.compose.ui.graphics.painter.Painter r1 = r0.getPainter()
            androidx.compose.ui.graphics.painter.Painter r2 = r4.getPainter()
            if (r1 == r2) goto L_0x004f
            androidx.compose.ui.graphics.painter.Painter r0 = r0.getPainter()
            boolean r1 = r0 instanceof androidx.compose.runtime.RememberObserver
            r2 = 0
            if (r1 == 0) goto L_0x0037
            androidx.compose.runtime.RememberObserver r0 = (androidx.compose.runtime.RememberObserver) r0
            goto L_0x0038
        L_0x0037:
            r0 = r2
        L_0x0038:
            if (r0 != 0) goto L_0x003b
            goto L_0x003e
        L_0x003b:
            r0.onForgotten()
        L_0x003e:
            androidx.compose.ui.graphics.painter.Painter r0 = r4.getPainter()
            boolean r1 = r0 instanceof androidx.compose.runtime.RememberObserver
            if (r1 == 0) goto L_0x0049
            r2 = r0
            androidx.compose.runtime.RememberObserver r2 = (androidx.compose.runtime.RememberObserver) r2
        L_0x0049:
            if (r2 != 0) goto L_0x004c
            goto L_0x004f
        L_0x004c:
            r2.onRemembered()
        L_0x004f:
            kotlin.jvm.functions.Function1<? super coil.compose.AsyncImagePainter$State, kotlin.Unit> r0 = r3.onState
            if (r0 != 0) goto L_0x0054
            goto L_0x0057
        L_0x0054:
            r0.invoke(r4)
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.compose.AsyncImagePainter.updateState(coil.compose.AsyncImagePainter$State):void");
    }

    private final CrossfadePainter maybeNewCrossfadePainter(State state, State state2) {
        ImageResult imageResult;
        if (state2 instanceof State.Success) {
            imageResult = ((State.Success) state2).getResult();
        } else {
            if (state2 instanceof State.Error) {
                imageResult = ((State.Error) state2).getResult();
            }
            return null;
        }
        Transition create = imageResult.getRequest().getTransitionFactory().create(AsyncImagePainterKt.FakeTransitionTarget, imageResult);
        if (create instanceof CrossfadeTransition) {
            CrossfadeTransition crossfadeTransition = (CrossfadeTransition) create;
            return new CrossfadePainter(state instanceof State.Loading ? state.getPainter() : null, state2.getPainter(), this.contentScale, crossfadeTransition.getDurationMillis(), !(imageResult instanceof SuccessResult) || !((SuccessResult) imageResult).isPlaceholderCached(), crossfadeTransition.getPreferExactIntrinsicSize());
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final State toState(ImageResult imageResult) {
        if (imageResult instanceof SuccessResult) {
            SuccessResult successResult = (SuccessResult) imageResult;
            return new State.Success(toPainter(successResult.getDrawable()), successResult);
        } else if (imageResult instanceof ErrorResult) {
            Drawable drawable = imageResult.getDrawable();
            return new State.Error(drawable == null ? null : toPainter(drawable), (ErrorResult) imageResult);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    public final Painter toPainter(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return BitmapPainterKt.m2607BitmapPainterQZhYCtY$default(AndroidImageBitmap_androidKt.asImageBitmap(((BitmapDrawable) drawable).getBitmap()), 0, 0, m4992getFilterQualityfv9h1I$coil_compose_base_release(), 6, (Object) null);
        }
        if (drawable instanceof ColorDrawable) {
            return new ColorPainter(ColorKt.Color(((ColorDrawable) drawable).getColor()), (DefaultConstructorMarker) null);
        }
        return new DrawablePainter(drawable.mutate());
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcoil/compose/AsyncImagePainter$State;", "", "()V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "Empty", "Error", "Loading", "Success", "Lcoil/compose/AsyncImagePainter$State$Empty;", "Lcoil/compose/AsyncImagePainter$State$Loading;", "Lcoil/compose/AsyncImagePainter$State$Success;", "Lcoil/compose/AsyncImagePainter$State$Error;", "coil-compose-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AsyncImagePainter.kt */
    public static abstract class State {
        public static final int $stable = 0;

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract Painter getPainter();

        private State() {
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcoil/compose/AsyncImagePainter$State$Empty;", "Lcoil/compose/AsyncImagePainter$State;", "()V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "coil-compose-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AsyncImagePainter.kt */
        public static final class Empty extends State {
            public static final int $stable = 0;
            public static final Empty INSTANCE = new Empty();

            public Painter getPainter() {
                return null;
            }

            private Empty() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcoil/compose/AsyncImagePainter$State$Loading;", "Lcoil/compose/AsyncImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AsyncImagePainter.kt */
        public static final class Loading extends State {
            public static final int $stable = 8;
            private final Painter painter;

            public static /* synthetic */ Loading copy$default(Loading loading, Painter painter2, int i, Object obj) {
                if ((i & 1) != 0) {
                    painter2 = loading.getPainter();
                }
                return loading.copy(painter2);
            }

            public final Painter component1() {
                return getPainter();
            }

            public final Loading copy(Painter painter2) {
                return new Loading(painter2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Loading) && Intrinsics.areEqual((Object) getPainter(), (Object) ((Loading) obj).getPainter());
            }

            public int hashCode() {
                if (getPainter() == null) {
                    return 0;
                }
                return getPainter().hashCode();
            }

            public String toString() {
                return "Loading(painter=" + getPainter() + ')';
            }

            public Painter getPainter() {
                return this.painter;
            }

            public Loading(Painter painter2) {
                super((DefaultConstructorMarker) null);
                this.painter = painter2;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcoil/compose/AsyncImagePainter$State$Success;", "Lcoil/compose/AsyncImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "result", "Lcoil/request/SuccessResult;", "(Landroidx/compose/ui/graphics/painter/Painter;Lcoil/request/SuccessResult;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getResult", "()Lcoil/request/SuccessResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AsyncImagePainter.kt */
        public static final class Success extends State {
            public static final int $stable = 8;
            private final Painter painter;
            private final SuccessResult result;

            public static /* synthetic */ Success copy$default(Success success, Painter painter2, SuccessResult successResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    painter2 = success.getPainter();
                }
                if ((i & 2) != 0) {
                    successResult = success.result;
                }
                return success.copy(painter2, successResult);
            }

            public final Painter component1() {
                return getPainter();
            }

            public final SuccessResult component2() {
                return this.result;
            }

            public final Success copy(Painter painter2, SuccessResult successResult) {
                return new Success(painter2, successResult);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Success)) {
                    return false;
                }
                Success success = (Success) obj;
                return Intrinsics.areEqual((Object) getPainter(), (Object) success.getPainter()) && Intrinsics.areEqual((Object) this.result, (Object) success.result);
            }

            public int hashCode() {
                return (getPainter().hashCode() * 31) + this.result.hashCode();
            }

            public String toString() {
                return "Success(painter=" + getPainter() + ", result=" + this.result + ')';
            }

            public Painter getPainter() {
                return this.painter;
            }

            public final SuccessResult getResult() {
                return this.result;
            }

            public Success(Painter painter2, SuccessResult successResult) {
                super((DefaultConstructorMarker) null);
                this.painter = painter2;
                this.result = successResult;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcoil/compose/AsyncImagePainter$State$Error;", "Lcoil/compose/AsyncImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "result", "Lcoil/request/ErrorResult;", "(Landroidx/compose/ui/graphics/painter/Painter;Lcoil/request/ErrorResult;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getResult", "()Lcoil/request/ErrorResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AsyncImagePainter.kt */
        public static final class Error extends State {
            public static final int $stable = 8;
            private final Painter painter;
            private final ErrorResult result;

            public static /* synthetic */ Error copy$default(Error error, Painter painter2, ErrorResult errorResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    painter2 = error.getPainter();
                }
                if ((i & 2) != 0) {
                    errorResult = error.result;
                }
                return error.copy(painter2, errorResult);
            }

            public final Painter component1() {
                return getPainter();
            }

            public final ErrorResult component2() {
                return this.result;
            }

            public final Error copy(Painter painter2, ErrorResult errorResult) {
                return new Error(painter2, errorResult);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Error)) {
                    return false;
                }
                Error error = (Error) obj;
                return Intrinsics.areEqual((Object) getPainter(), (Object) error.getPainter()) && Intrinsics.areEqual((Object) this.result, (Object) error.result);
            }

            public int hashCode() {
                return ((getPainter() == null ? 0 : getPainter().hashCode()) * 31) + this.result.hashCode();
            }

            public String toString() {
                return "Error(painter=" + getPainter() + ", result=" + this.result + ')';
            }

            public Painter getPainter() {
                return this.painter;
            }

            public final ErrorResult getResult() {
                return this.result;
            }

            public Error(Painter painter2, ErrorResult errorResult) {
                super((DefaultConstructorMarker) null);
                this.painter = painter2;
                this.result = errorResult;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcoil/compose/AsyncImagePainter$Companion;", "", "()V", "DefaultTransform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "getDefaultTransform", "()Lkotlin/jvm/functions/Function1;", "coil-compose-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AsyncImagePainter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function1<State, State> getDefaultTransform() {
            return AsyncImagePainter.DefaultTransform;
        }
    }
}
