package androidx.compose.foundation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Magnifier.kt */
final class MagnifierKt$magnifier$4$sourceCenterInRoot$2$1 extends Lambda implements Function0<Offset> {
    final /* synthetic */ MutableState<Offset> $anchorPositionInRoot$delegate;
    final /* synthetic */ Density $density;
    final /* synthetic */ State<Function1<Density, Offset>> $updatedSourceCenter$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MagnifierKt$magnifier$4$sourceCenterInRoot$2$1(Density density, State<? extends Function1<? super Density, Offset>> state, MutableState<Offset> mutableState) {
        super(0);
        this.$density = density;
        this.$updatedSourceCenter$delegate = state;
        this.$anchorPositionInRoot$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Offset.m1672boximpl(m246invokeF1C5BW0());
    }

    /* renamed from: invoke-F1C5BW0  reason: not valid java name */
    public final long m246invokeF1C5BW0() {
        long r0 = ((Offset) MagnifierKt$magnifier$4.m240invoke$lambda3(this.$updatedSourceCenter$delegate).invoke(this.$density)).m1693unboximpl();
        if (!OffsetKt.m1702isSpecifiedk4lQ0M(MagnifierKt$magnifier$4.m237invoke$lambda1(this.$anchorPositionInRoot$delegate)) || !OffsetKt.m1702isSpecifiedk4lQ0M(r0)) {
            return Offset.Companion.m1698getUnspecifiedF1C5BW0();
        }
        return Offset.m1688plusMKHz9U(MagnifierKt$magnifier$4.m237invoke$lambda1(this.$anchorPositionInRoot$delegate), r0);
    }
}
