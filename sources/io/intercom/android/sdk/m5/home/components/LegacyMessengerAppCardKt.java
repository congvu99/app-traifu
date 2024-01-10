package io.intercom.android.sdk.m5.home.components;

import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"LegacyMessengerAppCard", "", "url", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: LegacyMessengerAppCard.kt */
public final class LegacyMessengerAppCardKt {
    public static final void LegacyMessengerAppCard(String str, Composer composer, int i) {
        int i2;
        String str2 = str;
        int i3 = i;
        Intrinsics.checkNotNullParameter(str2, "url");
        Composer startRestartGroup = composer.startRestartGroup(1768759124);
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) str2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            CardKt.m1177CardFjzlyU((Modifier) null, (Shape) null, 0, 0, BorderStrokeKt.m191BorderStrokecXLIe8U(Dp.m4704constructorimpl((float) 0.5d), Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Dp.m4704constructorimpl((float) 2), ComposableLambdaKt.composableLambda(startRestartGroup, -938323439, true, new LegacyMessengerAppCardKt$LegacyMessengerAppCard$1(str2, i2)), startRestartGroup, 1769472, 15);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LegacyMessengerAppCardKt$LegacyMessengerAppCard$2(str2, i3));
        }
    }
}
