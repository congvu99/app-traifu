package io.intercom.android.sdk.m5.helpcenter;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.helpcenter.collections.HelpCenterViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterSectionListScreen.kt */
final class HelpCenterSectionListScreenKt$HelpCenterSectionListScreen$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ String $collectionId;
    final /* synthetic */ Function1<String, Unit> $onArticleClicked;
    final /* synthetic */ HelpCenterViewModel $viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterSectionListScreenKt$HelpCenterSectionListScreen$4(HelpCenterViewModel helpCenterViewModel, String str, Function1<? super String, Unit> function1, int i, int i2) {
        super(2);
        this.$viewModel = helpCenterViewModel;
        this.$collectionId = str;
        this.$onArticleClicked = function1;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        HelpCenterSectionListScreenKt.HelpCenterSectionListScreen(this.$viewModel, this.$collectionId, this.$onArticleClicked, composer, this.$$changed | 1, this.$$default);
    }
}
