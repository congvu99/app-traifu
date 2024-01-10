package androidx.compose.ui.window;

import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ComponentDialog;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.app.NotificationCompat;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B;\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\u0006\u0010\u001d\u001a\u00020\u0005J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J&\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b&¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+H\u0002J$\u0010,\u001a\u00020\u00052\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\u00020\u0016X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, d2 = {"Landroidx/compose/ui/window/DialogWrapper;", "Landroidx/activity/ComponentDialog;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "onDismissRequest", "Lkotlin/Function0;", "", "properties", "Landroidx/compose/ui/window/DialogProperties;", "composeView", "Landroid/view/View;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "dialogId", "Ljava/util/UUID;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/DialogProperties;Landroid/view/View;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Ljava/util/UUID;)V", "defaultSoftInputMode", "", "dialogLayout", "Landroidx/compose/ui/window/DialogLayout;", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "F", "subCompositionView", "Landroidx/compose/ui/platform/AbstractComposeView;", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "cancel", "disposeComposition", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setContent", "parentComposition", "Landroidx/compose/runtime/CompositionContext;", "children", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setLayoutDirection", "setSecurePolicy", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "updateParameters", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidDialog.android.kt */
final class DialogWrapper extends ComponentDialog implements ViewRootForInspector {
    private final View composeView;
    private final int defaultSoftInputMode;
    private final DialogLayout dialogLayout;
    private final float maxSupportedElevation;
    /* access modifiers changed from: private */
    public Function0<Unit> onDismissRequest;
    /* access modifiers changed from: private */
    public DialogProperties properties;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AndroidDialog.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void cancel() {
    }

    public /* synthetic */ View getViewRoot() {
        return ViewRootForInspector.CC.$default$getViewRoot(this);
    }

    /* JADX WARNING: type inference failed for: r7v6, types: [android.view.View] */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DialogWrapper(kotlin.jvm.functions.Function0<kotlin.Unit> r7, androidx.compose.ui.window.DialogProperties r8, android.view.View r9, androidx.compose.ui.unit.LayoutDirection r10, androidx.compose.ui.unit.Density r11, java.util.UUID r12) {
        /*
            r6 = this;
            java.lang.String r0 = "onDismissRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "properties"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "composeView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "layoutDirection"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "density"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "dialogId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            android.view.ContextThemeWrapper r0 = new android.view.ContextThemeWrapper
            android.content.Context r1 = r9.getContext()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 31
            if (r2 >= r3) goto L_0x0035
            boolean r2 = r8.getDecorFitsSystemWindows()
            if (r2 == 0) goto L_0x0032
            goto L_0x0035
        L_0x0032:
            int r2 = androidx.compose.ui.R.style.FloatingDialogWindowTheme
            goto L_0x0037
        L_0x0035:
            int r2 = androidx.compose.ui.R.style.DialogWindowTheme
        L_0x0037:
            r0.<init>(r1, r2)
            android.content.Context r0 = (android.content.Context) r0
            r1 = 2
            r2 = 0
            r3 = 0
            r6.<init>(r0, r2, r1, r3)
            r6.onDismissRequest = r7
            r6.properties = r8
            r6.composeView = r9
            r7 = 8
            float r7 = (float) r7
            float r7 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r7)
            r6.maxSupportedElevation = r7
            android.view.Window r7 = r6.getWindow()
            if (r7 == 0) goto L_0x010b
            android.view.WindowManager$LayoutParams r8 = r7.getAttributes()
            int r8 = r8.softInputMode
            r8 = r8 & 240(0xf0, float:3.36E-43)
            r6.defaultSoftInputMode = r8
            r8 = 1
            r7.requestFeature(r8)
            r8 = 17170445(0x106000d, float:2.461195E-38)
            r7.setBackgroundDrawableResource(r8)
            androidx.compose.ui.window.DialogProperties r8 = r6.properties
            boolean r8 = r8.getDecorFitsSystemWindows()
            androidx.core.view.WindowCompat.setDecorFitsSystemWindows(r7, r8)
            androidx.compose.ui.window.DialogLayout r8 = new androidx.compose.ui.window.DialogLayout
            android.content.Context r9 = r6.getContext()
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            r8.<init>(r9, r7)
            int r9 = androidx.compose.ui.R.id.compose_view_saveable_id_tag
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Dialog:"
            r0.append(r1)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            r8.setTag(r9, r12)
            r8.setClipChildren(r2)
            float r9 = r6.maxSupportedElevation
            float r9 = r11.m4649toPx0680j_4(r9)
            r8.setElevation(r9)
            androidx.compose.ui.window.DialogWrapper$1$2 r9 = new androidx.compose.ui.window.DialogWrapper$1$2
            r9.<init>()
            android.view.ViewOutlineProvider r9 = (android.view.ViewOutlineProvider) r9
            r8.setOutlineProvider(r9)
            r6.dialogLayout = r8
            android.view.View r7 = r7.getDecorView()
            boolean r8 = r7 instanceof android.view.ViewGroup
            if (r8 == 0) goto L_0x00bb
            r3 = r7
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
        L_0x00bb:
            if (r3 == 0) goto L_0x00c0
            _init_$disableClipping(r3)
        L_0x00c0:
            androidx.compose.ui.window.DialogLayout r7 = r6.dialogLayout
            android.view.View r7 = (android.view.View) r7
            r6.setContentView((android.view.View) r7)
            androidx.compose.ui.window.DialogLayout r7 = r6.dialogLayout
            android.view.View r7 = (android.view.View) r7
            android.view.View r8 = r6.composeView
            androidx.lifecycle.LifecycleOwner r8 = androidx.lifecycle.ViewTreeLifecycleOwner.get(r8)
            androidx.lifecycle.ViewTreeLifecycleOwner.set(r7, r8)
            androidx.compose.ui.window.DialogLayout r7 = r6.dialogLayout
            android.view.View r7 = (android.view.View) r7
            android.view.View r8 = r6.composeView
            androidx.lifecycle.ViewModelStoreOwner r8 = androidx.lifecycle.ViewTreeViewModelStoreOwner.get(r8)
            androidx.lifecycle.ViewTreeViewModelStoreOwner.set(r7, r8)
            androidx.compose.ui.window.DialogLayout r7 = r6.dialogLayout
            android.view.View r7 = (android.view.View) r7
            android.view.View r8 = r6.composeView
            androidx.savedstate.SavedStateRegistryOwner r8 = androidx.savedstate.ViewTreeSavedStateRegistryOwner.get(r8)
            androidx.savedstate.ViewTreeSavedStateRegistryOwner.set(r7, r8)
            kotlin.jvm.functions.Function0<kotlin.Unit> r7 = r6.onDismissRequest
            androidx.compose.ui.window.DialogProperties r8 = r6.properties
            r6.updateParameters(r7, r8, r10)
            androidx.activity.OnBackPressedDispatcher r0 = r6.getOnBackPressedDispatcher()
            r1 = r6
            androidx.lifecycle.LifecycleOwner r1 = (androidx.lifecycle.LifecycleOwner) r1
            r2 = 0
            androidx.compose.ui.window.DialogWrapper$2 r7 = new androidx.compose.ui.window.DialogWrapper$2
            r7.<init>(r6)
            r3 = r7
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r4 = 2
            r5 = 0
            androidx.activity.OnBackPressedDispatcherKt.addCallback$default(r0, r1, r2, r3, r4, r5)
            return
        L_0x010b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Dialog has no window"
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.DialogWrapper.<init>(kotlin.jvm.functions.Function0, androidx.compose.ui.window.DialogProperties, android.view.View, androidx.compose.ui.unit.LayoutDirection, androidx.compose.ui.unit.Density, java.util.UUID):void");
    }

    public AbstractComposeView getSubCompositionView() {
        return this.dialogLayout;
    }

    private static final void _init_$disableClipping(ViewGroup viewGroup) {
        viewGroup.setClipChildren(false);
        if (!(viewGroup instanceof DialogLayout)) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                ViewGroup viewGroup2 = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
                if (viewGroup2 != null) {
                    _init_$disableClipping(viewGroup2);
                }
            }
        }
    }

    private final void setLayoutDirection(LayoutDirection layoutDirection) {
        DialogLayout dialogLayout2 = this.dialogLayout;
        int i = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        int i2 = 1;
        if (i == 1) {
            i2 = 0;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        dialogLayout2.setLayoutDirection(i2);
    }

    public final void setContent(CompositionContext compositionContext, Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(compositionContext, "parentComposition");
        Intrinsics.checkNotNullParameter(function2, "children");
        this.dialogLayout.setContent(compositionContext, function2);
    }

    private final void setSecurePolicy(SecureFlagPolicy secureFlagPolicy) {
        boolean shouldApplySecureFlag = SecureFlagPolicy_androidKt.shouldApplySecureFlag(secureFlagPolicy, AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView));
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        window.setFlags(shouldApplySecureFlag ? 8192 : -8193, 8192);
    }

    public final void updateParameters(Function0<Unit> function0, DialogProperties dialogProperties, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(dialogProperties, "properties");
        Intrinsics.checkNotNullParameter(layoutDirection, ViewProps.LAYOUT_DIRECTION);
        this.onDismissRequest = function0;
        this.properties = dialogProperties;
        setSecurePolicy(dialogProperties.getSecurePolicy());
        setLayoutDirection(layoutDirection);
        this.dialogLayout.setUsePlatformDefaultWidth(dialogProperties.getUsePlatformDefaultWidth());
        if (Build.VERSION.SDK_INT >= 31) {
            return;
        }
        if (dialogProperties.getDecorFitsSystemWindows()) {
            Window window = getWindow();
            if (window != null) {
                window.setSoftInputMode(this.defaultSoftInputMode);
                return;
            }
            return;
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(16);
        }
    }

    public final void disposeComposition() {
        this.dialogLayout.disposeComposition();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (onTouchEvent && this.properties.getDismissOnClickOutside()) {
            this.onDismissRequest.invoke();
        }
        return onTouchEvent;
    }
}
