package io.intercom.android.sdk.m5.helpcenter.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.helpcenter.collections.ArticleSectionRow;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArticleRowComponent.kt */
final class ArticleRowComponentKt$ArticleRowComponent$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ ArticleSectionRow.ArticleRow $articleRow;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<String, Unit> $onClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleRowComponentKt$ArticleRowComponent$4(Modifier modifier, ArticleSectionRow.ArticleRow articleRow, Function1<? super String, Unit> function1, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$articleRow = articleRow;
        this.$onClick = function1;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ArticleRowComponentKt.ArticleRowComponent(this.$modifier, this.$articleRow, this.$onClick, composer, this.$$changed | 1, this.$$default);
    }
}
