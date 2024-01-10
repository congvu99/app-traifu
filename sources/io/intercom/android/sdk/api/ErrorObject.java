package io.intercom.android.sdk.api;

import com.intercom.twig.Twig;
import io.intercom.android.sdk.logger.LumberMill;
import java.io.IOException;
import retrofit2.Response;

public class ErrorObject {
    private final String errorBody;
    private final int statusCode;
    private final Throwable throwable;
    private final Twig twig = LumberMill.getLogger();

    public ErrorObject(Throwable th, Response response) {
        this.throwable = th;
        this.errorBody = parseErrorBody(response);
        this.statusCode = parseStatusCode(response);
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    /* access modifiers changed from: package-private */
    public String getErrorBody() {
        return this.errorBody;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    /* access modifiers changed from: package-private */
    public boolean hasErrorBody() {
        return this.errorBody != null;
    }

    private int parseStatusCode(Response response) {
        if (response != null) {
            return response.code();
        }
        return -1;
    }

    private String parseErrorBody(Response response) {
        if (response == null || response.errorBody() == null) {
            return null;
        }
        try {
            return response.errorBody().string();
        } catch (IOException e) {
            Twig twig2 = this.twig;
            twig2.internal("Couldn't parse error body: " + e.getMessage());
            return null;
        }
    }
}
