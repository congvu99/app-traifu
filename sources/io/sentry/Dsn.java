package io.sentry;

import com.facebook.internal.security.CertificateUtil;
import io.sentry.exception.InvalidDsnException;
import java.net.URI;

final class Dsn {
    private final String path;
    private final String projectId;
    private final String publicKey;
    private final String secretKey;
    private final URI sentryUri;

    public String getProjectId() {
        return this.projectId;
    }

    public String getPath() {
        return this.path;
    }

    public String getSecretKey() {
        return this.secretKey;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    /* access modifiers changed from: package-private */
    public URI getSentryUri() {
        return this.sentryUri;
    }

    Dsn(String str) throws InvalidDsnException {
        try {
            URI normalize = new URI(str).normalize();
            String userInfo = normalize.getUserInfo();
            if (userInfo != null) {
                if (!userInfo.isEmpty()) {
                    String[] split = userInfo.split(CertificateUtil.DELIMITER, -1);
                    String str2 = split[0];
                    this.publicKey = str2;
                    if (str2 == null || str2.isEmpty()) {
                        throw new IllegalArgumentException("Invalid DSN: No public key provided.");
                    }
                    this.secretKey = split.length > 1 ? split[1] : null;
                    String path2 = normalize.getPath();
                    path2 = path2.endsWith("/") ? path2.substring(0, path2.length() - 1) : path2;
                    int lastIndexOf = path2.lastIndexOf("/") + 1;
                    String substring = path2.substring(0, lastIndexOf);
                    if (!substring.endsWith("/")) {
                        substring = substring + "/";
                    }
                    this.path = substring;
                    String substring2 = path2.substring(lastIndexOf);
                    this.projectId = substring2;
                    if (!substring2.isEmpty()) {
                        this.sentryUri = new URI(normalize.getScheme(), (String) null, normalize.getHost(), normalize.getPort(), substring + "api/" + this.projectId, (String) null, (String) null);
                        return;
                    }
                    throw new IllegalArgumentException("Invalid DSN: A Project Id is required.");
                }
            }
            throw new IllegalArgumentException("Invalid DSN: No public key provided.");
        } catch (Exception e) {
            throw new InvalidDsnException(str, (Throwable) e);
        }
    }
}
