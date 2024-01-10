package com.github.scribejava.core.builder.api;

import com.github.scribejava.core.extractors.BaseStringExtractor;
import com.github.scribejava.core.extractors.BaseStringExtractorImpl;
import com.github.scribejava.core.extractors.HeaderExtractor;
import com.github.scribejava.core.extractors.HeaderExtractorImpl;
import com.github.scribejava.core.extractors.OAuth1AccessTokenExtractor;
import com.github.scribejava.core.extractors.OAuth1RequestTokenExtractor;
import com.github.scribejava.core.extractors.TokenExtractor;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuthConfig;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth10aService;
import com.github.scribejava.core.services.HMACSha1SignatureService;
import com.github.scribejava.core.services.SignatureService;
import com.github.scribejava.core.services.TimestampService;
import com.github.scribejava.core.services.TimestampServiceImpl;

public abstract class DefaultApi10a implements BaseApi<OAuth10aService> {
    public abstract String getAccessTokenEndpoint();

    public abstract String getAuthorizationUrl(OAuth1RequestToken oAuth1RequestToken);

    public abstract String getRequestTokenEndpoint();

    public boolean isEmptyOAuthTokenParamIsRequired() {
        return false;
    }

    public TokenExtractor<OAuth1AccessToken> getAccessTokenExtractor() {
        return OAuth1AccessTokenExtractor.instance();
    }

    public BaseStringExtractor getBaseStringExtractor() {
        return new BaseStringExtractorImpl();
    }

    public HeaderExtractor getHeaderExtractor() {
        return new HeaderExtractorImpl();
    }

    public TokenExtractor<OAuth1RequestToken> getRequestTokenExtractor() {
        return OAuth1RequestTokenExtractor.instance();
    }

    public SignatureService getSignatureService() {
        return new HMACSha1SignatureService();
    }

    public TimestampService getTimestampService() {
        return new TimestampServiceImpl();
    }

    public Verb getAccessTokenVerb() {
        return Verb.POST;
    }

    public Verb getRequestTokenVerb() {
        return Verb.POST;
    }

    public OAuth10aService createService(OAuthConfig oAuthConfig) {
        return new OAuth10aService(this, oAuthConfig);
    }
}
