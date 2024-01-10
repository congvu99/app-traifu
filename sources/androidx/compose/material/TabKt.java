package androidx.compose.material;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!\u001a\u0001\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$\u001a{\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00100&¢\u0006\u0002\b\u0016¢\u0006\u0002\b(H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\u001a7\u0010+\u001a\u00020\u00102\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u0016H\u0003¢\u0006\u0002\u0010,\u001a@\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u001aD\u00102\u001a\u00020\u0010*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000bH\u0002\u001a\u001c\u0010=\u001a\u00020\u0010*\u0002032\u0006\u0010>\u001a\u0002072\u0006\u0010:\u001a\u00020\u000bH\u0002\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\"\u0013\u0010\u000e\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006?"}, d2 = {"DoubleLineTextBaselineWithIcon", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalTextPadding", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "LargeTabHeight", "SingleLineTextBaselineWithIcon", "SmallTabHeight", "TabFadeInAnimationDelay", "", "TabFadeInAnimationDuration", "TabFadeOutAnimationDuration", "TextDistanceFromLeadingIcon", "LeadingIconTab", "", "selected", "", "onClick", "Lkotlin/Function0;", "text", "Landroidx/compose/runtime/Composable;", "icon", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "LeadingIconTab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "Tab", "Tab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-EVJuX4I", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextAndIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "tabWidth", "tabHeight", "firstBaseline", "lastBaseline", "placeTextOrIcon", "textOrIconPlaceable", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Tab.kt */
public final class TabKt {
    private static final float DoubleLineTextBaselineWithIcon = Dp.m4704constructorimpl((float) 6);
    /* access modifiers changed from: private */
    public static final float HorizontalTextPadding = Dp.m4704constructorimpl((float) 16);
    private static final long IconDistanceFromBaseline = TextUnitKt.getSp(20);
    /* access modifiers changed from: private */
    public static final float LargeTabHeight = Dp.m4704constructorimpl((float) 72);
    private static final float SingleLineTextBaselineWithIcon = Dp.m4704constructorimpl((float) 14);
    /* access modifiers changed from: private */
    public static final float SmallTabHeight = Dp.m4704constructorimpl((float) 48);
    private static final int TabFadeInAnimationDelay = 100;
    private static final int TabFadeInAnimationDuration = 150;
    private static final int TabFadeOutAnimationDuration = 100;
    /* access modifiers changed from: private */
    public static final float TextDistanceFromLeadingIcon = Dp.m4704constructorimpl((float) 8);

    /* JADX WARNING: Removed duplicated region for block: B:100:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0119  */
    /* renamed from: Tab-0nD-MI0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1443Tab0nDMI0(boolean r29, kotlin.jvm.functions.Function0<kotlin.Unit> r30, androidx.compose.ui.Modifier r31, boolean r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.foundation.interaction.MutableInteractionSource r35, long r36, long r38, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r13 = r30
            r14 = r41
            r15 = r42
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -1486097588(0xffffffffa76bf34c, float:-3.2744693E-15)
            r1 = r40
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(Tab)P(5,4,3!1,7!2,6:c#ui.graphics.Color,8:c#ui.graphics.Color)96@4350L39,97@4443L7,98@4535L6,106@4792L234:Tab.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            r0 = r15 & 1
            if (r0 == 0) goto L_0x0022
            r0 = r14 | 6
            r11 = r29
            goto L_0x0034
        L_0x0022:
            r0 = r14 & 14
            r11 = r29
            if (r0 != 0) goto L_0x0033
            boolean r0 = r12.changed((boolean) r11)
            if (r0 == 0) goto L_0x0030
            r0 = 4
            goto L_0x0031
        L_0x0030:
            r0 = 2
        L_0x0031:
            r0 = r0 | r14
            goto L_0x0034
        L_0x0033:
            r0 = r14
        L_0x0034:
            r1 = r15 & 2
            if (r1 == 0) goto L_0x003b
            r0 = r0 | 48
            goto L_0x004b
        L_0x003b:
            r1 = r14 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x004b
            boolean r1 = r12.changed((java.lang.Object) r13)
            if (r1 == 0) goto L_0x0048
            r1 = 32
            goto L_0x004a
        L_0x0048:
            r1 = 16
        L_0x004a:
            r0 = r0 | r1
        L_0x004b:
            r1 = r15 & 4
            if (r1 == 0) goto L_0x0052
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0065
        L_0x0052:
            r2 = r14 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0065
            r2 = r31
            boolean r3 = r12.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0061
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r0 = r0 | r3
            goto L_0x0067
        L_0x0065:
            r2 = r31
        L_0x0067:
            r3 = r15 & 8
            if (r3 == 0) goto L_0x006e
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r4 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0081
            r4 = r32
            boolean r5 = r12.changed((boolean) r4)
            if (r5 == 0) goto L_0x007d
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r0 = r0 | r5
            goto L_0x0083
        L_0x0081:
            r4 = r32
        L_0x0083:
            r5 = r15 & 16
            r6 = 57344(0xe000, float:8.0356E-41)
            if (r5 == 0) goto L_0x008d
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a0
        L_0x008d:
            r7 = r14 & r6
            if (r7 != 0) goto L_0x00a0
            r7 = r33
            boolean r8 = r12.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x009c
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009c:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r0 = r0 | r8
            goto L_0x00a2
        L_0x00a0:
            r7 = r33
        L_0x00a2:
            r8 = r15 & 32
            r9 = 458752(0x70000, float:6.42848E-40)
            if (r8 == 0) goto L_0x00ac
            r10 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r10
            goto L_0x00c0
        L_0x00ac:
            r10 = r14 & r9
            if (r10 != 0) goto L_0x00c0
            r10 = r34
            boolean r16 = r12.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x00bb
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bd
        L_0x00bb:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bd:
            r0 = r0 | r16
            goto L_0x00c2
        L_0x00c0:
            r10 = r34
        L_0x00c2:
            r16 = r15 & 64
            r17 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00cf
            r18 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r18
            r9 = r35
            goto L_0x00e2
        L_0x00cf:
            r18 = r14 & r17
            r9 = r35
            if (r18 != 0) goto L_0x00e2
            boolean r18 = r12.changed((java.lang.Object) r9)
            if (r18 == 0) goto L_0x00de
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e0
        L_0x00de:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00e0:
            r0 = r0 | r18
        L_0x00e2:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r14 & r18
            if (r18 != 0) goto L_0x00fe
            r6 = r15 & 128(0x80, float:1.794E-43)
            if (r6 != 0) goto L_0x00f7
            r6 = r36
            boolean r19 = r12.changed((long) r6)
            if (r19 == 0) goto L_0x00f9
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fb
        L_0x00f7:
            r6 = r36
        L_0x00f9:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fb:
            r0 = r0 | r19
            goto L_0x0100
        L_0x00fe:
            r6 = r36
        L_0x0100:
            r19 = 234881024(0xe000000, float:1.5777218E-30)
            r19 = r14 & r19
            if (r19 != 0) goto L_0x0119
            r2 = r15 & 256(0x100, float:3.59E-43)
            r6 = r38
            if (r2 != 0) goto L_0x0115
            boolean r2 = r12.changed((long) r6)
            if (r2 == 0) goto L_0x0115
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0117
        L_0x0115:
            r2 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0117:
            r0 = r0 | r2
            goto L_0x011b
        L_0x0119:
            r6 = r38
        L_0x011b:
            r2 = 191739611(0xb6db6db, float:4.5782105E-32)
            r2 = r2 & r0
            r4 = 38347922(0x2492492, float:1.4777643E-37)
            if (r2 != r4) goto L_0x0140
            boolean r2 = r12.getSkipping()
            if (r2 != 0) goto L_0x012b
            goto L_0x0140
        L_0x012b:
            r12.skipToGroupEnd()
            r3 = r31
            r4 = r32
            r5 = r33
            r17 = r12
            r27 = r6
            r7 = r9
            r8 = r36
            r6 = r10
            r10 = r27
            goto L_0x0282
        L_0x0140:
            r12.startDefaults()
            r2 = r14 & 1
            r19 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r20 = 0
            if (r2 == 0) goto L_0x0173
            boolean r2 = r12.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0153
            goto L_0x0173
        L_0x0153:
            r12.skipToGroupEnd()
            r1 = r15 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x015c
            r0 = r0 & r19
        L_0x015c:
            r1 = r15 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0164
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r1
        L_0x0164:
            r19 = r31
            r21 = r32
            r23 = r36
            r25 = r6
            r22 = r9
            r9 = r10
            r10 = r33
            goto L_0x020d
        L_0x0173:
            if (r1 == 0) goto L_0x017a
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x017c
        L_0x017a:
            r1 = r31
        L_0x017c:
            if (r3 == 0) goto L_0x0180
            r2 = 1
            goto L_0x0182
        L_0x0180:
            r2 = r32
        L_0x0182:
            if (r5 == 0) goto L_0x0187
            r3 = r20
            goto L_0x0189
        L_0x0187:
            r3 = r33
        L_0x0189:
            if (r8 == 0) goto L_0x018d
            r10 = r20
        L_0x018d:
            if (r16 == 0) goto L_0x01b3
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r5)
            java.lang.Object r5 = r12.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r5 != r8) goto L_0x01ad
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r12.updateRememberedValue(r5)
        L_0x01ad:
            r12.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = (androidx.compose.foundation.interaction.MutableInteractionSource) r5
            goto L_0x01b4
        L_0x01b3:
            r5 = r9
        L_0x01b4:
            r8 = r15 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x01d6
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r9, r4)
            java.lang.Object r4 = r12.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.graphics.Color r4 = (androidx.compose.ui.graphics.Color) r4
            long r8 = r4.m1942unboximpl()
            r0 = r0 & r19
            goto L_0x01d8
        L_0x01d6:
            r8 = r36
        L_0x01d8:
            r4 = r15 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x0201
            androidx.compose.material.ContentAlpha r4 = androidx.compose.material.ContentAlpha.INSTANCE
            r6 = 6
            float r4 = r4.getMedium(r12, r6)
            r6 = 0
            r7 = 0
            r19 = 0
            r22 = 14
            r23 = 0
            r31 = r8
            r33 = r4
            r34 = r6
            r35 = r7
            r36 = r19
            r37 = r22
            r38 = r23
            long r6 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r31, r33, r34, r35, r36, r37, r38)
            r4 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r4
        L_0x0201:
            r19 = r1
            r21 = r2
            r22 = r5
            r25 = r6
            r23 = r8
            r9 = r10
            r10 = r3
        L_0x020d:
            r12.endDefaults()
            if (r10 == 0) goto L_0x0224
            r1 = -1729014781(0xffffffff98f15403, float:-6.238187E-24)
            androidx.compose.material.TabKt$Tab$styledText$1$1 r2 = new androidx.compose.material.TabKt$Tab$styledText$1$1
            r2.<init>(r10, r0)
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r1, r3, r2)
            r20 = r1
            kotlin.jvm.functions.Function2 r20 = (kotlin.jvm.functions.Function2) r20
            goto L_0x0225
        L_0x0224:
            r3 = 1
        L_0x0225:
            r1 = r20
            r2 = -178151495(0xfffffffff5619fb9, float:-2.860123E32)
            androidx.compose.material.TabKt$Tab$2 r4 = new androidx.compose.material.TabKt$Tab$2
            r4.<init>(r1, r9, r0)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r2, r3, r4)
            r16 = r1
            kotlin.jvm.functions.Function3 r16 = (kotlin.jvm.functions.Function3) r16
            r1 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r0 & 14
            r1 = r1 | r2
            r2 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r0 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = 6
            int r0 = r0 >> r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r0
            r1 = r1 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r0
            r1 = r1 | r2
            r0 = r0 & r17
            r17 = r1 | r0
            r18 = 0
            r0 = r29
            r1 = r30
            r2 = r19
            r3 = r21
            r4 = r22
            r5 = r23
            r7 = r25
            r20 = r9
            r9 = r16
            r16 = r10
            r10 = r12
            r11 = r17
            r17 = r12
            r12 = r18
            m1444TabEVJuX4I(r0, r1, r2, r3, r4, r5, r7, r9, r10, r11, r12)
            r5 = r16
            r3 = r19
            r6 = r20
            r4 = r21
            r7 = r22
            r8 = r23
            r10 = r25
        L_0x0282:
            androidx.compose.runtime.ScopeUpdateScope r12 = r17.endRestartGroup()
            if (r12 != 0) goto L_0x0289
            goto L_0x02a1
        L_0x0289:
            androidx.compose.material.TabKt$Tab$3 r16 = new androidx.compose.material.TabKt$Tab$3
            r0 = r16
            r1 = r29
            r2 = r30
            r13 = r12
            r12 = r41
            r14 = r13
            r13 = r42
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r10, r12, r13)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x02a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabKt.m1443Tab0nDMI0(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.foundation.interaction.MutableInteractionSource, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x012a  */
    /* renamed from: LeadingIconTab-0nD-MI0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1442LeadingIconTab0nDMI0(boolean r28, kotlin.jvm.functions.Function0<kotlin.Unit> r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.ui.Modifier r32, boolean r33, androidx.compose.foundation.interaction.MutableInteractionSource r34, long r35, long r37, androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r10 = r29
            r11 = r30
            r12 = r31
            r13 = r40
            r14 = r41
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "icon"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1499861761(0xffffffffa699ecff, float:-1.0680746E-15)
            r1 = r39
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(LeadingIconTab)P(5,4,7,1,3!2,6:c#ui.graphics.Color,8:c#ui.graphics.Color)158@6914L39,159@7007L7,160@7099L6,165@7347L60,167@7413L929:Tab.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            r0 = r14 & 1
            if (r0 == 0) goto L_0x0031
            r0 = r13 | 6
            r9 = r28
            goto L_0x0043
        L_0x0031:
            r0 = r13 & 14
            r9 = r28
            if (r0 != 0) goto L_0x0042
            boolean r0 = r15.changed((boolean) r9)
            if (r0 == 0) goto L_0x003f
            r0 = 4
            goto L_0x0040
        L_0x003f:
            r0 = 2
        L_0x0040:
            r0 = r0 | r13
            goto L_0x0043
        L_0x0042:
            r0 = r13
        L_0x0043:
            r1 = r14 & 2
            if (r1 == 0) goto L_0x004a
            r0 = r0 | 48
            goto L_0x005a
        L_0x004a:
            r1 = r13 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x005a
            boolean r1 = r15.changed((java.lang.Object) r10)
            if (r1 == 0) goto L_0x0057
            r1 = 32
            goto L_0x0059
        L_0x0057:
            r1 = 16
        L_0x0059:
            r0 = r0 | r1
        L_0x005a:
            r1 = r14 & 4
            if (r1 == 0) goto L_0x0061
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0071
        L_0x0061:
            r1 = r13 & 896(0x380, float:1.256E-42)
            if (r1 != 0) goto L_0x0071
            boolean r1 = r15.changed((java.lang.Object) r11)
            if (r1 == 0) goto L_0x006e
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x0070
        L_0x006e:
            r1 = 128(0x80, float:1.794E-43)
        L_0x0070:
            r0 = r0 | r1
        L_0x0071:
            r1 = r14 & 8
            if (r1 == 0) goto L_0x0078
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0078:
            r1 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x0088
            boolean r1 = r15.changed((java.lang.Object) r12)
            if (r1 == 0) goto L_0x0085
            r1 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r1 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r0 = r0 | r1
        L_0x0088:
            r1 = r14 & 16
            if (r1 == 0) goto L_0x008f
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a4
        L_0x008f:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r13
            if (r2 != 0) goto L_0x00a4
            r2 = r32
            boolean r3 = r15.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x00a0
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a2
        L_0x00a0:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x00a2:
            r0 = r0 | r3
            goto L_0x00a6
        L_0x00a4:
            r2 = r32
        L_0x00a6:
            r3 = r14 & 32
            if (r3 == 0) goto L_0x00ae
            r4 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r4
            goto L_0x00c2
        L_0x00ae:
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r13
            if (r4 != 0) goto L_0x00c2
            r4 = r33
            boolean r5 = r15.changed((boolean) r4)
            if (r5 == 0) goto L_0x00be
            r5 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00be:
            r5 = 65536(0x10000, float:9.18355E-41)
        L_0x00c0:
            r0 = r0 | r5
            goto L_0x00c4
        L_0x00c2:
            r4 = r33
        L_0x00c4:
            r5 = r14 & 64
            if (r5 == 0) goto L_0x00cc
            r6 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r6
            goto L_0x00e0
        L_0x00cc:
            r6 = 3670016(0x380000, float:5.142788E-39)
            r6 = r6 & r13
            if (r6 != 0) goto L_0x00e0
            r6 = r34
            boolean r7 = r15.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x00dc
            r7 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00de
        L_0x00dc:
            r7 = 524288(0x80000, float:7.34684E-40)
        L_0x00de:
            r0 = r0 | r7
            goto L_0x00e2
        L_0x00e0:
            r6 = r34
        L_0x00e2:
            r7 = 29360128(0x1c00000, float:7.052966E-38)
            r7 = r7 & r13
            if (r7 != 0) goto L_0x00fd
            r7 = r14 & 128(0x80, float:1.794E-43)
            if (r7 != 0) goto L_0x00f6
            r7 = r35
            boolean r16 = r15.changed((long) r7)
            if (r16 == 0) goto L_0x00f8
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fa
        L_0x00f6:
            r7 = r35
        L_0x00f8:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fa:
            r0 = r0 | r16
            goto L_0x00ff
        L_0x00fd:
            r7 = r35
        L_0x00ff:
            r16 = 234881024(0xe000000, float:1.5777218E-30)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x0118
            r2 = r14 & 256(0x100, float:3.59E-43)
            r6 = r37
            if (r2 != 0) goto L_0x0114
            boolean r2 = r15.changed((long) r6)
            if (r2 == 0) goto L_0x0114
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0116
        L_0x0114:
            r2 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0116:
            r0 = r0 | r2
            goto L_0x011a
        L_0x0118:
            r6 = r37
        L_0x011a:
            r2 = 191739611(0xb6db6db, float:4.5782105E-32)
            r2 = r2 & r0
            r8 = 38347922(0x2492492, float:1.4777643E-37)
            if (r2 != r8) goto L_0x0137
            boolean r2 = r15.getSkipping()
            if (r2 != 0) goto L_0x012a
            goto L_0x0137
        L_0x012a:
            r15.skipToGroupEnd()
            r5 = r32
            r8 = r35
            r10 = r6
            r7 = r34
            r6 = r4
            goto L_0x025d
        L_0x0137:
            r15.startDefaults()
            r2 = r13 & 1
            r16 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            if (r2 == 0) goto L_0x0167
            boolean r2 = r15.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0148
            goto L_0x0167
        L_0x0148:
            r15.skipToGroupEnd()
            r1 = r14 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0151
            r0 = r0 & r16
        L_0x0151:
            r1 = r14 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0159
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r1
        L_0x0159:
            r16 = r32
            r19 = r34
            r20 = r35
            r24 = r0
            r18 = r4
            r22 = r6
            goto L_0x01f1
        L_0x0167:
            if (r1 == 0) goto L_0x016e
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0170
        L_0x016e:
            r1 = r32
        L_0x0170:
            if (r3 == 0) goto L_0x0173
            r4 = 1
        L_0x0173:
            if (r5 == 0) goto L_0x0199
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            java.lang.Object r2 = r15.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x0193
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r15.updateRememberedValue(r2)
        L_0x0193:
            r15.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            goto L_0x019b
        L_0x0199:
            r2 = r34
        L_0x019b:
            r3 = r14 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x01bd
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r5, r8)
            java.lang.Object r3 = r15.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            androidx.compose.ui.graphics.Color r3 = (androidx.compose.ui.graphics.Color) r3
            long r18 = r3.m1942unboximpl()
            r0 = r0 & r16
            goto L_0x01bf
        L_0x01bd:
            r18 = r35
        L_0x01bf:
            r3 = r14 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x01e5
            androidx.compose.material.ContentAlpha r3 = androidx.compose.material.ContentAlpha.INSTANCE
            r5 = 6
            float r22 = r3.getMedium(r15, r5)
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 14
            r27 = 0
            r20 = r18
            long r5 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r20, r22, r23, r24, r25, r26, r27)
            r3 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r3
            r24 = r0
            r16 = r1
            r22 = r5
            goto L_0x01ed
        L_0x01e5:
            r24 = r0
            r16 = r1
            r22 = r6
            r20 = r18
        L_0x01ed:
            r19 = r2
            r18 = r4
        L_0x01f1:
            r15.endDefaults()
            r0 = 1
            r1 = 0
            int r2 = r24 >> 15
            r2 = r2 & 896(0x380, float:1.256E-42)
            r8 = 6
            r2 = r2 | r8
            r3 = 2
            r32 = r0
            r33 = r1
            r34 = r20
            r36 = r15
            r37 = r2
            r38 = r3
            androidx.compose.foundation.Indication r4 = androidx.compose.material.ripple.RippleKt.m1521rememberRipple9IZ8Weo(r32, r33, r34, r36, r37, r38)
            r7 = 866677691(0x33a873bb, float:7.844161E-8)
            androidx.compose.material.TabKt$LeadingIconTab$2 r6 = new androidx.compose.material.TabKt$LeadingIconTab$2
            r0 = r6
            r1 = r16
            r2 = r28
            r3 = r19
            r5 = r18
            r10 = r6
            r6 = r29
            r11 = 866677691(0x33a873bb, float:7.844161E-8)
            r7 = r31
            r11 = 1
            r17 = 6
            r8 = r24
            r9 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = 866677691(0x33a873bb, float:7.844161E-8)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r11, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            int r1 = r24 >> 21
            r2 = r1 & 14
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            int r2 = r24 << 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r32 = r20
            r34 = r22
            r36 = r28
            r37 = r0
            r38 = r15
            r39 = r1
            m1445TabTransitionKlgxPg(r32, r34, r36, r37, r38, r39)
            r5 = r16
            r6 = r18
            r7 = r19
            r8 = r20
            r10 = r22
        L_0x025d:
            androidx.compose.runtime.ScopeUpdateScope r15 = r15.endRestartGroup()
            if (r15 != 0) goto L_0x0264
            goto L_0x027e
        L_0x0264:
            androidx.compose.material.TabKt$LeadingIconTab$3 r16 = new androidx.compose.material.TabKt$LeadingIconTab$3
            r0 = r16
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r12 = r40
            r13 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r10, r12, r13)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x027e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabKt.m1442LeadingIconTab0nDMI0(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:124:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0112  */
    /* renamed from: Tab-EVJuX4I  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1444TabEVJuX4I(boolean r27, kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.ui.Modifier r29, boolean r30, androidx.compose.foundation.interaction.MutableInteractionSource r31, long r32, long r34, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r9 = r28
            r10 = r36
            r11 = r38
            r12 = r39
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 713679175(0x2a89e147, float:2.4492406E-13)
            r1 = r37
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(Tab)P(5,4,3,1,2,6:c#ui.graphics.Color,7:c#ui.graphics.Color)227@10083L39,228@10176L7,229@10268L6,235@10562L60,237@10628L618:Tab.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0029
            r0 = r11 | 6
            r14 = r27
            goto L_0x003b
        L_0x0029:
            r0 = r11 & 14
            r14 = r27
            if (r0 != 0) goto L_0x003a
            boolean r0 = r13.changed((boolean) r14)
            if (r0 == 0) goto L_0x0037
            r0 = 4
            goto L_0x0038
        L_0x0037:
            r0 = 2
        L_0x0038:
            r0 = r0 | r11
            goto L_0x003b
        L_0x003a:
            r0 = r11
        L_0x003b:
            r1 = r12 & 2
            if (r1 == 0) goto L_0x0042
            r0 = r0 | 48
            goto L_0x0052
        L_0x0042:
            r1 = r11 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x0052
            boolean r1 = r13.changed((java.lang.Object) r9)
            if (r1 == 0) goto L_0x004f
            r1 = 32
            goto L_0x0051
        L_0x004f:
            r1 = 16
        L_0x0051:
            r0 = r0 | r1
        L_0x0052:
            r1 = r12 & 4
            if (r1 == 0) goto L_0x0059
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006c
        L_0x0059:
            r2 = r11 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x006c
            r2 = r29
            boolean r3 = r13.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0068
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r3 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r0 = r0 | r3
            goto L_0x006e
        L_0x006c:
            r2 = r29
        L_0x006e:
            r3 = r12 & 8
            if (r3 == 0) goto L_0x0075
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0075:
            r4 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0088
            r4 = r30
            boolean r5 = r13.changed((boolean) r4)
            if (r5 == 0) goto L_0x0084
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0086
        L_0x0084:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0086:
            r0 = r0 | r5
            goto L_0x008a
        L_0x0088:
            r4 = r30
        L_0x008a:
            r5 = r12 & 16
            if (r5 == 0) goto L_0x0091
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a6
        L_0x0091:
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r11
            if (r6 != 0) goto L_0x00a6
            r6 = r31
            boolean r7 = r13.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x00a2
            r7 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a2:
            r7 = 8192(0x2000, float:1.14794E-41)
        L_0x00a4:
            r0 = r0 | r7
            goto L_0x00a8
        L_0x00a6:
            r6 = r31
        L_0x00a8:
            r7 = 458752(0x70000, float:6.42848E-40)
            r7 = r7 & r11
            if (r7 != 0) goto L_0x00c2
            r7 = r12 & 32
            if (r7 != 0) goto L_0x00bc
            r7 = r32
            boolean r15 = r13.changed((long) r7)
            if (r15 == 0) goto L_0x00be
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00bc:
            r7 = r32
        L_0x00be:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00c0:
            r0 = r0 | r15
            goto L_0x00c4
        L_0x00c2:
            r7 = r32
        L_0x00c4:
            r15 = 3670016(0x380000, float:5.142788E-39)
            r15 = r15 & r11
            if (r15 != 0) goto L_0x00dc
            r15 = r12 & 64
            r6 = r34
            if (r15 != 0) goto L_0x00d8
            boolean r8 = r13.changed((long) r6)
            if (r8 == 0) goto L_0x00d8
            r8 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00da
        L_0x00d8:
            r8 = 524288(0x80000, float:7.34684E-40)
        L_0x00da:
            r0 = r0 | r8
            goto L_0x00de
        L_0x00dc:
            r6 = r34
        L_0x00de:
            r8 = r12 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x00e6
            r8 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00e4:
            r0 = r0 | r8
            goto L_0x00f7
        L_0x00e6:
            r8 = 29360128(0x1c00000, float:7.052966E-38)
            r8 = r8 & r11
            if (r8 != 0) goto L_0x00f7
            boolean r8 = r13.changed((java.lang.Object) r10)
            if (r8 == 0) goto L_0x00f4
            r8 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e4
        L_0x00f4:
            r8 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00e4
        L_0x00f7:
            r8 = 23967451(0x16db6db, float:4.3661218E-38)
            r8 = r8 & r0
            r15 = 4793490(0x492492, float:6.71711E-39)
            if (r8 != r15) goto L_0x0112
            boolean r8 = r13.getSkipping()
            if (r8 != 0) goto L_0x0107
            goto L_0x0112
        L_0x0107:
            r13.skipToGroupEnd()
            r5 = r31
            r3 = r2
            r8 = r6
            r6 = r32
            goto L_0x022e
        L_0x0112:
            r13.startDefaults()
            r8 = r11 & 1
            r16 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r8 == 0) goto L_0x0142
            boolean r8 = r13.getDefaultsInvalid()
            if (r8 == 0) goto L_0x0123
            goto L_0x0142
        L_0x0123:
            r13.skipToGroupEnd()
            r1 = r12 & 32
            if (r1 == 0) goto L_0x012c
            r0 = r0 & r16
        L_0x012c:
            r1 = r12 & 64
            if (r1 == 0) goto L_0x0134
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r0 = r0 & r1
        L_0x0134:
            r18 = r31
            r19 = r32
            r23 = r0
            r16 = r2
            r17 = r4
            r21 = r6
            goto L_0x01cb
        L_0x0142:
            if (r1 == 0) goto L_0x0149
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x014a
        L_0x0149:
            r1 = r2
        L_0x014a:
            if (r3 == 0) goto L_0x014d
            r4 = 1
        L_0x014d:
            if (r5 == 0) goto L_0x0173
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r13.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            java.lang.Object r2 = r13.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x016d
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r13.updateRememberedValue(r2)
        L_0x016d:
            r13.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            goto L_0x0175
        L_0x0173:
            r2 = r31
        L_0x0175:
            r3 = r12 & 32
            if (r3 == 0) goto L_0x0197
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r8)
            java.lang.Object r3 = r13.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.graphics.Color r3 = (androidx.compose.ui.graphics.Color) r3
            long r17 = r3.m1942unboximpl()
            r0 = r0 & r16
            goto L_0x0199
        L_0x0197:
            r17 = r32
        L_0x0199:
            r3 = r12 & 64
            if (r3 == 0) goto L_0x01bf
            androidx.compose.material.ContentAlpha r3 = androidx.compose.material.ContentAlpha.INSTANCE
            r5 = 6
            float r21 = r3.getMedium(r13, r5)
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 14
            r26 = 0
            r19 = r17
            long r5 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r19, r21, r22, r23, r24, r25, r26)
            r3 = -3670017(0xffffffffffc7ffff, float:NaN)
            r0 = r0 & r3
            r23 = r0
            r16 = r1
            r21 = r5
            goto L_0x01c7
        L_0x01bf:
            r23 = r0
            r16 = r1
            r21 = r6
            r19 = r17
        L_0x01c7:
            r18 = r2
            r17 = r4
        L_0x01cb:
            r13.endDefaults()
            r0 = 1
            r1 = 0
            int r2 = r23 >> 9
            r2 = r2 & 896(0x380, float:1.256E-42)
            r3 = 6
            r2 = r2 | r3
            r3 = 2
            r29 = r0
            r30 = r1
            r31 = r19
            r33 = r13
            r34 = r2
            r35 = r3
            androidx.compose.foundation.Indication r4 = androidx.compose.material.ripple.RippleKt.m1521rememberRipple9IZ8Weo(r29, r30, r31, r33, r34, r35)
            r8 = -1237246709(0xffffffffb6411d0b, float:-2.8776146E-6)
            androidx.compose.material.TabKt$Tab$5 r7 = new androidx.compose.material.TabKt$Tab$5
            r0 = r7
            r1 = r16
            r2 = r27
            r3 = r18
            r5 = r17
            r6 = r28
            r15 = r7
            r7 = r36
            r9 = -1237246709(0xffffffffb6411d0b, float:-2.8776146E-6)
            r8 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r9, r0, r15)
            r6 = r0
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            int r0 = r23 >> 15
            r1 = r0 & 14
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = 6
            int r1 = r23 << 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r8 = r0 | r1
            r1 = r19
            r3 = r21
            r5 = r27
            r7 = r13
            m1445TabTransitionKlgxPg(r1, r3, r5, r6, r7, r8)
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r8 = r21
        L_0x022e:
            androidx.compose.runtime.ScopeUpdateScope r13 = r13.endRestartGroup()
            if (r13 != 0) goto L_0x0235
            goto L_0x024a
        L_0x0235:
            androidx.compose.material.TabKt$Tab$6 r15 = new androidx.compose.material.TabKt$Tab$6
            r0 = r15
            r1 = r27
            r2 = r28
            r10 = r36
            r11 = r38
            r12 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r11, r12)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r13.updateScope(r15)
        L_0x024a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabKt.m1444TabEVJuX4I(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: TabTransition-Klgx-Pg  reason: not valid java name */
    public static final void m1445TabTransitionKlgxPg(long j, long j2, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-405571117);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)268@11677L26,269@11732L550,287@12287L164:Tab.kt#jmzs0o");
        long j3 = j;
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed(j3) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        long j4 = j2;
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed(j4) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        } else {
            boolean z2 = z;
        }
        if ((i3 & 7168) == 0) {
            i2 |= startRestartGroup.changed((Object) function22) ? 2048 : 1024;
        }
        if ((i2 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            int i4 = i2 >> 6;
            Transition updateTransition = TransitionKt.updateTransition(Boolean.valueOf(z), (String) null, startRestartGroup, i4 & 14, 2);
            Function3 function3 = TabKt$TabTransition$color$2.INSTANCE;
            startRestartGroup.startReplaceableGroup(-1462136984);
            ComposerKt.sourceInformation(startRestartGroup, "C(animateColor)P(2)68@3224L31,69@3291L70,73@3374L70:Transition.kt#xbi5r1");
            boolean booleanValue = ((Boolean) updateTransition.getTargetState()).booleanValue();
            startRestartGroup.startReplaceableGroup(1445938070);
            ComposerKt.sourceInformation(startRestartGroup, "C:Tab.kt#jmzs0o");
            long j5 = booleanValue ? j3 : j4;
            startRestartGroup.endReplaceableGroup();
            ColorSpace r10 = Color.m1936getColorSpaceimpl(j5);
            startRestartGroup.startReplaceableGroup(-3686930);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) r10);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(r10);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            TwoWayConverter twoWayConverter = (TwoWayConverter) rememberedValue;
            startRestartGroup.startReplaceableGroup(1847725064);
            ComposerKt.sourceInformation(startRestartGroup, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
            boolean booleanValue2 = ((Boolean) updateTransition.getCurrentState()).booleanValue();
            startRestartGroup.startReplaceableGroup(1445938070);
            ComposerKt.sourceInformation(startRestartGroup, "C:Tab.kt#jmzs0o");
            long j6 = booleanValue2 ? j3 : j4;
            startRestartGroup.endReplaceableGroup();
            Color r102 = Color.m1922boximpl(j6);
            boolean booleanValue3 = ((Boolean) updateTransition.getTargetState()).booleanValue();
            startRestartGroup.startReplaceableGroup(1445938070);
            ComposerKt.sourceInformation(startRestartGroup, "C:Tab.kt#jmzs0o");
            long j7 = booleanValue3 ? j3 : j4;
            startRestartGroup.endReplaceableGroup();
            State createTransitionAnimation = TransitionKt.createTransitionAnimation(updateTransition, r102, Color.m1922boximpl(j7), (FiniteAnimationSpec) function3.invoke(updateTransition.getSegment(), startRestartGroup, 0), twoWayConverter, "ColorAnimation", startRestartGroup, 32768);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1922boximpl(Color.m1931copywmQWz5c$default(m1446TabTransition_Klgx_Pg$lambda5(createTransitionAnimation), 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1934getAlphaimpl(m1446TabTransition_Klgx_Pg$lambda5(createTransitionAnimation))))}, function22, startRestartGroup, (i4 & 112) | 8);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TabKt$TabTransition$1(j, j2, z, function2, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void TabBaselineLayout(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(1249848471);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabBaselineLayout)P(1)304@12859L1909:Tab.kt#jmzs0o");
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) function23) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) function24) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            MeasurePolicy tabKt$TabBaselineLayout$2 = new TabKt$TabBaselineLayout$2(function23, function24);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r11 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r11, tabKt$TabBaselineLayout$2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r11, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r11, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r11, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(1142473408);
            ComposerKt.sourceInformation(startRestartGroup, "C312@13111L41:Tab.kt#jmzs0o");
            startRestartGroup.startReplaceableGroup(-2141028452);
            ComposerKt.sourceInformation(startRestartGroup, "307@12925L123");
            if (function23 != null) {
                Modifier r5 = PaddingKt.m512paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "text"), HorizontalTextPadding, 0.0f, 2, (Object) null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density2 = (Density) consume4;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LayoutDirection layoutDirection2 = (LayoutDirection) consume5;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r5);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer r10 = Updater.m1543constructorimpl(startRestartGroup);
                Updater.m1550setimpl(r10, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m1550setimpl(r10, density2, ComposeUiNode.Companion.getSetDensity());
                Updater.m1550setimpl(r10, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m1550setimpl(r10, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf2.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(-459869377);
                ComposerKt.sourceInformation(startRestartGroup, "C309@13040L6:Tab.kt#jmzs0o");
                function23.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            if (function24 != null) {
                Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, "icon");
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume7 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density3 = (Density) consume7;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume8 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LayoutDirection layoutDirection3 = (LayoutDirection) consume8;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume9 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) consume9;
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(layoutId);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer r112 = Updater.m1543constructorimpl(startRestartGroup);
                Updater.m1550setimpl(r112, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m1550setimpl(r112, density3, ComposeUiNode.Companion.getSetDensity());
                Updater.m1550setimpl(r112, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m1550setimpl(r112, viewConfiguration3, ComposeUiNode.Companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf3.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(892169960);
                ComposerKt.sourceInformation(startRestartGroup, "C312@13144L6:Tab.kt#jmzs0o");
                function24.invoke(startRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TabKt$TabBaselineLayout$3(function23, function24, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final void placeTextOrIcon(Placeable.PlacementScope placementScope, Placeable placeable, int i) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, (i - placeable.getHeight()) / 2, 0.0f, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void placeTextAndIcon(Placeable.PlacementScope placementScope, Density density, Placeable placeable, Placeable placeable2, int i, int i2, int i3, int i4) {
        float f;
        Density density2 = density;
        int i5 = i3;
        int i6 = i4;
        if (i5 == i6) {
            f = SingleLineTextBaselineWithIcon;
        } else {
            f = DoubleLineTextBaselineWithIcon;
        }
        int r3 = density.m4643roundToPx0680j_4(f) + density.m4643roundToPx0680j_4(TabRowDefaults.INSTANCE.m1455getIndicatorHeightD9Ej5fM());
        int height = (placeable2.getHeight() + density.m4642roundToPxR2X_6o(IconDistanceFromBaseline)) - i5;
        int i7 = (i2 - i6) - r3;
        Placeable.PlacementScope placementScope2 = placementScope;
        Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, (i - placeable.getWidth()) / 2, i7, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default(placementScope2, placeable2, (i - placeable2.getWidth()) / 2, i7 - height, 0.0f, 4, (Object) null);
    }

    /* renamed from: TabTransition_Klgx_Pg$lambda-5  reason: not valid java name */
    private static final long m1446TabTransition_Klgx_Pg$lambda5(State<Color> state) {
        return state.getValue().m1942unboximpl();
    }
}
