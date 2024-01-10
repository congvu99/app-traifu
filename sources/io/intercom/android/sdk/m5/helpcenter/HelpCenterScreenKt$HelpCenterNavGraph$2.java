package io.intercom.android.sdk.m5.helpcenter;

import androidx.compose.runtime.Composer;
import androidx.navigation.NavHostController;
import io.intercom.android.sdk.helpcenter.collections.HelpCenterViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterScreen.kt */
final class HelpCenterScreenKt$HelpCenterNavGraph$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ List<String> $collectionIds;
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ String $startDestination;
    final /* synthetic */ HelpCenterViewModel $viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterScreenKt$HelpCenterNavGraph$2(HelpCenterViewModel helpCenterViewModel, NavHostController navHostController, String str, List<String> list, int i) {
        super(2);
        this.$viewModel = helpCenterViewModel;
        this.$navController = navHostController;
        this.$startDestination = str;
        this.$collectionIds = list;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        HelpCenterScreenKt.HelpCenterNavGraph(this.$viewModel, this.$navController, this.$startDestination, this.$collectionIds, composer, this.$$changed | 1);
    }
}
