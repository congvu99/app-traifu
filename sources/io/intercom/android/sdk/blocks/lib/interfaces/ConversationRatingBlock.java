package io.intercom.android.sdk.blocks.lib.interfaces;

import android.view.View;
import android.view.ViewGroup;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;
import io.intercom.android.sdk.blocks.lib.models.ConversationRating;

public interface ConversationRatingBlock {
    View addConversationRatingBlock(ConversationRating conversationRating, BlockMetadata blockMetadata, ViewGroup viewGroup);
}
