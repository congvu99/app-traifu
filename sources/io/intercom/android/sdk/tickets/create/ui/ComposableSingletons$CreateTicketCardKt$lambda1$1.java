package io.intercom.android.sdk.tickets.create.ui;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.font.FontWeight;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.survey.block.BlockRenderData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.tickets.create.ui.ComposableSingletons$CreateTicketCardKt$lambda-1$1  reason: invalid class name */
/* compiled from: CreateTicketCard.kt */
final class ComposableSingletons$CreateTicketCardKt$lambda1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$CreateTicketCardKt$lambda1$1 INSTANCE = new ComposableSingletons$CreateTicketCardKt$lambda1$1();

    ComposableSingletons$CreateTicketCardKt$lambda1$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Block access$getSampleBlock$p = CreateTicketCardKt.sampleBlock;
            Intrinsics.checkNotNullExpressionValue(access$getSampleBlock$p, "sampleBlock");
            CreateTicketCardKt.CreateTicketCard(fillMaxWidth$default, new BlockRenderData(access$getSampleBlock$p, (Color) null, 0, 0, (FontWeight) null, (Color) null, 0, 0, (FontWeight) null, (Color) null, 0, 2046, (DefaultConstructorMarker) null), true, composer, 454, 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
