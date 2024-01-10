package com.github.scribejava.core.model;

import com.ning.http.client.AsyncHttpClientConfig;
import java.io.OutputStream;

public class OAuthConfigAsync extends OAuthConfig {
    private AsyncHttpClientConfig asyncHttpClientConfig;
    private String asyncHttpProviderClassName;

    public OAuthConfigAsync(String str, String str2) {
        super(str, str2);
    }

    public OAuthConfigAsync(String str, String str2, String str3, SignatureType signatureType, String str4, String str5, String str6, String str7, OutputStream outputStream, AsyncHttpClientConfig asyncHttpClientConfig2) {
        super(str, str2, str3, signatureType, str4, outputStream, (Integer) null, (Integer) null, str5, str6, str7);
        this.asyncHttpClientConfig = asyncHttpClientConfig2;
    }

    public AsyncHttpClientConfig getAsyncHttpClientConfig() {
        return this.asyncHttpClientConfig;
    }

    public void setAsyncHttpProviderClassName(String str) {
        this.asyncHttpProviderClassName = str;
    }

    public String getAsyncHttpProviderClassName() {
        return this.asyncHttpProviderClassName;
    }
}
