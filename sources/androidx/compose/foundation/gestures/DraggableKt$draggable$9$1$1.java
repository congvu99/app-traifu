package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Draggable.kt */
final class DraggableKt$draggable$9$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ MutableState<DragInteraction.Start> $draggedInteraction;
    final /* synthetic */ MutableInteractionSource $interactionSource;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DraggableKt$draggable$9$1$1(MutableState<DragInteraction.Start> mutableState, MutableInteractionSource mutableInteractionSource) {
        super(1);
        this.$draggedInteraction = mutableState;
        this.$interactionSource = mutableInteractionSource;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new DraggableKt$draggable$9$1$1$invoke$$inlined$onDispose$1(this.$draggedInteraction, this.$interactionSource);
    }
}
