package com.github.scribejava.core.services;

import com.github.scribejava.core.exceptions.OAuthSignatureException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;

public class RSASha1SignatureService implements SignatureService {
    private static final String METHOD = "RSA-SHA1";
    private static final String RSA_SHA1 = "SHA1withRSA";
    private static final String UTF8 = "UTF-8";
    private final PrivateKey privateKey;

    public String getSignatureMethod() {
        return METHOD;
    }

    public RSASha1SignatureService(PrivateKey privateKey2) {
        this.privateKey = privateKey2;
    }

    public String getSignature(String str, String str2, String str3) {
        try {
            Signature instance = Signature.getInstance(RSA_SHA1);
            instance.initSign(this.privateKey);
            instance.update(str.getBytes("UTF-8"));
            return bytesToBase64String(instance);
        } catch (UnsupportedEncodingException | RuntimeException | InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
            throw new OAuthSignatureException(str, e);
        }
    }

    private String bytesToBase64String(Signature signature) throws SignatureException {
        return Base64Encoder.getInstance().encode(signature.sign());
    }
}
