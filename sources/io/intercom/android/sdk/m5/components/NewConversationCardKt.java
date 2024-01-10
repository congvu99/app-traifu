package io.intercom.android.sdk.m5.components;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a)\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"NewConversationCard", "", "modifier", "Landroidx/compose/ui/Modifier;", "onNewConversationClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "NewConversationCardPreview", "(Landroidx/compose/runtime/Composer;I)V", "NewConversationCardWithButtonPreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: NewConversationCard.kt */
public final class NewConversationCardKt {
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void NewConversationCard(androidx.compose.ui.Modifier r18, kotlin.jvm.functions.Function0<kotlin.Unit> r19, androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r0 = r21
            r1 = r22
            r2 = 705360229(0x2a0af165, float:1.2340613E-13)
            r3 = r20
            androidx.compose.runtime.Composer r2 = r3.startRestartGroup(r2)
            r3 = r1 & 1
            if (r3 == 0) goto L_0x0017
            r4 = r0 | 6
            r5 = r4
            r4 = r18
            goto L_0x002b
        L_0x0017:
            r4 = r0 & 14
            if (r4 != 0) goto L_0x0028
            r4 = r18
            boolean r5 = r2.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0025
            r5 = 4
            goto L_0x0026
        L_0x0025:
            r5 = 2
        L_0x0026:
            r5 = r5 | r0
            goto L_0x002b
        L_0x0028:
            r4 = r18
            r5 = r0
        L_0x002b:
            r6 = r1 & 2
            if (r6 == 0) goto L_0x0032
            r5 = r5 | 48
            goto L_0x0045
        L_0x0032:
            r7 = r0 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0045
            r7 = r19
            boolean r8 = r2.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0041
            r8 = 32
            goto L_0x0043
        L_0x0041:
            r8 = 16
        L_0x0043:
            r5 = r5 | r8
            goto L_0x0047
        L_0x0045:
            r7 = r19
        L_0x0047:
            r5 = r5 & 91
            r8 = 18
            if (r5 != r8) goto L_0x0059
            boolean r5 = r2.getSkipping()
            if (r5 != 0) goto L_0x0054
            goto L_0x0059
        L_0x0054:
            r2.skipToGroupEnd()
            r15 = r4
            goto L_0x009f
        L_0x0059:
            if (r3 == 0) goto L_0x0061
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r15 = r3
            goto L_0x0062
        L_0x0061:
            r15 = r4
        L_0x0062:
            r3 = 0
            if (r6 == 0) goto L_0x0067
            r14 = r3
            goto L_0x0068
        L_0x0067:
            r14 = r7
        L_0x0068:
            r4 = 0
            float r4 = (float) r4
            float r10 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            r4 = 0
            r5 = 1
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r15, r4, r5, r3)
            androidx.compose.ui.graphics.Shape r4 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r6 = 0
            r8 = 0
            r11 = 0
            r12 = -1609820600(0xffffffffa00c1648, float:-1.1865834E-19)
            io.intercom.android.sdk.m5.components.NewConversationCardKt$NewConversationCard$1 r13 = new io.intercom.android.sdk.m5.components.NewConversationCardKt$NewConversationCard$1
            r13.<init>(r14)
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r12, r5, r13)
            r12 = r5
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r13 = 1769520(0x1b0030, float:2.479626E-39)
            r16 = 28
            r5 = r6
            r7 = r8
            r9 = r11
            r11 = r12
            r12 = r2
            r17 = r14
            r14 = r16
            androidx.compose.material.CardKt.m1177CardFjzlyU(r3, r4, r5, r7, r9, r10, r11, r12, r13, r14)
            r7 = r17
        L_0x009f:
            androidx.compose.runtime.ScopeUpdateScope r2 = r2.endRestartGroup()
            if (r2 != 0) goto L_0x00a6
            goto L_0x00b0
        L_0x00a6:
            io.intercom.android.sdk.m5.components.NewConversationCardKt$NewConversationCard$2 r3 = new io.intercom.android.sdk.m5.components.NewConversationCardKt$NewConversationCard$2
            r3.<init>(r15, r7, r0, r1)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r2.updateScope(r3)
        L_0x00b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.components.NewConversationCardKt.NewConversationCard(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void NewConversationCardPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1446582458);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$NewConversationCardKt.INSTANCE.m5161getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NewConversationCardKt$NewConversationCardPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void NewConversationCardWithButtonPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1361162958);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$NewConversationCardKt.INSTANCE.m5162getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NewConversationCardKt$NewConversationCardWithButtonPreview$1(i));
        }
    }
}
