package io.intercom.android.sdk.m5.shapes;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B2\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00070\u0006ø\u0001\u0000¢\u0006\u0002\u0010\bJ-\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J8\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fH\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\tR#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00070\u0006X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Lio/intercom/android/sdk/m5/shapes/CutAvatarBoxShape;", "Landroidx/compose/ui/graphics/Shape;", "shape", "cut", "Landroidx/compose/ui/unit/Dp;", "cutsOffsets", "", "Lkotlin/Pair;", "(Landroidx/compose/ui/graphics/Shape;FLjava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "getOffset", "Landroidx/compose/ui/geometry/Offset;", "", "xOffset", "yOffset", "getOffset-Rc2DDho", "(FFFLandroidx/compose/ui/unit/LayoutDirection;)J", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CutAvatarBoxShape.kt */
public final class CutAvatarBoxShape implements Shape {
    private final float cut;
    private final List<Pair<Dp, Dp>> cutsOffsets;
    private final Shape shape;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CutAvatarBoxShape.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ CutAvatarBoxShape(Shape shape2, float f, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(shape2, f, list);
    }

    private CutAvatarBoxShape(Shape shape2, float f, List<Pair<Dp, Dp>> list) {
        this.shape = shape2;
        this.cut = f;
        this.cutsOffsets = list;
    }

    /* renamed from: createOutline-Pq9zytI  reason: not valid java name */
    public Outline m5261createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, ViewProps.LAYOUT_DIRECTION);
        Intrinsics.checkNotNullParameter(density, "density");
        float r0 = density.m4649toPx0680j_4(this.cut);
        Path Path = AndroidPath_androidKt.Path();
        OutlineKt.addOutline(Path, this.shape.m2266createOutlinePq9zytI(j, layoutDirection, density));
        Path Path2 = AndroidPath_androidKt.Path();
        OutlineKt.addOutline(Path2, this.shape.m2266createOutlinePq9zytI(SizeKt.Size(Size.m1752getWidthimpl(j) + r0, Size.m1749getHeightimpl(j) + r0), layoutDirection, density));
        Path Path3 = AndroidPath_androidKt.Path();
        Iterable<Pair> iterable = this.cutsOffsets;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Pair pair : iterable) {
            Path3.m2183addPathUv8p0NA(Path2, m5260getOffsetRc2DDho(r0 / ((float) 2), density.m4649toPx0680j_4(((Dp) pair.component1()).m4718unboximpl()), density.m4649toPx0680j_4(((Dp) pair.component2()).m4718unboximpl()), layoutDirection));
            arrayList.add(Unit.INSTANCE);
        }
        List list = (List) arrayList;
        Path Path4 = AndroidPath_androidKt.Path();
        Path4.m2185opN5in7k0(Path, Path3, PathOperation.Companion.m2208getDifferenceb3I0S0c());
        return new Outline.Generic(Path4);
    }

    /* renamed from: getOffset-Rc2DDho  reason: not valid java name */
    private final long m5260getOffsetRc2DDho(float f, float f2, float f3, LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        if (i == 1) {
            return OffsetKt.Offset(f2 - f, f3 - f);
        }
        if (i == 2) {
            return OffsetKt.Offset((-f2) - f, f3 - f);
        }
        throw new NoWhenBranchMatchedException();
    }
}
