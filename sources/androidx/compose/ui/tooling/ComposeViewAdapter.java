package androidx.compose.ui.tooling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.activity.compose.LocalActivityResultRegistryOwner;
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.tooling.animation.PreviewAnimationClock;
import androidx.compose.ui.tooling.data.Group;
import androidx.compose.ui.tooling.data.SlotTreeKt;
import androidx.compose.ui.tooling.data.SourceLocation;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007*\u0004\u000b\u000e\u0011\u0014\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ \u0010L\u001a\u00020(2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\b)H\u0003¢\u0006\u0002\u0010MJ\u0012\u0010N\u001a\u00020(2\b\u0010O\u001a\u0004\u0018\u00010PH\u0014J\r\u0010Q\u001a\u00020(H\u0000¢\u0006\u0002\bRJ\b\u0010S\u001a\u00020(H\u0002J\b\u0010T\u001a\u00020(H\u0002J4\u0010U\u001a\b\u0012\u0004\u0012\u00020F032\u0006\u0010V\u001a\u00020F2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020.0X2\b\b\u0002\u0010Y\u001a\u00020.H\u0002J\u0006\u0010:\u001a\u00020.J\u0010\u0010Z\u001a\u00020(2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0001\u0010Z\u001a\u00020(2\u0006\u0010[\u001a\u00020\u00172\u0006\u0010\\\u001a\u00020\u00172\u0016\b\u0002\u0010]\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030_\u0018\u00010^2\b\b\u0002\u0010`\u001a\u00020\b2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\b\b\u0002\u0010a\u001a\u00020b2\b\b\u0002\u00109\u001a\u00020.2\b\b\u0002\u0010;\u001a\u00020.2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00172\u000e\b\u0002\u0010c\u001a\b\u0012\u0004\u0012\u00020(0'2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020(0'H\u0001¢\u0006\u0002\bdJ\b\u0010e\u001a\u00020(H\u0002J\b\u0010f\u001a\u00020(H\u0014J0\u0010g\u001a\u00020(2\u0006\u0010h\u001a\u00020.2\u0006\u0010i\u001a\u00020\b2\u0006\u0010j\u001a\u00020\b2\u0006\u0010k\u001a\u00020\b2\u0006\u0010l\u001a\u00020\bH\u0014J\b\u0010m\u001a\u00020(H\u0002J\u001a\u0010n\u001a\u00020(2\u0006\u0010o\u001a\u00020B2\b\b\u0002\u0010p\u001a\u00020\bH\u0002J&\u0010q\u001a\b\u0012\u0004\u0012\u00020F03*\u00020F2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020.0XH\u0002J\"\u0010r\u001a\u0004\u0018\u00010F*\u00020F2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020.0XH\u0002J\u000e\u0010s\u001a\u0004\u0018\u00010t*\u00020uH\u0002J\f\u0010v\u001a\u00020.*\u00020FH\u0002J\u001e\u0010w\u001a\u0004\u0018\u00010\u0017*\u00020u2\u0006\u0010x\u001a\u00020\b2\u0006\u0010y\u001a\u00020\bH\u0002J\f\u0010z\u001a\u00020.*\u00020FH\u0002J\f\u0010{\u001a\u00020B*\u00020FH\u0002R\u0010\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u00118\u0002X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017XD¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\u00198\u0000@\u0000X.¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R%\u0010%\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\b)0&X\u0004¢\u0006\b\n\u0000\u0012\u0004\b*\u0010\u001bR\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R \u00102\u001a\b\u0012\u0004\u0012\u00020\u001703X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u00108\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020(0'X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010=\u001a\r\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\b)X\u000e¢\u0006\u0004\n\u0002\u0010>R\u000e\u0010?\u001a\u00020@X\u0004¢\u0006\u0002\n\u0000R \u0010A\u001a\b\u0012\u0004\u0012\u00020B03X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00105\"\u0004\bD\u00107R\u0018\u0010E\u001a\u00020\u0017*\u00020F8BX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0018\u0010I\u001a\u00020\b*\u00020F8BX\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010K¨\u0006|"}, d2 = {"Landroidx/compose/ui/tooling/ComposeViewAdapter;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "FakeActivityResultRegistryOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeActivityResultRegistryOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeActivityResultRegistryOwner$1;", "FakeOnBackPressedDispatcherOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1;", "FakeSavedStateRegistryOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeSavedStateRegistryOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeSavedStateRegistryOwner$1;", "FakeViewModelStoreOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeViewModelStoreOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeViewModelStoreOwner$1;", "TAG", "", "clock", "Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "getClock$ui_tooling_release$annotations", "()V", "getClock$ui_tooling_release", "()Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "setClock$ui_tooling_release", "(Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;)V", "composableName", "composeView", "Landroidx/compose/ui/platform/ComposeView;", "composition", "Landroidx/compose/runtime/Composition;", "content", "Landroidx/compose/runtime/MutableState;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getContent$annotations", "debugBoundsPaint", "Landroid/graphics/Paint;", "debugPaintBounds", "", "debugViewInfos", "delayedException", "Landroidx/compose/ui/tooling/ThreadSafeException;", "designInfoList", "", "getDesignInfoList$ui_tooling_release", "()Ljava/util/List;", "setDesignInfoList$ui_tooling_release", "(Ljava/util/List;)V", "designInfoProvidersArgument", "forceCompositionInvalidation", "hasAnimations", "lookForDesignInfoProviders", "onDraw", "previewComposition", "Lkotlin/jvm/functions/Function2;", "slotTableRecord", "Landroidx/compose/ui/tooling/CompositionDataRecord;", "viewInfos", "Landroidx/compose/ui/tooling/ViewInfo;", "getViewInfos$ui_tooling_release", "setViewInfos$ui_tooling_release", "fileName", "Landroidx/compose/ui/tooling/data/Group;", "getFileName", "(Landroidx/compose/ui/tooling/data/Group;)Ljava/lang/String;", "lineNumber", "getLineNumber", "(Landroidx/compose/ui/tooling/data/Group;)I", "WrapPreview", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispose", "dispose$ui_tooling_release", "findAndTrackTransitions", "findDesignInfoProviders", "findGroupsThatMatchPredicate", "root", "predicate", "Lkotlin/Function1;", "findOnlyFirst", "init", "className", "methodName", "parameterProvider", "Ljava/lang/Class;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "parameterProviderIndex", "animationClockStartTime", "", "onCommit", "init$ui_tooling_release", "invalidateComposition", "onAttachedToWindow", "onLayout", "changed", "left", "top", "right", "bottom", "processViewInfos", "walkTable", "viewInfo", "indent", "findAll", "firstOrNull", "getDesignInfoMethodOrNull", "Ljava/lang/reflect/Method;", "", "hasNullSourcePosition", "invokeGetDesignInfo", "x", "y", "isNullGroup", "toViewInfo", "ui-tooling_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComposeViewAdapter.kt */
public final class ComposeViewAdapter extends FrameLayout {
    private final ComposeViewAdapter$FakeActivityResultRegistryOwner$1 FakeActivityResultRegistryOwner;
    private final ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1 FakeOnBackPressedDispatcherOwner;
    /* access modifiers changed from: private */
    public final ComposeViewAdapter$FakeSavedStateRegistryOwner$1 FakeSavedStateRegistryOwner;
    private final ComposeViewAdapter$FakeViewModelStoreOwner$1 FakeViewModelStoreOwner;
    private final String TAG = "ComposeViewAdapter";
    public PreviewAnimationClock clock;
    private String composableName;
    private final ComposeView composeView;
    private Composition composition;
    private final MutableState<Function2<Composer, Integer, Unit>> content;
    private final Paint debugBoundsPaint;
    private boolean debugPaintBounds;
    private boolean debugViewInfos;
    /* access modifiers changed from: private */
    public final ThreadSafeException delayedException;
    private List<String> designInfoList;
    private String designInfoProvidersArgument;
    private boolean forceCompositionInvalidation;
    private boolean hasAnimations;
    private boolean lookForDesignInfoProviders;
    private Function0<Unit> onDraw;
    private Function2<? super Composer, ? super Integer, Unit> previewComposition;
    /* access modifiers changed from: private */
    public final CompositionDataRecord slotTableRecord;
    private List<ViewInfo> viewInfos;

    public static /* synthetic */ void getClock$ui_tooling_release$annotations() {
    }

    private static /* synthetic */ void getContent$annotations() {
    }

    public final List<ViewInfo> getViewInfos$ui_tooling_release() {
        return this.viewInfos;
    }

    public final void setViewInfos$ui_tooling_release(List<ViewInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.viewInfos = list;
    }

    public final List<String> getDesignInfoList$ui_tooling_release() {
        return this.designInfoList;
    }

    public final void setDesignInfoList$ui_tooling_release(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.designInfoList = list;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeViewAdapter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.composeView = new ComposeView(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.viewInfos = CollectionsKt.emptyList();
        this.designInfoList = CollectionsKt.emptyList();
        this.slotTableRecord = CompositionDataRecord.Companion.create();
        this.composableName = "";
        this.delayedException = new ThreadSafeException();
        this.previewComposition = ComposableSingletons$ComposeViewAdapterKt.INSTANCE.m4594getLambda2$ui_tooling_release();
        this.content = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ComposeViewAdapterKt.emptyContent, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.designInfoProvidersArgument = "";
        this.onDraw = ComposeViewAdapter$onDraw$1.INSTANCE;
        Paint paint = new Paint();
        paint.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, 0.0f));
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(ColorKt.m1987toArgb8_81llA(Color.Companion.m1966getRed0d7_KjU()));
        this.debugBoundsPaint = paint;
        this.FakeSavedStateRegistryOwner = new ComposeViewAdapter$FakeSavedStateRegistryOwner$1();
        this.FakeViewModelStoreOwner = new ComposeViewAdapter$FakeViewModelStoreOwner$1();
        this.FakeOnBackPressedDispatcherOwner = new ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1(this);
        this.FakeActivityResultRegistryOwner = new ComposeViewAdapter$FakeActivityResultRegistryOwner$1();
        init(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeViewAdapter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.composeView = new ComposeView(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.viewInfos = CollectionsKt.emptyList();
        this.designInfoList = CollectionsKt.emptyList();
        this.slotTableRecord = CompositionDataRecord.Companion.create();
        this.composableName = "";
        this.delayedException = new ThreadSafeException();
        this.previewComposition = ComposableSingletons$ComposeViewAdapterKt.INSTANCE.m4594getLambda2$ui_tooling_release();
        this.content = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ComposeViewAdapterKt.emptyContent, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.designInfoProvidersArgument = "";
        this.onDraw = ComposeViewAdapter$onDraw$1.INSTANCE;
        Paint paint = new Paint();
        paint.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, 0.0f));
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(ColorKt.m1987toArgb8_81llA(Color.Companion.m1966getRed0d7_KjU()));
        this.debugBoundsPaint = paint;
        this.FakeSavedStateRegistryOwner = new ComposeViewAdapter$FakeSavedStateRegistryOwner$1();
        this.FakeViewModelStoreOwner = new ComposeViewAdapter$FakeViewModelStoreOwner$1();
        this.FakeOnBackPressedDispatcherOwner = new ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1(this);
        this.FakeActivityResultRegistryOwner = new ComposeViewAdapter$FakeActivityResultRegistryOwner$1();
        init(attributeSet);
    }

    static /* synthetic */ void walkTable$default(ComposeViewAdapter composeViewAdapter, ViewInfo viewInfo, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        composeViewAdapter.walkTable(viewInfo, i);
    }

    private final void walkTable(ViewInfo viewInfo, int i) {
        String str = this.TAG;
        Log.d(str, StringsKt.repeat("|  ", i) + "|-" + viewInfo);
        for (ViewInfo walkTable : viewInfo.getChildren()) {
            walkTable(walkTable, i + 1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = r1.getSourceFile();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getFileName(androidx.compose.ui.tooling.data.Group r1) {
        /*
            r0 = this;
            androidx.compose.ui.tooling.data.SourceLocation r1 = r1.getLocation()
            if (r1 == 0) goto L_0x000c
            java.lang.String r1 = r1.getSourceFile()
            if (r1 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r1 = ""
        L_0x000e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ComposeViewAdapter.getFileName(androidx.compose.ui.tooling.data.Group):java.lang.String");
    }

    private final int getLineNumber(Group group) {
        SourceLocation location = group.getLocation();
        if (location != null) {
            return location.getLineNumber();
        }
        return -1;
    }

    private final boolean hasNullSourcePosition(Group group) {
        return (getFileName(group).length() == 0) && getLineNumber(group) == -1;
    }

    private final boolean isNullGroup(Group group) {
        return hasNullSourcePosition(group) && group.getChildren().isEmpty();
    }

    private final ViewInfo toViewInfo(Group group) {
        String str;
        if (group.getChildren().size() == 1 && hasNullSourcePosition(group)) {
            return toViewInfo((Group) CollectionsKt.single(group.getChildren()));
        }
        Collection arrayList = new ArrayList();
        for (Object next : group.getChildren()) {
            if (!isNullGroup((Group) next)) {
                arrayList.add(next);
            }
        }
        Iterable<Group> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Group viewInfo : iterable) {
            arrayList2.add(toViewInfo(viewInfo));
        }
        List list = (List) arrayList2;
        SourceLocation location = group.getLocation();
        if (location == null || (str = location.getSourceFile()) == null) {
            str = "";
        }
        String str2 = str;
        SourceLocation location2 = group.getLocation();
        return new ViewInfo(str2, location2 != null ? location2.getLineNumber() : -1, group.getBox(), group.getLocation(), list);
    }

    private final void processViewInfos() {
        Iterable<CompositionData> store = this.slotTableRecord.getStore();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(store, 10));
        for (CompositionData asTree : store) {
            arrayList.add(SlotTreeKt.asTree(asTree));
        }
        Iterable<Group> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Group viewInfo : iterable) {
            arrayList2.add(toViewInfo(viewInfo));
        }
        List<ViewInfo> list = CollectionsKt.toList((List) arrayList2);
        this.viewInfos = list;
        if (this.debugViewInfos) {
            for (ViewInfo walkTable$default : list) {
                walkTable$default(this, walkTable$default, 0, 2, (Object) null);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.delayedException.throwIfPresent();
        processViewInfos();
        if (this.composableName.length() > 0) {
            findAndTrackTransitions();
            if (this.lookForDesignInfoProviders) {
                findDesignInfoProviders();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        ViewTreeLifecycleOwner.set(this.composeView.getRootView(), this.FakeSavedStateRegistryOwner);
        super.onAttachedToWindow();
    }

    private static final List<Transition<Object>> findAndTrackTransitions$findTransitionObjects(List<? extends Group> list, ComposeViewAdapter composeViewAdapter) {
        Transition transition;
        Object obj;
        Collection arrayList = new ArrayList();
        for (Group firstOrNull : list) {
            Group firstOrNull2 = composeViewAdapter.firstOrNull(firstOrNull, ComposeViewAdapter$findAndTrackTransitions$findTransitionObjects$rememberCalls$1$1.INSTANCE);
            if (firstOrNull2 != null) {
                arrayList.add(firstOrNull2);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (Group data : (List) arrayList) {
            Iterator it = data.getData().iterator();
            while (true) {
                transition = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (obj instanceof Transition) {
                    break;
                }
            }
            if (obj instanceof Transition) {
                transition = (Transition) obj;
            }
            if (transition != null) {
                arrayList2.add(transition);
            }
        }
        return (List) arrayList2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: androidx.compose.ui.tooling.data.Group} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: androidx.compose.ui.tooling.data.Group} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: androidx.compose.ui.tooling.data.Group} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: androidx.compose.ui.tooling.data.Group} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void findAndTrackTransitions() {
        /*
            r12 = this;
            androidx.compose.ui.tooling.CompositionDataRecord r0 = r12.slotTableRecord
            java.util.Set r0 = r0.getStore()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r2)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x0019:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r0.next()
            androidx.compose.runtime.tooling.CompositionData r2 = (androidx.compose.runtime.tooling.CompositionData) r2
            androidx.compose.ui.tooling.data.Group r2 = androidx.compose.ui.tooling.data.SlotTreeKt.asTree(r2)
            r1.add(r2)
            goto L_0x0019
        L_0x002d:
            java.util.List r1 = (java.util.List) r1
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            java.util.Set r0 = (java.util.Set) r0
            java.util.LinkedHashSet r2 = new java.util.LinkedHashSet
            r2.<init>()
            java.util.Set r2 = (java.util.Set) r2
            java.util.LinkedHashSet r3 = new java.util.LinkedHashSet
            r3.<init>()
            java.util.Set r3 = (java.util.Set) r3
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x004a:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0126
            java.lang.Object r4 = r1.next()
            androidx.compose.ui.tooling.data.Group r4 = (androidx.compose.ui.tooling.data.Group) r4
            androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackTransitions$1$1 r5 = androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackTransitions$1$1.INSTANCE
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            java.util.List r5 = r12.findAll(r4, r5)
            java.util.List r5 = findAndTrackTransitions$findTransitionObjects(r5, r12)
            java.util.Collection r5 = (java.util.Collection) r5
            r0.addAll(r5)
            androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackTransitions$1$2 r5 = androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackTransitions$1$2.INSTANCE
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            java.util.List r5 = r12.findAll(r4, r5)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L_0x007c:
            boolean r7 = r5.hasNext()
            java.lang.String r8 = "updateTransition"
            r9 = 0
            if (r7 == 0) goto L_0x00b6
            java.lang.Object r7 = r5.next()
            androidx.compose.ui.tooling.data.Group r7 = (androidx.compose.ui.tooling.data.Group) r7
            java.util.Collection r7 = r7.getChildren()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x0096:
            boolean r10 = r7.hasNext()
            if (r10 == 0) goto L_0x00ae
            java.lang.Object r10 = r7.next()
            r11 = r10
            androidx.compose.ui.tooling.data.Group r11 = (androidx.compose.ui.tooling.data.Group) r11
            java.lang.String r11 = r11.getName()
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r8)
            if (r11 == 0) goto L_0x0096
            r9 = r10
        L_0x00ae:
            androidx.compose.ui.tooling.data.Group r9 = (androidx.compose.ui.tooling.data.Group) r9
            if (r9 == 0) goto L_0x007c
            r6.add(r9)
            goto L_0x007c
        L_0x00b6:
            java.util.List r6 = (java.util.List) r6
            java.util.List r5 = findAndTrackTransitions$findTransitionObjects(r6, r12)
            java.util.Collection r5 = (java.util.Collection) r5
            r2.addAll(r5)
            androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackTransitions$1$4 r5 = androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackTransitions$1$4.INSTANCE
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            java.util.List r4 = r12.findAll(r4, r5)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r4 = r4.iterator()
        L_0x00d6:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x010d
            java.lang.Object r6 = r4.next()
            androidx.compose.ui.tooling.data.Group r6 = (androidx.compose.ui.tooling.data.Group) r6
            java.util.Collection r6 = r6.getChildren()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x00ec:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0104
            java.lang.Object r7 = r6.next()
            r10 = r7
            androidx.compose.ui.tooling.data.Group r10 = (androidx.compose.ui.tooling.data.Group) r10
            java.lang.String r10 = r10.getName()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r8)
            if (r10 == 0) goto L_0x00ec
            goto L_0x0105
        L_0x0104:
            r7 = r9
        L_0x0105:
            androidx.compose.ui.tooling.data.Group r7 = (androidx.compose.ui.tooling.data.Group) r7
            if (r7 == 0) goto L_0x00d6
            r5.add(r7)
            goto L_0x00d6
        L_0x010d:
            java.util.List r5 = (java.util.List) r5
            java.util.List r4 = findAndTrackTransitions$findTransitionObjects(r5, r12)
            java.util.Collection r4 = (java.util.Collection) r4
            r3.addAll(r4)
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            r0.removeAll(r4)
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            r0.removeAll(r4)
            goto L_0x004a
        L_0x0126:
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r3 = 1
            r1 = r1 ^ r3
            if (r1 != 0) goto L_0x013d
            r1 = r2
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r3
            if (r1 == 0) goto L_0x013c
            goto L_0x013d
        L_0x013c:
            r3 = 0
        L_0x013d:
            r12.hasAnimations = r3
            androidx.compose.ui.tooling.animation.PreviewAnimationClock r1 = r12.clock
            if (r1 == 0) goto L_0x017e
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0149:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x015d
            java.lang.Object r1 = r0.next()
            androidx.compose.animation.core.Transition r1 = (androidx.compose.animation.core.Transition) r1
            androidx.compose.ui.tooling.animation.PreviewAnimationClock r3 = r12.getClock$ui_tooling_release()
            r3.trackTransition(r1)
            goto L_0x0149
        L_0x015d:
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r0 = r2.iterator()
        L_0x0163:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x017e
            java.lang.Object r1 = r0.next()
            androidx.compose.animation.core.Transition r1 = (androidx.compose.animation.core.Transition) r1
            androidx.compose.ui.tooling.animation.PreviewAnimationClock r2 = r12.getClock$ui_tooling_release()
            androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackTransitions$4$1 r3 = new androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackTransitions$4$1
            r3.<init>(r12)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r2.trackAnimatedVisibility(r1, r3)
            goto L_0x0163
        L_0x017e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ComposeViewAdapter.findAndTrackTransitions():void");
    }

    private final void findDesignInfoProviders() {
        String str;
        Method method;
        Iterable<CompositionData> store = this.slotTableRecord.getStore();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(store, 10));
        for (CompositionData asTree : store) {
            arrayList.add(SlotTreeKt.asTree(asTree));
        }
        Collection arrayList2 = new ArrayList();
        for (Group findAll : (List) arrayList) {
            Collection arrayList3 = new ArrayList();
            for (Group group : findAll(findAll, new ComposeViewAdapter$findDesignInfoProviders$1$1(this))) {
                Iterator it = group.getChildren().iterator();
                while (true) {
                    str = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    Iterator it2 = ((Group) it.next()).getData().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Object next = it2.next();
                            if (next != null) {
                                method = getDesignInfoMethodOrNull(next);
                                continue;
                            } else {
                                method = null;
                                continue;
                            }
                            if (method != null) {
                                str = invokeGetDesignInfo(next, group.getBox().getLeft(), group.getBox().getTop());
                                break;
                            }
                        }
                    }
                }
                if (str != null) {
                    arrayList3.add(str);
                }
            }
            CollectionsKt.addAll(arrayList2, (List) arrayList3);
        }
        this.designInfoList = (List) arrayList2;
    }

    /* access modifiers changed from: private */
    public final Method getDesignInfoMethodOrNull(Object obj) {
        try {
            return obj.getClass().getDeclaredMethod("getDesignInfo", new Class[]{Integer.TYPE, Integer.TYPE, String.class});
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final String invokeGetDesignInfo(Object obj, int i, int i2) {
        Method designInfoMethodOrNull = getDesignInfoMethodOrNull(obj);
        if (designInfoMethodOrNull == null) {
            return null;
        }
        try {
            boolean z = false;
            Object invoke = designInfoMethodOrNull.invoke(obj, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), this.designInfoProvidersArgument});
            if (invoke != null) {
                CharSequence charSequence = (String) invoke;
                if (charSequence.length() == 0) {
                    z = true;
                }
                if (z) {
                    charSequence = null;
                }
                return (String) charSequence;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception unused) {
            return null;
        }
    }

    private final Group firstOrNull(Group group, Function1<? super Group, Boolean> function1) {
        return (Group) CollectionsKt.firstOrNull(findGroupsThatMatchPredicate(group, function1, true));
    }

    private final List<Group> findAll(Group group, Function1<? super Group, Boolean> function1) {
        return findGroupsThatMatchPredicate$default(this, group, function1, false, 4, (Object) null);
    }

    static /* synthetic */ List findGroupsThatMatchPredicate$default(ComposeViewAdapter composeViewAdapter, Group group, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return composeViewAdapter.findGroupsThatMatchPredicate(group, function1, z);
    }

    private final List<Group> findGroupsThatMatchPredicate(Group group, Function1<? super Group, Boolean> function1, boolean z) {
        List<Group> arrayList = new ArrayList<>();
        List mutableListOf = CollectionsKt.mutableListOf(group);
        while (!mutableListOf.isEmpty()) {
            Group group2 = (Group) CollectionsKt.removeLast(mutableListOf);
            if (function1.invoke(group2).booleanValue()) {
                if (z) {
                    return CollectionsKt.listOf(group2);
                }
                arrayList.add(group2);
            }
            mutableListOf.addAll(group2.getChildren());
        }
        return arrayList;
    }

    private final void invalidateComposition() {
        this.content.setValue(ComposableSingletons$ComposeViewAdapterKt.INSTANCE.m4595getLambda3$ui_tooling_release());
        this.content.setValue(this.previewComposition);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.forceCompositionInvalidation) {
            invalidateComposition();
        }
        this.onDraw.invoke();
        if (this.debugPaintBounds) {
            Collection arrayList = new ArrayList();
            for (ViewInfo viewInfo : this.viewInfos) {
                CollectionsKt.addAll(arrayList, CollectionsKt.plus(CollectionsKt.listOf(viewInfo), viewInfo.allChildren()));
            }
            for (ViewInfo viewInfo2 : (List) arrayList) {
                if (viewInfo2.hasBounds() && canvas != null) {
                    canvas.drawRect(new Rect(viewInfo2.getBounds().getLeft(), viewInfo2.getBounds().getTop(), viewInfo2.getBounds().getRight(), viewInfo2.getBounds().getBottom()), this.debugBoundsPaint);
                }
            }
        }
    }

    public final PreviewAnimationClock getClock$ui_tooling_release() {
        PreviewAnimationClock previewAnimationClock = this.clock;
        if (previewAnimationClock != null) {
            return previewAnimationClock;
        }
        Intrinsics.throwUninitializedPropertyAccessException("clock");
        return null;
    }

    public final void setClock$ui_tooling_release(PreviewAnimationClock previewAnimationClock) {
        Intrinsics.checkNotNullParameter(previewAnimationClock, "<set-?>");
        this.clock = previewAnimationClock;
    }

    /* access modifiers changed from: private */
    public final void WrapPreview(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(493526445);
        ComposerKt.sourceInformation(startRestartGroup, "C(WrapPreview)524@20254L428:ComposeViewAdapter.kt#hevd2p");
        ProvidableCompositionLocal<Font.ResourceLoader> localFontLoader = CompositionLocalsKt.getLocalFontLoader();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{localFontLoader.provides(new LayoutlibFontResourceLoader(context)), localFontFamilyResolver.provides(FontFamilyResolver_androidKt.createFontFamilyResolver(context2)), LocalOnBackPressedDispatcherOwner.INSTANCE.provides(this.FakeOnBackPressedDispatcherOwner), LocalActivityResultRegistryOwner.INSTANCE.provides(this.FakeActivityResultRegistryOwner)}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -1966112531, true, new ComposeViewAdapter$WrapPreview$1(this, function2, i)), startRestartGroup, 56);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ComposeViewAdapter$WrapPreview$2(this, function2, i));
        }
    }

    public static /* synthetic */ void init$ui_tooling_release$default(ComposeViewAdapter composeViewAdapter, String str, String str2, Class cls, int i, boolean z, boolean z2, long j, boolean z3, boolean z4, String str3, Function0 function0, Function0 function02, int i2, Object obj) {
        Function0 function03;
        int i3 = i2;
        Class cls2 = (i3 & 4) != 0 ? null : cls;
        int i4 = (i3 & 8) != 0 ? 0 : i;
        boolean z5 = (i3 & 16) != 0 ? false : z;
        boolean z6 = (i3 & 32) != 0 ? false : z2;
        long j2 = (i3 & 64) != 0 ? -1 : j;
        boolean z7 = (i3 & 128) != 0 ? false : z3;
        boolean z8 = (i3 & 256) != 0 ? false : z4;
        String str4 = (i3 & 512) != 0 ? null : str3;
        Function0 function04 = (i3 & 1024) != 0 ? ComposeViewAdapter$init$1.INSTANCE : function0;
        if ((i3 & 2048) != 0) {
            function03 = ComposeViewAdapter$init$2.INSTANCE;
        } else {
            function03 = function02;
        }
        composeViewAdapter.init$ui_tooling_release(str, str2, cls2, i4, z5, z6, j2, z7, z8, str4, function04, function03);
    }

    public final void init$ui_tooling_release(String str, String str2, Class<? extends PreviewParameterProvider<?>> cls, int i, boolean z, boolean z2, long j, boolean z3, boolean z4, String str3, Function0<Unit> function0, Function0<Unit> function02) {
        Function0<Unit> function03 = function02;
        String str4 = str;
        Intrinsics.checkNotNullParameter(str, "className");
        Intrinsics.checkNotNullParameter(str2, "methodName");
        Intrinsics.checkNotNullParameter(function0, "onCommit");
        Intrinsics.checkNotNullParameter(function03, "onDraw");
        this.debugPaintBounds = z;
        this.debugViewInfos = z2;
        this.composableName = str2;
        this.forceCompositionInvalidation = z3;
        this.lookForDesignInfoProviders = z4;
        this.designInfoProvidersArgument = str3 == null ? "" : str3;
        this.onDraw = function03;
        Function2<? super Composer, ? super Integer, Unit> composableLambdaInstance = ComposableLambdaKt.composableLambdaInstance(-1704541905, true, new ComposeViewAdapter$init$3(function0, this, j, str, str2, cls, i));
        this.previewComposition = composableLambdaInstance;
        this.composeView.setContent(composableLambdaInstance);
        invalidate();
    }

    public final void dispose$ui_tooling_release() {
        this.composeView.disposeComposition();
        if (this.clock != null) {
            getClock$ui_tooling_release().dispose();
        }
        this.FakeViewModelStoreOwner.getViewModelStore().clear();
    }

    public final boolean hasAnimations() {
        return this.hasAnimations;
    }

    private final void init(AttributeSet attributeSet) {
        long j;
        AttributeSet attributeSet2 = attributeSet;
        View view = this;
        ViewTreeLifecycleOwner.set(view, this.FakeSavedStateRegistryOwner);
        ViewTreeSavedStateRegistryOwner.set(view, this.FakeSavedStateRegistryOwner);
        ViewTreeViewModelStoreOwner.set(view, this.FakeViewModelStoreOwner);
        addView(this.composeView);
        String attributeValue = attributeSet2.getAttributeValue("http://schemas.android.com/tools", "composableName");
        if (attributeValue != null) {
            String substringBeforeLast$default = StringsKt.substringBeforeLast$default(attributeValue, '.', (String) null, 2, (Object) null);
            String substringAfterLast$default = StringsKt.substringAfterLast$default(attributeValue, '.', (String) null, 2, (Object) null);
            int attributeIntValue = attributeSet2.getAttributeIntValue("http://schemas.android.com/tools", "parameterProviderIndex", 0);
            String attributeValue2 = attributeSet2.getAttributeValue("http://schemas.android.com/tools", "parameterProviderClass");
            Class<? extends PreviewParameterProvider<?>> asPreviewProviderClass = attributeValue2 != null ? PreviewUtilsKt.asPreviewProviderClass(attributeValue2) : null;
            try {
                String attributeValue3 = attributeSet2.getAttributeValue("http://schemas.android.com/tools", "animationClockStartTime");
                Intrinsics.checkNotNullExpressionValue(attributeValue3, "attrs.getAttributeValue(…animationClockStartTime\")");
                j = Long.parseLong(attributeValue3);
            } catch (Exception unused) {
                j = -1;
            }
            init$ui_tooling_release$default(this, substringBeforeLast$default, substringAfterLast$default, asPreviewProviderClass, attributeIntValue, attributeSet2.getAttributeBooleanValue("http://schemas.android.com/tools", "paintBounds", this.debugPaintBounds), attributeSet2.getAttributeBooleanValue("http://schemas.android.com/tools", "printViewInfos", this.debugViewInfos), j, attributeSet2.getAttributeBooleanValue("http://schemas.android.com/tools", "forceCompositionInvalidation", false), attributeSet2.getAttributeBooleanValue("http://schemas.android.com/tools", "findDesignInfoProviders", this.lookForDesignInfoProviders), attributeSet2.getAttributeValue("http://schemas.android.com/tools", "designInfoProvidersArgument"), (Function0) null, (Function0) null, 3072, (Object) null);
        }
    }
}
