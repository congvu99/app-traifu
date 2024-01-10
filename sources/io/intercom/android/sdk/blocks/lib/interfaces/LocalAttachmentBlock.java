package io.intercom.android.sdk.blocks.lib.interfaces;

import android.view.View;
import android.view.ViewGroup;
import io.intercom.android.sdk.blocks.lib.models.BlockAttachment;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;

public interface LocalAttachmentBlock {
    View addAttachment(BlockAttachment blockAttachment, BlockMetadata blockMetadata, ViewGroup viewGroup);
}
