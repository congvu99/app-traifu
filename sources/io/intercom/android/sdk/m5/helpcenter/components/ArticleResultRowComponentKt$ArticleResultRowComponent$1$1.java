package io.intercom.android.sdk.m5.helpcenter.components;

import io.intercom.android.sdk.helpcenter.search.ArticleSearchResultRow;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArticleResultRowComponent.kt */
final class ArticleResultRowComponentKt$ArticleResultRowComponent$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ArticleSearchResultRow.ArticleResultRow $item;
    final /* synthetic */ Function1<String, Unit> $onClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleResultRowComponentKt$ArticleResultRowComponent$1$1(Function1<? super String, Unit> function1, ArticleSearchResultRow.ArticleResultRow articleResultRow) {
        super(0);
        this.$onClick = function1;
        this.$item = articleResultRow;
    }

    public final void invoke() {
        this.$onClick.invoke(this.$item.getId());
    }
}
