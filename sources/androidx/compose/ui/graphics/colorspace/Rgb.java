package androidx.compose.ui.graphics.colorspace;

import com.facebook.react.uimanager.ViewProps;
import com.github.mikephil.charting.utils.Utils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0011\u0018\u0000 H2\u00020\u0001:\u0001HB?\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nBW\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0002\u0010\u0011B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0015B/\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0002\u0010\u001aB'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0002\u0010\u001bB?\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u001cB\u001f\b\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0000\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u001fBs\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010!J\u0013\u00106\u001a\u00020*2\b\u00107\u001a\u0004\u0018\u000108H\u0002J\u001e\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u000fJ\u000e\u00109\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u0005J\u0010\u0010>\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u0005H\u0016J\u0006\u0010?\u001a\u00020\u0005J\u000e\u0010?\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005J\u0010\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u0017H\u0016J\u0010\u0010B\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u0017H\u0016J\u0006\u0010C\u001a\u00020\u0005J\u000e\u0010C\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010D\u001a\u00020\u0005J\u000e\u0010D\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005J\b\u0010E\u001a\u00020\u0017H\u0016J\u001e\u0010F\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u000fJ\u000e\u0010F\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u0005J\u0010\u0010G\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u0005H\u0016R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0014\u0010&\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020*X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010+R\u0014\u0010,\u001a\u00020*X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010#R \u0010.\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010#R\u0014\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(R\u0013\u0010 \u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0014\u0010\u001e\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010(R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b4\u00105¨\u0006I"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Rgb;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "toXYZ", "", "oetf", "Lkotlin/Function1;", "", "eotf", "(Ljava/lang/String;[FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "primaries", "whitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "min", "", "max", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FF)V", "function", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/TransferParameters;)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;)V", "id", "", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "gamma", "(Ljava/lang/String;[FD)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;D)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;DFFI)V", "colorSpace", "transform", "(Landroidx/compose/ui/graphics/colorspace/Rgb;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;)V", "transferParameters", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;[FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FFLandroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "getEotf", "()Lkotlin/jvm/functions/Function1;", "eotfOrig", "getEotfOrig$ui_graphics_release", "inverseTransform", "getInverseTransform$ui_graphics_release", "()[F", "isSrgb", "", "()Z", "isWideGamut", "getOetf", "oetfOrig", "getOetfOrig$ui_graphics_release", "getPrimaries$ui_graphics_release", "getTransferParameters", "()Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "getTransform$ui_graphics_release", "getWhitePoint", "()Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "equals", "other", "", "fromLinear", "r", "g", "b", "v", "fromXyz", "getInverseTransform", "getMaxValue", "component", "getMinValue", "getPrimaries", "getTransform", "hashCode", "toLinear", "toXyz", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Rgb.kt */
public final class Rgb extends ColorSpace {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Function1<Double, Double> DoubleIdentity = Rgb$Companion$DoubleIdentity$1.INSTANCE;
    private final Function1<Double, Double> eotf;
    private final Function1<Double, Double> eotfOrig;
    private final float[] inverseTransform;
    private final boolean isSrgb;
    private final boolean isWideGamut;
    /* access modifiers changed from: private */
    public final float max;
    /* access modifiers changed from: private */
    public final float min;
    private final Function1<Double, Double> oetf;
    private final Function1<Double, Double> oetfOrig;
    private final float[] primaries;
    private final TransferParameters transferParameters;
    private final float[] transform;
    private final WhitePoint whitePoint;

    public final WhitePoint getWhitePoint() {
        return this.whitePoint;
    }

    public final TransferParameters getTransferParameters() {
        return this.transferParameters;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(java.lang.String r16, float[] r17, androidx.compose.ui.graphics.colorspace.WhitePoint r18, float[] r19, kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r20, kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r21, float r22, float r23, androidx.compose.ui.graphics.colorspace.TransferParameters r24, int r25) {
        /*
            r15 = this;
            r6 = r15
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r11 = r21
            java.lang.String r0 = "name"
            r1 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "primaries"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "whitePoint"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "oetf"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "eotf"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            androidx.compose.ui.graphics.colorspace.ColorModel$Companion r0 = androidx.compose.ui.graphics.colorspace.ColorModel.Companion
            long r2 = r0.m2349getRgbxdoWZVw()
            r5 = 0
            r0 = r15
            r4 = r25
            r0.<init>(r1, r2, r4, r5)
            r6.whitePoint = r8
            r0 = r22
            r6.min = r0
            r0 = r23
            r6.max = r0
            r0 = r24
            r6.transferParameters = r0
            r6.oetfOrig = r10
            androidx.compose.ui.graphics.colorspace.Rgb$oetf$1 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$oetf$1
            r0.<init>(r15)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r6.oetf = r0
            r6.eotfOrig = r11
            androidx.compose.ui.graphics.colorspace.Rgb$eotf$1 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$eotf$1
            r0.<init>(r15)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r6.eotf = r0
            int r0 = r7.length
            r1 = 9
            r2 = 6
            if (r0 == r2) goto L_0x006b
            int r0 = r7.length
            if (r0 != r1) goto L_0x0063
            goto L_0x006b
        L_0x0063:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The color space's primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ"
            r0.<init>(r1)
            throw r0
        L_0x006b:
            float r0 = r6.min
            float r2 = r6.max
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x00d2
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r0 = Companion
            float[] r0 = r0.xyPrimaries(r7)
            r6.primaries = r0
            if (r9 != 0) goto L_0x0088
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r1 = Companion
            androidx.compose.ui.graphics.colorspace.WhitePoint r2 = r6.whitePoint
            float[] r0 = r1.computeXYZMatrix(r0, r2)
            r6.transform = r0
            goto L_0x008d
        L_0x0088:
            int r0 = r9.length
            if (r0 != r1) goto L_0x00ba
            r6.transform = r9
        L_0x008d:
            float[] r0 = r6.transform
            float[] r0 = androidx.compose.ui.graphics.colorspace.ColorSpaceKt.inverse3x3(r0)
            r6.inverseTransform = r0
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r0 = Companion
            float[] r1 = r6.primaries
            float r2 = r6.min
            float r3 = r6.max
            boolean r0 = r0.isWideGamut(r1, r2, r3)
            r6.isWideGamut = r0
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r7 = Companion
            float[] r8 = r6.primaries
            androidx.compose.ui.graphics.colorspace.WhitePoint r9 = r6.whitePoint
            float r12 = r6.min
            float r13 = r6.max
            r10 = r20
            r11 = r21
            r14 = r25
            boolean r0 = r7.isSrgb(r8, r9, r10, r11, r12, r13, r14)
            r6.isSrgb = r0
            return
        L_0x00ba:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Transform must have 9 entries! Has "
            r1.append(r2)
            int r2 = r9.length
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00d2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid range: min="
            r1.append(r2)
            float r2 = r6.min
            r1.append(r2)
            java.lang.String r2 = ", max="
            r1.append(r2)
            float r2 = r6.max
            r1.append(r2)
            java.lang.String r2 = "; min must be strictly < max"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.WhitePoint, float[], kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, float, float, androidx.compose.ui.graphics.colorspace.TransferParameters, int):void");
    }

    public final float[] getPrimaries$ui_graphics_release() {
        return this.primaries;
    }

    public final float[] getTransform$ui_graphics_release() {
        return this.transform;
    }

    public final float[] getInverseTransform$ui_graphics_release() {
        return this.inverseTransform;
    }

    public final Function1<Double, Double> getOetfOrig$ui_graphics_release() {
        return this.oetfOrig;
    }

    public final Function1<Double, Double> getOetf() {
        return this.oetf;
    }

    public final Function1<Double, Double> getEotfOrig$ui_graphics_release() {
        return this.eotfOrig;
    }

    public final Function1<Double, Double> getEotf() {
        return this.eotf;
    }

    public boolean isWideGamut() {
        return this.isWideGamut;
    }

    public boolean isSrgb() {
        return this.isSrgb;
    }

    public final float[] getPrimaries() {
        float[] fArr = this.primaries;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public final float[] getTransform() {
        float[] fArr = this.transform;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public final float[] getInverseTransform() {
        float[] fArr = this.inverseTransform;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(java.lang.String r14, float[] r15, kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r16, kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r17) {
        /*
            r13 = this;
            r0 = r15
            java.lang.String r1 = "name"
            r3 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            java.lang.String r1 = "toXYZ"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            java.lang.String r1 = "oetf"
            r7 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            java.lang.String r1 = "eotf"
            r8 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r1 = Companion
            float[] r4 = r1.computePrimaries$ui_graphics_release(r15)
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r1 = Companion
            androidx.compose.ui.graphics.colorspace.WhitePoint r5 = r1.computeWhitePoint(r15)
            r6 = 0
            r9 = 0
            r10 = 1065353216(0x3f800000, float:1.0)
            r11 = 0
            r12 = -1
            r2 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(java.lang.String r13, float[] r14, androidx.compose.ui.graphics.colorspace.WhitePoint r15, kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r16, kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r17, float r18, float r19) {
        /*
            r12 = this;
            java.lang.String r0 = "name"
            r2 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "primaries"
            r3 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "whitePoint"
            r4 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "oetf"
            r6 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "eotf"
            r7 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r5 = 0
            r10 = 0
            r11 = -1
            r1 = r12
            r8 = r18
            r9 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.WhitePoint, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, float, float):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Rgb(String str, float[] fArr, TransferParameters transferParameters2) {
        this(str, Companion.computePrimaries$ui_graphics_release(fArr), Companion.computeWhitePoint(fArr), transferParameters2, -1);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(fArr, "toXYZ");
        Intrinsics.checkNotNullParameter(transferParameters2, "function");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Rgb(String str, float[] fArr, WhitePoint whitePoint2, TransferParameters transferParameters2) {
        this(str, fArr, whitePoint2, transferParameters2, -1);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(fArr, "primaries");
        Intrinsics.checkNotNullParameter(whitePoint2, "whitePoint");
        Intrinsics.checkNotNullParameter(transferParameters2, "function");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(java.lang.String r13, float[] r14, androidx.compose.ui.graphics.colorspace.WhitePoint r15, androidx.compose.ui.graphics.colorspace.TransferParameters r16, int r17) {
        /*
            r12 = this;
            r9 = r16
            java.lang.String r0 = "name"
            r1 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "primaries"
            r2 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "whitePoint"
            r3 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "function"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            double r4 = r16.getE()
            r0 = 1
            r6 = 0
            r7 = 0
            int r10 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r10 != 0) goto L_0x0029
            r4 = 1
            goto L_0x002a
        L_0x0029:
            r4 = 0
        L_0x002a:
            if (r4 == 0) goto L_0x0041
            double r4 = r16.getF()
            int r10 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r10 != 0) goto L_0x0036
            r4 = 1
            goto L_0x0037
        L_0x0036:
            r4 = 0
        L_0x0037:
            if (r4 == 0) goto L_0x0041
            androidx.compose.ui.graphics.colorspace.Rgb$1 r4 = new androidx.compose.ui.graphics.colorspace.Rgb$1
            r4.<init>(r9)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            goto L_0x0048
        L_0x0041:
            androidx.compose.ui.graphics.colorspace.Rgb$2 r4 = new androidx.compose.ui.graphics.colorspace.Rgb$2
            r4.<init>(r9)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
        L_0x0048:
            r5 = r4
            double r10 = r16.getE()
            int r4 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r4 != 0) goto L_0x0053
            r4 = 1
            goto L_0x0054
        L_0x0053:
            r4 = 0
        L_0x0054:
            if (r4 == 0) goto L_0x006a
            double r10 = r16.getF()
            int r4 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r4 != 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r0 = 0
        L_0x0060:
            if (r0 == 0) goto L_0x006a
            androidx.compose.ui.graphics.colorspace.Rgb$3 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$3
            r0.<init>(r9)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            goto L_0x0071
        L_0x006a:
            androidx.compose.ui.graphics.colorspace.Rgb$4 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$4
            r0.<init>(r9)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
        L_0x0071:
            r6 = r0
            r7 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            r0 = r12
            r1 = r13
            r2 = r14
            r3 = r15
            r9 = r16
            r10 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.WhitePoint, androidx.compose.ui.graphics.colorspace.TransferParameters, int):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Rgb(String str, float[] fArr, double d) {
        this(str, Companion.computePrimaries$ui_graphics_release(fArr), Companion.computeWhitePoint(fArr), d, 0.0f, 1.0f, -1);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(fArr, "toXYZ");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Rgb(String str, float[] fArr, WhitePoint whitePoint2, double d) {
        this(str, fArr, whitePoint2, d, 0.0f, 1.0f, -1);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(fArr, "primaries");
        Intrinsics.checkNotNullParameter(whitePoint2, "whitePoint");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(java.lang.String r23, float[] r24, androidx.compose.ui.graphics.colorspace.WhitePoint r25, double r26, float r28, float r29, int r30) {
        /*
            r22 = this;
            r1 = r26
            java.lang.String r0 = "name"
            r15 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "primaries"
            r13 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "whitePoint"
            r14 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1
            r3 = 0
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0023
            r4 = 1
            goto L_0x0024
        L_0x0023:
            r4 = 0
        L_0x0024:
            if (r4 == 0) goto L_0x0029
            kotlin.jvm.functions.Function1<java.lang.Double, java.lang.Double> r4 = DoubleIdentity
            goto L_0x0030
        L_0x0029:
            androidx.compose.ui.graphics.colorspace.Rgb$5 r4 = new androidx.compose.ui.graphics.colorspace.Rgb$5
            r4.<init>(r1)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
        L_0x0030:
            r17 = r4
            if (r6 != 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r0 = 0
        L_0x0036:
            if (r0 == 0) goto L_0x003b
            kotlin.jvm.functions.Function1<java.lang.Double, java.lang.Double> r0 = DoubleIdentity
            goto L_0x0042
        L_0x003b:
            androidx.compose.ui.graphics.colorspace.Rgb$6 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$6
            r0.<init>(r1)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
        L_0x0042:
            r18 = r0
            androidx.compose.ui.graphics.colorspace.TransferParameters r19 = new androidx.compose.ui.graphics.colorspace.TransferParameters
            r0 = r19
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r5 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r20 = 0
            r13 = r20
            r16 = 96
            r15 = r16
            r16 = 0
            r1 = r26
            r0.<init>(r1, r3, r5, r7, r9, r11, r13, r15, r16)
            r5 = 0
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r6 = r17
            r7 = r18
            r8 = r28
            r9 = r29
            r10 = r19
            r11 = r30
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.WhitePoint, double, float, float, int):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Rgb(Rgb rgb, float[] fArr, WhitePoint whitePoint2) {
        this(rgb.getName(), rgb.primaries, whitePoint2, fArr, rgb.oetfOrig, rgb.eotfOrig, rgb.min, rgb.max, rgb.transferParameters, -1);
        Intrinsics.checkNotNullParameter(rgb, "colorSpace");
        Intrinsics.checkNotNullParameter(fArr, ViewProps.TRANSFORM);
        Intrinsics.checkNotNullParameter(whitePoint2, "whitePoint");
    }

    public final float[] getPrimaries(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "primaries");
        return ArraysKt.copyInto$default(this.primaries, fArr, 0, 0, 0, 14, (Object) null);
    }

    public final float[] getTransform(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, ViewProps.TRANSFORM);
        return ArraysKt.copyInto$default(this.transform, fArr, 0, 0, 0, 14, (Object) null);
    }

    public final float[] getInverseTransform(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "inverseTransform");
        return ArraysKt.copyInto$default(this.inverseTransform, fArr, 0, 0, 0, 14, (Object) null);
    }

    public float getMinValue(int i) {
        return this.min;
    }

    public float getMaxValue(int i) {
        return this.max;
    }

    public final float[] toLinear(float f, float f2, float f3) {
        return toLinear(new float[]{f, f2, f3});
    }

    public final float[] toLinear(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "v");
        fArr[0] = (float) this.eotf.invoke(Double.valueOf((double) fArr[0])).doubleValue();
        fArr[1] = (float) this.eotf.invoke(Double.valueOf((double) fArr[1])).doubleValue();
        fArr[2] = (float) this.eotf.invoke(Double.valueOf((double) fArr[2])).doubleValue();
        return fArr;
    }

    public final float[] fromLinear(float f, float f2, float f3) {
        return fromLinear(new float[]{f, f2, f3});
    }

    public final float[] fromLinear(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "v");
        fArr[0] = (float) this.oetf.invoke(Double.valueOf((double) fArr[0])).doubleValue();
        fArr[1] = (float) this.oetf.invoke(Double.valueOf((double) fArr[1])).doubleValue();
        fArr[2] = (float) this.oetf.invoke(Double.valueOf((double) fArr[2])).doubleValue();
        return fArr;
    }

    public float[] toXyz(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "v");
        fArr[0] = (float) this.eotf.invoke(Double.valueOf((double) fArr[0])).doubleValue();
        fArr[1] = (float) this.eotf.invoke(Double.valueOf((double) fArr[1])).doubleValue();
        fArr[2] = (float) this.eotf.invoke(Double.valueOf((double) fArr[2])).doubleValue();
        return ColorSpaceKt.mul3x3Float3(this.transform, fArr);
    }

    public float[] fromXyz(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "v");
        ColorSpaceKt.mul3x3Float3(this.inverseTransform, fArr);
        fArr[0] = (float) this.oetf.invoke(Double.valueOf((double) fArr[0])).doubleValue();
        fArr[1] = (float) this.oetf.invoke(Double.valueOf((double) fArr[1])).doubleValue();
        fArr[2] = (float) this.oetf.invoke(Double.valueOf((double) fArr[2])).doubleValue();
        return fArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(getClass()), (Object) Reflection.getOrCreateKotlinClass(obj.getClass())) || !super.equals(obj)) {
            return false;
        }
        Rgb rgb = (Rgb) obj;
        if (Float.compare(rgb.min, this.min) != 0 || Float.compare(rgb.max, this.max) != 0 || !Intrinsics.areEqual((Object) this.whitePoint, (Object) rgb.whitePoint) || !Arrays.equals(this.primaries, rgb.primaries)) {
            return false;
        }
        TransferParameters transferParameters2 = this.transferParameters;
        if (transferParameters2 != null) {
            return Intrinsics.areEqual((Object) transferParameters2, (Object) rgb.transferParameters);
        }
        if (rgb.transferParameters == null) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) this.oetfOrig, (Object) rgb.oetfOrig)) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.eotfOrig, (Object) rgb.eotfOrig);
    }

    public int hashCode() {
        boolean z = true;
        int i = 0;
        int hashCode = ((((((super.hashCode() * 31) + this.whitePoint.hashCode()) * 31) + Arrays.hashCode(this.primaries)) * 31) + (!((this.min > 0.0f ? 1 : (this.min == 0.0f ? 0 : -1)) == 0) ? Float.floatToIntBits(this.min) : 0)) * 31;
        if (this.max != 0.0f) {
            z = false;
        }
        int floatToIntBits = (hashCode + (!z ? Float.floatToIntBits(this.max) : 0)) * 31;
        TransferParameters transferParameters2 = this.transferParameters;
        if (transferParameters2 != null) {
            i = transferParameters2.hashCode();
        }
        int i2 = floatToIntBits + i;
        return this.transferParameters == null ? (((i2 * 31) + this.oetfOrig.hashCode()) * 31) + this.eotfOrig.hashCode() : i2;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J8\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0015\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0002J(\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0002JX\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00132\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$H\u0002J \u0010%\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u0010\u0010&\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Rgb$Companion;", "", "()V", "DoubleIdentity", "Lkotlin/Function1;", "", "area", "", "primaries", "", "compare", "", "point", "a", "b", "computePrimaries", "toXYZ", "computePrimaries$ui_graphics_release", "computeWhitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "computeXYZMatrix", "whitePoint", "contains", "p1", "p2", "cross", "ax", "ay", "bx", "by", "isSrgb", "OETF", "EOTF", "min", "max", "id", "", "isWideGamut", "xyPrimaries", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Rgb.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final float cross(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean isSrgb(float[] fArr, WhitePoint whitePoint, Function1<? super Double, Double> function1, Function1<? super Double, Double> function12, float f, float f2, int i) {
            if (i == 0) {
                return true;
            }
            if (!ColorSpaceKt.compare(fArr, ColorSpaces.INSTANCE.getSrgbPrimaries$ui_graphics_release()) || !ColorSpaceKt.compare(whitePoint, Illuminant.INSTANCE.getD65())) {
                return false;
            }
            if (!(f == 0.0f)) {
                return false;
            }
            if (!(f2 == 1.0f)) {
                return false;
            }
            Rgb srgb = ColorSpaces.INSTANCE.getSrgb();
            for (double d = Utils.DOUBLE_EPSILON; d <= 1.0d; d += 0.00392156862745098d) {
                if (!compare(d, function1, srgb.getOetfOrig$ui_graphics_release()) || !compare(d, function12, srgb.getEotfOrig$ui_graphics_release())) {
                    return false;
                }
            }
            return true;
        }

        private final boolean compare(double d, Function1<? super Double, Double> function1, Function1<? super Double, Double> function12) {
            return Math.abs(function1.invoke(Double.valueOf(d)).doubleValue() - function12.invoke(Double.valueOf(d)).doubleValue()) <= 0.001d;
        }

        /* access modifiers changed from: private */
        public final boolean isWideGamut(float[] fArr, float f, float f2) {
            return (area(fArr) / area(ColorSpaces.INSTANCE.getNtsc1953Primaries$ui_graphics_release()) > 0.9f && contains(fArr, ColorSpaces.INSTANCE.getSrgbPrimaries$ui_graphics_release())) || (f < 0.0f && f2 > 1.0f);
        }

        private final float area(float[] fArr) {
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            float f4 = fArr[3];
            float f5 = fArr[4];
            float f6 = fArr[5];
            float f7 = ((((((f * f4) + (f2 * f5)) + (f3 * f6)) - (f4 * f5)) - (f2 * f3)) - (f * f6)) * 0.5f;
            return f7 < 0.0f ? -f7 : f7;
        }

        private final boolean contains(float[] fArr, float[] fArr2) {
            float[] fArr3 = {fArr[0] - fArr2[0], fArr[1] - fArr2[1], fArr[2] - fArr2[2], fArr[3] - fArr2[3], fArr[4] - fArr2[4], fArr[5] - fArr2[5]};
            if (cross(fArr3[0], fArr3[1], fArr2[0] - fArr2[4], fArr2[1] - fArr2[5]) < 0.0f || cross(fArr2[0] - fArr2[2], fArr2[1] - fArr2[3], fArr3[0], fArr3[1]) < 0.0f || cross(fArr3[2], fArr3[3], fArr2[2] - fArr2[0], fArr2[3] - fArr2[1]) < 0.0f || cross(fArr2[2] - fArr2[4], fArr2[3] - fArr2[5], fArr3[2], fArr3[3]) < 0.0f || cross(fArr3[4], fArr3[5], fArr2[4] - fArr2[2], fArr2[5] - fArr2[3]) < 0.0f || cross(fArr2[4] - fArr2[0], fArr2[5] - fArr2[1], fArr3[4], fArr3[5]) < 0.0f) {
                return false;
            }
            return true;
        }

        public final float[] computePrimaries$ui_graphics_release(float[] fArr) {
            Intrinsics.checkNotNullParameter(fArr, "toXYZ");
            float[] mul3x3Float3 = ColorSpaceKt.mul3x3Float3(fArr, new float[]{1.0f, 0.0f, 0.0f});
            float[] mul3x3Float32 = ColorSpaceKt.mul3x3Float3(fArr, new float[]{0.0f, 1.0f, 0.0f});
            float[] mul3x3Float33 = ColorSpaceKt.mul3x3Float3(fArr, new float[]{0.0f, 0.0f, 1.0f});
            float f = mul3x3Float3[0] + mul3x3Float3[1] + mul3x3Float3[2];
            float f2 = mul3x3Float32[0] + mul3x3Float32[1] + mul3x3Float32[2];
            float f3 = mul3x3Float33[0] + mul3x3Float33[1] + mul3x3Float33[2];
            return new float[]{mul3x3Float3[0] / f, mul3x3Float3[1] / f, mul3x3Float32[0] / f2, mul3x3Float32[1] / f2, mul3x3Float33[0] / f3, mul3x3Float33[1] / f3};
        }

        /* access modifiers changed from: private */
        public final WhitePoint computeWhitePoint(float[] fArr) {
            float[] mul3x3Float3 = ColorSpaceKt.mul3x3Float3(fArr, new float[]{1.0f, 1.0f, 1.0f});
            float f = mul3x3Float3[0] + mul3x3Float3[1] + mul3x3Float3[2];
            return new WhitePoint(mul3x3Float3[0] / f, mul3x3Float3[1] / f);
        }

        /* access modifiers changed from: private */
        public final float[] xyPrimaries(float[] fArr) {
            float[] fArr2 = new float[6];
            if (fArr.length == 9) {
                float f = fArr[0] + fArr[1] + fArr[2];
                fArr2[0] = fArr[0] / f;
                fArr2[1] = fArr[1] / f;
                float f2 = fArr[3] + fArr[4] + fArr[5];
                fArr2[2] = fArr[3] / f2;
                fArr2[3] = fArr[4] / f2;
                float f3 = fArr[6] + fArr[7] + fArr[8];
                fArr2[4] = fArr[6] / f3;
                fArr2[5] = fArr[7] / f3;
            } else {
                ArraysKt.copyInto$default(fArr, fArr2, 0, 0, 6, 6, (Object) null);
            }
            return fArr2;
        }

        /* access modifiers changed from: private */
        public final float[] computeXYZMatrix(float[] fArr, WhitePoint whitePoint) {
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            float f4 = fArr[3];
            float f5 = fArr[4];
            float f6 = fArr[5];
            float x = whitePoint.getX();
            float y = whitePoint.getY();
            float f7 = (float) 1;
            float f8 = (f7 - f) / f2;
            float f9 = f / f2;
            float f10 = (f3 / f4) - f9;
            float f11 = (x / y) - f9;
            float f12 = ((f7 - f3) / f4) - f8;
            float f13 = (f5 / f6) - f9;
            float f14 = (((((f7 - x) / y) - f8) * f10) - (f11 * f12)) / (((((f7 - f5) / f6) - f8) * f10) - (f12 * f13));
            float f15 = (f11 - (f13 * f14)) / f10;
            float f16 = (1.0f - f15) - f14;
            float f17 = f16 / f2;
            float f18 = f15 / f4;
            float f19 = f14 / f6;
            return new float[]{f17 * f, f16, f17 * ((1.0f - f) - f2), f18 * f3, f15, f18 * ((1.0f - f3) - f4), f19 * f5, f14, f19 * ((1.0f - f5) - f6)};
        }
    }
}
