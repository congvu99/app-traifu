package io.intercom.android.sdk.blocks.lib.interfaces;

import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;

public interface ImageTextBlock {
    View addImageText(Spanned spanned, Spanned spanned2, String str, String str2, int i, int i2, BlockMetadata blockMetadata, ViewGroup viewGroup);
}
