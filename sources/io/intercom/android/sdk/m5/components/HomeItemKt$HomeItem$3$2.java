package io.intercom.android.sdk.m5.components;

import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeItem.kt */
final class HomeItemKt$HomeItem$3$2 extends Lambda implements Function1<DrawScope, Unit> {
    public static final HomeItemKt$HomeItem$3$2 INSTANCE = new HomeItemKt$HomeItem$3$2();

    HomeItemKt$HomeItem$3$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawBehind");
        DrawScope.CC.m2501drawCircleVaOC9Bg$default(drawScope, ColorKt.Color(4292544041L), 22.0f, 0, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 124, (Object) null);
    }
}
