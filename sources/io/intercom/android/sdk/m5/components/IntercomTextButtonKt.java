package io.intercom.android.sdk.m5.components;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a9\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0001¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\f\u001a\r\u0010\r\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"IntercomTextButton", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "trailingIconId", "", "onClick", "Lkotlin/Function0;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PrimaryButtonPreview", "(Landroidx/compose/runtime/Composer;I)V", "PrimaryButtonWithTrailingIconPreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomTextButton.kt */
public final class IntercomTextButtonKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void IntercomTextButton(java.lang.String r20, androidx.compose.ui.Modifier r21, java.lang.Integer r22, kotlin.jvm.functions.Function0<kotlin.Unit> r23, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r1 = r20
            r15 = r23
            r0 = r25
            java.lang.String r2 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r2)
            r2 = -2124423465(0xffffffff815fded7, float:-4.111851E-38)
            r3 = r24
            androidx.compose.runtime.Composer r14 = r3.startRestartGroup(r2)
            r2 = r26 & 1
            if (r2 == 0) goto L_0x0020
            r2 = r0 | 6
            goto L_0x0030
        L_0x0020:
            r2 = r0 & 14
            if (r2 != 0) goto L_0x002f
            boolean r2 = r14.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002c
            r2 = 4
            goto L_0x002d
        L_0x002c:
            r2 = 2
        L_0x002d:
            r2 = r2 | r0
            goto L_0x0030
        L_0x002f:
            r2 = r0
        L_0x0030:
            r3 = r26 & 2
            if (r3 == 0) goto L_0x0037
            r2 = r2 | 48
            goto L_0x004a
        L_0x0037:
            r4 = r0 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004a
            r4 = r21
            boolean r5 = r14.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0046
            r5 = 32
            goto L_0x0048
        L_0x0046:
            r5 = 16
        L_0x0048:
            r2 = r2 | r5
            goto L_0x004c
        L_0x004a:
            r4 = r21
        L_0x004c:
            r5 = r26 & 4
            if (r5 == 0) goto L_0x0053
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r6 = r0 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0066
            r6 = r22
            boolean r7 = r14.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0062
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r2 = r2 | r7
            goto L_0x0068
        L_0x0066:
            r6 = r22
        L_0x0068:
            r7 = r26 & 8
            if (r7 == 0) goto L_0x006f
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006f:
            r7 = r0 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x007f
            boolean r7 = r14.changed((java.lang.Object) r15)
            if (r7 == 0) goto L_0x007c
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r2 = r2 | r7
        L_0x007f:
            r7 = r2 & 5851(0x16db, float:8.199E-42)
            r8 = 1170(0x492, float:1.64E-42)
            if (r7 != r8) goto L_0x0094
            boolean r7 = r14.getSkipping()
            if (r7 != 0) goto L_0x008c
            goto L_0x0094
        L_0x008c:
            r14.skipToGroupEnd()
            r2 = r4
            r3 = r6
            r0 = r14
            goto L_0x012b
        L_0x0094:
            if (r3 == 0) goto L_0x009d
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r16 = r3
            goto L_0x009f
        L_0x009d:
            r16 = r4
        L_0x009f:
            if (r5 == 0) goto L_0x00a4
            r3 = 0
            r13 = r3
            goto L_0x00a5
        L_0x00a4:
            r13 = r6
        L_0x00a5:
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            r4 = 8
            androidx.compose.material.Shapes r3 = r3.getShapes(r14, r4)
            androidx.compose.foundation.shape.CornerBasedShape r17 = r3.getMedium()
            r12 = 1
            float r3 = (float) r12
            float r3 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r3)
            r5 = 4293454056(0xffe8e8e8, double:2.121248151E-314)
            long r5 = androidx.compose.ui.graphics.ColorKt.Color((long) r5)
            androidx.compose.foundation.BorderStroke r18 = androidx.compose.foundation.BorderStrokeKt.m191BorderStrokecXLIe8U(r3, r5)
            androidx.compose.material.ButtonDefaults r3 = androidx.compose.material.ButtonDefaults.INSTANCE
            r5 = 0
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r4 = r7.getColors(r14, r4)
            long r7 = r4.m1213getOnSurface0d7_KjU()
            r9 = 0
            r11 = 4096(0x1000, float:5.74E-42)
            r19 = 5
            r4 = r5
            r6 = r7
            r8 = r9
            r10 = r14
            r0 = 1
            r12 = r19
            androidx.compose.material.ButtonColors r9 = r3.m1173textButtonColorsRGew2ao(r4, r6, r8, r10, r11, r12)
            r3 = 12
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r3)
            r4 = 10
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            androidx.compose.foundation.layout.PaddingValues r10 = androidx.compose.foundation.layout.PaddingKt.m504PaddingValuesYgX7TsA(r3, r4)
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = r17
            androidx.compose.ui.graphics.Shape r7 = (androidx.compose.ui.graphics.Shape) r7
            r3 = 484989498(0x1ce85a3a, float:1.5375795E-21)
            io.intercom.android.sdk.m5.components.IntercomTextButtonKt$IntercomTextButton$1 r8 = new io.intercom.android.sdk.m5.components.IntercomTextButtonKt$IntercomTextButton$1
            r8.<init>(r1, r2, r13)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r3, r0, r8)
            r11 = r0
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11
            r0 = 907542528(0x36180000, float:2.2649765E-6)
            int r3 = r2 >> 9
            r3 = r3 & 14
            r0 = r0 | r3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r17 = 28
            r2 = r23
            r3 = r16
            r8 = r18
            r12 = r14
            r18 = r13
            r13 = r0
            r0 = r14
            r14 = r17
            androidx.compose.material.ButtonKt.TextButton(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r2 = r16
            r3 = r18
        L_0x012b:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto L_0x0132
            goto L_0x0145
        L_0x0132:
            io.intercom.android.sdk.m5.components.IntercomTextButtonKt$IntercomTextButton$2 r8 = new io.intercom.android.sdk.m5.components.IntercomTextButtonKt$IntercomTextButton$2
            r0 = r8
            r1 = r20
            r4 = r23
            r5 = r25
            r6 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x0145:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.components.IntercomTextButtonKt.IntercomTextButton(java.lang.String, androidx.compose.ui.Modifier, java.lang.Integer, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void PrimaryButtonPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(576106674);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$IntercomTextButtonKt.INSTANCE.m5159getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new IntercomTextButtonKt$PrimaryButtonPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void PrimaryButtonWithTrailingIconPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(615212717);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$IntercomTextButtonKt.INSTANCE.m5160getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new IntercomTextButtonKt$PrimaryButtonWithTrailingIconPreview$1(i));
        }
    }
}
