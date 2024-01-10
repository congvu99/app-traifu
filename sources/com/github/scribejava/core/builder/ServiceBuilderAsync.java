package com.github.scribejava.core.builder;

import com.github.scribejava.core.builder.api.BaseApi;
import com.github.scribejava.core.model.OAuthConfigAsync;
import com.github.scribejava.core.model.SignatureType;
import com.github.scribejava.core.oauth.OAuthService;
import com.github.scribejava.core.utils.Preconditions;
import com.ning.http.client.AsyncHttpClientConfig;
import java.io.OutputStream;

public class ServiceBuilderAsync extends AbstractServiceBuilder<ServiceBuilderAsync> {
    private AsyncHttpClientConfig asyncHttpClientConfig;
    private String asyncHttpProviderClassName;

    public /* bridge */ /* synthetic */ OAuthService build(BaseApi baseApi) {
        return super.build(baseApi);
    }

    public /* bridge */ /* synthetic */ String getApiKey() {
        return super.getApiKey();
    }

    public /* bridge */ /* synthetic */ String getApiSecret() {
        return super.getApiSecret();
    }

    public /* bridge */ /* synthetic */ String getCallback() {
        return super.getCallback();
    }

    public /* bridge */ /* synthetic */ OutputStream getDebugStream() {
        return super.getDebugStream();
    }

    public /* bridge */ /* synthetic */ String getGrantType() {
        return super.getGrantType();
    }

    public /* bridge */ /* synthetic */ String getResponseType() {
        return super.getResponseType();
    }

    public /* bridge */ /* synthetic */ String getScope() {
        return super.getScope();
    }

    public /* bridge */ /* synthetic */ SignatureType getSignatureType() {
        return super.getSignatureType();
    }

    public /* bridge */ /* synthetic */ String getState() {
        return super.getState();
    }

    public ServiceBuilderAsync asyncHttpClientConfig(AsyncHttpClientConfig asyncHttpClientConfig2) {
        Preconditions.checkNotNull(asyncHttpClientConfig2, "asyncHttpClientConfig can't be null");
        this.asyncHttpClientConfig = asyncHttpClientConfig2;
        return this;
    }

    public void checkPreconditions() {
        super.checkPreconditions();
        Preconditions.checkNotNull(this.asyncHttpClientConfig, "You must provide an asyncHttpClientConfig");
    }

    /* access modifiers changed from: protected */
    public OAuthConfigAsync createConfig() {
        checkPreconditions();
        OAuthConfigAsync oAuthConfigAsync = new OAuthConfigAsync(getApiKey(), getApiSecret(), getCallback(), getSignatureType(), getScope(), getGrantType(), getState(), getResponseType(), getDebugStream(), this.asyncHttpClientConfig);
        oAuthConfigAsync.setAsyncHttpProviderClassName(this.asyncHttpProviderClassName);
        return oAuthConfigAsync;
    }

    public ServiceBuilderAsync asyncHttpProviderClassName(String str) {
        this.asyncHttpProviderClassName = str;
        return this;
    }
}
