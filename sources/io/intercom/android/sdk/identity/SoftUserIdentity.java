package io.intercom.android.sdk.identity;

import android.text.TextUtils;

abstract class SoftUserIdentity {
    static final SoftUserIdentity NONE = create("", "", "", "", "", "", "");

    /* access modifiers changed from: package-private */
    public abstract String anonymousId();

    /* access modifiers changed from: package-private */
    public abstract String email();

    /* access modifiers changed from: package-private */
    public abstract String encryptedUserId();

    /* access modifiers changed from: package-private */
    public abstract String fingerprint();

    /* access modifiers changed from: package-private */
    public abstract String hmac();

    /* access modifiers changed from: package-private */
    public abstract String intercomId();

    /* access modifiers changed from: package-private */
    public abstract String userId();

    SoftUserIdentity() {
    }

    static SoftUserIdentity create(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return new AutoValue_SoftUserIdentity(str, str2, str3, str4, str5, str6, str7);
    }

    /* access modifiers changed from: package-private */
    public boolean isSameUser(Registration registration) {
        String userId = registration.getUserId();
        String email = registration.getEmail();
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(userId) || !TextUtils.isEmpty(email);
        if (!TextUtils.isEmpty(userId)) {
            z2 = z2 && userId.equals(userId());
        }
        if (TextUtils.isEmpty(email)) {
            return z2;
        }
        if (z2 && email.equals(email())) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean isPresent() {
        return !equals(NONE);
    }
}
