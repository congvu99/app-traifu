package io.intercom.android.sdk.models;

import com.intercom.commons.utilities.CollectionUtils;
import io.intercom.android.sdk.blocks.lib.models.Author;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.models.Card;
import io.intercom.android.sdk.models.ReactionReply;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Link {
    public static final String ARTICLE_TYPE = "educate.article";
    public static final String HELP_CENTER_TYPE = "educate.help_center";
    public static final String SUGGESTION_TYPE = "educate.suggestion";

    public abstract List<Block> getBlocks();

    public abstract Card getCard();

    public abstract long getCreatedAt();

    public abstract String getId();

    public abstract ReactionReply getReactionReply();

    public abstract long getUpdatedAt();

    public static final class Builder {
        List<Block.Builder> blocks;
        Card.Builder card;
        long created_at;
        String id;
        ReactionReply.Builder reactions_reply;
        long updated_at;

        public Link build() {
            ReactionReply reactionReply;
            String str = this.id;
            if (str == null) {
                str = UUID.randomUUID().toString();
            }
            String str2 = str;
            ArrayList arrayList = new ArrayList(CollectionUtils.capacityFor(this.blocks));
            List<Block.Builder> list = this.blocks;
            if (list != null) {
                for (Block.Builder next : list) {
                    if (next != null) {
                        arrayList.add(next.build());
                    }
                }
            }
            ReactionReply.Builder builder = this.reactions_reply;
            if (builder == null) {
                reactionReply = ReactionReply.NULL;
            } else {
                reactionReply = builder.build();
            }
            ReactionReply reactionReply2 = reactionReply;
            Card.Builder builder2 = this.card;
            if (builder2 == null) {
                builder2 = new Card.Builder();
            }
            return new AutoValue_Link(str2, builder2.build(), arrayList, reactionReply2, this.created_at, this.updated_at);
        }
    }

    public String getTitle() {
        return getCard().getTitle();
    }

    public String getText() {
        return getCard().getText();
    }

    public String getType() {
        return getCard().getType();
    }

    public String getDescription() {
        return getCard().getDescription();
    }

    public Author getAuthor() {
        return getCard().getAuthor();
    }
}
