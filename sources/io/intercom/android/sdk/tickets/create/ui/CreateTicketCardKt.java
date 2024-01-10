package io.intercom.android.sdk.tickets.create.ui;

import android.content.Context;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.Colors;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import io.intercom.android.sdk.blocks.lib.BlockType;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.blocks.lib.models.TicketType;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.survey.block.BlockRenderData;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a'\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010\r\u001a\r\u0010\u000e\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010\r\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"sampleBlock", "Lio/intercom/android/sdk/blocks/lib/models/Block;", "kotlin.jvm.PlatformType", "CreateTicketCard", "", "modifier", "Landroidx/compose/ui/Modifier;", "blockRenderData", "Lio/intercom/android/sdk/survey/block/BlockRenderData;", "enabled", "", "(Landroidx/compose/ui/Modifier;Lio/intercom/android/sdk/survey/block/BlockRenderData;ZLandroidx/compose/runtime/Composer;II)V", "DisabledCreateTicketCardPreview", "(Landroidx/compose/runtime/Composer;I)V", "EnabledCreateTicketCardPreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: CreateTicketCard.kt */
public final class CreateTicketCardKt {
    /* access modifiers changed from: private */
    public static final Block sampleBlock = new Block.Builder().withType(BlockType.CREATETICKETCARD.getSerializedName()).withText("Admin has requested you to create a ticket").withTitle("Create ticket").withTicketTypeTitle("Bug").withTicketType(new TicketType(1234, "Bug", "🎟", CollectionsKt.emptyList())).build();

    public static final void CreateTicketCard(Modifier modifier, BlockRenderData blockRenderData, boolean z, Composer composer, int i, int i2) {
        BlockRenderData blockRenderData2 = blockRenderData;
        Intrinsics.checkNotNullParameter(blockRenderData2, "blockRenderData");
        Composer startRestartGroup = composer.startRestartGroup(1412563435);
        Modifier modifier2 = (i2 & 1) != 0 ? Modifier.Companion : modifier;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        CardKt.m1177CardFjzlyU(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, (Object) null), (Shape) null, 0, 0, BorderStrokeKt.m191BorderStrokecXLIe8U(Dp.m4704constructorimpl((float) 0.5d), Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Dp.m4704constructorimpl((float) 2), ComposableLambdaKt.composableLambda(startRestartGroup, -1144264114, true, new CreateTicketCardKt$CreateTicketCard$1(z, blockRenderData2, (Context) consume, i)), startRestartGroup, 1769472, 14);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CreateTicketCardKt$CreateTicketCard$2(modifier2, blockRenderData, z, i, i2));
        }
    }

    /* access modifiers changed from: private */
    public static final void EnabledCreateTicketCardPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1535832576);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$CreateTicketCardKt.INSTANCE.m5387getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CreateTicketCardKt$EnabledCreateTicketCardPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void DisabledCreateTicketCardPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1443652823);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$CreateTicketCardKt.INSTANCE.m5388getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CreateTicketCardKt$DisabledCreateTicketCardPreview$1(i));
        }
    }
}
