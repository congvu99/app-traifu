package io.intercom.android.sdk.blocks;

import io.intercom.android.sdk.blocks.lib.BlockType;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.blocks.logic.TextSplittingStrategy;
import java.util.ArrayList;
import java.util.List;

public class BlockFactory {
    private final TextSplittingStrategy textSplittingStrategy;

    public BlockFactory(TextSplittingStrategy textSplittingStrategy2) {
        this.textSplittingStrategy = textSplittingStrategy2;
    }

    public List<Block.Builder> getBlocksForText(String str) {
        List<String> apply = this.textSplittingStrategy.apply(str);
        int size = apply.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new Block.Builder().withType(BlockType.PARAGRAPH.name().toLowerCase()).withText(apply.get(i)));
        }
        return arrayList;
    }
}
