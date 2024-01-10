package com.github.scribejava.core.oauth;

import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.model.AbstractRequest;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuth2Authorization;
import com.github.scribejava.core.model.OAuthAsyncRequestCallback;
import com.github.scribejava.core.model.OAuthConfig;
import com.github.scribejava.core.model.OAuthConstants;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.OAuthRequestAsync;
import com.github.scribejava.core.services.Base64Encoder;
import com.ning.http.client.ProxyServer;
import com.ning.http.client.Response;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.Future;

public class OAuth20Service extends OAuthService {
    private static final String VERSION = "2.0";
    private final DefaultApi20 api;

    public String getVersion() {
        return VERSION;
    }

    public OAuth20Service(DefaultApi20 defaultApi20, OAuthConfig oAuthConfig) {
        super(oAuthConfig);
        this.api = defaultApi20;
    }

    /* access modifiers changed from: protected */
    public OAuth2AccessToken sendAccessTokenRequestSync(OAuthRequest oAuthRequest) {
        return this.api.getAccessTokenExtractor().extract(oAuthRequest.send().getBody());
    }

    /* access modifiers changed from: protected */
    public Future<OAuth2AccessToken> sendAccessTokenRequestAsync(OAuthRequestAsync oAuthRequestAsync, OAuthAsyncRequestCallback<OAuth2AccessToken> oAuthAsyncRequestCallback, ProxyServer proxyServer) {
        return oAuthRequestAsync.sendAsync(oAuthAsyncRequestCallback, new OAuthRequestAsync.ResponseConverter<OAuth2AccessToken>() {
            public OAuth2AccessToken convert(Response response) throws IOException {
                return OAuth20Service.this.getApi().getAccessTokenExtractor().extract(OAuthRequestAsync.RESPONSE_CONVERTER.convert(response).getBody());
            }
        }, proxyServer);
    }

    public final OAuth2AccessToken getAccessToken(String str) {
        return sendAccessTokenRequestSync((OAuthRequest) createAccessTokenRequest(str, new OAuthRequest(this.api.getAccessTokenVerb(), this.api.getAccessTokenEndpoint(), this)));
    }

    public final Future<OAuth2AccessToken> getAccessTokenAsync(String str, OAuthAsyncRequestCallback<OAuth2AccessToken> oAuthAsyncRequestCallback) {
        return getAccessTokenAsync(str, oAuthAsyncRequestCallback, (ProxyServer) null);
    }

    public final Future<OAuth2AccessToken> getAccessTokenAsync(String str, OAuthAsyncRequestCallback<OAuth2AccessToken> oAuthAsyncRequestCallback, ProxyServer proxyServer) {
        return sendAccessTokenRequestAsync((OAuthRequestAsync) createAccessTokenRequest(str, new OAuthRequestAsync(this.api.getAccessTokenVerb(), this.api.getAccessTokenEndpoint(), this)), oAuthAsyncRequestCallback, proxyServer);
    }

    /* access modifiers changed from: protected */
    public <T extends AbstractRequest> T createAccessTokenRequest(String str, T t) {
        OAuthConfig config = getConfig();
        t.addParameter("client_id", config.getApiKey());
        t.addParameter(OAuthConstants.CLIENT_SECRET, config.getApiSecret());
        t.addParameter(OAuthConstants.CODE, str);
        t.addParameter("redirect_uri", config.getCallback());
        if (config.hasScope()) {
            t.addParameter("scope", config.getScope());
        }
        if (config.hasGrantType()) {
            t.addParameter(OAuthConstants.GRANT_TYPE, config.getGrantType());
        }
        return t;
    }

    public final OAuth2AccessToken refreshAccessToken(String str) {
        return sendAccessTokenRequestSync((OAuthRequest) createRefreshTokenRequest(str, new OAuthRequest(this.api.getAccessTokenVerb(), this.api.getAccessTokenEndpoint(), this)));
    }

    public final Future<OAuth2AccessToken> refreshAccessTokenAsync(String str, OAuthAsyncRequestCallback<OAuth2AccessToken> oAuthAsyncRequestCallback) {
        return refreshAccessTokenAsync(str, oAuthAsyncRequestCallback, (ProxyServer) null);
    }

    public final Future<OAuth2AccessToken> refreshAccessTokenAsync(String str, OAuthAsyncRequestCallback<OAuth2AccessToken> oAuthAsyncRequestCallback, ProxyServer proxyServer) {
        return sendAccessTokenRequestAsync((OAuthRequestAsync) createRefreshTokenRequest(str, new OAuthRequestAsync(this.api.getAccessTokenVerb(), this.api.getRefreshTokenEndpoint(), this)), oAuthAsyncRequestCallback, proxyServer);
    }

    /* access modifiers changed from: protected */
    public <T extends AbstractRequest> T createRefreshTokenRequest(String str, T t) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("The refreshToken cannot be null or empty");
        }
        OAuthConfig config = getConfig();
        t.addParameter("client_id", config.getApiKey());
        t.addParameter(OAuthConstants.CLIENT_SECRET, config.getApiSecret());
        t.addParameter(OAuthConstants.REFRESH_TOKEN, str);
        t.addParameter(OAuthConstants.GRANT_TYPE, OAuthConstants.REFRESH_TOKEN);
        return t;
    }

    public final OAuth2AccessToken getAccessTokenPasswordGrant(String str, String str2) {
        return sendAccessTokenRequestSync((OAuthRequest) createAccessTokenPasswordGrantRequest(str, str2, new OAuthRequest(this.api.getAccessTokenVerb(), this.api.getAccessTokenEndpoint(), this)));
    }

    public final Future<OAuth2AccessToken> getAccessTokenPasswordGrantAsync(String str, String str2, OAuthAsyncRequestCallback<OAuth2AccessToken> oAuthAsyncRequestCallback) {
        return getAccessTokenPasswordGrantAsync(str, str2, oAuthAsyncRequestCallback, (ProxyServer) null);
    }

    public final Future<OAuth2AccessToken> getAccessTokenPasswordGrantAsync(String str, String str2, OAuthAsyncRequestCallback<OAuth2AccessToken> oAuthAsyncRequestCallback, ProxyServer proxyServer) {
        return sendAccessTokenRequestAsync((OAuthRequestAsync) createAccessTokenPasswordGrantRequest(str, str2, new OAuthRequestAsync(this.api.getAccessTokenVerb(), this.api.getAccessTokenEndpoint(), this)), oAuthAsyncRequestCallback, proxyServer);
    }

    /* access modifiers changed from: protected */
    public <T extends AbstractRequest> T createAccessTokenPasswordGrantRequest(String str, String str2, T t) {
        OAuthConfig config = getConfig();
        t.addParameter("username", str);
        t.addParameter("password", str2);
        if (config.hasScope()) {
            t.addParameter("scope", config.getScope());
        }
        t.addParameter(OAuthConstants.GRANT_TYPE, "password");
        t.addHeader("Authorization", "Basic " + Base64Encoder.getInstance().encode(String.format("%s:%s", new Object[]{config.getApiKey(), config.getApiSecret()}).getBytes(Charset.forName("UTF-8"))));
        return t;
    }

    public void signRequest(OAuth2AccessToken oAuth2AccessToken, AbstractRequest abstractRequest) {
        abstractRequest.addQuerystringParameter("access_token", oAuth2AccessToken.getAccessToken());
    }

    public final String getAuthorizationUrl() {
        return getAuthorizationUrl((Map<String, String>) null);
    }

    public String getAuthorizationUrl(Map<String, String> map) {
        return this.api.getAuthorizationUrl(getConfig(), map);
    }

    public DefaultApi20 getApi() {
        return this.api;
    }

    public OAuth2Authorization extractAuthorization(String str) {
        OAuth2Authorization oAuth2Authorization = new OAuth2Authorization();
        for (String split : str.substring(str.indexOf(63) + 1).split("&")) {
            String[] split2 = split.split("=");
            if (split2.length == 2) {
                String str2 = split2[0];
                char c = 65535;
                int hashCode = str2.hashCode();
                if (hashCode != 3059181) {
                    if (hashCode == 109757585 && str2.equals("state")) {
                        c = 1;
                    }
                } else if (str2.equals(OAuthConstants.CODE)) {
                    c = 0;
                }
                if (c == 0) {
                    oAuth2Authorization.setCode(split2[1]);
                } else if (c == 1) {
                    oAuth2Authorization.setState(split2[1]);
                }
            }
        }
        return oAuth2Authorization;
    }
}
