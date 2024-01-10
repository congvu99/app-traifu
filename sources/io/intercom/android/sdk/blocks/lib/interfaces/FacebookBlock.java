package io.intercom.android.sdk.blocks.lib.interfaces;

import android.view.View;
import android.view.ViewGroup;
import io.intercom.android.sdk.blocks.lib.BlockAlignment;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;

public interface FacebookBlock {
    View addFacebookButton(String str, BlockAlignment blockAlignment, BlockMetadata blockMetadata, ViewGroup viewGroup);
}
