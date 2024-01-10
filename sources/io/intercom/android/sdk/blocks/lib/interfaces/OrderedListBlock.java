package io.intercom.android.sdk.blocks.lib.interfaces;

import android.view.View;
import android.view.ViewGroup;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;
import java.util.List;

public interface OrderedListBlock {
    View addOrderedList(List<String> list, BlockMetadata blockMetadata, ViewGroup viewGroup);
}
