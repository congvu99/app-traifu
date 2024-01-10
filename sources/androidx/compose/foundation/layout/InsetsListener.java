package androidx.compose.foundation.layout;

import android.os.Build;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001e\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0!H\u0016J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020#H\u0016J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u0018H\u0016J\b\u0010(\u001a\u00020\u001bH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006)"}, d2 = {"Landroidx/compose/foundation/layout/InsetsListener;", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "Ljava/lang/Runnable;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "Landroid/view/View$OnAttachStateChangeListener;", "composeInsets", "Landroidx/compose/foundation/layout/WindowInsetsHolder;", "(Landroidx/compose/foundation/layout/WindowInsetsHolder;)V", "getComposeInsets", "()Landroidx/compose/foundation/layout/WindowInsetsHolder;", "prepared", "", "getPrepared", "()Z", "setPrepared", "(Z)V", "savedInsets", "Landroidx/core/view/WindowInsetsCompat;", "getSavedInsets", "()Landroidx/core/view/WindowInsetsCompat;", "setSavedInsets", "(Landroidx/core/view/WindowInsetsCompat;)V", "onApplyWindowInsets", "view", "Landroid/view/View;", "insets", "onEnd", "", "animation", "Landroidx/core/view/WindowInsetsAnimationCompat;", "onPrepare", "onProgress", "runningAnimations", "", "onStart", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "onViewAttachedToWindow", "onViewDetachedFromWindow", "v", "run", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: WindowInsets.android.kt */
final class InsetsListener extends WindowInsetsAnimationCompat.Callback implements Runnable, OnApplyWindowInsetsListener, View.OnAttachStateChangeListener {
    private final WindowInsetsHolder composeInsets;
    private boolean prepared;
    private WindowInsetsCompat savedInsets;

    public void onViewDetachedFromWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
    }

    public final WindowInsetsHolder getComposeInsets() {
        return this.composeInsets;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InsetsListener(WindowInsetsHolder windowInsetsHolder) {
        super(windowInsetsHolder.getConsumes() ^ true ? 1 : 0);
        Intrinsics.checkNotNullParameter(windowInsetsHolder, "composeInsets");
        this.composeInsets = windowInsetsHolder;
    }

    public final boolean getPrepared() {
        return this.prepared;
    }

    public final void setPrepared(boolean z) {
        this.prepared = z;
    }

    public final WindowInsetsCompat getSavedInsets() {
        return this.savedInsets;
    }

    public final void setSavedInsets(WindowInsetsCompat windowInsetsCompat) {
        this.savedInsets = windowInsetsCompat;
    }

    public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        Intrinsics.checkNotNullParameter(windowInsetsAnimationCompat, "animation");
        this.prepared = true;
        super.onPrepare(windowInsetsAnimationCompat);
    }

    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        Intrinsics.checkNotNullParameter(windowInsetsAnimationCompat, "animation");
        Intrinsics.checkNotNullParameter(boundsCompat, "bounds");
        this.prepared = false;
        WindowInsetsAnimationCompat.BoundsCompat onStart = super.onStart(windowInsetsAnimationCompat, boundsCompat);
        Intrinsics.checkNotNullExpressionValue(onStart, "super.onStart(animation, bounds)");
        return onStart;
    }

    public WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list) {
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
        Intrinsics.checkNotNullParameter(list, "runningAnimations");
        WindowInsetsHolder.update$default(this.composeInsets, windowInsetsCompat, 0, 2, (Object) null);
        if (!this.composeInsets.getConsumes()) {
            return windowInsetsCompat;
        }
        WindowInsetsCompat windowInsetsCompat2 = WindowInsetsCompat.CONSUMED;
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompat2, "CONSUMED");
        return windowInsetsCompat2;
    }

    public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        Intrinsics.checkNotNullParameter(windowInsetsAnimationCompat, "animation");
        this.prepared = false;
        WindowInsetsCompat windowInsetsCompat = this.savedInsets;
        if (!(windowInsetsAnimationCompat.getDurationMillis() == 0 || windowInsetsCompat == null)) {
            this.composeInsets.update(windowInsetsCompat, windowInsetsAnimationCompat.getTypeMask());
        }
        this.savedInsets = null;
        super.onEnd(windowInsetsAnimationCompat);
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
        if (this.prepared) {
            this.savedInsets = windowInsetsCompat;
            if (Build.VERSION.SDK_INT == 30) {
                view.post(this);
            }
            return windowInsetsCompat;
        }
        WindowInsetsHolder.update$default(this.composeInsets, windowInsetsCompat, 0, 2, (Object) null);
        if (!this.composeInsets.getConsumes()) {
            return windowInsetsCompat;
        }
        WindowInsetsCompat windowInsetsCompat2 = WindowInsetsCompat.CONSUMED;
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompat2, "CONSUMED");
        return windowInsetsCompat2;
    }

    public void run() {
        if (this.prepared) {
            this.prepared = false;
            WindowInsetsCompat windowInsetsCompat = this.savedInsets;
            if (windowInsetsCompat != null) {
                WindowInsetsHolder.update$default(this.composeInsets, windowInsetsCompat, 0, 2, (Object) null);
                this.savedInsets = null;
            }
        }
    }

    public void onViewAttachedToWindow(View view) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        view.requestApplyInsets();
    }
}
