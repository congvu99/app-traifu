package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/focus/FocusEventModifierLocal;", "mod", "Landroidx/compose/ui/focus/FocusEventModifier;", "invoke", "(Landroidx/compose/ui/focus/FocusEventModifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/focus/FocusEventModifierLocal;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ComposedModifier.kt */
final class ComposedModifierKt$WrapFocusEventModifier$1 extends Lambda implements Function3<FocusEventModifier, Composer, Integer, FocusEventModifierLocal> {
    public static final ComposedModifierKt$WrapFocusEventModifier$1 INSTANCE = new ComposedModifierKt$WrapFocusEventModifier$1();

    ComposedModifierKt$WrapFocusEventModifier$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((FocusEventModifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final FocusEventModifierLocal invoke(FocusEventModifier focusEventModifier, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(focusEventModifier, "mod");
        composer.startReplaceableGroup(-1790596922);
        ComposerKt.sourceInformation(composer, "C309@13890L72,312@13978L51,312@13967L62:ComposedModifier.kt#quzd79");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1790596922, i, -1, "androidx.compose.ui.WrapFocusEventModifier.<anonymous> (ComposedModifier.kt:308)");
        }
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) focusEventModifier);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new FocusEventModifierLocal(new ComposedModifierKt$WrapFocusEventModifier$1$modifier$1$1(focusEventModifier));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        FocusEventModifierLocal focusEventModifierLocal = (FocusEventModifierLocal) rememberedValue;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed2 = composer.changed((Object) focusEventModifierLocal);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new ComposedModifierKt$WrapFocusEventModifier$1$1$1(focusEventModifierLocal);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.SideEffect((Function0) rememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return focusEventModifierLocal;
    }
}
