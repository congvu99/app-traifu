package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.vector.PathNode;
import com.facebook.imagepipeline.common.RotationOptions;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002bcB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010\u0011\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0012JX\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u0006\u0010 \u001a\u00020\fJ\u0010\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0015H\u0002J \u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002JX\u0010'\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0002J \u0010/\u001a\u00020\f2\u0006\u00100\u001a\u0002012\u0006\u0010\u001e\u001a\u00020%2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\u00102\u0006\u00100\u001a\u000201H\u0002J\u0018\u00105\u001a\u00020%2\u0006\u00100\u001a\u0002012\u0006\u0010&\u001a\u00020%H\u0002J\u000e\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u000201J\f\u00108\u001a\b\u0012\u0004\u0012\u00020\b0\u0012J\u0010\u00109\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015J\u0014\u0010:\u001a\u00020\f*\u00020;2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010<\u001a\u00020\f*\u00020=2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010>\u001a\u00020\f*\u00020?2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010@\u001a\u00020\f*\u00020A2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010B\u001a\u00020\f*\u00020C2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010D\u001a\u00020\f*\u00020E2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u001c\u0010F\u001a\u00020\f*\u00020G2\u0006\u0010H\u001a\u00020-2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u001c\u0010I\u001a\u00020\f*\u00020J2\u0006\u0010K\u001a\u00020-2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010L\u001a\u00020\f*\u00020M2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010N\u001a\u00020\f*\u00020O2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010P\u001a\u00020\f*\u00020Q2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010R\u001a\u00020\f*\u00020S2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010T\u001a\u00020\f*\u00020U2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010V\u001a\u00020\f*\u00020W2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u001c\u0010X\u001a\u00020\f*\u00020Y2\u0006\u0010H\u001a\u00020-2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u001c\u0010Z\u001a\u00020\f*\u00020[2\u0006\u0010K\u001a\u00020-2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010\\\u001a\u00020\f*\u00020]2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\f\u0010^\u001a\u00020\u0017*\u00020\u0017H\u0002J\f\u0010^\u001a\u00020_*\u00020_H\u0002J\u0014\u0010`\u001a\u00020\f*\u00020a2\u0006\u0010\"\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathParser;", "", "()V", "ctrlPoint", "Landroidx/compose/ui/graphics/vector/PathParser$PathPoint;", "currentPoint", "nodes", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "reflectiveCtrlPoint", "segmentPoint", "addNode", "", "cmd", "", "args", "", "addPathNodes", "", "arcToBezier", "p", "Landroidx/compose/ui/graphics/Path;", "cx", "", "cy", "a", "b", "e1x", "e1y", "theta", "start", "sweep", "clear", "close", "target", "copyOfRange", "original", "", "end", "drawArc", "x0", "y0", "x1", "y1", "isMoreThanHalf", "", "isPositiveArc", "extract", "s", "", "result", "Landroidx/compose/ui/graphics/vector/PathParser$ExtractFloatResult;", "getFloats", "nextStart", "parsePathString", "pathData", "toNodes", "toPath", "arcTo", "Landroidx/compose/ui/graphics/vector/PathNode$ArcTo;", "curveTo", "Landroidx/compose/ui/graphics/vector/PathNode$CurveTo;", "horizontalTo", "Landroidx/compose/ui/graphics/vector/PathNode$HorizontalTo;", "lineTo", "Landroidx/compose/ui/graphics/vector/PathNode$LineTo;", "moveTo", "Landroidx/compose/ui/graphics/vector/PathNode$MoveTo;", "quadTo", "Landroidx/compose/ui/graphics/vector/PathNode$QuadTo;", "reflectiveCurveTo", "Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveCurveTo;", "prevIsCurve", "reflectiveQuadTo", "Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveQuadTo;", "prevIsQuad", "relativeArcTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeArcTo;", "relativeCurveTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeCurveTo;", "relativeHorizontalTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeHorizontalTo;", "relativeLineTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeLineTo;", "relativeMoveTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeMoveTo;", "relativeQuadTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeQuadTo;", "relativeReflectiveCurveTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveCurveTo;", "relativeReflectiveQuadTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveQuadTo;", "relativeVerticalTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeVerticalTo;", "toRadians", "", "verticalTo", "Landroidx/compose/ui/graphics/vector/PathNode$VerticalTo;", "ExtractFloatResult", "PathPoint", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PathParser.kt */
public final class PathParser {
    private final PathPoint ctrlPoint = new PathPoint(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);
    private final PathPoint currentPoint = new PathPoint(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);
    private final List<PathNode> nodes = new ArrayList();
    private final PathPoint reflectiveCtrlPoint = new PathPoint(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);
    private final PathPoint segmentPoint = new PathPoint(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);

    private final double toRadians(double d) {
        return (d / ((double) RotationOptions.ROTATE_180)) * 3.141592653589793d;
    }

    private final float toRadians(float f) {
        return (f / 180.0f) * 3.1415927f;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathParser$PathPoint;", "", "x", "", "y", "(FF)V", "getX", "()F", "setX", "(F)V", "getY", "setY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "reset", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PathParser.kt */
    private static final class PathPoint {
        private float x;
        private float y;

        public PathPoint() {
            this(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PathPoint copy$default(PathPoint pathPoint, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = pathPoint.x;
            }
            if ((i & 2) != 0) {
                f2 = pathPoint.y;
            }
            return pathPoint.copy(f, f2);
        }

        public final float component1() {
            return this.x;
        }

        public final float component2() {
            return this.y;
        }

        public final PathPoint copy(float f, float f2) {
            return new PathPoint(f, f2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PathPoint)) {
                return false;
            }
            PathPoint pathPoint = (PathPoint) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.x), (Object) Float.valueOf(pathPoint.x)) && Intrinsics.areEqual((Object) Float.valueOf(this.y), (Object) Float.valueOf(pathPoint.y));
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y);
        }

        public String toString() {
            return "PathPoint(x=" + this.x + ", y=" + this.y + ')';
        }

        public PathPoint(float f, float f2) {
            this.x = f;
            this.y = f2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PathPoint(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f2);
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }

        public final void setX(float f) {
            this.x = f;
        }

        public final void setY(float f) {
            this.y = f;
        }

        public final void reset() {
            this.x = 0.0f;
            this.y = 0.0f;
        }
    }

    public final void clear() {
        this.nodes.clear();
    }

    public final PathParser parsePathString(String str) {
        Intrinsics.checkNotNullParameter(str, "pathData");
        this.nodes.clear();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int nextStart = nextStart(str, i);
            String substring = str.substring(i2, nextStart);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            CharSequence charSequence = substring;
            int length = charSequence.length() - 1;
            int i3 = 0;
            boolean z = false;
            while (i3 <= length) {
                boolean z2 = Intrinsics.compare((int) charSequence.charAt(!z ? i3 : length), 32) <= 0;
                if (!z) {
                    if (!z2) {
                        z = true;
                    } else {
                        i3++;
                    }
                } else if (!z2) {
                    break;
                } else {
                    length--;
                }
            }
            String obj = charSequence.subSequence(i3, length + 1).toString();
            if (obj.length() > 0) {
                addNode(obj.charAt(0), getFloats(obj));
            }
            i2 = nextStart;
            i = nextStart + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            addNode(str.charAt(i2), new float[0]);
        }
        return this;
    }

    public final PathParser addPathNodes(List<? extends PathNode> list) {
        Intrinsics.checkNotNullParameter(list, "nodes");
        this.nodes.addAll(list);
        return this;
    }

    public final List<PathNode> toNodes() {
        return this.nodes;
    }

    public static /* synthetic */ Path toPath$default(PathParser pathParser, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            path = AndroidPath_androidKt.Path();
        }
        return pathParser.toPath(path);
    }

    public final Path toPath(Path path) {
        Intrinsics.checkNotNullParameter(path, "target");
        path.reset();
        this.currentPoint.reset();
        this.ctrlPoint.reset();
        this.segmentPoint.reset();
        this.reflectiveCtrlPoint.reset();
        List<PathNode> list = this.nodes;
        int size = list.size();
        PathNode pathNode = null;
        int i = 0;
        while (i < size) {
            PathNode pathNode2 = list.get(i);
            if (pathNode == null) {
                pathNode = pathNode2;
            }
            if (pathNode2 instanceof PathNode.Close) {
                close(path);
            } else if (pathNode2 instanceof PathNode.RelativeMoveTo) {
                relativeMoveTo((PathNode.RelativeMoveTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.MoveTo) {
                moveTo((PathNode.MoveTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.RelativeLineTo) {
                relativeLineTo((PathNode.RelativeLineTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.LineTo) {
                lineTo((PathNode.LineTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.RelativeHorizontalTo) {
                relativeHorizontalTo((PathNode.RelativeHorizontalTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.HorizontalTo) {
                horizontalTo((PathNode.HorizontalTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.RelativeVerticalTo) {
                relativeVerticalTo((PathNode.RelativeVerticalTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.VerticalTo) {
                verticalTo((PathNode.VerticalTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.RelativeCurveTo) {
                relativeCurveTo((PathNode.RelativeCurveTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.CurveTo) {
                curveTo((PathNode.CurveTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.RelativeReflectiveCurveTo) {
                Intrinsics.checkNotNull(pathNode);
                relativeReflectiveCurveTo((PathNode.RelativeReflectiveCurveTo) pathNode2, pathNode.isCurve(), path);
            } else if (pathNode2 instanceof PathNode.ReflectiveCurveTo) {
                Intrinsics.checkNotNull(pathNode);
                reflectiveCurveTo((PathNode.ReflectiveCurveTo) pathNode2, pathNode.isCurve(), path);
            } else if (pathNode2 instanceof PathNode.RelativeQuadTo) {
                relativeQuadTo((PathNode.RelativeQuadTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.QuadTo) {
                quadTo((PathNode.QuadTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.RelativeReflectiveQuadTo) {
                Intrinsics.checkNotNull(pathNode);
                relativeReflectiveQuadTo((PathNode.RelativeReflectiveQuadTo) pathNode2, pathNode.isQuad(), path);
            } else if (pathNode2 instanceof PathNode.ReflectiveQuadTo) {
                Intrinsics.checkNotNull(pathNode);
                reflectiveQuadTo((PathNode.ReflectiveQuadTo) pathNode2, pathNode.isQuad(), path);
            } else if (pathNode2 instanceof PathNode.RelativeArcTo) {
                relativeArcTo((PathNode.RelativeArcTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.ArcTo) {
                arcTo((PathNode.ArcTo) pathNode2, path);
            }
            i++;
            pathNode = pathNode2;
        }
        return path;
    }

    private final void close(Path path) {
        this.currentPoint.setX(this.segmentPoint.getX());
        this.currentPoint.setY(this.segmentPoint.getY());
        this.ctrlPoint.setX(this.segmentPoint.getX());
        this.ctrlPoint.setY(this.segmentPoint.getY());
        path.close();
        path.moveTo(this.currentPoint.getX(), this.currentPoint.getY());
    }

    private final void relativeMoveTo(PathNode.RelativeMoveTo relativeMoveTo, Path path) {
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + relativeMoveTo.getDx());
        PathPoint pathPoint2 = this.currentPoint;
        pathPoint2.setY(pathPoint2.getY() + relativeMoveTo.getDy());
        path.relativeMoveTo(relativeMoveTo.getDx(), relativeMoveTo.getDy());
        this.segmentPoint.setX(this.currentPoint.getX());
        this.segmentPoint.setY(this.currentPoint.getY());
    }

    private final void moveTo(PathNode.MoveTo moveTo, Path path) {
        this.currentPoint.setX(moveTo.getX());
        this.currentPoint.setY(moveTo.getY());
        path.moveTo(moveTo.getX(), moveTo.getY());
        this.segmentPoint.setX(this.currentPoint.getX());
        this.segmentPoint.setY(this.currentPoint.getY());
    }

    private final void relativeLineTo(PathNode.RelativeLineTo relativeLineTo, Path path) {
        path.relativeLineTo(relativeLineTo.getDx(), relativeLineTo.getDy());
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + relativeLineTo.getDx());
        PathPoint pathPoint2 = this.currentPoint;
        pathPoint2.setY(pathPoint2.getY() + relativeLineTo.getDy());
    }

    private final void lineTo(PathNode.LineTo lineTo, Path path) {
        path.lineTo(lineTo.getX(), lineTo.getY());
        this.currentPoint.setX(lineTo.getX());
        this.currentPoint.setY(lineTo.getY());
    }

    private final void relativeHorizontalTo(PathNode.RelativeHorizontalTo relativeHorizontalTo, Path path) {
        path.relativeLineTo(relativeHorizontalTo.getDx(), 0.0f);
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + relativeHorizontalTo.getDx());
    }

    private final void horizontalTo(PathNode.HorizontalTo horizontalTo, Path path) {
        path.lineTo(horizontalTo.getX(), this.currentPoint.getY());
        this.currentPoint.setX(horizontalTo.getX());
    }

    private final void relativeVerticalTo(PathNode.RelativeVerticalTo relativeVerticalTo, Path path) {
        path.relativeLineTo(0.0f, relativeVerticalTo.getDy());
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setY(pathPoint.getY() + relativeVerticalTo.getDy());
    }

    private final void verticalTo(PathNode.VerticalTo verticalTo, Path path) {
        path.lineTo(this.currentPoint.getX(), verticalTo.getY());
        this.currentPoint.setY(verticalTo.getY());
    }

    private final void relativeCurveTo(PathNode.RelativeCurveTo relativeCurveTo, Path path) {
        path.relativeCubicTo(relativeCurveTo.getDx1(), relativeCurveTo.getDy1(), relativeCurveTo.getDx2(), relativeCurveTo.getDy2(), relativeCurveTo.getDx3(), relativeCurveTo.getDy3());
        this.ctrlPoint.setX(this.currentPoint.getX() + relativeCurveTo.getDx2());
        this.ctrlPoint.setY(this.currentPoint.getY() + relativeCurveTo.getDy2());
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + relativeCurveTo.getDx3());
        PathPoint pathPoint2 = this.currentPoint;
        pathPoint2.setY(pathPoint2.getY() + relativeCurveTo.getDy3());
    }

    private final void curveTo(PathNode.CurveTo curveTo, Path path) {
        path.cubicTo(curveTo.getX1(), curveTo.getY1(), curveTo.getX2(), curveTo.getY2(), curveTo.getX3(), curveTo.getY3());
        this.ctrlPoint.setX(curveTo.getX2());
        this.ctrlPoint.setY(curveTo.getY2());
        this.currentPoint.setX(curveTo.getX3());
        this.currentPoint.setY(curveTo.getY3());
    }

    private final void relativeReflectiveCurveTo(PathNode.RelativeReflectiveCurveTo relativeReflectiveCurveTo, boolean z, Path path) {
        if (z) {
            this.reflectiveCtrlPoint.setX(this.currentPoint.getX() - this.ctrlPoint.getX());
            this.reflectiveCtrlPoint.setY(this.currentPoint.getY() - this.ctrlPoint.getY());
        } else {
            this.reflectiveCtrlPoint.reset();
        }
        path.relativeCubicTo(this.reflectiveCtrlPoint.getX(), this.reflectiveCtrlPoint.getY(), relativeReflectiveCurveTo.getDx1(), relativeReflectiveCurveTo.getDy1(), relativeReflectiveCurveTo.getDx2(), relativeReflectiveCurveTo.getDy2());
        this.ctrlPoint.setX(this.currentPoint.getX() + relativeReflectiveCurveTo.getDx1());
        this.ctrlPoint.setY(this.currentPoint.getY() + relativeReflectiveCurveTo.getDy1());
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + relativeReflectiveCurveTo.getDx2());
        PathPoint pathPoint2 = this.currentPoint;
        pathPoint2.setY(pathPoint2.getY() + relativeReflectiveCurveTo.getDy2());
    }

    private final void reflectiveCurveTo(PathNode.ReflectiveCurveTo reflectiveCurveTo, boolean z, Path path) {
        if (z) {
            float f = (float) 2;
            this.reflectiveCtrlPoint.setX((this.currentPoint.getX() * f) - this.ctrlPoint.getX());
            this.reflectiveCtrlPoint.setY((f * this.currentPoint.getY()) - this.ctrlPoint.getY());
        } else {
            this.reflectiveCtrlPoint.setX(this.currentPoint.getX());
            this.reflectiveCtrlPoint.setY(this.currentPoint.getY());
        }
        path.cubicTo(this.reflectiveCtrlPoint.getX(), this.reflectiveCtrlPoint.getY(), reflectiveCurveTo.getX1(), reflectiveCurveTo.getY1(), reflectiveCurveTo.getX2(), reflectiveCurveTo.getY2());
        this.ctrlPoint.setX(reflectiveCurveTo.getX1());
        this.ctrlPoint.setY(reflectiveCurveTo.getY1());
        this.currentPoint.setX(reflectiveCurveTo.getX2());
        this.currentPoint.setY(reflectiveCurveTo.getY2());
    }

    private final void relativeQuadTo(PathNode.RelativeQuadTo relativeQuadTo, Path path) {
        path.relativeQuadraticBezierTo(relativeQuadTo.getDx1(), relativeQuadTo.getDy1(), relativeQuadTo.getDx2(), relativeQuadTo.getDy2());
        this.ctrlPoint.setX(this.currentPoint.getX() + relativeQuadTo.getDx1());
        this.ctrlPoint.setY(this.currentPoint.getY() + relativeQuadTo.getDy1());
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + relativeQuadTo.getDx2());
        PathPoint pathPoint2 = this.currentPoint;
        pathPoint2.setY(pathPoint2.getY() + relativeQuadTo.getDy2());
    }

    private final void quadTo(PathNode.QuadTo quadTo, Path path) {
        path.quadraticBezierTo(quadTo.getX1(), quadTo.getY1(), quadTo.getX2(), quadTo.getY2());
        this.ctrlPoint.setX(quadTo.getX1());
        this.ctrlPoint.setY(quadTo.getY1());
        this.currentPoint.setX(quadTo.getX2());
        this.currentPoint.setY(quadTo.getY2());
    }

    private final void relativeReflectiveQuadTo(PathNode.RelativeReflectiveQuadTo relativeReflectiveQuadTo, boolean z, Path path) {
        if (z) {
            this.reflectiveCtrlPoint.setX(this.currentPoint.getX() - this.ctrlPoint.getX());
            this.reflectiveCtrlPoint.setY(this.currentPoint.getY() - this.ctrlPoint.getY());
        } else {
            this.reflectiveCtrlPoint.reset();
        }
        path.relativeQuadraticBezierTo(this.reflectiveCtrlPoint.getX(), this.reflectiveCtrlPoint.getY(), relativeReflectiveQuadTo.getDx(), relativeReflectiveQuadTo.getDy());
        this.ctrlPoint.setX(this.currentPoint.getX() + this.reflectiveCtrlPoint.getX());
        this.ctrlPoint.setY(this.currentPoint.getY() + this.reflectiveCtrlPoint.getY());
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + relativeReflectiveQuadTo.getDx());
        PathPoint pathPoint2 = this.currentPoint;
        pathPoint2.setY(pathPoint2.getY() + relativeReflectiveQuadTo.getDy());
    }

    private final void reflectiveQuadTo(PathNode.ReflectiveQuadTo reflectiveQuadTo, boolean z, Path path) {
        if (z) {
            float f = (float) 2;
            this.reflectiveCtrlPoint.setX((this.currentPoint.getX() * f) - this.ctrlPoint.getX());
            this.reflectiveCtrlPoint.setY((f * this.currentPoint.getY()) - this.ctrlPoint.getY());
        } else {
            this.reflectiveCtrlPoint.setX(this.currentPoint.getX());
            this.reflectiveCtrlPoint.setY(this.currentPoint.getY());
        }
        path.quadraticBezierTo(this.reflectiveCtrlPoint.getX(), this.reflectiveCtrlPoint.getY(), reflectiveQuadTo.getX(), reflectiveQuadTo.getY());
        this.ctrlPoint.setX(this.reflectiveCtrlPoint.getX());
        this.ctrlPoint.setY(this.reflectiveCtrlPoint.getY());
        this.currentPoint.setX(reflectiveQuadTo.getX());
        this.currentPoint.setY(reflectiveQuadTo.getY());
    }

    private final void relativeArcTo(PathNode.RelativeArcTo relativeArcTo, Path path) {
        float arcStartDx = relativeArcTo.getArcStartDx() + this.currentPoint.getX();
        float arcStartDy = relativeArcTo.getArcStartDy() + this.currentPoint.getY();
        drawArc(path, (double) this.currentPoint.getX(), (double) this.currentPoint.getY(), (double) arcStartDx, (double) arcStartDy, (double) relativeArcTo.getHorizontalEllipseRadius(), (double) relativeArcTo.getVerticalEllipseRadius(), (double) relativeArcTo.getTheta(), relativeArcTo.isMoreThanHalf(), relativeArcTo.isPositiveArc());
        this.currentPoint.setX(arcStartDx);
        this.currentPoint.setY(arcStartDy);
        this.ctrlPoint.setX(this.currentPoint.getX());
        this.ctrlPoint.setY(this.currentPoint.getY());
    }

    private final void arcTo(PathNode.ArcTo arcTo, Path path) {
        drawArc(path, (double) this.currentPoint.getX(), (double) this.currentPoint.getY(), (double) arcTo.getArcStartX(), (double) arcTo.getArcStartY(), (double) arcTo.getHorizontalEllipseRadius(), (double) arcTo.getVerticalEllipseRadius(), (double) arcTo.getTheta(), arcTo.isMoreThanHalf(), arcTo.isPositiveArc());
        this.currentPoint.setX(arcTo.getArcStartX());
        this.currentPoint.setY(arcTo.getArcStartY());
        this.ctrlPoint.setX(this.currentPoint.getX());
        this.ctrlPoint.setY(this.currentPoint.getY());
    }

    private final void drawArc(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, boolean z, boolean z2) {
        double d8;
        double d9;
        double d10 = d;
        double d11 = d3;
        boolean z3 = z2;
        double radians = toRadians(d7);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d12 = ((d10 * cos) + (d2 * sin)) / d5;
        double d13 = (((-d10) * sin) + (d2 * cos)) / d6;
        double d14 = ((d11 * cos) + (d4 * sin)) / d5;
        double d15 = (((-d11) * sin) + (d4 * cos)) / d6;
        double d16 = d12 - d14;
        double d17 = d13 - d15;
        double d18 = (double) 2;
        double d19 = (d12 + d14) / d18;
        double d20 = (d13 + d15) / d18;
        double d21 = (d16 * d16) + (d17 * d17);
        if (!(d21 == Utils.DOUBLE_EPSILON)) {
            double d22 = (1.0d / d21) - 0.25d;
            if (d22 < Utils.DOUBLE_EPSILON) {
                double sqrt = (double) ((float) (Math.sqrt(d21) / 1.99999d));
                boolean z4 = z3;
                drawArc(path, d, d2, d3, d4, d5 * sqrt, d6 * sqrt, d7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d22);
            double d23 = d16 * sqrt2;
            double d24 = sqrt2 * d17;
            boolean z5 = z2;
            if (z == z5) {
                d9 = d19 - d24;
                d8 = d20 + d23;
            } else {
                d9 = d19 + d24;
                d8 = d20 - d23;
            }
            double atan2 = Math.atan2(d13 - d8, d12 - d9);
            double atan22 = Math.atan2(d15 - d8, d14 - d9) - atan2;
            int i = (atan22 > Utils.DOUBLE_EPSILON ? 1 : (atan22 == Utils.DOUBLE_EPSILON ? 0 : -1));
            if (z5 != (i >= 0)) {
                atan22 = i > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d25 = d9 * d5;
            double d26 = d8 * d6;
            arcToBezier(path, (d25 * cos) - (d26 * sin), (d25 * sin) + (d26 * cos), d5, d6, d, d2, radians, atan2, atan22);
        }
    }

    private final void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d3;
        double d11 = (double) 4;
        int ceil = (int) Math.ceil(Math.abs((d9 * d11) / 3.141592653589793d));
        double cos = Math.cos(d7);
        double sin = Math.sin(d7);
        double cos2 = Math.cos(d8);
        double sin2 = Math.sin(d8);
        double d12 = -d10;
        double d13 = d12 * cos;
        double d14 = d4 * sin;
        double d15 = (d13 * sin2) - (d14 * cos2);
        double d16 = d12 * sin;
        double d17 = d4 * cos;
        double d18 = (sin2 * d16) + (cos2 * d17);
        double d19 = d9 / ((double) ceil);
        double d20 = d5;
        double d21 = d8;
        double d22 = d18;
        double d23 = d15;
        int i = 0;
        double d24 = d6;
        while (i < ceil) {
            double d25 = d21 + d19;
            double sin3 = Math.sin(d25);
            double cos3 = Math.cos(d25);
            int i2 = ceil;
            double d26 = (d + ((d10 * cos) * cos3)) - (d14 * sin3);
            double d27 = d2 + (d10 * sin * cos3) + (d17 * sin3);
            double d28 = (d13 * sin3) - (d14 * cos3);
            double d29 = (sin3 * d16) + (cos3 * d17);
            double d30 = d25 - d21;
            double tan = Math.tan(d30 / ((double) 2));
            double d31 = d11;
            double sin4 = (Math.sin(d30) * (Math.sqrt(d11 + ((3.0d * tan) * tan)) - ((double) 1))) / ((double) 3);
            double d32 = d20 + (d23 * sin4);
            path.cubicTo((float) d32, (float) (d24 + (d22 * sin4)), (float) (d26 - (sin4 * d28)), (float) (d27 - (sin4 * d29)), (float) d26, (float) d27);
            i++;
            d19 = d19;
            sin = sin;
            d20 = d26;
            d16 = d16;
            d21 = d25;
            d22 = d29;
            d11 = d31;
            d23 = d28;
            cos = cos;
            ceil = i2;
            d24 = d27;
            d10 = d3;
        }
    }

    private final void addNode(char c, float[] fArr) {
        this.nodes.addAll(PathNodeKt.toPathNodes(c, fArr));
    }

    private final int nextStart(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    private final float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        float[] fArr = new float[str.length()];
        ExtractFloatResult extractFloatResult = new ExtractFloatResult(0, false, 3, (DefaultConstructorMarker) null);
        int length = str.length();
        int i = 1;
        int i2 = 0;
        while (i < length) {
            extract(str, i, extractFloatResult);
            int endPosition = extractFloatResult.getEndPosition();
            if (i < endPosition) {
                String substring = str.substring(i, endPosition);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                fArr[i2] = Float.parseFloat(substring);
                i2++;
            }
            i = extractFloatResult.getEndWithNegativeOrDot() ? endPosition : endPosition + 1;
        }
        return copyOfRange(fArr, 0, i2);
    }

    private final float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i <= i2) {
            int length = fArr.length;
            if (i < 0 || i > length) {
                throw new IndexOutOfBoundsException();
            }
            int i3 = i2 - i;
            int min = Math.min(i3, length - i);
            float[] fArr2 = new float[i3];
            ArraysKt.copyInto(fArr, fArr2, 0, i, min + i);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0051 A[LOOP:0: B:1:0x0008->B:31:0x0051, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0054 A[EDGE_INSN: B:35:0x0054->B:32:0x0054 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void extract(java.lang.String r9, int r10, androidx.compose.ui.graphics.vector.PathParser.ExtractFloatResult r11) {
        /*
            r8 = this;
            r0 = 0
            r11.setEndWithNegativeOrDot(r0)
            r1 = r10
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0008:
            int r5 = r9.length()
            if (r1 >= r5) goto L_0x0054
            char r5 = r9.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 != r6) goto L_0x0019
        L_0x0017:
            r6 = 1
            goto L_0x001f
        L_0x0019:
            r6 = 44
            if (r5 != r6) goto L_0x001e
            goto L_0x0017
        L_0x001e:
            r6 = 0
        L_0x001f:
            if (r6 == 0) goto L_0x0024
        L_0x0021:
            r2 = 0
            r4 = 1
            goto L_0x004e
        L_0x0024:
            r6 = 45
            if (r5 != r6) goto L_0x0030
            if (r1 == r10) goto L_0x004d
            if (r2 != 0) goto L_0x004d
            r11.setEndWithNegativeOrDot(r7)
            goto L_0x0021
        L_0x0030:
            r2 = 46
            if (r5 != r2) goto L_0x003d
            if (r3 != 0) goto L_0x0039
            r2 = 0
            r3 = 1
            goto L_0x004e
        L_0x0039:
            r11.setEndWithNegativeOrDot(r7)
            goto L_0x0021
        L_0x003d:
            r2 = 101(0x65, float:1.42E-43)
            if (r5 != r2) goto L_0x0043
        L_0x0041:
            r2 = 1
            goto L_0x0049
        L_0x0043:
            r2 = 69
            if (r5 != r2) goto L_0x0048
            goto L_0x0041
        L_0x0048:
            r2 = 0
        L_0x0049:
            if (r2 == 0) goto L_0x004d
            r2 = 1
            goto L_0x004e
        L_0x004d:
            r2 = 0
        L_0x004e:
            if (r4 == 0) goto L_0x0051
            goto L_0x0054
        L_0x0051:
            int r1 = r1 + 1
            goto L_0x0008
        L_0x0054:
            r11.setEndPosition(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.PathParser.extract(java.lang.String, int, androidx.compose.ui.graphics.vector.PathParser$ExtractFloatResult):void");
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathParser$ExtractFloatResult;", "", "endPosition", "", "endWithNegativeOrDot", "", "(IZ)V", "getEndPosition", "()I", "setEndPosition", "(I)V", "getEndWithNegativeOrDot", "()Z", "setEndWithNegativeOrDot", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PathParser.kt */
    private static final class ExtractFloatResult {
        private int endPosition;
        private boolean endWithNegativeOrDot;

        public ExtractFloatResult() {
            this(0, false, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ExtractFloatResult copy$default(ExtractFloatResult extractFloatResult, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = extractFloatResult.endPosition;
            }
            if ((i2 & 2) != 0) {
                z = extractFloatResult.endWithNegativeOrDot;
            }
            return extractFloatResult.copy(i, z);
        }

        public final int component1() {
            return this.endPosition;
        }

        public final boolean component2() {
            return this.endWithNegativeOrDot;
        }

        public final ExtractFloatResult copy(int i, boolean z) {
            return new ExtractFloatResult(i, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ExtractFloatResult)) {
                return false;
            }
            ExtractFloatResult extractFloatResult = (ExtractFloatResult) obj;
            return this.endPosition == extractFloatResult.endPosition && this.endWithNegativeOrDot == extractFloatResult.endWithNegativeOrDot;
        }

        public int hashCode() {
            int i = this.endPosition * 31;
            boolean z = this.endWithNegativeOrDot;
            if (z) {
                z = true;
            }
            return i + (z ? 1 : 0);
        }

        public String toString() {
            return "ExtractFloatResult(endPosition=" + this.endPosition + ", endWithNegativeOrDot=" + this.endWithNegativeOrDot + ')';
        }

        public ExtractFloatResult(int i, boolean z) {
            this.endPosition = i;
            this.endWithNegativeOrDot = z;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ExtractFloatResult(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z);
        }

        public final int getEndPosition() {
            return this.endPosition;
        }

        public final void setEndPosition(int i) {
            this.endPosition = i;
        }

        public final boolean getEndWithNegativeOrDot() {
            return this.endWithNegativeOrDot;
        }

        public final void setEndWithNegativeOrDot(boolean z) {
            this.endWithNegativeOrDot = z;
        }
    }
}
