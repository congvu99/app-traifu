package io.intercom.android.sdk.m5.home.components;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: WrapReportingText.kt */
final class WrapReportingTextKt$WrapReportingText$2$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ MutableState<Boolean> $readyToDraw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WrapReportingTextKt$WrapReportingText$2$1(MutableState<Boolean> mutableState) {
        super(1);
        this.$readyToDraw = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "$this$drawWithContent");
        if (this.$readyToDraw.getValue().booleanValue()) {
            contentDrawScope.drawContent();
        }
    }
}
