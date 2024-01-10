package io.intercom.android.sdk.views.compose;

import android.view.ViewGroup;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.font.FontWeight;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.survey.block.BlockRenderData;
import io.intercom.android.sdk.survey.block.BlockViewKt;
import io.intercom.android.sdk.survey.block.SuffixText;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: MessageRow.kt */
final class MessageRowKt$MessageRow$2$2 extends Lambda implements Function4<ColumnScope, Color, Composer, Integer, Unit> {
    final /* synthetic */ Shape $bubbleShape;
    final /* synthetic */ Part $conversationPart;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ List<ViewGroup> $legacyBlocks;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageRowKt$MessageRow$2$2(Part part, Shape shape, List<? extends ViewGroup> list, boolean z) {
        super(4);
        this.$conversationPart = part;
        this.$bubbleShape = shape;
        this.$legacyBlocks = list;
        this.$enabled = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        m5412invokeRPmYEkk((ColumnScope) obj, ((Color) obj2).m1942unboximpl(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-RPmYEkk  reason: not valid java name */
    public final void m5412invokeRPmYEkk(ColumnScope columnScope, long j, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(columnScope, "$this$MessageBubbleRow");
        if ((i & 112) == 0) {
            i2 = i | (composer.changed(j) ? 32 : 16);
        } else {
            long j2 = j;
            Composer composer2 = composer;
            i2 = i;
        }
        if ((i2 & 721) != 144 || !composer.getSkipping()) {
            List<Block> blocks = this.$conversationPart.getBlocks();
            Intrinsics.checkNotNullExpressionValue(blocks, "conversationPart.blocks");
            Shape shape = this.$bubbleShape;
            List<ViewGroup> list = this.$legacyBlocks;
            boolean z = this.$enabled;
            int i3 = 0;
            for (Object next : blocks) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Block block = (Block) next;
                Intrinsics.checkNotNullExpressionValue(block, "block");
                BlockViewKt.m5297BlockViewFU0evQE(ClipKt.clip(Modifier.Companion, shape), new BlockRenderData(block, Color.m1922boximpl(j), 0, 0, (FontWeight) null, (Color) null, 0, 0, (FontWeight) null, (Color) null, 0, 2044, (DefaultConstructorMarker) null), 0, (SuffixText) null, z, list != null ? (ViewGroup) CollectionsKt.getOrNull(list, i3) : null, composer, 262208, 12);
                i3 = i4;
                z = z;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
