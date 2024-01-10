package io.intercom.android.sdk.m5.shapes;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0005J-\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Lio/intercom/android/sdk/m5/shapes/CutAvatarShape;", "Landroidx/compose/ui/graphics/Shape;", "shape", "cut", "Landroidx/compose/ui/unit/Dp;", "(Landroidx/compose/ui/graphics/Shape;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "getOffset", "Landroidx/compose/ui/geometry/Offset;", "xOffset", "", "getOffset-dBAh8RU", "(FLandroidx/compose/ui/unit/LayoutDirection;)J", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CutAvatarShape.kt */
public final class CutAvatarShape implements Shape {
    private final float cut;
    private final Shape shape;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CutAvatarShape.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ CutAvatarShape(Shape shape2, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(shape2, f);
    }

    private CutAvatarShape(Shape shape2, float f) {
        this.shape = shape2;
        this.cut = f;
    }

    /* renamed from: createOutline-Pq9zytI  reason: not valid java name */
    public Outline m5263createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, ViewProps.LAYOUT_DIRECTION);
        Intrinsics.checkNotNullParameter(density, "density");
        float r0 = density.m4649toPx0680j_4(this.cut);
        Path Path = AndroidPath_androidKt.Path();
        OutlineKt.addOutline(Path, this.shape.m2266createOutlinePq9zytI(j, layoutDirection, density));
        Path Path2 = AndroidPath_androidKt.Path();
        Path2.m2183addPathUv8p0NA(Path, m5262getOffsetdBAh8RU(r0 - Size.m1752getWidthimpl(j), layoutDirection));
        Path Path3 = AndroidPath_androidKt.Path();
        Path3.m2185opN5in7k0(Path, Path2, PathOperation.Companion.m2208getDifferenceb3I0S0c());
        return new Outline.Generic(Path3);
    }

    /* renamed from: getOffset-dBAh8RU  reason: not valid java name */
    private final long m5262getOffsetdBAh8RU(float f, LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        if (i == 1) {
            return OffsetKt.Offset(f, 0.0f);
        }
        if (i == 2) {
            return OffsetKt.Offset(-f, 0.0f);
        }
        throw new NoWhenBranchMatchedException();
    }
}
