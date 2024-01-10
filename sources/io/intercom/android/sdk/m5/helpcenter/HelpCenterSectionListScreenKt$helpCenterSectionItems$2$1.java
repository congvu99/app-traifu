package io.intercom.android.sdk.m5.helpcenter;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import io.intercom.android.sdk.helpcenter.collections.ArticleSectionRow;
import io.intercom.android.sdk.m5.components.IntercomDividerKt;
import io.intercom.android.sdk.m5.helpcenter.components.ArticleRowComponentKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/LazyItemScope;", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterSectionListScreen.kt */
final class HelpCenterSectionListScreenKt$helpCenterSectionItems$2$1 extends Lambda implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ int $index;
    final /* synthetic */ ArticleSectionRow $item;
    final /* synthetic */ Function1<String, Unit> $onArticleClicked;
    final /* synthetic */ List<ArticleSectionRow> $sectionsUiModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterSectionListScreenKt$helpCenterSectionItems$2$1(int i, ArticleSectionRow articleSectionRow, Function1<? super String, Unit> function1, List<? extends ArticleSectionRow> list) {
        super(3);
        this.$index = i;
        this.$item = articleSectionRow;
        this.$onArticleClicked = function1;
        this.$sectionsUiModel = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((LazyItemScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope lazyItemScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$item");
        if ((i & 81) != 16 || !composer.getSkipping()) {
            composer.startReplaceableGroup(1496429615);
            if (this.$index == 0) {
                SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 16)), composer, 6);
            }
            composer.endReplaceableGroup();
            ArticleRowComponentKt.ArticleRowComponent((Modifier) null, (ArticleSectionRow.ArticleRow) this.$item, this.$onArticleClicked, composer, 0, 1);
            if (this.$index != this.$sectionsUiModel.size() - 1 && (this.$sectionsUiModel.get(this.$index + 1) instanceof ArticleSectionRow.ArticleRow)) {
                float f = (float) 16;
                IntercomDividerKt.IntercomDivider(PaddingKt.m514paddingqDBjuR0$default(Modifier.Companion, Dp.m4704constructorimpl(f), 0.0f, Dp.m4704constructorimpl(f), 0.0f, 10, (Object) null), composer, 6, 0);
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
