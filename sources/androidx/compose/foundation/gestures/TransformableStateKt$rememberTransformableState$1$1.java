package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TransformableState.kt */
final class TransformableStateKt$rememberTransformableState$1$1 extends Lambda implements Function3<Float, Offset, Float, Unit> {
    final /* synthetic */ State<Function3<Float, Offset, Float, Unit>> $lambdaState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransformableStateKt$rememberTransformableState$1$1(State<? extends Function3<? super Float, ? super Offset, ? super Float, Unit>> state) {
        super(3);
        this.$lambdaState = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        m379invoked4ec7I(((Number) obj).floatValue(), ((Offset) obj2).m1693unboximpl(), ((Number) obj3).floatValue());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-d-4ec7I  reason: not valid java name */
    public final void m379invoked4ec7I(float f, long j, float f2) {
        this.$lambdaState.getValue().invoke(Float.valueOf(f), Offset.m1672boximpl(j), Float.valueOf(f2));
    }
}
