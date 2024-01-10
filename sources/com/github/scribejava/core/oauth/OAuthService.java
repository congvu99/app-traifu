package com.github.scribejava.core.oauth;

import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.model.ForceTypeOfHttpRequest;
import com.github.scribejava.core.model.OAuthConfig;
import com.github.scribejava.core.model.OAuthConfigAsync;
import com.github.scribejava.core.model.ScribeJavaConfig;
import com.ning.http.client.AsyncHttpClient;

public abstract class OAuthService {
    private AsyncHttpClient asyncHttpClient;
    private final OAuthConfig config;

    public abstract String getVersion();

    public OAuthService(OAuthConfig oAuthConfig) {
        AsyncHttpClient asyncHttpClient2;
        this.config = oAuthConfig;
        ForceTypeOfHttpRequest forceTypeOfHttpRequests = ScribeJavaConfig.getForceTypeOfHttpRequests();
        if (oAuthConfig instanceof OAuthConfigAsync) {
            if (ForceTypeOfHttpRequest.FORCE_SYNC_ONLY_HTTP_REQUESTS != forceTypeOfHttpRequests) {
                if (ForceTypeOfHttpRequest.PREFER_SYNC_ONLY_HTTP_REQUESTS == forceTypeOfHttpRequests) {
                    oAuthConfig.log("Cannot use async operations, only sync");
                }
                OAuthConfigAsync oAuthConfigAsync = (OAuthConfigAsync) oAuthConfig;
                String asyncHttpProviderClassName = oAuthConfigAsync.getAsyncHttpProviderClassName();
                if (asyncHttpProviderClassName == null) {
                    asyncHttpClient2 = new AsyncHttpClient(oAuthConfigAsync.getAsyncHttpClientConfig());
                } else {
                    asyncHttpClient2 = new AsyncHttpClient(asyncHttpProviderClassName, oAuthConfigAsync.getAsyncHttpClientConfig());
                }
                this.asyncHttpClient = asyncHttpClient2;
                return;
            }
            throw new OAuthException("Cannot use async operations, only sync");
        } else if (ForceTypeOfHttpRequest.FORCE_ASYNC_ONLY_HTTP_REQUESTS == forceTypeOfHttpRequests) {
            throw new OAuthException("Cannot use sync operations, only async");
        } else if (ForceTypeOfHttpRequest.PREFER_ASYNC_ONLY_HTTP_REQUESTS == forceTypeOfHttpRequests) {
            oAuthConfig.log("Cannot use sync operations, only async");
        }
    }

    public AsyncHttpClient getAsyncHttpClient() {
        return this.asyncHttpClient;
    }

    public void closeAsyncClient() {
        this.asyncHttpClient.close();
    }

    public OAuthConfig getConfig() {
        return this.config;
    }
}
