package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import com.brentvatne.react.ReactVideoView;
import com.facebook.react.uimanager.ViewProps;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: androidx.compose.material.SwipeableKt$swipeable-pPrIpRY$$inlined$debugInspectorInfo$1  reason: invalid class name */
/* compiled from: InspectableValue.kt */
public final class SwipeableKt$swipeablepPrIpRY$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ Map $anchors$inlined;
    final /* synthetic */ boolean $enabled$inlined;
    final /* synthetic */ MutableInteractionSource $interactionSource$inlined;
    final /* synthetic */ Orientation $orientation$inlined;
    final /* synthetic */ ResistanceConfig $resistance$inlined;
    final /* synthetic */ boolean $reverseDirection$inlined;
    final /* synthetic */ SwipeableState $state$inlined;
    final /* synthetic */ Function2 $thresholds$inlined;
    final /* synthetic */ float $velocityThreshold$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableKt$swipeablepPrIpRY$$inlined$debugInspectorInfo$1(SwipeableState swipeableState, Map map, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, Function2 function2, ResistanceConfig resistanceConfig, float f) {
        super(1);
        this.$state$inlined = swipeableState;
        this.$anchors$inlined = map;
        this.$orientation$inlined = orientation;
        this.$enabled$inlined = z;
        this.$reverseDirection$inlined = z2;
        this.$interactionSource$inlined = mutableInteractionSource;
        this.$thresholds$inlined = function2;
        this.$resistance$inlined = resistanceConfig;
        this.$velocityThreshold$inlined = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("swipeable");
        inspectorInfo.getProperties().set("state", this.$state$inlined);
        inspectorInfo.getProperties().set("anchors", this.$anchors$inlined);
        inspectorInfo.getProperties().set(ReactVideoView.EVENT_PROP_ORIENTATION, this.$orientation$inlined);
        inspectorInfo.getProperties().set(ViewProps.ENABLED, Boolean.valueOf(this.$enabled$inlined));
        inspectorInfo.getProperties().set("reverseDirection", Boolean.valueOf(this.$reverseDirection$inlined));
        inspectorInfo.getProperties().set("interactionSource", this.$interactionSource$inlined);
        inspectorInfo.getProperties().set("thresholds", this.$thresholds$inlined);
        inspectorInfo.getProperties().set("resistance", this.$resistance$inlined);
        inspectorInfo.getProperties().set("velocityThreshold", Dp.m4702boximpl(this.$velocityThreshold$inlined));
    }
}
