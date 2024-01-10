package io.intercom.android.sdk.blocks.lib.interfaces;

import android.view.View;
import android.view.ViewGroup;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;

public interface MessengerCardBlock {
    View addCard(String str, String str2, BlockMetadata blockMetadata, ViewGroup viewGroup);
}
