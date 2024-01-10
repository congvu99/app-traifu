package io.intercom.android.sdk.m5.components;

import android.content.Context;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.SizeKt;
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
import io.intercom.android.sdk.models.Avatar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a3\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"PreviewSearchBrowse", "", "(Landroidx/compose/runtime/Composer;I)V", "PreviewSearchBrowseNoSearchFirst", "PreviewSearchBrowseNoSuggestions", "PreviewSearchBrowseNoSuggestionsNoSearchFirst", "SearchBrowseCard", "helpCenterData", "Lio/intercom/android/sdk/m5/home/data/HomeCards$HomeHelpCenterData;", "isSearchFirstEnabled", "", "avatars", "", "Lio/intercom/android/sdk/models/Avatar;", "accessToTeammateEnabled", "(Lio/intercom/android/sdk/m5/home/data/HomeCards$HomeHelpCenterData;ZLjava/util/List;ZLandroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SearchBrowseCard.kt */
public final class SearchBrowseCardKt {
    public static final void SearchBrowseCard(HomeCards.HomeHelpCenterData homeHelpCenterData, boolean z, List<? extends Avatar> list, boolean z2, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(homeHelpCenterData, "helpCenterData");
        Intrinsics.checkNotNullParameter(list, "avatars");
        Composer startRestartGroup = composer.startRestartGroup(2025309633);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
        float r16 = Dp.m4704constructorimpl((float) 2);
        Modifier modifier = fillMaxWidth$default;
        CardKt.m1177CardFjzlyU(modifier, (Shape) null, 0, 0, BorderStrokeKt.m191BorderStrokecXLIe8U(Dp.m4704constructorimpl((float) 0.5d), Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), r16, ComposableLambdaKt.composableLambda(startRestartGroup, -1474175362, true, new SearchBrowseCardKt$SearchBrowseCard$1(z, homeHelpCenterData, z2, (Context) consume, list)), startRestartGroup, 1769478, 14);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SearchBrowseCardKt$SearchBrowseCard$2(homeHelpCenterData, z, list, z2, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void PreviewSearchBrowse(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1546858090);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$SearchBrowseCardKt.INSTANCE.m5163getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SearchBrowseCardKt$PreviewSearchBrowse$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void PreviewSearchBrowseNoSuggestions(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1745562356);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$SearchBrowseCardKt.INSTANCE.m5164getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SearchBrowseCardKt$PreviewSearchBrowseNoSuggestions$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void PreviewSearchBrowseNoSearchFirst(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-678171621);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$SearchBrowseCardKt.INSTANCE.m5165getLambda3$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SearchBrowseCardKt$PreviewSearchBrowseNoSearchFirst$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void PreviewSearchBrowseNoSuggestionsNoSearchFirst(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(354688977);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$SearchBrowseCardKt.INSTANCE.m5166getLambda4$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SearchBrowseCardKt$PreviewSearchBrowseNoSuggestionsNoSearchFirst$1(i));
        }
    }
}
