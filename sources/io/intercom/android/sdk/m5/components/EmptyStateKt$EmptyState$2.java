package io.intercom.android.sdk.m5.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: EmptyState.kt */
final class EmptyStateKt$EmptyState$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function2<Composer, Integer, Unit> $bottomContent;
    final /* synthetic */ String $description;
    final /* synthetic */ Integer $iconId;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ String $title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EmptyStateKt$EmptyState$2(String str, Modifier modifier, String str2, Integer num, Function2<? super Composer, ? super Integer, Unit> function2, int i, int i2) {
        super(2);
        this.$title = str;
        this.$modifier = modifier;
        this.$description = str2;
        this.$iconId = num;
        this.$bottomContent = function2;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        EmptyStateKt.EmptyState(this.$title, this.$modifier, this.$description, this.$iconId, this.$bottomContent, composer, this.$$changed | 1, this.$$default);
    }
}
