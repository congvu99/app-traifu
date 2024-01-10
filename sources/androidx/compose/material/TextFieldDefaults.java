package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSize;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JS\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%J×\u0001\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00103\u001a\u0002042\u0013\b\u0002\u00105\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+H\u0007¢\u0006\u0002\u00106JÂ\u0001\u00107\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00103\u001a\u000204H\u0007¢\u0006\u0002\u00108Jç\u0001\u00109\u001a\u00020 2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010@\u001a\u00020;2\b\b\u0002\u0010A\u001a\u00020;2\b\b\u0002\u0010B\u001a\u00020;2\b\b\u0002\u0010C\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bP\u0010QJ=\u0010R\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bW\u0010XJç\u0001\u0010Y\u001a\u00020 2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010Z\u001a\u00020;2\b\b\u0002\u0010[\u001a\u00020;2\b\b\u0002\u0010\\\u001a\u00020;2\b\b\u0002\u0010]\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b^\u0010QJ=\u0010_\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b`\u0010XJ=\u0010a\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bb\u0010XJM\u0010c\u001a\u00020d*\u00020d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010e\u001a\u00020\u00062\b\b\u0002\u0010f\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bg\u0010hR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\f\u0010\bR\u001c\u0010\r\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0016\u0010\bR\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006i"}, d2 = {"Landroidx/compose/material/TextFieldDefaults;", "", "()V", "BackgroundOpacity", "", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "IconOpacity", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "OutlinedTextFieldShape", "Landroidx/compose/ui/graphics/Shape;", "getOutlinedTextFieldShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "TextFieldShape", "getTextFieldShape", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "UnfocusedIndicatorLineOpacity", "BorderBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material/TextFieldColors;", "shape", "focusedBorderThickness", "unfocusedBorderThickness", "BorderBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "OutlinedTextFieldDecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "border", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "TextFieldDecorationBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;III)V", "outlinedTextFieldColors", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-dx8h9Zs", "(JJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "outlinedTextFieldPadding", "start", "top", "end", "bottom", "outlinedTextFieldPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-dx8h9Zs", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "indicatorLine", "Landroidx/compose/ui/Modifier;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldDefaults.kt */
public final class TextFieldDefaults {
    public static final float BackgroundOpacity = 0.12f;
    private static final float FocusedBorderThickness = Dp.m4704constructorimpl((float) 2);
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    public static final float IconOpacity = 0.54f;
    private static final float MinHeight = Dp.m4704constructorimpl((float) 56);
    private static final float MinWidth = Dp.m4704constructorimpl((float) 280);
    private static final float UnfocusedBorderThickness = Dp.m4704constructorimpl((float) 1);
    public static final float UnfocusedIndicatorLineOpacity = 0.42f;

    private TextFieldDefaults() {
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m1469getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m1470getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    public final Shape getTextFieldShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1117199624, "C214@7704L6:TextFieldDefaults.kt#jmzs0o");
        CornerBasedShape copy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall(), (CornerSize) null, (CornerSize) null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, (Object) null);
        ComposerKt.sourceInformationMarkerEnd(composer);
        return copy$default;
    }

    public final Shape getOutlinedTextFieldShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1899109048, "C223@8006L6:TextFieldDefaults.kt#jmzs0o");
        CornerBasedShape small = MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall();
        ComposerKt.sourceInformationMarkerEnd(composer);
        return small;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM  reason: not valid java name */
    public final float m1471getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM  reason: not valid java name */
    public final float m1468getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* renamed from: indicatorLine-gv0btCI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1463indicatorLinegv0btCI$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, int i, Object obj) {
        float f3;
        float f4 = (i & 16) != 0 ? FocusedBorderThickness : f;
        if ((i & 32) != 0) {
            f3 = UnfocusedBorderThickness;
        } else {
            f3 = f2;
        }
        return textFieldDefaults.m1472indicatorLinegv0btCI(modifier, z, z2, interactionSource, textFieldColors, f4, f3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0136, code lost:
        if ((r12 & 64) != 0) goto L_0x0155;
     */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x010e  */
    @androidx.compose.material.ExperimentalMaterialApi
    /* renamed from: BorderBox-nbWgWpA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1467BorderBoxnbWgWpA(boolean r20, boolean r21, androidx.compose.foundation.interaction.InteractionSource r22, androidx.compose.material.TextFieldColors r23, androidx.compose.ui.graphics.Shape r24, float r25, float r26, androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            r19 = this;
            r11 = r19
            r8 = r22
            r9 = r23
            r10 = r28
            r12 = r29
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "colors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 943754022(0x38408b26, float:4.590596E-5)
            r1 = r27
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(BorderBox)P(1,4,3!1,5,2:c#ui.unit.Dp,6:c#ui.unit.Dp)313@11762L22,317@11946L203,325@12158L47:TextFieldDefaults.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x002b
            r0 = r10 | 6
            r14 = r20
            goto L_0x003d
        L_0x002b:
            r0 = r10 & 14
            r14 = r20
            if (r0 != 0) goto L_0x003c
            boolean r0 = r13.changed((boolean) r14)
            if (r0 == 0) goto L_0x0039
            r0 = 4
            goto L_0x003a
        L_0x0039:
            r0 = 2
        L_0x003a:
            r0 = r0 | r10
            goto L_0x003d
        L_0x003c:
            r0 = r10
        L_0x003d:
            r1 = r12 & 2
            if (r1 == 0) goto L_0x0046
            r0 = r0 | 48
            r15 = r21
            goto L_0x0058
        L_0x0046:
            r1 = r10 & 112(0x70, float:1.57E-43)
            r15 = r21
            if (r1 != 0) goto L_0x0058
            boolean r1 = r13.changed((boolean) r15)
            if (r1 == 0) goto L_0x0055
            r1 = 32
            goto L_0x0057
        L_0x0055:
            r1 = 16
        L_0x0057:
            r0 = r0 | r1
        L_0x0058:
            r1 = r12 & 4
            if (r1 == 0) goto L_0x005f
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006f
        L_0x005f:
            r1 = r10 & 896(0x380, float:1.256E-42)
            if (r1 != 0) goto L_0x006f
            boolean r1 = r13.changed((java.lang.Object) r8)
            if (r1 == 0) goto L_0x006c
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r1 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r0 = r0 | r1
        L_0x006f:
            r1 = r12 & 8
            if (r1 == 0) goto L_0x0076
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0086
        L_0x0076:
            r1 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x0086
            boolean r1 = r13.changed((java.lang.Object) r9)
            if (r1 == 0) goto L_0x0083
            r1 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0083:
            r1 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r0 = r0 | r1
        L_0x0086:
            r1 = 57344(0xe000, float:8.0356E-41)
            r2 = r10 & r1
            if (r2 != 0) goto L_0x00a2
            r2 = r12 & 16
            if (r2 != 0) goto L_0x009c
            r2 = r24
            boolean r3 = r13.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x009e
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a0
        L_0x009c:
            r2 = r24
        L_0x009e:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x00a0:
            r0 = r0 | r3
            goto L_0x00a4
        L_0x00a2:
            r2 = r24
        L_0x00a4:
            r3 = 458752(0x70000, float:6.42848E-40)
            r4 = r10 & r3
            if (r4 != 0) goto L_0x00bf
            r4 = r12 & 32
            if (r4 != 0) goto L_0x00b9
            r4 = r25
            boolean r5 = r13.changed((float) r4)
            if (r5 == 0) goto L_0x00bb
            r5 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bd
        L_0x00b9:
            r4 = r25
        L_0x00bb:
            r5 = 65536(0x10000, float:9.18355E-41)
        L_0x00bd:
            r0 = r0 | r5
            goto L_0x00c1
        L_0x00bf:
            r4 = r25
        L_0x00c1:
            r5 = 3670016(0x380000, float:5.142788E-39)
            r5 = r5 & r10
            if (r5 != 0) goto L_0x00db
            r5 = r12 & 64
            if (r5 != 0) goto L_0x00d5
            r5 = r26
            boolean r6 = r13.changed((float) r5)
            if (r6 == 0) goto L_0x00d7
            r6 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d9
        L_0x00d5:
            r5 = r26
        L_0x00d7:
            r6 = 524288(0x80000, float:7.34684E-40)
        L_0x00d9:
            r0 = r0 | r6
            goto L_0x00dd
        L_0x00db:
            r5 = r26
        L_0x00dd:
            r6 = r12 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x00e5
            r6 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00e3:
            r0 = r0 | r6
            goto L_0x00f6
        L_0x00e5:
            r6 = 29360128(0x1c00000, float:7.052966E-38)
            r6 = r6 & r10
            if (r6 != 0) goto L_0x00f6
            boolean r6 = r13.changed((java.lang.Object) r11)
            if (r6 == 0) goto L_0x00f3
            r6 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e3
        L_0x00f3:
            r6 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00e3
        L_0x00f6:
            r6 = 23967451(0x16db6db, float:4.3661218E-38)
            r6 = r6 & r0
            r7 = 4793490(0x492492, float:6.71711E-39)
            if (r6 != r7) goto L_0x010e
            boolean r6 = r13.getSkipping()
            if (r6 != 0) goto L_0x0106
            goto L_0x010e
        L_0x0106:
            r13.skipToGroupEnd()
            r6 = r2
            r7 = r4
            r8 = r5
            goto L_0x019b
        L_0x010e:
            r13.startDefaults()
            r6 = r10 & 1
            r7 = -3670017(0xffffffffffc7ffff, float:NaN)
            r16 = -458753(0xfffffffffff8ffff, float:NaN)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r6 == 0) goto L_0x0139
            boolean r6 = r13.getDefaultsInvalid()
            if (r6 == 0) goto L_0x0125
            goto L_0x0139
        L_0x0125:
            r13.skipToGroupEnd()
            r6 = r12 & 16
            if (r6 == 0) goto L_0x012e
            r0 = r0 & r17
        L_0x012e:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x0134
            r0 = r0 & r16
        L_0x0134:
            r6 = r12 & 64
            if (r6 == 0) goto L_0x0156
            goto L_0x0155
        L_0x0139:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0147
            int r2 = r0 >> 21
            r2 = r2 & 14
            androidx.compose.ui.graphics.Shape r2 = r11.getOutlinedTextFieldShape(r13, r2)
            r0 = r0 & r17
        L_0x0147:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x014f
            float r4 = FocusedBorderThickness
            r0 = r0 & r16
        L_0x014f:
            r6 = r12 & 64
            if (r6 == 0) goto L_0x0156
            float r5 = UnfocusedBorderThickness
        L_0x0155:
            r0 = r0 & r7
        L_0x0156:
            r7 = r2
            r16 = r4
            r17 = r5
            r13.endDefaults()
            r2 = r0 & 14
            r4 = r0 & 112(0x70, float:1.57E-43)
            r2 = r2 | r4
            r4 = r0 & 896(0x380, float:1.256E-42)
            r2 = r2 | r4
            r4 = r0 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r4
            int r0 = r0 >> 3
            r1 = r1 & r0
            r1 = r1 | r2
            r0 = r0 & r3
            r18 = r1 | r0
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r16
            r5 = r17
            r6 = r13
            r8 = r7
            r7 = r18
            androidx.compose.runtime.State r0 = androidx.compose.material.TextFieldDefaultsKt.m1479animateBorderStrokeAsStateNuRrP5Q(r0, r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            java.lang.Object r0 = r0.getValue()
            androidx.compose.foundation.BorderStroke r0 = (androidx.compose.foundation.BorderStroke) r0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.BorderKt.border(r1, r0, r8)
            r1 = 0
            androidx.compose.foundation.layout.BoxKt.Box(r0, r13, r1)
            r6 = r8
            r7 = r16
            r8 = r17
        L_0x019b:
            androidx.compose.runtime.ScopeUpdateScope r13 = r13.endRestartGroup()
            if (r13 != 0) goto L_0x01a2
            goto L_0x01be
        L_0x01a2:
            androidx.compose.material.TextFieldDefaults$BorderBox$1 r16 = new androidx.compose.material.TextFieldDefaults$BorderBox$1
            r0 = r16
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            r5 = r23
            r9 = r28
            r10 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x01be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldDefaults.m1467BorderBoxnbWgWpA(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material.TextFieldColors, androidx.compose.ui.graphics.Shape, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: textFieldWithLabelPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m1465textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getFirstBaselineOffset();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldBottomPadding();
        }
        return textFieldDefaults.m1476textFieldWithLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    @ExperimentalMaterialApi
    /* renamed from: textFieldWithLabelPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m1476textFieldWithLabelPaddinga9UjIt4(float f, float f2, float f3, float f4) {
        return PaddingKt.m506PaddingValuesa9UjIt4(f, f3, f2, f4);
    }

    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m1466textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m1477textFieldWithoutLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    @ExperimentalMaterialApi
    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m1477textFieldWithoutLabelPaddinga9UjIt4(float f, float f2, float f3, float f4) {
        return PaddingKt.m506PaddingValuesa9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: outlinedTextFieldPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m1464outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m1474outlinedTextFieldPaddinga9UjIt4(f, f2, f3, f4);
    }

    @ExperimentalMaterialApi
    /* renamed from: outlinedTextFieldPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m1474outlinedTextFieldPaddinga9UjIt4(float f, float f2, float f3, float f4) {
        return PaddingKt.m506PaddingValuesa9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: textFieldColors-dx8h9Zs  reason: not valid java name */
    public final TextFieldColors m1475textFieldColorsdx8h9Zs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, Composer composer, int i, int i2, int i3, int i4) {
        long j22;
        Composer composer2 = composer;
        int i5 = i4;
        composer2.startReplaceableGroup(231892599);
        ComposerKt.sourceInformation(composer2, "C(textFieldColors)P(17:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,19:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,15:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,18:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,20:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,16:c#ui.graphics.Color,5:c#ui.graphics.Color)376@14082L7,376@14113L7,377@14186L8,378@14244L6,379@14337L6,380@14401L6,382@14480L6,382@14521L4,384@14595L6,385@14747L8,386@14809L6,388@14883L6,389@15012L8,392@15141L6,393@15272L8,394@15337L6,396@15412L6,396@15453L4,397@15511L6,397@15546L6,398@15629L8,399@15687L6,400@15749L6,400@15784L6,401@15870L8:TextFieldDefaults.kt#jmzs0o");
        if ((i5 & 1) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd(composer);
            long r5 = ((Color) consume).m1942unboximpl();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer2.consume(ContentAlphaKt.getLocalContentAlpha());
            ComposerKt.sourceInformationMarkerEnd(composer);
            j22 = Color.m1931copywmQWz5c$default(r5, ((Number) consume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j22 = j;
        }
        long r7 = (i5 & 2) != 0 ? Color.m1931copywmQWz5c$default(j22, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        long r33 = (i5 & 4) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        long r9 = (i5 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1214getPrimary0d7_KjU() : j4;
        long r13 = (i5 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1208getError0d7_KjU() : j5;
        long r15 = (i5 & 32) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1214getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j6;
        long r17 = (i5 & 64) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.42f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j7;
        long r19 = (i5 & 128) != 0 ? Color.m1931copywmQWz5c$default(r17, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j8;
        long r21 = (i5 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1208getError0d7_KjU() : j9;
        long r23 = (i5 & 512) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j10;
        long r25 = (i5 & 1024) != 0 ? Color.m1931copywmQWz5c$default(r23, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j11;
        long j23 = (i5 & 2048) != 0 ? r23 : j12;
        long r29 = (i5 & 4096) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j13;
        long r31 = (i5 & 8192) != 0 ? Color.m1931copywmQWz5c$default(r29, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j14;
        long r35 = (i5 & 16384) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1208getError0d7_KjU() : j15;
        long r37 = (32768 & i5) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1214getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j16;
        long r39 = (65536 & i5) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j17;
        long r41 = (131072 & i5) != 0 ? Color.m1931copywmQWz5c$default(r39, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j18;
        long r43 = (262144 & i5) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1208getError0d7_KjU() : j19;
        long r45 = (524288 & i5) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j20;
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(j22, r7, r9, r13, r15, r17, r21, r19, r23, r25, j23, r29, r31, r35, r33, r37, r39, r41, r43, r45, (i5 & 1048576) != 0 ? Color.m1931copywmQWz5c$default(r45, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j21, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    /* renamed from: outlinedTextFieldColors-dx8h9Zs  reason: not valid java name */
    public final TextFieldColors m1473outlinedTextFieldColorsdx8h9Zs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, Composer composer, int i, int i2, int i3, int i4) {
        long j22;
        Composer composer2 = composer;
        int i5 = i4;
        composer2.startReplaceableGroup(1762667317);
        ComposerKt.sourceInformation(composer2, "C(outlinedTextFieldColors)P(17:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,13:c#ui.graphics.Color,19:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,18:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,20:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,16:c#ui.graphics.Color,5:c#ui.graphics.Color)434@17398L7,434@17429L7,435@17502L8,437@17608L6,438@17672L6,440@17748L6,440@17789L4,442@17860L6,442@17903L8,443@17998L8,444@18057L6,446@18131L6,447@18260L8,450@18389L6,451@18520L8,452@18585L6,454@18660L6,454@18701L4,455@18759L6,455@18794L6,456@18877L8,457@18935L6,458@18997L6,458@19032L6,459@19118L8:TextFieldDefaults.kt#jmzs0o");
        if ((i5 & 1) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd(composer);
            long r5 = ((Color) consume).m1942unboximpl();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer2.consume(ContentAlphaKt.getLocalContentAlpha());
            ComposerKt.sourceInformationMarkerEnd(composer);
            j22 = Color.m1931copywmQWz5c$default(r5, ((Number) consume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j22 = j;
        }
        long r7 = (i5 & 2) != 0 ? Color.m1931copywmQWz5c$default(j22, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        long r33 = (i5 & 4) != 0 ? Color.Companion.m1967getTransparent0d7_KjU() : j3;
        long r9 = (i5 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1214getPrimary0d7_KjU() : j4;
        long r13 = (i5 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1208getError0d7_KjU() : j5;
        long r15 = (i5 & 32) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1214getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j6;
        long r17 = (i5 & 64) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j7;
        long r19 = (i5 & 128) != 0 ? Color.m1931copywmQWz5c$default(r17, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j8;
        long r21 = (i5 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1208getError0d7_KjU() : j9;
        long r23 = (i5 & 512) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j10;
        long r25 = (i5 & 1024) != 0 ? Color.m1931copywmQWz5c$default(r23, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j11;
        long j23 = (i5 & 2048) != 0 ? r23 : j12;
        long r29 = (i5 & 4096) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j13;
        long r31 = (i5 & 8192) != 0 ? Color.m1931copywmQWz5c$default(r29, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j14;
        long r35 = (i5 & 16384) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1208getError0d7_KjU() : j15;
        long r37 = (32768 & i5) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1214getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j16;
        long r39 = (65536 & i5) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j17;
        long r41 = (131072 & i5) != 0 ? Color.m1931copywmQWz5c$default(r39, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j18;
        long r43 = (262144 & i5) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1208getError0d7_KjU() : j19;
        long r45 = (524288 & i5) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j20;
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(j22, r7, r9, r13, r15, r17, r21, r19, r23, r25, j23, r29, r31, r35, r33, r37, r39, r41, r43, r45, (i5 & 1048576) != 0 ? Color.m1931copywmQWz5c$default(r45, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j21, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x035a  */
    /* JADX WARNING: Removed duplicated region for block: B:195:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x013f  */
    @androidx.compose.material.ExperimentalMaterialApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void TextFieldDecorationBox(java.lang.String r71, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r72, boolean r73, boolean r74, androidx.compose.ui.text.input.VisualTransformation r75, androidx.compose.foundation.interaction.InteractionSource r76, boolean r77, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r79, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r80, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r81, androidx.compose.material.TextFieldColors r82, androidx.compose.foundation.layout.PaddingValues r83, androidx.compose.runtime.Composer r84, int r85, int r86, int r87) {
        /*
            r70 = this;
            r15 = r71
            r13 = r72
            r12 = r75
            r11 = r76
            r10 = r85
            r9 = r86
            r8 = r87
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "innerTextField"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "visualTransformation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 1171040065(0x45cca741, float:6548.9067)
            r1 = r84
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(TextFieldDecorationBox)P(11,3,2,9,12,4,5,6,8,7,10)553@25007L17,561@25241L569:TextFieldDefaults.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            r0 = r8 & 1
            if (r0 == 0) goto L_0x0039
            r0 = r10 | 6
            goto L_0x0049
        L_0x0039:
            r0 = r10 & 14
            if (r0 != 0) goto L_0x0048
            boolean r0 = r7.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0045
            r0 = 4
            goto L_0x0046
        L_0x0045:
            r0 = 2
        L_0x0046:
            r0 = r0 | r10
            goto L_0x0049
        L_0x0048:
            r0 = r10
        L_0x0049:
            r3 = r8 & 2
            if (r3 == 0) goto L_0x0050
            r0 = r0 | 48
            goto L_0x0060
        L_0x0050:
            r3 = r10 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0060
            boolean r3 = r7.changed((java.lang.Object) r13)
            if (r3 == 0) goto L_0x005d
            r3 = 32
            goto L_0x005f
        L_0x005d:
            r3 = 16
        L_0x005f:
            r0 = r0 | r3
        L_0x0060:
            r3 = r8 & 4
            if (r3 == 0) goto L_0x0067
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x007b
        L_0x0067:
            r3 = r10 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x007b
            r3 = r73
            boolean r16 = r7.changed((boolean) r3)
            if (r16 == 0) goto L_0x0076
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0078
        L_0x0076:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0078:
            r0 = r0 | r16
            goto L_0x007d
        L_0x007b:
            r3 = r73
        L_0x007d:
            r16 = r8 & 8
            r17 = 1024(0x400, float:1.435E-42)
            r18 = 2048(0x800, float:2.87E-42)
            if (r16 == 0) goto L_0x0088
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x009c
        L_0x0088:
            r1 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x009c
            r1 = r74
            boolean r16 = r7.changed((boolean) r1)
            if (r16 == 0) goto L_0x0097
            r16 = 2048(0x800, float:2.87E-42)
            goto L_0x0099
        L_0x0097:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x0099:
            r0 = r0 | r16
            goto L_0x009e
        L_0x009c:
            r1 = r74
        L_0x009e:
            r16 = r8 & 16
            r64 = 57344(0xe000, float:8.0356E-41)
            if (r16 == 0) goto L_0x00a8
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00b9
        L_0x00a8:
            r16 = r10 & r64
            if (r16 != 0) goto L_0x00b9
            boolean r16 = r7.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x00b5
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00b7
        L_0x00b5:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00b7:
            r0 = r0 | r16
        L_0x00b9:
            r16 = r8 & 32
            r65 = 458752(0x70000, float:6.42848E-40)
            if (r16 == 0) goto L_0x00c4
            r16 = 196608(0x30000, float:2.75506E-40)
        L_0x00c1:
            r0 = r0 | r16
            goto L_0x00d4
        L_0x00c4:
            r16 = r10 & r65
            if (r16 != 0) goto L_0x00d4
            boolean r16 = r7.changed((java.lang.Object) r11)
            if (r16 == 0) goto L_0x00d1
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c1
        L_0x00d1:
            r16 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00c1
        L_0x00d4:
            r16 = r8 & 64
            r66 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00e1
            r19 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r19
            r2 = r77
            goto L_0x00f4
        L_0x00e1:
            r19 = r10 & r66
            r2 = r77
            if (r19 != 0) goto L_0x00f4
            boolean r20 = r7.changed((boolean) r2)
            if (r20 == 0) goto L_0x00f0
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00f2
        L_0x00f0:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x00f2:
            r0 = r0 | r20
        L_0x00f4:
            r4 = r8 & 128(0x80, float:1.794E-43)
            r67 = 29360128(0x1c00000, float:7.052966E-38)
            if (r4 == 0) goto L_0x0101
            r21 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r21
            r5 = r78
            goto L_0x0114
        L_0x0101:
            r21 = r10 & r67
            r5 = r78
            if (r21 != 0) goto L_0x0114
            boolean r22 = r7.changed((java.lang.Object) r5)
            if (r22 == 0) goto L_0x0110
            r22 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0112
        L_0x0110:
            r22 = 4194304(0x400000, float:5.877472E-39)
        L_0x0112:
            r0 = r0 | r22
        L_0x0114:
            r6 = r8 & 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L_0x011f
            r23 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r23
            r14 = r79
            goto L_0x0134
        L_0x011f:
            r23 = 234881024(0xe000000, float:1.5777218E-30)
            r23 = r10 & r23
            r14 = r79
            if (r23 != 0) goto L_0x0134
            boolean r24 = r7.changed((java.lang.Object) r14)
            if (r24 == 0) goto L_0x0130
            r24 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0132
        L_0x0130:
            r24 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0132:
            r0 = r0 | r24
        L_0x0134:
            r1 = r8 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x013f
            r24 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r24
            r2 = r80
            goto L_0x0154
        L_0x013f:
            r24 = 1879048192(0x70000000, float:1.58456325E29)
            r24 = r10 & r24
            r2 = r80
            if (r24 != 0) goto L_0x0154
            boolean r24 = r7.changed((java.lang.Object) r2)
            if (r24 == 0) goto L_0x0150
            r24 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0152
        L_0x0150:
            r24 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0152:
            r0 = r0 | r24
        L_0x0154:
            r68 = r0
            r0 = r8 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x015f
            r19 = r9 | 6
            r2 = r81
            goto L_0x0175
        L_0x015f:
            r24 = r9 & 14
            r2 = r81
            if (r24 != 0) goto L_0x0173
            boolean r24 = r7.changed((java.lang.Object) r2)
            if (r24 == 0) goto L_0x016e
            r19 = 4
            goto L_0x0170
        L_0x016e:
            r19 = 2
        L_0x0170:
            r19 = r9 | r19
            goto L_0x0175
        L_0x0173:
            r19 = r9
        L_0x0175:
            r24 = r9 & 112(0x70, float:1.57E-43)
            if (r24 != 0) goto L_0x018f
            r2 = r8 & 2048(0x800, float:2.87E-42)
            if (r2 != 0) goto L_0x0188
            r2 = r82
            boolean r24 = r7.changed((java.lang.Object) r2)
            if (r24 == 0) goto L_0x018a
            r20 = 32
            goto L_0x018c
        L_0x0188:
            r2 = r82
        L_0x018a:
            r20 = 16
        L_0x018c:
            r19 = r19 | r20
            goto L_0x0191
        L_0x018f:
            r2 = r82
        L_0x0191:
            r2 = r9 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x01ab
            r2 = r8 & 4096(0x1000, float:5.74E-42)
            if (r2 != 0) goto L_0x01a4
            r2 = r83
            boolean r20 = r7.changed((java.lang.Object) r2)
            if (r20 == 0) goto L_0x01a6
            r22 = 256(0x100, float:3.59E-43)
            goto L_0x01a8
        L_0x01a4:
            r2 = r83
        L_0x01a6:
            r22 = 128(0x80, float:1.794E-43)
        L_0x01a8:
            r19 = r19 | r22
            goto L_0x01ad
        L_0x01ab:
            r2 = r83
        L_0x01ad:
            r2 = r19
            r3 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x01b6
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x01c7
        L_0x01b6:
            r3 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x01c7
            r3 = r70
            boolean r19 = r7.changed((java.lang.Object) r3)
            if (r19 == 0) goto L_0x01c4
            r17 = 2048(0x800, float:2.87E-42)
        L_0x01c4:
            r2 = r2 | r17
            goto L_0x01c9
        L_0x01c7:
            r3 = r70
        L_0x01c9:
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r68 & r17
            r5 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r5) goto L_0x01f4
            r3 = r2 & 5851(0x16db, float:8.199E-42)
            r5 = 1170(0x492, float:1.64E-42)
            if (r3 != r5) goto L_0x01f4
            boolean r3 = r7.getSkipping()
            if (r3 != 0) goto L_0x01e0
            goto L_0x01f4
        L_0x01e0:
            r7.skipToGroupEnd()
            r8 = r77
            r9 = r78
            r11 = r80
            r12 = r81
            r13 = r82
            r26 = r7
            r10 = r14
            r14 = r83
            goto L_0x0353
        L_0x01f4:
            r7.startDefaults()
            r3 = r10 & 1
            if (r3 == 0) goto L_0x0221
            boolean r3 = r7.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0202
            goto L_0x0221
        L_0x0202:
            r7.skipToGroupEnd()
            r0 = r8 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x020b
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
        L_0x020b:
            r0 = r8 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0211
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0211:
            r19 = r77
            r20 = r78
            r22 = r80
            r23 = r81
            r24 = r82
            r25 = r83
        L_0x021d:
            r21 = r14
            goto L_0x02e1
        L_0x0221:
            if (r16 == 0) goto L_0x0225
            r3 = 0
            goto L_0x0227
        L_0x0225:
            r3 = r77
        L_0x0227:
            r5 = 0
            if (r4 == 0) goto L_0x022c
            r4 = r5
            goto L_0x022e
        L_0x022c:
            r4 = r78
        L_0x022e:
            if (r6 == 0) goto L_0x0231
            r14 = r5
        L_0x0231:
            if (r1 == 0) goto L_0x0235
            r1 = r5
            goto L_0x0237
        L_0x0235:
            r1 = r80
        L_0x0237:
            if (r0 == 0) goto L_0x023a
            goto L_0x023c
        L_0x023a:
            r5 = r81
        L_0x023c:
            r0 = r8 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0280
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r39 = 0
            r41 = 0
            r43 = 0
            r45 = 0
            r47 = 0
            r49 = 0
            r51 = 0
            r53 = 0
            r55 = 0
            r57 = 0
            r60 = 0
            r61 = 0
            int r0 = r2 >> 6
            r62 = r0 & 112(0x70, float:1.57E-43)
            r63 = 2097151(0x1fffff, float:2.938734E-39)
            r16 = r70
            r59 = r7
            androidx.compose.material.TextFieldColors r0 = r16.m1475textFieldColorsdx8h9Zs(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r60, r61, r62, r63)
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x0282
        L_0x0280:
            r0 = r82
        L_0x0282:
            r6 = r8 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x02d3
            if (r4 != 0) goto L_0x02a6
            r6 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 15
            r20 = 0
            r77 = r70
            r78 = r6
            r79 = r16
            r80 = r17
            r81 = r18
            r82 = r19
            r83 = r20
            androidx.compose.foundation.layout.PaddingValues r6 = m1466textFieldWithoutLabelPaddinga9UjIt4$default(r77, r78, r79, r80, r81, r82, r83)
            goto L_0x02c3
        L_0x02a6:
            r6 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 15
            r20 = 0
            r77 = r70
            r78 = r6
            r79 = r16
            r80 = r17
            r81 = r18
            r82 = r19
            r83 = r20
            androidx.compose.foundation.layout.PaddingValues r6 = m1465textFieldWithLabelPaddinga9UjIt4$default(r77, r78, r79, r80, r81, r82, r83)
        L_0x02c3:
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            r24 = r0
            r22 = r1
            r19 = r3
            r20 = r4
            r23 = r5
            r25 = r6
            goto L_0x021d
        L_0x02d3:
            r25 = r83
            r24 = r0
            r22 = r1
            r19 = r3
            r20 = r4
            r23 = r5
            goto L_0x021d
        L_0x02e1:
            r7.endDefaults()
            androidx.compose.material.TextFieldType r0 = androidx.compose.material.TextFieldType.Filled
            r14 = 0
            int r1 = r68 << 3
            r3 = r1 & 112(0x70, float:1.57E-43)
            r3 = r3 | 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r1 = r1 | r3
            int r3 = r68 >> 3
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r3
            int r3 = r68 >> 9
            r4 = r3 & r64
            r1 = r1 | r4
            r4 = r3 & r65
            r1 = r1 | r4
            r3 = r3 & r66
            r1 = r1 | r3
            int r3 = r2 << 21
            r3 = r3 & r67
            r1 = r1 | r3
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            int r4 = r68 << 15
            r3 = r3 & r4
            r1 = r1 | r3
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            int r4 = r68 << 21
            r3 = r3 & r4
            r16 = r1 | r3
            int r1 = r68 >> 18
            r1 = r1 & 14
            int r3 = r68 >> 12
            r3 = r3 & 112(0x70, float:1.57E-43)
            r1 = r1 | r3
            r3 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r3
            int r2 = r2 << 6
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r17 = r1 | r2
            r18 = 16384(0x4000, float:2.2959E-41)
            r1 = r71
            r2 = r72
            r3 = r75
            r4 = r20
            r5 = r21
            r6 = r22
            r26 = r7
            r7 = r23
            r8 = r74
            r9 = r73
            r10 = r19
            r11 = r76
            r12 = r25
            r13 = r24
            r15 = r26
            androidx.compose.material.TextFieldImplKt.CommonDecorationBox(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r8 = r19
            r9 = r20
            r10 = r21
            r11 = r22
            r12 = r23
            r14 = r25
        L_0x0353:
            androidx.compose.runtime.ScopeUpdateScope r15 = r26.endRestartGroup()
            if (r15 != 0) goto L_0x035a
            goto L_0x0380
        L_0x035a:
            androidx.compose.material.TextFieldDefaults$TextFieldDecorationBox$1 r18 = new androidx.compose.material.TextFieldDefaults$TextFieldDecorationBox$1
            r0 = r18
            r1 = r70
            r2 = r71
            r3 = r72
            r4 = r73
            r5 = r74
            r6 = r75
            r7 = r76
            r69 = r15
            r15 = r85
            r16 = r86
            r17 = r87
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r69
            r1.updateScope(r0)
        L_0x0380:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0397  */
    /* JADX WARNING: Removed duplicated region for block: B:206:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0143  */
    @androidx.compose.material.ExperimentalMaterialApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void OutlinedTextFieldDecorationBox(java.lang.String r68, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r69, boolean r70, boolean r71, androidx.compose.ui.text.input.VisualTransformation r72, androidx.compose.foundation.interaction.InteractionSource r73, boolean r74, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r75, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, androidx.compose.material.TextFieldColors r79, androidx.compose.foundation.layout.PaddingValues r80, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r81, androidx.compose.runtime.Composer r82, int r83, int r84, int r85) {
        /*
            r67 = this;
            r15 = r68
            r14 = r69
            r13 = r72
            r12 = r73
            r11 = r83
            r10 = r84
            r9 = r85
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "innerTextField"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "visualTransformation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1280721485(0xffffffffb3a9bdb3, float:-7.904182E-8)
            r1 = r82
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(OutlinedTextFieldDecorationBox)P(12,4,3,10,13,5,6,7,9,8,11,1,2)645@30340L25,651@30571L600:TextFieldDefaults.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r0 = r9 & 1
            if (r0 == 0) goto L_0x0039
            r0 = r11 | 6
            goto L_0x0049
        L_0x0039:
            r0 = r11 & 14
            if (r0 != 0) goto L_0x0048
            boolean r0 = r8.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0045
            r0 = 4
            goto L_0x0046
        L_0x0045:
            r0 = 2
        L_0x0046:
            r0 = r0 | r11
            goto L_0x0049
        L_0x0048:
            r0 = r11
        L_0x0049:
            r3 = r9 & 2
            if (r3 == 0) goto L_0x0050
            r0 = r0 | 48
            goto L_0x0060
        L_0x0050:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0060
            boolean r3 = r8.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x005d
            r3 = 32
            goto L_0x005f
        L_0x005d:
            r3 = 16
        L_0x005f:
            r0 = r0 | r3
        L_0x0060:
            r3 = r9 & 4
            if (r3 == 0) goto L_0x0067
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x007b
        L_0x0067:
            r3 = r11 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x007b
            r3 = r70
            boolean r16 = r8.changed((boolean) r3)
            if (r16 == 0) goto L_0x0076
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0078
        L_0x0076:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0078:
            r0 = r0 | r16
            goto L_0x007d
        L_0x007b:
            r3 = r70
        L_0x007d:
            r16 = r9 & 8
            r17 = 1024(0x400, float:1.435E-42)
            r18 = 2048(0x800, float:2.87E-42)
            if (r16 == 0) goto L_0x0088
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x009c
        L_0x0088:
            r1 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x009c
            r1 = r71
            boolean r16 = r8.changed((boolean) r1)
            if (r16 == 0) goto L_0x0097
            r16 = 2048(0x800, float:2.87E-42)
            goto L_0x0099
        L_0x0097:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x0099:
            r0 = r0 | r16
            goto L_0x009e
        L_0x009c:
            r1 = r71
        L_0x009e:
            r16 = r9 & 16
            r19 = 16384(0x4000, float:2.2959E-41)
            r20 = 8192(0x2000, float:1.14794E-41)
            r64 = 57344(0xe000, float:8.0356E-41)
            if (r16 == 0) goto L_0x00ac
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00bd
        L_0x00ac:
            r16 = r11 & r64
            if (r16 != 0) goto L_0x00bd
            boolean r16 = r8.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x00b9
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00bb
        L_0x00b9:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00bb:
            r0 = r0 | r16
        L_0x00bd:
            r16 = r9 & 32
            if (r16 == 0) goto L_0x00c6
            r16 = 196608(0x30000, float:2.75506E-40)
        L_0x00c3:
            r0 = r0 | r16
            goto L_0x00d8
        L_0x00c6:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r11 & r16
            if (r16 != 0) goto L_0x00d8
            boolean r16 = r8.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x00d5
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c3
        L_0x00d5:
            r16 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00c3
        L_0x00d8:
            r16 = r9 & 64
            if (r16 == 0) goto L_0x00e3
            r21 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r21
            r2 = r74
            goto L_0x00f8
        L_0x00e3:
            r21 = 3670016(0x380000, float:5.142788E-39)
            r21 = r11 & r21
            r2 = r74
            if (r21 != 0) goto L_0x00f8
            boolean r22 = r8.changed((boolean) r2)
            if (r22 == 0) goto L_0x00f4
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00f6
        L_0x00f4:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x00f6:
            r0 = r0 | r22
        L_0x00f8:
            r4 = r9 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0103
            r23 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r23
            r5 = r75
            goto L_0x0118
        L_0x0103:
            r23 = 29360128(0x1c00000, float:7.052966E-38)
            r23 = r11 & r23
            r5 = r75
            if (r23 != 0) goto L_0x0118
            boolean r24 = r8.changed((java.lang.Object) r5)
            if (r24 == 0) goto L_0x0114
            r24 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0116
        L_0x0114:
            r24 = 4194304(0x400000, float:5.877472E-39)
        L_0x0116:
            r0 = r0 | r24
        L_0x0118:
            r6 = r9 & 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L_0x0123
            r25 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r25
            r7 = r76
            goto L_0x0138
        L_0x0123:
            r25 = 234881024(0xe000000, float:1.5777218E-30)
            r25 = r11 & r25
            r7 = r76
            if (r25 != 0) goto L_0x0138
            boolean r26 = r8.changed((java.lang.Object) r7)
            if (r26 == 0) goto L_0x0134
            r26 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0136
        L_0x0134:
            r26 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0136:
            r0 = r0 | r26
        L_0x0138:
            r1 = r9 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0143
            r26 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r26
            r2 = r77
            goto L_0x0158
        L_0x0143:
            r26 = 1879048192(0x70000000, float:1.58456325E29)
            r26 = r11 & r26
            r2 = r77
            if (r26 != 0) goto L_0x0158
            boolean r26 = r8.changed((java.lang.Object) r2)
            if (r26 == 0) goto L_0x0154
            r26 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0156
        L_0x0154:
            r26 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0156:
            r0 = r0 | r26
        L_0x0158:
            r65 = r0
            r0 = r9 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0163
            r21 = r10 | 6
            r2 = r78
            goto L_0x0179
        L_0x0163:
            r26 = r10 & 14
            r2 = r78
            if (r26 != 0) goto L_0x0177
            boolean r26 = r8.changed((java.lang.Object) r2)
            if (r26 == 0) goto L_0x0172
            r21 = 4
            goto L_0x0174
        L_0x0172:
            r21 = 2
        L_0x0174:
            r21 = r10 | r21
            goto L_0x0179
        L_0x0177:
            r21 = r10
        L_0x0179:
            r26 = r10 & 112(0x70, float:1.57E-43)
            if (r26 != 0) goto L_0x0193
            r2 = r9 & 2048(0x800, float:2.87E-42)
            if (r2 != 0) goto L_0x018c
            r2 = r79
            boolean r26 = r8.changed((java.lang.Object) r2)
            if (r26 == 0) goto L_0x018e
            r22 = 32
            goto L_0x0190
        L_0x018c:
            r2 = r79
        L_0x018e:
            r22 = 16
        L_0x0190:
            r21 = r21 | r22
            goto L_0x0195
        L_0x0193:
            r2 = r79
        L_0x0195:
            r2 = r10 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x01af
            r2 = r9 & 4096(0x1000, float:5.74E-42)
            if (r2 != 0) goto L_0x01a8
            r2 = r80
            boolean r22 = r8.changed((java.lang.Object) r2)
            if (r22 == 0) goto L_0x01aa
            r24 = 256(0x100, float:3.59E-43)
            goto L_0x01ac
        L_0x01a8:
            r2 = r80
        L_0x01aa:
            r24 = 128(0x80, float:1.794E-43)
        L_0x01ac:
            r21 = r21 | r24
            goto L_0x01b1
        L_0x01af:
            r2 = r80
        L_0x01b1:
            r2 = r21
            r3 = r9 & 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x01ba
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x01cb
        L_0x01ba:
            r5 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x01cb
            r5 = r81
            boolean r21 = r8.changed((java.lang.Object) r5)
            if (r21 == 0) goto L_0x01c8
            r17 = 2048(0x800, float:2.87E-42)
        L_0x01c8:
            r2 = r2 | r17
            goto L_0x01cd
        L_0x01cb:
            r5 = r81
        L_0x01cd:
            r5 = r9 & 16384(0x4000, float:2.2959E-41)
            if (r5 == 0) goto L_0x01d4
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x01e6
        L_0x01d4:
            r5 = r10 & r64
            if (r5 != 0) goto L_0x01e6
            r5 = r67
            boolean r17 = r8.changed((java.lang.Object) r5)
            if (r17 == 0) goto L_0x01e1
            goto L_0x01e3
        L_0x01e1:
            r19 = 8192(0x2000, float:1.14794E-41)
        L_0x01e3:
            r2 = r2 | r19
            goto L_0x01e8
        L_0x01e6:
            r5 = r67
        L_0x01e8:
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r5 = r65 & r17
            r7 = 306783378(0x12492492, float:6.3469493E-28)
            if (r5 != r7) goto L_0x0218
            r5 = 46811(0xb6db, float:6.5596E-41)
            r5 = r5 & r2
            r7 = 9362(0x2492, float:1.3119E-41)
            if (r5 != r7) goto L_0x0218
            boolean r5 = r8.getSkipping()
            if (r5 != 0) goto L_0x0201
            goto L_0x0218
        L_0x0201:
            r8.skipToGroupEnd()
            r9 = r75
            r10 = r76
            r11 = r77
            r12 = r78
            r13 = r79
            r14 = r80
            r15 = r81
            r27 = r8
            r8 = r74
            goto L_0x0390
        L_0x0218:
            r8.startDefaults()
            r5 = r11 & 1
            if (r5 == 0) goto L_0x0247
            boolean r5 = r8.getDefaultsInvalid()
            if (r5 == 0) goto L_0x0226
            goto L_0x0247
        L_0x0226:
            r8.skipToGroupEnd()
            r0 = r9 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x022f
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
        L_0x022f:
            r0 = r9 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0235
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0235:
            r19 = r74
            r20 = r75
            r21 = r76
            r22 = r77
            r23 = r78
            r24 = r79
            r25 = r80
            r26 = r81
            goto L_0x0313
        L_0x0247:
            if (r16 == 0) goto L_0x024b
            r5 = 0
            goto L_0x024d
        L_0x024b:
            r5 = r74
        L_0x024d:
            r7 = 0
            if (r4 == 0) goto L_0x0252
            r4 = r7
            goto L_0x0254
        L_0x0252:
            r4 = r75
        L_0x0254:
            if (r6 == 0) goto L_0x0258
            r6 = r7
            goto L_0x025a
        L_0x0258:
            r6 = r76
        L_0x025a:
            if (r1 == 0) goto L_0x025e
            r1 = r7
            goto L_0x0260
        L_0x025e:
            r1 = r77
        L_0x0260:
            if (r0 == 0) goto L_0x0263
            goto L_0x0265
        L_0x0263:
            r7 = r78
        L_0x0265:
            r0 = r9 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x02a9
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r39 = 0
            r41 = 0
            r43 = 0
            r45 = 0
            r47 = 0
            r49 = 0
            r51 = 0
            r53 = 0
            r55 = 0
            r57 = 0
            r60 = 0
            r61 = 0
            int r0 = r2 >> 9
            r62 = r0 & 112(0x70, float:1.57E-43)
            r63 = 2097151(0x1fffff, float:2.938734E-39)
            r16 = r67
            r59 = r8
            androidx.compose.material.TextFieldColors r0 = r16.m1473outlinedTextFieldColorsdx8h9Zs(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r60, r61, r62, r63)
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x02ab
        L_0x02a9:
            r0 = r79
        L_0x02ab:
            r82 = r1
            r1 = r9 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x02d1
            r1 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 15
            r20 = 0
            r74 = r67
            r75 = r1
            r76 = r16
            r77 = r17
            r78 = r18
            r79 = r19
            r80 = r20
            androidx.compose.foundation.layout.PaddingValues r1 = m1464outlinedTextFieldPaddinga9UjIt4$default(r74, r75, r76, r77, r78, r79, r80)
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x02d3
        L_0x02d1:
            r1 = r80
        L_0x02d3:
            if (r3 == 0) goto L_0x02ff
            androidx.compose.material.TextFieldDefaults$OutlinedTextFieldDecorationBox$1 r3 = new androidx.compose.material.TextFieldDefaults$OutlinedTextFieldDecorationBox$1
            r74 = r3
            r75 = r70
            r76 = r5
            r77 = r73
            r78 = r0
            r79 = r65
            r80 = r2
            r74.<init>(r75, r76, r77, r78, r79, r80)
            r74 = r0
            r0 = 1
            r75 = r1
            r1 = 1261916269(0x4b37506d, float:1.2013677E7)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r8, r1, r0, r3)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r24 = r74
            r25 = r75
            r22 = r82
            r26 = r0
            goto L_0x030b
        L_0x02ff:
            r74 = r0
            r75 = r1
            r24 = r74
            r25 = r75
            r26 = r81
            r22 = r82
        L_0x030b:
            r20 = r4
            r19 = r5
            r21 = r6
            r23 = r7
        L_0x0313:
            r8.endDefaults()
            androidx.compose.material.TextFieldType r0 = androidx.compose.material.TextFieldType.Outlined
            int r1 = r65 << 3
            r3 = r1 & 112(0x70, float:1.57E-43)
            r3 = r3 | 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r1 = r1 | r3
            int r3 = r65 >> 3
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r3
            int r3 = r65 >> 9
            r4 = r3 & r64
            r1 = r1 | r4
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r3
            r1 = r1 | r4
            r4 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r4
            r1 = r1 | r3
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            int r4 = r2 << 21
            r3 = r3 & r4
            r1 = r1 | r3
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            int r4 = r65 << 15
            r3 = r3 & r4
            r1 = r1 | r3
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            int r4 = r65 << 21
            r3 = r3 & r4
            r16 = r1 | r3
            int r1 = r65 >> 18
            r1 = r1 & 14
            int r3 = r65 >> 12
            r3 = r3 & 112(0x70, float:1.57E-43)
            r1 = r1 | r3
            r3 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r3
            int r3 = r2 << 6
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r3
            int r2 = r2 << 3
            r2 = r2 & r64
            r17 = r1 | r2
            r18 = 0
            r1 = r68
            r2 = r69
            r3 = r72
            r4 = r20
            r5 = r21
            r6 = r22
            r7 = r23
            r27 = r8
            r8 = r71
            r9 = r70
            r10 = r19
            r11 = r73
            r12 = r25
            r13 = r24
            r14 = r26
            r15 = r27
            androidx.compose.material.TextFieldImplKt.CommonDecorationBox(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r8 = r19
            r9 = r20
            r10 = r21
            r11 = r22
            r12 = r23
            r14 = r25
            r15 = r26
        L_0x0390:
            androidx.compose.runtime.ScopeUpdateScope r7 = r27.endRestartGroup()
            if (r7 != 0) goto L_0x0397
            goto L_0x03bd
        L_0x0397:
            androidx.compose.material.TextFieldDefaults$OutlinedTextFieldDecorationBox$2 r19 = new androidx.compose.material.TextFieldDefaults$OutlinedTextFieldDecorationBox$2
            r0 = r19
            r1 = r67
            r2 = r68
            r3 = r69
            r4 = r70
            r5 = r71
            r6 = r72
            r66 = r7
            r7 = r73
            r16 = r83
            r17 = r84
            r18 = r85
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0 = r19
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r66
            r1.updateScope(r0)
        L_0x03bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @ExperimentalMaterialApi
    /* renamed from: indicatorLine-gv0btCI  reason: not valid java name */
    public final Modifier m1472indicatorLinegv0btCI(Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2) {
        Modifier modifier2 = modifier;
        Intrinsics.checkNotNullParameter(modifier, "$this$indicatorLine");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(textFieldColors, "colors");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TextFieldDefaults$indicatorLinegv0btCI$$inlined$debugInspectorInfo$1(z, z2, interactionSource, textFieldColors, f, f2) : InspectableValueKt.getNoInspectorInfo(), new TextFieldDefaults$indicatorLine$2(z, z2, interactionSource, textFieldColors, f, f2));
    }
}
