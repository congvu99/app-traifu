package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013ø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NestedScrollModifier.kt */
public interface NestedScrollConnection {
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    Object m3293onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation);

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    long m3294onPostScrollDzOQY0M(long j, long j2, int i);

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    Object m3295onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation);

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    long m3296onPreScrollOzD1aCk(long j, int i);

    /* renamed from: androidx.compose.ui.input.nestedscroll.NestedScrollConnection$-CC  reason: invalid class name */
    /* compiled from: NestedScrollModifier.kt */
    public final /* synthetic */ class CC {
        /* renamed from: $default$onPostFling-RZ2iAVY  reason: not valid java name */
        public static Object m3297$default$onPostFlingRZ2iAVY(NestedScrollConnection nestedScrollConnection, long j, long j2, Continuation continuation) {
            return Velocity.m4920boximpl(Velocity.Companion.m4940getZero9UxMQ8M());
        }

        /* renamed from: $default$onPreFling-QWom1Mo  reason: not valid java name */
        public static Object m3299$default$onPreFlingQWom1Mo(NestedScrollConnection nestedScrollConnection, long j, Continuation continuation) {
            return Velocity.m4920boximpl(Velocity.Companion.m4940getZero9UxMQ8M());
        }

        /* renamed from: $default$onPreScroll-OzD1aCk  reason: not valid java name */
        public static long m3300$default$onPreScrollOzD1aCk(NestedScrollConnection _this, long j, int i) {
            return Offset.Companion.m1699getZeroF1C5BW0();
        }

        /* renamed from: $default$onPostScroll-DzOQY0M  reason: not valid java name */
        public static long m3298$default$onPostScrollDzOQY0M(NestedScrollConnection _this, long j, long j2, int i) {
            return Offset.Companion.m1699getZeroF1C5BW0();
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NestedScrollModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
        public static long m3310onPreScrollOzD1aCk(NestedScrollConnection nestedScrollConnection, long j, int i) {
            return CC.m3300$default$onPreScrollOzD1aCk(nestedScrollConnection, j, i);
        }

        @Deprecated
        /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
        public static long m3308onPostScrollDzOQY0M(NestedScrollConnection nestedScrollConnection, long j, long j2, int i) {
            return CC.m3298$default$onPostScrollDzOQY0M(nestedScrollConnection, j, j2, i);
        }

        @Deprecated
        /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
        public static Object m3309onPreFlingQWom1Mo(NestedScrollConnection nestedScrollConnection, long j, Continuation<? super Velocity> continuation) {
            return CC.m3299$default$onPreFlingQWom1Mo(nestedScrollConnection, j, continuation);
        }

        @Deprecated
        /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
        public static Object m3307onPostFlingRZ2iAVY(NestedScrollConnection nestedScrollConnection, long j, long j2, Continuation<? super Velocity> continuation) {
            return CC.m3297$default$onPostFlingRZ2iAVY(nestedScrollConnection, j, j2, continuation);
        }
    }
}
