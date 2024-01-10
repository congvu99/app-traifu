package com.github.scribejava.core.model;

import java.io.Serializable;

public abstract class Token implements Serializable {
    private static final long serialVersionUID = -8409640649946468092L;
    private final String rawResponse;

    protected Token(String str) {
        this.rawResponse = str;
    }

    public String getRawResponse() {
        String str = this.rawResponse;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("This token object was not constructed by ScribeJava and does not have a rawResponse");
    }

    public String getParameter(String str) {
        String[] split = this.rawResponse.split("&");
        int length = split.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String str2 = split[i];
            if (str2.startsWith(str + '=')) {
                String[] split2 = str2.split("=");
                if (split2.length > 1) {
                    return split2[1].trim();
                }
            } else {
                i++;
            }
        }
        return null;
    }
}
