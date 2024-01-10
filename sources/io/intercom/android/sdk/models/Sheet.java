package io.intercom.android.sdk.models;

import com.google.gson.JsonObject;

public class Sheet {
    private final String body;

    Sheet(Builder builder) {
        this.body = builder.sheet_request_body == null ? "" : builder.sheet_request_body.toString();
    }

    public String getBody() {
        return this.body;
    }

    public static final class Builder {
        JsonObject sheet_request_body;
        String sheet_title;

        public Sheet build() {
            return new Sheet(this);
        }
    }
}
