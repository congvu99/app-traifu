package io.intercom.android.sdk.models;

import io.intercom.android.sdk.models.BaseResponse;
import io.intercom.android.sdk.models.Link;

public class LinkResponse extends BaseResponse {
    private final Link link;

    LinkResponse(Builder builder) {
        super(builder);
        Link link2;
        if (builder.article == null) {
            link2 = new Link.Builder().build();
        } else {
            link2 = builder.article.build();
        }
        this.link = link2;
    }

    public Link getLink() {
        return this.link;
    }

    public static final class Builder extends BaseResponse.Builder {
        Link.Builder article;

        public LinkResponse build() {
            return new LinkResponse(this);
        }
    }
}
