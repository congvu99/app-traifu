package io.intercom.android.sdk.m5.components;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
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
/* compiled from: ConversationItem.kt */
final class ConversationItemKt$ConversationUnreadIndicator$1$1 extends Lambda implements Function1<DrawScope, Unit> {
    public static final ConversationItemKt$ConversationUnreadIndicator$1$1 INSTANCE = new ConversationItemKt$ConversationUnreadIndicator$1$1();

    ConversationItemKt$ConversationUnreadIndicator$1$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        DrawScope.CC.m2501drawCircleVaOC9Bg$default(drawScope, ColorKt.Color(4292544041L), 0.0f, OffsetKt.Offset(Size.m1752getWidthimpl(drawScope.m2478getSizeNHjbRc()) / 2.0f, Size.m1749getHeightimpl(drawScope.m2478getSizeNHjbRc()) / 2.0f), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 122, (Object) null);
    }
}
