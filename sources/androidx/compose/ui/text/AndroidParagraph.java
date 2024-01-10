package androidx.compose.ui.text;

import android.graphics.RectF;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.android.LayoutIntrinsics;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.selection.WordBoundary;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001Bj\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0002\u0010\u0016B(\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0002\u0010\u0019JB\u0010Q\u001a\u0002002\u0006\u0010R\u001a\u00020\r2\u0006\u0010S\u001a\u00020\r2\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010V\u001a\u00020\r2\u0006\u0010W\u001a\u00020\r2\u0006\u0010X\u001a\u00020\rH\u0002J+\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\rø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010aJ\u0010\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\rH\u0016J\u0010\u0010e\u001a\u00020<2\u0006\u0010d\u001a\u00020\rH\u0016J\u0010\u0010f\u001a\u00020<2\u0006\u0010d\u001a\u00020\rH\u0016J\u0018\u0010g\u001a\u00020(2\u0006\u0010d\u001a\u00020\r2\u0006\u0010h\u001a\u00020\u000fH\u0016J\u0015\u0010i\u001a\u00020(2\u0006\u0010j\u001a\u00020\rH\u0000¢\u0006\u0002\bkJ\u0015\u0010l\u001a\u00020(2\u0006\u0010j\u001a\u00020\rH\u0000¢\u0006\u0002\bmJ\u0010\u0010n\u001a\u00020(2\u0006\u0010j\u001a\u00020\rH\u0016J\u0015\u0010o\u001a\u00020(2\u0006\u0010j\u001a\u00020\rH\u0000¢\u0006\u0002\bpJ\u0018\u0010q\u001a\u00020\r2\u0006\u0010j\u001a\u00020\r2\u0006\u0010r\u001a\u00020\u000fH\u0016J\u0010\u0010s\u001a\u00020\r2\u0006\u0010d\u001a\u00020\rH\u0016J\u0010\u0010t\u001a\u00020\r2\u0006\u0010u\u001a\u00020(H\u0016J\u0010\u0010v\u001a\u00020(2\u0006\u0010j\u001a\u00020\rH\u0016J\u0010\u0010w\u001a\u00020(2\u0006\u0010j\u001a\u00020\rH\u0016J\u0010\u0010x\u001a\u00020(2\u0006\u0010j\u001a\u00020\rH\u0016J\u0010\u0010y\u001a\u00020\r2\u0006\u0010j\u001a\u00020\rH\u0016J\u0010\u0010z\u001a\u00020(2\u0006\u0010j\u001a\u00020\rH\u0016J\u0010\u0010{\u001a\u00020(2\u0006\u0010j\u001a\u00020\rH\u0016J\u001e\u0010|\u001a\u00020\r2\u0006\u0010}\u001a\u00020~H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0005\b\u0010\u0001J\u0011\u0010\u0001\u001a\u00020c2\u0006\u0010d\u001a\u00020\rH\u0016J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\rH\u0016J\"\u0010M\u001a\u00020\\2\u0006\u0010d\u001a\u00020\rH\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0001\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\rH\u0001¢\u0006\u0003\b\u0001J\u0011\u0010\u0001\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\rH\u0016J\u0013\u0010\u0001\u001a\u00020Z2\b\u0010\u0001\u001a\u00030\u0001H\u0002JJ\u0010\u0001\u001a\u00020Z2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020(2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016JD\u0010\u0001\u001a\u00020Z2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001JP\u0010\u0001\u001a\u00020Z2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001*\u000200H\u0002¢\u0006\u0003\u0010 \u0001R\u001c\u0010\u001a\u001a\u00020\u001b8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010*R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b5\u0010*R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b6\u00103R\u0014\u00107\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b8\u0010*R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001c\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020@8@X\u0004¢\u0006\f\u0012\u0004\bA\u0010\u001d\u001a\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020E8@X\u0004¢\u0006\f\u0012\u0004\bF\u0010\u001d\u001a\u0004\bG\u0010HR\u0014\u0010I\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010*R\u001b\u0010K\u001a\u00020L8BX\u0002¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bM\u0010N\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¡\u0001"}, d2 = {"Landroidx/compose/ui/text/AndroidParagraph;", "Landroidx/compose/ui/text/Paragraph;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "ellipsis", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "density", "Landroidx/compose/ui/unit/Density;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Ljava/util/List;IZJLandroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "paragraphIntrinsics", "Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "(Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;IZJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "charSequence", "", "getCharSequence$ui_text_release$annotations", "()V", "getCharSequence$ui_text_release", "()Ljava/lang/CharSequence;", "getConstraints-msEJaDk", "()J", "J", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "getEllipsis", "firstBaseline", "", "getFirstBaseline", "()F", "height", "getHeight", "lastBaseline", "getLastBaseline", "layout", "Landroidx/compose/ui/text/android/TextLayout;", "lineCount", "getLineCount", "()I", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "getMaxLines", "minIntrinsicWidth", "getMinIntrinsicWidth", "getParagraphIntrinsics", "()Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "placeholderRects", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "()Ljava/util/List;", "textLocale", "Ljava/util/Locale;", "getTextLocale$ui_text_release$annotations", "getTextLocale$ui_text_release", "()Ljava/util/Locale;", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getTextPaint$ui_text_release$annotations", "getTextPaint$ui_text_release", "()Landroidx/compose/ui/text/platform/AndroidTextPaint;", "width", "getWidth", "wordBoundary", "Landroidx/compose/ui/text/android/selection/WordBoundary;", "getWordBoundary", "()Landroidx/compose/ui/text/android/selection/WordBoundary;", "wordBoundary$delegate", "Lkotlin/Lazy;", "constructTextLayout", "alignment", "justificationMode", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "fillBoundingBoxes", "", "range", "Landroidx/compose/ui/text/TextRange;", "array", "", "arrayStart", "fillBoundingBoxes-8ffj60Q", "(J[FI)V", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineAscent", "lineIndex", "getLineAscent$ui_text_release", "getLineBaseline", "getLineBaseline$ui_text_release", "getLineBottom", "getLineDescent", "getLineDescent$ui_text_release", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineWidth", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "getWordBoundary--jx7JFs", "(I)J", "isEllipsisApplied", "isEllipsisApplied$ui_text_release", "isLineEllipsized", "paint", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "paint-iJQMabo", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)V", "getShaderBrushSpans", "", "Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "(Landroidx/compose/ui/text/android/TextLayout;)[Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidParagraph.android.kt */
public final class AndroidParagraph implements Paragraph {
    private final CharSequence charSequence;
    private final long constraints;
    private final boolean ellipsis;
    /* access modifiers changed from: private */
    public final TextLayout layout;
    private final int maxLines;
    private final AndroidParagraphIntrinsics paragraphIntrinsics;
    private final List<Rect> placeholderRects;
    private final Lazy wordBoundary$delegate;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AndroidParagraph.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResolvedTextDirection.values().length];
            iArr[ResolvedTextDirection.Ltr.ordinal()] = 1;
            iArr[ResolvedTextDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ AndroidParagraph(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i, boolean z, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(androidParagraphIntrinsics, i, z, j);
    }

    public /* synthetic */ AndroidParagraph(String str, TextStyle textStyle, List list, List list2, int i, boolean z, long j, FontFamily.Resolver resolver, Density density, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, list, list2, i, z, j, resolver, density);
    }

    public static /* synthetic */ void getCharSequence$ui_text_release$annotations() {
    }

    public static /* synthetic */ void getTextLocale$ui_text_release$annotations() {
    }

    public static /* synthetic */ void getTextPaint$ui_text_release$annotations() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v35, resolved type: java.util.List<androidx.compose.ui.geometry.Rect>} */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x021e, code lost:
        r9 = r9 + r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0248, code lost:
        r9 = r9 - ((float) r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x024a, code lost:
        r11 = new androidx.compose.ui.geometry.Rect(r6, r9, r7, ((float) r5.getHeightPx()) + r9);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AndroidParagraph(androidx.compose.ui.text.platform.AndroidParagraphIntrinsics r20, int r21, boolean r22, long r23) {
        /*
            r19 = this;
            r8 = r19
            r19.<init>()
            r0 = r20
            r8.paragraphIntrinsics = r0
            r0 = r21
            r8.maxLines = r0
            r0 = r22
            r8.ellipsis = r0
            r0 = r23
            r8.constraints = r0
            int r0 = androidx.compose.ui.unit.Constraints.m4625getMinHeightimpl(r23)
            r9 = 0
            r10 = 1
            if (r0 != 0) goto L_0x0027
            long r0 = r8.constraints
            int r0 = androidx.compose.ui.unit.Constraints.m4626getMinWidthimpl(r0)
            if (r0 != 0) goto L_0x0027
            r0 = 1
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            if (r0 == 0) goto L_0x0280
            int r0 = r8.maxLines
            if (r0 < r10) goto L_0x0030
            r0 = 1
            goto L_0x0031
        L_0x0030:
            r0 = 0
        L_0x0031:
            if (r0 == 0) goto L_0x0274
            androidx.compose.ui.text.platform.AndroidParagraphIntrinsics r0 = r8.paragraphIntrinsics
            androidx.compose.ui.text.TextStyle r11 = r0.getStyle()
            boolean r0 = r8.ellipsis
            boolean r0 = androidx.compose.ui.text.AndroidParagraph_androidKt.shouldAttachIndentationFixSpan(r11, r0)
            if (r0 == 0) goto L_0x004c
            androidx.compose.ui.text.platform.AndroidParagraphIntrinsics r0 = r8.paragraphIntrinsics
            java.lang.CharSequence r0 = r0.getCharSequence$ui_text_release()
            java.lang.CharSequence r0 = androidx.compose.ui.text.AndroidParagraph_androidKt.attachIndentationFixSpan(r0)
            goto L_0x0052
        L_0x004c:
            androidx.compose.ui.text.platform.AndroidParagraphIntrinsics r0 = r8.paragraphIntrinsics
            java.lang.CharSequence r0 = r0.getCharSequence$ui_text_release()
        L_0x0052:
            r8.charSequence = r0
            androidx.compose.ui.text.style.TextAlign r0 = r11.m4244getTextAlignbuA522U()
            int r12 = androidx.compose.ui.text.AndroidParagraph_androidKt.m4116toLayoutAlignAMY3VfE(r0)
            androidx.compose.ui.text.style.TextAlign r0 = r11.m4244getTextAlignbuA522U()
            androidx.compose.ui.text.style.TextAlign$Companion r1 = androidx.compose.ui.text.style.TextAlign.Companion
            int r1 = r1.m4556getJustifye0LSkKk()
            if (r0 != 0) goto L_0x006a
            r13 = 0
            goto L_0x0073
        L_0x006a:
            int r0 = r0.m4553unboximpl()
            boolean r0 = androidx.compose.ui.text.style.TextAlign.m4550equalsimpl0(r0, r1)
            r13 = r0
        L_0x0073:
            androidx.compose.ui.text.style.LineBreak r0 = r11.getLineBreak()
            r14 = 0
            if (r0 == 0) goto L_0x0083
            int r0 = r0.m4484getStrategyfcGXIks()
            androidx.compose.ui.text.style.LineBreak$Strategy r0 = androidx.compose.ui.text.style.LineBreak.Strategy.m4487boximpl(r0)
            goto L_0x0084
        L_0x0083:
            r0 = r14
        L_0x0084:
            int r15 = androidx.compose.ui.text.AndroidParagraph_androidKt.m4117toLayoutBreakStrategyu6PBz3U(r0)
            androidx.compose.ui.text.style.LineBreak r0 = r11.getLineBreak()
            if (r0 == 0) goto L_0x0097
            int r0 = r0.m4485getStrictnessusljTpc()
            androidx.compose.ui.text.style.LineBreak$Strictness r0 = androidx.compose.ui.text.style.LineBreak.Strictness.m4497boximpl(r0)
            goto L_0x0098
        L_0x0097:
            r0 = r14
        L_0x0098:
            int r16 = androidx.compose.ui.text.AndroidParagraph_androidKt.m4118toLayoutLineBreakStyle4a2g8L8(r0)
            androidx.compose.ui.text.style.LineBreak r0 = r11.getLineBreak()
            if (r0 == 0) goto L_0x00ab
            int r0 = r0.m4486getWordBreakjp8hJ3c()
            androidx.compose.ui.text.style.LineBreak$WordBreak r0 = androidx.compose.ui.text.style.LineBreak.WordBreak.m4508boximpl(r0)
            goto L_0x00ac
        L_0x00ab:
            r0 = r14
        L_0x00ac:
            int r17 = androidx.compose.ui.text.AndroidParagraph_androidKt.m4119toLayoutLineBreakWordStylegvcdTPQ(r0)
            boolean r0 = r8.ellipsis
            if (r0 == 0) goto L_0x00b7
            android.text.TextUtils$TruncateAt r0 = android.text.TextUtils.TruncateAt.END
            goto L_0x00ba
        L_0x00b7:
            r0 = r14
            android.text.TextUtils$TruncateAt r0 = (android.text.TextUtils.TruncateAt) r0
        L_0x00ba:
            r18 = r0
            int r4 = r8.maxLines
            r0 = r19
            r1 = r12
            r2 = r13
            r3 = r18
            r5 = r15
            r6 = r16
            r7 = r17
            androidx.compose.ui.text.android.TextLayout r0 = r0.constructTextLayout(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r8.ellipsis
            if (r1 == 0) goto L_0x0107
            int r1 = r0.getHeight()
            long r2 = r8.constraints
            int r2 = androidx.compose.ui.unit.Constraints.m4623getMaxHeightimpl(r2)
            if (r1 <= r2) goto L_0x0107
            int r1 = r8.maxLines
            if (r1 <= r10) goto L_0x0107
            long r1 = r8.constraints
            int r1 = androidx.compose.ui.unit.Constraints.m4623getMaxHeightimpl(r1)
            int r1 = androidx.compose.ui.text.AndroidParagraph_androidKt.numberOfLinesThatFitMaxHeight(r0, r1)
            if (r1 < 0) goto L_0x0104
            int r2 = r8.maxLines
            if (r1 == r2) goto L_0x0104
            int r4 = kotlin.ranges.RangesKt.coerceAtLeast((int) r1, (int) r10)
            r0 = r19
            r1 = r12
            r2 = r13
            r3 = r18
            r5 = r15
            r6 = r16
            r7 = r17
            androidx.compose.ui.text.android.TextLayout r0 = r0.constructTextLayout(r1, r2, r3, r4, r5, r6, r7)
        L_0x0104:
            r8.layout = r0
            goto L_0x0109
        L_0x0107:
            r8.layout = r0
        L_0x0109:
            androidx.compose.ui.text.platform.AndroidTextPaint r0 = r19.getTextPaint$ui_text_release()
            androidx.compose.ui.graphics.Brush r1 = r11.getBrush()
            float r2 = r19.getWidth()
            float r3 = r19.getHeight()
            long r2 = androidx.compose.ui.geometry.SizeKt.Size(r2, r3)
            float r4 = r11.getAlpha()
            r0.m4438setBrush12SF9DM(r1, r2, r4)
            androidx.compose.ui.text.android.TextLayout r0 = r8.layout
            androidx.compose.ui.text.platform.style.ShaderBrushSpan[] r0 = r8.getShaderBrushSpans(r0)
            int r1 = r0.length
            r2 = 0
        L_0x012c:
            if (r2 >= r1) goto L_0x0146
            r3 = r0[r2]
            float r4 = r19.getWidth()
            float r5 = r19.getHeight()
            long r4 = androidx.compose.ui.geometry.SizeKt.Size(r4, r5)
            androidx.compose.ui.geometry.Size r4 = androidx.compose.ui.geometry.Size.m1740boximpl(r4)
            r3.m4461setSizeiaC8Vc4(r4)
            int r2 = r2 + 1
            goto L_0x012c
        L_0x0146:
            java.lang.CharSequence r0 = r8.charSequence
            boolean r1 = r0 instanceof android.text.Spanned
            if (r1 != 0) goto L_0x0152
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0262
        L_0x0152:
            r1 = r0
            android.text.Spanned r1 = (android.text.Spanned) r1
            int r0 = r0.length()
            java.lang.Class<androidx.compose.ui.text.android.style.PlaceholderSpan> r2 = androidx.compose.ui.text.android.style.PlaceholderSpan.class
            java.lang.Object[] r0 = r1.getSpans(r9, r0, r2)
            java.lang.String r2 = "getSpans(0, length, PlaceholderSpan::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r0.length
            r2.<init>(r3)
            java.util.Collection r2 = (java.util.Collection) r2
            int r3 = r0.length
            r4 = 0
        L_0x016e:
            if (r4 >= r3) goto L_0x025f
            r5 = r0[r4]
            androidx.compose.ui.text.android.style.PlaceholderSpan r5 = (androidx.compose.ui.text.android.style.PlaceholderSpan) r5
            int r6 = r1.getSpanStart(r5)
            int r7 = r1.getSpanEnd(r5)
            androidx.compose.ui.text.android.TextLayout r11 = r8.layout
            int r11 = r11.getLineForOffset(r6)
            int r12 = r8.maxLines
            if (r11 < r12) goto L_0x0188
            r12 = 1
            goto L_0x0189
        L_0x0188:
            r12 = 0
        L_0x0189:
            androidx.compose.ui.text.android.TextLayout r13 = r8.layout
            int r13 = r13.getLineEllipsisCount(r11)
            if (r13 <= 0) goto L_0x019b
            androidx.compose.ui.text.android.TextLayout r13 = r8.layout
            int r13 = r13.getLineEllipsisOffset(r11)
            if (r7 <= r13) goto L_0x019b
            r13 = 1
            goto L_0x019c
        L_0x019b:
            r13 = 0
        L_0x019c:
            androidx.compose.ui.text.android.TextLayout r15 = r8.layout
            int r15 = r15.getLineEnd(r11)
            if (r7 <= r15) goto L_0x01a6
            r7 = 1
            goto L_0x01a7
        L_0x01a6:
            r7 = 0
        L_0x01a7:
            if (r13 != 0) goto L_0x0256
            if (r7 != 0) goto L_0x0256
            if (r12 == 0) goto L_0x01af
            goto L_0x0256
        L_0x01af:
            androidx.compose.ui.text.style.ResolvedTextDirection r7 = r8.getBidiRunDirection(r6)
            int[] r12 = androidx.compose.ui.text.AndroidParagraph.WhenMappings.$EnumSwitchMapping$0
            int r7 = r7.ordinal()
            r7 = r12[r7]
            r12 = 2
            if (r7 == r10) goto L_0x01d1
            if (r7 != r12) goto L_0x01cb
            float r6 = r8.getHorizontalPosition(r6, r10)
            int r7 = r5.getWidthPx()
            float r7 = (float) r7
            float r6 = r6 - r7
            goto L_0x01d5
        L_0x01cb:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01d1:
            float r6 = r8.getHorizontalPosition(r6, r10)
        L_0x01d5:
            int r7 = r5.getWidthPx()
            float r7 = (float) r7
            float r7 = r7 + r6
            androidx.compose.ui.text.android.TextLayout r13 = r8.layout
            int r15 = r5.getVerticalAlign()
            switch(r15) {
                case 0: goto L_0x0240;
                case 1: goto L_0x023b;
                case 2: goto L_0x0232;
                case 3: goto L_0x0220;
                case 4: goto L_0x0213;
                case 5: goto L_0x0202;
                case 6: goto L_0x01ed;
                default: goto L_0x01e4;
            }
        L_0x01e4:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unexpected verticalAlignment"
            r0.<init>(r1)
            throw r0
        L_0x01ed:
            android.graphics.Paint$FontMetricsInt r15 = r5.getFontMetrics()
            int r9 = r15.ascent
            int r15 = r15.descent
            int r9 = r9 + r15
            int r15 = r5.getHeightPx()
            int r9 = r9 - r15
            int r9 = r9 / r12
            float r9 = (float) r9
            float r11 = r13.getLineBaseline(r11)
            goto L_0x021e
        L_0x0202:
            android.graphics.Paint$FontMetricsInt r9 = r5.getFontMetrics()
            int r9 = r9.descent
            float r9 = (float) r9
            float r11 = r13.getLineBaseline(r11)
            float r9 = r9 + r11
            int r11 = r5.getHeightPx()
            goto L_0x0248
        L_0x0213:
            android.graphics.Paint$FontMetricsInt r9 = r5.getFontMetrics()
            int r9 = r9.ascent
            float r9 = (float) r9
            float r11 = r13.getLineBaseline(r11)
        L_0x021e:
            float r9 = r9 + r11
            goto L_0x024a
        L_0x0220:
            float r9 = r13.getLineTop(r11)
            float r11 = r13.getLineBottom(r11)
            float r9 = r9 + r11
            int r11 = r5.getHeightPx()
            float r11 = (float) r11
            float r9 = r9 - r11
            float r11 = (float) r12
            float r9 = r9 / r11
            goto L_0x024a
        L_0x0232:
            float r9 = r13.getLineBottom(r11)
            int r11 = r5.getHeightPx()
            goto L_0x0248
        L_0x023b:
            float r9 = r13.getLineTop(r11)
            goto L_0x024a
        L_0x0240:
            float r9 = r13.getLineBaseline(r11)
            int r11 = r5.getHeightPx()
        L_0x0248:
            float r11 = (float) r11
            float r9 = r9 - r11
        L_0x024a:
            int r5 = r5.getHeightPx()
            float r5 = (float) r5
            float r5 = r5 + r9
            androidx.compose.ui.geometry.Rect r11 = new androidx.compose.ui.geometry.Rect
            r11.<init>(r6, r9, r7, r5)
            goto L_0x0257
        L_0x0256:
            r11 = r14
        L_0x0257:
            r2.add(r11)
            int r4 = r4 + 1
            r9 = 0
            goto L_0x016e
        L_0x025f:
            r0 = r2
            java.util.List r0 = (java.util.List) r0
        L_0x0262:
            r8.placeholderRects = r0
            kotlin.LazyThreadSafetyMode r0 = kotlin.LazyThreadSafetyMode.NONE
            androidx.compose.ui.text.AndroidParagraph$wordBoundary$2 r1 = new androidx.compose.ui.text.AndroidParagraph$wordBoundary$2
            r1.<init>(r8)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            kotlin.Lazy r0 = kotlin.LazyKt.lazy((kotlin.LazyThreadSafetyMode) r0, r1)
            r8.wordBoundary$delegate = r0
            return
        L_0x0274:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "maxLines should be greater than 0"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0280:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.AndroidParagraph.<init>(androidx.compose.ui.text.platform.AndroidParagraphIntrinsics, int, boolean, long):void");
    }

    public final AndroidParagraphIntrinsics getParagraphIntrinsics() {
        return this.paragraphIntrinsics;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final boolean getEllipsis() {
        return this.ellipsis;
    }

    /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
    public final long m4107getConstraintsmsEJaDk() {
        return this.constraints;
    }

    private AndroidParagraph(String str, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, List<AnnotatedString.Range<Placeholder>> list2, int i, boolean z, long j, FontFamily.Resolver resolver, Density density) {
        this(new AndroidParagraphIntrinsics(str, textStyle, list, list2, resolver, density), i, z, j, (DefaultConstructorMarker) null);
    }

    public final CharSequence getCharSequence$ui_text_release() {
        return this.charSequence;
    }

    public float getWidth() {
        return (float) Constraints.m4624getMaxWidthimpl(this.constraints);
    }

    public float getHeight() {
        return (float) this.layout.getHeight();
    }

    public float getMaxIntrinsicWidth() {
        return this.paragraphIntrinsics.getMaxIntrinsicWidth();
    }

    public float getMinIntrinsicWidth() {
        return this.paragraphIntrinsics.getMinIntrinsicWidth();
    }

    public float getFirstBaseline() {
        return getLineBaseline$ui_text_release(0);
    }

    public float getLastBaseline() {
        return getLineBaseline$ui_text_release(getLineCount() - 1);
    }

    public boolean getDidExceedMaxLines() {
        return this.layout.getDidExceedMaxLines();
    }

    public final Locale getTextLocale$ui_text_release() {
        Locale textLocale = this.paragraphIntrinsics.getTextPaint$ui_text_release().getTextLocale();
        Intrinsics.checkNotNullExpressionValue(textLocale, "paragraphIntrinsics.textPaint.textLocale");
        return textLocale;
    }

    public int getLineCount() {
        return this.layout.getLineCount();
    }

    public List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    public final AndroidTextPaint getTextPaint$ui_text_release() {
        return this.paragraphIntrinsics.getTextPaint$ui_text_release();
    }

    public int getLineForVerticalPosition(float f) {
        return this.layout.getLineForVertical((int) f);
    }

    /* renamed from: getOffsetForPosition-k-4lQ0M  reason: not valid java name */
    public int m4108getOffsetForPositionk4lQ0M(long j) {
        return this.layout.getOffsetForHorizontal(this.layout.getLineForVertical((int) Offset.m1684getYimpl(j)), Offset.m1683getXimpl(j));
    }

    public Rect getBoundingBox(int i) {
        RectF boundingBox = this.layout.getBoundingBox(i);
        return new Rect(boundingBox.left, boundingBox.top, boundingBox.right, boundingBox.bottom);
    }

    /* renamed from: fillBoundingBoxes-8ffj60Q  reason: not valid java name */
    public final void m4106fillBoundingBoxes8ffj60Q(long j, float[] fArr, int i) {
        Intrinsics.checkNotNullParameter(fArr, "array");
        this.layout.fillBoundingBoxes(TextRange.m4218getMinimpl(j), TextRange.m4217getMaximpl(j), fArr, i);
    }

    public Path getPathForRange(int i, int i2) {
        boolean z = false;
        if (i >= 0 && i <= i2) {
            z = true;
        }
        if (!z || i2 > this.charSequence.length()) {
            throw new AssertionError("Start(" + i + ") or End(" + i2 + ") is out of Range(0.." + this.charSequence.length() + "), or start > end!");
        }
        android.graphics.Path path = new android.graphics.Path();
        this.layout.getSelectionPath(i, i2, path);
        return AndroidPath_androidKt.asComposePath(path);
    }

    public Rect getCursorRect(int i) {
        if (i >= 0 && i <= this.charSequence.length()) {
            float primaryHorizontal$default = TextLayout.getPrimaryHorizontal$default(this.layout, i, false, 2, (Object) null);
            int lineForOffset = this.layout.getLineForOffset(i);
            return new Rect(primaryHorizontal$default, this.layout.getLineTop(lineForOffset), primaryHorizontal$default, this.layout.getLineBottom(lineForOffset));
        }
        throw new AssertionError("offset(" + i + ") is out of bounds (0," + this.charSequence.length());
    }

    private final WordBoundary getWordBoundary() {
        return (WordBoundary) this.wordBoundary$delegate.getValue();
    }

    /* renamed from: getWordBoundary--jx7JFs  reason: not valid java name */
    public long m4109getWordBoundaryjx7JFs(int i) {
        return TextRangeKt.TextRange(getWordBoundary().getWordStart(i), getWordBoundary().getWordEnd(i));
    }

    public float getLineLeft(int i) {
        return this.layout.getLineLeft(i);
    }

    public float getLineRight(int i) {
        return this.layout.getLineRight(i);
    }

    public float getLineTop(int i) {
        return this.layout.getLineTop(i);
    }

    public final float getLineAscent$ui_text_release(int i) {
        return this.layout.getLineAscent(i);
    }

    public final float getLineBaseline$ui_text_release(int i) {
        return this.layout.getLineBaseline(i);
    }

    public final float getLineDescent$ui_text_release(int i) {
        return this.layout.getLineDescent(i);
    }

    public float getLineBottom(int i) {
        return this.layout.getLineBottom(i);
    }

    public float getLineHeight(int i) {
        return this.layout.getLineHeight(i);
    }

    public float getLineWidth(int i) {
        return this.layout.getLineWidth(i);
    }

    public int getLineStart(int i) {
        return this.layout.getLineStart(i);
    }

    public int getLineEnd(int i, boolean z) {
        if (z) {
            return this.layout.getLineVisibleEnd(i);
        }
        return this.layout.getLineEnd(i);
    }

    public boolean isLineEllipsized(int i) {
        return this.layout.isLineEllipsized(i);
    }

    public int getLineForOffset(int i) {
        return this.layout.getLineForOffset(i);
    }

    public float getHorizontalPosition(int i, boolean z) {
        if (z) {
            return TextLayout.getPrimaryHorizontal$default(this.layout, i, false, 2, (Object) null);
        }
        return TextLayout.getSecondaryHorizontal$default(this.layout, i, false, 2, (Object) null);
    }

    public ResolvedTextDirection getParagraphDirection(int i) {
        return this.layout.getParagraphDirection(this.layout.getLineForOffset(i)) == 1 ? ResolvedTextDirection.Ltr : ResolvedTextDirection.Rtl;
    }

    public ResolvedTextDirection getBidiRunDirection(int i) {
        if (this.layout.isRtlCharAt(i)) {
            return ResolvedTextDirection.Rtl;
        }
        return ResolvedTextDirection.Ltr;
    }

    public final boolean isEllipsisApplied$ui_text_release(int i) {
        return this.layout.isEllipsisApplied(i);
    }

    private final ShaderBrushSpan[] getShaderBrushSpans(TextLayout textLayout) {
        if (!(textLayout.getText() instanceof Spanned)) {
            return (ShaderBrushSpan[]) ((Object[]) new ShaderBrushSpan[0]);
        }
        CharSequence text = textLayout.getText();
        Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spanned");
        ShaderBrushSpan[] shaderBrushSpanArr = (ShaderBrushSpan[]) ((Spanned) text).getSpans(0, textLayout.getText().length(), ShaderBrushSpan.class);
        Intrinsics.checkNotNullExpressionValue(shaderBrushSpanArr, "brushSpans");
        return shaderBrushSpanArr.length == 0 ? (ShaderBrushSpan[]) ((Object[]) new ShaderBrushSpan[0]) : shaderBrushSpanArr;
    }

    /* renamed from: paint-RPmYEkk  reason: not valid java name */
    public void m4110paintRPmYEkk(Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        textPaint$ui_text_release.m4440setColor8_81llA(j);
        textPaint$ui_text_release.setShadow(shadow);
        textPaint$ui_text_release.setTextDecoration(textDecoration);
        paint(canvas);
    }

    /* renamed from: paint-iJQMabo  reason: not valid java name */
    public void m4111paintiJQMabo(Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        textPaint$ui_text_release.m4440setColor8_81llA(j);
        textPaint$ui_text_release.setShadow(shadow);
        textPaint$ui_text_release.setTextDecoration(textDecoration);
        textPaint$ui_text_release.setDrawStyle(drawStyle);
        paint(canvas);
    }

    public void paint(Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(brush, "brush");
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        textPaint$ui_text_release.m4438setBrush12SF9DM(brush, SizeKt.Size(getWidth(), getHeight()), f);
        textPaint$ui_text_release.setShadow(shadow);
        textPaint$ui_text_release.setTextDecoration(textDecoration);
        textPaint$ui_text_release.setDrawStyle(drawStyle);
        paint(canvas);
    }

    private final void paint(Canvas canvas) {
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.save();
            nativeCanvas.clipRect(0.0f, 0.0f, getWidth(), getHeight());
        }
        this.layout.paint(nativeCanvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.restore();
        }
    }

    private final TextLayout constructTextLayout(int i, int i2, TextUtils.TruncateAt truncateAt, int i3, int i4, int i5, int i6) {
        TextUtils.TruncateAt truncateAt2 = truncateAt;
        int i7 = i3;
        int i8 = i4;
        int i9 = i5;
        int i10 = i6;
        CharSequence charSequence2 = this.charSequence;
        float width = getWidth();
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        int textDirectionHeuristic$ui_text_release = this.paragraphIntrinsics.getTextDirectionHeuristic$ui_text_release();
        LayoutIntrinsics layoutIntrinsics$ui_text_release = this.paragraphIntrinsics.getLayoutIntrinsics$ui_text_release();
        return new TextLayout(charSequence2, width, textPaint$ui_text_release, i, truncateAt2, textDirectionHeuristic$ui_text_release, 1.0f, 0.0f, AndroidParagraphHelper_androidKt.isIncludeFontPaddingEnabled(this.paragraphIntrinsics.getStyle()), true, i7, i8, i9, i10, 0, i2, (int[]) null, (int[]) null, layoutIntrinsics$ui_text_release, 213120, (DefaultConstructorMarker) null);
    }
}
