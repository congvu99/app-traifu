package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_accountCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AccountCircle", "Landroidx/compose/material/icons/Icons$TwoTone;", "getAccountCircle", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountCircle.kt */
public final class AccountCircleKt {
    private static ImageVector _accountCircle;

    public static final ImageVector getAccountCircle(Icons.TwoTone twoTone) {
        Intrinsics.checkNotNullParameter(twoTone, "<this>");
        ImageVector imageVector = _accountCircle;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = r1;
        ImageVector.Builder builder2 = r1;
        ImageVector.Builder builder3 = new ImageVector.Builder("TwoTone.AccountCircle", Dp.m4704constructorimpl(24.0f), Dp.m4704constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, 96, (DefaultConstructorMarker) null);
        int r21 = StrokeCap.Companion.m2287getButtKaPHkGw();
        int r22 = StrokeJoin.Companion.m2297getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(12.0f, 4.0f);
        PathBuilder pathBuilder2 = pathBuilder;
        pathBuilder2.curveToRelative(-4.41f, 0.0f, -8.0f, 3.59f, -8.0f, 8.0f);
        pathBuilder2.curveToRelative(0.0f, 1.82f, 0.62f, 3.49f, 1.64f, 4.83f);
        pathBuilder2.curveToRelative(1.43f, -1.74f, 4.9f, -2.33f, 6.36f, -2.33f);
        pathBuilder.reflectiveCurveToRelative(4.93f, 0.59f, 6.36f, 2.33f);
        pathBuilder2.curveTo(19.38f, 15.49f, 20.0f, 13.82f, 20.0f, 12.0f);
        pathBuilder2.curveToRelative(0.0f, -4.41f, -3.59f, -8.0f, -8.0f, -8.0f);
        pathBuilder.close();
        pathBuilder.moveTo(12.0f, 13.0f);
        pathBuilder2.curveToRelative(-1.94f, 0.0f, -3.5f, -1.56f, -3.5f, -3.5f);
        pathBuilder.reflectiveCurveTo(10.06f, 6.0f, 12.0f, 6.0f);
        pathBuilder.reflectiveCurveToRelative(3.5f, 1.56f, 3.5f, 3.5f);
        pathBuilder.reflectiveCurveTo(13.94f, 13.0f, 12.0f, 13.0f);
        pathBuilder.close();
        ImageVector.Builder.m2619addPathoIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m1958getBlack0d7_KjU(), (DefaultConstructorMarker) null), 0.3f, (Brush) null, 0.3f, 1.0f, r21, r22, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        int r38 = StrokeCap.Companion.m2287getButtKaPHkGw();
        int r39 = StrokeJoin.Companion.m2297getBevelLxFBmk8();
        PathBuilder pathBuilder3 = new PathBuilder();
        pathBuilder3.moveTo(12.0f, 2.0f);
        pathBuilder3.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        pathBuilder3.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
        pathBuilder3.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        pathBuilder3.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
        pathBuilder3.close();
        pathBuilder3.moveTo(7.07f, 18.28f);
        pathBuilder3.curveToRelative(0.43f, -0.9f, 3.05f, -1.78f, 4.93f, -1.78f);
        pathBuilder3.reflectiveCurveToRelative(4.51f, 0.88f, 4.93f, 1.78f);
        PathBuilder pathBuilder4 = pathBuilder3;
        pathBuilder4.curveTo(15.57f, 19.36f, 13.86f, 20.0f, 12.0f, 20.0f);
        pathBuilder3.reflectiveCurveToRelative(-3.57f, -0.64f, -4.93f, -1.72f);
        pathBuilder3.close();
        pathBuilder3.moveTo(18.36f, 16.83f);
        pathBuilder4.curveToRelative(-1.43f, -1.74f, -4.9f, -2.33f, -6.36f, -2.33f);
        pathBuilder3.reflectiveCurveToRelative(-4.93f, 0.59f, -6.36f, 2.33f);
        pathBuilder4.curveTo(4.62f, 15.49f, 4.0f, 13.82f, 4.0f, 12.0f);
        pathBuilder4.curveToRelative(0.0f, -4.41f, 3.59f, -8.0f, 8.0f, -8.0f);
        pathBuilder3.reflectiveCurveToRelative(8.0f, 3.59f, 8.0f, 8.0f);
        pathBuilder4.curveToRelative(0.0f, 1.82f, -0.62f, 3.49f, -1.64f, 4.83f);
        pathBuilder3.close();
        pathBuilder3.moveTo(12.0f, 6.0f);
        pathBuilder4.curveToRelative(-1.94f, 0.0f, -3.5f, 1.56f, -3.5f, 3.5f);
        pathBuilder3.reflectiveCurveTo(10.06f, 13.0f, 12.0f, 13.0f);
        pathBuilder3.reflectiveCurveToRelative(3.5f, -1.56f, 3.5f, -3.5f);
        pathBuilder3.reflectiveCurveTo(13.94f, 6.0f, 12.0f, 6.0f);
        pathBuilder3.close();
        pathBuilder3.moveTo(12.0f, 11.0f);
        pathBuilder4.curveToRelative(-0.83f, 0.0f, -1.5f, -0.67f, -1.5f, -1.5f);
        pathBuilder3.reflectiveCurveTo(11.17f, 8.0f, 12.0f, 8.0f);
        pathBuilder3.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        pathBuilder3.reflectiveCurveTo(12.83f, 11.0f, 12.0f, 11.0f);
        pathBuilder3.close();
        ImageVector build = ImageVector.Builder.m2619addPathoIyEayM$default(builder, pathBuilder3.getNodes(), VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m1958getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, r38, r39, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _accountCircle = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
