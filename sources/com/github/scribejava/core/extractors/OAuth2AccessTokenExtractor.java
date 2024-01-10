package com.github.scribejava.core.extractors;

import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.utils.OAuthEncoder;
import com.github.scribejava.core.utils.Preconditions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OAuth2AccessTokenExtractor implements TokenExtractor<OAuth2AccessToken> {
    private static final String ACCESS_TOKEN_REGEX = "access_token=([^&]+)";
    private static final String EXPIRES_IN_REGEX = "expires_in=([^&]+)";
    private static final String REFRESH_TOKEN_REGEX = "refresh_token=([^&]+)";
    private static final String SCOPE_REGEX = "scope=([^&]+)";
    private static final String TOKEN_TYPE_REGEX = "token_type=([^&]+)";

    protected OAuth2AccessTokenExtractor() {
    }

    private static class InstanceHolder {
        /* access modifiers changed from: private */
        public static final OAuth2AccessTokenExtractor INSTANCE = new OAuth2AccessTokenExtractor();

        private InstanceHolder() {
        }
    }

    public static OAuth2AccessTokenExtractor instance() {
        return InstanceHolder.INSTANCE;
    }

    public OAuth2AccessToken extract(String str) {
        Preconditions.checkEmptyString(str, "Response body is incorrect. Can't extract a token from an empty string");
        String extractParameter = extractParameter(str, ACCESS_TOKEN_REGEX, true);
        String extractParameter2 = extractParameter(str, TOKEN_TYPE_REGEX, false);
        String extractParameter3 = extractParameter(str, EXPIRES_IN_REGEX, false);
        Integer num = null;
        if (extractParameter3 != null) {
            try {
                num = Integer.valueOf(extractParameter3);
            } catch (NumberFormatException unused) {
            }
        }
        return new OAuth2AccessToken(extractParameter, extractParameter2, num, extractParameter(str, REFRESH_TOKEN_REGEX, false), extractParameter(str, SCOPE_REGEX, false), str);
    }

    private static String extractParameter(String str, String str2, boolean z) throws OAuthException {
        Matcher matcher = Pattern.compile(str2).matcher(str);
        if (matcher.find()) {
            return OAuthEncoder.decode(matcher.group(1));
        }
        if (!z) {
            return null;
        }
        throw new OAuthException("Response body is incorrect. Can't extract a '" + str2 + "' from this: '" + str + "'", (Exception) null);
    }
}
