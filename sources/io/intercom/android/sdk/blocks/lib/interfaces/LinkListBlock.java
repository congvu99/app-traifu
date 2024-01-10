package io.intercom.android.sdk.blocks.lib.interfaces;

import android.view.View;
import android.view.ViewGroup;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;
import io.intercom.android.sdk.blocks.lib.models.LinkList;

public interface LinkListBlock {
    View addLinkListBlock(LinkList linkList, BlockMetadata blockMetadata, ViewGroup viewGroup);
}
