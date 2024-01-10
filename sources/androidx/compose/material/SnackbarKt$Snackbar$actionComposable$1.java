package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Snackbar.kt */
final class SnackbarKt$Snackbar$actionComposable$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ long $actionColor;
    final /* synthetic */ String $actionLabel;
    final /* synthetic */ SnackbarData $snackbarData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnackbarKt$Snackbar$actionComposable$1(long j, int i, SnackbarData snackbarData, String str) {
        super(2);
        this.$actionColor = j;
        this.$$dirty = i;
        this.$snackbarData = snackbarData;
        this.$actionLabel = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C165@7570L44,164@7518L219:Snackbar.kt#jmzs0o");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            ButtonColors r8 = ButtonDefaults.INSTANCE.m1173textButtonColorsRGew2ao(0, this.$actionColor, 0, composer, ((this.$$dirty >> 15) & 112) | 3072, 5);
            final SnackbarData snackbarData = this.$snackbarData;
            final String str = this.$actionLabel;
            ButtonKt.TextButton(new Function0<Unit>() {
                public final void invoke() {
                    snackbarData.performAction();
                }
            }, (Modifier) null, false, (MutableInteractionSource) null, (ButtonElevation) null, (Shape) null, (BorderStroke) null, r8, (PaddingValues) null, ComposableLambdaKt.composableLambda(composer2, -929149933, true, new Function3<RowScope, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope rowScope, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
                    ComposerKt.sourceInformation(composer, "C167@7704L17:Snackbar.kt#jmzs0o");
                    if ((i & 81) != 16 || !composer.getSkipping()) {
                        TextKt.m1496TextfLXpl1I(str, (Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 65534);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 805306368, 382);
            return;
        }
        composer.skipToGroupEnd();
    }
}
