package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f21\u0010\r\u001a-\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0012¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0013\u001aU\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172>\b\u0002\u0010\u0018\u001a8\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u001c0\u000eH\u0007ø\u0001\u0000\u001a¬\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2%\b\u0002\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u000721\u0010\r\u001a-\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0012¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010 \u001a\u0015\u0010!\u001a\u00020\t*\u00020\"2\u0006\u0010#\u001a\u00020$H\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"AnimatedContent", "", "S", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/compose/animation/ContentTransform;", "Lkotlin/ExtensionFunctionType;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "content", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "SizeTransform", "Landroidx/compose/animation/SizeTransform;", "clip", "", "sizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "initialSize", "targetSize", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/animation/core/Transition;", "contentKey", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "with", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "animation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
public final class AnimatedContentKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    @androidx.compose.animation.ExperimentalAnimationApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S> void AnimatedContent(S r16, androidx.compose.ui.Modifier r17, kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentScope<S>, androidx.compose.animation.ContentTransform> r18, androidx.compose.ui.Alignment r19, kotlin.jvm.functions.Function4<? super androidx.compose.animation.AnimatedVisibilityScope, ? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r1 = r16
            r11 = r20
            r12 = r22
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -441539443(0xffffffffe5aea48d, float:-1.030909E23)
            r2 = r21
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(AnimatedContent)P(3,2,4,1)129@6620L70,130@6706L116:AnimatedContent.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r23 & 1
            if (r2 == 0) goto L_0x0020
            r2 = r12 | 6
            goto L_0x0030
        L_0x0020:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x002f
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002c
            r2 = 4
            goto L_0x002d
        L_0x002c:
            r2 = 2
        L_0x002d:
            r2 = r2 | r12
            goto L_0x0030
        L_0x002f:
            r2 = r12
        L_0x0030:
            r3 = r23 & 2
            if (r3 == 0) goto L_0x0037
            r2 = r2 | 48
            goto L_0x004a
        L_0x0037:
            r4 = r12 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004a
            r4 = r17
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0046
            r5 = 32
            goto L_0x0048
        L_0x0046:
            r5 = 16
        L_0x0048:
            r2 = r2 | r5
            goto L_0x004c
        L_0x004a:
            r4 = r17
        L_0x004c:
            r5 = r23 & 4
            if (r5 == 0) goto L_0x0053
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r6 = r12 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0066
            r6 = r18
            boolean r7 = r0.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0062
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r2 = r2 | r7
            goto L_0x0068
        L_0x0066:
            r6 = r18
        L_0x0068:
            r7 = r23 & 8
            if (r7 == 0) goto L_0x006f
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r8 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0082
            r8 = r19
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x007e
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r2 = r2 | r9
            goto L_0x0084
        L_0x0082:
            r8 = r19
        L_0x0084:
            r9 = r23 & 16
            if (r9 == 0) goto L_0x008b
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009d
        L_0x008b:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r12
            if (r9 != 0) goto L_0x009d
            boolean r9 = r0.changed((java.lang.Object) r11)
            if (r9 == 0) goto L_0x009a
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r2 = r2 | r9
        L_0x009d:
            r9 = 46811(0xb6db, float:6.5596E-41)
            r9 = r9 & r2
            r9 = r9 ^ 9362(0x2492, float:1.3119E-41)
            if (r9 != 0) goto L_0x00b3
            boolean r9 = r0.getSkipping()
            if (r9 != 0) goto L_0x00ac
            goto L_0x00b3
        L_0x00ac:
            r0.skipToGroupEnd()
            r2 = r4
            r3 = r6
            r4 = r8
            goto L_0x00fd
        L_0x00b3:
            if (r3 == 0) goto L_0x00bb
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r13 = r3
            goto L_0x00bc
        L_0x00bb:
            r13 = r4
        L_0x00bc:
            if (r5 == 0) goto L_0x00c4
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$1 r3 = androidx.compose.animation.AnimatedContentKt$AnimatedContent$1.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r14 = r3
            goto L_0x00c5
        L_0x00c4:
            r14 = r6
        L_0x00c5:
            if (r7 == 0) goto L_0x00cf
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getTopStart()
            r15 = r3
            goto L_0x00d0
        L_0x00cf:
            r15 = r8
        L_0x00d0:
            r3 = r2 & 8
            r3 = r3 | 48
            r4 = r2 & 14
            r3 = r3 | r4
            r4 = 0
            java.lang.String r5 = "AnimatedContent"
            androidx.compose.animation.core.Transition r3 = androidx.compose.animation.core.TransitionKt.updateTransition(r1, (java.lang.String) r5, (androidx.compose.runtime.Composer) r0, (int) r3, (int) r4)
            r6 = 0
            r4 = r2 & 112(0x70, float:1.57E-43)
            r5 = r2 & 896(0x380, float:1.256E-42)
            r4 = r4 | r5
            r5 = r2 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r5
            r5 = 458752(0x70000, float:6.42848E-40)
            int r2 = r2 << 3
            r2 = r2 & r5
            r9 = r4 | r2
            r10 = 8
            r2 = r3
            r3 = r13
            r4 = r14
            r5 = r15
            r7 = r20
            r8 = r0
            AnimatedContent(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = r13
            r3 = r14
            r4 = r15
        L_0x00fd:
            androidx.compose.runtime.ScopeUpdateScope r8 = r0.endRestartGroup()
            if (r8 != 0) goto L_0x0104
            goto L_0x0117
        L_0x0104:
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$2 r9 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$2
            r0 = r9
            r1 = r16
            r5 = r20
            r6 = r22
            r7 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x0117:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt.AnimatedContent(java.lang.Object, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    public static /* synthetic */ SizeTransform SizeTransform$default(boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function2 = AnimatedContentKt$SizeTransform$1.INSTANCE;
        }
        return SizeTransform(z, function2);
    }

    @ExperimentalAnimationApi
    public static final SizeTransform SizeTransform(boolean z, Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> function2) {
        Intrinsics.checkNotNullParameter(function2, "sizeAnimationSpec");
        return new SizeTransformImpl(z, function2);
    }

    @ExperimentalAnimationApi
    public static final ContentTransform with(EnterTransition enterTransition, ExitTransition exitTransition) {
        Intrinsics.checkNotNullParameter(enterTransition, "<this>");
        Intrinsics.checkNotNullParameter(exitTransition, "exit");
        return new ContentTransform(enterTransition, exitTransition, 0.0f, (SizeTransform) null, 12, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:141:0x0307  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x035a  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0366  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x03c2  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0409  */
    /* JADX WARNING: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00dc  */
    @androidx.compose.animation.ExperimentalAnimationApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S> void AnimatedContent(androidx.compose.animation.core.Transition<S> r23, androidx.compose.ui.Modifier r24, kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentScope<S>, androidx.compose.animation.ContentTransform> r25, androidx.compose.ui.Alignment r26, kotlin.jvm.functions.Function1<? super S, ? extends java.lang.Object> r27, kotlin.jvm.functions.Function4<? super androidx.compose.animation.AnimatedVisibilityScope, ? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r8 = r23
            r9 = r28
            r10 = r30
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = -441518303(0xffffffffe5aef721, float:-1.0328131E23)
            r1 = r29
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(AnimatedContent)P(3,4,1,2)585@27831L7,586@27859L92,591@28040L51,592@28113L62,663@31559L58,664@31651L45,674@31966L52,665@31701L323:AnimatedContent.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r31 & r0
            if (r0 == 0) goto L_0x0027
            r0 = r10 | 6
            goto L_0x0037
        L_0x0027:
            r0 = r10 & 14
            if (r0 != 0) goto L_0x0036
            boolean r0 = r11.changed((java.lang.Object) r8)
            if (r0 == 0) goto L_0x0033
            r0 = 4
            goto L_0x0034
        L_0x0033:
            r0 = 2
        L_0x0034:
            r0 = r0 | r10
            goto L_0x0037
        L_0x0036:
            r0 = r10
        L_0x0037:
            r1 = r31 & 1
            if (r1 == 0) goto L_0x003e
            r0 = r0 | 48
            goto L_0x0051
        L_0x003e:
            r2 = r10 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0051
            r2 = r24
            boolean r3 = r11.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x004d
            r3 = 32
            goto L_0x004f
        L_0x004d:
            r3 = 16
        L_0x004f:
            r0 = r0 | r3
            goto L_0x0053
        L_0x0051:
            r2 = r24
        L_0x0053:
            r3 = r31 & 2
            if (r3 == 0) goto L_0x005a
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x005a:
            r4 = r10 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x006d
            r4 = r25
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0069
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r5 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r0 = r0 | r5
            goto L_0x006f
        L_0x006d:
            r4 = r25
        L_0x006f:
            r5 = r31 & 4
            if (r5 == 0) goto L_0x0076
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0076:
            r6 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0089
            r6 = r26
            boolean r7 = r11.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0085
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r0 = r0 | r7
            goto L_0x008b
        L_0x0089:
            r6 = r26
        L_0x008b:
            r7 = r31 & 8
            if (r7 == 0) goto L_0x0092
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a7
        L_0x0092:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r10
            if (r12 != 0) goto L_0x00a7
            r12 = r27
            boolean r13 = r11.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x00a3
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a5
        L_0x00a3:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x00a5:
            r0 = r0 | r13
            goto L_0x00a9
        L_0x00a7:
            r12 = r27
        L_0x00a9:
            r13 = r31 & 16
            if (r13 == 0) goto L_0x00b1
            r13 = 196608(0x30000, float:2.75506E-40)
        L_0x00af:
            r0 = r0 | r13
            goto L_0x00c2
        L_0x00b1:
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r10
            if (r13 != 0) goto L_0x00c2
            boolean r13 = r11.changed((java.lang.Object) r9)
            if (r13 == 0) goto L_0x00bf
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00af
        L_0x00bf:
            r13 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00af
        L_0x00c2:
            r13 = r0
            r0 = 374491(0x5b6db, float:5.24774E-40)
            r0 = r0 & r13
            r14 = 74898(0x12492, float:1.04954E-40)
            r0 = r0 ^ r14
            if (r0 != 0) goto L_0x00dc
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x00d4
            goto L_0x00dc
        L_0x00d4:
            r11.skipToGroupEnd()
            r3 = r4
            r4 = r6
            r5 = r12
            goto L_0x0402
        L_0x00dc:
            if (r1 == 0) goto L_0x00e4
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r14 = r0
            goto L_0x00e5
        L_0x00e4:
            r14 = r2
        L_0x00e5:
            if (r3 == 0) goto L_0x00ed
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$3 r0 = androidx.compose.animation.AnimatedContentKt$AnimatedContent$3.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r15 = r0
            goto L_0x00ee
        L_0x00ed:
            r15 = r4
        L_0x00ee:
            if (r5 == 0) goto L_0x00f7
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r0 = r0.getTopStart()
            r6 = r0
        L_0x00f7:
            if (r7 == 0) goto L_0x00fe
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$4 r0 = androidx.compose.animation.AnimatedContentKt$AnimatedContent$4.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r12 = r0
        L_0x00fe:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r7 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r7, r5)
            java.lang.Object r0 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.unit.LayoutDirection r0 = (androidx.compose.ui.unit.LayoutDirection) r0
            r1 = -3686930(0xffffffffffc7bdee, float:NaN)
            r11.startReplaceableGroup(r1)
            java.lang.String r2 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            boolean r3 = r11.changed((java.lang.Object) r8)
            java.lang.Object r4 = r11.rememberedValue()
            if (r3 != 0) goto L_0x0132
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x013a
        L_0x0132:
            androidx.compose.animation.AnimatedContentScope r4 = new androidx.compose.animation.AnimatedContentScope
            r4.<init>(r8, r6, r0)
            r11.updateRememberedValue(r4)
        L_0x013a:
            r11.endReplaceableGroup()
            androidx.compose.animation.AnimatedContentScope r4 = (androidx.compose.animation.AnimatedContentScope) r4
            r11.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            boolean r3 = r11.changed((java.lang.Object) r8)
            java.lang.Object r7 = r11.rememberedValue()
            r1 = 1
            if (r3 != 0) goto L_0x0158
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r7 != r3) goto L_0x0169
        L_0x0158:
            java.lang.Object[] r3 = new java.lang.Object[r1]
            java.lang.Object r7 = r23.getCurrentState()
            r16 = 0
            r3[r16] = r7
            androidx.compose.runtime.snapshots.SnapshotStateList r7 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf(r3)
            r11.updateRememberedValue(r7)
        L_0x0169:
            r11.endReplaceableGroup()
            androidx.compose.runtime.snapshots.SnapshotStateList r7 = (androidx.compose.runtime.snapshots.SnapshotStateList) r7
            r3 = -3686930(0xffffffffffc7bdee, float:NaN)
            r11.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            boolean r2 = r11.changed((java.lang.Object) r8)
            java.lang.Object r3 = r11.rememberedValue()
            if (r2 != 0) goto L_0x0189
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x0194
        L_0x0189:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            r3 = r2
            java.util.Map r3 = (java.util.Map) r3
            r11.updateRememberedValue(r3)
        L_0x0194:
            r11.endReplaceableGroup()
            java.util.Map r3 = (java.util.Map) r3
            java.lang.Object r2 = r23.getCurrentState()
            java.lang.Object r1 = r23.getTargetState()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x01e2
            int r1 = r7.size()
            r2 = 1
            if (r1 != r2) goto L_0x01bd
            r1 = 0
            java.lang.Object r2 = r7.get(r1)
            java.lang.Object r1 = r23.getCurrentState()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r1)
            if (r1 != 0) goto L_0x01c7
        L_0x01bd:
            r7.clear()
            java.lang.Object r1 = r23.getCurrentState()
            r7.add(r1)
        L_0x01c7:
            int r1 = r3.size()
            r2 = 1
            if (r1 != r2) goto L_0x01d8
            java.lang.Object r1 = r23.getCurrentState()
            boolean r1 = r3.containsKey(r1)
            if (r1 == 0) goto L_0x01db
        L_0x01d8:
            r3.clear()
        L_0x01db:
            r4.setContentAlignment$animation_release(r6)
            r4.setLayoutDirection$animation_release(r0)
            goto L_0x01e3
        L_0x01e2:
            r2 = 1
        L_0x01e3:
            java.lang.Object r0 = r23.getCurrentState()
            java.lang.Object r1 = r23.getTargetState()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 != 0) goto L_0x023a
            java.lang.Object r0 = r23.getTargetState()
            boolean r0 = r7.contains(r0)
            if (r0 != 0) goto L_0x023a
            r0 = r7
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r0 = r0.iterator()
            r16 = 0
        L_0x0204:
            boolean r17 = r0.hasNext()
            if (r17 == 0) goto L_0x0227
            java.lang.Object r2 = r0.next()
            java.lang.Object r2 = r12.invoke(r2)
            java.lang.Object r1 = r23.getTargetState()
            java.lang.Object r1 = r12.invoke(r1)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0223
            r0 = r16
            goto L_0x0228
        L_0x0223:
            int r16 = r16 + 1
            r2 = 1
            goto L_0x0204
        L_0x0227:
            r0 = -1
        L_0x0228:
            r1 = -1
            if (r0 != r1) goto L_0x0233
            java.lang.Object r0 = r23.getTargetState()
            r7.add(r0)
            goto L_0x023a
        L_0x0233:
            java.lang.Object r1 = r23.getTargetState()
            r7.set(r0, r1)
        L_0x023a:
            java.lang.Object r0 = r23.getTargetState()
            boolean r0 = r3.containsKey(r0)
            if (r0 != 0) goto L_0x02a3
            r3.clear()
            r2 = r7
            java.util.List r2 = (java.util.List) r2
            int r0 = r2.size()
            r1 = -1
            int r1 = r1 + r0
            if (r1 < 0) goto L_0x02a3
            r0 = 0
        L_0x0253:
            int r8 = r0 + 1
            java.lang.Object r0 = r2.get(r0)
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1 r9 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1
            r29 = r0
            r0 = r9
            r10 = r1
            r17 = r12
            r12 = 1
            r16 = 0
            r1 = r23
            r18 = r2
            r2 = r29
            r19 = r3
            r3 = r13
            r25 = r4
            r4 = r15
            r20 = r5
            r5 = r25
            r21 = r6
            r6 = r28
            r22 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = -985562382(0xffffffffc54182f2, float:-3096.184)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r0, r12, r9)
            r1 = r29
            r3 = r19
            r3.put(r1, r0)
            if (r8 <= r10) goto L_0x028e
            goto L_0x02af
        L_0x028e:
            r4 = r25
            r9 = r28
            r0 = r8
            r1 = r10
            r12 = r17
            r2 = r18
            r5 = r20
            r6 = r21
            r7 = r22
            r8 = r23
            r10 = r30
            goto L_0x0253
        L_0x02a3:
            r25 = r4
            r20 = r5
            r21 = r6
            r22 = r7
            r17 = r12
            r16 = 0
        L_0x02af:
            androidx.compose.animation.core.Transition$Segment r0 = r23.getSegment()
            r1 = -3686552(0xffffffffffc7bf68, float:NaN)
            r11.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r4 = r25
            boolean r1 = r11.changed((java.lang.Object) r4)
            boolean r0 = r11.changed((java.lang.Object) r0)
            r0 = r0 | r1
            java.lang.Object r1 = r11.rememberedValue()
            if (r0 != 0) goto L_0x02d7
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x02e1
        L_0x02d7:
            java.lang.Object r0 = r15.invoke(r4)
            r1 = r0
            androidx.compose.animation.ContentTransform r1 = (androidx.compose.animation.ContentTransform) r1
            r11.updateRememberedValue(r1)
        L_0x02e1:
            r11.endReplaceableGroup()
            androidx.compose.animation.ContentTransform r1 = (androidx.compose.animation.ContentTransform) r1
            r0 = 72
            androidx.compose.ui.Modifier r0 = r4.createSizeAnimationModifier$animation_release(r1, r11, r0)
            androidx.compose.ui.Modifier r0 = r14.then(r0)
            r1 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r11.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            java.lang.Object r1 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x030f
            androidx.compose.animation.AnimatedContentMeasurePolicy r1 = new androidx.compose.animation.AnimatedContentMeasurePolicy
            r1.<init>(r4)
            r11.updateRememberedValue(r1)
        L_0x030f:
            r11.endReplaceableGroup()
            androidx.compose.animation.AnimatedContentMeasurePolicy r1 = (androidx.compose.animation.AnimatedContentMeasurePolicy) r1
            r2 = 1376089335(0x520574f7, float:1.43298249E11)
            r11.startReplaceableGroup(r2)
            java.lang.String r2 = "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = r20
            r5 = 103361330(0x6292b32, float:3.1817102E-35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r5, r4)
            java.lang.Object r2 = r11.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r5, r4)
            java.lang.Object r4 = r11.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            androidx.compose.runtime.Applier r6 = r11.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x035d
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x035d:
            r11.startReusableNode()
            boolean r6 = r11.getInserting()
            if (r6 == 0) goto L_0x036a
            r11.createNode(r5)
            goto L_0x036d
        L_0x036a:
            r11.useNode()
        L_0x036d:
            r11.disableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m1543constructorimpl(r11)
            androidx.compose.ui.layout.MeasurePolicy r1 = (androidx.compose.ui.layout.MeasurePolicy) r1
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r1, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r2, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r4, r1)
            r11.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r11)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r16)
            r0.invoke(r1, r11, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r11.startReplaceableGroup(r0)
            r0 = -740842621(0xffffffffd3d7a383, float:-1.85232248E12)
            r11.startReplaceableGroup(r0)
            java.lang.String r0 = "C:AnimatedContent.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            r7 = r22
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r0 = r7.iterator()
        L_0x03bc:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x03ef
            java.lang.Object r1 = r0.next()
            r2 = -1739565873(0xffffffff985054cf, float:-2.6926187E-24)
            r12 = r17
            java.lang.Object r4 = r12.invoke(r1)
            r11.startMovableGroup(r2, r4)
            java.lang.String r2 = "670@31890L8"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            java.lang.Object r1 = r3.get(r1)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            if (r1 != 0) goto L_0x03e0
            goto L_0x03e9
        L_0x03e0:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r16)
            r1.invoke(r11, r2)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x03e9:
            r11.endMovableGroup()
            r17 = r12
            goto L_0x03bc
        L_0x03ef:
            r12 = r17
            r11.endReplaceableGroup()
            r11.endReplaceableGroup()
            r11.endNode()
            r11.endReplaceableGroup()
            r5 = r12
            r2 = r14
            r3 = r15
            r4 = r21
        L_0x0402:
            androidx.compose.runtime.ScopeUpdateScope r9 = r11.endRestartGroup()
            if (r9 != 0) goto L_0x0409
            goto L_0x041c
        L_0x0409:
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$8 r10 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$8
            r0 = r10
            r1 = r23
            r6 = r28
            r7 = r30
            r8 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x041c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt.AnimatedContent(androidx.compose.animation.core.Transition, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }
}
