package io.intercom.android.sdk.tickets;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"TicketProgressRow", "", "name", "", "status", "onClick", "Lkotlin/Function0;", "visible", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TicketProgressRowPreview", "(Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketProgressRow.kt */
public final class TicketProgressRowKt {
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TicketProgressRow(java.lang.String r20, java.lang.String r21, kotlin.jvm.functions.Function0<kotlin.Unit> r22, boolean r23, androidx.compose.ui.Modifier r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r6 = r20
            r7 = r21
            r8 = r22
            r9 = r26
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "status"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 1942484036(0x73c7f444, float:3.1684002E31)
            r1 = r25
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            r0 = r27 & 1
            r1 = 4
            r2 = 2
            if (r0 == 0) goto L_0x0029
            r0 = r9 | 6
            goto L_0x0039
        L_0x0029:
            r0 = r9 & 14
            if (r0 != 0) goto L_0x0038
            boolean r0 = r15.changed((java.lang.Object) r6)
            if (r0 == 0) goto L_0x0035
            r0 = 4
            goto L_0x0036
        L_0x0035:
            r0 = 2
        L_0x0036:
            r0 = r0 | r9
            goto L_0x0039
        L_0x0038:
            r0 = r9
        L_0x0039:
            r3 = r27 & 2
            if (r3 == 0) goto L_0x0040
            r0 = r0 | 48
            goto L_0x0050
        L_0x0040:
            r3 = r9 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0050
            boolean r3 = r15.changed((java.lang.Object) r7)
            if (r3 == 0) goto L_0x004d
            r3 = 32
            goto L_0x004f
        L_0x004d:
            r3 = 16
        L_0x004f:
            r0 = r0 | r3
        L_0x0050:
            r3 = r27 & 4
            if (r3 == 0) goto L_0x0057
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0067
        L_0x0057:
            r3 = r9 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0067
            boolean r3 = r15.changed((java.lang.Object) r8)
            if (r3 == 0) goto L_0x0064
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r0 = r0 | r3
        L_0x0067:
            r3 = r27 & 8
            if (r3 == 0) goto L_0x0070
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r14 = r23
            goto L_0x0082
        L_0x0070:
            r3 = r9 & 7168(0x1c00, float:1.0045E-41)
            r14 = r23
            if (r3 != 0) goto L_0x0082
            boolean r3 = r15.changed((boolean) r14)
            if (r3 == 0) goto L_0x007f
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007f:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r0 = r0 | r3
        L_0x0082:
            r3 = r27 & 16
            if (r3 == 0) goto L_0x0089
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009e
        L_0x0089:
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r9
            if (r4 != 0) goto L_0x009e
            r4 = r24
            boolean r5 = r15.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x009a
            r5 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r5 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r0 = r0 | r5
            goto L_0x00a0
        L_0x009e:
            r4 = r24
        L_0x00a0:
            r10 = r0
            r0 = 46811(0xb6db, float:6.5596E-41)
            r0 = r0 & r10
            r5 = 9362(0x2492, float:1.3119E-41)
            if (r0 != r5) goto L_0x00b6
            boolean r0 = r15.getSkipping()
            if (r0 != 0) goto L_0x00b0
            goto L_0x00b6
        L_0x00b0:
            r15.skipToGroupEnd()
            r5 = r4
            r1 = r15
            goto L_0x0114
        L_0x00b6:
            if (r3 == 0) goto L_0x00bf
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r19 = r0
            goto L_0x00c1
        L_0x00bf:
            r19 = r4
        L_0x00c1:
            r0 = 1000(0x3e8, float:1.401E-42)
            r3 = 0
            androidx.compose.animation.core.TweenSpec r1 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r0, r0, r3, r1, r3)
            androidx.compose.animation.core.FiniteAnimationSpec r1 = (androidx.compose.animation.core.FiniteAnimationSpec) r1
            r4 = 0
            androidx.compose.animation.EnterTransition r12 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r1, r4, r2, r3)
            r1 = 0
            r5 = 6
            androidx.compose.animation.core.TweenSpec r0 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r0, r1, r3, r5, r3)
            androidx.compose.animation.core.FiniteAnimationSpec r0 = (androidx.compose.animation.core.FiniteAnimationSpec) r0
            androidx.compose.animation.ExitTransition r13 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r0, r4, r2, r3)
            r16 = 0
            r5 = 1078270236(0x4045191c, float:3.0796576)
            io.intercom.android.sdk.tickets.TicketProgressRowKt$TicketProgressRow$1 r4 = new io.intercom.android.sdk.tickets.TicketProgressRowKt$TicketProgressRow$1
            r0 = r4
            r1 = r19
            r2 = r22
            r3 = r20
            r11 = r4
            r4 = r21
            r6 = 1078270236(0x4045191c, float:3.0796576)
            r5 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r6, r0, r11)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r1 = 200064(0x30d80, float:2.8035E-40)
            int r2 = r10 >> 9
            r2 = r2 & 14
            r17 = r2 | r1
            r18 = 18
            r10 = r23
            r1 = 0
            r11 = r1
            r14 = r16
            r1 = r15
            r15 = r0
            r16 = r1
            androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility((boolean) r10, (androidx.compose.ui.Modifier) r11, (androidx.compose.animation.EnterTransition) r12, (androidx.compose.animation.ExitTransition) r13, (java.lang.String) r14, (kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r15, (androidx.compose.runtime.Composer) r16, (int) r17, (int) r18)
            r5 = r19
        L_0x0114:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 != 0) goto L_0x011b
            goto L_0x0132
        L_0x011b:
            io.intercom.android.sdk.tickets.TicketProgressRowKt$TicketProgressRow$2 r11 = new io.intercom.android.sdk.tickets.TicketProgressRowKt$TicketProgressRow$2
            r0 = r11
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r6 = r26
            r7 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0132:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.tickets.TicketProgressRowKt.TicketProgressRow(java.lang.String, java.lang.String, kotlin.jvm.functions.Function0, boolean, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void TicketProgressRowPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1160752885);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TicketProgressRowKt.INSTANCE.m5362getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TicketProgressRowKt$TicketProgressRowPreview$1(i));
        }
    }
}
