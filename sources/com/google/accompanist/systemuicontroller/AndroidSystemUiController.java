package com.google.accompanist.systemuicontroller;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.accompanist.systemuicontroller.SystemUiController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006JA\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0&H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J9\u0010)\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\b2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0&H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR$\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR$\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR$\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00178V@VX\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lcom/google/accompanist/systemuicontroller/AndroidSystemUiController;", "Lcom/google/accompanist/systemuicontroller/SystemUiController;", "view", "Landroid/view/View;", "window", "Landroid/view/Window;", "(Landroid/view/View;Landroid/view/Window;)V", "value", "", "isNavigationBarContrastEnforced", "()Z", "setNavigationBarContrastEnforced", "(Z)V", "isNavigationBarVisible", "setNavigationBarVisible", "isStatusBarVisible", "setStatusBarVisible", "navigationBarDarkContentEnabled", "getNavigationBarDarkContentEnabled", "setNavigationBarDarkContentEnabled", "statusBarDarkContentEnabled", "getStatusBarDarkContentEnabled", "setStatusBarDarkContentEnabled", "", "systemBarsBehavior", "getSystemBarsBehavior", "()I", "setSystemBarsBehavior", "(I)V", "windowInsetsController", "Landroidx/core/view/WindowInsetsControllerCompat;", "setNavigationBarColor", "", "color", "Landroidx/compose/ui/graphics/Color;", "darkIcons", "navigationBarContrastEnforced", "transformColorForLightContent", "Lkotlin/Function1;", "setNavigationBarColor-Iv8Zu3U", "(JZZLkotlin/jvm/functions/Function1;)V", "setStatusBarColor", "setStatusBarColor-ek8zF_U", "(JZLkotlin/jvm/functions/Function1;)V", "systemuicontroller_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SystemUiController.kt */
public final class AndroidSystemUiController implements SystemUiController {
    private final View view;
    private final Window window;
    private final WindowInsetsControllerCompat windowInsetsController;

    public /* synthetic */ boolean getSystemBarsDarkContentEnabled() {
        return SystemUiController.CC.$default$getSystemBarsDarkContentEnabled(this);
    }

    public /* synthetic */ boolean isSystemBarsVisible() {
        return SystemUiController.CC.$default$isSystemBarsVisible(this);
    }

    /* renamed from: setSystemBarsColor-Iv8Zu3U  reason: not valid java name */
    public /* synthetic */ void m5079setSystemBarsColorIv8Zu3U(long j, boolean z, boolean z2, Function1<? super Color, Color> function1) {
        SystemUiController.CC.m5083$default$setSystemBarsColorIv8Zu3U(this, j, z, z2, function1);
    }

    public /* synthetic */ void setSystemBarsDarkContentEnabled(boolean z) {
        SystemUiController.CC.$default$setSystemBarsDarkContentEnabled(this, z);
    }

    public /* synthetic */ void setSystemBarsVisible(boolean z) {
        SystemUiController.CC.$default$setSystemBarsVisible(this, z);
    }

    public AndroidSystemUiController(View view2, Window window2) {
        Intrinsics.checkNotNullParameter(view2, ViewHierarchyConstants.VIEW_KEY);
        this.view = view2;
        this.window = window2;
        this.windowInsetsController = window2 != null ? WindowCompat.getInsetsController(window2, view2) : null;
    }

    /* renamed from: setStatusBarColor-ek8zF_U  reason: not valid java name */
    public void m5078setStatusBarColorek8zF_U(long j, boolean z, Function1<? super Color, Color> function1) {
        Intrinsics.checkNotNullParameter(function1, "transformColorForLightContent");
        setStatusBarDarkContentEnabled(z);
        Window window2 = this.window;
        if (window2 != null) {
            if (z) {
                WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
                boolean z2 = true;
                if (windowInsetsControllerCompat == null || !windowInsetsControllerCompat.isAppearanceLightStatusBars()) {
                    z2 = false;
                }
                if (!z2) {
                    j = function1.invoke(Color.m1922boximpl(j)).m1942unboximpl();
                }
            }
            window2.setStatusBarColor(ColorKt.m1987toArgb8_81llA(j));
        }
    }

    /* renamed from: setNavigationBarColor-Iv8Zu3U  reason: not valid java name */
    public void m5077setNavigationBarColorIv8Zu3U(long j, boolean z, boolean z2, Function1<? super Color, Color> function1) {
        Intrinsics.checkNotNullParameter(function1, "transformColorForLightContent");
        setNavigationBarDarkContentEnabled(z);
        setNavigationBarContrastEnforced(z2);
        Window window2 = this.window;
        if (window2 != null) {
            if (z) {
                WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
                boolean z3 = true;
                if (windowInsetsControllerCompat == null || !windowInsetsControllerCompat.isAppearanceLightNavigationBars()) {
                    z3 = false;
                }
                if (!z3) {
                    j = function1.invoke(Color.m1922boximpl(j)).m1942unboximpl();
                }
            }
            window2.setNavigationBarColor(ColorKt.m1987toArgb8_81llA(j));
        }
    }

    public int getSystemBarsBehavior() {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
        if (windowInsetsControllerCompat != null) {
            return windowInsetsControllerCompat.getSystemBarsBehavior();
        }
        return 0;
    }

    public void setSystemBarsBehavior(int i) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
        if (windowInsetsControllerCompat != null) {
            windowInsetsControllerCompat.setSystemBarsBehavior(i);
        }
    }

    public boolean isStatusBarVisible() {
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.view);
        if (rootWindowInsets == null || !rootWindowInsets.isVisible(WindowInsetsCompat.Type.statusBars())) {
            return false;
        }
        return true;
    }

    public void setStatusBarVisible(boolean z) {
        if (z) {
            WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
            if (windowInsetsControllerCompat != null) {
                windowInsetsControllerCompat.show(WindowInsetsCompat.Type.statusBars());
                return;
            }
            return;
        }
        WindowInsetsControllerCompat windowInsetsControllerCompat2 = this.windowInsetsController;
        if (windowInsetsControllerCompat2 != null) {
            windowInsetsControllerCompat2.hide(WindowInsetsCompat.Type.statusBars());
        }
    }

    public boolean isNavigationBarVisible() {
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.view);
        if (rootWindowInsets == null || !rootWindowInsets.isVisible(WindowInsetsCompat.Type.navigationBars())) {
            return false;
        }
        return true;
    }

    public void setNavigationBarVisible(boolean z) {
        if (z) {
            WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
            if (windowInsetsControllerCompat != null) {
                windowInsetsControllerCompat.show(WindowInsetsCompat.Type.navigationBars());
                return;
            }
            return;
        }
        WindowInsetsControllerCompat windowInsetsControllerCompat2 = this.windowInsetsController;
        if (windowInsetsControllerCompat2 != null) {
            windowInsetsControllerCompat2.hide(WindowInsetsCompat.Type.navigationBars());
        }
    }

    public boolean getStatusBarDarkContentEnabled() {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
        return windowInsetsControllerCompat != null && windowInsetsControllerCompat.isAppearanceLightStatusBars();
    }

    public void setStatusBarDarkContentEnabled(boolean z) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
        if (windowInsetsControllerCompat != null) {
            windowInsetsControllerCompat.setAppearanceLightStatusBars(z);
        }
    }

    public boolean getNavigationBarDarkContentEnabled() {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
        return windowInsetsControllerCompat != null && windowInsetsControllerCompat.isAppearanceLightNavigationBars();
    }

    public void setNavigationBarDarkContentEnabled(boolean z) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
        if (windowInsetsControllerCompat != null) {
            windowInsetsControllerCompat.setAppearanceLightNavigationBars(z);
        }
    }

    public boolean isNavigationBarContrastEnforced() {
        if (Build.VERSION.SDK_INT >= 29) {
            Window window2 = this.window;
            if (window2 != null && window2.isNavigationBarContrastEnforced()) {
                return true;
            }
        }
        return false;
    }

    public void setNavigationBarContrastEnforced(boolean z) {
        Window window2;
        if (Build.VERSION.SDK_INT >= 29 && (window2 = this.window) != null) {
            window2.setNavigationBarContrastEnforced(z);
        }
    }
}
