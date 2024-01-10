package io.intercom.android.sdk.m5.components;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.m5.IntercomTheme;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"IntercomChevron", "", "(Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomChevron.kt */
public final class IntercomChevronKt {
    public static final void IntercomChevron(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(113059432);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            IconKt.m1313Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.intercom_chevron, startRestartGroup, 0), (String) null, PaddingKt.m512paddingVpY3zN4$default(RotateKt.rotate(Modifier.Companion, consume == LayoutDirection.Rtl ? 180.0f : 0.0f), Dp.m4704constructorimpl((float) 22), 0.0f, 2, (Object) null), IntercomTheme.INSTANCE.m5118getColorOnWhite0d7_KjU$intercom_sdk_base_release(), startRestartGroup, 56, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new IntercomChevronKt$IntercomChevron$1(i));
        }
    }
}
