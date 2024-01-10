package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.NestedScrollInteropConnectionKt;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.VelocityKt;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\u0015\b \u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010M\u001a\u00020\u00122\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\n\u0010P\u001a\u0004\u0018\u00010QH\u0016J\b\u0010R\u001a\u00020\u0014H\u0016J\u001e\u0010S\u001a\u0004\u0018\u00010T2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\b\u0010W\u001a\u00020\u0012H\u0016J \u0010X\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\u00142\u0006\u0010[\u001a\u00020\u0014H\u0002J\b\u0010\\\u001a\u00020,H\u0014J\u0018\u0010]\u001a\u00020,2\u0006\u0010^\u001a\u00020G2\u0006\u0010_\u001a\u00020GH\u0016J\b\u0010`\u001a\u00020,H\u0014J0\u0010a\u001a\u00020,2\u0006\u0010b\u001a\u00020\u00122\u0006\u0010c\u001a\u00020\u00142\u0006\u0010d\u001a\u00020\u00142\u0006\u0010e\u001a\u00020\u00142\u0006\u0010f\u001a\u00020\u0014H\u0014J\u0018\u0010g\u001a\u00020,2\u0006\u0010h\u001a\u00020\u00142\u0006\u0010i\u001a\u00020\u0014H\u0014J(\u0010j\u001a\u00020\u00122\u0006\u0010_\u001a\u00020G2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020l2\u0006\u0010n\u001a\u00020\u0012H\u0016J \u0010o\u001a\u00020\u00122\u0006\u0010_\u001a\u00020G2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020lH\u0016J0\u0010p\u001a\u00020,2\u0006\u0010_\u001a\u00020G2\u0006\u0010q\u001a\u00020\u00142\u0006\u0010r\u001a\u00020\u00142\u0006\u0010n\u001a\u00020!2\u0006\u0010s\u001a\u00020\u0014H\u0016J8\u0010t\u001a\u00020,2\u0006\u0010_\u001a\u00020G2\u0006\u0010u\u001a\u00020\u00142\u0006\u0010v\u001a\u00020\u00142\u0006\u0010w\u001a\u00020\u00142\u0006\u0010x\u001a\u00020\u00142\u0006\u0010s\u001a\u00020\u0014H\u0016J@\u0010t\u001a\u00020,2\u0006\u0010_\u001a\u00020G2\u0006\u0010u\u001a\u00020\u00142\u0006\u0010v\u001a\u00020\u00142\u0006\u0010w\u001a\u00020\u00142\u0006\u0010x\u001a\u00020\u00142\u0006\u0010s\u001a\u00020\u00142\u0006\u0010n\u001a\u00020!H\u0016J(\u0010y\u001a\u00020,2\u0006\u0010^\u001a\u00020G2\u0006\u0010_\u001a\u00020G2\u0006\u0010z\u001a\u00020\u00142\u0006\u0010s\u001a\u00020\u0014H\u0016J(\u0010{\u001a\u00020\u00122\u0006\u0010^\u001a\u00020G2\u0006\u0010_\u001a\u00020G2\u0006\u0010z\u001a\u00020\u00142\u0006\u0010s\u001a\u00020\u0014H\u0016J\u0018\u0010|\u001a\u00020,2\u0006\u0010_\u001a\u00020G2\u0006\u0010s\u001a\u00020\u0014H\u0016J\u0006\u0010}\u001a\u00020,J\u0010\u0010~\u001a\u00020,2\u0006\u0010\u001a\u00020\u0012H\u0016J\t\u0010\u0001\u001a\u00020\u0012H\u0016R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R(\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\n\u001a\u0004\u0018\u00010\u001a@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R$\u0010#\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\"@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020,0+X\u0004¢\u0006\u0002\n\u0000R(\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020,\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00102\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020,\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R(\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020,\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020,09X\u0004¢\u0006\u0002\n\u0000R(\u0010;\u001a\u0004\u0018\u00010:2\b\u0010\n\u001a\u0004\u0018\u00010:@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u000e\u0010@\u001a\u00020AX\u0004¢\u0006\u0002\n\u0000R0\u0010B\u001a\b\u0012\u0004\u0012\u00020,092\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020,09@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR(\u0010H\u001a\u0004\u0018\u00010G2\b\u0010\n\u001a\u0004\u0018\u00010G@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroid/view/ViewGroup;", "Landroidx/core/view/NestedScrollingParent3;", "context", "Landroid/content/Context;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroid/content/Context;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "hasUpdateBlock", "", "lastHeightMeasureSpec", "", "lastWidthMeasureSpec", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "location", "", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "nestedScrollingParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "onCommitAffectingUpdate", "Lkotlin/Function1;", "", "onDensityChanged", "getOnDensityChanged$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnDensityChanged$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onModifierChanged", "getOnModifierChanged$ui_release", "setOnModifierChanged$ui_release", "onRequestDisallowInterceptTouchEvent", "getOnRequestDisallowInterceptTouchEvent$ui_release", "setOnRequestDisallowInterceptTouchEvent$ui_release", "runUpdate", "Lkotlin/Function0;", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedStateRegistryOwner", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "setSavedStateRegistryOwner", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "snapshotObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "update", "getUpdate", "()Lkotlin/jvm/functions/Function0;", "setUpdate", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/View;", "view", "getView", "()Landroid/view/View;", "setView$ui_release", "(Landroid/view/View;)V", "gatherTransparentRegion", "region", "Landroid/graphics/Region;", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getNestedScrollAxes", "invalidateChildInParent", "Landroid/view/ViewParent;", "dirty", "Landroid/graphics/Rect;", "isNestedScrollingEnabled", "obtainMeasureSpec", "min", "max", "preferred", "onAttachedToWindow", "onDescendantInvalidated", "child", "target", "onDetachedFromWindow", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNestedFling", "velocityX", "", "velocityY", "consumed", "onNestedPreFling", "onNestedPreScroll", "dx", "dy", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "axes", "onStartNestedScroll", "onStopNestedScroll", "remeasure", "requestDisallowInterceptTouchEvent", "disallowIntercept", "shouldDelayChildPressedState", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidViewHolder.android.kt */
public abstract class AndroidViewHolder extends ViewGroup implements NestedScrollingParent3 {
    private Density density;
    /* access modifiers changed from: private */
    public final NestedScrollDispatcher dispatcher;
    /* access modifiers changed from: private */
    public boolean hasUpdateBlock;
    private int lastHeightMeasureSpec;
    private int lastWidthMeasureSpec;
    private final LayoutNode layoutNode;
    private LifecycleOwner lifecycleOwner;
    private final int[] location;
    private Modifier modifier;
    private final NestedScrollingParentHelper nestedScrollingParentHelper;
    /* access modifiers changed from: private */
    public final Function1<AndroidViewHolder, Unit> onCommitAffectingUpdate;
    private Function1<? super Density, Unit> onDensityChanged;
    private Function1<? super Modifier, Unit> onModifierChanged;
    private Function1<? super Boolean, Unit> onRequestDisallowInterceptTouchEvent;
    /* access modifiers changed from: private */
    public final Function0<Unit> runUpdate;
    private SavedStateRegistryOwner savedStateRegistryOwner;
    /* access modifiers changed from: private */
    public final SnapshotStateObserver snapshotObserver;
    private Function0<Unit> update;
    private View view;

    public boolean onStartNestedScroll(View view2, View view3, int i, int i2) {
        Intrinsics.checkNotNullParameter(view2, "child");
        Intrinsics.checkNotNullParameter(view3, "target");
        return ((i & 2) == 0 && (i & 1) == 0) ? false : true;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder(Context context, CompositionContext compositionContext, NestedScrollDispatcher nestedScrollDispatcher) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nestedScrollDispatcher, "dispatcher");
        this.dispatcher = nestedScrollDispatcher;
        if (compositionContext != null) {
            WindowRecomposer_androidKt.setCompositionContext(this, compositionContext);
        }
        setSaveFromParentEnabled(false);
        this.update = AndroidViewHolder$update$1.INSTANCE;
        this.modifier = Modifier.Companion;
        this.density = DensityKt.Density$default(1.0f, 0.0f, 2, (Object) null);
        this.snapshotObserver = new SnapshotStateObserver(new AndroidViewHolder$snapshotObserver$1(this));
        this.onCommitAffectingUpdate = new AndroidViewHolder$onCommitAffectingUpdate$1(this);
        this.runUpdate = new AndroidViewHolder$runUpdate$1(this);
        this.location = new int[2];
        this.lastWidthMeasureSpec = Integer.MIN_VALUE;
        this.lastHeightMeasureSpec = Integer.MIN_VALUE;
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        AndroidViewHolder androidViewHolder = this;
        LayoutNode layoutNode2 = new LayoutNode(false, 0, 3, (DefaultConstructorMarker) null);
        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(DrawModifierKt.drawBehind(PointerInteropFilter_androidKt.pointerInteropFilter(Modifier.Companion, androidViewHolder), new AndroidViewHolder$layoutNode$1$coreModifier$1(layoutNode2, this)), new AndroidViewHolder$layoutNode$1$coreModifier$2(androidViewHolder, layoutNode2));
        layoutNode2.setModifier(androidViewHolder.modifier.then(onGloballyPositioned));
        androidViewHolder.onModifierChanged = new AndroidViewHolder$layoutNode$1$1(layoutNode2, onGloballyPositioned);
        layoutNode2.setDensity(androidViewHolder.density);
        androidViewHolder.onDensityChanged = new AndroidViewHolder$layoutNode$1$2(layoutNode2);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        layoutNode2.setOnAttach$ui_release(new AndroidViewHolder$layoutNode$1$3(androidViewHolder, layoutNode2, objectRef));
        layoutNode2.setOnDetach$ui_release(new AndroidViewHolder$layoutNode$1$4(androidViewHolder, objectRef));
        layoutNode2.setMeasurePolicy(new AndroidViewHolder$layoutNode$1$5(androidViewHolder, layoutNode2));
        this.layoutNode = layoutNode2;
    }

    public final View getView() {
        return this.view;
    }

    public final void setView$ui_release(View view2) {
        if (view2 != this.view) {
            this.view = view2;
            removeAllViewsInLayout();
            if (view2 != null) {
                addView(view2);
                this.runUpdate.invoke();
            }
        }
    }

    public final Function0<Unit> getUpdate() {
        return this.update;
    }

    /* access modifiers changed from: protected */
    public final void setUpdate(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "value");
        this.update = function0;
        this.hasUpdateBlock = true;
        this.runUpdate.invoke();
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final void setModifier(Modifier modifier2) {
        Intrinsics.checkNotNullParameter(modifier2, "value");
        if (modifier2 != this.modifier) {
            this.modifier = modifier2;
            Function1<? super Modifier, Unit> function1 = this.onModifierChanged;
            if (function1 != null) {
                function1.invoke(modifier2);
            }
        }
    }

    public final Function1<Modifier, Unit> getOnModifierChanged$ui_release() {
        return this.onModifierChanged;
    }

    public final void setOnModifierChanged$ui_release(Function1<? super Modifier, Unit> function1) {
        this.onModifierChanged = function1;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final void setDensity(Density density2) {
        Intrinsics.checkNotNullParameter(density2, "value");
        if (density2 != this.density) {
            this.density = density2;
            Function1<? super Density, Unit> function1 = this.onDensityChanged;
            if (function1 != null) {
                function1.invoke(density2);
            }
        }
    }

    public final Function1<Density, Unit> getOnDensityChanged$ui_release() {
        return this.onDensityChanged;
    }

    public final void setOnDensityChanged$ui_release(Function1<? super Density, Unit> function1) {
        this.onDensityChanged = function1;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final void setLifecycleOwner(LifecycleOwner lifecycleOwner2) {
        if (lifecycleOwner2 != this.lifecycleOwner) {
            this.lifecycleOwner = lifecycleOwner2;
            ViewTreeLifecycleOwner.set(this, lifecycleOwner2);
        }
    }

    public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
        return this.savedStateRegistryOwner;
    }

    public final void setSavedStateRegistryOwner(SavedStateRegistryOwner savedStateRegistryOwner2) {
        if (savedStateRegistryOwner2 != this.savedStateRegistryOwner) {
            this.savedStateRegistryOwner = savedStateRegistryOwner2;
            ViewTreeSavedStateRegistryOwner.set(this, savedStateRegistryOwner2);
        }
    }

    public final Function1<Boolean, Unit> getOnRequestDisallowInterceptTouchEvent$ui_release() {
        return this.onRequestDisallowInterceptTouchEvent;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui_release(Function1<? super Boolean, Unit> function1) {
        this.onRequestDisallowInterceptTouchEvent = function1;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        View view2 = this.view;
        if (view2 != null) {
            view2.measure(i, i2);
        }
        View view3 = this.view;
        int i3 = 0;
        int measuredWidth = view3 != null ? view3.getMeasuredWidth() : 0;
        View view4 = this.view;
        if (view4 != null) {
            i3 = view4.getMeasuredHeight();
        }
        setMeasuredDimension(measuredWidth, i3);
        this.lastWidthMeasureSpec = i;
        this.lastHeightMeasureSpec = i2;
    }

    public final void remeasure() {
        int i;
        int i2 = this.lastWidthMeasureSpec;
        if (i2 != Integer.MIN_VALUE && (i = this.lastHeightMeasureSpec) != Integer.MIN_VALUE) {
            measure(i2, i);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view2 = this.view;
        if (view2 != null) {
            view2.layout(0, 0, i3 - i, i4 - i2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getLayoutParams();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.ViewGroup.LayoutParams getLayoutParams() {
        /*
            r2 = this;
            android.view.View r0 = r2.view
            if (r0 == 0) goto L_0x000a
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            if (r0 != 0) goto L_0x0010
        L_0x000a:
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r1 = -1
            r0.<init>(r1, r1)
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidViewHolder.getLayoutParams():android.view.ViewGroup$LayoutParams");
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        Function1<? super Boolean, Unit> function1 = this.onRequestDisallowInterceptTouchEvent;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.snapshotObserver.start();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.snapshotObserver.stop();
        this.snapshotObserver.clear();
    }

    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        super.invalidateChildInParent(iArr, rect);
        this.layoutNode.invalidateLayer$ui_release();
        return null;
    }

    public void onDescendantInvalidated(View view2, View view3) {
        Intrinsics.checkNotNullParameter(view2, "child");
        Intrinsics.checkNotNullParameter(view3, "target");
        super.onDescendantInvalidated(view2, view3);
        this.layoutNode.invalidateLayer$ui_release();
    }

    public boolean gatherTransparentRegion(Region region) {
        if (region == null) {
            return true;
        }
        getLocationInWindow(this.location);
        int[] iArr = this.location;
        region.op(iArr[0], iArr[1], iArr[0] + getWidth(), this.location[1] + getHeight(), Region.Op.DIFFERENCE);
        return true;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    /* access modifiers changed from: private */
    public final int obtainMeasureSpec(int i, int i2, int i3) {
        if (i3 >= 0 || i == i2) {
            return View.MeasureSpec.makeMeasureSpec(RangesKt.coerceIn(i3, i, i2), 1073741824);
        }
        if (i3 == -2 && i2 != Integer.MAX_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE);
        }
        if (i3 != -1 || i2 == Integer.MAX_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        return View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
    }

    public int getNestedScrollAxes() {
        return this.nestedScrollingParentHelper.getNestedScrollAxes();
    }

    public void onNestedScrollAccepted(View view2, View view3, int i, int i2) {
        Intrinsics.checkNotNullParameter(view2, "child");
        Intrinsics.checkNotNullParameter(view3, "target");
        this.nestedScrollingParentHelper.onNestedScrollAccepted(view2, view3, i, i2);
    }

    public void onStopNestedScroll(View view2, int i) {
        Intrinsics.checkNotNullParameter(view2, "target");
        this.nestedScrollingParentHelper.onStopNestedScroll(view2, i);
    }

    public void onNestedScroll(View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        Intrinsics.checkNotNullParameter(view2, "target");
        Intrinsics.checkNotNullParameter(iArr, "consumed");
        if (isNestedScrollingEnabled()) {
            long r7 = this.dispatcher.m3312dispatchPostScrollDzOQY0M(OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i), AndroidViewHolder_androidKt.toComposeOffset(i2)), OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i3), AndroidViewHolder_androidKt.toComposeOffset(i4)), AndroidViewHolder_androidKt.toNestedScrollSource(i5));
            iArr[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1683getXimpl(r7));
            iArr[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1684getYimpl(r7));
        }
    }

    public void onNestedScroll(View view2, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(view2, "target");
        if (isNestedScrollingEnabled()) {
            this.dispatcher.m3312dispatchPostScrollDzOQY0M(OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i), AndroidViewHolder_androidKt.toComposeOffset(i2)), OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i3), AndroidViewHolder_androidKt.toComposeOffset(i4)), AndroidViewHolder_androidKt.toNestedScrollSource(i5));
        }
    }

    public void onNestedPreScroll(View view2, int i, int i2, int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(view2, "target");
        Intrinsics.checkNotNullParameter(iArr, "consumed");
        if (isNestedScrollingEnabled()) {
            long r2 = this.dispatcher.m3314dispatchPreScrollOzD1aCk(OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i), AndroidViewHolder_androidKt.toComposeOffset(i2)), AndroidViewHolder_androidKt.toNestedScrollSource(i3));
            iArr[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1683getXimpl(r2));
            iArr[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1684getYimpl(r2));
        }
    }

    public boolean onNestedFling(View view2, float f, float f2, boolean z) {
        View view3 = view2;
        Intrinsics.checkNotNullParameter(view2, "target");
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        long Velocity = VelocityKt.Velocity(AndroidViewHolder_androidKt.toComposeVelocity(f), AndroidViewHolder_androidKt.toComposeVelocity(f2));
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.dispatcher.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new AndroidViewHolder$onNestedFling$1(z, this, Velocity, (Continuation<? super AndroidViewHolder$onNestedFling$1>) null), 3, (Object) null);
        return false;
    }

    public boolean onNestedPreFling(View view2, float f, float f2) {
        Intrinsics.checkNotNullParameter(view2, "target");
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.dispatcher.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new AndroidViewHolder$onNestedPreFling$1(this, VelocityKt.Velocity(AndroidViewHolder_androidKt.toComposeVelocity(f), AndroidViewHolder_androidKt.toComposeVelocity(f2)), (Continuation<? super AndroidViewHolder$onNestedPreFling$1>) null), 3, (Object) null);
        return false;
    }

    public boolean isNestedScrollingEnabled() {
        View view2 = this.view;
        return view2 != null ? view2.isNestedScrollingEnabled() : super.isNestedScrollingEnabled();
    }
}
