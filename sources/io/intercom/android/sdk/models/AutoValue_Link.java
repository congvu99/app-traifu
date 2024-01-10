package io.intercom.android.sdk.models;

import io.intercom.android.sdk.blocks.lib.models.Block;
import java.util.List;

final class AutoValue_Link extends Link {
    private final List<Block> blocks;
    private final Card card;
    private final long createdAt;
    private final String id;
    private final ReactionReply reactionReply;
    private final long updatedAt;

    AutoValue_Link(String str, Card card2, List<Block> list, ReactionReply reactionReply2, long j, long j2) {
        if (str != null) {
            this.id = str;
            if (card2 != null) {
                this.card = card2;
                if (list != null) {
                    this.blocks = list;
                    if (reactionReply2 != null) {
                        this.reactionReply = reactionReply2;
                        this.createdAt = j;
                        this.updatedAt = j2;
                        return;
                    }
                    throw new NullPointerException("Null reactionReply");
                }
                throw new NullPointerException("Null blocks");
            }
            throw new NullPointerException("Null card");
        }
        throw new NullPointerException("Null id");
    }

    public String getId() {
        return this.id;
    }

    public Card getCard() {
        return this.card;
    }

    public List<Block> getBlocks() {
        return this.blocks;
    }

    public ReactionReply getReactionReply() {
        return this.reactionReply;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public String toString() {
        return "Link{id=" + this.id + ", card=" + this.card + ", blocks=" + this.blocks + ", reactionReply=" + this.reactionReply + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Link)) {
            return false;
        }
        Link link = (Link) obj;
        if (!this.id.equals(link.getId()) || !this.card.equals(link.getCard()) || !this.blocks.equals(link.getBlocks()) || !this.reactionReply.equals(link.getReactionReply()) || this.createdAt != link.getCreatedAt() || this.updatedAt != link.getUpdatedAt()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.createdAt;
        long j2 = this.updatedAt;
        return ((((((((((this.id.hashCode() ^ 1000003) * 1000003) ^ this.card.hashCode()) * 1000003) ^ this.blocks.hashCode()) * 1000003) ^ this.reactionReply.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }
}
