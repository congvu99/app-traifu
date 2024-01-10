package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.platform.InspectorInfo;
import com.brentvatne.react.ReactVideoView;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: InspectableValue.kt */
public final class DraggableKt$draggable$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ Function1 $canDrag$inlined;
    final /* synthetic */ boolean $enabled$inlined;
    final /* synthetic */ MutableInteractionSource $interactionSource$inlined;
    final /* synthetic */ Function3 $onDragStarted$inlined;
    final /* synthetic */ Function3 $onDragStopped$inlined;
    final /* synthetic */ Orientation $orientation$inlined;
    final /* synthetic */ boolean $reverseDirection$inlined;
    final /* synthetic */ Function0 $startDragImmediately$inlined;
    final /* synthetic */ DraggableState $state$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DraggableKt$draggable$$inlined$debugInspectorInfo$1(Function1 function1, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, Function0 function0, Function3 function3, Function3 function32, DraggableState draggableState) {
        super(1);
        this.$canDrag$inlined = function1;
        this.$orientation$inlined = orientation;
        this.$enabled$inlined = z;
        this.$reverseDirection$inlined = z2;
        this.$interactionSource$inlined = mutableInteractionSource;
        this.$startDragImmediately$inlined = function0;
        this.$onDragStarted$inlined = function3;
        this.$onDragStopped$inlined = function32;
        this.$state$inlined = draggableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("draggable");
        inspectorInfo.getProperties().set("canDrag", this.$canDrag$inlined);
        inspectorInfo.getProperties().set(ReactVideoView.EVENT_PROP_ORIENTATION, this.$orientation$inlined);
        inspectorInfo.getProperties().set(ViewProps.ENABLED, Boolean.valueOf(this.$enabled$inlined));
        inspectorInfo.getProperties().set("reverseDirection", Boolean.valueOf(this.$reverseDirection$inlined));
        inspectorInfo.getProperties().set("interactionSource", this.$interactionSource$inlined);
        inspectorInfo.getProperties().set("startDragImmediately", this.$startDragImmediately$inlined);
        inspectorInfo.getProperties().set("onDragStarted", this.$onDragStarted$inlined);
        inspectorInfo.getProperties().set("onDragStopped", this.$onDragStopped$inlined);
        inspectorInfo.getProperties().set("state", this.$state$inlined);
    }
}
