package androidx.compose.animation;

import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n2&\u0010\t\u001a\"\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Crossfade", "", "T", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/animation/core/Transition;", "contentKey", "Lkotlin/ParameterName;", "name", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Crossfade.kt */
public final class CrossfadeKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void Crossfade(T r15, androidx.compose.ui.Modifier r16, androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float> r17, kotlin.jvm.functions.Function3<? super T, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r18, androidx.compose.runtime.Composer r19, int r20, int r21) {
        /*
            r1 = r15
            r10 = r18
            r11 = r20
            r12 = r21
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -1621451783(0xffffffff9f5a9bf9, float:-4.6292313E-20)
            r2 = r19
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(Crossfade)P(3,2)53@2155L29,54@2200L53:Crossfade.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r12 & 1
            r3 = 4
            r4 = 2
            if (r2 == 0) goto L_0x0023
            r2 = r11 | 6
            goto L_0x0033
        L_0x0023:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0032
            boolean r2 = r0.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x002f
            r2 = 4
            goto L_0x0030
        L_0x002f:
            r2 = 2
        L_0x0030:
            r2 = r2 | r11
            goto L_0x0033
        L_0x0032:
            r2 = r11
        L_0x0033:
            r5 = r12 & 2
            if (r5 == 0) goto L_0x003a
            r2 = r2 | 48
            goto L_0x004d
        L_0x003a:
            r6 = r11 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x004d
            r6 = r16
            boolean r7 = r0.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0049
            r7 = 32
            goto L_0x004b
        L_0x0049:
            r7 = 16
        L_0x004b:
            r2 = r2 | r7
            goto L_0x004f
        L_0x004d:
            r6 = r16
        L_0x004f:
            r7 = r12 & 4
            if (r7 == 0) goto L_0x0055
            r2 = r2 | 128(0x80, float:1.794E-43)
        L_0x0055:
            r8 = r12 & 8
            if (r8 == 0) goto L_0x005c
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x006c
        L_0x005c:
            r8 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x006c
            boolean r8 = r0.changed((java.lang.Object) r10)
            if (r8 == 0) goto L_0x0069
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x006b
        L_0x0069:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x006b:
            r2 = r2 | r8
        L_0x006c:
            int r8 = ~r12
            r3 = r3 & r8
            if (r3 != 0) goto L_0x0084
            r3 = r2 & 5851(0x16db, float:8.199E-42)
            r3 = r3 ^ 1170(0x492, float:1.64E-42)
            if (r3 != 0) goto L_0x0084
            boolean r3 = r0.getSkipping()
            if (r3 != 0) goto L_0x007d
            goto L_0x0084
        L_0x007d:
            r0.skipToGroupEnd()
            r3 = r17
            r2 = r6
            goto L_0x00be
        L_0x0084:
            if (r5 == 0) goto L_0x008c
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r13 = r3
            goto L_0x008d
        L_0x008c:
            r13 = r6
        L_0x008d:
            r3 = 0
            if (r7 == 0) goto L_0x009a
            r5 = 7
            r6 = 0
            androidx.compose.animation.core.TweenSpec r5 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r6, r6, r3, r5, r3)
            androidx.compose.animation.core.FiniteAnimationSpec r5 = (androidx.compose.animation.core.FiniteAnimationSpec) r5
            r14 = r5
            goto L_0x009c
        L_0x009a:
            r14 = r17
        L_0x009c:
            r5 = r2 & 8
            r6 = r2 & 14
            r5 = r5 | r6
            androidx.compose.animation.core.Transition r3 = androidx.compose.animation.core.TransitionKt.updateTransition(r15, (java.lang.String) r3, (androidx.compose.runtime.Composer) r0, (int) r5, (int) r4)
            r5 = 0
            r4 = r2 & 112(0x70, float:1.57E-43)
            r4 = r4 | 512(0x200, float:7.175E-43)
            r6 = 57344(0xe000, float:8.0356E-41)
            int r2 = r2 << 3
            r2 = r2 & r6
            r8 = r4 | r2
            r9 = 4
            r2 = r3
            r3 = r13
            r4 = r14
            r6 = r18
            r7 = r0
            Crossfade(r2, r3, r4, r5, r6, r7, r8, r9)
            r2 = r13
            r3 = r14
        L_0x00be:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto L_0x00c5
            goto L_0x00d7
        L_0x00c5:
            androidx.compose.animation.CrossfadeKt$Crossfade$1 r8 = new androidx.compose.animation.CrossfadeKt$Crossfade$1
            r0 = r8
            r1 = r15
            r4 = r18
            r5 = r20
            r6 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x00d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.CrossfadeKt.Crossfade(java.lang.Object, androidx.compose.ui.Modifier, androidx.compose.animation.core.FiniteAnimationSpec, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x028d  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x029d  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02fa  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0388  */
    /* JADX WARNING: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ac  */
    @androidx.compose.animation.ExperimentalAnimationApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void Crossfade(androidx.compose.animation.core.Transition<T> r24, androidx.compose.ui.Modifier r25, androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float> r26, kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Object> r27, kotlin.jvm.functions.Function3<? super T, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r6 = r24
            r7 = r28
            r8 = r30
            r9 = r31
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = -1621450215(0xffffffff9f5aa219, float:-4.629738E-20)
            r1 = r29
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(Crossfade)P(3!1,2)85@3787L64,86@3873L66,120@5162L159:Crossfade.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r9
            r11 = 2
            if (r0 == 0) goto L_0x0029
            r0 = r8 | 6
            goto L_0x0039
        L_0x0029:
            r0 = r8 & 14
            if (r0 != 0) goto L_0x0038
            boolean r0 = r10.changed((java.lang.Object) r6)
            if (r0 == 0) goto L_0x0035
            r0 = 4
            goto L_0x0036
        L_0x0035:
            r0 = 2
        L_0x0036:
            r0 = r0 | r8
            goto L_0x0039
        L_0x0038:
            r0 = r8
        L_0x0039:
            r1 = r9 & 1
            if (r1 == 0) goto L_0x0040
            r0 = r0 | 48
            goto L_0x0053
        L_0x0040:
            r2 = r8 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0053
            r2 = r25
            boolean r3 = r10.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x004f
            r3 = 32
            goto L_0x0051
        L_0x004f:
            r3 = 16
        L_0x0051:
            r0 = r0 | r3
            goto L_0x0055
        L_0x0053:
            r2 = r25
        L_0x0055:
            r3 = r9 & 2
            if (r3 == 0) goto L_0x005b
            r0 = r0 | 128(0x80, float:1.794E-43)
        L_0x005b:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x0062
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0075
        L_0x0062:
            r5 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0075
            r5 = r27
            boolean r13 = r10.changed((java.lang.Object) r5)
            if (r13 == 0) goto L_0x0071
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x0073
        L_0x0071:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x0073:
            r0 = r0 | r13
            goto L_0x0077
        L_0x0075:
            r5 = r27
        L_0x0077:
            r13 = r9 & 8
            if (r13 == 0) goto L_0x007e
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0090
        L_0x007e:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r8
            if (r13 != 0) goto L_0x0090
            boolean r13 = r10.changed((java.lang.Object) r7)
            if (r13 == 0) goto L_0x008d
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x008f
        L_0x008d:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x008f:
            r0 = r0 | r13
        L_0x0090:
            r13 = r0
            int r0 = ~r9
            r0 = r0 & r11
            if (r0 != 0) goto L_0x00ac
            r0 = 46811(0xb6db, float:6.5596E-41)
            r0 = r0 & r13
            r0 = r0 ^ 9362(0x2492, float:1.3119E-41)
            if (r0 != 0) goto L_0x00ac
            boolean r0 = r10.getSkipping()
            if (r0 != 0) goto L_0x00a4
            goto L_0x00ac
        L_0x00a4:
            r10.skipToGroupEnd()
            r3 = r26
            r4 = r5
            goto L_0x0381
        L_0x00ac:
            if (r1 == 0) goto L_0x00b4
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r14 = r0
            goto L_0x00b5
        L_0x00b4:
            r14 = r2
        L_0x00b5:
            r15 = 0
            if (r3 == 0) goto L_0x00c3
            r0 = 7
            r1 = 0
            androidx.compose.animation.core.TweenSpec r0 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r15, r15, r1, r0, r1)
            androidx.compose.animation.core.FiniteAnimationSpec r0 = (androidx.compose.animation.core.FiniteAnimationSpec) r0
            r16 = r0
            goto L_0x00c5
        L_0x00c3:
            r16 = r26
        L_0x00c5:
            if (r4 == 0) goto L_0x00cc
            androidx.compose.animation.CrossfadeKt$Crossfade$2 r0 = androidx.compose.animation.CrossfadeKt$Crossfade$2.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r5 = r0
        L_0x00cc:
            r0 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r10.startReplaceableGroup(r0)
            java.lang.String r1 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            java.lang.Object r2 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x00f3
            androidx.compose.runtime.snapshots.SnapshotStateList r2 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf()
            java.lang.Object r3 = r24.getCurrentState()
            r2.add(r3)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r10.updateRememberedValue(r2)
        L_0x00f3:
            r10.endReplaceableGroup()
            r4 = r2
            androidx.compose.runtime.snapshots.SnapshotStateList r4 = (androidx.compose.runtime.snapshots.SnapshotStateList) r4
            r10.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            java.lang.Object r0 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x0115
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Map r0 = (java.util.Map) r0
            r10.updateRememberedValue(r0)
        L_0x0115:
            r10.endReplaceableGroup()
            r3 = r0
            java.util.Map r3 = (java.util.Map) r3
            r0 = -1621449801(0xffffffff9f5aa3b7, float:-4.6298717E-20)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "93@4253L21"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            java.lang.Object r0 = r24.getCurrentState()
            java.lang.Object r1 = r24.getTargetState()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            r2 = 1
            if (r0 == 0) goto L_0x017f
            int r0 = r4.size()
            if (r0 != r2) goto L_0x0149
            java.lang.Object r0 = r4.get(r15)
            java.lang.Object r1 = r24.getTargetState()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 != 0) goto L_0x017f
        L_0x0149:
            r0 = r4
            java.util.List r0 = (java.util.List) r0
            r1 = -3686930(0xffffffffffc7bdee, float:NaN)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            boolean r1 = r10.changed((java.lang.Object) r6)
            java.lang.Object r2 = r10.rememberedValue()
            if (r1 != 0) goto L_0x0169
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x0174
        L_0x0169:
            androidx.compose.animation.CrossfadeKt$Crossfade$3$1 r1 = new androidx.compose.animation.CrossfadeKt$Crossfade$3$1
            r1.<init>(r6)
            r2 = r1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r10.updateRememberedValue(r2)
        L_0x0174:
            r10.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.collections.CollectionsKt.removeAll(r0, r2)
            r3.clear()
        L_0x017f:
            r10.endReplaceableGroup()
            java.lang.Object r0 = r24.getTargetState()
            boolean r0 = r3.containsKey(r0)
            r2 = -1
            if (r0 != 0) goto L_0x0217
            r1 = r4
            java.util.List r1 = (java.util.List) r1
            java.util.Iterator r0 = r1.iterator()
            r17 = 0
        L_0x0196:
            boolean r18 = r0.hasNext()
            if (r18 == 0) goto L_0x01b9
            java.lang.Object r12 = r0.next()
            java.lang.Object r12 = r5.invoke(r12)
            java.lang.Object r11 = r24.getTargetState()
            java.lang.Object r11 = r5.invoke(r11)
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r11)
            if (r11 == 0) goto L_0x01b5
            r0 = r17
            goto L_0x01ba
        L_0x01b5:
            int r17 = r17 + 1
            r11 = 2
            goto L_0x0196
        L_0x01b9:
            r0 = -1
        L_0x01ba:
            if (r0 != r2) goto L_0x01c4
            java.lang.Object r0 = r24.getTargetState()
            r4.add(r0)
            goto L_0x01cb
        L_0x01c4:
            java.lang.Object r11 = r24.getTargetState()
            r4.set(r0, r11)
        L_0x01cb:
            r3.clear()
            int r0 = r1.size()
            int r11 = r0 + -1
            if (r11 < 0) goto L_0x0217
            r0 = 0
        L_0x01d7:
            int r12 = r0 + 1
            java.lang.Object r0 = r1.get(r0)
            androidx.compose.animation.CrossfadeKt$Crossfade$4$1 r15 = new androidx.compose.animation.CrossfadeKt$Crossfade$4$1
            r27 = r0
            r0 = r15
            r19 = r1
            r1 = r24
            r6 = 1
            r20 = -1
            r2 = r13
            r21 = r3
            r3 = r16
            r22 = r4
            r4 = r27
            r23 = r5
            r5 = r28
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = -985537632(0xffffffffc541e3a0, float:-3102.2266)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r0, r6, r15)
            r2 = r27
            r1 = r21
            r1.put(r2, r0)
            if (r12 <= r11) goto L_0x020a
            goto L_0x021e
        L_0x020a:
            r2 = -1
            r15 = 0
            r6 = r24
            r3 = r1
            r0 = r12
            r1 = r19
            r4 = r22
            r5 = r23
            goto L_0x01d7
        L_0x0217:
            r1 = r3
            r22 = r4
            r23 = r5
            r20 = -1
        L_0x021e:
            int r0 = r13 >> 3
            r0 = r0 & 14
            r2 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getTopStart()
            int r3 = r0 >> 3
            r4 = r3 & 14
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            r4 = 0
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r2, r4, r10, r3)
            int r3 = r0 << 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r4 = 1376089335(0x520574f7, float:1.43298249E11)
            r10.startReplaceableGroup(r4)
            java.lang.String r4 = "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r4)
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r5 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r6 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r6)
            java.lang.Object r4 = r10.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r6)
            java.lang.Object r5 = r10.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r11 = androidx.compose.ui.layout.LayoutKt.materializerOf(r14)
            int r3 = r3 << 9
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            androidx.compose.runtime.Applier r12 = r10.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x0290
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0290:
            r10.startReusableNode()
            boolean r12 = r10.getInserting()
            if (r12 == 0) goto L_0x029d
            r10.createNode(r6)
            goto L_0x02a0
        L_0x029d:
            r10.useNode()
        L_0x02a0:
            r10.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m1543constructorimpl(r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r2, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r4, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r5, r2)
            r10.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r10)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r2)
            int r4 = r3 >> 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r11.invoke(r2, r10, r4)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r10.startReplaceableGroup(r2)
            int r2 = r3 >> 9
            r2 = r2 & 14
            r3 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r10.startReplaceableGroup(r3)
            java.lang.String r3 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r3)
            r2 = r2 & 11
            r3 = 2
            r2 = r2 ^ r3
            if (r2 != 0) goto L_0x0301
            boolean r2 = r10.getSkipping()
            if (r2 != 0) goto L_0x02fa
            goto L_0x0301
        L_0x02fa:
            r10.skipToGroupEnd()
            r6 = r23
            goto L_0x036e
        L_0x0301:
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r0 = r0 >> 6
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | 6
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r2 = 2072161330(0x7b82ac32, float:1.3569823E36)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "C:Crossfade.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            r0 = r0 & 81
            r2 = 16
            r0 = r0 ^ r2
            if (r0 != 0) goto L_0x032a
            boolean r0 = r10.getSkipping()
            if (r0 != 0) goto L_0x0324
            goto L_0x032a
        L_0x0324:
            r10.skipToGroupEnd()
        L_0x0327:
            r6 = r23
            goto L_0x036b
        L_0x032a:
            r4 = r22
            java.util.List r4 = (java.util.List) r4
            int r0 = r4.size()
            int r0 = r0 + -1
            if (r0 < 0) goto L_0x0327
            r2 = 0
        L_0x0337:
            int r3 = r2 + 1
            java.lang.Object r2 = r4.get(r2)
            r5 = -450541954(0xffffffffe525467e, float:-4.8780676E22)
            r6 = r23
            java.lang.Object r11 = r6.invoke(r2)
            r10.startMovableGroup(r5, r11)
            java.lang.String r5 = "123@5283L8"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r5)
            java.lang.Object r2 = r1.get(r2)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r5 = 0
            if (r2 != 0) goto L_0x0358
            goto L_0x0361
        L_0x0358:
            java.lang.Integer r11 = java.lang.Integer.valueOf(r5)
            r2.invoke(r10, r11)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x0361:
            r10.endMovableGroup()
            if (r3 <= r0) goto L_0x0367
            goto L_0x036b
        L_0x0367:
            r2 = r3
            r23 = r6
            goto L_0x0337
        L_0x036b:
            r10.endReplaceableGroup()
        L_0x036e:
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            r10.endNode()
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            r4 = r6
            r2 = r14
            r3 = r16
        L_0x0381:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 != 0) goto L_0x0388
            goto L_0x039b
        L_0x0388:
            androidx.compose.animation.CrossfadeKt$Crossfade$6 r11 = new androidx.compose.animation.CrossfadeKt$Crossfade$6
            r0 = r11
            r1 = r24
            r5 = r28
            r6 = r30
            r7 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x039b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.CrossfadeKt.Crossfade(androidx.compose.animation.core.Transition, androidx.compose.ui.Modifier, androidx.compose.animation.core.FiniteAnimationSpec, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
