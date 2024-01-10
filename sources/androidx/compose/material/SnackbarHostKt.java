package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.work.WorkRequest;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0002\u0010\r\u001a:\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\t2\u0019\b\u0002\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0012\u001a9\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0003¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0003¢\u0006\u0002\u0010\u001e\u001a\u001e\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000*b\b\u0002\u0010%\"-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\u0002\b\f¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\f2-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\u0002\b\f¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\f¨\u0006("}, d2 = {"SnackbarFadeInMillis", "", "SnackbarFadeOutMillis", "SnackbarInBetweenDelayMillis", "FadeInFadeOutWithScale", "", "current", "Landroidx/compose/material/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material/SnackbarData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SnackbarHost", "hostState", "Landroidx/compose/material/SnackbarHostState;", "snackbar", "(Landroidx/compose/material/SnackbarHostState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animatedOpacity", "Landroidx/compose/runtime/State;", "", "animation", "Landroidx/compose/animation/core/AnimationSpec;", "visible", "", "onAnimationFinish", "Lkotlin/Function0;", "(Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animatedScale", "(Landroidx/compose/animation/core/AnimationSpec;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "toMillis", "", "Landroidx/compose/material/SnackbarDuration;", "hasAction", "accessibilityManager", "Landroidx/compose/ui/platform/AccessibilityManager;", "FadeInFadeOutTransition", "Lkotlin/ParameterName;", "name", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SnackbarHost.kt */
public final class SnackbarHostKt {
    private static final int SnackbarFadeInMillis = 150;
    private static final int SnackbarFadeOutMillis = 75;
    private static final int SnackbarInBetweenDelayMillis = 0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SnackbarHost.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SnackbarDuration.values().length];
            iArr[SnackbarDuration.Indefinite.ordinal()] = 1;
            iArr[SnackbarDuration.Long.ordinal()] = 2;
            iArr[SnackbarDuration.Short.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SnackbarHost(androidx.compose.material.SnackbarHostState r12, androidx.compose.ui.Modifier r13, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarData, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r14, androidx.compose.runtime.Composer r15, int r16, int r17) {
        /*
            r1 = r12
            r4 = r16
            java.lang.String r0 = "hostState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 431012348(0x19b0b9fc, float:1.8273092E-23)
            r2 = r15
            androidx.compose.runtime.Composer r0 = r15.startRestartGroup(r0)
            java.lang.String r2 = "C(SnackbarHost)156@6461L7,157@6473L340,167@6818L134:SnackbarHost.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r17 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r4 | 6
            goto L_0x002c
        L_0x001c:
            r2 = r4 & 14
            if (r2 != 0) goto L_0x002b
            boolean r2 = r0.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x0028
            r2 = 4
            goto L_0x0029
        L_0x0028:
            r2 = 2
        L_0x0029:
            r2 = r2 | r4
            goto L_0x002c
        L_0x002b:
            r2 = r4
        L_0x002c:
            r3 = r17 & 2
            if (r3 == 0) goto L_0x0033
            r2 = r2 | 48
            goto L_0x0045
        L_0x0033:
            r5 = r4 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0045
            r5 = r13
            boolean r6 = r0.changed((java.lang.Object) r13)
            if (r6 == 0) goto L_0x0041
            r6 = 32
            goto L_0x0043
        L_0x0041:
            r6 = 16
        L_0x0043:
            r2 = r2 | r6
            goto L_0x0046
        L_0x0045:
            r5 = r13
        L_0x0046:
            r6 = r17 & 4
            if (r6 == 0) goto L_0x004d
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004d:
            r7 = r4 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x005f
            r7 = r14
            boolean r8 = r0.changed((java.lang.Object) r14)
            if (r8 == 0) goto L_0x005b
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r2 = r2 | r8
            goto L_0x0060
        L_0x005f:
            r7 = r14
        L_0x0060:
            r8 = r2 & 731(0x2db, float:1.024E-42)
            r9 = 146(0x92, float:2.05E-43)
            if (r8 != r9) goto L_0x0073
            boolean r8 = r0.getSkipping()
            if (r8 != 0) goto L_0x006d
            goto L_0x0073
        L_0x006d:
            r0.skipToGroupEnd()
            r2 = r5
            r3 = r7
            goto L_0x00c0
        L_0x0073:
            if (r3 == 0) goto L_0x007a
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x007b
        L_0x007a:
            r3 = r5
        L_0x007b:
            if (r6 == 0) goto L_0x0085
            androidx.compose.material.ComposableSingletons$SnackbarHostKt r5 = androidx.compose.material.ComposableSingletons$SnackbarHostKt.INSTANCE
            kotlin.jvm.functions.Function3 r5 = r5.m1244getLambda1$material_release()
            r11 = r5
            goto L_0x0086
        L_0x0085:
            r11 = r7
        L_0x0086:
            androidx.compose.material.SnackbarData r5 = r12.getCurrentSnackbarData()
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalAccessibilityManager()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r7, r8)
            java.lang.Object r6 = r0.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.AccessibilityManager r6 = (androidx.compose.ui.platform.AccessibilityManager) r6
            androidx.compose.material.SnackbarHostKt$SnackbarHost$1 r7 = new androidx.compose.material.SnackbarHostKt$SnackbarHost$1
            r8 = 0
            r7.<init>(r5, r6, r8)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6 = 0
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r5, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r7, (androidx.compose.runtime.Composer) r0, (int) r6)
            androidx.compose.material.SnackbarData r5 = r12.getCurrentSnackbarData()
            r6 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 & 896(0x380, float:1.256E-42)
            r9 = r6 | r2
            r10 = 0
            r6 = r3
            r7 = r11
            r8 = r0
            FadeInFadeOutWithScale(r5, r6, r7, r8, r9, r10)
            r2 = r3
            r3 = r11
        L_0x00c0:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x00c7
            goto L_0x00d7
        L_0x00c7:
            androidx.compose.material.SnackbarHostKt$SnackbarHost$2 r7 = new androidx.compose.material.SnackbarHostKt$SnackbarHost$2
            r0 = r7
            r1 = r12
            r4 = r16
            r5 = r17
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x00d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarHostKt.SnackbarHost(androidx.compose.material.SnackbarHostState, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final long toMillis(SnackbarDuration snackbarDuration, boolean z, AccessibilityManager accessibilityManager) {
        long j;
        Intrinsics.checkNotNullParameter(snackbarDuration, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[snackbarDuration.ordinal()];
        if (i == 1) {
            j = Long.MAX_VALUE;
        } else if (i == 2) {
            j = WorkRequest.MIN_BACKOFF_MILLIS;
        } else if (i == 3) {
            j = 4000;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        long j2 = j;
        if (accessibilityManager == null) {
            return j2;
        }
        return accessibilityManager.calculateRecommendedTimeoutMillis(j2, true, true, z);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x02b0  */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void FadeInFadeOutWithScale(androidx.compose.material.SnackbarData r17, androidx.compose.ui.Modifier r18, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarData, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r19, androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r1 = r17
            r3 = r19
            r4 = r21
            r0 = 2036134589(0x795cf2bd, float:7.170179E34)
            r2 = r20
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(FadeInFadeOutWithScale)P(1,2)261@9210L48,315@11457L246:SnackbarHost.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r22 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r4 | 6
            goto L_0x002b
        L_0x001b:
            r2 = r4 & 14
            if (r2 != 0) goto L_0x002a
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r4
            goto L_0x002b
        L_0x002a:
            r2 = r4
        L_0x002b:
            r6 = r22 & 2
            if (r6 == 0) goto L_0x0032
            r2 = r2 | 48
            goto L_0x0045
        L_0x0032:
            r8 = r4 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0045
            r8 = r18
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0041
            r9 = 32
            goto L_0x0043
        L_0x0041:
            r9 = 16
        L_0x0043:
            r2 = r2 | r9
            goto L_0x0047
        L_0x0045:
            r8 = r18
        L_0x0047:
            r9 = r22 & 4
            if (r9 == 0) goto L_0x004e
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x005e
        L_0x004e:
            r9 = r4 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x005e
            boolean r9 = r0.changed((java.lang.Object) r3)
            if (r9 == 0) goto L_0x005b
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r2 = r2 | r9
        L_0x005e:
            r9 = r2 & 731(0x2db, float:1.024E-42)
            r10 = 146(0x92, float:2.05E-43)
            if (r9 != r10) goto L_0x0071
            boolean r9 = r0.getSkipping()
            if (r9 != 0) goto L_0x006b
            goto L_0x0071
        L_0x006b:
            r0.skipToGroupEnd()
            r2 = r8
            goto L_0x02a9
        L_0x0071:
            if (r6 == 0) goto L_0x0078
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            goto L_0x0079
        L_0x0078:
            r6 = r8
        L_0x0079:
            r8 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r8)
            java.lang.String r8 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            java.lang.Object r8 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r8 != r9) goto L_0x0098
            androidx.compose.material.FadeInFadeOutState r8 = new androidx.compose.material.FadeInFadeOutState
            r8.<init>()
            r0.updateRememberedValue(r8)
        L_0x0098:
            r0.endReplaceableGroup()
            androidx.compose.material.FadeInFadeOutState r8 = (androidx.compose.material.FadeInFadeOutState) r8
            java.lang.Object r9 = r8.getCurrent()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r9)
            r10 = 1
            if (r9 != 0) goto L_0x0126
            r8.setCurrent(r1)
            java.util.List r9 = r8.getItems()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r11 = new java.util.ArrayList
            r12 = 10
            int r12 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r12)
            r11.<init>(r12)
            java.util.Collection r11 = (java.util.Collection) r11
            java.util.Iterator r9 = r9.iterator()
        L_0x00c2:
            boolean r12 = r9.hasNext()
            if (r12 == 0) goto L_0x00d8
            java.lang.Object r12 = r9.next()
            androidx.compose.material.FadeInFadeOutAnimationItem r12 = (androidx.compose.material.FadeInFadeOutAnimationItem) r12
            java.lang.Object r12 = r12.getKey()
            androidx.compose.material.SnackbarData r12 = (androidx.compose.material.SnackbarData) r12
            r11.add(r12)
            goto L_0x00c2
        L_0x00d8:
            java.util.List r11 = (java.util.List) r11
            java.util.Collection r11 = (java.util.Collection) r11
            java.util.List r9 = kotlin.collections.CollectionsKt.toMutableList(r11)
            boolean r11 = r9.contains(r1)
            if (r11 != 0) goto L_0x00e9
            r9.add(r1)
        L_0x00e9:
            java.util.List r11 = r8.getItems()
            r11.clear()
            r11 = r9
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.List r11 = kotlin.collections.CollectionsKt.filterNotNull(r11)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.List r12 = r8.getItems()
            java.util.Collection r12 = (java.util.Collection) r12
            java.util.Iterator r11 = r11.iterator()
        L_0x0103:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x0126
            java.lang.Object r13 = r11.next()
            androidx.compose.material.SnackbarData r13 = (androidx.compose.material.SnackbarData) r13
            androidx.compose.material.FadeInFadeOutAnimationItem r14 = new androidx.compose.material.FadeInFadeOutAnimationItem
            r15 = -94104314(0xfffffffffa641506, float:-2.9606752E35)
            androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$1$1 r7 = new androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$1$1
            r7.<init>(r13, r1, r9, r8)
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r15, r10, r7)
            kotlin.jvm.functions.Function3 r7 = (kotlin.jvm.functions.Function3) r7
            r14.<init>(r13, r7)
            r12.add(r14)
            goto L_0x0103
        L_0x0126:
            int r7 = r2 >> 3
            r7 = r7 & 14
            r9 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r9)
            java.lang.String r9 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r9)
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r9 = r9.getTopStart()
            int r11 = r7 >> 3
            r12 = r11 & 14
            r11 = r11 & 112(0x70, float:1.57E-43)
            r11 = r11 | r12
            r12 = 0
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r9, r12, r0, r11)
            int r11 = r7 << 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r13)
            java.lang.String r13 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r13)
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r15 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r14, r15)
            java.lang.Object r13 = r0.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r13 = (androidx.compose.ui.unit.Density) r13
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r10 = r16
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r14, r15)
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r12 = r16
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r14, r15)
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r12 = (androidx.compose.ui.platform.ViewConfiguration) r12
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r15 = androidx.compose.ui.layout.LayoutKt.materializerOf(r6)
            int r11 = r11 << 9
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            r16 = 6
            r11 = r11 | 6
            androidx.compose.runtime.Applier r5 = r0.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x01b2
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01b2:
            r0.startReusableNode()
            boolean r5 = r0.getInserting()
            if (r5 == 0) goto L_0x01bf
            r0.createNode(r14)
            goto L_0x01c2
        L_0x01bf:
            r0.useNode()
        L_0x01c2:
            r0.disableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r9, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r13, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r10, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r12, r9)
            r0.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r5)
            int r9 = r11 >> 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r15.invoke(r5, r0, r9)
            r5 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r5)
            int r5 = r11 >> 9
            r5 = r5 & 14
            r9 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r9)
            java.lang.String r9 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r9)
            r5 = r5 & 11
            r9 = 2
            if (r5 != r9) goto L_0x0228
            boolean r5 = r0.getSkipping()
            if (r5 != 0) goto L_0x0224
            goto L_0x0228
        L_0x0224:
            r0.skipToGroupEnd()
            goto L_0x0299
        L_0x0228:
            androidx.compose.foundation.layout.BoxScopeInstance r5 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r7 = r7 >> 6
            r7 = r7 & 112(0x70, float:1.57E-43)
            r7 = r7 | 6
            androidx.compose.foundation.layout.BoxScope r5 = (androidx.compose.foundation.layout.BoxScope) r5
            r5 = -1788016521(0xffffffff956d0877, float:-4.7868446E-26)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "C316@11495L21:SnackbarHost.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            r5 = r7 & 81
            r7 = 16
            if (r5 != r7) goto L_0x024e
            boolean r5 = r0.getSkipping()
            if (r5 != 0) goto L_0x024a
            goto L_0x024e
        L_0x024a:
            r0.skipToGroupEnd()
            goto L_0x0296
        L_0x024e:
            r5 = 0
            androidx.compose.runtime.RecomposeScope r7 = androidx.compose.runtime.ComposablesKt.getCurrentRecomposeScope(r0, r5)
            r8.setScope(r7)
            java.util.List r7 = r8.getItems()
            int r8 = r7.size()
            r12 = 0
        L_0x025f:
            if (r12 >= r8) goto L_0x0296
            java.lang.Object r5 = r7.get(r12)
            androidx.compose.material.FadeInFadeOutAnimationItem r5 = (androidx.compose.material.FadeInFadeOutAnimationItem) r5
            java.lang.Object r9 = r5.component1()
            androidx.compose.material.SnackbarData r9 = (androidx.compose.material.SnackbarData) r9
            kotlin.jvm.functions.Function3 r5 = r5.component2()
            r10 = -208579897(0xfffffffff39152c7, float:-2.3027404E31)
            r0.startMovableGroup(r10, r9)
            java.lang.String r10 = "319@11610L63"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r10)
            r10 = 2041982076(0x79b62c7c, float:1.1823753E35)
            androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$2$1$1 r11 = new androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$2$1$1
            r11.<init>(r3, r9, r2)
            r9 = 1
            androidx.compose.runtime.internal.ComposableLambda r10 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r10, r9, r11)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r16)
            r5.invoke(r10, r0, r11)
            r0.endMovableGroup()
            int r12 = r12 + 1
            goto L_0x025f
        L_0x0296:
            r0.endReplaceableGroup()
        L_0x0299:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r2 = r6
        L_0x02a9:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x02b0
            goto L_0x02c3
        L_0x02b0:
            androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$3 r7 = new androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$3
            r0 = r7
            r1 = r17
            r3 = r19
            r4 = r21
            r5 = r22
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x02c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarHostKt.FadeInFadeOutWithScale(androidx.compose.material.SnackbarData, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final State<Float> animatedOpacity(AnimationSpec<Float> animationSpec, boolean z, Function0<Unit> function0, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1016418159);
        ComposerKt.sourceInformation(composer, "C(animatedOpacity)P(!1,2)347@12351L49,348@12405L169:SnackbarHost.kt#jmzs0o");
        if ((i2 & 4) != 0) {
            function0 = SnackbarHostKt$animatedOpacity$1.INSTANCE;
        }
        Function0<Unit> function02 = function0;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = AnimatableKt.Animatable$default(!z ? 1.0f : 0.0f, 0.0f, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Animatable animatable = (Animatable) rememberedValue;
        EffectsKt.LaunchedEffect((Object) Boolean.valueOf(z), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new SnackbarHostKt$animatedOpacity$2(animatable, z, animationSpec, function02, (Continuation<? super SnackbarHostKt$animatedOpacity$2>) null), composer, (i >> 3) & 14);
        State<Float> asState = animatable.asState();
        composer.endReplaceableGroup();
        return asState;
    }

    /* access modifiers changed from: private */
    public static final State<Float> animatedScale(AnimationSpec<Float> animationSpec, boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(2003504988);
        ComposerKt.sourceInformation(composer, "C(animatedScale)360@12726L51,361@12782L143:SnackbarHost.kt#jmzs0o");
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = AnimatableKt.Animatable$default(!z ? 1.0f : 0.8f, 0.0f, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Animatable animatable = (Animatable) rememberedValue;
        EffectsKt.LaunchedEffect((Object) Boolean.valueOf(z), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new SnackbarHostKt$animatedScale$1(animatable, z, animationSpec, (Continuation<? super SnackbarHostKt$animatedScale$1>) null), composer, (i >> 3) & 14);
        State<Float> asState = animatable.asState();
        composer.endReplaceableGroup();
        return asState;
    }
}
