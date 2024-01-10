package com.github.scribejava.core.model;

import java.util.Objects;
import kotlinx.serialization.json.internal.JsonLexerKt;

public class OAuth1RequestToken extends OAuth1Token {
    private static final long serialVersionUID = 6185104114662587991L;
    private final boolean oauthCallbackConfirmed;

    public OAuth1RequestToken(String str, String str2) {
        this(str, str2, (String) null);
    }

    public OAuth1RequestToken(String str, String str2, String str3) {
        this(str, str2, true, str3);
    }

    public OAuth1RequestToken(String str, String str2, boolean z, String str3) {
        super(str, str2, str3);
        this.oauthCallbackConfirmed = z;
    }

    public String getToken() {
        return super.getToken();
    }

    public String getTokenSecret() {
        return super.getTokenSecret();
    }

    public boolean isOauthCallbackConfirmed() {
        return this.oauthCallbackConfirmed;
    }

    public int hashCode() {
        return ((((581 + Objects.hashCode(getToken())) * 83) + Objects.hashCode(getTokenSecret())) * 83) + (this.oauthCallbackConfirmed ? 1 : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OAuth1RequestToken oAuth1RequestToken = (OAuth1RequestToken) obj;
        if (this.oauthCallbackConfirmed == oAuth1RequestToken.isOauthCallbackConfirmed() && Objects.equals(getToken(), oAuth1RequestToken.getToken())) {
            return Objects.equals(getTokenSecret(), oAuth1RequestToken.getTokenSecret());
        }
        return false;
    }

    public String toString() {
        return "OAuth1RequestToken{oauth_token=" + getToken() + ", oauth_token_secret=" + getTokenSecret() + ", oauth_callback_confirmed=" + this.oauthCallbackConfirmed + JsonLexerKt.END_OBJ;
    }
}
