package io.intercom.android.sdk.blocks.lib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;
import io.intercom.android.sdk.models.carousel.Appearance;
import java.util.List;

public class Blocks {
    private final Appearance appearance;
    private final LayoutInflater inflater;
    private final Twig twig;

    public Blocks(Context context, Twig twig2) {
        this.inflater = LayoutInflater.from(context);
        this.twig = twig2;
        this.appearance = Appearance.NULL;
    }

    public Blocks(Context context, Twig twig2, Appearance appearance2) {
        this.inflater = LayoutInflater.from(context);
        this.twig = twig2;
        this.appearance = appearance2;
    }

    public LinearLayout createBlocks(List<Block> list, BlocksViewHolder blocksViewHolder) {
        LinearLayout linearLayout = (LinearLayout) this.inflater.inflate(blocksViewHolder.getLayout(), (ViewGroup) null);
        if (list != null) {
            int i = 0;
            while (i < list.size()) {
                Block block = list.get(i);
                try {
                    linearLayout.addView(block.getType().getView(blocksViewHolder, block, linearLayout, new BlockMetadata.Builder().withAppearance(this.appearance.toBuilder()).isFirstObject(Boolean.valueOf(i == 0)).isLastObject(Boolean.valueOf(i == list.size() - 1)).build()));
                } catch (BlockTypeNotImplementedException e) {
                    this.twig.e(e, "Error creating view for block with type %s ", block.getType());
                }
                i++;
            }
        }
        return linearLayout;
    }
}
