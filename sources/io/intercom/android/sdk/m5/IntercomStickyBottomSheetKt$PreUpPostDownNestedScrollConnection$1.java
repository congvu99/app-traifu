package io.intercom.android.sdk.m5;

import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u0015*\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\t*\u00020\u0015H\u0002ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0018\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0019"}, d2 = {"io/intercom/android/sdk/m5/IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "(J)F", "toOffset", "(F)J", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomStickyBottomSheet.kt */
public final class IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ ModalBottomSheetState $this_PreUpPostDownNestedScrollConnection;

    IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1(ModalBottomSheetState modalBottomSheetState) {
        this.$this_PreUpPostDownNestedScrollConnection = modalBottomSheetState;
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m5116onPreScrollOzD1aCk(long j, int i) {
        float f = toFloat(j);
        if (f >= 0.0f || !NestedScrollSource.m3322equalsimpl0(i, NestedScrollSource.Companion.m3327getDragWNlRxjI()) || this.$this_PreUpPostDownNestedScrollConnection.getCurrentValue() == ModalBottomSheetValue.Expanded) {
            return Offset.Companion.m1699getZeroF1C5BW0();
        }
        return toOffset(this.$this_PreUpPostDownNestedScrollConnection.performDrag(f));
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m5114onPostScrollDzOQY0M(long j, long j2, int i) {
        if (!NestedScrollSource.m3322equalsimpl0(i, NestedScrollSource.Companion.m3327getDragWNlRxjI()) || this.$this_PreUpPostDownNestedScrollConnection.getCurrentValue() == ModalBottomSheetValue.Expanded) {
            return Offset.Companion.m1699getZeroF1C5BW0();
        }
        return toOffset(this.$this_PreUpPostDownNestedScrollConnection.performDrag(toFloat(j2)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m5115onPreFlingQWom1Mo(long r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1 r0 = (io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1 r0 = new io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1
            r0.<init>(r6, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            long r7 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0075
        L_0x002c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r9)
            float r9 = androidx.compose.ui.unit.Velocity.m4929getXimpl(r7)
            float r2 = androidx.compose.ui.unit.Velocity.m4930getYimpl(r7)
            long r4 = androidx.compose.ui.geometry.OffsetKt.Offset(r9, r2)
            float r9 = r6.toFloat(r4)
            r2 = 0
            int r2 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x006f
            androidx.compose.material.ModalBottomSheetState r2 = r6.$this_PreUpPostDownNestedScrollConnection
            androidx.compose.runtime.State r2 = r2.getOffset()
            java.lang.Object r2 = r2.getValue()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            r4 = 1120403456(0x42c80000, float:100.0)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x006f
            androidx.compose.material.ModalBottomSheetState r2 = r6.$this_PreUpPostDownNestedScrollConnection
            r0.J$0 = r7
            r0.label = r3
            java.lang.Object r9 = r2.performFling(r9, r0)
            if (r9 != r1) goto L_0x0075
            return r1
        L_0x006f:
            androidx.compose.ui.unit.Velocity$Companion r7 = androidx.compose.ui.unit.Velocity.Companion
            long r7 = r7.m4940getZero9UxMQ8M()
        L_0x0075:
            androidx.compose.ui.unit.Velocity r7 = androidx.compose.ui.unit.Velocity.m4920boximpl(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1.m5115onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m5113onPostFlingRZ2iAVY(long r5, long r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
        /*
            r4 = this;
            boolean r5 = r9 instanceof io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1
            if (r5 == 0) goto L_0x0014
            r5 = r9
            io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1 r5 = (io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1) r5
            int r6 = r5.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r6 & r0
            if (r6 == 0) goto L_0x0014
            int r6 = r5.label
            int r6 = r6 - r0
            r5.label = r6
            goto L_0x0019
        L_0x0014:
            io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1 r5 = new io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1
            r5.<init>(r4, r9)
        L_0x0019:
            java.lang.Object r6 = r5.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r5.label
            r1 = 1
            if (r0 == 0) goto L_0x0034
            if (r0 != r1) goto L_0x002c
            long r7 = r5.J$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0054
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.material.ModalBottomSheetState r6 = r4.$this_PreUpPostDownNestedScrollConnection
            float r0 = androidx.compose.ui.unit.Velocity.m4929getXimpl(r7)
            float r2 = androidx.compose.ui.unit.Velocity.m4930getYimpl(r7)
            long r2 = androidx.compose.ui.geometry.OffsetKt.Offset(r0, r2)
            float r0 = r4.toFloat(r2)
            r5.J$0 = r7
            r5.label = r1
            java.lang.Object r5 = r6.performFling(r0, r5)
            if (r5 != r9) goto L_0x0054
            return r9
        L_0x0054:
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.m4920boximpl(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1.m5113onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final long toOffset(float f) {
        return OffsetKt.Offset(0.0f, f);
    }

    private final float toFloat(long j) {
        return Offset.m1684getYimpl(j);
    }
}
