package androidx.compose.foundation;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Magnifier.kt */
final class MagnifierKt$magnifier$4$isMagnifierShown$2$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ State<Offset> $sourceCenterInRoot$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MagnifierKt$magnifier$4$isMagnifierShown$2$1(State<Offset> state) {
        super(0);
        this.$sourceCenterInRoot$delegate = state;
    }

    public final Boolean invoke() {
        return Boolean.valueOf(OffsetKt.m1702isSpecifiedk4lQ0M(MagnifierKt$magnifier$4.m244invoke$lambda8(this.$sourceCenterInRoot$delegate)));
    }
}
