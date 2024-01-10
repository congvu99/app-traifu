package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Snackbar.kt */
final class SnackbarKt$Snackbar$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $action;
    final /* synthetic */ boolean $actionOnNewLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnackbarKt$Snackbar$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i, boolean z) {
        super(2);
        this.$action = function2;
        this.$content = function22;
        this.$$dirty = i;
        this.$actionOnNewLine = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C97@4400L4,97@4335L448:Snackbar.kt#jmzs0o");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer, 6)))};
            final Function2<Composer, Integer, Unit> function2 = this.$action;
            final Function2<Composer, Integer, Unit> function22 = this.$content;
            final int i2 = this.$$dirty;
            final boolean z = this.$actionOnNewLine;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 1939362236, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C98@4450L10,99@4479L294:Snackbar.kt#jmzs0o");
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer, 6).getBody2();
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final Function2<Composer, Integer, Unit> function22 = function22;
                        final int i2 = i2;
                        final boolean z = z;
                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer, 225114541, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                ComposerKt.sourceInformation(composer, "C:Snackbar.kt#jmzs0o");
                                if ((i & 11) == 2 && composer.getSkipping()) {
                                    composer.skipToGroupEnd();
                                } else if (function2 == null) {
                                    composer.startReplaceableGroup(59708346);
                                    ComposerKt.sourceInformation(composer, "101@4578L25");
                                    SnackbarKt.TextOnlySnackbar(function22, composer, (i2 >> 21) & 14);
                                    composer.endReplaceableGroup();
                                } else if (z) {
                                    composer.startReplaceableGroup(59708411);
                                    ComposerKt.sourceInformation(composer, "102@4643L38");
                                    Function2<Composer, Integer, Unit> function2 = function22;
                                    Function2<Composer, Integer, Unit> function22 = function2;
                                    int i2 = i2;
                                    SnackbarKt.NewLineButtonSnackbar(function2, function22, composer, (i2 & 112) | ((i2 >> 21) & 14));
                                    composer.endReplaceableGroup();
                                } else {
                                    composer.startReplaceableGroup(59708478);
                                    ComposerKt.sourceInformation(composer, "103@4710L31");
                                    Function2<Composer, Integer, Unit> function23 = function22;
                                    Function2<Composer, Integer, Unit> function24 = function2;
                                    int i3 = i2;
                                    SnackbarKt.OneRowSnackbar(function23, function24, composer, (i3 & 112) | ((i3 >> 21) & 14));
                                    composer.endReplaceableGroup();
                                }
                            }
                        }), composer, 48);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 56);
            return;
        }
        composer.skipToGroupEnd();
    }
}
