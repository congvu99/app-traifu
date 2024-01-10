package io.intercom.android.sdk.models;

import io.intercom.android.sdk.blocks.lib.models.Author;
import io.intercom.android.sdk.utilities.NullSafety;

public abstract class Card {
    public abstract Author getAuthor();

    public abstract String getDescription();

    public abstract String getText();

    public abstract String getTitle();

    public abstract String getType();

    public static Card create(String str, String str2, String str3, String str4, Author author) {
        return new AutoValue_Card(str, str2, str3, str4, author);
    }

    public static final class Builder {
        String articleId;
        Author.Builder author;
        String description;
        String linkType;
        String text;
        String title;
        String type;

        public Card build() {
            Author.Builder builder = this.author;
            if (builder == null) {
                builder = new Author.Builder();
            }
            return Card.create(NullSafety.valueOrEmpty(this.type), NullSafety.valueOrEmpty(this.text), NullSafety.valueOrEmpty(this.title), NullSafety.valueOrEmpty(this.description), builder.build());
        }
    }
}
