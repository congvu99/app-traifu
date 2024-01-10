package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.vector.ImageVector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\b\u0012H\bø\u0001\u0000\u001a\u0001\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\b\u0012H\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b#\u0010$\u0002\u0012\n\u0005\b20\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006%"}, d2 = {"group", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "name", "", "rotate", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "path", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "pathBuilder", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "path-R_LF-3I", "(Landroidx/compose/ui/graphics/vector/ImageVector$Builder;Ljava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImageVector.kt */
public final class ImageVectorKt {
    /* renamed from: path-R_LF-3I$default  reason: not valid java name */
    public static /* synthetic */ ImageVector.Builder m2622pathR_LF3I$default(ImageVector.Builder builder, String str, Brush brush, float f, Brush brush2, float f2, float f3, int i, int i2, float f4, int i3, Function1 function1, int i4, Object obj) {
        int i5;
        Function1 function12 = function1;
        int i6 = i4;
        String str2 = (i6 & 1) != 0 ? "" : str;
        Brush brush3 = (i6 & 2) != 0 ? null : brush;
        float f5 = (i6 & 4) != 0 ? 1.0f : f;
        Brush brush4 = (i6 & 8) != 0 ? null : brush2;
        float f6 = (i6 & 16) != 0 ? 1.0f : f2;
        float f7 = (i6 & 32) != 0 ? 0.0f : f3;
        int defaultStrokeLineCap = (i6 & 64) != 0 ? VectorKt.getDefaultStrokeLineCap() : i;
        int defaultStrokeLineJoin = (i6 & 128) != 0 ? VectorKt.getDefaultStrokeLineJoin() : i2;
        float f8 = (i6 & 256) != 0 ? 4.0f : f4;
        if ((i6 & 512) != 0) {
            i5 = VectorKt.getDefaultFillType();
        } else {
            i5 = i3;
        }
        Intrinsics.checkNotNullParameter(builder, "$this$path");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(function12, "pathBuilder");
        PathBuilder pathBuilder = new PathBuilder();
        function12.invoke(pathBuilder);
        return ImageVector.Builder.m2619addPathoIyEayM$default(builder, pathBuilder.getNodes(), i5, str2, brush3, f5, brush4, f6, f7, defaultStrokeLineCap, defaultStrokeLineJoin, f8, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
    }

    public static /* synthetic */ ImageVector.Builder group$default(ImageVector.Builder builder, String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List list, Function1 function1, int i, Object obj) {
        List<PathNode> list2;
        ImageVector.Builder builder2 = builder;
        Function1 function12 = function1;
        int i2 = i;
        String str2 = (i2 & 1) != 0 ? "" : str;
        float f8 = (i2 & 2) != 0 ? 0.0f : f;
        float f9 = (i2 & 4) != 0 ? 0.0f : f2;
        float f10 = (i2 & 8) != 0 ? 0.0f : f3;
        float f11 = 1.0f;
        float f12 = (i2 & 16) != 0 ? 1.0f : f4;
        if ((i2 & 32) == 0) {
            f11 = f5;
        }
        float f13 = (i2 & 64) != 0 ? 0.0f : f6;
        float f14 = (i2 & 128) != 0 ? 0.0f : f7;
        if ((i2 & 256) != 0) {
            list2 = VectorKt.getEmptyPath();
        } else {
            list2 = list;
        }
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(list2, "clipPathData");
        Intrinsics.checkNotNullParameter(function12, "block");
        builder.addGroup(str2, f8, f9, f10, f12, f11, f13, f14, list2);
        function12.invoke(builder);
        builder.clearGroup();
        return builder2;
    }

    public static final ImageVector.Builder group(ImageVector.Builder builder, String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List<? extends PathNode> list, Function1<? super ImageVector.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "clipPathData");
        Intrinsics.checkNotNullParameter(function1, "block");
        builder.addGroup(str, f, f2, f3, f4, f5, f6, f7, list);
        function1.invoke(builder);
        builder.clearGroup();
        return builder;
    }

    /* renamed from: path-R_LF-3I  reason: not valid java name */
    public static final ImageVector.Builder m2621pathR_LF3I(ImageVector.Builder builder, String str, Brush brush, float f, Brush brush2, float f2, float f3, int i, int i2, float f4, int i3, Function1<? super PathBuilder, Unit> function1) {
        Function1<? super PathBuilder, Unit> function12 = function1;
        int i4 = i3;
        Intrinsics.checkNotNullParameter(builder, "$this$path");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function12, "pathBuilder");
        PathBuilder pathBuilder = new PathBuilder();
        function12.invoke(pathBuilder);
        return ImageVector.Builder.m2619addPathoIyEayM$default(builder, pathBuilder.getNodes(), i4, str, brush, f, brush2, f2, f3, i, i2, f4, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
    }
}
