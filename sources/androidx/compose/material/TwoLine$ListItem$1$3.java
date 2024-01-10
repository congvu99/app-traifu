package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class TwoLine$ListItem$1$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $secondaryText;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TwoLine$ListItem$1$3(Function2<? super Composer, ? super Integer, Unit> function2, int i, Function2<? super Composer, ? super Integer, Unit> function22) {
        super(2);
        this.$text = function2;
        this.$$dirty = i;
        this.$secondaryText = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C249@9459L6,250@9486L17:ListItem.kt#jmzs0o");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            this.$text.invoke(composer, Integer.valueOf((this.$$dirty >> 6) & 14));
            Function2<Composer, Integer, Unit> function2 = this.$secondaryText;
            Intrinsics.checkNotNull(function2);
            function2.invoke(composer, 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
