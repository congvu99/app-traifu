package org.apache.http.impl.io;

import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.config.MessageConstraints;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;

public class DefaultHttpResponseParserFactory implements HttpMessageParserFactory<HttpResponse> {
    public static final DefaultHttpResponseParserFactory INSTANCE = new DefaultHttpResponseParserFactory();
    private final LineParser lineParser;
    private final HttpResponseFactory responseFactory;

    public DefaultHttpResponseParserFactory(LineParser lineParser2, HttpResponseFactory httpResponseFactory) {
        this.lineParser = lineParser2 == null ? BasicLineParser.INSTANCE : lineParser2;
        this.responseFactory = httpResponseFactory == null ? DefaultHttpResponseFactory.INSTANCE : httpResponseFactory;
    }

    public DefaultHttpResponseParserFactory() {
        this((LineParser) null, (HttpResponseFactory) null);
    }

    public HttpMessageParser<HttpResponse> create(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints) {
        return new DefaultHttpResponseParser(sessionInputBuffer, this.lineParser, this.responseFactory, messageConstraints);
    }
}
