package com.github.scribejava.core.extractors;

import com.github.scribejava.core.model.OAuth1RequestToken;

public class OAuth1RequestTokenExtractor extends AbstractOAuth1TokenExtractor<OAuth1RequestToken> {
    protected OAuth1RequestTokenExtractor() {
    }

    private static class InstanceHolder {
        /* access modifiers changed from: private */
        public static final OAuth1RequestTokenExtractor INSTANCE = new OAuth1RequestTokenExtractor();

        private InstanceHolder() {
        }
    }

    public static OAuth1RequestTokenExtractor instance() {
        return InstanceHolder.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public OAuth1RequestToken createToken(String str, String str2, String str3) {
        return new OAuth1RequestToken(str, str2, str3);
    }
}
