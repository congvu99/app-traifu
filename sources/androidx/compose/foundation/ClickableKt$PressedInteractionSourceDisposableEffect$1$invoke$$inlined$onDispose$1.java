package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.MutableState;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Effects.kt */
public final class ClickableKt$PressedInteractionSourceDisposableEffect$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ Map $currentKeyPressInteractions$inlined;
    final /* synthetic */ MutableInteractionSource $interactionSource$inlined;
    final /* synthetic */ MutableState $pressedInteraction$inlined;

    public ClickableKt$PressedInteractionSourceDisposableEffect$1$invoke$$inlined$onDispose$1(MutableState mutableState, Map map, MutableInteractionSource mutableInteractionSource) {
        this.$pressedInteraction$inlined = mutableState;
        this.$currentKeyPressInteractions$inlined = map;
        this.$interactionSource$inlined = mutableInteractionSource;
    }

    public void dispose() {
        PressInteraction.Press press = (PressInteraction.Press) this.$pressedInteraction$inlined.getValue();
        if (press != null) {
            this.$interactionSource$inlined.tryEmit(new PressInteraction.Cancel(press));
            this.$pressedInteraction$inlined.setValue(null);
        }
        for (PressInteraction.Press cancel : this.$currentKeyPressInteractions$inlined.values()) {
            this.$interactionSource$inlined.tryEmit(new PressInteraction.Cancel(cancel));
        }
        this.$currentKeyPressInteractions$inlined.clear();
    }
}
