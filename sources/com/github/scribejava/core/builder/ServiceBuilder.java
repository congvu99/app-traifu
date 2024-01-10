package com.github.scribejava.core.builder;

import com.github.scribejava.core.builder.api.BaseApi;
import com.github.scribejava.core.model.OAuthConfig;
import com.github.scribejava.core.model.SignatureType;
import com.github.scribejava.core.oauth.OAuthService;
import com.github.scribejava.core.utils.Preconditions;
import java.io.OutputStream;

public class ServiceBuilder extends AbstractServiceBuilder<ServiceBuilder> {
    private Integer connectTimeout;
    private Integer readTimeout;

    public /* bridge */ /* synthetic */ OAuthService build(BaseApi baseApi) {
        return super.build(baseApi);
    }

    public /* bridge */ /* synthetic */ void checkPreconditions() {
        super.checkPreconditions();
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

    public ServiceBuilder connectTimeout(Integer num) {
        Preconditions.checkNotNull(num, "Connection timeout can't be null");
        this.connectTimeout = num;
        return this;
    }

    public ServiceBuilder readTimeout(Integer num) {
        Preconditions.checkNotNull(num, "Read timeout can't be null");
        this.readTimeout = num;
        return this;
    }

    /* access modifiers changed from: protected */
    public OAuthConfig createConfig() {
        super.checkPreconditions();
        return new OAuthConfig(getApiKey(), getApiSecret(), getCallback(), getSignatureType(), getScope(), getDebugStream(), this.connectTimeout, this.readTimeout, getGrantType(), getState(), getResponseType());
    }
}
