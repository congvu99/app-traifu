package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0011J%\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"androidx/compose/foundation/AndroidOverscrollKt$NoOpOverscrollEffect$1", "Landroidx/compose/foundation/OverscrollEffect;", "effectModifier", "Landroidx/compose/ui/Modifier;", "getEffectModifier", "()Landroidx/compose/ui/Modifier;", "isEnabled", "", "()Z", "setEnabled", "(Z)V", "isInProgress", "consumePostFling", "", "velocity", "Landroidx/compose/ui/unit/Velocity;", "consumePostFling-sF-c-tU", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumePostScroll", "initialDragDelta", "Landroidx/compose/ui/geometry/Offset;", "overscrollDelta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "consumePostScroll-OMhpSzk", "(JJI)V", "consumePreFling", "consumePreFling-QWom1Mo", "consumePreScroll", "scrollDelta", "consumePreScroll-OzD1aCk", "(JI)J", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidOverscroll.kt */
public final class AndroidOverscrollKt$NoOpOverscrollEffect$1 implements OverscrollEffect {
    private boolean isEnabled;

    /* renamed from: consumePostScroll-OMhpSzk  reason: not valid java name */
    public void m171consumePostScrollOMhpSzk(long j, long j2, int i) {
    }

    public boolean isInProgress() {
        return false;
    }

    AndroidOverscrollKt$NoOpOverscrollEffect$1() {
    }

    /* renamed from: consumePreScroll-OzD1aCk  reason: not valid java name */
    public long m173consumePreScrollOzD1aCk(long j, int i) {
        return Offset.Companion.m1699getZeroF1C5BW0();
    }

    /* renamed from: consumePreFling-QWom1Mo  reason: not valid java name */
    public Object m172consumePreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        return Velocity.m4920boximpl(Velocity.Companion.m4940getZero9UxMQ8M());
    }

    /* renamed from: consumePostFling-sF-c-tU  reason: not valid java name */
    public Object m170consumePostFlingsFctU(long j, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public Modifier getEffectModifier() {
        return Modifier.Companion;
    }
}
