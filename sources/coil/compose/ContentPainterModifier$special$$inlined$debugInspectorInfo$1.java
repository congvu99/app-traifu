package coil.compose;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: InspectableValue.kt */
public final class ContentPainterModifier$special$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ Alignment $alignment$inlined;
    final /* synthetic */ float $alpha$inlined;
    final /* synthetic */ ColorFilter $colorFilter$inlined;
    final /* synthetic */ ContentScale $contentScale$inlined;
    final /* synthetic */ Painter $painter$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContentPainterModifier$special$$inlined$debugInspectorInfo$1(Painter painter, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        super(1);
        this.$painter$inlined = painter;
        this.$alignment$inlined = alignment;
        this.$contentScale$inlined = contentScale;
        this.$alpha$inlined = f;
        this.$colorFilter$inlined = colorFilter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("content");
        inspectorInfo.getProperties().set("painter", this.$painter$inlined);
        inspectorInfo.getProperties().set("alignment", this.$alignment$inlined);
        inspectorInfo.getProperties().set("contentScale", this.$contentScale$inlined);
        inspectorInfo.getProperties().set("alpha", Float.valueOf(this.$alpha$inlined));
        inspectorInfo.getProperties().set("colorFilter", this.$colorFilter$inlined);
    }
}
