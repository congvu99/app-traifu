package androidx.compose.ui.viewinterop;

import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidView.android.kt */
public final class AndroidView_androidKt$AndroidView$noOpConnection$1$1 implements NestedScrollConnection {
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public /* synthetic */ Object m4944onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        return NestedScrollConnection.CC.m3297$default$onPostFlingRZ2iAVY(this, j, j2, continuation);
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public /* synthetic */ long m4945onPostScrollDzOQY0M(long j, long j2, int i) {
        return NestedScrollConnection.CC.m3298$default$onPostScrollDzOQY0M(this, j, j2, i);
    }

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public /* synthetic */ Object m4946onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        return NestedScrollConnection.CC.m3299$default$onPreFlingQWom1Mo(this, j, continuation);
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public /* synthetic */ long m4947onPreScrollOzD1aCk(long j, int i) {
        return NestedScrollConnection.CC.m3300$default$onPreScrollOzD1aCk(this, j, i);
    }

    AndroidView_androidKt$AndroidView$noOpConnection$1$1() {
    }
}
