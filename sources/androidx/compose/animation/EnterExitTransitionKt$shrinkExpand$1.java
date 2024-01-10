package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
final class EnterExitTransitionKt$shrinkExpand$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ State<ChangeSize> $expand;
    final /* synthetic */ String $labelPrefix;
    final /* synthetic */ State<ChangeSize> $shrink;
    final /* synthetic */ Transition<EnterExitState> $transition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EnterExitTransitionKt$shrinkExpand$1(Transition<EnterExitState> transition, State<ChangeSize> state, State<ChangeSize> state2, String str) {
        super(3);
        this.$transition = transition;
        this.$expand = state;
        this.$shrink = state2;
        this.$labelPrefix = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* renamed from: invoke$lambda-1  reason: not valid java name */
    private static final boolean m65invoke$lambda1(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* renamed from: invoke$lambda-2  reason: not valid java name */
    private static final void m66invoke$lambda2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: androidx.compose.animation.ExpandShrinkModifier} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: androidx.compose.animation.ExpandShrinkModifier} */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x017c, code lost:
        if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01e7, code lost:
        if ((r2 != null && !r2.getClip()) != false) goto L_0x01e9;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r22, androidx.compose.runtime.Composer r23, int r24) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r8 = r23
            java.lang.String r2 = "$this$composed"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = -1553215817(0xffffffffa36bceb7, float:-1.2783149E-17)
            r8.startReplaceableGroup(r2)
            java.lang.String r2 = "C1011@43374L46,1021@43728L396,1034@44238L41,1032@44164L125,1043@44599L218:EnterExitTransition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r2 = r0.$transition
            r9 = -3686930(0xffffffffffc7bdee, float:NaN)
            r8.startReplaceableGroup(r9)
            java.lang.String r10 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r10)
            boolean r2 = r8.changed((java.lang.Object) r2)
            java.lang.Object r3 = r23.rememberedValue()
            r11 = 0
            r12 = 0
            if (r2 != 0) goto L_0x0037
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x0043
        L_0x0037:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r12)
            r3 = 2
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r11, r3, r11)
            r8.updateRememberedValue(r3)
        L_0x0043:
            r23.endReplaceableGroup()
            androidx.compose.runtime.MutableState r3 = (androidx.compose.runtime.MutableState) r3
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r2 = r0.$transition
            java.lang.Object r2 = r2.getCurrentState()
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r4 = r0.$transition
            java.lang.Object r4 = r4.getTargetState()
            r13 = 1
            if (r2 != r4) goto L_0x0063
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r2 = r0.$transition
            boolean r2 = r2.isSeeking()
            if (r2 != 0) goto L_0x0063
            m66invoke$lambda2(r3, r12)
            goto L_0x0076
        L_0x0063:
            androidx.compose.runtime.State<androidx.compose.animation.ChangeSize> r2 = r0.$expand
            java.lang.Object r2 = r2.getValue()
            if (r2 != 0) goto L_0x0073
            androidx.compose.runtime.State<androidx.compose.animation.ChangeSize> r2 = r0.$shrink
            java.lang.Object r2 = r2.getValue()
            if (r2 == 0) goto L_0x0076
        L_0x0073:
            m66invoke$lambda2(r3, r13)
        L_0x0076:
            boolean r2 = m65invoke$lambda1(r3)
            if (r2 == 0) goto L_0x01ff
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r2 = r0.$transition
            androidx.compose.animation.core.Transition$Segment r2 = r2.getSegment()
            androidx.compose.animation.EnterExitState r3 = androidx.compose.animation.EnterExitState.PreEnter
            androidx.compose.animation.EnterExitState r4 = androidx.compose.animation.EnterExitState.Visible
            boolean r2 = r2.isTransitioningTo(r3, r4)
            androidx.compose.runtime.State<androidx.compose.animation.ChangeSize> r3 = r0.$expand
            androidx.compose.runtime.State<androidx.compose.animation.ChangeSize> r4 = r0.$shrink
            if (r2 == 0) goto L_0x00ae
            java.lang.Object r2 = r3.getValue()
            androidx.compose.animation.ChangeSize r2 = (androidx.compose.animation.ChangeSize) r2
            if (r2 != 0) goto L_0x009a
            r2 = r11
            goto L_0x009e
        L_0x009a:
            androidx.compose.ui.Alignment r2 = r2.getAlignment()
        L_0x009e:
            if (r2 != 0) goto L_0x00cc
            java.lang.Object r2 = r4.getValue()
            androidx.compose.animation.ChangeSize r2 = (androidx.compose.animation.ChangeSize) r2
            if (r2 != 0) goto L_0x00a9
            goto L_0x00c6
        L_0x00a9:
            androidx.compose.ui.Alignment r2 = r2.getAlignment()
            goto L_0x00cc
        L_0x00ae:
            java.lang.Object r2 = r4.getValue()
            androidx.compose.animation.ChangeSize r2 = (androidx.compose.animation.ChangeSize) r2
            if (r2 != 0) goto L_0x00b8
            r2 = r11
            goto L_0x00bc
        L_0x00b8:
            androidx.compose.ui.Alignment r2 = r2.getAlignment()
        L_0x00bc:
            if (r2 != 0) goto L_0x00cc
            java.lang.Object r2 = r3.getValue()
            androidx.compose.animation.ChangeSize r2 = (androidx.compose.animation.ChangeSize) r2
            if (r2 != 0) goto L_0x00c8
        L_0x00c6:
            r2 = r11
            goto L_0x00cc
        L_0x00c8:
            androidx.compose.ui.Alignment r2 = r2.getAlignment()
        L_0x00cc:
            androidx.compose.runtime.State r20 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r2, r8, r12)
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r2 = r0.$transition
            androidx.compose.ui.unit.IntSize$Companion r3 = androidx.compose.ui.unit.IntSize.Companion
            androidx.compose.animation.core.TwoWayConverter r3 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((androidx.compose.ui.unit.IntSize.Companion) r3)
            java.lang.String r4 = r0.$labelPrefix
            r14 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r8.startReplaceableGroup(r14)
            java.lang.String r15 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r15)
            java.lang.Object r5 = r23.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r5 != r6) goto L_0x00fa
            java.lang.String r5 = " shrink/expand"
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r5)
            r8.updateRememberedValue(r5)
        L_0x00fa:
            r23.endReplaceableGroup()
            r4 = r5
            java.lang.String r4 = (java.lang.String) r4
            r6 = 448(0x1c0, float:6.28E-43)
            r7 = 0
            r5 = r23
            androidx.compose.animation.core.Transition$DeferredAnimation r16 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(r2, r3, r4, r5, r6, r7)
            r2 = -1553214637(0xffffffffa36bd353, float:-1.2784125E-17)
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r3 = r0.$transition
            java.lang.Object r3 = r3.getCurrentState()
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r4 = r0.$transition
            java.lang.Object r4 = r4.getTargetState()
            if (r3 != r4) goto L_0x011c
            r3 = 1
            goto L_0x011d
        L_0x011c:
            r3 = 0
        L_0x011d:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r8.startMovableGroup(r2, r3)
            java.lang.String r2 = "1039@44484L54,1037@44400L152"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r2 = r0.$transition
            androidx.compose.ui.unit.IntOffset$Companion r3 = androidx.compose.ui.unit.IntOffset.Companion
            androidx.compose.animation.core.TwoWayConverter r3 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((androidx.compose.ui.unit.IntOffset.Companion) r3)
            java.lang.String r4 = r0.$labelPrefix
            r8.startReplaceableGroup(r14)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r15)
            java.lang.Object r5 = r23.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r5 != r6) goto L_0x014e
            java.lang.String r5 = " InterruptionHandlingOffset"
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r5)
            r8.updateRememberedValue(r5)
        L_0x014e:
            r23.endReplaceableGroup()
            r4 = r5
            java.lang.String r4 = (java.lang.String) r4
            r6 = 448(0x1c0, float:6.28E-43)
            r7 = 0
            r5 = r23
            androidx.compose.animation.core.Transition$DeferredAnimation r2 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(r2, r3, r4, r5, r6, r7)
            r23.endMovableGroup()
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r3 = r0.$transition
            androidx.compose.runtime.State<androidx.compose.animation.ChangeSize> r4 = r0.$expand
            androidx.compose.runtime.State<androidx.compose.animation.ChangeSize> r5 = r0.$shrink
            r8.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r10)
            boolean r3 = r8.changed((java.lang.Object) r3)
            java.lang.Object r6 = r23.rememberedValue()
            if (r3 != 0) goto L_0x017e
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r6 != r3) goto L_0x0191
        L_0x017e:
            androidx.compose.animation.ExpandShrinkModifier r6 = new androidx.compose.animation.ExpandShrinkModifier
            r14 = r6
            r15 = r16
            r16 = r2
            r17 = r4
            r18 = r5
            r19 = r20
            r14.<init>(r15, r16, r17, r18, r19)
            r8.updateRememberedValue(r6)
        L_0x0191:
            r23.endReplaceableGroup()
            androidx.compose.animation.ExpandShrinkModifier r6 = (androidx.compose.animation.ExpandShrinkModifier) r6
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r2 = r0.$transition
            java.lang.Object r2 = r2.getCurrentState()
            androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r3 = r0.$transition
            java.lang.Object r3 = r3.getTargetState()
            if (r2 != r3) goto L_0x01a8
            r6.setCurrentAlignment(r11)
            goto L_0x01bf
        L_0x01a8:
            androidx.compose.ui.Alignment r2 = r6.getCurrentAlignment()
            if (r2 != 0) goto L_0x01bf
            java.lang.Object r2 = r20.getValue()
            androidx.compose.ui.Alignment r2 = (androidx.compose.ui.Alignment) r2
            if (r2 != 0) goto L_0x01bc
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getTopStart()
        L_0x01bc:
            r6.setCurrentAlignment(r2)
        L_0x01bf:
            androidx.compose.runtime.State<androidx.compose.animation.ChangeSize> r2 = r0.$expand
            java.lang.Object r2 = r2.getValue()
            androidx.compose.animation.ChangeSize r2 = (androidx.compose.animation.ChangeSize) r2
            if (r2 != 0) goto L_0x01cb
        L_0x01c9:
            r2 = 0
            goto L_0x01d2
        L_0x01cb:
            boolean r2 = r2.getClip()
            if (r2 != 0) goto L_0x01c9
            r2 = 1
        L_0x01d2:
            if (r2 != 0) goto L_0x01e9
            androidx.compose.runtime.State<androidx.compose.animation.ChangeSize> r2 = r0.$shrink
            java.lang.Object r2 = r2.getValue()
            androidx.compose.animation.ChangeSize r2 = (androidx.compose.animation.ChangeSize) r2
            if (r2 != 0) goto L_0x01e0
        L_0x01de:
            r2 = 0
            goto L_0x01e7
        L_0x01e0:
            boolean r2 = r2.getClip()
            if (r2 != 0) goto L_0x01de
            r2 = 1
        L_0x01e7:
            if (r2 == 0) goto L_0x01ea
        L_0x01e9:
            r12 = 1
        L_0x01ea:
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            if (r12 == 0) goto L_0x01f1
            goto L_0x01f5
        L_0x01f1:
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.draw.ClipKt.clipToBounds(r2)
        L_0x01f5:
            androidx.compose.ui.Modifier r1 = r1.then(r2)
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            androidx.compose.ui.Modifier r1 = r1.then(r6)
        L_0x01ff:
            r23.endReplaceableGroup()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
