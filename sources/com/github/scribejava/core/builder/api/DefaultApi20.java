package com.github.scribejava.core.builder.api;

import com.github.scribejava.core.extractors.OAuth2AccessTokenJsonExtractor;
import com.github.scribejava.core.extractors.TokenExtractor;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthConfig;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.github.scribejava.core.utils.OAuthEncoder;
import java.util.Map;
import kotlin.text.Typography;

public abstract class DefaultApi20 implements BaseApi<OAuth20Service> {
    public abstract String getAccessTokenEndpoint();

    public abstract String getAuthorizationUrl(OAuthConfig oAuthConfig);

    public TokenExtractor<OAuth2AccessToken> getAccessTokenExtractor() {
        return OAuth2AccessTokenJsonExtractor.instance();
    }

    public Verb getAccessTokenVerb() {
        return Verb.POST;
    }

    public String getRefreshTokenEndpoint() {
        return getAccessTokenEndpoint();
    }

    public String getAuthorizationUrl(OAuthConfig oAuthConfig, Map<String, String> map) {
        String authorizationUrl = getAuthorizationUrl(oAuthConfig);
        if (map == null || map.isEmpty()) {
            return authorizationUrl;
        }
        StringBuilder sb = new StringBuilder(authorizationUrl);
        char c = '?';
        if (authorizationUrl.indexOf(63) != -1) {
            c = Typography.amp;
        }
        sb.append(c);
        for (Map.Entry next : map.entrySet()) {
            sb.append(OAuthEncoder.encode((String) next.getKey()));
            sb.append('=');
            sb.append(OAuthEncoder.encode((String) next.getValue()));
            sb.append(Typography.amp);
        }
        return sb.substring(0, sb.length() - 1);
    }

    public OAuth20Service createService(OAuthConfig oAuthConfig) {
        return new OAuth20Service(this, oAuthConfig);
    }
}
