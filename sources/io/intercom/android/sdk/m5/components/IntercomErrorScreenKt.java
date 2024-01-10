package io.intercom.android.sdk.m5.components;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\u001f\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"ErrorScreenWithCTAPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "ErrorScreenWithoutCTAPreview", "IntercomErrorScreen", "state", "Lio/intercom/android/sdk/m5/components/ErrorState;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lio/intercom/android/sdk/m5/components/ErrorState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomErrorScreen.kt */
public final class IntercomErrorScreenKt {
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void IntercomErrorScreen(io.intercom.android.sdk.m5.components.ErrorState r18, androidx.compose.ui.Modifier r19, androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r0 = r18
            r1 = r21
            r2 = r22
            java.lang.String r3 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            r3 = -45428996(0xfffffffffd4acefc, float:-1.6848674E37)
            r4 = r20
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
            r6 = r19
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
            r6 = r19
        L_0x0047:
            r4 = r4 & 91
            r7 = 18
            if (r4 != r7) goto L_0x0058
            boolean r4 = r3.getSkipping()
            if (r4 != 0) goto L_0x0054
            goto L_0x0058
        L_0x0054:
            r3.skipToGroupEnd()
            goto L_0x0090
        L_0x0058:
            if (r5 == 0) goto L_0x0060
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            r15 = r4
            goto L_0x0061
        L_0x0060:
            r15 = r6
        L_0x0061:
            r4 = 0
            r5 = 0
            r6 = 1
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r15, r4, r6, r5)
            r7 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 666155072(0x27b4b840, float:5.01598E-15)
            io.intercom.android.sdk.m5.components.IntercomErrorScreenKt$IntercomErrorScreen$1 r14 = new io.intercom.android.sdk.m5.components.IntercomErrorScreenKt$IntercomErrorScreen$1
            r14.<init>(r0)
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r3, r13, r6, r14)
            r13 = r6
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r14 = 1572864(0x180000, float:2.204052E-39)
            r16 = 62
            r6 = r7
            r8 = r9
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r3
            r17 = r15
            r15 = r16
            androidx.compose.material.SurfaceKt.m1419SurfaceFjzlyU(r4, r5, r6, r8, r10, r11, r12, r13, r14, r15)
            r6 = r17
        L_0x0090:
            androidx.compose.runtime.ScopeUpdateScope r3 = r3.endRestartGroup()
            if (r3 != 0) goto L_0x0097
            goto L_0x00a1
        L_0x0097:
            io.intercom.android.sdk.m5.components.IntercomErrorScreenKt$IntercomErrorScreen$2 r4 = new io.intercom.android.sdk.m5.components.IntercomErrorScreenKt$IntercomErrorScreen$2
            r4.<init>(r0, r6, r1, r2)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r3.updateScope(r4)
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.components.IntercomErrorScreenKt.IntercomErrorScreen(io.intercom.android.sdk.m5.components.ErrorState, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void ErrorScreenWithCTAPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-2005095861);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$IntercomErrorScreenKt.INSTANCE.m5155getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new IntercomErrorScreenKt$ErrorScreenWithCTAPreview$1(i));
        }
    }

    public static final void ErrorScreenWithoutCTAPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(753957761);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$IntercomErrorScreenKt.INSTANCE.m5156getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new IntercomErrorScreenKt$ErrorScreenWithoutCTAPreview$1(i));
        }
    }
}
