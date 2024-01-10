package com.github.scribejava.core.extractors;

import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.utils.Preconditions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OAuth2AccessTokenJsonExtractor implements TokenExtractor<OAuth2AccessToken> {
    private static final String ACCESS_TOKEN_REGEX = "\"access_token\"\\s*:\\s*\"(\\S*?)\"";
    private static final String EXPIRES_IN_REGEX = "\"expires_in\"\\s*:\\s*\"?(\\d*?)\"?\\D";
    private static final String REFRESH_TOKEN_REGEX = "\"refresh_token\"\\s*:\\s*\"(\\S*?)\"";
    private static final String SCOPE_REGEX = "\"scope\"\\s*:\\s*\"(\\S*?)\"";
    private static final String TOKEN_TYPE_REGEX = "\"token_type\"\\s*:\\s*\"(\\S*?)\"";

    protected OAuth2AccessTokenJsonExtractor() {
    }

    private static class InstanceHolder {
        /* access modifiers changed from: private */
        public static final OAuth2AccessTokenJsonExtractor INSTANCE = new OAuth2AccessTokenJsonExtractor();

        private InstanceHolder() {
        }
    }

    public static OAuth2AccessTokenJsonExtractor instance() {
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
        return createToken(extractParameter, extractParameter2, num, extractParameter(str, REFRESH_TOKEN_REGEX, false), extractParameter(str, SCOPE_REGEX, false), str);
    }

    /* access modifiers changed from: protected */
    public OAuth2AccessToken createToken(String str, String str2, Integer num, String str3, String str4, String str5) {
        return new OAuth2AccessToken(str, str2, num, str3, str4, str5);
    }

    protected static String extractParameter(String str, String str2, boolean z) throws OAuthException {
        Matcher matcher = Pattern.compile(str2).matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        if (!z) {
            return null;
        }
        throw new OAuthException("Response body is incorrect. Can't extract a '" + str2 + "' from this: '" + str + "'", (Exception) null);
    }
}
