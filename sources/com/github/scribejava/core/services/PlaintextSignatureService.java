package com.github.scribejava.core.services;

import com.github.scribejava.core.exceptions.OAuthSignatureException;
import com.github.scribejava.core.utils.OAuthEncoder;
import com.github.scribejava.core.utils.Preconditions;
import kotlin.text.Typography;

public class PlaintextSignatureService implements SignatureService {
    private static final String METHOD = "PLAINTEXT";

    public String getSignatureMethod() {
        return METHOD;
    }

    public String getSignature(String str, String str2, String str3) {
        try {
            Preconditions.checkEmptyString(str2, "Api secret cant be null or empty string");
            return OAuthEncoder.encode(str2) + Typography.amp + OAuthEncoder.encode(str3);
        } catch (Exception e) {
            throw new OAuthSignatureException(str, e);
        }
    }
}
