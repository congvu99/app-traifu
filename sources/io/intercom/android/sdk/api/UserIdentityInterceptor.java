package io.intercom.android.sdk.api;

import com.intercom.twig.Twig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

class UserIdentityInterceptor implements Interceptor {
    private static final String NO_USER_IDENTITY = "A network request was made with no user registered on this device.Please call registerUnidentifiedUser() or registerIdentifiedUser(Registration).";
    private static final String USER_IDENTITY_CHANGED = "registered user changed while this request was in flight";
    private final Twig twig = LumberMill.getLogger();
    private final UserIdentity userIdentity;

    public UserIdentityInterceptor(UserIdentity userIdentity2) {
        this.userIdentity = userIdentity2;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        if (this.userIdentity.identityExists()) {
            String fingerprint = this.userIdentity.getFingerprint();
            Response proceed = chain.proceed(chain.request());
            if (fingerprint.equals(this.userIdentity.getFingerprint())) {
                this.twig.internal("interceptor", "proceeding");
                return proceed;
            }
            this.twig.internal("interceptor", "halting: user identity changed");
            if (proceed != null) {
                proceed.body().close();
            }
            throw new IOException(USER_IDENTITY_CHANGED);
        }
        throw new IOException(NO_USER_IDENTITY);
    }
}
