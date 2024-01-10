package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

@ExperimentalMaterialApi
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001JK\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0017¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u0005H&¨\u0006\u0012"}, d2 = {"Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "", "ExposedDropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "exposedDropdownSize", "matchTextFieldWidth", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
public interface ExposedDropdownMenuBoxScope {
    void ExposedDropdownMenu(boolean z, Function0<Unit> function0, Modifier modifier, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2);

    Modifier exposedDropdownSize(Modifier modifier, boolean z);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ExposedDropdownMenu.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = true;
                }
                return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: kotlin.jvm.functions.Function2} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0074  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0088  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x008d  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x00b0  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x00b7  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x01c2  */
        /* JADX WARNING: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void ExposedDropdownMenu(androidx.compose.material.ExposedDropdownMenuBoxScope r23, boolean r24, kotlin.jvm.functions.Function0<kotlin.Unit> r25, androidx.compose.ui.Modifier r26, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
            /*
                r6 = r25
                r14 = r27
                r15 = r29
                java.lang.String r0 = "onDismissRequest"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r0 = "content"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
                r0 = -1165636223(0xffffffffba85cd81, float:-0.001020834)
                r1 = r28
                androidx.compose.runtime.Composer r5 = r1.startRestartGroup(r0)
                java.lang.String r0 = "C(ExposedDropdownMenu)P(1,3,2)244@9344L42,248@9546L51,249@9637L7,253@9784L139,257@9937L444:ExposedDropdownMenu.kt#jmzs0o"
                androidx.compose.runtime.ComposerKt.sourceInformation(r5, r0)
                r0 = r30 & 1
                r1 = 2
                if (r0 == 0) goto L_0x0028
                r0 = r15 | 6
                r4 = r24
                goto L_0x003a
            L_0x0028:
                r0 = r15 & 14
                r4 = r24
                if (r0 != 0) goto L_0x0039
                boolean r0 = r5.changed((boolean) r4)
                if (r0 == 0) goto L_0x0036
                r0 = 4
                goto L_0x0037
            L_0x0036:
                r0 = 2
            L_0x0037:
                r0 = r0 | r15
                goto L_0x003a
            L_0x0039:
                r0 = r15
            L_0x003a:
                r2 = r30 & 2
                if (r2 == 0) goto L_0x0041
                r0 = r0 | 48
                goto L_0x0051
            L_0x0041:
                r2 = r15 & 112(0x70, float:1.57E-43)
                if (r2 != 0) goto L_0x0051
                boolean r2 = r5.changed((java.lang.Object) r6)
                if (r2 == 0) goto L_0x004e
                r2 = 32
                goto L_0x0050
            L_0x004e:
                r2 = 16
            L_0x0050:
                r0 = r0 | r2
            L_0x0051:
                r2 = r30 & 4
                if (r2 == 0) goto L_0x0058
                r0 = r0 | 384(0x180, float:5.38E-43)
                goto L_0x006b
            L_0x0058:
                r3 = r15 & 896(0x380, float:1.256E-42)
                if (r3 != 0) goto L_0x006b
                r3 = r26
                boolean r7 = r5.changed((java.lang.Object) r3)
                if (r7 == 0) goto L_0x0067
                r7 = 256(0x100, float:3.59E-43)
                goto L_0x0069
            L_0x0067:
                r7 = 128(0x80, float:1.794E-43)
            L_0x0069:
                r0 = r0 | r7
                goto L_0x006d
            L_0x006b:
                r3 = r26
            L_0x006d:
                r7 = r30 & 8
                if (r7 == 0) goto L_0x0074
                r0 = r0 | 3072(0xc00, float:4.305E-42)
                goto L_0x0084
            L_0x0074:
                r7 = r15 & 7168(0x1c00, float:1.0045E-41)
                if (r7 != 0) goto L_0x0084
                boolean r7 = r5.changed((java.lang.Object) r14)
                if (r7 == 0) goto L_0x0081
                r7 = 2048(0x800, float:2.87E-42)
                goto L_0x0083
            L_0x0081:
                r7 = 1024(0x400, float:1.435E-42)
            L_0x0083:
                r0 = r0 | r7
            L_0x0084:
                r7 = r30 & 16
                if (r7 == 0) goto L_0x008d
                r0 = r0 | 24576(0x6000, float:3.4438E-41)
                r13 = r23
                goto L_0x00a1
            L_0x008d:
                r7 = 57344(0xe000, float:8.0356E-41)
                r7 = r7 & r15
                r13 = r23
                if (r7 != 0) goto L_0x00a1
                boolean r7 = r5.changed((java.lang.Object) r13)
                if (r7 == 0) goto L_0x009e
                r7 = 16384(0x4000, float:2.2959E-41)
                goto L_0x00a0
            L_0x009e:
                r7 = 8192(0x2000, float:1.14794E-41)
            L_0x00a0:
                r0 = r0 | r7
            L_0x00a1:
                r7 = 46811(0xb6db, float:6.5596E-41)
                r7 = r7 & r0
                r8 = 9362(0x2492, float:1.3119E-41)
                if (r7 != r8) goto L_0x00b7
                boolean r7 = r5.getSkipping()
                if (r7 != 0) goto L_0x00b0
                goto L_0x00b7
            L_0x00b0:
                r5.skipToGroupEnd()
                r4 = r3
                r7 = r5
                goto L_0x01bb
            L_0x00b7:
                if (r2 == 0) goto L_0x00c0
                androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
                androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
                r16 = r2
                goto L_0x00c2
            L_0x00c0:
                r16 = r3
            L_0x00c2:
                r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
                r5.startReplaceableGroup(r2)
                java.lang.String r3 = "C(remember):Composables.kt#9igjgp"
                androidx.compose.runtime.ComposerKt.sourceInformation(r5, r3)
                java.lang.Object r7 = r5.rememberedValue()
                androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
                java.lang.Object r8 = r8.getEmpty()
                if (r7 != r8) goto L_0x00e6
                androidx.compose.animation.core.MutableTransitionState r7 = new androidx.compose.animation.core.MutableTransitionState
                r8 = 0
                java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
                r7.<init>(r8)
                r5.updateRememberedValue(r7)
            L_0x00e6:
                r5.endReplaceableGroup()
                r8 = r7
                androidx.compose.animation.core.MutableTransitionState r8 = (androidx.compose.animation.core.MutableTransitionState) r8
                java.lang.Boolean r7 = java.lang.Boolean.valueOf(r24)
                r8.setTargetState(r7)
                java.lang.Object r7 = r8.getCurrentState()
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r7 = r7.booleanValue()
                if (r7 != 0) goto L_0x010f
                java.lang.Object r7 = r8.getTargetState()
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r7 = r7.booleanValue()
                if (r7 == 0) goto L_0x010c
                goto L_0x010f
            L_0x010c:
                r7 = r5
                goto L_0x01b9
            L_0x010f:
                r5.startReplaceableGroup(r2)
                androidx.compose.runtime.ComposerKt.sourceInformation(r5, r3)
                java.lang.Object r2 = r5.rememberedValue()
                androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
                java.lang.Object r3 = r3.getEmpty()
                if (r2 != r3) goto L_0x0133
                androidx.compose.ui.graphics.TransformOrigin$Companion r2 = androidx.compose.ui.graphics.TransformOrigin.Companion
                long r2 = r2.m2326getCenterSzJe1aQ()
                androidx.compose.ui.graphics.TransformOrigin r2 = androidx.compose.ui.graphics.TransformOrigin.m2313boximpl(r2)
                r3 = 0
                androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r3, r1, r3)
                r5.updateRememberedValue(r2)
            L_0x0133:
                r5.endReplaceableGroup()
                r9 = r2
                androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
                androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
                androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
                r2 = 2023513938(0x789c5f52, float:2.5372864E34)
                java.lang.String r3 = "C:CompositionLocal.kt#9igjgp"
                androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r2, r3)
                java.lang.Object r1 = r5.consume(r1)
                androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
                r20 = r1
                androidx.compose.ui.unit.Density r20 = (androidx.compose.ui.unit.Density) r20
                androidx.compose.ui.unit.DpOffset$Companion r1 = androidx.compose.ui.unit.DpOffset.Companion
                long r18 = r1.m4775getZeroRKDOV3M()
                r1 = 1157296644(0x44faf204, float:2007.563)
                r5.startReplaceableGroup(r1)
                java.lang.String r1 = "C(remember)P(1):Composables.kt#9igjgp"
                androidx.compose.runtime.ComposerKt.sourceInformation(r5, r1)
                boolean r1 = r5.changed((java.lang.Object) r9)
                java.lang.Object r2 = r5.rememberedValue()
                if (r1 != 0) goto L_0x0175
                androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
                java.lang.Object r1 = r1.getEmpty()
                if (r2 != r1) goto L_0x0180
            L_0x0175:
                androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1 r1 = new androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1
                r1.<init>(r9)
                r2 = r1
                kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
                r5.updateRememberedValue(r2)
            L_0x0180:
                r5.endReplaceableGroup()
                r21 = r2
                kotlin.jvm.functions.Function2 r21 = (kotlin.jvm.functions.Function2) r21
                r22 = 0
                androidx.compose.material.DropdownMenuPositionProvider r1 = new androidx.compose.material.DropdownMenuPositionProvider
                r17 = r1
                r17.<init>(r18, r20, r21, r22)
                androidx.compose.ui.window.PopupPositionProvider r1 = (androidx.compose.ui.window.PopupPositionProvider) r1
                r2 = -406650841(0xffffffffe7c30027, float:-1.8417285E24)
                androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1 r3 = new androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1
                r7 = r3
                r10 = r23
                r11 = r16
                r12 = r27
                r13 = r0
                r7.<init>(r8, r9, r10, r11, r12, r13)
                r7 = 1
                androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r5, r2, r7, r3)
                kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
                int r0 = r0 >> 3
                r0 = r0 & 14
                r7 = r0 | 384(0x180, float:5.38E-43)
                r8 = 0
                r0 = r25
                r3 = r5
                r4 = r7
                r7 = r5
                r5 = r8
                androidx.compose.material.internal.ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(r0, r1, r2, r3, r4, r5)
            L_0x01b9:
                r4 = r16
            L_0x01bb:
                androidx.compose.runtime.ScopeUpdateScope r8 = r7.endRestartGroup()
                if (r8 != 0) goto L_0x01c2
                goto L_0x01d9
            L_0x01c2:
                androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2 r9 = new androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2
                r0 = r9
                r1 = r23
                r2 = r24
                r3 = r25
                r5 = r27
                r6 = r29
                r7 = r30
                r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
                r8.updateScope(r9)
            L_0x01d9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuBoxScope.DefaultImpls.ExposedDropdownMenu(androidx.compose.material.ExposedDropdownMenuBoxScope, boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
        }
    }
}
