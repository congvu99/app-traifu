package io.intercom.android.sdk.m5.helpcenter.components;

import io.intercom.android.sdk.helpcenter.collections.ArticleSectionRow;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArticleRowComponent.kt */
final class ArticleRowComponentKt$ArticleRowComponent$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ArticleSectionRow.ArticleRow $articleRow;
    final /* synthetic */ Function1<String, Unit> $onClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleRowComponentKt$ArticleRowComponent$2$1(Function1<? super String, Unit> function1, ArticleSectionRow.ArticleRow articleRow) {
        super(0);
        this.$onClick = function1;
        this.$articleRow = articleRow;
    }

    public final void invoke() {
        this.$onClick.invoke(this.$articleRow.getId());
    }
}
