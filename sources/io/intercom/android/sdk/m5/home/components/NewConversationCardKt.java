package io.intercom.android.sdk.m5.home.components;

import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.Colors;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.m5.home.data.HomeCards;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"NewConversationCard", "", "newConversation", "Lio/intercom/android/sdk/m5/home/data/HomeCards$HomeNewConversationData;", "onNewConversationClicked", "Lkotlin/Function0;", "(Lio/intercom/android/sdk/m5/home/data/HomeCards$HomeNewConversationData;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "NewConversationCardBotPreview", "(Landroidx/compose/runtime/Composer;I)V", "NewConversationCardTeammatePreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: NewConversationCard.kt */
public final class NewConversationCardKt {
    public static final void NewConversationCard(HomeCards.HomeNewConversationData homeNewConversationData, Function0<Unit> function0, Composer composer, int i) {
        HomeCards.HomeNewConversationData homeNewConversationData2 = homeNewConversationData;
        Function0<Unit> function02 = function0;
        int i2 = i;
        Intrinsics.checkNotNullParameter(homeNewConversationData2, "newConversation");
        Intrinsics.checkNotNullParameter(function02, "onNewConversationClicked");
        Composer startRestartGroup = composer.startRestartGroup(-641759021);
        CardKt.m1177CardFjzlyU((Modifier) null, (Shape) null, 0, 0, BorderStrokeKt.m191BorderStrokecXLIe8U(Dp.m4704constructorimpl((float) 0.5d), Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Dp.m4704constructorimpl((float) 2), ComposableLambdaKt.composableLambda(startRestartGroup, -211263946, true, new NewConversationCardKt$NewConversationCard$1(homeNewConversationData2, function02, i2)), startRestartGroup, 1769472, 15);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NewConversationCardKt$NewConversationCard$2(homeNewConversationData2, function02, i2));
        }
    }

    /* access modifiers changed from: private */
    public static final void NewConversationCardTeammatePreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(686820771);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$NewConversationCardKt.INSTANCE.m5214getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NewConversationCardKt$NewConversationCardTeammatePreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void NewConversationCardBotPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-2139229922);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$NewConversationCardKt.INSTANCE.m5215getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NewConversationCardKt$NewConversationCardBotPreview$1(i));
        }
    }
}
