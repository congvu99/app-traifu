package androidx.compose.material;

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
import androidx.compose.ui.geometry.Size;
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
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010+\u001a\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010,\u001aÄ\u0001\u0010-\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0019\u0010\u0018\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\r¢\u0006\u0002\b\u00172\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u00100\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0006\u0010\"\u001a\u00020\u00112\u0006\u00101\u001a\u0002022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\t0\r2\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0006\u00106\u001a\u000207H\u0001ø\u0001\u0000¢\u0006\u0002\u00108\u001aU\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u0002022\u0006\u00106\u001a\u000207H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bB\u0010C\u001aE\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020$2\u0006\u0010?\u001a\u00020@H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bJ\u0010K\u001a)\u0010L\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010M\u001a\u0002042\u0006\u00106\u001a\u000207H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bN\u0010O\u001a|\u0010P\u001a\u00020\t*\u00020Q2\u0006\u0010R\u001a\u00020$2\u0006\u0010S\u001a\u00020$2\b\u0010T\u001a\u0004\u0018\u00010U2\b\u0010V\u001a\u0004\u0018\u00010U2\u0006\u0010W\u001a\u00020U2\b\u0010X\u001a\u0004\u0018\u00010U2\b\u0010Y\u001a\u0004\u0018\u00010U2\u0006\u0010Z\u001a\u00020U2\u0006\u00101\u001a\u0002022\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010A\u001a\u0002022\u0006\u0010[\u001a\u00020\\2\u0006\u00106\u001a\u000207H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006]"}, d2 = {"BorderId", "", "OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "getOutlinedTextFieldTopPadding", "()F", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", "border", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-zUg2_y0", "(IIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "calculateWidth-VsPV1Ek", "(IIIIIJ)I", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "height", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "borderPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: OutlinedTextField.kt */
public final class OutlinedTextFieldKt {
    public static final String BorderId = "border";
    /* access modifiers changed from: private */
    public static final float OutlinedTextFieldInnerPadding = Dp.m4704constructorimpl((float) 4);
    private static final float OutlinedTextFieldTopPadding = Dp.m4704constructorimpl((float) 8);

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
    /* JADX WARNING: Removed duplicated region for block: B:284:0x047f  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x0481  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x0485  */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x04d5  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x04f1  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x05e7  */
    /* JADX WARNING: Removed duplicated region for block: B:297:? A[RETURN, SYNTHETIC] */
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
    public static final void OutlinedTextField(java.lang.String r68, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r69, androidx.compose.ui.Modifier r70, boolean r71, boolean r72, androidx.compose.ui.text.TextStyle r73, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r75, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, boolean r78, androidx.compose.ui.text.input.VisualTransformation r79, androidx.compose.foundation.text.KeyboardOptions r80, androidx.compose.foundation.text.KeyboardActions r81, boolean r82, int r83, androidx.compose.foundation.interaction.MutableInteractionSource r84, androidx.compose.ui.graphics.Shape r85, androidx.compose.material.TextFieldColors r86, androidx.compose.runtime.Composer r87, int r88, int r89, int r90) {
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
            r0 = -2099955827(0xffffffff82d5378d, float:-3.1329422E-37)
            r1 = r87
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)137@7575L7,148@8135L39,149@8209L6,150@8271L25,166@8821L24,175@9187L20,159@8599L1801:OutlinedTextField.kt#jmzs0o"
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
            goto L_0x05e0
        L_0x029d:
            r7.startDefaults()
            r9 = r10 & 1
            if (r9 == 0) goto L_0x02f8
            boolean r9 = r7.getDefaultsInvalid()
            if (r9 == 0) goto L_0x02ab
            goto L_0x02f8
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
            r19 = r70
            r12 = r71
            r20 = r72
            r9 = r73
            r21 = r74
            r22 = r75
            r23 = r76
            r24 = r77
            r6 = r78
            r25 = r79
            r26 = r80
            r27 = r81
            r28 = r82
            r66 = r83
            r29 = r84
            r5 = r85
            r4 = r86
        L_0x02f5:
            r1 = r11
            goto L_0x0463
        L_0x02f8:
            if (r3 == 0) goto L_0x02ff
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x0301
        L_0x02ff:
            r3 = r70
        L_0x0301:
            if (r14 == 0) goto L_0x0305
            r9 = 1
            goto L_0x0307
        L_0x0305:
            r9 = r71
        L_0x0307:
            if (r18 == 0) goto L_0x030b
            r14 = 0
            goto L_0x030d
        L_0x030b:
            r14 = r72
        L_0x030d:
            r18 = r8 & 32
            if (r18 == 0) goto L_0x0333
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
            goto L_0x0339
        L_0x0333:
            r70 = r3
            r71 = r9
            r3 = r73
        L_0x0339:
            if (r24 == 0) goto L_0x033d
            r9 = 0
            goto L_0x033f
        L_0x033d:
            r9 = r74
        L_0x033f:
            if (r6 == 0) goto L_0x0343
            r6 = 0
            goto L_0x0345
        L_0x0343:
            r6 = r75
        L_0x0345:
            if (r1 == 0) goto L_0x0349
            r1 = 0
            goto L_0x034b
        L_0x0349:
            r1 = r76
        L_0x034b:
            if (r2 == 0) goto L_0x034f
            r2 = 0
            goto L_0x0351
        L_0x034f:
            r2 = r77
        L_0x0351:
            if (r4 == 0) goto L_0x0355
            r4 = 0
            goto L_0x0357
        L_0x0355:
            r4 = r78
        L_0x0357:
            if (r5 == 0) goto L_0x0360
            androidx.compose.ui.text.input.VisualTransformation$Companion r5 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r5 = r5.getNone()
            goto L_0x0362
        L_0x0360:
            r5 = r79
        L_0x0362:
            r13 = r8 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x036f
            androidx.compose.foundation.text.KeyboardOptions$Companion r13 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r13 = r13.getDefault()
            r11 = r11 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0371
        L_0x036f:
            r13 = r80
        L_0x0371:
            r72 = r0
            r0 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0380
            androidx.compose.foundation.text.KeyboardActions$Companion r0 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r0 = r0.getDefault()
            r11 = r11 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0382
        L_0x0380:
            r0 = r81
        L_0x0382:
            if (r12 == 0) goto L_0x0386
            r12 = 0
            goto L_0x0388
        L_0x0386:
            r12 = r82
        L_0x0388:
            if (r16 == 0) goto L_0x0391
            r16 = 2147483647(0x7fffffff, float:NaN)
            r66 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0393
        L_0x0391:
            r66 = r83
        L_0x0393:
            r73 = r0
            if (r17 == 0) goto L_0x03bd
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r7.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            java.lang.Object r0 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r74 = r1
            java.lang.Object r1 = r16.getEmpty()
            if (r0 != r1) goto L_0x03b7
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r7.updateRememberedValue(r0)
        L_0x03b7:
            r7.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x03c1
        L_0x03bd:
            r74 = r1
            r0 = r84
        L_0x03c1:
            r1 = r8 & r23
            if (r1 == 0) goto L_0x03da
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r75 = r0
            r0 = 6
            androidx.compose.material.Shapes r0 = r1.getShapes(r7, r0)
            androidx.compose.foundation.shape.CornerBasedShape r0 = r0.getSmall()
            androidx.compose.ui.graphics.Shape r0 = (androidx.compose.ui.graphics.Shape) r0
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r11
            r11 = r1
            goto L_0x03de
        L_0x03da:
            r75 = r0
            r0 = r85
        L_0x03de:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r8
            if (r1 == 0) goto L_0x0443
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
            androidx.compose.material.TextFieldColors r1 = r16.m1473outlinedTextFieldColorsdx8h9Zs(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r60, r61, r62, r63)
            r16 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r11 = r11 & r16
            r19 = r70
            r27 = r73
            r23 = r74
            r29 = r75
            r24 = r2
            r25 = r5
            r22 = r6
            r21 = r9
            r28 = r12
            r26 = r13
            r20 = r14
            r12 = r71
            r5 = r0
            r9 = r3
            r6 = r4
            r0 = r72
            r4 = r1
            goto L_0x02f5
        L_0x0443:
            r19 = r70
            r27 = r73
            r23 = r74
            r29 = r75
            r24 = r2
            r25 = r5
            r22 = r6
            r21 = r9
            r1 = r11
            r28 = r12
            r26 = r13
            r20 = r14
            r12 = r71
            r5 = r0
            r9 = r3
            r6 = r4
            r0 = r72
            r4 = r86
        L_0x0463:
            r7.endDefaults()
            r2 = 1961394975(0x74e8831f, float:1.4737211E32)
            r7.startReplaceableGroup(r2)
            java.lang.String r2 = "*154@8448L18"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r2)
            long r2 = r9.m4238getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r11 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r11.m1968getUnspecified0d7_KjU()
            int r11 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r11 == 0) goto L_0x0481
            r13 = 1
            goto L_0x0482
        L_0x0481:
            r13 = 0
        L_0x0482:
            if (r13 == 0) goto L_0x0485
            goto L_0x049c
        L_0x0485:
            int r2 = r0 >> 9
            r2 = r2 & 14
            int r3 = r1 >> 21
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            androidx.compose.runtime.State r2 = r4.textColor(r12, r7, r2)
            java.lang.Object r2 = r2.getValue()
            androidx.compose.ui.graphics.Color r2 = (androidx.compose.ui.graphics.Color) r2
            long r2 = r2.m1942unboximpl()
        L_0x049c:
            r31 = r2
            r7.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r2 = new androidx.compose.ui.text.TextStyle
            r30 = r2
            r33 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r53 = 0
            r54 = 262142(0x3fffe, float:3.67339E-40)
            r55 = 0
            r30.<init>((long) r31, (long) r33, (androidx.compose.ui.text.font.FontWeight) r35, (androidx.compose.ui.text.font.FontStyle) r36, (androidx.compose.ui.text.font.FontSynthesis) r37, (androidx.compose.ui.text.font.FontFamily) r38, (java.lang.String) r39, (long) r40, (androidx.compose.ui.text.style.BaselineShift) r42, (androidx.compose.ui.text.style.TextGeometricTransform) r43, (androidx.compose.ui.text.intl.LocaleList) r44, (long) r45, (androidx.compose.ui.text.style.TextDecoration) r47, (androidx.compose.ui.graphics.Shadow) r48, (androidx.compose.ui.text.style.TextAlign) r49, (androidx.compose.ui.text.style.TextDirection) r50, (long) r51, (androidx.compose.ui.text.style.TextIndent) r53, (int) r54, (kotlin.jvm.internal.DefaultConstructorMarker) r55)
            androidx.compose.ui.text.TextStyle r30 = r9.merge((androidx.compose.ui.text.TextStyle) r2)
            if (r21 == 0) goto L_0x04f1
            r2 = 0
            float r3 = OutlinedTextFieldTopPadding
            r11 = 0
            r13 = 0
            r14 = 13
            r16 = 0
            r76 = r19
            r77 = r2
            r78 = r3
            r79 = r11
            r80 = r13
            r81 = r14
            r82 = r16
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r76, r77, r78, r79, r80, r81, r82)
            goto L_0x04f3
        L_0x04f1:
            r2 = r19
        L_0x04f3:
            int r3 = r0 >> 9
            r3 = r3 & 14
            int r11 = r1 >> 21
            r11 = r11 & 112(0x70, float:1.57E-43)
            r3 = r3 | r11
            androidx.compose.runtime.State r3 = r4.backgroundColor(r12, r7, r3)
            java.lang.Object r3 = r3.getValue()
            androidx.compose.ui.graphics.Color r3 = (androidx.compose.ui.graphics.Color) r3
            long r13 = r3.m1942unboximpl()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.BackgroundKt.m176backgroundbw27NRU(r2, r13, r5)
            androidx.compose.material.TextFieldDefaults r3 = androidx.compose.material.TextFieldDefaults.INSTANCE
            float r3 = r3.m1470getMinWidthD9Ej5fM()
            androidx.compose.material.TextFieldDefaults r13 = androidx.compose.material.TextFieldDefaults.INSTANCE
            float r13 = r13.m1469getMinHeightD9Ej5fM()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m566defaultMinSizeVpY3zN4(r2, r3, r13)
            androidx.compose.ui.graphics.SolidColor r3 = new androidx.compose.ui.graphics.SolidColor
            r13 = r1 & 14
            r11 = r11 | r13
            androidx.compose.runtime.State r11 = r4.cursorColor(r6, r7, r11)
            java.lang.Object r11 = r11.getValue()
            androidx.compose.ui.graphics.Color r11 = (androidx.compose.ui.graphics.Color) r11
            long r13 = r11.m1942unboximpl()
            r11 = 0
            r3.<init>(r13, r11)
            r11 = 0
            r13 = r3
            androidx.compose.ui.graphics.Brush r13 = (androidx.compose.ui.graphics.Brush) r13
            r3 = 1
            r14 = 986454116(0x3acc1864, float:0.0015571234)
            androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$2 r11 = new androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$2
            r70 = r11
            r71 = r68
            r72 = r12
            r73 = r28
            r74 = r25
            r75 = r29
            r76 = r6
            r77 = r21
            r78 = r22
            r79 = r23
            r80 = r24
            r81 = r4
            r82 = r0
            r83 = r1
            r84 = r5
            r70.<init>(r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84)
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r7, r14, r3, r11)
            r14 = r3
            kotlin.jvm.functions.Function3 r14 = (kotlin.jvm.functions.Function3) r14
            r3 = r0 & 14
            r11 = r0 & 112(0x70, float:1.57E-43)
            r3 = r3 | r11
            r11 = r0 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r11
            r0 = r0 & r64
            r0 = r0 | r3
            int r3 = r1 << 12
            r11 = r3 & r65
            r0 = r0 | r11
            int r11 = androidx.compose.foundation.text.KeyboardActions.$stable
            int r11 = r11 << 21
            r0 = r0 | r11
            r11 = 29360128(0x1c00000, float:7.052966E-38)
            r11 = r11 & r3
            r0 = r0 | r11
            r11 = 234881024(0xe000000, float:1.5777218E-30)
            r11 = r11 & r3
            r0 = r0 | r11
            r11 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r11
            r16 = r0 | r3
            int r0 = r1 >> 3
            r0 = r0 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            int r1 = r1 >> 12
            r1 = r1 & 896(0x380, float:1.256E-42)
            r17 = r0 | r1
            r18 = 2048(0x800, float:2.87E-42)
            r0 = r68
            r1 = r69
            r3 = r12
            r31 = r4
            r4 = r20
            r32 = r5
            r5 = r30
            r30 = r6
            r6 = r26
            r33 = r7
            r7 = r27
            r8 = r28
            r34 = r9
            r9 = r66
            r10 = r25
            r35 = r12
            r12 = r29
            r15 = r33
            r11 = 0
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((java.lang.String) r0, (kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (androidx.compose.foundation.text.KeyboardOptions) r6, (androidx.compose.foundation.text.KeyboardActions) r7, (boolean) r8, (int) r9, (androidx.compose.ui.text.input.VisualTransformation) r10, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r11, (androidx.compose.foundation.interaction.MutableInteractionSource) r12, (androidx.compose.ui.graphics.Brush) r13, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r14, (androidx.compose.runtime.Composer) r15, (int) r16, (int) r17, (int) r18)
            r3 = r19
            r5 = r20
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            r12 = r25
            r13 = r26
            r14 = r27
            r15 = r28
            r17 = r29
            r11 = r30
            r19 = r31
            r18 = r32
            r6 = r34
            r4 = r35
            r16 = r66
        L_0x05e0:
            androidx.compose.runtime.ScopeUpdateScope r2 = r33.endRestartGroup()
            if (r2 != 0) goto L_0x05e7
            goto L_0x0603
        L_0x05e7:
            androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3 r23 = new androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3
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
        L_0x0603:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
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
    /* JADX WARNING: Removed duplicated region for block: B:284:0x049a  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x049c  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x04a0  */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x04f0  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x050c  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0602  */
    /* JADX WARNING: Removed duplicated region for block: B:297:? A[RETURN, SYNTHETIC] */
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
    public static final void OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue r68, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r69, androidx.compose.ui.Modifier r70, boolean r71, boolean r72, androidx.compose.ui.text.TextStyle r73, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r75, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, boolean r78, androidx.compose.ui.text.input.VisualTransformation r79, androidx.compose.foundation.text.KeyboardOptions r80, androidx.compose.foundation.text.KeyboardActions r81, boolean r82, int r83, androidx.compose.foundation.interaction.MutableInteractionSource r84, androidx.compose.ui.graphics.Shape r85, androidx.compose.material.TextFieldColors r86, androidx.compose.runtime.Composer r87, int r88, int r89, int r90) {
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
            r0 = -288998816(0xffffffffeec63a60, float:-3.0674301E28)
            r1 = r87
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)281@15178L7,292@15732L39,293@15810L22,294@15882L25,310@16432L24,319@16798L20,303@16210L1806:OutlinedTextField.kt#jmzs0o"
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
            goto L_0x05fb
        L_0x029d:
            r7.startDefaults()
            r9 = r10 & 1
            if (r9 == 0) goto L_0x02f8
            boolean r9 = r7.getDefaultsInvalid()
            if (r9 == 0) goto L_0x02ab
            goto L_0x02f8
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
            r19 = r70
            r12 = r71
            r20 = r72
            r9 = r73
            r21 = r74
            r22 = r75
            r23 = r76
            r24 = r77
            r6 = r78
            r25 = r79
            r26 = r80
            r27 = r81
            r28 = r82
            r66 = r83
            r29 = r84
            r5 = r85
            r4 = r86
        L_0x02f5:
            r1 = r11
            goto L_0x047e
        L_0x02f8:
            if (r3 == 0) goto L_0x02ff
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x0301
        L_0x02ff:
            r3 = r70
        L_0x0301:
            if (r14 == 0) goto L_0x0305
            r9 = 1
            goto L_0x0307
        L_0x0305:
            r9 = r71
        L_0x0307:
            if (r18 == 0) goto L_0x030b
            r14 = 0
            goto L_0x030d
        L_0x030b:
            r14 = r72
        L_0x030d:
            r18 = r8 & 32
            if (r18 == 0) goto L_0x0333
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
            goto L_0x0339
        L_0x0333:
            r70 = r3
            r71 = r9
            r3 = r73
        L_0x0339:
            if (r24 == 0) goto L_0x033d
            r9 = 0
            goto L_0x033f
        L_0x033d:
            r9 = r74
        L_0x033f:
            if (r6 == 0) goto L_0x0343
            r6 = 0
            goto L_0x0345
        L_0x0343:
            r6 = r75
        L_0x0345:
            if (r1 == 0) goto L_0x0349
            r1 = 0
            goto L_0x034b
        L_0x0349:
            r1 = r76
        L_0x034b:
            if (r2 == 0) goto L_0x034f
            r2 = 0
            goto L_0x0351
        L_0x034f:
            r2 = r77
        L_0x0351:
            if (r4 == 0) goto L_0x0355
            r4 = 0
            goto L_0x0357
        L_0x0355:
            r4 = r78
        L_0x0357:
            if (r5 == 0) goto L_0x0360
            androidx.compose.ui.text.input.VisualTransformation$Companion r5 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r5 = r5.getNone()
            goto L_0x0362
        L_0x0360:
            r5 = r79
        L_0x0362:
            r13 = r8 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x036f
            androidx.compose.foundation.text.KeyboardOptions$Companion r13 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r13 = r13.getDefault()
            r11 = r11 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0371
        L_0x036f:
            r13 = r80
        L_0x0371:
            r72 = r0
            r0 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x03a1
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
            goto L_0x03a3
        L_0x03a1:
            r0 = r81
        L_0x03a3:
            if (r12 == 0) goto L_0x03a7
            r12 = 0
            goto L_0x03a9
        L_0x03a7:
            r12 = r82
        L_0x03a9:
            if (r16 == 0) goto L_0x03b2
            r16 = 2147483647(0x7fffffff, float:NaN)
            r66 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x03b4
        L_0x03b2:
            r66 = r83
        L_0x03b4:
            r73 = r0
            if (r17 == 0) goto L_0x03de
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r7.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            java.lang.Object r0 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r74 = r1
            java.lang.Object r1 = r16.getEmpty()
            if (r0 != r1) goto L_0x03d8
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r7.updateRememberedValue(r0)
        L_0x03d8:
            r7.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x03e2
        L_0x03de:
            r74 = r1
            r0 = r84
        L_0x03e2:
            r1 = r8 & r23
            if (r1 == 0) goto L_0x03f5
            androidx.compose.material.TextFieldDefaults r1 = androidx.compose.material.TextFieldDefaults.INSTANCE
            r75 = r0
            r0 = 6
            androidx.compose.ui.graphics.Shape r0 = r1.getOutlinedTextFieldShape(r7, r0)
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r11
            r11 = r1
            goto L_0x03f9
        L_0x03f5:
            r75 = r0
            r0 = r85
        L_0x03f9:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r8
            if (r1 == 0) goto L_0x045e
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
            androidx.compose.material.TextFieldColors r1 = r16.m1473outlinedTextFieldColorsdx8h9Zs(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r60, r61, r62, r63)
            r16 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r11 = r11 & r16
            r19 = r70
            r27 = r73
            r23 = r74
            r29 = r75
            r24 = r2
            r25 = r5
            r22 = r6
            r21 = r9
            r28 = r12
            r26 = r13
            r20 = r14
            r12 = r71
            r5 = r0
            r9 = r3
            r6 = r4
            r0 = r72
            r4 = r1
            goto L_0x02f5
        L_0x045e:
            r19 = r70
            r27 = r73
            r23 = r74
            r29 = r75
            r24 = r2
            r25 = r5
            r22 = r6
            r21 = r9
            r1 = r11
            r28 = r12
            r26 = r13
            r20 = r14
            r12 = r71
            r5 = r0
            r9 = r3
            r6 = r4
            r0 = r72
            r4 = r86
        L_0x047e:
            r7.endDefaults()
            r2 = 1961402586(0x74e8a0da, float:1.4744572E32)
            r7.startReplaceableGroup(r2)
            java.lang.String r2 = "*298@16059L18"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r2)
            long r2 = r9.m4238getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r11 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r11.m1968getUnspecified0d7_KjU()
            int r11 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r11 == 0) goto L_0x049c
            r13 = 1
            goto L_0x049d
        L_0x049c:
            r13 = 0
        L_0x049d:
            if (r13 == 0) goto L_0x04a0
            goto L_0x04b7
        L_0x04a0:
            int r2 = r0 >> 9
            r2 = r2 & 14
            int r3 = r1 >> 21
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            androidx.compose.runtime.State r2 = r4.textColor(r12, r7, r2)
            java.lang.Object r2 = r2.getValue()
            androidx.compose.ui.graphics.Color r2 = (androidx.compose.ui.graphics.Color) r2
            long r2 = r2.m1942unboximpl()
        L_0x04b7:
            r31 = r2
            r7.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r2 = new androidx.compose.ui.text.TextStyle
            r30 = r2
            r33 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r53 = 0
            r54 = 262142(0x3fffe, float:3.67339E-40)
            r55 = 0
            r30.<init>((long) r31, (long) r33, (androidx.compose.ui.text.font.FontWeight) r35, (androidx.compose.ui.text.font.FontStyle) r36, (androidx.compose.ui.text.font.FontSynthesis) r37, (androidx.compose.ui.text.font.FontFamily) r38, (java.lang.String) r39, (long) r40, (androidx.compose.ui.text.style.BaselineShift) r42, (androidx.compose.ui.text.style.TextGeometricTransform) r43, (androidx.compose.ui.text.intl.LocaleList) r44, (long) r45, (androidx.compose.ui.text.style.TextDecoration) r47, (androidx.compose.ui.graphics.Shadow) r48, (androidx.compose.ui.text.style.TextAlign) r49, (androidx.compose.ui.text.style.TextDirection) r50, (long) r51, (androidx.compose.ui.text.style.TextIndent) r53, (int) r54, (kotlin.jvm.internal.DefaultConstructorMarker) r55)
            androidx.compose.ui.text.TextStyle r30 = r9.merge((androidx.compose.ui.text.TextStyle) r2)
            if (r21 == 0) goto L_0x050c
            r2 = 0
            float r3 = OutlinedTextFieldTopPadding
            r11 = 0
            r13 = 0
            r14 = 13
            r16 = 0
            r76 = r19
            r77 = r2
            r78 = r3
            r79 = r11
            r80 = r13
            r81 = r14
            r82 = r16
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r76, r77, r78, r79, r80, r81, r82)
            goto L_0x050e
        L_0x050c:
            r2 = r19
        L_0x050e:
            int r3 = r0 >> 9
            r3 = r3 & 14
            int r11 = r1 >> 21
            r11 = r11 & 112(0x70, float:1.57E-43)
            r3 = r3 | r11
            androidx.compose.runtime.State r3 = r4.backgroundColor(r12, r7, r3)
            java.lang.Object r3 = r3.getValue()
            androidx.compose.ui.graphics.Color r3 = (androidx.compose.ui.graphics.Color) r3
            long r13 = r3.m1942unboximpl()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.BackgroundKt.m176backgroundbw27NRU(r2, r13, r5)
            androidx.compose.material.TextFieldDefaults r3 = androidx.compose.material.TextFieldDefaults.INSTANCE
            float r3 = r3.m1470getMinWidthD9Ej5fM()
            androidx.compose.material.TextFieldDefaults r13 = androidx.compose.material.TextFieldDefaults.INSTANCE
            float r13 = r13.m1469getMinHeightD9Ej5fM()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m566defaultMinSizeVpY3zN4(r2, r3, r13)
            androidx.compose.ui.graphics.SolidColor r3 = new androidx.compose.ui.graphics.SolidColor
            r13 = r1 & 14
            r11 = r11 | r13
            androidx.compose.runtime.State r11 = r4.cursorColor(r6, r7, r11)
            java.lang.Object r11 = r11.getValue()
            androidx.compose.ui.graphics.Color r11 = (androidx.compose.ui.graphics.Color) r11
            long r13 = r11.m1942unboximpl()
            r11 = 0
            r3.<init>(r13, r11)
            r11 = 0
            r13 = r3
            androidx.compose.ui.graphics.Brush r13 = (androidx.compose.ui.graphics.Brush) r13
            r3 = 1
            r14 = -1219079113(0xffffffffb7565437, float:-1.2775002E-5)
            androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$5 r11 = new androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$5
            r70 = r11
            r71 = r68
            r72 = r12
            r73 = r28
            r74 = r25
            r75 = r29
            r76 = r6
            r77 = r21
            r78 = r22
            r79 = r23
            r80 = r24
            r81 = r4
            r82 = r0
            r83 = r1
            r84 = r5
            r70.<init>(r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84)
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r7, r14, r3, r11)
            r14 = r3
            kotlin.jvm.functions.Function3 r14 = (kotlin.jvm.functions.Function3) r14
            r3 = r0 & 14
            r11 = r0 & 112(0x70, float:1.57E-43)
            r3 = r3 | r11
            r11 = r0 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r11
            r0 = r0 & r64
            r0 = r0 | r3
            int r3 = r1 << 12
            r11 = r3 & r65
            r0 = r0 | r11
            int r11 = androidx.compose.foundation.text.KeyboardActions.$stable
            int r11 = r11 << 21
            r0 = r0 | r11
            r11 = 29360128(0x1c00000, float:7.052966E-38)
            r11 = r11 & r3
            r0 = r0 | r11
            r11 = 234881024(0xe000000, float:1.5777218E-30)
            r11 = r11 & r3
            r0 = r0 | r11
            r11 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r11
            r16 = r0 | r3
            int r0 = r1 >> 3
            r0 = r0 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            int r1 = r1 >> 12
            r1 = r1 & 896(0x380, float:1.256E-42)
            r17 = r0 | r1
            r18 = 2048(0x800, float:2.87E-42)
            r0 = r68
            r1 = r69
            r3 = r12
            r31 = r4
            r4 = r20
            r32 = r5
            r5 = r30
            r30 = r6
            r6 = r26
            r33 = r7
            r7 = r27
            r8 = r28
            r34 = r9
            r9 = r66
            r10 = r25
            r35 = r12
            r12 = r29
            r15 = r33
            r11 = 0
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((androidx.compose.ui.text.input.TextFieldValue) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (androidx.compose.foundation.text.KeyboardOptions) r6, (androidx.compose.foundation.text.KeyboardActions) r7, (boolean) r8, (int) r9, (androidx.compose.ui.text.input.VisualTransformation) r10, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r11, (androidx.compose.foundation.interaction.MutableInteractionSource) r12, (androidx.compose.ui.graphics.Brush) r13, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r14, (androidx.compose.runtime.Composer) r15, (int) r16, (int) r17, (int) r18)
            r3 = r19
            r5 = r20
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            r12 = r25
            r13 = r26
            r14 = r27
            r15 = r28
            r17 = r29
            r11 = r30
            r19 = r31
            r18 = r32
            r6 = r34
            r4 = r35
            r16 = r66
        L_0x05fb:
            androidx.compose.runtime.ScopeUpdateScope r2 = r33.endRestartGroup()
            if (r2 != 0) goto L_0x0602
            goto L_0x061e
        L_0x0602:
            androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$6 r23 = new androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$6
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
        L_0x061e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void OutlinedTextFieldLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z, float f, Function1<? super Size, Unit> function1, Function2<? super Composer, ? super Integer, Unit> function25, PaddingValues paddingValues, Composer composer, int i, int i2) {
        int i3;
        int i4;
        int i5;
        Modifier modifier2 = modifier;
        Function2<? super Composer, ? super Integer, Unit> function26 = function2;
        Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function32 = function3;
        Function2<? super Composer, ? super Integer, Unit> function27 = function22;
        Function2<? super Composer, ? super Integer, Unit> function28 = function23;
        Function2<? super Composer, ? super Integer, Unit> function29 = function24;
        boolean z2 = z;
        float f2 = f;
        Function1<? super Size, Unit> function12 = function1;
        Function2<? super Composer, ? super Integer, Unit> function210 = function25;
        PaddingValues paddingValues2 = paddingValues;
        int i6 = i;
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(function26, "textField");
        Intrinsics.checkNotNullParameter(function12, "onLabelMeasured");
        Intrinsics.checkNotNullParameter(function210, BorderId);
        Intrinsics.checkNotNullParameter(paddingValues2, "paddingValues");
        Composer startRestartGroup = composer.startRestartGroup(-2049536174);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedTextFieldLayout)P(4,9,7,2,3,10,8!1,5)374@18737L239,382@19024L7,383@19036L2308:OutlinedTextField.kt#jmzs0o");
        if ((i6 & 14) == 0) {
            i3 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i6;
        } else {
            i3 = i6;
        }
        if ((i6 & 112) == 0) {
            i3 |= startRestartGroup.changed((Object) function26) ? 32 : 16;
        }
        if ((i6 & 896) == 0) {
            i3 |= startRestartGroup.changed((Object) function32) ? 256 : 128;
        }
        if ((i6 & 7168) == 0) {
            i3 |= startRestartGroup.changed((Object) function27) ? 2048 : 1024;
        }
        if ((57344 & i6) == 0) {
            i3 |= startRestartGroup.changed((Object) function28) ? 16384 : 8192;
        }
        if ((458752 & i6) == 0) {
            i3 |= startRestartGroup.changed((Object) function29) ? 131072 : 65536;
        }
        if ((3670016 & i6) == 0) {
            i3 |= startRestartGroup.changed(z2) ? 1048576 : 524288;
        }
        if ((29360128 & i6) == 0) {
            i3 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if ((234881024 & i6) == 0) {
            i3 |= startRestartGroup.changed((Object) function12) ? 67108864 : 33554432;
        }
        if ((1879048192 & i6) == 0) {
            i3 |= startRestartGroup.changed((Object) function210) ? 536870912 : 268435456;
        }
        if ((i2 & 14) == 0) {
            i4 = i2 | (startRestartGroup.changed((Object) paddingValues2) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i3 & 1533916891) == 306783378 && (i4 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            Function2<? super Composer, ? super Integer, Unit> function211 = function26;
            Function2<? super Composer, ? super Integer, Unit> function212 = function27;
        } else {
            Object[] objArr = {function12, Boolean.valueOf(z), Float.valueOf(f), paddingValues2};
            startRestartGroup.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            int i7 = 0;
            boolean z3 = false;
            for (int i8 = 4; i7 < i8; i8 = 4) {
                z3 |= startRestartGroup.changed(objArr[i7]);
                i7++;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new OutlinedTextFieldMeasurePolicy(function12, z2, f2, paddingValues2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = (OutlinedTextFieldMeasurePolicy) rememberedValue;
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
            int i9 = ((((i3 << 3) & 112) << 9) & 7168) | 6;
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
            Composer r9 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r9, outlinedTextFieldMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r9, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r9, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r9, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i9 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(118153609);
            ComposerKt.sourceInformation(startRestartGroup, "C391@19540L8,430@20988L182,438@21221L54:OutlinedTextField.kt#jmzs0o");
            if (((i9 >> 9) & 14 & 11) != 2 || !startRestartGroup.getSkipping()) {
                function210.invoke(startRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                startRestartGroup.startReplaceableGroup(1169914108);
                ComposerKt.sourceInformation(startRestartGroup, "394@19601L219");
                if (function28 != null) {
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
                    Composer r10 = Updater.m1543constructorimpl(startRestartGroup);
                    Updater.m1550setimpl(r10, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m1550setimpl(r10, density2, ComposeUiNode.Companion.getSetDensity());
                    Updater.m1550setimpl(r10, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
                    Updater.m1550setimpl(r10, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf2.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceableGroup(1691709354);
                    ComposerKt.sourceInformation(startRestartGroup, "C398@19793L9:OutlinedTextField.kt#jmzs0o");
                    function28.invoke(startRestartGroup, Integer.valueOf((i3 >> 12) & 14));
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                }
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(1169914393);
                ComposerKt.sourceInformation(startRestartGroup, "402@19887L221");
                if (function29 != null) {
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
                    Composer r11 = Updater.m1543constructorimpl(startRestartGroup);
                    Updater.m1550setimpl(r11, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m1550setimpl(r11, density3, ComposeUiNode.Companion.getSetDensity());
                    Updater.m1550setimpl(r11, layoutDirection4, ComposeUiNode.Companion.getSetLayoutDirection());
                    Updater.m1550setimpl(r11, viewConfiguration3, ComposeUiNode.Companion.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf3.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceableGroup(-1351586719);
                    ComposerKt.sourceInformation(startRestartGroup, "C406@20080L10:OutlinedTextField.kt#jmzs0o");
                    function29.invoke(startRestartGroup, Integer.valueOf((i3 >> 15) & 14));
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
                if (function28 != null) {
                    i5 = 0;
                    calculateStartPadding = Dp.m4704constructorimpl(RangesKt.coerceAtLeast(Dp.m4704constructorimpl(calculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m4704constructorimpl((float) 0)));
                } else {
                    i5 = 0;
                }
                float f3 = calculateStartPadding;
                if (function29 != null) {
                    calculateEndPadding = Dp.m4704constructorimpl(RangesKt.coerceAtLeast(Dp.m4704constructorimpl(calculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m4704constructorimpl((float) i5)));
                }
                Modifier r1 = PaddingKt.m514paddingqDBjuR0$default(modifier3, f3, 0.0f, calculateEndPadding, 0.0f, 10, (Object) null);
                startRestartGroup.startReplaceableGroup(1169915404);
                ComposerKt.sourceInformation(startRestartGroup, "427@20901L59");
                Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function33 = function3;
                if (function33 != null) {
                    function33.invoke(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.PlaceholderId).then(r1), startRestartGroup, Integer.valueOf((i3 >> 3) & 112));
                }
                startRestartGroup.endReplaceableGroup();
                Modifier then3 = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.TextFieldId).then(r1);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, startRestartGroup, 48);
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
                Composer r3 = Updater.m1543constructorimpl(startRestartGroup);
                Updater.m1550setimpl(r3, rememberBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m1550setimpl(r3, density4, ComposeUiNode.Companion.getSetDensity());
                Updater.m1550setimpl(r3, layoutDirection5, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m1550setimpl(r3, viewConfiguration4, ComposeUiNode.Companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf4.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(-1205597937);
                ComposerKt.sourceInformation(startRestartGroup, "C434@21145L11:OutlinedTextField.kt#jmzs0o");
                function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                Function2<? super Composer, ? super Integer, Unit> function213 = function22;
                if (function213 != null) {
                    Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.LabelId);
                    startRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
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
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf5 = LayoutKt.materializerOf(layoutId);
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
                    Composer r102 = Updater.m1543constructorimpl(startRestartGroup);
                    Updater.m1550setimpl(r102, rememberBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m1550setimpl(r102, density5, ComposeUiNode.Companion.getSetDensity());
                    Updater.m1550setimpl(r102, layoutDirection6, ComposeUiNode.Companion.getSetLayoutDirection());
                    Updater.m1550setimpl(r102, viewConfiguration5, ComposeUiNode.Companion.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf5.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceableGroup(-55131805);
                    ComposerKt.sourceInformation(startRestartGroup, "C438@21266L7:OutlinedTextField.kt#jmzs0o");
                    function213.invoke(startRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                Function2<? super Composer, ? super Integer, Unit> function214 = function2;
                Function2<? super Composer, ? super Integer, Unit> function215 = function22;
                PaddingValues paddingValues4 = paddingValues;
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new OutlinedTextFieldKt$OutlinedTextFieldLayout$2(modifier, function2, function3, function22, function23, function24, z, f, function1, function25, paddingValues, i, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateWidth-VsPV1Ek  reason: not valid java name */
    public static final int m1354calculateWidthVsPV1Ek(int i, int i2, int i3, int i4, int i5, long j) {
        return Math.max(i + Math.max(i3, Math.max(i4, i5)) + i2, Constraints.m4626getMinWidthimpl(j));
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateHeight-zUg2_y0  reason: not valid java name */
    public static final int m1353calculateHeightzUg2_y0(int i, int i2, int i3, int i4, int i5, long j, float f, PaddingValues paddingValues) {
        return Math.max(Constraints.m4625getMinHeightimpl(j), Math.max(i, Math.max(i2, MathKt.roundToInt(((float) Math.max(i3, i5)) + (paddingValues.m520calculateBottomPaddingD9Ej5fM() * f) + Math.max(paddingValues.m523calculateTopPaddingD9Ej5fM() * f, ((float) i4) / 2.0f)))));
    }

    /* access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, float f, boolean z, float f2, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        float f3;
        int i3 = i;
        int roundToInt = MathKt.roundToInt(paddingValues.m523calculateTopPaddingD9Ej5fM() * f2);
        int roundToInt2 = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * f2);
        float horizontalIconPadding = TextFieldImplKt.getHorizontalIconPadding() * f2;
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i3), 0.0f, 4, (Object) null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2 - placeable2.getWidth(), Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i3), 0.0f, 4, (Object) null);
        }
        if (placeable4 != null) {
            float f4 = ((float) 1) - f;
            float align = (((float) (z ? Alignment.Companion.getCenterVertically().align(placeable4.getHeight(), i3) : roundToInt)) * f4) - (((float) (placeable4.getHeight() / 2)) * f);
            if (placeable == null) {
                f3 = 0.0f;
            } else {
                f3 = f4 * (((float) TextFieldImplKt.widthOrZero(placeable)) - horizontalIconPadding);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, MathKt.roundToInt(f3) + roundToInt2, MathKt.roundToInt(align), 0.0f, 4, (Object) null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable), Math.max(z ? Alignment.Companion.getCenterVertically().align(placeable3.getHeight(), i3) : roundToInt, TextFieldImplKt.heightOrZero(placeable4) / 2), 0.0f, 4, (Object) null);
        if (placeable5 != null) {
            if (z) {
                roundToInt = Alignment.Companion.getCenterVertically().align(placeable5.getHeight(), i3);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, TextFieldImplKt.widthOrZero(placeable), roundToInt, 0.0f, 4, (Object) null);
        }
        Placeable.PlacementScope.m3689place70tqf50$default(placementScope, placeable6, IntOffset.Companion.m4832getZeronOccac(), 0.0f, 2, (Object) null);
    }

    /* renamed from: outlineCutout-12SF9DM  reason: not valid java name */
    public static final Modifier m1355outlineCutout12SF9DM(Modifier modifier, long j, PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(modifier, "$this$outlineCutout");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return DrawModifierKt.drawWithContent(modifier, new OutlinedTextFieldKt$outlineCutout$1(j, paddingValues));
    }

    public static final float getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }
}
