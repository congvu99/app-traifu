package io.intercom.android.sdk.m5.helpcenter.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.helpcenter.collections.ArticleSectionRow;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SectionTitleComponent.kt */
final class SectionTitleComponentKt$SectionTitleComponent$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ ArticleSectionRow.SectionRow $item;
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SectionTitleComponentKt$SectionTitleComponent$1(ArticleSectionRow.SectionRow sectionRow, Modifier modifier, int i, int i2) {
        super(2);
        this.$item = sectionRow;
        this.$modifier = modifier;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SectionTitleComponentKt.SectionTitleComponent(this.$item, this.$modifier, composer, this.$$changed | 1, this.$$default);
    }
}
