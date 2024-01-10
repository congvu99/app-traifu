package io.intercom.android.sdk.m5.helpcenter;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.helpcenter.collections.CollectionViewState;
import io.intercom.android.sdk.m5.helpcenter.components.CollectionSummaryComponentKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/LazyItemScope;", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterSectionListScreen.kt */
final class HelpCenterSectionListScreenKt$helpCenterSectionItems$1 extends Lambda implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ CollectionViewState.Content.CollectionContent $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterSectionListScreenKt$helpCenterSectionItems$1(CollectionViewState.Content.CollectionContent collectionContent) {
        super(3);
        this.$state = collectionContent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((LazyItemScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope lazyItemScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$item");
        if ((i & 81) != 16 || !composer.getSkipping()) {
            CollectionSummaryComponentKt.CollectionSummaryComponent(this.$state, (Modifier) null, composer, 8, 2);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
