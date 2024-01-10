package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.MagnifierKt;
import androidx.compose.foundation.MagnifierStyle;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SelectionManager.android.kt */
final class SelectionManager_androidKt$selectionMagnifier$1$2$1 extends Lambda implements Function1<Function0<? extends Offset>, Modifier> {
    final /* synthetic */ Density $density;
    final /* synthetic */ MutableState<IntSize> $magnifierSize$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionManager_androidKt$selectionMagnifier$1$2$1(Density density, MutableState<IntSize> mutableState) {
        super(1);
        this.$density = density;
        this.$magnifierSize$delegate = mutableState;
    }

    public final Modifier invoke(final Function0<Offset> function0) {
        Intrinsics.checkNotNullParameter(function0, "center");
        Modifier.Companion companion = Modifier.Companion;
        MagnifierStyle textDefault = MagnifierStyle.Companion.getTextDefault();
        final Density density = this.$density;
        final MutableState<IntSize> mutableState = this.$magnifierSize$delegate;
        return MagnifierKt.magnifier$default(companion, new Function1<Density, Offset>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Offset.m1672boximpl(m1064invoketuRUvjQ((Density) obj));
            }

            /* renamed from: invoke-tuRUvjQ  reason: not valid java name */
            public final long m1064invoketuRUvjQ(Density density) {
                Intrinsics.checkNotNullParameter(density, "$this$magnifier");
                return function0.invoke().m1693unboximpl();
            }
        }, (Function1) null, 0.0f, textDefault, new Function1<DpSize, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m1065invokeEaSLcWc(((DpSize) obj).m4810unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-EaSLcWc  reason: not valid java name */
            public final void m1065invokeEaSLcWc(long j) {
                MutableState<IntSize> mutableState = mutableState;
                Density density = density;
                SelectionManager_androidKt$selectionMagnifier$1.m1062invoke$lambda2(mutableState, IntSizeKt.IntSize(density.m4643roundToPx0680j_4(DpSize.m4802getWidthD9Ej5fM(j)), density.m4643roundToPx0680j_4(DpSize.m4800getHeightD9Ej5fM(j))));
            }
        }, 6, (Object) null);
    }
}
