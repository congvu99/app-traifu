package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.vector.PathNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aB\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\b2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110#¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020!0&H\b\u001a\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020!0 *\u00020\u00012\u0006\u0010\"\u001a\u00020#H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"ArcToKey", "", "CloseKey", "CurveToKey", "HorizontalToKey", "LineToKey", "MoveToKey", "NUM_ARC_TO_ARGS", "", "NUM_CURVE_TO_ARGS", "NUM_HORIZONTAL_TO_ARGS", "NUM_LINE_TO_ARGS", "NUM_MOVE_TO_ARGS", "NUM_QUAD_TO_ARGS", "NUM_REFLECTIVE_CURVE_TO_ARGS", "NUM_REFLECTIVE_QUAD_TO_ARGS", "NUM_VERTICAL_TO_ARGS", "QuadToKey", "ReflectiveCurveToKey", "ReflectiveQuadToKey", "RelativeArcToKey", "RelativeCloseKey", "RelativeCurveToKey", "RelativeHorizontalToKey", "RelativeLineToKey", "RelativeMoveToKey", "RelativeQuadToKey", "RelativeReflectiveCurveToKey", "RelativeReflectiveQuadToKey", "RelativeVerticalToKey", "VerticalToKey", "pathNodesFromArgs", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "args", "", "numArgs", "nodeFor", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "subArray", "toPathNodes", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: PathNode.kt */
public final class PathNodeKt {
    private static final char ArcToKey = 'A';
    private static final char CloseKey = 'Z';
    private static final char CurveToKey = 'C';
    private static final char HorizontalToKey = 'H';
    private static final char LineToKey = 'L';
    private static final char MoveToKey = 'M';
    private static final int NUM_ARC_TO_ARGS = 7;
    private static final int NUM_CURVE_TO_ARGS = 6;
    private static final int NUM_HORIZONTAL_TO_ARGS = 1;
    private static final int NUM_LINE_TO_ARGS = 2;
    private static final int NUM_MOVE_TO_ARGS = 2;
    private static final int NUM_QUAD_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_CURVE_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_QUAD_TO_ARGS = 2;
    private static final int NUM_VERTICAL_TO_ARGS = 1;
    private static final char QuadToKey = 'Q';
    private static final char ReflectiveCurveToKey = 'S';
    private static final char ReflectiveQuadToKey = 'T';
    private static final char RelativeArcToKey = 'a';
    private static final char RelativeCloseKey = 'z';
    private static final char RelativeCurveToKey = 'c';
    private static final char RelativeHorizontalToKey = 'h';
    private static final char RelativeLineToKey = 'l';
    private static final char RelativeMoveToKey = 'm';
    private static final char RelativeQuadToKey = 'q';
    private static final char RelativeReflectiveCurveToKey = 's';
    private static final char RelativeReflectiveQuadToKey = 't';
    private static final char RelativeVerticalToKey = 'v';
    private static final char VerticalToKey = 'V';

    public static final List<PathNode> toPathNodes(char c, float[] fArr) {
        char c2 = c;
        float[] fArr2 = fArr;
        Intrinsics.checkNotNullParameter(fArr2, "args");
        if (c2 == 'z' || c2 == 'Z') {
            return CollectionsKt.listOf(PathNode.Close.INSTANCE);
        }
        if (c2 == 'm') {
            Iterable step = RangesKt.step((IntProgression) new IntRange(0, fArr2.length - 2), 2);
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step, 10));
            Iterator it = step.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                float[] copyOfRange = ArraysKt.copyOfRange(fArr2, nextInt, nextInt + 2);
                PathNode relativeMoveTo = new PathNode.RelativeMoveTo(copyOfRange[0], copyOfRange[1]);
                if ((relativeMoveTo instanceof PathNode.MoveTo) && nextInt > 0) {
                    relativeMoveTo = new PathNode.LineTo(copyOfRange[0], copyOfRange[1]);
                } else if (nextInt > 0) {
                    relativeMoveTo = new PathNode.RelativeLineTo(copyOfRange[0], copyOfRange[1]);
                }
                arrayList.add(relativeMoveTo);
            }
            return (List) arrayList;
        } else if (c2 == 'M') {
            Iterable step2 = RangesKt.step((IntProgression) new IntRange(0, fArr2.length - 2), 2);
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(step2, 10));
            Iterator it2 = step2.iterator();
            while (it2.hasNext()) {
                int nextInt2 = ((IntIterator) it2).nextInt();
                float[] copyOfRange2 = ArraysKt.copyOfRange(fArr2, nextInt2, nextInt2 + 2);
                PathNode moveTo = new PathNode.MoveTo(copyOfRange2[0], copyOfRange2[1]);
                if (nextInt2 > 0) {
                    moveTo = new PathNode.LineTo(copyOfRange2[0], copyOfRange2[1]);
                } else if ((moveTo instanceof PathNode.RelativeMoveTo) && nextInt2 > 0) {
                    moveTo = new PathNode.RelativeLineTo(copyOfRange2[0], copyOfRange2[1]);
                }
                arrayList2.add(moveTo);
            }
            return (List) arrayList2;
        } else if (c2 == 'l') {
            Iterable step3 = RangesKt.step((IntProgression) new IntRange(0, fArr2.length - 2), 2);
            Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(step3, 10));
            Iterator it3 = step3.iterator();
            while (it3.hasNext()) {
                int nextInt3 = ((IntIterator) it3).nextInt();
                float[] copyOfRange3 = ArraysKt.copyOfRange(fArr2, nextInt3, nextInt3 + 2);
                PathNode relativeLineTo = new PathNode.RelativeLineTo(copyOfRange3[0], copyOfRange3[1]);
                if ((relativeLineTo instanceof PathNode.MoveTo) && nextInt3 > 0) {
                    relativeLineTo = new PathNode.LineTo(copyOfRange3[0], copyOfRange3[1]);
                } else if ((relativeLineTo instanceof PathNode.RelativeMoveTo) && nextInt3 > 0) {
                    relativeLineTo = new PathNode.RelativeLineTo(copyOfRange3[0], copyOfRange3[1]);
                }
                arrayList3.add(relativeLineTo);
            }
            return (List) arrayList3;
        } else if (c2 == 'L') {
            Iterable step4 = RangesKt.step((IntProgression) new IntRange(0, fArr2.length - 2), 2);
            Collection arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(step4, 10));
            Iterator it4 = step4.iterator();
            while (it4.hasNext()) {
                int nextInt4 = ((IntIterator) it4).nextInt();
                float[] copyOfRange4 = ArraysKt.copyOfRange(fArr2, nextInt4, nextInt4 + 2);
                PathNode lineTo = new PathNode.LineTo(copyOfRange4[0], copyOfRange4[1]);
                if ((lineTo instanceof PathNode.MoveTo) && nextInt4 > 0) {
                    lineTo = new PathNode.LineTo(copyOfRange4[0], copyOfRange4[1]);
                } else if ((lineTo instanceof PathNode.RelativeMoveTo) && nextInt4 > 0) {
                    lineTo = new PathNode.RelativeLineTo(copyOfRange4[0], copyOfRange4[1]);
                }
                arrayList4.add(lineTo);
            }
            return (List) arrayList4;
        } else if (c2 == 'h') {
            Iterable step5 = RangesKt.step((IntProgression) new IntRange(0, fArr2.length - 1), 1);
            Collection arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(step5, 10));
            Iterator it5 = step5.iterator();
            while (it5.hasNext()) {
                int nextInt5 = ((IntIterator) it5).nextInt();
                float[] copyOfRange5 = ArraysKt.copyOfRange(fArr2, nextInt5, nextInt5 + 1);
                PathNode relativeHorizontalTo = new PathNode.RelativeHorizontalTo(copyOfRange5[0]);
                if ((relativeHorizontalTo instanceof PathNode.MoveTo) && nextInt5 > 0) {
                    relativeHorizontalTo = new PathNode.LineTo(copyOfRange5[0], copyOfRange5[1]);
                } else if ((relativeHorizontalTo instanceof PathNode.RelativeMoveTo) && nextInt5 > 0) {
                    relativeHorizontalTo = new PathNode.RelativeLineTo(copyOfRange5[0], copyOfRange5[1]);
                }
                arrayList5.add(relativeHorizontalTo);
            }
            return (List) arrayList5;
        } else if (c2 == 'H') {
            Iterable step6 = RangesKt.step((IntProgression) new IntRange(0, fArr2.length - 1), 1);
            Collection arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(step6, 10));
            Iterator it6 = step6.iterator();
            while (it6.hasNext()) {
                int nextInt6 = ((IntIterator) it6).nextInt();
                float[] copyOfRange6 = ArraysKt.copyOfRange(fArr2, nextInt6, nextInt6 + 1);
                PathNode horizontalTo = new PathNode.HorizontalTo(copyOfRange6[0]);
                if ((horizontalTo instanceof PathNode.MoveTo) && nextInt6 > 0) {
                    horizontalTo = new PathNode.LineTo(copyOfRange6[0], copyOfRange6[1]);
                } else if ((horizontalTo instanceof PathNode.RelativeMoveTo) && nextInt6 > 0) {
                    horizontalTo = new PathNode.RelativeLineTo(copyOfRange6[0], copyOfRange6[1]);
                }
                arrayList6.add(horizontalTo);
            }
            return (List) arrayList6;
        } else if (c2 == 'v') {
            Iterable step7 = RangesKt.step((IntProgression) new IntRange(0, fArr2.length - 1), 1);
            Collection arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(step7, 10));
            Iterator it7 = step7.iterator();
            while (it7.hasNext()) {
                int nextInt7 = ((IntIterator) it7).nextInt();
                float[] copyOfRange7 = ArraysKt.copyOfRange(fArr2, nextInt7, nextInt7 + 1);
                PathNode relativeVerticalTo = new PathNode.RelativeVerticalTo(copyOfRange7[0]);
                if ((relativeVerticalTo instanceof PathNode.MoveTo) && nextInt7 > 0) {
                    relativeVerticalTo = new PathNode.LineTo(copyOfRange7[0], copyOfRange7[1]);
                } else if ((relativeVerticalTo instanceof PathNode.RelativeMoveTo) && nextInt7 > 0) {
                    relativeVerticalTo = new PathNode.RelativeLineTo(copyOfRange7[0], copyOfRange7[1]);
                }
                arrayList7.add(relativeVerticalTo);
            }
            return (List) arrayList7;
        } else if (c2 == 'V') {
            Iterable step8 = RangesKt.step((IntProgression) new IntRange(0, fArr2.length - 1), 1);
            Collection arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(step8, 10));
            Iterator it8 = step8.iterator();
            while (it8.hasNext()) {
                int nextInt8 = ((IntIterator) it8).nextInt();
                float[] copyOfRange8 = ArraysKt.copyOfRange(fArr2, nextInt8, nextInt8 + 1);
                PathNode verticalTo = new PathNode.VerticalTo(copyOfRange8[0]);
                if ((verticalTo instanceof PathNode.MoveTo) && nextInt8 > 0) {
                    verticalTo = new PathNode.LineTo(copyOfRange8[0], copyOfRange8[1]);
                } else if ((verticalTo instanceof PathNode.RelativeMoveTo) && nextInt8 > 0) {
                    verticalTo = new PathNode.RelativeLineTo(copyOfRange8[0], copyOfRange8[1]);
                }
                arrayList8.add(verticalTo);
            }
            return (List) arrayList8;
        } else if (c2 == 'c') {
            Iterable step9 = RangesKt.step((IntProgression) new IntRange(0, fArr2.length - 6), 6);
            Collection arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(step9, 10));
            Iterator it9 = step9.iterator();
            while (it9.hasNext()) {
                int nextInt9 = ((IntIterator) it9).nextInt();
                float[] copyOfRange9 = ArraysKt.copyOfRange(fArr2, nextInt9, nextInt9 + 6);
                PathNode relativeCurveTo = new PathNode.RelativeCurveTo(copyOfRange9[0], copyOfRange9[1], copyOfRange9[2], copyOfRange9[3], copyOfRange9[4], copyOfRange9[5]);
                if ((relativeCurveTo instanceof PathNode.MoveTo) && nextInt9 > 0) {
                    relativeCurveTo = new PathNode.LineTo(copyOfRange9[0], copyOfRange9[1]);
                } else if ((relativeCurveTo instanceof PathNode.RelativeMoveTo) && nextInt9 > 0) {
                    relativeCurveTo = new PathNode.RelativeLineTo(copyOfRange9[0], copyOfRange9[1]);
                }
                arrayList9.add(relativeCurveTo);
            }
            return (List) arrayList9;
        } else if (c2 == 'C') {
            Iterable step10 = RangesKt.step((IntProgression) new IntRange(0, fArr2.length - 6), 6);
            Collection arrayList10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(step10, 10));
            Iterator it10 = step10.iterator();
            while (it10.hasNext()) {
                int nextInt10 = ((IntIterator) it10).nextInt();
                float[] copyOfRange10 = ArraysKt.copyOfRange(fArr2, nextInt10, nextInt10 + 6);
                PathNode curveTo = new PathNode.CurveTo(copyOfRange10[0], copyOfRange10[1], copyOfRange10[2], copyOfRange10[3], copyOfRange10[4], copyOfRange10[5]);
                if ((curveTo instanceof PathNode.MoveTo) && nextInt10 > 0) {
                    curveTo = new PathNode.LineTo(copyOfRange10[0], copyOfRange10[1]);
                } else if ((curveTo instanceof PathNode.RelativeMoveTo) && nextInt10 > 0) {
                    curveTo = new PathNode.RelativeLineTo(copyOfRange10[0], copyOfRange10[1]);
                }
                arrayList10.add(curveTo);
            }
            return (List) arrayList10;
        } else if (c2 == 's') {
            Iterable step11 = RangesKt.step((IntProgression) new IntRange(0, fArr2.length - 4), 4);
            Collection arrayList11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(step11, 10));
            Iterator it11 = step11.iterator();
            while (it11.hasNext()) {
                int nextInt11 = ((IntIterator) it11).nextInt();
                float[] copyOfRange11 = ArraysKt.copyOfRange(fArr2, nextInt11, nextInt11 + 4);
                PathNode relativeReflectiveCurveTo = new PathNode.RelativeReflectiveCurveTo(copyOfRange11[0], copyOfRange11[1], copyOfRange11[2], copyOfRange11[3]);
                if ((relativeReflectiveCurveTo instanceof PathNode.MoveTo) && nextInt11 > 0) {
                    relativeReflectiveCurveTo = new PathNode.LineTo(copyOfRange11[0], copyOfRange11[1]);
                } else if ((relativeReflectiveCurveTo instanceof PathNode.RelativeMoveTo) && nextInt11 > 0) {
                    relativeReflectiveCurveTo = new PathNode.RelativeLineTo(copyOfRange11[0], copyOfRange11[1]);
                }
                arrayList11.add(relativeReflectiveCurveTo);
            }
            return (List) arrayList11;
        } else if (c2 == 'S') {
            Iterable step12 = RangesKt.step((IntProgression) new IntRange(0, fArr2.length - 4), 4);
            Collection arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(step12, 10));
            Iterator it12 = step12.iterator();
            while (it12.hasNext()) {
                int nextInt12 = ((IntIterator) it12).nextInt();
                float[] copyOfRange12 = ArraysKt.copyOfRange(fArr2, nextInt12, nextInt12 + 4);
                PathNode reflectiveCurveTo = new PathNode.ReflectiveCurveTo(copyOfRange12[0], copyOfRange12[1], copyOfRange12[2], copyOfRange12[3]);
                if ((reflectiveCurveTo instanceof PathNode.MoveTo) && nextInt12 > 0) {
                    reflectiveCurveTo = new PathNode.LineTo(copyOfRange12[0], copyOfRange12[1]);
                } else if ((reflectiveCurveTo instanceof PathNode.RelativeMoveTo) && nextInt12 > 0) {
                    reflectiveCurveTo = new PathNode.RelativeLineTo(copyOfRange12[0], copyOfRange12[1]);
                }
                arrayList12.add(reflectiveCurveTo);
            }
            return (List) arrayList12;
        } else if (c2 == 'q') {
            Iterable step13 = RangesKt.step((IntProgression) new IntRange(0, fArr2.length - 4), 4);
            Collection arrayList13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(step13, 10));
            Iterator it13 = step13.iterator();
            while (it13.hasNext()) {
                int nextInt13 = ((IntIterator) it13).nextInt();
                float[] copyOfRange13 = ArraysKt.copyOfRange(fArr2, nextInt13, nextInt13 + 4);
                PathNode relativeQuadTo = new PathNode.RelativeQuadTo(copyOfRange13[0], copyOfRange13[1], copyOfRange13[2], copyOfRange13[3]);
                if ((relativeQuadTo instanceof PathNode.MoveTo) && nextInt13 > 0) {
                    relativeQuadTo = new PathNode.LineTo(copyOfRange13[0], copyOfRange13[1]);
                } else if ((relativeQuadTo instanceof PathNode.RelativeMoveTo) && nextInt13 > 0) {
                    relativeQuadTo = new PathNode.RelativeLineTo(copyOfRange13[0], copyOfRange13[1]);
                }
                arrayList13.add(relativeQuadTo);
            }
            return (List) arrayList13;
        } else if (c2 == 'Q') {
            Iterable step14 = RangesKt.step((IntProgression) new IntRange(0, fArr2.length - 4), 4);
            Collection arrayList14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(step14, 10));
            Iterator it14 = step14.iterator();
            while (it14.hasNext()) {
                int nextInt14 = ((IntIterator) it14).nextInt();
                float[] copyOfRange14 = ArraysKt.copyOfRange(fArr2, nextInt14, nextInt14 + 4);
                PathNode quadTo = new PathNode.QuadTo(copyOfRange14[0], copyOfRange14[1], copyOfRange14[2], copyOfRange14[3]);
                if ((quadTo instanceof PathNode.MoveTo) && nextInt14 > 0) {
                    quadTo = new PathNode.LineTo(copyOfRange14[0], copyOfRange14[1]);
                } else if ((quadTo instanceof PathNode.RelativeMoveTo) && nextInt14 > 0) {
                    quadTo = new PathNode.RelativeLineTo(copyOfRange14[0], copyOfRange14[1]);
                }
                arrayList14.add(quadTo);
            }
            return (List) arrayList14;
        } else if (c2 == 't') {
            Iterable step15 = RangesKt.step((IntProgression) new IntRange(0, fArr2.length - 2), 2);
            Collection arrayList15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(step15, 10));
            Iterator it15 = step15.iterator();
            while (it15.hasNext()) {
                int nextInt15 = ((IntIterator) it15).nextInt();
                float[] copyOfRange15 = ArraysKt.copyOfRange(fArr2, nextInt15, nextInt15 + 2);
                PathNode relativeReflectiveQuadTo = new PathNode.RelativeReflectiveQuadTo(copyOfRange15[0], copyOfRange15[1]);
                if ((relativeReflectiveQuadTo instanceof PathNode.MoveTo) && nextInt15 > 0) {
                    relativeReflectiveQuadTo = new PathNode.LineTo(copyOfRange15[0], copyOfRange15[1]);
                } else if ((relativeReflectiveQuadTo instanceof PathNode.RelativeMoveTo) && nextInt15 > 0) {
                    relativeReflectiveQuadTo = new PathNode.RelativeLineTo(copyOfRange15[0], copyOfRange15[1]);
                }
                arrayList15.add(relativeReflectiveQuadTo);
            }
            return (List) arrayList15;
        } else if (c2 == 'T') {
            Iterable step16 = RangesKt.step((IntProgression) new IntRange(0, fArr2.length - 2), 2);
            Collection arrayList16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(step16, 10));
            Iterator it16 = step16.iterator();
            while (it16.hasNext()) {
                int nextInt16 = ((IntIterator) it16).nextInt();
                float[] copyOfRange16 = ArraysKt.copyOfRange(fArr2, nextInt16, nextInt16 + 2);
                PathNode reflectiveQuadTo = new PathNode.ReflectiveQuadTo(copyOfRange16[0], copyOfRange16[1]);
                if ((reflectiveQuadTo instanceof PathNode.MoveTo) && nextInt16 > 0) {
                    reflectiveQuadTo = new PathNode.LineTo(copyOfRange16[0], copyOfRange16[1]);
                } else if ((reflectiveQuadTo instanceof PathNode.RelativeMoveTo) && nextInt16 > 0) {
                    reflectiveQuadTo = new PathNode.RelativeLineTo(copyOfRange16[0], copyOfRange16[1]);
                }
                arrayList16.add(reflectiveQuadTo);
            }
            return (List) arrayList16;
        } else if (c2 == 'a') {
            Iterable step17 = RangesKt.step((IntProgression) new IntRange(0, fArr2.length - 7), 7);
            Collection arrayList17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(step17, 10));
            Iterator it17 = step17.iterator();
            while (it17.hasNext()) {
                int nextInt17 = ((IntIterator) it17).nextInt();
                float[] copyOfRange17 = ArraysKt.copyOfRange(fArr2, nextInt17, nextInt17 + 7);
                PathNode relativeArcTo = new PathNode.RelativeArcTo(copyOfRange17[0], copyOfRange17[1], copyOfRange17[2], Float.compare(copyOfRange17[3], 0.0f) != 0, Float.compare(copyOfRange17[4], 0.0f) != 0, copyOfRange17[5], copyOfRange17[6]);
                if ((relativeArcTo instanceof PathNode.MoveTo) && nextInt17 > 0) {
                    relativeArcTo = new PathNode.LineTo(copyOfRange17[0], copyOfRange17[1]);
                } else if ((relativeArcTo instanceof PathNode.RelativeMoveTo) && nextInt17 > 0) {
                    relativeArcTo = new PathNode.RelativeLineTo(copyOfRange17[0], copyOfRange17[1]);
                }
                arrayList17.add(relativeArcTo);
            }
            return (List) arrayList17;
        } else if (c2 == 'A') {
            Iterable step18 = RangesKt.step((IntProgression) new IntRange(0, fArr2.length - 7), 7);
            Collection arrayList18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(step18, 10));
            Iterator it18 = step18.iterator();
            while (it18.hasNext()) {
                int nextInt18 = ((IntIterator) it18).nextInt();
                float[] copyOfRange18 = ArraysKt.copyOfRange(fArr2, nextInt18, nextInt18 + 7);
                PathNode arcTo = new PathNode.ArcTo(copyOfRange18[0], copyOfRange18[1], copyOfRange18[2], Float.compare(copyOfRange18[3], 0.0f) != 0, Float.compare(copyOfRange18[4], 0.0f) != 0, copyOfRange18[5], copyOfRange18[6]);
                if ((arcTo instanceof PathNode.MoveTo) && nextInt18 > 0) {
                    arcTo = new PathNode.LineTo(copyOfRange18[0], copyOfRange18[1]);
                } else if ((arcTo instanceof PathNode.RelativeMoveTo) && nextInt18 > 0) {
                    arcTo = new PathNode.RelativeLineTo(copyOfRange18[0], copyOfRange18[1]);
                }
                arrayList18.add(arcTo);
            }
            return (List) arrayList18;
        } else {
            throw new IllegalArgumentException("Unknown command for: " + c2);
        }
    }

    private static final List<PathNode> pathNodesFromArgs(float[] fArr, int i, Function1<? super float[], ? extends PathNode> function1) {
        Iterable step = RangesKt.step((IntProgression) new IntRange(0, fArr.length - i), i);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(step, 10));
        Iterator it = step.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            float[] copyOfRange = ArraysKt.copyOfRange(fArr, nextInt, nextInt + i);
            PathNode pathNode = (PathNode) function1.invoke(copyOfRange);
            if ((pathNode instanceof PathNode.MoveTo) && nextInt > 0) {
                pathNode = new PathNode.LineTo(copyOfRange[0], copyOfRange[1]);
            } else if ((pathNode instanceof PathNode.RelativeMoveTo) && nextInt > 0) {
                pathNode = new PathNode.RelativeLineTo(copyOfRange[0], copyOfRange[1]);
            }
            arrayList.add(pathNode);
        }
        return (List) arrayList;
    }
}
