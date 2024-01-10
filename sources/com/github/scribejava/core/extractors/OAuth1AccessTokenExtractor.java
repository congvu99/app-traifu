package com.github.scribejava.core.extractors;

import com.github.scribejava.core.model.OAuth1AccessToken;

public class OAuth1AccessTokenExtractor extends AbstractOAuth1TokenExtractor<OAuth1AccessToken> {
    protected OAuth1AccessTokenExtractor() {
    }

    private static class InstanceHolder {
        /* access modifiers changed from: private */
        public static final OAuth1AccessTokenExtractor INSTANCE = new OAuth1AccessTokenExtractor();

        private InstanceHolder() {
        }
    }

    public static OAuth1AccessTokenExtractor instance() {
        return InstanceHolder.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public OAuth1AccessToken createToken(String str, String str2, String str3) {
        return new OAuth1AccessToken(str, str2, str3);
    }
}
