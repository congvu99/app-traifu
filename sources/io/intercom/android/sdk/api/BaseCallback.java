package io.intercom.android.sdk.api;

import com.intercom.twig.Twig;
import io.intercom.android.sdk.logger.LumberMill;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseCallback<T> implements Callback<T> {
    private final Twig twig = LumberMill.getLogger();

    /* access modifiers changed from: protected */
    public void onError(ErrorObject errorObject) {
    }

    /* access modifiers changed from: protected */
    public abstract void onSuccess(T t);

    /* access modifiers changed from: package-private */
    public void logFailure(String str, ErrorObject errorObject) {
        Twig twig2 = this.twig;
        twig2.e(str + ": " + getDetails(errorObject), new Object[0]);
    }

    public final void onResponse(Call<T> call, Response<T> response) {
        if (response == null) {
            handleError(new ErrorObject(new IllegalStateException("No body returned from the server"), (Response) null));
        } else if (response.body() == null) {
            handleError(new ErrorObject(new IllegalStateException("No body returned from the server"), response));
        } else if (!response.isSuccessful()) {
            handleError(new ErrorObject(new Exception("Status code outside the 200-300 range"), response));
        } else {
            onSuccess(response.body());
        }
    }

    public final void onFailure(Call<T> call, Throwable th) {
        handleError(new ErrorObject(th, (Response) null));
    }

    private void handleError(ErrorObject errorObject) {
        logFailure("Api call failed", errorObject);
        onError(errorObject);
    }

    static String getDetails(ErrorObject errorObject) {
        String str;
        if (errorObject.hasErrorBody()) {
            str = errorObject.getErrorBody();
        } else {
            str = errorObject.getThrowable().getMessage();
        }
        return str == null ? "unknown error" : str;
    }
}
