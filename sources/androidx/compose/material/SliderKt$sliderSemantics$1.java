package androidx.compose.material;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$sliderSemantics$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ float $coerced;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function1<Float, Unit> $onValueChange;
    final /* synthetic */ int $steps;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$sliderSemantics$1(boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, List<Float> list, float f, Function1<? super Float, Unit> function1) {
        super(1);
        this.$enabled = z;
        this.$valueRange = closedFloatingPointRange;
        this.$steps = i;
        this.$tickFractions = list;
        this.$coerced = f;
        this.$onValueChange = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        if (!this.$enabled) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        final ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$valueRange;
        final int i = this.$steps;
        final List<Float> list = this.$tickFractions;
        final float f = this.$coerced;
        final Function1<Float, Unit> function1 = this.$onValueChange;
        SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, (String) null, new Function1<Float, Boolean>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).floatValue());
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.Number} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Boolean invoke(float r7) {
                /*
                    r6 = this;
                    kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r0 = r2
                    java.lang.Comparable r0 = r0.getStart()
                    java.lang.Number r0 = (java.lang.Number) r0
                    float r0 = r0.floatValue()
                    kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r1 = r2
                    java.lang.Comparable r1 = r1.getEndInclusive()
                    java.lang.Number r1 = (java.lang.Number) r1
                    float r1 = r1.floatValue()
                    float r7 = kotlin.ranges.RangesKt.coerceIn((float) r7, (float) r0, (float) r1)
                    int r0 = r3
                    if (r0 <= 0) goto L_0x00b6
                    java.util.List<java.lang.Float> r0 = r4
                    java.lang.Iterable r0 = (java.lang.Iterable) r0
                    kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r1 = r2
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r3 = 10
                    int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r3)
                    r2.<init>(r3)
                    java.util.Collection r2 = (java.util.Collection) r2
                    java.util.Iterator r0 = r0.iterator()
                L_0x0037:
                    boolean r3 = r0.hasNext()
                    if (r3 == 0) goto L_0x0067
                    java.lang.Object r3 = r0.next()
                    java.lang.Number r3 = (java.lang.Number) r3
                    float r3 = r3.floatValue()
                    java.lang.Comparable r4 = r1.getStart()
                    java.lang.Number r4 = (java.lang.Number) r4
                    float r4 = r4.floatValue()
                    java.lang.Comparable r5 = r1.getEndInclusive()
                    java.lang.Number r5 = (java.lang.Number) r5
                    float r5 = r5.floatValue()
                    float r3 = androidx.compose.ui.util.MathHelpersKt.lerp((float) r4, (float) r5, (float) r3)
                    java.lang.Float r3 = java.lang.Float.valueOf(r3)
                    r2.add(r3)
                    goto L_0x0037
                L_0x0067:
                    java.util.List r2 = (java.util.List) r2
                    java.lang.Iterable r2 = (java.lang.Iterable) r2
                    java.util.Iterator r0 = r2.iterator()
                    boolean r1 = r0.hasNext()
                    if (r1 != 0) goto L_0x0077
                    r0 = 0
                    goto L_0x00ae
                L_0x0077:
                    java.lang.Object r1 = r0.next()
                    boolean r2 = r0.hasNext()
                    if (r2 != 0) goto L_0x0083
                L_0x0081:
                    r0 = r1
                    goto L_0x00ae
                L_0x0083:
                    r2 = r1
                    java.lang.Number r2 = (java.lang.Number) r2
                    float r2 = r2.floatValue()
                    float r2 = r2 - r7
                    float r2 = java.lang.Math.abs(r2)
                L_0x008f:
                    java.lang.Object r3 = r0.next()
                    r4 = r3
                    java.lang.Number r4 = (java.lang.Number) r4
                    float r4 = r4.floatValue()
                    float r4 = r4 - r7
                    float r4 = java.lang.Math.abs(r4)
                    int r5 = java.lang.Float.compare(r2, r4)
                    if (r5 <= 0) goto L_0x00a7
                    r1 = r3
                    r2 = r4
                L_0x00a7:
                    boolean r3 = r0.hasNext()
                    if (r3 != 0) goto L_0x008f
                    goto L_0x0081
                L_0x00ae:
                    java.lang.Float r0 = (java.lang.Float) r0
                    if (r0 == 0) goto L_0x00b6
                    float r7 = r0.floatValue()
                L_0x00b6:
                    float r0 = r5
                    r1 = 1
                    r2 = 0
                    int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                    if (r0 != 0) goto L_0x00c0
                    r0 = 1
                    goto L_0x00c1
                L_0x00c0:
                    r0 = 0
                L_0x00c1:
                    if (r0 == 0) goto L_0x00c5
                    r1 = 0
                    goto L_0x00ce
                L_0x00c5:
                    kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit> r0 = r6
                    java.lang.Float r7 = java.lang.Float.valueOf(r7)
                    r0.invoke(r7)
                L_0x00ce:
                    java.lang.Boolean r7 = java.lang.Boolean.valueOf(r1)
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt$sliderSemantics$1.AnonymousClass1.invoke(float):java.lang.Boolean");
            }
        }, 1, (Object) null);
    }
}
