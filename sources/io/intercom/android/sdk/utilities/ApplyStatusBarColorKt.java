package io.intercom.android.sdk.utilities;

import android.view.Window;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.view.WindowInsetsControllerCompat;
import com.google.accompanist.systemuicontroller.SystemUiController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"applyStatusBarColor", "", "systemUiController", "Lcom/google/accompanist/systemuicontroller/SystemUiController;", "color", "Landroidx/compose/ui/graphics/Color;", "applyStatusBarColor-4WTKRHQ", "(Lcom/google/accompanist/systemuicontroller/SystemUiController;J)V", "Landroid/view/Window;", "colorInt", "", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ApplyStatusBarColor.kt */
public final class ApplyStatusBarColorKt {
    public static final void applyStatusBarColor(Window window, int i) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        window.setStatusBarColor(i);
        new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightStatusBars(!ColorExtensionsKt.m5401isDarkColor8_81llA(ColorKt.Color(i)));
    }

    /* renamed from: applyStatusBarColor-4WTKRHQ  reason: not valid java name */
    public static final void m5394applyStatusBarColor4WTKRHQ(SystemUiController systemUiController, long j) {
        Intrinsics.checkNotNullParameter(systemUiController, "systemUiController");
        SystemUiController.CC.m5085setStatusBarColorek8zF_U$default(systemUiController, j, !ColorExtensionsKt.m5401isDarkColor8_81llA(j), (Function1) null, 4, (Object) null);
    }
}
