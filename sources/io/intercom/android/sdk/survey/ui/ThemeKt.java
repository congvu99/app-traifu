package io.intercom.android.sdk.survey.ui;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"IntercomSurveyTheme", "", "darkTheme", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Theme.kt */
public final class ThemeKt {
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006b, code lost:
        if ((r9 & 1) != 0) goto L_0x0077;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void IntercomSurveyTheme(boolean r38, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r7 = r39
            r8 = r41
            r9 = r42
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 320644025(0x131ca3b9, float:1.977069E-27)
            r1 = r40
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            r0 = r8 & 14
            if (r0 != 0) goto L_0x002b
            r0 = r9 & 1
            if (r0 != 0) goto L_0x0026
            r0 = r38
            boolean r1 = r10.changed((boolean) r0)
            if (r1 == 0) goto L_0x0028
            r1 = 4
            goto L_0x0029
        L_0x0026:
            r0 = r38
        L_0x0028:
            r1 = 2
        L_0x0029:
            r1 = r1 | r8
            goto L_0x002e
        L_0x002b:
            r0 = r38
            r1 = r8
        L_0x002e:
            r2 = r9 & 2
            if (r2 == 0) goto L_0x0035
            r1 = r1 | 48
            goto L_0x0045
        L_0x0035:
            r2 = r8 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0045
            boolean r2 = r10.changed((java.lang.Object) r7)
            if (r2 == 0) goto L_0x0042
            r2 = 32
            goto L_0x0044
        L_0x0042:
            r2 = 16
        L_0x0044:
            r1 = r1 | r2
        L_0x0045:
            r2 = r1 & 91
            r3 = 18
            if (r2 != r3) goto L_0x0058
            boolean r2 = r10.getSkipping()
            if (r2 != 0) goto L_0x0052
            goto L_0x0058
        L_0x0052:
            r10.skipToGroupEnd()
            r11 = r0
            goto L_0x00cf
        L_0x0058:
            r10.startDefaults()
            r2 = r8 & 1
            if (r2 == 0) goto L_0x006e
            boolean r2 = r10.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0066
            goto L_0x006e
        L_0x0066:
            r10.skipToGroupEnd()
            r2 = r9 & 1
            if (r2 == 0) goto L_0x0079
            goto L_0x0077
        L_0x006e:
            r2 = r9 & 1
            if (r2 == 0) goto L_0x0079
            r0 = 0
            boolean r0 = androidx.compose.foundation.DarkThemeKt.isSystemInDarkTheme(r10, r0)
        L_0x0077:
            r1 = r1 & -15
        L_0x0079:
            r11 = r0
            r10.endDefaults()
            r12 = 0
            r14 = 0
            r16 = 0
            r18 = 0
            r20 = 0
            r22 = 0
            r2 = 4294785623(0xfffd3a57, double:2.1219060326E-314)
            long r24 = androidx.compose.ui.graphics.ColorKt.Color((long) r2)
            r26 = 0
            r28 = 0
            r30 = 0
            r32 = 0
            r34 = 0
            r36 = 4031(0xfbf, float:5.649E-42)
            r37 = 0
            androidx.compose.material.Colors r0 = androidx.compose.material.ColorsKt.m1236lightColors2qZNXz8$default(r12, r14, r16, r18, r20, r22, r24, r26, r28, r30, r32, r34, r36, r37)
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r3 = 8
            androidx.compose.material.Shapes r12 = r2.getShapes(r10, r3)
            r13 = 0
            float r2 = (float) r3
            float r2 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r2)
            androidx.compose.foundation.shape.RoundedCornerShape r2 = androidx.compose.foundation.shape.RoundedCornerShapeKt.m855RoundedCornerShape0680j_4(r2)
            r14 = r2
            androidx.compose.foundation.shape.CornerBasedShape r14 = (androidx.compose.foundation.shape.CornerBasedShape) r14
            r15 = 0
            r16 = 5
            r17 = 0
            androidx.compose.material.Shapes r2 = androidx.compose.material.Shapes.copy$default(r12, r13, r14, r15, r16, r17)
            r3 = 0
            int r1 = r1 << 6
            r5 = r1 & 7168(0x1c00, float:1.0045E-41)
            r6 = 2
            r1 = r3
            r3 = r39
            r4 = r10
            androidx.compose.material.MaterialThemeKt.MaterialTheme(r0, r1, r2, r3, r4, r5, r6)
        L_0x00cf:
            androidx.compose.runtime.ScopeUpdateScope r0 = r10.endRestartGroup()
            if (r0 != 0) goto L_0x00d6
            goto L_0x00e0
        L_0x00d6:
            io.intercom.android.sdk.survey.ui.ThemeKt$IntercomSurveyTheme$1 r1 = new io.intercom.android.sdk.survey.ui.ThemeKt$IntercomSurveyTheme$1
            r1.<init>(r11, r7, r8, r9)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r0.updateScope(r1)
        L_0x00e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.ThemeKt.IntercomSurveyTheme(boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
