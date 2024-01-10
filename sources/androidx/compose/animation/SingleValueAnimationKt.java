package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001aK\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"colorDefaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/graphics/Color;", "Animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector4D;", "initialValue", "Animatable-8_81llA", "(J)Landroidx/compose/animation/core/Animatable;", "animateColorAsState", "Landroidx/compose/runtime/State;", "targetValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "finishedListener", "Lkotlin/Function1;", "", "animateColorAsState-KTwxG1Y", "(JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SingleValueAnimation.kt */
public final class SingleValueAnimationKt {
    private static final SpringSpec<Color> colorDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: androidx.compose.animation.core.TwoWayConverter} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: animateColorAsState-KTwxG1Y  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.runtime.State<androidx.compose.ui.graphics.Color> m86animateColorAsStateKTwxG1Y(long r8, androidx.compose.animation.core.AnimationSpec<androidx.compose.ui.graphics.Color> r10, kotlin.jvm.functions.Function1<? super androidx.compose.ui.graphics.Color, kotlin.Unit> r11, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            r0 = -309953786(0xffffffffed867b06, float:-5.2024647E27)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "C(animateColorAsState)P(2:c#ui.graphics.Color)60@2717L96,63@2825L109:SingleValueAnimation.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            r0 = r14 & 2
            if (r0 == 0) goto L_0x0013
            androidx.compose.animation.core.SpringSpec<androidx.compose.ui.graphics.Color> r10 = colorDefaultSpring
            androidx.compose.animation.core.AnimationSpec r10 = (androidx.compose.animation.core.AnimationSpec) r10
        L_0x0013:
            r2 = r10
            r10 = r14 & 4
            if (r10 == 0) goto L_0x0019
            r11 = 0
        L_0x0019:
            r4 = r11
            androidx.compose.ui.graphics.colorspace.ColorSpace r10 = androidx.compose.ui.graphics.Color.m1936getColorSpaceimpl(r8)
            r11 = -3686930(0xffffffffffc7bdee, float:NaN)
            r12.startReplaceableGroup(r11)
            java.lang.String r11 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r11)
            boolean r10 = r12.changed((java.lang.Object) r10)
            java.lang.Object r11 = r12.rememberedValue()
            if (r10 != 0) goto L_0x003b
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r11 != r10) goto L_0x004f
        L_0x003b:
            androidx.compose.ui.graphics.Color$Companion r10 = androidx.compose.ui.graphics.Color.Companion
            kotlin.jvm.functions.Function1 r10 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r10)
            androidx.compose.ui.graphics.colorspace.ColorSpace r11 = androidx.compose.ui.graphics.Color.m1936getColorSpaceimpl(r8)
            java.lang.Object r10 = r10.invoke(r11)
            r11 = r10
            androidx.compose.animation.core.TwoWayConverter r11 = (androidx.compose.animation.core.TwoWayConverter) r11
            r12.updateRememberedValue(r11)
        L_0x004f:
            r12.endReplaceableGroup()
            r1 = r11
            androidx.compose.animation.core.TwoWayConverter r1 = (androidx.compose.animation.core.TwoWayConverter) r1
            androidx.compose.ui.graphics.Color r0 = androidx.compose.ui.graphics.Color.m1922boximpl(r8)
            r3 = 0
            r8 = r13 & 14
            r8 = r8 | 576(0x240, float:8.07E-43)
            r9 = 57344(0xe000, float:8.0356E-41)
            int r10 = r13 << 6
            r9 = r9 & r10
            r6 = r8 | r9
            r7 = 8
            r5 = r12
            androidx.compose.runtime.State r8 = androidx.compose.animation.core.AnimateAsStateKt.animateValueAsState(r0, r1, r2, r3, r4, r5, r6, r7)
            r12.endReplaceableGroup()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.SingleValueAnimationKt.m86animateColorAsStateKTwxG1Y(long, androidx.compose.animation.core.AnimationSpec, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):androidx.compose.runtime.State");
    }

    /* renamed from: Animatable-8_81llA  reason: not valid java name */
    public static final Animatable<Color, AnimationVector4D> m85Animatable8_81llA(long j) {
        return new Animatable(Color.m1922boximpl(j), ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.m1936getColorSpaceimpl(j)), (Object) null, 4, (DefaultConstructorMarker) null);
    }
}
