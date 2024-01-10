package com.github.scribejava.core.model;

import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.utils.StreamUtils;
import com.loopj.android.http.AsyncHttpClient;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.JsonLexerKt;

public class Response {
    private String body;
    private int code;
    private Map<String, String> headers;
    private String message;
    private InputStream stream;

    public Response(int i, String str, Map<String, String> map, String str2, InputStream inputStream) {
        this.code = i;
        this.headers = map;
        this.body = str2;
        this.message = str;
        this.stream = inputStream;
    }

    Response(HttpURLConnection httpURLConnection) throws IOException {
        try {
            httpURLConnection.connect();
            this.code = httpURLConnection.getResponseCode();
            this.message = httpURLConnection.getResponseMessage();
            this.headers = parseHeaders(httpURLConnection);
            this.stream = isSuccessful() ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
        } catch (UnknownHostException e) {
            throw new OAuthException("The IP address of a host could not be determined.", e);
        }
    }

    private String parseBodyContents() {
        if (AsyncHttpClient.ENCODING_GZIP.equals(getHeader("Content-Encoding"))) {
            this.body = StreamUtils.getGzipStreamContents(getStream());
        } else {
            this.body = StreamUtils.getStreamContents(getStream());
        }
        return this.body;
    }

    private Map<String, String> parseHeaders(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        for (String str : httpURLConnection.getHeaderFields().keySet()) {
            hashMap.put(str, ((List) httpURLConnection.getHeaderFields().get(str)).get(0));
        }
        return hashMap;
    }

    public final boolean isSuccessful() {
        return getCode() >= 200 && getCode() < 400;
    }

    public String getBody() {
        String str = this.body;
        return str == null ? parseBodyContents() : str;
    }

    public InputStream getStream() {
        return this.stream;
    }

    public final int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getHeader(String str) {
        return this.headers.get(str);
    }

    public String toString() {
        return "Response{code=" + this.code + ", message='" + this.message + '\'' + ", body='" + this.body + '\'' + ", headers=" + this.headers + JsonLexerKt.END_OBJ;
    }
}
