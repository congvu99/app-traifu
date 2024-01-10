package io.intercom.android.sdk.m5.components;

import android.view.ViewGroup;
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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"BlocksLayoutCard", "", "blocksLayout", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: BlocksLayoutCard.kt */
public final class BlocksLayoutCardKt {
    public static final void BlocksLayoutCard(ViewGroup viewGroup, Composer composer, int i) {
        ViewGroup viewGroup2 = viewGroup;
        Intrinsics.checkNotNullParameter(viewGroup2, "blocksLayout");
        Composer startRestartGroup = composer.startRestartGroup(2052386320);
        CardKt.m1177CardFjzlyU((Modifier) null, (Shape) null, 0, 0, BorderStrokeKt.m191BorderStrokecXLIe8U(Dp.m4704constructorimpl((float) 1), Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Dp.m4704constructorimpl((float) 2), ComposableLambdaKt.composableLambda(startRestartGroup, -2117533811, true, new BlocksLayoutCardKt$BlocksLayoutCard$1(viewGroup2)), startRestartGroup, 1769472, 15);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BlocksLayoutCardKt$BlocksLayoutCard$2(viewGroup2, i));
        }
    }
}
