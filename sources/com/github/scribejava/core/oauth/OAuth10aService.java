package com.github.scribejava.core.oauth;

import com.github.scribejava.core.builder.api.DefaultApi10a;
import com.github.scribejava.core.model.AbstractRequest;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuthAsyncRequestCallback;
import com.github.scribejava.core.model.OAuthConfig;
import com.github.scribejava.core.model.OAuthConstants;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.OAuthRequestAsync;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.services.Base64Encoder;
import com.github.scribejava.core.utils.MapUtils;
import com.ning.http.client.ProxyServer;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Future;

public class OAuth10aService extends OAuthService {
    private static final String VERSION = "1.0";
    private final DefaultApi10a api;

    public String getVersion() {
        return "1.0";
    }

    public OAuth10aService(DefaultApi10a defaultApi10a, OAuthConfig oAuthConfig) {
        super(oAuthConfig);
        this.api = defaultApi10a;
    }

    public OAuth1RequestToken getRequestToken() {
        OAuthConfig config = getConfig();
        config.log("obtaining request token from " + this.api.getRequestTokenEndpoint());
        OAuthRequest oAuthRequest = new OAuthRequest(this.api.getRequestTokenVerb(), this.api.getRequestTokenEndpoint(), this);
        config.log("setting oauth_callback to " + config.getCallback());
        oAuthRequest.addOAuthParameter(OAuthConstants.CALLBACK, config.getCallback());
        addOAuthParams(oAuthRequest, "");
        appendSignature(oAuthRequest);
        config.log("sending request...");
        Response send = oAuthRequest.send();
        String body = send.getBody();
        config.log("response status code: " + send.getCode());
        config.log("response body: " + body);
        return this.api.getRequestTokenExtractor().extract(body);
    }

    private void addOAuthParams(AbstractRequest abstractRequest, String str) {
        OAuthConfig config = getConfig();
        abstractRequest.addOAuthParameter(OAuthConstants.TIMESTAMP, this.api.getTimestampService().getTimestampInSeconds());
        abstractRequest.addOAuthParameter(OAuthConstants.NONCE, this.api.getTimestampService().getNonce());
        abstractRequest.addOAuthParameter(OAuthConstants.CONSUMER_KEY, config.getApiKey());
        abstractRequest.addOAuthParameter(OAuthConstants.SIGN_METHOD, this.api.getSignatureService().getSignatureMethod());
        abstractRequest.addOAuthParameter(OAuthConstants.VERSION, getVersion());
        if (config.hasScope()) {
            abstractRequest.addOAuthParameter("scope", config.getScope());
        }
        abstractRequest.addOAuthParameter(OAuthConstants.SIGNATURE, getSignature(abstractRequest, str));
        config.log("appended additional OAuth parameters: " + MapUtils.toString(abstractRequest.getOauthParameters()));
    }

    public final OAuth1AccessToken getAccessToken(OAuth1RequestToken oAuth1RequestToken, String str) {
        OAuthConfig config = getConfig();
        config.log("obtaining access token from " + this.api.getAccessTokenEndpoint());
        OAuthRequest oAuthRequest = new OAuthRequest(this.api.getAccessTokenVerb(), this.api.getAccessTokenEndpoint(), this);
        prepareAccessTokenRequest(oAuthRequest, oAuth1RequestToken, str);
        return this.api.getAccessTokenExtractor().extract(oAuthRequest.send().getBody());
    }

    public final Future<OAuth1AccessToken> getAccessTokenAsync(OAuth1RequestToken oAuth1RequestToken, String str, OAuthAsyncRequestCallback<OAuth1AccessToken> oAuthAsyncRequestCallback) {
        return getAccessTokenAsync(oAuth1RequestToken, str, oAuthAsyncRequestCallback, (ProxyServer) null);
    }

    public final Future<OAuth1AccessToken> getAccessTokenAsync(OAuth1RequestToken oAuth1RequestToken, String str, OAuthAsyncRequestCallback<OAuth1AccessToken> oAuthAsyncRequestCallback, ProxyServer proxyServer) {
        OAuthConfig config = getConfig();
        config.log("async obtaining access token from " + this.api.getAccessTokenEndpoint());
        OAuthRequestAsync oAuthRequestAsync = new OAuthRequestAsync(this.api.getAccessTokenVerb(), this.api.getAccessTokenEndpoint(), this);
        prepareAccessTokenRequest(oAuthRequestAsync, oAuth1RequestToken, str);
        return oAuthRequestAsync.sendAsync(oAuthAsyncRequestCallback, new OAuthRequestAsync.ResponseConverter<OAuth1AccessToken>() {
            public OAuth1AccessToken convert(com.ning.http.client.Response response) throws IOException {
                return OAuth10aService.this.getApi().getAccessTokenExtractor().extract(OAuthRequestAsync.RESPONSE_CONVERTER.convert(response).getBody());
            }
        }, proxyServer);
    }

    /* access modifiers changed from: protected */
    public void prepareAccessTokenRequest(AbstractRequest abstractRequest, OAuth1RequestToken oAuth1RequestToken, String str) {
        OAuthConfig config = getConfig();
        abstractRequest.addOAuthParameter(OAuthConstants.TOKEN, oAuth1RequestToken.getToken());
        abstractRequest.addOAuthParameter(OAuthConstants.VERIFIER, str);
        config.log("setting token to: " + oAuth1RequestToken + " and verifier to: " + str);
        addOAuthParams(abstractRequest, oAuth1RequestToken.getTokenSecret());
        appendSignature(abstractRequest);
    }

    public void signRequest(OAuth1AccessToken oAuth1AccessToken, AbstractRequest abstractRequest) {
        OAuthConfig config = getConfig();
        config.log("signing request: " + abstractRequest.getCompleteUrl());
        if (!oAuth1AccessToken.isEmpty() || this.api.isEmptyOAuthTokenParamIsRequired()) {
            abstractRequest.addOAuthParameter(OAuthConstants.TOKEN, oAuth1AccessToken.getToken());
        }
        config.log("setting token to: " + oAuth1AccessToken);
        addOAuthParams(abstractRequest, oAuth1AccessToken.getTokenSecret());
        appendSignature(abstractRequest);
    }

    public String getAuthorizationUrl(OAuth1RequestToken oAuth1RequestToken) {
        return this.api.getAuthorizationUrl(oAuth1RequestToken);
    }

    private String getSignature(AbstractRequest abstractRequest, String str) {
        OAuthConfig config = getConfig();
        config.log("generating signature...");
        config.log("using base64 encoder: " + Base64Encoder.type());
        String extract = this.api.getBaseStringExtractor().extract(abstractRequest);
        String signature = this.api.getSignatureService().getSignature(extract, config.getApiSecret(), str);
        config.log("base string is: " + extract);
        config.log("signature is: " + signature);
        return signature;
    }

    /* renamed from: com.github.scribejava.core.oauth.OAuth10aService$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$github$scribejava$core$model$SignatureType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.github.scribejava.core.model.SignatureType[] r0 = com.github.scribejava.core.model.SignatureType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$github$scribejava$core$model$SignatureType = r0
                com.github.scribejava.core.model.SignatureType r1 = com.github.scribejava.core.model.SignatureType.Header     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$github$scribejava$core$model$SignatureType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.scribejava.core.model.SignatureType r1 = com.github.scribejava.core.model.SignatureType.QueryString     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.scribejava.core.oauth.OAuth10aService.AnonymousClass2.<clinit>():void");
        }
    }

    private void appendSignature(AbstractRequest abstractRequest) {
        OAuthConfig config = getConfig();
        int i = AnonymousClass2.$SwitchMap$com$github$scribejava$core$model$SignatureType[config.getSignatureType().ordinal()];
        if (i == 1) {
            config.log("using Http Header signature");
            abstractRequest.addHeader("Authorization", this.api.getHeaderExtractor().extract(abstractRequest));
        } else if (i == 2) {
            config.log("using Querystring signature");
            for (Map.Entry next : abstractRequest.getOauthParameters().entrySet()) {
                abstractRequest.addQuerystringParameter((String) next.getKey(), (String) next.getValue());
            }
        } else {
            throw new IllegalStateException("Unknown new Signature Type '" + config.getSignatureType() + "'.");
        }
    }

    public DefaultApi10a getApi() {
        return this.api;
    }
}
