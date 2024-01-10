package io.intercom.android.sdk.survey.block;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.compose.ui.graphics.ColorKt;
import io.intercom.android.sdk.blocks.ViewHolderGenerator;
import io.intercom.android.sdk.blocks.lib.Blocks;
import io.intercom.android.sdk.blocks.lib.models.Block;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BlockView.kt */
final class BlockViewKt$RenderLegacyBlocks$1 extends Lambda implements Function1<Context, LinearLayout> {
    final /* synthetic */ Block $block;
    final /* synthetic */ Blocks $blocks;
    final /* synthetic */ ViewHolderGenerator $generator;
    final /* synthetic */ long $textColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BlockViewKt$RenderLegacyBlocks$1(Blocks blocks, Block block, ViewHolderGenerator viewHolderGenerator, long j) {
        super(1);
        this.$blocks = blocks;
        this.$block = block;
        this.$generator = viewHolderGenerator;
        this.$textColor = j;
    }

    public final LinearLayout invoke(Context context) {
        Intrinsics.checkNotNullParameter(context, "it");
        LinearLayout createBlocks = this.$blocks.createBlocks(CollectionsKt.listOf(this.$block), this.$generator.getPostHolder());
        Intrinsics.checkNotNullExpressionValue(createBlocks, "createBlocks");
        ViewGroup viewGroup = createBlocks;
        long j = this.$textColor;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
            if (childAt instanceof TextView) {
                ((TextView) childAt).setTextColor(Color.rgb((ColorKt.m1987toArgb8_81llA(j) >> 16) & 255, (ColorKt.m1987toArgb8_81llA(j) >> 8) & 255, ColorKt.m1987toArgb8_81llA(j) & 255));
            }
        }
        createBlocks.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return createBlocks;
    }
}
