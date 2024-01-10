package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001ak\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0003¢\u0006\u0002\u0010\u0012\u001aR\u0010\u0000\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\b¢\u0006\u0002\u0010\u0014\u001aa\u0010\u0015\u001a\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u001a\u001aJ\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00072\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001d\u001a[\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u001e\u001am\u0010\u0015\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u001f\u001ae\u0010\u0015\u001a\u00020\u0001*\u00020 2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010!\u001a_\u0010\u0015\u001a\u00020\u0001*\u00020 2\u0006\u0010\u0005\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\"\u001ae\u0010\u0015\u001a\u00020\u0001*\u00020#2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010$\u001a_\u0010\u0015\u001a\u00020\u0001*\u00020#2\u0006\u0010\u0005\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010%\u001a9\u0010&\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010'\u001a\u0002H\u0002H\u0003¢\u0006\u0002\u0010(¨\u0006)"}, d2 = {"AnimatedEnterExitImpl", "", "T", "transition", "Landroidx/compose/animation/core/Transition;", "visible", "Lkotlin/Function1;", "", "modifier", "Landroidx/compose/ui/Modifier;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "content", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/animation/EnterExitState;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "AnimatedVisibility", "visibleState", "Landroidx/compose/animation/core/MutableTransitionState;", "label", "", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "initiallyVisible", "Lkotlin/Function0;", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/ColumnScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/RowScope;", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/RowScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "targetEnterExit", "targetState", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterExitState;", "animation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnimatedVisibility.kt */
public final class AnimatedVisibilityKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(boolean r23, androidx.compose.ui.Modifier r24, androidx.compose.animation.EnterTransition r25, androidx.compose.animation.ExitTransition r26, java.lang.String r27, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r8 = r28
            r9 = r30
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 1844970278(0x6df80326, float:9.594511E27)
            r1 = r29
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(AnimatedVisibility)P(5,4,1,2,3)126@6656L32,127@6693L73:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = r31 & 1
            if (r0 == 0) goto L_0x0020
            r0 = r9 | 6
            r11 = r23
            goto L_0x0032
        L_0x0020:
            r0 = r9 & 14
            r11 = r23
            if (r0 != 0) goto L_0x0031
            boolean r0 = r10.changed((boolean) r11)
            if (r0 == 0) goto L_0x002e
            r0 = 4
            goto L_0x002f
        L_0x002e:
            r0 = 2
        L_0x002f:
            r0 = r0 | r9
            goto L_0x0032
        L_0x0031:
            r0 = r9
        L_0x0032:
            r1 = r31 & 2
            if (r1 == 0) goto L_0x0039
            r0 = r0 | 48
            goto L_0x004c
        L_0x0039:
            r2 = r9 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004c
            r2 = r24
            boolean r3 = r10.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0048
            r3 = 32
            goto L_0x004a
        L_0x0048:
            r3 = 16
        L_0x004a:
            r0 = r0 | r3
            goto L_0x004e
        L_0x004c:
            r2 = r24
        L_0x004e:
            r3 = r31 & 4
            if (r3 == 0) goto L_0x0055
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r4 = r9 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0068
            r4 = r25
            boolean r5 = r10.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0064
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r0 = r0 | r5
            goto L_0x006a
        L_0x0068:
            r4 = r25
        L_0x006a:
            r5 = r31 & 8
            if (r5 == 0) goto L_0x0071
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0071:
            r6 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0084
            r6 = r26
            boolean r7 = r10.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0080
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r0 = r0 | r7
            goto L_0x0086
        L_0x0084:
            r6 = r26
        L_0x0086:
            r7 = r31 & 16
            r12 = 57344(0xe000, float:8.0356E-41)
            if (r7 == 0) goto L_0x0090
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a3
        L_0x0090:
            r13 = r9 & r12
            if (r13 != 0) goto L_0x00a3
            r13 = r27
            boolean r14 = r10.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x009f
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a1
        L_0x009f:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x00a1:
            r0 = r0 | r14
            goto L_0x00a5
        L_0x00a3:
            r13 = r27
        L_0x00a5:
            r14 = r31 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r14 == 0) goto L_0x00af
            r14 = 196608(0x30000, float:2.75506E-40)
        L_0x00ad:
            r0 = r0 | r14
            goto L_0x00bf
        L_0x00af:
            r14 = r9 & r15
            if (r14 != 0) goto L_0x00bf
            boolean r14 = r10.changed((java.lang.Object) r8)
            if (r14 == 0) goto L_0x00bc
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ad
        L_0x00bc:
            r14 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00ad
        L_0x00bf:
            r14 = 374491(0x5b6db, float:5.24774E-40)
            r14 = r14 & r0
            r16 = 74898(0x12492, float:1.04954E-40)
            r14 = r14 ^ r16
            if (r14 != 0) goto L_0x00d9
            boolean r14 = r10.getSkipping()
            if (r14 != 0) goto L_0x00d1
            goto L_0x00d9
        L_0x00d1:
            r10.skipToGroupEnd()
            r3 = r4
            r4 = r6
        L_0x00d6:
            r5 = r13
            goto L_0x0158
        L_0x00d9:
            if (r1 == 0) goto L_0x00e1
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r14 = r1
            goto L_0x00e2
        L_0x00e1:
            r14 = r2
        L_0x00e2:
            r1 = 0
            r2 = 3
            r15 = 0
            if (r3 == 0) goto L_0x0102
            androidx.compose.animation.EnterTransition r3 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r15, r1, r2, r15)
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 15
            r21 = 0
            androidx.compose.animation.EnterTransition r4 = androidx.compose.animation.EnterExitTransitionKt.expandIn$default(r16, r17, r18, r19, r20, r21)
            androidx.compose.animation.EnterTransition r3 = r3.plus(r4)
            r16 = r3
            goto L_0x0104
        L_0x0102:
            r16 = r4
        L_0x0104:
            if (r5 == 0) goto L_0x0120
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 15
            r22 = 0
            androidx.compose.animation.ExitTransition r3 = androidx.compose.animation.EnterExitTransitionKt.shrinkOut$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.ExitTransition r1 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r15, r1, r2, r15)
            androidx.compose.animation.ExitTransition r1 = r3.plus(r1)
            r15 = r1
            goto L_0x0121
        L_0x0120:
            r15 = r6
        L_0x0121:
            if (r7 == 0) goto L_0x0126
            java.lang.String r1 = "AnimatedVisibility"
            r13 = r1
        L_0x0126:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r23)
            r2 = r0 & 14
            int r3 = r0 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            r3 = 0
            androidx.compose.animation.core.Transition r1 = androidx.compose.animation.core.TransitionKt.updateTransition(r1, (java.lang.String) r13, (androidx.compose.runtime.Composer) r10, (int) r2, (int) r3)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1 r2 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1.INSTANCE
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            int r3 = r0 << 3
            r4 = r3 & 896(0x380, float:1.256E-42)
            r4 = r4 | 48
            r5 = r3 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r5
            r3 = r3 & r12
            r3 = r3 | r4
            r4 = 458752(0x70000, float:6.42848E-40)
            r0 = r0 & r4
            r7 = r3 | r0
            r0 = r1
            r1 = r2
            r2 = r14
            r3 = r16
            r4 = r15
            r5 = r28
            r6 = r10
            AnimatedEnterExitImpl(r0, r1, r2, r3, r4, r5, r6, r7)
            goto L_0x00d6
        L_0x0158:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 != 0) goto L_0x015f
            goto L_0x0172
        L_0x015f:
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$2 r12 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$2
            r0 = r12
            r1 = r23
            r6 = r28
            r7 = r30
            r8 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r10.updateScope(r12)
        L_0x0172:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(boolean, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(androidx.compose.foundation.layout.RowScope r24, boolean r25, androidx.compose.ui.Modifier r26, androidx.compose.animation.EnterTransition r27, androidx.compose.animation.ExitTransition r28, java.lang.String r29, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r8 = r30
            r9 = r32
            java.lang.String r0 = "<this>"
            r10 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 1844974544(0x6df813d0, float:9.597029E27)
            r1 = r31
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(AnimatedVisibility)P(5,4,1,2,3)201@10950L32,202@10987L73:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            r0 = r33 & 1
            if (r0 == 0) goto L_0x0027
            r0 = r9 | 48
            r12 = r25
            goto L_0x003b
        L_0x0027:
            r0 = r9 & 112(0x70, float:1.57E-43)
            r12 = r25
            if (r0 != 0) goto L_0x003a
            boolean r0 = r11.changed((boolean) r12)
            if (r0 == 0) goto L_0x0036
            r0 = 32
            goto L_0x0038
        L_0x0036:
            r0 = 16
        L_0x0038:
            r0 = r0 | r9
            goto L_0x003b
        L_0x003a:
            r0 = r9
        L_0x003b:
            r1 = r33 & 2
            if (r1 == 0) goto L_0x0042
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0055
        L_0x0042:
            r2 = r9 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0055
            r2 = r26
            boolean r3 = r11.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0051
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0053
        L_0x0051:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0053:
            r0 = r0 | r3
            goto L_0x0057
        L_0x0055:
            r2 = r26
        L_0x0057:
            r3 = r33 & 4
            if (r3 == 0) goto L_0x005e
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0071
        L_0x005e:
            r4 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0071
            r4 = r27
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x006d
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x006f
        L_0x006d:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x006f:
            r0 = r0 | r5
            goto L_0x0073
        L_0x0071:
            r4 = r27
        L_0x0073:
            r5 = r33 & 8
            r6 = 57344(0xe000, float:8.0356E-41)
            if (r5 == 0) goto L_0x007d
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0090
        L_0x007d:
            r7 = r9 & r6
            if (r7 != 0) goto L_0x0090
            r7 = r28
            boolean r13 = r11.changed((java.lang.Object) r7)
            if (r13 == 0) goto L_0x008c
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x008e
        L_0x008c:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x008e:
            r0 = r0 | r13
            goto L_0x0092
        L_0x0090:
            r7 = r28
        L_0x0092:
            r13 = r33 & 16
            r14 = 458752(0x70000, float:6.42848E-40)
            if (r13 == 0) goto L_0x009c
            r15 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r15
            goto L_0x00b0
        L_0x009c:
            r15 = r9 & r14
            if (r15 != 0) goto L_0x00b0
            r15 = r29
            boolean r16 = r11.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00ab
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ad
        L_0x00ab:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00ad:
            r0 = r0 | r16
            goto L_0x00b2
        L_0x00b0:
            r15 = r29
        L_0x00b2:
            r16 = r33 & 32
            if (r16 == 0) goto L_0x00bb
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00b8:
            r0 = r0 | r16
            goto L_0x00cd
        L_0x00bb:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r9 & r16
            if (r16 != 0) goto L_0x00cd
            boolean r16 = r11.changed((java.lang.Object) r8)
            if (r16 == 0) goto L_0x00ca
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00b8
        L_0x00ca:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00b8
        L_0x00cd:
            r16 = 2995921(0x2db6d1, float:4.19818E-39)
            r16 = r0 & r16
            r17 = 599184(0x92490, float:8.39636E-40)
            r16 = r16 ^ r17
            if (r16 != 0) goto L_0x00e8
            boolean r16 = r11.getSkipping()
            if (r16 != 0) goto L_0x00e0
            goto L_0x00e8
        L_0x00e0:
            r11.skipToGroupEnd()
            r3 = r2
            r5 = r7
            r6 = r15
            goto L_0x016e
        L_0x00e8:
            if (r1 == 0) goto L_0x00f1
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r16 = r1
            goto L_0x00f3
        L_0x00f1:
            r16 = r2
        L_0x00f3:
            r1 = 0
            r2 = 3
            r14 = 0
            if (r3 == 0) goto L_0x0113
            androidx.compose.animation.EnterTransition r3 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r14, r1, r2, r14)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 15
            r22 = 0
            androidx.compose.animation.EnterTransition r4 = androidx.compose.animation.EnterExitTransitionKt.expandHorizontally$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.EnterTransition r3 = r3.plus(r4)
            r17 = r3
            goto L_0x0115
        L_0x0113:
            r17 = r4
        L_0x0115:
            if (r5 == 0) goto L_0x0131
            androidx.compose.animation.ExitTransition r1 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r14, r1, r2, r14)
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 15
            r23 = 0
            androidx.compose.animation.ExitTransition r2 = androidx.compose.animation.EnterExitTransitionKt.shrinkHorizontally$default(r18, r19, r20, r21, r22, r23)
            androidx.compose.animation.ExitTransition r1 = r1.plus(r2)
            r14 = r1
            goto L_0x0132
        L_0x0131:
            r14 = r7
        L_0x0132:
            if (r13 == 0) goto L_0x0137
            java.lang.String r1 = "AnimatedVisibility"
            r15 = r1
        L_0x0137:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r25)
            int r2 = r0 >> 3
            r3 = r2 & 14
            int r4 = r0 >> 12
            r4 = r4 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            r4 = 0
            androidx.compose.animation.core.Transition r1 = androidx.compose.animation.core.TransitionKt.updateTransition(r1, (java.lang.String) r15, (androidx.compose.runtime.Composer) r11, (int) r3, (int) r4)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3 r3 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r4 = r0 & 896(0x380, float:1.256E-42)
            r4 = r4 | 48
            r5 = r0 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r5
            r0 = r0 & r6
            r0 = r0 | r4
            r4 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r4
            r7 = r0 | r2
            r0 = r1
            r1 = r3
            r2 = r16
            r3 = r17
            r4 = r14
            r5 = r30
            r6 = r11
            AnimatedEnterExitImpl(r0, r1, r2, r3, r4, r5, r6, r7)
            r5 = r14
            r6 = r15
            r3 = r16
            r4 = r17
        L_0x016e:
            androidx.compose.runtime.ScopeUpdateScope r11 = r11.endRestartGroup()
            if (r11 != 0) goto L_0x0175
            goto L_0x018a
        L_0x0175:
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$4 r13 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$4
            r0 = r13
            r1 = r24
            r2 = r25
            r7 = r30
            r8 = r32
            r9 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r11.updateScope(r13)
        L_0x018a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.foundation.layout.RowScope, boolean, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(androidx.compose.foundation.layout.ColumnScope r24, boolean r25, androidx.compose.ui.Modifier r26, androidx.compose.animation.EnterTransition r27, androidx.compose.animation.ExitTransition r28, java.lang.String r29, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r8 = r30
            r9 = r32
            java.lang.String r0 = "<this>"
            r10 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 1844978819(0x6df82483, float:9.599553E27)
            r1 = r31
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(AnimatedVisibility)P(5,4,1,2,3)274@15222L32,275@15259L73:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            r0 = r33 & 1
            if (r0 == 0) goto L_0x0027
            r0 = r9 | 48
            r12 = r25
            goto L_0x003b
        L_0x0027:
            r0 = r9 & 112(0x70, float:1.57E-43)
            r12 = r25
            if (r0 != 0) goto L_0x003a
            boolean r0 = r11.changed((boolean) r12)
            if (r0 == 0) goto L_0x0036
            r0 = 32
            goto L_0x0038
        L_0x0036:
            r0 = 16
        L_0x0038:
            r0 = r0 | r9
            goto L_0x003b
        L_0x003a:
            r0 = r9
        L_0x003b:
            r1 = r33 & 2
            if (r1 == 0) goto L_0x0042
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0055
        L_0x0042:
            r2 = r9 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0055
            r2 = r26
            boolean r3 = r11.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0051
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0053
        L_0x0051:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0053:
            r0 = r0 | r3
            goto L_0x0057
        L_0x0055:
            r2 = r26
        L_0x0057:
            r3 = r33 & 4
            if (r3 == 0) goto L_0x005e
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0071
        L_0x005e:
            r4 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0071
            r4 = r27
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x006d
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x006f
        L_0x006d:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x006f:
            r0 = r0 | r5
            goto L_0x0073
        L_0x0071:
            r4 = r27
        L_0x0073:
            r5 = r33 & 8
            r6 = 57344(0xe000, float:8.0356E-41)
            if (r5 == 0) goto L_0x007d
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0090
        L_0x007d:
            r7 = r9 & r6
            if (r7 != 0) goto L_0x0090
            r7 = r28
            boolean r13 = r11.changed((java.lang.Object) r7)
            if (r13 == 0) goto L_0x008c
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x008e
        L_0x008c:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x008e:
            r0 = r0 | r13
            goto L_0x0092
        L_0x0090:
            r7 = r28
        L_0x0092:
            r13 = r33 & 16
            r14 = 458752(0x70000, float:6.42848E-40)
            if (r13 == 0) goto L_0x009c
            r15 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r15
            goto L_0x00b0
        L_0x009c:
            r15 = r9 & r14
            if (r15 != 0) goto L_0x00b0
            r15 = r29
            boolean r16 = r11.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00ab
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ad
        L_0x00ab:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00ad:
            r0 = r0 | r16
            goto L_0x00b2
        L_0x00b0:
            r15 = r29
        L_0x00b2:
            r16 = r33 & 32
            if (r16 == 0) goto L_0x00bb
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00b8:
            r0 = r0 | r16
            goto L_0x00cd
        L_0x00bb:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r9 & r16
            if (r16 != 0) goto L_0x00cd
            boolean r16 = r11.changed((java.lang.Object) r8)
            if (r16 == 0) goto L_0x00ca
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00b8
        L_0x00ca:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00b8
        L_0x00cd:
            r16 = 2995921(0x2db6d1, float:4.19818E-39)
            r16 = r0 & r16
            r17 = 599184(0x92490, float:8.39636E-40)
            r16 = r16 ^ r17
            if (r16 != 0) goto L_0x00e8
            boolean r16 = r11.getSkipping()
            if (r16 != 0) goto L_0x00e0
            goto L_0x00e8
        L_0x00e0:
            r11.skipToGroupEnd()
            r3 = r2
            r5 = r7
            r6 = r15
            goto L_0x016e
        L_0x00e8:
            if (r1 == 0) goto L_0x00f1
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r16 = r1
            goto L_0x00f3
        L_0x00f1:
            r16 = r2
        L_0x00f3:
            r1 = 0
            r2 = 3
            r14 = 0
            if (r3 == 0) goto L_0x0113
            androidx.compose.animation.EnterTransition r3 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r14, r1, r2, r14)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 15
            r22 = 0
            androidx.compose.animation.EnterTransition r4 = androidx.compose.animation.EnterExitTransitionKt.expandVertically$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.EnterTransition r3 = r3.plus(r4)
            r17 = r3
            goto L_0x0115
        L_0x0113:
            r17 = r4
        L_0x0115:
            if (r5 == 0) goto L_0x0131
            androidx.compose.animation.ExitTransition r1 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r14, r1, r2, r14)
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 15
            r23 = 0
            androidx.compose.animation.ExitTransition r2 = androidx.compose.animation.EnterExitTransitionKt.shrinkVertically$default(r18, r19, r20, r21, r22, r23)
            androidx.compose.animation.ExitTransition r1 = r1.plus(r2)
            r14 = r1
            goto L_0x0132
        L_0x0131:
            r14 = r7
        L_0x0132:
            if (r13 == 0) goto L_0x0137
            java.lang.String r1 = "AnimatedVisibility"
            r15 = r1
        L_0x0137:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r25)
            int r2 = r0 >> 3
            r3 = r2 & 14
            int r4 = r0 >> 12
            r4 = r4 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            r4 = 0
            androidx.compose.animation.core.Transition r1 = androidx.compose.animation.core.TransitionKt.updateTransition(r1, (java.lang.String) r15, (androidx.compose.runtime.Composer) r11, (int) r3, (int) r4)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5 r3 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r4 = r0 & 896(0x380, float:1.256E-42)
            r4 = r4 | 48
            r5 = r0 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r5
            r0 = r0 & r6
            r0 = r0 | r4
            r4 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r4
            r7 = r0 | r2
            r0 = r1
            r1 = r3
            r2 = r16
            r3 = r17
            r4 = r14
            r5 = r30
            r6 = r11
            AnimatedEnterExitImpl(r0, r1, r2, r3, r4, r5, r6, r7)
            r5 = r14
            r6 = r15
            r3 = r16
            r4 = r17
        L_0x016e:
            androidx.compose.runtime.ScopeUpdateScope r11 = r11.endRestartGroup()
            if (r11 != 0) goto L_0x0175
            goto L_0x018a
        L_0x0175:
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$6 r13 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$6
            r0 = r13
            r1 = r24
            r2 = r25
            r7 = r30
            r8 = r32
            r9 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r11.updateScope(r13)
        L_0x018a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.foundation.layout.ColumnScope, boolean, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean> r23, androidx.compose.ui.Modifier r24, androidx.compose.animation.EnterTransition r25, androidx.compose.animation.ExitTransition r26, java.lang.String r27, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r1 = r23
            r10 = r28
            r11 = r30
            java.lang.String r0 = "visibleState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 1844984230(0x6df839a6, float:9.602747E27)
            r2 = r29
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(AnimatedVisibility)P(5,4,1,2,3)380@20637L37,381@20679L73:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r31 & 1
            if (r2 == 0) goto L_0x0026
            r2 = r11 | 6
            goto L_0x0036
        L_0x0026:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0035
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0032
            r2 = 4
            goto L_0x0033
        L_0x0032:
            r2 = 2
        L_0x0033:
            r2 = r2 | r11
            goto L_0x0036
        L_0x0035:
            r2 = r11
        L_0x0036:
            r3 = r31 & 2
            if (r3 == 0) goto L_0x003d
            r2 = r2 | 48
            goto L_0x0050
        L_0x003d:
            r4 = r11 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0050
            r4 = r24
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004c
            r5 = 32
            goto L_0x004e
        L_0x004c:
            r5 = 16
        L_0x004e:
            r2 = r2 | r5
            goto L_0x0052
        L_0x0050:
            r4 = r24
        L_0x0052:
            r5 = r31 & 4
            if (r5 == 0) goto L_0x0059
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x006c
        L_0x0059:
            r6 = r11 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x006c
            r6 = r25
            boolean r7 = r0.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0068
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r7 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r2 = r2 | r7
            goto L_0x006e
        L_0x006c:
            r6 = r25
        L_0x006e:
            r7 = r31 & 8
            if (r7 == 0) goto L_0x0075
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0075:
            r8 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0088
            r8 = r26
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0084
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0086
        L_0x0084:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0086:
            r2 = r2 | r9
            goto L_0x008a
        L_0x0088:
            r8 = r26
        L_0x008a:
            r9 = r31 & 16
            r12 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x0094
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a7
        L_0x0094:
            r13 = r11 & r12
            if (r13 != 0) goto L_0x00a7
            r13 = r27
            boolean r14 = r0.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00a3
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a5
        L_0x00a3:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x00a5:
            r2 = r2 | r14
            goto L_0x00a9
        L_0x00a7:
            r13 = r27
        L_0x00a9:
            r14 = r31 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r14 == 0) goto L_0x00b3
            r14 = 196608(0x30000, float:2.75506E-40)
        L_0x00b1:
            r2 = r2 | r14
            goto L_0x00c3
        L_0x00b3:
            r14 = r11 & r15
            if (r14 != 0) goto L_0x00c3
            boolean r14 = r0.changed((java.lang.Object) r10)
            if (r14 == 0) goto L_0x00c0
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00c0:
            r14 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b1
        L_0x00c3:
            r14 = 374491(0x5b6db, float:5.24774E-40)
            r14 = r14 & r2
            r16 = 74898(0x12492, float:1.04954E-40)
            r14 = r14 ^ r16
            if (r14 != 0) goto L_0x00de
            boolean r14 = r0.getSkipping()
            if (r14 != 0) goto L_0x00d5
            goto L_0x00de
        L_0x00d5:
            r0.skipToGroupEnd()
            r2 = r4
            r3 = r6
            r4 = r8
            r5 = r13
            goto L_0x015f
        L_0x00de:
            if (r3 == 0) goto L_0x00e6
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r14 = r3
            goto L_0x00e7
        L_0x00e6:
            r14 = r4
        L_0x00e7:
            r3 = 0
            r4 = 3
            r15 = 0
            if (r5 == 0) goto L_0x0107
            androidx.compose.animation.EnterTransition r5 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r15, r3, r4, r15)
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 15
            r21 = 0
            androidx.compose.animation.EnterTransition r6 = androidx.compose.animation.EnterExitTransitionKt.expandIn$default(r16, r17, r18, r19, r20, r21)
            androidx.compose.animation.EnterTransition r5 = r5.plus(r6)
            r16 = r5
            goto L_0x0109
        L_0x0107:
            r16 = r6
        L_0x0109:
            if (r7 == 0) goto L_0x0125
            androidx.compose.animation.ExitTransition r3 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r15, r3, r4, r15)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 15
            r22 = 0
            androidx.compose.animation.ExitTransition r4 = androidx.compose.animation.EnterExitTransitionKt.shrinkOut$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.ExitTransition r3 = r3.plus(r4)
            r15 = r3
            goto L_0x0126
        L_0x0125:
            r15 = r8
        L_0x0126:
            if (r9 == 0) goto L_0x012b
            java.lang.String r3 = "AnimatedVisibility"
            r13 = r3
        L_0x012b:
            int r3 = androidx.compose.animation.core.MutableTransitionState.$stable
            r4 = r2 & 14
            r3 = r3 | r4
            int r4 = r2 >> 9
            r4 = r4 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            r4 = 0
            androidx.compose.animation.core.Transition r3 = androidx.compose.animation.core.TransitionKt.updateTransition(r1, (java.lang.String) r13, (androidx.compose.runtime.Composer) r0, (int) r3, (int) r4)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7 r4 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7.INSTANCE
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            int r5 = r2 << 3
            r6 = r5 & 896(0x380, float:1.256E-42)
            r6 = r6 | 48
            r7 = r5 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | r7
            r5 = r5 & r12
            r5 = r5 | r6
            r6 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r6
            r9 = r5 | r2
            r2 = r3
            r3 = r4
            r4 = r14
            r5 = r16
            r6 = r15
            r7 = r28
            r8 = r0
            AnimatedEnterExitImpl(r2, r3, r4, r5, r6, r7, r8, r9)
            r5 = r13
            r2 = r14
            r4 = r15
            r3 = r16
        L_0x015f:
            androidx.compose.runtime.ScopeUpdateScope r9 = r0.endRestartGroup()
            if (r9 != 0) goto L_0x0166
            goto L_0x0179
        L_0x0166:
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$8 r12 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$8
            r0 = r12
            r1 = r23
            r6 = r28
            r7 = r30
            r8 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r9.updateScope(r12)
        L_0x0179:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.animation.core.MutableTransitionState, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(androidx.compose.foundation.layout.RowScope r24, androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean> r25, androidx.compose.ui.Modifier r26, androidx.compose.animation.EnterTransition r27, androidx.compose.animation.ExitTransition r28, java.lang.String r29, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r2 = r25
            r11 = r30
            r12 = r32
            java.lang.String r0 = "<this>"
            r1 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "visibleState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 1844988552(0x6df84a88, float:9.605298E27)
            r3 = r31
            androidx.compose.runtime.Composer r0 = r3.startRestartGroup(r0)
            java.lang.String r3 = "C(AnimatedVisibility)P(5,4,1,2,3)455@24987L37,456@25029L73:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            r3 = r33 & 1
            if (r3 == 0) goto L_0x002d
            r3 = r12 | 48
            goto L_0x003f
        L_0x002d:
            r3 = r12 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x003e
            boolean r3 = r0.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x003a
            r3 = 32
            goto L_0x003c
        L_0x003a:
            r3 = 16
        L_0x003c:
            r3 = r3 | r12
            goto L_0x003f
        L_0x003e:
            r3 = r12
        L_0x003f:
            r4 = r33 & 2
            if (r4 == 0) goto L_0x0046
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0059
        L_0x0046:
            r5 = r12 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0059
            r5 = r26
            boolean r6 = r0.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0055
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0057
        L_0x0055:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0057:
            r3 = r3 | r6
            goto L_0x005b
        L_0x0059:
            r5 = r26
        L_0x005b:
            r6 = r33 & 4
            if (r6 == 0) goto L_0x0062
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0075
        L_0x0062:
            r7 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0075
            r7 = r27
            boolean r8 = r0.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0071
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0073
        L_0x0071:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0073:
            r3 = r3 | r8
            goto L_0x0077
        L_0x0075:
            r7 = r27
        L_0x0077:
            r8 = r33 & 8
            r9 = 57344(0xe000, float:8.0356E-41)
            if (r8 == 0) goto L_0x0081
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0094
        L_0x0081:
            r10 = r12 & r9
            if (r10 != 0) goto L_0x0094
            r10 = r28
            boolean r13 = r0.changed((java.lang.Object) r10)
            if (r13 == 0) goto L_0x0090
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0092
        L_0x0090:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0092:
            r3 = r3 | r13
            goto L_0x0096
        L_0x0094:
            r10 = r28
        L_0x0096:
            r13 = r33 & 16
            r14 = 458752(0x70000, float:6.42848E-40)
            if (r13 == 0) goto L_0x00a0
            r15 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r15
            goto L_0x00b4
        L_0x00a0:
            r15 = r12 & r14
            if (r15 != 0) goto L_0x00b4
            r15 = r29
            boolean r16 = r0.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00af
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00af:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r3 = r3 | r16
            goto L_0x00b6
        L_0x00b4:
            r15 = r29
        L_0x00b6:
            r16 = r33 & 32
            if (r16 == 0) goto L_0x00bf
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00bc:
            r3 = r3 | r16
            goto L_0x00d1
        L_0x00bf:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x00d1
            boolean r16 = r0.changed((java.lang.Object) r11)
            if (r16 == 0) goto L_0x00ce
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00bc
        L_0x00ce:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00bc
        L_0x00d1:
            r16 = 2995921(0x2db6d1, float:4.19818E-39)
            r16 = r3 & r16
            r17 = 599184(0x92490, float:8.39636E-40)
            r16 = r16 ^ r17
            if (r16 != 0) goto L_0x00ed
            boolean r16 = r0.getSkipping()
            if (r16 != 0) goto L_0x00e4
            goto L_0x00ed
        L_0x00e4:
            r0.skipToGroupEnd()
            r3 = r5
            r4 = r7
            r5 = r10
            r6 = r15
            goto L_0x0172
        L_0x00ed:
            if (r4 == 0) goto L_0x00f6
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            r16 = r4
            goto L_0x00f8
        L_0x00f6:
            r16 = r5
        L_0x00f8:
            r4 = 0
            r5 = 3
            r14 = 0
            if (r6 == 0) goto L_0x0118
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 15
            r22 = 0
            androidx.compose.animation.EnterTransition r6 = androidx.compose.animation.EnterExitTransitionKt.expandHorizontally$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.EnterTransition r7 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r14, r4, r5, r14)
            androidx.compose.animation.EnterTransition r6 = r6.plus(r7)
            r17 = r6
            goto L_0x011a
        L_0x0118:
            r17 = r7
        L_0x011a:
            if (r8 == 0) goto L_0x0136
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 15
            r23 = 0
            androidx.compose.animation.ExitTransition r6 = androidx.compose.animation.EnterExitTransitionKt.shrinkHorizontally$default(r18, r19, r20, r21, r22, r23)
            androidx.compose.animation.ExitTransition r4 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r14, r4, r5, r14)
            androidx.compose.animation.ExitTransition r4 = r6.plus(r4)
            r14 = r4
            goto L_0x0137
        L_0x0136:
            r14 = r10
        L_0x0137:
            if (r13 == 0) goto L_0x013c
            java.lang.String r4 = "AnimatedVisibility"
            r15 = r4
        L_0x013c:
            int r4 = androidx.compose.animation.core.MutableTransitionState.$stable
            int r5 = r3 >> 3
            r6 = r5 & 14
            r4 = r4 | r6
            int r6 = r3 >> 12
            r6 = r6 & 112(0x70, float:1.57E-43)
            r4 = r4 | r6
            r6 = 0
            androidx.compose.animation.core.Transition r4 = androidx.compose.animation.core.TransitionKt.updateTransition(r2, (java.lang.String) r15, (androidx.compose.runtime.Composer) r0, (int) r4, (int) r6)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9 r6 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9.INSTANCE
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r7 = r3 & 896(0x380, float:1.256E-42)
            r7 = r7 | 48
            r8 = r3 & 7168(0x1c00, float:1.0045E-41)
            r7 = r7 | r8
            r3 = r3 & r9
            r3 = r3 | r7
            r7 = 458752(0x70000, float:6.42848E-40)
            r5 = r5 & r7
            r10 = r3 | r5
            r3 = r4
            r4 = r6
            r5 = r16
            r6 = r17
            r7 = r14
            r8 = r30
            r9 = r0
            AnimatedEnterExitImpl(r3, r4, r5, r6, r7, r8, r9, r10)
            r5 = r14
            r6 = r15
            r3 = r16
            r4 = r17
        L_0x0172:
            androidx.compose.runtime.ScopeUpdateScope r10 = r0.endRestartGroup()
            if (r10 != 0) goto L_0x0179
            goto L_0x018e
        L_0x0179:
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$10 r13 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$10
            r0 = r13
            r1 = r24
            r2 = r25
            r7 = r30
            r8 = r32
            r9 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r10.updateScope(r13)
        L_0x018e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.foundation.layout.RowScope, androidx.compose.animation.core.MutableTransitionState, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(androidx.compose.foundation.layout.ColumnScope r24, androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean> r25, androidx.compose.ui.Modifier r26, androidx.compose.animation.EnterTransition r27, androidx.compose.animation.ExitTransition r28, java.lang.String r29, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r2 = r25
            r11 = r30
            r12 = r32
            java.lang.String r0 = "<this>"
            r1 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "visibleState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 1844992995(0x6df85be3, float:9.607921E27)
            r3 = r31
            androidx.compose.runtime.Composer r0 = r3.startRestartGroup(r0)
            java.lang.String r3 = "C(AnimatedVisibility)P(5,4,1,2,3)531@29429L37,532@29471L73:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            r3 = r33 & 1
            if (r3 == 0) goto L_0x002d
            r3 = r12 | 48
            goto L_0x003f
        L_0x002d:
            r3 = r12 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x003e
            boolean r3 = r0.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x003a
            r3 = 32
            goto L_0x003c
        L_0x003a:
            r3 = 16
        L_0x003c:
            r3 = r3 | r12
            goto L_0x003f
        L_0x003e:
            r3 = r12
        L_0x003f:
            r4 = r33 & 2
            if (r4 == 0) goto L_0x0046
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0059
        L_0x0046:
            r5 = r12 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0059
            r5 = r26
            boolean r6 = r0.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0055
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0057
        L_0x0055:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0057:
            r3 = r3 | r6
            goto L_0x005b
        L_0x0059:
            r5 = r26
        L_0x005b:
            r6 = r33 & 4
            if (r6 == 0) goto L_0x0062
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0075
        L_0x0062:
            r7 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0075
            r7 = r27
            boolean r8 = r0.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0071
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0073
        L_0x0071:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0073:
            r3 = r3 | r8
            goto L_0x0077
        L_0x0075:
            r7 = r27
        L_0x0077:
            r8 = r33 & 8
            r9 = 57344(0xe000, float:8.0356E-41)
            if (r8 == 0) goto L_0x0081
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0094
        L_0x0081:
            r10 = r12 & r9
            if (r10 != 0) goto L_0x0094
            r10 = r28
            boolean r13 = r0.changed((java.lang.Object) r10)
            if (r13 == 0) goto L_0x0090
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0092
        L_0x0090:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0092:
            r3 = r3 | r13
            goto L_0x0096
        L_0x0094:
            r10 = r28
        L_0x0096:
            r13 = r33 & 16
            r14 = 458752(0x70000, float:6.42848E-40)
            if (r13 == 0) goto L_0x00a0
            r15 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r15
            goto L_0x00b4
        L_0x00a0:
            r15 = r12 & r14
            if (r15 != 0) goto L_0x00b4
            r15 = r29
            boolean r16 = r0.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00af
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00af:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r3 = r3 | r16
            goto L_0x00b6
        L_0x00b4:
            r15 = r29
        L_0x00b6:
            r16 = r33 & 32
            if (r16 == 0) goto L_0x00bf
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00bc:
            r3 = r3 | r16
            goto L_0x00d1
        L_0x00bf:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x00d1
            boolean r16 = r0.changed((java.lang.Object) r11)
            if (r16 == 0) goto L_0x00ce
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00bc
        L_0x00ce:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00bc
        L_0x00d1:
            r16 = 2995921(0x2db6d1, float:4.19818E-39)
            r16 = r3 & r16
            r17 = 599184(0x92490, float:8.39636E-40)
            r16 = r16 ^ r17
            if (r16 != 0) goto L_0x00ed
            boolean r16 = r0.getSkipping()
            if (r16 != 0) goto L_0x00e4
            goto L_0x00ed
        L_0x00e4:
            r0.skipToGroupEnd()
            r3 = r5
            r4 = r7
            r5 = r10
            r6 = r15
            goto L_0x0172
        L_0x00ed:
            if (r4 == 0) goto L_0x00f6
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            r16 = r4
            goto L_0x00f8
        L_0x00f6:
            r16 = r5
        L_0x00f8:
            r4 = 0
            r5 = 3
            r14 = 0
            if (r6 == 0) goto L_0x0118
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 15
            r22 = 0
            androidx.compose.animation.EnterTransition r6 = androidx.compose.animation.EnterExitTransitionKt.expandVertically$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.EnterTransition r7 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r14, r4, r5, r14)
            androidx.compose.animation.EnterTransition r6 = r6.plus(r7)
            r17 = r6
            goto L_0x011a
        L_0x0118:
            r17 = r7
        L_0x011a:
            if (r8 == 0) goto L_0x0136
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 15
            r23 = 0
            androidx.compose.animation.ExitTransition r6 = androidx.compose.animation.EnterExitTransitionKt.shrinkVertically$default(r18, r19, r20, r21, r22, r23)
            androidx.compose.animation.ExitTransition r4 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r14, r4, r5, r14)
            androidx.compose.animation.ExitTransition r4 = r6.plus(r4)
            r14 = r4
            goto L_0x0137
        L_0x0136:
            r14 = r10
        L_0x0137:
            if (r13 == 0) goto L_0x013c
            java.lang.String r4 = "AnimatedVisibility"
            r15 = r4
        L_0x013c:
            int r4 = androidx.compose.animation.core.MutableTransitionState.$stable
            int r5 = r3 >> 3
            r6 = r5 & 14
            r4 = r4 | r6
            int r6 = r3 >> 12
            r6 = r6 & 112(0x70, float:1.57E-43)
            r4 = r4 | r6
            r6 = 0
            androidx.compose.animation.core.Transition r4 = androidx.compose.animation.core.TransitionKt.updateTransition(r2, (java.lang.String) r15, (androidx.compose.runtime.Composer) r0, (int) r4, (int) r6)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11 r6 = androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11.INSTANCE
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r7 = r3 & 896(0x380, float:1.256E-42)
            r7 = r7 | 48
            r8 = r3 & 7168(0x1c00, float:1.0045E-41)
            r7 = r7 | r8
            r3 = r3 & r9
            r3 = r3 | r7
            r7 = 458752(0x70000, float:6.42848E-40)
            r5 = r5 & r7
            r10 = r3 | r5
            r3 = r4
            r4 = r6
            r5 = r16
            r6 = r17
            r7 = r14
            r8 = r30
            r9 = r0
            AnimatedEnterExitImpl(r3, r4, r5, r6, r7, r8, r9, r10)
            r5 = r14
            r6 = r15
            r3 = r16
            r4 = r17
        L_0x0172:
            androidx.compose.runtime.ScopeUpdateScope r10 = r0.endRestartGroup()
            if (r10 != 0) goto L_0x0179
            goto L_0x018e
        L_0x0179:
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$12 r13 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$12
            r0 = r13
            r1 = r24
            r2 = r25
            r7 = r30
            r8 = r32
            r9 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r10.updateScope(r13)
        L_0x018e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.foundation.layout.ColumnScope, androidx.compose.animation.core.MutableTransitionState, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    @androidx.compose.animation.ExperimentalAnimationApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void AnimatedVisibility(androidx.compose.animation.core.Transition<T> r23, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r24, androidx.compose.ui.Modifier r25, androidx.compose.animation.EnterTransition r26, androidx.compose.animation.ExitTransition r27, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r8 = r23
            r9 = r24
            r10 = r28
            r11 = r30
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "visible"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 1844997449(0x6df86d49, float:9.61055E27)
            r1 = r29
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(AnimatedVisibility)P(4,3,1,2)605@33789L68:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r31 & r0
            if (r0 == 0) goto L_0x002f
            r0 = r11 | 6
            goto L_0x003f
        L_0x002f:
            r0 = r11 & 14
            if (r0 != 0) goto L_0x003e
            boolean r0 = r12.changed((java.lang.Object) r8)
            if (r0 == 0) goto L_0x003b
            r0 = 4
            goto L_0x003c
        L_0x003b:
            r0 = 2
        L_0x003c:
            r0 = r0 | r11
            goto L_0x003f
        L_0x003e:
            r0 = r11
        L_0x003f:
            r1 = r31 & 1
            if (r1 == 0) goto L_0x0046
            r0 = r0 | 48
            goto L_0x0056
        L_0x0046:
            r1 = r11 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x0056
            boolean r1 = r12.changed((java.lang.Object) r9)
            if (r1 == 0) goto L_0x0053
            r1 = 32
            goto L_0x0055
        L_0x0053:
            r1 = 16
        L_0x0055:
            r0 = r0 | r1
        L_0x0056:
            r1 = r31 & 2
            if (r1 == 0) goto L_0x005d
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0070
        L_0x005d:
            r2 = r11 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0070
            r2 = r25
            boolean r3 = r12.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x006c
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r3 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r0 = r0 | r3
            goto L_0x0072
        L_0x0070:
            r2 = r25
        L_0x0072:
            r3 = r31 & 4
            if (r3 == 0) goto L_0x0079
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x008c
        L_0x0079:
            r4 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x008c
            r4 = r26
            boolean r5 = r12.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0088
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x008a
        L_0x0088:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x008a:
            r0 = r0 | r5
            goto L_0x008e
        L_0x008c:
            r4 = r26
        L_0x008e:
            r5 = r31 & 8
            r6 = 57344(0xe000, float:8.0356E-41)
            if (r5 == 0) goto L_0x0098
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00ab
        L_0x0098:
            r7 = r11 & r6
            if (r7 != 0) goto L_0x00ab
            r7 = r27
            boolean r13 = r12.changed((java.lang.Object) r7)
            if (r13 == 0) goto L_0x00a7
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a9
        L_0x00a7:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x00a9:
            r0 = r0 | r13
            goto L_0x00ad
        L_0x00ab:
            r7 = r27
        L_0x00ad:
            r13 = r31 & 16
            r14 = 458752(0x70000, float:6.42848E-40)
            if (r13 == 0) goto L_0x00b7
            r13 = 196608(0x30000, float:2.75506E-40)
        L_0x00b5:
            r0 = r0 | r13
            goto L_0x00c7
        L_0x00b7:
            r13 = r11 & r14
            if (r13 != 0) goto L_0x00c7
            boolean r13 = r12.changed((java.lang.Object) r10)
            if (r13 == 0) goto L_0x00c4
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00c4:
            r13 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b5
        L_0x00c7:
            r13 = 374491(0x5b6db, float:5.24774E-40)
            r13 = r13 & r0
            r15 = 74898(0x12492, float:1.04954E-40)
            r13 = r13 ^ r15
            if (r13 != 0) goto L_0x00df
            boolean r13 = r12.getSkipping()
            if (r13 != 0) goto L_0x00d8
            goto L_0x00df
        L_0x00d8:
            r12.skipToGroupEnd()
            r3 = r2
            r5 = r7
            goto L_0x014a
        L_0x00df:
            if (r1 == 0) goto L_0x00e7
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r13 = r1
            goto L_0x00e8
        L_0x00e7:
            r13 = r2
        L_0x00e8:
            r1 = 3
            r2 = 0
            r15 = 0
            if (r3 == 0) goto L_0x0108
            androidx.compose.animation.EnterTransition r3 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r15, r2, r1, r15)
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 15
            r21 = 0
            androidx.compose.animation.EnterTransition r4 = androidx.compose.animation.EnterExitTransitionKt.expandIn$default(r16, r17, r18, r19, r20, r21)
            androidx.compose.animation.EnterTransition r3 = r3.plus(r4)
            r16 = r3
            goto L_0x010a
        L_0x0108:
            r16 = r4
        L_0x010a:
            if (r5 == 0) goto L_0x0126
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 15
            r22 = 0
            androidx.compose.animation.ExitTransition r3 = androidx.compose.animation.EnterExitTransitionKt.shrinkOut$default(r17, r18, r19, r20, r21, r22)
            androidx.compose.animation.ExitTransition r1 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r15, r2, r1, r15)
            androidx.compose.animation.ExitTransition r1 = r3.plus(r1)
            r15 = r1
            goto L_0x0127
        L_0x0126:
            r15 = r7
        L_0x0127:
            r1 = r0 & 14
            r2 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r0 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = r0 & r6
            r1 = r1 | r2
            r0 = r0 & r14
            r7 = r1 | r0
            r0 = r23
            r1 = r24
            r2 = r13
            r3 = r16
            r4 = r15
            r5 = r28
            r6 = r12
            AnimatedEnterExitImpl(r0, r1, r2, r3, r4, r5, r6, r7)
            r3 = r13
            r5 = r15
            r4 = r16
        L_0x014a:
            androidx.compose.runtime.ScopeUpdateScope r12 = r12.endRestartGroup()
            if (r12 != 0) goto L_0x0151
            goto L_0x0166
        L_0x0151:
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$13 r13 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$13
            r0 = r13
            r1 = r23
            r2 = r24
            r6 = r28
            r7 = r30
            r8 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x0166:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.animation.core.Transition, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    @androidx.compose.animation.ExperimentalAnimationApi
    @kotlin.Deprecated(message = "AnimatedVisibility no longer accepts initiallyVisible as a parameter, please use AnimatedVisibility(MutableTransitionState, Modifier, ...) API instead", replaceWith = @kotlin.ReplaceWith(expression = "AnimatedVisibility(transitionState = remember { MutableTransitionState(initiallyVisible) }\n.apply { targetState = visible },\nmodifier = modifier,\nenter = enter,\nexit = exit) {\ncontent() \n}", imports = {"androidx.compose.animation.core.MutableTransitionState"}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AnimatedVisibility(boolean r17, androidx.compose.ui.Modifier r18, androidx.compose.animation.EnterTransition r19, androidx.compose.animation.ExitTransition r20, boolean r21, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            r9 = r19
            r10 = r20
            r11 = r22
            r12 = r24
            java.lang.String r0 = "enter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "exit"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 1845002287(0x6df8802f, float:9.613406E27)
            r1 = r23
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(AnimatedVisibility)P(5,4,1,2,3)*707@38596L53,706@38557L214:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            r0 = r25 & 1
            if (r0 == 0) goto L_0x002e
            r0 = r12 | 6
            r14 = r17
            goto L_0x0040
        L_0x002e:
            r0 = r12 & 14
            r14 = r17
            if (r0 != 0) goto L_0x003f
            boolean r0 = r13.changed((boolean) r14)
            if (r0 == 0) goto L_0x003c
            r0 = 4
            goto L_0x003d
        L_0x003c:
            r0 = 2
        L_0x003d:
            r0 = r0 | r12
            goto L_0x0040
        L_0x003f:
            r0 = r12
        L_0x0040:
            r1 = r25 & 2
            if (r1 == 0) goto L_0x0047
            r0 = r0 | 48
            goto L_0x005a
        L_0x0047:
            r2 = r12 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x005a
            r2 = r18
            boolean r3 = r13.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0056
            r3 = 32
            goto L_0x0058
        L_0x0056:
            r3 = 16
        L_0x0058:
            r0 = r0 | r3
            goto L_0x005c
        L_0x005a:
            r2 = r18
        L_0x005c:
            r3 = r25 & 4
            if (r3 == 0) goto L_0x0063
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0073
        L_0x0063:
            r3 = r12 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0073
            boolean r3 = r13.changed((java.lang.Object) r9)
            if (r3 == 0) goto L_0x0070
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0072
        L_0x0070:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0072:
            r0 = r0 | r3
        L_0x0073:
            r3 = r25 & 8
            if (r3 == 0) goto L_0x007a
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x008a
        L_0x007a:
            r3 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x008a
            boolean r3 = r13.changed((java.lang.Object) r10)
            if (r3 == 0) goto L_0x0087
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x0089
        L_0x0087:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x0089:
            r0 = r0 | r3
        L_0x008a:
            r3 = r25 & 16
            if (r3 == 0) goto L_0x0093
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r15 = r21
            goto L_0x00a7
        L_0x0093:
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r12
            r15 = r21
            if (r3 != 0) goto L_0x00a7
            boolean r3 = r13.changed((boolean) r15)
            if (r3 == 0) goto L_0x00a4
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a6
        L_0x00a4:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x00a6:
            r0 = r0 | r3
        L_0x00a7:
            r3 = r25 & 32
            r4 = 196608(0x30000, float:2.75506E-40)
            if (r3 == 0) goto L_0x00af
            r0 = r0 | r4
            goto L_0x00c0
        L_0x00af:
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r12
            if (r3 != 0) goto L_0x00c0
            boolean r3 = r13.changed((java.lang.Object) r11)
            if (r3 == 0) goto L_0x00bd
            r3 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bf
        L_0x00bd:
            r3 = 65536(0x10000, float:9.18355E-41)
        L_0x00bf:
            r0 = r0 | r3
        L_0x00c0:
            r3 = 374491(0x5b6db, float:5.24774E-40)
            r3 = r3 & r0
            r5 = 74898(0x12492, float:1.04954E-40)
            r3 = r3 ^ r5
            if (r3 != 0) goto L_0x00d5
            boolean r3 = r13.getSkipping()
            if (r3 != 0) goto L_0x00d1
            goto L_0x00d5
        L_0x00d1:
            r13.skipToGroupEnd()
            goto L_0x013e
        L_0x00d5:
            if (r1 == 0) goto L_0x00de
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r16 = r1
            goto L_0x00e0
        L_0x00de:
            r16 = r2
        L_0x00e0:
            r1 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r13.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            java.lang.Object r1 = r13.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0103
            androidx.compose.animation.core.MutableTransitionState r1 = new androidx.compose.animation.core.MutableTransitionState
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r21)
            r1.<init>(r2)
            r13.updateRememberedValue(r1)
        L_0x0103:
            r13.endReplaceableGroup()
            androidx.compose.animation.core.MutableTransitionState r1 = (androidx.compose.animation.core.MutableTransitionState) r1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r17)
            r1.setTargetState(r2)
            r5 = 0
            r2 = -819858964(0xffffffffcf21f1ec, float:-2.71698637E9)
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$16 r3 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$16
            r3.<init>(r11, r0)
            r6 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r2, r6, r3)
            r6 = r2
            kotlin.jvm.functions.Function3 r6 = (kotlin.jvm.functions.Function3) r6
            int r2 = androidx.compose.animation.core.MutableTransitionState.$stable
            r2 = r2 | r4
            r3 = r0 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            r3 = r0 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r7 = r2 | r0
            r8 = 16
            r0 = r1
            r1 = r16
            r2 = r19
            r3 = r20
            r4 = r5
            r5 = r6
            r6 = r13
            AnimatedVisibility((androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean>) r0, (androidx.compose.ui.Modifier) r1, (androidx.compose.animation.EnterTransition) r2, (androidx.compose.animation.ExitTransition) r3, (java.lang.String) r4, (kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r5, (androidx.compose.runtime.Composer) r6, (int) r7, (int) r8)
            r2 = r16
        L_0x013e:
            androidx.compose.runtime.ScopeUpdateScope r13 = r13.endRestartGroup()
            if (r13 != 0) goto L_0x0145
            goto L_0x0161
        L_0x0145:
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$17 r16 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$17
            r0 = r16
            r1 = r17
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            r7 = r24
            r8 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x0161:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(boolean, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void AnimatedEnterExitImpl(androidx.compose.animation.core.Transition<T> r18, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r19, androidx.compose.ui.Modifier r20, androidx.compose.animation.EnterTransition r21, androidx.compose.animation.ExitTransition r22, kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, int r25) {
        /*
            r6 = r18
            r7 = r19
            r8 = r20
            r9 = r23
            r10 = r25
            r0 = -918810774(0xffffffffc93c0f6a, float:-770294.6)
            r1 = r24
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(AnimatedEnterExitImpl)P(4,5,3,1,2)732@39290L85,737@39513L116,741@39671L270,741@39639L302,750@39951L165:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            r0 = r10 & 14
            r1 = 2
            if (r0 != 0) goto L_0x0028
            boolean r0 = r15.changed((java.lang.Object) r6)
            if (r0 == 0) goto L_0x0025
            r0 = 4
            goto L_0x0026
        L_0x0025:
            r0 = 2
        L_0x0026:
            r0 = r0 | r10
            goto L_0x0029
        L_0x0028:
            r0 = r10
        L_0x0029:
            r2 = r10 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0039
            boolean r2 = r15.changed((java.lang.Object) r7)
            if (r2 == 0) goto L_0x0036
            r2 = 32
            goto L_0x0038
        L_0x0036:
            r2 = 16
        L_0x0038:
            r0 = r0 | r2
        L_0x0039:
            r2 = r10 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0049
            boolean r2 = r15.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x0046
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0048
        L_0x0046:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0048:
            r0 = r0 | r2
        L_0x0049:
            r2 = r10 & 7168(0x1c00, float:1.0045E-41)
            r14 = r21
            if (r2 != 0) goto L_0x005b
            boolean r2 = r15.changed((java.lang.Object) r14)
            if (r2 == 0) goto L_0x0058
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x005a
        L_0x0058:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x005a:
            r0 = r0 | r2
        L_0x005b:
            r11 = 57344(0xe000, float:8.0356E-41)
            r2 = r10 & r11
            r13 = r22
            if (r2 != 0) goto L_0x0070
            boolean r2 = r15.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x006d
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x006f
        L_0x006d:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x006f:
            r0 = r0 | r2
        L_0x0070:
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r10
            if (r2 != 0) goto L_0x0081
            boolean r2 = r15.changed((java.lang.Object) r9)
            if (r2 == 0) goto L_0x007e
            r2 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0080
        L_0x007e:
            r2 = 65536(0x10000, float:9.18355E-41)
        L_0x0080:
            r0 = r0 | r2
        L_0x0081:
            r12 = r0
            r0 = 374491(0x5b6db, float:5.24774E-40)
            r0 = r0 & r12
            r2 = 74898(0x12492, float:1.04954E-40)
            r0 = r0 ^ r2
            if (r0 != 0) goto L_0x0099
            boolean r0 = r15.getSkipping()
            if (r0 != 0) goto L_0x0093
            goto L_0x0099
        L_0x0093:
            r15.skipToGroupEnd()
        L_0x0096:
            r2 = r15
            goto L_0x0304
        L_0x0099:
            r0 = r12 & 14
            r5 = -3686930(0xffffffffffc7bdee, float:NaN)
            r15.startReplaceableGroup(r5)
            java.lang.String r4 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r4)
            boolean r2 = r15.changed((java.lang.Object) r6)
            java.lang.Object r3 = r15.rememberedValue()
            r11 = 0
            if (r2 != 0) goto L_0x00b9
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x00c8
        L_0x00b9:
            java.lang.Object r2 = r18.getCurrentState()
            java.lang.Object r2 = r7.invoke(r2)
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r11, r1, r11)
            r15.updateRememberedValue(r3)
        L_0x00c8:
            r15.endReplaceableGroup()
            androidx.compose.runtime.MutableState r3 = (androidx.compose.runtime.MutableState) r3
            java.lang.Object r1 = r18.getTargetState()
            java.lang.Object r1 = r7.invoke(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x00ef
            java.lang.Object r1 = r3.getValue()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x00ef
            boolean r1 = r18.isSeeking()
            if (r1 == 0) goto L_0x0096
        L_0x00ef:
            r1 = r0 | 48
            r2 = 1117107336(0x4295b488, float:74.8526)
            r15.startReplaceableGroup(r2)
            java.lang.String r2 = "C(createChildTransition)772@30334L36,773@30394L74,774@30491L39,775@30542L63:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = r1 & 14
            r15.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r4)
            boolean r16 = r15.changed((java.lang.Object) r6)
            java.lang.Object r5 = r15.rememberedValue()
            if (r16 != 0) goto L_0x0116
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r16.getEmpty()
            if (r5 != r11) goto L_0x011d
        L_0x0116:
            java.lang.Object r5 = r18.getCurrentState()
            r15.updateRememberedValue(r5)
        L_0x011d:
            r15.endReplaceableGroup()
            boolean r11 = r18.isSeeking()
            if (r11 == 0) goto L_0x012a
            java.lang.Object r5 = r18.getCurrentState()
        L_0x012a:
            int r11 = r1 >> 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            r16 = r3
            r3 = -174039129(0xfffffffff5a05fa7, float:-4.065955E32)
            r15.startReplaceableGroup(r3)
            java.lang.String r3 = "C738@39591L28:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r3)
            r17 = r12 & 112(0x70, float:1.57E-43)
            r0 = r0 | r17
            int r11 = r11 << 6
            r11 = r11 & 896(0x380, float:1.256E-42)
            r0 = r0 | r11
            androidx.compose.animation.EnterExitState r5 = targetEnterExit(r6, r7, r5, r15, r0)
            r15.endReplaceableGroup()
            java.lang.Object r11 = r18.getTargetState()
            r17 = r4
            r4 = -174039129(0xfffffffff5a05fa7, float:-4.065955E32)
            r15.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r3)
            androidx.compose.animation.EnterExitState r3 = targetEnterExit(r6, r7, r11, r15, r0)
            r15.endReplaceableGroup()
            int r0 = r1 << 6
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r11 = r2 | r0
            java.lang.String r4 = "EnterExitTransition"
            r0 = r18
            r1 = r5
            r2 = r3
            r5 = r16
            r3 = r4
            r6 = r17
            r4 = r15
            r7 = r5
            r10 = -3686930(0xffffffffffc7bdee, float:NaN)
            r5 = r11
            androidx.compose.animation.core.Transition r11 = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(r0, r1, r2, r3, r4, r5)
            r15.endReplaceableGroup()
            r0 = -3686552(0xffffffffffc7bf68, float:NaN)
            r15.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            boolean r0 = r15.changed((java.lang.Object) r11)
            boolean r1 = r15.changed((java.lang.Object) r7)
            r0 = r0 | r1
            java.lang.Object r1 = r15.rememberedValue()
            if (r0 != 0) goto L_0x01a1
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x01ad
        L_0x01a1:
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1 r0 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1
            r1 = 0
            r0.<init>(r11, r7, r1)
            r1 = r0
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r15.updateRememberedValue(r1)
        L_0x01ad:
            r15.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r0 = 0
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r11, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r1, (androidx.compose.runtime.Composer) r15, (int) r0)
            int r1 = r12 >> 3
            r2 = r1 & 112(0x70, float:1.57E-43)
            r3 = r1 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            r3 = r1 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r3
            r1 = r1 | r2
            r2 = -918809573(0xffffffffc93c141b, float:-770369.7)
            r15.startReplaceableGroup(r2)
            java.lang.String r2 = "C(AnimatedEnterExitImpl)P(4,3,1,2)775@40805L64,778@40977L39,779@41047L50,776@40878L229:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            java.lang.Object r2 = r11.getCurrentState()
            androidx.compose.animation.EnterExitState r3 = androidx.compose.animation.EnterExitState.Visible
            if (r2 == r3) goto L_0x01e4
            java.lang.Object r2 = r11.getTargetState()
            androidx.compose.animation.EnterExitState r3 = androidx.compose.animation.EnterExitState.Visible
            if (r2 != r3) goto L_0x01e1
            goto L_0x01e4
        L_0x01e1:
            r2 = r15
            goto L_0x0301
        L_0x01e4:
            r2 = r1 & 14
            r15.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r6)
            boolean r3 = r15.changed((java.lang.Object) r11)
            java.lang.Object r4 = r15.rememberedValue()
            if (r3 != 0) goto L_0x01fe
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x0206
        L_0x01fe:
            androidx.compose.animation.AnimatedVisibilityScopeImpl r4 = new androidx.compose.animation.AnimatedVisibilityScopeImpl
            r4.<init>(r11)
            r15.updateRememberedValue(r4)
        L_0x0206:
            r15.endReplaceableGroup()
            androidx.compose.animation.AnimatedVisibilityScopeImpl r4 = (androidx.compose.animation.AnimatedVisibilityScopeImpl) r4
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            int r3 = r1 >> 3
            r5 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r5
            r3 = r3 & 896(0x380, float:1.256E-42)
            r16 = r2 | r3
            java.lang.String r2 = "Built-in"
            r12 = r21
            r13 = r22
            r14 = r2
            r2 = r15
            androidx.compose.ui.Modifier r3 = androidx.compose.animation.EnterExitTransitionKt.createModifier(r11, r12, r13, r14, r15, r16)
            androidx.compose.ui.Modifier r3 = r8.then(r3)
            r5 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r2.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r5)
            java.lang.Object r5 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r5 != r6) goto L_0x0245
            androidx.compose.animation.AnimatedEnterExitMeasurePolicy r5 = new androidx.compose.animation.AnimatedEnterExitMeasurePolicy
            r5.<init>(r4)
            r2.updateRememberedValue(r5)
        L_0x0245:
            r2.endReplaceableGroup()
            androidx.compose.ui.layout.MeasurePolicy r5 = (androidx.compose.ui.layout.MeasurePolicy) r5
            r6 = 1376089335(0x520574f7, float:1.43298249E11)
            r2.startReplaceableGroup(r6)
            java.lang.String r6 = "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r7 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r10 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r7, r10)
            java.lang.Object r6 = r2.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r7, r10)
            java.lang.Object r7 = r2.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.materializerOf(r3)
            androidx.compose.runtime.Applier r11 = r2.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x0293
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0293:
            r2.startReusableNode()
            boolean r11 = r2.getInserting()
            if (r11 == 0) goto L_0x02a0
            r2.createNode(r10)
            goto L_0x02a3
        L_0x02a0:
            r2.useNode()
        L_0x02a3:
            r2.disableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m1543constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r5, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r6, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r7, r5)
            r2.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r5)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3.invoke(r5, r2, r0)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r0)
            r0 = -174037785(0xfffffffff5a064e7, float:-4.0664748E32)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "C777@40916L9:AnimatedVisibility.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            int r0 = r1 >> 9
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | 8
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.invoke(r4, r2, r0)
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
        L_0x0301:
            r2.endReplaceableGroup()
        L_0x0304:
            androidx.compose.runtime.ScopeUpdateScope r10 = r2.endRestartGroup()
            if (r10 != 0) goto L_0x030b
            goto L_0x0324
        L_0x030b:
            androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2 r11 = new androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2
            r0 = r11
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0324:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedEnterExitImpl(androidx.compose.animation.core.Transition, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int):void");
    }

    private static final void AnimatedEnterExitImpl(Transition<EnterExitState> transition, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i) {
        composer.startReplaceableGroup(-918809573);
        ComposerKt.sourceInformation(composer, "C(AnimatedEnterExitImpl)P(4,3,1,2)775@40805L64,778@40977L39,779@41047L50,776@40878L229:AnimatedVisibility.kt#xbi5r1");
        if (transition.getCurrentState() == EnterExitState.Visible || transition.getTargetState() == EnterExitState.Visible) {
            int i2 = i & 14;
            composer.startReplaceableGroup(-3686930);
            ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
            boolean changed = composer.changed((Object) transition);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new AnimatedVisibilityScopeImpl(transition);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl = (AnimatedVisibilityScopeImpl) rememberedValue;
            int i3 = i >> 3;
            Modifier then = modifier.then(EnterExitTransitionKt.createModifier(transition, enterTransition, exitTransition, "Built-in", composer, i2 | 3072 | (i3 & 112) | (i3 & 896)));
            composer.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceableGroup();
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue2;
            composer.startReplaceableGroup(1376089335);
            ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(then);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer r0 = Updater.m1543constructorimpl(composer);
            Updater.m1550setimpl(r0, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r0, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r0, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(-174037785);
            ComposerKt.sourceInformation(composer, "C777@40916L9:AnimatedVisibility.kt#xbi5r1");
            function3.invoke(animatedVisibilityScopeImpl, composer, Integer.valueOf(((i >> 9) & 112) | 8));
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
    }

    private static final <T> EnterExitState targetEnterExit(Transition<T> transition, Function1<? super T, Boolean> function1, T t, Composer composer, int i) {
        EnterExitState enterExitState;
        composer.startReplaceableGroup(-721837653);
        ComposerKt.sourceInformation(composer, "C(targetEnterExit)P(1):AnimatedVisibility.kt#xbi5r1");
        composer.startMovableGroup(-721837546, transition);
        ComposerKt.sourceInformation(composer, "844@43255L34");
        if (!transition.isSeeking()) {
            composer.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) rememberedValue;
            if (function1.invoke(transition.getCurrentState()).booleanValue()) {
                mutableState.setValue(true);
            }
            if (function1.invoke(t).booleanValue()) {
                enterExitState = EnterExitState.Visible;
            } else if (((Boolean) mutableState.getValue()).booleanValue()) {
                enterExitState = EnterExitState.PostExit;
            } else {
                enterExitState = EnterExitState.PreEnter;
            }
        } else if (function1.invoke(t).booleanValue()) {
            enterExitState = EnterExitState.Visible;
        } else if (function1.invoke(transition.getCurrentState()).booleanValue()) {
            enterExitState = EnterExitState.PostExit;
        } else {
            enterExitState = EnterExitState.PreEnter;
        }
        composer.endMovableGroup();
        composer.endReplaceableGroup();
        return enterExitState;
    }
}
