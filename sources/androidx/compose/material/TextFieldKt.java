package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001a\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020-2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010.\u001a\u0001\u0010/\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020\n0\u0017¢\u0006\u0002\b\u00182\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0019\u0010\u0019\u001a\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e¢\u0006\u0002\b\u00182\u0013\u00101\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u0010#\u001a\u00020\u00122\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0001¢\u0006\u0002\u00107\u001a]\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020%2\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bB\u0010C\u001aE\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020%2\u0006\u0010?\u001a\u00020@H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bJ\u0010K\u001a\u0014\u0010L\u001a\u00020\u0010*\u00020\u00102\u0006\u0010M\u001a\u00020NH\u0000\u001at\u0010O\u001a\u00020\n*\u00020P2\u0006\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010T2\b\u0010V\u001a\u0004\u0018\u00010T2\b\u0010W\u001a\u0004\u0018\u00010T2\b\u0010X\u001a\u0004\u0018\u00010T2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020%2\u0006\u0010Z\u001a\u00020%2\u0006\u00103\u001a\u0002042\u0006\u0010A\u001a\u000204H\u0002\u001aZ\u0010[\u001a\u00020\n*\u00020P2\u0006\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020%2\u0006\u0010\\\u001a\u00020T2\b\u0010V\u001a\u0004\u0018\u00010T2\b\u0010W\u001a\u0004\u0018\u00010T2\b\u0010X\u001a\u0004\u0018\u00010T2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010A\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0019\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0019\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006]"}, d2 = {"FirstBaselineOffset", "Landroidx/compose/ui/unit/Dp;", "getFirstBaselineOffset", "()F", "F", "TextFieldBottomPadding", "getTextFieldBottomPadding", "TextFieldTopPadding", "getTextFieldTopPadding", "TextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "calculateHeight", "textFieldHeight", "hasLabel", "labelBaseline", "leadingHeight", "trailingHeight", "placeholderHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-O3s9Psw", "(IZIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-VsPV1Ek", "(IIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "height", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextField.kt */
public final class TextFieldKt {
    private static final float FirstBaselineOffset = Dp.m4704constructorimpl((float) 20);
    private static final float TextFieldBottomPadding = Dp.m4704constructorimpl((float) 10);
    private static final float TextFieldTopPadding = Dp.m4704constructorimpl((float) 4);

    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01b5, code lost:
        if (r7.changed((java.lang.Object) r81) != false) goto L_0x01bc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x029d  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0612  */
    /* JADX WARNING: Removed duplicated region for block: B:293:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x013b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TextField(java.lang.String r68, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r69, androidx.compose.ui.Modifier r70, boolean r71, boolean r72, androidx.compose.ui.text.TextStyle r73, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r75, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, boolean r78, androidx.compose.ui.text.input.VisualTransformation r79, androidx.compose.foundation.text.KeyboardOptions r80, androidx.compose.foundation.text.KeyboardActions r81, boolean r82, int r83, androidx.compose.foundation.interaction.MutableInteractionSource r84, androidx.compose.ui.graphics.Shape r85, androidx.compose.material.TextFieldColors r86, androidx.compose.runtime.Composer r87, int r88, int r89, int r90) {
        /*
            r15 = r68
            r12 = r69
            r10 = r88
            r9 = r89
            r8 = r90
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1690895095(0xffffffff9b36fd09, float:-1.5136447E-22)
            r1 = r87
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(TextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)163@8397L7,174@8951L39,176@9033L6,177@9158L17,189@9576L24,199@10014L20,186@9478L1542:TextField.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            r0 = r8 & 1
            if (r0 == 0) goto L_0x002b
            r0 = r10 | 6
            goto L_0x003b
        L_0x002b:
            r0 = r10 & 14
            if (r0 != 0) goto L_0x003a
            boolean r0 = r7.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0037
            r0 = 4
            goto L_0x0038
        L_0x0037:
            r0 = 2
        L_0x0038:
            r0 = r0 | r10
            goto L_0x003b
        L_0x003a:
            r0 = r10
        L_0x003b:
            r3 = r8 & 2
            if (r3 == 0) goto L_0x0042
            r0 = r0 | 48
            goto L_0x0052
        L_0x0042:
            r3 = r10 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0052
            boolean r3 = r7.changed((java.lang.Object) r12)
            if (r3 == 0) goto L_0x004f
            r3 = 32
            goto L_0x0051
        L_0x004f:
            r3 = 16
        L_0x0051:
            r0 = r0 | r3
        L_0x0052:
            r3 = r8 & 4
            if (r3 == 0) goto L_0x0059
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006c
        L_0x0059:
            r13 = r10 & 896(0x380, float:1.256E-42)
            if (r13 != 0) goto L_0x006c
            r13 = r70
            boolean r14 = r7.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x0068
            r14 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r14 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r0 = r0 | r14
            goto L_0x006e
        L_0x006c:
            r13 = r70
        L_0x006e:
            r14 = r8 & 8
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0079
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x008d
        L_0x0079:
            r1 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x008d
            r1 = r71
            boolean r18 = r7.changed((boolean) r1)
            if (r18 == 0) goto L_0x0088
            r18 = 2048(0x800, float:2.87E-42)
            goto L_0x008a
        L_0x0088:
            r18 = 1024(0x400, float:1.435E-42)
        L_0x008a:
            r0 = r0 | r18
            goto L_0x008f
        L_0x008d:
            r1 = r71
        L_0x008f:
            r18 = r8 & 16
            r19 = 16384(0x4000, float:2.2959E-41)
            r64 = 57344(0xe000, float:8.0356E-41)
            r20 = 8192(0x2000, float:1.14794E-41)
            if (r18 == 0) goto L_0x009f
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r2 = r72
            goto L_0x00b2
        L_0x009f:
            r21 = r10 & r64
            r2 = r72
            if (r21 != 0) goto L_0x00b2
            boolean r22 = r7.changed((boolean) r2)
            if (r22 == 0) goto L_0x00ae
            r22 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00b0
        L_0x00ae:
            r22 = 8192(0x2000, float:1.14794E-41)
        L_0x00b0:
            r0 = r0 | r22
        L_0x00b2:
            r22 = 458752(0x70000, float:6.42848E-40)
            r22 = r10 & r22
            r23 = 131072(0x20000, float:1.83671E-40)
            if (r22 != 0) goto L_0x00ce
            r22 = r8 & 32
            r4 = r73
            if (r22 != 0) goto L_0x00c9
            boolean r24 = r7.changed((java.lang.Object) r4)
            if (r24 == 0) goto L_0x00c9
            r24 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cb
        L_0x00c9:
            r24 = 65536(0x10000, float:9.18355E-41)
        L_0x00cb:
            r0 = r0 | r24
            goto L_0x00d0
        L_0x00ce:
            r4 = r73
        L_0x00d0:
            r24 = r8 & 64
            r65 = 3670016(0x380000, float:5.142788E-39)
            if (r24 == 0) goto L_0x00dd
            r25 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r25
            r5 = r74
            goto L_0x00f0
        L_0x00dd:
            r25 = r10 & r65
            r5 = r74
            if (r25 != 0) goto L_0x00f0
            boolean r26 = r7.changed((java.lang.Object) r5)
            if (r26 == 0) goto L_0x00ec
            r26 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ee
        L_0x00ec:
            r26 = 524288(0x80000, float:7.34684E-40)
        L_0x00ee:
            r0 = r0 | r26
        L_0x00f0:
            r6 = r8 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x00fb
            r27 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r27
            r11 = r75
            goto L_0x0110
        L_0x00fb:
            r27 = 29360128(0x1c00000, float:7.052966E-38)
            r27 = r10 & r27
            r11 = r75
            if (r27 != 0) goto L_0x0110
            boolean r28 = r7.changed((java.lang.Object) r11)
            if (r28 == 0) goto L_0x010c
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010e
        L_0x010c:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x010e:
            r0 = r0 | r28
        L_0x0110:
            r1 = r8 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x011b
            r28 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r28
            r2 = r76
            goto L_0x0130
        L_0x011b:
            r28 = 234881024(0xe000000, float:1.5777218E-30)
            r28 = r10 & r28
            r2 = r76
            if (r28 != 0) goto L_0x0130
            boolean r28 = r7.changed((java.lang.Object) r2)
            if (r28 == 0) goto L_0x012c
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012e
        L_0x012c:
            r28 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012e:
            r0 = r0 | r28
        L_0x0130:
            r2 = r8 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x013b
            r28 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r28
            r4 = r77
            goto L_0x0150
        L_0x013b:
            r28 = 1879048192(0x70000000, float:1.58456325E29)
            r28 = r10 & r28
            r4 = r77
            if (r28 != 0) goto L_0x0150
            boolean r28 = r7.changed((java.lang.Object) r4)
            if (r28 == 0) goto L_0x014c
            r28 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x014e
        L_0x014c:
            r28 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x014e:
            r0 = r0 | r28
        L_0x0150:
            r4 = r8 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x0159
            r21 = r9 | 6
            r5 = r78
            goto L_0x016f
        L_0x0159:
            r28 = r9 & 14
            r5 = r78
            if (r28 != 0) goto L_0x016d
            boolean r28 = r7.changed((boolean) r5)
            if (r28 == 0) goto L_0x0168
            r21 = 4
            goto L_0x016a
        L_0x0168:
            r21 = 2
        L_0x016a:
            r21 = r9 | r21
            goto L_0x016f
        L_0x016d:
            r21 = r9
        L_0x016f:
            r5 = r8 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x0178
            r21 = r21 | 48
            r11 = r79
            goto L_0x018b
        L_0x0178:
            r28 = r9 & 112(0x70, float:1.57E-43)
            r11 = r79
            if (r28 != 0) goto L_0x018b
            boolean r28 = r7.changed((java.lang.Object) r11)
            if (r28 == 0) goto L_0x0187
            r25 = 32
            goto L_0x0189
        L_0x0187:
            r25 = 16
        L_0x0189:
            r21 = r21 | r25
        L_0x018b:
            r11 = r9 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x01a5
            r11 = r8 & 4096(0x1000, float:5.74E-42)
            if (r11 != 0) goto L_0x019e
            r11 = r80
            boolean r22 = r7.changed((java.lang.Object) r11)
            if (r22 == 0) goto L_0x01a0
            r26 = 256(0x100, float:3.59E-43)
            goto L_0x01a2
        L_0x019e:
            r11 = r80
        L_0x01a0:
            r26 = 128(0x80, float:1.794E-43)
        L_0x01a2:
            r21 = r21 | r26
            goto L_0x01a7
        L_0x01a5:
            r11 = r80
        L_0x01a7:
            r11 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x01bf
            r11 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r11 != 0) goto L_0x01b8
            r11 = r81
            boolean r22 = r7.changed((java.lang.Object) r11)
            if (r22 == 0) goto L_0x01ba
            goto L_0x01bc
        L_0x01b8:
            r11 = r81
        L_0x01ba:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x01bc:
            r21 = r21 | r16
            goto L_0x01c1
        L_0x01bf:
            r11 = r81
        L_0x01c1:
            r11 = r21
            r12 = r8 & 16384(0x4000, float:2.2959E-41)
            if (r12 == 0) goto L_0x01cc
            r11 = r11 | 24576(0x6000, float:3.4438E-41)
            r13 = r82
            goto L_0x01dd
        L_0x01cc:
            r16 = r9 & r64
            r13 = r82
            if (r16 != 0) goto L_0x01dd
            boolean r16 = r7.changed((boolean) r13)
            if (r16 == 0) goto L_0x01d9
            goto L_0x01db
        L_0x01d9:
            r19 = 8192(0x2000, float:1.14794E-41)
        L_0x01db:
            r11 = r11 | r19
        L_0x01dd:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r8 & r16
            if (r16 == 0) goto L_0x01eb
            r17 = 196608(0x30000, float:2.75506E-40)
            r11 = r11 | r17
            r13 = r83
            goto L_0x0200
        L_0x01eb:
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r9 & r17
            r13 = r83
            if (r17 != 0) goto L_0x0200
            boolean r17 = r7.changed((int) r13)
            if (r17 == 0) goto L_0x01fc
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01fe
        L_0x01fc:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x01fe:
            r11 = r11 | r17
        L_0x0200:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r8 & r17
            if (r17 == 0) goto L_0x020d
            r19 = 1572864(0x180000, float:2.204052E-39)
            r11 = r11 | r19
            r13 = r84
            goto L_0x0220
        L_0x020d:
            r19 = r9 & r65
            r13 = r84
            if (r19 != 0) goto L_0x0220
            boolean r19 = r7.changed((java.lang.Object) r13)
            if (r19 == 0) goto L_0x021c
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x021e
        L_0x021c:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x021e:
            r11 = r11 | r19
        L_0x0220:
            r19 = 29360128(0x1c00000, float:7.052966E-38)
            r19 = r9 & r19
            if (r19 != 0) goto L_0x023a
            r19 = r8 & r23
            r13 = r85
            if (r19 != 0) goto L_0x0235
            boolean r19 = r7.changed((java.lang.Object) r13)
            if (r19 == 0) goto L_0x0235
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0237
        L_0x0235:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x0237:
            r11 = r11 | r19
            goto L_0x023c
        L_0x023a:
            r13 = r85
        L_0x023c:
            r19 = 234881024(0xe000000, float:1.5777218E-30)
            r19 = r9 & r19
            if (r19 != 0) goto L_0x0258
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r8 & r19
            r9 = r86
            if (r19 != 0) goto L_0x0253
            boolean r19 = r7.changed((java.lang.Object) r9)
            if (r19 == 0) goto L_0x0253
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0255
        L_0x0253:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0255:
            r11 = r11 | r19
            goto L_0x025a
        L_0x0258:
            r9 = r86
        L_0x025a:
            r19 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r9 = r0 & r19
            r13 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r13) goto L_0x029d
            r9 = 191739611(0xb6db6db, float:4.5782105E-32)
            r9 = r9 & r11
            r13 = 38347922(0x2492492, float:1.4777643E-37)
            if (r9 != r13) goto L_0x029d
            boolean r9 = r7.getSkipping()
            if (r9 != 0) goto L_0x0274
            goto L_0x029d
        L_0x0274:
            r7.skipToGroupEnd()
            r3 = r70
            r4 = r71
            r5 = r72
            r6 = r73
            r8 = r75
            r9 = r76
            r10 = r77
            r11 = r78
            r12 = r79
            r13 = r80
            r14 = r81
            r15 = r82
            r16 = r83
            r17 = r84
            r18 = r85
            r19 = r86
            r33 = r7
            r7 = r74
            goto L_0x060b
        L_0x029d:
            r7.startDefaults()
            r9 = r10 & 1
            if (r9 == 0) goto L_0x02f9
            boolean r9 = r7.getDefaultsInvalid()
            if (r9 == 0) goto L_0x02ab
            goto L_0x02f9
        L_0x02ab:
            r7.skipToGroupEnd()
            r1 = r8 & 32
            if (r1 == 0) goto L_0x02b6
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r1
        L_0x02b6:
            r1 = r8 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x02bc
            r11 = r11 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x02bc:
            r1 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x02c2
            r11 = r11 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x02c2:
            r1 = r8 & r23
            if (r1 == 0) goto L_0x02ca
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r11 = r11 & r1
        L_0x02ca:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r8
            if (r1 == 0) goto L_0x02d3
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r11 = r11 & r1
        L_0x02d3:
            r12 = r70
            r9 = r71
            r19 = r72
            r6 = r73
            r20 = r74
            r21 = r75
            r22 = r76
            r23 = r77
            r4 = r78
            r24 = r79
            r25 = r80
            r26 = r81
            r27 = r82
            r66 = r83
            r28 = r84
            r3 = r85
            r1 = r86
            r17 = r11
            goto L_0x048d
        L_0x02f9:
            if (r3 == 0) goto L_0x0300
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x0302
        L_0x0300:
            r3 = r70
        L_0x0302:
            if (r14 == 0) goto L_0x0306
            r9 = 1
            goto L_0x0308
        L_0x0306:
            r9 = r71
        L_0x0308:
            if (r18 == 0) goto L_0x030c
            r14 = 0
            goto L_0x030e
        L_0x030c:
            r14 = r72
        L_0x030e:
            r18 = r8 & 32
            if (r18 == 0) goto L_0x0334
            androidx.compose.runtime.ProvidableCompositionLocal r18 = androidx.compose.material.TextKt.getLocalTextStyle()
            r13 = r18
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r70 = r3
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            r71 = r9
            java.lang.String r9 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r3, r9)
            java.lang.Object r3 = r7.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.ui.text.TextStyle r3 = (androidx.compose.ui.text.TextStyle) r3
            r9 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r9
            goto L_0x033a
        L_0x0334:
            r70 = r3
            r71 = r9
            r3 = r73
        L_0x033a:
            if (r24 == 0) goto L_0x033e
            r9 = 0
            goto L_0x0340
        L_0x033e:
            r9 = r74
        L_0x0340:
            if (r6 == 0) goto L_0x0344
            r6 = 0
            goto L_0x0346
        L_0x0344:
            r6 = r75
        L_0x0346:
            if (r1 == 0) goto L_0x034a
            r1 = 0
            goto L_0x034c
        L_0x034a:
            r1 = r76
        L_0x034c:
            if (r2 == 0) goto L_0x0350
            r2 = 0
            goto L_0x0352
        L_0x0350:
            r2 = r77
        L_0x0352:
            if (r4 == 0) goto L_0x0356
            r4 = 0
            goto L_0x0358
        L_0x0356:
            r4 = r78
        L_0x0358:
            if (r5 == 0) goto L_0x0361
            androidx.compose.ui.text.input.VisualTransformation$Companion r5 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r5 = r5.getNone()
            goto L_0x0363
        L_0x0361:
            r5 = r79
        L_0x0363:
            r13 = r8 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x0370
            androidx.compose.foundation.text.KeyboardOptions$Companion r13 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r13 = r13.getDefault()
            r11 = r11 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0372
        L_0x0370:
            r13 = r80
        L_0x0372:
            r72 = r0
            r0 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x03a2
            androidx.compose.foundation.text.KeyboardActions r0 = new androidx.compose.foundation.text.KeyboardActions
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r24 = 0
            r25 = 63
            r26 = 0
            r73 = r0
            r74 = r18
            r75 = r19
            r76 = r20
            r77 = r21
            r78 = r22
            r79 = r24
            r80 = r25
            r81 = r26
            r73.<init>(r74, r75, r76, r77, r78, r79, r80, r81)
            r11 = r11 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x03a4
        L_0x03a2:
            r0 = r81
        L_0x03a4:
            if (r12 == 0) goto L_0x03a8
            r12 = 0
            goto L_0x03aa
        L_0x03a8:
            r12 = r82
        L_0x03aa:
            if (r16 == 0) goto L_0x03b3
            r16 = 2147483647(0x7fffffff, float:NaN)
            r66 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x03b5
        L_0x03b3:
            r66 = r83
        L_0x03b5:
            r73 = r0
            if (r17 == 0) goto L_0x03df
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r7.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            java.lang.Object r0 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r74 = r1
            java.lang.Object r1 = r16.getEmpty()
            if (r0 != r1) goto L_0x03d9
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r7.updateRememberedValue(r0)
        L_0x03d9:
            r7.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x03e3
        L_0x03df:
            r74 = r1
            r0 = r84
        L_0x03e3:
            r1 = r8 & r23
            if (r1 == 0) goto L_0x041d
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r75 = r0
            r0 = 6
            androidx.compose.material.Shapes r0 = r1.getShapes(r7, r0)
            androidx.compose.foundation.shape.CornerBasedShape r0 = r0.getSmall()
            r1 = 0
            r16 = 0
            androidx.compose.foundation.shape.CornerSize r17 = androidx.compose.foundation.shape.CornerSizeKt.getZeroCornerSize()
            androidx.compose.foundation.shape.CornerSize r18 = androidx.compose.foundation.shape.CornerSizeKt.getZeroCornerSize()
            r19 = 3
            r20 = 0
            r76 = r0
            r77 = r1
            r78 = r16
            r79 = r17
            r80 = r18
            r81 = r19
            r82 = r20
            androidx.compose.foundation.shape.CornerBasedShape r0 = androidx.compose.foundation.shape.CornerBasedShape.copy$default(r76, r77, r78, r79, r80, r81, r82)
            androidx.compose.ui.graphics.Shape r0 = (androidx.compose.ui.graphics.Shape) r0
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r11
            r11 = r1
            goto L_0x0421
        L_0x041d:
            r75 = r0
            r0 = r85
        L_0x0421:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r8
            if (r1 == 0) goto L_0x046d
            androidx.compose.material.TextFieldDefaults r16 = androidx.compose.material.TextFieldDefaults.INSTANCE
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
            r62 = 48
            r63 = 2097151(0x1fffff, float:2.938734E-39)
            r59 = r7
            androidx.compose.material.TextFieldColors r1 = r16.m1475textFieldColorsdx8h9Zs(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r60, r61, r62, r63)
            r16 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r11 = r11 & r16
            r26 = r73
            r22 = r74
            r28 = r75
            goto L_0x0475
        L_0x046d:
            r26 = r73
            r22 = r74
            r28 = r75
            r1 = r86
        L_0x0475:
            r23 = r2
            r24 = r5
            r21 = r6
            r20 = r9
            r17 = r11
            r27 = r12
            r25 = r13
            r19 = r14
            r12 = r70
            r9 = r71
            r6 = r3
            r3 = r0
            r0 = r72
        L_0x048d:
            r7.endDefaults()
            r2 = -833027444(0xffffffffce59028c, float:-9.102057E8)
            r7.startReplaceableGroup(r2)
            java.lang.String r2 = "*181@9327L18"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r2)
            long r13 = r6.m4238getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r29 = r2.m1968getUnspecified0d7_KjU()
            int r2 = (r13 > r29 ? 1 : (r13 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x04ab
            r2 = 1
            goto L_0x04ac
        L_0x04ab:
            r2 = 0
        L_0x04ac:
            if (r2 == 0) goto L_0x04af
            goto L_0x04c6
        L_0x04af:
            int r2 = r0 >> 9
            r2 = r2 & 14
            int r5 = r17 >> 21
            r5 = r5 & 112(0x70, float:1.57E-43)
            r2 = r2 | r5
            androidx.compose.runtime.State r2 = r1.textColor(r9, r7, r2)
            java.lang.Object r2 = r2.getValue()
            androidx.compose.ui.graphics.Color r2 = (androidx.compose.ui.graphics.Color) r2
            long r13 = r2.m1942unboximpl()
        L_0x04c6:
            r30 = r13
            r7.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r2 = new androidx.compose.ui.text.TextStyle
            r29 = r2
            r32 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r52 = 0
            r53 = 262142(0x3fffe, float:3.67339E-40)
            r54 = 0
            r29.<init>((long) r30, (long) r32, (androidx.compose.ui.text.font.FontWeight) r34, (androidx.compose.ui.text.font.FontStyle) r35, (androidx.compose.ui.text.font.FontSynthesis) r36, (androidx.compose.ui.text.font.FontFamily) r37, (java.lang.String) r38, (long) r39, (androidx.compose.ui.text.style.BaselineShift) r41, (androidx.compose.ui.text.style.TextGeometricTransform) r42, (androidx.compose.ui.text.intl.LocaleList) r43, (long) r44, (androidx.compose.ui.text.style.TextDecoration) r46, (androidx.compose.ui.graphics.Shadow) r47, (androidx.compose.ui.text.style.TextAlign) r48, (androidx.compose.ui.text.style.TextDirection) r49, (long) r50, (androidx.compose.ui.text.style.TextIndent) r52, (int) r53, (kotlin.jvm.internal.DefaultConstructorMarker) r54)
            androidx.compose.ui.text.TextStyle r5 = r6.merge((androidx.compose.ui.text.TextStyle) r2)
            androidx.compose.material.TextFieldDefaults r2 = androidx.compose.material.TextFieldDefaults.INSTANCE
            int r11 = r0 >> 9
            r11 = r11 & 14
            int r13 = r17 >> 21
            r13 = r13 & 112(0x70, float:1.57E-43)
            r11 = r11 | r13
            androidx.compose.runtime.State r11 = r1.backgroundColor(r9, r7, r11)
            java.lang.Object r11 = r11.getValue()
            androidx.compose.ui.graphics.Color r11 = (androidx.compose.ui.graphics.Color) r11
            long r10 = r11.m1942unboximpl()
            androidx.compose.ui.Modifier r10 = androidx.compose.foundation.BackgroundKt.m176backgroundbw27NRU(r12, r10, r3)
            r11 = r28
            androidx.compose.foundation.interaction.InteractionSource r11 = (androidx.compose.foundation.interaction.InteractionSource) r11
            r14 = 0
            r16 = 0
            r18 = 48
            r29 = 0
            r70 = r2
            r71 = r10
            r72 = r9
            r73 = r4
            r74 = r11
            r75 = r1
            r76 = r14
            r77 = r16
            r78 = r18
            r79 = r29
            androidx.compose.ui.Modifier r2 = androidx.compose.material.TextFieldDefaults.m1463indicatorLinegv0btCI$default(r70, r71, r72, r73, r74, r75, r76, r77, r78, r79)
            androidx.compose.material.TextFieldDefaults r10 = androidx.compose.material.TextFieldDefaults.INSTANCE
            float r10 = r10.m1470getMinWidthD9Ej5fM()
            androidx.compose.material.TextFieldDefaults r11 = androidx.compose.material.TextFieldDefaults.INSTANCE
            float r11 = r11.m1469getMinHeightD9Ej5fM()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m566defaultMinSizeVpY3zN4(r2, r10, r11)
            androidx.compose.ui.graphics.SolidColor r10 = new androidx.compose.ui.graphics.SolidColor
            r11 = r17 & 14
            r11 = r11 | r13
            androidx.compose.runtime.State r11 = r1.cursorColor(r4, r7, r11)
            java.lang.Object r11 = r11.getValue()
            androidx.compose.ui.graphics.Color r11 = (androidx.compose.ui.graphics.Color) r11
            long r13 = r11.m1942unboximpl()
            r11 = 0
            r10.<init>(r13, r11)
            r11 = 0
            r13 = r10
            androidx.compose.ui.graphics.Brush r13 = (androidx.compose.ui.graphics.Brush) r13
            r10 = 1
            r14 = -1994363936(0xffffffff89206be0, float:-1.9310022E-33)
            androidx.compose.material.TextFieldKt$TextField$2 r11 = new androidx.compose.material.TextFieldKt$TextField$2
            r70 = r11
            r71 = r68
            r73 = r27
            r74 = r24
            r75 = r28
            r76 = r4
            r77 = r20
            r78 = r21
            r79 = r22
            r80 = r23
            r81 = r1
            r82 = r0
            r83 = r17
            r70.<init>(r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83)
            androidx.compose.runtime.internal.ComposableLambda r10 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r7, r14, r10, r11)
            r14 = r10
            kotlin.jvm.functions.Function3 r14 = (kotlin.jvm.functions.Function3) r14
            r10 = r0 & 14
            r11 = r0 & 112(0x70, float:1.57E-43)
            r10 = r10 | r11
            r11 = r0 & 7168(0x1c00, float:1.0045E-41)
            r10 = r10 | r11
            r0 = r0 & r64
            r0 = r0 | r10
            int r10 = r17 << 12
            r11 = r10 & r65
            r0 = r0 | r11
            int r11 = androidx.compose.foundation.text.KeyboardActions.$stable
            int r11 = r11 << 21
            r0 = r0 | r11
            r11 = 29360128(0x1c00000, float:7.052966E-38)
            r11 = r11 & r10
            r0 = r0 | r11
            r11 = 234881024(0xe000000, float:1.5777218E-30)
            r11 = r11 & r10
            r0 = r0 | r11
            r11 = 1879048192(0x70000000, float:1.58456325E29)
            r10 = r10 & r11
            r16 = r0 | r10
            int r0 = r17 >> 3
            r0 = r0 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            int r10 = r17 >> 12
            r10 = r10 & 896(0x380, float:1.256E-42)
            r17 = r0 | r10
            r18 = 2048(0x800, float:2.87E-42)
            r0 = r68
            r29 = r1
            r1 = r69
            r30 = r3
            r3 = r9
            r31 = r4
            r4 = r19
            r32 = r6
            r6 = r25
            r33 = r7
            r7 = r26
            r8 = r27
            r34 = r9
            r9 = r66
            r10 = r24
            r35 = r12
            r12 = r28
            r15 = r33
            r11 = 0
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((java.lang.String) r0, (kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (androidx.compose.foundation.text.KeyboardOptions) r6, (androidx.compose.foundation.text.KeyboardActions) r7, (boolean) r8, (int) r9, (androidx.compose.ui.text.input.VisualTransformation) r10, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r11, (androidx.compose.foundation.interaction.MutableInteractionSource) r12, (androidx.compose.ui.graphics.Brush) r13, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r14, (androidx.compose.runtime.Composer) r15, (int) r16, (int) r17, (int) r18)
            r5 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r12 = r24
            r13 = r25
            r14 = r26
            r15 = r27
            r17 = r28
            r19 = r29
            r18 = r30
            r11 = r31
            r6 = r32
            r4 = r34
            r3 = r35
            r16 = r66
        L_0x060b:
            androidx.compose.runtime.ScopeUpdateScope r2 = r33.endRestartGroup()
            if (r2 != 0) goto L_0x0612
            goto L_0x062e
        L_0x0612:
            androidx.compose.material.TextFieldKt$TextField$3 r23 = new androidx.compose.material.TextFieldKt$TextField$3
            r0 = r23
            r1 = r68
            r67 = r2
            r2 = r69
            r20 = r88
            r21 = r89
            r22 = r90
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = r23
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r67
            r1.updateScope(r0)
        L_0x062e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01b5, code lost:
        if (r7.changed((java.lang.Object) r81) != false) goto L_0x01bc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x029d  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x05eb  */
    /* JADX WARNING: Removed duplicated region for block: B:293:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x013b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TextField(androidx.compose.ui.text.input.TextFieldValue r68, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r69, androidx.compose.ui.Modifier r70, boolean r71, boolean r72, androidx.compose.ui.text.TextStyle r73, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r75, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, boolean r78, androidx.compose.ui.text.input.VisualTransformation r79, androidx.compose.foundation.text.KeyboardOptions r80, androidx.compose.foundation.text.KeyboardActions r81, boolean r82, int r83, androidx.compose.foundation.interaction.MutableInteractionSource r84, androidx.compose.ui.graphics.Shape r85, androidx.compose.material.TextFieldColors r86, androidx.compose.runtime.Composer r87, int r88, int r89, int r90) {
        /*
            r15 = r68
            r12 = r69
            r10 = r88
            r9 = r89
            r8 = r90
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1576622884(0xffffffffa206a4dc, float:-1.8247662E-18)
            r1 = r87
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(TextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)298@15761L7,309@16315L39,310@16393L14,311@16457L17,323@16875L24,333@17313L20,320@16777L1547:TextField.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            r0 = r8 & 1
            if (r0 == 0) goto L_0x002b
            r0 = r10 | 6
            goto L_0x003b
        L_0x002b:
            r0 = r10 & 14
            if (r0 != 0) goto L_0x003a
            boolean r0 = r7.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0037
            r0 = 4
            goto L_0x0038
        L_0x0037:
            r0 = 2
        L_0x0038:
            r0 = r0 | r10
            goto L_0x003b
        L_0x003a:
            r0 = r10
        L_0x003b:
            r3 = r8 & 2
            if (r3 == 0) goto L_0x0042
            r0 = r0 | 48
            goto L_0x0052
        L_0x0042:
            r3 = r10 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0052
            boolean r3 = r7.changed((java.lang.Object) r12)
            if (r3 == 0) goto L_0x004f
            r3 = 32
            goto L_0x0051
        L_0x004f:
            r3 = 16
        L_0x0051:
            r0 = r0 | r3
        L_0x0052:
            r3 = r8 & 4
            if (r3 == 0) goto L_0x0059
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006c
        L_0x0059:
            r13 = r10 & 896(0x380, float:1.256E-42)
            if (r13 != 0) goto L_0x006c
            r13 = r70
            boolean r14 = r7.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x0068
            r14 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r14 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r0 = r0 | r14
            goto L_0x006e
        L_0x006c:
            r13 = r70
        L_0x006e:
            r14 = r8 & 8
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0079
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x008d
        L_0x0079:
            r1 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x008d
            r1 = r71
            boolean r18 = r7.changed((boolean) r1)
            if (r18 == 0) goto L_0x0088
            r18 = 2048(0x800, float:2.87E-42)
            goto L_0x008a
        L_0x0088:
            r18 = 1024(0x400, float:1.435E-42)
        L_0x008a:
            r0 = r0 | r18
            goto L_0x008f
        L_0x008d:
            r1 = r71
        L_0x008f:
            r18 = r8 & 16
            r19 = 16384(0x4000, float:2.2959E-41)
            r64 = 57344(0xe000, float:8.0356E-41)
            r20 = 8192(0x2000, float:1.14794E-41)
            if (r18 == 0) goto L_0x009f
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r2 = r72
            goto L_0x00b2
        L_0x009f:
            r21 = r10 & r64
            r2 = r72
            if (r21 != 0) goto L_0x00b2
            boolean r22 = r7.changed((boolean) r2)
            if (r22 == 0) goto L_0x00ae
            r22 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00b0
        L_0x00ae:
            r22 = 8192(0x2000, float:1.14794E-41)
        L_0x00b0:
            r0 = r0 | r22
        L_0x00b2:
            r22 = 458752(0x70000, float:6.42848E-40)
            r22 = r10 & r22
            r23 = 131072(0x20000, float:1.83671E-40)
            if (r22 != 0) goto L_0x00ce
            r22 = r8 & 32
            r4 = r73
            if (r22 != 0) goto L_0x00c9
            boolean r24 = r7.changed((java.lang.Object) r4)
            if (r24 == 0) goto L_0x00c9
            r24 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cb
        L_0x00c9:
            r24 = 65536(0x10000, float:9.18355E-41)
        L_0x00cb:
            r0 = r0 | r24
            goto L_0x00d0
        L_0x00ce:
            r4 = r73
        L_0x00d0:
            r24 = r8 & 64
            r65 = 3670016(0x380000, float:5.142788E-39)
            if (r24 == 0) goto L_0x00dd
            r25 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r25
            r5 = r74
            goto L_0x00f0
        L_0x00dd:
            r25 = r10 & r65
            r5 = r74
            if (r25 != 0) goto L_0x00f0
            boolean r26 = r7.changed((java.lang.Object) r5)
            if (r26 == 0) goto L_0x00ec
            r26 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ee
        L_0x00ec:
            r26 = 524288(0x80000, float:7.34684E-40)
        L_0x00ee:
            r0 = r0 | r26
        L_0x00f0:
            r6 = r8 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x00fb
            r27 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r27
            r11 = r75
            goto L_0x0110
        L_0x00fb:
            r27 = 29360128(0x1c00000, float:7.052966E-38)
            r27 = r10 & r27
            r11 = r75
            if (r27 != 0) goto L_0x0110
            boolean r28 = r7.changed((java.lang.Object) r11)
            if (r28 == 0) goto L_0x010c
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010e
        L_0x010c:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x010e:
            r0 = r0 | r28
        L_0x0110:
            r1 = r8 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x011b
            r28 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r28
            r2 = r76
            goto L_0x0130
        L_0x011b:
            r28 = 234881024(0xe000000, float:1.5777218E-30)
            r28 = r10 & r28
            r2 = r76
            if (r28 != 0) goto L_0x0130
            boolean r28 = r7.changed((java.lang.Object) r2)
            if (r28 == 0) goto L_0x012c
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012e
        L_0x012c:
            r28 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012e:
            r0 = r0 | r28
        L_0x0130:
            r2 = r8 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x013b
            r28 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r28
            r4 = r77
            goto L_0x0150
        L_0x013b:
            r28 = 1879048192(0x70000000, float:1.58456325E29)
            r28 = r10 & r28
            r4 = r77
            if (r28 != 0) goto L_0x0150
            boolean r28 = r7.changed((java.lang.Object) r4)
            if (r28 == 0) goto L_0x014c
            r28 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x014e
        L_0x014c:
            r28 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x014e:
            r0 = r0 | r28
        L_0x0150:
            r4 = r8 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x0159
            r21 = r9 | 6
            r5 = r78
            goto L_0x016f
        L_0x0159:
            r28 = r9 & 14
            r5 = r78
            if (r28 != 0) goto L_0x016d
            boolean r28 = r7.changed((boolean) r5)
            if (r28 == 0) goto L_0x0168
            r21 = 4
            goto L_0x016a
        L_0x0168:
            r21 = 2
        L_0x016a:
            r21 = r9 | r21
            goto L_0x016f
        L_0x016d:
            r21 = r9
        L_0x016f:
            r5 = r8 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x0178
            r21 = r21 | 48
            r11 = r79
            goto L_0x018b
        L_0x0178:
            r28 = r9 & 112(0x70, float:1.57E-43)
            r11 = r79
            if (r28 != 0) goto L_0x018b
            boolean r28 = r7.changed((java.lang.Object) r11)
            if (r28 == 0) goto L_0x0187
            r25 = 32
            goto L_0x0189
        L_0x0187:
            r25 = 16
        L_0x0189:
            r21 = r21 | r25
        L_0x018b:
            r11 = r9 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x01a5
            r11 = r8 & 4096(0x1000, float:5.74E-42)
            if (r11 != 0) goto L_0x019e
            r11 = r80
            boolean r22 = r7.changed((java.lang.Object) r11)
            if (r22 == 0) goto L_0x01a0
            r26 = 256(0x100, float:3.59E-43)
            goto L_0x01a2
        L_0x019e:
            r11 = r80
        L_0x01a0:
            r26 = 128(0x80, float:1.794E-43)
        L_0x01a2:
            r21 = r21 | r26
            goto L_0x01a7
        L_0x01a5:
            r11 = r80
        L_0x01a7:
            r11 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x01bf
            r11 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r11 != 0) goto L_0x01b8
            r11 = r81
            boolean r22 = r7.changed((java.lang.Object) r11)
            if (r22 == 0) goto L_0x01ba
            goto L_0x01bc
        L_0x01b8:
            r11 = r81
        L_0x01ba:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x01bc:
            r21 = r21 | r16
            goto L_0x01c1
        L_0x01bf:
            r11 = r81
        L_0x01c1:
            r11 = r21
            r12 = r8 & 16384(0x4000, float:2.2959E-41)
            if (r12 == 0) goto L_0x01cc
            r11 = r11 | 24576(0x6000, float:3.4438E-41)
            r13 = r82
            goto L_0x01dd
        L_0x01cc:
            r16 = r9 & r64
            r13 = r82
            if (r16 != 0) goto L_0x01dd
            boolean r16 = r7.changed((boolean) r13)
            if (r16 == 0) goto L_0x01d9
            goto L_0x01db
        L_0x01d9:
            r19 = 8192(0x2000, float:1.14794E-41)
        L_0x01db:
            r11 = r11 | r19
        L_0x01dd:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r8 & r16
            if (r16 == 0) goto L_0x01eb
            r17 = 196608(0x30000, float:2.75506E-40)
            r11 = r11 | r17
            r13 = r83
            goto L_0x0200
        L_0x01eb:
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r9 & r17
            r13 = r83
            if (r17 != 0) goto L_0x0200
            boolean r17 = r7.changed((int) r13)
            if (r17 == 0) goto L_0x01fc
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01fe
        L_0x01fc:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x01fe:
            r11 = r11 | r17
        L_0x0200:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r8 & r17
            if (r17 == 0) goto L_0x020d
            r19 = 1572864(0x180000, float:2.204052E-39)
            r11 = r11 | r19
            r13 = r84
            goto L_0x0220
        L_0x020d:
            r19 = r9 & r65
            r13 = r84
            if (r19 != 0) goto L_0x0220
            boolean r19 = r7.changed((java.lang.Object) r13)
            if (r19 == 0) goto L_0x021c
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x021e
        L_0x021c:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x021e:
            r11 = r11 | r19
        L_0x0220:
            r19 = 29360128(0x1c00000, float:7.052966E-38)
            r19 = r9 & r19
            if (r19 != 0) goto L_0x023a
            r19 = r8 & r23
            r13 = r85
            if (r19 != 0) goto L_0x0235
            boolean r19 = r7.changed((java.lang.Object) r13)
            if (r19 == 0) goto L_0x0235
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0237
        L_0x0235:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x0237:
            r11 = r11 | r19
            goto L_0x023c
        L_0x023a:
            r13 = r85
        L_0x023c:
            r19 = 234881024(0xe000000, float:1.5777218E-30)
            r19 = r9 & r19
            if (r19 != 0) goto L_0x0258
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r8 & r19
            r9 = r86
            if (r19 != 0) goto L_0x0253
            boolean r19 = r7.changed((java.lang.Object) r9)
            if (r19 == 0) goto L_0x0253
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0255
        L_0x0253:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0255:
            r11 = r11 | r19
            goto L_0x025a
        L_0x0258:
            r9 = r86
        L_0x025a:
            r19 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r9 = r0 & r19
            r13 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r13) goto L_0x029d
            r9 = 191739611(0xb6db6db, float:4.5782105E-32)
            r9 = r9 & r11
            r13 = 38347922(0x2492492, float:1.4777643E-37)
            if (r9 != r13) goto L_0x029d
            boolean r9 = r7.getSkipping()
            if (r9 != 0) goto L_0x0274
            goto L_0x029d
        L_0x0274:
            r7.skipToGroupEnd()
            r3 = r70
            r4 = r71
            r5 = r72
            r6 = r73
            r8 = r75
            r9 = r76
            r10 = r77
            r11 = r78
            r12 = r79
            r13 = r80
            r14 = r81
            r15 = r82
            r16 = r83
            r17 = r84
            r18 = r85
            r19 = r86
            r33 = r7
            r7 = r74
            goto L_0x05e4
        L_0x029d:
            r7.startDefaults()
            r9 = r10 & 1
            if (r9 == 0) goto L_0x02f9
            boolean r9 = r7.getDefaultsInvalid()
            if (r9 == 0) goto L_0x02ab
            goto L_0x02f9
        L_0x02ab:
            r7.skipToGroupEnd()
            r1 = r8 & 32
            if (r1 == 0) goto L_0x02b6
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r1
        L_0x02b6:
            r1 = r8 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x02bc
            r11 = r11 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x02bc:
            r1 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x02c2
            r11 = r11 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x02c2:
            r1 = r8 & r23
            if (r1 == 0) goto L_0x02ca
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r11 = r11 & r1
        L_0x02ca:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r8
            if (r1 == 0) goto L_0x02d3
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r11 = r11 & r1
        L_0x02d3:
            r12 = r70
            r9 = r71
            r19 = r72
            r6 = r73
            r20 = r74
            r21 = r75
            r22 = r76
            r23 = r77
            r4 = r78
            r24 = r79
            r25 = r80
            r26 = r81
            r27 = r82
            r66 = r83
            r28 = r84
            r3 = r85
            r1 = r86
            r17 = r11
            goto L_0x0466
        L_0x02f9:
            if (r3 == 0) goto L_0x0300
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x0302
        L_0x0300:
            r3 = r70
        L_0x0302:
            if (r14 == 0) goto L_0x0306
            r9 = 1
            goto L_0x0308
        L_0x0306:
            r9 = r71
        L_0x0308:
            if (r18 == 0) goto L_0x030c
            r14 = 0
            goto L_0x030e
        L_0x030c:
            r14 = r72
        L_0x030e:
            r18 = r8 & 32
            if (r18 == 0) goto L_0x0334
            androidx.compose.runtime.ProvidableCompositionLocal r18 = androidx.compose.material.TextKt.getLocalTextStyle()
            r13 = r18
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r70 = r3
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            r71 = r9
            java.lang.String r9 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r3, r9)
            java.lang.Object r3 = r7.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.ui.text.TextStyle r3 = (androidx.compose.ui.text.TextStyle) r3
            r9 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r9
            goto L_0x033a
        L_0x0334:
            r70 = r3
            r71 = r9
            r3 = r73
        L_0x033a:
            if (r24 == 0) goto L_0x033e
            r9 = 0
            goto L_0x0340
        L_0x033e:
            r9 = r74
        L_0x0340:
            if (r6 == 0) goto L_0x0344
            r6 = 0
            goto L_0x0346
        L_0x0344:
            r6 = r75
        L_0x0346:
            if (r1 == 0) goto L_0x034a
            r1 = 0
            goto L_0x034c
        L_0x034a:
            r1 = r76
        L_0x034c:
            if (r2 == 0) goto L_0x0350
            r2 = 0
            goto L_0x0352
        L_0x0350:
            r2 = r77
        L_0x0352:
            if (r4 == 0) goto L_0x0356
            r4 = 0
            goto L_0x0358
        L_0x0356:
            r4 = r78
        L_0x0358:
            if (r5 == 0) goto L_0x0361
            androidx.compose.ui.text.input.VisualTransformation$Companion r5 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r5 = r5.getNone()
            goto L_0x0363
        L_0x0361:
            r5 = r79
        L_0x0363:
            r13 = r8 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x0370
            androidx.compose.foundation.text.KeyboardOptions$Companion r13 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r13 = r13.getDefault()
            r11 = r11 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0372
        L_0x0370:
            r13 = r80
        L_0x0372:
            r72 = r0
            r0 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x03a2
            androidx.compose.foundation.text.KeyboardActions r0 = new androidx.compose.foundation.text.KeyboardActions
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r24 = 0
            r25 = 63
            r26 = 0
            r73 = r0
            r74 = r18
            r75 = r19
            r76 = r20
            r77 = r21
            r78 = r22
            r79 = r24
            r80 = r25
            r81 = r26
            r73.<init>(r74, r75, r76, r77, r78, r79, r80, r81)
            r11 = r11 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x03a4
        L_0x03a2:
            r0 = r81
        L_0x03a4:
            if (r12 == 0) goto L_0x03a8
            r12 = 0
            goto L_0x03aa
        L_0x03a8:
            r12 = r82
        L_0x03aa:
            if (r16 == 0) goto L_0x03b3
            r16 = 2147483647(0x7fffffff, float:NaN)
            r66 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x03b5
        L_0x03b3:
            r66 = r83
        L_0x03b5:
            r73 = r0
            if (r17 == 0) goto L_0x03df
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r7.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            java.lang.Object r0 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r74 = r1
            java.lang.Object r1 = r16.getEmpty()
            if (r0 != r1) goto L_0x03d9
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r7.updateRememberedValue(r0)
        L_0x03d9:
            r7.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x03e3
        L_0x03df:
            r74 = r1
            r0 = r84
        L_0x03e3:
            r1 = r8 & r23
            if (r1 == 0) goto L_0x03f6
            androidx.compose.material.TextFieldDefaults r1 = androidx.compose.material.TextFieldDefaults.INSTANCE
            r75 = r0
            r0 = 6
            androidx.compose.ui.graphics.Shape r0 = r1.getTextFieldShape(r7, r0)
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r11
            r11 = r1
            goto L_0x03fa
        L_0x03f6:
            r75 = r0
            r0 = r85
        L_0x03fa:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r8
            if (r1 == 0) goto L_0x0446
            androidx.compose.material.TextFieldDefaults r16 = androidx.compose.material.TextFieldDefaults.INSTANCE
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
            r62 = 48
            r63 = 2097151(0x1fffff, float:2.938734E-39)
            r59 = r7
            androidx.compose.material.TextFieldColors r1 = r16.m1475textFieldColorsdx8h9Zs(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r60, r61, r62, r63)
            r16 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r11 = r11 & r16
            r26 = r73
            r22 = r74
            r28 = r75
            goto L_0x044e
        L_0x0446:
            r26 = r73
            r22 = r74
            r28 = r75
            r1 = r86
        L_0x044e:
            r23 = r2
            r24 = r5
            r21 = r6
            r20 = r9
            r17 = r11
            r27 = r12
            r25 = r13
            r19 = r14
            r12 = r70
            r9 = r71
            r6 = r3
            r3 = r0
            r0 = r72
        L_0x0466:
            r7.endDefaults()
            r2 = -833020145(0xffffffffce591f0f, float:-9.1067283E8)
            r7.startReplaceableGroup(r2)
            java.lang.String r2 = "*315@16626L18"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r2)
            long r13 = r6.m4238getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r29 = r2.m1968getUnspecified0d7_KjU()
            int r2 = (r13 > r29 ? 1 : (r13 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x0484
            r2 = 1
            goto L_0x0485
        L_0x0484:
            r2 = 0
        L_0x0485:
            if (r2 == 0) goto L_0x0488
            goto L_0x049f
        L_0x0488:
            int r2 = r0 >> 9
            r2 = r2 & 14
            int r5 = r17 >> 21
            r5 = r5 & 112(0x70, float:1.57E-43)
            r2 = r2 | r5
            androidx.compose.runtime.State r2 = r1.textColor(r9, r7, r2)
            java.lang.Object r2 = r2.getValue()
            androidx.compose.ui.graphics.Color r2 = (androidx.compose.ui.graphics.Color) r2
            long r13 = r2.m1942unboximpl()
        L_0x049f:
            r30 = r13
            r7.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r2 = new androidx.compose.ui.text.TextStyle
            r29 = r2
            r32 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r52 = 0
            r53 = 262142(0x3fffe, float:3.67339E-40)
            r54 = 0
            r29.<init>((long) r30, (long) r32, (androidx.compose.ui.text.font.FontWeight) r34, (androidx.compose.ui.text.font.FontStyle) r35, (androidx.compose.ui.text.font.FontSynthesis) r36, (androidx.compose.ui.text.font.FontFamily) r37, (java.lang.String) r38, (long) r39, (androidx.compose.ui.text.style.BaselineShift) r41, (androidx.compose.ui.text.style.TextGeometricTransform) r42, (androidx.compose.ui.text.intl.LocaleList) r43, (long) r44, (androidx.compose.ui.text.style.TextDecoration) r46, (androidx.compose.ui.graphics.Shadow) r47, (androidx.compose.ui.text.style.TextAlign) r48, (androidx.compose.ui.text.style.TextDirection) r49, (long) r50, (androidx.compose.ui.text.style.TextIndent) r52, (int) r53, (kotlin.jvm.internal.DefaultConstructorMarker) r54)
            androidx.compose.ui.text.TextStyle r5 = r6.merge((androidx.compose.ui.text.TextStyle) r2)
            androidx.compose.material.TextFieldDefaults r2 = androidx.compose.material.TextFieldDefaults.INSTANCE
            int r11 = r0 >> 9
            r11 = r11 & 14
            int r13 = r17 >> 21
            r13 = r13 & 112(0x70, float:1.57E-43)
            r11 = r11 | r13
            androidx.compose.runtime.State r11 = r1.backgroundColor(r9, r7, r11)
            java.lang.Object r11 = r11.getValue()
            androidx.compose.ui.graphics.Color r11 = (androidx.compose.ui.graphics.Color) r11
            long r10 = r11.m1942unboximpl()
            androidx.compose.ui.Modifier r10 = androidx.compose.foundation.BackgroundKt.m176backgroundbw27NRU(r12, r10, r3)
            r11 = r28
            androidx.compose.foundation.interaction.InteractionSource r11 = (androidx.compose.foundation.interaction.InteractionSource) r11
            r14 = 0
            r16 = 0
            r18 = 48
            r29 = 0
            r70 = r2
            r71 = r10
            r72 = r9
            r73 = r4
            r74 = r11
            r75 = r1
            r76 = r14
            r77 = r16
            r78 = r18
            r79 = r29
            androidx.compose.ui.Modifier r2 = androidx.compose.material.TextFieldDefaults.m1463indicatorLinegv0btCI$default(r70, r71, r72, r73, r74, r75, r76, r77, r78, r79)
            androidx.compose.material.TextFieldDefaults r10 = androidx.compose.material.TextFieldDefaults.INSTANCE
            float r10 = r10.m1470getMinWidthD9Ej5fM()
            androidx.compose.material.TextFieldDefaults r11 = androidx.compose.material.TextFieldDefaults.INSTANCE
            float r11 = r11.m1469getMinHeightD9Ej5fM()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m566defaultMinSizeVpY3zN4(r2, r10, r11)
            androidx.compose.ui.graphics.SolidColor r10 = new androidx.compose.ui.graphics.SolidColor
            r11 = r17 & 14
            r11 = r11 | r13
            androidx.compose.runtime.State r11 = r1.cursorColor(r4, r7, r11)
            java.lang.Object r11 = r11.getValue()
            androidx.compose.ui.graphics.Color r11 = (androidx.compose.ui.graphics.Color) r11
            long r13 = r11.m1942unboximpl()
            r11 = 0
            r10.<init>(r13, r11)
            r11 = 0
            r13 = r10
            androidx.compose.ui.graphics.Brush r13 = (androidx.compose.ui.graphics.Brush) r13
            r10 = 1
            r14 = -2078585677(0xffffffff841b4cb3, float:-1.8255381E-36)
            androidx.compose.material.TextFieldKt$TextField$5 r11 = new androidx.compose.material.TextFieldKt$TextField$5
            r70 = r11
            r71 = r68
            r73 = r27
            r74 = r24
            r75 = r28
            r76 = r4
            r77 = r20
            r78 = r21
            r79 = r22
            r80 = r23
            r81 = r1
            r82 = r0
            r83 = r17
            r70.<init>(r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83)
            androidx.compose.runtime.internal.ComposableLambda r10 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r7, r14, r10, r11)
            r14 = r10
            kotlin.jvm.functions.Function3 r14 = (kotlin.jvm.functions.Function3) r14
            r10 = r0 & 14
            r11 = r0 & 112(0x70, float:1.57E-43)
            r10 = r10 | r11
            r11 = r0 & 7168(0x1c00, float:1.0045E-41)
            r10 = r10 | r11
            r0 = r0 & r64
            r0 = r0 | r10
            int r10 = r17 << 12
            r11 = r10 & r65
            r0 = r0 | r11
            int r11 = androidx.compose.foundation.text.KeyboardActions.$stable
            int r11 = r11 << 21
            r0 = r0 | r11
            r11 = 29360128(0x1c00000, float:7.052966E-38)
            r11 = r11 & r10
            r0 = r0 | r11
            r11 = 234881024(0xe000000, float:1.5777218E-30)
            r11 = r11 & r10
            r0 = r0 | r11
            r11 = 1879048192(0x70000000, float:1.58456325E29)
            r10 = r10 & r11
            r16 = r0 | r10
            int r0 = r17 >> 3
            r0 = r0 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            int r10 = r17 >> 12
            r10 = r10 & 896(0x380, float:1.256E-42)
            r17 = r0 | r10
            r18 = 2048(0x800, float:2.87E-42)
            r0 = r68
            r29 = r1
            r1 = r69
            r30 = r3
            r3 = r9
            r31 = r4
            r4 = r19
            r32 = r6
            r6 = r25
            r33 = r7
            r7 = r26
            r8 = r27
            r34 = r9
            r9 = r66
            r10 = r24
            r35 = r12
            r12 = r28
            r15 = r33
            r11 = 0
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((androidx.compose.ui.text.input.TextFieldValue) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (androidx.compose.foundation.text.KeyboardOptions) r6, (androidx.compose.foundation.text.KeyboardActions) r7, (boolean) r8, (int) r9, (androidx.compose.ui.text.input.VisualTransformation) r10, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r11, (androidx.compose.foundation.interaction.MutableInteractionSource) r12, (androidx.compose.ui.graphics.Brush) r13, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r14, (androidx.compose.runtime.Composer) r15, (int) r16, (int) r17, (int) r18)
            r5 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r12 = r24
            r13 = r25
            r14 = r26
            r15 = r27
            r17 = r28
            r19 = r29
            r18 = r30
            r11 = r31
            r6 = r32
            r4 = r34
            r3 = r35
            r16 = r66
        L_0x05e4:
            androidx.compose.runtime.ScopeUpdateScope r2 = r33.endRestartGroup()
            if (r2 != 0) goto L_0x05eb
            goto L_0x0607
        L_0x05eb:
            androidx.compose.material.TextFieldKt$TextField$6 r23 = new androidx.compose.material.TextFieldKt$TextField$6
            r0 = r23
            r1 = r68
            r67 = r2
            r2 = r69
            r20 = r88
            r21 = r89
            r22 = r90
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = r23
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r67
            r1.updateScope(r0)
        L_0x0607:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void TextFieldLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z, float f, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        int i3;
        Modifier modifier2 = modifier;
        Function2<? super Composer, ? super Integer, Unit> function25 = function2;
        Function2<? super Composer, ? super Integer, Unit> function26 = function22;
        Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function32 = function3;
        Function2<? super Composer, ? super Integer, Unit> function27 = function23;
        Function2<? super Composer, ? super Integer, Unit> function28 = function24;
        boolean z2 = z;
        float f2 = f;
        PaddingValues paddingValues2 = paddingValues;
        int i4 = i;
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(function25, "textField");
        Intrinsics.checkNotNullParameter(paddingValues2, "paddingValues");
        Composer startRestartGroup = composer.startRestartGroup(-2112507061);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldLayout)P(3,7,1,5,2,8,6)376@18854L139,379@19041L7,380@19053L1853:TextField.kt#jmzs0o");
        if ((i4 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i4;
        } else {
            i2 = i4;
        }
        if ((i4 & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) function25) ? 32 : 16;
        }
        if ((i4 & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) function26) ? 256 : 128;
        }
        if ((i4 & 7168) == 0) {
            i2 |= startRestartGroup.changed((Object) function32) ? 2048 : 1024;
        }
        if ((57344 & i4) == 0) {
            i2 |= startRestartGroup.changed((Object) function27) ? 16384 : 8192;
        }
        if ((458752 & i4) == 0) {
            i2 |= startRestartGroup.changed((Object) function28) ? 131072 : 65536;
        }
        if ((3670016 & i4) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 1048576 : 524288;
        }
        if ((29360128 & i4) == 0) {
            i2 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if ((234881024 & i4) == 0) {
            i2 |= startRestartGroup.changed((Object) paddingValues2) ? 67108864 : 33554432;
        }
        if ((191739611 & i2) != 38347922 || !startRestartGroup.getSkipping()) {
            Boolean valueOf = Boolean.valueOf(z);
            Float valueOf2 = Float.valueOf(f);
            startRestartGroup.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) valueOf) | startRestartGroup.changed((Object) valueOf2) | startRestartGroup.changed((Object) paddingValues2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new TextFieldMeasurePolicy(z2, f2, paddingValues2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            TextFieldMeasurePolicy textFieldMeasurePolicy = (TextFieldMeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume;
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume3;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume4;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
            int i5 = ((((i2 << 3) & 112) << 9) & 7168) | 6;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r4 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r4, textFieldMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r4, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r4, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r4, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i5 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(642667778);
            ComposerKt.sourceInformation(startRestartGroup, "C422@20668L183:TextField.kt#jmzs0o");
            if (((i5 >> 9) & 14 & 11) != 2 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startReplaceableGroup(254816194);
                ComposerKt.sourceInformation(startRestartGroup, "384@19161L219");
                if (function27 != null) {
                    Modifier then = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.LeadingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center = Alignment.Companion.getCenter();
                    startRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Density density2 = (Density) consume5;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume6 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    LayoutDirection layoutDirection3 = (LayoutDirection) consume6;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume7 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume7;
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(then);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor2);
                    } else {
                        startRestartGroup.useNode();
                    }
                    startRestartGroup.disableReusing();
                    Composer r8 = Updater.m1543constructorimpl(startRestartGroup);
                    Updater.m1550setimpl(r8, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m1550setimpl(r8, density2, ComposeUiNode.Companion.getSetDensity());
                    Updater.m1550setimpl(r8, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
                    Updater.m1550setimpl(r8, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf2.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceableGroup(822730659);
                    ComposerKt.sourceInformation(startRestartGroup, "C388@19353L9:TextField.kt#jmzs0o");
                    function27.invoke(startRestartGroup, Integer.valueOf((i2 >> 12) & 14));
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                }
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(254816479);
                ComposerKt.sourceInformation(startRestartGroup, "392@19447L221");
                if (function28 != null) {
                    Modifier then2 = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.TrailingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center2 = Alignment.Companion.getCenter();
                    startRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, startRestartGroup, 6);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume8 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Density density3 = (Density) consume8;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume9 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    LayoutDirection layoutDirection4 = (LayoutDirection) consume9;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume10 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ViewConfiguration viewConfiguration3 = (ViewConfiguration) consume10;
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(then2);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor3);
                    } else {
                        startRestartGroup.useNode();
                    }
                    startRestartGroup.disableReusing();
                    Composer r10 = Updater.m1543constructorimpl(startRestartGroup);
                    Updater.m1550setimpl(r10, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m1550setimpl(r10, density3, ComposeUiNode.Companion.getSetDensity());
                    Updater.m1550setimpl(r10, layoutDirection4, ComposeUiNode.Companion.getSetLayoutDirection());
                    Updater.m1550setimpl(r10, viewConfiguration3, ComposeUiNode.Companion.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf3.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceableGroup(-1007916070);
                    ComposerKt.sourceInformation(startRestartGroup, "C396@19640L10:TextField.kt#jmzs0o");
                    function28.invoke(startRestartGroup, Integer.valueOf((i2 >> 15) & 14));
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                }
                startRestartGroup.endReplaceableGroup();
                PaddingValues paddingValues3 = paddingValues;
                float calculateStartPadding = PaddingKt.calculateStartPadding(paddingValues3, layoutDirection);
                float calculateEndPadding = PaddingKt.calculateEndPadding(paddingValues3, layoutDirection);
                Modifier modifier3 = Modifier.Companion;
                if (function27 != null) {
                    i3 = 0;
                    calculateStartPadding = Dp.m4704constructorimpl(RangesKt.coerceAtLeast(Dp.m4704constructorimpl(calculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m4704constructorimpl((float) 0)));
                } else {
                    i3 = 0;
                }
                float f3 = calculateStartPadding;
                if (function28 != null) {
                    calculateEndPadding = Dp.m4704constructorimpl(RangesKt.coerceAtLeast(Dp.m4704constructorimpl(calculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m4704constructorimpl((float) i3)));
                }
                Modifier r1 = PaddingKt.m514paddingqDBjuR0$default(modifier3, f3, 0.0f, calculateEndPadding, 0.0f, 10, (Object) null);
                startRestartGroup.startReplaceableGroup(254817490);
                ComposerKt.sourceInformation(startRestartGroup, "417@20461L59");
                Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function33 = function3;
                if (function33 != null) {
                    function33.invoke(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.PlaceholderId).then(r1), startRestartGroup, Integer.valueOf((i2 >> 6) & 112));
                }
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(254817619);
                ComposerKt.sourceInformation(startRestartGroup, "420@20584L57");
                Function2<? super Composer, ? super Integer, Unit> function29 = function22;
                if (function29 != null) {
                    Modifier then3 = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.LabelId).then(r1);
                    startRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume11 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Density density4 = (Density) consume11;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume12 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    LayoutDirection layoutDirection5 = (LayoutDirection) consume12;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume13 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ViewConfiguration viewConfiguration4 = (ViewConfiguration) consume13;
                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf4 = LayoutKt.materializerOf(then3);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor4);
                    } else {
                        startRestartGroup.useNode();
                    }
                    startRestartGroup.disableReusing();
                    Composer r7 = Updater.m1543constructorimpl(startRestartGroup);
                    Updater.m1550setimpl(r7, rememberBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m1550setimpl(r7, density4, ComposeUiNode.Companion.getSetDensity());
                    Updater.m1550setimpl(r7, layoutDirection5, ComposeUiNode.Companion.getSetLayoutDirection());
                    Updater.m1550setimpl(r7, viewConfiguration4, ComposeUiNode.Companion.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf4.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceableGroup(1319246300);
                    ComposerKt.sourceInformation(startRestartGroup, "C420@20632L7:TextField.kt#jmzs0o");
                    function29.invoke(startRestartGroup, Integer.valueOf((i2 >> 6) & 14));
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                }
                startRestartGroup.endReplaceableGroup();
                Modifier then4 = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.TextFieldId).then(r1);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, startRestartGroup, 48);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume14 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density5 = (Density) consume14;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume15 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LayoutDirection layoutDirection6 = (LayoutDirection) consume15;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume16 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ViewConfiguration viewConfiguration5 = (ViewConfiguration) consume16;
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf5 = LayoutKt.materializerOf(then4);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor5);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer r82 = Updater.m1543constructorimpl(startRestartGroup);
                Updater.m1550setimpl(r82, rememberBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m1550setimpl(r82, density5, ComposeUiNode.Companion.getSetDensity());
                Updater.m1550setimpl(r82, layoutDirection6, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m1550setimpl(r82, viewConfiguration5, ComposeUiNode.Companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf5.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(-2048931960);
                ComposerKt.sourceInformation(startRestartGroup, "C426@20826L11:TextField.kt#jmzs0o");
                function2.invoke(startRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.skipToGroupEnd();
                Function2<? super Composer, ? super Integer, Unit> function210 = function2;
                Function2<? super Composer, ? super Integer, Unit> function211 = function22;
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextFieldKt$TextFieldLayout$2(modifier, function2, function22, function3, function23, function24, z, f, paddingValues, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateWidth-VsPV1Ek  reason: not valid java name */
    public static final int m1488calculateWidthVsPV1Ek(int i, int i2, int i3, int i4, int i5, long j) {
        return Math.max(i + Math.max(i3, Math.max(i4, i5)) + i2, Constraints.m4626getMinWidthimpl(j));
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateHeight-O3s9Psw  reason: not valid java name */
    public static final int m1487calculateHeightO3s9Psw(int i, boolean z, int i2, int i3, int i4, int i5, long j, float f, PaddingValues paddingValues) {
        float f2 = TextFieldTopPadding * f;
        float r1 = paddingValues.m523calculateTopPaddingD9Ej5fM() * f;
        float r11 = paddingValues.m520calculateBottomPaddingD9Ej5fM() * f;
        int max = Math.max(i, i5);
        return Math.max(MathKt.roundToInt(z ? ((float) i2) + f2 + ((float) max) + r11 : r1 + ((float) max) + r11), Math.max(Math.max(i3, i4), Constraints.m4625getMinHeightimpl(j)));
    }

    /* access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, boolean z, int i3, int i4, float f, float f2) {
        int i5;
        int i6 = i2;
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, 0, Alignment.Companion.getCenterVertically().align(placeable4.getHeight(), i6), 0.0f, 4, (Object) null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, i - placeable5.getWidth(), Alignment.Companion.getCenterVertically().align(placeable5.getHeight(), i6), 0.0f, 4, (Object) null);
        }
        if (placeable2 != null) {
            if (z) {
                i5 = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i6);
            } else {
                i5 = MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * f2);
            }
            int roundToInt = i5 - MathKt.roundToInt(((float) (i5 - i3)) * f);
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable4), roundToInt, 0.0f, 4, (Object) null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, TextFieldImplKt.widthOrZero(placeable4), i4, 0.0f, 4, (Object) null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable4), i4, 0.0f, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, boolean z, float f, PaddingValues paddingValues) {
        int i3 = i2;
        int roundToInt = MathKt.roundToInt(paddingValues.m523calculateTopPaddingD9Ej5fM() * f);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, 0, Alignment.Companion.getCenterVertically().align(placeable3.getHeight(), i3), 0.0f, 4, (Object) null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i - placeable4.getWidth(), Alignment.Companion.getCenterVertically().align(placeable4.getHeight(), i3), 0.0f, 4, (Object) null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, TextFieldImplKt.widthOrZero(placeable3), z ? Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i3) : roundToInt, 0.0f, 4, (Object) null);
        if (placeable2 != null) {
            if (z) {
                roundToInt = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i3);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable3), roundToInt, 0.0f, 4, (Object) null);
        }
    }

    public static final Modifier drawIndicatorLine(Modifier modifier, BorderStroke borderStroke) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(borderStroke, "indicatorBorder");
        return DrawModifierKt.drawWithContent(modifier, new TextFieldKt$drawIndicatorLine$1(borderStroke.m190getWidthD9Ej5fM(), borderStroke));
    }

    public static final float getFirstBaselineOffset() {
        return FirstBaselineOffset;
    }

    public static final float getTextFieldBottomPadding() {
        return TextFieldBottomPadding;
    }

    public static final float getTextFieldTopPadding() {
        return TextFieldTopPadding;
    }
}
