package com.google.accompanist.placeholder;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectorInfo;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.google.accompanist.placeholder.PlaceholderKt$placeholder-cf5BqRc$$inlined$debugInspectorInfo$1  reason: invalid class name */
/* compiled from: InspectableValue.kt */
public final class PlaceholderKt$placeholdercf5BqRc$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ long $color$inlined;
    final /* synthetic */ PlaceholderHighlight $highlight$inlined;
    final /* synthetic */ Shape $shape$inlined;
    final /* synthetic */ boolean $visible$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlaceholderKt$placeholdercf5BqRc$$inlined$debugInspectorInfo$1(boolean z, long j, PlaceholderHighlight placeholderHighlight, Shape shape) {
        super(1);
        this.$visible$inlined = z;
        this.$color$inlined = j;
        this.$highlight$inlined = placeholderHighlight;
        this.$shape$inlined = shape;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName(ReactTextInputShadowNode.PROP_PLACEHOLDER);
        inspectorInfo.setValue(Boolean.valueOf(this.$visible$inlined));
        inspectorInfo.getProperties().set(ViewProps.VISIBLE, Boolean.valueOf(this.$visible$inlined));
        inspectorInfo.getProperties().set("color", Color.m1922boximpl(this.$color$inlined));
        inspectorInfo.getProperties().set("highlight", this.$highlight$inlined);
        inspectorInfo.getProperties().set("shape", this.$shape$inlined);
    }
}
