package io.intercom.android.sdk.m5.inbox;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.m5.components.ErrorState;
import io.intercom.android.sdk.m5.components.IntercomErrorScreenKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"InboxErrorScreen", "", "state", "Lio/intercom/android/sdk/m5/components/ErrorState;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lio/intercom/android/sdk/m5/components/ErrorState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "InboxErrorScreenWithCTAPreview", "(Landroidx/compose/runtime/Composer;I)V", "InboxErrorScreenWithoutCTAPreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: InboxErrorScreen.kt */
public final class InboxErrorScreenKt {
    public static final void InboxErrorScreen(ErrorState errorState, Modifier modifier, Composer composer, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(errorState, "state");
        Composer startRestartGroup = composer.startRestartGroup(1763538306);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed((Object) errorState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changed((Object) modifier) ? 32 : 16;
        }
        if ((i3 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            IntercomErrorScreenKt.IntercomErrorScreen(errorState, modifier, startRestartGroup, (i3 & 112) | (i3 & 14), 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InboxErrorScreenKt$InboxErrorScreen$1(errorState, modifier, i, i2));
        }
    }

    public static final void InboxErrorScreenWithCTAPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1195714942);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$InboxErrorScreenKt.INSTANCE.m5252getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InboxErrorScreenKt$InboxErrorScreenWithCTAPreview$1(i));
        }
    }

    public static final void InboxErrorScreenWithoutCTAPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1570188684);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$InboxErrorScreenKt.INSTANCE.m5253getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InboxErrorScreenKt$InboxErrorScreenWithoutCTAPreview$1(i));
        }
    }
}
