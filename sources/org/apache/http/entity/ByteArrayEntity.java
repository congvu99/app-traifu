package org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.util.Args;

public class ByteArrayEntity extends AbstractHttpEntity implements Cloneable {
    private final byte[] b;
    @Deprecated
    protected final byte[] content;
    private final int len;
    private final int off;

    public boolean isRepeatable() {
        return true;
    }

    public boolean isStreaming() {
        return false;
    }

    public ByteArrayEntity(byte[] bArr, ContentType contentType) {
        Args.notNull(bArr, "Source byte array");
        this.content = bArr;
        this.b = bArr;
        this.off = 0;
        this.len = bArr.length;
        if (contentType != null) {
            setContentType(contentType.toString());
        }
    }

    public ByteArrayEntity(byte[] bArr, int i, int i2, ContentType contentType) {
        int i3;
        Args.notNull(bArr, "Source byte array");
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) < 0 || i3 > bArr.length) {
            throw new IndexOutOfBoundsException("off: " + i + " len: " + i2 + " b.length: " + bArr.length);
        }
        this.content = bArr;
        this.b = bArr;
        this.off = i;
        this.len = i2;
        if (contentType != null) {
            setContentType(contentType.toString());
        }
    }

    public ByteArrayEntity(byte[] bArr) {
        this(bArr, (ContentType) null);
    }

    public ByteArrayEntity(byte[] bArr, int i, int i2) {
        this(bArr, i, i2, (ContentType) null);
    }

    public long getContentLength() {
        return (long) this.len;
    }

    public InputStream getContent() {
        return new ByteArrayInputStream(this.b, this.off, this.len);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        outputStream.write(this.b, this.off, this.len);
        outputStream.flush();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
