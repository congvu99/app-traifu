package io.intercom.android.sdk.m5.helpcenter;

import android.content.Context;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavHostControllerKt;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import io.intercom.android.sdk.helpcenter.collections.HelpCenterViewModel;
import io.intercom.android.sdk.helpcenter.search.IntercomArticleSearchActivity;
import io.intercom.android.sdk.m5.helpcenter.components.HelpCenterTopBarKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterScreen.kt */
final class HelpCenterScreenKt$HelpCenterScreen$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ List<String> $collectionIds;
    final /* synthetic */ Function0<Unit> $onCloseClick;
    final /* synthetic */ HelpCenterViewModel $viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterScreenKt$HelpCenterScreen$1(Function0<Unit> function0, List<String> list, HelpCenterViewModel helpCenterViewModel) {
        super(2);
        this.$onCloseClick = function0;
        this.$collectionIds = list;
        this.$viewModel = helpCenterViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        if ((i & 11) != 2 || !composer.getSkipping()) {
            final NavHostController rememberNavController = NavHostControllerKt.rememberNavController(new Navigator[0], composer2, 8);
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(composer);
            final Context context = (Context) consume;
            final Function0<Unit> function0 = this.$onCloseClick;
            final NavHostController navHostController = rememberNavController;
            final List<String> list = this.$collectionIds;
            final HelpCenterViewModel helpCenterViewModel = this.$viewModel;
            ScaffoldKt.m1388Scaffold27mzLpw((Modifier) null, (ScaffoldState) null, ComposableLambdaKt.composableLambda(composer2, 1903891059, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        final NavHostController navHostController = rememberNavController;
                        final Function0<Unit> function0 = function0;
                        final Context context = context;
                        HelpCenterTopBarKt.HelpCenterTopBar(new Function0<Unit>() {
                            public final void invoke() {
                                if (navHostController.getPreviousBackStackEntry() == null) {
                                    function0.invoke();
                                } else {
                                    navHostController.navigateUp();
                                }
                            }
                        }, new Function0<Unit>() {
                            public final void invoke() {
                                context.startActivity(IntercomArticleSearchActivity.Companion.buildIntent(context, false));
                            }
                        }, composer, 0);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), (Function2<? super Composer, ? super Integer, Unit>) null, (Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, 0, false, (Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit>) null, false, (Shape) null, 0.0f, 0, 0, 0, 0, 0, ComposableLambdaKt.composableLambda(composer2, 1678591340, true, new Function3<PaddingValues, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((PaddingValues) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues paddingValues, Composer composer, int i) {
                    String str;
                    Intrinsics.checkNotNullParameter(paddingValues, "it");
                    if ((i & 14) == 0) {
                        i |= composer.changed((Object) paddingValues) ? 4 : 2;
                    }
                    if ((i & 91) != 18 || !composer.getSkipping()) {
                        paddingValues.m520calculateBottomPaddingD9Ej5fM();
                        if (list.size() == 1) {
                            str = HelpCenterDestination.COLLECTION.name();
                        } else {
                            str = HelpCenterDestination.COLLECTIONS.name();
                        }
                        HelpCenterScreenKt.HelpCenterNavGraph(helpCenterViewModel, navHostController, str, list, composer, 4168);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 12582912, 131067);
            return;
        }
        composer.skipToGroupEnd();
    }
}
