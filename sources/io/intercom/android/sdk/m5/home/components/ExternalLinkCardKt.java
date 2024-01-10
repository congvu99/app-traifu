package io.intercom.android.sdk.m5.home.components;

import android.content.Context;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.Colors;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.m5.home.data.HomeCards;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\r\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"ExternalLinkCard", "", "homeExternalLinkData", "Lio/intercom/android/sdk/m5/home/data/HomeCards$HomeExternalLinkData;", "(Lio/intercom/android/sdk/m5/home/data/HomeCards$HomeExternalLinkData;Landroidx/compose/runtime/Composer;I)V", "ExternalLinkCardPreview", "(Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExternalLinkCard.kt */
public final class ExternalLinkCardKt {
    public static final void ExternalLinkCard(HomeCards.HomeExternalLinkData homeExternalLinkData, Composer composer, int i) {
        HomeCards.HomeExternalLinkData homeExternalLinkData2 = homeExternalLinkData;
        Intrinsics.checkNotNullParameter(homeExternalLinkData2, "homeExternalLinkData");
        Composer startRestartGroup = composer.startRestartGroup(-111597481);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        CardKt.m1177CardFjzlyU((Modifier) null, (Shape) null, 0, 0, BorderStrokeKt.m191BorderStrokecXLIe8U(Dp.m4704constructorimpl((float) 0.5d), Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Dp.m4704constructorimpl((float) 2), ComposableLambdaKt.composableLambda(startRestartGroup, 1132240852, true, new ExternalLinkCardKt$ExternalLinkCard$1(homeExternalLinkData2, (Context) consume)), startRestartGroup, 1769472, 15);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ExternalLinkCardKt$ExternalLinkCard$2(homeExternalLinkData2, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void ExternalLinkCardPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-959560921);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$ExternalLinkCardKt.INSTANCE.m5211getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ExternalLinkCardKt$ExternalLinkCardPreview$1(i));
        }
    }
}
