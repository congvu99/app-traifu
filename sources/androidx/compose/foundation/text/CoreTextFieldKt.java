package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aä\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u001323\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0001¢\u0006\u0002\u0010\"\u001a0\u0010#\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%2\u0011\u0010&\u001a\r\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001eH\u0003¢\u0006\u0002\u0010'\u001a\u001d\u0010(\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\u0006\u0010)\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010*\u001a\u0015\u0010+\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010,\u001a(\u0010-\u001a\u00020\u00012\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a\u0010\u00102\u001a\u00020\u00012\u0006\u00100\u001a\u000201H\u0002\u001a \u00103\u001a\u00020\u00012\u0006\u00100\u001a\u0002012\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0013H\u0002\u001a5\u00107\u001a\u00020\u0001*\u0002082\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020=H@ø\u0001\u0000¢\u0006\u0002\u0010>\u001a\u001c\u0010?\u001a\u00020\u0007*\u00020\u00072\u0006\u00100\u001a\u0002012\u0006\u0010$\u001a\u00020%H\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006@"}, d2 = {"CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "notifyTextInputServiceOnFocusChange", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "state", "Landroidx/compose/foundation/text/TextFieldState;", "onBlur", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewKeyEventToDeselectOnBack", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: CoreTextField.kt */
public final class CoreTextFieldKt {
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0807  */
    /* JADX WARNING: Removed duplicated region for block: B:300:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x013c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CoreTextField(androidx.compose.ui.text.input.TextFieldValue r44, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r45, androidx.compose.ui.Modifier r46, androidx.compose.ui.text.TextStyle r47, androidx.compose.ui.text.input.VisualTransformation r48, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r49, androidx.compose.foundation.interaction.MutableInteractionSource r50, androidx.compose.ui.graphics.Brush r51, boolean r52, int r53, androidx.compose.ui.text.input.ImeOptions r54, androidx.compose.foundation.text.KeyboardActions r55, boolean r56, boolean r57, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, androidx.compose.runtime.Composer r59, int r60, int r61, int r62) {
        /*
            r15 = r44
            r14 = r45
            r13 = r60
            r12 = r61
            r11 = r62
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 109313709(0x683fead, float:4.9650936E-35)
            r1 = r59
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(CoreTextField)P(13,9,7,12,14,8,4!1,11,6,3,5,2,10)199@11067L7,200@11128L7,201@11196L7,202@11261L7,210@11570L42,207@11477L135,213@11653L268,225@12226L21,226@12264L324,254@12987L26,257@13073L51,263@13376L7,264@13427L7,265@13484L7,269@13595L24,270@13653L37,492@21995L86,496@22087L515,542@23735L4354:CoreTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r11 & 1
            if (r1 == 0) goto L_0x002b
            r1 = r13 | 6
            goto L_0x003b
        L_0x002b:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x003a
            boolean r1 = r10.changed((java.lang.Object) r15)
            if (r1 == 0) goto L_0x0037
            r1 = 4
            goto L_0x0038
        L_0x0037:
            r1 = 2
        L_0x0038:
            r1 = r1 | r13
            goto L_0x003b
        L_0x003a:
            r1 = r13
        L_0x003b:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x0042
            r1 = r1 | 48
            goto L_0x0052
        L_0x0042:
            r4 = r13 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0052
            boolean r4 = r10.changed((java.lang.Object) r14)
            if (r4 == 0) goto L_0x004f
            r4 = 32
            goto L_0x0051
        L_0x004f:
            r4 = 16
        L_0x0051:
            r1 = r1 | r4
        L_0x0052:
            r4 = r11 & 4
            if (r4 == 0) goto L_0x0059
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x0059:
            r9 = r13 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x006d
            r9 = r46
            boolean r16 = r10.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x0068
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r16 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r1 = r1 | r16
            goto L_0x006f
        L_0x006d:
            r9 = r46
        L_0x006f:
            r16 = r11 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x007a
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x008e
        L_0x007a:
            r2 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x008e
            r2 = r47
            boolean r19 = r10.changed((java.lang.Object) r2)
            if (r19 == 0) goto L_0x0089
            r19 = 2048(0x800, float:2.87E-42)
            goto L_0x008b
        L_0x0089:
            r19 = 1024(0x400, float:1.435E-42)
        L_0x008b:
            r1 = r1 | r19
            goto L_0x0090
        L_0x008e:
            r2 = r47
        L_0x0090:
            r19 = r11 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x009d
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r5 = r48
            goto L_0x00b3
        L_0x009d:
            r22 = 57344(0xe000, float:8.0356E-41)
            r22 = r13 & r22
            r5 = r48
            if (r22 != 0) goto L_0x00b3
            boolean r23 = r10.changed((java.lang.Object) r5)
            if (r23 == 0) goto L_0x00af
            r23 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00b1
        L_0x00af:
            r23 = 8192(0x2000, float:1.14794E-41)
        L_0x00b1:
            r1 = r1 | r23
        L_0x00b3:
            r23 = r11 & 32
            if (r23 == 0) goto L_0x00be
            r24 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r24
            r6 = r49
            goto L_0x00d3
        L_0x00be:
            r24 = 458752(0x70000, float:6.42848E-40)
            r24 = r13 & r24
            r6 = r49
            if (r24 != 0) goto L_0x00d3
            boolean r25 = r10.changed((java.lang.Object) r6)
            if (r25 == 0) goto L_0x00cf
            r25 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d1
        L_0x00cf:
            r25 = 65536(0x10000, float:9.18355E-41)
        L_0x00d1:
            r1 = r1 | r25
        L_0x00d3:
            r25 = r11 & 64
            if (r25 == 0) goto L_0x00de
            r26 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r26
            r7 = r50
            goto L_0x00f3
        L_0x00de:
            r26 = 3670016(0x380000, float:5.142788E-39)
            r26 = r13 & r26
            r7 = r50
            if (r26 != 0) goto L_0x00f3
            boolean r27 = r10.changed((java.lang.Object) r7)
            if (r27 == 0) goto L_0x00ef
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00f1
        L_0x00ef:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x00f1:
            r1 = r1 | r27
        L_0x00f3:
            r27 = 29360128(0x1c00000, float:7.052966E-38)
            r27 = r13 & r27
            if (r27 != 0) goto L_0x010f
            r8 = r11 & 128(0x80, float:1.794E-43)
            if (r8 != 0) goto L_0x0108
            r8 = r51
            boolean r28 = r10.changed((java.lang.Object) r8)
            if (r28 == 0) goto L_0x010a
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010c
        L_0x0108:
            r8 = r51
        L_0x010a:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x010c:
            r1 = r1 | r28
            goto L_0x0111
        L_0x010f:
            r8 = r51
        L_0x0111:
            r3 = r11 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x011c
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r29
            r0 = r52
            goto L_0x0131
        L_0x011c:
            r29 = 234881024(0xe000000, float:1.5777218E-30)
            r29 = r13 & r29
            r0 = r52
            if (r29 != 0) goto L_0x0131
            boolean r30 = r10.changed((boolean) r0)
            if (r30 == 0) goto L_0x012d
            r30 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012f
        L_0x012d:
            r30 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012f:
            r1 = r1 | r30
        L_0x0131:
            r0 = r11 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x013c
            r30 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r30
            r2 = r53
            goto L_0x0151
        L_0x013c:
            r30 = 1879048192(0x70000000, float:1.58456325E29)
            r30 = r13 & r30
            r2 = r53
            if (r30 != 0) goto L_0x0151
            boolean r30 = r10.changed((int) r2)
            if (r30 == 0) goto L_0x014d
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x014f
        L_0x014d:
            r30 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x014f:
            r1 = r1 | r30
        L_0x0151:
            r30 = r12 & 14
            if (r30 != 0) goto L_0x016b
            r2 = r11 & 1024(0x400, float:1.435E-42)
            if (r2 != 0) goto L_0x0164
            r2 = r54
            boolean r30 = r10.changed((java.lang.Object) r2)
            if (r30 == 0) goto L_0x0166
            r30 = 4
            goto L_0x0168
        L_0x0164:
            r2 = r54
        L_0x0166:
            r30 = 2
        L_0x0168:
            r30 = r12 | r30
            goto L_0x016f
        L_0x016b:
            r2 = r54
            r30 = r12
        L_0x016f:
            r2 = r11 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0176
            r30 = r30 | 48
            goto L_0x0189
        L_0x0176:
            r31 = r12 & 112(0x70, float:1.57E-43)
            r5 = r55
            if (r31 != 0) goto L_0x0189
            boolean r31 = r10.changed((java.lang.Object) r5)
            if (r31 == 0) goto L_0x0185
            r22 = 32
            goto L_0x0187
        L_0x0185:
            r22 = 16
        L_0x0187:
            r30 = r30 | r22
        L_0x0189:
            r5 = r30
            r6 = r11 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x0192
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x01a6
        L_0x0192:
            r7 = r12 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x01a6
            r7 = r56
            boolean r22 = r10.changed((boolean) r7)
            if (r22 == 0) goto L_0x01a1
            r26 = 256(0x100, float:3.59E-43)
            goto L_0x01a3
        L_0x01a1:
            r26 = 128(0x80, float:1.794E-43)
        L_0x01a3:
            r5 = r5 | r26
            goto L_0x01a8
        L_0x01a6:
            r7 = r56
        L_0x01a8:
            r7 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r7 == 0) goto L_0x01af
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x01c1
        L_0x01af:
            r8 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x01c1
            r8 = r57
            boolean r22 = r10.changed((boolean) r8)
            if (r22 == 0) goto L_0x01bc
            goto L_0x01be
        L_0x01bc:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x01be:
            r5 = r5 | r17
            goto L_0x01c3
        L_0x01c1:
            r8 = r57
        L_0x01c3:
            r8 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r8 == 0) goto L_0x01cc
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            r9 = r58
            goto L_0x01e0
        L_0x01cc:
            r17 = 57344(0xe000, float:8.0356E-41)
            r17 = r12 & r17
            r9 = r58
            if (r17 != 0) goto L_0x01e0
            boolean r17 = r10.changed((java.lang.Object) r9)
            if (r17 == 0) goto L_0x01dc
            goto L_0x01de
        L_0x01dc:
            r20 = 8192(0x2000, float:1.14794E-41)
        L_0x01de:
            r5 = r5 | r20
        L_0x01e0:
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r9 = r1 & r17
            r12 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r12) goto L_0x0219
            r9 = 46811(0xb6db, float:6.5596E-41)
            r9 = r9 & r5
            r12 = 9362(0x2492, float:1.3119E-41)
            if (r9 != r12) goto L_0x0219
            boolean r9 = r10.getSkipping()
            if (r9 != 0) goto L_0x01f9
            goto L_0x0219
        L_0x01f9:
            r10.skipToGroupEnd()
            r3 = r46
            r4 = r47
            r5 = r48
            r6 = r49
            r7 = r50
            r8 = r51
            r9 = r52
            r11 = r54
            r12 = r55
            r13 = r56
            r14 = r57
            r15 = r58
            r0 = r10
            r10 = r53
            goto L_0x0800
        L_0x0219:
            r10.startDefaults()
            r9 = r13 & 1
            if (r9 == 0) goto L_0x0272
            boolean r9 = r10.getDefaultsInvalid()
            if (r9 == 0) goto L_0x0227
            goto L_0x0272
        L_0x0227:
            r10.skipToGroupEnd()
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0232
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r0
        L_0x0232:
            r0 = r11 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0255
            r0 = r5 & -15
            r14 = r46
            r19 = r47
            r13 = r48
            r21 = r49
            r12 = r50
            r22 = r51
            r23 = r52
            r9 = r53
            r8 = r54
            r24 = r55
            r7 = r56
            r25 = r57
            r26 = r58
            r2 = r0
            goto L_0x0321
        L_0x0255:
            r14 = r46
            r19 = r47
            r13 = r48
            r21 = r49
            r12 = r50
            r22 = r51
            r23 = r52
            r9 = r53
            r8 = r54
            r24 = r55
            r7 = r56
            r25 = r57
            r26 = r58
            r2 = r5
            goto L_0x0321
        L_0x0272:
            if (r4 == 0) goto L_0x0279
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x027b
        L_0x0279:
            r4 = r46
        L_0x027b:
            if (r16 == 0) goto L_0x0284
            androidx.compose.ui.text.TextStyle$Companion r9 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r9 = r9.getDefault()
            goto L_0x0286
        L_0x0284:
            r9 = r47
        L_0x0286:
            if (r19 == 0) goto L_0x028f
            androidx.compose.ui.text.input.VisualTransformation$Companion r16 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r16 = r16.getNone()
            goto L_0x0291
        L_0x028f:
            r16 = r48
        L_0x0291:
            if (r23 == 0) goto L_0x0298
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$1 r18 = androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$1.INSTANCE
            kotlin.jvm.functions.Function1 r18 = (kotlin.jvm.functions.Function1) r18
            goto L_0x029a
        L_0x0298:
            r18 = r49
        L_0x029a:
            if (r25 == 0) goto L_0x029f
            r19 = 0
            goto L_0x02a1
        L_0x029f:
            r19 = r50
        L_0x02a1:
            r12 = r11 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x02bb
            androidx.compose.ui.graphics.SolidColor r12 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r21 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r21.m1968getUnspecified0d7_KjU()
            r46 = r4
            r4 = 0
            r12.<init>(r13, r4)
            r4 = r12
            androidx.compose.ui.graphics.Brush r4 = (androidx.compose.ui.graphics.Brush) r4
            r12 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r12
            goto L_0x02bf
        L_0x02bb:
            r46 = r4
            r4 = r51
        L_0x02bf:
            if (r3 == 0) goto L_0x02c3
            r3 = 1
            goto L_0x02c5
        L_0x02c3:
            r3 = r52
        L_0x02c5:
            if (r0 == 0) goto L_0x02cb
            r0 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x02cd
        L_0x02cb:
            r0 = r53
        L_0x02cd:
            r12 = r11 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x02da
            androidx.compose.ui.text.input.ImeOptions$Companion r12 = androidx.compose.ui.text.input.ImeOptions.Companion
            androidx.compose.ui.text.input.ImeOptions r12 = r12.getDefault()
            r5 = r5 & -15
            goto L_0x02dc
        L_0x02da:
            r12 = r54
        L_0x02dc:
            if (r2 == 0) goto L_0x02e5
            androidx.compose.foundation.text.KeyboardActions$Companion r2 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r2 = r2.getDefault()
            goto L_0x02e7
        L_0x02e5:
            r2 = r55
        L_0x02e7:
            if (r6 == 0) goto L_0x02eb
            r6 = 1
            goto L_0x02ed
        L_0x02eb:
            r6 = r56
        L_0x02ed:
            if (r7 == 0) goto L_0x02f1
            r7 = 0
            goto L_0x02f3
        L_0x02f1:
            r7 = r57
        L_0x02f3:
            if (r8 == 0) goto L_0x0309
            androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt r8 = androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r8 = r8.m874getLambda1$foundation_release()
            r14 = r46
            r24 = r2
            r23 = r3
            r22 = r4
            r2 = r5
            r25 = r7
            r26 = r8
            goto L_0x0316
        L_0x0309:
            r14 = r46
            r26 = r58
            r24 = r2
            r23 = r3
            r22 = r4
            r2 = r5
            r25 = r7
        L_0x0316:
            r8 = r12
            r13 = r16
            r21 = r18
            r12 = r19
            r7 = r6
            r19 = r9
            r9 = r0
        L_0x0321:
            r10.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0332
            java.lang.String r0 = "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:176)"
            r3 = 109313709(0x683fead, float:4.9650936E-35)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r2, r0)
        L_0x0332:
            androidx.compose.ui.focus.FocusRequester r0 = new androidx.compose.ui.focus.FocusRequester
            r0.<init>()
            r1 = -55013261(0xfffffffffcb89073, float:-7.666499E36)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "198@11028L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            java.lang.String r1 = "C:CompositionLocal.kt#9igjgp"
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            if (r7 == 0) goto L_0x035f
            if (r25 == 0) goto L_0x034c
            goto L_0x035f
        L_0x034c:
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalTextInputService()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r1)
            java.lang.Object r4 = r10.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.text.input.TextInputService r4 = (androidx.compose.ui.text.input.TextInputService) r4
            goto L_0x0360
        L_0x035f:
            r4 = 0
        L_0x0360:
            r10.endReplaceableGroup()
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r1)
            java.lang.Object r5 = r10.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r18 = r5
            androidx.compose.ui.unit.Density r18 = (androidx.compose.ui.unit.Density) r18
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r1)
            java.lang.Object r5 = r10.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.text.font.FontFamily$Resolver r5 = (androidx.compose.ui.text.font.FontFamily.Resolver) r5
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r1)
            java.lang.Object r6 = r10.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.foundation.text.selection.TextSelectionColors r6 = (androidx.compose.foundation.text.selection.TextSelectionColors) r6
            long r29 = r6.m1108getBackgroundColor0d7_KjU()
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFocusManager()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r1)
            java.lang.Object r6 = r10.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.focus.FocusManager r6 = (androidx.compose.ui.focus.FocusManager) r6
            r3 = 1
            if (r9 != r3) goto L_0x03be
            if (r23 != 0) goto L_0x03be
            boolean r3 = r8.getSingleLine()
            if (r3 == 0) goto L_0x03be
            r3 = 1
            goto L_0x03bf
        L_0x03be:
            r3 = 0
        L_0x03bf:
            if (r3 == 0) goto L_0x03c4
            androidx.compose.foundation.gestures.Orientation r3 = androidx.compose.foundation.gestures.Orientation.Horizontal
            goto L_0x03c6
        L_0x03c4:
            androidx.compose.foundation.gestures.Orientation r3 = androidx.compose.foundation.gestures.Orientation.Vertical
        L_0x03c6:
            r16 = r14
            r11 = 1
            java.lang.Object[] r14 = new java.lang.Object[r11]
            r11 = 0
            r14[r11] = r3
            androidx.compose.foundation.text.TextFieldScrollerPosition$Companion r11 = androidx.compose.foundation.text.TextFieldScrollerPosition.Companion
            androidx.compose.runtime.saveable.Saver r11 = r11.getSaver()
            r27 = 0
            r31 = r9
            r9 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r9)
            java.lang.String r9 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r9)
            boolean r9 = r10.changed((java.lang.Object) r3)
            r32 = r2
            java.lang.Object r2 = r10.rememberedValue()
            if (r9 != 0) goto L_0x03f7
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r2 != r9) goto L_0x0401
        L_0x03f7:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1 r2 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
            r2.<init>(r3)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r10.updateRememberedValue(r2)
        L_0x0401:
            r10.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r3 = 72
            r9 = 4
            r46 = r14
            r47 = r11
            r48 = r27
            r49 = r2
            r50 = r10
            r51 = r3
            r52 = r9
            java.lang.Object r2 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r46, r47, (java.lang.String) r48, r49, (androidx.compose.runtime.Composer) r50, (int) r51, (int) r52)
            r9 = r2
            androidx.compose.foundation.text.TextFieldScrollerPosition r9 = (androidx.compose.foundation.text.TextFieldScrollerPosition) r9
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            boolean r2 = r10.changed((java.lang.Object) r15)
            boolean r3 = r10.changed((java.lang.Object) r13)
            r2 = r2 | r3
            java.lang.Object r3 = r10.rememberedValue()
            if (r2 != 0) goto L_0x0443
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x0441
            goto L_0x0443
        L_0x0441:
            r14 = r12
            goto L_0x0462
        L_0x0443:
            androidx.compose.ui.text.AnnotatedString r2 = r44.getAnnotatedString()
            androidx.compose.ui.text.input.TransformedText r2 = androidx.compose.foundation.text.ValidatingOffsetMappingKt.filterWithValidation(r13, r2)
            androidx.compose.ui.text.TextRange r3 = r44.m4421getCompositionMzsxiRA()
            r14 = r12
            if (r3 == 0) goto L_0x045e
            long r11 = r3.m4224unboximpl()
            androidx.compose.foundation.text.TextFieldDelegate$Companion r3 = androidx.compose.foundation.text.TextFieldDelegate.Companion
            androidx.compose.ui.text.input.TransformedText r3 = r3.m943applyCompositionDecoration72CqOWE(r11, r2)
            if (r3 != 0) goto L_0x045f
        L_0x045e:
            r3 = r2
        L_0x045f:
            r10.updateRememberedValue(r3)
        L_0x0462:
            r10.endReplaceableGroup()
            r2 = r3
            androidx.compose.ui.text.input.TransformedText r2 = (androidx.compose.ui.text.input.TransformedText) r2
            androidx.compose.ui.text.AnnotatedString r3 = r2.getText()
            androidx.compose.ui.text.input.OffsetMapping r11 = r2.getOffsetMapping()
            r27 = r14
            r12 = 0
            androidx.compose.runtime.RecomposeScope r14 = androidx.compose.runtime.ComposablesKt.getCurrentRecomposeScope(r10, r12)
            r12 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r12)
            java.lang.String r12 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r12)
            r33 = r9
            java.lang.Object r9 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r34 = androidx.compose.runtime.Composer.Companion
            r35 = r2
            java.lang.Object r2 = r34.getEmpty()
            if (r9 != r2) goto L_0x04bf
            androidx.compose.foundation.text.TextFieldState r9 = new androidx.compose.foundation.text.TextFieldState
            androidx.compose.foundation.text.TextDelegate r2 = new androidx.compose.foundation.text.TextDelegate
            r34 = 0
            r36 = 0
            r37 = 0
            r38 = 148(0x94, float:2.07E-43)
            r39 = 0
            r46 = r2
            r47 = r3
            r48 = r19
            r49 = r34
            r50 = r23
            r51 = r36
            r52 = r18
            r53 = r5
            r54 = r37
            r55 = r38
            r56 = r39
            r46.<init>(r47, r48, r49, r50, r51, r52, r53, r54, r55, r56)
            r9.<init>(r2, r14)
            r10.updateRememberedValue(r9)
        L_0x04bf:
            r10.endReplaceableGroup()
            androidx.compose.foundation.text.TextFieldState r9 = (androidx.compose.foundation.text.TextFieldState) r9
            androidx.compose.ui.text.AnnotatedString r2 = r44.getAnnotatedString()
            r46 = r9
            r47 = r2
            r48 = r3
            r49 = r19
            r50 = r23
            r51 = r18
            r52 = r5
            r53 = r45
            r54 = r24
            r55 = r6
            r56 = r29
            r46.m962updatefnh65Uc(r47, r48, r49, r50, r51, r52, r53, r54, r55, r56)
            androidx.compose.ui.text.input.EditProcessor r2 = r9.getProcessor()
            androidx.compose.ui.text.input.TextInputSession r3 = r9.getInputSession()
            r2.reset(r15, r3)
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r12)
            java.lang.Object r2 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x050c
            androidx.compose.foundation.text.UndoManager r2 = new androidx.compose.foundation.text.UndoManager
            r3 = 0
            r5 = 0
            r6 = 1
            r2.<init>(r5, r6, r3)
            r10.updateRememberedValue(r2)
        L_0x050c:
            r10.endReplaceableGroup()
            androidx.compose.foundation.text.UndoManager r2 = (androidx.compose.foundation.text.UndoManager) r2
            r5 = 0
            r3 = 2
            r14 = 0
            r46 = r2
            r47 = r44
            r48 = r5
            r50 = r3
            r51 = r14
            androidx.compose.foundation.text.UndoManager.snapshotIfNeeded$default(r46, r47, r48, r50, r51)
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r12)
            java.lang.Object r3 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r3 != r5) goto L_0x053f
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r3 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager
            r3.<init>(r2)
            r10.updateRememberedValue(r3)
        L_0x053f:
            r10.endReplaceableGroup()
            r14 = r3
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r14 = (androidx.compose.foundation.text.selection.TextFieldSelectionManager) r14
            r14.setOffsetMapping$foundation_release(r11)
            r14.setVisualTransformation$foundation_release(r13)
            kotlin.jvm.functions.Function1 r3 = r9.getOnValueChange()
            r14.setOnValueChange$foundation_release(r3)
            r14.setState$foundation_release(r9)
            r14.setValue$foundation_release(r15)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalClipboardManager()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r1)
            java.lang.Object r3 = r10.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.platform.ClipboardManager r3 = (androidx.compose.ui.platform.ClipboardManager) r3
            r14.setClipboardManager$foundation_release(r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalTextToolbar()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r1)
            java.lang.Object r3 = r10.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.platform.TextToolbar r3 = (androidx.compose.ui.platform.TextToolbar) r3
            r14.setTextToolbar(r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalHapticFeedback()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r1)
            java.lang.Object r1 = r10.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.hapticfeedback.HapticFeedback r1 = (androidx.compose.ui.hapticfeedback.HapticFeedback) r1
            r14.setHapticFeedBack(r1)
            r14.setFocusRequester(r0)
            r1 = r25 ^ 1
            r14.setEditable(r1)
            r1 = 773894976(0x2e20b340, float:3.6538994E-11)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r12)
            java.lang.Object r1 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r1 != r3) goto L_0x05d3
            kotlin.coroutines.EmptyCoroutineContext r1 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            kotlinx.coroutines.CoroutineScope r1 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r1, r10)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r3 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r3.<init>(r1)
            r10.updateRememberedValue(r3)
            r1 = r3
        L_0x05d3:
            r10.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r1
            kotlinx.coroutines.CoroutineScope r1 = r1.getCoroutineScope()
            r10.endReplaceableGroup()
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r12)
            java.lang.Object r3 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r3 != r5) goto L_0x05fb
            androidx.compose.foundation.relocation.BringIntoViewRequester r3 = androidx.compose.foundation.relocation.BringIntoViewRequesterKt.BringIntoViewRequester()
            r10.updateRememberedValue(r3)
        L_0x05fb:
            r10.endReplaceableGroup()
            r29 = r3
            androidx.compose.foundation.relocation.BringIntoViewRequester r29 = (androidx.compose.foundation.relocation.BringIntoViewRequester) r29
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1 r5 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1
            r46 = r5
            r47 = r9
            r48 = r4
            r49 = r44
            r50 = r8
            r51 = r14
            r52 = r1
            r53 = r29
            r54 = r11
            r46.<init>(r47, r48, r49, r50, r51, r52, r53, r54)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r12 = r27
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.text.TextFieldGestureModifiersKt.textFieldFocusModifier(r3, r7, r0, r12, r5)
            r3 = -55008775(0xfffffffffcb8a1f9, float:-7.6693425E36)
            r10.startReplaceableGroup(r3)
            java.lang.String r3 = "318@15664L163"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r3)
            r3 = 8
            if (r7 == 0) goto L_0x0640
            if (r25 != 0) goto L_0x0640
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2 r5 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2
            r5.<init>(r9)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r9, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r5, (androidx.compose.runtime.Composer) r10, (int) r3)
        L_0x0640:
            r10.endReplaceableGroup()
            boolean r5 = androidx.compose.foundation.text.TouchMode_androidKt.isInTouchMode()
            if (r5 == 0) goto L_0x067c
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            androidx.compose.foundation.text.TextDragObserver r6 = r14.getTouchSelectionObserver$foundation_release()
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.text.TextFieldGestureModifiersKt.longPressDragGestureFilter(r5, r6, r7)
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1 r27 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1
            r46 = r27
            r47 = r9
            r48 = r0
            r49 = r25
            r50 = r14
            r51 = r11
            r46.<init>(r47, r48, r49, r50, r51)
            r3 = r27
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.text.TextFieldPressGestureFilterKt.tapPressTextFieldModifier(r6, r12, r7, r3)
            androidx.compose.ui.Modifier r3 = r3.then(r5)
            r58 = r1
            r27 = r12
            r1 = 0
            goto L_0x0697
        L_0x067c:
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.foundation.text.selection.MouseSelectionObserver r5 = r14.getMouseSelectionObserver$foundation_release()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.text.TextFieldGestureModifiersKt.mouseDragGestureDetector(r3, r5, r7)
            androidx.compose.ui.input.pointer.PointerIcon r5 = androidx.compose.foundation.text.TextPointerIcon_androidKt.getTextPointerIcon()
            r58 = r1
            r27 = r12
            r1 = 0
            r6 = 2
            r12 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.input.pointer.PointerIconKt.pointerHoverIcon$default(r3, r5, r1, r6, r12)
        L_0x0697:
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1 r6 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1
            r6.<init>(r9, r15, r11)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.ui.Modifier r12 = androidx.compose.ui.draw.DrawModifierKt.drawBehind(r5, r6)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1 r6 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1
            r6.<init>(r9, r7, r14)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.ui.Modifier r17 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r5, r6)
            boolean r5 = r13 instanceof androidx.compose.ui.text.input.PasswordVisualTransformation
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1 r28 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1
            r46 = r28
            r47 = r8
            r48 = r35
            r49 = r44
            r50 = r7
            r51 = r5
            r52 = r25
            r53 = r9
            r54 = r11
            r55 = r14
            r56 = r0
            r46.<init>(r47, r48, r49, r50, r51, r52, r53, r54, r55, r56)
            r0 = r28
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r5 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r6, r5, r0)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            if (r7 == 0) goto L_0x06e9
            if (r25 != 0) goto L_0x06e9
            r6 = 1
            goto L_0x06ea
        L_0x06e9:
            r6 = 0
        L_0x06ea:
            r46 = r5
            r47 = r9
            r48 = r44
            r49 = r11
            r50 = r22
            r51 = r6
            androidx.compose.ui.Modifier r28 = androidx.compose.foundation.text.TextFieldCursorKt.cursor(r46, r47, r48, r49, r50, r51)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3 r5 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3
            r5.<init>(r14)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r6 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r14, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r5, (androidx.compose.runtime.Composer) r10, (int) r6)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4 r5 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4
            r5.<init>(r4, r9, r15, r8)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r4 = r32 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r8, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r5, (androidx.compose.runtime.Composer) r10, (int) r4)
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            kotlin.jvm.functions.Function1 r5 = r9.getOnValueChange()
            r6 = r25 ^ 1
            r59 = r10
            r10 = r31
            r15 = 1
            if (r10 != r15) goto L_0x0726
            r20 = 1
            goto L_0x0728
        L_0x0726:
            r20 = 0
        L_0x0728:
            r46 = r4
            r47 = r9
            r48 = r14
            r49 = r44
            r50 = r5
            r51 = r6
            r52 = r20
            r53 = r11
            r54 = r2
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.text.TextFieldKeyInputKt.textFieldKeyInput(r46, r47, r48, r49, r50, r51, r52, r53, r54)
            r4 = r58
            r11 = r16
            androidx.compose.ui.Modifier r4 = r11.then(r4)
            androidx.compose.ui.Modifier r4 = previewKeyEventToDeselectOnBack(r4, r9, r14)
            androidx.compose.ui.Modifier r2 = r4.then(r2)
            r5 = r27
            r6 = r33
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.text.TextFieldScrollKt.textFieldScrollable(r2, r6, r5, r7)
            androidx.compose.ui.Modifier r2 = r2.then(r3)
            androidx.compose.ui.Modifier r0 = r2.then(r0)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1 r2 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
            r2.<init>(r9)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r0, r2)
            if (r7 == 0) goto L_0x077a
            boolean r0 = r9.getHasFocus()
            if (r0 == 0) goto L_0x077a
            boolean r0 = androidx.compose.foundation.text.TouchMode_androidKt.isInTouchMode()
            if (r0 == 0) goto L_0x077a
            r16 = 1
            goto L_0x077c
        L_0x077a:
            r16 = 0
        L_0x077c:
            if (r16 == 0) goto L_0x0787
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt.textFieldMagnifier(r0, r14)
            goto L_0x078b
        L_0x0787:
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x078b:
            r20 = r0
            r3 = -1885146845(0xffffffff8fa2f123, float:-1.6067316E-29)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5 r2 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
            r0 = r2
            r1 = r26
            r40 = r2
            r2 = r32
            r3 = r9
            r9 = r4
            r4 = r10
            r27 = r5
            r5 = r19
            r30 = r7
            r7 = r44
            r31 = r8
            r8 = r13
            r32 = r10
            r10 = r9
            r9 = r28
            r41 = r59
            r42 = r10
            r10 = r12
            r28 = r11
            r11 = r17
            r12 = r20
            r20 = r13
            r13 = r29
            r46 = r14
            r15 = r16
            r16 = r25
            r17 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r2 = r40
            r0 = r41
            r1 = -1885146845(0xffffffff8fa2f123, float:-1.6067316E-29)
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r1, r3, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r2 = 448(0x1c0, float:6.28E-43)
            r3 = r46
            r4 = r42
            CoreTextFieldRootBox(r4, r3, r1, r0, r2)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x07e6
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x07e6:
            r4 = r19
            r5 = r20
            r6 = r21
            r8 = r22
            r9 = r23
            r12 = r24
            r14 = r25
            r15 = r26
            r7 = r27
            r3 = r28
            r13 = r30
            r11 = r31
            r10 = r32
        L_0x0800:
            androidx.compose.runtime.ScopeUpdateScope r2 = r0.endRestartGroup()
            if (r2 != 0) goto L_0x0807
            goto L_0x0823
        L_0x0807:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$6 r19 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$6
            r0 = r19
            r1 = r44
            r43 = r2
            r2 = r45
            r16 = r60
            r17 = r61
            r18 = r62
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0 = r19
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r43
            r1.updateScope(r0)
        L_0x0823:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, boolean, int, androidx.compose.ui.text.input.ImeOptions, androidx.compose.foundation.text.KeyboardActions, boolean, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void CoreTextFieldRootBox(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-20551815);
        ComposerKt.sourceInformation(startRestartGroup, "C(CoreTextFieldRootBox)P(2,1)642@28247L95:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-20551815, i, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:637)");
        }
        int i2 = (i & 14) | BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
        int i3 = i2 >> 3;
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, startRestartGroup, (i3 & 112) | (i3 & 14));
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LayoutDirection layoutDirection = (LayoutDirection) consume2;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
        int i4 = ((((i2 << 3) & 112) << 9) & 7168) | 6;
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
        Composer r5 = Updater.m1543constructorimpl(startRestartGroup);
        Updater.m1550setimpl(r5, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1550setimpl(r5, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m1550setimpl(r5, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1550setimpl(r5, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i4 >> 3) & 112));
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-2137368960);
        ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
        if (((i4 >> 9) & 14 & 11) != 2 || !startRestartGroup.getSkipping()) {
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(1524757375);
            ComposerKt.sourceInformation(startRestartGroup, "C643@28303L33:CoreTextField.kt#423gt5");
            if (((((i2 >> 6) & 112) | 6) & 81) != 16 || !startRestartGroup.getSkipping()) {
                ContextMenu_androidKt.ContextMenuArea(textFieldSelectionManager, function2, startRestartGroup, ((i >> 3) & 112) | 8);
            } else {
                startRestartGroup.skipToGroupEnd();
            }
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CoreTextFieldKt$CoreTextFieldRootBox$2(modifier, textFieldSelectionManager, function2, i));
        }
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier modifier, TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new CoreTextFieldKt$previewKeyEventToDeselectOnBack$1(textFieldState, textFieldSelectionManager));
    }

    /* access modifiers changed from: private */
    public static final void tapToFocus(TextFieldState textFieldState, FocusRequester focusRequester, boolean z) {
        TextInputSession inputSession;
        if (!textFieldState.getHasFocus()) {
            focusRequester.requestFocus();
        } else if (z && (inputSession = textFieldState.getInputSession()) != null) {
            inputSession.showSoftwareKeyboard();
        }
    }

    /* access modifiers changed from: private */
    public static final void notifyTextInputServiceOnFocusChange(TextInputService textInputService, TextFieldState textFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions) {
        if (textFieldState.getHasFocus()) {
            textFieldState.setInputSession(TextFieldDelegate.Companion.onFocus$foundation_release(textInputService, textFieldValue, textFieldState.getProcessor(), imeOptions, textFieldState.getOnValueChange(), textFieldState.getOnImeActionPerformed()));
            return;
        }
        onBlur(textFieldState);
    }

    /* access modifiers changed from: private */
    public static final void onBlur(TextFieldState textFieldState) {
        TextInputSession inputSession = textFieldState.getInputSession();
        if (inputSession != null) {
            TextFieldDelegate.Companion.onBlur$foundation_release(inputSession, textFieldState.getProcessor(), textFieldState.getOnValueChange());
        }
        textFieldState.setInputSession((TextInputSession) null);
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> continuation) {
        Rect rect;
        int originalToTransformed = offsetMapping.originalToTransformed(TextRange.m4217getMaximpl(textFieldValue.m4422getSelectiond9O1mEE()));
        if (originalToTransformed < textLayoutResult.getLayoutInput().getText().length()) {
            rect = textLayoutResult.getBoundingBox(originalToTransformed);
        } else if (originalToTransformed != 0) {
            rect = textLayoutResult.getBoundingBox(originalToTransformed - 1);
        } else {
            rect = new Rect(0.0f, 0.0f, 1.0f, (float) IntSize.m4863getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), (String) null, 0, 24, (Object) null)));
        }
        Object bringIntoView = bringIntoViewRequester.bringIntoView(rect, continuation);
        return bringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? bringIntoView : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void SelectionToolbarAndHandles(TextFieldSelectionManager textFieldSelectionManager, boolean z, Composer composer, int i) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer startRestartGroup = composer.startRestartGroup(626339208);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionToolbarAndHandles)979@41906L202:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(626339208, i, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:960)");
        }
        if (z) {
            TextFieldState state$foundation_release = textFieldSelectionManager.getState$foundation_release();
            TextLayoutResult textLayoutResult = null;
            boolean z2 = true;
            if (!(state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null || (value = layoutResult.getValue()) == null)) {
                TextFieldState state$foundation_release2 = textFieldSelectionManager.getState$foundation_release();
                if (!(state$foundation_release2 != null ? state$foundation_release2.isLayoutResultStale() : true)) {
                    textLayoutResult = value;
                }
            }
            if (textLayoutResult != null) {
                if (!TextRange.m4214getCollapsedimpl(textFieldSelectionManager.getValue$foundation_release().m4422getSelectiond9O1mEE())) {
                    int originalToTransformed = textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m4220getStartimpl(textFieldSelectionManager.getValue$foundation_release().m4422getSelectiond9O1mEE()));
                    int originalToTransformed2 = textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m4215getEndimpl(textFieldSelectionManager.getValue$foundation_release().m4422getSelectiond9O1mEE()));
                    ResolvedTextDirection bidiRunDirection = textLayoutResult.getBidiRunDirection(originalToTransformed);
                    ResolvedTextDirection bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(originalToTransformed2 - 1, 0));
                    startRestartGroup.startReplaceableGroup(-498393098);
                    ComposerKt.sourceInformation(startRestartGroup, "972@41583L203");
                    TextFieldState state$foundation_release3 = textFieldSelectionManager.getState$foundation_release();
                    if (state$foundation_release3 != null && state$foundation_release3.getShowSelectionHandleStart()) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, startRestartGroup, 518);
                    }
                    startRestartGroup.endReplaceableGroup();
                    TextFieldState state$foundation_release4 = textFieldSelectionManager.getState$foundation_release();
                    if (state$foundation_release4 == null || !state$foundation_release4.getShowSelectionHandleEnd()) {
                        z2 = false;
                    }
                    if (z2) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, startRestartGroup, 518);
                    }
                }
                TextFieldState state$foundation_release5 = textFieldSelectionManager.getState$foundation_release();
                if (state$foundation_release5 != null) {
                    if (textFieldSelectionManager.isTextChanged$foundation_release()) {
                        state$foundation_release5.setShowFloatingToolbar(false);
                    }
                    if (state$foundation_release5.getHasFocus()) {
                        if (state$foundation_release5.getShowFloatingToolbar()) {
                            textFieldSelectionManager.showSelectionToolbar$foundation_release();
                        } else {
                            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                        }
                    }
                }
            }
        } else {
            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CoreTextFieldKt$SelectionToolbarAndHandles$2(textFieldSelectionManager, z, i));
        }
    }

    public static final void TextFieldCursorHandle(TextFieldSelectionManager textFieldSelectionManager, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(textFieldSelectionManager, "manager");
        Composer startRestartGroup = composer.startRestartGroup(-1436003720);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldCursorHandle)1005@42951L50,1006@43064L7,1013@43321L205,1007@43081L483:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1436003720, i, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1003)");
        }
        TextFieldState state$foundation_release = textFieldSelectionManager.getState$foundation_release();
        if (state$foundation_release != null && state$foundation_release.getShowCursorHandle()) {
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) textFieldSelectionManager);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = textFieldSelectionManager.cursorDragObserver$foundation_release();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            long r6 = textFieldSelectionManager.m1085getCursorPositiontuRUvjQ$foundation_release((Density) consume);
            Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) textDragObserver, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new CoreTextFieldKt$TextFieldCursorHandle$1(textDragObserver, (Continuation<? super CoreTextFieldKt$TextFieldCursorHandle$1>) null));
            Offset r5 = Offset.m1672boximpl(r6);
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed((Object) r5);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new CoreTextFieldKt$TextFieldCursorHandle$2$1(r6);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            AndroidCursorHandle_androidKt.m858CursorHandleULxng0E(r6, SemanticsModifierKt.semantics$default(pointerInput, false, (Function1) rememberedValue2, 1, (Object) null), (Function2<? super Composer, ? super Integer, Unit>) null, startRestartGroup, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CoreTextFieldKt$TextFieldCursorHandle$3(textFieldSelectionManager, i));
        }
    }
}
