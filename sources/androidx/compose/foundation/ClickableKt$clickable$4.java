package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.Role;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Clickable.kt */
final class ClickableKt$clickable$4 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Indication $indication;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ String $onClickLabel;
    final /* synthetic */ Role $role;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableKt$clickable$4(Function0<Unit> function0, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, String str, Role role) {
        super(3);
        this.$onClick = function0;
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
        this.$indication = indication;
        this.$onClickLabel = str;
        this.$role = role;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Map map;
        MutableState mutableState;
        MutableInteractionSource mutableInteractionSource;
        Boolean bool;
        Modifier modifier2;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer2.startReplaceableGroup(92076020);
        ComposerKt.sourceInformation(composer2, "C136@5787L29,137@5850L58,138@5951L56,146@6266L36,147@6350L33,148@6441L95,148@6420L116,151@6564L40,153@6678L550,171@7281L445,186@7960L24:Clickable.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(92076020, i, -1, "androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:135)");
        }
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.$onClick, composer2, 0);
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState2 = (MutableState) rememberedValue;
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new LinkedHashMap();
            composer2.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        Map map2 = (Map) rememberedValue2;
        composer2.startReplaceableGroup(1841981561);
        ComposerKt.sourceInformation(composer2, "140@6043L170");
        if (this.$enabled) {
            ClickableKt.PressedInteractionSourceDisposableEffect(this.$interactionSource, mutableState2, map2, composer2, 560);
        }
        composer.endReplaceableGroup();
        Function0<Boolean> isComposeRootInScrollableContainer = Clickable_androidKt.isComposeRootInScrollableContainer(composer2, 0);
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer2.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        MutableState mutableState3 = (MutableState) rememberedValue3;
        composer2.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean changed = composer2.changed((Object) mutableState3) | composer2.changed((Object) isComposeRootInScrollableContainer);
        Object rememberedValue4 = composer.rememberedValue();
        if (changed || rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = new ClickableKt$clickable$4$delayPressInteraction$1$1(mutableState3, isComposeRootInScrollableContainer);
            composer2.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceableGroup();
        State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(rememberedValue4, composer2, 0);
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue5 = composer.rememberedValue();
        if (rememberedValue5 == Composer.Companion.getEmpty()) {
            rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m1672boximpl(Offset.Companion.m1699getZeroF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
            composer2.updateRememberedValue(rememberedValue5);
        }
        composer.endReplaceableGroup();
        MutableState mutableState4 = (MutableState) rememberedValue5;
        Modifier modifier3 = Modifier.Companion;
        MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
        Boolean valueOf = Boolean.valueOf(this.$enabled);
        MutableInteractionSource mutableInteractionSource3 = this.$interactionSource;
        Object[] objArr = {mutableState4, Boolean.valueOf(this.$enabled), mutableInteractionSource3, mutableState2, rememberUpdatedState2, rememberUpdatedState};
        boolean z = this.$enabled;
        composer2.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer2, "C(remember)P(1):Composables.kt#9igjgp");
        Boolean bool2 = valueOf;
        int i2 = 0;
        boolean z2 = false;
        for (int i3 = 6; i2 < i3; i3 = 6) {
            z2 |= composer2.changed(objArr[i2]);
            i2++;
        }
        Object rememberedValue6 = composer.rememberedValue();
        if (z2 || rememberedValue6 == Composer.Companion.getEmpty()) {
            Boolean bool3 = bool2;
            map = map2;
            mutableInteractionSource = mutableInteractionSource2;
            MutableState mutableState5 = mutableState4;
            mutableState = mutableState4;
            bool = bool3;
            boolean z3 = z;
            Modifier modifier4 = modifier3;
            MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
            modifier2 = modifier4;
            rememberedValue6 = new ClickableKt$clickable$4$gesture$1$1(mutableState5, z3, mutableInteractionSource4, mutableState2, rememberUpdatedState2, rememberUpdatedState, (Continuation<? super ClickableKt$clickable$4$gesture$1$1>) null);
            composer2.updateRememberedValue(rememberedValue6);
        } else {
            modifier2 = modifier3;
            mutableState = mutableState4;
            bool = bool2;
            map = map2;
            mutableInteractionSource = mutableInteractionSource2;
        }
        composer.endReplaceableGroup();
        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier2, mutableInteractionSource, bool, (Function2) rememberedValue6);
        Modifier.Companion companion = Modifier.Companion;
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue7 = composer.rememberedValue();
        if (rememberedValue7 == Composer.Companion.getEmpty()) {
            rememberedValue7 = new ClickableKt$clickable$4$1$1(mutableState3);
            composer2.updateRememberedValue(rememberedValue7);
        }
        composer.endReplaceableGroup();
        Modifier then = companion.then((Modifier) rememberedValue7);
        MutableInteractionSource mutableInteractionSource5 = this.$interactionSource;
        Indication indication = this.$indication;
        composer2.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer2, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue8 = composer.rememberedValue();
        if (rememberedValue8 == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2));
            composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue8 = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue8).getCoroutineScope();
        composer.endReplaceableGroup();
        Indication indication2 = indication;
        CoroutineScope coroutineScope2 = coroutineScope;
        Map map3 = map;
        Modifier r2 = ClickableKt.m201genericClickableWithoutGesturebdNGguI(then, pointerInput, mutableInteractionSource5, indication2, coroutineScope2, map3, mutableState, this.$enabled, this.$onClickLabel, this.$role, (String) null, (Function0<Unit>) null, this.$onClick);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r2;
    }
}
