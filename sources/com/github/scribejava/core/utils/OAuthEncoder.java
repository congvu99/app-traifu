package com.github.scribejava.core.utils;

import androidx.webkit.ProxyConfig;
import com.github.scribejava.core.exceptions.OAuthException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class OAuthEncoder {
    private static final String CHARSET = "UTF-8";
    private static final Map<String, String> ENCODING_RULES;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(ProxyConfig.MATCH_ALL_SCHEMES, "%2A");
        hashMap.put("+", "%20");
        hashMap.put("%7E", "~");
        ENCODING_RULES = Collections.unmodifiableMap(hashMap);
    }

    public static String encode(String str) {
        Preconditions.checkNotNull(str, "Cannot encode null object");
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            for (Map.Entry next : ENCODING_RULES.entrySet()) {
                encode = applyRule(encode, (String) next.getKey(), (String) next.getValue());
            }
            return encode;
        } catch (UnsupportedEncodingException e) {
            throw new OAuthException("Charset not found while encoding string: UTF-8", e);
        }
    }

    private static String applyRule(String str, String str2, String str3) {
        return str.replaceAll(Pattern.quote(str2), str3);
    }

    public static String decode(String str) {
        Preconditions.checkNotNull(str, "Cannot decode null object");
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new OAuthException("Charset not found while decoding string: UTF-8", e);
        }
    }
}
