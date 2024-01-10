package io.intercom.android.sdk.blocks.lib.interfaces;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import io.intercom.android.sdk.blocks.lib.BlockAlignment;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;

public interface LocalImageBlock {
    View addImage(Uri uri, int i, int i2, BlockAlignment blockAlignment, BlockMetadata blockMetadata, ViewGroup viewGroup);
}
