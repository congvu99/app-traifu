package io.intercom.android.sdk.m5.helpcenter;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\r\u0010\u0005\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"HelpCenterLoadingScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "HomeLoadingContentPreview", "(Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterLoadingScreen.kt */
public final class HelpCenterLoadingScreenKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void HelpCenterLoadingScreen(androidx.compose.ui.Modifier r7, androidx.compose.runtime.Composer r8, int r9, int r10) {
        /*
            r0 = 948792273(0x388d6bd1, float:6.743486E-5)
            androidx.compose.runtime.Composer r8 = r8.startRestartGroup(r0)
            r0 = r10 & 1
            r1 = 2
            if (r0 == 0) goto L_0x000f
            r2 = r9 | 6
            goto L_0x001f
        L_0x000f:
            r2 = r9 & 14
            if (r2 != 0) goto L_0x001e
            boolean r2 = r8.changed((java.lang.Object) r7)
            if (r2 == 0) goto L_0x001b
            r2 = 4
            goto L_0x001c
        L_0x001b:
            r2 = 2
        L_0x001c:
            r2 = r2 | r9
            goto L_0x001f
        L_0x001e:
            r2 = r9
        L_0x001f:
            r2 = r2 & 11
            if (r2 != r1) goto L_0x002e
            boolean r1 = r8.getSkipping()
            if (r1 != 0) goto L_0x002a
            goto L_0x002e
        L_0x002a:
            r8.skipToGroupEnd()
            goto L_0x0080
        L_0x002e:
            if (r0 == 0) goto L_0x0034
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
        L_0x0034:
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            r1 = 8
            androidx.compose.material.Colors r0 = r0.getColors(r8, r1)
            long r0 = r0.m1209getOnBackground0d7_KjU()
            r2 = 0
            r3 = 0
            r4 = 1
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r7, r2, r4, r3)
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m1922boximpl(r0)
            r4 = 1157296644(0x44faf204, float:2007.563)
            r8.startReplaceableGroup(r4)
            java.lang.String r4 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r4)
            boolean r3 = r8.changed((java.lang.Object) r3)
            java.lang.Object r4 = r8.rememberedValue()
            if (r3 != 0) goto L_0x0068
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x0073
        L_0x0068:
            io.intercom.android.sdk.m5.helpcenter.HelpCenterLoadingScreenKt$HelpCenterLoadingScreen$1$1 r3 = new io.intercom.android.sdk.m5.helpcenter.HelpCenterLoadingScreenKt$HelpCenterLoadingScreen$1$1
            r3.<init>(r0)
            r4 = r3
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r8.updateRememberedValue(r4)
        L_0x0073:
            r8.endReplaceableGroup()
            r1 = r4
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r3 = 0
            r5 = 0
            r6 = 4
            r4 = r8
            androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(r1, r2, r3, r4, r5, r6)
        L_0x0080:
            androidx.compose.runtime.ScopeUpdateScope r8 = r8.endRestartGroup()
            if (r8 != 0) goto L_0x0087
            goto L_0x0091
        L_0x0087:
            io.intercom.android.sdk.m5.helpcenter.HelpCenterLoadingScreenKt$HelpCenterLoadingScreen$2 r0 = new io.intercom.android.sdk.m5.helpcenter.HelpCenterLoadingScreenKt$HelpCenterLoadingScreen$2
            r0.<init>(r7, r9, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8.updateScope(r0)
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.helpcenter.HelpCenterLoadingScreenKt.HelpCenterLoadingScreen(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void HomeLoadingContentPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1279636354);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$HelpCenterLoadingScreenKt.INSTANCE.m5188getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new HelpCenterLoadingScreenKt$HomeLoadingContentPreview$1(i));
        }
    }
}
