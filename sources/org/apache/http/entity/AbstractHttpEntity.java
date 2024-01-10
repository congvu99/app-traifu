package org.apache.http.entity;

import java.io.IOException;
import kotlinx.serialization.json.internal.JsonLexerKt;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

public abstract class AbstractHttpEntity implements HttpEntity {
    protected static final int OUTPUT_BUFFER_SIZE = 4096;
    protected boolean chunked;
    protected Header contentEncoding;
    protected Header contentType;

    @Deprecated
    public void consumeContent() throws IOException {
    }

    protected AbstractHttpEntity() {
    }

    public Header getContentType() {
        return this.contentType;
    }

    public Header getContentEncoding() {
        return this.contentEncoding;
    }

    public boolean isChunked() {
        return this.chunked;
    }

    public void setContentType(Header header) {
        this.contentType = header;
    }

    public void setContentType(String str) {
        setContentType((Header) str != null ? new BasicHeader("Content-Type", str) : null);
    }

    public void setContentEncoding(Header header) {
        this.contentEncoding = header;
    }

    public void setContentEncoding(String str) {
        setContentEncoding((Header) str != null ? new BasicHeader("Content-Encoding", str) : null);
    }

    public void setChunked(boolean z) {
        this.chunked = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(JsonLexerKt.BEGIN_LIST);
        if (this.contentType != null) {
            sb.append("Content-Type: ");
            sb.append(this.contentType.getValue());
            sb.append(JsonLexerKt.COMMA);
        }
        if (this.contentEncoding != null) {
            sb.append("Content-Encoding: ");
            sb.append(this.contentEncoding.getValue());
            sb.append(JsonLexerKt.COMMA);
        }
        long contentLength = getContentLength();
        if (contentLength >= 0) {
            sb.append("Content-Length: ");
            sb.append(contentLength);
            sb.append(JsonLexerKt.COMMA);
        }
        sb.append("Chunked: ");
        sb.append(this.chunked);
        sb.append(JsonLexerKt.END_LIST);
        return sb.toString();
    }
}
