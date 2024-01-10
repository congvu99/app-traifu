package com.github.scribejava.core.model;

import java.util.Objects;
import kotlinx.serialization.json.internal.JsonLexerKt;

public class OAuth1AccessToken extends OAuth1Token {
    private static final long serialVersionUID = -103999293167210966L;

    public OAuth1AccessToken(String str, String str2) {
        this(str, str2, (String) null);
    }

    public OAuth1AccessToken(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public String getToken() {
        return super.getToken();
    }

    public String getTokenSecret() {
        return super.getTokenSecret();
    }

    public int hashCode() {
        return ((219 + Objects.hashCode(getToken())) * 73) + Objects.hashCode(getTokenSecret());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OAuth1AccessToken oAuth1AccessToken = (OAuth1AccessToken) obj;
        if (!Objects.equals(getToken(), oAuth1AccessToken.getToken())) {
            return false;
        }
        return Objects.equals(getTokenSecret(), oAuth1AccessToken.getTokenSecret());
    }

    public String toString() {
        return "OAuth1AccessToken{oauth_token=" + getToken() + ", oauth_token_secret=" + getTokenSecret() + JsonLexerKt.END_OBJ;
    }
}
