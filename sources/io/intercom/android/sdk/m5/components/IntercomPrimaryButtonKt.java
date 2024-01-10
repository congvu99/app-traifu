package io.intercom.android.sdk.m5.components;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a9\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0001¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\f\u001a\r\u0010\r\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"IntercomPrimaryButton", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "trailingIconId", "", "onClick", "Lkotlin/Function0;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PrimaryButtonPreview", "(Landroidx/compose/runtime/Composer;I)V", "PrimaryButtonWithTrailingIconPreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomPrimaryButton.kt */
public final class IntercomPrimaryButtonKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void IntercomPrimaryButton(java.lang.String r27, androidx.compose.ui.Modifier r28, java.lang.Integer r29, kotlin.jvm.functions.Function0<kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r1 = r27
            r15 = r30
            r0 = r32
            java.lang.String r2 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r2)
            r2 = -801577387(0xffffffffd038e655, float:-1.24084111E10)
            r3 = r31
            androidx.compose.runtime.Composer r2 = r3.startRestartGroup(r2)
            r3 = r33 & 1
            if (r3 == 0) goto L_0x0020
            r3 = r0 | 6
            goto L_0x0030
        L_0x0020:
            r3 = r0 & 14
            if (r3 != 0) goto L_0x002f
            boolean r3 = r2.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x002c
            r3 = 4
            goto L_0x002d
        L_0x002c:
            r3 = 2
        L_0x002d:
            r3 = r3 | r0
            goto L_0x0030
        L_0x002f:
            r3 = r0
        L_0x0030:
            r4 = r33 & 2
            r14 = 16
            if (r4 == 0) goto L_0x0039
            r3 = r3 | 48
            goto L_0x004c
        L_0x0039:
            r5 = r0 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x004c
            r5 = r28
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0048
            r6 = 32
            goto L_0x004a
        L_0x0048:
            r6 = 16
        L_0x004a:
            r3 = r3 | r6
            goto L_0x004e
        L_0x004c:
            r5 = r28
        L_0x004e:
            r6 = r33 & 4
            if (r6 == 0) goto L_0x0055
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r7 = r0 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0068
            r7 = r29
            boolean r8 = r2.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0064
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r3 = r3 | r8
            goto L_0x006a
        L_0x0068:
            r7 = r29
        L_0x006a:
            r8 = r33 & 8
            if (r8 == 0) goto L_0x0071
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x0071:
            r8 = r0 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0081
            boolean r8 = r2.changed((java.lang.Object) r15)
            if (r8 == 0) goto L_0x007e
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r3 = r3 | r8
        L_0x0081:
            r13 = r3
            r3 = r13 & 5851(0x16db, float:8.199E-42)
            r8 = 1170(0x492, float:1.64E-42)
            if (r3 != r8) goto L_0x0098
            boolean r3 = r2.getSkipping()
            if (r3 != 0) goto L_0x008f
            goto L_0x0098
        L_0x008f:
            r2.skipToGroupEnd()
            r18 = r2
            r2 = r5
            r3 = r7
            goto L_0x0194
        L_0x0098:
            if (r4 == 0) goto L_0x00a1
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r16 = r3
            goto L_0x00a3
        L_0x00a1:
            r16 = r5
        L_0x00a3:
            if (r6 == 0) goto L_0x00a8
            r3 = 0
            r12 = r3
            goto L_0x00a9
        L_0x00a8:
            r12 = r7
        L_0x00a9:
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            r4 = 8
            androidx.compose.material.Colors r3 = r3.getColors(r2, r4)
            long r5 = r3.m1214getPrimary0d7_KjU()
            boolean r3 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5402isLightColor8_81llA(r5)
            r10 = 1
            if (r3 == 0) goto L_0x00dd
            float r3 = (float) r10
            float r3 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r3)
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.Companion
            long r17 = r5.m1958getBlack0d7_KjU()
            r19 = 1045220557(0x3e4ccccd, float:0.2)
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 14
            r24 = 0
            long r5 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r17, r19, r20, r21, r22, r23, r24)
            androidx.compose.foundation.BorderStroke r3 = androidx.compose.foundation.BorderStrokeKt.m191BorderStrokecXLIe8U(r3, r5)
            goto L_0x00fd
        L_0x00dd:
            float r3 = (float) r10
            float r3 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r3)
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.Companion
            long r17 = r5.m1969getWhite0d7_KjU()
            r19 = 1045220557(0x3e4ccccd, float:0.2)
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 14
            r24 = 0
            long r5 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r17, r19, r20, r21, r22, r23, r24)
            androidx.compose.foundation.BorderStroke r3 = androidx.compose.foundation.BorderStrokeKt.m191BorderStrokecXLIe8U(r3, r5)
        L_0x00fd:
            r17 = r3
            r3 = 10
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r3)
            androidx.compose.foundation.shape.RoundedCornerShape r18 = androidx.compose.foundation.shape.RoundedCornerShapeKt.m855RoundedCornerShape0680j_4(r3)
            androidx.compose.material.ButtonDefaults r3 = androidx.compose.material.ButtonDefaults.INSTANCE
            androidx.compose.material.MaterialTheme r5 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r4 = r5.getColors(r2, r4)
            long r4 = r4.m1214getPrimary0d7_KjU()
            r6 = 0
            r8 = 0
            r19 = 0
            r21 = 32768(0x8000, float:4.5918E-41)
            r22 = 14
            r10 = r19
            r25 = r12
            r12 = r2
            r26 = r13
            r13 = r21
            r0 = 16
            r14 = r22
            androidx.compose.material.ButtonColors r12 = r3.m1164buttonColorsro_MJ88(r4, r6, r8, r10, r12, r13, r14)
            androidx.compose.material.ButtonDefaults r3 = androidx.compose.material.ButtonDefaults.INSTANCE
            r4 = 0
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 262150(0x40006, float:3.6735E-40)
            r11 = 30
            r9 = r2
            androidx.compose.material.ButtonElevation r6 = r3.m1165elevationR_JCAzs(r4, r5, r6, r7, r8, r9, r10, r11)
            float r0 = (float) r0
            float r0 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r0)
            r3 = 12
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r3)
            androidx.compose.foundation.layout.PaddingValues r10 = androidx.compose.foundation.layout.PaddingKt.m504PaddingValuesYgX7TsA(r0, r3)
            r4 = 0
            r5 = 0
            r7 = r18
            androidx.compose.ui.graphics.Shape r7 = (androidx.compose.ui.graphics.Shape) r7
            r0 = -794769307(0xffffffffd0a0c865, float:-2.15799009E10)
            io.intercom.android.sdk.m5.components.IntercomPrimaryButtonKt$IntercomPrimaryButton$1 r3 = new io.intercom.android.sdk.m5.components.IntercomPrimaryButtonKt$IntercomPrimaryButton$1
            r14 = r25
            r8 = r26
            r3.<init>(r1, r8, r14)
            r9 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r0, r9, r3)
            r11 = r0
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11
            r0 = 905969664(0x36000000, float:1.9073486E-6)
            int r3 = r8 >> 9
            r3 = r3 & 14
            r0 = r0 | r3
            r3 = r8 & 112(0x70, float:1.57E-43)
            r13 = r0 | r3
            r0 = 12
            r18 = r2
            r2 = r30
            r3 = r16
            r8 = r17
            r9 = r12
            r12 = r18
            r17 = r14
            r14 = r0
            androidx.compose.material.ButtonKt.Button(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r2 = r16
            r3 = r17
        L_0x0194:
            androidx.compose.runtime.ScopeUpdateScope r7 = r18.endRestartGroup()
            if (r7 != 0) goto L_0x019b
            goto L_0x01ae
        L_0x019b:
            io.intercom.android.sdk.m5.components.IntercomPrimaryButtonKt$IntercomPrimaryButton$2 r8 = new io.intercom.android.sdk.m5.components.IntercomPrimaryButtonKt$IntercomPrimaryButton$2
            r0 = r8
            r1 = r27
            r4 = r30
            r5 = r32
            r6 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x01ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.components.IntercomPrimaryButtonKt.IntercomPrimaryButton(java.lang.String, androidx.compose.ui.Modifier, java.lang.Integer, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void PrimaryButtonPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1925294537);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$IntercomPrimaryButtonKt.INSTANCE.m5157getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new IntercomPrimaryButtonKt$PrimaryButtonPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void PrimaryButtonWithTrailingIconPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1297682962);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$IntercomPrimaryButtonKt.INSTANCE.m5158getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new IntercomPrimaryButtonKt$PrimaryButtonWithTrailingIconPreview$1(i));
        }
    }
}
