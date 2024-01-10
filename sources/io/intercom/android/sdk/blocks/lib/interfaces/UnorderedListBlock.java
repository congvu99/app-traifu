package io.intercom.android.sdk.blocks.lib.interfaces;

import android.view.View;
import android.view.ViewGroup;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;
import java.util.List;

public interface UnorderedListBlock {
    View addUnorderedList(List<String> list, BlockMetadata blockMetadata, ViewGroup viewGroup);
}
