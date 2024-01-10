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
import io.intercom.android.sdk.m5.home.data.HomeCards;
import io.intercom.android.sdk.m5.home.data.SpaceItemType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"SpacesCard", "", "homeSpacesData", "Lio/intercom/android/sdk/m5/home/data/HomeCards$HomeSpacesData;", "onItemClick", "Lkotlin/Function1;", "Lio/intercom/android/sdk/m5/home/data/SpaceItemType;", "(Lio/intercom/android/sdk/m5/home/data/HomeCards$HomeSpacesData;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SpacesCard.kt */
public final class SpacesCardKt {
    public static final void SpacesCard(HomeCards.HomeSpacesData homeSpacesData, Function1<? super SpaceItemType, Unit> function1, Composer composer, int i) {
        HomeCards.HomeSpacesData homeSpacesData2 = homeSpacesData;
        Function1<? super SpaceItemType, Unit> function12 = function1;
        int i2 = i;
        Intrinsics.checkNotNullParameter(homeSpacesData2, "homeSpacesData");
        Intrinsics.checkNotNullParameter(function12, "onItemClick");
        Composer startRestartGroup = composer.startRestartGroup(1661440098);
        CardKt.m1177CardFjzlyU((Modifier) null, (Shape) null, 0, 0, BorderStrokeKt.m191BorderStrokecXLIe8U(Dp.m4704constructorimpl((float) 0.5d), Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Dp.m4704constructorimpl((float) 2), ComposableLambdaKt.composableLambda(startRestartGroup, -1488661281, true, new SpacesCardKt$SpacesCard$1(homeSpacesData2, function12, i2)), startRestartGroup, 1769472, 15);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SpacesCardKt$SpacesCard$2(homeSpacesData2, function12, i2));
        }
    }
}
