package io.intercom.android.sdk.m5.helpcenter;

import android.content.Context;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavHostKt;
import io.intercom.android.sdk.helpcenter.collections.HelpCenterViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0001¢\u0006\u0002\u0010\n\u001a1\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"HelpCenterNavGraph", "", "viewModel", "Lio/intercom/android/sdk/helpcenter/collections/HelpCenterViewModel;", "navController", "Landroidx/navigation/NavHostController;", "startDestination", "", "collectionIds", "", "(Lio/intercom/android/sdk/helpcenter/collections/HelpCenterViewModel;Landroidx/navigation/NavHostController;Ljava/lang/String;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "HelpCenterScreen", "onCloseClick", "Lkotlin/Function0;", "(Lio/intercom/android/sdk/helpcenter/collections/HelpCenterViewModel;Ljava/util/List;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterScreen.kt */
public final class HelpCenterScreenKt {
    public static final void HelpCenterScreen(HelpCenterViewModel helpCenterViewModel, List<String> list, Function0<Unit> function0, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(helpCenterViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(list, "collectionIds");
        Intrinsics.checkNotNullParameter(function0, "onCloseClick");
        Composer startRestartGroup = composer.startRestartGroup(-1001087506);
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{localContext.provides(helpCenterViewModel.localizedContext((Context) consume))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 1521156782, true, new HelpCenterScreenKt$HelpCenterScreen$1(function0, list, helpCenterViewModel)), startRestartGroup, 56);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new HelpCenterScreenKt$HelpCenterScreen$2(helpCenterViewModel, list, function0, i));
        }
    }

    public static final void HelpCenterNavGraph(HelpCenterViewModel helpCenterViewModel, NavHostController navHostController, String str, List<String> list, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(helpCenterViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navHostController, "navController");
        Intrinsics.checkNotNullParameter(str, "startDestination");
        Intrinsics.checkNotNullParameter(list, "collectionIds");
        Composer startRestartGroup = composer.startRestartGroup(-597762581);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        NavHostKt.NavHost(navHostController, str, WindowInsetsPadding_androidKt.navigationBarsPadding(Modifier.Companion), (String) null, new HelpCenterScreenKt$HelpCenterNavGraph$1(helpCenterViewModel, list, navHostController, (Context) consume), startRestartGroup, ((i >> 3) & 112) | 8, 8);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new HelpCenterScreenKt$HelpCenterNavGraph$2(helpCenterViewModel, navHostController, str, list, i));
        }
    }
}
