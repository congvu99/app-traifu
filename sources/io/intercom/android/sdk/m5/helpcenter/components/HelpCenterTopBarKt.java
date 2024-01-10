package io.intercom.android.sdk.m5.helpcenter.components;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.StringResources_androidKt;
import com.facebook.internal.FacebookRequestErrorClassification;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.m5.components.TopActionBarKt;
import io.intercom.android.sdk.models.Avatar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a)\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0001¢\u0006\u0002\u0010\u0005\u001a\r\u0010\u0006\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"HelpCenterTopBar", "", "onBackClick", "Lkotlin/Function0;", "onSearchClick", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "HelpCenterTopBarPreview", "(Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterTopBar.kt */
public final class HelpCenterTopBarKt {
    public static final void HelpCenterTopBar(Function0<Unit> function0, Function0<Unit> function02, Composer composer, int i) {
        int i2;
        Composer composer2;
        Function0<Unit> function03;
        Function0<Unit> function04 = function0;
        Function0<Unit> function05 = function02;
        int i3 = i;
        Intrinsics.checkNotNullParameter(function04, "onBackClick");
        Intrinsics.checkNotNullParameter(function05, "onSearchClick");
        Composer startRestartGroup = composer.startRestartGroup(1455848260);
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) function04) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) function05) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            composer2 = startRestartGroup;
            function03 = function05;
            TopActionBarKt.m5180TopActionBar6oU6zVQ((Modifier) null, StringResources_androidKt.stringResource(R.string.intercom_get_help, startRestartGroup, 0), (String) null, (List<? extends Avatar>) null, function0, (Painter) null, false, 0, 0, ComposableLambdaKt.composableLambda(startRestartGroup, -1651778198, true, new HelpCenterTopBarKt$HelpCenterTopBar$1(function05, i2)), startRestartGroup, ((i2 << 12) & 57344) | 805306368, FacebookRequestErrorClassification.ESC_APP_INACTIVE);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
            function03 = function05;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new HelpCenterTopBarKt$HelpCenterTopBar$2(function0, function03, i));
        }
    }

    public static final void HelpCenterTopBarPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1538438368);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$HelpCenterTopBarKt.INSTANCE.m5206getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new HelpCenterTopBarKt$HelpCenterTopBarPreview$1(i));
        }
    }
}
