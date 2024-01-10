package androidx.compose.material;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a6\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0005H\u0002\u001a\"\u0010\u0015\u001a\u00020\u0007*\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u0019"}, d2 = {"ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "updateHeight", "view", "Landroid/view/View;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "verticalMarginInPx", "", "onHeightUpdate", "expandable", "Lkotlin/Function0;", "menuLabel", "", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
public final class ExposedDropdownMenuKt {
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x032c  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    @androidx.compose.material.ExperimentalMaterialApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ExposedDropdownMenuBox(boolean r19, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r20, androidx.compose.ui.Modifier r21, kotlin.jvm.functions.Function3<? super androidx.compose.material.ExposedDropdownMenuBoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            r1 = r19
            r2 = r20
            r4 = r22
            r5 = r24
            java.lang.String r0 = "onExpandedChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 1456052980(0x56c99af4, float:1.10833678E14)
            r3 = r23
            androidx.compose.runtime.Composer r0 = r3.startRestartGroup(r0)
            java.lang.String r3 = "C(ExposedDropdownMenuBox)P(1,3,2)95@4098L7,96@4131L7,97@4156L30,98@4209L30,100@4340L37,102@4395L486,115@4907L29,129@5318L31,130@5375L38,117@4942L550,136@5498L70,140@5574L441:ExposedDropdownMenu.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            r3 = r25 & 1
            r6 = 2
            if (r3 == 0) goto L_0x0028
            r3 = r5 | 6
            goto L_0x0038
        L_0x0028:
            r3 = r5 & 14
            if (r3 != 0) goto L_0x0037
            boolean r3 = r0.changed((boolean) r1)
            if (r3 == 0) goto L_0x0034
            r3 = 4
            goto L_0x0035
        L_0x0034:
            r3 = 2
        L_0x0035:
            r3 = r3 | r5
            goto L_0x0038
        L_0x0037:
            r3 = r5
        L_0x0038:
            r7 = r25 & 2
            if (r7 == 0) goto L_0x003f
            r3 = r3 | 48
            goto L_0x004f
        L_0x003f:
            r7 = r5 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x004f
            boolean r7 = r0.changed((java.lang.Object) r2)
            if (r7 == 0) goto L_0x004c
            r7 = 32
            goto L_0x004e
        L_0x004c:
            r7 = 16
        L_0x004e:
            r3 = r3 | r7
        L_0x004f:
            r7 = r25 & 4
            if (r7 == 0) goto L_0x0056
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0069
        L_0x0056:
            r8 = r5 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0069
            r8 = r21
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0065
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0065:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r3 = r3 | r9
            goto L_0x006b
        L_0x0069:
            r8 = r21
        L_0x006b:
            r9 = r25 & 8
            if (r9 == 0) goto L_0x0072
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x0072:
            r9 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0082
            boolean r9 = r0.changed((java.lang.Object) r4)
            if (r9 == 0) goto L_0x007f
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007f:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r3 = r3 | r9
        L_0x0082:
            r9 = r3 & 5851(0x16db, float:8.199E-42)
            r10 = 1170(0x492, float:1.64E-42)
            if (r9 != r10) goto L_0x0096
            boolean r9 = r0.getSkipping()
            if (r9 != 0) goto L_0x008f
            goto L_0x0096
        L_0x008f:
            r0.skipToGroupEnd()
            r5 = r4
            r3 = r8
            goto L_0x0325
        L_0x0096:
            if (r7 == 0) goto L_0x009d
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            goto L_0x009e
        L_0x009d:
            r7 = r8
        L_0x009e:
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r8 = (androidx.compose.ui.unit.Density) r8
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r11 = r0.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            android.view.View r11 = (android.view.View) r11
            r12 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r12)
            java.lang.String r13 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r13)
            java.lang.Object r14 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            r9 = 0
            r12 = 0
            if (r14 != r15) goto L_0x00eb
            java.lang.Integer r14 = java.lang.Integer.valueOf(r12)
            androidx.compose.runtime.MutableState r14 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r14, r9, r6, r9)
            r0.updateRememberedValue(r14)
        L_0x00eb:
            r0.endReplaceableGroup()
            r15 = r14
            androidx.compose.runtime.MutableState r15 = (androidx.compose.runtime.MutableState) r15
            r14 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r14)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r13)
            java.lang.Object r14 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r16.getEmpty()
            if (r14 != r6) goto L_0x0112
            java.lang.Integer r6 = java.lang.Integer.valueOf(r12)
            r14 = 2
            androidx.compose.runtime.MutableState r14 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r6, r9, r14, r9)
            r0.updateRememberedValue(r14)
        L_0x0112:
            r0.endReplaceableGroup()
            r6 = r14
            androidx.compose.runtime.MutableState r6 = (androidx.compose.runtime.MutableState) r6
            float r9 = androidx.compose.material.MenuKt.getMenuVerticalMargin()
            int r9 = r8.m4643roundToPx0680j_4(r9)
            r14 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r14)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r13)
            java.lang.Object r14 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r16.getEmpty()
            if (r14 != r12) goto L_0x013d
            androidx.compose.ui.node.Ref r14 = new androidx.compose.ui.node.Ref
            r14.<init>()
            r0.updateRememberedValue(r14)
        L_0x013d:
            r0.endReplaceableGroup()
            androidx.compose.ui.node.Ref r14 = (androidx.compose.ui.node.Ref) r14
            int r12 = m1290ExposedDropdownMenuBox$lambda4(r6)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            int r16 = m1288ExposedDropdownMenuBox$lambda1(r15)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r16)
            r4 = 1618982084(0x607fb4c4, float:7.370227E19)
            r0.startReplaceableGroup(r4)
            java.lang.String r4 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            boolean r4 = r0.changed((java.lang.Object) r8)
            boolean r12 = r0.changed((java.lang.Object) r12)
            r4 = r4 | r12
            boolean r5 = r0.changed((java.lang.Object) r5)
            r4 = r4 | r5
            java.lang.Object r5 = r0.rememberedValue()
            if (r4 != 0) goto L_0x0179
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x0181
        L_0x0179:
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 r5 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1
            r5.<init>(r8, r6, r15)
            r0.updateRememberedValue(r5)
        L_0x0181:
            r0.endReplaceableGroup()
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 r5 = (androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) r5
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r13)
            java.lang.Object r4 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r4 != r8) goto L_0x01a3
            androidx.compose.ui.focus.FocusRequester r4 = new androidx.compose.ui.focus.FocusRequester
            r4.<init>()
            r0.updateRememberedValue(r4)
        L_0x01a3:
            r0.endReplaceableGroup()
            androidx.compose.ui.focus.FocusRequester r4 = (androidx.compose.ui.focus.FocusRequester) r4
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$1 r8 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$1
            r13 = 0
            r12 = r8
            r23 = r5
            r5 = 0
            r13 = r14
            r18 = r14
            r14 = r11
            r16 = r15
            r15 = r9
            r17 = r6
            r12.<init>(r13, r14, r15, r16, r17)
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            androidx.compose.ui.Modifier r8 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r7, r8)
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r19)
            r13 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r0.startReplaceableGroup(r13)
            java.lang.String r13 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r13)
            boolean r13 = r0.changed((java.lang.Object) r2)
            boolean r12 = r0.changed((java.lang.Object) r12)
            r12 = r12 | r13
            java.lang.Object r13 = r0.rememberedValue()
            if (r12 != 0) goto L_0x01e7
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r13 != r12) goto L_0x01f2
        L_0x01e7:
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1 r12 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1
            r12.<init>(r2, r1)
            r13 = r12
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r0.updateRememberedValue(r13)
        L_0x01f2:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            androidx.compose.material.Strings$Companion r12 = androidx.compose.material.Strings.Companion
            int r12 = r12.m1413getExposedDropdownMenuUdPEhr4()
            r14 = 6
            java.lang.String r12 = androidx.compose.material.Strings_androidKt.m1417getString4foXLRw(r12, r0, r14)
            androidx.compose.ui.Modifier r8 = expandable(r8, r13, r12)
            androidx.compose.ui.Modifier r8 = androidx.compose.ui.focus.FocusRequesterModifierKt.focusRequester(r8, r4)
            r12 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r12)
            java.lang.String r12 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            androidx.compose.ui.Alignment$Companion r12 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r12 = r12.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r12 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r12, r5, r0, r5)
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r13)
            java.lang.String r13 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r13)
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r10)
            java.lang.Object r13 = r0.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r13 = (androidx.compose.ui.unit.Density) r13
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r14 = r16
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r10)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r14 = (androidx.compose.ui.unit.LayoutDirection) r14
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r5 = r16
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r10)
            java.lang.Object r5 = r0.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            kotlin.jvm.functions.Function3 r8 = androidx.compose.ui.layout.LayoutKt.materializerOf(r8)
            androidx.compose.runtime.Applier r15 = r0.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x027c
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x027c:
            r0.startReusableNode()
            boolean r15 = r0.getInserting()
            if (r15 == 0) goto L_0x0289
            r0.createNode(r10)
            goto L_0x028c
        L_0x0289:
            r0.useNode()
        L_0x028c:
            r0.disableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r12, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r13, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r14, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r5, r12)
            r0.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r5)
            r10 = 0
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)
            r8.invoke(r5, r0, r12)
            r5 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r5)
            r5 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            androidx.compose.foundation.layout.BoxScopeInstance r5 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r5 = (androidx.compose.foundation.layout.BoxScope) r5
            r5 = -443225682(0xffffffffe594e9ae, float:-8.790261E22)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "C133@5477L9:ExposedDropdownMenu.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            r5 = 6
            int r3 = r3 >> r5
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r5 = r22
            r8 = r23
            r5.invoke(r8, r0, r3)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$4 r3 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$4
            r3.<init>(r1, r4)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r4 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r3, r0, r4)
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5 r3 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5
            r14 = r18
            r3.<init>(r11, r14, r9, r6)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r4 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r3, (androidx.compose.runtime.Composer) r0, (int) r4)
            r3 = r7
        L_0x0325:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto L_0x032c
            goto L_0x0341
        L_0x032c:
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$6 r8 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$6
            r0 = r8
            r1 = r19
            r2 = r20
            r4 = r22
            r5 = r24
            r6 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x0341:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuKt.ExposedDropdownMenuBox(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: ExposedDropdownMenuBox$lambda-1  reason: not valid java name */
    public static final int m1288ExposedDropdownMenuBox$lambda1(MutableState<Integer> mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: ExposedDropdownMenuBox$lambda-2  reason: not valid java name */
    public static final void m1289ExposedDropdownMenuBox$lambda2(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* access modifiers changed from: private */
    /* renamed from: ExposedDropdownMenuBox$lambda-4  reason: not valid java name */
    public static final int m1290ExposedDropdownMenuBox$lambda4(MutableState<Integer> mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: ExposedDropdownMenuBox$lambda-5  reason: not valid java name */
    public static final void m1291ExposedDropdownMenuBox$lambda5(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final Modifier expandable(Modifier modifier, Function0<Unit> function0, String str) {
        return SemanticsModifierKt.semantics$default(SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) Unit.INSTANCE, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new ExposedDropdownMenuKt$expandable$1(function0, (Continuation<? super ExposedDropdownMenuKt$expandable$1>) null)), false, new ExposedDropdownMenuKt$expandable$2(str, function0), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void updateHeight(View view, LayoutCoordinates layoutCoordinates, int i, Function1<? super Integer, Unit> function1) {
        if (layoutCoordinates != null) {
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            function1.invoke(Integer.valueOf(((int) Math.max(LayoutCoordinatesKt.boundsInWindow(layoutCoordinates).getTop() - ((float) rect.top), ((float) (rect.bottom - rect.top)) - LayoutCoordinatesKt.boundsInWindow(layoutCoordinates).getBottom())) - i));
        }
    }
}
