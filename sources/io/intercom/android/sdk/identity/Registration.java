package io.intercom.android.sdk.identity;

import android.text.TextUtils;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.UserAttributes;
import io.intercom.android.sdk.logger.LumberMill;
import kotlinx.serialization.json.internal.JsonLexerKt;

public class Registration {
    private UserAttributes attributes;
    private String email = "";
    private final Twig twig = LumberMill.getLogger();
    private String userId = "";
    private Validity validity = Validity.NOT_SET;

    private enum Validity {
        NOT_SET,
        INVALID,
        VALID
    }

    public static Registration create() {
        return new Registration();
    }

    public Registration withEmail(String str) {
        boolean z = !TextUtils.isEmpty(str);
        if (z) {
            this.email = str;
        } else {
            this.twig.e("Email cannot be null or empty", new Object[0]);
        }
        updateState(z);
        return this;
    }

    public Registration withUserId(String str) {
        boolean z = !TextUtils.isEmpty(str);
        if (z) {
            this.userId = str;
        } else {
            this.twig.e("UserId cannot be null or empty", new Object[0]);
        }
        updateState(z);
        return this;
    }

    public Registration withUserAttributes(UserAttributes userAttributes) {
        if (userAttributes == null) {
            this.validity = Validity.INVALID;
            this.twig.e("Registration.withUserAttributes method failed: the attributes Map provided is null", new Object[0]);
        } else if (userAttributes.isEmpty()) {
            this.validity = Validity.INVALID;
            this.twig.e("Registration.withUserAttributes method failed: the attributes Map provided is empty", new Object[0]);
        } else {
            this.attributes = userAttributes;
        }
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public String getUserId() {
        return this.userId;
    }

    public UserAttributes getAttributes() {
        return this.attributes;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Registration registration = (Registration) obj;
        if (!this.email.equals(registration.email) || !this.userId.equals(registration.userId)) {
            return false;
        }
        UserAttributes userAttributes = this.attributes;
        UserAttributes userAttributes2 = registration.attributes;
        if (userAttributes != null) {
            return userAttributes.equals(userAttributes2);
        }
        if (userAttributes2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.email.hashCode() * 31) + this.userId.hashCode()) * 31;
        UserAttributes userAttributes = this.attributes;
        return hashCode + (userAttributes != null ? userAttributes.hashCode() : 0);
    }

    public String toString() {
        return "Registration{email='" + this.email + '\'' + ", userId='" + this.userId + '\'' + ", attributes=" + this.attributes + JsonLexerKt.END_OBJ;
    }

    /* access modifiers changed from: package-private */
    public boolean isValidRegistration() {
        return Validity.VALID.equals(this.validity);
    }

    private void updateState(boolean z) {
        if (this.validity == Validity.NOT_SET || this.validity == Validity.VALID) {
            this.validity = z ? Validity.VALID : Validity.INVALID;
        }
    }
}
