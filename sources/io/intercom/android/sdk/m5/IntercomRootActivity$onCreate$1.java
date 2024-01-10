package io.intercom.android.sdk.m5;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomRootActivity.kt */
final class IntercomRootActivity$onCreate$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ IntercomRootActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomRootActivity$onCreate$1(IntercomRootActivity intercomRootActivity) {
        super(2);
        this.this$0 = intercomRootActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            final IntercomRootActivity intercomRootActivity = this.this$0;
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableLambdaKt.composableLambda(composer, -67818788, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: kotlin.jvm.functions.Function1} */
                /* JADX WARNING: Multi-variable type inference failed */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void invoke(androidx.compose.runtime.Composer r24, int r25) {
                    /*
                        r23 = this;
                        r0 = r23
                        r11 = r24
                        r1 = r25 & 11
                        r7 = 2
                        if (r1 != r7) goto L_0x0015
                        boolean r1 = r24.getSkipping()
                        if (r1 != 0) goto L_0x0010
                        goto L_0x0015
                    L_0x0010:
                        r24.skipToGroupEnd()
                        goto L_0x0182
                    L_0x0015:
                        io.intercom.android.sdk.m5.IntercomRootActivityLauncher r1 = io.intercom.android.sdk.m5.IntercomRootActivityLauncher.INSTANCE
                        io.intercom.android.sdk.m5.IntercomRootActivity r2 = r5
                        android.content.Intent r2 = r2.getIntent()
                        java.lang.String r3 = "intent"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                        io.intercom.android.sdk.m5.IntercomScreenScenario r14 = r1.getIntercomScreenScenario(r2)
                        boolean r1 = r14 instanceof io.intercom.android.sdk.m5.IntercomScreenScenario.NoContent
                        if (r1 == 0) goto L_0x002f
                        io.intercom.android.sdk.m5.IntercomRootActivity r1 = r5
                        r1.finish()
                    L_0x002f:
                        androidx.compose.material.ModalBottomSheetValue r1 = androidx.compose.material.ModalBottomSheetValue.Hidden
                        r2 = 0
                        io.intercom.android.sdk.m5.IntercomRootActivity r3 = r5
                        r8 = 1157296644(0x44faf204, float:2007.563)
                        r11.startReplaceableGroup(r8)
                        java.lang.String r9 = "C(remember)P(1):Composables.kt#9igjgp"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r11, r9)
                        boolean r4 = r11.changed((java.lang.Object) r3)
                        java.lang.Object r5 = r24.rememberedValue()
                        if (r4 != 0) goto L_0x0051
                        androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
                        java.lang.Object r4 = r4.getEmpty()
                        if (r5 != r4) goto L_0x005c
                    L_0x0051:
                        io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$sheetState$1$1 r4 = new io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$sheetState$1$1
                        r4.<init>(r3)
                        r5 = r4
                        kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
                        r11.updateRememberedValue(r5)
                    L_0x005c:
                        r24.endReplaceableGroup()
                        r3 = r5
                        kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
                        r5 = 6
                        r6 = 2
                        r4 = r24
                        androidx.compose.material.ModalBottomSheetState r2 = androidx.compose.material.ModalBottomSheetKt.rememberModalBottomSheetState(r1, r2, r3, r4, r5, r6)
                        r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
                        r11.startReplaceableGroup(r1)
                        java.lang.String r3 = "C(remember):Composables.kt#9igjgp"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
                        java.lang.Object r4 = r24.rememberedValue()
                        androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
                        java.lang.Object r5 = r5.getEmpty()
                        r6 = 0
                        r10 = 0
                        if (r4 != r5) goto L_0x008e
                        java.lang.Float r4 = java.lang.Float.valueOf(r6)
                        androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r10, r7, r10)
                        r11.updateRememberedValue(r4)
                    L_0x008e:
                        r24.endReplaceableGroup()
                        androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
                        r5 = 0
                        androidx.navigation.Navigator[] r5 = new androidx.navigation.Navigator[r5]
                        r7 = 8
                        androidx.navigation.NavHostController r13 = androidx.navigation.compose.NavHostControllerKt.rememberNavController(r5, r11, r7)
                        r5 = 773894976(0x2e20b340, float:3.6538994E-11)
                        r11.startReplaceableGroup(r5)
                        java.lang.String r5 = "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r11, r5)
                        r11.startReplaceableGroup(r1)
                        androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
                        java.lang.Object r1 = r24.rememberedValue()
                        androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
                        java.lang.Object r3 = r3.getEmpty()
                        if (r1 != r3) goto L_0x00ca
                        kotlin.coroutines.EmptyCoroutineContext r1 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
                        kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
                        kotlinx.coroutines.CoroutineScope r1 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r1, r11)
                        androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r3 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
                        r3.<init>(r1)
                        r11.updateRememberedValue(r3)
                        r1 = r3
                    L_0x00ca:
                        r24.endReplaceableGroup()
                        androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r1
                        kotlinx.coroutines.CoroutineScope r1 = r1.getCoroutineScope()
                        r24.endReplaceableGroup()
                        kotlin.jvm.internal.Ref$ObjectRef r17 = new kotlin.jvm.internal.Ref$ObjectRef
                        r17.<init>()
                        io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$1 r3 = new io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$1
                        r20 = 0
                        r15 = r3
                        r16 = r13
                        r18 = r1
                        r19 = r2
                        r15.<init>(r16, r17, r18, r19, r20)
                        kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
                        r5 = 70
                        java.lang.String r7 = ""
                        androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r7, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r3, (androidx.compose.runtime.Composer) r11, (int) r5)
                        androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
                        androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
                        r5 = 1
                        androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r3, r6, r5, r10)
                        r11.startReplaceableGroup(r8)
                        androidx.compose.runtime.ComposerKt.sourceInformation(r11, r9)
                        boolean r6 = r11.changed((java.lang.Object) r4)
                        java.lang.Object r7 = r24.rememberedValue()
                        if (r6 != 0) goto L_0x0113
                        androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
                        java.lang.Object r6 = r6.getEmpty()
                        if (r7 != r6) goto L_0x011e
                    L_0x0113:
                        io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$2$1 r6 = new io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$2$1
                        r6.<init>(r4)
                        r7 = r6
                        kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
                        r11.updateRememberedValue(r7)
                    L_0x011e:
                        r24.endReplaceableGroup()
                        kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
                        androidx.compose.ui.Modifier r3 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r3, r7)
                        androidx.compose.ui.graphics.Shape r6 = io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt.getEquivalentCorner(r2, r4)
                        r7 = 0
                        r19 = 0
                        r21 = 0
                        io.intercom.android.sdk.m5.IntercomRootActivity r10 = r5
                        r11.startReplaceableGroup(r8)
                        androidx.compose.runtime.ComposerKt.sourceInformation(r11, r9)
                        boolean r8 = r11.changed((java.lang.Object) r10)
                        java.lang.Object r9 = r24.rememberedValue()
                        if (r8 != 0) goto L_0x014a
                        androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
                        java.lang.Object r8 = r8.getEmpty()
                        if (r9 != r8) goto L_0x0155
                    L_0x014a:
                        io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$3$1 r8 = new io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$3$1
                        r8.<init>(r10)
                        r9 = r8
                        kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
                        r11.updateRememberedValue(r9)
                    L_0x0155:
                        r24.endReplaceableGroup()
                        kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
                        r8 = 1016773576(0x3c9abbc8, float:0.01888837)
                        io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4 r10 = new io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4
                        io.intercom.android.sdk.m5.IntercomRootActivity r15 = r5
                        r12 = r10
                        r16 = r2
                        r17 = r4
                        r18 = r1
                        r12.<init>(r13, r14, r15, r16, r17, r18)
                        androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r8, r5, r10)
                        r10 = r1
                        kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
                        r12 = 12582912(0xc00000, float:1.7632415E-38)
                        r13 = 56
                        r1 = r3
                        r3 = r6
                        r4 = r7
                        r5 = r19
                        r7 = r21
                        r11 = r24
                        io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt.m5107IntercomStickyBottomSheeteVqBt0c(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13)
                    L_0x0182:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), composer, 3072, 7);
            return;
        }
        composer.skipToGroupEnd();
    }
}
