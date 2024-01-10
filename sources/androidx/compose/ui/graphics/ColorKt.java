package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a<\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a2\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a1\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\b\u001a-\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\fH\u0002\u001a!\u0010'\u001a\u00020\u0002*\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u0019\u0010+\u001a\u00020,*\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u0019\u0010/\u001a\u00020\f*\u00020\u0002H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a+\u00102\u001a\u00020\u0002*\u00020\u00022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000204H\bø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a\u0019\u00107\u001a\u00020\u0014*\u00020\u0002H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\"\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\"\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b20\u0001¨\u0006:"}, d2 = {"isSpecified", "", "Landroidx/compose/ui/graphics/Color;", "isSpecified-8_81llA$annotations", "(J)V", "isSpecified-8_81llA", "(J)Z", "isUnspecified", "isUnspecified-8_81llA$annotations", "isUnspecified-8_81llA", "Color", "red", "", "green", "blue", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "color", "", "(I)J", "(IIII)J", "", "(J)J", "compositeComponent", "fgC", "bgC", "fgA", "bgA", "a", "lerp", "start", "stop", "fraction", "lerp-jxsXWHM", "(JJF)J", "saturate", "v", "compositeOver", "background", "compositeOver--OWjLjI", "(JJ)J", "getComponents", "", "getComponents-8_81llA", "(J)[F", "luminance", "luminance-8_81llA", "(J)F", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-DxMtmZc", "(JLkotlin/jvm/functions/Function0;)J", "toArgb", "toArgb-8_81llA", "(J)I", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Color.kt */
public final class ColorKt {
    private static final float compositeComponent(float f, float f2, float f3, float f4, float f5) {
        if (f5 == 0.0f) {
            return 0.0f;
        }
        return ((f * f3) + ((f2 * f4) * (1.0f - f3))) / f5;
    }

    /* renamed from: isSpecified-8_81llA$annotations  reason: not valid java name */
    public static /* synthetic */ void m1981isSpecified8_81llA$annotations(long j) {
    }

    /* renamed from: isUnspecified-8_81llA$annotations  reason: not valid java name */
    public static /* synthetic */ void m1983isUnspecified8_81llA$annotations(long j) {
    }

    private static final float saturate(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public static /* synthetic */ long Color$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f, f2, f3, f4, colorSpace);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x014d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long Color(float r9, float r10, float r11, float r12, androidx.compose.ui.graphics.colorspace.ColorSpace r13) {
        /*
            java.lang.String r0 = "colorSpace"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = 0
            float r1 = r13.getMinValue(r0)
            float r2 = r13.getMaxValue(r0)
            r3 = 1
            int r2 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x0019
            int r1 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r1 > 0) goto L_0x0019
            r1 = 1
            goto L_0x001a
        L_0x0019:
            r1 = 0
        L_0x001a:
            r2 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r1 == 0) goto L_0x0059
            float r1 = r13.getMinValue(r3)
            float r5 = r13.getMaxValue(r3)
            int r5 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x0031
            int r1 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r1 > 0) goto L_0x0031
            r1 = 1
            goto L_0x0032
        L_0x0031:
            r1 = 0
        L_0x0032:
            if (r1 == 0) goto L_0x0059
            r1 = 2
            float r5 = r13.getMinValue(r1)
            float r1 = r13.getMaxValue(r1)
            int r1 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x0047
            int r1 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r1 > 0) goto L_0x0047
            r1 = 1
            goto L_0x0048
        L_0x0047:
            r1 = 0
        L_0x0048:
            if (r1 == 0) goto L_0x0059
            int r1 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r1 > 0) goto L_0x0054
            int r1 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0054
            r1 = 1
            goto L_0x0055
        L_0x0054:
            r1 = 0
        L_0x0055:
            if (r1 == 0) goto L_0x0059
            r1 = 1
            goto L_0x005a
        L_0x0059:
            r1 = 0
        L_0x005a:
            if (r1 == 0) goto L_0x014d
            boolean r1 = r13.isSrgb()
            r5 = 32
            r6 = 16
            r7 = 1056964608(0x3f000000, float:0.5)
            if (r1 == 0) goto L_0x009b
            r13 = 1132396544(0x437f0000, float:255.0)
            float r12 = r12 * r13
            float r12 = r12 + r7
            int r12 = (int) r12
            int r12 = r12 << 24
            float r9 = r9 * r13
            float r9 = r9 + r7
            int r9 = (int) r9
            int r9 = r9 << r6
            r9 = r9 | r12
            float r10 = r10 * r13
            float r10 = r10 + r7
            int r10 = (int) r10
            int r10 = r10 << 8
            r9 = r9 | r10
            float r11 = r11 * r13
            float r11 = r11 + r7
            int r10 = (int) r11
            r9 = r9 | r10
            long r9 = (long) r9
            long r9 = kotlin.ULong.m5600constructorimpl(r9)
            r11 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r9 = r9 & r11
            long r9 = kotlin.ULong.m5600constructorimpl(r9)
            long r9 = r9 << r5
            long r9 = kotlin.ULong.m5600constructorimpl(r9)
            long r9 = androidx.compose.ui.graphics.Color.m1928constructorimpl(r9)
            return r9
        L_0x009b:
            int r1 = r13.getComponentCount()
            r8 = 3
            if (r1 != r8) goto L_0x00a4
            r1 = 1
            goto L_0x00a5
        L_0x00a4:
            r1 = 0
        L_0x00a5:
            if (r1 == 0) goto L_0x0141
            int r13 = r13.getId$ui_graphics_release()
            r1 = -1
            if (r13 == r1) goto L_0x00af
            r0 = 1
        L_0x00af:
            if (r0 == 0) goto L_0x0135
            short r9 = androidx.compose.ui.graphics.Float16.m2026constructorimpl((float) r9)
            short r10 = androidx.compose.ui.graphics.Float16.m2026constructorimpl((float) r10)
            short r11 = androidx.compose.ui.graphics.Float16.m2026constructorimpl((float) r11)
            float r12 = java.lang.Math.min(r12, r2)
            float r12 = java.lang.Math.max(r4, r12)
            r0 = 1149222912(0x447fc000, float:1023.0)
            float r12 = r12 * r0
            float r12 = r12 + r7
            int r12 = (int) r12
            long r0 = (long) r9
            long r0 = kotlin.ULong.m5600constructorimpl(r0)
            r2 = 65535(0xffff, double:3.23786E-319)
            long r0 = r0 & r2
            long r0 = kotlin.ULong.m5600constructorimpl(r0)
            r9 = 48
            long r0 = r0 << r9
            long r0 = kotlin.ULong.m5600constructorimpl(r0)
            long r9 = (long) r10
            long r9 = kotlin.ULong.m5600constructorimpl(r9)
            long r9 = r9 & r2
            long r9 = kotlin.ULong.m5600constructorimpl(r9)
            long r9 = r9 << r5
            long r9 = kotlin.ULong.m5600constructorimpl(r9)
            long r9 = r9 | r0
            long r9 = kotlin.ULong.m5600constructorimpl(r9)
            long r0 = (long) r11
            long r0 = kotlin.ULong.m5600constructorimpl(r0)
            long r0 = r0 & r2
            long r0 = kotlin.ULong.m5600constructorimpl(r0)
            long r0 = r0 << r6
            long r0 = kotlin.ULong.m5600constructorimpl(r0)
            long r9 = r9 | r0
            long r9 = kotlin.ULong.m5600constructorimpl(r9)
            long r11 = (long) r12
            long r11 = kotlin.ULong.m5600constructorimpl(r11)
            r0 = 1023(0x3ff, double:5.054E-321)
            long r11 = r11 & r0
            long r11 = kotlin.ULong.m5600constructorimpl(r11)
            r0 = 6
            long r11 = r11 << r0
            long r11 = kotlin.ULong.m5600constructorimpl(r11)
            long r9 = r9 | r11
            long r9 = kotlin.ULong.m5600constructorimpl(r9)
            long r11 = (long) r13
            long r11 = kotlin.ULong.m5600constructorimpl(r11)
            r0 = 63
            long r11 = r11 & r0
            long r11 = kotlin.ULong.m5600constructorimpl(r11)
            long r9 = r9 | r11
            long r9 = kotlin.ULong.m5600constructorimpl(r9)
            long r9 = androidx.compose.ui.graphics.Color.m1928constructorimpl(r9)
            return r9
        L_0x0135:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Unknown color space, please use a color space in ColorSpaces"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x0141:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Color only works with ColorSpaces with 3 components"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x014d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "red = "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = ", green = "
            r0.append(r9)
            r0.append(r10)
            java.lang.String r9 = ", blue = "
            r0.append(r9)
            r0.append(r11)
            java.lang.String r9 = ", alpha = "
            r0.append(r9)
            r0.append(r12)
            java.lang.String r9 = " outside the range for "
            r0.append(r9)
            r0.append(r13)
            java.lang.String r9 = r0.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.ColorKt.Color(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    public static final long Color(int i) {
        return Color.m1928constructorimpl(ULong.m5600constructorimpl(ULong.m5600constructorimpl((long) i) << 32));
    }

    public static final long Color(long j) {
        return Color.m1928constructorimpl(ULong.m5600constructorimpl(ULong.m5600constructorimpl(ULong.m5600constructorimpl(j) & 4294967295L) << 32));
    }

    public static /* synthetic */ long Color$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 255;
        }
        return Color(i, i2, i3, i4);
    }

    public static final long Color(int i, int i2, int i3, int i4) {
        return Color(((i & 255) << 16) | ((i4 & 255) << 24) | ((i2 & 255) << 8) | (i3 & 255));
    }

    /* renamed from: lerp-jxsXWHM  reason: not valid java name */
    public static final long m1984lerpjxsXWHM(long j, long j2, float f) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long r8 = Color.m1929convertvNxB06k(j, oklab);
        long r1 = Color.m1929convertvNxB06k(j2, oklab);
        float r3 = Color.m1934getAlphaimpl(r8);
        float r4 = Color.m1938getRedimpl(r8);
        float r5 = Color.m1937getGreenimpl(r8);
        float r82 = Color.m1935getBlueimpl(r8);
        float r9 = Color.m1934getAlphaimpl(r1);
        float r6 = Color.m1938getRedimpl(r1);
        float r7 = Color.m1937getGreenimpl(r1);
        float r12 = Color.m1935getBlueimpl(r1);
        return Color.m1929convertvNxB06k(Color(MathHelpersKt.lerp(r4, r6, f), MathHelpersKt.lerp(r5, r7, f), MathHelpersKt.lerp(r82, r12, f), MathHelpersKt.lerp(r3, r9, f), oklab), Color.m1936getColorSpaceimpl(j2));
    }

    /* renamed from: compositeOver--OWjLjI  reason: not valid java name */
    public static final long m1978compositeOverOWjLjI(long j, long j2) {
        long r12 = Color.m1929convertvNxB06k(j, Color.m1936getColorSpaceimpl(j2));
        float r0 = Color.m1934getAlphaimpl(j2);
        float r1 = Color.m1934getAlphaimpl(r12);
        float f = 1.0f - r1;
        float f2 = (r0 * f) + r1;
        boolean z = true;
        float f3 = 0.0f;
        int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        float r4 = i == 0 ? 0.0f : ((Color.m1938getRedimpl(r12) * r1) + ((Color.m1938getRedimpl(j2) * r0) * f)) / f2;
        float r5 = i == 0 ? 0.0f : ((Color.m1937getGreenimpl(r12) * r1) + ((Color.m1937getGreenimpl(j2) * r0) * f)) / f2;
        float r122 = Color.m1935getBlueimpl(r12);
        float r13 = Color.m1935getBlueimpl(j2);
        if (i != 0) {
            z = false;
        }
        if (!z) {
            f3 = ((r122 * r1) + ((r13 * r0) * f)) / f2;
        }
        return Color(r4, r5, f3, f2, Color.m1936getColorSpaceimpl(j2));
    }

    /* access modifiers changed from: private */
    /* renamed from: getComponents-8_81llA  reason: not valid java name */
    public static final float[] m1979getComponents8_81llA(long j) {
        return new float[]{Color.m1938getRedimpl(j), Color.m1937getGreenimpl(j), Color.m1935getBlueimpl(j), Color.m1934getAlphaimpl(j)};
    }

    /* renamed from: luminance-8_81llA  reason: not valid java name */
    public static final float m1985luminance8_81llA(long j) {
        ColorSpace r0 = Color.m1936getColorSpaceimpl(j);
        if (ColorModel.m2342equalsimpl0(r0.m2351getModelxdoWZVw(), ColorModel.Companion.m2349getRgbxdoWZVw())) {
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            Function1<Double, Double> eotf = ((Rgb) r0).getEotf();
            return saturate((float) ((eotf.invoke(Double.valueOf((double) Color.m1938getRedimpl(j))).doubleValue() * 0.2126d) + (eotf.invoke(Double.valueOf((double) Color.m1937getGreenimpl(j))).doubleValue() * 0.7152d) + (eotf.invoke(Double.valueOf((double) Color.m1935getBlueimpl(j))).doubleValue() * 0.0722d)));
        }
        throw new IllegalArgumentException(("The specified color must be encoded in an RGB color space. The supplied color space is " + ColorModel.m2345toStringimpl(r0.m2351getModelxdoWZVw())).toString());
    }

    /* renamed from: toArgb-8_81llA  reason: not valid java name */
    public static final int m1987toArgb8_81llA(long j) {
        ColorSpace r0 = Color.m1936getColorSpaceimpl(j);
        if (r0.isSrgb()) {
            return (int) ULong.m5600constructorimpl(j >>> 32);
        }
        float[] r3 = m1979getComponents8_81llA(j);
        ColorSpaceKt.m2353connectYBCOT_4$default(r0, (ColorSpace) null, 0, 3, (Object) null).transform(r3);
        return ((int) ((r3[2] * 255.0f) + 0.5f)) | (((int) ((r3[3] * 255.0f) + 0.5f)) << 24) | (((int) ((r3[0] * 255.0f) + 0.5f)) << 16) | (((int) ((r3[1] * 255.0f) + 0.5f)) << 8);
    }

    /* renamed from: isSpecified-8_81llA  reason: not valid java name */
    public static final boolean m1980isSpecified8_81llA(long j) {
        return j != Color.Companion.m1968getUnspecified0d7_KjU();
    }

    /* renamed from: isUnspecified-8_81llA  reason: not valid java name */
    public static final boolean m1982isUnspecified8_81llA(long j) {
        return j == Color.Companion.m1968getUnspecified0d7_KjU();
    }

    /* renamed from: takeOrElse-DxMtmZc  reason: not valid java name */
    public static final long m1986takeOrElseDxMtmZc(long j, Function0<Color> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return (j > Color.Companion.m1968getUnspecified0d7_KjU() ? 1 : (j == Color.Companion.m1968getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? j : function0.invoke().m1942unboximpl();
    }
}
