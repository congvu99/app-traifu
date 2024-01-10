package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.focus.FocusRequesterModifier;
import androidx.compose.ui.focus.FocusRequesterModifierLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/focus/FocusRequesterModifierLocal;", "mod", "Landroidx/compose/ui/focus/FocusRequesterModifier;", "invoke", "(Landroidx/compose/ui/focus/FocusRequesterModifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/focus/FocusRequesterModifierLocal;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ComposedModifier.kt */
final class ComposedModifierKt$WrapFocusRequesterModifier$1 extends Lambda implements Function3<FocusRequesterModifier, Composer, Integer, FocusRequesterModifierLocal> {
    public static final ComposedModifierKt$WrapFocusRequesterModifier$1 INSTANCE = new ComposedModifierKt$WrapFocusRequesterModifier$1();

    ComposedModifierKt$WrapFocusRequesterModifier$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((FocusRequesterModifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final FocusRequesterModifierLocal invoke(FocusRequesterModifier focusRequesterModifier, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(focusRequesterModifier, "mod");
        composer.startReplaceableGroup(945678692);
        ComposerKt.sourceInformation(composer, "C319@14150L77:ComposedModifier.kt#quzd79");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(945678692, i, -1, "androidx.compose.ui.WrapFocusRequesterModifier.<anonymous> (ComposedModifier.kt:318)");
        }
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) focusRequesterModifier);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new FocusRequesterModifierLocal(focusRequesterModifier.getFocusRequester());
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        FocusRequesterModifierLocal focusRequesterModifierLocal = (FocusRequesterModifierLocal) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return focusRequesterModifierLocal;
    }
}
