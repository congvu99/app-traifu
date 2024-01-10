package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$Slider$3 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ State<Function1<Float, Unit>> $onValueChangeState;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ float $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$Slider$3(ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, float f, MutableInteractionSource mutableInteractionSource, boolean z, List<Float> list, SliderColors sliderColors, State<? extends Function1<? super Float, Unit>> state, Function0<Unit> function0) {
        super(3);
        this.$valueRange = closedFloatingPointRange;
        this.$$dirty = i;
        this.$value = f;
        this.$interactionSource = mutableInteractionSource;
        this.$enabled = z;
        this.$tickFractions = list;
        this.$colors = sliderColors;
        this.$onValueChangeState = state;
        this.$onValueChangeFinished = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v0, resolved type: androidx.compose.material.SliderDraggableState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: kotlin.jvm.functions.Function3} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope r30, androidx.compose.runtime.Composer r31, int r32) {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            r8 = r31
            java.lang.String r2 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "C167@8011L7,*172@8172L7,183@8586L24,184@8635L49,185@8711L31,187@8773L367,196@9150L83,198@9266L618,227@10378L55,234@10719L209:Slider.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            r2 = r32 & 14
            r3 = 2
            if (r2 != 0) goto L_0x0021
            boolean r2 = r8.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x001d
            r2 = 4
            goto L_0x001e
        L_0x001d:
            r2 = 2
        L_0x001e:
            r2 = r32 | r2
            goto L_0x0023
        L_0x0021:
            r2 = r32
        L_0x0023:
            r2 = r2 & 91
            r4 = 18
            if (r2 != r4) goto L_0x0035
            boolean r2 = r31.getSkipping()
            if (r2 != 0) goto L_0x0030
            goto L_0x0035
        L_0x0030:
            r31.skipToGroupEnd()
            goto L_0x02a5
        L_0x0035:
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r5)
            java.lang.Object r2 = r8.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r31)
            androidx.compose.ui.unit.LayoutDirection r6 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r9 = 0
            if (r2 != r6) goto L_0x0053
            r2 = 1
            r19 = 1
            goto L_0x0055
        L_0x0053:
            r19 = 0
        L_0x0055:
            long r1 = r30.m457getConstraintsmsEJaDk()
            int r1 = androidx.compose.ui.unit.Constraints.m4624getMaxWidthimpl(r1)
            float r13 = (float) r1
            kotlin.jvm.internal.Ref$FloatRef r15 = new kotlin.jvm.internal.Ref$FloatRef
            r15.<init>()
            kotlin.jvm.internal.Ref$FloatRef r14 = new kotlin.jvm.internal.Ref$FloatRef
            r14.<init>()
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r5)
            java.lang.Object r1 = r8.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r31)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            float r2 = androidx.compose.material.SliderKt.getThumbRadius()
            float r2 = r1.m4649toPx0680j_4(r2)
            float r2 = r13 - r2
            r4 = 0
            float r2 = java.lang.Math.max(r2, r4)
            r15.element = r2
            float r2 = androidx.compose.material.SliderKt.getThumbRadius()
            float r1 = r1.m4649toPx0680j_4(r2)
            float r2 = r15.element
            float r1 = java.lang.Math.min(r1, r2)
            r14.element = r1
            r1 = 773894976(0x2e20b340, float:3.6538994E-11)
            r8.startReplaceableGroup(r1)
            java.lang.String r1 = "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r8.startReplaceableGroup(r1)
            java.lang.String r2 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            java.lang.Object r5 = r31.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r5 != r6) goto L_0x00ce
            kotlin.coroutines.EmptyCoroutineContext r5 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            kotlinx.coroutines.CoroutineScope r5 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r5, r8)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r6 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r6.<init>(r5)
            r8.updateRememberedValue(r6)
            r5 = r6
        L_0x00ce:
            r31.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r5 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r5
            kotlinx.coroutines.CoroutineScope r10 = r5.getCoroutineScope()
            r31.endReplaceableGroup()
            float r5 = r0.$value
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.$valueRange
            r8.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            java.lang.Object r7 = r31.rememberedValue()
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            r12 = 0
            if (r7 != r11) goto L_0x0100
            float r5 = invoke$scaleToOffset(r6, r14, r15, r5)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            androidx.compose.runtime.MutableState r7 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r5, r12, r3, r12)
            r8.updateRememberedValue(r7)
        L_0x0100:
            r31.endReplaceableGroup()
            r11 = r7
            androidx.compose.runtime.MutableState r11 = (androidx.compose.runtime.MutableState) r11
            r8.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            java.lang.Object r1 = r31.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0123
            java.lang.Float r1 = java.lang.Float.valueOf(r4)
            androidx.compose.runtime.MutableState r1 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r12, r3, r12)
            r8.updateRememberedValue(r1)
        L_0x0123:
            r31.endReplaceableGroup()
            r17 = r1
            androidx.compose.runtime.MutableState r17 = (androidx.compose.runtime.MutableState) r17
            float r1 = r14.element
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            float r2 = r15.element
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit>> r4 = r0.$onValueChangeState
            r5 = 1618982084(0x607fb4c4, float:7.370227E19)
            r8.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r5)
            boolean r1 = r8.changed((java.lang.Object) r1)
            boolean r2 = r8.changed((java.lang.Object) r2)
            r1 = r1 | r2
            boolean r2 = r8.changed((java.lang.Object) r3)
            r1 = r1 | r2
            java.lang.Object r2 = r31.rememberedValue()
            if (r1 != 0) goto L_0x0161
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x017e
        L_0x0161:
            androidx.compose.material.SliderDraggableState r2 = new androidx.compose.material.SliderDraggableState
            androidx.compose.material.SliderKt$Slider$3$draggableState$1$1 r1 = new androidx.compose.material.SliderKt$Slider$3$draggableState$1$1
            r20 = r1
            r21 = r11
            r22 = r17
            r23 = r14
            r24 = r15
            r25 = r4
            r26 = r3
            r20.<init>(r21, r22, r23, r24, r25, r26)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r2.<init>(r1)
            r8.updateRememberedValue(r2)
        L_0x017e:
            r31.endReplaceableGroup()
            r28 = r2
            androidx.compose.material.SliderDraggableState r28 = (androidx.compose.material.SliderDraggableState) r28
            androidx.compose.material.SliderKt$Slider$3$2 r1 = new androidx.compose.material.SliderKt$Slider$3$2
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            r1.<init>(r2, r14, r15)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            float r3 = r14.element
            float r4 = r15.element
            kotlin.ranges.ClosedFloatingPointRange r3 = kotlin.ranges.RangesKt.rangeTo((float) r3, (float) r4)
            float r5 = r0.$value
            int r4 = r0.$$dirty
            int r6 = r4 >> 9
            r6 = r6 & 112(0x70, float:1.57E-43)
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            r7 = 57344(0xe000, float:8.0356E-41)
            int r4 = r4 << 12
            r4 = r4 & r7
            r7 = r6 | r4
            r4 = r11
            r6 = r31
            androidx.compose.material.SliderKt.CorrectValueSideEffect(r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1 r1 = new androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1
            java.util.List<java.lang.Float> r2 = r0.$tickFractions
            kotlin.jvm.functions.Function0<kotlin.Unit> r3 = r0.$onValueChangeFinished
            r20 = r1
            r21 = r11
            r22 = r2
            r23 = r14
            r24 = r15
            r25 = r10
            r26 = r28
            r27 = r3
            r20.<init>(r21, r22, r23, r24, r25, r26, r27)
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r1, r8, r9)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r10 = r2
            androidx.compose.ui.Modifier r10 = (androidx.compose.ui.Modifier) r10
            r2 = r28
            androidx.compose.foundation.gestures.DraggableState r2 = (androidx.compose.foundation.gestures.DraggableState) r2
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r0.$interactionSource
            r4 = r11
            androidx.compose.runtime.State r4 = (androidx.compose.runtime.State) r4
            boolean r5 = r0.$enabled
            r11 = r2
            r6 = r12
            r12 = r3
            r3 = r14
            r14 = r19
            r7 = r15
            r15 = r4
            r16 = r1
            r18 = r5
            androidx.compose.ui.Modifier r4 = androidx.compose.material.SliderKt.sliderTapModifier(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.gestures.Orientation r12 = androidx.compose.foundation.gestures.Orientation.Horizontal
            boolean r15 = r28.isDragging()
            r10 = r5
            androidx.compose.ui.Modifier r10 = (androidx.compose.ui.Modifier) r10
            boolean r13 = r0.$enabled
            androidx.compose.foundation.interaction.MutableInteractionSource r14 = r0.$interactionSource
            r16 = 0
            r5 = 1157296644(0x44faf204, float:2007.563)
            r8.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r5)
            boolean r5 = r8.changed((java.lang.Object) r1)
            java.lang.Object r9 = r31.rememberedValue()
            if (r5 != 0) goto L_0x021b
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r9 != r5) goto L_0x0226
        L_0x021b:
            androidx.compose.material.SliderKt$Slider$3$drag$1$1 r5 = new androidx.compose.material.SliderKt$Slider$3$drag$1$1
            r5.<init>(r1, r6)
            r9 = r5
            kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
            r8.updateRememberedValue(r9)
        L_0x0226:
            r31.endReplaceableGroup()
            r17 = r9
            kotlin.jvm.functions.Function3 r17 = (kotlin.jvm.functions.Function3) r17
            r1 = 32
            r20 = 0
            r11 = r2
            r18 = r19
            r19 = r1
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            float r2 = r0.$value
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r5 = r0.$valueRange
            java.lang.Comparable r5 = r5.getStart()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.$valueRange
            java.lang.Comparable r6 = r6.getEndInclusive()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            float r2 = kotlin.ranges.RangesKt.coerceIn((float) r2, (float) r5, (float) r6)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r5 = r0.$valueRange
            java.lang.Comparable r5 = r5.getStart()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.$valueRange
            java.lang.Comparable r6 = r6.getEndInclusive()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            float r2 = androidx.compose.material.SliderKt.calcFraction(r5, r6, r2)
            boolean r5 = r0.$enabled
            java.util.List<java.lang.Float> r6 = r0.$tickFractions
            androidx.compose.material.SliderColors r9 = r0.$colors
            float r7 = r7.element
            float r3 = r3.element
            float r7 = r7 - r3
            androidx.compose.foundation.interaction.MutableInteractionSource r10 = r0.$interactionSource
            androidx.compose.ui.Modifier r11 = r4.then(r1)
            int r1 = r0.$$dirty
            int r3 = r1 >> 9
            r3 = r3 & 14
            r3 = r3 | 512(0x200, float:7.175E-43)
            int r4 = r1 >> 15
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r4
            r4 = 458752(0x70000, float:6.42848E-40)
            int r1 = r1 >> 6
            r1 = r1 & r4
            r12 = r3 | r1
            r1 = r5
            r3 = r6
            r4 = r9
            r5 = r7
            r6 = r10
            r7 = r11
            r8 = r31
            r9 = r12
            androidx.compose.material.SliderKt.SliderImpl(r1, r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x02a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt$Slider$3.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final float invoke$scaleToUserValue(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, float f) {
        return SliderKt.scale(floatRef.element, floatRef2.element, f, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
    }

    /* access modifiers changed from: private */
    public static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, float f) {
        return SliderKt.scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), f, floatRef.element, floatRef2.element);
    }
}
