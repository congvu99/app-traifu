package io.intercom.android.sdk.blocks;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import io.intercom.android.sdk.blocks.lib.BlocksViewHolder;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;
import io.intercom.android.sdk.models.carousel.Appearance;
import io.intercom.android.sdk.models.carousel.CarouselScreen;
import java.util.List;

public class ContentLayoutManager {
    private final BlocksViewHolder blocksViewHolder;
    private final Context context;

    public ContentLayoutManager(Context context2, BlocksViewHolder blocksViewHolder2) {
        this.context = context2;
        this.blocksViewHolder = blocksViewHolder2;
    }

    public void renderCarouselScreen(CarouselScreen carouselScreen, FrameLayout frameLayout) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.context).inflate(this.blocksViewHolder.getLayout(), frameLayout, false);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.gravity = carouselScreen.getGravity();
        linearLayout.setLayoutParams(layoutParams);
        frameLayout.addView(linearLayout);
        renderContent(carouselScreen.getBlocks(), carouselScreen.getTextColor(), linearLayout);
    }

    /* access modifiers changed from: package-private */
    public void renderContent(List<Block> list, String str, LinearLayout linearLayout) {
        for (Block renderBlock : list) {
            renderBlock(renderBlock, str, linearLayout);
        }
    }

    /* access modifiers changed from: package-private */
    public void renderBlock(Block block, String str, LinearLayout linearLayout) {
        linearLayout.addView(block.getType().getView(this.blocksViewHolder, block, linearLayout, new BlockMetadata.Builder().withAppearance(new Appearance.Builder().withTextColor(str)).build()));
    }
}
