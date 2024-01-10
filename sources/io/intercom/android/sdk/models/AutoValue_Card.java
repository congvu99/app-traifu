package io.intercom.android.sdk.models;

import io.intercom.android.sdk.blocks.lib.models.Author;

final class AutoValue_Card extends Card {
    private final Author author;
    private final String description;
    private final String text;
    private final String title;
    private final String type;

    AutoValue_Card(String str, String str2, String str3, String str4, Author author2) {
        if (str != null) {
            this.type = str;
            if (str2 != null) {
                this.text = str2;
                if (str3 != null) {
                    this.title = str3;
                    if (str4 != null) {
                        this.description = str4;
                        if (author2 != null) {
                            this.author = author2;
                            return;
                        }
                        throw new NullPointerException("Null author");
                    }
                    throw new NullPointerException("Null description");
                }
                throw new NullPointerException("Null title");
            }
            throw new NullPointerException("Null text");
        }
        throw new NullPointerException("Null type");
    }

    public String getType() {
        return this.type;
    }

    public String getText() {
        return this.text;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public Author getAuthor() {
        return this.author;
    }

    public String toString() {
        return "Card{type=" + this.type + ", text=" + this.text + ", title=" + this.title + ", description=" + this.description + ", author=" + this.author + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Card)) {
            return false;
        }
        Card card = (Card) obj;
        if (!this.type.equals(card.getType()) || !this.text.equals(card.getText()) || !this.title.equals(card.getTitle()) || !this.description.equals(card.getDescription()) || !this.author.equals(card.getAuthor())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((((this.type.hashCode() ^ 1000003) * 1000003) ^ this.text.hashCode()) * 1000003) ^ this.title.hashCode()) * 1000003) ^ this.description.hashCode()) * 1000003) ^ this.author.hashCode();
    }
}
