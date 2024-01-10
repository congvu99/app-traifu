package io.intercom.android.sdk.m5.components.intercombadge;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"IntercomBadge", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "IntercomBadgePreview", "(Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomBadge.kt */
public final class IntercomBadgeKt {
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void IntercomBadge(kotlin.jvm.functions.Function0<kotlin.Unit> r17, androidx.compose.ui.Modifier r18, androidx.compose.runtime.Composer r19, int r20, int r21) {
        /*
            r0 = r17
            r1 = r20
            r2 = r21
            java.lang.String r3 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            r3 = 1251614285(0x4a9a1e4d, float:5050150.5)
            r4 = r19
            androidx.compose.runtime.Composer r3 = r4.startRestartGroup(r3)
            r4 = r2 & 1
            if (r4 == 0) goto L_0x001b
            r4 = r1 | 6
            goto L_0x002b
        L_0x001b:
            r4 = r1 & 14
            if (r4 != 0) goto L_0x002a
            boolean r4 = r3.changed((java.lang.Object) r0)
            if (r4 == 0) goto L_0x0027
            r4 = 4
            goto L_0x0028
        L_0x0027:
            r4 = 2
        L_0x0028:
            r4 = r4 | r1
            goto L_0x002b
        L_0x002a:
            r4 = r1
        L_0x002b:
            r5 = r2 & 2
            if (r5 == 0) goto L_0x0032
            r4 = r4 | 48
            goto L_0x0045
        L_0x0032:
            r6 = r1 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0045
            r6 = r18
            boolean r7 = r3.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0041
            r7 = 32
            goto L_0x0043
        L_0x0041:
            r7 = 16
        L_0x0043:
            r4 = r4 | r7
            goto L_0x0047
        L_0x0045:
            r6 = r18
        L_0x0047:
            r7 = r4 & 91
            r8 = 18
            if (r7 != r8) goto L_0x0058
            boolean r7 = r3.getSkipping()
            if (r7 != 0) goto L_0x0054
            goto L_0x0058
        L_0x0054:
            r3.skipToGroupEnd()
            goto L_0x00b0
        L_0x0058:
            if (r5 == 0) goto L_0x0061
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            r16 = r5
            goto L_0x0063
        L_0x0061:
            r16 = r6
        L_0x0063:
            r5 = 0
            androidx.compose.material.MaterialTheme r6 = androidx.compose.material.MaterialTheme.INSTANCE
            r7 = 8
            androidx.compose.material.Colors r6 = r6.getColors(r3, r7)
            boolean r6 = r6.isLight()
            if (r6 == 0) goto L_0x007c
            r6 = 4294440951(0xfff7f7f7, double:2.121735742E-314)
            long r6 = androidx.compose.ui.graphics.ColorKt.Color((long) r6)
            goto L_0x0086
        L_0x007c:
            androidx.compose.material.MaterialTheme r6 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r6 = r6.getColors(r3, r7)
            long r6 = r6.m1218getSurface0d7_KjU()
        L_0x0086:
            r8 = 0
            r10 = 0
            r11 = 0
            float r11 = (float) r11
            float r11 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r11)
            r12 = 1155896944(0x44e59670, float:1836.7012)
            io.intercom.android.sdk.m5.components.intercombadge.IntercomBadgeKt$IntercomBadge$1 r13 = new io.intercom.android.sdk.m5.components.intercombadge.IntercomBadgeKt$IntercomBadge$1
            r13.<init>(r0)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r12 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r3, r12, r14, r13)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r13 = 1769472(0x1b0000, float:2.479558E-39)
            int r4 = r4 >> 3
            r4 = r4 & 14
            r14 = r4 | r13
            r15 = 26
            r4 = r16
            r13 = r3
            androidx.compose.material.CardKt.m1177CardFjzlyU(r4, r5, r6, r8, r10, r11, r12, r13, r14, r15)
            r6 = r16
        L_0x00b0:
            androidx.compose.runtime.ScopeUpdateScope r3 = r3.endRestartGroup()
            if (r3 != 0) goto L_0x00b7
            goto L_0x00c1
        L_0x00b7:
            io.intercom.android.sdk.m5.components.intercombadge.IntercomBadgeKt$IntercomBadge$2 r4 = new io.intercom.android.sdk.m5.components.intercombadge.IntercomBadgeKt$IntercomBadge$2
            r4.<init>(r0, r6, r1, r2)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r3.updateScope(r4)
        L_0x00c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.components.intercombadge.IntercomBadgeKt.IntercomBadge(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void IntercomBadgePreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1173373024);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$IntercomBadgeKt.INSTANCE.m5181getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new IntercomBadgeKt$IntercomBadgePreview$1(i));
        }
    }
}
