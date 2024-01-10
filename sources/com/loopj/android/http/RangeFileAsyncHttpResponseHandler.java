package com.loopj.android.http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;

public abstract class RangeFileAsyncHttpResponseHandler extends FileAsyncHttpResponseHandler {
    private static final String LOG_TAG = "RangeFileAsyncHttpRH";
    private boolean append = false;
    private long current = 0;

    public RangeFileAsyncHttpResponseHandler(File file) {
        super(file);
    }

    public void sendResponseMessage(HttpResponse httpResponse) throws IOException {
        if (!Thread.currentThread().isInterrupted()) {
            StatusLine statusLine = httpResponse.getStatusLine();
            if (statusLine.getStatusCode() == 416) {
                if (!Thread.currentThread().isInterrupted()) {
                    sendSuccessMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), (byte[]) null);
                }
            } else if (statusLine.getStatusCode() >= 300) {
                if (!Thread.currentThread().isInterrupted()) {
                    sendFailureMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), (byte[]) null, new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
                }
            } else if (!Thread.currentThread().isInterrupted()) {
                Header firstHeader = httpResponse.getFirstHeader("Content-Range");
                if (firstHeader == null) {
                    this.append = false;
                    this.current = 0;
                } else {
                    LogInterface logInterface = AsyncHttpClient.log;
                    logInterface.v(LOG_TAG, "Content-Range: " + firstHeader.getValue());
                }
                sendSuccessMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), getResponseData(httpResponse.getEntity()));
            }
        }
    }

    /* access modifiers changed from: protected */
    public byte[] getResponseData(HttpEntity httpEntity) throws IOException {
        int read;
        if (httpEntity == null) {
            return null;
        }
        InputStream content = httpEntity.getContent();
        long contentLength = httpEntity.getContentLength() + this.current;
        FileOutputStream fileOutputStream = new FileOutputStream(getTargetFile(), this.append);
        if (content == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (this.current < contentLength && (read = content.read(bArr)) != -1 && !Thread.currentThread().isInterrupted()) {
                this.current += (long) read;
                fileOutputStream.write(bArr, 0, read);
                sendProgressMessage(this.current, contentLength);
            }
            return null;
        } finally {
            content.close();
            fileOutputStream.flush();
            fileOutputStream.close();
        }
    }

    public void updateRequestHeaders(HttpUriRequest httpUriRequest) {
        if (this.file.exists() && this.file.canWrite()) {
            this.current = this.file.length();
        }
        if (this.current > 0) {
            this.append = true;
            httpUriRequest.setHeader("Range", "bytes=" + this.current + "-");
        }
    }
}
