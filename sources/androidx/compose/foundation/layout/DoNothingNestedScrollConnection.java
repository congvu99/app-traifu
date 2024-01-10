package androidx.compose.foundation.layout;

import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/DoNothingNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "()V", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: WindowInsetsConnection.android.kt */
final class DoNothingNestedScrollConnection implements NestedScrollConnection {
    public static final DoNothingNestedScrollConnection INSTANCE = new DoNothingNestedScrollConnection();

    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public /* synthetic */ Object m472onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        return NestedScrollConnection.CC.m3297$default$onPostFlingRZ2iAVY(this, j, j2, continuation);
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public /* synthetic */ long m473onPostScrollDzOQY0M(long j, long j2, int i) {
        return NestedScrollConnection.CC.m3298$default$onPostScrollDzOQY0M(this, j, j2, i);
    }

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public /* synthetic */ Object m474onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        return NestedScrollConnection.CC.m3299$default$onPreFlingQWom1Mo(this, j, continuation);
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public /* synthetic */ long m475onPreScrollOzD1aCk(long j, int i) {
        return NestedScrollConnection.CC.m3300$default$onPreScrollOzD1aCk(this, j, i);
    }

    private DoNothingNestedScrollConnection() {
    }
}
