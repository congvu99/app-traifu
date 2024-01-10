package com.trainerfu.android;

import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.model.OAuthConfig;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.github.scribejava.core.utils.OAuthEncoder;

public class FitbitApi extends DefaultApi20 {
    private static final String AUTHORIZE_URL = "https://www.fitbit.com/oauth2/authorize?response_type=%s&client_id=%s&redirect_uri=%s&scope=%s";

    public String getAccessTokenEndpoint() {
        return "https://api.fitbit.com/oauth2/token";
    }

    protected FitbitApi() {
    }

    private static class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FitbitApi INSTANCE = new FitbitApi();

        private InstanceHolder() {
        }
    }

    public static FitbitApi instance() {
        return InstanceHolder.INSTANCE;
    }

    public Verb getAccessTokenVerb() {
        return Verb.POST;
    }

    public String getAuthorizationUrl(OAuthConfig oAuthConfig) {
        return new StringBuilder(String.format(AUTHORIZE_URL, new Object[]{oAuthConfig.getResponseType(), oAuthConfig.getApiKey(), OAuthEncoder.encode(oAuthConfig.getCallback()), OAuthEncoder.encode(oAuthConfig.getScope())})).toString();
    }

    public OAuth20Service createService(OAuthConfig oAuthConfig) {
        return new FitbitOAuthService(this, oAuthConfig);
    }
}
