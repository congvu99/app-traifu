package io.intercom.android.sdk.api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.Response;

class RetryInterceptor implements Interceptor {
    private static final int MAX_RETRIES = 3;
    private final Sleeper sleeper;

    public RetryInterceptor(Sleeper sleeper2) {
        this.sleeper = sleeper2;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        int i = 0;
        while (i <= 3) {
            try {
                return chain.proceed(chain.request());
            } catch (IOException e) {
                if (i != 3) {
                    i++;
                    this.sleeper.sleep(getRetryTimer(i));
                } else {
                    throw e;
                }
            }
        }
        throw new IOException("request failed due to network errors");
    }

    static int getRetryTimer(int i) {
        return (int) Math.pow(2.0d, (double) i);
    }

    public static class Sleeper {
        public void sleep(int i) {
            try {
                TimeUnit.SECONDS.sleep((long) i);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
