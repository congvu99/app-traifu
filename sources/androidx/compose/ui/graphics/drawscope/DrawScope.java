package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.internal.AnalyticsEvents;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u0000 n2\u00020\u0001:\u0001nJs\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#Js\u0010\u0011\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'J[\u0010(\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00162\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J[\u0010(\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010)\u001a\u00020\u00162\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-JQ\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u0002002\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102Jo\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u0002002\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002042\b\b\u0002\u00108\u001a\u0002062\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H'ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:Jy\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u0002002\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002042\b\b\u0002\u00108\u001a\u0002062\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010;\u001a\u00020<H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>Jm\u0010?\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00032\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010HJm\u0010?\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00032\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ[\u0010K\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bL\u0010MJ[\u0010K\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010OJO\u0010P\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010TJO\u0010P\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020R2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bU\u0010VJs\u0010W\u001a\u00020\u00122\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00030Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\\\u0010]Js\u0010W\u001a\u00020\u00122\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00030Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010_J[\u0010`\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\ba\u0010MJ[\u0010`\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bb\u0010OJe\u0010c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010d\u001a\u00020e2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bf\u0010gJe\u0010c\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010d\u001a\u00020e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bh\u0010iJ!\u0010j\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010k\u001a\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bl\u0010mR\u001d\u0010\u0002\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u00020\u000f8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005ø\u0001\u0003\u0002\u0015\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006oÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/unit/Density;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "drawArc", "", "brush", "Landroidx/compose/ui/graphics/Brush;", "startAngle", "", "sweepAngle", "useCenter", "", "topLeft", "alpha", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "offsetSize", "offset", "offsetSize-PENXr5M", "(JJ)J", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@DrawScopeMarker
/* compiled from: DrawScope.kt */
public interface DrawScope extends Density {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* renamed from: drawArc-illE91I  reason: not valid java name */
    void m2458drawArcillE91I(Brush brush, float f, float f2, boolean z, long j, long j2, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawArc-yD3GUKo  reason: not valid java name */
    void m2459drawArcyD3GUKo(long j, float f, float f2, boolean z, long j2, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawCircle-V9BoPsw  reason: not valid java name */
    void m2460drawCircleV9BoPsw(Brush brush, float f, long j, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawCircle-VaOC9Bg  reason: not valid java name */
    void m2461drawCircleVaOC9Bg(long j, float f, long j2, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* renamed from: drawImage-9jGpkUE  reason: not valid java name */
    /* synthetic */ void m2462drawImage9jGpkUE(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawImage-AZ2fEMs  reason: not valid java name */
    void m2463drawImageAZ2fEMs(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2);

    /* renamed from: drawImage-gbVJVH8  reason: not valid java name */
    void m2464drawImagegbVJVH8(ImageBitmap imageBitmap, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawLine-1RTmtNc  reason: not valid java name */
    void m2465drawLine1RTmtNc(Brush brush, long j, long j2, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2);

    /* renamed from: drawLine-NGM6Ib0  reason: not valid java name */
    void m2466drawLineNGM6Ib0(long j, long j2, long j3, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2);

    /* renamed from: drawOval-AsUm42w  reason: not valid java name */
    void m2467drawOvalAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawOval-n-J9OG0  reason: not valid java name */
    void m2468drawOvalnJ9OG0(long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawPath-GBMwjPU  reason: not valid java name */
    void m2469drawPathGBMwjPU(Path path, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawPath-LG529CI  reason: not valid java name */
    void m2470drawPathLG529CI(Path path, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawPoints-F8ZwMP8  reason: not valid java name */
    void m2471drawPointsF8ZwMP8(List<Offset> list, int i, long j, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3);

    /* renamed from: drawPoints-Gsft0Ws  reason: not valid java name */
    void m2472drawPointsGsft0Ws(List<Offset> list, int i, Brush brush, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3);

    /* renamed from: drawRect-AsUm42w  reason: not valid java name */
    void m2473drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawRect-n-J9OG0  reason: not valid java name */
    void m2474drawRectnJ9OG0(long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawRoundRect-ZuiqVtQ  reason: not valid java name */
    void m2475drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawRoundRect-u-Aw5IA  reason: not valid java name */
    void m2476drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i);

    /* renamed from: getCenter-F1C5BW0  reason: not valid java name */
    long m2477getCenterF1C5BW0();

    DrawContext getDrawContext();

    LayoutDirection getLayoutDirection();

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    long m2478getSizeNHjbRc();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DrawScope.kt */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m2541roundToPxR2X_6o(DrawScope drawScope, long j) {
            return Density.CC.m4654$default$roundToPxR2X_6o(drawScope, j);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m2542roundToPx0680j_4(DrawScope drawScope, float f) {
            return Density.CC.m4655$default$roundToPx0680j_4(drawScope, f);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m2543toDpGaN1DYA(DrawScope drawScope, long j) {
            return Density.CC.m4656$default$toDpGaN1DYA(drawScope, j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m2544toDpu2uoSUM(DrawScope drawScope, float f) {
            return Density.CC.m4657$default$toDpu2uoSUM((Density) drawScope, f);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m2545toDpu2uoSUM(DrawScope drawScope, int i) {
            return Density.CC.m4658$default$toDpu2uoSUM((Density) drawScope, i);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m2546toDpSizekrfVVM(DrawScope drawScope, long j) {
            return Density.CC.m4659$default$toDpSizekrfVVM(drawScope, j);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m2547toPxR2X_6o(DrawScope drawScope, long j) {
            return Density.CC.m4660$default$toPxR2X_6o(drawScope, j);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m2548toPx0680j_4(DrawScope drawScope, float f) {
            return Density.CC.m4661$default$toPx0680j_4(drawScope, f);
        }

        @Deprecated
        public static Rect toRect(DrawScope drawScope, DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "$receiver");
            return Density.CC.$default$toRect(drawScope, dpRect);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m2549toSizeXkaWNTQ(DrawScope drawScope, long j) {
            return Density.CC.m4662$default$toSizeXkaWNTQ(drawScope, j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m2550toSp0xMU5do(DrawScope drawScope, float f) {
            return Density.CC.m4663$default$toSp0xMU5do(drawScope, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m2551toSpkPz2Gy4(DrawScope drawScope, float f) {
            return Density.CC.m4664$default$toSpkPz2Gy4((Density) drawScope, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m2552toSpkPz2Gy4(DrawScope drawScope, int i) {
            return Density.CC.m4665$default$toSpkPz2Gy4((Density) drawScope, i);
        }

        @Deprecated
        /* renamed from: getCenter-F1C5BW0  reason: not valid java name */
        public static long m2539getCenterF1C5BW0(DrawScope drawScope) {
            return CC.m2480$default$getCenterF1C5BW0(drawScope);
        }

        @Deprecated
        /* renamed from: getSize-NH-jbRc  reason: not valid java name */
        public static long m2540getSizeNHjbRc(DrawScope drawScope) {
            return CC.m2481$default$getSizeNHjbRc(drawScope);
        }

        @Deprecated
        /* renamed from: drawImage-AZ2fEMs  reason: not valid java name */
        public static void m2524drawImageAZ2fEMs(DrawScope drawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2) {
            Intrinsics.checkNotNullParameter(imageBitmap, "image");
            Intrinsics.checkNotNullParameter(drawStyle, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
            CC.m2479$default$drawImageAZ2fEMs(drawScope, imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i, i2);
        }
    }

    /* renamed from: androidx.compose.ui.graphics.drawscope.DrawScope$-CC  reason: invalid class name */
    /* compiled from: DrawScope.kt */
    public final /* synthetic */ class CC {
        /* renamed from: $default$getCenter-F1C5BW0  reason: not valid java name */
        public static long m2480$default$getCenterF1C5BW0(DrawScope _this) {
            return SizeKt.m1762getCenteruvyYCjk(_this.getDrawContext().m2456getSizeNHjbRc());
        }

        /* renamed from: $default$getSize-NH-jbRc  reason: not valid java name */
        public static long m2481$default$getSizeNHjbRc(DrawScope _this) {
            return _this.getDrawContext().m2456getSizeNHjbRc();
        }

        /* renamed from: drawLine-1RTmtNc$default  reason: not valid java name */
        public static /* synthetic */ void m2505drawLine1RTmtNc$default(DrawScope drawScope, Brush brush, long j, long j2, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2, int i3, Object obj) {
            int i4 = i3;
            if (obj == null) {
                drawScope.m2465drawLine1RTmtNc(brush, j, j2, (i4 & 8) != 0 ? 0.0f : f, (i4 & 16) != 0 ? Stroke.Companion.m2600getDefaultCapKaPHkGw() : i, (i4 & 32) != 0 ? null : pathEffect, (i4 & 64) != 0 ? 1.0f : f2, (i4 & 128) != 0 ? null : colorFilter, (i4 & 256) != 0 ? DrawScope.Companion.m2517getDefaultBlendMode0nO6VwU() : i2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-1RTmtNc");
        }

        /* renamed from: drawLine-NGM6Ib0$default  reason: not valid java name */
        public static /* synthetic */ void m2506drawLineNGM6Ib0$default(DrawScope drawScope, long j, long j2, long j3, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2, int i3, Object obj) {
            int i4 = i3;
            if (obj == null) {
                drawScope.m2466drawLineNGM6Ib0(j, j2, j3, (i4 & 8) != 0 ? 0.0f : f, (i4 & 16) != 0 ? Stroke.Companion.m2600getDefaultCapKaPHkGw() : i, (i4 & 32) != 0 ? null : pathEffect, (i4 & 64) != 0 ? 1.0f : f2, (i4 & 128) != 0 ? null : colorFilter, (i4 & 256) != 0 ? DrawScope.Companion.m2517getDefaultBlendMode0nO6VwU() : i2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-NGM6Ib0");
        }

        /* renamed from: drawRect-AsUm42w$default  reason: not valid java name */
        public static /* synthetic */ void m2513drawRectAsUm42w$default(DrawScope drawScope, Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
            long j3;
            if (obj == null) {
                long r0 = (i2 & 2) != 0 ? Offset.Companion.m1699getZeroF1C5BW0() : j;
                if ((i2 & 4) != 0) {
                    DrawScope drawScope2 = drawScope;
                    j3 = m2482$private$offsetSizePENXr5M(drawScope, drawScope.m2478getSizeNHjbRc(), r0);
                } else {
                    DrawScope drawScope3 = drawScope;
                    j3 = j2;
                }
                drawScope.m2473drawRectAsUm42w(brush, r0, j3, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? DrawScope.Companion.m2517getDefaultBlendMode0nO6VwU() : i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-AsUm42w");
        }

        /* renamed from: drawRect-n-J9OG0$default  reason: not valid java name */
        public static /* synthetic */ void m2514drawRectnJ9OG0$default(DrawScope drawScope, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
            long j4;
            if (obj == null) {
                long r5 = (i2 & 2) != 0 ? Offset.Companion.m1699getZeroF1C5BW0() : j2;
                if ((i2 & 4) != 0) {
                    DrawScope drawScope2 = drawScope;
                    j4 = m2482$private$offsetSizePENXr5M(drawScope, drawScope.m2478getSizeNHjbRc(), r5);
                } else {
                    DrawScope drawScope3 = drawScope;
                    j4 = j3;
                }
                drawScope.m2474drawRectnJ9OG0(j, r5, j4, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? DrawScope.Companion.m2517getDefaultBlendMode0nO6VwU() : i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-n-J9OG0");
        }

        /* renamed from: drawImage-gbVJVH8$default  reason: not valid java name */
        public static /* synthetic */ void m2504drawImagegbVJVH8$default(DrawScope drawScope, ImageBitmap imageBitmap, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
            if (obj == null) {
                drawScope.m2464drawImagegbVJVH8(imageBitmap, (i2 & 2) != 0 ? Offset.Companion.m1699getZeroF1C5BW0() : j, (i2 & 4) != 0 ? 1.0f : f, (i2 & 8) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 16) != 0 ? null : colorFilter, (i2 & 32) != 0 ? DrawScope.Companion.m2517getDefaultBlendMode0nO6VwU() : i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-gbVJVH8");
        }

        /* renamed from: drawImage-9jGpkUE$default  reason: not valid java name */
        public static /* synthetic */ void m2502drawImage9jGpkUE$default(DrawScope drawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
            int i3 = i2;
            if (obj == null) {
                long r1 = (i3 & 2) != 0 ? IntOffset.Companion.m4832getZeronOccac() : j;
                long IntSize = (i3 & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j2;
                drawScope.m2462drawImage9jGpkUE(imageBitmap, r1, IntSize, (i3 & 8) != 0 ? IntOffset.Companion.m4832getZeronOccac() : j3, (i3 & 16) != 0 ? IntSize : j4, (i3 & 32) != 0 ? 1.0f : f, (i3 & 64) != 0 ? Fill.INSTANCE : drawStyle, (i3 & 128) != 0 ? null : colorFilter, (i3 & 256) != 0 ? DrawScope.Companion.m2517getDefaultBlendMode0nO6VwU() : i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-9jGpkUE");
        }

        /* renamed from: drawImage-AZ2fEMs$default  reason: not valid java name */
        public static /* synthetic */ void m2503drawImageAZ2fEMs$default(DrawScope drawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, int i3, Object obj) {
            int i4 = i3;
            if (obj == null) {
                long r1 = (i4 & 2) != 0 ? IntOffset.Companion.m4832getZeronOccac() : j;
                long IntSize = (i4 & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j2;
                drawScope.m2463drawImageAZ2fEMs(imageBitmap, r1, IntSize, (i4 & 8) != 0 ? IntOffset.Companion.m4832getZeronOccac() : j3, (i4 & 16) != 0 ? IntSize : j4, (i4 & 32) != 0 ? 1.0f : f, (i4 & 64) != 0 ? Fill.INSTANCE : drawStyle, (i4 & 128) != 0 ? null : colorFilter, (i4 & 256) != 0 ? DrawScope.Companion.m2517getDefaultBlendMode0nO6VwU() : i, (i4 & 512) != 0 ? DrawScope.Companion.m2518getDefaultFilterQualityfv9h1I() : i2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-AZ2fEMs");
        }

        /* renamed from: $default$drawImage-AZ2fEMs  reason: not valid java name */
        public static void m2479$default$drawImageAZ2fEMs(DrawScope _this, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2) {
            Intrinsics.checkNotNullParameter(imageBitmap, "image");
            Intrinsics.checkNotNullParameter(drawStyle, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
            m2503drawImageAZ2fEMs$default(_this, imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i, 0, 512, (Object) null);
        }

        /* renamed from: drawRoundRect-ZuiqVtQ$default  reason: not valid java name */
        public static /* synthetic */ void m2515drawRoundRectZuiqVtQ$default(DrawScope drawScope, Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
            long j4;
            int i3 = i2;
            if (obj == null) {
                long r1 = (i3 & 2) != 0 ? Offset.Companion.m1699getZeroF1C5BW0() : j;
                if ((i3 & 4) != 0) {
                    DrawScope drawScope2 = drawScope;
                    j4 = m2482$private$offsetSizePENXr5M(drawScope, drawScope.m2478getSizeNHjbRc(), r1);
                } else {
                    DrawScope drawScope3 = drawScope;
                    j4 = j2;
                }
                drawScope.m2475drawRoundRectZuiqVtQ(brush, r1, j4, (i3 & 8) != 0 ? CornerRadius.Companion.m1668getZerokKHJgLs() : j3, (i3 & 16) != 0 ? 1.0f : f, (i3 & 32) != 0 ? Fill.INSTANCE : drawStyle, (i3 & 64) != 0 ? null : colorFilter, (i3 & 128) != 0 ? DrawScope.Companion.m2517getDefaultBlendMode0nO6VwU() : i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-ZuiqVtQ");
        }

        /* renamed from: drawRoundRect-u-Aw5IA$default  reason: not valid java name */
        public static /* synthetic */ void m2516drawRoundRectuAw5IA$default(DrawScope drawScope, long j, long j2, long j3, long j4, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, Object obj) {
            long j5;
            int i3 = i2;
            if (obj == null) {
                long r6 = (i3 & 2) != 0 ? Offset.Companion.m1699getZeroF1C5BW0() : j2;
                if ((i3 & 4) != 0) {
                    j5 = m2482$private$offsetSizePENXr5M(drawScope, drawScope.m2478getSizeNHjbRc(), r6);
                } else {
                    DrawScope drawScope2 = drawScope;
                    j5 = j3;
                }
                drawScope.m2476drawRoundRectuAw5IA(j, r6, j5, (i3 & 8) != 0 ? CornerRadius.Companion.m1668getZerokKHJgLs() : j4, (i3 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i3 & 32) != 0 ? 1.0f : f, (i3 & 64) != 0 ? null : colorFilter, (i3 & 128) != 0 ? DrawScope.Companion.m2517getDefaultBlendMode0nO6VwU() : i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-u-Aw5IA");
        }

        /* renamed from: drawCircle-V9BoPsw$default  reason: not valid java name */
        public static /* synthetic */ void m2500drawCircleV9BoPsw$default(DrawScope drawScope, Brush brush, float f, long j, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
            if (obj == null) {
                drawScope.m2460drawCircleV9BoPsw(brush, (i2 & 2) != 0 ? Size.m1751getMinDimensionimpl(drawScope.m2478getSizeNHjbRc()) / 2.0f : f, (i2 & 4) != 0 ? drawScope.m2477getCenterF1C5BW0() : j, (i2 & 8) != 0 ? 1.0f : f2, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? DrawScope.Companion.m2517getDefaultBlendMode0nO6VwU() : i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-V9BoPsw");
        }

        /* renamed from: drawCircle-VaOC9Bg$default  reason: not valid java name */
        public static /* synthetic */ void m2501drawCircleVaOC9Bg$default(DrawScope drawScope, long j, float f, long j2, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
            if (obj == null) {
                drawScope.m2461drawCircleVaOC9Bg(j, (i2 & 2) != 0 ? Size.m1751getMinDimensionimpl(drawScope.m2478getSizeNHjbRc()) / 2.0f : f, (i2 & 4) != 0 ? drawScope.m2477getCenterF1C5BW0() : j2, (i2 & 8) != 0 ? 1.0f : f2, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? DrawScope.Companion.m2517getDefaultBlendMode0nO6VwU() : i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-VaOC9Bg");
        }

        /* renamed from: drawOval-AsUm42w$default  reason: not valid java name */
        public static /* synthetic */ void m2507drawOvalAsUm42w$default(DrawScope drawScope, Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
            long j3;
            if (obj == null) {
                long r0 = (i2 & 2) != 0 ? Offset.Companion.m1699getZeroF1C5BW0() : j;
                if ((i2 & 4) != 0) {
                    DrawScope drawScope2 = drawScope;
                    j3 = m2482$private$offsetSizePENXr5M(drawScope, drawScope.m2478getSizeNHjbRc(), r0);
                } else {
                    DrawScope drawScope3 = drawScope;
                    j3 = j2;
                }
                drawScope.m2467drawOvalAsUm42w(brush, r0, j3, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? DrawScope.Companion.m2517getDefaultBlendMode0nO6VwU() : i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-AsUm42w");
        }

        /* renamed from: drawOval-n-J9OG0$default  reason: not valid java name */
        public static /* synthetic */ void m2508drawOvalnJ9OG0$default(DrawScope drawScope, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
            long j4;
            if (obj == null) {
                long r5 = (i2 & 2) != 0 ? Offset.Companion.m1699getZeroF1C5BW0() : j2;
                if ((i2 & 4) != 0) {
                    DrawScope drawScope2 = drawScope;
                    j4 = m2482$private$offsetSizePENXr5M(drawScope, drawScope.m2478getSizeNHjbRc(), r5);
                } else {
                    DrawScope drawScope3 = drawScope;
                    j4 = j3;
                }
                drawScope.m2468drawOvalnJ9OG0(j, r5, j4, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? DrawScope.Companion.m2517getDefaultBlendMode0nO6VwU() : i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-n-J9OG0");
        }

        /* renamed from: drawArc-illE91I$default  reason: not valid java name */
        public static /* synthetic */ void m2498drawArcillE91I$default(DrawScope drawScope, Brush brush, float f, float f2, boolean z, long j, long j2, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
            long j3;
            int i3 = i2;
            if (obj == null) {
                long r8 = (i3 & 16) != 0 ? Offset.Companion.m1699getZeroF1C5BW0() : j;
                if ((i3 & 32) != 0) {
                    j3 = m2482$private$offsetSizePENXr5M(drawScope, drawScope.m2478getSizeNHjbRc(), r8);
                } else {
                    DrawScope drawScope2 = drawScope;
                    j3 = j2;
                }
                drawScope.m2458drawArcillE91I(brush, f, f2, z, r8, j3, (i3 & 64) != 0 ? 1.0f : f3, (i3 & 128) != 0 ? Fill.INSTANCE : drawStyle, (i3 & 256) != 0 ? null : colorFilter, (i3 & 512) != 0 ? DrawScope.Companion.m2517getDefaultBlendMode0nO6VwU() : i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-illE91I");
        }

        /* renamed from: drawArc-yD3GUKo$default  reason: not valid java name */
        public static /* synthetic */ void m2499drawArcyD3GUKo$default(DrawScope drawScope, long j, float f, float f2, boolean z, long j2, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
            long j4;
            int i3 = i2;
            if (obj == null) {
                long r9 = (i3 & 16) != 0 ? Offset.Companion.m1699getZeroF1C5BW0() : j2;
                if ((i3 & 32) != 0) {
                    j4 = m2482$private$offsetSizePENXr5M(drawScope, drawScope.m2478getSizeNHjbRc(), r9);
                } else {
                    DrawScope drawScope2 = drawScope;
                    j4 = j3;
                }
                drawScope.m2459drawArcyD3GUKo(j, f, f2, z, r9, j4, (i3 & 64) != 0 ? 1.0f : f3, (i3 & 128) != 0 ? Fill.INSTANCE : drawStyle, (i3 & 256) != 0 ? null : colorFilter, (i3 & 512) != 0 ? DrawScope.Companion.m2517getDefaultBlendMode0nO6VwU() : i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-yD3GUKo");
        }

        /* renamed from: drawPath-LG529CI$default  reason: not valid java name */
        public static /* synthetic */ void m2510drawPathLG529CI$default(DrawScope drawScope, Path path, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
            if (obj == null) {
                drawScope.m2470drawPathLG529CI(path, j, (i2 & 4) != 0 ? 1.0f : f, (i2 & 8) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 16) != 0 ? null : colorFilter, (i2 & 32) != 0 ? DrawScope.Companion.m2517getDefaultBlendMode0nO6VwU() : i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-LG529CI");
        }

        /* renamed from: drawPath-GBMwjPU$default  reason: not valid java name */
        public static /* synthetic */ void m2509drawPathGBMwjPU$default(DrawScope drawScope, Path path, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
            if (obj == null) {
                float f2 = (i2 & 4) != 0 ? 1.0f : f;
                if ((i2 & 8) != 0) {
                    drawStyle = Fill.INSTANCE;
                }
                DrawStyle drawStyle2 = drawStyle;
                if ((i2 & 16) != 0) {
                    colorFilter = null;
                }
                ColorFilter colorFilter2 = colorFilter;
                if ((i2 & 32) != 0) {
                    i = DrawScope.Companion.m2517getDefaultBlendMode0nO6VwU();
                }
                drawScope.m2469drawPathGBMwjPU(path, brush, f2, drawStyle2, colorFilter2, i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-GBMwjPU");
        }

        /* renamed from: drawPoints-F8ZwMP8$default  reason: not valid java name */
        public static /* synthetic */ void m2511drawPointsF8ZwMP8$default(DrawScope drawScope, List list, int i, long j, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3, int i4, Object obj) {
            int i5 = i4;
            if (obj == null) {
                drawScope.m2471drawPointsF8ZwMP8(list, i, j, (i5 & 8) != 0 ? 0.0f : f, (i5 & 16) != 0 ? StrokeCap.Companion.m2287getButtKaPHkGw() : i2, (i5 & 32) != 0 ? null : pathEffect, (i5 & 64) != 0 ? 1.0f : f2, (i5 & 128) != 0 ? null : colorFilter, (i5 & 256) != 0 ? DrawScope.Companion.m2517getDefaultBlendMode0nO6VwU() : i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-F8ZwMP8");
        }

        /* renamed from: drawPoints-Gsft0Ws$default  reason: not valid java name */
        public static /* synthetic */ void m2512drawPointsGsft0Ws$default(DrawScope drawScope, List list, int i, Brush brush, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3, int i4, Object obj) {
            int i5 = i4;
            if (obj == null) {
                drawScope.m2472drawPointsGsft0Ws(list, i, brush, (i5 & 8) != 0 ? 0.0f : f, (i5 & 16) != 0 ? StrokeCap.Companion.m2287getButtKaPHkGw() : i2, (i5 & 32) != 0 ? null : pathEffect, (i5 & 64) != 0 ? 1.0f : f2, (i5 & 128) != 0 ? null : colorFilter, (i5 & 256) != 0 ? DrawScope.Companion.m2517getDefaultBlendMode0nO6VwU() : i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-Gsft0Ws");
        }

        /* renamed from: $private$offsetSize-PENXr5M  reason: not valid java name */
        public static long m2482$private$offsetSizePENXr5M(DrawScope _this, long j, long j2) {
            return SizeKt.Size(Size.m1752getWidthimpl(j) - Offset.m1683getXimpl(j2), Size.m1749getHeightimpl(j) - Offset.m1684getYimpl(j2));
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\n\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope$Companion;", "", "()V", "DefaultBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getDefaultBlendMode-0nO6VwU", "()I", "I", "DefaultFilterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getDefaultFilterQuality-f-v9h1I", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DrawScope.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final int DefaultBlendMode = BlendMode.Companion.m1864getSrcOver0nO6VwU();
        private static final int DefaultFilterQuality = FilterQuality.Companion.m2018getLowfv9h1I();

        private Companion() {
        }

        /* renamed from: getDefaultBlendMode-0nO6VwU  reason: not valid java name */
        public final int m2517getDefaultBlendMode0nO6VwU() {
            return DefaultBlendMode;
        }

        /* renamed from: getDefaultFilterQuality-f-v9h1I  reason: not valid java name */
        public final int m2518getDefaultFilterQualityfv9h1I() {
            return DefaultFilterQuality;
        }
    }
}
