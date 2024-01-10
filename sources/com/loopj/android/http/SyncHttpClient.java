package com.loopj.android.http;

import android.content.Context;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

public class SyncHttpClient extends AsyncHttpClient {
    public SyncHttpClient() {
        super(false, 80, 443);
    }

    public SyncHttpClient(int i) {
        super(false, i, 443);
    }

    public SyncHttpClient(int i, int i2) {
        super(false, i, i2);
    }

    public SyncHttpClient(boolean z, int i, int i2) {
        super(z, i, i2);
    }

    public SyncHttpClient(SchemeRegistry schemeRegistry) {
        super(schemeRegistry);
    }

    /* access modifiers changed from: protected */
    public RequestHandle sendRequest(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, ResponseHandlerInterface responseHandlerInterface, Context context) {
        if (str != null) {
            httpUriRequest.addHeader("Content-Type", str);
        }
        responseHandlerInterface.setUseSynchronousMode(true);
        newAsyncHttpRequest(defaultHttpClient, httpContext, httpUriRequest, str, responseHandlerInterface, context).run();
        return new RequestHandle((AsyncHttpRequest) null);
    }
}
