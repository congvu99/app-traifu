package com.github.scribejava.core.extractors;

import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.model.OAuth1Token;
import com.github.scribejava.core.utils.OAuthEncoder;
import com.github.scribejava.core.utils.Preconditions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractOAuth1TokenExtractor<T extends OAuth1Token> implements TokenExtractor<T> {
    private static final String OAUTH_TOKEN_REGEXP = "oauth_token=([^&]+)";
    private static final String OAUTH_TOKEN_SECRET_REGEXP = "oauth_token_secret=([^&]*)";

    /* access modifiers changed from: protected */
    public abstract T createToken(String str, String str2, String str3);

    public T extract(String str) {
        Preconditions.checkEmptyString(str, "Response body is incorrect. Can't extract a token from an empty string");
        return createToken(extract(str, Pattern.compile(OAUTH_TOKEN_REGEXP)), extract(str, Pattern.compile(OAUTH_TOKEN_SECRET_REGEXP)), str);
    }

    private String extract(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() >= 1) {
            return OAuthEncoder.decode(matcher.group(1));
        }
        throw new OAuthException("Response body is incorrect. Can't extract token and secret from this: '" + str + "'", (Exception) null);
    }
}
