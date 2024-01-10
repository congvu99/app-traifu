package androidx.compose.foundation.layout;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0019\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u00109\u001a\u00020:2\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010;\u001a\u00020:2\u0006\u0010\u0004\u001a\u00020\u0005J\u0018\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020\u00032\b\b\u0002\u0010>\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0011\u0010\u0017\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\fR\u0011\u0010\u001d\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\fR\u0011\u0010\u001f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0010R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0011\u0010'\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0011\u0010)\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\fR\u0011\u0010+\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0010R\u0011\u0010-\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\fR\u0011\u0010/\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0010R\u0011\u00101\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\fR\u0011\u00103\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\fR\u0011\u00105\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0010R\u0011\u00107\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0010¨\u0006@"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsHolder;", "", "insets", "Landroidx/core/view/WindowInsetsCompat;", "view", "Landroid/view/View;", "(Landroidx/core/view/WindowInsetsCompat;Landroid/view/View;)V", "accessCount", "", "captionBar", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "getCaptionBar", "()Landroidx/compose/foundation/layout/AndroidWindowInsets;", "captionBarIgnoringVisibility", "Landroidx/compose/foundation/layout/ValueInsets;", "getCaptionBarIgnoringVisibility", "()Landroidx/compose/foundation/layout/ValueInsets;", "consumes", "", "getConsumes", "()Z", "displayCutout", "getDisplayCutout", "ime", "getIme", "insetsListener", "Landroidx/compose/foundation/layout/InsetsListener;", "mandatorySystemGestures", "getMandatorySystemGestures", "navigationBars", "getNavigationBars", "navigationBarsIgnoringVisibility", "getNavigationBarsIgnoringVisibility", "safeContent", "Landroidx/compose/foundation/layout/WindowInsets;", "getSafeContent", "()Landroidx/compose/foundation/layout/WindowInsets;", "safeDrawing", "getSafeDrawing", "safeGestures", "getSafeGestures", "statusBars", "getStatusBars", "statusBarsIgnoringVisibility", "getStatusBarsIgnoringVisibility", "systemBars", "getSystemBars", "systemBarsIgnoringVisibility", "getSystemBarsIgnoringVisibility", "systemGestures", "getSystemGestures", "tappableElement", "getTappableElement", "tappableElementIgnoringVisibility", "getTappableElementIgnoringVisibility", "waterfall", "getWaterfall", "decrementAccessors", "", "incrementAccessors", "update", "windowInsets", "types", "Companion", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: WindowInsets.android.kt */
public final class WindowInsetsHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static boolean testInsets;
    /* access modifiers changed from: private */
    public static final WeakHashMap<View, WindowInsetsHolder> viewMap = new WeakHashMap<>();
    private int accessCount;
    private final AndroidWindowInsets captionBar;
    private final ValueInsets captionBarIgnoringVisibility;
    private final boolean consumes;
    private final AndroidWindowInsets displayCutout;
    private final AndroidWindowInsets ime;
    private final InsetsListener insetsListener;
    private final AndroidWindowInsets mandatorySystemGestures;
    private final AndroidWindowInsets navigationBars;
    private final ValueInsets navigationBarsIgnoringVisibility;
    private final WindowInsets safeContent;
    private final WindowInsets safeDrawing;
    private final WindowInsets safeGestures;
    private final AndroidWindowInsets statusBars;
    private final ValueInsets statusBarsIgnoringVisibility;
    private final AndroidWindowInsets systemBars;
    private final ValueInsets systemBarsIgnoringVisibility;
    private final AndroidWindowInsets systemGestures;
    private final AndroidWindowInsets tappableElement;
    private final ValueInsets tappableElementIgnoringVisibility;
    private final ValueInsets waterfall;

    public /* synthetic */ WindowInsetsHolder(WindowInsetsCompat windowInsetsCompat, View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowInsetsCompat, view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x008d, code lost:
        r0 = (r0 = r4.getDisplayCutout()).getWaterfallInsets();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private WindowInsetsHolder(androidx.core.view.WindowInsetsCompat r4, android.view.View r5) {
        /*
            r3 = this;
            r3.<init>()
            androidx.compose.foundation.layout.WindowInsetsHolder$Companion r0 = Companion
            int r1 = androidx.core.view.WindowInsetsCompat.Type.captionBar()
            java.lang.String r2 = "captionBar"
            androidx.compose.foundation.layout.AndroidWindowInsets r0 = r0.systemInsets(r4, r1, r2)
            r3.captionBar = r0
            androidx.compose.foundation.layout.WindowInsetsHolder$Companion r0 = Companion
            int r1 = androidx.core.view.WindowInsetsCompat.Type.displayCutout()
            java.lang.String r2 = "displayCutout"
            androidx.compose.foundation.layout.AndroidWindowInsets r0 = r0.systemInsets(r4, r1, r2)
            r3.displayCutout = r0
            androidx.compose.foundation.layout.WindowInsetsHolder$Companion r0 = Companion
            int r1 = androidx.core.view.WindowInsetsCompat.Type.ime()
            java.lang.String r2 = "ime"
            androidx.compose.foundation.layout.AndroidWindowInsets r0 = r0.systemInsets(r4, r1, r2)
            r3.ime = r0
            androidx.compose.foundation.layout.WindowInsetsHolder$Companion r0 = Companion
            int r1 = androidx.core.view.WindowInsetsCompat.Type.mandatorySystemGestures()
            java.lang.String r2 = "mandatorySystemGestures"
            androidx.compose.foundation.layout.AndroidWindowInsets r0 = r0.systemInsets(r4, r1, r2)
            r3.mandatorySystemGestures = r0
            androidx.compose.foundation.layout.WindowInsetsHolder$Companion r0 = Companion
            int r1 = androidx.core.view.WindowInsetsCompat.Type.navigationBars()
            java.lang.String r2 = "navigationBars"
            androidx.compose.foundation.layout.AndroidWindowInsets r0 = r0.systemInsets(r4, r1, r2)
            r3.navigationBars = r0
            androidx.compose.foundation.layout.WindowInsetsHolder$Companion r0 = Companion
            int r1 = androidx.core.view.WindowInsetsCompat.Type.statusBars()
            java.lang.String r2 = "statusBars"
            androidx.compose.foundation.layout.AndroidWindowInsets r0 = r0.systemInsets(r4, r1, r2)
            r3.statusBars = r0
            androidx.compose.foundation.layout.WindowInsetsHolder$Companion r0 = Companion
            int r1 = androidx.core.view.WindowInsetsCompat.Type.systemBars()
            java.lang.String r2 = "systemBars"
            androidx.compose.foundation.layout.AndroidWindowInsets r0 = r0.systemInsets(r4, r1, r2)
            r3.systemBars = r0
            androidx.compose.foundation.layout.WindowInsetsHolder$Companion r0 = Companion
            int r1 = androidx.core.view.WindowInsetsCompat.Type.systemGestures()
            java.lang.String r2 = "systemGestures"
            androidx.compose.foundation.layout.AndroidWindowInsets r0 = r0.systemInsets(r4, r1, r2)
            r3.systemGestures = r0
            androidx.compose.foundation.layout.WindowInsetsHolder$Companion r0 = Companion
            int r1 = androidx.core.view.WindowInsetsCompat.Type.tappableElement()
            java.lang.String r2 = "tappableElement"
            androidx.compose.foundation.layout.AndroidWindowInsets r0 = r0.systemInsets(r4, r1, r2)
            r3.tappableElement = r0
            if (r4 == 0) goto L_0x0093
            androidx.core.view.DisplayCutoutCompat r0 = r4.getDisplayCutout()
            if (r0 == 0) goto L_0x0093
            androidx.core.graphics.Insets r0 = r0.getWaterfallInsets()
            if (r0 != 0) goto L_0x0095
        L_0x0093:
            androidx.core.graphics.Insets r0 = androidx.core.graphics.Insets.NONE
        L_0x0095:
            java.lang.String r1 = "insets?.displayCutout?.w…ts ?: AndroidXInsets.NONE"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r1 = "waterfall"
            androidx.compose.foundation.layout.ValueInsets r0 = androidx.compose.foundation.layout.WindowInsets_androidKt.ValueInsets(r0, r1)
            r3.waterfall = r0
            androidx.compose.foundation.layout.AndroidWindowInsets r0 = r3.systemBars
            androidx.compose.foundation.layout.WindowInsets r0 = (androidx.compose.foundation.layout.WindowInsets) r0
            androidx.compose.foundation.layout.AndroidWindowInsets r1 = r3.ime
            androidx.compose.foundation.layout.WindowInsets r1 = (androidx.compose.foundation.layout.WindowInsets) r1
            androidx.compose.foundation.layout.WindowInsets r0 = androidx.compose.foundation.layout.WindowInsetsKt.union(r0, r1)
            androidx.compose.foundation.layout.AndroidWindowInsets r1 = r3.displayCutout
            androidx.compose.foundation.layout.WindowInsets r1 = (androidx.compose.foundation.layout.WindowInsets) r1
            androidx.compose.foundation.layout.WindowInsets r0 = androidx.compose.foundation.layout.WindowInsetsKt.union(r0, r1)
            r3.safeDrawing = r0
            androidx.compose.foundation.layout.AndroidWindowInsets r0 = r3.tappableElement
            androidx.compose.foundation.layout.WindowInsets r0 = (androidx.compose.foundation.layout.WindowInsets) r0
            androidx.compose.foundation.layout.AndroidWindowInsets r1 = r3.mandatorySystemGestures
            androidx.compose.foundation.layout.WindowInsets r1 = (androidx.compose.foundation.layout.WindowInsets) r1
            androidx.compose.foundation.layout.WindowInsets r0 = androidx.compose.foundation.layout.WindowInsetsKt.union(r0, r1)
            androidx.compose.foundation.layout.AndroidWindowInsets r1 = r3.systemGestures
            androidx.compose.foundation.layout.WindowInsets r1 = (androidx.compose.foundation.layout.WindowInsets) r1
            androidx.compose.foundation.layout.WindowInsets r0 = androidx.compose.foundation.layout.WindowInsetsKt.union(r0, r1)
            androidx.compose.foundation.layout.ValueInsets r1 = r3.waterfall
            androidx.compose.foundation.layout.WindowInsets r1 = (androidx.compose.foundation.layout.WindowInsets) r1
            androidx.compose.foundation.layout.WindowInsets r0 = androidx.compose.foundation.layout.WindowInsetsKt.union(r0, r1)
            r3.safeGestures = r0
            androidx.compose.foundation.layout.WindowInsets r1 = r3.safeDrawing
            androidx.compose.foundation.layout.WindowInsets r0 = androidx.compose.foundation.layout.WindowInsetsKt.union(r1, r0)
            r3.safeContent = r0
            androidx.compose.foundation.layout.WindowInsetsHolder$Companion r0 = Companion
            int r1 = androidx.core.view.WindowInsetsCompat.Type.captionBar()
            java.lang.String r2 = "captionBarIgnoringVisibility"
            androidx.compose.foundation.layout.ValueInsets r0 = r0.valueInsetsIgnoringVisibility(r4, r1, r2)
            r3.captionBarIgnoringVisibility = r0
            androidx.compose.foundation.layout.WindowInsetsHolder$Companion r0 = Companion
            int r1 = androidx.core.view.WindowInsetsCompat.Type.navigationBars()
            java.lang.String r2 = "navigationBarsIgnoringVisibility"
            androidx.compose.foundation.layout.ValueInsets r0 = r0.valueInsetsIgnoringVisibility(r4, r1, r2)
            r3.navigationBarsIgnoringVisibility = r0
            androidx.compose.foundation.layout.WindowInsetsHolder$Companion r0 = Companion
            int r1 = androidx.core.view.WindowInsetsCompat.Type.statusBars()
            java.lang.String r2 = "statusBarsIgnoringVisibility"
            androidx.compose.foundation.layout.ValueInsets r0 = r0.valueInsetsIgnoringVisibility(r4, r1, r2)
            r3.statusBarsIgnoringVisibility = r0
            androidx.compose.foundation.layout.WindowInsetsHolder$Companion r0 = Companion
            int r1 = androidx.core.view.WindowInsetsCompat.Type.systemBars()
            java.lang.String r2 = "systemBarsIgnoringVisibility"
            androidx.compose.foundation.layout.ValueInsets r0 = r0.valueInsetsIgnoringVisibility(r4, r1, r2)
            r3.systemBarsIgnoringVisibility = r0
            androidx.compose.foundation.layout.WindowInsetsHolder$Companion r0 = Companion
            int r1 = androidx.core.view.WindowInsetsCompat.Type.tappableElement()
            java.lang.String r2 = "tappableElementIgnoringVisibility"
            androidx.compose.foundation.layout.ValueInsets r4 = r0.valueInsetsIgnoringVisibility(r4, r1, r2)
            r3.tappableElementIgnoringVisibility = r4
            android.view.ViewParent r4 = r5.getParent()
            boolean r5 = r4 instanceof android.view.View
            r0 = 0
            if (r5 == 0) goto L_0x0134
            android.view.View r4 = (android.view.View) r4
            goto L_0x0135
        L_0x0134:
            r4 = r0
        L_0x0135:
            if (r4 == 0) goto L_0x013e
            int r5 = androidx.compose.ui.R.id.consume_window_insets_tag
            java.lang.Object r4 = r4.getTag(r5)
            goto L_0x013f
        L_0x013e:
            r4 = r0
        L_0x013f:
            boolean r5 = r4 instanceof java.lang.Boolean
            if (r5 == 0) goto L_0x0146
            r0 = r4
            java.lang.Boolean r0 = (java.lang.Boolean) r0
        L_0x0146:
            if (r0 == 0) goto L_0x014d
            boolean r4 = r0.booleanValue()
            goto L_0x014e
        L_0x014d:
            r4 = 1
        L_0x014e:
            r3.consumes = r4
            androidx.compose.foundation.layout.InsetsListener r4 = new androidx.compose.foundation.layout.InsetsListener
            r4.<init>(r3)
            r3.insetsListener = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.WindowInsetsHolder.<init>(androidx.core.view.WindowInsetsCompat, android.view.View):void");
    }

    public final AndroidWindowInsets getCaptionBar() {
        return this.captionBar;
    }

    public final AndroidWindowInsets getDisplayCutout() {
        return this.displayCutout;
    }

    public final AndroidWindowInsets getIme() {
        return this.ime;
    }

    public final AndroidWindowInsets getMandatorySystemGestures() {
        return this.mandatorySystemGestures;
    }

    public final AndroidWindowInsets getNavigationBars() {
        return this.navigationBars;
    }

    public final AndroidWindowInsets getStatusBars() {
        return this.statusBars;
    }

    public final AndroidWindowInsets getSystemBars() {
        return this.systemBars;
    }

    public final AndroidWindowInsets getSystemGestures() {
        return this.systemGestures;
    }

    public final AndroidWindowInsets getTappableElement() {
        return this.tappableElement;
    }

    public final ValueInsets getWaterfall() {
        return this.waterfall;
    }

    public final WindowInsets getSafeDrawing() {
        return this.safeDrawing;
    }

    public final WindowInsets getSafeGestures() {
        return this.safeGestures;
    }

    public final WindowInsets getSafeContent() {
        return this.safeContent;
    }

    public final ValueInsets getCaptionBarIgnoringVisibility() {
        return this.captionBarIgnoringVisibility;
    }

    public final ValueInsets getNavigationBarsIgnoringVisibility() {
        return this.navigationBarsIgnoringVisibility;
    }

    public final ValueInsets getStatusBarsIgnoringVisibility() {
        return this.statusBarsIgnoringVisibility;
    }

    public final ValueInsets getSystemBarsIgnoringVisibility() {
        return this.systemBarsIgnoringVisibility;
    }

    public final ValueInsets getTappableElementIgnoringVisibility() {
        return this.tappableElementIgnoringVisibility;
    }

    public final boolean getConsumes() {
        return this.consumes;
    }

    public final void incrementAccessors(View view) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        if (this.accessCount == 0) {
            ViewCompat.setOnApplyWindowInsetsListener(view, this.insetsListener);
            if (view.isAttachedToWindow()) {
                view.requestApplyInsets();
            }
            view.addOnAttachStateChangeListener(this.insetsListener);
            if (Build.VERSION.SDK_INT >= 30) {
                ViewCompat.setWindowInsetsAnimationCallback(view, this.insetsListener);
            }
        }
        this.accessCount++;
    }

    public final void decrementAccessors(View view) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        int i = this.accessCount - 1;
        this.accessCount = i;
        if (i == 0) {
            ViewCompat.setOnApplyWindowInsetsListener(view, (OnApplyWindowInsetsListener) null);
            ViewCompat.setWindowInsetsAnimationCallback(view, (WindowInsetsAnimationCompat.Callback) null);
            view.removeOnAttachStateChangeListener(this.insetsListener);
        }
    }

    public static /* synthetic */ void update$default(WindowInsetsHolder windowInsetsHolder, WindowInsetsCompat windowInsetsCompat, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        windowInsetsHolder.update(windowInsetsCompat, i);
    }

    public final void update(WindowInsetsCompat windowInsetsCompat, int i) {
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsets");
        if (testInsets) {
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            Intrinsics.checkNotNull(windowInsets);
            windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
        }
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompat, "if (testInsets) {\n      …   windowInsets\n        }");
        this.captionBar.update$foundation_layout_release(windowInsetsCompat, i);
        this.ime.update$foundation_layout_release(windowInsetsCompat, i);
        this.displayCutout.update$foundation_layout_release(windowInsetsCompat, i);
        this.navigationBars.update$foundation_layout_release(windowInsetsCompat, i);
        this.statusBars.update$foundation_layout_release(windowInsetsCompat, i);
        this.systemBars.update$foundation_layout_release(windowInsetsCompat, i);
        this.systemGestures.update$foundation_layout_release(windowInsetsCompat, i);
        this.tappableElement.update$foundation_layout_release(windowInsetsCompat, i);
        this.mandatorySystemGestures.update$foundation_layout_release(windowInsetsCompat, i);
        if (i == 0) {
            ValueInsets valueInsets = this.captionBarIgnoringVisibility;
            Insets insetsIgnoringVisibility = windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.captionBar());
            Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility, "insets.getInsetsIgnoring…aptionBar()\n            )");
            valueInsets.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(insetsIgnoringVisibility));
            ValueInsets valueInsets2 = this.navigationBarsIgnoringVisibility;
            Insets insetsIgnoringVisibility2 = windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.navigationBars());
            Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility2, "insets.getInsetsIgnoring…ationBars()\n            )");
            valueInsets2.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(insetsIgnoringVisibility2));
            ValueInsets valueInsets3 = this.statusBarsIgnoringVisibility;
            Insets insetsIgnoringVisibility3 = windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.statusBars());
            Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility3, "insets.getInsetsIgnoring…tatusBars()\n            )");
            valueInsets3.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(insetsIgnoringVisibility3));
            ValueInsets valueInsets4 = this.systemBarsIgnoringVisibility;
            Insets insetsIgnoringVisibility4 = windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars());
            Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility4, "insets.getInsetsIgnoring…ystemBars()\n            )");
            valueInsets4.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(insetsIgnoringVisibility4));
            ValueInsets valueInsets5 = this.tappableElementIgnoringVisibility;
            Insets insetsIgnoringVisibility5 = windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.tappableElement());
            Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility5, "insets.getInsetsIgnoring…leElement()\n            )");
            valueInsets5.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(insetsIgnoringVisibility5));
            DisplayCutoutCompat displayCutout2 = windowInsetsCompat.getDisplayCutout();
            if (displayCutout2 != null) {
                Insets waterfallInsets = displayCutout2.getWaterfallInsets();
                Intrinsics.checkNotNullExpressionValue(waterfallInsets, "cutout.waterfallInsets");
                this.waterfall.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(waterfallInsets));
            }
        }
        Snapshot.Companion.sendApplyNotifications();
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0004J\"\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\"\u0010\u0017\u001a\u00020\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsHolder$Companion;", "", "()V", "testInsets", "", "viewMap", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "Landroidx/compose/foundation/layout/WindowInsetsHolder;", "current", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsetsHolder;", "getOrCreateFor", "view", "setUseTestInsets", "", "systemInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "windowInsets", "Landroidx/core/view/WindowInsetsCompat;", "type", "", "name", "", "valueInsetsIgnoringVisibility", "Landroidx/compose/foundation/layout/ValueInsets;", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WindowInsets.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void setUseTestInsets(boolean z) {
            WindowInsetsHolder.testInsets = z;
        }

        public final WindowInsetsHolder current(Composer composer, int i) {
            composer.startReplaceableGroup(-1366542614);
            ComposerKt.sourceInformation(composer, "C(current)555@20288L7,558@20355L186:WindowInsets.android.kt#2w3rfo");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1366542614, i, -1, "androidx.compose.foundation.layout.WindowInsetsHolder.Companion.current (WindowInsets.android.kt:554)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
            ComposerKt.sourceInformationMarkerEnd(composer);
            View view = (View) consume;
            WindowInsetsHolder orCreateFor = getOrCreateFor(view);
            EffectsKt.DisposableEffect((Object) orCreateFor, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new WindowInsetsHolder$Companion$current$1(orCreateFor, view), composer, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return orCreateFor;
        }

        private final WindowInsetsHolder getOrCreateFor(View view) {
            WindowInsetsHolder windowInsetsHolder;
            synchronized (WindowInsetsHolder.viewMap) {
                Map access$getViewMap$cp = WindowInsetsHolder.viewMap;
                Object obj = access$getViewMap$cp.get(view);
                if (obj == null) {
                    obj = new WindowInsetsHolder((WindowInsetsCompat) null, view, (DefaultConstructorMarker) null);
                    access$getViewMap$cp.put(view, obj);
                }
                windowInsetsHolder = (WindowInsetsHolder) obj;
            }
            return windowInsetsHolder;
        }

        /* access modifiers changed from: private */
        public final AndroidWindowInsets systemInsets(WindowInsetsCompat windowInsetsCompat, int i, String str) {
            AndroidWindowInsets androidWindowInsets = new AndroidWindowInsets(i, str);
            if (windowInsetsCompat != null) {
                androidWindowInsets.update$foundation_layout_release(windowInsetsCompat, i);
            }
            return androidWindowInsets;
        }

        /* access modifiers changed from: private */
        public final ValueInsets valueInsetsIgnoringVisibility(WindowInsetsCompat windowInsetsCompat, int i, String str) {
            Insets insets;
            if (windowInsetsCompat == null || (insets = windowInsetsCompat.getInsetsIgnoringVisibility(i)) == null) {
                insets = Insets.NONE;
            }
            Intrinsics.checkNotNullExpressionValue(insets, "windowInsets?.getInsetsI…e) ?: AndroidXInsets.NONE");
            return WindowInsets_androidKt.ValueInsets(insets, str);
        }
    }
}
