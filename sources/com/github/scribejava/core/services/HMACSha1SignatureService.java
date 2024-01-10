package com.github.scribejava.core.services;

import com.github.scribejava.core.exceptions.OAuthSignatureException;
import com.github.scribejava.core.utils.OAuthEncoder;
import com.github.scribejava.core.utils.Preconditions;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.text.Typography;

public class HMACSha1SignatureService implements SignatureService {
    private static final String CARRIAGE_RETURN = "\r\n";
    private static final String EMPTY_STRING = "";
    private static final String HMAC_SHA1 = "HmacSHA1";
    private static final String METHOD = "HMAC-SHA1";
    private static final String UTF8 = "UTF-8";

    public String getSignatureMethod() {
        return METHOD;
    }

    public String getSignature(String str, String str2, String str3) {
        try {
            Preconditions.checkEmptyString(str, "Base string cant be null or empty string");
            Preconditions.checkEmptyString(str2, "Api secret cant be null or empty string");
            return doSign(str, OAuthEncoder.encode(str2) + Typography.amp + OAuthEncoder.encode(str3));
        } catch (UnsupportedEncodingException | RuntimeException | InvalidKeyException | NoSuchAlgorithmException e) {
            throw new OAuthSignatureException(str, e);
        }
    }

    private String doSign(String str, String str2) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), HMAC_SHA1);
        Mac instance = Mac.getInstance(HMAC_SHA1);
        instance.init(secretKeySpec);
        return bytesToBase64String(instance.doFinal(str.getBytes("UTF-8"))).replace(CARRIAGE_RETURN, "");
    }

    private String bytesToBase64String(byte[] bArr) {
        return Base64Encoder.getInstance().encode(bArr);
    }
}
