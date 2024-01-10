package com.github.scribejava.core.model;

import java.io.IOException;
import java.io.OutputStream;

public class OAuthConfig {
    private final String apiKey;
    private final String apiSecret;
    private final String callback;
    private final Integer connectTimeout;
    private final OutputStream debugStream;
    private final String grantType;
    private final Integer readTimeout;
    private final String responseType;
    private final String scope;
    private final SignatureType signatureType;
    private final String state;

    public OAuthConfig(String str, String str2) {
        this(str, str2, (String) null, (SignatureType) null, (String) null, (OutputStream) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null);
    }

    public OAuthConfig(String str, String str2, String str3, SignatureType signatureType2, String str4, OutputStream outputStream, Integer num, Integer num2, String str5, String str6, String str7) {
        this.apiKey = str;
        this.apiSecret = str2;
        this.callback = str3;
        this.signatureType = signatureType2;
        this.scope = str4;
        this.debugStream = outputStream;
        this.connectTimeout = num;
        this.readTimeout = num2;
        this.grantType = str5;
        this.state = str6;
        this.responseType = str7;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getApiSecret() {
        return this.apiSecret;
    }

    public String getCallback() {
        return this.callback;
    }

    public SignatureType getSignatureType() {
        return this.signatureType;
    }

    public String getScope() {
        return this.scope;
    }

    public boolean hasScope() {
        return this.scope != null;
    }

    public String getGrantType() {
        return this.grantType;
    }

    public boolean hasGrantType() {
        return this.grantType != null;
    }

    public Integer getConnectTimeout() {
        return this.connectTimeout;
    }

    public Integer getReadTimeout() {
        return this.readTimeout;
    }

    public void log(String str) {
        if (this.debugStream != null) {
            try {
                this.debugStream.write((str + 10).getBytes("UTF8"));
            } catch (IOException | RuntimeException e) {
                throw new RuntimeException("there were problems while writting to the debug stream", e);
            }
        }
    }

    public String getState() {
        return this.state;
    }

    public String getResponseType() {
        return this.responseType;
    }
}
