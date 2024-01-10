package androidx.compose.ui.viewinterop;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\u0007\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010\u000e\"\"\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"NoOpUpdate", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "getNoOpUpdate", "()Lkotlin/jvm/functions/Function1;", "AndroidView", "T", "factory", "Landroid/content/Context;", "modifier", "Landroidx/compose/ui/Modifier;", "update", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidView.android.kt */
public final class AndroidView_androidKt {
    private static final Function1<View, Unit> NoOpUpdate = AndroidView_androidKt$NoOpUpdate$1.INSTANCE;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends android.view.View> void AndroidView(kotlin.jvm.functions.Function1<? super android.content.Context, ? extends T> r17, androidx.compose.ui.Modifier r18, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r19, androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r8 = r17
            r9 = r21
            java.lang.String r0 = "factory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = -1783766393(0xffffffff95ade287, float:-7.023154E-26)
            r1 = r20
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AndroidView)86@4146L7,89@4353L47,91@4503L37,98@5071L7,99@5126L7,100@5160L28,101@5240L7,102@5267L23,103@5333L40,109@5749L7,110@5820L7,112@5833L1313,140@7189L439:AndroidView.android.kt#z33iqn"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r22 & 1
            if (r1 == 0) goto L_0x001e
            r1 = r9 | 6
            goto L_0x002e
        L_0x001e:
            r1 = r9 & 14
            if (r1 != 0) goto L_0x002d
            boolean r1 = r10.changed((java.lang.Object) r8)
            if (r1 == 0) goto L_0x002a
            r1 = 4
            goto L_0x002b
        L_0x002a:
            r1 = 2
        L_0x002b:
            r1 = r1 | r9
            goto L_0x002e
        L_0x002d:
            r1 = r9
        L_0x002e:
            r2 = r22 & 2
            if (r2 == 0) goto L_0x0035
            r1 = r1 | 48
            goto L_0x0048
        L_0x0035:
            r3 = r9 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0048
            r3 = r18
            boolean r4 = r10.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0044
            r4 = 32
            goto L_0x0046
        L_0x0044:
            r4 = 16
        L_0x0046:
            r1 = r1 | r4
            goto L_0x004a
        L_0x0048:
            r3 = r18
        L_0x004a:
            r4 = r22 & 4
            if (r4 == 0) goto L_0x0051
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r5 = r9 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0064
            r5 = r19
            boolean r6 = r10.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0060
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r1 = r1 | r6
            goto L_0x0066
        L_0x0064:
            r5 = r19
        L_0x0066:
            r1 = r1 & 731(0x2db, float:1.024E-42)
            r6 = 146(0x92, float:2.05E-43)
            if (r1 != r6) goto L_0x007a
            boolean r1 = r10.getSkipping()
            if (r1 != 0) goto L_0x0073
            goto L_0x007a
        L_0x0073:
            r10.skipToGroupEnd()
            r2 = r3
            r3 = r5
            goto L_0x0258
        L_0x007a:
            if (r2 == 0) goto L_0x0082
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r11 = r1
            goto L_0x0083
        L_0x0082:
            r11 = r3
        L_0x0083:
            if (r4 == 0) goto L_0x0089
            kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> r1 = NoOpUpdate
            r12 = r1
            goto L_0x008a
        L_0x0089:
            r12 = r5
        L_0x008a:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0096
            r1 = -1
            java.lang.String r2 = "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:81)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r9, r1, r2)
        L_0x0096:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r1, r2)
            java.lang.Object r0 = r10.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r3 = r0
            android.content.Context r3 = (android.content.Context) r3
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r0)
            java.lang.String r4 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r4)
            java.lang.Object r5 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r5 != r6) goto L_0x00cd
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$noOpConnection$1$1 r5 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$noOpConnection$1$1
            r5.<init>()
            r10.updateRememberedValue(r5)
        L_0x00cd:
            r10.endReplaceableGroup()
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$noOpConnection$1$1 r5 = (androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$noOpConnection$1$1) r5
            r10.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r4)
            java.lang.Object r6 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r6 != r7) goto L_0x00ec
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r6 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher
            r6.<init>()
            r10.updateRememberedValue(r6)
        L_0x00ec:
            r10.endReplaceableGroup()
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r6 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher) r6
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r5 = (androidx.compose.ui.input.nestedscroll.NestedScrollConnection) r5
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll(r7, r5, r6)
            androidx.compose.ui.Modifier r5 = r11.then(r5)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$modifierWithSemantics$1 r7 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$modifierWithSemantics$1.INSTANCE
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r13 = 1
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r5, r13, r7)
            androidx.compose.ui.Modifier r13 = androidx.compose.ui.ComposedModifierKt.materialize(r10, r5)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r1, r2)
            java.lang.Object r5 = r10.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r14 = r5
            androidx.compose.ui.unit.Density r14 = (androidx.compose.ui.unit.Density) r14
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r1, r2)
            java.lang.Object r5 = r10.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r15 = r5
            androidx.compose.ui.unit.LayoutDirection r15 = (androidx.compose.ui.unit.LayoutDirection) r15
            r5 = 0
            androidx.compose.runtime.CompositionContext r7 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r10, r5)
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.runtime.saveable.SaveableStateRegistryKt.getLocalSaveableStateRegistry()
            r0 = r16
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r1, r2)
            java.lang.Object r0 = r10.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.runtime.saveable.SaveableStateRegistry r0 = (androidx.compose.runtime.saveable.SaveableStateRegistry) r0
            int r5 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r10, r5)
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r4)
            java.lang.Object r1 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r1 != r4) goto L_0x0170
            androidx.compose.ui.node.Ref r1 = new androidx.compose.ui.node.Ref
            r1.<init>()
            r10.updateRememberedValue(r1)
        L_0x0170:
            r10.endReplaceableGroup()
            r4 = r1
            androidx.compose.ui.node.Ref r4 = (androidx.compose.ui.node.Ref) r4
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r18 = r0
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r0, r2)
            java.lang.Object r1 = r10.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.lifecycle.LifecycleOwner r1 = (androidx.lifecycle.LifecycleOwner) r1
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner()
            r19 = r1
            r1 = r16
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r0, r2)
            java.lang.Object r0 = r10.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r2 = r0
            androidx.savedstate.SavedStateRegistryOwner r2 = (androidx.savedstate.SavedStateRegistryOwner) r2
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1 r16 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1
            r1 = r18
            r0 = r16
            r8 = r19
            r1 = r3
            r3 = r2
            r2 = r7
            r7 = r3
            r3 = r6
            r6 = r4
            r4 = r17
            r19 = r5
            r5 = r18
            r20 = r6
            r6 = r19
            r9 = r7
            r7 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = r16
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r1 = 1886828752(0x7076b8d0, float:3.0542695E29)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "C(ComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            androidx.compose.runtime.Applier r1 = r10.getApplier()
            boolean r1 = r1 instanceof androidx.compose.ui.node.UiApplier
            if (r1 != 0) goto L_0x01dc
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01dc:
            r10.startNode()
            boolean r1 = r10.getInserting()
            if (r1 == 0) goto L_0x01f0
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1
            r1.<init>(r0)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r10.createNode(r1)
            goto L_0x01f3
        L_0x01f0:
            r10.useNode()
        L_0x01f3:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m1543constructorimpl(r10)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1
            r2 = r20
            r1.<init>(r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r0, r13, r1)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2
            r1.<init>(r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r0, r14, r1)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3
            r1.<init>(r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r0, r8, r1)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$4 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$4
            r1.<init>(r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r0, r9, r1)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$5 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$5
            r1.<init>(r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r0, r12, r1)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$6 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$6
            r1.<init>(r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r0, r15, r1)
            r10.endNode()
            r10.endReplaceableGroup()
            r0 = r18
            if (r0 == 0) goto L_0x024d
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3
            r3 = r19
            r1.<init>(r0, r3, r2)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r2 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect(r0, r3, r1, r10, r2)
        L_0x024d:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0256
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0256:
            r2 = r11
            r3 = r12
        L_0x0258:
            androidx.compose.runtime.ScopeUpdateScope r6 = r10.endRestartGroup()
            if (r6 != 0) goto L_0x025f
            goto L_0x0270
        L_0x025f:
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$4 r7 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$4
            r0 = r7
            r1 = r17
            r4 = r21
            r5 = r22
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x0270:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final Function1<View, Unit> getNoOpUpdate() {
        return NoOpUpdate;
    }
}
