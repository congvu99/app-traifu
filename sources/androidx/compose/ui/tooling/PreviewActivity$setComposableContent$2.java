package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreviewActivity.kt */
final class PreviewActivity$setComposableContent$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ String $className;
    final /* synthetic */ String $methodName;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreviewActivity$setComposableContent$2(String str, String str2) {
        super(2);
        this.$className = str;
        this.$methodName = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:PreviewActivity.kt#hevd2p");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            ComposableInvoker.INSTANCE.invokeComposable(this.$className, this.$methodName, composer, new Object[0]);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
