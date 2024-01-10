package io.intercom.android.sdk.m5.helpcenter;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.helpcenter.collections.HelpCenterViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterScreen.kt */
final class HelpCenterScreenKt$HelpCenterScreen$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ List<String> $collectionIds;
    final /* synthetic */ Function0<Unit> $onCloseClick;
    final /* synthetic */ HelpCenterViewModel $viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterScreenKt$HelpCenterScreen$2(HelpCenterViewModel helpCenterViewModel, List<String> list, Function0<Unit> function0, int i) {
        super(2);
        this.$viewModel = helpCenterViewModel;
        this.$collectionIds = list;
        this.$onCloseClick = function0;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        HelpCenterScreenKt.HelpCenterScreen(this.$viewModel, this.$collectionIds, this.$onCloseClick, composer, this.$$changed | 1);
    }
}
