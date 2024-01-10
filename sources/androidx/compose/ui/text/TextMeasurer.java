package androidx.compose.ui.text;

import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@ExperimentalTextApi
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006%"}, d2 = {"Landroidx/compose/ui/text/TextMeasurer;", "", "fallbackFontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fallbackDensity", "Landroidx/compose/ui/unit/Density;", "fallbackLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "cacheSize", "", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;I)V", "textLayoutCache", "Landroidx/compose/ui/text/TextLayoutCache;", "measure", "Landroidx/compose/ui/text/TextLayoutResult;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "density", "fontFamilyResolver", "skipCache", "measure-xDpz5zY", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;IZILjava/util/List;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Z)Landroidx/compose/ui/text/TextLayoutResult;", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextMeasurer.kt */
public final class TextMeasurer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int cacheSize;
    private final Density fallbackDensity;
    private final FontFamily.Resolver fallbackFontFamilyResolver;
    private final LayoutDirection fallbackLayoutDirection;
    private final TextLayoutCache textLayoutCache;

    public TextMeasurer(FontFamily.Resolver resolver, Density density, LayoutDirection layoutDirection, int i) {
        Intrinsics.checkNotNullParameter(resolver, "fallbackFontFamilyResolver");
        Intrinsics.checkNotNullParameter(density, "fallbackDensity");
        Intrinsics.checkNotNullParameter(layoutDirection, "fallbackLayoutDirection");
        this.fallbackFontFamilyResolver = resolver;
        this.fallbackDensity = density;
        this.fallbackLayoutDirection = layoutDirection;
        this.cacheSize = i;
        this.textLayoutCache = i > 0 ? new TextLayoutCache(i) : null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextMeasurer(FontFamily.Resolver resolver, Density density, LayoutDirection layoutDirection, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(resolver, density, layoutDirection, (i2 & 8) != 0 ? TextMeasurerKt.DefaultCacheSize : i);
    }

    /* renamed from: measure-xDpz5zY$default  reason: not valid java name */
    public static /* synthetic */ TextLayoutResult m4198measurexDpz5zY$default(TextMeasurer textMeasurer, AnnotatedString annotatedString, TextStyle textStyle, int i, boolean z, int i2, List list, long j, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z2, int i3, Object obj) {
        FontFamily.Resolver resolver2;
        TextMeasurer textMeasurer2 = textMeasurer;
        int i4 = i3;
        TextStyle textStyle2 = (i4 & 2) != 0 ? TextStyle.Companion.getDefault() : textStyle;
        int r3 = (i4 & 4) != 0 ? TextOverflow.Companion.m4590getClipgIe3tQ8() : i;
        boolean z3 = (i4 & 8) != 0 ? true : z;
        int i5 = (i4 & 16) != 0 ? Integer.MAX_VALUE : i2;
        List emptyList = (i4 & 32) != 0 ? CollectionsKt.emptyList() : list;
        long Constraints$default = (i4 & 64) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null) : j;
        LayoutDirection layoutDirection2 = (i4 & 128) != 0 ? textMeasurer2.fallbackLayoutDirection : layoutDirection;
        Density density2 = (i4 & 256) != 0 ? textMeasurer2.fallbackDensity : density;
        if ((i4 & 512) != 0) {
            resolver2 = textMeasurer2.fallbackFontFamilyResolver;
        } else {
            resolver2 = resolver;
        }
        return textMeasurer.m4199measurexDpz5zY(annotatedString, textStyle2, r3, z3, i5, emptyList, Constraints$default, layoutDirection2, density2, resolver2, (i4 & 1024) != 0 ? false : z2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x003f, code lost:
        r2 = r0.textLayoutCache;
     */
    /* renamed from: measure-xDpz5zY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.text.TextLayoutResult m4199measurexDpz5zY(androidx.compose.ui.text.AnnotatedString r16, androidx.compose.ui.text.TextStyle r17, int r18, boolean r19, int r20, java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> r21, long r22, androidx.compose.ui.unit.LayoutDirection r24, androidx.compose.ui.unit.Density r25, androidx.compose.ui.text.font.FontFamily.Resolver r26, boolean r27) {
        /*
            r15 = this;
            r0 = r15
            java.lang.String r1 = "text"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            java.lang.String r1 = "style"
            r4 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
            java.lang.String r1 = "placeholders"
            r5 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)
            java.lang.String r1 = "layoutDirection"
            r10 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            java.lang.String r1 = "density"
            r9 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            java.lang.String r1 = "fontFamilyResolver"
            r11 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            androidx.compose.ui.text.TextLayoutInput r1 = new androidx.compose.ui.text.TextLayoutInput
            r14 = 0
            r2 = r1
            r6 = r20
            r7 = r19
            r8 = r18
            r12 = r22
            r2.<init>((androidx.compose.ui.text.AnnotatedString) r3, (androidx.compose.ui.text.TextStyle) r4, (java.util.List) r5, (int) r6, (boolean) r7, (int) r8, (androidx.compose.ui.unit.Density) r9, (androidx.compose.ui.unit.LayoutDirection) r10, (androidx.compose.ui.text.font.FontFamily.Resolver) r11, (long) r12, (kotlin.jvm.internal.DefaultConstructorMarker) r14)
            if (r27 != 0) goto L_0x0048
            androidx.compose.ui.text.TextLayoutCache r2 = r0.textLayoutCache
            if (r2 == 0) goto L_0x0048
            androidx.compose.ui.text.TextLayoutResult r2 = r2.get(r1)
            goto L_0x0049
        L_0x0048:
            r2 = 0
        L_0x0049:
            if (r2 == 0) goto L_0x0072
            androidx.compose.ui.text.MultiParagraph r3 = r2.getMultiParagraph()
            float r3 = r3.getWidth()
            int r3 = androidx.compose.ui.text.ParagraphKt.ceilToInt(r3)
            androidx.compose.ui.text.MultiParagraph r4 = r2.getMultiParagraph()
            float r4 = r4.getHeight()
            int r4 = androidx.compose.ui.text.ParagraphKt.ceilToInt(r4)
            long r3 = androidx.compose.ui.unit.IntSizeKt.IntSize(r3, r4)
            r5 = r22
            long r3 = androidx.compose.ui.unit.ConstraintsKt.m4635constrain4WqzIAM(r5, r3)
            androidx.compose.ui.text.TextLayoutResult r1 = r2.m4194copyO0kMr_c(r1, r3)
            goto L_0x0080
        L_0x0072:
            androidx.compose.ui.text.TextMeasurer$Companion r2 = Companion
            androidx.compose.ui.text.TextLayoutResult r2 = r2.layout(r1)
            androidx.compose.ui.text.TextLayoutCache r3 = r0.textLayoutCache
            if (r3 == 0) goto L_0x007f
            r3.put(r1, r2)
        L_0x007f:
            r1 = r2
        L_0x0080:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextMeasurer.m4199measurexDpz5zY(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.text.TextStyle, int, boolean, int, java.util.List, long, androidx.compose.ui.unit.LayoutDirection, androidx.compose.ui.unit.Density, androidx.compose.ui.text.font.FontFamily$Resolver, boolean):androidx.compose.ui.text.TextLayoutResult");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/TextMeasurer$Companion;", "", "()V", "layout", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TextMeasurer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final TextLayoutResult layout(TextLayoutInput textLayoutInput) {
            int i;
            MultiParagraphIntrinsics multiParagraphIntrinsics = new MultiParagraphIntrinsics(textLayoutInput.getText(), TextStyleKt.resolveDefaults(textLayoutInput.getStyle(), textLayoutInput.getLayoutDirection()), textLayoutInput.getPlaceholders(), textLayoutInput.getDensity(), textLayoutInput.getFontFamilyResolver());
            int r0 = Constraints.m4626getMinWidthimpl(textLayoutInput.m4191getConstraintsmsEJaDk());
            boolean z = false;
            int r1 = (!(textLayoutInput.getSoftWrap() || TextOverflow.m4583equalsimpl0(textLayoutInput.m4192getOverflowgIe3tQ8(), TextOverflow.Companion.m4591getEllipsisgIe3tQ8())) || !Constraints.m4620getHasBoundedWidthimpl(textLayoutInput.m4191getConstraintsmsEJaDk())) ? Integer.MAX_VALUE : Constraints.m4624getMaxWidthimpl(textLayoutInput.m4191getConstraintsmsEJaDk());
            if (!textLayoutInput.getSoftWrap() && TextOverflow.m4583equalsimpl0(textLayoutInput.m4192getOverflowgIe3tQ8(), TextOverflow.Companion.m4591getEllipsisgIe3tQ8())) {
                z = true;
            }
            if (z) {
                i = 1;
            } else {
                i = textLayoutInput.getMaxLines();
            }
            if (r0 != r1) {
                r1 = RangesKt.coerceIn(ParagraphKt.ceilToInt(multiParagraphIntrinsics.getMaxIntrinsicWidth()), r0, r1);
            }
            MultiParagraph multiParagraph = new MultiParagraph(multiParagraphIntrinsics, ConstraintsKt.Constraints$default(0, r1, 0, Constraints.m4623getMaxHeightimpl(textLayoutInput.m4191getConstraintsmsEJaDk()), 5, (Object) null), i, TextOverflow.m4583equalsimpl0(textLayoutInput.m4192getOverflowgIe3tQ8(), TextOverflow.Companion.m4591getEllipsisgIe3tQ8()), (DefaultConstructorMarker) null);
            return new TextLayoutResult(textLayoutInput, multiParagraph, ConstraintsKt.m4635constrain4WqzIAM(textLayoutInput.m4191getConstraintsmsEJaDk(), IntSizeKt.IntSize((int) ((float) Math.ceil((double) multiParagraph.getWidth())), (int) ((float) Math.ceil((double) multiParagraph.getHeight())))), (DefaultConstructorMarker) null);
        }
    }
}
