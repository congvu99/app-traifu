package com.google.accompanist.systemuicontroller;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001JG\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0$H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&J=\u0010'\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00032\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0$H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)JG\u0010*\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0$H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0004\"\u0004\b\n\u0010\u0006R$\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00038V@VX\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0004\"\u0004\b\r\u0010\u0006R\u0018\u0010\u000e\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0004\"\u0004\b\u0010\u0010\u0006R\u0018\u0010\u0011\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0004\"\u0004\b\u0013\u0010\u0006R\u0018\u0010\u0014\u001a\u00020\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00038V@VX\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u0006ø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006,À\u0006\u0001"}, d2 = {"Lcom/google/accompanist/systemuicontroller/SystemUiController;", "", "isNavigationBarContrastEnforced", "", "()Z", "setNavigationBarContrastEnforced", "(Z)V", "isNavigationBarVisible", "setNavigationBarVisible", "isStatusBarVisible", "setStatusBarVisible", "value", "isSystemBarsVisible", "setSystemBarsVisible", "navigationBarDarkContentEnabled", "getNavigationBarDarkContentEnabled", "setNavigationBarDarkContentEnabled", "statusBarDarkContentEnabled", "getStatusBarDarkContentEnabled", "setStatusBarDarkContentEnabled", "systemBarsBehavior", "", "getSystemBarsBehavior", "()I", "setSystemBarsBehavior", "(I)V", "systemBarsDarkContentEnabled", "getSystemBarsDarkContentEnabled", "setSystemBarsDarkContentEnabled", "setNavigationBarColor", "", "color", "Landroidx/compose/ui/graphics/Color;", "darkIcons", "navigationBarContrastEnforced", "transformColorForLightContent", "Lkotlin/Function1;", "setNavigationBarColor-Iv8Zu3U", "(JZZLkotlin/jvm/functions/Function1;)V", "setStatusBarColor", "setStatusBarColor-ek8zF_U", "(JZLkotlin/jvm/functions/Function1;)V", "setSystemBarsColor", "setSystemBarsColor-Iv8Zu3U", "systemuicontroller_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SystemUiController.kt */
public interface SystemUiController {
    boolean getNavigationBarDarkContentEnabled();

    boolean getStatusBarDarkContentEnabled();

    int getSystemBarsBehavior();

    boolean getSystemBarsDarkContentEnabled();

    boolean isNavigationBarContrastEnforced();

    boolean isNavigationBarVisible();

    boolean isStatusBarVisible();

    boolean isSystemBarsVisible();

    /* renamed from: setNavigationBarColor-Iv8Zu3U  reason: not valid java name */
    void m5080setNavigationBarColorIv8Zu3U(long j, boolean z, boolean z2, Function1<? super Color, Color> function1);

    void setNavigationBarContrastEnforced(boolean z);

    void setNavigationBarDarkContentEnabled(boolean z);

    void setNavigationBarVisible(boolean z);

    /* renamed from: setStatusBarColor-ek8zF_U  reason: not valid java name */
    void m5081setStatusBarColorek8zF_U(long j, boolean z, Function1<? super Color, Color> function1);

    void setStatusBarDarkContentEnabled(boolean z);

    void setStatusBarVisible(boolean z);

    void setSystemBarsBehavior(int i);

    /* renamed from: setSystemBarsColor-Iv8Zu3U  reason: not valid java name */
    void m5082setSystemBarsColorIv8Zu3U(long j, boolean z, boolean z2, Function1<? super Color, Color> function1);

    void setSystemBarsDarkContentEnabled(boolean z);

    void setSystemBarsVisible(boolean z);

    /* renamed from: com.google.accompanist.systemuicontroller.SystemUiController$-CC  reason: invalid class name */
    /* compiled from: SystemUiController.kt */
    public final /* synthetic */ class CC {
        public static boolean $default$isSystemBarsVisible(SystemUiController _this) {
            return _this.isNavigationBarVisible() && _this.isStatusBarVisible();
        }

        public static void $default$setSystemBarsVisible(SystemUiController _this, boolean z) {
            _this.setStatusBarVisible(z);
            _this.setNavigationBarVisible(z);
        }

        /* renamed from: setStatusBarColor-ek8zF_U$default  reason: not valid java name */
        public static /* synthetic */ void m5085setStatusBarColorek8zF_U$default(SystemUiController systemUiController, long j, boolean z, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = ColorKt.m1985luminance8_81llA(j) > 0.5f;
                }
                if ((i & 4) != 0) {
                    function1 = SystemUiControllerKt.BlackScrimmed;
                }
                systemUiController.m5081setStatusBarColorek8zF_U(j, z, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStatusBarColor-ek8zF_U");
        }

        /* renamed from: setNavigationBarColor-Iv8Zu3U$default  reason: not valid java name */
        public static /* synthetic */ void m5084setNavigationBarColorIv8Zu3U$default(SystemUiController systemUiController, long j, boolean z, boolean z2, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = ColorKt.m1985luminance8_81llA(j) > 0.5f;
                }
                boolean z3 = z;
                boolean z4 = (i & 4) != 0 ? true : z2;
                if ((i & 8) != 0) {
                    function1 = SystemUiControllerKt.BlackScrimmed;
                }
                systemUiController.m5080setNavigationBarColorIv8Zu3U(j, z3, z4, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setNavigationBarColor-Iv8Zu3U");
        }

        /* renamed from: setSystemBarsColor-Iv8Zu3U$default  reason: not valid java name */
        public static /* synthetic */ void m5086setSystemBarsColorIv8Zu3U$default(SystemUiController systemUiController, long j, boolean z, boolean z2, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = ColorKt.m1985luminance8_81llA(j) > 0.5f;
                }
                boolean z3 = z;
                boolean z4 = (i & 4) != 0 ? true : z2;
                if ((i & 8) != 0) {
                    function1 = SystemUiControllerKt.BlackScrimmed;
                }
                systemUiController.m5082setSystemBarsColorIv8Zu3U(j, z3, z4, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSystemBarsColor-Iv8Zu3U");
        }

        /* renamed from: $default$setSystemBarsColor-Iv8Zu3U  reason: not valid java name */
        public static void m5083$default$setSystemBarsColorIv8Zu3U(SystemUiController _this, long j, boolean z, boolean z2, Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "transformColorForLightContent");
            _this.m5081setStatusBarColorek8zF_U(j, z, function1);
            _this.m5080setNavigationBarColorIv8Zu3U(j, z, z2, function1);
        }

        public static boolean $default$getSystemBarsDarkContentEnabled(SystemUiController _this) {
            return _this.getStatusBarDarkContentEnabled() && _this.getNavigationBarDarkContentEnabled();
        }

        public static void $default$setSystemBarsDarkContentEnabled(SystemUiController _this, boolean z) {
            _this.setStatusBarDarkContentEnabled(z);
            _this.setNavigationBarDarkContentEnabled(z);
        }
    }
}
