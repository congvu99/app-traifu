package io.intercom.android.sdk.m5.helpcenter.components;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"SectionTitleComponent", "", "item", "Lio/intercom/android/sdk/helpcenter/collections/ArticleSectionRow$SectionRow;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lio/intercom/android/sdk/helpcenter/collections/ArticleSectionRow$SectionRow;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SectionTitleComponentPreview", "(Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SectionTitleComponent.kt */
public final class SectionTitleComponentKt {
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SectionTitleComponent(io.intercom.android.sdk.helpcenter.collections.ArticleSectionRow.SectionRow r29, androidx.compose.ui.Modifier r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r0 = r29
            r1 = r32
            r2 = r33
            java.lang.String r3 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            r3 = -2025243344(0xffffffff87493d30, float:-1.5139541E-34)
            r4 = r31
            androidx.compose.runtime.Composer r3 = r4.startRestartGroup(r3)
            r4 = r2 & 1
            r5 = 2
            if (r4 == 0) goto L_0x001c
            r4 = r1 | 6
            goto L_0x002c
        L_0x001c:
            r4 = r1 & 14
            if (r4 != 0) goto L_0x002b
            boolean r4 = r3.changed((java.lang.Object) r0)
            if (r4 == 0) goto L_0x0028
            r4 = 4
            goto L_0x0029
        L_0x0028:
            r4 = 2
        L_0x0029:
            r4 = r4 | r1
            goto L_0x002c
        L_0x002b:
            r4 = r1
        L_0x002c:
            r6 = r2 & 2
            r7 = 16
            if (r6 == 0) goto L_0x0035
            r4 = r4 | 48
            goto L_0x0048
        L_0x0035:
            r8 = r1 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0048
            r8 = r30
            boolean r9 = r3.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0044
            r9 = 32
            goto L_0x0046
        L_0x0044:
            r9 = 16
        L_0x0046:
            r4 = r4 | r9
            goto L_0x004a
        L_0x0048:
            r8 = r30
        L_0x004a:
            r4 = r4 & 91
            r9 = 18
            if (r4 != r9) goto L_0x005c
            boolean r4 = r3.getSkipping()
            if (r4 != 0) goto L_0x0057
            goto L_0x005c
        L_0x0057:
            r3.skipToGroupEnd()
            goto L_0x00d9
        L_0x005c:
            if (r6 == 0) goto L_0x0064
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            r15 = r4
            goto L_0x0065
        L_0x0064:
            r15 = r8
        L_0x0065:
            r4 = 0
            r6 = 1
            r8 = 0
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r15, r4, r6, r8)
            androidx.compose.material.MaterialTheme r6 = androidx.compose.material.MaterialTheme.INSTANCE
            r14 = 8
            androidx.compose.material.Colors r6 = r6.getColors(r3, r14)
            long r10 = r6.m1218getSurface0d7_KjU()
            r12 = 0
            r13 = 2
            r6 = 0
            r14 = r6
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.BackgroundKt.m177backgroundbw27NRU$default(r9, r10, r12, r13, r14)
            float r7 = (float) r7
            float r7 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r7)
            androidx.compose.ui.Modifier r16 = androidx.compose.foundation.layout.PaddingKt.m512paddingVpY3zN4$default(r6, r7, r4, r5, r8)
            r17 = 0
            r4 = 24
            float r4 = (float) r4
            float r18 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            r19 = 0
            r6 = 8
            float r4 = (float) r6
            float r20 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            r21 = 5
            r22 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r16, r17, r18, r19, r20, r21, r22)
            java.lang.String r4 = r29.getTitle()
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Typography r6 = r7.getTypography(r3, r6)
            androidx.compose.ui.text.TextStyle r23 = r6.getSubtitle1()
            androidx.compose.ui.text.font.FontWeight$Companion r6 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r11 = r6.getSemiBold()
            r6 = 0
            r8 = 0
            r10 = 0
            r13 = 0
            r16 = 0
            r28 = r15
            r15 = r16
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r25 = 196608(0x30000, float:2.75506E-40)
            r26 = 0
            r27 = 32732(0x7fdc, float:4.5867E-41)
            r24 = r3
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r4, r5, r6, r8, r10, r11, r12, r13, r15, r16, r17, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r8 = r28
        L_0x00d9:
            androidx.compose.runtime.ScopeUpdateScope r3 = r3.endRestartGroup()
            if (r3 != 0) goto L_0x00e0
            goto L_0x00ea
        L_0x00e0:
            io.intercom.android.sdk.m5.helpcenter.components.SectionTitleComponentKt$SectionTitleComponent$1 r4 = new io.intercom.android.sdk.m5.helpcenter.components.SectionTitleComponentKt$SectionTitleComponent$1
            r4.<init>(r0, r8, r1, r2)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r3.updateScope(r4)
        L_0x00ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.helpcenter.components.SectionTitleComponentKt.SectionTitleComponent(io.intercom.android.sdk.helpcenter.collections.ArticleSectionRow$SectionRow, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void SectionTitleComponentPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-630447638);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$SectionTitleComponentKt.INSTANCE.m5208getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SectionTitleComponentKt$SectionTitleComponentPreview$1(i));
        }
    }
}
