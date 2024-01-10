package io.intercom.android.sdk.m5.helpcenter;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.helpcenter.collections.HelpCenterViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterCollectionListScreen.kt */
final class HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ List<String> $collectionIds;
    final /* synthetic */ Function1<String, Unit> $onAutoNavigateToCollection;
    final /* synthetic */ Function1<String, Unit> $onCollectionClick;
    final /* synthetic */ HelpCenterViewModel $viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$4(HelpCenterViewModel helpCenterViewModel, List<String> list, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, int i) {
        super(2);
        this.$viewModel = helpCenterViewModel;
        this.$collectionIds = list;
        this.$onCollectionClick = function1;
        this.$onAutoNavigateToCollection = function12;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        HelpCenterCollectionListScreenKt.HelpCenterCollectionListScreen(this.$viewModel, this.$collectionIds, this.$onCollectionClick, this.$onAutoNavigateToCollection, composer, this.$$changed | 1);
    }
}
