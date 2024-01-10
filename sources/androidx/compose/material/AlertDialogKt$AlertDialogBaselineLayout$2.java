package androidx.compose.material;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import java.util.List;
import kotlin.Metadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlertDialog.kt */
final class AlertDialogKt$AlertDialogBaselineLayout$2 implements MeasurePolicy {
    public static final AlertDialogKt$AlertDialogBaselineLayout$2 INSTANCE = new AlertDialogKt$AlertDialogBaselineLayout$2();

    AlertDialogKt$AlertDialogBaselineLayout$2() {
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0118  */
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.layout.MeasureResult m1112measure3p2s80s(androidx.compose.ui.layout.MeasureScope r12, java.util.List<? extends androidx.compose.ui.layout.Measurable> r13, long r14) {
        /*
            r11 = this;
            java.lang.String r0 = "$this$Layout"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "measurables"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r0 = r13.iterator()
        L_0x0010:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x002c
            java.lang.Object r1 = r0.next()
            r3 = r1
            androidx.compose.ui.layout.Measurable r3 = (androidx.compose.ui.layout.Measurable) r3
            java.lang.Object r3 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r3)
            java.lang.String r4 = "title"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0010
            goto L_0x002d
        L_0x002c:
            r1 = r2
        L_0x002d:
            androidx.compose.ui.layout.Measurable r1 = (androidx.compose.ui.layout.Measurable) r1
            if (r1 == 0) goto L_0x0042
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 11
            r10 = 0
            r3 = r14
            long r3 = androidx.compose.ui.unit.Constraints.m4615copyZbe2FdA$default(r3, r5, r6, r7, r8, r9, r10)
            androidx.compose.ui.layout.Placeable r0 = r1.m3649measureBRTryo0(r3)
            goto L_0x0043
        L_0x0042:
            r0 = r2
        L_0x0043:
            java.util.Iterator r13 = r13.iterator()
        L_0x0047:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x0062
            java.lang.Object r1 = r13.next()
            r3 = r1
            androidx.compose.ui.layout.Measurable r3 = (androidx.compose.ui.layout.Measurable) r3
            java.lang.Object r3 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r3)
            java.lang.String r4 = "text"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0047
            goto L_0x0063
        L_0x0062:
            r1 = r2
        L_0x0063:
            androidx.compose.ui.layout.Measurable r1 = (androidx.compose.ui.layout.Measurable) r1
            if (r1 == 0) goto L_0x0078
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 11
            r10 = 0
            r3 = r14
            long r13 = androidx.compose.ui.unit.Constraints.m4615copyZbe2FdA$default(r3, r5, r6, r7, r8, r9, r10)
            androidx.compose.ui.layout.Placeable r13 = r1.m3649measureBRTryo0(r13)
            goto L_0x0079
        L_0x0078:
            r13 = r2
        L_0x0079:
            r14 = 0
            if (r0 == 0) goto L_0x0081
            int r15 = r0.getWidth()
            goto L_0x0082
        L_0x0081:
            r15 = 0
        L_0x0082:
            if (r13 == 0) goto L_0x0089
            int r1 = r13.getWidth()
            goto L_0x008a
        L_0x0089:
            r1 = 0
        L_0x008a:
            int r4 = java.lang.Math.max(r15, r1)
            r15 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == 0) goto L_0x00ab
            androidx.compose.ui.layout.HorizontalAlignmentLine r1 = androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline()
            androidx.compose.ui.layout.AlignmentLine r1 = (androidx.compose.ui.layout.AlignmentLine) r1
            int r1 = r0.get(r1)
            if (r1 != r15) goto L_0x00a0
            r1 = r2
            goto L_0x00a4
        L_0x00a0:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x00a4:
            if (r1 == 0) goto L_0x00ab
            int r1 = r1.intValue()
            goto L_0x00ac
        L_0x00ab:
            r1 = 0
        L_0x00ac:
            if (r0 == 0) goto L_0x00c7
            androidx.compose.ui.layout.HorizontalAlignmentLine r3 = androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline()
            androidx.compose.ui.layout.AlignmentLine r3 = (androidx.compose.ui.layout.AlignmentLine) r3
            int r3 = r0.get(r3)
            if (r3 != r15) goto L_0x00bc
            r3 = r2
            goto L_0x00c0
        L_0x00bc:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x00c0:
            if (r3 == 0) goto L_0x00c7
            int r3 = r3.intValue()
            goto L_0x00c8
        L_0x00c7:
            r3 = 0
        L_0x00c8:
            long r5 = androidx.compose.material.AlertDialogKt.TitleBaselineDistanceFromTop
            int r5 = r12.m4642roundToPxR2X_6o(r5)
            int r5 = r5 - r1
            if (r13 == 0) goto L_0x00eb
            androidx.compose.ui.layout.HorizontalAlignmentLine r1 = androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline()
            androidx.compose.ui.layout.AlignmentLine r1 = (androidx.compose.ui.layout.AlignmentLine) r1
            int r1 = r13.get(r1)
            if (r1 != r15) goto L_0x00e0
            goto L_0x00e4
        L_0x00e0:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
        L_0x00e4:
            if (r2 == 0) goto L_0x00eb
            int r15 = r2.intValue()
            goto L_0x00ec
        L_0x00eb:
            r15 = 0
        L_0x00ec:
            if (r0 != 0) goto L_0x00f7
            long r1 = androidx.compose.material.AlertDialogKt.TextBaselineDistanceFromTop
            int r1 = r12.m4642roundToPxR2X_6o(r1)
            goto L_0x00ff
        L_0x00f7:
            long r1 = androidx.compose.material.AlertDialogKt.TextBaselineDistanceFromTitle
            int r1 = r12.m4642roundToPxR2X_6o(r1)
        L_0x00ff:
            if (r0 == 0) goto L_0x0107
            int r2 = r0.getHeight()
            int r2 = r2 + r5
            goto L_0x0108
        L_0x0107:
            r2 = 0
        L_0x0108:
            if (r0 != 0) goto L_0x010d
            int r6 = r1 - r15
            goto L_0x0116
        L_0x010d:
            if (r3 != 0) goto L_0x0112
            int r6 = r2 - r15
            goto L_0x0115
        L_0x0112:
            int r6 = r5 + r3
            int r6 = r6 - r15
        L_0x0115:
            int r6 = r6 + r1
        L_0x0116:
            if (r13 == 0) goto L_0x0130
            if (r3 != 0) goto L_0x0121
            int r14 = r13.getHeight()
            int r14 = r14 + r1
            int r14 = r14 - r15
            goto L_0x0130
        L_0x0121:
            int r7 = r13.getHeight()
            int r7 = r7 + r1
            int r7 = r7 - r15
            if (r0 == 0) goto L_0x012d
            int r14 = r0.getHeight()
        L_0x012d:
            int r14 = r14 - r3
            int r7 = r7 - r14
            r14 = r7
        L_0x0130:
            int r14 = r14 + r2
            r15 = 0
            androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2$measure$1 r1 = new androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2$measure$1
            r1.<init>(r0, r5, r13, r6)
            r7 = r1
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r8 = 4
            r9 = 0
            r3 = r12
            r5 = r14
            r6 = r15
            androidx.compose.ui.layout.MeasureResult r12 = androidx.compose.ui.layout.MeasureScope.CC.layout$default(r3, r4, r5, r6, r7, r8, r9)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2.m1112measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }
}
