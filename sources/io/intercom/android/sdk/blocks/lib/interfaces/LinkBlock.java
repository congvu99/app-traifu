package io.intercom.android.sdk.blocks.lib.interfaces;

import android.view.View;
import android.view.ViewGroup;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;
import io.intercom.android.sdk.blocks.lib.models.Link;

public interface LinkBlock {
    View addLinkBlock(Link link, BlockMetadata blockMetadata, ViewGroup viewGroup);
}
