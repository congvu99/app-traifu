package io.intercom.android.sdk.m5.home.screens;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a!\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"HomeLoadingContent", "", "modifier", "Landroidx/compose/ui/Modifier;", "shimmerDrawable", "", "(Landroidx/compose/ui/Modifier;ILandroidx/compose/runtime/Composer;II)V", "HomeLoadingContentPreview", "(Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeLoadingContent.kt */
public final class HomeLoadingContentKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void HomeLoadingContent(androidx.compose.ui.Modifier r7, int r8, androidx.compose.runtime.Composer r9, int r10, int r11) {
        /*
            r0 = -903022646(0xffffffffca2cf7ca, float:-2833906.5)
            androidx.compose.runtime.Composer r9 = r9.startRestartGroup(r0)
            r0 = r11 & 1
            if (r0 == 0) goto L_0x000e
            r1 = r10 | 6
            goto L_0x001e
        L_0x000e:
            r1 = r10 & 14
            if (r1 != 0) goto L_0x001d
            boolean r1 = r9.changed((java.lang.Object) r7)
            if (r1 == 0) goto L_0x001a
            r1 = 4
            goto L_0x001b
        L_0x001a:
            r1 = 2
        L_0x001b:
            r1 = r1 | r10
            goto L_0x001e
        L_0x001d:
            r1 = r10
        L_0x001e:
            r2 = r11 & 2
            if (r2 == 0) goto L_0x0025
            r1 = r1 | 48
            goto L_0x0035
        L_0x0025:
            r2 = r10 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0035
            boolean r2 = r9.changed((int) r8)
            if (r2 == 0) goto L_0x0032
            r2 = 32
            goto L_0x0034
        L_0x0032:
            r2 = 16
        L_0x0034:
            r1 = r1 | r2
        L_0x0035:
            r1 = r1 & 91
            r2 = 18
            if (r1 != r2) goto L_0x0046
            boolean r1 = r9.getSkipping()
            if (r1 != 0) goto L_0x0042
            goto L_0x0046
        L_0x0042:
            r9.skipToGroupEnd()
            goto L_0x00a1
        L_0x0046:
            if (r0 == 0) goto L_0x004c
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
        L_0x004c:
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            r1 = 8
            androidx.compose.material.Colors r0 = r0.getColors(r9, r1)
            long r0 = r0.m1209getOnBackground0d7_KjU()
            r2 = 0
            r3 = 0
            r4 = 1
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r7, r2, r4, r3)
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m1922boximpl(r0)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r5 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r9.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r5)
            boolean r3 = r9.changed((java.lang.Object) r3)
            boolean r4 = r9.changed((java.lang.Object) r4)
            r3 = r3 | r4
            java.lang.Object r4 = r9.rememberedValue()
            if (r3 != 0) goto L_0x0089
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x0094
        L_0x0089:
            io.intercom.android.sdk.m5.home.screens.HomeLoadingContentKt$HomeLoadingContent$1$1 r3 = new io.intercom.android.sdk.m5.home.screens.HomeLoadingContentKt$HomeLoadingContent$1$1
            r3.<init>(r0, r8)
            r4 = r3
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r9.updateRememberedValue(r4)
        L_0x0094:
            r9.endReplaceableGroup()
            r1 = r4
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r3 = 0
            r5 = 0
            r6 = 4
            r4 = r9
            androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(r1, r2, r3, r4, r5, r6)
        L_0x00a1:
            androidx.compose.runtime.ScopeUpdateScope r9 = r9.endRestartGroup()
            if (r9 != 0) goto L_0x00a8
            goto L_0x00b2
        L_0x00a8:
            io.intercom.android.sdk.m5.home.screens.HomeLoadingContentKt$HomeLoadingContent$2 r0 = new io.intercom.android.sdk.m5.home.screens.HomeLoadingContentKt$HomeLoadingContent$2
            r0.<init>(r7, r8, r10, r11)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.home.screens.HomeLoadingContentKt.HomeLoadingContent(androidx.compose.ui.Modifier, int, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void HomeLoadingContentPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1299951780);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$HomeLoadingContentKt.INSTANCE.m5221getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new HomeLoadingContentKt$HomeLoadingContentPreview$1(i));
        }
    }
}
