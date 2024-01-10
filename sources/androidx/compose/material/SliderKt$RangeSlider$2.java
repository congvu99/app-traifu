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
final class SliderKt$RangeSlider$2 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $endInteractionSource;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
    final /* synthetic */ MutableInteractionSource $startInteractionSource;
    final /* synthetic */ int $steps;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;
    final /* synthetic */ ClosedFloatingPointRange<Float> $values;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$2(ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int i, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z, List<Float> list, int i2, SliderColors sliderColors, Function0<Unit> function0) {
        super(3);
        this.$valueRange = closedFloatingPointRange;
        this.$values = closedFloatingPointRange2;
        this.$$dirty = i;
        this.$onValueChangeState = state;
        this.$startInteractionSource = mutableInteractionSource;
        this.$endInteractionSource = mutableInteractionSource2;
        this.$enabled = z;
        this.$tickFractions = list;
        this.$steps = i2;
        this.$colors = sliderColors;
        this.$onValueChangeFinished = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope r31, androidx.compose.runtime.Composer r32, int r33) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            r12 = r32
            java.lang.String r2 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "C306@13913L7,*311@14074L7,322@14502L56,323@14586L63,325@14659L165,332@14833L170,340@15025L24,341@15081L944,365@16095L809,365@16048L856,405@17826L63,413@18103L65,418@18258L340:Slider.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r2)
            r2 = r33 & 14
            r9 = 2
            if (r2 != 0) goto L_0x0021
            boolean r2 = r12.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x001d
            r2 = 4
            goto L_0x001e
        L_0x001d:
            r2 = 2
        L_0x001e:
            r2 = r33 | r2
            goto L_0x0023
        L_0x0021:
            r2 = r33
        L_0x0023:
            r2 = r2 & 91
            r3 = 18
            if (r2 != r3) goto L_0x0035
            boolean r2 = r32.getSkipping()
            if (r2 != 0) goto L_0x0030
            goto L_0x0035
        L_0x0030:
            r32.skipToGroupEnd()
            goto L_0x03d4
        L_0x0035:
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r3, r4)
            java.lang.Object r2 = r12.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r32)
            androidx.compose.ui.unit.LayoutDirection r5 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r10 = 1
            r11 = 0
            if (r2 != r5) goto L_0x0053
            r19 = 1
            goto L_0x0055
        L_0x0053:
            r19 = 0
        L_0x0055:
            long r1 = r31.m457getConstraintsmsEJaDk()
            int r1 = androidx.compose.ui.unit.Constraints.m4624getMaxWidthimpl(r1)
            float r15 = (float) r1
            kotlin.jvm.internal.Ref$FloatRef r14 = new kotlin.jvm.internal.Ref$FloatRef
            r14.<init>()
            kotlin.jvm.internal.Ref$FloatRef r13 = new kotlin.jvm.internal.Ref$FloatRef
            r13.<init>()
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r3, r4)
            java.lang.Object r1 = r12.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r32)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            float r2 = androidx.compose.material.SliderKt.getThumbRadius()
            float r2 = r1.m4649toPx0680j_4(r2)
            float r2 = r15 - r2
            r14.element = r2
            float r2 = androidx.compose.material.SliderKt.getThumbRadius()
            float r1 = r1.m4649toPx0680j_4(r2)
            r13.element = r1
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r1 = r0.$values
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            r7 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r7)
            java.lang.String r6 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r6)
            java.lang.Object r3 = r32.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            r5 = 0
            if (r3 != r4) goto L_0x00c7
            java.lang.Comparable r1 = r1.getStart()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            float r1 = invoke$scaleToOffset(r2, r13, r14, r1)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r5, r9, r5)
            r12.updateRememberedValue(r3)
        L_0x00c7:
            r32.endReplaceableGroup()
            r16 = r3
            androidx.compose.runtime.MutableState r16 = (androidx.compose.runtime.MutableState) r16
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r1 = r0.$values
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            r12.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r6)
            java.lang.Object r3 = r32.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x00fd
            java.lang.Comparable r1 = r1.getEndInclusive()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            float r1 = invoke$scaleToOffset(r2, r13, r14, r1)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r5, r9, r5)
            r12.updateRememberedValue(r3)
        L_0x00fd:
            r32.endReplaceableGroup()
            r17 = r3
            androidx.compose.runtime.MutableState r17 = (androidx.compose.runtime.MutableState) r17
            androidx.compose.material.SliderKt$RangeSlider$2$2 r1 = new androidx.compose.material.SliderKt$RangeSlider$2$2
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            r1.<init>(r2, r13, r14)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            float r3 = r13.element
            float r4 = r14.element
            kotlin.ranges.ClosedFloatingPointRange r3 = kotlin.ranges.RangesKt.rangeTo((float) r3, (float) r4)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$values
            java.lang.Comparable r4 = r4.getStart()
            java.lang.Number r4 = (java.lang.Number) r4
            float r5 = r4.floatValue()
            int r4 = r0.$$dirty
            int r4 = r4 >> 9
            r4 = r4 & 112(0x70, float:1.57E-43)
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            r18 = r4
            r4 = r16
            r8 = r6
            r6 = r32
            r9 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r7 = r18
            androidx.compose.material.SliderKt.CorrectValueSideEffect(r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.material.SliderKt$RangeSlider$2$3 r1 = new androidx.compose.material.SliderKt$RangeSlider$2$3
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            r1.<init>(r2, r13, r14)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            float r3 = r13.element
            float r4 = r14.element
            kotlin.ranges.ClosedFloatingPointRange r3 = kotlin.ranges.RangesKt.rangeTo((float) r3, (float) r4)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$values
            java.lang.Comparable r4 = r4.getEndInclusive()
            java.lang.Number r4 = (java.lang.Number) r4
            float r5 = r4.floatValue()
            int r4 = r0.$$dirty
            int r4 = r4 >> 9
            r4 = r4 & 112(0x70, float:1.57E-43)
            r7 = r4 | 3072(0xc00, float:4.305E-42)
            r4 = r17
            androidx.compose.material.SliderKt.CorrectValueSideEffect(r1, r2, r3, r4, r5, r6, r7)
            r1 = 773894976(0x2e20b340, float:3.6538994E-11)
            r12.startReplaceableGroup(r1)
            java.lang.String r1 = "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r12.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r8)
            java.lang.Object r1 = r32.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0194
            kotlin.coroutines.EmptyCoroutineContext r1 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            kotlinx.coroutines.CoroutineScope r1 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r1, r12)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r2.<init>(r1)
            r12.updateRememberedValue(r2)
            r1 = r2
        L_0x0194:
            r32.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r1
            kotlinx.coroutines.CoroutineScope r27 = r1.getCoroutineScope()
            r32.endReplaceableGroup()
            androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1 r1 = new androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1
            java.util.List<java.lang.Float> r2 = r0.$tickFractions
            kotlin.jvm.functions.Function0<kotlin.Unit> r3 = r0.$onValueChangeFinished
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r4 = r0.$onValueChangeState
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r5 = r0.$valueRange
            r20 = r1
            r21 = r16
            r22 = r17
            r23 = r2
            r24 = r13
            r25 = r14
            r26 = r3
            r28 = r4
            r29 = r5
            r20.<init>(r21, r22, r23, r24, r25, r26, r27, r28, r29)
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r1, r12, r11)
            r2 = 7
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r3[r11] = r16
            r3[r10] = r17
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$valueRange
            r5 = 2
            r3[r5] = r4
            r4 = 3
            float r5 = r13.element
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r3[r4] = r5
            float r4 = r14.element
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            r5 = 4
            r3[r5] = r4
            r4 = 5
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r5 = r0.$values
            r3[r4] = r5
            r4 = 6
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r6 = r0.$onValueChangeState
            r3[r4] = r6
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$valueRange
            r7 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r12.startReplaceableGroup(r7)
            java.lang.String r7 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r7)
            r7 = 0
            r8 = 0
        L_0x01fa:
            if (r7 >= r2) goto L_0x0206
            r9 = r3[r7]
            boolean r9 = r12.changed((java.lang.Object) r9)
            r8 = r8 | r9
            int r7 = r7 + 1
            goto L_0x01fa
        L_0x0206:
            java.lang.Object r2 = r32.rememberedValue()
            if (r8 != 0) goto L_0x0214
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x022e
        L_0x0214:
            androidx.compose.material.SliderKt$RangeSlider$2$onDrag$1$1 r2 = new androidx.compose.material.SliderKt$RangeSlider$2$onDrag$1$1
            r20 = r2
            r21 = r16
            r22 = r17
            r23 = r5
            r24 = r13
            r25 = r14
            r26 = r6
            r27 = r4
            r20.<init>(r21, r22, r23, r24, r25, r26, r27)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r12.updateRememberedValue(r2)
        L_0x022e:
            r32.endReplaceableGroup()
            androidx.compose.runtime.State r23 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r2, r12, r11)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r0.$startInteractionSource
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r0.$endInteractionSource
            androidx.compose.runtime.State r16 = (androidx.compose.runtime.State) r16
            androidx.compose.runtime.State r17 = (androidx.compose.runtime.State) r17
            boolean r5 = r0.$enabled
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.$valueRange
            r7 = r13
            r13 = r2
            r2 = r14
            r14 = r3
            r3 = r15
            r15 = r4
            r18 = r5
            r20 = r3
            r21 = r6
            r22 = r1
            androidx.compose.ui.Modifier r9 = androidx.compose.material.SliderKt.rangeSliderPressDragModifier(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r1 = r0.$values
            java.lang.Comparable r1 = r1.getStart()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            java.lang.Comparable r3 = r3.getStart()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$values
            java.lang.Comparable r4 = r4.getEndInclusive()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            float r1 = kotlin.ranges.RangesKt.coerceIn((float) r1, (float) r3, (float) r4)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$values
            java.lang.Comparable r3 = r3.getEndInclusive()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$values
            java.lang.Comparable r4 = r4.getStart()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r5 = r0.$valueRange
            java.lang.Comparable r5 = r5.getEndInclusive()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            float r3 = kotlin.ranges.RangesKt.coerceIn((float) r3, (float) r4, (float) r5)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$valueRange
            java.lang.Comparable r4 = r4.getStart()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r5 = r0.$valueRange
            java.lang.Comparable r5 = r5.getEndInclusive()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            float r4 = androidx.compose.material.SliderKt.calcFraction(r4, r5, r1)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r5 = r0.$valueRange
            java.lang.Comparable r5 = r5.getStart()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.$valueRange
            java.lang.Comparable r6 = r6.getEndInclusive()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            float r5 = androidx.compose.material.SliderKt.calcFraction(r5, r6, r3)
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            r13 = r6
            androidx.compose.ui.Modifier r13 = (androidx.compose.ui.Modifier) r13
            java.util.List<java.lang.Float> r15 = r0.$tickFractions
            boolean r6 = r0.$enabled
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r8 = r0.$onValueChangeState
            java.lang.Float r10 = java.lang.Float.valueOf(r3)
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r11 = r0.$onValueChangeState
            r14 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r12.startReplaceableGroup(r14)
            r31 = r9
            java.lang.String r9 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r9)
            boolean r8 = r12.changed((java.lang.Object) r8)
            boolean r10 = r12.changed((java.lang.Object) r10)
            r8 = r8 | r10
            java.lang.Object r10 = r32.rememberedValue()
            if (r8 != 0) goto L_0x0314
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r10 != r8) goto L_0x031f
        L_0x0314:
            androidx.compose.material.SliderKt$RangeSlider$2$startThumbSemantics$1$1 r8 = new androidx.compose.material.SliderKt$RangeSlider$2$startThumbSemantics$1$1
            r8.<init>(r11, r3)
            r10 = r8
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r12.updateRememberedValue(r10)
        L_0x031f:
            r32.endReplaceableGroup()
            r17 = r10
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r8 = r0.$valueRange
            java.lang.Comparable r8 = r8.getStart()
            java.lang.Number r8 = (java.lang.Number) r8
            float r8 = r8.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r18 = kotlin.ranges.RangesKt.rangeTo((float) r8, (float) r3)
            int r8 = r0.$steps
            r10 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r14 = r1
            r16 = r6
            r19 = r8
            androidx.compose.ui.Modifier r11 = androidx.compose.material.SliderKt.sliderSemantics(r13, r14, r15, r16, r17, r18, r19)
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            r13 = r6
            androidx.compose.ui.Modifier r13 = (androidx.compose.ui.Modifier) r13
            java.util.List<java.lang.Float> r15 = r0.$tickFractions
            boolean r6 = r0.$enabled
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r8 = r0.$onValueChangeState
            java.lang.Float r14 = java.lang.Float.valueOf(r1)
            r33 = r11
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r11 = r0.$onValueChangeState
            r12.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r9)
            boolean r8 = r12.changed((java.lang.Object) r8)
            boolean r9 = r12.changed((java.lang.Object) r14)
            r8 = r8 | r9
            java.lang.Object r9 = r32.rememberedValue()
            if (r8 != 0) goto L_0x0374
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r9 != r8) goto L_0x037f
        L_0x0374:
            androidx.compose.material.SliderKt$RangeSlider$2$endThumbSemantics$1$1 r8 = new androidx.compose.material.SliderKt$RangeSlider$2$endThumbSemantics$1$1
            r8.<init>(r11, r1)
            r9 = r8
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r12.updateRememberedValue(r9)
        L_0x037f:
            r32.endReplaceableGroup()
            r17 = r9
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r8 = r0.$valueRange
            java.lang.Comparable r8 = r8.getEndInclusive()
            java.lang.Number r8 = (java.lang.Number) r8
            float r8 = r8.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r18 = kotlin.ranges.RangesKt.rangeTo((float) r1, (float) r8)
            int r1 = r0.$steps
            r14 = r3
            r16 = r6
            r19 = r1
            androidx.compose.ui.Modifier r11 = androidx.compose.material.SliderKt.sliderSemantics(r13, r14, r15, r16, r17, r18, r19)
            boolean r1 = r0.$enabled
            java.util.List<java.lang.Float> r6 = r0.$tickFractions
            androidx.compose.material.SliderColors r8 = r0.$colors
            float r2 = r2.element
            float r3 = r7.element
            float r7 = r2 - r3
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = r0.$startInteractionSource
            androidx.compose.foundation.interaction.MutableInteractionSource r10 = r0.$endInteractionSource
            r2 = 14159872(0xd81000, float:1.9842207E-38)
            int r3 = r0.$$dirty
            int r13 = r3 >> 9
            r13 = r13 & 14
            r2 = r2 | r13
            r13 = 57344(0xe000, float:8.0356E-41)
            int r3 = r3 >> 9
            r3 = r3 & r13
            r13 = r2 | r3
            r14 = 0
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r8
            r6 = r7
            r7 = r9
            r8 = r10
            r9 = r31
            r10 = r33
            r12 = r32
            androidx.compose.material.SliderKt.RangeSliderImpl(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
        L_0x03d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt$RangeSlider$2.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> invoke$scaleToUserValue(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
        return SliderKt.scale(floatRef.element, floatRef2.element, closedFloatingPointRange2, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
    }

    /* access modifiers changed from: private */
    public static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, float f) {
        return SliderKt.scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), f, floatRef.element, floatRef2.element);
    }
}
