package androidx.compose.ui.graphics;

import android.graphics.Matrix;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\t"}, d2 = {"setFrom", "", "Landroid/graphics/Matrix;", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "setFrom-EL8BTi8", "(Landroid/graphics/Matrix;[F)V", "setFrom-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidMatrixConversions.android.kt */
public final class AndroidMatrixConversions_androidKt {
    /* renamed from: setFrom-tU-YjHk  reason: not valid java name */
    public static final void m1796setFromtUYjHk(float[] fArr, Matrix matrix) {
        float[] fArr2 = fArr;
        Matrix matrix2 = matrix;
        Intrinsics.checkNotNullParameter(fArr2, "$this$setFrom");
        Intrinsics.checkNotNullParameter(matrix2, "matrix");
        matrix2.getValues(fArr2);
        float f = fArr2[0];
        float f2 = fArr2[1];
        float f3 = fArr2[2];
        float f4 = fArr2[3];
        float f5 = fArr2[4];
        float f6 = fArr2[5];
        float f7 = fArr2[6];
        float f8 = fArr2[7];
        float f9 = fArr2[8];
        fArr2[0] = f;
        fArr2[1] = f4;
        fArr2[2] = 0.0f;
        fArr2[3] = f7;
        fArr2[4] = f2;
        fArr2[5] = f5;
        fArr2[6] = 0.0f;
        fArr2[7] = f8;
        fArr2[8] = 0.0f;
        fArr2[9] = 0.0f;
        fArr2[10] = 1.0f;
        fArr2[11] = 0.0f;
        fArr2[12] = f3;
        fArr2[13] = f6;
        fArr2[14] = 0.0f;
        fArr2[15] = f9;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bc  */
    /* renamed from: setFrom-EL8BTi8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1795setFromEL8BTi8(android.graphics.Matrix r23, float[] r24) {
        /*
            r0 = r24
            java.lang.String r1 = "$this$setFrom"
            r2 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.String r1 = "matrix"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = 2
            r3 = r0[r1]
            r4 = 0
            r5 = 1
            r6 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x001a
            r3 = 1
            goto L_0x001b
        L_0x001a:
            r3 = 0
        L_0x001b:
            r7 = 8
            r8 = 6
            if (r3 == 0) goto L_0x006e
            r3 = r0[r8]
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x0028
            r3 = 1
            goto L_0x0029
        L_0x0028:
            r3 = 0
        L_0x0029:
            if (r3 == 0) goto L_0x006e
            r3 = 10
            r3 = r0[r3]
            r9 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r3 != 0) goto L_0x0037
            r3 = 1
            goto L_0x0038
        L_0x0037:
            r3 = 0
        L_0x0038:
            if (r3 == 0) goto L_0x006e
            r3 = 14
            r3 = r0[r3]
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x0044
            r3 = 1
            goto L_0x0045
        L_0x0044:
            r3 = 0
        L_0x0045:
            if (r3 == 0) goto L_0x006e
            r3 = r0[r7]
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x004f
            r3 = 1
            goto L_0x0050
        L_0x004f:
            r3 = 0
        L_0x0050:
            if (r3 == 0) goto L_0x006e
            r3 = 9
            r3 = r0[r3]
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x005c
            r3 = 1
            goto L_0x005d
        L_0x005c:
            r3 = 0
        L_0x005d:
            if (r3 == 0) goto L_0x006e
            r3 = 11
            r3 = r0[r3]
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x0069
            r3 = 1
            goto L_0x006a
        L_0x0069:
            r3 = 0
        L_0x006a:
            if (r3 == 0) goto L_0x006e
            r3 = 1
            goto L_0x006f
        L_0x006e:
            r3 = 0
        L_0x006f:
            if (r3 == 0) goto L_0x00bc
            r3 = r0[r6]
            r4 = r0[r5]
            r9 = r0[r1]
            r10 = 3
            r11 = r0[r10]
            r12 = 4
            r13 = r0[r12]
            r14 = 5
            r15 = r0[r14]
            r16 = r0[r8]
            r17 = 7
            r18 = r0[r17]
            r19 = r0[r7]
            r20 = 12
            r20 = r0[r20]
            r21 = 13
            r21 = r0[r21]
            r22 = 15
            r22 = r0[r22]
            r0[r6] = r3
            r0[r5] = r13
            r0[r1] = r20
            r0[r10] = r4
            r0[r12] = r15
            r0[r14] = r21
            r0[r8] = r11
            r0[r17] = r18
            r0[r7] = r22
            r23.setValues(r24)
            r0[r6] = r3
            r0[r5] = r4
            r0[r1] = r9
            r0[r10] = r11
            r0[r12] = r13
            r0[r14] = r15
            r0[r8] = r16
            r0[r17] = r18
            r0[r7] = r19
            return
        L_0x00bc:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Android does not support arbitrary transforms"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt.m1795setFromEL8BTi8(android.graphics.Matrix, float[]):void");
    }
}
