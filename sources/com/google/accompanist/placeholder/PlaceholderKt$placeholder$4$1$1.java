package com.google.accompanist.placeholder;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Placeholder.kt */
final class PlaceholderKt$placeholder$4$1$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ long $color;
    final /* synthetic */ State<Float> $contentAlpha$delegate;
    final /* synthetic */ PlaceholderHighlight $highlight;
    final /* synthetic */ MutableState<Float> $highlightProgress$delegate;
    final /* synthetic */ Ref<LayoutDirection> $lastLayoutDirection;
    final /* synthetic */ Ref<Outline> $lastOutline;
    final /* synthetic */ Ref<Size> $lastSize;
    final /* synthetic */ Paint $paint;
    final /* synthetic */ State<Float> $placeholderAlpha$delegate;
    final /* synthetic */ Shape $shape;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlaceholderKt$placeholder$4$1$1(Paint paint, Ref<Outline> ref, Shape shape, long j, PlaceholderHighlight placeholderHighlight, Ref<LayoutDirection> ref2, Ref<Size> ref3, State<Float> state, State<Float> state2, MutableState<Float> mutableState) {
        super(1);
        this.$paint = paint;
        this.$lastOutline = ref;
        this.$shape = shape;
        this.$color = j;
        this.$highlight = placeholderHighlight;
        this.$lastLayoutDirection = ref2;
        this.$lastSize = ref3;
        this.$contentAlpha$delegate = state;
        this.$placeholderAlpha$delegate = state2;
        this.$highlightProgress$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "$this$drawWithContent");
        float r0 = PlaceholderKt$placeholder$4.m5069invoke$lambda11(this.$contentAlpha$delegate);
        boolean z = true;
        if (0.01f <= r0 && r0 <= 0.99f) {
            this.$paint.setAlpha(PlaceholderKt$placeholder$4.m5069invoke$lambda11(this.$contentAlpha$delegate));
            DrawScope drawScope = contentDrawScope;
            Paint paint = this.$paint;
            Canvas canvas = drawScope.getDrawContext().getCanvas();
            canvas.saveLayer(SizeKt.m1773toRectuvyYCjk(drawScope.m2478getSizeNHjbRc()), paint);
            contentDrawScope.drawContent();
            canvas.restore();
        } else if (PlaceholderKt$placeholder$4.m5069invoke$lambda11(this.$contentAlpha$delegate) >= 0.99f) {
            contentDrawScope.drawContent();
        }
        float r02 = PlaceholderKt$placeholder$4.m5072invoke$lambda9(this.$placeholderAlpha$delegate);
        if (0.01f > r02 || r02 > 0.99f) {
            z = false;
        }
        if (z) {
            this.$paint.setAlpha(PlaceholderKt$placeholder$4.m5072invoke$lambda9(this.$placeholderAlpha$delegate));
            DrawScope drawScope2 = contentDrawScope;
            Paint paint2 = this.$paint;
            Ref<Outline> ref = this.$lastOutline;
            Shape shape = this.$shape;
            long j = this.$color;
            PlaceholderHighlight placeholderHighlight = this.$highlight;
            Ref<LayoutDirection> ref2 = this.$lastLayoutDirection;
            Ref<Size> ref3 = this.$lastSize;
            MutableState<Float> mutableState = this.$highlightProgress$delegate;
            Canvas canvas2 = drawScope2.getDrawContext().getCanvas();
            canvas2.saveLayer(SizeKt.m1773toRectuvyYCjk(drawScope2.m2478getSizeNHjbRc()), paint2);
            ref.setValue(PlaceholderKt.m5063drawPlaceholderhpmOzss(drawScope2, shape, j, placeholderHighlight, PlaceholderKt$placeholder$4.m5070invoke$lambda4(mutableState), ref.getValue(), ref2.getValue(), ref3.getValue()));
            canvas2.restore();
        } else if (PlaceholderKt$placeholder$4.m5072invoke$lambda9(this.$placeholderAlpha$delegate) >= 0.99f) {
            this.$lastOutline.setValue(PlaceholderKt.m5063drawPlaceholderhpmOzss(contentDrawScope, this.$shape, this.$color, this.$highlight, PlaceholderKt$placeholder$4.m5070invoke$lambda4(this.$highlightProgress$delegate), this.$lastOutline.getValue(), this.$lastLayoutDirection.getValue(), this.$lastSize.getValue()));
        }
        this.$lastSize.setValue(Size.m1740boximpl(contentDrawScope.m2478getSizeNHjbRc()));
        this.$lastLayoutDirection.setValue(contentDrawScope.getLayoutDirection());
    }
}
