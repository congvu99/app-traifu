package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0017\u001a\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a-\u0010\u0019\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0016\u0010 \u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u001a\u0016\u0010!\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u001a\u0016\u0010\"\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u001a!\u0010#\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010#\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%\u001a-\u0010&\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010'\u001a\u00020\u001c2\b\b\u0002\u0010(\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010\u001f\u001a!\u0010*\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010#\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010%\u001a-\u0010,\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010'\u001a\u00020\u001c2\b\b\u0002\u0010(\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010\u001f\u001a!\u0010.\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010/\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u0010%\u001a)\u0010.\u001a\u00020\u001a*\u00020\u001a2\u0006\u00101\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u0010\u001f\u001a!\u0010.\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010/\u001a\u000203H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105\u001aA\u00106\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u00107\u001a\u00020\u001c2\b\b\u0002\u00108\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:\u001a!\u0010;\u001a\u00020\u001a*\u00020\u001a2\u0006\u00101\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010%\u001a-\u0010=\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010'\u001a\u00020\u001c2\b\b\u0002\u0010(\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010\u001f\u001a!\u0010/\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010/\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010%\u001a)\u0010/\u001a\u00020\u001a*\u00020\u001a2\u0006\u00101\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u0010\u001f\u001a!\u0010/\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010/\u001a\u000203H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bA\u00105\u001aA\u0010B\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u00107\u001a\u00020\u001c2\b\b\u0002\u00108\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010:\u001a!\u00101\u001a\u00020\u001a*\u00020\u001a2\u0006\u00101\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bD\u0010%\u001a-\u0010E\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010'\u001a\u00020\u001c2\b\b\u0002\u0010(\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bF\u0010\u001f\u001a \u0010G\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007\u001a \u0010H\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\u00162\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007\u001a \u0010I\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\u00182\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006J"}, d2 = {"FillWholeMaxHeight", "Landroidx/compose/foundation/layout/FillModifier;", "FillWholeMaxSize", "FillWholeMaxWidth", "WrapContentHeightCenter", "Landroidx/compose/foundation/layout/WrapContentModifier;", "WrapContentHeightTop", "WrapContentSizeCenter", "WrapContentSizeTopStart", "WrapContentWidthCenter", "WrapContentWidthStart", "createFillHeightModifier", "fraction", "", "createFillSizeModifier", "createFillWidthModifier", "createWrapContentHeightModifier", "align", "Landroidx/compose/ui/Alignment$Vertical;", "unbounded", "", "createWrapContentSizeModifier", "Landroidx/compose/ui/Alignment;", "createWrapContentWidthModifier", "Landroidx/compose/ui/Alignment$Horizontal;", "defaultMinSize", "Landroidx/compose/ui/Modifier;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "defaultMinSize-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "fillMaxHeight", "fillMaxSize", "fillMaxWidth", "height", "height-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "heightIn", "min", "max", "heightIn-VpY3zN4", "requiredHeight", "requiredHeight-3ABfNKs", "requiredHeightIn", "requiredHeightIn-VpY3zN4", "requiredSize", "size", "requiredSize-3ABfNKs", "width", "requiredSize-VpY3zN4", "Landroidx/compose/ui/unit/DpSize;", "requiredSize-6HolHcs", "(Landroidx/compose/ui/Modifier;J)Landroidx/compose/ui/Modifier;", "requiredSizeIn", "maxWidth", "maxHeight", "requiredSizeIn-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "requiredWidth", "requiredWidth-3ABfNKs", "requiredWidthIn", "requiredWidthIn-VpY3zN4", "size-3ABfNKs", "size-VpY3zN4", "size-6HolHcs", "sizeIn", "sizeIn-qDBjuR0", "width-3ABfNKs", "widthIn", "widthIn-VpY3zN4", "wrapContentHeight", "wrapContentSize", "wrapContentWidth", "foundation-layout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Size.kt */
public final class SizeKt {
    private static final FillModifier FillWholeMaxHeight = createFillHeightModifier(1.0f);
    private static final FillModifier FillWholeMaxSize = createFillSizeModifier(1.0f);
    private static final FillModifier FillWholeMaxWidth = createFillWidthModifier(1.0f);
    private static final WrapContentModifier WrapContentHeightCenter = createWrapContentHeightModifier(Alignment.Companion.getCenterVertically(), false);
    private static final WrapContentModifier WrapContentHeightTop = createWrapContentHeightModifier(Alignment.Companion.getTop(), false);
    private static final WrapContentModifier WrapContentSizeCenter = createWrapContentSizeModifier(Alignment.Companion.getCenter(), false);
    private static final WrapContentModifier WrapContentSizeTopStart = createWrapContentSizeModifier(Alignment.Companion.getTopStart(), false);
    private static final WrapContentModifier WrapContentWidthCenter = createWrapContentWidthModifier(Alignment.Companion.getCenterHorizontally(), false);
    private static final WrapContentModifier WrapContentWidthStart = createWrapContentWidthModifier(Alignment.Companion.getStart(), false);

    /* renamed from: width-3ABfNKs  reason: not valid java name */
    public static final Modifier m587width3ABfNKs(Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "$this$width");
        return modifier.then(new SizeModifier(f, 0.0f, f, 0.0f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$width3ABfNKs$$inlined$debugInspectorInfo$1(f) : InspectableValueKt.getNoInspectorInfo(), 10, (DefaultConstructorMarker) null));
    }

    /* renamed from: height-3ABfNKs  reason: not valid java name */
    public static final Modifier m568height3ABfNKs(Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "$this$height");
        return modifier.then(new SizeModifier(0.0f, f, 0.0f, f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$height3ABfNKs$$inlined$debugInspectorInfo$1(f) : InspectableValueKt.getNoInspectorInfo(), 5, (DefaultConstructorMarker) null));
    }

    /* renamed from: size-6HolHcs  reason: not valid java name */
    public static final Modifier m583size6HolHcs(Modifier modifier, long j) {
        Intrinsics.checkNotNullParameter(modifier, "$this$size");
        return m584sizeVpY3zN4(modifier, DpSize.m4802getWidthD9Ej5fM(j), DpSize.m4800getHeightD9Ej5fM(j));
    }

    /* renamed from: widthIn-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m589widthInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m4724getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m4724getUnspecifiedD9Ej5fM();
        }
        return m588widthInVpY3zN4(modifier, f, f2);
    }

    /* renamed from: widthIn-VpY3zN4  reason: not valid java name */
    public static final Modifier m588widthInVpY3zN4(Modifier modifier, float f, float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$widthIn");
        return modifier.then(new SizeModifier(f, 0.0f, f2, 0.0f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$widthInVpY3zN4$$inlined$debugInspectorInfo$1(f, f2) : InspectableValueKt.getNoInspectorInfo(), 10, (DefaultConstructorMarker) null));
    }

    /* renamed from: heightIn-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m570heightInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m4724getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m4724getUnspecifiedD9Ej5fM();
        }
        return m569heightInVpY3zN4(modifier, f, f2);
    }

    /* renamed from: heightIn-VpY3zN4  reason: not valid java name */
    public static final Modifier m569heightInVpY3zN4(Modifier modifier, float f, float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$heightIn");
        return modifier.then(new SizeModifier(0.0f, f, 0.0f, f2, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$heightInVpY3zN4$$inlined$debugInspectorInfo$1(f, f2) : InspectableValueKt.getNoInspectorInfo(), 5, (DefaultConstructorMarker) null));
    }

    /* renamed from: sizeIn-qDBjuR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m586sizeInqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m4724getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m4724getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f3 = Dp.Companion.m4724getUnspecifiedD9Ej5fM();
        }
        if ((i & 8) != 0) {
            f4 = Dp.Companion.m4724getUnspecifiedD9Ej5fM();
        }
        return m585sizeInqDBjuR0(modifier, f, f2, f3, f4);
    }

    /* renamed from: sizeIn-qDBjuR0  reason: not valid java name */
    public static final Modifier m585sizeInqDBjuR0(Modifier modifier, float f, float f2, float f3, float f4) {
        Intrinsics.checkNotNullParameter(modifier, "$this$sizeIn");
        return modifier.then(new SizeModifier(f, f2, f3, f4, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$sizeInqDBjuR0$$inlined$debugInspectorInfo$1(f, f2, f3, f4) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredWidth-3ABfNKs  reason: not valid java name */
    public static final Modifier m579requiredWidth3ABfNKs(Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredWidth");
        return modifier.then(new SizeModifier(f, 0.0f, f, 0.0f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredWidth3ABfNKs$$inlined$debugInspectorInfo$1(f) : InspectableValueKt.getNoInspectorInfo(), 10, (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredHeight-3ABfNKs  reason: not valid java name */
    public static final Modifier m571requiredHeight3ABfNKs(Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredHeight");
        return modifier.then(new SizeModifier(0.0f, f, 0.0f, f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredHeight3ABfNKs$$inlined$debugInspectorInfo$1(f) : InspectableValueKt.getNoInspectorInfo(), 5, (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredSize-6HolHcs  reason: not valid java name */
    public static final Modifier m575requiredSize6HolHcs(Modifier modifier, long j) {
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredSize");
        return m576requiredSizeVpY3zN4(modifier, DpSize.m4802getWidthD9Ej5fM(j), DpSize.m4800getHeightD9Ej5fM(j));
    }

    /* renamed from: requiredWidthIn-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m581requiredWidthInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m4724getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m4724getUnspecifiedD9Ej5fM();
        }
        return m580requiredWidthInVpY3zN4(modifier, f, f2);
    }

    /* renamed from: requiredWidthIn-VpY3zN4  reason: not valid java name */
    public static final Modifier m580requiredWidthInVpY3zN4(Modifier modifier, float f, float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredWidthIn");
        return modifier.then(new SizeModifier(f, 0.0f, f2, 0.0f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredWidthInVpY3zN4$$inlined$debugInspectorInfo$1(f, f2) : InspectableValueKt.getNoInspectorInfo(), 10, (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredHeightIn-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m573requiredHeightInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m4724getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m4724getUnspecifiedD9Ej5fM();
        }
        return m572requiredHeightInVpY3zN4(modifier, f, f2);
    }

    /* renamed from: requiredHeightIn-VpY3zN4  reason: not valid java name */
    public static final Modifier m572requiredHeightInVpY3zN4(Modifier modifier, float f, float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredHeightIn");
        return modifier.then(new SizeModifier(0.0f, f, 0.0f, f2, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredHeightInVpY3zN4$$inlined$debugInspectorInfo$1(f, f2) : InspectableValueKt.getNoInspectorInfo(), 5, (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredSizeIn-qDBjuR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m578requiredSizeInqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m4724getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m4724getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f3 = Dp.Companion.m4724getUnspecifiedD9Ej5fM();
        }
        if ((i & 8) != 0) {
            f4 = Dp.Companion.m4724getUnspecifiedD9Ej5fM();
        }
        return m577requiredSizeInqDBjuR0(modifier, f, f2, f3, f4);
    }

    /* renamed from: requiredSizeIn-qDBjuR0  reason: not valid java name */
    public static final Modifier m577requiredSizeInqDBjuR0(Modifier modifier, float f, float f2, float f3, float f4) {
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredSizeIn");
        return modifier.then(new SizeModifier(f, f2, f3, f4, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredSizeInqDBjuR0$$inlined$debugInspectorInfo$1(f, f2, f3, f4) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ Modifier fillMaxWidth$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxWidth(modifier, f);
    }

    public static final Modifier fillMaxWidth(Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return modifier.then((f > 1.0f ? 1 : (f == 1.0f ? 0 : -1)) == 0 ? FillWholeMaxWidth : createFillWidthModifier(f));
    }

    public static /* synthetic */ Modifier fillMaxHeight$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxHeight(modifier, f);
    }

    public static final Modifier fillMaxHeight(Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return modifier.then((f > 1.0f ? 1 : (f == 1.0f ? 0 : -1)) == 0 ? FillWholeMaxHeight : createFillHeightModifier(f));
    }

    public static /* synthetic */ Modifier fillMaxSize$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxSize(modifier, f);
    }

    public static final Modifier fillMaxSize(Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return modifier.then((f > 1.0f ? 1 : (f == 1.0f ? 0 : -1)) == 0 ? FillWholeMaxSize : createFillSizeModifier(f));
    }

    public static /* synthetic */ Modifier wrapContentWidth$default(Modifier modifier, Alignment.Horizontal horizontal, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            horizontal = Alignment.Companion.getCenterHorizontally();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentWidth(modifier, horizontal, z);
    }

    public static final Modifier wrapContentWidth(Modifier modifier, Alignment.Horizontal horizontal, boolean z) {
        WrapContentModifier wrapContentModifier;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(horizontal, "align");
        if (Intrinsics.areEqual((Object) horizontal, (Object) Alignment.Companion.getCenterHorizontally()) && !z) {
            wrapContentModifier = WrapContentWidthCenter;
        } else if (!Intrinsics.areEqual((Object) horizontal, (Object) Alignment.Companion.getStart()) || z) {
            wrapContentModifier = createWrapContentWidthModifier(horizontal, z);
        } else {
            wrapContentModifier = WrapContentWidthStart;
        }
        return modifier.then(wrapContentModifier);
    }

    public static /* synthetic */ Modifier wrapContentHeight$default(Modifier modifier, Alignment.Vertical vertical, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            vertical = Alignment.Companion.getCenterVertically();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentHeight(modifier, vertical, z);
    }

    public static final Modifier wrapContentHeight(Modifier modifier, Alignment.Vertical vertical, boolean z) {
        WrapContentModifier wrapContentModifier;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(vertical, "align");
        if (Intrinsics.areEqual((Object) vertical, (Object) Alignment.Companion.getCenterVertically()) && !z) {
            wrapContentModifier = WrapContentHeightCenter;
        } else if (!Intrinsics.areEqual((Object) vertical, (Object) Alignment.Companion.getTop()) || z) {
            wrapContentModifier = createWrapContentHeightModifier(vertical, z);
        } else {
            wrapContentModifier = WrapContentHeightTop;
        }
        return modifier.then(wrapContentModifier);
    }

    public static /* synthetic */ Modifier wrapContentSize$default(Modifier modifier, Alignment alignment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            alignment = Alignment.Companion.getCenter();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentSize(modifier, alignment, z);
    }

    public static final Modifier wrapContentSize(Modifier modifier, Alignment alignment, boolean z) {
        WrapContentModifier wrapContentModifier;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(alignment, "align");
        if (Intrinsics.areEqual((Object) alignment, (Object) Alignment.Companion.getCenter()) && !z) {
            wrapContentModifier = WrapContentSizeCenter;
        } else if (!Intrinsics.areEqual((Object) alignment, (Object) Alignment.Companion.getTopStart()) || z) {
            wrapContentModifier = createWrapContentSizeModifier(alignment, z);
        } else {
            wrapContentModifier = WrapContentSizeTopStart;
        }
        return modifier.then(wrapContentModifier);
    }

    /* renamed from: defaultMinSize-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m567defaultMinSizeVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m4724getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m4724getUnspecifiedD9Ej5fM();
        }
        return m566defaultMinSizeVpY3zN4(modifier, f, f2);
    }

    /* renamed from: defaultMinSize-VpY3zN4  reason: not valid java name */
    public static final Modifier m566defaultMinSizeVpY3zN4(Modifier modifier, float f, float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$defaultMinSize");
        return modifier.then(new UnspecifiedConstraintsModifier(f, f2, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$defaultMinSizeVpY3zN4$$inlined$debugInspectorInfo$1(f, f2) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    private static final FillModifier createFillWidthModifier(float f) {
        return new FillModifier(Direction.Horizontal, f, new SizeKt$createFillWidthModifier$1(f));
    }

    private static final FillModifier createFillHeightModifier(float f) {
        return new FillModifier(Direction.Vertical, f, new SizeKt$createFillHeightModifier$1(f));
    }

    private static final FillModifier createFillSizeModifier(float f) {
        return new FillModifier(Direction.Both, f, new SizeKt$createFillSizeModifier$1(f));
    }

    private static final WrapContentModifier createWrapContentWidthModifier(Alignment.Horizontal horizontal, boolean z) {
        return new WrapContentModifier(Direction.Horizontal, z, new SizeKt$createWrapContentWidthModifier$1(horizontal), horizontal, new SizeKt$createWrapContentWidthModifier$2(horizontal, z));
    }

    private static final WrapContentModifier createWrapContentHeightModifier(Alignment.Vertical vertical, boolean z) {
        return new WrapContentModifier(Direction.Vertical, z, new SizeKt$createWrapContentHeightModifier$1(vertical), vertical, new SizeKt$createWrapContentHeightModifier$2(vertical, z));
    }

    private static final WrapContentModifier createWrapContentSizeModifier(Alignment alignment, boolean z) {
        return new WrapContentModifier(Direction.Both, z, new SizeKt$createWrapContentSizeModifier$1(alignment), alignment, new SizeKt$createWrapContentSizeModifier$2(alignment, z));
    }

    /* renamed from: size-3ABfNKs  reason: not valid java name */
    public static final Modifier m582size3ABfNKs(Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "$this$size");
        return modifier.then(new SizeModifier(f, f, f, f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$size3ABfNKs$$inlined$debugInspectorInfo$1(f) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: size-VpY3zN4  reason: not valid java name */
    public static final Modifier m584sizeVpY3zN4(Modifier modifier, float f, float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$size");
        return modifier.then(new SizeModifier(f, f2, f, f2, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$sizeVpY3zN4$$inlined$debugInspectorInfo$1(f, f2) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredSize-3ABfNKs  reason: not valid java name */
    public static final Modifier m574requiredSize3ABfNKs(Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredSize");
        return modifier.then(new SizeModifier(f, f, f, f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredSize3ABfNKs$$inlined$debugInspectorInfo$1(f) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredSize-VpY3zN4  reason: not valid java name */
    public static final Modifier m576requiredSizeVpY3zN4(Modifier modifier, float f, float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredSize");
        return modifier.then(new SizeModifier(f, f2, f, f2, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredSizeVpY3zN4$$inlined$debugInspectorInfo$1(f, f2) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }
}
