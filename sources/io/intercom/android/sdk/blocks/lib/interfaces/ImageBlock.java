package io.intercom.android.sdk.blocks.lib.interfaces;

import android.view.View;
import android.view.ViewGroup;
import io.intercom.android.sdk.blocks.lib.BlockAlignment;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;

public interface ImageBlock {
    View addImage(String str, String str2, String str3, int i, int i2, BlockAlignment blockAlignment, BlockMetadata blockMetadata, ViewGroup viewGroup);
}
