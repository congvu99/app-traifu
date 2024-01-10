package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidSelectionHandles.android.kt */
final class AndroidSelectionHandles_androidKt$SelectionHandle$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ ResolvedTextDirection $direction;
    final /* synthetic */ boolean $handlesCrossed;
    final /* synthetic */ boolean $isStartHandle;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ long $position;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidSelectionHandles_androidKt$SelectionHandle$1(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z, long j, int i, ResolvedTextDirection resolvedTextDirection, boolean z2) {
        super(2);
        this.$content = function2;
        this.$modifier = modifier;
        this.$isStartHandle = z;
        this.$position = j;
        this.$$dirty = i;
        this.$direction = resolvedTextDirection;
        this.$handlesCrossed = z2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:AndroidSelectionHandles.android.kt#eksfi3");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(732099485, i, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:69)");
            }
            if (this.$content == null) {
                composer.startReplaceableGroup(386443790);
                ComposerKt.sourceInformation(composer, "73@3009L405,71@2918L645");
                Modifier modifier = this.$modifier;
                Boolean valueOf = Boolean.valueOf(this.$isStartHandle);
                Offset r2 = Offset.m1672boximpl(this.$position);
                boolean z = this.$isStartHandle;
                long j = this.$position;
                composer.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composer, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean changed = composer.changed((Object) valueOf) | composer.changed((Object) r2);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new AndroidSelectionHandles_androidKt$SelectionHandle$1$1$1(z, j);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier, false, (Function1) rememberedValue, 1, (Object) null);
                boolean z2 = this.$isStartHandle;
                ResolvedTextDirection resolvedTextDirection = this.$direction;
                boolean z3 = this.$handlesCrossed;
                int i2 = this.$$dirty;
                AndroidSelectionHandles_androidKt.DefaultSelectionHandle(semantics$default, z2, resolvedTextDirection, z3, composer, (i2 & 112) | (i2 & 896) | (i2 & 7168));
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(386444465);
                ComposerKt.sourceInformation(composer, "88@3593L9");
                this.$content.invoke(composer, Integer.valueOf((this.$$dirty >> 15) & 14));
                composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
