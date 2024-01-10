package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
final class AnimatedContentKt$AnimatedContent$5$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function4<AnimatedVisibilityScope, S, Composer, Integer, Unit> $content;
    final /* synthetic */ SnapshotStateList<S> $currentlyVisible;
    final /* synthetic */ AnimatedContentScope<S> $rootScope;
    final /* synthetic */ S $stateForContent;
    final /* synthetic */ Transition<S> $this_AnimatedContent;
    final /* synthetic */ Function1<AnimatedContentScope<S>, ContentTransform> $transitionSpec;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimatedContentKt$AnimatedContent$5$1(Transition<S> transition, S s, int i, Function1<? super AnimatedContentScope<S>, ContentTransform> function1, AnimatedContentScope<S> animatedContentScope, Function4<? super AnimatedVisibilityScope, ? super S, ? super Composer, ? super Integer, Unit> function4, SnapshotStateList<S> snapshotStateList) {
        super(2);
        this.$this_AnimatedContent = transition;
        this.$stateForContent = s;
        this.$$dirty = i;
        this.$transitionSpec = function1;
        this.$rootScope = animatedContentScope;
        this.$content = function4;
        this.$currentlyVisible = snapshotStateList;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: androidx.compose.animation.ExitTransition} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            r7 = r17
            java.lang.String r1 = "C625@29653L38,629@29867L142,632@30042L111,637@30336L1164:AnimatedContent.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            r1 = r18 & 11
            r1 = r1 ^ 2
            if (r1 != 0) goto L_0x001b
            boolean r1 = r17.getSkipping()
            if (r1 != 0) goto L_0x0016
            goto L_0x001b
        L_0x0016:
            r17.skipToGroupEnd()
            goto L_0x0117
        L_0x001b:
            kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentScope<S>, androidx.compose.animation.ContentTransform> r1 = r0.$transitionSpec
            androidx.compose.animation.AnimatedContentScope<S> r2 = r0.$rootScope
            r3 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r7.startReplaceableGroup(r3)
            java.lang.String r4 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r4)
            java.lang.Object r5 = r17.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r5 != r6) goto L_0x0040
            java.lang.Object r1 = r1.invoke(r2)
            r5 = r1
            androidx.compose.animation.ContentTransform r5 = (androidx.compose.animation.ContentTransform) r5
            r7.updateRememberedValue(r5)
        L_0x0040:
            r17.endReplaceableGroup()
            androidx.compose.animation.ContentTransform r5 = (androidx.compose.animation.ContentTransform) r5
            androidx.compose.animation.core.Transition<S> r1 = r0.$this_AnimatedContent
            androidx.compose.animation.core.Transition$Segment r1 = r1.getSegment()
            java.lang.Object r1 = r1.getTargetState()
            S r2 = r0.$stateForContent
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentScope<S>, androidx.compose.animation.ContentTransform> r2 = r0.$transitionSpec
            androidx.compose.animation.AnimatedContentScope<S> r6 = r0.$rootScope
            r8 = -3686930(0xffffffffffc7bdee, float:NaN)
            r7.startReplaceableGroup(r8)
            java.lang.String r8 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r8)
            boolean r1 = r7.changed((java.lang.Object) r1)
            java.lang.Object r8 = r17.rememberedValue()
            if (r1 != 0) goto L_0x007a
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r8 != r1) goto L_0x0087
        L_0x007a:
            java.lang.Object r1 = r2.invoke(r6)
            androidx.compose.animation.ContentTransform r1 = (androidx.compose.animation.ContentTransform) r1
            androidx.compose.animation.ExitTransition r8 = r1.getInitialContentExit()
            r7.updateRememberedValue(r8)
        L_0x0087:
            r17.endReplaceableGroup()
            r6 = r8
            androidx.compose.animation.ExitTransition r6 = (androidx.compose.animation.ExitTransition) r6
            S r1 = r0.$stateForContent
            androidx.compose.animation.core.Transition<S> r2 = r0.$this_AnimatedContent
            r7.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r4)
            java.lang.Object r3 = r17.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x00b3
            androidx.compose.animation.AnimatedContentScope$ChildData r3 = new androidx.compose.animation.AnimatedContentScope$ChildData
            java.lang.Object r2 = r2.getTargetState()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            r3.<init>(r1)
            r7.updateRememberedValue(r3)
        L_0x00b3:
            r17.endReplaceableGroup()
            androidx.compose.animation.AnimatedContentScope$ChildData r3 = (androidx.compose.animation.AnimatedContentScope.ChildData) r3
            androidx.compose.animation.EnterTransition r4 = r5.getTargetContentEnter()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1$1 r2 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1$1
            r2.<init>(r5)
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.layout.LayoutModifierKt.layout(r1, r2)
            S r2 = r0.$stateForContent
            androidx.compose.animation.core.Transition<S> r5 = r0.$this_AnimatedContent
            java.lang.Object r5 = r5.getTargetState()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            r3.setTarget(r2)
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.ui.Modifier r3 = r1.then(r3)
            androidx.compose.animation.core.Transition<S> r1 = r0.$this_AnimatedContent
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1$3 r2 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1$3
            S r5 = r0.$stateForContent
            r2.<init>(r5)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r5 = -819913132(0xffffffffcf211e54, float:-2.70311936E9)
            r8 = 1
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1$4 r15 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1$4
            androidx.compose.animation.AnimatedContentScope<S> r10 = r0.$rootScope
            S r11 = r0.$stateForContent
            kotlin.jvm.functions.Function4<androidx.compose.animation.AnimatedVisibilityScope, S, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r12 = r0.$content
            int r13 = r0.$$dirty
            androidx.compose.runtime.snapshots.SnapshotStateList<S> r14 = r0.$currentlyVisible
            r9 = r15
            r9.<init>(r10, r11, r12, r13, r14)
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r7, r5, r8, r15)
            r8 = r5
            kotlin.jvm.functions.Function3 r8 = (kotlin.jvm.functions.Function3) r8
            r5 = 196608(0x30000, float:2.75506E-40)
            int r9 = r0.$$dirty
            r9 = r9 & 14
            r9 = r9 | r5
            r10 = 0
            r5 = r6
            r6 = r8
            r7 = r17
            r8 = r9
            r9 = r10
            androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(r1, r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.animation.EnterTransition) r4, (androidx.compose.animation.ExitTransition) r5, (kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r6, (androidx.compose.runtime.Composer) r7, (int) r8, (int) r9)
        L_0x0117:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
