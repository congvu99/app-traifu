package com.github.scribejava.core.model;

import com.github.scribejava.core.utils.Preconditions;

public abstract class OAuth1Token extends Token {
    private static final long serialVersionUID = 6285873427974823019L;
    private final String token;
    private final String tokenSecret;

    public OAuth1Token(String str, String str2, String str3) {
        super(str3);
        Preconditions.checkNotNull(str, "oauth_token can't be null");
        Preconditions.checkNotNull(str2, "oauth_token_secret can't be null");
        this.token = str;
        this.tokenSecret = str2;
    }

    public String getToken() {
        return this.token;
    }

    public String getTokenSecret() {
        return this.tokenSecret;
    }

    public boolean isEmpty() {
        return "".equals(this.token) && "".equals(this.tokenSecret);
    }
}
