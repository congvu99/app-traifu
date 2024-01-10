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
/* compiled from: AvatarIcon.kt */
final class AvatarIconKt$AvatarActiveIndicator$1 extends Lambda implements Function1<DrawScope, Unit> {
    public static final AvatarIconKt$AvatarActiveIndicator$1 INSTANCE = new AvatarIconKt$AvatarActiveIndicator$1();

    AvatarIconKt$AvatarActiveIndicator$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        DrawScope.CC.m2501drawCircleVaOC9Bg$default(drawScope, ColorKt.Color(4280004951L), 0.0f, 0, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 126, (Object) null);
    }
}
