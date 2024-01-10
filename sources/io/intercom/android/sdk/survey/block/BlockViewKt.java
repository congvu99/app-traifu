package io.intercom.android.sdk.survey.block;

import android.content.Context;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.ButtonClickListener;
import io.intercom.android.sdk.blocks.CarouselImageClickListener;
import io.intercom.android.sdk.blocks.UploadingImageCache;
import io.intercom.android.sdk.blocks.ViewHolderGenerator;
import io.intercom.android.sdk.blocks.lib.BlockType;
import io.intercom.android.sdk.blocks.lib.Blocks;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.FeatureFlag;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.m5.components.BlocksLayoutCardKt;
import io.intercom.android.sdk.m5.home.components.LegacyMessengerAppCardKt;
import io.intercom.android.sdk.tickets.create.ui.CreateTicketCardKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aQ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a%\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"BlockView", "", "modifier", "Landroidx/compose/ui/Modifier;", "blockRenderData", "Lio/intercom/android/sdk/survey/block/BlockRenderData;", "textColor", "Landroidx/compose/ui/graphics/Color;", "suffixText", "Lio/intercom/android/sdk/survey/block/SuffixText;", "enabled", "", "blocksLayout", "Landroid/view/ViewGroup;", "BlockView-FU0evQE", "(Landroidx/compose/ui/Modifier;Lio/intercom/android/sdk/survey/block/BlockRenderData;JLio/intercom/android/sdk/survey/block/SuffixText;ZLandroid/view/ViewGroup;Landroidx/compose/runtime/Composer;II)V", "RenderLegacyBlocks", "block", "Lio/intercom/android/sdk/blocks/lib/models/Block;", "RenderLegacyBlocks-RPmYEkk", "(Lio/intercom/android/sdk/blocks/lib/models/Block;JLandroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: BlockView.kt */
public final class BlockViewKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BlockView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BlockType.values().length];
            iArr[BlockType.IMAGE.ordinal()] = 1;
            iArr[BlockType.PARAGRAPH.ordinal()] = 2;
            iArr[BlockType.HEADING.ordinal()] = 3;
            iArr[BlockType.SUBHEADING.ordinal()] = 4;
            iArr[BlockType.CREATETICKETCARD.ordinal()] = 5;
            iArr[BlockType.MESSENGERCARD.ordinal()] = 6;
            iArr[BlockType.CODE.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: BlockView-FU0evQE  reason: not valid java name */
    public static final void m5297BlockViewFU0evQE(Modifier modifier, BlockRenderData blockRenderData, long j, SuffixText suffixText, boolean z, ViewGroup viewGroup, Composer composer, int i, int i2) {
        BlockRenderData blockRenderData2 = blockRenderData;
        Intrinsics.checkNotNullParameter(blockRenderData, "blockRenderData");
        Composer startRestartGroup = composer.startRestartGroup(1111036664);
        Modifier modifier2 = (i2 & 1) != 0 ? Modifier.Companion : modifier;
        long r3 = (i2 & 4) != 0 ? Color.Companion.m1958getBlack0d7_KjU() : j;
        SuffixText no_suffix = (i2 & 8) != 0 ? SuffixText.Companion.getNO_SUFFIX() : suffixText;
        boolean z2 = (i2 & 16) != 0 ? true : z;
        Unit unit = null;
        ViewGroup viewGroup2 = (i2 & 32) != 0 ? null : viewGroup;
        Block block = blockRenderData.getBlock();
        if (Injector.isNotInitialised() || !Injector.get().getAppConfigProvider().get().hasFeature(FeatureFlag.BLOCK_RENDERING_FALLBACK)) {
            startRestartGroup.startReplaceableGroup(1485044140);
            BlockType type = block.getType();
            switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    startRestartGroup.startReplaceableGroup(1485044201);
                    ImageBlockKt.ImageBlock(block, modifier2, startRestartGroup, ((i << 3) & 112) | 8);
                    startRestartGroup.endReplaceableGroup();
                    break;
                case 2:
                    startRestartGroup.startReplaceableGroup(1485044283);
                    TextBlockKt.TextBlock(modifier2, blockRenderData, no_suffix, startRestartGroup, (i & 14) | 64 | ((i >> 3) & 896), 0);
                    startRestartGroup.endReplaceableGroup();
                    break;
                case 3:
                    startRestartGroup.startReplaceableGroup(1485044469);
                    TextBlockKt.TextBlock(modifier2, blockRenderData, no_suffix, startRestartGroup, (i & 14) | 64 | ((i >> 3) & 896), 0);
                    startRestartGroup.endReplaceableGroup();
                    break;
                case 4:
                    startRestartGroup.startReplaceableGroup(1485044658);
                    TextBlockKt.TextBlock(modifier2, blockRenderData, no_suffix, startRestartGroup, (i & 14) | 64 | ((i >> 3) & 896), 0);
                    startRestartGroup.endReplaceableGroup();
                    break;
                case 5:
                    startRestartGroup.startReplaceableGroup(1485044853);
                    CreateTicketCardKt.CreateTicketCard(Modifier.Companion, blockRenderData, z2, startRestartGroup, ((i >> 6) & 896) | 70, 0);
                    startRestartGroup.endReplaceableGroup();
                    break;
                case 6:
                    startRestartGroup.startReplaceableGroup(1485045046);
                    startRestartGroup.startReplaceableGroup(1485045060);
                    if (viewGroup2 != null) {
                        BlocksLayoutCardKt.BlocksLayoutCard(viewGroup2, startRestartGroup, 8);
                        unit = Unit.INSTANCE;
                    }
                    startRestartGroup.endReplaceableGroup();
                    if (unit == null) {
                        String fallbackUrl = block.getFallbackUrl();
                        Intrinsics.checkNotNullExpressionValue(fallbackUrl, "block.fallbackUrl");
                        LegacyMessengerAppCardKt.LegacyMessengerAppCard(fallbackUrl, startRestartGroup, 0);
                    }
                    startRestartGroup.endReplaceableGroup();
                    break;
                case 7:
                    startRestartGroup.startReplaceableGroup(1485045201);
                    CodeBlockKt.CodeBlock(block, modifier2, startRestartGroup, ((i << 3) & 112) | 8, 0);
                    startRestartGroup.endReplaceableGroup();
                    break;
                default:
                    startRestartGroup.startReplaceableGroup(1485045935);
                    if (!Injector.isNotInitialised()) {
                        m5298RenderLegacyBlocksRPmYEkk(block, r3, startRestartGroup, ((i >> 3) & 112) | 8);
                    }
                    startRestartGroup.endReplaceableGroup();
                    break;
            }
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(1485044082);
            m5298RenderLegacyBlocksRPmYEkk(block, r3, startRestartGroup, ((i >> 3) & 112) | 8);
            startRestartGroup.endReplaceableGroup();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BlockViewKt$BlockView$2(modifier2, blockRenderData, r3, no_suffix, z2, viewGroup2, i, i2));
        }
    }

    /* renamed from: RenderLegacyBlocks-RPmYEkk  reason: not valid java name */
    public static final void m5298RenderLegacyBlocksRPmYEkk(Block block, long j, Composer composer, int i) {
        Block block2 = block;
        Intrinsics.checkNotNullParameter(block2, "block");
        Composer startRestartGroup = composer.startRestartGroup(-1903827898);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Context context = (Context) consume;
        Blocks blocks = new Blocks(context, LumberMill.getBlocksTwig());
        UploadingImageCache uploadingImageCache = new UploadingImageCache();
        Api api = Injector.get().getApi();
        Provider<AppConfig> appConfigProvider = Injector.get().getAppConfigProvider();
        Api api2 = Injector.get().getApi();
        Intrinsics.checkNotNullExpressionValue(api2, "get().api");
        AndroidView_androidKt.AndroidView(new BlockViewKt$RenderLegacyBlocks$1(blocks, block, new ViewHolderGenerator(uploadingImageCache, api, appConfigProvider, "", new CarouselImageClickListener(api2), (ButtonClickListener) null, Injector.get().getGson(), Injector.get().getBus(), Injector.get().getMetricTracker(), context), j), (Modifier) null, (Function1) null, startRestartGroup, 0, 6);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BlockViewKt$RenderLegacyBlocks$2(block2, j, i));
        }
    }
}
