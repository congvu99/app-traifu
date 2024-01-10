package com.github.scribejava.core.model;

import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.oauth.OAuthService;
import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.FluentCaseInsensitiveStringsMap;
import com.ning.http.client.ProxyServer;
import com.ning.http.client.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

public class OAuthRequestAsync extends AbstractRequest {
    public static final ResponseConverter<Response> RESPONSE_CONVERTER = new ResponseConverter<Response>() {
        public Response convert(Response response) throws IOException {
            FluentCaseInsensitiveStringsMap headers = response.getHeaders();
            HashMap hashMap = new HashMap();
            Iterator it = headers.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                StringBuilder sb = new StringBuilder();
                for (String append : (List) entry.getValue()) {
                    sb.append(append);
                }
                hashMap.put(entry.getKey(), sb.toString());
            }
            return new Response(response.getStatusCode(), response.getStatusText(), hashMap, response.getResponseBody(), response.getResponseBodyAsStream());
        }
    };

    public interface ResponseConverter<T> {
        T convert(Response response) throws IOException;
    }

    public OAuthRequestAsync(Verb verb, String str, OAuthService oAuthService) {
        super(verb, str, oAuthService);
    }

    public <T> Future<T> sendAsync(OAuthAsyncRequestCallback<T> oAuthAsyncRequestCallback, ResponseConverter<T> responseConverter) {
        return sendAsync(oAuthAsyncRequestCallback, responseConverter, (ProxyServer) null);
    }

    public <T> Future<T> sendAsync(OAuthAsyncRequestCallback<T> oAuthAsyncRequestCallback, ResponseConverter<T> responseConverter, ProxyServer proxyServer) {
        AsyncHttpClient.BoundRequestBuilder boundRequestBuilder;
        ForceTypeOfHttpRequest forceTypeOfHttpRequests = ScribeJavaConfig.getForceTypeOfHttpRequests();
        if (ForceTypeOfHttpRequest.FORCE_SYNC_ONLY_HTTP_REQUESTS != forceTypeOfHttpRequests) {
            OAuthService service = getService();
            if (ForceTypeOfHttpRequest.PREFER_SYNC_ONLY_HTTP_REQUESTS == forceTypeOfHttpRequests) {
                service.getConfig().log("Cannot use async operations, only sync");
            }
            String completeUrl = getCompleteUrl();
            AsyncHttpClient asyncHttpClient = service.getAsyncHttpClient();
            Map<String, String> headers = getHeaders();
            int i = AnonymousClass2.$SwitchMap$com$github$scribejava$core$model$Verb[getVerb().ordinal()];
            if (i == 1) {
                boundRequestBuilder = asyncHttpClient.prepareGet(completeUrl);
            } else if (i == 2) {
                AsyncHttpClient.BoundRequestBuilder preparePost = asyncHttpClient.preparePost(completeUrl);
                if (!headers.containsKey("Content-Type")) {
                    preparePost = preparePost.addHeader("Content-Type", AbstractRequest.DEFAULT_CONTENT_TYPE);
                }
                boundRequestBuilder = preparePost.setBody(getBodyContents());
            } else {
                throw new IllegalArgumentException("message build error: unknown verb type");
            }
            for (Map.Entry next : headers.entrySet()) {
                boundRequestBuilder.addHeader((String) next.getKey(), (String) next.getValue());
            }
            if (proxyServer != null) {
                boundRequestBuilder.setProxyServer(proxyServer);
            }
            return boundRequestBuilder.execute(new OAuthAsyncCompletionHandler(oAuthAsyncRequestCallback, responseConverter));
        }
        throw new OAuthException("Cannot use async operations, only sync");
    }

    /* renamed from: com.github.scribejava.core.model.OAuthRequestAsync$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$github$scribejava$core$model$Verb;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.github.scribejava.core.model.Verb[] r0 = com.github.scribejava.core.model.Verb.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$github$scribejava$core$model$Verb = r0
                com.github.scribejava.core.model.Verb r1 = com.github.scribejava.core.model.Verb.GET     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$github$scribejava$core$model$Verb     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.scribejava.core.model.Verb r1 = com.github.scribejava.core.model.Verb.POST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.scribejava.core.model.OAuthRequestAsync.AnonymousClass2.<clinit>():void");
        }
    }

    private static class OAuthAsyncCompletionHandler<T> extends AsyncCompletionHandler<T> {
        private final OAuthAsyncRequestCallback<T> callback;
        private final ResponseConverter<T> converter;

        OAuthAsyncCompletionHandler(OAuthAsyncRequestCallback<T> oAuthAsyncRequestCallback, ResponseConverter<T> responseConverter) {
            this.callback = oAuthAsyncRequestCallback;
            this.converter = responseConverter;
        }

        public T onCompleted(Response response) throws IOException {
            T convert = this.converter.convert(response);
            OAuthAsyncRequestCallback<T> oAuthAsyncRequestCallback = this.callback;
            if (oAuthAsyncRequestCallback != null) {
                oAuthAsyncRequestCallback.onCompleted(convert);
            }
            return convert;
        }

        public void onThrowable(Throwable th) {
            OAuthAsyncRequestCallback<T> oAuthAsyncRequestCallback = this.callback;
            if (oAuthAsyncRequestCallback != null) {
                oAuthAsyncRequestCallback.onThrowable(th);
            }
        }
    }

    public Future<Response> sendAsync(OAuthAsyncRequestCallback<Response> oAuthAsyncRequestCallback) {
        return sendAsync(oAuthAsyncRequestCallback, RESPONSE_CONVERTER, (ProxyServer) null);
    }

    public Future<Response> sendAsync(OAuthAsyncRequestCallback<Response> oAuthAsyncRequestCallback, ProxyServer proxyServer) {
        return sendAsync(oAuthAsyncRequestCallback, RESPONSE_CONVERTER, proxyServer);
    }
}
