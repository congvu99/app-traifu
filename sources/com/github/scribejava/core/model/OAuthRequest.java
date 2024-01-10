package com.github.scribejava.core.model;

import com.facebook.internal.ServerProtocol;
import com.github.scribejava.core.exceptions.OAuthConnectionException;
import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.oauth.OAuthService;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class OAuthRequest extends AbstractRequest {
    private HttpURLConnection connection;

    public OAuthRequest(Verb verb, String str, OAuthService oAuthService) {
        super(verb, str, oAuthService);
    }

    public Response send() {
        ForceTypeOfHttpRequest forceTypeOfHttpRequests = ScribeJavaConfig.getForceTypeOfHttpRequests();
        if (ForceTypeOfHttpRequest.FORCE_ASYNC_ONLY_HTTP_REQUESTS != forceTypeOfHttpRequests) {
            if (ForceTypeOfHttpRequest.PREFER_ASYNC_ONLY_HTTP_REQUESTS == forceTypeOfHttpRequests) {
                getService().getConfig().log("Cannot use sync operations, only async");
            }
            try {
                createConnection();
                return doSend();
            } catch (IOException | RuntimeException e) {
                throw new OAuthConnectionException(getCompleteUrl(), e);
            }
        } else {
            throw new OAuthException("Cannot use sync operations, only async");
        }
    }

    /* access modifiers changed from: package-private */
    public Response doSend() throws IOException {
        this.connection.setRequestMethod(getVerb().name());
        OAuthConfig config = getService().getConfig();
        if (config.getConnectTimeout() != null) {
            this.connection.setConnectTimeout(config.getConnectTimeout().intValue());
        }
        if (config.getReadTimeout() != null) {
            this.connection.setReadTimeout(config.getReadTimeout().intValue());
        }
        addHeaders();
        if (hasBodyContent()) {
            addBody(getByteBodyContents());
        }
        return new Response(this.connection);
    }

    private void createConnection() throws IOException {
        String completeUrl = getCompleteUrl();
        if (this.connection == null) {
            System.setProperty("http.keepAlive", isConnectionKeepAlive() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(completeUrl).openConnection();
            this.connection = httpURLConnection;
            httpURLConnection.setInstanceFollowRedirects(isFollowRedirects());
        }
    }

    /* access modifiers changed from: package-private */
    public void addHeaders() {
        for (Map.Entry next : getHeaders().entrySet()) {
            this.connection.setRequestProperty((String) next.getKey(), (String) next.getValue());
        }
    }

    /* access modifiers changed from: package-private */
    public void addBody(byte[] bArr) throws IOException {
        this.connection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
        if (this.connection.getRequestProperty("Content-Type") == null) {
            this.connection.setRequestProperty("Content-Type", AbstractRequest.DEFAULT_CONTENT_TYPE);
        }
        this.connection.setDoOutput(true);
        this.connection.getOutputStream().write(bArr);
    }

    /* access modifiers changed from: package-private */
    public void setConnection(HttpURLConnection httpURLConnection) {
        this.connection = httpURLConnection;
    }
}
