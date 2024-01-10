package com.github.scribejava.core.model;

import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.oauth.OAuthService;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractRequest {
    protected static final String CONTENT_LENGTH = "Content-Length";
    protected static final String CONTENT_TYPE = "Content-Type";
    public static final String DEFAULT_CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String OAUTH_PREFIX = "oauth_";
    private final ParameterList bodyParams = new ParameterList();
    private byte[] bytePayload;
    private String charset;
    private boolean connectionKeepAlive;
    private boolean followRedirects = true;
    private final Map<String, String> headers = new HashMap();
    private final Map<String, String> oauthParameters = new HashMap();
    private String payload;
    private final ParameterList querystringParams = new ParameterList();
    private String realm;
    private final OAuthService service;
    private final String url;
    private final Verb verb;

    public AbstractRequest(Verb verb2, String str, OAuthService oAuthService) {
        this.verb = verb2;
        this.url = str;
        this.service = oAuthService;
    }

    public void addOAuthParameter(String str, String str2) {
        this.oauthParameters.put(checkKey(str), str2);
    }

    private String checkKey(String str) {
        if (str.startsWith("oauth_") || str.equals("scope") || str.equals(OAuthConstants.REALM)) {
            return str;
        }
        throw new IllegalArgumentException(String.format("OAuth parameters must either be '%s', '%s' or start with '%s'", new Object[]{"scope", OAuthConstants.REALM, "oauth_"}));
    }

    public Map<String, String> getOauthParameters() {
        return this.oauthParameters;
    }

    public void setRealm(String str) {
        this.realm = str;
    }

    public String getRealm() {
        return this.realm;
    }

    public String getCompleteUrl() {
        return this.querystringParams.appendTo(this.url);
    }

    public void addHeader(String str, String str2) {
        this.headers.put(str, str2);
    }

    public void addBodyParameter(String str, String str2) {
        this.bodyParams.add(str, str2);
    }

    public void addQuerystringParameter(String str, String str2) {
        this.querystringParams.add(str, str2);
    }

    public void addParameter(String str, String str2) {
        if (hasBodyContent()) {
            this.bodyParams.add(str, str2);
        } else {
            this.querystringParams.add(str, str2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean hasBodyContent() {
        return this.verb == Verb.PUT || this.verb == Verb.POST;
    }

    public void addPayload(String str) {
        this.payload = str;
    }

    public void addPayload(byte[] bArr) {
        this.bytePayload = (byte[]) bArr.clone();
    }

    public ParameterList getQueryStringParams() {
        try {
            ParameterList parameterList = new ParameterList();
            parameterList.addQuerystring(new URL(this.url).getQuery());
            parameterList.addAll(this.querystringParams);
            return parameterList;
        } catch (MalformedURLException e) {
            throw new OAuthException("Malformed URL", e);
        }
    }

    public ParameterList getBodyParams() {
        return this.bodyParams;
    }

    public String getUrl() {
        return this.url;
    }

    public String getSanitizedUrl() {
        if (this.url.startsWith("http://") && (this.url.endsWith(":80") || this.url.contains(":80/"))) {
            return this.url.replaceAll("\\?.*", "").replaceAll(":80", "");
        }
        if (!this.url.startsWith("https://") || (!this.url.endsWith(":443") && !this.url.contains(":443/"))) {
            return this.url.replaceAll("\\?.*", "");
        }
        return this.url.replaceAll("\\?.*", "").replaceAll(":443", "");
    }

    public String getBodyContents() {
        try {
            return new String(getByteBodyContents(), getCharset());
        } catch (UnsupportedEncodingException e) {
            throw new OAuthException("Unsupported Charset: " + this.charset, e);
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] getByteBodyContents() {
        byte[] bArr = this.bytePayload;
        if (bArr != null) {
            return bArr;
        }
        String str = this.payload;
        if (str == null) {
            str = this.bodyParams.asFormUrlEncodedString();
        }
        try {
            return str.getBytes(getCharset());
        } catch (UnsupportedEncodingException e) {
            throw new OAuthException("Unsupported Charset: " + getCharset(), e);
        }
    }

    public String toString() {
        return String.format("@Request(%s %s)", new Object[]{getVerb(), getUrl()});
    }

    public Verb getVerb() {
        return this.verb;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getCharset() {
        String str = this.charset;
        return str == null ? Charset.defaultCharset().name() : str;
    }

    public void setCharset(String str) {
        this.charset = str;
    }

    public void setConnectionKeepAlive(boolean z) {
        this.connectionKeepAlive = z;
    }

    public void setFollowRedirects(boolean z) {
        this.followRedirects = z;
    }

    public boolean isConnectionKeepAlive() {
        return this.connectionKeepAlive;
    }

    public boolean isFollowRedirects() {
        return this.followRedirects;
    }

    public OAuthService getService() {
        return this.service;
    }
}
