package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004ø\u0001\u0001\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAwaitRelease", "", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TapGestureDetector.kt */
public interface PressGestureScope extends Density {

    /* renamed from: androidx.compose.foundation.gestures.PressGestureScope$-CC  reason: invalid class name */
    /* compiled from: TapGestureDetector.kt */
    public final /* synthetic */ class CC {
    }

    Object awaitRelease(Continuation<? super Unit> continuation);

    Object tryAwaitRelease(Continuation<? super Boolean> continuation);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TapGestureDetector.kt */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m327roundToPxR2X_6o(PressGestureScope pressGestureScope, long j) {
            return Density.CC.m4654$default$roundToPxR2X_6o(pressGestureScope, j);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m328roundToPx0680j_4(PressGestureScope pressGestureScope, float f) {
            return Density.CC.m4655$default$roundToPx0680j_4(pressGestureScope, f);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m329toDpGaN1DYA(PressGestureScope pressGestureScope, long j) {
            return Density.CC.m4656$default$toDpGaN1DYA(pressGestureScope, j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m330toDpu2uoSUM(PressGestureScope pressGestureScope, float f) {
            return Density.CC.m4657$default$toDpu2uoSUM((Density) pressGestureScope, f);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m331toDpu2uoSUM(PressGestureScope pressGestureScope, int i) {
            return Density.CC.m4658$default$toDpu2uoSUM((Density) pressGestureScope, i);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m332toDpSizekrfVVM(PressGestureScope pressGestureScope, long j) {
            return Density.CC.m4659$default$toDpSizekrfVVM(pressGestureScope, j);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m333toPxR2X_6o(PressGestureScope pressGestureScope, long j) {
            return Density.CC.m4660$default$toPxR2X_6o(pressGestureScope, j);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m334toPx0680j_4(PressGestureScope pressGestureScope, float f) {
            return Density.CC.m4661$default$toPx0680j_4(pressGestureScope, f);
        }

        @Deprecated
        public static Rect toRect(PressGestureScope pressGestureScope, DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "$receiver");
            return Density.CC.$default$toRect(pressGestureScope, dpRect);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m335toSizeXkaWNTQ(PressGestureScope pressGestureScope, long j) {
            return Density.CC.m4662$default$toSizeXkaWNTQ(pressGestureScope, j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m336toSp0xMU5do(PressGestureScope pressGestureScope, float f) {
            return Density.CC.m4663$default$toSp0xMU5do(pressGestureScope, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m337toSpkPz2Gy4(PressGestureScope pressGestureScope, float f) {
            return Density.CC.m4664$default$toSpkPz2Gy4((Density) pressGestureScope, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m338toSpkPz2Gy4(PressGestureScope pressGestureScope, int i) {
            return Density.CC.m4665$default$toSpkPz2Gy4((Density) pressGestureScope, i);
        }
    }
}
