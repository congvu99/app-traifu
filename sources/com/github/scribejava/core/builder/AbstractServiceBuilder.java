package com.github.scribejava.core.builder;

import com.github.scribejava.core.builder.AbstractServiceBuilder;
import com.github.scribejava.core.builder.api.BaseApi;
import com.github.scribejava.core.model.OAuthConfig;
import com.github.scribejava.core.model.OAuthConstants;
import com.github.scribejava.core.model.SignatureType;
import com.github.scribejava.core.oauth.OAuthService;
import com.github.scribejava.core.utils.Preconditions;
import java.io.OutputStream;

abstract class AbstractServiceBuilder<T extends AbstractServiceBuilder<T>> {
    private String apiKey;
    private String apiSecret;
    private String callback = OAuthConstants.OUT_OF_BAND;
    private OutputStream debugStream;
    private String grantType;
    private String responseType = OAuthConstants.CODE;
    private String scope;
    private SignatureType signatureType = SignatureType.Header;
    private String state;

    /* access modifiers changed from: protected */
    public abstract OAuthConfig createConfig();

    AbstractServiceBuilder() {
    }

    public T callback(String str) {
        Preconditions.checkNotNull(str, "Callback can't be null");
        this.callback = str;
        return this;
    }

    public T apiKey(String str) {
        Preconditions.checkEmptyString(str, "Invalid Api key");
        this.apiKey = str;
        return this;
    }

    public T apiSecret(String str) {
        Preconditions.checkEmptyString(str, "Invalid Api secret");
        this.apiSecret = str;
        return this;
    }

    public T scope(String str) {
        Preconditions.checkEmptyString(str, "Invalid OAuth scope");
        this.scope = str;
        return this;
    }

    public T state(String str) {
        Preconditions.checkEmptyString(str, "Invalid OAuth state");
        this.state = str;
        return this;
    }

    public T signatureType(SignatureType signatureType2) {
        Preconditions.checkNotNull(signatureType2, "Signature type can't be null");
        this.signatureType = signatureType2;
        return this;
    }

    public T debugStream(OutputStream outputStream) {
        Preconditions.checkNotNull(outputStream, "debug stream can't be null");
        this.debugStream = outputStream;
        return this;
    }

    public T grantType(String str) {
        Preconditions.checkEmptyString(str, "Invalid OAuth grantType");
        this.grantType = str;
        return this;
    }

    public T responseType(String str) {
        Preconditions.checkEmptyString(str, "Invalid OAuth responseType");
        this.responseType = str;
        return this;
    }

    public T debug() {
        debugStream(System.out);
        return this;
    }

    public void checkPreconditions() {
        Preconditions.checkEmptyString(this.apiKey, "You must provide an api key");
    }

    public String getCallback() {
        return this.callback;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getApiSecret() {
        return this.apiSecret;
    }

    public String getScope() {
        return this.scope;
    }

    public String getState() {
        return this.state;
    }

    public SignatureType getSignatureType() {
        return this.signatureType;
    }

    public OutputStream getDebugStream() {
        return this.debugStream;
    }

    public String getGrantType() {
        return this.grantType;
    }

    public String getResponseType() {
        return this.responseType;
    }

    public <S extends OAuthService> S build(BaseApi<S> baseApi) {
        return baseApi.createService(createConfig());
    }
}
