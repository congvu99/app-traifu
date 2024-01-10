package com.trainerfu.android;

import android.util.Base64;
import com.facebook.internal.security.CertificateUtil;
import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.model.AbstractRequest;
import com.github.scribejava.core.model.OAuthConfig;
import com.github.scribejava.core.oauth.OAuth20Service;

public class FitbitOAuthService extends OAuth20Service {
    public FitbitOAuthService(DefaultApi20 defaultApi20, OAuthConfig oAuthConfig) {
        super(defaultApi20, oAuthConfig);
    }

    /* access modifiers changed from: protected */
    public <T extends AbstractRequest> T createAccessTokenRequest(String str, T t) {
        super.createAccessTokenRequest(str, t);
        String encodeToString = Base64.encodeToString((getConfig().getApiKey() + CertificateUtil.DELIMITER + getConfig().getApiSecret()).getBytes(), 0);
        StringBuilder sb = new StringBuilder();
        sb.append("Basic ");
        sb.append(encodeToString);
        t.addHeader("Authorization", sb.toString());
        t.addHeader("Content-Type", AbstractRequest.DEFAULT_CONTENT_TYPE);
        return t;
    }
}
