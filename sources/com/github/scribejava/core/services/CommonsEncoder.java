package com.github.scribejava.core.services;

import com.github.scribejava.core.exceptions.OAuthSignatureException;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary.Base64;

public class CommonsEncoder extends Base64Encoder {
    public String getType() {
        return "CommonsCodec";
    }

    public String encode(byte[] bArr) {
        try {
            return new String(Base64.encodeBase64(bArr), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new OAuthSignatureException("Can't perform base64 encoding", e);
        }
    }

    public static boolean isPresent() {
        try {
            Class.forName("org.apache.commons.codec.binary.Base64");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
