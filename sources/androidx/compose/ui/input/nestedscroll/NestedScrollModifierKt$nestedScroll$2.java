package androidx.compose.ui.input.nestedscroll;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NestedScrollModifier.kt */
final class NestedScrollModifierKt$nestedScroll$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ NestedScrollConnection $connection;
    final /* synthetic */ NestedScrollDispatcher $dispatcher;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NestedScrollModifierKt$nestedScroll$2(NestedScrollDispatcher nestedScrollDispatcher, NestedScrollConnection nestedScrollConnection) {
        super(3);
        this.$dispatcher = nestedScrollDispatcher;
        this.$connection = nestedScrollConnection;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r4, androidx.compose.runtime.Composer r5, int r6) {
        /*
            r3 = this;
            java.lang.String r0 = "$this$composed"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r4 = 410346167(0x187562b7, float:3.1715346E-24)
            r5.startReplaceableGroup(r4)
            java.lang.String r0 = "C336@15461L24,339@15612L180:NestedScrollModifier.kt#kpqmsf"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x001c
            r0 = -1
            java.lang.String r1 = "androidx.compose.ui.input.nestedscroll.nestedScroll.<anonymous> (NestedScrollModifier.kt:335)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r6, r0, r1)
        L_0x001c:
            r4 = 773894976(0x2e20b340, float:3.6538994E-11)
            r5.startReplaceableGroup(r4)
            java.lang.String r4 = "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r4)
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r5.startReplaceableGroup(r4)
            java.lang.String r6 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            java.lang.Object r0 = r5.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x004f
            kotlin.coroutines.EmptyCoroutineContext r0 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r5)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r5.updateRememberedValue(r1)
            r0 = r1
        L_0x004f:
            r5.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r0 = r0.getCoroutineScope()
            r5.endReplaceableGroup()
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r1 = r3.$dispatcher
            r2 = 100475956(0x5fd2434, float:2.3805305E-35)
            r5.startReplaceableGroup(r2)
            java.lang.String r2 = "338@15570L37"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r2)
            if (r1 != 0) goto L_0x008a
            r5.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            java.lang.Object r4 = r5.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r4 != r6) goto L_0x0084
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r4 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher
            r4.<init>()
            r5.updateRememberedValue(r4)
        L_0x0084:
            r5.endReplaceableGroup()
            r1 = r4
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r1 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher) r1
        L_0x008a:
            r5.endReplaceableGroup()
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r4 = r3.$connection
            r6 = 1618982084(0x607fb4c4, float:7.370227E19)
            r5.startReplaceableGroup(r6)
            java.lang.String r6 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            boolean r6 = r5.changed((java.lang.Object) r4)
            boolean r2 = r5.changed((java.lang.Object) r1)
            r6 = r6 | r2
            boolean r2 = r5.changed((java.lang.Object) r0)
            r6 = r6 | r2
            java.lang.Object r2 = r5.rememberedValue()
            if (r6 != 0) goto L_0x00b6
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r2 != r6) goto L_0x00c1
        L_0x00b6:
            r1.setOriginNestedScrollScope$ui_release(r0)
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal r2 = new androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal
            r2.<init>(r1, r4)
            r5.updateRememberedValue(r2)
        L_0x00c1:
            r5.endReplaceableGroup()
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal r2 = (androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal) r2
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x00cf
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00cf:
            r5.endReplaceableGroup()
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt$nestedScroll$2.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
